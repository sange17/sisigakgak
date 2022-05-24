package com.example.sisigakgak;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 진료 예약
        Button appointmentBtn = (Button) findViewById(R.id.appointment);
        appointmentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AppointmentActivity.class);
                startActivity(intent);
            }
        });

        // 진료과 길 안내
        Button directionsBtn = (Button) findViewById(R.id.directions);
        directionsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DirectionsActivity.class);
                startActivity(intent);
            }
        });

        // 도착 확인
        Button arrivalBtn = (Button) findViewById(R.id.arrival);
        arrivalBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ArrivalActivity.class);
                startActivity(intent);
            }
        });
    }
}