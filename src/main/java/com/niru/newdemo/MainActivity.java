package com.niru.newdemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button create,join;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        create=findViewById(R.id.create);
        join=findViewById(R.id.join);


        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Create.class);
                startActivity(intent);
                finish();

            }
        });

        join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, Comingsoon.class);
                startActivity(intent);
                finish();

            }
        });

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