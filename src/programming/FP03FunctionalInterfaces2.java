package programming;

import java.util.List;
import java.util.Random;
import java.util.function.*;

public class FP03FunctionalInterfaces2 {


    @SuppressWarnings("unused")
    public static void main(String[] args) {

        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);

        Predicate<Integer> isEvenPredicate = x -> x % 2 == 0;

        Function<Integer, Integer> squareFunction = x -> x * x;

        Function<Integer, String> stringOutputFunction = x -> " ";
        Consumer<Integer> sysoutConsumer = x -> System.out.println(x);

        BinaryOperator<Integer> sumBinaryOperator = (x,y) -> x + y;

        //No input > Return something (FACTORY)
        Supplier<Integer> randomIntegerSupplier = () -> 2; //não temos parametros () e ganhamos o 2 de volta

        System.out.println(randomIntegerSupplier.get());

        Supplier<Integer> randomIntegerSupplier1= () -> {
            Random random = new Random();
           return random.nextInt();
        };

        System.out.println(randomIntegerSupplier1.get());

        UnaryOperator<Integer> unaryOperator = (x) -> 3 * x;
        System.out.println();
        System.out.println(unaryOperator.apply(10));
        System.out.println();

        //Usar o BiPredicate quando tivermos duas entradas na lambda e quisermos retornar
        //um boolean

        BiPredicate<Integer, String> biPredicate =  (number, str) ->  {
            return number < 10 && str.length() > 5;
        };
        System.out.println();
        System.out.println(biPredicate.test(5,"anneNi"));

        //BiFunction - > quando tivermos duas entradas e quisermos devolver um retorno (pode ser diferente)
        BiFunction<Integer, String, String> biFunction =  (number, str) ->  {
            return number + " - " + str;
        };
        System.out.println();
        System.out.println(biFunction.apply(10, "Anne"));

        //BiConsumer -> pega uma entrada e imprime ou consome

        BiConsumer<String, String> biConsumer = (s1, s2) -> {
            System.out.println(s1);
            System.out.println(s2);
        };
        System.out.println();
        biConsumer.accept("Anne","Dudu");

        IntBinaryOperator intBinaryOperator = (x,y) -> x + y;

        Consumer<String> consumer = System.out::println;

    }

    private static void filterAndPrint(List<Integer> numbers, Predicate<Integer> integerPredicate) {
        numbers.stream()
                .filter(integerPredicate)
                .forEach(System.out::println);
    }


}
