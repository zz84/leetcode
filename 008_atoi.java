class Solution {
    public int myAtoi(String str) {
        //System.out.println("0 is: " + (int)'0');
        //System.out.println("1 is: " + (int)'1');
        //System.out.println("2 is: " + (int)'2');
        //System.out.println("3 is: " + (int)'3');
        //System.out.println("4 is: " + (int)'4');
        //System.out.println("5 is: " + (int)'5');
        //System.out.println("6 is: " + (int)'6');
        //System.out.println("7 is: " + (int)'7');
        //System.out.println("8 is: " + (int)'8');
        //System.out.println("9 is: " + (int)'9');
        //System.out.println("+ is: " + (int)'+');
        //System.out.println("- is: " + (int)'-');
        //System.out.println("space is: " + (int)' ');
        
        int res = 0;
        int index = 0;
        int l = str.length();
        while (index < l && ((int)str.charAt(index)) == 32) index++;
        if (index >= l) return 0;
        int signBit = (int)str.charAt(index);
        boolean isNeg = signBit == 45;
        if (signBit == 43 || signBit == 45) index++;
        while (index < l && ((int)str.charAt(index)) == 48) index++;
        int start = index;
        while (index < l && (((int)str.charAt(index)) >= 48 && ((int)str.charAt(index)) <= 57)) index++;
        int end = index;
        
        if (start == end) return 0;
        
        if (end - start > 10) {
            res = (isNeg) ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            return res;
        }
        
        long temp = Long.parseLong(str.substring(start, end));
        temp = (isNeg) ? (-temp) : temp;
        if (temp > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if (temp < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        return (int)temp;
    }
}
