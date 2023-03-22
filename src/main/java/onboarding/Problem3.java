/**
 * 이 클래스는 369게임을 위한 클래스다.
 * 손뼉 횟수 세기 기능에 대한 콘트롤은 clapNum 메소드를 사용하여 수행한다.
 *
 * @version 1.00 03/21/23
 * @author 허준기
 */
package onboarding;

public class Problem3 {
    public static int solution(int number) {
        return calculateClapNum(number);
    }

    public static int calculateClapNum(int number) {
        int clap = 0;
        for (int j = 1; j <= number; j++) {
            if (j % 3 == 0) {
                clap += 1;
            }
            if ((j > 10) && ((j / 10) % 3 == 0)) {
                clap += 1;
                if (((j % 30) == 0)) {
                    clap -= 1;
                }
            }
        }
        return clap;
    }
}
