package org.example;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;


import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.SampleTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Fork(value = 1)
@Warmup(iterations = 5, timeUnit = TimeUnit.MILLISECONDS)
@Measurement(iterations = 5, timeUnit = TimeUnit.MILLISECONDS)
public class StreamBenchmark {

    @Benchmark
    public void fibClassic(Blackhole bh, BookDataSupplier bookDataSupplier) {
        System.out.println(bookDataSupplier.books());
        bh.consume(30);
    }
}
