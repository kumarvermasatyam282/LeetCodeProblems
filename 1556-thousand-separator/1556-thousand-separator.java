class Solution {
    public String thousandSeparator(int n) {
        String s=String.valueOf(n);
        if(s.length()==3) return s;
        StringBuilder ans=new StringBuilder();
        int place=0;
        for(int i=s.length()-1;i>=0;i--){
                ans.append(s.charAt(i));
                place++;
                if(place==3 && i!=0){
                    ans.append('.');
                    place=0;
             }
            
        }
        return ans.reverse().toString(); 
    }
}