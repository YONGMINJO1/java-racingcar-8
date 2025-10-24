package racingcar.view;

import java.util.List;
import java.util.Map;

public class OutputView {

    public static void printCarPositions(Map<String, Integer> carPositions) {
        for (String name : carPositions.keySet()) {
            int position = carPositions.get(name);
            System.out.print(name + " : ");
            for (int i = 0; i < position; i++) {
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void printWinners(List<String> winners) {

        String winnersName = String.join(", ", winners);
        System.out.println("최종 우승자: " + winnersName);

    }
}
