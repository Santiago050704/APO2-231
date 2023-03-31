import java.util.ArrayList;

public class Main {
  public static void main(String[] args) {
    ArrayList<Integer> arr = new ArrayList<>();
    arr.add(10);
    arr.add(-4);
    arr.add(22);
    arr.add(40);
    arr.add(-2);
    arr.add(-80);
    for(int s : arr){
      System.out.print(s + " ");
    }
    System.out.println();
    //bubbleSort(arr);
    //selectionSort(arr);
    insertionSort(arr);
    for(int s : arr){
      System.out.print(s + " ");
    }
  }
    
  public static void bubbleSort(ArrayList<Integer> arr){
    for(int j = 0; j < arr.size() - 1; j++){
      for(int i = 1; i < arr.size() - j; i++){
        if(arr.get(i-1) > arr.get(i)){
          int previous = arr.get(i-1);
          int current = arr.get(i);
          arr.set(i-1, current);
          arr.set(i, previous);
        }
      }
    }
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

  public static void insertionSort(ArrayList<Integer> arr) {
    for (int i = 1; i < arr.size(); i++) {
      int key = arr.get(i);
      int j = i - 1;
      while (j >= 0 && arr.get(j) > key) {
        arr.set(j + 1, arr.get(j));
        j -= 1;
      }
      arr.set(j + 1, key);
    }
  }
}