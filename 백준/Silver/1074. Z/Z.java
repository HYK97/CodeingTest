import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
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
		if (r < half) {
			return half * half + recursion(n - 1, r, c - half);
		}
		if (c < half) {
			return 2 * half * half + recursion(n - 1, r - half, c);
		}

		return 3 * half * half + recursion(n - 1, r - half, c - half);


	}

}
