class Solution {
    public boolean isMatch(String s, String p) {
        //dp: opt[i][j] stores whether s[:i] matches p[:j]
        int l1 = s.length();
        int l2 = p.length();
        boolean[][] opt = new boolean[l1 + 1][l2 + 1];
        opt[0][0] = true;
        
        for (int i = 1; i < l1 + 1; i++) {
            opt[i][0] = false;
        }
        
        for (int si = 0; si < l1 + 1; si++) {
            for (int pi = 1; pi < l2 + 1; pi++) {
                if (pi >= 2 && p.charAt(pi - 1) == '*') {
                    opt[si][pi] = opt[si][pi-2] || (si >= 1 && (s.charAt(si-1) == p.charAt(pi-2) 
                                                                || p.charAt(pi-2) =='.') && opt[si-1][pi]);
                } else {
                    opt[si][pi] = si > 0 && (s.charAt(si-1) == p.charAt(pi-1) || p.charAt(pi-1) == '.') && opt[si-1][pi-1];
                }
            }
        }
        return opt[l1][l2];
    }
}
