import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    public static void selectionSort(ArrayList<Integer> arr){
        for(int rojo = 0; rojo < arr.size() - 1; rojo++){
            for(int azul = rojo + 1; azul < arr.size(); azul++){
                if(arr.get(azul) < arr.get(rojo)){
                    int valorAzul = arr.get(azul);
                    int valorRojo = arr.get(rojo);
                    arr.set(azul, valorRojo);
                    arr.set(rojo, valorAzul);
                }
            }
        }
    }

    public static void insertionSort(ArrayList<Integer> arr){

    }
}