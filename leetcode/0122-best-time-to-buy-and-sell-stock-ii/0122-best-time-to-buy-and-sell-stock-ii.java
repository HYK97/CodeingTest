class Solution {
    //오늘 가격이 다음날 보다 싼경우는 오늘 사서 다음날 파는 식으로 접근
    public int maxProfit(int[] prices) {
        int prevIndex = 0;
        int sum = 0;
        for(int i = 0 ; i < prices.length ; i++){
            if(i == 0){
                continue;
            }
            int currentPrice = prices[i];
            int prevPrice = prices[prevIndex];
            if(currentPrice > prevPrice){
                sum += currentPrice - prevPrice;
                prevIndex++;
            } else {
                prevIndex = i;
            }
        }
        return sum;
    }
}