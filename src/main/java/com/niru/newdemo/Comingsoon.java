package com.niru.newdemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

public class Comingsoon extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coming_soon);

    }
    private void doExit(){
        startActivity( new Intent(getApplicationContext(),ModeOfPlay.class));
        finish();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        doExit();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        onBackPressed();
        return true;
    }
}