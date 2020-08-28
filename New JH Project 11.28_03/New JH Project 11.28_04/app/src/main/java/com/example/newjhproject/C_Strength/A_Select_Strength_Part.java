package com.example.newjhproject.C_Strength;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.newjhproject.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class A_Select_Strength_Part extends AppCompatActivity {
    Button abs, quads, glutes, triceps, biceps, back, chest;


    // DB 관련 변수
    private FirebaseDatabase firedatabase = FirebaseDatabase.getInstance();
    private DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference("JEON");


    DatabaseReference conditionRef = mRootRef.child("Strength_Part");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ca_select_strength_part);

        abs = (Button) findViewById(R.id.abs);
        quads = (Button) findViewById(R.id.quads);
        glutes = (Button) findViewById(R.id.glutes);
        triceps = (Button) findViewById(R.id.triceps);
        biceps = (Button) findViewById(R.id.biceps);
        back = (Button) findViewById(R.id.back);
        chest = (Button) findViewById(R.id.chest);

        firedatabase = FirebaseDatabase.getInstance();


        abs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), B_Select_Strength_Part_Abs.class);
                startActivity(intent);
                conditionRef.setValue("abs");
                finish();
                Log.v("알림", "근력 운동 - 파트 - abs");
            }
        });

        quads.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), B_Select_Strength_Part_Quads.class);
                startActivity(intent);
                conditionRef.setValue("quads");
                finish();
                Log.v("알림", "근력 운동 - 파트 - quads");
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), B_Select_Strength_Part_Back.class);
                startActivity(intent);
                conditionRef.setValue("back");
                finish();
                Log.v("알림", "근력 운동 - 파트 - back");
            }
        });

        biceps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), B_Select_Strength_Part_Biceps.class);
                startActivity(intent);
                conditionRef.setValue("biceps");
                finish();
                Log.v("알림", "근력 운동 - 파트 - biceps");
            }
        });

        chest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), B_Select_Strength_Part_Chest.class);
                startActivity(intent);
                conditionRef.setValue("chest");
                finish();
                Log.v("알림", "근력 운동 - 파트 - chest");
            }
        });

        glutes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), B_Select_Strength_Part_Glutes.class);
                startActivity(intent);
                conditionRef.setValue("glutes");
                finish();
                Log.v("알림", "근력 운동 - 파트 - glutes");
            }
        });
        triceps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), B_Select_Strength_Part_Triceps.class);
                startActivity(intent);
                conditionRef.setValue("triceps");
                finish();
                Log.v("알림", "근력 운동 - 파트 - triceps");
            }
        });


    }
}
