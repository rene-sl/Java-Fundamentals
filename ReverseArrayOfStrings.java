import java.util.Scanner;

public class ReverseArrayOfStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String currentType = scanner.nextLine();
        String[] array = currentType.split(" ");
        String element = null;

        for (int i = 0; i < array.length / 2; i++) {
            element = array[array.length - 1 -i];
            array[array.length - 1 - i] = array[i];
            array[i] = element;
        }
        System.out.println(String.join(" ", array));
    }
}
