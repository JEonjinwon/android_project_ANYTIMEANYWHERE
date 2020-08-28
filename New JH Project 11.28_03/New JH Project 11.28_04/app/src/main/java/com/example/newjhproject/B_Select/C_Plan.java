package com.example.newjhproject.B_Select;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.newjhproject.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.annotations.Nullable;

public class C_Plan extends AppCompatActivity {
    Button btn_plan1, btn_plan2, btn_plan3;
    EditText edit_plan, edit_plan2;

    // DB 관련 변수
    int ct, ct2;
    Handler mHandler = new Handler() {
        public void handleMessage(Message msg) {
            edit_plan2 = (EditText) findViewById(R.id.edit_plan2);
            edit_plan2.setText(ct + "");
            mHandler.sendEmptyMessageDelayed(10, 100);

            edit_plan = (EditText) findViewById(R.id.edit_plan);
            edit_plan.setText(ct2 + "");

        }
    };
    private DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference("JEON");
    DatabaseReference conditionRef = mRootRef.child("plan");

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.b_plan);

        btn_plan1 = (Button) findViewById(R.id.btn_plan1);
        btn_plan2 = (Button) findViewById(R.id.btn_plan2);
        btn_plan3 = (Button) findViewById(R.id.btn_plan3);


        btn_plan1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                mHandler.sendEmptyMessageDelayed(10, 300);
                if (ct < 9) {
                    ct++;
                } else if (ct == 9) {
                    ct2++;
                    ct = 0;

                }
                return false;
            }
        });


        btn_plan2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                mHandler.sendEmptyMessageDelayed(10, 300);
                if (ct > 0) {
                    ct--;
                } else if (ct == 0) {
                    if (ct2 > 0) {
                        ct2--;
                        ct = 9;
                    }
                }
                return false;
            }
        });

        btn_plan3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(C_Plan.this, (ct2 * 10) + ct + " 걸음 으로 설정 되었습니다.", Toast.LENGTH_SHORT).show();
                conditionRef.setValue((ct2 * 10) + ct);
            }
        });

    }

    private void level_up() {

    }
}