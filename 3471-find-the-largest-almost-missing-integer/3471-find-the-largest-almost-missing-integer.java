class Solution {
    public int largestInteger(int[] nums, int k) {
        if(nums.length==0 || k > nums.length) return -1;
        
        HashMap<Integer,HashSet<Integer>> map=new HashMap<>();
       for (int i = 0; i <= nums.length - k; i++) {
            for (int j = i; j < i + k; j++) {
                if (!map.containsKey(nums[j])) {
                    map.put(nums[j], new HashSet<>());  
                }
                map.get(nums[j]).add(i);  
            }
        }

        int max=-1;
        for(int key : map.keySet()){
            if(map.get(key).size()==1){
                max=Math.max(max,key);
            }
        }
        return max;
    }
}