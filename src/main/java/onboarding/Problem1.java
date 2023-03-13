package onboarding;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

import static java.lang.Integer.MIN_VALUE;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong)  {
        int pobiScore = Integer.MIN_VALUE;              //안정성 측면에서 MIN_VALUE사용
        int crongScore = Integer.MIN_VALUE;
        int pobiPage = (int)Math.random()%200;
        int crongPage = (int)Math.random()%200;
        pobiScore = Math.max(plusCalc(pobiPage),multCalc(pobiPage));
        crongScore = Math.max(plusCalc(crongPage),multCalc(crongPage));
        int answer = comparison(pobiScore, crongScore) ;

        return answer;
    }
    public static int comparison(int pobiScore, int crongScore){    //포비랑 크롱의 점수 비교
        int answer = Integer.MAX_VALUE;
        if (pobiScore > crongScore) answer = 1;
        if (pobiScore == crongScore) answer = 0;
        if (pobiScore < crongScore) answer = 2;
        return answer;
    }
    public static int plusCalc(int page){                  //모든 자리수 더하기
        if (page > 0 && 10 > page){
            return page;
        }
        else if (page >= 10 && 100 > page) {
            int score = (page/10) + (page % 10);
            return score;
        }
        else if (page >= 100 && 400 >= page){
            int score = (page/100) + ((page/10)%10) + (page%10);
            return score;
        }
        else {
            return -1;
        }
    }
    public static int multCalc(int page){                  //모든 자리수 곱하기
        if (page > 0 && 10 > page){
            return page;
        }
        else if (page >= 10 && 100 > page) {
            int score = (page/10) * (page % 10);
            return score;
        }
        else if (page >= 100 && 400 >= page){
            int score = (page/100) * ((page/10)%10) * (page%10);
            return score;
        }
        else {
            return -1;
        }
    }
}