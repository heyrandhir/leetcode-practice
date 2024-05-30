class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
 
        for (int asteroid : asteroids) {
            boolean shouldAdd = true;
            while (st.size() != 0 && asteroid < 0 && st.peek() > 0) {
                int peek = st.peek();

                if (Math.abs(asteroid) > Math.abs(peek)) {
                    st.pop();
                    continue;
                } else if (Math.abs(asteroid) == Math.abs(peek)) {
                    shouldAdd = false;
                    st.pop();
                    break;
                }
                shouldAdd = false;
                break;
            }

            if (shouldAdd)
                st.push(asteroid);

        }    
        int[] result = new int[st.size()];
        int count = 0;
        for (int i : st) {
            result[count++] = i;
        }
        
        return result;
    }
}