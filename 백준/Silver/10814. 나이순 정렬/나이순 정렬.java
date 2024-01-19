import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) throws IOException {
		final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

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
