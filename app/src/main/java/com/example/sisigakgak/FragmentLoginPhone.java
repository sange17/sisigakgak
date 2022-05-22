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

public class FragmentLoginPhone extends Fragment {
    private SharedViewModel model;
    Button nextBtn;
    TextView inputPhone;

    public static FragmentLoginPhone newInstance(){
        return new FragmentLoginPhone();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        // Fragment로 불러올 xml 파일을 view로 가져옴.
        View view = inflater.inflate(R.layout.fragment_login_phone, null);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // 음성 인식 - 전화번호
        inputPhone = view.findViewById(R.id.text_name);
        // 다음으로 버튼
        nextBtn = view.findViewById(R.id.btn_next);
        nextBtn.setOnClickListener(item -> {
            // 값 전달할 모델 생성
            model = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);
            // 다음 프래그먼트(화면)으로 값 전달
            model.setPhone(inputPhone.getText());

            // 다음 화면(프래그먼트) 띄우기
            Intent intent = new Intent(getActivity(), MainActivity.class);
            startActivity(intent);
        });
    }
}
