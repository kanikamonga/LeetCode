class Solution {
    public int mostBooked(int n, int[][] meetings) {
        // Sort meetings by start time
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);
      
        // Priority queue to track busy rooms: [endTime, roomNumber]
        // Sorted by end time first, then by room number if end times are equal
        PriorityQueue<long[]> busyRooms = new PriorityQueue<>((a, b) -> {
            if (a[0] == b[0]) {
                return Long.compare(a[1], b[1]);
            }
            return Long.compare(a[0], b[0]);
        });

      
        // Priority queue to track available rooms (sorted by room number)
        PriorityQueue<Integer> availableRooms = new PriorityQueue<>();
      
        // Initialize all rooms as available
        for (int roomId = 0; roomId < n; roomId++) {
            availableRooms.offer(roomId);
        }
      
        // Track the count of meetings held in each room
        int[] meetingCount = new int[n];
      
        // Process each meeting
        for (int[] meeting : meetings) {
            int startTime = meeting[0];
            int endTime = meeting[1];
          
            // Free up rooms that have finished their meetings before current start time
            while (!busyRooms.isEmpty() && busyRooms.peek()[0] <= startTime) {
                long[] finishedRoom = busyRooms.poll();
                availableRooms.offer((int)finishedRoom[1]);  // Add room back to available pool
            }
          
            int assignedRoom;
          
           if (!availableRooms.isEmpty()) {
                assignedRoom = availableRooms.poll();
                busyRooms.offer(new long[] {endTime, assignedRoom});
            } else {
                long[] earliestRoom = busyRooms.poll();

                assignedRoom = (int) earliestRoom[1];
                long duration = endTime - startTime;
                long delayedEndTime = earliestRoom[0] + duration;

                busyRooms.offer(new long[] {delayedEndTime, assignedRoom});
            }
            // Increment the meeting count for the assigned room
            meetingCount[assignedRoom]++;
        }
      
        // Find the room with the most meetings (smallest room number if tied)
        int mostUsedRoom = 0;
        for (int roomId = 0; roomId < n; roomId++) {
            if (meetingCount[roomId] > meetingCount[mostUsedRoom]) {
                mostUsedRoom = roomId;
            }
        }
      
        return mostUsedRoom;
    }
}
