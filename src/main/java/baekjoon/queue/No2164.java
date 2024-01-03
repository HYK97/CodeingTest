package baekjoon.queue;

import baekjoon.template.BaekjoonTemplate;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;

public class No2164 extends BaekjoonTemplate {
	public static void main(String[] args) throws IOException {
		new No2164().solution();
	}

	@Override
	public void solution() throws IOException {
		int totalCardNum = Integer.parseInt(br.readLine());
		Deque<Integer> cards = new LinkedList<>();

		for (int i = 1; i <= totalCardNum; i++) {
			cards.add(i);
		}
		boolean isPop = false;
		while (cards.size() != 1) {
			if (!isPop) {
				cards.pollFirst(); //6
				isPop = true;
				continue;
			}
			cards.addLast(cards.pollFirst());
			isPop = false;
		}
		System.out.println(cards.pollFirst());
	}
}
