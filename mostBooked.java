class Solution {
    public int mostBooked(int n, int[][] meetings) {
       Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));

        // Min-heap of available room numbers
        PriorityQueue<Integer> availableRooms = new PriorityQueue<>();
        for (int i = 0; i < n; i++) availableRooms.offer(i);

        // Min-heap of [endTime, roomNumber]
        PriorityQueue<long[]> busyRooms = new PriorityQueue<>((a, b) -> 
            a[0] == b[0] ? Long.compare(a[1], b[1]) : Long.compare(a[0], b[0])
        );

        int[] roomCount = new int[n];

        for (int[] meeting : meetings) {
            int start = meeting[0], end = meeting[1];

            // Free rooms whose meetings have ended
            while (!busyRooms.isEmpty() && busyRooms.peek()[0] <= start) {
                availableRooms.offer((int) busyRooms.poll()[1]);
            }

            if (!availableRooms.isEmpty()) {
                int room = availableRooms.poll();
                busyRooms.offer(new long[]{end, room});
                roomCount[room]++;
            } else {
                long[] earliest = busyRooms.poll();
                long newStart = earliest[0];
                int room = (int) earliest[1];
                long duration = end - start;
                busyRooms.offer(new long[]{newStart + duration, room});
                roomCount[room]++;
            }
        }

        // Find room with max meetings
        int maxMeetings = 0, resultRoom = 0;
        for (int i = 0; i < n; i++) {
            if (roomCount[i] > maxMeetings) {
                maxMeetings = roomCount[i];
                resultRoom = i;
            }
        }
        return resultRoom; 
    }
}