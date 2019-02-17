class Solution {
    public List<String> letterCombinations(String digits) {
        Queue<String> res = new LinkedList<String>();
        int l = digits.length();
        if (l == 0) return new ArrayList<String>();
        for (int i = 0; i < l; i++) {
            addOne(digits.charAt(i), res);
        }
        
        List<String> result = new ArrayList<String>();
        while (res.peek() != null) {
            result.add(res.poll());
        }
        return result;
    }
    
    public void addOne(char c, Queue<String> q) {
        String letter = "";
        if (c == '2') letter = "abc";
        else if (c == '3') letter = "def";
        else if (c == '4') letter = "ghi";
        else if (c == '5') letter = "jkl";
        else if (c == '6') letter = "mno";
        else if (c == '7') letter = "pqrs";
        else if (c == '8') letter = "tuv";
        else if (c == '9') letter = "wxyz";
        else return;
        int l = letter.length();
        if (l == 0) return;
        //the very beginning
        if (q.peek() == null) {
            for (int i = 0; i < l; i++) {
                q.add(""+letter.charAt(i));
            }
            return;
        }
        
        int oldL = (q.peek()).length();
        while ((q.peek()).length() == oldL) {
            String cur = q.poll();
            for (int j = 0; j < l; j++) {
                q.add(cur + letter.charAt(j));
            }
        }
        return;
    }
}
