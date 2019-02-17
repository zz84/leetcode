class Solution {
    public List<String> generateParenthesis(int n) {
        Set<String> s = new HashSet<String>();
        if (n == 0) {
            s.add("");
        } else {
            List<String> prev = generateParenthesis(n-1);
            for (String cur : prev) {
                for (int i = 0; i < cur.length(); i++) {
                    if (cur.charAt(i) == '(') {
                        s.add(cur.substring(0, i+1) + "()" + cur.substring(i+1, cur.length()));
                    }
                }
                s.add("()" + cur);
            }
        }
        return new ArrayList(s);
    }
}
