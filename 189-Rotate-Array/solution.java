public class Solution {
    public void rotate(int[] nums, int k) {
        if(k==0) return;
        int len=nums.length;
        int distance=0;
        int idx=0;
        int cur =nums[0];
        for(int i=0;i<len;i++){
            idx=(idx+k)%len;
            int temp=nums[idx];
            nums[idx]=cur;
            cur=temp;
            distance=(distance+k)%len;
            if(distance==0){
                idx=(idx+1)%len;
                cur=nums[idx];
            }
        }
    }
}