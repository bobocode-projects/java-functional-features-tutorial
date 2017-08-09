package com.bobocode;


import java.util.function.LongPredicate;
import java.util.stream.LongStream;

public class StreamExamples_ParallelProcessing {
    static final long STREAM_SIZE = 100000000;
    static final int N = 12;

    public static void main(String[] args) {
        LongPredicate isEven = n -> n % 2 == 0;

        System.out.println("Sequential processing");
        performNTimes(N, () -> LongStream.range(1, STREAM_SIZE).filter(isEven).count());

        System.out.println("\nParallel processing");
        performNTimes(N, () -> LongStream.range(1, STREAM_SIZE).parallel().filter(isEven).count());

    }

    static void performNTimes(int n, Runnable r) {
        LongStream.range(0, n).forEach(i -> {
                    long start = System.nanoTime();
                    r.run();
                    System.out.println((System.nanoTime() - start) / 1_000_000 + " ms");
                }
        );
    }
}
