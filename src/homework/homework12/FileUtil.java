package homework.homework12;

import java.io.*;
import java.nio.ByteBuffer;
import java.util.Scanner;

public class FileUtil {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        fileSearch();
        contentSearch();
        findLines();
        printSizeOfPackage();
        createFileWithContent();
    }

    //այս մեթոդը պետք է սքաններով վերցնի երկու string.
    // 1 - path թե որ ֆոլդերում ենք փնտրելու
    // 2 - fileName - ֆայլի անունը, որը փնտրում ենք։
    //Որպես արդյունք պտի ծրագիրը տպի true եթե կա էդ ֆայլը էդ պապկի մեջ, false եթե չկա։
    static void fileSearch() {
        System.out.print("Enter the file path: ");
        String path = scanner.nextLine();
        System.out.print("Enter file name: ");
        String fileName = scanner.nextLine();

        File file = new File(path);
        if (file.isDirectory()) {
            File[] files = file.listFiles(new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    return name.equals(fileName);
                }
            });
            if (files.length > 0) {
                System.out.println(true);
            } else {
                System.out.println("File: " + fileName + " is not found.");
            }
        } else {
            System.out.println("path: " + path + " is not directory. Input correct directory.");
        }

    }

    //այս մեթոդը պետք է սքաններով վերցնի երկու string.
    // 1 - path թե որ ֆոլդերում ենք փնտրելու
    // 2 - keyword - ինչ որ բառ
    // Մեթոդը պետք է նշված path-ում գտնի բոլոր .txt ֆայլերը, և իրենց մեջ փնտրի
    // մեր տված keyword-ը, եթե գտնի, պետք է տպի տվյալ ֆայլի անունը։
    static void contentSearch() {
        System.out.print("Enter the file path: ");
        String path = scanner.nextLine();

        System.out.print("Enter file keyword: ");
        String keyword = scanner.nextLine();

        File files = new File(path);
        File[] filerFiles = files.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".txt");
            }
        });
        for (File file : filerFiles) {
            File strFilePath = new File(file.getAbsolutePath());
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(strFilePath.getAbsolutePath()))) {
                String strLine;
                while ((strLine = bufferedReader.readLine()) != null) {
                    if (strLine.contains(keyword)) {
                        System.out.println("In file " + file.getName() + " contains keyword " + keyword);
                    }
                }

            } catch (IOException e) {
                System.out.println("File not found");
            }
        }
    }

    //այս մեթոդը պետք է սքաններով վերցնի երկու string.
    // 1 - txtPath txt ֆայլի փաթը
    // 2 - keyword - ինչ որ բառ
    // տալու ենք txt ֆայլի տեղը, ու ինչ որ բառ, ինքը տպելու է էն տողերը, որտեղ գտնի էդ բառը։
    static void findLines() {
        System.out.print("Enter the file path: ");
        String path = scanner.nextLine();
        System.out.print("Enter file keyword: ");
        String keyword = scanner.nextLine();

        File files = new File(path);
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(files.getAbsolutePath()))) {
            String strLine;
            while ((strLine = bufferedReader.readLine()) != null) {
                if (strLine.contains(keyword)) {
                    System.out.println(strLine);
                }
            }

        } catch (IOException e) {
            System.out.println("File not found");
        }
    }

    //այս մեթոդը պետք է սքաններով վերցնի մեկ string.
    // 1 - path թե որ ֆոլդերի չափն ենք ուզում հաշվել
    // ֆոլդերի բոլոր ֆայլերի չափսերը գումարում ենք իրար, ու տպում
    static void printSizeOfPackage() {
        System.out.print("Enter the file path: ");
        String path = scanner.nextLine();
        File file = new File(path);
        if (file.isDirectory()) {
            double size = 0;
            File[] files = file.listFiles();

            for (File file1 : files) {
                size += file1.length();
            }
            System.out.println("Size of the path " + path + " is " + size + " byte.");
        } else {
            System.out.println("Size of the file " + path + " is " + file.length() + " byte.");

        }

    }

    //այս մեթոդը պետք է սքաններով վերցնի երեք string.
    // 1 - path պապկի տեղը, թե որտեղ է սարքելու նոր ֆայլը
    // 2 - fileName ֆայլի անունը, թե ինչ անունով ֆայլ է սարքելու
    // 3 - content ֆայլի պարունակությունը։ Այսինքն ստեղծված ֆայլի մեջ ինչ է գրելու
    // որպես արդյունք պապկի մեջ սարքելու է նոր ֆայլ, իրա մեջ էլ լինելու է content-ով տվածը
    static void createFileWithContent() {
        System.out.print("Enter the file path: ");
        String path = scanner.nextLine();
        System.out.print("Enter file name: ");
        String fileName = scanner.nextLine();
        System.out.print("Enter content: ");
        String content = scanner.nextLine();

        File file = new File(path);

        if (file.isDirectory()){
            String createdFileUrl = path + File.separator + fileName;
            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(createdFileUrl))){
                bufferedWriter.write(content);
            }catch (IOException e){
                System.out.println(e.getMessage());
            }
        }else {
            System.out.println(path + " iss not directory. Input correct directory");
        }
    }

}
