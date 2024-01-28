package baekjoon.bfs;

import baekjoon.template.BaekjoonTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class No5014 extends BaekjoonTemplate {
	//F층건물 G층으로 가고싶음 현재층은 S층  u=> 위로 몇층 D는 아래로몇층
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] split1 = br.readLine().split(" ");
		int F = Integer.parseInt(split1[0]);
		int S = Integer.parseInt(split1[1]) - 1;
		int G = Integer.parseInt(split1[2]) - 1;
		int U = Integer.parseInt(split1[3]);
		int D = Integer.parseInt(split1[4]);
		int[] map = new int[F];
		boolean[] check = new boolean[F];
		Queue<Integer> queue = new LinkedList<>();
		int[] dx = {U, -D};
		queue.add(S);
		map[S] = 0;
		check[S] = true;
		while (!queue.isEmpty()) {
			int current = queue.poll();
			if (current == G) {
				System.out.println(map[G]);
				return;
			}
			for (int i = 0; i < 2; i++) {

				int newX = current + dx[i];
				if (newX < 0 || newX >= F) {
					continue;
				}
				if (check[newX]) {
					continue;
				}
				queue.add(newX);
				map[newX] = map[current] + 1;
				check[newX] = true;
			}
		}
		System.out.println("use the stairs");

	}

	@Override
	public void solution() throws IOException {

	}
}
