class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        String start = arriveAlice.compareTo(arriveBob) > 0 ? arriveAlice : arriveBob;
        String end = leaveAlice.compareTo(leaveBob) < 0 ? leaveAlice : leaveBob;

        if (end.compareTo(start) < 0) {
            return 0;
        }

        int sm = Integer.parseInt(start.substring(0, 2));
        int em = Integer.parseInt(end.substring(0, 2));
        int sd = Integer.parseInt(start.substring(3, 5));
        int ed = Integer.parseInt(end.substring(3, 5));

        int d = 0;
        for (int i = sm - 1; i < em; i++) {
            d += days[i];
        }

        return d - (sd - 1) - (days[em - 1] - ed);
    }
}