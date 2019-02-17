class Solution:
    def findMedianSortedArrays(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: float
        """
        l1 = len(nums1)
        l2 = len(nums2)
        k = (int)((l1 + l2) / 2)
        if (l1 + l2) % 2 == 0:
            return 0.5 * (self.findK(nums1, nums2, k) + self.findK(nums1, nums2, k+1))
        return (float)(self.findK(nums1, nums2, k + 1))
        
    
    def findK(self, nums1, nums2, k):
        #return kth smallset
        #print(nums1)
        #print(nums2)
        l1 = len(nums1)
        l2 = len(nums2)
        if l2<l1: return self.findK(nums2, nums1, k)
        if l1 == 0 : 
            return nums2[k - 1]
        if l2 == 0 : 
            return nums1[k - 1]
        if k == 1 :
            return min(nums1[0], nums2[0])
        a = (int)(min(k/2, l1))
        b = (int)(k - a)
        if nums1[a-1] <= nums2[b-1]:
            return self.findK(nums1[a:], nums2, b)
        return self.findK(nums1, nums2[b:], a)
