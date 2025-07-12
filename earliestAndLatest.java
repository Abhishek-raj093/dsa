class Solution {
    private int earliest = Integer.MAX_VALUE;
    private int latest = -1;
    
    public int[] earliestAndLatest(int n, int firstPlayer, int secondPlayer) {
        int[] players = new int[n];
        for (int i = 0; i < n; i++) {
            players[i] = i + 1;
        }
        backtrack(players, 1, firstPlayer, secondPlayer);
        return new int[]{earliest, latest};
    }
    
    private void backtrack(int[] players, int round, int firstPlayer, int secondPlayer) {
        int n = players.length;
        if (n < 2) return;
        int[] nextRound = new int[n / 2 + n % 2];
        
        loop: for (int mask = 0; mask < (1 << (n / 2)); mask++) {
            int bit = 1;
            for (int i = 0; i < n / 2; i++) {
                if (players[i] == firstPlayer && players[n - i - 1] == secondPlayer) {
                    if (round < earliest) {
                        earliest = round;
                    }
                    if (round > latest) {
                        latest = round;
                    }
                    break loop;
                }
                if ((players[i] == firstPlayer || players[i] == secondPlayer) && (mask & bit) == 0) {
                    continue loop;
                }
                if ((players[n - 1 - i] == firstPlayer || players[n - 1 - i] == secondPlayer) && (mask & bit) != 0) {
                    continue loop;
                }
                nextRound[i] = (mask & bit) != 0 ? players[i] : players[n - 1 - i];
                bit = bit << 1;
            }
            if (n % 2 == 1) {
                nextRound[n / 2] = players[n / 2];
            }
            Arrays.sort(nextRound);
            backtrack(nextRound, round + 1, firstPlayer, secondPlayer);
        }
    }
}