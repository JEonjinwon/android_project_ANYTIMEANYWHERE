package com.example.newjhproject.B_Select;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.newjhproject.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class D_Recommand extends AppCompatActivity {

    ImageView reco_iv;
    TextView name;

    String im;
    private DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference("JEON");

    //  DatabaseReference conditionRef = mRootRef.child("Strength_Part");


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.b_recommand);

        reco_iv = (ImageView) findViewById(R.id.reco_iv);
        name = (TextView) findViewById(R.id.name);


        mRootRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // 데이터를 읽어올 때 모든 데이터를 읽어오기때문에 List 를 초기화해주는 작업이 필요하다.


                for (DataSnapshot messageData : dataSnapshot.getChildren()) {

                    im = (dataSnapshot.child("Strength_Part").getValue().toString());


                    if (im.equals("abs")) {
                        reco_iv.setImageResource(R.drawable.quads1);
                        name.setText("허벅지");
                    } else if (im.equals("quads")) {
                        reco_iv.setImageResource(R.drawable.chest1);
                        name.setText("가슴");
                    } else if (im.equals("glutes")) {
                        reco_iv.setImageResource(R.drawable.biceps1);
                        name.setText("이두박근");

                    } else if (im.equals("triceps")) {
                        reco_iv.setImageResource(R.drawable.abs1);
                        name.setText("복근");

                    } else if (im.equals("biceps")) {
                        reco_iv.setImageResource(R.drawable.back1);
                        name.setText("등");

                    } else if (im.equals("back")) {
                        reco_iv.setImageResource(R.drawable.glutes1);
                        name.setText("엉덩이");

                    } else if (im.equals("chest")) {
                        reco_iv.setImageResource(R.drawable.triceps1);
                        name.setText("삼두근");

                    }


                }
            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}