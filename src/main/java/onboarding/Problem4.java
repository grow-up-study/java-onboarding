/**
 * 이 클래스는 문장 암호화를 위한 클래스다.
 * 암호화 기능에 대한 콘트롤은 encryption 메소드를 사용하여 수행한다.
 *
 * @version 1.00 03/21/23
 * @author 허준기
 */
package onboarding;

public class Problem4 {
    public static String solution(String word) {
        StringBuilder encrypt = new StringBuilder(word);
        encryption(encrypt);
        String answer = encrypt.toString();
        return answer;
    }

    public static StringBuilder encryption(StringBuilder encrypt) {
        for (int k = 0; k < encrypt.length(); k++) {
            if (encrypt.charAt(k) >= 65 && encrypt.charAt(k) <= 90) {
                int x = 155 - encrypt.charAt(k);
                encrypt.setCharAt(k, (char) x);
            }
            if (encrypt.charAt(k) >= 97 && encrypt.charAt(k) <= 122) {
                int y = 219 - encrypt.charAt(k);
                encrypt.setCharAt(k, (char) y);
            }
        }
        return encrypt;
    }
}
