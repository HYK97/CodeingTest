package baekjoon.recursion;

import baekjoon.template.BaekjoonTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No1780 extends BaekjoonTemplate {
	static Result result = new Result();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		for (int i = 0; i < N; i++) {
			map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}
		recursion(map, 0, 0, N);
		System.out.println(result.minusOne);
		System.out.println(result.zero);
		System.out.println(result.one);

	}

	private static void recursion(int[][] map, int x, int y, int N) {
		if (check(map, x, y, N)) {
			cal(map[x][y]);
			return;
		}

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				recursion(map, i * N / 3 + x, j * N / 3 + y, N / 3);
			}
		}

		// 0,0 3,0 6,0
		// 0,6 3,3 6,3
		// 0,3 3,6 6,6



	}

	private static void cal(int data) {
		if (data == 0) {
			result.zero++;
			return;
		}
		if (data == 1) {
			result.one++;
			return;
		}
		if (data == -1) {
			result.minusOne++;
		}
	}


	public static boolean check(int[][] map, int x, int y, int N) {
		int checkValue = map[x][y];
		for (int i = x; i < x + N; i++) {
			for (int j = y; j < y + N; j++) {
				int data = map[i][j];
				if (checkValue != data) {
					return false;
				}
			}
		}
		return true;
	}


	static class Result {
		int zero;
		int one;
		int minusOne;

		public Result() {
			this.zero = 0;
			this.one = 0;
			this.minusOne = 0;
		}
	}

	@Override
	public void solution() throws IOException {

	}
}
