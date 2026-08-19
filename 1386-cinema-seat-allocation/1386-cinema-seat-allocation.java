class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
       for(int[] seat : reservedSeats){
            if(!map.containsKey(seat[0])){
                map.put(seat[0] , new HashSet<>());
            }
            map.get(seat[0]).add(seat[1]);
       }
       int block=0;
       for(int row : map.keySet()){
        Set<Integer> reserved = map.get(row);
        boolean left=!(reserved.contains(2) || reserved.contains(3) || reserved.contains(4) ||
                        reserved.contains(5));
        boolean middle=!(reserved.contains(4) || reserved.contains(5) || reserved.contains(6) ||reserved.contains(7));

        boolean right=!(reserved.contains(6) || reserved.contains(7) || reserved.contains(8) ||reserved.contains(9));

        if(left && right) block+=2;
        else if(left || right || middle) block++;
       }
       block += (n - map.size()) * 2;
       return block;
    }
}