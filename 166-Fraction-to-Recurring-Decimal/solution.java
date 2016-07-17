public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if(numerator==0) return "0";
        String result="";
        if(numerator<0 ^ denominator<0) result+="-";
        long n =numerator, d=denominator;
        n=Math.abs(n);
        d=Math.abs(d);
        long divi= n/d;
        result=result+divi;
        long r=n%d;
        if(r==0) return result;
        else result+=".";
        
        Map<Long,Integer> map=new HashMap<Long,Integer>();
        while(r!=0){
            if(map.containsKey(r)){
                result=result.substring(0,map.get(r))+"("+result.substring(map.get(r));
                result+=")";
                break;
            }
            map.put(r,result.length());
            r*=10;
            divi=r/d;
            result=result+divi;
            r=r%d;
        }
        return result;
    }
}