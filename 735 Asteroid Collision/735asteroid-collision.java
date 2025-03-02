class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        int i = 0;

        // Push all negative asteroids first (moving left)
        while (i < asteroids.length && asteroids[i] < 0) {
            st.push(asteroids[i]);
            i++;
        }

        // Process remaining asteroids
        for (int j = i; j < asteroids.length; j++) {
            if (asteroids[j] > 0) {
                st.push(asteroids[j]); // Moving right, push to stack
            } else {
                // Handle collisions with positive asteroids
                while (!st.isEmpty() && st.peek() > 0 && st.peek() < -asteroids[j]) {
                    st.pop(); // Smaller asteroid explodes
                }

                // If the stack is empty or contains a negative asteroid, push it
                if (st.isEmpty() || st.peek() < 0) 
                st.push(asteroids[j]);
                
                // If both asteroids are of the same size, both explode
                else if (st.peek() == -asteroids[j]) 
                st.pop();
            }
        }

        // Convert stack to array
        return convertStackToArray(st);
    }

    private int[] convertStackToArray(Stack<Integer> stack) {
        int size = stack.size();
        int[] array = new int[size];

        // Pop elements into array in correct order
        for (int i = size - 1; i >= 0; i--) {
            array[i] = stack.pop();
        }
        return array;
    }
}