import java.util.Scanner;

public class PrintNumbersInReverseOrder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());

        int [] array = new int[count];
        for (int i = 0; i < count ; i++) {
         int element  = Integer.parseInt(scanner.next());
         array[i] = element;
        }
        for (int j = array.length-1; j >= 0 ; j--) {
            System.out.print(array[j] + " ");
        }
    }
}
