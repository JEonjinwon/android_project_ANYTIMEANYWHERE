package com.example.newjhproject.B_Select;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.newjhproject.A_Sign.A_Loading;
import com.example.newjhproject.C_Strength.A_Select_Strength;
import com.example.newjhproject.D_Cardio.A_Air;
import com.example.newjhproject.R;
import com.google.firebase.auth.FirebaseAuth;

public class A_Select_Cat extends AppCompatActivity {


    Button b_info_cardio, b_info_strength, b_info_level, b_info_motivation, b_info_plan, b_info_calendar, b_info_signout;
    TextView t_info_level, t_info_distance, t_info_workoutday;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.b_select_category);


        b_info_cardio = (Button) findViewById(R.id.b_info_cardio);
        b_info_strength = (Button) findViewById(R.id.b_info_strength);
        b_info_level = (Button) findViewById(R.id.b_info_level);
        b_info_motivation = (Button) findViewById(R.id.b_info_motivation);
        b_info_plan = (Button) findViewById(R.id.b_info_plan);
        b_info_calendar = (Button) findViewById(R.id.b_info_calendar);
        b_info_signout = (Button) findViewById(R.id.b_info_signout);

        b_info_strength.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), A_Select_Strength.class);
                startActivity(intent);
                //finish();
                Log.v("알림", "근력 운동 선택");
            }
        });

        b_info_cardio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), A_Air.class);
                startActivity(intent);
                //finish();
                Log.v("알림", "유산소 운동 선택");
            }
        });

        b_info_signout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                FirebaseAuth.getInstance().signOut();
                Toast.makeText(A_Select_Cat.this, "로그아웃 및 초기 화면으로 이동", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getApplicationContext(), A_Loading.class);
                startActivity(intent);
                //finish();

            }
        });

        b_info_plan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), C_Plan.class);
                startActivity(intent);
                //finish();
                Log.v("알림", "Plan 선택");
            }
        });

        b_info_level.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), E_Level.class);
                startActivity(intent);
                //finish();
                Log.v("알림", "Level 선택");
            }
        });

        b_info_calendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), B_Calendar.class);
                startActivity(intent);
                //finish();
                Log.v("알림", "Calendar 선택");
            }
        });

        b_info_motivation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), D_Recommand.class);
                startActivity(intent);
                //finish();
                Log.v("알림", "Calendar 선택");
            }
        });

    }


}
