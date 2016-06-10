public class Solution {
    public int findMin(int[] nums) {
        // int min=nums[0];
        // for(int i=1;i<nums.length;i++){
        //     if(nums[i]<min){
        //         min=nums[i];
        //     }
        // }
        // return min;
        int start = 0, end = nums.length-1;
        while(start<end) {
            int mid = start+(end-start)/2;
            if(nums[mid]<nums[end]) 
                end = mid;
            else 
                start = mid+1;
        }
        return nums[start];
    }
}