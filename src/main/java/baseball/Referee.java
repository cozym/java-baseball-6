package baseball;

import java.util.List;
import java.util.Objects;

public class Referee {
    int[] result;

    public void compareNumbers(List<Integer> user, List<Integer> computer) {
        result = new int[]{0, 0};
        if (user.size() != 3) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < user.size(); i++) {
            if (Objects.equals(user.get(i), computer.get(i))) {
                result[0]++;
            } else if (computer.contains(user.get(i))) {
                result[1]++;
            }
        }
    }

    public int printResult() {
        if (result[0] > 0 && result[1] > 0) {
            System.out.printf("%d볼 %d스트라이크\n", result[1], result[0]);
        } else if (result[0] == 3) {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return 1;
        } else if (result[0] > 0 && result[1] == 0) {
            System.out.printf("%d스트라이크\n", result[0]);
        } else if (result[0] == 0 && result[1] > 0) {
            System.out.printf("%d볼\n", result[1]);
        } else if (result[0] == 0 && result[1] == 0) {
            System.out.println("낫싱");
        }
        return 0;
    }
}
