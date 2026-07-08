//실패한 역 다음
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int gasSum = Arrays.stream(gas).sum();
        int costSum = Arrays.stream(cost).sum();
        if (gasSum < costSum){
            return -1;
        }
        int tank = 0;
        int startIndex = 0;
        for (int i = 0 ; i < gas.length ; i++){
            tank += gas[i];
            if(tank - cost[i] < 0){
                tank = 0;
                startIndex = i + 1;
                continue;
            }
            tank -= cost[i];
        }
        return startIndex;
    }
}