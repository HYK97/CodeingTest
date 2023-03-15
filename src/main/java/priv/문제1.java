package priv;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

public class 문제1 {
    public static void main(String[] args) {
        List<Integer> test = List.of(
            solution(3,
                new String[] {"alex111 100", "cheries2 200", "coco 150", "luna 100", "alex111 120", "coco 300",
                    "cheries2 110"}),
            solution(3,
                new String[] {"alex111 100", "cheries2 200", "alex111 200", "cheries2 150", "coco 50", "coco 200"}),
            solution(2, new String[] {"cheries2 200", "alex111 100", "coco 150", "puyo 120"})
        );
        for (Integer integer : test) {
            System.out.println("test = " + integer);
        }
    }

    public static int solution(int K, String[] user_scores) {
        Stack<User> ranker = new Stack<>();
        List<User> tempRanker = new ArrayList<>();
        int answer = 0;
        for (String user_score : user_scores) {
            makeNewRanking(K, ranker, new User(user_score));
            if (!tempRanker.equals(ranker)) {
                answer++;
            }
            tempRanker = new ArrayList<>(ranker);
        }
        return answer;
    }

    private static void makeNewRanking(int K, Stack<User> ranking, User target) {
        if (ranking.contains(target)) {
            updateUserScore(ranking, target);
        } else if (ranking.size() < K) {
            addUser(ranking, target);
        } else if (isHigherScore(ranking, target)) {
            popUser(ranking);
            addUser(ranking, target);
        }
        sortRanking(ranking);
    }

    private static void updateUserScore(Stack<User> ranking, User target) {
        ranking.get(ranking.indexOf(target)).newScore(target);
    }

    private static void addUser(Stack<User> ranking, User target) {
        ranking.add(target);
    }

    private static boolean isHigherScore(Stack<User> ranking, User target) {
        return ranking.peek().getScore() < target.getScore();
    }

    private static void popUser(Stack<User> ranking) {
        ranking.pop();
    }

    private static void sortRanking(List<User> ranking) {
        ranking.sort((o1, o2) -> o2.getScore().compareTo(o1.getScore()));
    }

    static class User {
        private final String username;
        private Integer score;

        public User(String nameAndScore) {
            String[] split = nameAndScore.split(" ");
            this.username = split[0];
            this.score = Integer.valueOf(split[1]);
        }

        public String getUsername() {
            return username;
        }

        public Integer getScore() {
            return score;
        }

        public void setScore(Integer score) {
            this.score = score;
        }

        public void newScore(User newUser) {
            this.score = this.score > newUser.score ? this.score : newUser.score;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;
            User user = (User)o;
            return username.equals(user.username);
        }

        @Override
        public int hashCode() {
            return Objects.hash(username);
        }

    }
}