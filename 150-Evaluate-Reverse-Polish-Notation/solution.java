public class Solution {
    public int evalRPN(String[] tokens) {
        if(tokens==null||tokens.length==2) return 0;
        if(tokens.length==1) return Integer.parseInt(tokens[0]);
        Stack<String> stack=new Stack<String>();
        stack.push(tokens[0]);
        stack.push(tokens[1]);
        int index=2;
        int result=0;
         String strs[] = new String[]{"+", "-", "*", "/"};
        List<String> operators=Arrays.asList(strs);
        while(!stack.isEmpty()&&index<tokens.length){
            if(operators.contains(tokens[index])){
                int a =Integer.parseInt(stack.pop());
                int b =Integer.parseInt(stack.pop());
                if(tokens[index].equals("+")){
                    result=b+a;
                    stack.push(result+"");
                }else if(tokens[index].equals("-")){
                    result=b-a;
                    stack.push(result+"");
                }else if(tokens[index].equals("*")){
                    result=b*a;
                    stack.push(result+"");
                }else if(tokens[index].equals("/")){
                    result=b/a;
                    stack.push(result+"");
                }
                index++;
            }else{
                stack.push(tokens[index++]);
            }
        }
        return Integer.parseInt(stack.pop());
    }
}