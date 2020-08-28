package com.example.newjhproject.B_Select;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;
import com.example.newjhproject.R;

public class F_Work_Out_End extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "ProfileActivity";
    private Button GO_TO_CALENDAR, GO_TO_MAIN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.b_work_out_end);
        ImageView WorkEnd = (ImageView) findViewById(R.id.img_workout_end_gif);
        GlideDrawableImageViewTarget gifImage = new GlideDrawableImageViewTarget(WorkEnd);
        Glide.with(this).load(R.drawable.workout_end_gif).into(gifImage);
        GO_TO_CALENDAR = (Button) findViewById(R.id.GO_TO_CALENDAR);
        GO_TO_MAIN = (Button) findViewById(R.id.GO_TO_MAIN);
        GO_TO_CALENDAR.setOnClickListener(this);
        GO_TO_MAIN.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == GO_TO_CALENDAR) {
            finish();
            startActivity(new Intent(this, B_Calendar.class));
            Log.v("알림", "GO_TO_CALENDAR > CALENDAR ACTIVITY");
        }
        if (view == GO_TO_MAIN) {
            finish();
            startActivity(new Intent(this, A_Select_Cat.class));
            Log.v("알림", "GO_TO_MAIN > SELECT ACTIVITY");
        }
    }
}