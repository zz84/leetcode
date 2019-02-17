class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<Integer>();
        int l = s.length();
        int num = words.length;
        if (l == 0 || num == 0) return res;
        int len = words[0].length();
        if (len == 0) return res;
        
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (String w : words) {
            map.put(w, map.getOrDefault(w, 0) + 1);
        }
        
        for (int i = 0; i < l - num*len + 1; i++) {
            Map<String, Integer> cur = new HashMap<String, Integer>();
            int j = 0;
            while (j < num) {
                String st = s.substring(i + j*len, i + (j + 1)*len);
                //System.out.println(st);
                cur.put(st, cur.getOrDefault(st, 0) + 1);
                if (!map.containsKey(st)) break;
                if (cur.get(st) > map.get(st)) break;
                j++;
            }
            if (j == num) res.add(i);
        }
        return res;
    }
}
