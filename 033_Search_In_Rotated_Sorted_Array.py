class Solution(object):
    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        return self.binarySearch(nums, target, 0, len(nums)-1)

    
    def binarySearch(self, nums, target, low, high):
        if high < low:
            return -1
        mid = (low + high)/2
        vmid = nums[mid]
        vlow = nums[low]
        vhigh = nums[high]
        if vmid == target:
            return mid
        elif vlow == target:
            return low
        elif vhigh == target:
            return high
        elif vmid > vlow:
            if vmid > target and vlow < target:
                return self.binarySearch(nums, target, low, mid-1)
            else:
                return self.binarySearch(nums, target, mid+1, high)
        elif vmid < vlow:
            if vmid < target and vhigh > target:
                return self.binarySearch(nums, target, mid+1, high)
            else:
                return self.binarySearch(nums, target, low, mid-1)
        return -1
    
