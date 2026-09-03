class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        Stack<Character> stack = new Stack<>();
        generate(n, res, 0, 0, stack);
        return res;
    }

    public void generate(int n, List<String> res, int open, int close, Stack<Character> stack){
        StringBuilder sb = new StringBuilder();
        if(open == close && open >= n){
            for(Character c : stack){
                sb.append(c);
            }
            res.add(sb.toString());
        }
        if(open < n){
            stack.push('(');
            generate(n, res, open + 1, close, stack);
            stack.pop();
        }
        if(close < open){
            stack.push(')');
            generate(n, res, open, close + 1, stack);
            stack.pop();
        }
    }
}
