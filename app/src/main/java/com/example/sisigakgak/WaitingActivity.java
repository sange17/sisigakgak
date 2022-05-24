package com.example.sisigakgak;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class WaitingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_waiting);

        // 진료 대기 현황
        TextView waiting = findViewById(R.id.waiting_info);
        waiting.setText("김순자 님 앞에 5명 대기 중입니다.");

        // 다음으로 버튼
        Button nextBtn = findViewById(R.id.btn_next);
        nextBtn.setOnClickListener(e -> {
            // 다음 화면(메인 화면 Activity) 띄우기
            Intent intent = new Intent(WaitingActivity.this, MainActivity.class);
            startActivity(intent);
        });
    }
}
