class Solution {
    public List<Integer> findMissingElements(int[] arr) {
        List<Integer> list=new ArrayList<>();
        int large=Integer.MIN_VALUE;
        int small=Integer.MAX_VALUE;
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<arr.length;i++){
            if(arr[i] > large) {
                large=arr[i];
            }
            if(arr[i] < small){
                small=arr[i];
            }
            set.add(arr[i]);
        }
        for(int i=small;i<=large;i++){
            if(!set.contains(i)){
                list.add(i);
            }
        }
        return list;
    }
}