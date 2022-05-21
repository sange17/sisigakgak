package com.example.sisigakgak;

public class Item {
    //로그인
    private String mName;
    private String mBirth;
    private String mPhone;

    // 진료 예약
    private String mDept;
    private String mDoctor;
    private int mMonth;
    private int mDay;
    private int mHour;
    private int mMinute;


    public void setName(String name){ mName = name; }
    public void setBirth(String birth){ mBirth = birth; }
    public void setPhone(String phone){ mPhone = phone; }
    public void setDept(String dept){ mDept = dept; }
    public void setDoctor(String doctor){
        mDoctor = doctor;
    }
    public void setMonth(int month){ mMonth = month; }
    public void setDay(int day){ mDay = day; }
    public void setHour(int hour){ mHour = hour;}
    public void setMinute(int minute){ mMinute = minute; }

    public String getName(){ return mName; }
    public String getBirth(){ return mBirth; }
    public String getPhone(){ return mPhone; }
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
