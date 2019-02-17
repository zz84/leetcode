class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; i + j < nums.length; j++) {
                if (nums[i] + nums[i+j] == target) {
                    result[0] = i;
                    result[1] = i+j;
                    return result;
                }
            }
        }
        return null;
    }
}
