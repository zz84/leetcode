class Solution {
    public int reverse(int x) {
        long newX = (long)x;
        boolean isPos = x >= 0;
        if (!isPos) newX = - newX;
        long res = 0;
        while (newX > 0) {
            res = res*10 + newX % 10;
            newX = newX/10;
        }
        if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) return 0;
        if (!isPos) res = - res;
        return (int)res;
    }
}
