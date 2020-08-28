package com.example.newjhproject.C_Strength;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import androidx.appcompat.app.AppCompatActivity;

import com.example.newjhproject.B_Select.F_Work_Out_End;
import com.example.newjhproject.R;

import java.util.Random;

public class A_Select_Strength_Intermediatie extends AppCompatActivity {
    private static final int COUNT_DOWN_INTERVAL = 1000;
    ViewFlipper v_fllipper; // fllipperImages;
    int WORKOUT_COUNTER;
    int WORKOUT_LEVEL = 3;
    int PRESET = WORKOUT_LEVEL;
    private final int MILLISINFUTURE = (PRESET + 1) * 1000;
    int WORKOUT_COUNTER_LOG = 0;

    private int COUNT = PRESET;
    private TextView countTxt;
    private CountDownTimer countDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ca_select_strength_intermediate);

        final TextView workout_count = (TextView) findViewById(R.id.workout_count);

        int images[] = {
                R.drawable.abs2, R.drawable.abs3, R.drawable.abs4, R.drawable.abs5, R.drawable.abs6, R.drawable.abs7,
                R.drawable.quads2, R.drawable.quads3, R.drawable.quads4, R.drawable.quads5, R.drawable.quads6, R.drawable.quads7,
                R.drawable.glutes2, R.drawable.glutes3, R.drawable.glutes4, R.drawable.glutes5, R.drawable.glutes6, R.drawable.glutes7,
                R.drawable.triceps2, R.drawable.triceps3, R.drawable.triceps4, R.drawable.triceps5, R.drawable.triceps6, R.drawable.triceps7,
                R.drawable.back2, R.drawable.back3, R.drawable.back4, R.drawable.back5, R.drawable.back6, R.drawable.back7,
                R.drawable.chest2, R.drawable.chest3, R.drawable.chest4, R.drawable.chest5, R.drawable.chest6, R.drawable.chest7,
                R.drawable.biceps2, R.drawable.biceps3, R.drawable.biceps4, R.drawable.biceps5, R.drawable.biceps6, R.drawable.biceps7
        };

        v_fllipper = findViewById(R.id.image_slide);

        for (int image : images) {
            fllipperImages(image);
        }

        countTxt = (TextView) findViewById(R.id.workout_timer);
        countDownTimer();

        final Button btn_start = (Button) findViewById(R.id.btn_start1);
        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countDownTimer.start();
                Random WR = new Random();
                WORKOUT_COUNTER = WR.nextInt(10) + (20) / 2 + 2;  //횟수 랜덤
                workout_count.setText("횟수 : " + WORKOUT_COUNTER);
            }
        });

        final Button btn_next = (Button) findViewById(R.id.btn_next);
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.v("알림", "WORKOUT_COUNTER_LOG : " + WORKOUT_COUNTER_LOG);
                Log.v("알림", "WORKOUT_LEVEL : " + WORKOUT_LEVEL);
                if (view == btn_next) {
                    v_fllipper.showPrevious();
                    countDownTimer.start();
                    Random WR = new Random();
                    WORKOUT_COUNTER = WR.nextInt(10) + (20) / 2 + 2;  //횟수 랜덤
                    workout_count.setText("횟수 : " + WORKOUT_COUNTER);
                }
            }
        });
    }

    // 이미지 슬라이더 구현 메서드
    public void fllipperImages(int image) {
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(image);

        v_fllipper.addView(imageView);      // 이미지 추가
        Random mRandom = new Random();
        v_fllipper.setDisplayedChild(mRandom.nextInt(400)); //이미지 랜덤
        // v_fllipper.setFlipInterval(100);       // 자동 이미지 슬라이드 딜레이시간(1000 당 1초)
        // v_fllipper.setAutoStart(true);          // 자동 시작 유무 설정
        // animation
        v_fllipper.setInAnimation(this, android.R.anim.slide_in_left);
        v_fllipper.setOutAnimation(this, android.R.anim.slide_out_right);
    }

    public void countDownTimer() {
        countDownTimer = new CountDownTimer(MILLISINFUTURE, COUNT_DOWN_INTERVAL) {
            public void onTick(long millisUntilFinished) {
                countTxt.setText(String.valueOf(COUNT));
                COUNT--;
                final Button btn_start = (Button) findViewById(R.id.btn_start1);
                final Button btn_next = (Button) findViewById(R.id.btn_next);
                btn_start.setClickable(false);
                btn_next.setClickable(false);
            }

            public void onFinish() {
                v_fllipper.stopFlipping();
                countTxt.setText(String.valueOf("다음 운동 시작"));
                COUNT = PRESET;
                Log.v("알림", "WORKOUT_CENTER_LOG : " + WORKOUT_COUNTER_LOG);
                Log.v("알림", "WORKOUT_LEVEL : " + WORKOUT_LEVEL);
                WORKOUT_COUNTER_LOG += 1;
                final Button btn_start = (Button) findViewById(R.id.btn_start1);
                final Button btn_next = (Button) findViewById(R.id.btn_next);
                btn_start.setClickable(false);
                btn_next.setClickable(true);
                if (WORKOUT_COUNTER_LOG > WORKOUT_LEVEL) {
                    Intent intent = new Intent(getApplicationContext(), F_Work_Out_End.class);
                    startActivity(intent);
                    Log.v("알림", "ACTIVITY INTENT");
                }
            }
        };
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        try {
            countDownTimer.cancel();
        } catch (Exception e) {
        }
        countDownTimer = null;
    }
}

