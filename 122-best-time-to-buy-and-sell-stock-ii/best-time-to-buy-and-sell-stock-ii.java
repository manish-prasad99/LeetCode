class Solution {
    public int maxProfit(int[] prices) {
        
        int result=0;
        
        for(int i=0; i<prices.length-1;i++){
           int k=prices[i+1]-prices[i];
            if(k>0){
                result = result +k;
            }
        }
        return result; 
    }
}