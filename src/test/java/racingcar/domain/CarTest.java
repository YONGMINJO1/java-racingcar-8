package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    void 자동차_이름_5자_이상_일때_예외() {
        assertThatThrownBy(() -> new Car("asdfgh"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 5자 이하만 가능합니다.");
    }

    @Test
    void 자동차_이름_정상() {
        Car car = new Car("pobi");
        assertThat(car.getName()).isEqualTo("pobi");
    }

    @Test
    void 자동차_이름_공백_예외() {
        assertThatThrownBy(() -> new Car(" "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름에 공백을 사용할 수 없습니다.");
    }
}
