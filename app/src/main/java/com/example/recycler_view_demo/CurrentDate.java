package com.example.recycler_view_demo;

import java.util.Date;

public class CurrentDate {
    Date date = new Date();
    public String formatedDate(){
        return getDay()+"/"+getMonth()+"/"+getYear();
    }
    private String getDay(){
        int i = date.getDate();
        return Integer.toString( i );
    }
    private String getMonth(){
        int i = date.getMonth()+1;
        return Integer.toString( i );    }
    private String getYear(){
        int i = date.getYear()+1900;
        return Integer.toString( i );
    }

}
