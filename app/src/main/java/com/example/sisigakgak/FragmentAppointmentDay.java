package com.example.sisigakgak;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.NumberPicker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FragmentAppointmentDay extends Fragment {
    private SharedViewModel model;
    private LinearLayout dayLayout;
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

        // 일 버튼
        dayLayout = view.findViewById(R.id.layout_day);
        for(int i=1; i<=31; i++) {
            Button btnDay = new Button(getContext());
            btnDay.setText(i + "일");
            btnDay.setBackgroundResource(R.drawable.btn_round);
            btnDay.setHeight(250);
            btnDay.setTextSize(35);
            // Margin 추가
            LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            param.topMargin = Math.round(20 * getResources().getDisplayMetrics().density);
            ;
            btnDay.setLayoutParams(param);

            dayLayout.addView(btnDay);
            btnDay.setOnClickListener(e -> {
                // 값 전달할 모델 생성
                model = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);
                // 다음 프래그먼트(화면)으로 값 전달
                model.setDay(Integer.parseInt(String.valueOf(btnDay.getText()).substring(0,btnDay.getText().length()-1)));

                // 다음 프래그먼트(화면) 띄우기
                ((AppointmentActivity) getActivity()).change_fragment(FragmentAppointmentHour.newInstance());
            });
        }
        return view;
    }
}
