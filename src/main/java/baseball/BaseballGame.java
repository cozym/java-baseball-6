package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class BaseballGame {
    List<Integer> user = new ArrayList<>();

    public void inputNumber() {
        try {
            String input = Console.readLine();
            for (int i = 0; i < input.length(); i++) {
                int num = Integer.parseInt(String.valueOf(input.charAt(i)));
                user.add(checkNum(num));
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private int checkNum(int num) {
        if (num < 1) {
            throw new IllegalArgumentException();
        }
        return num;
    }
}
