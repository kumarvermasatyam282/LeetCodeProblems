class Solution {
    public boolean stoneGameIX(int[] stones) {
        int n=stones.length;
        int[] count=new int[3];
        for(int i=0;i<n;i++){
            int rem=stones[i]%3;
            count[rem]++;
        }

        if(count[0]%2==0){
            return count[1] >0 && count[2]>0;
        }
        else 
            return Math.abs(count[1]-count[2])>2;

    }
}