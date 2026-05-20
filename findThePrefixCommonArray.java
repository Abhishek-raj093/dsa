import java.util.*;

class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] res = new int[n];
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<n; i++) {
            map.put(A[i], map.getOrDefault(A[i], 0) + 1);
            map.put(B[i], map.getOrDefault(B[i], 0) + 1);

            res[i] = count(map);
        }

        return res;
    }

    public int count(HashMap<Integer, Integer> map) {
        int count = 0;

        for(int key : map.keySet()) {
            if(map.get(key) == 2) {
                count++;
            }
        }

        return count;
    }
} 