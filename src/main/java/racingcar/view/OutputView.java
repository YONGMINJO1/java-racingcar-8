package racingcar.view;

import java.util.List;
import racingcar.domain.Car;

public class OutputView {

    private static final String POSITION_MARKER = "-";
    private static final String DELIMITER = " : ";
    private static final String WINNER_PREFIX = "최종 우승자 : ";
    private static final String NAME_SEPARATOR = ", ";
    private static final String RACE_START_MESSAGE = "실행 결과";

    public static void printRaceStart() {
        System.out.println();
        System.out.println(RACE_START_MESSAGE);
    }

    public static void printCarPositions(List<Car> cars) {
        printEachCar(cars);
        printEmptyLine();
    }

    private static void printEachCar(List<Car> cars) {
        for (Car car : cars) {
            printSingleCar(car);
        }
    }

    private static void printSingleCar(Car car) {
        String carStatus = formatCarStatus(car);
        System.out.println(carStatus);
    }

    private static String formatCarStatus(Car car) {
        return car.getName() + DELIMITER + generatePositionBar(car.getPosition());
    }

    private static String generatePositionBar(int position) {
        return POSITION_MARKER.repeat(position);
    }

    public static void printEmptyLine() {
        System.out.println();
    }

    public static void printWinners(List<String> winners) {
        String result = formatWinners(winners);
        System.out.println(result);
    }

    private static String formatWinners(List<String> winners) {
        String winnersName = String.join(NAME_SEPARATOR, winners);
        return WINNER_PREFIX + winnersName;
    }
}
