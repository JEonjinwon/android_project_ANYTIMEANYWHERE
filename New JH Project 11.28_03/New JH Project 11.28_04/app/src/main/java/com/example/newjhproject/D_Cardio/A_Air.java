package com.example.newjhproject.D_Cardio;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.newjhproject.R;

public class A_Air extends AppCompatActivity {
    Button btn_gmap, btn_airstep;
    int cnt;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.d_air);
        btn_gmap = (Button) findViewById(R.id.btn_gmap);
        btn_airstep = (Button) findViewById(R.id.btn_airstep);
        btn_gmap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), B_Air_GoogleMap.class);
                startActivity(intent);
            }
        });

        btn_airstep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), C_Air_Step.class);
                startActivity(intent);
            }
        });
    }
}