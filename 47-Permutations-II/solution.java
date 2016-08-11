public class Solution {
    // public List<List<Integer>> permuteUnique(int[] nums) {
    //     List<List<Integer>> result = new ArrayList<List<Integer>>();
    //     if (nums == null || nums.length == 0) return result;

    //     List<Integer> list = new ArrayList<Integer>();
    //     dfs(0,nums, list, result);

    //     return result;
    // }

    // private void dfs(int start, int[] nums, List<Integer> list, List<List<Integer>> result) {
    //     if (list.size() == nums.length) {
    //         result.add(new ArrayList<Integer>(list));
    //         return;
    //     }

    //     for (int i = 0; i < nums.length; i++) {
    //         if (i==start) continue;
    //         list.add(nums[i]);
    //         dfs(i,nums, list, result);
    //         list.remove(list.size() - 1);
    //     }
    // }
    public List<List<Integer>> permuteUnique(int[] num) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(num == null || num.length == 0)
            return result;
        ArrayList<Integer> list = new ArrayList<Integer>();
        int[] visited = new int[num.length];
        
        Arrays.sort(num);
        helper(result, list, visited, num);
        return result;
    }
    
    public void helper(List<List<Integer>> result, ArrayList<Integer> list, int[] visited, int[] num) {
        if(list.size() == num.length) {
            result.add(new ArrayList<Integer>(list));
            return;
        }
        
        for(int i = 0; i < num.length; i++) {
            if (visited[i] == 1 || (i != 0 && num[i] == num[i - 1] && visited[i - 1] == 0)){
                continue;
        /*
            上面的判断主要是为了去除重复元素影响。
            比如，给出一个排好序的数组，[1,2,2]，那么第一个2和第二2如果在结果中互换位置，
            我们也认为是同一种方案，所以我们强制要求相同的数字，原来排在前面的，在结果
            当中也应该排在前面，这样就保证了唯一性。所以当前面的2还没有使用的时候，就
            不应该让后面的2使用。
        */
            }
            visited[i] = 1;
            list.add(num[i]);
            helper(result, list, visited, num);
            list.remove(list.size() - 1);
            visited[i] = 0;
        }
    }    
}