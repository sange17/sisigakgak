package com.example.sisigakgak;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import java.util.ArrayList;

public class FragmentAppointmentDoctor extends Fragment {
    private SharedViewModel model;
    Button nextBtn;
    NumberPicker picker;
    String dept;

    // 각 Fragment마다 Instance 반환
    public static FragmentAppointmentDoctor newInstance(){
        return new FragmentAppointmentDoctor();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        // Fragment로 불러올 xml 파일을 view로 가져옴
        View view = inflater.inflate(R.layout.fragment_appointment_doctor, null);

        // 값 전달할 모델 생성
        model = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);

        // 이전 화면에서 선택한 값(진료과) 받아오기
        SharedViewModel model = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);
        model.getSelected().observe(getViewLifecycleOwner(), item -> {
            dept = item.getDept();

            //의사 목록
            String[] doctors = {"원의사", "김의사", "권의사", "신의사", "이의사"};

            // 휠뷰 스피너
            picker = view.findViewById(R.id.number_picker);
            picker.setMinValue(0); // 처음 값 index
            picker.setMaxValue(doctors.length-1); // 마지막 값 index
            picker.setDisplayedValues(doctors); // index에 해당하는 배열 값
            picker.setWrapSelectorWheel(false); // 휠 순환 제한

        });

        return view;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // 값 전달할 모델 생성
        model = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);

        // 다음으로 버튼
        nextBtn = view.findViewById(R.id.btn_next);
        nextBtn.setOnClickListener(e -> {
            // 다음 프래그먼트(화면)으로 값 전달
            Item inputItem = new Item();
            inputItem.setDoctor(picker.getDisplayedValues()[picker.getValue()]);
            model.select(inputItem);
//            Toast.makeText(getActivity(), inputItem.getDoctor(), Toast.LENGTH_LONG).show();

            // 다음 프래그먼트(화면) 띄우기
                ((AppointmentActivity)getActivity()).change_fragment(FragmentAppointmentMonth.newInstance());
        });
    }
}
