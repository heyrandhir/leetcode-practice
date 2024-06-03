class Solution {
    public int countDays(int days, int[][] meetings) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> {
            if (a[0] == b[0])
                return a[1] - b[1];
            else
                return a[0] - b[0];
            }
        );

        for (int[] meeting : meetings) {
            pq.add(meeting);
        }

        int prev = 0;
        int totalFreeDays = 0;

        while (pq.size() != 0) {
            int[] currMeet = pq.remove();
            if ((currMeet[0] - 1 - prev) > 0) {
                totalFreeDays+= currMeet[0] - prev - 1;
            }
            prev = Math.max(prev,currMeet[1]);
        }
        totalFreeDays+= days - prev;
        return totalFreeDays;
    }
}