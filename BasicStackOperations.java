import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class BasicStackOperations {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int[] input = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();


        ArrayDeque<Integer> stack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).limit(input[0])
                .forEach(stack::push);

        stack.stream().limit(input[1]).forEach(e -> stack.pop());

        if (stack.contains(input[2])) {
            System.out.printf("true");
        } else {
            int min = stack.stream().min(Integer::compareTo).orElse(0);
            System.out.println(min);



        }
    }
}
