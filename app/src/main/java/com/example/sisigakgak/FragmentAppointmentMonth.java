package com.example.sisigakgak;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.NumberPicker;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentAppointmentMonth extends Fragment {
    Button nextBtn;
    NumberPicker picker;

    // 각 Fragment마다 Instance 반환
    public static FragmentAppointmentMonth newInstance(){
        return new FragmentAppointmentMonth();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        // Fragment로 불러올 xml 파일을 view로 가져옴.
        View view = inflater.inflate(R.layout.fragment_appointment_month, null);
        nextBtn = view.findViewById(R.id.btn_next);
        // 다음 프래그먼트 띄우기.
        nextBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                ((AppointmentActivity)getActivity()).change_fragment(FragmentAppointmentDay.newInstance());
            }
        });

        // 휠뷰 스피너
        picker = view.findViewById(R.id.number_picker);
        // 월 목록
        picker.setMinValue(4);
        picker.setMaxValue(6);

        return view;
    }
}
