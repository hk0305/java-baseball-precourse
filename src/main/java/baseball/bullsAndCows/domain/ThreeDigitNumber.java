package baseball.bullsAndCows.domain;

import org.junit.platform.commons.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ThreeDigitNumber {

    private int threeDigitNumber;

    public ThreeDigitNumber(final String text) {
        validateThreeDigitNumber(text);
        parsePositiveThreeDigitNumber(text);
    }

    private void validateThreeDigitNumber(final String text) {
        if (StringUtils.isBlank(text)) {
            throw new IllegalArgumentException("입력 값이 없습니다.");
        }

        if (text.length() != 3) {
            throw new IllegalArgumentException("3자리 숫자만 사용할 수 있습니다.");
        }
    }

    private void parsePositiveThreeDigitNumber(final String text) {
        int parseThreeDigitNumber = parseThreeDigitNumber(text);
        this.threeDigitNumber = parseThreeDigitNumber;
    }

    private int parseThreeDigitNumber(final String text) {
        List<Integer> parsedThreeDigitNumber = new ArrayList<>();
        for (int k = 0; k < 3; k++) {
            parsedThreeDigitNumber.add(
                    new PositiveNumber(text.charAt(k))
                            .getPositiveNumber()
            );
        }

        checkIfNumbersSame(parsedThreeDigitNumber.get(0)
                , parsedThreeDigitNumber.get(1)
                , parsedThreeDigitNumber.get(2));

        int thirdDigit = parsedThreeDigitNumber.get(0) * 100;
        int secondDigit = parsedThreeDigitNumber.get(1) * 10;
        int firstDigit = parsedThreeDigitNumber.get(2);

        return thirdDigit + secondDigit + firstDigit;
    }

    private void checkIfNumbersSame(final int first, final int second, final int third) {
        if (first == second
                || first == third
                || second == third) {
            throw new IllegalArgumentException("같은 숫자는 사용할 수 없습니다.");
        }
    }

    public int getThreeDigitNumber() {
        return this.threeDigitNumber;
    }

}
