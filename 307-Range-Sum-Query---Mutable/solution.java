public class NumArray {
    private SegNode root;

    public NumArray(int[] nums) {
        if(nums==null||nums.length==0){
            return;
        }
        root=build(nums,0,nums.length-1);
    }
    
    private SegNode build(int[] nums,int start, int end){
        SegNode cur = new SegNode(start,end);
        if(start==end){
            cur.sum=nums[start];
            return cur;
        }
        
        int mid=(start+end)/2;
        
        cur.left=build(nums,start, mid);
        cur.right=build(nums,mid+1,end);
        cur.sum=cur.left.sum+cur.right.sum;
        return cur;
    }

    void update(int i, int val) {
        updateHelper(root, i, val);
    }
    
    private void updateHelper(SegNode root, int i,int val){
        if(root.start==root.end&&root.start==i){
            root.sum=val;
            return;
        }
        int mid =(root.start+root.end)/2;
        if(i<=mid){
            updateHelper(root.left,i,val);
        }else{
            updateHelper(root.right, i, val);
        }
        root.sum=root.left.sum+root.right.sum;
    }

    public int sumRange(int i, int j) {
        return sumRange(root, i, j);
    }
    
    private int sumRange(SegNode root, int i, int j){
        int mid=(root.start+root.end)/2;
        if(i==root.start&&root.end==j){
            return root.sum;
        }else if(j<=mid){
            return sumRange(root.left, i, j);
        }else if(mid<i){
            return sumRange(root.right, i, j);
        }else{
            return sumRange(root.left, i, mid)+sumRange(root.right, mid+1,j);
        }
    }
    
    // Segment Tree Node class contains start index, end index, sum of the range, left node and right node
    class SegNode {
        public int start;
        public int end;
        public int sum;
        public SegNode left;
        public SegNode right;
        public SegNode(int s, int e) {
            this.start = s;
            this.end = e;
            left = null;
            right = null;
            sum = 0;
        }
    }

}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.update(1, 10);
// numArray.sumRange(1, 2);