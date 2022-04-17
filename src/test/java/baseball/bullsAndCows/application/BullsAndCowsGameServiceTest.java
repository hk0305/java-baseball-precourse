package baseball.bullsAndCows.application;

import baseball.bullsAndCows.domain.GuideMessage;
import baseball.bullsAndCows.domain.Hints;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class BullsAndCowsGameServiceTest {

    private BullsAndCowsGameService bullsAndCowsGameService;

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        bullsAndCowsGameService = new BullsAndCowsGameService(Fixtures.TEST_ANSWER_NUMBER);
        System.setOut(new PrintStream(outputStreamCaptor));
    }

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

    @DisplayName("정답이 '425'일 때, 힌트를 가지며 출력값은 '낫싱' 이다.")
    @ParameterizedTest
    @ValueSource(strings = "789")
    void hintNothing(final String input) {
        assertThat(new Hints().hasHints(
                Fixtures.TEST_ANSWER_NUMBER
                , Integer.parseInt(input)
        )).isTrue();
        Assertions.assertEquals(
                GuideMessage.낫싱
                        .getMessage().trim()
                , outputStreamCaptor.toString().trim()
        );
    }

    @DisplayName("정답이 '425'일 때, 힌트를 가지며 출력값은 '1스트라이크' 이다")
    @ParameterizedTest
    @ValueSource(strings = "123")
    void hintOneStrike(final String input) {
        assertThat(new Hints().hasHints(
                Fixtures.TEST_ANSWER_NUMBER
                , Integer.parseInt(input)
        )).isTrue();
        Assertions.assertEquals(
                "1스트라이크".trim()
                , outputStreamCaptor.toString().trim()
        );
    }

    @DisplayName("정답이 '425'일 때, 힌트를 가지며 출력값은 '1볼 1스트라이크' 이다")
    @ParameterizedTest
    @ValueSource(strings = "456")
    void hintOneBallAndOneStrike(final String input) {
        assertThat(new Hints().hasHints(
                Fixtures.TEST_ANSWER_NUMBER
                , Integer.parseInt(input)
        )).isTrue();
        Assertions.assertEquals(
                "1볼 1스트라이크".trim()
                , outputStreamCaptor.toString().trim()
        );
    }

    @DisplayName("정답이 '425'일 때, 힌트를 갖지 않으며, '3스트라이크'를 출력한다.")
    @ParameterizedTest
    @ValueSource(strings = "425")
    void threeStrike(final String input) {
        assertThat(new Hints().hasHints(
                Fixtures.TEST_ANSWER_NUMBER
                , Integer.parseInt(input)
        )).isFalse();

        Assertions.assertEquals(
                GuideMessage.쓰리_스트라이크
                        .getMessage().trim()
                , outputStreamCaptor.toString().trim()
        );
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

}
