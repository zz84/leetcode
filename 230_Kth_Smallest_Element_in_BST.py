# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def kthSmallest(self, root, k):
        """
        :type root: TreeNode
        :type k: int
        :rtype: int
        """
        self.depth = k
        self.res = None
        self.helper(root)
        return self.res
    
    def helper(self, x):
            if x.left:
                self.helper(x.left)
                if self.res:
                    return
            self.depth -= 1
            if self.depth == 0:
                self.res = x.val
                return
            if x.right:
                self.helper(x.right)
