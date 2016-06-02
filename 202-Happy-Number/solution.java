public class Solution {
    public boolean isHappy(int n) {
        int result =0;
        while(result!=1){
            while(n>0){
                int a =n%10;
                result+=a*a;
                n=n/10;
            }
        }
        if(result==1)return true;
        return false;
    }
}