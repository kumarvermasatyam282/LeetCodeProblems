class Solution {
    public int strStr(String haystack, String needle) {
        int m=haystack.length();
        int n=needle.length();
        int j=0;
        int i=0;
        while(i < m && j < n){
            if(haystack.charAt(i)==needle.charAt(j)) {
                i++;
                j++;
            }
            else{
                i=i-j+1;
                j=0;
            }
            if(j == n) return i-j;
        }
        return -1;
    }
}