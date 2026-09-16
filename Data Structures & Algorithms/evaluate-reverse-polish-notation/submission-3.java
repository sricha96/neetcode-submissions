class Solution {
    public int evalRPN(String[] tokens) {
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        for(String c : tokens){
            if(!stack.isEmpty() && c.equals("+")){
                int a = stack.pop();
                int b = stack.pop();
                int x = b + a;
                stack.push(x);
            }else if(!stack.isEmpty() && c.equals("-")){
                int a = stack.pop();
                int b = stack.pop();
                int x = b - a;
                stack.push(x);
            }else if(!stack.isEmpty() && c.equals("*")){
                int a = stack.pop();
                int b = stack.pop();
                int x = b * a;
                stack.push(x);
            }else if(!stack.isEmpty() && c.equals("/")){
                int a = stack.pop();
                int b = stack.pop();
                int x = b / a;
                stack.push(x);
            }else{
                stack.push(Integer.valueOf(c));
            }
        }
        return stack.peek();
    }
}
