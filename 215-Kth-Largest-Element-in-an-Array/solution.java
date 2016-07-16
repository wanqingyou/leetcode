public class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(nums==null||nums.length==0) return -1;
        int len=nums.length;
        int[] temp=new int[len];
         mergeSort(nums,0,len-1,temp);
         return nums[len-k];
    }
    
    private void merge(int[] nums, int left, int mid, int right, int[] temp){
        int i=left;
        int j=mid+1;
        int m=mid;int n=right;
        int k=0;
        while(i<=m&&j<=n){
            if(nums[i]<=nums[j]){
                temp[k++]=nums[i++];
            }else{
                temp[k++]=nums[j++];
            }
        }
        while(i<=m){
            temp[k++]=nums[i++];
        }
        while(j<=n){
            temp[k++]=nums[j++];
        }
        for (i = 0; i < k; i++)  
            nums[left + i] = temp[i]; 
    }
    
    private void mergeSort(int[] nums, int left, int right, int []temp){
        if(left<right){
            int mid=(left+right)/2;
            mergeSort(nums, left, mid,temp);
            mergeSort(nums,mid+1,right,temp);
            merge(nums,left, mid, right,temp);
        }
    }
}