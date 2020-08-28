package com.example.newjhproject.D_Cardio;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.example.newjhproject.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class C_Air_Step extends Activity implements SensorEventListener {


    private static final int SHAKE_THRESHOLD = 800;
    private static final int DATA_X = SensorManager.DATA_X;
    private static final int DATA_Y = SensorManager.DATA_Y;
    private static final int DATA_Z = SensorManager.DATA_Z;
    public static int cnt = 0;
    int level;
    int msg;
    double ct;
    private DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference("JEON");
    DatabaseReference conditionRef = mRootRef.child("step");
    private TextView tView, tv_air, db_tv2, db_tv1;
    private Button resetBtn, step_btn;
    private ToggleButton TB;
    private long lastTime;
    private float speed;
    private float lastX;
    private float lastY;
    private float lastZ;
    private float x, y, z;
    private SensorManager sensorManager;
    private Sensor accelerormeterSensor;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.d_air_step);


        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        accelerormeterSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        tView = (TextView) findViewById(R.id.cntView);
        resetBtn = (Button) findViewById(R.id.resetBtn);
        TB = (ToggleButton) findViewById(R.id.start_Btn);
        tv_air = (TextView) findViewById(R.id.tv_air);
        db_tv1 = (TextView) findViewById(R.id.db_tv1);
        db_tv2 = (TextView) findViewById(R.id.db_tv2);
        step_btn = (Button) findViewById(R.id.step_btn);


        mRootRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // 데이터를 읽어올 때 모든 데이터를 읽어오기때문에 List 를 초기화해주는 작업이 필요하다.


                for (DataSnapshot messageData : dataSnapshot.getChildren()) {

                    msg = Integer.parseInt(dataSnapshot.child("plan").getValue().toString());

                    db_tv2.setText("본인 설정 목표 걸음 : " + msg + " 걸음 ");


                }
            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        tView.setText("" + cnt);

    }


    @Override
    public void onStart() {
        super.onStart();
        if (accelerormeterSensor != null)
            sensorManager.registerListener(this, accelerormeterSensor,
                    SensorManager.SENSOR_DELAY_GAME);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (sensorManager != null)
            sensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            long currentTime = System.currentTimeMillis();
            long gabOfTime = (currentTime - lastTime);
            if (gabOfTime > 120) {
                lastTime = currentTime;
                x = event.values[SensorManager.DATA_X];
                y = event.values[SensorManager.DATA_Y];
                z = event.values[SensorManager.DATA_Z];

                speed = Math.abs(x + y + z - lastX - lastY - lastZ) / gabOfTime * 10000;


                if (TB.isChecked()) {


                    if (cnt == 0) {
                        createNotification();
                    }


                    if (speed > SHAKE_THRESHOLD) {
                        tView.setText("" + (++cnt));
                        conditionRef.setValue(cnt);


                        if (msg == cnt) {
                            db_tv2.setText("목표 걸음 " + msg + "를 넘기셨습니다.");

                        }

                        ct = ((cnt * (0.7)) * 100) / 100.0;
                        db_tv1.setText("현재 까지 걸은 거리 : " + ct + "m (1걸음 당 약 70cm)");


                    }
                } else {


                    step_btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            conditionRef.setValue(cnt);
                            Toast.makeText(C_Air_Step.this, "오늘 걸은 수 " + cnt + "를 저장 하였습니다", Toast.LENGTH_SHORT).show();


                        }
                    });

                }

                lastX = event.values[DATA_X];
                lastY = event.values[DATA_Y];
                lastZ = event.values[DATA_Z];
            }
        }
    }


    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    public void mOnClick(View v) {
        switch (v.getId()) {
            case R.id.resetBtn:
                cnt = 0;
                tView.setText("" + cnt);
                break;


        }
    }


    private void createNotification() {

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "default");

        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setContentTitle("걸음 측정 ON");
        builder.setContentText("걸은 측정을 위해 걸음 페이지를 켜세요. ");
        builder.setDefaults(Notification.DEFAULT_VIBRATE);
        builder.setDefaults(Notification.DEFAULT_SOUND);


        builder.setColor(Color.RED);
        // 사용자가 탭을 클릭하면 자동 제거
        builder.setAutoCancel(true);

        // 알림 표시
        NotificationManager notificationManager = (NotificationManager) this.getSystemService(Context.NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            notificationManager.createNotificationChannel(new NotificationChannel("default", "기본 채널", NotificationManager.IMPORTANCE_DEFAULT));
        }

        // id값은
        // 정의해야하는 각 알림의 고유한 int값
        notificationManager.notify(1, builder.build());
    }

    private void noticarion() {
        Intent intent = new Intent(getApplicationContext(), C_Air_Step.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);

    }


    private void removeNotification() {

        // Notification 제거
        NotificationManagerCompat.from(this).cancel(1);
    }
}