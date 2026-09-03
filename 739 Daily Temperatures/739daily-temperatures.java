class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(0);
        int[] r = new int[temperatures.length];
        for(int i = 1; i < temperatures.length; i++) {
            while(!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                int index = stack.pop();
                r[index] = i - index;
            }
            stack.push(i);
        }
        return r;
    }
}