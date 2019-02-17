class Solution(object):
    def longestValidParentheses(self, s):
        """
        :type s: str
        :rtype: int
        """
        best = 0
        stack = []
        for i in range(0, len(s)):
            if s[i] == ')' and len(stack) > 0 and s[stack[len(stack)-1]] == '(':
                stack.pop()
                if len(stack) == 0:
                    best = i + 1
                else:
                    best = max(best, i - stack[len(stack)-1])
            else:
                stack.append(i)
        return best
