class Solution {
    public String largestGoodInteger(String num) {
        String max = "";
        for (int i = 0; i <= num.length() - 3; i++) {
            String current = num.substring(i, i + 3);
            if (current.charAt(0) == current.charAt(1) && 
                current.charAt(1) == current.charAt(2)) {
                if (current.compareTo(max) > 0) {
                    max = current;
                }
            }
        }
        return max;
    }
}