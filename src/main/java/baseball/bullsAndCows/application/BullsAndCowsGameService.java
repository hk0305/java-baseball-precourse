package baseball.bullsAndCows.application;

import baseball.bullsAndCows.domain.*;
import camp.nextstep.edu.missionutils.Console;

public class BullsAndCowsGameService implements BullsAndCowsGame {

    private static final String 게임_재시작 = "1";
    private static final String 게임_종료 = "2";
    private int answer;
    private boolean isContinueGame = false;

    public BullsAndCowsGameService(final int answer) {
        this.answer = answer;
    }

    @Override
    public boolean play(final String inputText) {
        System.out.println(inputText);
        boolean hasHints = new Hints().hasHints(
                this.answer
                , new ThreeDigitNumber(inputText).getThreeDigitNumber());

        if (!hasHints) {
            GuideMessage.게임_재시작_안내.printLnMessage();
            chooseRestart(Console.readLine());
            return isContinueGame;
        }

        return true;
    }

    private void chooseRestart(final String inputText) {

        if (게임_재시작.equals(inputText)) {
            System.out.println(inputText);
            this.answer = new Opponent().pickAnswerNumber();
            this.isContinueGame = true;
        }

        if (게임_종료.equals(inputText)) {
            System.out.println(inputText);
            GuideMessage.게임_종료_안내.printLnMessage();
            this.isContinueGame = false;
        }

        if (!게임_재시작.equals(inputText)
                && !게임_종료.equals(inputText)) {
            throw new IllegalArgumentException("올바른 값이 입력되지 않아 프로그램을 종료합니다.");
        }

    }

}
