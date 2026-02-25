import java.util.*;

class Solution {
    public int[] sortByBits(int[] arr) {
        Integer temp[] = new Integer[arr.length];
        
        for(int i = 0; i < arr.length; i++){
            temp[i] = arr[i];
        }

        Arrays.sort(temp, (a, b) -> {
            int bitofa = Integer.bitCount(a);
            int bitofb = Integer.bitCount(b);

            if(bitofa == bitofb) return a - b;
            return bitofa - bitofb;
        });

        for(int i = 0; i < arr.length; i++){
            arr[i] = temp[i];
        }

        return arr;
    }
}