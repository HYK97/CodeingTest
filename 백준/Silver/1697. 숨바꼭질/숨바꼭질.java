import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.function.Function;

public class Main {

	public static void main(String[] args) throws IOException {
		final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] split = br.readLine().split(" ");
		int subin = Integer.parseInt(split[0]);
		int brother = Integer.parseInt(split[1]);
		Queue<Integer> queue = new LinkedList<>();
		int[] check = new int[100001];
		Function<Integer, Integer>[] operation = new Function[3];
		operation[0] = (Integer z) -> z + 1;
		operation[1] = (Integer z) -> z - 1;
		operation[2] = (Integer z) -> 2 * z;
		queue.add(subin);
		Arrays.fill(check, -1);
		check[subin] = 0;
		while (!queue.isEmpty()) {
			Integer poll = queue.poll();
			for (int i = 0; i < 3; i++) {
				int newX = operation[i].apply(poll);
				if (newX < 0 || newX >= 100001) {
					continue;
				}
				if (check[newX] != -1) {
					continue;
				}
				queue.add(newX);
				check[newX] = check[poll] + 1;
			}
		}
		System.out.println(check[brother]);
	}


}
