//My solution uses DP, O(n^2) time complexity
class MySolution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if (n == 0) return 0;
        HashSet<Character>[] opt = new HashSet[n];
        HashSet<Character> first = new HashSet();
        first.add(s.charAt(0));
        opt[0] = first;
        for (int i = 1; i < n; i++) {
            char cur_c = s.charAt(i);
            HashSet<Character> cur = new HashSet<Character>();
            if (opt[i-1].contains(cur_c)) {
                cur.add(cur_c);
                int temp = i-1;
                while (s.charAt(temp) != cur_c) {
                    cur.add(s.charAt(temp));
                    temp = temp - 1;
                }
            } else {
                for (char c : opt[i-1]) {
                    cur.add(c);
                }
                cur.add(cur_c);
            }
            opt[i] = cur;
        }
        
        int best = 0;
        for (int j = 0; j < n; j++){
            best = Math.max(best, opt[j].size());
        }
        return best;
    }
}


//best solution 
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }
}

