package com.example.sisigakgak;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.NumberPicker;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentAppointmentDoctor extends Fragment {
    Button nextBtn;
    NumberPicker picker;

    // 각 Fragment마다 Instance 반환
    public static FragmentAppointmentDoctor newInstance(){
        return new FragmentAppointmentDoctor();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        // Fragment로 불러올 xml 파일을 view로 가져옴.
        View view = inflater.inflate(R.layout.fragment_appointment_doctor, null);
        nextBtn = view.findViewById(R.id.btn_next);
        // 다음 프래그먼트 띄우기.
        nextBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                ((AppointmentActivity)getActivity()).change_fragment(FragmentAppointmentMonth.newInstance());
            }
        });

        // 휠뷰 스피너
        picker = view.findViewById(R.id.number_picker);
        // 의사 목록
        String[] data = new String[]{"원의사", "김의사", "권의사", "신의사", "이의사"};
        picker.setMinValue(0);
        picker.setMaxValue(data.length-1);
        picker.setDisplayedValues(data);

        return view;
    }
}
