class Solution {
    public int strStr(String haystack, String needle) {
        int l = needle.length();
        if (l == 0) return 0;
        for (int i = 0; i < haystack.length() - l + 1; i++) {
            if (haystack.substring(i, i+l).equals(needle)) return i;
        }
        return -1;
    }
}
