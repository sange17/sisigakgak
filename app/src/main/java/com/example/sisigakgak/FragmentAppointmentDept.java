package com.example.sisigakgak;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.NumberPicker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

public class FragmentAppointmentDept extends Fragment {
    private SharedViewModel model;

    private Button nextBtn;
    private NumberPicker picker;

    // 각 Fragment마다 Instance 반환
    public static FragmentAppointmentDept newInstance(){
        return new FragmentAppointmentDept();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        // Fragment로 불러올 xml 파일을 view로 가져옴.
        View view = inflater.inflate(R.layout.fragment_appointment_dept, null);

        // 휠뷰 피커
        picker = view.findViewById(R.id.number_picker);
        // 진료과 목록
        String[] data = new String[]{"재활의학과", "신경외과", "신경과"};
        picker.setMinValue(0); // 처음 값 index
        picker.setMaxValue(data.length-1); // 마지막 값 index
        picker.setDisplayedValues(data); // index에 해당하는 배열 값
        picker.setWrapSelectorWheel(false); // 휠 순환 제한

        return view;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // 값 전달할 모델 생성
        model = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);

        // 다음으로 버튼
        nextBtn = view.findViewById(R.id.btn_next);
        nextBtn.setOnClickListener(item -> {
            // 다음 프래그먼트(화면)으로 값 전달
            Item inputItem = new Item();
            inputItem.setDept(picker.getDisplayedValues()[picker.getValue()]);
            model.select(inputItem);

            // 다음 화면(프래그먼트) 띄우기
            ((AppointmentActivity)getActivity()).change_fragment(FragmentAppointmentDoctor.newInstance());
        });
    }
}
