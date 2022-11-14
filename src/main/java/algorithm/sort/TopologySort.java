package algorithm.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * packageName :  algorithm.sort
 * fileName : TopologySort
 * author :  ddh96
 * date : 2022-11-14
 * description : 위상 정렬 알고리즘
 * 큐를 이용하자 진입차수가 0 인것들을 큐에 넣자
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2022-11-14                ddh96             최초 생성
 */
public class TopologySort {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //정답 리스트
        List<Integer> result = new ArrayList<>();
        String[] s = br.readLine().split(" ");
        int v = Integer.parseInt(s[0]);
        int e = Integer.parseInt(s[1]);
        int[] input = new int[v + 1];// 진입차수
        List<List<Integer>> node = new ArrayList<>();
        for (int i = 0; i < e; i++) {
            node.add(new ArrayList<>());
        }
        for (int i = 0; i < e; i++) {
            String[] s1 = br.readLine().split(" ");
            int a = Integer.parseInt(s1[0]);
            int b = Integer.parseInt(s1[1]);
            node.get(a).add(b);
            input[b]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        addQueue(input, queue);
        while (!queue.isEmpty()) {

            Integer poll = queue.poll(); // 큐에서 앞에있는 노드 하나 빼기
            result.add(poll); // 결과에 추가

            List<Integer> integers = node.get(poll);// 현재노드에서 연결되있는 노드들의 진입차수들을 -1 해줌
            for (Integer integer : integers) {
                input[integer]--;
            }
            // 진입차수가 0인 노드들을 큐에 넣어줌
            addQueue(input, queue);
        }

        System.out.println("result = " + result);
    }

    private static void addQueue(int[] input, Queue<Integer> queue) {
        for (int i = 1; i < input.length; i++) {
            if (input[i] == 0) {
                queue.add(i);
                input[i] = -1; //제거된 노드 표시 (중복제거)
            }
        }
    }
}
