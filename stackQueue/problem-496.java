// https://leetcode.com/problems/next-greater-element-i/description/

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> hashmap = new HashMap<>();
        int index = 0;
        for (int num1 : nums1) {
            hashmap.put(num1,index);
            index++;
        }

        Stack<Integer> st = new Stack<>();
        int[] nge = new int[nums1.length];

        for (int i = nums2.length -1; i >= 0; i--) {
            while (!st.isEmpty() && st.peek() <= nums2[i]){
                st.pop();
            }
            if (hashmap.containsKey(nums2[i])) {
                int indxMap = hashmap.get(nums2[i]);
                if (st.isEmpty()) {
                    nge[indxMap] = -1;
                } else {
                    nge[indxMap] = st.peek();
                }
            }
            st.push(nums2[i]);
        }
        return nge;
    }
}