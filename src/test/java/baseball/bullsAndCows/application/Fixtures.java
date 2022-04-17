package baseball.bullsAndCows.application;

import baseball.bullsAndCows.domain.ThreeDigitNumber;

public class Fixtures {

    static final int TEST_ANSWER_NUMBER = 425;

    static int createPositiveThreeDigitNumber(final String text) {
        return new ThreeDigitNumber(text).getThreeDigitNumber();
    }

}
