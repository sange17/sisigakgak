package com.example.sisigakgak;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentLoginBirth extends Fragment {
    Button nextBtn;

    public static FragmentLoginBirth newInstance(){
        return new FragmentLoginBirth();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        // Fragment로 불러올 xml 파일을 view로 가져옴.
        View view = inflater.inflate(R.layout.fragment_login_birth, null);
        nextBtn = view.findViewById(R.id.btn_next);
        // 다음 프래그먼트 띄우기.
        nextBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                ((LoginActivity)getActivity()).change_fragment(FragmentLoginPhone.newInstance());
            }
        });
        return view;
    }
}
