class Solution {
    public String longestCommonPrefix(String[] arr) {
        if(arr==null || arr.length==0) return "";
        Arrays.sort(arr);
        // String ans="";
        // String first=arr[0];
        // String last=arr[arr.length-1];
        // for(int i=0;i<Math.min(first.length(),last.length());i++){
        //     if(first.charAt(i)==last.charAt(i)){
        //         ans+=first.charAt(i);
        //     }
        //     else break;
        // }
        // return ans;

        String first=arr[0];
        String last=arr[arr.length-1];
        int i=0;
        while(i<first.length() && i<last.length() && first.charAt(i)==last.charAt(i)){
            i++;
        }
        return first.substring(0,i);
    }
}