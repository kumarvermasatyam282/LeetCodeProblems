class Solution {
    public int numberOfMatches(int n) {
        int played=0;
        int advance=0;
        while(n>1){
            if(n%2!=0){
                played+=(n-1)/2;
                advance=(n-1)/2+1;
            }
            else {
                played+=n/2;
                advance=n/2;
            }
            n=advance;

        }
        return played;
    }
}