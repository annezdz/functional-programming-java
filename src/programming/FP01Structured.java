package programming;

import java.util.List;

public class FP01Structured {
    public static void main(String[] args) {

        printAllNumbersInListStructured(List.of(12,9,13,4,6,2,4,1));
        System.out.println("---------------------------------------");
        printEvenNumbersInListStructured(List.of(12,9,13,4,6,2,4,1));
        System.out.println("---------------------------------------");
        printOddNumbersInListStructured(List.of(12,9,13,4,6,2,4,1));
    }

    private static void printAllNumbersInListStructured(List<Integer> numbers) {
        //How to loop the numbers ? Functional Approach
        for(int number : numbers) {
            System.out.println(number);
        }
    }

    private static void printEvenNumbersInListStructured(List<Integer> numbers) {
        //How to loop the numbers ? Functional Approach
        for(int number : numbers) {
            if(number % 2 == 0) {
                System.out.println(number);
            }
        }
    }

    private static void printOddNumbersInListStructured(List<Integer> numbers) {
        for(int number : numbers) {
            if(number % 2 != 0) {
                System.out.println(number);
            }
        }
    }
}
