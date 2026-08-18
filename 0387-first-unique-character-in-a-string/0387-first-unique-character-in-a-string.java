class Solution {
    public int firstUniqChar(String s) {
       char[] ch=s.toCharArray();
       int[] freq=new int[26];
       for(int i=0;i<ch.length;i++){
            freq[ch[i]-'a']++;
       }
       for(int i=0;i<s.length();i++){
            if(freq[s.charAt(i)-'a']==1){
                 return i;
            }
       }
       return -1;
    }
}