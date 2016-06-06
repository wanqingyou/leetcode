public class Solution {
    public int findPeakElement(int[] nums) {
        if(nums==null||nums.length==0||nums.length==1) return 0;
        int result=-1;
        for(int i=0;i<nums.length;i++){
            if(i==0){
                if(nums[i]>nums[i+1]) {
                    result=i;
                    break;
                }
            }else if(i==nums.length-1){
                if(nums[i]>nums[i-1]) {
                    result=i;
                    break;
                }
            }else{
                if(nums[i]>nums[i-1]&&nums[i]>nums[i+1]){
                    result=i;
                    break;
                }
            }
            
        }
        return result;
    }
}