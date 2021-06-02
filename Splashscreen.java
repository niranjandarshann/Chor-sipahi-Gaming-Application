package com.niru.myapplication3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

public class Splashscreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        getSupportActionBar().hide();
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Thread td=new Thread() {
            public void run() {
                try {
                    sleep(2200);

                } catch (Exception ex) {
                    ex.printStackTrace();

                } finally {
                    Intent intent=new Intent(Splashscreen.this,Playername.class);
                    startActivity(intent);
                    finish();


                }
            }
        };
        td.start();


    }
}