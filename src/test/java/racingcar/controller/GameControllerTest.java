package racingcar.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.RacingGame;
import racingcar.view.OutputView;

public class GameControllerTest {

    @Test
    void 라운드별_자동차_위치() {

        List<Car> cars = List.of(new Car("pobi"), new Car("crong"));
        RacingGame game = new RacingGame(cars);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        List<Integer> randomNumber = List.of(4, 3);
        game.moveCars(randomNumber);

        OutputView.printCarPositions(game.getCars());

        String expected = "pobi : -\ncrong : \n\n";
        assertThat(out.toString()).isEqualToNormalizingNewlines(expected);
    }

    @Test
    void 최종_우숭자() {

        List<Car> cars = List.of(new Car("pobi"), new Car("crong"));
        RacingGame game = new RacingGame(cars);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        List<String> winners = List.of("pobi", "crong");
        OutputView.printWinners(winners);

        String expected = "최종 우승자 : pobi, crong\n";
        assertThat(out.toString()).isEqualToNormalizingNewlines(expected);
    }
}
