import java.util.Arrays;
import java.util.Scanner;

public class EvenAndOddSubtraction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int [] array = Arrays.stream(scanner.nextLine().split(" ")).
                mapToInt( e -> Integer.parseInt(e)).toArray();

        int sumEven = 0;
        int sumOdd = 0;

        for (int i = 0; i <array.length ; i++) {
            if (array[i] % 2 == 0) {
                sumEven += array[i];
            } else {
                sumOdd += array[i];
            }
        }
        System.out.println(sumEven-sumOdd);
    }
}
