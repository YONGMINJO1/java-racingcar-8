package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class RacingGameTest {

    @Test
    void 자동차가_4이상일_경우_전진() {

        List<Car> cars = List.of(new Car("pobi"));
        RacingGame game = new RacingGame(cars);

        game.moveCars(List.of(4));

        assertThat(cars.get(0).getPosition()).isEqualTo(1);
    }

    @Test
    void 자동차가_3이하일_경우_멈춤() {

        List<Car> cars = List.of(new Car("pobi"));
        RacingGame game = new RacingGame(cars);

        game.moveCars(List.of(3));

        assertThat(cars.get(0).getPosition()).isEqualTo(0);
    }
}
