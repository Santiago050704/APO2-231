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
        bubbleSort(arr);
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
}