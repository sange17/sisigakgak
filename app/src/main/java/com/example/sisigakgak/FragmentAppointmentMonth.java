package com.example.sisigakgak;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FragmentAppointmentMonth extends Fragment {
    private SharedViewModel model;
    Button nextBtn;
    NumberPicker picker;
    TextView notice;

    // 각 Fragment마다 Instance 반환
    public static FragmentAppointmentMonth newInstance(){
        return new FragmentAppointmentMonth();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        // Fragment로 불러올 xml 파일을 view로 가져옴.
        View view = inflater.inflate(R.layout.fragment_appointment_month, null);

        // 월 목록
        long now = System.currentTimeMillis(); // 현재 시간
        Date mDate = new Date(now);
        SimpleDateFormat simpleDate = new SimpleDateFormat("MM");
        int month = Integer.parseInt(simpleDate.format(mDate));

        // 음성 안내 문구
        notice = view.findViewById(R.id.notice_box);
        notice.setText("예약 가능한 달은"+month+"월부터 "+(month+2)+"월까지입니다. 화면을 위아래로 스크롤하여 월을 선택해주세요.");

        // 휠뷰 스피너
        picker = view.findViewById(R.id.number_picker);
        picker.setMinValue(month); // 처음 값
        picker.setMaxValue(month+2); // 마지막 값
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
            inputItem.setMonth(picker.getValue());
            model.select(inputItem);
//            Toast.makeText(getActivity(), inputItem.getMonth(), Toast.LENGTH_LONG).show();

            // 다음 프래그먼트(화면) 띄우기
            ((AppointmentActivity)getActivity()).change_fragment(FragmentAppointmentDay.newInstance());
        });
    }
}
