package com.niru.myapplication3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Playername extends AppCompatActivity {
    EditText player1,player2,player3,player4;
    Button startgame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playername);
        player1=findViewById(R.id.player1);
        player2=findViewById(R.id.player2);
        player3=findViewById(R.id.player3);
        player4=findViewById(R.id.player4);
        startgame=findViewById(R.id.startplaying);

        startgame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String p1name=player1.getText().toString();
                String p2name=player2.getText().toString();
                String p3name=player3.getText().toString();
                String p4name=player4.getText().toString();
                Intent intent=new Intent(Playername.this,MainActivity.class);
                intent.putExtra("player1name",p1name);
                intent.putExtra("player2name",p2name);

                intent.putExtra("player3name",p3name);

                intent.putExtra("player4name",p4name);
                startActivity(intent);

                finish();
            }
        });

    }
}