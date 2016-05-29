public class Solution {
    public int numSquares(int n) {
        int dp[]=new int[n+1];
        dp[0]=0;
        List<Integer> squares=new ArrayList<Integer>();
        for(int i=1;i<=n;i++){
            dp[i]=Integer.MAX_VALUE;
            if(i*i<=Integer.MAX_VALUE){
                squares.add(i*i);
            }
        }
        
        dp[1]=1;
        for(int i=2;i<=n;i++){
            if(squares.contains(i)){
                dp[i]=1;
                continue;
            }
            for(int j=1;j<i;j++){
                if(dp[i]>dp[j]+dp[i-j]){
                    dp[i]=dp[j]+dp[i-j];
                }
            }
        }
        
        return dp[n];
    }
}