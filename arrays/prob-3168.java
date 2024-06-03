class Solution {
    public int minimumChairs(String s) {
        int maxCount = 0;
        int count = 0;
        for (Character c: s.toCharArray()) {
            if (c == 'E')
                count+=1;
            else
                count-=1;
            if (count > maxCount)
                maxCount = count;
        }
        return maxCount;
    }
}