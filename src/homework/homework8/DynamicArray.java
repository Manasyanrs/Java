package homework.homework8;

public class DynamicArray {
    private int[] array = new int[2];   //սա մեր հիմնական մասիվն է, որտեղ պահելու ենք ավելացվող էլեմենտները
    private int size = 0;   //սա մեր մասիվի մեջ ավելացված էլեմենտների քանակն է

    public void add(int value) {
        /*
         *  Մեթոդը ստուգում է մասիվի լայնքը, եթե տեղ չկա կանչվում է extend() մեթոդը։
         *  Հակառակ դեպքում արժեքը ավելացվում է մասիվի մեջ
         */

        if (size <= array.length - 1) {
            array[size] = value;
            size++;

        } else {
            extend();
            add(value);
        }
    }

    private void extend() {
        /*
         * Մեթոդը ստեղծում է հին մասիվից 10 էլեմենտ ավելի մեծ մասիվ։
         * Հին մասիվի էլեմենտները ավելացնում է նորի մեջ և հին մասիվի հղումը կապում է նոր մասիվի հղման հետ։
         */

        int[] newArray = new int[array.length + 10];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
    }

    public int getByIndex(int index) {
        /*
         *   Մեթոդը վերադարձնում է մասիվի index-երրորդ էլեմենտը,
         *   եթե տրված ինդեքսը մեր ունեցած մասիվի ինդեքսի սահմաններում է։
         *   Հակառակ դեպքում վերադարձնում է -1։
         */

        if (index <= size && index >= 0) {
            System.out.print(index + "֊րդ ինդեքսի էլեմենտը մասիվի մեջ հավասար է ");
            return array[index];
        } else {
            System.out.print(index + "֊րդ ինդեքսի էլեմենտ մասիվի մեջ չկա 'return' ");
            return -1;
        }
    }

    public void print() {
        // Մեթոդը տպում է մասիվի բոլոր ավելացրած էլեմենտները

        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    private boolean checkIndex(int index) {
        /*
         * Մեթոդը ստուգում է կա index―երորդ էլեմենտ, եթե կա վերադարձնում է true:
         * Հակառակ դեպքում տպում է, որ "Նման ինդեքսով էլեմենտ չկա։" և վերադարձնում է false
         */

        if (index > size || index < 0) {
            System.out.println("Նման ինդեքսով էլեմենտ չկա։");
            return false;
        } else {
            return true;
        }
    }

    public void deleteByIndex(int index) {
        /*
         * Մեթոդը նախատեսված է ջնջելու մասիվի index-երորդ էլեմենտը,
         * եթե չկա նման ինդեքսով էլեմենտ, տպեում է, որ չկա նման էլեմենտ։
         */


        int[] temp = new int[array.length - 1];
        if (checkIndex(index)) {
            for (int i = 0, j = 0; i < size; i++, j++) {
                if (i != index) {
                    temp[i] = array[j];
                } else {
                    j++;
                    temp[i] = array[j];
                    size--;
                }
            }
            array = temp;
            size--;
        }
    }

    public void set(int index, int value) {
        /* Մեթոդը կանչում է checkIndex(index) մեթոդը, որը եթե վերեդարձնում է true,
         * եթե  նման ինդեքսով էլեմենտ կա տրված value-ն դրվում է տրված index-ով էլեմենտի տեղը։
         * Իսկ եթե checkIndex(index) մեթոդը վերեդարձնում է false, ուրեմն տպվում է, որ  նման ինդեքսով էլեմենտ չկա
         */

        if (checkIndex(index)) {
            array[index] = value;
        }
    }

    public void add(int index, int value) {
        /* Մեթոդը կանչում է checkIndex(index) մեթոդը, որը եթե վերեդարձնում է true, ապա
         * ավելացվում է տրված value-ն տրված ինդեքսում, իսկ էղած էլեմենտները մի հատ աջ են տաղափոխվում։
         * Իսկ եթե checkIndex(index) մեթոդը վերեդարձնում է false, ուրեմն տպվում է, որ  նման ինդեքսով էլեմենտ չկա
         */

        if (checkIndex(index)) {
            int[] temp = new int[size + 1];
            for (int i = 0, j = 0; i < temp.length; i++, j++) {
                if (i != index) {
                    temp[i] = array[j];
                } else {
                    temp[i] = value;
                    j--;
                }
            }
            array = temp;
            size++;
        }
    }

    public boolean exists(int value) {
        // Մեթեդը վերադարձնում true եթե տրված value-ն կա մասիվի մեջ, եթե ոչ ապա false

        System.out.print(value + " թվից կա մասիվի մե՞ջ ");

        for (int i = 0; i < size; i++) {
            if (array[i] == value) {
                return true;
            }
        }
        return false;
    }


    public int getIndexByValue(int value) {
        /* Մեթոդը վերադարձնում է տրված value-ի ինդեքսը, եթե շատ կա տվյալ value-ից, վերադարձնում է առաջին ինդեքսը,
         * իսկ եթե չկա, վերադարձնում է -1
         */
        for (int i = 0; i < size; i++) {
            if (array[i] == value) {
                System.out.print(value + " թվի ինդեքսը մասիվի մեջ հավասար է ");
                return i;
            }
        }
        return -1;
    }

    public void length() {
        System.out.println("Մասիվի լայնքը հավասար է " + size);
    }
}
