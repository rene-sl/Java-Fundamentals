
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SumAdjacentEqualNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        String[] arrayString = input.split("\\s+");

        List<Double> numbers = new ArrayList<>();

        for (String s : arrayString) {
            numbers.add(Double.parseDouble(s));
        }

        for (int i = 0; i < numbers.size() - 1; i++) {
            double firstNum = numbers.get(i);
            double secondNum = numbers.get(i + 1);
            double sum = 0;
            if (firstNum == secondNum) {
                sum = firstNum + secondNum;
                numbers.set(i, sum);
                numbers.remove(i + 1);
                i = -1;
            }
        }
        System.out.println(printingFormating(numbers));
    }

    static String printingFormating (List<Double> numbers){
 String current = " ";
 DecimalFormat format = new DecimalFormat("#.###");
        for (Double number : numbers) {
current+=format.format(number)+ " ";
        }
        return current.trim();
    }
}




