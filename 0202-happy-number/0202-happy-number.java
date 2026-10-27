class Solution {
    public static int SumofSquares(int n){
        int res=0;
        while(n>0){
            int rem=n%10;
            res+=rem*rem;
            n=n/10;
        }
        return res;
    }
    public boolean isHappy(int n) {
        if(n==1) return true;
        int slow=n;
        int fast=n;
        while(true){
            slow=SumofSquares(slow);
            fast=SumofSquares(SumofSquares(fast));
            if(fast==1) return true;
            if(slow==fast) return false;
        }
        // return false;
    }
}