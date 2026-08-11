class Solution {
    public String restoreString(String s, int[] indices) {
        char[] arr=s.toCharArray();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            arr[indices[i]]=ch;
        }
        return new String(arr);
    }
}