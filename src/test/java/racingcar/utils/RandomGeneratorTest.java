package racingcar.utils;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class RandomGeneratorTest {

    @Test
    void 랜덤_숫자_0_이상_9_이하() {

        assertThat(RandomGenerator.generate())
                .isGreaterThanOrEqualTo(0)
                .isLessThanOrEqualTo(9);
    }
}
