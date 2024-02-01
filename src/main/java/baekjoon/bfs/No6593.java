package baekjoon.bfs;

import baekjoon.template.BaekjoonTemplate;

import java.io.IOException;
import java.util.Arrays;

public class No6593 extends BaekjoonTemplate {

	public static void main(String[] args) throws IOException {
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
			Node end = null;
			for (int i = 0; i < L; i++) {
				for (int j = 0; j < X; j++) {
					String[] input = br.readLine().split("");
					for (int k = 0; k < Y; k++) {
						String s = input[k];
						if (s.equals("S")) {
							start = new Node(i, j, k);
						} else if (s.equals("E")) {
							end = new Node(i, j, k);
						}
						map[i][j][k] = s;
						check[i][j][k] = -1;
					}
				}
				br.readLine();
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
