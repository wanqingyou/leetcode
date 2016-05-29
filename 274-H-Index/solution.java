public class Solution {
    public int hIndex(int[] citations) {
        if(citations.length==0) return 0;
        if(citations.length==1&&citations[0]==0) return 0;
        if(citations.length==1&&citations[0]!=0) return 1;
        Arrays.sort(citations);
        
        int len=citations.length;
        int map[]=new int[len];
        for(int i=0;i<len;i++){
            if(citations[i]==0){
                map[i]=0;
                continue;
            }else{
                map[i]=len-i;
            }
        }
        
        int h=0;
        for(int i=0;i<len;i++){
         if(citations[i]>=map[i]){
             if(h<map[i]){
                 h=map[i];
             }
         }
        }
        return h;
    }
}