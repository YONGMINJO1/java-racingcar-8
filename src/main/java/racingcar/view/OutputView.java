package racingcar.view;

import java.util.List;
import racingcar.domain.Car;

public class OutputView {

    public static void printCarPositions(List<Car> cars) {
        for (Car car : cars ) {
            System.out.print(car.getName() + " : ");
            for (int i = 0; i < car.getPosition(); i++) {
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void printWinners(List<String> winners) {

        String winnersName = String.join(", ", winners);
        System.out.println("최종 우승자 : " + winnersName);

    }
}
