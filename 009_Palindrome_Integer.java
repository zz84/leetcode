class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        String str = "" + x;
        int l = str.length();
        String reverse = "";
        for (int i = 0; i < l; i++) {
            reverse = reverse + str.charAt(l - i - 1);
        }
        long newX = Long.parseLong(reverse);
        if (newX > Integer.MAX_VALUE) return false;
        return (int)newX == x;
        
    }
}
