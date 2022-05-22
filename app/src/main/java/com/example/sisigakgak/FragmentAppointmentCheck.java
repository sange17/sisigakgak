package com.example.sisigakgak;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

public class FragmentAppointmentCheck extends Fragment {
    private SharedViewModel model;
    Button nextBtn;
    TextView appointmentCheck;

    // 각 Fragment마다 Instance 반환
    public static FragmentAppointmentCheck newInstance(){
        return new FragmentAppointmentCheck();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        // Fragment로 불러올 xml 파일을 view로 가져옴.
        View view = inflater.inflate(R.layout.fragment_appointment_check, null);

        // 예약 정보
        appointmentCheck = view.findViewById(R.id.appointment_info);

        // 선택한 값들 받아오기
        model = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);
        model.getDept().observe(getViewLifecycleOwner(), dept -> {
            appointmentCheck.setText(dept+" ");
        });
        model.getDoctor().observe(getViewLifecycleOwner(), doctor -> {
            appointmentCheck.setText(appointmentCheck.getText()+doctor.toString()+" 의사\n");
        });
        model.getMonth().observe(getViewLifecycleOwner(), month -> {
            appointmentCheck.setText(appointmentCheck.getText()+"2022년 "+month.toString()+"월 ");
        });
        model.getDay().observe(getViewLifecycleOwner(), day -> {
            appointmentCheck.setText(appointmentCheck.getText()+day.toString()+"일 ");
        });
        model.getHour().observe(getViewLifecycleOwner(), hour -> {
            appointmentCheck.setText(appointmentCheck.getText()+hour.toString()+"시 ");
        });
        model.getMinute().observe(getViewLifecycleOwner(), minute -> {
            appointmentCheck.setText(appointmentCheck.getText()+minute.toString()+"분에\n예약되었습니다.");
        });

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // 다음으로 버튼
        nextBtn = view.findViewById(R.id.btn_next);
        nextBtn.setOnClickListener(e -> {
            // 다음 화면(메인 화면 Activity) 띄우기
            Intent intent = new Intent(getActivity(), MainActivity.class);
            startActivity(intent);
        });
    }
}
