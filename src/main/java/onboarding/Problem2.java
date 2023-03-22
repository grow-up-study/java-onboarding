/**
 * 이 클래스는 중복 문자 삭제를 위한 클래스다.
 * 중복되는 문자 삭제 기능에 대한 콘트롤은 deleteDup 메소드를 사용하여 수행한다.
 *
 * @version 1.00 03/21/23
 * @author 허준기
 */
package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        int cryptogram_length = cryptogram.length();                                // 들어오는 문자열의 길이
        StringBuilder crypArray = new StringBuilder(cryptogram);        //StringBuilder는 문자열을 배열처럼 관리하며 추가, 삭제, 삽입을 용이하게 하기 위해 사용
        deleteDuplicate(crypArray, cryptogram_length - 1);
        String answer = crypArray.toString();                           // String으로 반환하기 위해 StringBuilder를 String으로 변환
        return answer;
    }

    public static StringBuilder deleteDuplicate(StringBuilder crypArray, int cryptogram_length) {       // 중복되는 문자 삭제하는 클래스
        int index = 0;                                                                  // 인덱스 0부터 시작
        while (index < cryptogram_length - 1) {                                                     // k는 길이-2의 인덱스까지만 검사
            if (crypArray.charAt(index) == crypArray.charAt(index + 1)) {                   // k와 그 다음 인덱스의 문자가 같다면
                crypArray = crypArray.delete(index, index + 2);                                // k와 그 다음 인덱스 문자 삭제
                index = -1;                                                             // k = -1로 초기화
                cryptogram_length = crypArray.length();                                         // 문자열 길이 다시 측정
            }
            index += 1;
        }                                                                           //정규표현식?? -> 문자열을 탐색하는 방법
        return crypArray;                                                           // 최종 문자열 StringBuilder로 반환
    }
}
