import java.util.Scanner;

public class MagicSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        int number = Integer.parseInt(scanner.nextLine());
        int[] array = new int[input.length];
        for (int i = 0; i < input.length ; i++) {
            array[i]= Integer.parseInt(input[i]);
        }

        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length ; j++) {
                int sum =0;
                int numberNewArray1 =0;
                int numberNewArray2 = 0;
                sum = array[i] +array[j];
                if(sum==number){
                    numberNewArray1= array[i];
                    numberNewArray2= array[j];
                }

                if(sum==number){
                    System.out.print(numberNewArray1+" "+numberNewArray2 +"\n");
                }
            }
        }

    }
}
