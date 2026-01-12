class Solution {
    // o(n)으로 풀기 위해서는 한 번의 배열을 지나면서 값을 저장해야함
    // 일단 지나오면서의 가장 작은 값을 저장, 그리고 그 값의 차도 함께 저장해서
    // 한칸씩 움직일때 마다 위의 두 값을 이용해서 계산한뒤에 업데이트 하는식으로 하면될것같음
    public int maxProfit(int[] prices) {
        int maxValue = 0;
        int maxPrioroty = prices[0];
        for(int i = 0 ; i < prices.length ; i++){
            int currentValue = prices[i];
            int diff =  currentValue - maxPrioroty;
            if (diff > maxValue) {
                maxValue = diff; 
            }
            if (currentValue < maxPrioroty){
                maxPrioroty = currentValue;
            }
        }
        return maxValue;
    }
}