package baseball.bullsAndCows.application;

import baseball.bullsAndCows.domain.ThreeDigitNumber;

public class Fixtures {

    static int createPositiveThreeDigitNumber(final String text) {
        return new ThreeDigitNumber(text).getThreeDigitNumber();
    }

}
