package com.example.responsi_mp3.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.responsi_mp3.Database.UserDao;
import com.example.responsi_mp3.Database.UserDatabase;
import com.example.responsi_mp3.Database.UserEntity;
import com.example.responsi_mp3.R;


public class Recovery_Activity extends AppCompatActivity {
    EditText email;
    Button recovery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recovery_activity);

        email = findViewById(R.id.r_email);
        recovery = findViewById(R.id.recovery);
        recovery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailText = email.getText().toString();
                if (emailText.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Harap isi semua", Toast.LENGTH_SHORT).show();
                } else {
                    UserDatabase userDatabase = UserDatabase.getUserDatabase(getApplicationContext());
                    UserDao userDao = userDatabase.userDao();
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            UserEntity userEntity = userDao.recovery(emailText);
                            if (userEntity == null) {
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast.makeText(getApplicationContext(), "Tidak valid", Toast.LENGTH_SHORT).show();
                                    }
                                });
                            } else {
                                startActivity(new Intent(Recovery_Activity.this, LoginActivity.class));
                            }
                        }
                    }).start();
                }
            }
        });

    }
}