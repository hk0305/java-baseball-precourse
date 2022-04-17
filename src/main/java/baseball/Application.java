package baseball;

import baseball.bullsAndCows.application.BullsAndCowsGameService;
import baseball.bullsAndCows.domain.GuideMessage;
import baseball.bullsAndCows.domain.Opponent;
import camp.nextstep.edu.missionutils.Console;

public class Application {

    private static BullsAndCowsGameService bullsAndCowsGameService;

    public static void main(String[] args) {
        bullsAndCowsGameService = new BullsAndCowsGameService(new Opponent().pickAnswerNumber());
        do {
            GuideMessage.숫자입력_안내.printMessage();
        }
        while (bullsAndCowsGameService.play(Console.readLine()));
    }

}
