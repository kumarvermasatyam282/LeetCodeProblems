class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n=nums.length;
        int[][] arr=new int[n][2];

        for(int i=0;i<n;i++){
            arr[i][0]=nums[i];
            arr[i][1]=i;
        }
        Arrays.sort(arr,(a,b) -> a[0]-b[0]);

        int left=0;
        while(left < n){
            int right=left+1;
            while(right < n && arr[right][0]-arr[right-1][0]<=limit){
                right++;
            }
            int[] indices=new int[right-left];
            for(int i=left;i<right;i++){
                indices[i-left]=arr[i][1];
            }
            Arrays.sort(indices);
            for(int i=left;i<right;i++){
                nums[indices[i-left]]=arr[i][0];
            }
            left=right;
        }
        return nums;
    }
}