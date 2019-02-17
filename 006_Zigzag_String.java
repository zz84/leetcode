class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        String res = "";
        int len = s.length();
        int s_counter = 0;
        while (s_counter < len) {
            res = (s_counter >= 0 && s_counter < len) ? res + s.charAt(s_counter) : res;
            s_counter = s_counter + 2*(numRows - 1);
        }
        
        for (int i = 1; i < numRows - 1; i++) {
            int counter = 0;
            while (counter - 2*(numRows - 1) < len) {
                res = (counter - i >= 0 && counter - i < len) ? res + s.charAt(counter - i) : res;
                res = (counter + i < len) ? res + s.charAt(counter + i) : res;
                counter = counter + 2*(numRows - 1);
            }
        }
        
        int e_counter = 0;
        while (e_counter < len) {
            res = (e_counter + numRows - 1 >= 0 && e_counter + numRows - 1 < len) ? 
                res + s.charAt(e_counter + numRows - 1) : res;
            e_counter = e_counter + 2*(numRows - 1);
        }
        return res;
    }
}
