package org.example;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.Throughput)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Fork(value = 1)
@Warmup(iterations = 1, timeUnit = TimeUnit.MILLISECONDS)
@Measurement(iterations = 2, timeUnit = TimeUnit.MILLISECONDS)
public class SampleBenchmark {
    @Benchmark
    public void fibClassic(Blackhole bh) {
        bh.consume(Fib.fibClassic(30));
    }

    @Benchmark
    public void fibTailRec(Blackhole bh) {
        bh.consume(Fib.tailRecFib(30));
    }
}