class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list=new ArrayList<>();
        Parenthesis(n,0,0,"",list);
        return list;
    }
    public static void Parenthesis(int n , int l , int r ,String s , List<String> list){
        if(r==n && l==n){ 
            list.add(s);
            return;
        }
        if(l<n) Parenthesis(n,l+1,r,s+"(",list);
        if(r<l) Parenthesis(n,l,r+1,s+")",list);
    }
}