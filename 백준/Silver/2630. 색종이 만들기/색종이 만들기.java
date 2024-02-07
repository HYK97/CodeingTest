import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static Result result = new Result();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		for (int i = 0; i < N; i++) {
			map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}
		recursion(map, 0, 0, N);
		System.out.println(result.white);
		System.out.println(result.blue);

	}

	private static void recursion(int[][] map, int x, int y, int N) {
		if (check(map, x, y, N)) {
			cal(map[x][y]);
			return;
		}

		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				recursion(map, i * N / 2 + x, j * N / 2 + y, N / 2);
			}
		}




	}

	private static void cal(int data) {
		if (data == 0) {
			result.white++;
			return;
		}
		if (data == 1) {
			result.blue++;
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
		int blue;
		int white;


		public Result() {
			this.blue = 0;
			this.white = 0;
		}
	}

}
