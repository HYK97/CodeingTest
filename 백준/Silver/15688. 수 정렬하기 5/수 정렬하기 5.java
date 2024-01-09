import java.io.*;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
	    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final StringBuilder st = new StringBuilder();
		int count = Integer.parseInt(br.readLine());
		int[] array = new int[count];
		for (int i = 0; i < count; i++) {
			array[i]=Integer.parseInt(br.readLine());
		}
		Arrays.sort(array);
		for (int i : array) {
			st.append(i).append("\n");
		}
		System.out.println(st);
	}
}
