/**
 * 이 클래스는 페이지 번호 게임을 위한 클래스다.
 * 포비와 크롱의 점수 비교 기능에 대한 콘트롤은 compareScore 메소드를 사용하여 수행한다.
 * 모든 자리수 더하기 기능에 대한 콘트롤은 plusCalc 메소드를 사용하여 수행한다.
 * 모든 자리수 곱하기 기능에 대한 콘트롤은 multCalc 메소드를 사용하여 수행한다.
 *
 * @version 1.00 03/21/23
 * @author 허준기
 */
package onboarding;

import java.util.List;

public class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int pobiScore = Integer.MIN_VALUE;              //안정성 측면에서 MIN_VALUE사용
        int crongScore = Integer.MIN_VALUE;
        if (pobi.get(0) < 1 || pobi.get(1) > 400 || crong.get(0) < 1 || crong.get(1) > 400) {
            return -1;
        }
        if (pobi.get(1) - pobi.get(0) != 1) {
            return -1;
        }
        if (crong.get(1) - crong.get(0) != 1) {
            return -1;
        }
        pobiScore = Math.max(plusCalc(pobi.get(1)), multCalc(pobi.get(0)));
        crongScore = Math.max(plusCalc(crong.get(0)), multCalc(crong.get(1)));
        return compareScore(pobiScore, crongScore);
    }

    public static int compareScore(int pobiScore, int crongScore) {    //포비랑 크롱의 점수 비교
        int answer = Integer.MAX_VALUE;
        if (pobiScore > crongScore) answer = 1;
        if (pobiScore == crongScore) answer = 0;
        if (pobiScore < crongScore) answer = 2;
        return answer;
    }

    public static int plusCalc(int page) {                  //모든 자리수 더하기
        int result = 0;
        while (page != 0) {
            result += page % 10;
            page = page / 10;
        }
        return result;
    }

    public static int multCalc(int page) {                  //모든 자리수 곱하기
        int result = 0;
        while (page != 0) {
            result *= page % 10;
            page = page / 10;
        }
        return result;
    }
}