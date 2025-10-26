package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.RacingGame;
import racingcar.utils.RandomGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {

    public void run() {
        RacingGame game = createGame();
        int tryCount = getTryCount();
        OutputView.printRaceStart();
        playRounds(game, tryCount);
        printResult(game);
    }

    private RacingGame createGame() {
        List<String> carNames = InputView.carNames();
        List<Car> cars = createCars(carNames);
        return new RacingGame(cars);
    }

    private List<Car> createCars(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(name));
        }
        return cars;
    }

    private int getTryCount() {
        return InputView.tryCount();
    }

    private void playRounds(RacingGame game, int tryCount) {
        for (int i = 0; i < tryCount; i++) {
            playRound(game);
        }
    }

    private void playRound(RacingGame game) {
        List<Integer> randomNumbers = generateRandomNumbers(game.getCars().size());
        game.moveCars(randomNumbers);
        OutputView.printCarPositions(game.getCars());
    }

    private List<Integer> generateRandomNumbers(int count) {
        List<Integer> randomNumbers = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            randomNumbers.add(RandomGenerator.generate());
        }
        return randomNumbers;
    }

    private void printResult(RacingGame game) {
        List<String> winners = game.getWinners();
        OutputView.printWinners(winners);
    }
}
