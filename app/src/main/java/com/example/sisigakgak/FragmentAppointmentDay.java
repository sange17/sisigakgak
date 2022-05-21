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

import java.text.SimpleDateFormat;
import java.util.Date;

public class FragmentAppointmentDay extends Fragment {
    private SharedViewModel model;
    Button nextBtn;
    NumberPicker picker;

    // 각 Fragment마다 Instance 반환
    public static FragmentAppointmentDay newInstance(){
        return new FragmentAppointmentDay();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        // Fragment로 불러올 xml 파일을 view로 가져옴.
        View view = inflater.inflate(R.layout.fragment_appointment_day, null);

        // 이전 화면에서 선택한 값(월) 받아오기
        SharedViewModel model = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);
        model.getSelected().observe(getViewLifecycleOwner(), item -> {
            int month = item.getMonth();

            // 휠뷰 스피너
            picker = view.findViewById(R.id.number_picker);
            // 일 목록
            long now = System.currentTimeMillis(); // 현재 시간
            Date mDate = new Date(now);
            SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy");
            int year = Integer.parseInt(simpleDate.format(mDate));

            picker.setMinValue(1); // 처음 값
            if((month<8 && month%2 != 0) || (month>8 && month%2 == 0)){
                picker.setMaxValue(31); // 마지막 값
            }else if(month == 2){ // 윤년 계산
                if(year%4 == 0){
                    picker.setMaxValue(29);
                }else{
                    picker.setMaxValue(28);
                }
            }else{
                picker.setMaxValue(30);
            }
            picker.setWrapSelectorWheel(false); // 휠 순환 제한

        });

        return view;
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // 값 전달할 모델 생성
        model = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);

        // 다음으로 버튼
        nextBtn = view.findViewById(R.id.btn_next);
        nextBtn.setOnClickListener(e -> {
            // 다음 프래그먼트(화면)으로 값 전달
            Item inputItem = new Item();
            inputItem.setDay(picker.getValue());
            model.select(inputItem);
//            Toast.makeText(getActivity(), inputItem.getDay(), Toast.LENGTH_LONG).show();

            // 다음 프래그먼트(화면) 띄우기
            ((AppointmentActivity)getActivity()).change_fragment(FragmentAppointmentHour.newInstance());
        });
    }
}
