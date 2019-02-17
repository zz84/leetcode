class Solution(object):
    def nextPermutation(self, nums):
        """
        :type nums: List[int]
        :rtype: void Do not return anything, modify nums in-place instead.
        """
        length = len(nums)
        if length <= 1:
            return
        
        for i in range(1, length):
            if nums[length-i] > nums[length-i-1]:
                nums[length-i:] = sorted(nums[length-i:])
                #print(nums[length-i:])
                start = length - i
                cur = nums[length-i-1]
                while nums[start] <= cur:
                    start = start+1
                temp = nums[start]
                #print(start)
                nums[start] = cur
                nums[length-i-1] = temp
                nums[length-i:] = sorted(nums[length-i:])
                #print(nums)
                return
            
        nums.sort()
        return
