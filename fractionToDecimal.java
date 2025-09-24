class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";
        
        StringBuilder result = new StringBuilder();
        Map<Long, Integer> remainderPositions = new HashMap<>();
        
        if ((numerator < 0) ^ (denominator < 0)) {
            result.append("-");
        }
        
        long num = Math.abs((long) numerator), den = Math.abs((long) denominator);
        
        result.append(num / den);
        long remainder = num % den;
        
        if (remainder == 0) {
            return result.toString();
        } else {
            result.append(".");
        
            while (remainder != 0) {
                if (remainderPositions.containsKey(remainder)) {
                    int pos = remainderPositions.get(remainder);
                    result.insert(pos, "(").append(")");
                    break;
                }

                remainderPositions.put(remainder, result.length());
            
                remainder *= 10;
                result.append(remainder / den);
                remainder %= den;
            }
        
            return result.toString();
        }
    }
}