package com.example.sisigakgak;

import android.os.Bundle;
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

public class FragmentAppointmentHour extends Fragment {
    private SharedViewModel model;
    private LinearLayout hourLayout;

    // 각 Fragment마다 Instance 반환
    public static FragmentAppointmentHour newInstance(){
        return new FragmentAppointmentHour();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        // Fragment로 불러올 xml 파일을 view로 가져옴.
        View view = inflater.inflate(R.layout.fragment_appointment_hour, null);

        // 시 버튼
        hourLayout = view.findViewById(R.id.layout_hour);
        for(int i=9; i<=17; i++) {
            Button btnHour = new Button(getContext());
            btnHour.setText(i + "시");
            btnHour.setBackgroundResource(R.drawable.btn_round);
            btnHour.setHeight(250);
            btnHour.setTextSize(35);
            // Margin 추가
            LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            param.topMargin = Math.round(20 * getResources().getDisplayMetrics().density);
            ;
            btnHour.setLayoutParams(param);

            hourLayout.addView(btnHour);
            btnHour.setOnClickListener(e -> {
                // 값 전달할 모델 생성
                model = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);
                // 다음 프래그먼트(화면)으로 값 전달
                model.setHour(Integer.parseInt(String.valueOf(btnHour.getText()).substring(0,btnHour.getText().length()-1)));

                // 다음 프래그먼트(화면) 띄우기
                ((AppointmentActivity) getActivity()).change_fragment(FragmentAppointmentMinute.newInstance());
            });
        }

        return view;
    }
}
