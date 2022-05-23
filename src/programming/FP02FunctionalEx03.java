package programming;

import java.util.Comparator;
import java.util.List;

public class FP02FunctionalEx03 {
    public static void main(String[] args) {

        //Distinct - Delete repeted numbers

        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);

        numbers.stream()
                .distinct() //Stream<T>
                .forEach(System.out::println);

        //Sorted - ordered de elements in a list
        System.out.println();
        numbers.stream()
                .sorted()//Stream<T>
                .forEach(System.out::println);
        System.out.println();

        //Distinct and sorted

        numbers.stream().distinct().sorted().forEach(System.out::println);
        System.out.println();

        List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices", "AWS",
                "PCF", "Azure", "Docker","Kubernetes");

        courses.stream().sorted().forEach(System.out::println);

        System.out.println();
        //Ordem natural é a ordem ascendente
        courses.stream().sorted(Comparator.naturalOrder()).forEach(System.out::println);
        System.out.println();
        //Imprimindo na ordem inversa
        courses.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
        System.out.println();
        //Comparando pelo tamanho da palavra e ordenando
        courses.stream()
                .sorted(Comparator.comparing(str -> str.length()))
                .forEach(System.out::println); // void //R

        //Intermediate and Terminal Stream Operations



    }

}
