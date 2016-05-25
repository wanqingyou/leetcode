public class NumArray {
    private int[]nums;

    public NumArray(int[] nums) {
        this.nums=nums;
    }

    void update(int i, int val) {
        if(i<0||i>nums.length){
            throw new IllegalArgumentException();
        }
        nums[i]=val;
    }

    public int sumRange(int i, int j) {
        if(i<0||j>nums.length||i>j){
            throw new IllegalArgumentException();
        }
        int sum=0;
        for(int start=i;start<=j;start++){
            sum+=nums[start];
        }
        return sum;
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.update(1, 10);
// numArray.sumRange(1, 2);