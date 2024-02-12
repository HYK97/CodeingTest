package baekjoon.backtraking;

import baekjoon.template.BaekjoonTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No15649 extends BaekjoonTemplate {
	static int n;
	static int m;
	static int arr[];
	static boolean check[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputs = br.readLine().split(" ");
		n = Integer.parseInt(inputs[0]);
		m = Integer.parseInt(inputs[1]);
		arr = new int[m];
		check = new boolean[10];
		backTracking(0);
	}

	public static void backTracking(int arrCount) {
		if (arrCount == m) {
			for (int i : arr) {
				System.out.print(i + " ");
			}
			System.out.println();
			return;
		}
		for (int i = 1; i <= n; i++) {
			if (!check[i]) {
				arr[arrCount] = i;
				check[i] = true;
				backTracking(arrCount + 1);
				check[i] = false;
			}
		}
	}

	@Override
	public void solution() throws IOException {

	}
}
