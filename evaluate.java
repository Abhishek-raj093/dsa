class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        int n = s.length();

        HashMap<String, String> map = new HashMap<>();

        for (List<String> list : knowledge) {
            map.put(list.get(0), list.get(1));
        }

        StringBuilder sb = new StringBuilder();

        int i = 0;

        while (i < n) {
            char ch = s.charAt(i);

            if (ch == '(') {
                int j = i;

                while (s.charAt(j) != ')') {
                    j++;
                }

                String key = s.substring(i + 1, j);
                String value = map.get(key);

                if (value == null) {
                    sb.append('?');
                } else {
                    sb.append(value);
                }

                i = j + 1;
            } else {
                sb.append(ch);
                i++;
            }
        }

        return sb.toString();
    }
}