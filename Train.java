import java.util.Arrays;
import java.util.Scanner;

public class Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int wagonsCount = Integer.parseInt(scanner.nextLine());
        int[] wagons = new int[wagonsCount];
        int sum=0;

        for (int i=0; i<wagons.length; i++){
            int wagonPeople = Integer.parseInt(scanner.nextLine());
            wagons[i]=wagonPeople;
            sum+=wagons[i];
        }

        for (int j = 0; j < wagons.length ; j++) {
            System.out.print(wagons[j] + " ");
        }
        System.out.println();
        System.out.println(sum);
    }
}
