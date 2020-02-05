import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ChangeList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String input = scanner.nextLine();
        List<Integer> list = Arrays.stream(input.split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());


        input = scanner.nextLine();
        while (!(input.equalsIgnoreCase("end"))) {
            String[] command = input.split("\\s+");

            int length = command.length;


            if (length == 2) {
             list = list.stream().filter(e->!e.equals(Integer.parseInt(command[1])))
                        .collect(Collectors.toList());
            } else if (length == 3){
                int element = Integer.parseInt(command[1]);
                int position  = Integer.parseInt(command[2]);
                list.add(position,element);
            }
            input=scanner.nextLine();
        }

        for (Integer integer : list) {
            System.out.print(integer+" ");
        }
    }
}
