package com.example.sisigakgak;

public class Item {
    // 진료 예약
    private String mDept;
    private String mDoctor;
    private int mMonth;
    private int mDay;
    private int mHour;
    private int mMinute;

    public void setDept(String dept){
        mDept = dept;
    }
    public void setDoctor(String doctor){
        mDoctor = doctor;
    }
    public void setMonth(int month){
        mMonth = month;
    }
    public void setDay(int day){
        mDay = day;
    }
    public void setHour(int hour){
        mHour = hour;
    }
    public void setMinute(int minute){
        mMinute = minute;
    }

    public String getDept(){
        return mDept;
    }
    public String getDoctor(){
        return mDoctor;
    }
    public int getMonth(){
        return mMonth;
    }
    public int getDay(){
        return mDay;
    }
    public int getHour(){
        return mHour;
    }
    public int getMinute(){
        return mMinute;
    }
}
