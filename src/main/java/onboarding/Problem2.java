package onboarding;
import java.lang.StringBuilder;

public class Problem2 {
    public static String solution(String cryptogram) {
        int c_len = cryptogram.length();                                // 들어오는 문자열의 길이
        StringBuilder crypArray = new StringBuilder(cryptogram);        //StringBuilder는 문자열을 배열처럼 관리하며 추가, 삭제, 삽입을 용이하게 하기 위해 사용
        deleteDup(crypArray,c_len-1);
        String answer = crypArray.toString();                           // String으로 반환하기 위해 StringBuilder를 String으로 변환
        return answer;
    }
    public static StringBuilder deleteDup(StringBuilder crypArray,int c_len){       // 중복되는 문자 삭제하는 클래스
        int k = 0;                                                                  // 인덱스 0부터 시작
        while (k < c_len - 1) {                                                     // k는 길이-2의 인덱스까지만 검사
            if (crypArray.charAt(k) == crypArray.charAt(k + 1)) {                   // k와 그 다음 인덱스의 문자가 같다면
                crypArray = crypArray.delete(k,k+2);                                // k와 그 다음 인덱스 문자 삭제
                k = -1;                                                             // k = -1로 초기화
                c_len = crypArray.length();                                         // 문자열 길이 다시 측정
            }
            k += 1;
        }                                                                           //정규표현식?? -> 문자열을 탐색하는 방법
        return crypArray;                                                           // 최종 문자열 StringBuilder로 반환
    }
}
