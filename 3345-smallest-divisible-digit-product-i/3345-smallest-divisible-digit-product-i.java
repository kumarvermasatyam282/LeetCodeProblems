class Solution {
    public int smallestNumber(int n, int t) {
       int candidate=n;
       while(true){
            int product =1;
            int temp=candidate;
            while(temp>0){
                int rem=temp%10;
                product*=rem;
                temp/=10;
            }
            if(product%t==0) {
                return candidate;
            }
            candidate++;
        }
        
    }
}