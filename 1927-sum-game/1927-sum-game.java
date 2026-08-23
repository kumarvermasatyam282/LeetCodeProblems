class Solution {
    public boolean sumGame(String num) {
        int sum1=0;
        int sum2=0;
        int mid=num.length()/2;
        int q1=0;
        int q2=0;
        int i=0;
        int j=mid;
        while(i<mid && j<num.length()){
            if(num.charAt(i)=='?') 
                q1++;
            
            else  sum1+=num.charAt(i)-'0';
                
            if(num.charAt(j)=='?') 
                q2++;
         
            else sum2+=num.charAt(j)-'0';
            i++;
            j++;
        }
        int diff=sum1-sum2;
        return 2*diff!=9*(q2-q1);
    }
}