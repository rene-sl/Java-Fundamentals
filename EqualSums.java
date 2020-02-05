import java.util.Scanner;

public class EqualSums {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        int[] array = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            array[i] = Integer.parseInt(input[i]);
        }
        int sumLeft = 0;
        int sumRight = 0;
        int index = 0;


        for (int i = 0; i < array.length; i++) {
            for (int k = i - 1; k >= 0; k--) {
                sumLeft += array[k];
                }
            for (int j = i + 1; j < array.length; j++) {
                sumRight += array[j];
            }
            if (sumLeft == sumRight) {
                index = i;
            } else {
                sumLeft = 0;
                sumRight = 0;
            }
        }
        if (sumLeft == sumRight ) {
            System.out.println(index);
        } else {
            System.out.println("no");
        }

    }
}
