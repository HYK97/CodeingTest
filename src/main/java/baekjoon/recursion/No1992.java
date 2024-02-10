package baekjoon.recursion;

import baekjoon.template.BaekjoonTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class No1992 extends BaekjoonTemplate {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[][] map = new int[n][n];
		for (int i = 0; i < n; i++) {
			map[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
		}
		recursion(map, 0, 0, n);

	}

	private static void recursion(int[][] map, int x, int y, int n) {
		if (check(map, x, y, n)) { // 분할 해야 하는경우

			System.out.print(map[x][y]);
			return;
		}
		if (n == 2) {
			System.out.print("(");
			for (int i = x; i < x + n; i++) {
				for (int j = y; j < y + n; j++) {
					System.out.print(map[i][j]);
				}
			}
			System.out.print(")");
			return;
		}
		System.out.print("(");
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				recursion(map, x + i * n / 2, y + j * n / 2, n / 2);
			}
		}
		System.out.print(")");
	}

	private static boolean check(int[][] map, int x, int y, int n) {
		int data = map[x][y];
		for (int i = x; i < x + n; i++) {
			for (int j = y; j < y + n; j++) {
				if (data != map[i][j]) {
					return false;
				}
			}
		}
		return true;
	}


	@Override
	public void solution() throws IOException {

	}
}
