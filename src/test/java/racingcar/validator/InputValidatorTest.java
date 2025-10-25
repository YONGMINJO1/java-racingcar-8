package racingcar.validator;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

public class InputValidatorTest {

    @Test
    void 자동차_이름_정상_입력() {
        List<String> names = List.of("pobi", "crong", "honux");
        assertThatCode(() -> InputValidator.validateCarNames(names))
                .doesNotThrowAnyException();
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
    void 시도_횟수_최솟값_1_정상() {
        String input = "1";

        assertThatCode(() -> InputValidator.validateTryCount(input))
                .doesNotThrowAnyException();
    }

    @Test
    void 시도_횟수_일반_숫자_정상() {
        String input = "5";

        assertThatCode(() -> InputValidator.validateTryCount(input))
                .doesNotThrowAnyException();
    }

    @Test
    void 시도_횟수_0_이하_숫자_예외() {
        String input = "0";

        assertThatThrownBy(() -> InputValidator.validateTryCount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도 횟수는 1 이상이어야 합니다.");
    }

    @Test
    void 시도_횟수_음수_예외() {
        String input = "-5";

        assertThatThrownBy(() -> InputValidator.validateTryCount("-5"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도 횟수는 1 이상이어야 합니다.");
    }

    @Test
    void 시도_횟수_숫자_아닌_입력_예외() {
        String input = "abc";

        assertThatThrownBy(() -> InputValidator.validateTryCount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도 횟수는 숫자만 입력 가능합니다.");
    }

    @Test
    void 시도_횟수_소수_입력_예외() {
        // given
        String input = "1.5";

        // when & then
        assertThatThrownBy(() -> InputValidator.validateTryCount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자");
    }
}
