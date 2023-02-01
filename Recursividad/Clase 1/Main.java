public class Main {

    public static String className;
    public int alfa=0;

    public static void main(String[] args) {
        //alfa(0);
        System.out.println("Fin");

        ClassicRecursives obj = new ClassicRecursives();
        long res = obj.f(5);
        System.out.println(res);

    }
    public static void alfa(int n){
        //Casos base
        System.out.println("Estoy en la fase "+n);
        System.out.println("Vamos a hacer la comparación");
        if(n>=5){
            System.out.println("El numero "+n+" es mayor o igual que 5, finaliza el llamado");
            return;
        }
        System.out.println("Estamos haciendo el conteo");
        //Operacion
        System.out.println(n);
        n++;
        System.out.println("Conteo hecho");
        //Llamado recursivo

        System.out.println("Llamando recursivamente alfa");
        alfa(n);
        System.out.println("Finaliza el llamado recursivo");
        System.out.println("El metodo termina con n="+n);
    }

    public void beta(){

    }


}