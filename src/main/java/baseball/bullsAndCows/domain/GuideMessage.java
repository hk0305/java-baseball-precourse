package baseball.bullsAndCows.domain;

public enum GuideMessage {

    숫자입력_안내("숫자를 입력해 주세요 : "),
    게임_재시작_안내("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."),
    게임_종료_안내("게임 종료"),
    쓰리_스트라이크("3스트라이크"),
    낫싱("낫싱");

    private final String message;

    GuideMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

    public void printMessage() {
        System.out.print(this.message);
    }

    public void printLnMessage() {
        System.out.println(this.message);
    }

}
