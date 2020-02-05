import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class HouseParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = Integer.parseInt(scanner.nextLine());
        List<String> newList = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            String input = scanner.nextLine();
            List<String> list = Arrays.stream(input.split("\\s+"))
                    .collect(Collectors.toList());

            if (list.contains("not")) {
                if (newList.contains(list.get(0))) {
                    newList = newList.stream().filter(e -> !e.equals(list.get(0)))
                            .collect(Collectors.toList());
                    //list.stream().filter(e->!e.equals(Integer.parseInt(command[1])))
                    //                        .collect(Collectors.toList());
                } else {
                    System.out.printf("%s is not in the list!%n", list.get(0));
                }
            } else {
                if (newList.contains(list.get(0))) {
                    System.out.printf("%s is already in the list!%n", list.get(0));
                } else {
                    newList.add(list.get(0));
                }
            }
        }
        for (String s : newList) {
            System.out.printf("%s%n", s);
        }
    }
}

