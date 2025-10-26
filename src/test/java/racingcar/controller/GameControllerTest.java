package racingcar.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.RacingGame;
import racingcar.view.OutputView;

public class GameControllerTest {

    private ByteArrayOutputStream outputStream;
    private PrintStream originalOut;

    @BeforeEach
    void setup() {
        outputStream = new ByteArrayOutputStream();
        originalOut = System.out;
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    void 자동차_이동_후_출력_통합() {
        List<Car> cars = List.of(new Car("pobi"), new Car("crong"));
        RacingGame game = new RacingGame(cars);
        List<Integer> randomNumers = List.of(4, 3);

        game.moveCars(randomNumers);
        OutputView.printCarPositions(game.getCars());

        String output = outputStream.toString();
        assertThat(output).contains("pobi : -");
        assertThat(output).contains("crong : ");
    }

    @Test
    void 여러_라운드_진행_통합() {
        List<Car> cars = List.of(new Car("pobi"), new Car("crong"));
        RacingGame game = new RacingGame(cars);

        game.moveCars(List.of(4, 4));
        OutputView.printCarPositions(game.getCars());

        outputStream.reset();

        game.moveCars(List.of(4, 3));
        OutputView.printCarPositions(game.getCars());

        String output = outputStream.toString();
        assertThat(output).contains("pobi : --");
        assertThat(output).contains("crong : -");
    }

    @Test
    void 우승자_결정_출력_통합() {
        List<Car> cars = List.of(new Car("pobi"), new Car("crong"), new Car("honux"));
        RacingGame game = new RacingGame(cars);

        cars.get(0).move();
        cars.get(0).move();
        cars.get(1).move();
        cars.get(1).move();
        cars.get(2).move();

        List<String> winners = game.getWinners();
        OutputView.printWinners(winners);

        String output = outputStream.toString();
        assertThat(output).contains("최종 우승자 : ");
        assertThat(output).contains("pobi");
        assertThat(output).contains("crong");
    }

    @Test
    void 경주_시작_메시지_통합() {
        List<Car> cars = List.of(new Car("pobi"));
        RacingGame game = new RacingGame(cars);

        OutputView.printRaceStart();
        game.moveCars(List.of(4));
        OutputView.printCarPositions(game.getCars());

        String output = outputStream.toString();
        assertThat(output).contains("실행 결과");
        assertThat(output).contains("pobi : -");
    }

    @Test
    void 전체_게임_흐름_통합() {
        List<Car> cars = List.of(new Car("pobi"), new Car("crong"));
        RacingGame game = new RacingGame(cars);

        OutputView.printRaceStart();

        game.moveCars(List.of(4, 3));
        OutputView.printCarPositions(game.getCars());

        game.moveCars(List.of(4, 4));
        OutputView.printCarPositions(game.getCars());

        List<String> winners = game.getWinners();
        OutputView.printWinners(winners);

        String output = outputStream.toString();
        assertThat(output).contains("실행 결과");
        assertThat(output).contains("최종 우승자");
    }
}
