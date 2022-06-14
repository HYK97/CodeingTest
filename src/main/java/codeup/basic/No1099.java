package codeup.basic;

import java.io.*;

public class No1099 {
    public static void main(String[] args) throws IOException {
        int[][] maze = new int[10][10];
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = 1;
        int y = 1;
        int nowvalue = 0;
        boolean flag = true;
        for (int i = 0; i < 10; i++) {
            String[] split = br.readLine().split(" ");
            for (int j = 0; j < 10; j++) {
                maze[i][j] = Integer.parseInt(split[j]);
            }
        }

        /*while (true) {
            if (x == 8 && y == 8) {
                break;
            } else if (maze[y][x + 1] == 1 && maze[y + 1][x] == 1) {
                break;
            } else if (maze[y][x] == 2 && (x == 1 && y == 1)) {
                maze[y][x] = 9;
                break;
            }
            while (true) {
                maze[y][x] = 9; //현재자리
                if (maze[y][x + 1] == 2) {
                    x++;
                    break;
                }
                if (maze[y][x + 1] != 1) {

                    x++;
                } else {
                    break;
                }
            }
            if (maze[y][x] == 2) {
                maze[y][x] = 9;
                break;
            }
            while (true) {
                maze[y][x] = 9;
                if (maze[y][x + 1] == 0) {

                    break;
                }
                if (maze[y + 1][x] == 2) {

                    y++;
                    break;
                }
                if (maze[y + 1][x] != 1) {

                    y++;
                } else {
                    break;
                }
            }
            if (maze[y][x] == 2) {
                maze[y][x] = 9;
                break;
            }

        }*/


        while (true) {
            if (maze[x][y] == 0) {
                maze[x][y] = 9;
                y++;
            }
            if (maze[x][y] == 1) {
                y--;
                x++;
            }
            if (maze[x][y] == 2) {
                maze[x][y] = 9;
                break;
            } else if (maze[x][y + 1] == 1 && maze[x + 1][y] == 1) {
                if (maze[x][y] == 0) {
                    maze[x][y] = 9;
                }
                break;
            }


        }


        for (int[] ints : maze) {
            for (int anInt : ints) {
                bw.write(anInt + " ");
            }
            bw.write("\n");
        }
        bw.flush();

    }
}

