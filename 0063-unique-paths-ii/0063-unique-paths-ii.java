class Solution {
    static int path;
    public static int paths(int[][] dp,int[][] obstacleGrid,int n , int m){
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                // if  obstacle is there
                if(obstacleGrid[i][j]==1) dp[i][j]=0;
                 else if(i==0 && j==0){
                    dp[i][j]=1; // start cell
                }
                else{
                   int fromTop = 0;
                    if (i > 0) {
                        fromTop = dp[i-1][j];
                    }

                    int fromLeft = 0;
                    if (j > 0) {
                        fromLeft = dp[i][j-1];
                    }

                    dp[i][j] = fromTop + fromLeft;
                }
            }
        }
            path=dp[m-1][n-1];
            return path;
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        // if(m==1 && n==1){
        //    if(obstacleGrid[0][0]!=1) return 1;
        //    return 0;
        // }
        int[][] grid=new int[m][n];
        path=0;
        int ans=paths(grid,obstacleGrid,n,m);
        return ans;
    }
}