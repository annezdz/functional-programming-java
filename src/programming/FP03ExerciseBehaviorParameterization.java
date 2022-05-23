package programming;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FP03ExerciseBehaviorParameterization {
    @SuppressWarnings("unused")
    public static void main(String[] args) {

        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);

        Function<Integer, Integer> squareFunction = x -> x * x;
        Function<Integer, Integer> cubeFunction = x -> x * x * x;

        List squaredNumbers = getCollect(numbers, squareFunction);
        System.out.println(squaredNumbers);

    }

    private static List<Integer> getCollect(List<Integer> numbers, Function<Integer, Integer> squareFunction) {
        return numbers.stream()
                .map(squareFunction)
                .collect(Collectors.toList());
    }
}
