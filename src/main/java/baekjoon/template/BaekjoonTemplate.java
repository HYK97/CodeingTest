package baekjoon.template;

import java.io.*;

public abstract class BaekjoonTemplate {
	public final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public abstract void solution() throws IOException;

}
