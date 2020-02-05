import java.util.*;
import java.util.stream.Collectors;

public class RemoveNegativesAndReverse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numberList = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt)
                .collect(Collectors.toList());


        numberList.removeIf(n->n<0);
        Collections.reverse(numberList);

        for (Integer integer : numberList) {
            System.out.print(integer+ " ");
        }
    }
}
