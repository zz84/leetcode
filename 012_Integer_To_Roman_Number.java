class Solution {
    public String intToRoman(int num) {
        String res = "";
        int thousand = num/1000;
        int hundred = (num/100) % 10;
        int ten = (num/10) % 10;
        int one = num % 10;
        
        if (thousand != 0) {
            if (thousand == 1) res = res + "M";
            else if (thousand == 2) res = res + "MM";
            else if (thousand == 3) res = res + "MMM";
        }
        
        if (hundred != 0) {
            if (hundred == 1) res = res + "C";
            else if (hundred == 2) res = res + "CC";
            else if (hundred == 3) res = res + "CCC";
            else if (hundred == 4) res = res + "CD";
            else if (hundred == 5) res = res + "D";
            else if (hundred == 6) res = res + "DC";
            else if (hundred == 7) res = res + "DCC";
            else if (hundred == 8) res = res + "DCCC";
            else if (hundred == 9) res = res + "CM";            
        }
        
        if (ten != 0) {
            if (ten == 1) res = res + "X";
            else if (ten == 2) res = res + "XX";
            else if (ten == 3) res = res + "XXX";
            else if (ten == 4) res = res + "XL";
            else if (ten == 5) res = res + "L";
            else if (ten == 6) res = res + "LX";
            else if (ten == 7) res = res + "LXX";
            else if (ten == 8) res = res + "LXXX";
            else if (ten == 9) res = res + "XC";            
        }
        
        if (one != 0) {
            if (one == 1) res = res + "I";
            else if (one == 2) res = res + "II";
            else if (one == 3) res = res + "III";
            else if (one == 4) res = res + "IV";
            else if (one == 5) res = res + "V";
            else if (one == 6) res = res + "VI";
            else if (one == 7) res = res + "VII";
            else if (one == 8) res = res + "VIII";
            else if (one == 9) res = res + "IX";            
        }
        return res;
    }
}
