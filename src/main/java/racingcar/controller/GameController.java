package racingcar.controller;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.domain.RacingGame;
import racingcar.view.OutputView;

public class GameController {

    private final RacingGame game;
    private final List<List<Integer>> rounds;

    public GameController(RacingGame game, List<List<Integer>> rounds) {
        this.game = game;
        this.rounds = rounds;
    }

    public void play() {
        for (List<Integer> randomNumbers : rounds) {
            game.moveCars(randomNumbers);
            OutputView.printCarPositions(game.getCars());
        }

        List<String> winners = game.getCars().stream()
                .filter(car -> car.getPosition() == getMaxPosition())
                .map(Car::getName)
                .collect(Collectors.toList());

        OutputView.printWinners(winners);
    }

    private int getMaxPosition() {
        return game.getCars().stream()
                .mapToInt(Car::getPosition)
                .max().
                orElse(0);
    }
}
