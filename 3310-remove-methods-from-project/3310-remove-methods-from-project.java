class Solution {
    public List<Integer> remainingMethods(int len, int k, int[][] invocations) {
        // create a graph
        ArrayList<ArrayList<Integer>> graph=new ArrayList<>();
        for(int i=0;i<len;i++){
            graph.add(new ArrayList<>());
        }
        for(int[] ele : invocations){
            graph.get(ele[0]).add(ele[1]);
        }
        // use dfs traversal and mark the node visited from k
        boolean[] visited=new boolean[len];
        Stack<Integer> stack=new Stack<>();
        stack.push(k);
        visited[k]=true;
        while(!stack.isEmpty()){
            int edge=stack.pop();
            for(int neighbours : graph.get(edge)){
                if(!visited[neighbours]){
                visited[neighbours]=true;
                stack.push(neighbours);
                }
            }
        }

        for(int[] ele : invocations){
            int u=ele[0];
            int v=ele[1];
            if(!visited[u] && visited[v]){
                List<Integer> arr=new ArrayList<>();
                for(int i=0;i<len;i++){
                    arr.add(i);
                }
            return arr;
            }
        }

        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<len;i++){
            if(!visited[i]) ans.add(i);
        }
        return ans;
    }
}