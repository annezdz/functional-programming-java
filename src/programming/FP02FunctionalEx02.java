package programming;

import java.util.List;
import java.util.stream.Collectors;

public class FP02FunctionalEx02 {
    public static void main(String[] args) {

        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);

        int sum = addListFunctional(numbers);
        System.out.println(sum);
        System.out.println("--- Collectors Example ---");
        System.out.println(doubleList(numbers));
        System.out.println();
        List<Integer> doubledNumbers = doubleList(numbers);
        System.out.println(doubledNumbers);

    }

    private static List<Integer> doubleList(List<Integer> numbers) {
        //1 , 5, 6
        //1 -> 1
        //5 -> 25
        //6 -> 36
        //Transform a list in Stream and transform in a map and return how a list
        return numbers.stream()
                .map(number -> number * number) ////Stream<R>
                .collect(Collectors.toList()); //R
    }


    private static int addListFunctional(List<Integer> numbers) {
        return numbers.stream()
                //.reduce(0, (x,y) -> x + y);
                .reduce(0, Integer::sum); //void T

    }
}



