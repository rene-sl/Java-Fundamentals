import java.util.Scanner;

public class MaxSequenceOfEqualElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        int[] arrayNum = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            arrayNum[i] = Integer.parseInt(input[i]);
        }

        int counterBiggerLeft = 0;
        int numberBiggerLeft = 0;

        for (int i = 0; i < arrayNum.length; i++) {
            int counter = 0;
            int number = 0;
            for (int j = i + 1; j < arrayNum.length; j++) {
                if (arrayNum[i] == arrayNum[j]) {
                    counter++;
                    number = arrayNum[j];
                    if (counter > counterBiggerLeft) {
                        counterBiggerLeft = counter;
                        numberBiggerLeft = number;
                    }
                } else {
                    break;
                }
            }
        }
        int[] newArray = new int[counterBiggerLeft+1];
        for (int k = 0; k < newArray.length; k++) {
            newArray[k] = numberBiggerLeft;
            System.out.print(newArray[k] + " ");
        }
    }
}

