// [2,3,1,3,2] val:3 returns [2,1,2,3,3] 
class Solution {
    public int removeElement(int[] nums, int val) {
        int start= 0;
        int end= nums.length - 1;
        while (start <= end) {
            if (nums[start] == val) {
                swap(nums, start, end);
                end--;
            } else start ++;
        } 
        return start;
    }
    
    public void swap(int[] nums, int i, int j){
        int temp= nums[i];
        nums[i]= nums[j];
        nums[j]= temp;
    }
}

// [2,3,1,3,2] val:3 returns [2,1,2,*,*] 
class Solution2 {
    public int removeElement(int[] nums, int val) {
        int res= 0;
        for (int i=0; i< nums.length; i++) {
            if (nums[i] != val) {
                nums[res]= nums[i];
                res++;
            } 
        }
        return res;
    }
}
