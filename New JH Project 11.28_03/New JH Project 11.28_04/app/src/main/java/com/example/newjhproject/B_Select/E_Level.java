package com.example.newjhproject.B_Select;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.newjhproject.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class E_Level extends AppCompatActivity {

    int level, cnt;
    TextView power ;

    Button btn_lv;

    private DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference("JEON");
    DatabaseReference conditionRef = mRootRef.child("Level");
    //TextView power;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.b_level);

        btn_lv = (Button) findViewById(R.id.btn_level);
        power = (TextView)findViewById(R.id.t_power);

        mRootRef.addListenerForSingleValueEvent(new ValueEventListener() {


            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // 데이터를 읽어올 때 모든 데이터를 읽어오기때문에 List 를 초기화해주는 작업이 필요하다.


                for (DataSnapshot messageData : dataSnapshot.getChildren()) {

                    cnt = Integer.parseInt(dataSnapshot.child("step").getValue().toString());

                    level = Integer.parseInt(dataSnapshot.child("Level").getValue().toString());

                    btn_lv.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            level += cnt;
                            conditionRef.setValue(level);

                            if (level <= 3000) {
                                if (level < 300) {
                                    power.setText("경험치 : 0%");
                                    AlertDialog.Builder builder = new AlertDialog.Builder(E_Level.this);
                                    builder.setTitle("본인의 Level");
                                    builder.setMessage("Lv. 브론즈 입니다.")
                                            .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialogInterface, int i) {
                                                    cnt = 0;
                                                }
                                            });
                                    AlertDialog alertDialog = builder.create();
                                    alertDialog.show();
                                } else if (level >= 300 && level < 600) {
                                    power.setText("경험치 : 10%");
                                    AlertDialog.Builder builder = new AlertDialog.Builder(E_Level.this);
                                    builder.setTitle("본인의 Level");
                                    builder.setMessage("Lv. 브론즈 입니다.")
                                            .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialogInterface, int i) {
                                                    cnt = 0;
                                                }
                                            });
                                    AlertDialog alertDialog = builder.create();
                                    alertDialog.show();


                                } else if (level >= 600 && level < 900) {
                                    power.setText("경험치 : 20%");
                                    AlertDialog.Builder builder = new AlertDialog.Builder(E_Level.this);
                                    builder.setTitle("본인의 Level");
                                    builder.setMessage("Lv. 브론즈 입니다.")
                                            .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialogInterface, int i) {
                                                    cnt = 0;
                                                }
                                            });
                                    AlertDialog alertDialog = builder.create();
                                    alertDialog.show();


                                } else if (level >= 900 && level < 1200) {
                                    power.setText("경험치 : 30%");
                                    AlertDialog.Builder builder = new AlertDialog.Builder(E_Level.this);
                                    builder.setTitle("본인의 Level");
                                    builder.setMessage("Lv. 브론즈 입니다.")
                                            .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialogInterface, int i) {
                                                    cnt = 0;
                                                }
                                            });
                                    AlertDialog alertDialog = builder.create();
                                    alertDialog.show();


                                } else if (level >= 1200 && level < 1500) {
                                    power.setText("경험치 : 40%");
                                    AlertDialog.Builder builder = new AlertDialog.Builder(E_Level.this);
                                    builder.setTitle("본인의 Level");
                                    builder.setMessage("Lv. 브론즈 입니다.")
                                            .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialogInterface, int i) {
                                                    cnt = 0;
                                                }
                                            });
                                    AlertDialog alertDialog = builder.create();
                                    alertDialog.show();


                                } else if (level >= 1500 && level < 1800) {
                                    power.setText("경험치 : 50%");
                                    AlertDialog.Builder builder = new AlertDialog.Builder(E_Level.this);
                                    builder.setTitle("본인의 Level");
                                    builder.setMessage("Lv. 브론즈 입니다.")
                                            .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialogInterface, int i) {
                                                    cnt = 0;
                                                }
                                            });
                                    AlertDialog alertDialog = builder.create();
                                    alertDialog.show();


                                } else if (level >= 1800 && level < 2100) {
                                    power.setText("경험치 : 60%");
                                    AlertDialog.Builder builder = new AlertDialog.Builder(E_Level.this);
                                    builder.setTitle("본인의 Level");
                                    builder.setMessage("Lv. 브론즈 입니다.")
                                            .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialogInterface, int i) {
                                                    cnt = 0;
                                                }
                                            });
                                    AlertDialog alertDialog = builder.create();
                                    alertDialog.show();


                                } else if (level >= 2100 && level < 2300) {
                                    power.setText("경험치 : 70%");
                                    AlertDialog.Builder builder = new AlertDialog.Builder(E_Level.this);
                                    builder.setTitle("본인의 Level");
                                    builder.setMessage("Lv. 브론즈 입니다.")
                                            .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialogInterface, int i) {
                                                    cnt = 0;
                                                }
                                            });
                                    AlertDialog alertDialog = builder.create();
                                    alertDialog.show();


                                } else if (level >= 2300 && level < 2500) {
                                    power.setText("경험치 : 80%");
                                    AlertDialog.Builder builder = new AlertDialog.Builder(E_Level.this);
                                    builder.setTitle("본인의 Level");
                                    builder.setMessage("Lv. 브론즈 입니다.")
                                            .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialogInterface, int i) {
                                                    cnt = 0;
                                                }
                                            });
                                    AlertDialog alertDialog = builder.create();
                                    alertDialog.show();


                                } else if (level >= 2500 && level < 2600) {
                                    power.setText("경험치 : 90%");
                                    AlertDialog.Builder builder = new AlertDialog.Builder(E_Level.this);
                                    builder.setTitle("본인의 Level");
                                    builder.setMessage("Lv. 브론즈 입니다.")
                                            .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialogInterface, int i) {
                                                    cnt = 0;
                                                }
                                            });
                                    AlertDialog alertDialog = builder.create();
                                    alertDialog.show();


                                } else if (level >= 2600 && level <= 3000) {
                                    power.setText("경험치 : 99%");
                                    AlertDialog.Builder builder = new AlertDialog.Builder(E_Level.this);
                                    builder.setTitle("본인의 Level");
                                    builder.setMessage("Lv. 브론즈 입니다.")
                                            .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialogInterface, int i) {
                                                    cnt = 0;
                                                }
                                            });
                                    AlertDialog alertDialog = builder.create();
                                    alertDialog.show();


                                }

                            } else if (level > 3000 && level <= 5000) {
                                if (level < 3200) {
                                    power.setText("경험치 : 0%");
                                    AlertDialog.Builder builder = new AlertDialog.Builder(E_Level.this);
                                    builder.setTitle("본인의 Level");
                                    builder.setMessage("Lv. 실버 입니다.")
                                            .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialogInterface, int i) {
                                                    cnt = 0;
                                                }
                                            });
                                    AlertDialog alertDialog = builder.create();
                                    alertDialog.show();
                                } else if (level >= 3200 && level < 3500) {
                                    power.setText("경험치 : 10%");
                                    AlertDialog.Builder builder = new AlertDialog.Builder(E_Level.this);
                                    builder.setTitle("본인의 Level");
                                    builder.setMessage("Lv. 실버 입니다.")
                                            .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialogInterface, int i) {
                                                    cnt = 0;
                                                }
                                            });
                                    AlertDialog alertDialog = builder.create();
                                    alertDialog.show();
                                } else if (level >= 3500 && level < 3700) {
                                    power.setText("경험치 : 20%");
                                    AlertDialog.Builder builder = new AlertDialog.Builder(E_Level.this);
                                    builder.setTitle("본인의 Level");
                                    builder.setMessage("Lv. 실버 입니다.")
                                            .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialogInterface, int i) {
                                                    cnt = 0;
                                                }
                                            });
                                    AlertDialog alertDialog = builder.create();
                                    alertDialog.show();
                                } else if (level >= 3700 && level < 3900) {
                                    power.setText("경험치 : 30%");
                                    AlertDialog.Builder builder = new AlertDialog.Builder(E_Level.this);
                                    builder.setTitle("본인의 Level");
                                    builder.setMessage("Lv. 실버 입니다.")
                                            .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialogInterface, int i) {
                                                    cnt = 0;
                                                }
                                            });
                                    AlertDialog alertDialog = builder.create();
                                    alertDialog.show();
                                } else if (level >= 3900 && level < 4100) {
                                    power.setText("경험치 : 40%");
                                    AlertDialog.Builder builder = new AlertDialog.Builder(E_Level.this);
                                    builder.setTitle("본인의 Level");
                                    builder.setMessage("Lv. 실버 입니다.")
                                            .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialogInterface, int i) {
                                                    cnt = 0;
                                                }
                                            });
                                    AlertDialog alertDialog = builder.create();
                                    alertDialog.show();
                                } else if (level >= 4100 && level < 4200) {
                                    power.setText("경험치 : 50%");
                                    AlertDialog.Builder builder = new AlertDialog.Builder(E_Level.this);
                                    builder.setTitle("본인의 Level");
                                    builder.setMessage("Lv. 실버 입니다.")
                                            .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialogInterface, int i) {
                                                    cnt = 0;
                                                }
                                            });
                                    AlertDialog alertDialog = builder.create();
                                    alertDialog.show();
                                } else if (level >= 4200 && level < 4400) {
                                    power.setText("경험치 : 60%");
                                    AlertDialog.Builder builder = new AlertDialog.Builder(E_Level.this);
                                    builder.setTitle("본인의 Level");
                                    builder.setMessage("Lv. 실버 입니다.")
                                            .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialogInterface, int i) {
                                                    cnt = 0;
                                                }
                                            });
                                    AlertDialog alertDialog = builder.create();
                                    alertDialog.show();
                                } else if (level >= 4400 && level < 4600) {
                                    power.setText("경험치 : 70%");
                                    AlertDialog.Builder builder = new AlertDialog.Builder(E_Level.this);
                                    builder.setTitle("본인의 Level");
                                    builder.setMessage("Lv. 실버 입니다.")
                                            .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialogInterface, int i) {
                                                    cnt = 0;
                                                }
                                            });
                                    AlertDialog alertDialog = builder.create();
                                    alertDialog.show();
                                } else if (level >= 4600 && level < 4750) {
                                    power.setText("경험치 : 80%");
                                    AlertDialog.Builder builder = new AlertDialog.Builder(E_Level.this);
                                    builder.setTitle("본인의 Level");
                                    builder.setMessage("Lv. 실버 입니다.")
                                            .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialogInterface, int i) {
                                                    cnt = 0;
                                                }
                                            });
                                    AlertDialog alertDialog = builder.create();
                                    alertDialog.show();
                                } else if (level >= 4750 && level < 4900) {
                                    power.setText("경험치 : 90%");
                                    AlertDialog.Builder builder = new AlertDialog.Builder(E_Level.this);
                                    builder.setTitle("본인의 Level");
                                    builder.setMessage("Lv. 실버 입니다.")
                                            .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialogInterface, int i) {
                                                    cnt = 0;
                                                }
                                            });
                                    AlertDialog alertDialog = builder.create();
                                    alertDialog.show();
                                } else if (level >= 4900 && level <= 5000) {
                                    power.setText("경험치 : 99%");
                                    AlertDialog.Builder builder = new AlertDialog.Builder(E_Level.this);
                                    builder.setTitle("본인의 Level");
                                    builder.setMessage("Lv. 실버 입니다.")
                                            .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialogInterface, int i) {
                                                    cnt = 0;
                                                }
                                            });
                                    AlertDialog alertDialog = builder.create();
                                    alertDialog.show();
                                }


                            } else if (level > 5000 && level <= 10000) {

                                if (level < 5300) {
                                    power.setText("경험치 : 0%");
                                    AlertDialog.Builder builder = new AlertDialog.Builder(E_Level.this);

                                    builder.setTitle("본인의 Level");
                                    builder.setMessage("Lv. 골드 입니다.")
                                            .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialogInterface, int i) {
                                                    cnt = 0;
                                                }
                                            });


                                    AlertDialog alertDialog = builder.create();

                                    alertDialog.show();
                                } else if (level >= 5300 && level < 5500) {
                                    power.setText("경험치 : 10%");
                                    AlertDialog.Builder builder = new AlertDialog.Builder(E_Level.this);

                                    builder.setTitle("본인의 Level");
                                    builder.setMessage("Lv. 골드 입니다.")
                                            .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialogInterface, int i) {
                                                    cnt = 0;
                                                }
                                            });


                                    AlertDialog alertDialog = builder.create();

                                    alertDialog.show();
                                } else if (level >= 5500 && level < 6000) {
                                    power.setText("경험치 : 20%");
                                    AlertDialog.Builder builder = new AlertDialog.Builder(E_Level.this);

                                    builder.setTitle("본인의 Level");
                                    builder.setMessage("Lv. 골드 입니다.")
                                            .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialogInterface, int i) {
                                                    cnt = 0;
                                                }
                                            });


                                    AlertDialog alertDialog = builder.create();

                                    alertDialog.show();
                                } else if (level >= 6000 && level < 6500) {
                                    power.setText("경험치 : 40%");
                                    AlertDialog.Builder builder = new AlertDialog.Builder(E_Level.this);

                                    builder.setTitle("본인의 Level");
                                    builder.setMessage("Lv. 골드 입니다.")
                                            .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialogInterface, int i) {
                                                    cnt = 0;
                                                }
                                            });


                                    AlertDialog alertDialog = builder.create();

                                    alertDialog.show();
                                } else if (level >= 6500 && level < 7000) {
                                    power.setText("경험치 : 50%");
                                    AlertDialog.Builder builder = new AlertDialog.Builder(E_Level.this);

                                    builder.setTitle("본인의 Level");
                                    builder.setMessage("Lv. 골드 입니다.")
                                            .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialogInterface, int i) {
                                                    cnt = 0;
                                                }
                                            });


                                    AlertDialog alertDialog = builder.create();

                                    alertDialog.show();
                                } else if (level >= 7000 && level < 7500) {
                                    power.setText("경험치 : 60%");
                                    AlertDialog.Builder builder = new AlertDialog.Builder(E_Level.this);

                                    builder.setTitle("본인의 Level");
                                    builder.setMessage("Lv. 골드 입니다.")
                                            .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialogInterface, int i) {
                                                    cnt = 0;
                                                }
                                            });


                                    AlertDialog alertDialog = builder.create();

                                    alertDialog.show();
                                } else if (level >= 7500 && level < 8000) {
                                    power.setText("경험치 : 70%");
                                    AlertDialog.Builder builder = new AlertDialog.Builder(E_Level.this);

                                    builder.setTitle("본인의 Level");
                                    builder.setMessage("Lv. 골드 입니다.")
                                            .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialogInterface, int i) {
                                                    cnt = 0;
                                                }
                                            });


                                    AlertDialog alertDialog = builder.create();

                                    alertDialog.show();
                                } else if (level >= 8000 && level < 8500) {
                                    power.setText("경험치 : 80%");
                                    AlertDialog.Builder builder = new AlertDialog.Builder(E_Level.this);

                                    builder.setTitle("본인의 Level");
                                    builder.setMessage("Lv. 골드 입니다.")
                                            .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialogInterface, int i) {
                                                    cnt = 0;
                                                }
                                            });

                                    AlertDialog alertDialog = builder.create();
                                    alertDialog.show();
                                } else if (level >= 8500 && level < 9000) {
                                    power.setText("경험치 : 90%");
                                    AlertDialog.Builder builder = new AlertDialog.Builder(E_Level.this);

                                    builder.setTitle("본인의 Level");
                                    builder.setMessage("Lv. 골드 입니다.")
                                            .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialogInterface, int i) {
                                                    cnt = 0;
                                                }
                                            });
                                    AlertDialog alertDialog = builder.create();
                                    alertDialog.show();
                                } else if (level >= 9000 && level <= 10000) {
                                    power.setText("경험치 : 99%");
                                    AlertDialog.Builder builder = new AlertDialog.Builder(E_Level.this);

                                    builder.setTitle("본인의 Level");
                                    builder.setMessage("Lv. 골드 입니다.")
                                            .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialogInterface, int i) {
                                                    cnt = 0;
                                                }
                                            });
                                    AlertDialog alertDialog = builder.create();
                                    alertDialog.show();
                                }


                            } else if (level > 10000 && level <= 15000) {

                                if (level < 10300) {
                                    power.setText("경험치 : 0%");
                                    AlertDialog.Builder builder = new AlertDialog.Builder(E_Level.this);
                                    builder.setTitle("본인의 Level");
                                    builder.setMessage("Lv. 플레티넘 입니다.")
                                            .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialogInterface, int i) {
                                                    cnt = 0;
                                                }
                                            });
                                    AlertDialog alertDialog = builder.create();
                                    alertDialog.show();
                                } else if (level >= 10300 && level < 10800) {
                                    power.setText("경험치 : 10%");
                                    AlertDialog.Builder builder = new AlertDialog.Builder(E_Level.this);
                                    builder.setTitle("본인의 Level");
                                    builder.setMessage("Lv. 플레티넘 입니다.")
                                            .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialogInterface, int i) {
                                                    cnt = 0;
                                                }
                                            });
                                    AlertDialog alertDialog = builder.create();
                                    alertDialog.show();
                                } else if (level >= 10800 && level < 11200) {
                                    power.setText("경험치 : 20%");
                                    AlertDialog.Builder builder = new AlertDialog.Builder(E_Level.this);
                                    builder.setTitle("본인의 Level");
                                    builder.setMessage("Lv. 플레티넘 입니다.")
                                            .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialogInterface, int i) {
                                                    cnt = 0;
                                                }
                                            });
                                    AlertDialog alertDialog = builder.create();
                                    alertDialog.show();
                                } else if (level >= 11200 && level < 11600) {
                                    power.setText("경험치 : 30%");
                                    AlertDialog.Builder builder = new AlertDialog.Builder(E_Level.this);
                                    builder.setTitle("본인의 Level");
                                    builder.setMessage("Lv. 플레티넘 입니다.")
                                            .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialogInterface, int i) {
                                                    cnt = 0;
                                                }
                                            });
                                    AlertDialog alertDialog = builder.create();
                                    alertDialog.show();
                                } else if (level >= 11600 && level < 12300) {
                                    power.setText("경험치 : 40%");
                                    AlertDialog.Builder builder = new AlertDialog.Builder(E_Level.this);
                                    builder.setTitle("본인의 Level");
                                    builder.setMessage("Lv. 플레티넘 입니다.")
                                            .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialogInterface, int i) {
                                                    cnt = 0;
                                                }
                                            });
                                    AlertDialog alertDialog = builder.create();
                                    alertDialog.show();
                                } else if (level >= 12300 && level < 13000) {
                                    power.setText("경험치 : 50%");
                                    AlertDialog.Builder builder = new AlertDialog.Builder(E_Level.this);
                                    builder.setTitle("본인의 Level");
                                    builder.setMessage("Lv. 플레티넘 입니다.")
                                            .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialogInterface, int i) {
                                                    cnt = 0;
                                                }
                                            });
                                    AlertDialog alertDialog = builder.create();
                                    alertDialog.show();
                                } else if (level >= 13000 && level < 13500) {
                                    power.setText("경험치 : 60%");
                                    AlertDialog.Builder builder = new AlertDialog.Builder(E_Level.this);
                                    builder.setTitle("본인의 Level");
                                    builder.setMessage("Lv. 플레티넘 입니다.")
                                            .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialogInterface, int i) {
                                                    cnt = 0;
                                                }
                                            });
                                    AlertDialog alertDialog = builder.create();
                                    alertDialog.show();
                                } else if (level >= 13500 && level < 13700) {
                                    power.setText("경험치 : 70%");
                                    AlertDialog.Builder builder = new AlertDialog.Builder(E_Level.this);
                                    builder.setTitle("본인의 Level");
                                    builder.setMessage("Lv. 플레티넘 입니다.")
                                            .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialogInterface, int i) {
                                                    cnt = 0;
                                                }
                                            });
                                    AlertDialog alertDialog = builder.create();
                                    alertDialog.show();
                                } else if (level >= 13700 && level < 14000) {
                                    power.setText("경험치 : 80%");
                                    AlertDialog.Builder builder = new AlertDialog.Builder(E_Level.this);
                                    builder.setTitle("본인의 Level");
                                    builder.setMessage("Lv. 플레티넘 입니다.")
                                            .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialogInterface, int i) {
                                                    cnt = 0;
                                                }
                                            });
                                    AlertDialog alertDialog = builder.create();
                                    alertDialog.show();
                                } else if (level >= 14000 && level < 14500) {
                                    power.setText("경험치 : 90%");
                                    AlertDialog.Builder builder = new AlertDialog.Builder(E_Level.this);
                                    builder.setTitle("본인의 Level");
                                    builder.setMessage("Lv. 플레티넘 입니다.")
                                            .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialogInterface, int i) {
                                                    cnt = 0;
                                                }
                                            });
                                    AlertDialog alertDialog = builder.create();
                                    alertDialog.show();
                                } else if (level >= 14500 && level <= 15000) {
                                    power.setText("경험치 : 99%");
                                    AlertDialog.Builder builder = new AlertDialog.Builder(E_Level.this);
                                    builder.setTitle("본인의 Level");
                                    builder.setMessage("Lv. 플레티넘 입니다.")
                                            .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialogInterface, int i) {
                                                    cnt = 0;
                                                }
                                            });
                                    AlertDialog alertDialog = builder.create();
                                    alertDialog.show();
                                }


                            } else if (level > 15000 && level <= 20000) {
                                if (level < 15300) {
                                    power.setText("경험치 : 0%");
                                    AlertDialog.Builder builder = new AlertDialog.Builder(E_Level.this);
                                    builder.setTitle("본인의 Level");
                                    builder.setMessage("Lv. 다이아 입니다.")
                                            .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialogInterface, int i) {
                                                    cnt = 0;
                                                }
                                            });
                                    AlertDialog alertDialog = builder.create();
                                    alertDialog.show();
                                } else if (level >= 15300 && level < 15600) {
                                    power.setText("경험치 : 10%");
                                    AlertDialog.Builder builder = new AlertDialog.Builder(E_Level.this);
                                    builder.setTitle("본인의 Level");
                                    builder.setMessage("Lv. 다이아 입니다.")
                                            .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialogInterface, int i) {
                                                    cnt = 0;
                                                }
                                            });
                                    AlertDialog alertDialog = builder.create();
                                    alertDialog.show();
                                } else if (level >= 15600 && level < 16000) {
                                    power.setText("경험치 : 20%");
                                    AlertDialog.Builder builder = new AlertDialog.Builder(E_Level.this);
                                    builder.setTitle("본인의 Level");
                                    builder.setMessage("Lv. 다이아 입니다.")
                                            .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialogInterface, int i) {
                                                    cnt = 0;
                                                }
                                            });
                                    AlertDialog alertDialog = builder.create();
                                    alertDialog.show();
                                } else if (level >= 16000 && level < 16400) {
                                    power.setText("경험치 : 30%");
                                    AlertDialog.Builder builder = new AlertDialog.Builder(E_Level.this);
                                    builder.setTitle("본인의 Level");
                                    builder.setMessage("Lv. 다이아 입니다.")
                                            .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialogInterface, int i) {
                                                    cnt = 0;
                                                }
                                            });
                                    AlertDialog alertDialog = builder.create();
                                    alertDialog.show();
                                } else if (level >= 16400 && level < 17000) {
                                    power.setText("경험치 : 40%");
                                    AlertDialog.Builder builder = new AlertDialog.Builder(E_Level.this);
                                    builder.setTitle("본인의 Level");
                                    builder.setMessage("Lv. 다이아 입니다.")
                                            .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialogInterface, int i) {
                                                    cnt = 0;
                                                }
                                            });
                                    AlertDialog alertDialog = builder.create();
                                    alertDialog.show();
                                } else if (level >= 17000 && level < 175000) {
                                    power.setText("경험치 : 50%");
                                    AlertDialog.Builder builder = new AlertDialog.Builder(E_Level.this);
                                    builder.setTitle("본인의 Level");
                                    builder.setMessage("Lv. 다이아 입니다.")
                                            .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialogInterface, int i) {
                                                    cnt = 0;
                                                }
                                            });
                                    AlertDialog alertDialog = builder.create();
                                    alertDialog.show();
                                } else if (level >= 17500 && level < 18000) {
                                    power.setText("경험치 : 60%");
                                    AlertDialog.Builder builder = new AlertDialog.Builder(E_Level.this);
                                    builder.setTitle("본인의 Level");
                                    builder.setMessage("Lv. 다이아 입니다.")
                                            .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialogInterface, int i) {
                                                    cnt = 0;
                                                }
                                            });
                                    AlertDialog alertDialog = builder.create();
                                    alertDialog.show();
                                } else if (level >= 18000 && level < 18500) {
                                    power.setText("경험치 : 70%");
                                    AlertDialog.Builder builder = new AlertDialog.Builder(E_Level.this);
                                    builder.setTitle("본인의 Level");
                                    builder.setMessage("Lv. 다이아 입니다.")
                                            .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialogInterface, int i) {
                                                    cnt = 0;
                                                }
                                            });
                                    AlertDialog alertDialog = builder.create();
                                    alertDialog.show();
                                } else if (level >= 18500 && level < 19000) {
                                    power.setText("경험치 : 80%");
                                    AlertDialog.Builder builder = new AlertDialog.Builder(E_Level.this);
                                    builder.setTitle("본인의 Level");
                                    builder.setMessage("Lv. 다이아 입니다.")
                                            .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialogInterface, int i) {
                                                    cnt = 0;
                                                }
                                            });
                                    AlertDialog alertDialog = builder.create();
                                    alertDialog.show();
                                } else if (level >= 19000 && level < 19500) {
                                    power.setText("경험치 : 90%");
                                    AlertDialog.Builder builder = new AlertDialog.Builder(E_Level.this);
                                    builder.setTitle("본인의 Level");
                                    builder.setMessage("Lv. 다이아 입니다.")
                                            .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialogInterface, int i) {
                                                    cnt = 0;
                                                }
                                            });
                                    AlertDialog alertDialog = builder.create();
                                    alertDialog.show();
                                } else if (level >= 19500 && level <= 20000) {
                                    power.setText("경험치 : 99%");
                                    AlertDialog.Builder builder = new AlertDialog.Builder(E_Level.this);
                                    builder.setTitle("본인의 Level");
                                    builder.setMessage("Lv. 다이아 입니다.")
                                            .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialogInterface, int i) {
                                                    cnt = 0;
                                                }
                                            });
                                    AlertDialog alertDialog = builder.create();
                                    alertDialog.show();


                                }
                            } else if (level > 20000) {
                                power.setText("모든 레벨을 끝내셨습니다.");
                                AlertDialog.Builder builder = new AlertDialog.Builder(E_Level.this);
                                builder.setTitle("본인의 Level");
                                builder.setMessage("Lv. 마스터 입니다.")
                                        .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialogInterface, int i) {
                                                cnt = 0;
                                            }
                                        });
                                AlertDialog alertDialog = builder.create();
                                alertDialog.show();

                            }


                        }
                    });


                }
            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }


}
