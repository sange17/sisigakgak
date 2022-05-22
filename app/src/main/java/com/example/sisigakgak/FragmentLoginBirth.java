package com.example.sisigakgak;

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

public class FragmentLoginBirth extends Fragment {
    private SharedViewModel model;
    Button nextBtn;
    TextView inputBirth;

    public static FragmentLoginBirth newInstance(){
        return new FragmentLoginBirth();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        // Fragment로 불러올 xml 파일을 view로 가져옴.
        View view = inflater.inflate(R.layout.fragment_login_birth, null);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // 음성 인식 - 주민등록번호
        inputBirth = view.findViewById(R.id.text_name);
        // 다음으로 버튼
        nextBtn = view.findViewById(R.id.btn_next);
        nextBtn.setOnClickListener(item -> {
            // 값 전달할 모델 생성
            model = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);
            // 다음 프래그먼트(화면)으로 값 전달
            model.setBirth(inputBirth.getText().toString());

            // 다음 화면(프래그먼트) 띄우기
            ((LoginActivity)getActivity()).change_fragment(FragmentLoginPhone.newInstance());
        });
    }
}
