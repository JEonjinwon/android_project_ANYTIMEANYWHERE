package com.example.newjhproject.C_Strength;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.newjhproject.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class A_Select_Strength extends AppCompatActivity {

    Button c_begin, c_inter, c_part;
    int level;
    private DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference("JEON");
    DatabaseReference conditionRef = mRootRef.child("오늘 걸은 수");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ca_select_strength);


        c_begin = (Button) findViewById(R.id.c_begin);
        c_inter = (Button) findViewById(R.id.c_inter);
        c_part = (Button) findViewById(R.id.c_part);

        Button c_begin = (Button) findViewById(R.id.c_begin);
        Button c_inter = (Button) findViewById(R.id.c_inter);
        Button c_part = (Button) findViewById(R.id.c_part);

        c_begin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), A_Select_Strength_Beginner.class);
                startActivity(intent);
                //finish();
                Log.v("알림", "근력 운동 - 초보자 선택");

            }
        });


        c_inter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mRootRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        for (DataSnapshot messageData : dataSnapshot.getChildren()) {
                            level = Integer.parseInt(dataSnapshot.child("Level").getValue().toString());

                            if (level >= 10000) {
                                Intent intent = new Intent(getApplicationContext(), A_Select_Strength_Intermediatie.class);
                                startActivity(intent);
                                //finish();
                                Log.v("알림", "근력 운동 - 상급자 선택");
                            } else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(A_Select_Strength.this);

                                builder.setTitle("레벨 제한 ");
                                builder.setMessage("Lv. 플레티넘 부터 입장이 가능합니다.")
                                        .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialogInterface, int i) {

                                            }
                                        });


                                AlertDialog alertDialog = builder.create();

                                alertDialog.show();

                            }


                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });


            }
        });


        c_part.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), A_Select_Strength_Part.class);
                startActivity(intent);
                //finish();
                Log.v("알림", "근력 운동 - 파트 선택");

            }
        });


    }
}