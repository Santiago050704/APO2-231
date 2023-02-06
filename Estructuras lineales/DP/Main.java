public class Main {

    static int[] dp = new int[1000];


    //Greedy
    public static void main(String[] args) {

        long tic = System.currentTimeMillis();
        System.out.println(fib1(45));
        System.out.println(System.currentTimeMillis() - tic);

        tic = System.currentTimeMillis();
        System.out.println(fib2(100));
        System.out.println(System.currentTimeMillis() - tic);
    }

    public static int fib2(int n){
        if(dp[n] != 0){
            return dp[n];
        }else {
            if (n == 0 || n == 1) {
                return 1;
            }
            int value = fib2(n - 1) + fib2(n - 2);
            dp[n] = value;
            return value;
        }
    }

    //Fibonacci Lento
    public static int fib1(int n){
        if(n==0 || n==1){
            return 1;
        }
        return fib1(n-1) + fib1(n-2);
    }

}