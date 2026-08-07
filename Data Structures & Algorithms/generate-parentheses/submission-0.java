class Solution {
    public List<String> generateParenthesis(int n) {

        Stack<Character> stack = new Stack<>();
        List<String> res = new ArrayList<>();
        backTrack(n, 0, 0, stack, res);
        return res;
        
    }

    public void backTrack(int n, int open, int closed, 
        Stack<Character> stack, List<String> res){
            StringBuilder sb = new StringBuilder();
            if(open == closed && open == n){
                for(Character s : stack){
                    sb.append(s);
                }
                res.add(sb.toString());
            }
            if(open < n){
                stack.push('(');
                backTrack(n, open + 1, closed, stack, res);
                stack.pop();
            }
            if(closed < open){
                stack.push(')');
                backTrack(n, open, closed + 1, stack, res);
                stack.pop();
            }
        }
}
