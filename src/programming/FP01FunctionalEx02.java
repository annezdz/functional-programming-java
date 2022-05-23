package programming;

import java.util.List;

public class FP01FunctionalEx02 {
    public static void main(String[] args) {

        printAllNumbersInListFunctional(List.of(12,9,13,4,6,2,4,1));
        System.out.println("--------------------------------------");
        printEvenNumbersInListFunctional(List.of(12,9,13,4,6,2,4,1));
        System.out.println("--------------------------------------");
        printOddNumbersInListFunctional(List.of(12,9,13,4,6,2,4,1));
        System.out.println("--------------------------------------");
        printSquaresOfEvenNumbersInListFunctional(List.of(12,9,13,4,6,2,4,1));

    }

    private static void printAllNumbersInListFunctional(List<Integer> numbers) {
        numbers.stream()
                .forEach(System.out::println); //Method Reference
    }

    private static void printEvenNumbersInListFunctional(List<Integer> numbers) {
        //Using Lambda Expression - simple syntax to create methods
        //Transform list in stream and applicate filter to find even numbers
        numbers.stream()
                .filter(number -> number%2 == 0) //Stream<T>
                .forEach(System.out::println); //Method Reference
    }

    private static void printOddNumbersInListFunctional(List<Integer> numbers) {
        numbers.stream()
                .filter(number -> number % 2 != 0)
                .forEach(System.out::println);
    }

    //Using Map to return square for all numbers

    private static void printSquaresOfEvenNumbersInListFunctional(List<Integer> numbers) {
        numbers.stream()
                .filter(number -> number % 2 == 0)
                //Mapping to square of even numbers
                // mapping - x -> x * x
                .map(number -> number * number)
                .forEach(System.out::println);

    }
}
