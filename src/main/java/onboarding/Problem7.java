package onboarding;

import java.util.*;


public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = result(user, friends, visitors);
        return answer;
    }
    public static List<String> result (String user, List<List<String>> friends, List<String> visitors) {
            Map<String, Set<String>> friendMap = new HashMap<>();                       // 사용자의 친구 리스트를 저장
            for (List<String> friendPair : friends) {                                   // friend를 하나씩 넣어줌
                String user1 = friendPair.get(0);
                String user2 = friendPair.get(1);                                       // 사용자 친구리스트에 친구추가
                friendMap.computeIfAbsent(user1, k -> new HashSet<>()).add(user2);      // 만약 user1이 있으면 HashSet에 추가
                friendMap.computeIfAbsent(user2, k -> new HashSet<>()).add(user1);      // 만약 user2가 있으면 HashSet에 추가
            }

            Map<String, Integer> scoreMap = new HashMap<>();                             // 사용자가 아는 모든 사용자와 친구가 아닌 사용자 추천점수계산
            for (String friend : friendMap.get(user)) {
                for (String candidate : friendMap.get(friend)) {                         // 친구의 친구 리스트에 사용자가 존재하지 않고, 사용자와 친구가 아닌경우 추천점수계산
                    if (!friendMap.get(user).contains(candidate) && !candidate.equals(user)) {
                        scoreMap.put(candidate, scoreMap.getOrDefault(candidate, 0) + 10);
                    }
                }
            }
            for (String visitor : visitors) {                                            // 사용자 타임라인을 방문한 기록이 있으면 추천점수추가
                if (!friendMap.get(user).contains(visitor) && !visitor.equals(user)) {
                    scoreMap.put(visitor, scoreMap.getOrDefault(visitor, 0) + 1);
                }
            }

            List<Map.Entry<String, Integer>> scoreList = new ArrayList<>(scoreMap.entrySet()); // 추천 점수가 높은 순으로 정렬
            Collections.sort(scoreList, (o1, o2) -> {
                int scoreDiff = o2.getValue() - o1.getValue();
                if (scoreDiff != 0) {
                    return scoreDiff;
                } else {
                    return o1.getKey().compareTo(o2.getKey());
                }
            });

            List<String> recommendation = new ArrayList<>();                        // 최대 5명까지 추천
            for (Map.Entry<String, Integer> entry : scoreList) {
                if (recommendation.size() >= 5 || entry.getValue() == 0) {
                    break;
                }
                recommendation.add(entry.getKey());
            }
            return recommendation;
        }
    }

