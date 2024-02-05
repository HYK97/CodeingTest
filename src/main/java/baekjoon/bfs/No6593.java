package baekjoon.bfs;

import baekjoon.template.BaekjoonTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class No6593 extends BaekjoonTemplate {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] dx = {1, 0, -1, 0, 0, 0};
		int[] dy = {0, 1, 0, -1, 0, 0};
		int[] dz = {0, 0, 0, 0, 1, -1};

		while (true) {
			String[] split1 = br.readLine().split(" ");

			if (Arrays.stream(split1).allMatch(i -> i.equals("0"))) {
				break;
			}

			int L = Integer.parseInt(split1[0]);
			int X = Integer.parseInt(split1[1]);
			int Y = Integer.parseInt(split1[2]);
			String[][][] map = new String[L][X][Y];
			int[][][] check = new int[L][X][Y];
			Node start = null;
			for (int i = 0; i < L; i++) {
				for (int j = 0; j < X; j++) {
					String[] input = br.readLine().split("");
					for (int k = 0; k < Y; k++) {
						String s = input[k];
						if (s.equals("S")) {
							start = new Node(i, j, k);
						}
						map[i][j][k] = s;
						check[i][j][k] = -1;
					}
				}
				br.readLine();
			}
			Queue<Node> queue = new LinkedList<>();
			queue.add(start);
			check[start.z][start.x][start.y] = 0;
			boolean flag = false;

			while (!queue.isEmpty()) {
				Node current = queue.poll();
				for (int i = 0; i < 6; i++) {
					int newZ = current.z + dz[i];
					int newX = current.x + dx[i];
					int newY = current.y + dy[i];
					if (map[current.z][current.x][current.y].equals("E")) {
						System.out.println("Escaped in " + check[current.z][current.x][current.y] + " minute(s).");
						flag = true;
						break;
					}
					if (newZ < 0 || newZ >= L || newX < 0 || newX >= X || newY < 0 || newY >= Y) {
						continue;
					}
					if (map[newZ][newX][newY].equals("#") || check[newZ][newX][newY] != -1) {
						continue;
					}
					queue.add(new Node(newZ, newX, newY));
					check[newZ][newX][newY] = check[current.z][current.x][current.y] + 1;

				}
			}
			if (!flag) {
				System.out.println("Trapped!");
			}

		}
	}

	@Override
	public void solution() throws IOException {

	}

	static class Node {
		int z;
		int x;
		int y;

		public Node(int z, int x, int y) {
			this.z = z;
			this.x = x;
			this.y = y;
		}

	}
}
