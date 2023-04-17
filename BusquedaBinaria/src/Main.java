import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        /*arr.add(41);
        arr.add(29);
        arr.add(-40);
        arr.add(2);
        arr.add(142);
        arr.add(-22);
        arr.add(37);
        arr.add(-7);
        arr.add(91);
        arr.add(-1);
        Collections.sort(arr);*/
        for(int i = 0; i < 10000000; i++){
            arr.add(i);
        }
        Collections.shuffle(arr);

        long tic = System.nanoTime();
        Collections.sort(arr);
        long toc = System.nanoTime() - tic;
        System.out.println("Ordenamiento en: " + toc);

        tic = System.nanoTime();
        int result = linearSearch(888, arr);
        System.out.println(result);
        toc = System.nanoTime() - tic;
        System.out.println("Elapsed time: " + toc);


        tic = System.nanoTime();
        int index = binarySearch(888, arr);
        System.out.println(index);
        toc = System.nanoTime() - tic;
        System.out.println("Elapsed time: " + toc);
        //System.out.println(binarySearch(29, arr));
    }

    public static int linearSearch(int num, ArrayList<Integer> arr){
        for (int i = 0; i < arr.size(); i++){
            if(arr.get(i) == num){
                return i;
            }
        }
        return -1;
    }

    public static int binarySearch(int num, ArrayList<Integer> arr){
        int iterations = 0;
        int begin = 0;
        int end = arr.size() - 1;
        while(begin <= end){
            int midPoint = (end + begin)/2;
            int midValue = arr.get(midPoint);
            iterations++;
            if(midValue == num){
                System.out.println("Iterations: " + iterations);
                return midPoint;
            }else if(num > midValue){
                begin = midPoint + 1;
            }else{
                end = midPoint - 1;
            }
        }
        System.out.println("Iterations: " + iterations);
        return -1;
    }
}