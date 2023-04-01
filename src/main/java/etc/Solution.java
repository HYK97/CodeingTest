package etc;

class ConveyorBelt {
    int start;
    int end;
    int length;

    public ConveyorBelt(int start, int end, int length) {
        this.start = start;
        this.end = end;
        this.length = length;
    }
}

class Factory {
    private int n, m, k;
    private ConveyorBelt[] belts;
    private boolean[] used;
    private int[][] dist;
    private int maxMinLength = -1;

    public Factory(int n, int m, int k, int[] u, int[] v, int[] l) {
        this.n = n;
        this.m = m;
        this.k = k;
        this.used = new boolean[m];
        this.dist = new int[n + 1][n + 1];

        belts = new ConveyorBelt[m];
        for (int i = 0; i < m; i++) {
            belts[i] = new ConveyorBelt(u[i], v[i], l[i]);
            dist[u[i]][v[i]] = dist[v[i]][u[i]] = l[i];
        }
    }

    public int findMaxMinLength() {
        backtracking(1, 0, 0, Integer.MAX_VALUE);
        return maxMinLength;
    }

    private void backtracking(int node, int depth, int sum, int minLen) {
        if (isReturningToStart(node, depth)) {
            updateMaxMinLength(node, sum, minLen);
            return;
        }

        if (isInvalid(depth, sum)) {
            return;
        }

        for (int i = 0; i < m; i++) {
            if (!used[i] && dist[node][belts[i].end] > 0) {
                used[i] = true;
                backtracking(belts[i].end, depth + 1, sum + dist[node][belts[i].end],
                    Math.min(minLen, dist[node][belts[i].end]));
                used[i] = false;
            }
        }
    }

    private boolean isReturningToStart(int node, int depth) {
        return depth == n - 1 && dist[node][1] > 0;
    }

    private void updateMaxMinLength(int node, int sum, int minLen) {
        int totalLen = sum + dist[node][1];
        if (totalLen <= k) {
            maxMinLength = Math.max(maxMinLength, Math.min(minLen, dist[node][1]));
        }
    }

    private boolean isInvalid(int depth, int sum) {
        return depth >= n || sum > k;
    }
}

public class Solution {
    public static void main(String[] args) {

        Solution solution11 = new Solution();
        Solution solution22 = new Solution();
        Solution solution33 = new Solution();
        Solution solution44 = new Solution();
        int solution1 = solution11.solution(4, 6, 9, new int[] {1, 2, 3, 1, 1, 2}, new int[] {2, 3, 4, 4, 3, 4},
            new int[] {3, 3, 3, 3, 1, 2});
        int solution2 = solution22.solution(4, 6, 12, new int[] {1, 2, 3, 1, 1, 2}, new int[] {2, 3, 4, 4, 3, 4},
            new int[] {3, 3, 3, 3, 1, 2});
        int solution3 = solution33.solution(3, 3, 1, new int[] {1, 1, 2}, new int[] {2, 3, 3}, new int[] {2, 2, 2});
        int solution4 = solution44.solution(5, 5, 10, new int[] {2, 2, 2, 3, 3}, new int[] {3, 4, 5, 4, 5},
            new int[] {1, 1, 1, 1, 1});
        System.out.println("solution1 = " + solution1);
        System.out.println("solution1 = " + solution2);
        System.out.println("solution1 = " + solution3);
        System.out.println("solution1 = " + solution4);
    }

    public int solution(int n, int m, int k, int[] u, int[] v, int[] l) {
        Factory factory = new Factory(n, m, k, u, v, l);
        return factory.findMaxMinLength();
    }
}

