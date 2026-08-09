class Solution {
    static int[][] dp;
    public static int getAlicescore(int[] piles,int[] sum){
        int n=piles.length;
        for(int i=n-1;i>=0;i--){
            for(int M=n;M>0;M--){
                if(i+2*M >= n){
                    dp[i][M]=sum[i];
                }
                else{
                    int best=0;
                    for(int X=1;X<=2*M;X++){
                        int newM=Math.max(M,X);
                        int opponent=dp[i+X][newM];
                        int current=sum[i]-opponent;
                        best=Math.max(best,current);
                    }
                    dp[i][M]=best;
                }
            }
        }
        return dp[0][1];
    }
    
    public int stoneGameII(int[] piles) {
        int n=piles.length;
        int[] sum=new int[n+1];
        dp=new int[n+1][n+1];
        for(int i=n-1;i>=0;i--){
            sum[i]=piles[i]+sum[i+1];
        }
        // Arrays.fill(dp,-1);
        int alice_score=getAlicescore(piles,sum);
        return alice_score;
    }
}