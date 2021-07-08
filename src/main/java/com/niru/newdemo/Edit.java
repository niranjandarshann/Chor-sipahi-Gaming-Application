package com.niru.newdemo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Edit extends AppCompatActivity {

    Button btnPlay;

    public static TextView txtScore1, txtScore2;

    // public static EditText edtName1, edtName2;

    static int counter = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);


        btnPlay = (Button) findViewById(R.id.btnPlay);

        // edtName1 =(EditText) findViewById(R.id.edtName1);
        // edtName2 = (EditText) findViewById(R.id.edtName2);


        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Edit.this, MainActivity.class));
                finish();
            }
        });

    }

    public Button getBtnPlay() {
        return btnPlay;
    }

}
