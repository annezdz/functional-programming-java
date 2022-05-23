package programming;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FP07 {
    public static void main(String[] args) {

        //FlapMap
        List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices", "AWS",
                "PCF", "Azure", "Docker","Kubernetes");
        List<String> courses2 = List.of("Spring", "Spring Boot", "API", "Microservices", "AWS",
                "PCF", "Azure", "Docker","Kubernetes");



        System.out.println(courses.stream().collect(Collectors.joining(" ")));
        //Spring Spring Boot API Microservices AWS PCF Azure Docker Kubernetes
        System.out.println(courses.stream().collect(Collectors.joining(" * ")));
        //Spring * Spring Boot * API * Microservices * AWS * PCF * Azure * Docker * Kubernetes

        //Flatmap each element of stream replaced with content of mapped stream (Arrays::stream)
        System.out.println(courses.stream()
                .map(course -> course.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.toList()));

        //Join completo  de 2 listas
        System.out.println(courses.stream()
                .flatMap(course -> courses2.stream().map(course2 -> List.of(course, course2)))
                .collect(Collectors.toList()));

        System.out.println();
        //print same elements repeated twice
        System.out.println(courses.stream()
                .flatMap(course -> courses2.stream().map(course2 -> List.of(course, course2)))
                .filter(list -> list.get(0).equals(list.get(1)))
                .collect(Collectors.toList()));

        //Eliminate same elements repeated twice
        System.out.println(courses.stream()
                .flatMap(course -> courses2.stream().map(course2 -> List.of(course, course2)))
                .filter(list -> !list.get(0).equals(list.get(1)))
                .collect(Collectors.toList()));

        //Filter tuples with same length
        System.out.println();
        System.out.println(courses.stream().flatMap(course -> courses2.stream().filter(course2 -> course2.length()== course.length())
                .map(course2 -> List.of(course, course2)))
                .filter(list -> !list.get(0).equals(list.get(1)))
                .collect(Collectors.toList()));
    }


}
