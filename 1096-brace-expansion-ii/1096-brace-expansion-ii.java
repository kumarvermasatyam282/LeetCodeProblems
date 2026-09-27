class Solution {
    int index=0;
    public List<String> braceExpansionII(String expression) {
        Set<String> result=parse(expression);
        List<String> ans=new ArrayList<>(result);
        Collections.sort(ans);
        return ans;
    }
    public Set<String> parse(String s){
        Set<String> result=new HashSet<>();

        while(index < s.length() && s.charAt(index)!='}'){
            Set<String> current;
            if(s.charAt(index)=='{'){
                index++;
                current=parse(s);
                index++;
            }
            else{
                current = new HashSet<>();
                current.add(String.valueOf(s.charAt(index)));
                index++;
            }
            if(result.isEmpty()){
                result.addAll(current);
            }else{
                Set<String> temp=new HashSet<>();
                for(String a: result){
                    for(String b : current){
                        temp.add(a+b);
                    }
                }
                result=temp;
            }
            if(index<s.length() && s.charAt(index)==','){
                index++;
                Set<String> next=parse(s);
                result.addAll(next);
                break;
            }
        }
        return result;
    }
}