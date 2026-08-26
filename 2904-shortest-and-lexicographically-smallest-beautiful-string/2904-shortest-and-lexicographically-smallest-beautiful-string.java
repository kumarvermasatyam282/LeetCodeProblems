class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        TreeSet<String> set=new TreeSet<>();
        for (int i = 0; i < s.length(); i++) {
            String ans = "";
            int count = 0;
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(j) == '1') {
                    count++;
                }
                ans += s.charAt(j);
                if (count == k) {
                    if(!set.contains(ans)) set.add(ans);
                    break;
                }
            }
        }
        int minlength = Integer.MAX_VALUE;
        StringBuilder res = new StringBuilder();
        for (String ele : set) {
            if (ele.length() < minlength) {
                minlength = ele.length();
                res = new StringBuilder(ele);
            }
        }
        return res.toString();
        
    }

}