class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int j = 0;//track the popped element using variable j
        Stack<Integer> s = new Stack<>();
        for(int i = 0 ; i < pushed.length; i ++){
            s.push(pushed[i]); //pushing the element into stack
            //peek() element is present in popped array then pop() the peek() element
            while(!s.isEmpty() && j != popped.length){
                if(s.peek() == popped[j]){
                    s.pop(); //pop the element 
                    j++; //increase the j pointer
                }else{
                    break;//break from the while loop not the for loop
                }
            }
        }
        return s.isEmpty();//check if the stack is empty or not if empty then all operation went successfull 
    
    }
}