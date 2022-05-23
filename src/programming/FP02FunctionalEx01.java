package programming;

import java.util.List;

public class FP02FunctionalEx01 {
    public static void main(String[] args) {

        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
        int sum = addListFunctional(numbers);
        System.out.println(sum);

    }

    private static int sum(int aggregate , int nextNumber) {
        System.out.println(aggregate + " + " + nextNumber);
        return aggregate + nextNumber;
    }

    private static int addListFunctional(List<Integer> numbers) {
        //Stream of numbers -> One result value
        //Combine them into one result => One Value
        // 0  and (a,b) -> a + b FP02Functional::sum
        return numbers.stream()
                .reduce(0, FP02FunctionalEx01::sum);

    }
}



