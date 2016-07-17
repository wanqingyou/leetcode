public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if(prerequisites==null) return new int[] {};
        
        int len=prerequisites.length;
        int[] seq=new int[numCourses];
        if(len==0){
            for(int i=0;i<numCourses;i++){
                seq[i]=i;
            }
            return seq;
        }
        
        int[] pres=new int[numCourses];
        for(int i=0;i<len;i++){
            pres[prerequisites[i][0]]++;
        }
        
        LinkedList<Integer> queue=new LinkedList<Integer>();
        for(int i=0;i<numCourses;i++){
            if(pres[i]==0){
                queue.add(i);
            }
        }
        int c=0;
        int numNoPre = queue.size();
        while(!queue.isEmpty()){
            int top=queue.pollFirst();
            seq[c++]=top;
            for (int i = 0; i < len; i++) {
                if(prerequisites[i][1]==top){
                    pres[prerequisites[i][0]]--;
                    if(pres[prerequisites[i][0]]==0){
                        queue.add(prerequisites[i][0]);
                        numNoPre++;
                    }
                }
            }
        }
        
       if (numNoPre != numCourses) {
            return new int[] {};
        }
        return seq;
    }
}