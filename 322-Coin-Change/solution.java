public class Solution {
    public int coinChange(int[] coins, int amount) {
       if(amount==0){
            return 0;
        }
        int[] dp=new int[amount+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0]=0;
        for(int i=1;i<=amount;i++){
            for(int j=0;j<coins.length;j++){
                if(i-coins[j]<0||(i-coins[j]>0&&dp[i-coins[j]]==Integer.MAX_VALUE)){
                    continue;
                }
                dp[i]=Math.min(dp[i], dp[i-coins[j]]+1);
            }
        }
        return dp[amount]==Integer.MAX_VALUE?-1:dp[amount];
    }
        
}