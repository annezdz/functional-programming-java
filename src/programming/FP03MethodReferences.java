package programming;

import java.util.List;
import java.util.Locale;

public class FP03MethodReferences {

    public static void main(String[] args) {

        List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices", "AWS",
                "PCF", "Azure", "Docker","Kubernetes");

        courses.stream()
                //.map(str -> str.toUpperCase())
                .map(String::toUpperCase)
                //.forEach(str -> System.out.println(str));
                .forEach(System.out::println);

    }
}
