package quiz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 상하좌우 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] split = br.readLine().split(" ");
        Vector vector = new Vector(N);
        for (String s : split) {
            switch (s) {
                case "R":
                    vector.right();
                    break;
                case "L":
                    vector.left();
                    break;
                case "U":
                    vector.up();
                    break;
                case "D":
                    vector.down();
                    break;
            }
        }
        System.out.println("vector = " + vector);

    }


    static class Vector {
        int x;
        int y;

        int lastPath;

        public Vector(int lastPath) {
            this.x = 1;
            this.y = 1;
            this.lastPath = lastPath;
        }

        public void right() {
            if (x != lastPath) {
                this.x++;
            }
        }

        public void left() {
            if (x != 1) {
                this.x--;
            }
        }

        public void up() {
            if (y != 1) {
                this.y--;
            }
        }

        public void down() {
            if (y != lastPath) {
                this.y++;
            }
        }


        @Override
        public String toString() {
            return y + " " + x;
        }
    }
}
