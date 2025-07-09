class Solution { 
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) { 
        int n = startTime.length; 
        List<Integer>ls = new ArrayList<>(); 
        ls.add(startTime[0]); 
        for (int i = 1; i < n; i++) { 
            ls.add(startTime[i] - endTime[i - 1]); 
        }  
        ls.add(eventTime - endTime[n - 1]); 
        int sum = 0; 
        for (int i = 0; i < k + 1; i++) { 
            sum += ls.get(i); 
        } 
 
        int maxi = sum; 
        for (int i = k + 1; i < ls.size(); i++) { 
            sum += ls.get(i) - ls.get(i - (k + 1)); 
            maxi = Math.max(maxi, sum); 
        } 
 
        return maxi; 
    } 
}