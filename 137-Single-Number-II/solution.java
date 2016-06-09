public class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer,Integer> map=new HashMap<Integer,Integer>();
        for(int i =0;i<nums.length;i++){
            if(map.get(nums[i])!=null){
                map.put(nums[i],map.get(nums[i])+1);
            }else{
                map.put(nums[i],1);
            }
        }
        int result=0;
        for(Integer key:map.keySet()){
            if(map.get(key)==1){
                result=key;
                break;
            }
        }
        return result;
    }
}