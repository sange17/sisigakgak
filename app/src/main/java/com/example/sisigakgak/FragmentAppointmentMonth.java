package com.example.sisigakgak;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FragmentAppointmentMonth extends Fragment {
    private SharedViewModel model;
    private LinearLayout monthLayout;

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
        SimpleDateFormat monthDate = new SimpleDateFormat("MM");
        SimpleDateFormat yearDate = new SimpleDateFormat("yyyy");
        int year = Integer.parseInt(yearDate.format(mDate));
        int month = Integer.parseInt(monthDate.format(mDate));

        // 음성 안내 문구
        notice = view.findViewById(R.id.notice_box);
        notice.setText("예약 가능한 달은"+month+"월부터 "+(month+2)+"월까지입니다. 화면을 위아래로 스크롤하여 월을 선택해주세요.");

        // 월 버튼
        monthLayout = view.findViewById(R.id.layout_month);
        for(int i=0; i<3; i++){
            Button btnMonth = new Button(getContext());
            btnMonth.setText((month+i)+"월");
            btnMonth.setBackgroundResource(R.drawable.btn_round);
            btnMonth.setHeight(250);
            btnMonth.setTextSize(35);
            // Margin 추가
            LinearLayout.LayoutParams param = new LinearLayout.LayoutParams( LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            param.topMargin = Math.round(20 * getResources().getDisplayMetrics().density);;
            btnMonth.setLayoutParams(param);

            monthLayout.addView(btnMonth);
            btnMonth.setOnClickListener(e -> {
                // 값 전달할 모델 생성
                model = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);
                // 다음 프래그먼트(화면)으로 값 전달
                model.setYear(year);
                model.setMonth(Integer.parseInt(String.valueOf(btnMonth.getText()).substring(0,btnMonth.getText().length()-1)));

                // 다음 프래그먼트(화면) 띄우기
                ((AppointmentActivity)getActivity()).change_fragment(FragmentAppointmentDay.newInstance());
            });
        }

        return view;
    }
}
