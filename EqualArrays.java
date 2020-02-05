import java.util.Arrays;
import java.util.Scanner;

public class EqualArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arrayOne = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e)).toArray();
        int[] arrayTwo = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e)).toArray();
        int sum = 0;

        for (int i = 0; i < arrayOne.length; i++) {
           if(arrayOne[i]==arrayTwo[i]) {
               sum += arrayOne[i];
           } else {
               System.out.printf("Arrays are not identical. Found difference at %d index.", i);
               break;
           }

        }
        if (Arrays.equals(arrayOne, arrayTwo)) {
            System.out.printf("Arrays are identical. Sum: %d", sum);
        }
    }
}


