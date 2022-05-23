package programming;

import java.util.List;
import java.util.stream.Collectors;

public class FP02ExerciseAnneResolution {
    public static void main(String[] args) {

        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
        List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices", "AWS",
                "PCF", "Azure", "Docker","Kubernetes");
        System.out.println();
        System.out.println(sumOfSquares(numbers));
        System.out.println();
        System.out.println(sumOfCube(numbers));
        System.out.println();
        System.out.println(sumOfOdd(numbers));
        System.out.println();
        System.out.println(evenList(numbers));
        System.out.println(listLengths(courses));

    }

    private static List<Integer> listLengths(List<String> courses) {
      return courses.stream()
              .map(c -> c.length())
              .collect(Collectors.toList());
    }

    private static List<Integer> evenList(List<Integer> numbers) {
        return numbers.stream()
                .filter(number -> number % 2 != 0)
                .collect(Collectors.toList());
    }

    private static int sumOfSquares(List<Integer> numbers) {
       return numbers.stream()
                .map(number -> number * number)
                .reduce(0, (x,y) -> x + y);
    }

    private static int sumOfCube(List<Integer> numbers) {
        return numbers.stream()
                .map(number -> number * number * number)
                .reduce(0, (x,y) -> x + y);
    }

    private static int sumOfOdd(List<Integer> numbers) {
        return numbers.stream()
                .filter(number -> number % 2 != 0)
                .reduce(0,(x, y) -> x + y);
    }
}
