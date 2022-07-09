package org.example;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FibTest {


    @Test
    void fibClassic() {
        Assertions.assertThat(Fib.fibClassic(12)).isEqualTo(144);
    }

    @Test
    void tailRecFib() {
        Assertions.assertThat(Fib.tailRecFib(12)).isEqualTo(144);
    }
}