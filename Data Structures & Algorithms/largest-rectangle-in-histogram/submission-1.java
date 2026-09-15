class Solution {
    public int largestRectangleArea(int[] heights) {

        // Ab tak ka maximum rectangle area
        int maxArea = 0;

        // Stack mein bar ke INDEX store karenge
        // Stack mein heights increasing order mein rahengi
        Stack<Integer> stack = new Stack<>();

        int n = heights.length;

        /*
         * i <= n isliye:
         * Last iteration mein ek imaginary bar of height 0
         * maanenge, taaki stack mein bache hue bars bhi process ho jayein.
         */
        for(int i = 0; i <= n; i++){

            // Normal case: current bar ki height
            // Last iteration: imaginary height 0
            int currentHeight = (i == n) ? 0 : heights[i];

            /*
             * Agar current height stack ke top bar se chhoti hai,
             * to top bar ka rectangle yahin end ho raha hai.
             *
             * Isliye us bar ko pop karke uska maximum area calculate karenge.
             */
            while(!stack.isEmpty() && currentHeight < heights[stack.peek()]){

                // Top bar ka index nikalo
                int top = stack.pop();

                /*
                 * Width calculate karo:
                 *
                 * Agar stack empty hai:
                 *     left mein koi smaller bar nahi hai
                 *     → rectangle index 0 se i-1 tak ja sakta hai
                 *     → width = i
                 *
                 * Agar stack empty nahi hai:
                 *     stack.peek() = nearest smaller bar on left
                 *     i = smaller bar on right
                 *     → width = i - stack.peek() - 1
                 */
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;

                // Rectangle ka area = height × width
                int area = heights[top] * width;

                // Maximum area update karo
                maxArea = Math.max(maxArea, area);
            }

            /*
             * Current bar ka index stack mein push karo.
             *
             * Stack increasing height order maintain karega.
             */
            stack.push(i);
        }

        // Histogram ka largest rectangle return karo
        return maxArea;
    }
}