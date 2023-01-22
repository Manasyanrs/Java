package chapter7;

public class Factorial {
    int factn(int n){
        int result;
        if (n == 1){
            return 1;
        }else {
            result = factn(n - 1) * n;
            return result;
        }
    }
}
