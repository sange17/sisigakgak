package com.example.sisigakgak;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SharedViewModel extends ViewModel {
    //로그인
    private final MutableLiveData<CharSequence> mName = new MutableLiveData<>();
    private final MutableLiveData<CharSequence> mBirth = new MutableLiveData<>();
    private final MutableLiveData<CharSequence> mPhone = new MutableLiveData<>();

    // 진료 예약
    private final MutableLiveData<CharSequence> mDept = new MutableLiveData<>();
    private final MutableLiveData<CharSequence> mDoctor = new MutableLiveData<>();
    private final MutableLiveData<Integer> mYear = new MutableLiveData<>();
    private final MutableLiveData<Integer> mMonth = new MutableLiveData<>();
    private final MutableLiveData<Integer> mDay = new MutableLiveData<>();
    private final MutableLiveData<Integer> mHour = new MutableLiveData<>();
    private final MutableLiveData<Integer> mMinute = new MutableLiveData<>();

    // 길 안내
    private final MutableLiveData<CharSequence> mDirectionsDept = new MutableLiveData<>();



    // setData
    public void setName(CharSequence name){ mName.setValue(name); }
    public void setBirth(CharSequence birth){ mBirth.setValue(birth); }
    public void setPhone(CharSequence phone){ mPhone.setValue(phone); }
    public void setDept(CharSequence dept){ mDept.setValue(dept); }
    public void setDoctor(CharSequence doctor){
        mDoctor.setValue(doctor);
    }
    public void setYear(Integer year){ mYear.setValue(year); }
    public void setMonth(Integer month){ mMonth.setValue(month); }
    public void setDay(Integer day){ mDay.setValue(day); }
    public void setHour(Integer hour){ mHour.setValue(hour);}
    public void setMinute(Integer minute){ mMinute.setValue(minute); }
    public void setDirectionsDept(CharSequence directionsdept){ mDirectionsDept.setValue(directionsdept); }

    // getData
    public LiveData<CharSequence> getName(){ return mName; }
    public LiveData<CharSequence> getBirth(){ return mBirth; }
    public LiveData<CharSequence> getPhone(){ return mPhone; }
    public LiveData<CharSequence> getDept(){
        return mDept;
    }
    public LiveData<CharSequence> getDoctor(){
        return mDoctor;
    }
    public LiveData<Integer> getYear(){
        return mYear;
    }
    public LiveData<Integer> getMonth(){
        return mMonth;
    }
    public LiveData<Integer> getDay(){
        return mDay;
    }
    public LiveData<Integer> getHour(){
        return mHour;
    }
    public LiveData<Integer> getMinute(){
        return mMinute;
    }
    public LiveData<CharSequence> getDirectionsDept(){
        return mDirectionsDept;
    }
}
