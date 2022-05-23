package programming;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class FP04 {
    public static void main(String[] args) {
        //Soma de 0 a 9 == 45
        System.out.println(IntStream.range(1,10).sum());

        //Soma de 1 a 10 == 55
        System.out.println(IntStream.rangeClosed(1,10).sum());
        //100
        System.out.println(IntStream.iterate(1, e -> e + 2).limit(10).sum());
        System.out.println();
        System.out.println(IntStream.iterate(1, e -> e + 2)
                .limit(10)
                .peek(System.out::println).sum());
        System.out.println();
        System.out.println(IntStream.iterate(2, e -> e + 2).limit(10).sum());
        System.out.println(IntStream.iterate(2, e -> e * 2).limit(10).sum());
        System.out.println("Boxed");
        System.out.println(IntStream.iterate(2, e -> e * 2).limit(10).boxed().collect(Collectors.toList()));

        System.out.println(IntStream.rangeClosed(1,50).reduce(1,(x,y) -> x * y));
        System.out.println(LongStream.rangeClosed(1,50).reduce(1,(x, y) -> x * y));

    }
}
