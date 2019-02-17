class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (st.empty()) {
                if (cur == '(' || cur == '[' || cur == '{') {
                    st.push(cur);
                    continue;
                } else return false;       
            }
            
            if (cur == '(' || cur == '[' || cur == '{') {
                st.push(cur);
                continue;
            } else {
                char prev = st.pop();
                if (cur == ')' && prev == '(') continue;
                else if (cur == ']' && prev == '[') continue;
                else if (cur == '}' && prev == '{') continue;
                else return false;
            }
        }
        return st.empty();
    }
}
