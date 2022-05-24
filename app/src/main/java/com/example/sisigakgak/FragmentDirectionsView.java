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

public class FragmentDirectionsView extends Fragment {
    private SharedViewModel model;
    private TextView titleDirections;

    // 각 Fragment마다 Instance 반환
    public static FragmentDirectionsView newInstance(){
        return new FragmentDirectionsView();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        // Fragment로 불러올 xml 파일을 view로 가져옴.
        View view = inflater.inflate(R.layout.fragment_directions_view, null);

        // 이전에 선택한 값(진료과) 받아오기
        model = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);
        model.getDirectionsDept().observe(getViewLifecycleOwner(), item -> {
            titleDirections = view.findViewById(R.id.title_directions);
            titleDirections.setText(item+titleDirections.getText().toString());

            // 진료과 도착 완료
            Button arrivalBtn = view.findViewById(R.id.btn_next);
            arrivalBtn.setOnClickListener(e -> {
                // 다음 화면(메인 화면 Activity) 띄우기
                Intent intent = new Intent(getActivity(), ArrivalActivity.class);
                intent.putExtra("dept", item);
                startActivity(intent);
            });

        });
        return view;
    }
}
