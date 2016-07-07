public class Solution {
    public int search(int[] nums, int target) {
        return searchRotatedSortedArray(nums, 0, nums.length-1, target);
        }
        
        int searchRotatedSortedArray(int A[], int start, int end, int target) {
            if(start>end) return -1;
            int mid = start + (end-start)/2;
            if(A[mid]==target) return mid;
            
            if(A[mid]<A[end]) { // right half sorted
                if(target>A[mid] && target<=A[end])
                    return searchRotatedSortedArray(A, mid+1, end, target);
                else
                    return searchRotatedSortedArray(A, start, mid-1, target);
            }
            else {  // left half sorted
                if(target>=A[start] && target<A[mid]) 
                    return searchRotatedSortedArray(A, start, mid-1, target);
                else
                    return searchRotatedSortedArray(A, mid+1, end, target);
            }
    }
    //     if(nums==null||nums.length==0) return -1;
    //     return binSearch(nums,0,nums.length-1,target);
    // }
    
    // private int binSearch(int[] nums, int start, int end, int target){
    //     if(start>end) return -1;
    //     int mid=(start+end)/2;
    //     if(target==nums[mid]) return mid;
    //     else if(target<nums[mid]){
    //         if(nums[mid]>nums[end]){
    //             return binSearch(nums,mid+1,end,target);
    //         }else if (nums[mid]<nums[end]){
    //             return binSearch(nums,start, mid-1,target);
    //         }else{
    //             return end;
    //         }
    //     }else{
    //         if(nums[start]<nums[mid]){
    //             return binSearch(nums,start, mid-1,target);
    //         }else if(nums[start]>nums[mid]){
    //             return binSearch(nums,mid+1,end,target);
    //         }else{
    //             return start;
    //         }
    //     }
    // }
}