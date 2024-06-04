class Solution {
    public int myAtoi(String s) {
        s = s.trim();

        if (s.isEmpty())
            return 0;

        int multiplyBy = 1;
        int i = 0;
        if (s.charAt(0) == '-')
            multiplyBy = -1;
        if (s.charAt(0) == '-' || s.charAt(0) == '+'){
            i = 1;
        }
        
        int ans = 0;
        int maxDiv10 = Integer.MAX_VALUE/10;

        while (i < s.length()) {
            int diff = s.charAt(i)-'0';
            if ( diff >= 0 && diff <= 9) {
                if (ans > maxDiv10 || (ans == maxDiv10 && diff > 7))
                    return multiplyBy == 1 ?  Integer.MAX_VALUE :  Integer.MIN_VALUE;
                ans = ans*10+diff;
            } else {
                return multiplyBy*ans;
            }
            i++;
        }
        return multiplyBy*ans;
    }
}