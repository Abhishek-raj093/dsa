import java.util.*;

class Solution {
    public int minSwaps(int[][] grid) {
        int n = grid.length;
        int result=0;
        int[] idx =new int[n];
        for(int i=0; i<n; i++){
            idx[i]=i;
        }
        for(int i=0; i<n; i++){
            // now check karenge ki i idx pe konsi row honi chahiye
            // or use lane ke liye count kaenge
            boolean found = false;
            for(int j=i; j<n; j++){
                int[] arr = grid[idx[j]];
                // vo idx[j] arr agar nr<=i and nc<=i ho to now update idx array or continue karene 
                
                int lc =0;
                for(int k=0; k<arr.length; k++){
                    if(arr[k]==1)lc = k;
                }
                if(lc<=i){
                    found = true;
                    result+=j-i;
                    int temp = idx[j];
                    for(int k= j; k>i; k--){
                        idx[k]=idx[k-1];
                    }
                    idx[i]=temp;
                    break;
                }
            }
            if(!found)return -1;
        }
        return result;
    }
}