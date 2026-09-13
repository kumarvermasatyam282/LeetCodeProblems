class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        HashMap<String ,Integer> map=new HashMap<>();
        ArrayList<int[]> i1=new ArrayList<>();
        ArrayList<int[]> i2=new ArrayList<>();
        for(int i=0;i<img1.length;i++){
            for(int j=0;j<img1[0].length;j++){
                if(img1[i][j]==1) i1.add(new int[]{i,j});
            }
        }
        for(int i=0;i<img2.length;i++){
            for(int j=0;j<img2[0].length;j++){
                if(img2[i][j]==1) i2.add(new int[]{i,j});
            }
        }
        int overlap=0;
        for(int []e1 : i1){
            for(int[] e2 : i2){
                int dx=e1[0]-e2[0];
                int dy=e1[1]-e2[1];
                String coordinate=dx+","+dy;
                map.put(coordinate,map.getOrDefault(coordinate,0)+1);
                overlap=Math.max(overlap,map.get(coordinate));
            }
        }
        return overlap;
    }
}