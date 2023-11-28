package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class BaseballGame {
    List<Integer> user = new ArrayList<>();
    Referee referee = new Referee();
    RandomGenerator randomGenerator = new RandomGenerator();

    public void inputNumber() {
        try {
            user.clear();
            System.out.print("숫자를 입력해주세요 : ");
            String input = Console.readLine();
            for (int i = 0; i < input.length(); i++) {
                int num = Integer.parseInt(String.valueOf(input.charAt(i)));
                user.add(checkNum(num));
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    public void playGame() {
        List<Integer> randomNumber = randomGenerator.getRandomNumber();
        int again = 0;

        System.out.println("숫자 야구 게임을 시작합니다.");
        while (again != 2) {
            inputNumber();
            referee.compareNumbers(user, randomNumber);
            again = referee.printResult();
            if (again == 1) {
                randomNumber = randomGenerator.getRandomNumber();
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                again = Integer.parseInt(Console.readLine());
            }
        }
    }

    private int checkNum(int num) {
        if (num < 1) {
            throw new IllegalArgumentException();
        }
        return num;
    }
}
