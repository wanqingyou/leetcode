public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        
        int leftGas=0, sum =0, startnode=0;
        for(int i=0;i<gas.length;i++){
            leftGas+=gas[i]-cost[i];
            sum+=gas[i]-cost[i];
            
            if(sum<0){
                startnode=i+1;
                sum=0;
            }
        }
        if(leftGas<0){
            return -1;
        }else
            return startnode;
    }
}