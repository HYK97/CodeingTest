package baekjoon.sort;

import baekjoon.template.BaekjoonTemplate;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class No10814 extends BaekjoonTemplate {

	public static void main(String[] args) throws IOException {
		new No10814().solution();
	}

	@Override
	public void solution() throws IOException {
		int count = Integer.parseInt(br.readLine());
		Map<Integer, List<String>> map = new HashMap<>();
		for (int i = 0; i < count; i++) {
			String[] data = br.readLine().split(" ");
			Integer key = Integer.valueOf(data[0]);
			String value = data[1];
			if (map.containsKey(key)) {
				List<String> strings = map.get(key);
				strings.add(value);
			} else {
				map.put(key, new ArrayList<>(List.of(value)));
			}
		}
		Set<Integer> integers = map.keySet();
		List<Integer> sortList = integers.stream().sorted().collect(Collectors.toList());
		for (Integer i : sortList) {
			List<String> values = map.get(i);
			for (String value : values) {
				bw.write(i + " " + value);
				bw.newLine();
			}
		}
		bw.close();
	}
}
