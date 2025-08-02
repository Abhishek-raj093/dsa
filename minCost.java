class Solution {
    public long minCost(int[] basket1, int[] basket2) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        
        for(int num : basket1){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for(int num : basket2){
            map.put(num, map.getOrDefault(num, 0) - 1);
        }

        ArrayList<Integer> more = new ArrayList<>();
        int minVal = Integer.MAX_VALUE;

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            int fruit = entry.getKey();
            int freq = entry.getValue();

            minVal = Math.min(minVal, fruit);

            if(freq % 2 != 0) return -1;

            for(int i = 0; i < Math.abs(freq)/2; i++){
                more.add(fruit);
            } 
        }

        long cost = 0;
        for(int i = 0; i < more.size()/2; i++){
            int val = more.get(i);
            cost += Math.min(val, 2*minVal); 
        }
        return cost;
    }
}