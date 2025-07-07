class Solution {

    public int maxEvents(int[][] events) {
        int n = events.length;
        int lastDay = 0;
        for (int[] event : events) {
            lastDay = Math.max(lastDay, event[1]);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        int ans = 0;
        for (int day = 1, j = 0; day <= lastDay; day++) {
             // Add all events starting today - can be attended today
            while (j < n && events[j][0] <= day) {
                pq.offer(events[j][1]);
                j++;
            }
            // Remove events that ended before today - expired events
            while (!pq.isEmpty() && pq.peek() < day) {
                pq.poll();
            }
            //Attend the meeting with the earliest end time 
            if (!pq.isEmpty()) {
                pq.poll();
                ans++;
            }
        }

        return ans;
    }
}