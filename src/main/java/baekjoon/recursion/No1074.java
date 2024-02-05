package baekjoon.recursion;

import baekjoon.template.BaekjoonTemplate;

import java.io.IOException;

/*
* 아이디어 큰 네모를 하나의 작은 네모에서 실행 시키자!
* 분면을 나눠서 규칙을 찾아야 함
* 작은 네모에서 큰네모의 좌표를 찾을수 있으면 성공
* */
public class No1074 extends BaekjoonTemplate {
	public static void main(String[] args) throws IOException {
		String[] split1 = br.readLine().split(" ");
		int N = Integer.parseInt(split1[0]);
		int R = Integer.parseInt(split1[1]);
		int C = Integer.parseInt(split1[2]);
		System.out.println(recursion(N, R, C));
	}

	public static int recursion(int n, int r, int c) {
		if (n == 0) {
			return 0;
		}

		int half = 1 << (n - 1);
		if (r < half && c < half) {
			return recursion(n - 1, r, c);
		}
		if (r < half && half <= c) {
			return half * half + recursion(n - 1, r, c - half);
		}
		if (half <= r && c < half) {
			return 2 * half * half + recursion(n - 1, r - half, c);
		}

		return 3 * half * half + recursion(n - 1, r - half, c - half);


	}

	@Override
	public void solution() throws IOException {

	}
}
