public class Solution {
    public int strStr(String haystack, String needle) {
        // return haystack.indexOf(needle);
        int len=haystack.length();
        int subLen=needle.length();
        if(len<subLen) return -1;
        if(haystack.equals(needle)) return 0;
        if(needle.equals("")) return 0;
        int count=0;
        
        for(int i=0;i<len-subLen+1;i++){
            for(int j=0;j<subLen;j++){
                if(needle.charAt(j)!=haystack.charAt(i+j)){
                    count=0;
                    break;
                }else{
                    count++;
                    if(count==subLen){
                        return i;
                    }
                }
            }
        }
        return -1;
    }
}