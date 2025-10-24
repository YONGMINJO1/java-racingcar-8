package racingcar;

import java.util.ArrayList;
import java.util.List;
import racingcar.controller.GameController;
import racingcar.domain.Car;
import racingcar.domain.RacingGame;
import racingcar.utils.RandomGenerator;
import racingcar.view.InputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        List<String> carNames = InputView.carNames();
        int rounds = InputView.tryCount();

        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(name));
        }

        RacingGame game = new RacingGame(cars);

        List<List<Integer>> allrounds = new ArrayList<>();
        for (int i = 0; i < rounds; i++) {
            List<Integer> roundNumbers = new ArrayList<>();
            for (int j = 0; j < cars.size(); j++) {
                roundNumbers.add(RandomGenerator.generate());
            }
            allrounds.add(roundNumbers);
        }

        GameController controller = new GameController(game, allrounds);
        controller.play();

    }
}
