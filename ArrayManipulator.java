import java.util.*;

public class ArrayManipulator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] arrayNumbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();


        String input = scanner.nextLine();

        while (!input.equalsIgnoreCase("end")) {
            String[] commands = input.toLowerCase().split("\\s+");
            String command = commands[0];
            int index = 0;


            switch (command) {
                case "exchange":
                    index = Integer.parseInt(commands[1]);
                    if (isIndexInBorders(index, arrayNumbers)) {
                        commandExchange(index, arrayNumbers);
                    } else {
                        System.out.println("Invalid index");
                    }
                    break;
                case "max":
                    int maxIndex = maxNumberIndex(arrayNumbers, commands);
                    if (maxIndex != -1) {
                        System.out.println(maxIndex);
                    } else {
                        System.out.println("No matches");
                    }

                    break;
                case "min":
                    int minIndex = minNumberIndex(arrayNumbers, commands);
                    if (minIndex != -1) {
                        System.out.println(minIndex);
                    } else {
                        System.out.println("No matches");
                    }
                    break;
                case "first":
                    int count = Integer.parseInt(commands[1]);
                    firstEvenOdd(arrayNumbers, count, commands);
                    break;
                case "last":
                    int countLast = Integer.parseInt(commands[1]);
                    LastEvenOdd(arrayNumbers, countLast, commands);
                    break;
                default:
                    break;
            }


            input = scanner.nextLine();
        }
    }


    static void commandExchange(int index, int[] arrayNumbers) {
        if (index == 0 || index == arrayNumbers.length - 1) {
            return;
        }
        for (int i = 0; i <= index; i++) {
            int firstNumber = arrayNumbers[0];
            for (int j = 0; j < arrayNumbers.length - 1; j++) {
                arrayNumbers[j] = arrayNumbers[j + 1];
            }
            arrayNumbers[arrayNumbers.length - 1] = firstNumber;
        }
    }

    static boolean isIndexInBorders(int index, int[] arrayNumbers) {
        boolean indexIsInBorders = false;
        if (0 <= index && index < arrayNumbers.length) {
            indexIsInBorders = true;
        }
        return indexIsInBorders;
    }


    static int maxNumberIndex(int[] arrayNumbers, String[] commands) {
        int currentNumber = 0;
        int maxValueIndex = -1;
        int maxValue = Integer.MIN_VALUE;
        for (int i = 0; i < arrayNumbers.length; i++) {
            currentNumber = arrayNumbers[i];
            if (commands[1].equalsIgnoreCase("odd") && isOdd(currentNumber)) {
                if (maxValue <= currentNumber) {
                    maxValue = currentNumber;
                    maxValueIndex = i;
                }
            }
            if (commands[1].equalsIgnoreCase("even") && isEven(currentNumber)) {
                if (maxValue <= currentNumber) {
                    maxValue = currentNumber;
                    maxValueIndex = i;
                }
            }

        }
        return maxValueIndex;
    }

    static int minNumberIndex(int[] arrayNumbers, String[] commands) {
        int currentNumber = 0;
        int minValueIndex = -1;
        int minValue = Integer.MAX_VALUE;
        for (int i = 0; i < arrayNumbers.length; i++) {
            currentNumber = arrayNumbers[i];
            if (commands[1].equalsIgnoreCase("odd") && isOdd(currentNumber)) {
                if (currentNumber <= minValue) {
                    minValue = currentNumber;
                    minValueIndex = i;
                }
            }
            if (commands[1].equalsIgnoreCase("even") && isEven(currentNumber)) {
                if (currentNumber <= minValue) {
                    minValue = currentNumber;
                    minValueIndex = i;
                }
            }

        }
        return minValueIndex;
    }


    static boolean isOdd(int number) {
        boolean isOdd = false;
        if (!(number % 2 == 0)) {
            isOdd = true;
        }
        return isOdd;
    }

    static boolean isEven(int number) {
        boolean isEven = false;
        if (number % 2 == 0) {
            isEven = true;
        }
        return isEven;
    }

    static void firstEvenOdd(int[] arrayNumber, int count, String[] commands) {
        int[] result = new int[count];
        int index = 0;
        for (int j = 0; j < arrayNumber.length; j++) {
            if (isEven(arrayNumber[j]) && commands[2].equalsIgnoreCase("even")) {
                result[index++] = arrayNumber[j];

            }
            if (isOdd(arrayNumber[j]) && commands[2].equalsIgnoreCase("odd")) {
                result[index++] = arrayNumber[j];
            }
        }
        if (index == 0) {
            System.out.println("Invalid count");
        } else {
            for (int i = 0; i < result.length; i++) {
                System.out.print(result[i] + " ");
            }
        }
    }

    private static void LastEvenOdd(int[] arrayNumber, int countLast, String[] commands) {
        int[] result = new int[countLast];
        int indexLast = countLast - 1;
        for (int j = arrayNumber.length - 1; j >= 0; j--) {
            if (isEven(arrayNumber[j]) && commands[2].equalsIgnoreCase("even")) {
                result[indexLast--] = arrayNumber[j];

            }
            if (isOdd(arrayNumber[j]) && commands[2].equalsIgnoreCase("odd")) {
                result[indexLast--] = arrayNumber[j];
            }

            if (indexLast == countLast - 1 || arrayNumber.length <countLast) {
                System.out.println("Invalid count");
            } else {
                for (int i = 0; i < result.length; i++) {
                    System.out.print(result);
                }
            }
        }

    }
}




