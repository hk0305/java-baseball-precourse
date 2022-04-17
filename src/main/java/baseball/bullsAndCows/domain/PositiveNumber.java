package baseball.bullsAndCows.domain;

public class PositiveNumber {

    private int number;

    public PositiveNumber(char text) {
        validateParseInt(text);
        validatePositive(number);
    }

    private void validateParseInt(final char text) {
        try {
            this.number = Integer.parseInt(
                    String.valueOf(text)
            );
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자 이외의 값은 사용할 수 없습니다.");
        }
    }

    private void validatePositive(int number) {
        if (number < 1 || number > 10) {
            throw new IllegalArgumentException("1부터 9까지 숫자만 사용할 수 있습니다.");
        }
    }

    public int getPositiveNumber() {
        return this.number;
    }

}
