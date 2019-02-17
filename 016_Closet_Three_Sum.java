class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if (nums.length == 0) return 0;
        int best = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-2; i++) {
            int left = i+1;
            int right = nums.length - 1;
            int newTarget = target - nums[i];
            int cur = Integer.MAX_VALUE;
            while (left < right) {
                if (nums[left] + nums[right] == newTarget) {
                    return target;
                } else if (nums[left] + nums[right] > newTarget) {
                    cur = (Math.abs(nums[left] + nums[right] - newTarget) < Math.abs(cur)) ? 
                        nums[left] + nums[right] - newTarget : cur;
                    right--;
                } else {
                    cur = (Math.abs(nums[left] + nums[right] - newTarget) < Math.abs(cur)) ? 
                        nums[left] + nums[right] - newTarget : cur;
                    left++;
                }      
            }
            best = (Math.abs(best) < Math.abs(cur)) ? best : cur;
        }
        return best + target;
    }
}
