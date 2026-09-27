class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        int n=s.length();
        HashMap<String , String > map =new HashMap<>();
        for(List<String> ele : knowledge){
            map.put(ele.get(0) ,ele.get(1));
        }
        String result="";
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='('){
                int j=i+1;
                String ans="";
                while( j<n &&s.charAt(j)!=')'){
                    ans+=s.charAt(j);
                    j++;
                }
            if(map.containsKey(ans)) result+=map.get(ans);
            else if(!map.containsKey(ans)) result+="?";
            i=j;
            }
            else result+=s.charAt(i);
        }
        return result;
    }
}