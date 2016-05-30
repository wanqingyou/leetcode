public class Solution {
    public int[] singleNumber(int[] nums) {
        List<Integer> result=new ArrayList<Integer>();
        Arrays.sort(nums);
        int i=1;
        while(i<nums.length){
            if(nums[i]!=nums[i-1]){
                result.add(nums[i-1]);
                i++;
            }else{
                i+=2;
            }
        }
        if(i==nums.length){
            result.add(nums[nums.length-1]);
        }
        int[] returned=new int[result.size()];
        for(i=0;i<result.size();i++){
            returned[i]=result.get(i);
        }
        return returned;
    }
}