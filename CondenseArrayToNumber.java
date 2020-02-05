import java.util.Arrays;
import java.util.Scanner;

public class CondenseArrayToNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e)).toArray();




        while (array.length>=2) {
            int sum = 0;
            int length = array.length-1;
            int [] current = new int[length];
            for (int i = 0; i < array.length - 1; i++) {
                sum = array[i] + array[i + 1];
                current[i]= sum;
            }
            array=current;

        }

                for (int i : array) {
                    System.out.println(i);
                }
            }
        }



