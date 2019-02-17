//O(n^2) naive solution
class MySolution {
    public int maxArea(int[] height) {
        int best = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = 1; i + j < height.length; j++) {
                best = Math.max(best, j * Math.min(height[i], height[i+j]));
            }
        }
        return best;
    }
}

//O(n) solution. Greedy algo
class Solution {
    public int maxArea(int[] height) {
        int best = 0;
        int leftEdge = 0;
        int rightEdge = height.length - 1;
        while (leftEdge != rightEdge) {
            best = Math.max(best, (rightEdge - leftEdge) * Math.min(height[leftEdge], height[rightEdge]));
            if (height[leftEdge] < height[rightEdge]) {
                leftEdge++;
            } else {
                rightEdge--;
            }
        }
        return best;
    }
}
