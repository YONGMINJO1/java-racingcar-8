package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

public class OutputViewTest {

    @Test
    void 자동차_위치_출력() {

        List<Car> cars = List.of(new Car("pobi"), new Car("crong"));
        cars.get(0).move(); // 포지션 1
        cars.get(0).move(); // 포지션 2
        cars.get(1).move(); // 포지션 1
        cars.get(1).move(); // 포지션 2
        cars.get(1).move(); // 포지션 3

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        OutputView.printCarPositions(cars);

        String expected = "pobi : --\ncrong : ---\n\n";
        assertThat(out.toString()).isEqualToNormalizingNewlines(expected);
    }

    @Test
    void 최종_우승자_출력() {

        List<String> winners = Arrays.asList("pobi", "crong");

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        OutputView.printWinners(winners);

        String expected = "최종 우승자 : pobi, crong\n";
        assertThat(out.toString()).isEqualToNormalizingNewlines(expected);
    }
}
