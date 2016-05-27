public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        // if the length less than 2, return them avoid duplicate
        if (nums.length <= 2) {
            for (int i = 0; i < nums.length; i++) {
                if (!res.contains(nums[i]))
                    res.add(nums[i]);
            }
            return res;
        }
        int count = 1;
        Arrays.sort(nums);
        // count the number appearance times
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                count++;
            } else {
                count = 1;
            }
            // if appear more than three times, add it to the result and set the
            // count to 1;
            if (count > nums.length / 3 && !res.contains(nums[i]))
                res.add(nums[i]);
    
        }
        return res;
    }
}