class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        if(temperatures == null){
            return new int[]{0};
        }
        int[] res = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        for(int i = temperatures.length - 1; i >= 0; i--){
            while(!stack.isEmpty() && temperatures[i] >= temperatures[stack.peek()]){
                stack.pop();
            }
            if(!stack.isEmpty()){
                res[i] = stack.peek() - i;
            }
            stack.push(i);
        }
        return res;
    }
}
