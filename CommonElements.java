import java.util.Scanner;

public class CommonElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] arrayOne = input.split(" ");
        String secondInput = scanner.nextLine();
        String [] arrayTwo = secondInput.split(" ");


        for (int i = 0; i < arrayTwo.length; i++) {

            for (int j = 0; j < arrayOne.length ; j++) {

                if (arrayTwo[i].equals(arrayOne[j])){
                    System.out.printf("%s ", arrayTwo[i]);
                }
            }
        }
    }
}
