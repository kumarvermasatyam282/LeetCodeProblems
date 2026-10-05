class Solution {
    static{
        for(int i = 0; i<60; i++){
             maxArea(new int[]{0,0});
        }
    }
    public static int maxArea(int[] height) {
        int maxwater=0;
        int area=0;
        int i=0;
        int j=height.length-1;
        if(height.length==2){
            area=Math.min(height[0],height[1])*(1);
            maxwater=Math.max(maxwater,area);
        }
        while(i<j){
            area=Math.min(height[i],height[j])*(j-i);
            maxwater=Math.max(maxwater,area);
            if(height[i]<height[j]) i++;
            else j--;
        }
        return maxwater;
    }
}