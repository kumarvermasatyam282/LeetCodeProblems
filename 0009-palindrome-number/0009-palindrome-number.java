class Solution {
    public boolean isPalindrome(int x) {
        String str=Integer.toString(x);
        char[] arr=str.toCharArray();
        int n=str.length();
        int i=0;
        int j=n-1;
        boolean flag=true;
        while(i<=j){
            if(arr[i]!=arr[j]) flag =false;
            i++;
            j--;
        }
        return flag;
    }
}