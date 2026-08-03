class Solution {
    public boolean checkIfExist(int[] arr) {
    //    for(int i=0;i<arr.length;i++){
    //     for(int j=0;j<arr.length;j++){
    //         if(i!=j && arr[i]==2*arr[j]) return true;
    //         }
    //    }
    //    return false;

    // using HashSet
    HashSet<Integer> set=new HashSet<>();
        for(int nums : arr){
            if(set.contains(nums*2) ||
             (nums%2==0 && set.contains(nums/2))) {return true;}

             set.add(nums);
        }
        return false;
    }
}