import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GaussTrick {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] inputArray = input.split("\\s+");

        List<Integer> numbers = new ArrayList<>();
        for (String number : inputArray) {
            numbers.add(Integer.parseInt(number));
        }
        int sum = 0;
        int size = numbers.size()/2;
        for (int i = 0; i < size; i++) {
            sum = numbers.get(i) + numbers.get(numbers.size() - 1);
            numbers.set(i, sum);
            numbers.remove(numbers.size() - 1);
        }
        System.out.println(numbers.toString().replaceAll("\\[|,|\\]|", ""));
    }
}

