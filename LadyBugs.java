import java.util.Scanner;

public class LadyBugs {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        String[] input = scanner.nextLine().split("\\s+");


        int[] array = new int[size];
        for (int i = 0; i < input.length; i++) {
            for (int j = i; j < array.length; j++) {
                if (Integer.parseInt(input[i]) == j) {
                    array[j] = 1;
                } else {
                    array[j] = 0;
                }
            }
        }

        String currentInput = scanner.nextLine();
        while (!(currentInput.equalsIgnoreCase("end"))) {
            String[] current = currentInput.split("\\s+");

            calculatingIndexBug(current, array, size);

            currentInput = scanner.nextLine();
        }
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    private static boolean isLeft(String[] current) {
        boolean isLeft = false;
        if (current[1].equalsIgnoreCase("left") && Integer.parseInt(current[2]) > 0) {
            isLeft = true;
        } else {
            isRight(current);
        }
        return isLeft;
    }

    private static boolean isRight(String[] current) {
        boolean isRight = false;
        if (current[1].equalsIgnoreCase("right") && Integer.parseInt(current[2]) > 0) {
            isRight = true;
        } else {
            isLeft(current);
        }
        return isRight;
    }

    private static void calculatingIndexBug(String[] current, int[] array, int size) {
        int indexCurrent0 = Integer.parseInt(current[0]);
        int indexCurrent2 = Integer.parseInt(current[2]);
        if (isBugInTheField(current, array, size, indexCurrent0, indexCurrent2)) {
            if (isLeft(current)) {
                if (isThereBugAlready(current, array, indexCurrent0, indexCurrent2)) {
                    goAnotherPositionLeft(current, array, indexCurrent0, indexCurrent0);
                } else {
                    array[indexCurrent0 - indexCurrent2] = 1;
                    array[indexCurrent0] = 0;
                }

            } else if (isRight(current)) {
                if (isThereBugAlready(current, array, indexCurrent0, indexCurrent2)) {
                    goAnotherPositionRight(current, array, indexCurrent0, indexCurrent2);
                } else {
                    array[indexCurrent0 + indexCurrent2] = 1;
                    array[indexCurrent0] = 0;
                }
            }
            } else {
                bugIsNotInTheField(array, indexCurrent0);
            }
        }



    private static boolean isBugInTheField(String[] current, int[] array, int size, int indexCurrent0, int indexCurrent2) {
        boolean isInTheField = false;
        if (isLeft(current) && indexCurrent0 - indexCurrent2 >= 0) {
            isInTheField = true;
        } else if (isRight(current) && indexCurrent0 + indexCurrent2 < size) {
            isInTheField = true;
        }
        return isInTheField;
    }

    private static boolean isThereBugAlready(String[] current, int[] array, int indexCurrent0, int indexCurrent2) {
        boolean thereIsBug = false;
        if (isLeft(current) && array[indexCurrent0 - indexCurrent2] == 1) {
            thereIsBug = true;

        } else if (isRight(current) && indexCurrent0 + indexCurrent2 == 1) {
            thereIsBug = true;
        }
        return thereIsBug;
    }

    private static void goAnotherPositionLeft(String[] current, int[] array, int indexCurrent0, int indexCurrent2) {
        for (int i = indexCurrent0 - indexCurrent2; i >= 0; i--) {
            if (array[i] == 0) {
                array[i] = 1;
                break;
            }
        }
    }

    private static void goAnotherPositionRight(String[] current, int[] array, int indexCurrent0, int indexCurrent2) {
        for (int i = indexCurrent0 - indexCurrent2; i < array.length; i++) {
            if (array[i] == 0) {
                array[i] = 1;
                break;
            }

        }
    }

    private static void bugIsNotInTheField(int[] array, int indexCurrent0) {
        array[indexCurrent0] = 0;
    }

}

