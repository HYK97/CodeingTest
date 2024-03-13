package programmers.greedy;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class 요격시스템 {

	public static void main(String[] args) {
		int solution = new 요격시스템().solution(new int[][]{{4, 5}, {4, 8}, {10, 14}, {11, 13}, {5, 12}, {3, 7}, {1, 4}});
		System.out.println("solution = " + solution);
	}

	public int solution(int[][] targets) {
		int answer = 0;
		List<Pair> rocket = Arrays.stream(targets)
				.map(i -> new Pair(i[0], i[1]))
				.sorted()
				.collect(Collectors.toList());

		double shoot = -0.5;
		for (Pair pair : rocket) {
			if (shoot < pair.start) {
				answer += 1;
				shoot = pair.end - 0.5;
			}
		}


		return answer;
	}

	static class Pair implements Comparable<Pair> {
		private int start;
		private int end;

		public Pair(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Pair o) {
			return this.end - o.end;
		}
	}
}
