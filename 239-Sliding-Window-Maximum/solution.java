public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums==null||nums.length==0) return new int[]{};
        List<Integer> result=new ArrayList<Integer>();
        Dequeue queue=new Dequeue(k,nums);
        result.add(queue.getMax());
        for(int i=0;i<nums.length-k;i++){
            queue.move(nums[i+k]);
            result.add(queue.getMax());
        }
        int[] ret=new int[result.size()];
        for(int i=0;i<result.size();i++){
            ret[i]=result.get(i);
        }
        return ret;
    }
    
    
    class Dequeue{
        
        private int winSize;
        private int maxInWin;
        private LinkedList<Integer> list;
        
        public Dequeue(int winSize,int[]nums){
            this.winSize=winSize;
            list= new LinkedList<Integer>();
            int max=nums[0];
            for(int i=0;i<winSize;i++){
                list.add(nums[i]);
                if(max<nums[i]) max=nums[i];
            }
            this.maxInWin=max;
        }
        
        public int getMax(){
            return this.maxInWin;
        }
        
        public void move(int newElement){
            int first=list.poll();
            list.add(newElement);
            if(first<maxInWin&&newElement<maxInWin) return;
            if(newElement>maxInWin){
                maxInWin=newElement;
                return;
            }
            int max=list.get(0);
            for(int i=1;i<winSize;i++){
                if(max<list.get(i)) max=list.get(i);
            }
            
            maxInWin=max;
        }
    }
}