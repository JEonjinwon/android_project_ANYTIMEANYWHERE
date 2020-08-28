package com.example.newjhproject.A_Sign;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.newjhproject.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class D_Find extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "FindActivity";

    //define view objects
    private EditText editTextUserEmail;
    private Button buttonFind;
    private TextView textviewMessage;
    private ProgressDialog progressDialog;
    //define firebase object
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_find);

        Log.v("알림", "activity_find 시작");

        editTextUserEmail = (EditText) findViewById(R.id.editTextUserEmail);
        buttonFind = (Button) findViewById(R.id.buttonFind);
        progressDialog = new ProgressDialog(this);
        firebaseAuth = FirebaseAuth.getInstance();

        buttonFind.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if (view == buttonFind) {
            progressDialog.setMessage("처리중입니다. 잠시 기다려 주세요...");
            progressDialog.show();
            //비밀번호 재설정 이메일 보내기
            String emailAddress = editTextUserEmail.getText().toString().trim();
            firebaseAuth.sendPasswordResetEmail(emailAddress)
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(D_Find.this, "이메일을 보냈습니다.", Toast.LENGTH_LONG).show();
                                Log.v("알림", "계정 찾기 - 이메일 전송");
                                finish();
                                startActivity(new Intent(getApplicationContext(), B_Sign_In.class));
                            } else {
                                Toast.makeText(D_Find.this, "메일 보내기 실패!", Toast.LENGTH_LONG).show();
                                Log.v("알림", "계정 찾기 - 이메일 전송 실패");
                            }
                            progressDialog.dismiss();
                        }
                    });

        }
    }
}