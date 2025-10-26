package racingcar.controller;

import java.util.List;
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
        OutputView.printRaceStart();
        runRounds();
        OutputView.printWinners(game.getWinners());
    }

    private void runRounds() {
        for (List<Integer> randomNumbers : rounds) {
            game.moveCars(randomNumbers);
            OutputView.printCarPositions(game.getCars());
        }
    }
}
