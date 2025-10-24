package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class OutputViewTest {

    @Test
    void 자동차_위치_출력() {

        Map<String, Integer> carPositions = new LinkedHashMap<>();
        carPositions.put("pobi", 2);
        carPositions.put("crong", 3);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        OutputView.printCarPositions(carPositions);

        String expected = "pobi : --\ncrong : ---\n\n";
        assertThat(out.toString()).isEqualToNormalizingNewlines(expected);
    }

    @Test
    void 최종_우승자_출력() {

        List<String> winners = Arrays.asList("pobi", "crong");

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        OutputView.printWinners(winners);

        String expected = "최종 우승자: pobi, crong\n";
        assertThat(out.toString()).isEqualToNormalizingNewlines(expected);
    }
}
