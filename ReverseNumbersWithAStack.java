import java.util.ArrayDeque;
import java.util.Scanner;

public class ReverseNumbersWithAStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String [] input = scanner.nextLine().split("\\s+");

        ArrayDeque<String> reversed = new ArrayDeque<>();

        for (int i = 0; i < input.length ; i++) {
            reversed.push(input[i]);
        }

        while (reversed.size()>0){
            System.out.print(reversed.pop() + " ");
        }
    }
}
