class Solution {
    public int maxSubArray(int[] nums) {
        int n= nums.length;
        int[] T= new int[n]; //dp maximum subarray ending with nums[i]
        T[0]= nums[0];
        int max= T[0];
        for (int i=1; i<n; i++){
            T[i]= nums[i] + (T[i-1] > 0 ? T[i-1] :0);
            max= Math.max(T[i], max) ;
        }
        return max;
    }
}
