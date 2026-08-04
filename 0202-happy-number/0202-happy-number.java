class Solution {
    public static int getsum(int n){
        int sum=0;
            while(n>0){
                int rem=n%10;
                sum+=rem*rem;
                n=n/10;
            }
            return sum;
    }
    public boolean isHappy(int n) {
        int slow=n;
        int fast=getsum(n);
        while(fast!=1 && slow!=fast){
        slow=getsum(slow);
        fast=getsum(getsum(fast));
        }
        if(fast==1) return true;
        return false;
    }
}