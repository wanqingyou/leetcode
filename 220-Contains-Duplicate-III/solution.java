public class Solution {
    // public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
    //     if(nums==null||nums.length==0) return false;
    //     int abst =Math.abs(t);
    //     int absk=Math.abs(k);
    //     for(int i=0;i<nums.length;i++){
    //         for(int j=i+1;j<=i+absk&&j<nums.length;j++){
    //             int d=Math.abs(nums[i]-nums[j]);
    //             if(d<=abst) 
    //                 return true;
    //         }
            
    //         for(int j=i-1;j>=0&&j>=i-absk;j--){
    //             int d=Math.abs(nums[i]-nums[j]);
    //             if(d<=abst) {
    //                 return true;
    //             }
    //         }
        
    //     }
    //     return false;
    // }
    
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
 
        if(nums==null || nums.length<=1 || k<=0 || t<0)
            return false;
 
        TreeSet<Integer> window = new TreeSet<Integer>();
 
        for(int i = 0; i<nums.length; i++){
 
            Integer floor = window.floor(nums[i]);
            Integer ceiling = window.ceiling(nums[i]);
            if(floor != null && new Long(nums[i])- new Long(floor)<= new Long(t))
                return true;
            if(ceiling != null && new Long(ceiling)- new Long(nums[i])<= new Long(t))
                return true;
            if(window.size()==k)
                window.remove(nums[i-k]);
            window.add(nums[i]);
        }
        return false;
    }
    

}