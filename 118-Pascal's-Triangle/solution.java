public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>>result=new ArrayList<List<Integer>>();
        if(numRows<=0){
            return result;
        }
        List<Integer> row1=new ArrayList<Integer>();
        row1.add(1);
        List<Integer> row2=new ArrayList<Integer>();
        row2.add(1);
        row2.add(1);
        result.add(row1);
        if(numRows==1) return result;
        result.add(row2);
        for(int i=2;i<numRows;i++){
            List<Integer> rowI=new ArrayList<Integer>();
            for(int j=0;j<=i;j++){
                if(j==0||j==i){
                    rowI.add(1);
                }else{
                    rowI.add(result.get(i-1).get(j-1)+result.get(i-1).get(j));
                }
            }
            result.add(rowI);
        }
        return result;
    }
    
}