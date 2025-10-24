package racingcar.domain;

import java.util.List;

public class RacingGame {
    private final List<Car> cars;

    public RacingGame(List<Car> cars) {
        this.cars = cars;
    }

    public void moveCars(List<Integer> randomNumbers) {
        for (int i = 0; i < cars.size(); i++) {
            if (randomNumbers.get(i) >= 4) {
                cars.get(i).move();
            }
        }
    }

    public List<Car> getCars() {
        return cars;
    }
}
