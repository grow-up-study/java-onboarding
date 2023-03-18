package onboarding;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

import static java.lang.Integer.MIN_VALUE;

public class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong)  {
        int pobiScore = Integer.MIN_VALUE;              //안정성 측면에서 MIN_VALUE사용
        int crongScore = Integer.MIN_VALUE;
        if (pobi.get(0) < 1 || pobi.get(1) > 400 || crong.get(0) < 1 || crong.get(1) > 400) {
            return -1;
        }
        if(pobi.get(1) - pobi.get(0) != 1){
            return -1;
        }
        if(crong.get(1) - crong.get(0) != 1){
            return -1;
        }
        pobiScore = Math.max(plusCalc(pobi.get(1)),multCalc(pobi.get(0)));
        crongScore = Math.max(plusCalc(crong.get(0)),multCalc(crong.get(1)));
        int answer = compare(pobiScore, crongScore) ;
        return answer;
    }
    public static int compare(int pobiScore, int crongScore){    //포비랑 크롱의 점수 비교
        int answer = Integer.MAX_VALUE;
        if (pobiScore > crongScore) answer = 1;
        if (pobiScore == crongScore) answer = 0;
        if (pobiScore < crongScore) answer = 2;
        return answer;
    }
    public static int plusCalc(int page){                  //모든 자리수 더하기
        int result = 0;
        while(page != 0) {
            result += page % 10;
            page = page / 10;
        }
        return result;
    }
    public static int multCalc(int page){                  //모든 자리수 곱하기
        int result = 0;
        while(page != 0){
            result *= page % 10;
            page = page / 10;
        }
        return result;
    }
}