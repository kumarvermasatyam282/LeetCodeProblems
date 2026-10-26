class Solution {
    public static int solve(int[] leftmax, int[] rightmax , int[] height){
        int res=0;
        for(int i=0;i<height.length;i++){
            res+=Math.min(leftmax[i],rightmax[i])-height[i];
        }
        return res;
    }
    public static void print(int[] arr){
        for(int ele : arr){
        System.out.print(ele+" ");
        }
        System.out.println();
    }
    public int trap(int[] height) {
        int n=height.length;
        int[] leftmax=new int[n];
        int[] rightmax=new int[n];
        int left=0;
        leftmax[0]=0;
        for(int i=0;i<n;i++){
            if(left <= height[i]){
                left=height[i];
            }
            leftmax[i]=left;
        }
        rightmax[n-1]=0;
        int right = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (right < height[i]) { 
                right = height[i];
            }
            rightmax[i] = right;
        }
        int res=solve(leftmax,rightmax,height);
        return res;
    }
}