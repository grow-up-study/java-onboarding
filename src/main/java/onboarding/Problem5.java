package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer =change(money);
        return answer;
    }
    public static List<Integer> change(int money){
        List<Integer> devide = new ArrayList<Integer>();
        int k = 0;
        if (money / 10000 >= 5){
            devide.add(money/50000);
            money -= 50000 * (money/50000);
        }
        else devide.add(0);
        if (money / 10000 < 5){
            devide.add(money/10000);
            money -= 10000 * (money/10000);
        }
        else devide.add(0);
        if (money / 1000 >= 5){
            devide.add(money/5000);
            money -= 5000 * (money/5000);
        }
        else devide.add(0);
        if (money / 1000 < 5){
            devide.add(money/1000);
            money -= 1000 * (money/1000);
        }
        else devide.add(0);
        if (money / 100 >= 5){
            devide.add(money/500);
            money -= 500 * (money/500);
        }
        else devide.add(0);
        if (money / 100 < 5){
            devide.add(money/100);
            money -= 100 * (money/100);
        }
        else devide.add(0);
        if (money / 10 >= 5){
            devide.add(money/50);
            money -= 50 * (money/50);
        }
        else devide.add(0);
        if (money / 10 < 5){
            devide.add(money/10);
            money -= 10 * (money/10);
        }
        devide.add(money);
        return devide;
    }
}
