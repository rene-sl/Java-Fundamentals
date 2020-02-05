import java.util.*;
import java.util.stream.Collectors;

public class MergingLists {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        List<String> list = Arrays.stream(input.split("\\s+"))
                .collect(Collectors.toList());
        input = scanner.nextLine();
        List<String> list2 = Arrays.stream(input.split("\\s+"))
                .collect(Collectors.toList());
        int firstSize = list.size();
        int secondSize = list2.size();

        List<String> result = new ArrayList<>();
        if (firstSize < secondSize) {
            for (int i = 0; i < firstSize; i++) {
                result.add(list.get(i));
                result.add(list2.get(i));
            }
            result.addAll(getOtherElements(list,list2));
        } else {
            for (int i = 0; i < secondSize; i++) {
                result.add(list.get(i));
                result.add(list2.get(i));
            }
            result.addAll(getOtherElements(list2,list));
        }

        for (String s : result) {
            System.out.print(s + " ");
        }
    }

    static List<String> getOtherElements(List<String> listShort, List<String> listLong) {
        List<String> result = new ArrayList<>();
        for (int i = listShort.size(); i < listLong.size(); i++) {
            result.add(listLong.get(i));
        }
        return result;
    }

}