class Solution {
    public int countCompleteDayPairs(int[] hours) {
        int ans = 0;
        HashMap<Integer,Integer> memo = new HashMap<>();
        for (int hour : hours) {
            int rem = hour%24;
            if (memo.containsKey(rem)) {
                memo.put(rem,memo.get(rem)+1);
            } else {
                memo.put(rem,1);
            }

            if (rem == 0 || rem == 12) {
                ans += memo.get(rem) - 1;
            } else if (memo.containsKey(24-rem)) {
                ans += memo.get(24-rem);
            }
        }

        return ans;
    }
}