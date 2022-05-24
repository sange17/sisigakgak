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

public class FragmentDirectionsDept extends Fragment {
    private SharedViewModel model;
    private Button dept1;
    private Button dept2;
    private Button dept3;
    private Button dept4;
    private Button dept5;
    private Button dept6;

    // 각 Fragment마다 Instance 반환
    public static FragmentDirectionsDept newInstance(){
        return new FragmentDirectionsDept();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        // Fragment로 불러올 xml 파일을 view로 가져옴.
        View view = inflater.inflate(R.layout.fragment_directions_dept, null);

        return view;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // 값 전달할 모델 생성
        model = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);
        // 진료과 버튼
        dept1 = view.findViewById(R.id.btn_dept1); // 재활의학과
        dept2 = view.findViewById(R.id.btn_dept2); // 신경외과
        dept3 = view.findViewById(R.id.btn_dept3); // 신경과
        dept4 = view.findViewById(R.id.btn_dept4); // 소아청소년과
        dept5 = view.findViewById(R.id.btn_dept5); // 영상의학과
        dept6 = view.findViewById(R.id.btn_dept6); // 정형외과


        dept1.setOnClickListener(item -> {
            // 다음 프래그먼트(화면)으로 값 전달
            model.setDirectionsDept(dept1.getText());
            // 다음 화면(프래그먼트) 띄우기
            ((DirectionsActivity)getActivity()).change_fragment(FragmentDirectionsView.newInstance());
        });
        dept2.setOnClickListener(item -> {
            // 다음 프래그먼트(화면)으로 값 전달
            model.setDirectionsDept(dept2.getText());
            // 다음 화면(프래그먼트) 띄우기
            ((DirectionsActivity)getActivity()).change_fragment(FragmentDirectionsView.newInstance());
        });
        dept3.setOnClickListener(item -> {
            // 다음 프래그먼트(화면)으로 값 전달
            model.setDirectionsDept(dept3.getText());
            // 다음 화면(프래그먼트) 띄우기
            ((DirectionsActivity)getActivity()).change_fragment(FragmentDirectionsView.newInstance());
        });
        dept4.setOnClickListener(item -> {
            // 다음 프래그먼트(화면)으로 값 전달
            model.setDirectionsDept(dept4.getText());
            // 다음 화면(프래그먼트) 띄우기
            ((DirectionsActivity)getActivity()).change_fragment(FragmentDirectionsView.newInstance());
        });
        dept5.setOnClickListener(item -> {
            // 다음 프래그먼트(화면)으로 값 전달
            model.setDirectionsDept(dept5.getText());
            // 다음 화면(프래그먼트) 띄우기
            ((DirectionsActivity)getActivity()).change_fragment(FragmentDirectionsView.newInstance());
        });
        dept6.setOnClickListener(item -> {
            // 다음 프래그먼트(화면)으로 값 전달
            model.setDirectionsDept(dept6.getText());
            // 다음 화면(프래그먼트) 띄우기
            ((DirectionsActivity)getActivity()).change_fragment(FragmentDirectionsView.newInstance());
        });
    }
}
