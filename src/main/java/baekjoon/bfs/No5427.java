package baekjoon.bfs;

import baekjoon.template.BaekjoonTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No5427 extends BaekjoonTemplate {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int quizCount = Integer.parseInt(br.readLine());
		for (int i = 0; i < quizCount; i++) {
			String[] split = br.readLine().split(" ");
			int x = Integer.parseInt(split[1]);
			int y = Integer.parseInt(split[0]);
			String[][] map = new String[x][y];
			int[][] fireMap = new int[x][y];
			int[][] sangMap = new int[x][y];

			for (int j = 0; j < x; j++) {
				String[] input = br.readLine().split(" ");
				for (int k = 0; k < y; k++) {
					map[k][j] = input[k];
					fireMap[k][j] = -1;
					sangMap[k][j] = -1;

				}
			}

			System.out.println("========");
			for (int j = 0; j < x; j++) {
				for (int k = 0; k < y; k++) {
					System.out.print(map[j][k]);
				}
				System.out.println();
			}
			System.out.println("--------");
			for (int j = 0; j < x; j++) {
				for (int k = 0; k < y; k++) {
					System.out.print(fireMap[j][k]);
				}
				System.out.println();
			}
			System.out.println("--------");
			for (int j = 0; j < x; j++) {
				for (int k = 0; k < y; k++) {
					System.out.print(sangMap[j][k]);
				}
				System.out.println();
			}
			System.out.println("========");
			System.out.println();
			System.out.println();
		}
	}

	@Override
	public void solution() throws IOException {

	}
}
