package programming;

import java.util.List;

public class FP01ExerciseTeacherResolution {
    public static void main(String[] args) {

        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
        printOddNumbersInListFunctional(numbers);
        System.out.println();

        List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices", "AWS",
                "PCF", "Azure", "Docker","Kubernetes");

        courses.stream()
                .forEach(System.out::println);

        System.out.println();

        courses.stream()
                .filter(course -> course.contains("Spring"))
                .forEach(System.out::println);

        System.out.println();

        courses.stream()
                .filter(course -> course.length() >= 4)
                .forEach(System.out::println);
    }

    private static void printOddNumbersInListFunctional(List<Integer> numbers) {
        numbers.stream()
                .filter(number -> number%2 == 1)
                .forEach(System.out::println);
    }
}
