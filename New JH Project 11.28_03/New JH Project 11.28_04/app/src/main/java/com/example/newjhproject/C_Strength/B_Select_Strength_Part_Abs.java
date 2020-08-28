package com.example.newjhproject.C_Strength;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

import com.example.newjhproject.R;

public class B_Select_Strength_Part_Abs extends AppCompatActivity {

    RadioGroup R_group;
    RadioButton R_btn1, R_btn2, R_btn3, R_btn4, R_btn5, R_btn6;
    Button btn;
    ImageView img;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cb_select_strength_part_abs);
        R_group = (RadioGroup) findViewById(R.id.Rgroup);

        R_btn1 = (RadioButton) findViewById(R.id.btn1);
        R_btn2 = (RadioButton) findViewById(R.id.btn2);
        R_btn3 = (RadioButton) findViewById(R.id.btn3);
        R_btn4 = (RadioButton) findViewById(R.id.btn4);
        R_btn5 = (RadioButton) findViewById(R.id.btn5);
        R_btn6 = (RadioButton) findViewById(R.id.btn6);


        btn = (Button) findViewById(R.id.button);
        img = (ImageView) findViewById(R.id.imageView);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (R_group.getCheckedRadioButtonId()) {
                    case R.id.btn1:
                        img.setImageResource(R.drawable.abs2);
                        break;
                    case R.id.btn2:
                        img.setImageResource(R.drawable.abs3);
                        break;
                    case R.id.btn3:
                        img.setImageResource(R.drawable.abs4);
                        break;
                    case R.id.btn4:
                        img.setImageResource(R.drawable.abs5);
                        break;
                    case R.id.btn5:
                        img.setImageResource(R.drawable.abs6);
                        break;
                    case R.id.btn6:
                        img.setImageResource(R.drawable.abs7);
                        break;
                }
            }
        });

    }
}