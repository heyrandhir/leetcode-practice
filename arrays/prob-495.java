class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries.length == 1)
            return duration;
        int prev = 0;
        int totalDuration = 0;
        for (int i = 1; i < timeSeries.length; i++) {
            if (timeSeries[i] - timeSeries[prev] <= duration -1)
                totalDuration+= timeSeries[i] - timeSeries[prev];
            else
                totalDuration+= duration;
            prev = i;
        }
        return totalDuration+duration;
    }
}