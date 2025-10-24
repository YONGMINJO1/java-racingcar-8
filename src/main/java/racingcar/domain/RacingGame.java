package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {

    private static final int MOVE_THRESHOLD = 4;
    private final List<Car> cars;

    public RacingGame(List<Car> cars) {
        this.cars = cars;
    }

    public void moveCars(List<Integer> randomNumbers) {
        for (int i = 0; i < cars.size(); i++) {
            moveIfPossible(cars.get(i), randomNumbers.get(i));
        }
    }

    private void moveIfPossible(Car car, int randomNumber) {
        if (randomNumber >= MOVE_THRESHOLD) {
            car.move();
        }
    }

//    public void moveCars(List<Integer> randomNumbers) {
//        for (int i = 0; i < cars.size(); i++) {
//            if (randomNumbers.get(i) >= MOVE_THRESHOLD) {
//                cars.get(i).move();
//            }
//        }
//    }

    public List<Car> getCars() {
        return cars;
    }

    public List<String> getWinners() {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
        return cars.stream().filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}
