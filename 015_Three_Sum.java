class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) break;
            if (i-1 >= 0 && nums[i] == nums[i-1]) continue;
            int left = i+1;
            int right = nums.length - 1;
            int target = 0 - nums[i];
            while (left < right) {
                if (nums[left] + nums[right] == target) {
                    //System.out.println("" +i+" "+left+" "+right);
                    List<Integer> sum = new ArrayList<Integer>();
                    sum.add(nums[i]);
                    sum.add(nums[left]);
                    sum.add(nums[right]);
                    res.add(sum);
                    while (left + 1 < nums.length && nums[left] == nums[left + 1]) left++;
                    while (right - 1 > 0 && nums[right] == nums[right - 1]) right--;
                    left++;
                    right--;
                } else if (nums[left] + nums[right] > target) {
                    right--;
                } else {
                    left++;
                }
                
            }
        }
        return res;
    }
}
