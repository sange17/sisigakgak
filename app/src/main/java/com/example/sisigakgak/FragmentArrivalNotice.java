package com.example.sisigakgak;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

public class FragmentArrivalNotice extends Fragment {
    private SharedViewModel model;
    private Button nextBtn;
    private TextView textNotice;

    // 각 Fragment마다 Instance 반환
    public static FragmentArrivalNotice newInstance(){
        return new FragmentArrivalNotice();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        // Fragment로 불러올 xml 파일을 view로 가져옴.
        View view = inflater.inflate(R.layout.fragment_arrival_notice, null);

        // 이전에 선택한 값(진료과) 받아오기
        Intent intent=new Intent(getActivity().getIntent());
        String dept=intent.getStringExtra("dept");
        textNotice = view.findViewById(R.id.arrival_info);
        textNotice.setText(dept+textNotice.getText().toString());

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // 다음으로 버튼
        nextBtn = view.findViewById(R.id.btn_next);
        nextBtn.setOnClickListener(e -> {
            // 다음 화면(프래그먼트) 띄우기
            ((ArrivalActivity)getActivity()).change_fragment(FragmentArrivalCheck.newInstance());
        });
    }
}
