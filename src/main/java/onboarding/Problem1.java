package onboarding;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) throws IOException {
        int answer = Integer.MAX_VALUE;
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        bufferedWriter.write("안녕하세요");
        bufferedWriter.flush();
        bufferedWriter.close();
        return answer;
    }
}