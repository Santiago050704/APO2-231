public class ClassicRecursives {
    public long f(long n){
        //Casos base
        if(n<0){
            System.out.println("Factorial no determinado");
            return -1;
        }
        if(n == 1 || n == 0){
            return 1;
        }
        //Operacion + recursivo
        return n*f(n-1);
    }

    public int fib(int n){
        if(n == 0 || n == 1){
            return 1;
        }
        return fib(n-1) + fib(n-2);
    }



}
