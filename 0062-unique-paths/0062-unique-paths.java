class Solution {
    static int paths;
    public static int possiblepaths(int[][] grid ,int m,int n){
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 || j==0){
                    grid[i][j]=1;
                }else{
                    grid[i][j]=grid[i-1][j]+grid[i][j-1];
                }
            }
        }
        paths=grid[m-1][n-1];
        return paths;
    }
    public int uniquePaths(int m, int n) {
        int[][] grid=new int[m][n];
        paths=0;
        int result=possiblepaths(grid,m,n);
        return result;

    }
}