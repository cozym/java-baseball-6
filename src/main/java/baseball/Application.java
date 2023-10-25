package baseball;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Application {
    public static void main(String[] args) throws IllegalArgumentException{
        // TODO: 프로그램 구현
        List<Integer> computer = new ArrayList<>();
        String user_input = "";
        Scanner sc = new Scanner(System.in);
        int strike;
        int ball;
        int terminate = 1;

        System.out.println("숫자 야구 게임을 시작합니다.");

        do {
            computer.clear();
            // 랜덤 값 생성
            while (computer.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!computer.contains(randomNumber)) {
                    computer.add(randomNumber);
                }
            }
            //System.out.println(computer);
            while (true) {
                strike = 0;
                ball = 0;

                System.out.print("숫자를 입력해주세요 : ");
                user_input = sc.next();

                if (user_input.length() != 3)
                    throw new IllegalArgumentException();

                // strike와 ball 개수 카운트
                for (int i = 0; i < user_input.length(); i++) {
                    if (computer.contains(user_input.charAt(i) - '0')) {
                        if (computer.get(i) == user_input.charAt(i) - '0') {
                            strike++;
                            continue;
                        }
                        ball++;
                    }
                }

                // strike, ball 개수에 따른 출력
                if (strike == 3) {
                    System.out.printf("%d스트라이크\n",strike);
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    break;
                } else if (strike > 0 && ball == 0) {
                    System.out.printf("%d스트라이크\n", strike);
                } else if (ball > 0 && strike == 0) {
                    System.out.printf("%d볼\n", ball);
                } else if (strike > 0 && ball > 0) {
                    System.out.printf("%d볼 %d스트라이크\n", ball, strike);
                } else if (ball == 0 && strike == 0) {
                    System.out.println("낫싱");
                }
            }
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            terminate = sc.nextInt();
        } while (terminate != 2);
    }

    /**
     * 랜덤 값 생성
     * 입력값 검사
     * 입력값 리스트 인덱스 단위 검사
     * 생성된 값 내에 입력값이 있을경우 인덱스 까지 검사
     * 인덱스까지 일치할 경우 strike+, 인덱스 일치하지 않을 경우 ball+
     * 마지막 문자까지 없으면 낫싱
     * 입력값이 잘못되거나 정답이 나올 때 까지 반복
     * 정답이 나온 경우 1또는 2로 재시작/종료 결정
     */
}
