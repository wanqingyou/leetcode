public class Solution {
    // public int lengthOfLIS(int[] nums) {
    //     if(nums==null||nums.length==0) return 0;
    //     if(nums.length==1) return 1;
    //     int len=0;
    //     int maxLen=0;
    //     for(int i=0;i<nums.length-1;i++){
    //         int temp=nums[i];
    //         len=1;
    //         for(int j=i+1;j<nums.length;j++){
    //             if(temp<nums[j]){
    //                 len++;
    //                 temp=nums[j];
    //             }
    //         }
    //         if(len>maxLen){
    //             maxLen=len;
    //         }
    //     }
    //     return maxLen;
    // }
    
    public int lengthOfLIS(int[] nums) {
        if(nums==null||nums.length==0) return 0;
        if(nums.length==1) return 1;
        int len=0;
        int maxLen=0;
        Map<Integer, List<Integer>> map=new HashMap<Integer, List<Integer>>();
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]<nums[j]){
                    if(map.get(i)!=null){
                        map.get(i).add(j);
                    }else{
                        List<Integer> temp=new ArrayList<Integer>();
                        temp.add(j);
                        map.put(i,temp);
                    }
                }
            }
        }
        if(map.size()==0){
            return 1;
        }
        
        int count=0;
        for(Map.Entry<Integer,List<Integer>> entry:map.entrySet()){
            len=2;
            for(int value:entry.getValue()){
                int temp=value;
                for(int j=value+1;j<nums.length;j++){
                    if(nums[temp]<nums[j]){
                        len++;
                        temp=j;
                    }
                }
                if(len>maxLen){
                    maxLen=len;
                }
            }
        }
        return maxLen;
    }
    
}