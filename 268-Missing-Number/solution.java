public class Solution {
    public int missingNumber(int[] nums) {
        if(nums.length==1){
            if(nums[0]==0) return 1;
            if(nums[0]==1) return 0;
        }
        int i=0;
        Arrays.sort(nums);
        for(;i<nums.length;i++){
            if(nums[i]!=i){
                break;
            }
        }
        if(i==nums.length-1){
            if(nums[i]==nums.length) return i;
            else
                i=nums.length;
        }
        return i;
    }
}