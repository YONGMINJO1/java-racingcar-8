package racingcar.validator;

import java.util.List;

public class InputValidator {

    private static final int MAX_NAME_LENGTH = 5;

    public static void validateCarNames(List<String> carNames) {
        for (String name : carNames) {
            vaildateSingleCarName(name);
        }
    }

    private static void vaildateSingleCarName(String name) {
        validateNotBlank(name);
        validateLength(name);
    }

    private static void validateNotBlank(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("자동차 이름에 공백을 사용할 수 없습니다.");
        }
    }

    private static void validateLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
    }

    public static void validateTryCount(String input) {
        validateTryCountFormat(input);
        validateTryCountRange(input);
    }

    private static void validateTryCountFormat(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자만 입력 가능합니다.");
        }
    }

    private static void validateTryCountRange(String input) {
        int count = Integer.parseInt(input);
        if (count <= 0) {
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
        }
    }
}
