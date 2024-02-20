import java.io.*;

public class Main {
	static int count = 0;

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean[] up = new boolean[15];
		boolean[] diagonal1 = new boolean[29];
		boolean[] diagonal2 = new boolean[29];
		int input = Integer.parseInt(br.readLine());
		recursion(0, input, up, diagonal1, diagonal2);
		System.out.println(count);

	}

	private static void recursion(int i, int input, boolean[] up, boolean[] diagonal1, boolean[] diagonal2) {
		if (i == input) {
			count++;
			return;
		}
		for (int j = 0; j < input; j++) {
			if (up[j] || diagonal1[j + i] || diagonal2[j - i + input - 1]) {
				continue;
			}
			up[j] = true;
			diagonal1[j + i] = true;
			diagonal2[j - i + input - 1] = true;
			recursion(i + 1, input, up, diagonal1, diagonal2);
			up[j] = false;
			diagonal1[j + i] = false;
			diagonal2[j - i + input - 1] = false;
		}
	}

}
