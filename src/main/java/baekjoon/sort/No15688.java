package baekjoon.sort;

import baekjoon.template.BaekjoonTemplate;

import java.io.IOException;
import java.util.Arrays;
/*
* Arrays sort 사용
* Collection sort 사용시 시간초과
* */
public class No15688 extends BaekjoonTemplate {
	public static void main(String[] args) throws IOException {
		new No15688().solution();
	}

	@Override
	public void solution() throws IOException {
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
