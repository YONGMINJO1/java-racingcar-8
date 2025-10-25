package racingcar.validator;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

public class validatorTest {

    @Test
    void 자동차_이름_정상_입력() {
        List<String> names = List.of("pobi", "crong", "honux");
        assertThatNoException().isThrownBy(() -> InputValidator.validateCarNames(names));
    }

    @Test
    void 자동차_이름_공백_이름_예외() {
        List<String> names = List.of("pobi", " ", "crong");
        assertThatThrownBy(() -> InputValidator.validateCarNames(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름에 공백을 사용할 수 없습니다.");
    }

    @Test
    void 자동차_이름_5자_초과_이름_예외() {
        List<String> names = List.of("pobi", "longname");
        assertThatThrownBy(() -> InputValidator.validateCarNames(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 5자 이하만 가능합니다.");
    }

    @Test
    void 시도횟수_정상_숫자_입력() {
        assertThatNoException().isThrownBy(() -> InputValidator.validateTryCount("1"));
        assertThatNoException().isThrownBy(() -> InputValidator.validateTryCount("10"));
    }

    @Test
    void 시도횟수_0_이하_숫자_예외() {
        assertThatThrownBy(() -> InputValidator.validateTryCount("0"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도 횟수는 1 이상이어야 합니다.");

        assertThatThrownBy(() -> InputValidator.validateTryCount("-5"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도 횟수는 1 이상이어야 합니다.");
    }

    @Test
    void 시도횟수_숫자_아닌_입력_예외() {
        assertThatThrownBy(() -> InputValidator.validateTryCount("abc"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도 횟수는 숫자만 입력 가능합니다.");
    }
}
