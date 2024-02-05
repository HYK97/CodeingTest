package baekjoon.recursion;

import baekjoon.template.BaekjoonTemplate;

import java.io.BufferedWriter;
import java.io.IOException;

public class No11729 extends BaekjoonTemplate {
	@Override
	public void solution() throws IOException {

	}

	public static void main(String[] args) throws IOException {
		int numberOfDiscs = Integer.parseInt(br.readLine());
		System.out.println((int)Math.pow(2,numberOfDiscs)-1);
		recursion(numberOfDiscs,1,3,bw);
		bw.flush();
		bw.close();
	}

	public static void recursion(int count, int start, int end, BufferedWriter bw) throws IOException {
		if (count == 1) {
			bw.write(start + " " + end+"\n");
			return;
		}
		recursion(count-1,start,6-start-end, bw);
		bw.write(start + " " + end+"\n");
		recursion(count-1,6-start-end,end, bw);

	}
}
