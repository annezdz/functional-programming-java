package programming;

import java.util.List;

public class FP01FunctionalEx01 {
    public static void main(String[] args) {

        printAllNumbersInListFunctional(List.of(12,9,13,4,6,2,4,1));
        System.out.println("--------------------------------------");
        printEvenNumbersInListFunctional(List.of(12,9,13,4,6,2,4,1));
        System.out.println("--------------------------------------");
        printOddNumbersInListFunctional(List.of(12,9,13,4,6,2,4,1));

    }

    private static void print(int number) {
        System.out.println(number);
    }

    private static boolean isEven(int number) {
        return number % 2 == 0;
    }

    private static boolean isOdd(int number) {
        return number % 2 != 0;
    }

    private static void printAllNumbersInListFunctional(List<Integer> numbers) {
        numbers.stream()
                .forEach(FP01FunctionalEx01::print); //Method Reference
    }

    private static void printEvenNumbersInListFunctional(List<Integer> numbers) {
        numbers.stream()
                //Filter - Only Allow Even Numbers
                .filter(FP01FunctionalEx01::isEven)
                .forEach(FP01FunctionalEx01::print); //Method Reference
    }

    private static void printOddNumbersInListFunctional(List<Integer> numbers) {
        numbers.stream()
                //Filter - Only Allow Even Numbers
                .filter(FP01FunctionalEx01::isOdd)
                .forEach(FP01FunctionalEx01::print); //Method Reference
    }


}
