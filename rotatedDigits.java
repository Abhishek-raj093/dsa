import java.util.*;

class Solution {
    static ArrayList<Integer> goodNumbers = new ArrayList<>();
    static ArrayList<Integer> goodNumberCount = new ArrayList<>();
    public int rotatedDigits(int n) {
        if(goodNumbers.isEmpty()) {
            createAGoodNumberList();
        }
        return goodNumberCount.get(n);
    }

    private void createAGoodNumberList() {
        int count = 0;
        for(int num = 0; num <= 10000; num++) {
            boolean isValid = isValidGoodNumber(num);
            if(isValid) {
                count++;
                goodNumbers.add(num);
            }
            goodNumberCount.add(count);
        }
    }

    private boolean isValidGoodNumber(int num) {
        boolean isValid = false;
        while(num > 0) {
            int digit = num % 10;
            if( digit == 3 || digit == 4 || digit == 7) {
                return false;
            }
            if(digit == 2 || digit == 5 || digit == 6 || digit == 9) {
                isValid = true;
            }
            num /= 10;
        }
        return isValid;
    }
}