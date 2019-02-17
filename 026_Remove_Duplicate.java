class Solution {
    public int removeDuplicates(int[] nums) {
        int l = nums.length;
        if (l <= 1) return l;
        int res = 1;
        int prev = nums[0];
        for (int i = 0; i < l; i++) {
            if (nums[i] != prev) {
                prev = nums[i];
                nums[res] = nums[i];
                res++;
            }
        }
        return res;
    }
}
