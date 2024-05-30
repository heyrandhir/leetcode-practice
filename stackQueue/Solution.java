// problem statement https://www.interviewbit.com/problems/nearest-smaller-element/

public class Solution {
    public ArrayList<Integer> prevSmaller(ArrayList<Integer> arr) {
        Stack<Integer> st = new Stack<>();
        ArrayList<Integer> nse = new ArrayList<>(); 
        for (int i = 0; i < arr.size(); i++) {
            while (!st.isEmpty() && st.peek() >= arr.get(i)){
                st.pop();
            }
            if (st.isEmpty()) {
                nse.add(-1);
            } else {
                nse.add(st.peek());
            }
            st.push(arr.get(i));
        }
        return nse;
    }
}
