/**
 * 이 클래스는 현금 변환을 위한 클래스다.
 * 금액이 큰 단위로 변환하는 기능에 대한 콘트롤은 change 메소드를 사용하여 수행한다.
 *
 * @version 1.00 03/21/23
 * @author 허준기
 */
package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = change(money);
        return answer;
    }

    public static List<Integer> change(int money) {
        List<Integer> devide = new ArrayList<Integer>();
        int monetaryUnit = 50000;
        int moneytaryDigit;
        while (monetaryUnit >= 1) {
            moneytaryDigit = (int) (Math.log10(monetaryUnit));
            if (money >= monetaryUnit) {
                devide.add(money / monetaryUnit);
                money -= monetaryUnit * (money / monetaryUnit);
                if (monetaryUnit / (Math.pow(10, moneytaryDigit)) == 5) {
                    monetaryUnit /= 5;
                } else if (monetaryUnit == 10) {
                    monetaryUnit /= 10;
                } else {
                    monetaryUnit /= 2;
                }
            } else {
                devide.add(0);
                moneytaryDigit = (int) (Math.log10(monetaryUnit));
                if (monetaryUnit / (Math.pow(10, moneytaryDigit)) == 5) {   //(10 ^ (moneytaryDigit))로 자리수 구했더니 오류남..
                    monetaryUnit /= 5;
                } else if (monetaryUnit == 10) {
                    monetaryUnit /= 10;
                } else {
                    monetaryUnit /= 2;
                }
            }
        }
        return devide;
    }
}
