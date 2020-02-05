import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        List<Integer> wagons = Arrays.stream(input.split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        int maxPassengers = Integer.parseInt(scanner.nextLine());

        input = scanner.nextLine();
        while (!(input.equalsIgnoreCase("end"))) {
            String[] command = input.split("\\s+");
            int length = command.length;
            if (2 == length) {
                int newWagonLength = Integer.parseInt(command[1]);
                wagons.add(newWagonLength);
            } else {
                int newPassengers = Integer.parseInt(command[0]);

                for (int i = 0; i < wagons.size(); i++) {
                    int addPassengers = newPassengers + wagons.get(i);
                    if (addPassengers <= maxPassengers) {
                        wagons.set(i, addPassengers);
                        break;
                    }
                }
            }
            input = scanner.nextLine();
        }
        for (Integer wagon : wagons) {
            System.out.print(wagon + " ");
        }
    }
}

