import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int A = Integer.parseInt(input[0]);
		int B = Integer.parseInt(input[1]);
		int C = Integer.parseInt(input[2]);
		System.out.println((Long) recursion(A, B, C));
	}

	public static long recursion(int A, int B, int C) {
		if (B == 1) {
			return A % C;
		}
		long recursion = recursion(A, B / 2, C);

		long temp = recursion * recursion % C;

		if (B % 2 == 0) {
			return temp;
		}
		return temp * A % C;
	}


}
