class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i-1]) continue;
            for (int j = i+1; j < nums.length; j++) {
                if (j != i + 1 && nums[j] == nums[j-1]) continue;
                int left = j+1;
                int right = nums.length - 1;
                while (left < right) {
                    if (nums[left] + nums[right] + nums[i] + nums[j] == target) {
                        //System.out.println("" +i+" "+left+" "+right);
                        List<Integer> sum = new ArrayList<Integer>();
                        sum.add(nums[i]);
                        sum.add(nums[j]);
                        sum.add(nums[left]);
                        sum.add(nums[right]);
                        res.add(sum);
                        while (left + 1 < nums.length && nums[left] == nums[left + 1]) left++;
                        while (right - 1 > 0 && nums[right] == nums[right - 1]) right--;
                        left++;
                        right--;
                    } else if (nums[left] + nums[right] + nums[i] + nums[j] > target) {
                        right--;
                    } else {
                        left++;
                    }
                }
            }     
        }
        return res;
    }
}

//Out of Time N-Sum solution
class MySolution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        search(nums, target, 0, new ArrayList<Integer>(), res);
        return res;
    }
    
    public void search(int[] nums, int target, int curIndex, ArrayList<Integer> curNum, List<List<Integer>> res) {
        if (curNum.size() == 4) {
            if (target == getSum(curNum)) {
                //System.out.println("" + curNum.get(0) + ", " + curNum.get(1) + ", " + curNum.get(2) + ", " + curNum.get(3) + "");
                res.add(new ArrayList<>(curNum));
            }
            return;
        }
        
        if (curIndex >= nums.length) return;
        
        for (int i = curIndex; i < nums.length; i++) {
            if (i != curIndex && nums[i] == nums[i-1]) continue;
            curNum.add(nums[i]);
            if (getSum(curNum) > target && nums[i] > 0) {
                if (!curNum.isEmpty()) curNum.remove(curNum.size() - 1);
                return;
            }
            search(nums, target, i+1, curNum, res);
            curNum.remove(curNum.size()-1);
        }
        return;
    }
    
    public int getSum(ArrayList<Integer> arr) {
        int sum = 0;
        for (int num : arr) {
            sum = sum + num;
        }
        return sum;
    }
}
