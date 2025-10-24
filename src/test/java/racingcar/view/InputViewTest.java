package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

public class InputViewTest {

    @AfterEach
    void tearDown() {
        Console.close(); // Scanner를 닫지 않으면 오류 발생
    }

    @Test
    void 자동차_이름_입력() {

        String input = "pobi,crong,honux";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        List<String> names = InputView.carNames();

        assertThat(names).containsExactly("pobi", "crong", "honux");
    }

    @Test
    void 시도_횟수_입력() {

        String input = "5";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        int tryCount = InputView.tryCount();

        assertThat(tryCount).isEqualTo(5);
    }
}
