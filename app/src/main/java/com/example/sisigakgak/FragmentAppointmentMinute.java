package com.example.sisigakgak;

import android.content.Intent;
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

public class FragmentAppointmentMinute extends Fragment {
    private SharedViewModel model;
    private LinearLayout minuteLayout;

    // 각 Fragment마다 Instance 반환
    public static FragmentAppointmentMinute newInstance(){
        return new FragmentAppointmentMinute();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        // Fragment로 불러올 xml 파일을 view로 가져옴.
        View view = inflater.inflate(R.layout.fragment_appointment_minute, null);

        // 분 버튼
        minuteLayout = view.findViewById(R.id.layout_minute);
        for(int i=5; i<=55; i+=10) {
            Button btnMinute = new Button(getContext());
            btnMinute.setText(i + "분");
            btnMinute.setBackgroundResource(R.drawable.btn_round);
            btnMinute.setHeight(250);
            btnMinute.setTextSize(35);
            // Margin 추가
            LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            param.topMargin = Math.round(20 * getResources().getDisplayMetrics().density);
            ;
            btnMinute.setLayoutParams(param);

            minuteLayout.addView(btnMinute);
            btnMinute.setOnClickListener(e -> {
                // 값 전달할 모델 생성
                model = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);
                // 다음 프래그먼트(화면)으로 값 전달
                model.setMinute(Integer.parseInt(String.valueOf(btnMinute.getText()).substring(0,btnMinute.getText().length()-1)));

                // 다음 화면(프래그먼트) 띄우기
                ((AppointmentActivity)getActivity()).change_fragment(FragmentAppointmentCheck.newInstance());
            });
        }

        return view;
    }
}
