package com.scwl.utils;

import java.util.Calendar;
import java.util.Date;

public class DayUtil {

    public static  Date getDay(Date date){
        Calendar cal=Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE,-1);
        return cal.getTime();

    }

   /* public static void main(String[] args) {
        Date day = getDay(new Date());
        System.out.println(day);
    }*/
}
