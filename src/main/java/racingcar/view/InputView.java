package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import racingcar.validator.InputValidator;

public class InputView {

    private static String getUserInput(String message) {
        System.out.println(message);
        return Console.readLine();
    }

    public static List<String> carNames() {
        String input = readCarNamesInput();
        List<String> names = parseCarNames(input);
        InputValidator.validateCarNames(names);
        return names;
    }

    private static String readCarNamesInput() {
        return getUserInput("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public static List<String> parseCarNames(String input) {
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .toList();
    }

    public static int tryCount() {
        String input = readTryCountInput();
        InputValidator.validateTryCount(input);
        return Integer.parseInt(input);
    }

    private static String readTryCountInput() {
        return getUserInput("시도할 횟수는 몇 회인가요?");
    }
}
