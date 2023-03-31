import java.util.Arrays;
import java.util.Scanner;

public class ProblemB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] talks = new int[n];
        for(int i = 0; i < n; i++){
            talks[i] = scanner.nextInt();
        }
        System.out.println(n);
        System.out.println(Arrays.toString(talks));
    }
}
