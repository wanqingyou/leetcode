public class Solution {
    public int maxProduct(int[] nums) {
        if(nums==null||nums.length==0) return 0;
        int len=nums.length;
        int max_product[]=new int[len];
        int min_product[]=new int[len];
        max_product[0]=nums[0];
        min_product[0]=nums[0];
        for(int i=1;i<len;i++){
            max_product[i]=Math.max(Math.max(max_product[i-1]*nums[i],min_product[i-1]*nums[i]),nums[i]);
            min_product[i]=Math.min(Math.min(max_product[i-1]*nums[i],min_product[i-1]*nums[i]),nums[i]);
        }
        
        int max=max_product[0];
        for(int i=1;i<len;i++){
            if(max_product[i]>max){
                max=max_product[i];
            }
        }
        
        return max;
    }
}