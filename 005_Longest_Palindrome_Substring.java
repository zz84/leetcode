class Solution {
    public String longestPalindrome(String s) {
        int start = 0; 
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len = Math.max(expand(s, i, i), expand(s, i, i+1));
            //System.out.print("\nlen is " + len);
            if (len > (end - start + 1)) {
                start = (len % 2 == 0) ? i - len/2 + 1 : i - len/2;
                end = i + len/2;
            }
        }
        //System.out.print("\nstart is " + start);
        //System.out.print("\nend is " + end);
        return s.substring(start, end + 1);
        
    }
    
    public int expand(String s, int start, int end) {
        int left = start;
        int right = end;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}
