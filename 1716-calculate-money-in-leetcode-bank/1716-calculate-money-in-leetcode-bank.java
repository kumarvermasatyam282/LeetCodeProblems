class Solution {
    public int totalMoney(int n) {
        int weeks=n/7;
        int days=n%7;
        int sum=0;
        for(int i=0;i<weeks;i++){
            for(int j=1;j<=7;j++){
                sum=sum+i+j;
            }
        }
        for(int i=1;i<=days;i++){
            sum=sum+(weeks+i);
        }
        return sum;
    }
}