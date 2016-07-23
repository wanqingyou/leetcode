public class Solution {
    public String largestNumber(int[] nums) {
        if(nums==null||nums.length==0) return null;
        int len=nums.length;
        
        Integer ints[]=new Integer[len];
        for(int i=0;i<len;i++){
            ints[i]=nums[i];
        }
        
        Arrays.sort(ints, new Comparator<Integer>(){
            public int compare(Integer n1, Integer n2){
                String str1=String.valueOf(n1);
                String str2=String.valueOf(n2);
                return (str2+str1).compareTo(str1+str2);
            }
            
        });
        
        if(ints[0]==0) return "0";
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<len;i++){
            sb.append(ints[i]);
        }
        return sb.toString();
    }
    
    private void quickSort(char[] chars, int start, int end){
        if(start >= end){
            return;
        }
        int mid=(start+end)/2;
        int pivot=chars[mid]-'0';
        int i=start;
        int j=end;
        while(i<=j){
            while(chars[i]-'0'<pivot){
                i++;
            }
            while(chars[j]-'0'>pivot){
                j--;
            }
            
            if(i<=j){
                if(chars[i]!=chars[j]){
                    //swap
                    char temp=chars[i];
                    chars[i]=chars[j];
                    chars[j]=temp;
                }
                i++;j--;
            }
        }
        quickSort(chars,start,i-1);
        quickSort(chars,i+1,end);
    }
}