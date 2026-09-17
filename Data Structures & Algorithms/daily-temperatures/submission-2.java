class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[temperatures.length];
        for(int i = temperatures.length - 1; i >= 0; i--){
            int temp = temperatures[i];
            while(!stack.isEmpty() && temp >= temperatures[stack.peek()]){
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
