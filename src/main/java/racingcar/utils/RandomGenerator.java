package racingcar.utils;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomGenerator {

    private static final int MIN_RANDOM = 0;
    private static final int MAX_RANDOM = 9;

    private RandomGenerator() { }

    public static int generate() {
        return Randoms.pickNumberInRange(MIN_RANDOM, MAX_RANDOM);
    }
}
