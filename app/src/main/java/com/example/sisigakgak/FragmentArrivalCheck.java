package com.example.sisigakgak;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

public class FragmentArrivalCheck extends Fragment {
    Button nextBtn;

    // 각 Fragment마다 Instance 반환
    public static FragmentArrivalCheck newInstance(){
        return new FragmentArrivalCheck();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        // Fragment로 불러올 xml 파일을 view로 가져옴.
        View view = inflater.inflate(R.layout.fragment_arrival_check, null);

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
