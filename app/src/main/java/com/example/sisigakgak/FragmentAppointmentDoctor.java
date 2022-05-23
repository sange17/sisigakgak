package com.example.sisigakgak;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import java.util.ArrayList;

public class FragmentAppointmentDoctor extends Fragment {
    private SharedViewModel model;
    private LinearLayout doctorLayout;
    Button nextBtn;
    NumberPicker picker;

    // 각 Fragment마다 Instance 반환
    public static FragmentAppointmentDoctor newInstance(){
        return new FragmentAppointmentDoctor();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        // Fragment로 불러올 xml 파일을 view로 가져옴
        View view = inflater.inflate(R.layout.fragment_appointment_doctor, null);

        // 이전 화면에서 선택한 값(진료과) 받아오기
        model = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);
        model.getDept().observe(getViewLifecycleOwner(), item -> {
            //의사 목록
            String[] doctors = {"원의사", "김의사", "권의사", "신의사", "이의사"};
            doctorLayout = view.findViewById(R.id.layout_doctor);
            for(String doctor : doctors){
                Button btnDoctor = new Button(getContext());
                btnDoctor.setText(doctor);
                btnDoctor.setBackgroundResource(R.drawable.btn_round);
                btnDoctor.setHeight(250);
                btnDoctor.setTextSize(35);
                // Margin 추가
                LinearLayout.LayoutParams param = new LinearLayout.LayoutParams( LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                param.topMargin = Math.round(20 * getResources().getDisplayMetrics().density);;
                btnDoctor.setLayoutParams(param);

                doctorLayout.addView(btnDoctor);
                btnDoctor.setOnClickListener(e -> {
                    // 값 전달할 모델 생성
                    model = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);
                    // 다음 프래그먼트(화면)으로 값 전달
                    model.setDoctor(doctor);

                    // 다음 프래그먼트(화면) 띄우기
                    ((AppointmentActivity)getActivity()).change_fragment(FragmentAppointmentMonth.newInstance());
                });
            }
        });

        return view;
    }
}
