package programming;

import java.util.List;

public class FP01ExerciseAnneResolution {
    public static void main(String[] args) {

        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
        System.out.println("--- Print All Courses individually --- ");
        printAllCourses(List.of("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Azure", "Docker","Kubernetes"));
        System.out.println("--- Print Courses Containing the word 'Spring'");
        printCoursesContainsSpring(List.of("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Azure", "Docker","Kubernetes"));
        System.out.println("--- Print courses whose name has at least 4 letters. --- ");
        printCoursesWithAtLeast4Letters(List.of("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Azure", "Docker","Kubernetes"));
        System.out.println("--- Print the cube of odd numbers ---");
        printCubeOfOddNumbers(numbers);
        System.out.println("--- Print number of characters in each course name ---");
        printNumberOfLettersInEachCourse(List.of("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Azure", "Docker","Kubernetes"));
    }

    private static void printAllCourses(List<String> courses) {
        courses.stream()
                .forEach(System.out::println);
    }

    private static void printCoursesContainsSpring(List<String> courses) {
        courses.stream()
                .filter(course -> course.contains("Spring") || course.contains("sppring"))
                .forEach(System.out::println);
    }

    private static void printCoursesWithAtLeast4Letters(List<String> courses) {
        courses.stream()
                .filter(course -> course.length() >= 4)
                .forEach(System.out::println);
    }

    private static void printCubeOfOddNumbers(List<Integer> numbers) {
        numbers.stream()
                .filter(number -> number % 2 != 0)
                .map(number -> Math.pow(number,3))
                .forEach(System.out::println);
    }

    private static void printNumberOfLettersInEachCourse(List<String> courses) {
        courses.stream()
                .map(course -> course + " - " + course.length()) // map to map one value to another value
                .forEach(System.out::println); // forEach is used for consume the element
    }

}
