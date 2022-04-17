package baseball.bullsAndCows.domain;

public class Hints {

    private static final String APPEND_BLANK = " ";
    private int strikeCount = 0;
    private int ballCount = 0;

    public boolean hasHints(final int answer, final int inputNumber) {
        calculatorStrikeAndBallCount(
                String.valueOf(answer)
                , String.valueOf(inputNumber)
        );

        if (isThreeStrike())
            return false;

        if (isNothing())
            return true;

        StringBuilder hintMessageAppender = new StringBuilder();
        getBallMessage(ballCount, hintMessageAppender);
        getStrikeMessage(strikeCount, hintMessageAppender);
        System.out.println(hintMessageAppender);
        return true;
    }

    private void calculatorStrikeAndBallCount(final String firstInput, final String secondInput) {
        for (int k = 0; k < 3; k++) {
            if (firstInput.charAt(k) == secondInput.charAt(k)) {
                this.strikeCount++;
            } else if (firstInput.contains(
                    String.valueOf(secondInput.charAt(k)))
            ) {
                this.ballCount++;
            }
        }
    }

    private boolean isThreeStrike() {
        if (this.strikeCount == 3) {
            GuideMessage.쓰리_스트라이크.printLnMessage();
            return true;
        }
        return false;
    }

    private boolean isNothing() {
        if (strikeCount == 0 && ballCount == 0) {
            GuideMessage.낫싱.printLnMessage();
            return true;
        }
        return false;
    }

    private void getBallMessage(final int strikeCount, final StringBuilder appender) {
        if (ballCount > 0) {
            appender.append(ballCount);
            appender.append(HintsType.볼);
            appender.append(APPEND_BLANK);
        }
    }

    private void getStrikeMessage(final int strikeCount, final StringBuilder appender) {
        if (strikeCount > 0) {
            appender.append(strikeCount);
            appender.append(HintsType.스트라이크);
        }
    }

}
