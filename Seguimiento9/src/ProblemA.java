import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
public class ProblemA {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in)
        );
        String line = reader.readLine();
        String[] numberStr = line.split("\\+");
        ArrayList<Integer> numbers = new ArrayList<>();
        for(int i = 0; i < numberStr.length; i++){
            numbers.add(i, Integer.parseInt(numberStr[i]));
        }
        bubbleSort(numbers);
        /*for(int num : numbers){
            System.out.print(num);
        }*/
        StringBuilder outputBuilder = new StringBuilder();
        for(int num : numbers){
            outputBuilder.append(num).append("+");
        }
        String output = outputBuilder.toString();
        System.out.println(
                output.substring(0, output.length() - 1)
        );
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