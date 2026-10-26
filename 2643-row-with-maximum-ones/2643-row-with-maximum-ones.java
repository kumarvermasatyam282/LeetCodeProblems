class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int[] res=new int[2];
            int maxcount=0;
            int row=0;
        for(int i=0;i<mat.length;i++){
            int count=0;
            for(int j=0;j<mat[i].length;j++){
                count+=mat[i][j];
            }
            if(count > maxcount){
                maxcount=count;
                row=i;
            }
        }
        res[0]=row;
        res[1]=maxcount;
        return res;
    }
}