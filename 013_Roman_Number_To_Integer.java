class Solution {
    public int romanToInt(String s) {
        int res = 0;
        int extra = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            char cur = s.charAt(i);
            char next = s.charAt(i+1);
            if (cur == 'C' && (next == 'D' || next == 'M')) extra = extra + 100;
            else if (cur == 'X' && (next == 'L' || next == 'C')) extra = extra + 10;
            else if (cur == 'I' && (next == 'V' || next == 'X')) extra = extra + 1;
        }
        
        for (int j = 0; j < s.length(); j++) {
            char current = s.charAt(j);
            if (current == 'M') res = res + 1000;
            else if (current == 'D') res = res + 500;
            else if (current == 'C') res = res + 100;
            else if (current == 'L') res = res + 50;
            else if (current == 'X') res = res + 10;
            else if (current == 'V') res = res + 5;
            else if (current == 'I') res = res + 1;
        }
        
        return res - 2*extra;
    }
}
