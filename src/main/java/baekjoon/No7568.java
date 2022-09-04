package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class No7568 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        List<User> users = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            String[] data = br.readLine().split(" ");
            users.add(new User(Integer.parseInt(data[0]), Integer.parseInt(data[1])));
        }
        int counts = 1;
        for (int i = 0; i < count; i++) {
            User user = users.get(i);
            for (int j = 0; j < count; j++) {
                User user1 = users.get(j);
                if (user.weight < user1.weight && user.tall < user1.tall) {
                    counts++;
                }
            }
            users.get(i).rank = counts;
            counts = 1;
        }
        for (User user : users) {
            System.out.print(user.rank + " ");
        }
    }

    static class User {
        private int weight;
        private int tall;
        private int rank;

        public User(int weight, int tall) {
            this.weight = weight;
            this.tall = tall;
            this.rank = 0;
        }

    }
}

