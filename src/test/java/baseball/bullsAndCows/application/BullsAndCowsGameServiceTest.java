package baseball.bullsAndCows.application;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class BullsAndCowsGameServiceTest {

    @DisplayName("입력한 값이 3자리 숫자여야 한다.")
    @ParameterizedTest
    @ValueSource(strings = {"321", "345", "876"})
    void inputPositiveThreeNumbers(final String text) {
        int actual = Fixtures.createPositiveThreeDigitNumber(text);
        assertThat(actual).isEqualTo(
                Integer.parseInt(text)
        );
    }

    @DisplayName("입력한 값이 숫자가 아니면, IllegalArgumentException 예외 처리 한다.")
    @ParameterizedTest
    @ValueSource(strings = {"문자", "테스트", "일23"})
    void cannotParseNumbers(final String text) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> Fixtures.createPositiveThreeDigitNumber(text));
    }

    @DisplayName("입력한 값이 3자리 숫자가 아니면, IllegalArgumentException 예외 처리 한다.")
    @ParameterizedTest
    @ValueSource(strings = {"12", "4", "1"})
    void notThreeDigitNumbers(final String text) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> Fixtures.createPositiveThreeDigitNumber(text));
    }

    @DisplayName("입력한 값은 서로 다른 3개의 숫자여야 한다.")
    @ParameterizedTest
    @ValueSource(strings = {"112", "211", "121", "111"})
    void notThreeDifferentNumbers(final String text) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> Fixtures.createPositiveThreeDigitNumber(text));
    }

}
