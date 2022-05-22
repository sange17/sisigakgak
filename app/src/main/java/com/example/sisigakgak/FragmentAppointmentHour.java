package com.example.sisigakgak;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.NumberPicker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

public class FragmentAppointmentHour extends Fragment {
    private SharedViewModel model;
    Button nextBtn;
    NumberPicker picker;

    // 각 Fragment마다 Instance 반환
    public static FragmentAppointmentHour newInstance(){
        return new FragmentAppointmentHour();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        // Fragment로 불러올 xml 파일을 view로 가져옴.
        View view = inflater.inflate(R.layout.fragment_appointment_hour, null);

        // 휠뷰 스피너
        picker = view.findViewById(R.id.number_picker);
        // 시 목록
        picker.setMinValue(9); // 처음 값
        picker.setMaxValue(17); // 마지막 값
        picker.setWrapSelectorWheel(false); // 휠 순환 제한

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // 다음으로 버튼
        nextBtn = view.findViewById(R.id.btn_next);
        nextBtn.setOnClickListener(e -> {
            // 값 전달할 모델 생성
            model = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);
            // 다음 프래그먼트(화면)으로 값 전달
            model.setHour(picker.getValue());

            // 다음 프래그먼트(화면) 띄우기
            ((AppointmentActivity)getActivity()).change_fragment(FragmentAppointmentMinute.newInstance());
        });
    }
}
