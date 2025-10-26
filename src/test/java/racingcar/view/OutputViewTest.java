package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

public class OutputViewTest {

    private ByteArrayOutputStream outputStream;
    private PrintStream originalOut;

    @BeforeEach
    void setUp() {
        outputStream = new ByteArrayOutputStream();
        originalOut = System.out;
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    void 실행_결과_출력() {
        OutputView.printRaceStart();

        String output = outputStream.toString();
        assertThat(output).contains("실행 결과");
    }


    @Test
    void 자동차_위치_출력() {
        List<Car> cars = List.of(new Car("pobi"), new Car("crong"));
        cars.get(0).move();
        cars.get(0).move();
        cars.get(1).move();
        cars.get(1).move();
        cars.get(1).move();

        OutputView.printCarPositions(cars);

        String output = outputStream.toString();
        assertThat(output).isEqualToNormalizingNewlines(
                "pobi : --\n" +
                        "crong : ---\n" +
                        "\n"
        );
    }

    @Test
    void 최종_우승자_출력() {

        List<String> winners = Arrays.asList("pobi", "crong");

        OutputView.printWinners(winners);

        String output = outputStream.toString();
        assertThat(output).isEqualToNormalizingNewlines("최종 우승자 : pobi, crong\n");
    }
}
