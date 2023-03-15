package onboarding;
import java.lang.StringBuilder;
public class Problem4 {
    public static String solution(String word) {
        StringBuilder encrypt = new StringBuilder(word);
        encryption(encrypt);
        String answer = encrypt.toString();
        return answer;
    }
    public static StringBuilder encryption(StringBuilder encrypt){

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
