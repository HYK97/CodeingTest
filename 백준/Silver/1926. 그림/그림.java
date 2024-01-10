import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

public class Main {
	public static void main(String[] args) throws IOException {
		final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] split = br.readLine().split(" ");
		int n = Integer.parseInt(split[0]);
		int m = Integer.parseInt(split[1]);
		int[][] board = new int[502][502];
		boolean[][] check = new boolean[502][502];
		int[] dx = {1, 0, -1, 0};
		int[] dy = {0, 1, 0, -1};

		int imageCount = 0;
		int maxImageSize = 0;

		for (int i = 0; i < n; i++) {
			int[] s = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			Arrays.fill(check[i], false);
			board[i] = s;
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (board[i][j] == 0 || check[i][j]) {
					continue;
				}
				imageCount++;
				LinkedList<Pair> queue = new LinkedList<>();
				check[i][j] = true;
				queue.add(new Pair(i, j));
				int imageSize = 0;
				while (!queue.isEmpty()) {
					imageSize++;
					Pair current = queue.pollFirst();
					for (int k = 0; k < 4; k++) {
						int newX = current.x + dx[k];
						int newY = current.y + dy[k];
						if (newX < 0 || newX >= n || newY < 0 || newY >= m) {
							continue;
						}
						if (check[newX][newY] || board[newX][newY] != 1) {
							continue;
						}
						check[newX][newY] = true;
						queue.add(new Pair(newX, newY));
					}
				}
				maxImageSize = Math.max(maxImageSize, imageSize);
			}
		}
		System.out.println(imageCount);
		System.out.println(maxImageSize);

	}

	static class Pair {
		int x;
		int y;

		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
