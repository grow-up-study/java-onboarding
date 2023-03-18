package onboarding;

public class Problem3 {
    public static int solution(int number) {
        return clapNum(number);
    }
    public static int clapNum(int number){
        int clap = 0;                                           // 박수 횟수 0으로 초기화
        for (int j = 1; j <= number; j++){                      // j가 1부터 주어진 number가 될때까지 반복
            if (j % 3 == 0){                                    // j가 3으로 나눠지면
                clap += 1;                                      // 박수 횟수 + 1
            }
            if((j/10 == 3) || (j/10 == 6)||(j/10 == 9)){        // j의 십의자리가 3,6,9중 하나면
                clap += 1;                                      // 박수 횟수 + 1
                if ((j/10 == 3)&&(j%10 == 0)||(j/10 == 6)&&(j%10 == 0)||(j/10 == 9)&&(j%10 == 0)){
                                                                // 30,60,90,... 과 같은 숫자들은 3으로도 나눠지고 십의자리가 1이라서 중복되므로
                    clap -= 1;                                  // 박수 횟수 -1
                }
            }
        }
        return clap;
    }
}
