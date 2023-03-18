package onboarding;
import java.lang.StringBuilder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = compareNickname(forms);
        return answer;
    }

    public static List<String> compareNickname(List<List<String>> forms) {
        HashMap<String, Integer> formMap = new HashMap<String, Integer>();  // 닉네임을 키, 인덱스를 밸류로 저장하는 hashmap
        List<Integer> indexList = new ArrayList<Integer>();                 // 중복되는 인덱스를 저장할 리스트
        HashSet<String> answerList = new HashSet<String>();                 // 중복되는 이메일을 저장할 HashSet
        for (int i = 0; i < forms.size(); i++) {                            // 주어진 이중 리스트의 크기만큼 반복
            String nickname = forms.get(i).get(1);                          // 검사할 닉네임 가져오기
            for (int j = 0; j < nickname.length() - 1; j++) {               // 닉네임의 길이만큼 반복
                String twoChars = nickname.substring(j, j + 2);             // 두개씩 쪼개서 twoChars에 저장
                if (formMap.containsKey(twoChars)) {                        // 해시맵에 키가 있으면
                    indexList.add(formMap.get(twoChars));                   // 중복된 폼의 인덱스를 indexList에 추가
                    indexList.add(i);                                       // 현재 인덱스 indexList에 추가
                    formMap.put(twoChars, i);                               // 중복된 폼의 인덱스를 현재 폼의 인덱스로 변경
                } else {                                                    // 해시맵에 키가 없으면
                    formMap.put(twoChars, i);                               // 해시맵에 twoChars 추가
                }
            }
        }

        for (int l = 0; l < indexList.size(); l++) {
            answerList.add(forms.get(indexList.get(l)).get(0));             // 중복된 폼의 인덱스에 해당하는 이름을 answerList에 추가
        }
        List<String> answer = new ArrayList<>(answerList);
        return answer;
    }
}