import java.net.InetSocketAddress;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = Integer.parseInt(scanner.nextLine());

        ArrayDeque<Integer> collection = new ArrayDeque<>();

        for (int i = 0; i < rows ; i++) {
            String [] input = scanner.nextLine().split("\\s+");

            switch (input[0]){
                case "1":
                    collection.push(Integer.parseInt(input[1]));
                    break;
                case "2":
                    if ( 0< collection.size()) {
                        collection.pop();
                    }
                    break;
                case "3":
                    if (0< collection.size()) {
                        System.out.println(Collections.max(collection));
                    }
                    break;
            }
        }
    }
}
