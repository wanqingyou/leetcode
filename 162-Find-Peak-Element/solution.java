public class Solution {
    public int findPeakElement(int[] nums) {
        // if(nums==null||nums.length==0||nums.length==1) return 0;
        // int result=-1;
        // for(int i=0;i<nums.length;i++){
        //     if(i==0){
        //         if(nums[i]>nums[i+1]) {
        //             result=i;
        //             break;
        //         }
        //     }else if(i==nums.length-1){
        //         if(nums[i]>nums[i-1]) {
        //             result=i;
        //             break;
        //         }
        //     }else{
        //         if(nums[i]>nums[i-1]&&nums[i]>nums[i+1]){
        //             result=i;
        //             break;
        //         }
        //     }
            
        // }
        // return result;
        
        //O(N)
        for(int i=1;i<nums.length;i++){  
            if(nums[i]<nums[i-1])  
                return i-1;  
        }  
        return nums.length-1; 
        
        //o(logn)
        // int left=0,right=nums.length-1;  
        // while(left<=right){  
        //     if(left==right)  
        //         return left;  
        //     int mid=(left+right)/2;  
        //     if(nums[mid]<nums[mid+1])  
        //         left=mid+1;  
        //     else  
        //         right=mid;  
        // }  
    }
}