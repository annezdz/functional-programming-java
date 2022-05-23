package programming;

import java.util.ArrayList;
import java.util.List;

public class FP08 {
    public static void main(String[] args) {
        List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices", "AWS",
                "PCF", "Azure", "Docker","Kubernetes");
        List<String> newList = new ArrayList<>(courses);

        System.out.println();


        newList.removeIf(course -> course.length() < 6);
    }
}
