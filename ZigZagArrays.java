import java.util.Arrays;
import java.util.Scanner;

public class ZigZagArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countArray = Integer.parseInt(scanner.nextLine());

        int[] outputArr1 = new int[countArray];
        int[] outputArr2 = new int[countArray];


        for (int i = 0; i < countArray; i++) {
            int[] inputArr = new int[2];
            inputArr = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();

                if (i % 2 == 0) {
                    outputArr1[i] = inputArr[0];
                    outputArr2[i] = inputArr[1];
                } else {
                    outputArr2[i] = inputArr[0];
                    outputArr1[i] = inputArr[1];
                }
            }
        for (int k = 0; k < outputArr1.length; k++) {
            System.out.print(outputArr1[k] + " ");
        }
        System.out.println();
        for (int l = 0; l < outputArr2.length ; l++) {
            System.out.print(outputArr2[l] + " ");
        }
    }
}

