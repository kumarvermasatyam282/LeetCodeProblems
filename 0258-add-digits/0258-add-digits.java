class Solution {
    public int addDigits(int num) {
        while(num >= 10){
           int digit=0;
           int sum=0;
           while(num > 0){
            digit=num%10;
            sum+=digit;
            num=num/10;
           }
           num=sum;
        }
        return num;
    }
}