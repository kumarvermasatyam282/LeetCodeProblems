class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n=arr.length;
        int[] best=new int[n];
        Arrays.fill(best,Integer.MAX_VALUE);
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,-1);
        int sum=0;
        int ans=Integer.MAX_VALUE;
        int minlen=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            sum+=arr[i];
            if(map.containsKey(sum-target)){
                int j=map.get(sum-target); 
                int currlen=i-j;
                if(j>=0 && best[j]!=Integer.MAX_VALUE){
                    ans=Math.min(ans,best[j]+currlen);
                }
                minlen=Math.min(minlen,currlen);
            }
            if(i==0){
                best[i]=minlen;
            }else{
                best[i]=Math.min(best[i-1],minlen);
            }
            map.put(sum,i);
        }
        return ans==Integer.MAX_VALUE ?-1:ans;
    }
}