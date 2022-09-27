package quiz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 게임개발 {

    /**
     * while true :
     * if left != false
     * go left
     * else
     * if fron !=false
     * go
     * else
     * turn left
     * if all == true or front see
     * if goback != see
     * goback
     * else
     * break;
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] s = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        int[][] map = new int[s[0]][s[1]];
        int[][] check = new int[s[0]][s[1]];
        int[] pdata = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        User user = new User(pdata[0], pdata[1], pdata[2]);
        for (int i = 0; i < map.length; i++) {
            String[] tempData = br.readLine().split(" ");
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = Integer.parseInt(tempData[j]);
            }
        }
        int count = 0;
        while (true) {
            //first
            user.turn();
            //second
            if (user.goCheck(map, check)) {
                user.go();
                count++;
                check[user.y][user.x] = 1;
                continue;
            } else {
                user.turnTime++;
            }

            if (!user.check(map)) {
                user.back();
                if (map[user.y][user.x] == 1) {
                    break;
                }
            }
        }
        System.out.println("count = " + count);

    }


    static class User {
        int direction;
        int x;
        int y;
        int turnTime = 0;
        String[] dir = new String[]{"-1 0", "0 1", "1 0", "0 -1"};

        public User(int x, int y, int direction) {
            this.direction = direction;
            this.x = x;
            this.y = y;
        }

        public void go() {
            String[] s = dir[this.direction].split(" ");
            this.x = x + Integer.parseInt(s[1]);
            this.y = y + Integer.parseInt(s[0]);
            turnTime = 0;
        }

        public boolean goCheck(int[][] map, int[][] check) {
            String[] s = dir[this.direction].split(" ");
            int tempX = x + Integer.parseInt(s[1]);
            int tempY = y + Integer.parseInt(s[0]);
            return map[tempY][tempX] == 0 && check[tempY][tempX] == 0;
        }


        public void back() {
            if (this.direction == 0) {
                y++;
            } else if (this.direction == 1) {
                x--;
            } else if (this.direction == 2) {
                y--;
            } else {
                x++;
            }
            turnTime = 0;
        }

        public boolean check(int[][] map) {
            if (turnTime == 4) {
                return false;
            }
            return map[y][x] != 1;
        }


        public void turn() {
            if (this.direction == 0) {
                this.direction = 3;
            } else {
                this.direction--;
            }
        }


        @Override
        public String toString() {
            return y + " " + x;
        }
    }
}
