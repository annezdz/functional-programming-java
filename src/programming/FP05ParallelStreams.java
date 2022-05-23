package programming;

import java.util.stream.LongStream;

public class FP05ParallelStreams {
    public static void main(String[] args) {

        long time = System.currentTimeMillis();

        System.out.println(LongStream.range(0, 10000000000L).parallel().sum());
        System.out.println(System.currentTimeMillis() - time);
    }
}
