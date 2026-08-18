class Solution {
    public int dayOfYear(String date) {
        String[] time=date.split("-");
        int year=Integer.parseInt(time[0]);
        int month=Integer.parseInt(time[1]);
        int datenum=Integer.parseInt(time[2]);
        boolean isLeapYear=false;
        int totaldays=0;
        int[] daysarr={31,28,31,30,31,30,31,31,30,31,30,31};
        if(year%400==0 || (year%4==0 && year%100!=0)){
            daysarr[1]=29;
        }
        int prevdays=0;
        for(int i=0;i<month-1;i++){
             prevdays+=daysarr[i];
        }
        totaldays=prevdays+datenum;
        return totaldays;
    }
}