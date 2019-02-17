class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String first = strs[0];
        int l = first.length();
        if (l == 0) return "";
        String res = "";
        for (int i = 0; i < l; i++) {
            char cur = first.charAt(i);
            for (int j = 0; j < strs.length; j++) {
                if (strs[j].length() < i+1 || strs[j].charAt(i) != cur) {
                    return res;
                } 
            }
            res = res + cur;
        }
        return res;
    }
}
