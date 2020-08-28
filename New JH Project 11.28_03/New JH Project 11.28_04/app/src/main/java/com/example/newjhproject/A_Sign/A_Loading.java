package com.example.newjhproject.A_Sign;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;
import com.example.newjhproject.R;

public class A_Loading extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_loading);
        ImageView Intro = (ImageView) findViewById(R.id.mr_do_nothing);
        GlideDrawableImageViewTarget gifImage = new GlideDrawableImageViewTarget(Intro);
        Glide.with(this).load(R.drawable.mr_nothing_gif).into(gifImage);
        startLoading();
    }

    private void startLoading() {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(getApplicationContext(), B_Sign_In.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
            }
        }, 3000);
    }
}
