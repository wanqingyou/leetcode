public class Solution {
    public int findMin(int[] num) {
        // int min=nums[0];
        // for(int i=1;i<nums.length;i++){
        //     if(nums[i]<min){
        //         min=nums[i];
        //     }
        // }
        // return min;
        if(num == null || num.length==0)  
            return 0;  
        int l = 0;  
        int r = num.length-1;  
        int min = num[0];  
        while(l<r-1)  
        {  
            int m = (l+r)/2;  
            if(num[l]<num[m])  
            {  
                min = Math.min(num[l],min);  
                l = m+1;  
            }  
            else if(num[l]>num[m])  
            {  
                min = Math.min(num[m],min);  
                r = m-1;  
            }  
            else  
            {  
                l++;  
            }  
        }  
        min = Math.min(num[r],min);  
        min = Math.min(num[l],min);  
        return min;
    }
}