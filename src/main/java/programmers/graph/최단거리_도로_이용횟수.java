package programmers.graph;

import java.util.Arrays;

class 최단거리_도로_이용횟수 {
    public static void main(String[] args) {

        int[] solution = new 최단거리_도로_이용횟수().solution(4, 4, new int[] {1, 1, 2, 4}, new int[] {3, 2, 3, 1},
            new int[] {1, 5, 2, 4});
        System.out.println("Arrays.s(s) = " + Arrays.toString(solution));
    }

    public int[] solution(int a, int b, int[] c, int[] d, int[] e) {
        // 도로 정보로 그래프 초기화
        int[][] graph = new int[a + 1][a + 1];
        for (int i = 1; i <= a; i++) {
            Arrays.fill(graph[i], 100_001);
            graph[i][i] = 0;
        }

        for (int i = 0; i < b; i++) {
            graph[c[i]][d[i]] = e[i];
            graph[d[i]][c[i]] = e[i];
        }

        // Floyd-Warshall 알고리즘을 적용하여 최단 경로 찾기
        for (int k = 1; k <= a; k++) {
            for (int i = 1; i <= a; i++) {
                for (int j = 1; j <= a; j++) {
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }

        // 도로별 교통량 계산
        int[] trafficVolume = new int[b];
        for (int i = 0; i < b; i++) {
            for (int j = 1; j <= a; j++) {
                for (int k = 1; k <= a; k++) {
                    if (graph[j][k] == graph[j][c[i]] + e[i] + graph[d[i]][k]) {
                        trafficVolume[i]++;
                    }
                }
            }
        }
        for (int i : trafficVolume) {
            System.out.println("i = " + i);
        }
        // 도로 번호 배열을 생성하고 교통량 및 도로 번호별로 정렬
        Integer[] roadNumbers = new Integer[b];
        for (int i = 0; i < b; i++) {
            roadNumbers[i] = i + 1;
        }
        Arrays.sort(roadNumbers, (i1, i2) -> trafficVolume[i1 - 1] != trafficVolume[i2 - 1]
            ? Integer.compare(trafficVolume[i2 - 1], trafficVolume[i1 - 1]) : Integer.compare(i1, i2));

        // Integer 배열을 int 배열로 변환하고 반환
        int[] answer = new int[b];
        for (int i = 0; i < b; i++) {
            answer[i] = roadNumbers[i];
        }
        return answer;
    }
}