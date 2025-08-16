class Solution {
    public int maximum69Number (int num) {
        char[] digits = String.valueOf(num).toCharArray();
        for (int k = 0; k < digits.length; k++) {
            if (digits[k] == '6') {
                digits[k] = '9';
                break;
            }
        }
        return Integer.parseInt(new String(digits));
    }
}