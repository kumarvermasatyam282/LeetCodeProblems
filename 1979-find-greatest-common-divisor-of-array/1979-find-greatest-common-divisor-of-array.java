class Solution {
    public int findGCD(int[] arr) {
        // using Euclid Dividion algorithm
        int n=arr.length;
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            if(arr[i] > max) {
                max=arr[i];
            }
            if(arr[i] < min){
                min=arr[i];
            }
        }
        while(max!=0){
            int temp=max;
            max=min%max;
            min=temp;
        }
        return min;
    }
}