package com.example.sisigakgak;

import android.content.Intent;
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

public class FragmentAppointmentMinute extends Fragment {
    private SharedViewModel model;
    Button nextBtn;
    NumberPicker picker;

    // 각 Fragment마다 Instance 반환
    public static FragmentAppointmentMinute newInstance(){
        return new FragmentAppointmentMinute();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        // Fragment로 불러올 xml 파일을 view로 가져옴.
        View view = inflater.inflate(R.layout.fragment_appointment_minute, null);

        // 휠뷰 스피너
        picker = view.findViewById(R.id.number_picker);
        // 분 목록
        picker.setMinValue(0); // 처음 값
        picker.setMaxValue(59); // 마지막 값
        picker.setWrapSelectorWheel(false); // 휠 순환 제한

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
            inputItem.setMinute(picker.getValue());
            model.select(inputItem);
//            Toast.makeText(getActivity(), inputItem.getMinute(), Toast.LENGTH_LONG).show();

            // 다음 화면(메인 화면 Activity) 띄우기
            Intent intent = new Intent(getActivity(), MainActivity.class);
            startActivity(intent);
        });
    }
}
