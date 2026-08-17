class Solution {
    public String longestCommonPrefix(String[] arr) {
        if(arr==null || arr.length==0) return "";
        Arrays.sort(arr);
        String ans="";
        String first=arr[0];
        String last=arr[arr.length-1];
        for(int i=0;i<Math.min(first.length(),last.length());i++){
            if(first.charAt(i)==last.charAt(i)){
                ans+=first.charAt(i);
            }
            else break;
        }
        return ans;
    }
}