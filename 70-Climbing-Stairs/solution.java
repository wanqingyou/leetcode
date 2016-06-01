public class Solution {
    private int count=0;
    public int climbStairs(int n) {
        if(n==0) return 0;
        climbs(n);
        return count;
        
    }
    private void climbs(int n){
        
        if(n==0){
            count++;
        }
        if(n>=1){
            climbs(n-1);
        }
        if(n>=2){
            climbs(n-2);
        }
    }
}