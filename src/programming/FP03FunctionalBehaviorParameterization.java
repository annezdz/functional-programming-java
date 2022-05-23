package programming;

import java.util.List;
import java.util.function.Predicate;

public class FP03FunctionalBehaviorParameterization {

    /**
     * boolean - isEven(int x) {
     *     return x % 2 == 0;
     * }
     *
     * .forEach(x -> System.out.println(x))
     * */

    @SuppressWarnings("unused")
    public static void main(String[] args) {

        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);

        final Predicate<Integer> integerPredicate = x -> x % 2 == 0;
        filterAndPrint(numbers, integerPredicate);
        System.out.println();

        final Predicate<Integer> integerPredicate1 = x -> x % 2 != 0;
        filterAndPrint(numbers, integerPredicate1);
    }

    private static void filterAndPrint(List<Integer> numbers, Predicate<Integer> integerPredicate) {
        numbers.stream()
                .filter(integerPredicate)
                .forEach(System.out::println);
    }


}
