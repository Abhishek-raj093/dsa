class Solution {
    // get sum of digits of a number
    public int getSum(int num)
    {
        int sum=0;
        while(num!=0)
        {
            sum+= num%10;
            num/= 10;
        }
        return sum;
    }

    public int minSwaps(int[] nums) {
        int n= nums.length;
        int arr[][]= new int[n][3];

        // make 2D array storing info about num, sumOfDigits and its originalPosition
        for(int i=0; i<n; i++)
        {
            int sumOfDigits= getSum(nums[i]);

            arr[i][0]= nums[i];
            arr[i][1]= sumOfDigits;
            arr[i][2]= i;
        }

        // sort the array based on sumOfDigits, if equal then sort by value of num
        Arrays.sort(arr, (a, b) -> {
            if(a[1]==b[1])
                return Integer.compare(a[0], b[0]);
            else
                return Integer.compare(a[1], b[1]);
        });

        // visited array for checking if some pos swap is already counted in a cycle
        boolean[] visited = new boolean[n];
        int swaps = 0;

        for (int i = 0; i < n; i++) {
            // if swap already counted or no swap happened for curr position
            if (visited[i] || arr[i][2] == i)
                continue;

            int cycleLength = 0;
            int j = i;

            // get cycle length until we come back to starting position
            while (!visited[j]) {
                visited[j] = true;
                j = arr[j][2];
                cycleLength++;
            }

            swaps += cycleLength - 1;
        }

        return swaps;
    }
}