package baseball.bullsAndCows.domain;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Opponent {

    private int answer;

    public Opponent() {
        makeRandomNumber();
    }

    private void makeRandomNumber() {
        Set<Integer> numberSet = new LinkedHashSet<>();
        do {
            numberSet.add(pickNumberInRange(1, 9));
        } while (isNumberSetLength(numberSet));

        parseAnswerNumbers(numberSet);
    }

    private boolean isNumberSetLength(final Set<Integer> numberSet) {
        if (numberSet.size() != 3) {
            return true;
        }

        return false;
    }

    private void parseAnswerNumbers(final Set<Integer> numberSet) {
        List<Integer> numberList = new ArrayList<>(numberSet);

        int firstDigit = numberList.get(0) * 100;
        int secondDigit = numberList.get(1) * 10;
        int thirdDigit = numberList.get(2);

        this.answer = firstDigit + secondDigit + thirdDigit;
    }

    public int pickAnswerNumber() {
        return this.answer;
    }

}
