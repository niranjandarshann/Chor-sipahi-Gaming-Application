package com.niru.newdemo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class OfflinePlay extends AppCompatActivity {

    Button btn1,btn2,btn3,btn4,player1text,player2text,player3text,player4text;
    MediaPlayer mdx,rmdx,wmdx;
    String[] name={"Raja","Mantri","Chor","Sipahi"};
    // int color = R.color.purple_200;
    //public final int color=0xFFFF0000;

    //int[] image={R.drawable.raja,R.drawable.mantri,R.drawable.chor,R.drawable.sipahi};
    int sump1=0,roundcount=1,sump2=0,sump3=0,sump4=0,r1,r2;
    TextView scoreplayer1,scoreplayer2,scoreplayer3,scoreplayer4,playerturn;
    Button shufflebtn,guess,player1score,player2score,player3score,player4score,round;
    Boolean turnshuffle=false,turnguess=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offline_play);

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        guess = findViewById(R.id.guess);
        // Number of Round
        round = findViewById(R.id.round);
        //Player name
        player1text = findViewById(R.id.player1txt);
        player2text = findViewById(R.id.player2txt);

        player3text = findViewById(R.id.player3txt);

        player4text = findViewById(R.id.player4txt);
        String p1 = getIntent().getStringExtra("player1name");
        String p2 = getIntent().getStringExtra("player2name");

        String p3 = getIntent().getStringExtra("player3name");

        String p4 = getIntent().getStringExtra("player4name");
        player1text.setText(p1);
        player2text.setText(p2);
        player3text.setText(p3);
        player4text.setText(p4);

        //Score of players

        scoreplayer1 = findViewById(R.id.scoreplayer1);
        scoreplayer2 = findViewById(R.id.scoreplayer2);
        scoreplayer3 = findViewById(R.id.scoreplayer3);
        scoreplayer4 = findViewById(R.id.scoreplayer4);
        //Mediaplauyer
        playerturn = findViewById(R.id.playerturn);


        mdx = MediaPlayer.create(OfflinePlay.this, R.raw.music);


        shufflebtn = findViewById(R.id.shufflebtn);



        shufflebtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (roundcount <= 5) {
                    round.setText(Integer.toString(roundcount) + "/5");

                    mdx.start();

                    Shuffle();

                    //Reveal RAja and Sipahi
                    if (name[0] == "Raja" || name[0] == "Sipahi" || name[0] == "Mantri" || name[0] == "Chor") {
                        btn1.setClickable(false);
                        Toast.makeText(OfflinePlay.this, "Please click for Guess", Toast.LENGTH_SHORT).show();
                        if (name[0] == "Mantri") {
                            // btn1.setText(name[0]);
                            btn1.setBackgroundResource(R.drawable.mantri);
                            sump1 = sump1 + 800;
                            scoreplayer1.setText(Integer.toString(sump1));
                            playerturn.setText((p1)+"\t Turns");

                        }
                        if (name[0] == "Raja") {
                            // btn1.setText(name[0]);
                            btn1.setBackgroundResource(R.drawable.raja);
                            sump1 = sump1 + 1000;
                            //scoreplayer1.setText(sump1);
                            scoreplayer1.setText(Integer.toString(sump1));

                        }

                        if (name[0] == "Sipahi") {
                            r1 = btn1.getId();
                            //btn1.setText(name[0]);
                            //Toast.makeText(getApplicationContext(),"r1:"+r1,Toast.LENGTH_SHORT).show();

                        }
                        if (name[0] == "Chor") {
                            r2 = btn1.getId();
                            //btn1.setText(name[0]);

                        }


                    }


                    if (name[1] == "Raja" || name[1] == "Sipahi" || name[1] == "Chor" || name[1] == "Mantri") {
                        btn2.setClickable(false);
                        Toast.makeText(OfflinePlay.this, "Please click for Guess", Toast.LENGTH_SHORT).show();

                        if (name[1] == "Raja") {
                            // btn2.setText(name[1]);
                            btn2.setBackgroundResource(R.drawable.raja);
                            sump2 = sump2 + 1000;
                            //  scoreplayer2.setText(sump2);
                            scoreplayer2.setText(Integer.toString(sump2));
                        }
                        if (name[1] == "Mantri") {
                            //  btn2.setText(name[1]);
                            btn2.setBackgroundResource(R.drawable.mantri);
                            sump2 = sump2 + 800;
                            playerturn.setText((p2)+"\t Turns");

                            // scoreplayer2.setText(sump2);
                            scoreplayer2.setText(Integer.toString(sump2));


                        }

                        if (name[1] == "Sipahi") {
                            r1 = btn2.getId();
                            //    btn2.setText(name[1]);

                            // Toast.makeText(getApplicationContext(),"r1:"+r1,Toast.LENGTH_SHORT).show();

                        }
                        if (name[1] == "Chor") {
                            r2 = btn2.getId();
                            //  btn2.setText(name[1]);

                        }

                    }
                    if (name[2] == "Raja" || name[2] == "Sipahi" || name[2] == "Chor" || name[2] == "Mantri") {
                        btn3.setClickable(false);
                        Toast.makeText(OfflinePlay.this, "Please click for Guess", Toast.LENGTH_SHORT).show();

                        if (name[2] == "Raja") {
                            //btn3.setText(name[2]);
                            btn3.setBackgroundResource(R.drawable.raja);
                            sump3 = sump3 + 1000;
                            //  scoreplayer3.setText(sump3);
                            scoreplayer3.setText(Integer.toString(sump3));

                        }
                        if (name[2] == "Mantri") {
                            //btn3.setText(name[2]);
                            btn3.setBackgroundResource(R.drawable.mantri);
                            sump3 = sump3 + 800;
                            playerturn.setText((p3)+"\t Turns");

                            //scoreplayer3.setText(sump3);
                            scoreplayer3.setText(Integer.toString(sump3));


                        }
                        // if (name[2] =="Chor" || name[2] =="Mantri") {
                        if (name[2] == "Sipahi") {
                            r1 = btn3.getId();
                            //  btn3.setText(name[2]);

                            //   Toast.makeText(getApplicationContext(),"r1:"+r1,Toast.LENGTH_SHORT).show();

                        }
                        if (name[2] == "Chor") {
                            r2 = btn3.getId();
                            //      btn3.setText(name[2]);

                        }
                        //   }
                    }
                    if (name[3] == "Raja" || name[3] == "Sipahi" || name[3] == "Mantri" || name[3] == "Chor") {
                        btn4.setClickable(false);
                        Toast.makeText(OfflinePlay.this, "Please click for Guess", Toast.LENGTH_SHORT).show();

                        if (name[3] == "Raja") {
                            // btn4.setText(name[3]);
                            btn4.setBackgroundResource(R.drawable.raja);
                            sump4 = sump4 + 1000;
                            //  scoreplayer4.setText(sump4);
                            scoreplayer4.setText(Integer.toString(sump4));


                        }
                        if (name[3] == "Mantri") {
                            //btn4.setText(name[3]);
                            btn4.setBackgroundResource(R.drawable.mantri);
                            sump4 = sump4 + 800;
                            playerturn.setText((p4)+"\t Turns");

                            scoreplayer4.setText(Integer.toString(sump4));

                        }


                        if (name[3] == "Sipahi") {
                            r1 = btn4.getId();
                            //btn4.setText(name[3]);

                            // Toast.makeText(getApplicationContext(),"r1:"+r1,Toast.LENGTH_SHORT).show();

                        }
                        if (name[3] == "Chor") {
                            r2 = btn4.getId();
                            //    btn4.setText(name[3]);

                        }
                    }
                    //  Toast.makeText(getApplicationContext(),"r1:"+r1,Toast.LENGTH_SHORT).show();
                    //Toast.makeText(getApplicationContext(),"r2:"+r2,Toast.LENGTH_SHORT).show();


                    roundcount++;

                }
                else{
                    checkwinner();
                }
                guess.setVisibility(View.VISIBLE);


            }


        });


        guess();

    }


    public void guess() {
        guess.setClickable(true);
        rmdx = MediaPlayer.create(OfflinePlay.this, R.raw.right);
        wmdx = MediaPlayer.create(OfflinePlay.this, R.raw.wrong);


        guess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //    turnguess=true;
                //if (guess.isPressed()){

                if (r1 == R.id.btn1) {
                    if (r2 == R.id.btn2) {
                        btn1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                //btn1.setText("Sipahi");
                                wmdx.start();
                                btn1.setBackgroundResource(R.drawable.sipahi);

                                //btn2.setText("Chor");
                                btn2.setBackgroundResource(R.drawable.chor);
                                // scoreplayer2=scoreplayer2-500;

                                sump1=sump1-500;
                                if(sump1<=0){
                                    sump1=0;

                                }

                                sump2=sump2+500;

                                scoreplayer1.setText(Integer.toString(sump1));
                                scoreplayer2.setText(Integer.toString(sump2));


                            }


                        });
                        btn2.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                //btn1.setText("Sipahi");
                                rmdx.start();
                                btn1.setBackgroundResource(R.drawable.sipahi);

                                //  btn2.setText("Chor");
                                btn2.setBackgroundResource(R.drawable.chor);
                                sump2=sump2+500;

                                scoreplayer2.setText(Integer.toString(sump2));


                            }

                        });
                    }
                    if (r2 == R.id.btn3) {
                        btn1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                wmdx.start();
                                // btn1.setText("Sipahi");
                                btn1.setBackgroundResource(R.drawable.sipahi);


                                //btn3.setText("Chor");
                                btn3.setBackgroundResource(R.drawable.chor);
                                sump1=sump1-500;
                                if(sump1<=0){
                                    sump1=0;
                                }
                                sump3=sump3+500;
                                scoreplayer1.setText(Integer.toString(sump1));
                                scoreplayer3.setText(Integer.toString(sump3));



                            }

                        });
                        btn3.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                //btn1.setText("Sipahi");
                                rmdx.start();
                                btn1.setBackgroundResource(R.drawable.sipahi);

                                //btn3.setText("Chor");
                                btn3.setBackgroundResource(R.drawable.chor);
                                sump3=sump3+500;
                                scoreplayer3.setText(Integer.toString(sump3));


                            }
                        });

                    }
                    if (r2 == R.id.btn4) {
                        btn1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                wmdx.start();
                                // btn1.setText("Sipahi");
                                btn1.setBackgroundResource(R.drawable.sipahi);

                                // btn4.setText("Chor");

                                btn4.setBackgroundResource(R.drawable.chor);
                                sump1=sump1-500;
                                if(sump1<=0){
                                    sump1=0;
                                }
                                sump4=sump4+500;
                                scoreplayer4.setText(Integer.toString(sump4));
                                scoreplayer1.setText(Integer.toString(sump1));



                            }

                        });
                        btn4.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                rmdx.start();

                                //  btn1.setText("Sipahi");
                                btn1.setBackgroundResource(R.drawable.sipahi);

                                //btn4.setText("Chor");
                                btn4.setBackgroundResource(R.drawable.chor);
                                sump4=sump4+500;
                                scoreplayer4.setText(Integer.toString(sump4));


                            }
                        });

                    }
                } else if (r1 == R.id.btn2) {
                    if (r2 == R.id.btn1) {
                        btn2.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                //btn2.setText("Sipahi");
                                wmdx.start();

                                btn2.setBackgroundResource(R.drawable.sipahi);

                                //   btn1.setText("Chor");
                                btn1.setBackgroundResource(R.drawable.chor);
                                sump2=sump2-500;
                                if(sump2<=0){
                                    sump2=0;
                                }
                                sump1=sump1+500;
                                scoreplayer1.setText(Integer.toString(sump1));

                                scoreplayer2.setText(Integer.toString(sump2));


                            }

                        });
                        btn1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                //  btn2.setText("Sipahi");
                                rmdx.start();

                                btn2.setBackgroundResource(R.drawable.sipahi);

                                //btn1.setText("Chor");
                                btn1.setBackgroundResource(R.drawable.chor);
                                sump2=sump2+500;
                                scoreplayer1.setText(Integer.toString(sump1));
                                scoreplayer2.setText((Integer.toString(sump2)));


                            }
                        });
                    }
                    if (r2 == R.id.btn3) {
                        btn2.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                // btn2.setText("Sipahi");
                                wmdx.start();

                                btn2.setBackgroundResource(R.drawable.sipahi);
                                sump2=sump2-500;
                                if(sump2<=0){
                                    sump2=0;
                                }


                                //btn3.setText("Chor");
                                btn3.setBackgroundResource(R.drawable.chor);
                                sump3=sump3+500;
                                scoreplayer2.setText(Integer.toString(sump2));
                                scoreplayer3.setText((Integer.toString(sump3)));


                            }

                        });
                        btn3.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                //btn2.setText("Sipahi");
                                rmdx.start();

                                btn2.setBackgroundResource(R.drawable.sipahi);

                                //btn3.setText("Chor");
                                btn3.setBackgroundResource(R.drawable.chor);
                                sump3=sump3+500;
                                scoreplayer3.setText(Integer.toString(sump3));



                            }
                        });

                    }
                    if (r2 == R.id.btn4) {
                        btn2.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                //  btn2.setText("Sipahi");
                                wmdx.start();

                                btn2.setBackgroundResource(R.drawable.sipahi);

                                //   btn4.setText("Chor");
                                btn4.setBackgroundResource(R.drawable.chor);
                                sump2=sump2-500;
                                if(sump2<=0){
                                    sump2=0;
                                }
                                sump4=sump4+500;
                                scoreplayer2.setText(Integer.toString(sump2));
                                scoreplayer4.setText(Integer.toString(sump4));



                            }

                        });
                        btn4.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                // btn2.setText("Sipahi");
                                rmdx.start();

                                btn2.setBackgroundResource(R.drawable.sipahi);

                                //   btn4.setText("Chor");
                                btn4.setBackgroundResource(R.drawable.chor);
                                sump2=sump2+500;
                                scoreplayer2.setText(Integer.toString(sump2));



                            }
                        });

                    }
                } else if (r1 == R.id.btn3) {
                    if (r2 == R.id.btn1) {
                        btn3.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                //    btn3.setText("Sipahi");
                                wmdx.start();

                                btn3.setBackgroundResource(R.drawable.sipahi);

                                //btn1.setText("Chor");
                                btn1.setBackgroundResource(R.drawable.chor);
                                sump3=sump3-500;
                                if(sump3<=0){
                                    sump3=0;
                                }
                                sump1=sump1+500;
                                scoreplayer1.setText(Integer.toString(sump1));

                                scoreplayer3.setText(Integer.toString(sump3));



                            }

                        });
                        btn1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                //   btn3.setText("Sipahi");
                                rmdx.start();

                                btn3.setBackgroundResource(R.drawable.sipahi);

                                //   btn1.setText("Chor");
                                btn1.setBackgroundResource(R.drawable.chor);
                                sump3=sump3+500;
                                scoreplayer3.setText(Integer.toString(sump3));



                            }
                        });
                    }
                    if (r2 == R.id.btn2) {
                        btn3.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                //   btn3.setText("Sipahi");
                                wmdx.start();

                                btn3.setBackgroundResource(R.drawable.sipahi);

                                //   btn2.setText("Chor");
                                btn2.setBackgroundResource(R.drawable.chor);
                                sump3=sump3-500;
                                if(sump3<=0){
                                    sump3=0;
                                }
                                sump2=sump2+500;
                                scoreplayer3.setText(Integer.toString(sump3));
                                scoreplayer2.setText(Integer.toString(sump2));



                            }

                        });
                        btn2.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                //btn3.setText("Sipahi");
                                rmdx.start();

                                btn3.setBackgroundResource(R.drawable.sipahi);

                                //btn2.setText("Chor");
                                btn2.setBackgroundResource(R.drawable.chor);
                                sump3=sump3+500;
                                scoreplayer3.setText(Integer.toString(sump3));



                            }
                        });

                    }
                    if (r2 == R.id.btn4) {
                        btn3.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                //  btn3.setText("Sipahi");
                                wmdx.start();

                                btn3.setBackgroundResource(R.drawable.sipahi);

                                // btn4.setText("Chor");
                                btn4.setBackgroundResource(R.drawable.chor);

                                sump3=sump3-500;
                                if(sump3<=0){
                                    sump3=0;
                                }
                                sump4=sump4+500;
                                scoreplayer3.setText(Integer.toString(sump3));
                                scoreplayer4.setText(Integer.toString(sump4));



                            }

                        });
                        btn4.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                // btn3.setText("Sipahi");
                                rmdx.start();

                                btn3.setBackgroundResource(R.drawable.sipahi);

                                // btn4.setText("Chor");
                                btn4.setBackgroundResource(R.drawable.chor);
                                sump3=sump3+500;
                                scoreplayer3.setText(Integer.toString(sump3));



                            }
                        });

                    }
                } else if (r1 == R.id.btn4) {
                    if (r2 == R.id.btn1) {
                        btn4.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                // btn4.setText("Sipahi");
                                wmdx.start();

                                btn4.setBackgroundResource(R.drawable.sipahi);

                                //btn1.setText("Chor");
                                btn1.setBackgroundResource(R.drawable.chor);

                                sump4=sump4-500;
                                if(sump4<=0){
                                    sump4=0;
                                }
                                sump1=sump1+500;
                                scoreplayer4.setText(Integer.toString(sump4));
                                scoreplayer1.setText(Integer.toString(sump1));



                            }

                        });
                        btn1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                // btn4.setText("Sipahi");
                                rmdx.start();

                                btn4.setBackgroundResource(R.drawable.sipahi);

                                //  btn1.setText("Chor");
                                btn1.setBackgroundResource(R.drawable.chor);

                                sump4=sump4+500;
                                scoreplayer4.setText(Integer.toString(sump4));



                            }
                        });
                    }
                    if (r2 == R.id.btn3) {
                        btn4.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                //btn4.setText("Sipahi");
                                btn4.setBackgroundResource(R.drawable.sipahi);

                                //  btn3.setText("Chor");
                                wmdx.start();

                                btn3.setBackgroundResource(R.drawable.chor);
                                sump4=sump4-500;
                                if(sump4<=0){
                                    sump4=0;
                                }
                                sump3=sump3+500;
                                scoreplayer4.setText(Integer.toString(sump4));
                                scoreplayer3.setText(Integer.toString(sump3));



                            }

                        });
                        btn3.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                //  btn4.setText("Sipahi");
                                rmdx.start();

                                btn4.setBackgroundResource(R.drawable.sipahi);

                                // btn3.setText("Chor");
                                btn3.setBackgroundResource(R.drawable.chor);
                                sump4=sump4+500;
                                scoreplayer4.setText(Integer.toString(sump4));



                            }
                        });

                    }
                    if (r2 == R.id.btn2) {
                        btn4.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                //  btn4.setText("Sipahi");
                                wmdx.start();

                                btn4.setBackgroundResource(R.drawable.sipahi);

                                // btn2.setText("Chor");
                                btn2.setBackgroundResource(R.drawable.chor);
                                sump4=sump4-500;
                                if(sump4<=0){
                                    sump4=0;
                                }
                                sump2=sump2+500;
                                scoreplayer4.setText(Integer.toString(sump4));

                                scoreplayer2.setText(Integer.toString(sump2));



                            }

                        });
                        btn2.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                //  btn4.setText("Sipahi");
                                rmdx.start();
                                btn4.setBackgroundResource(R.drawable.sipahi);

                                //  btn2.setText("Chor");
                                btn2.setBackgroundResource(R.drawable.chor);
                                sump4=sump4+500;
                                scoreplayer4.setText(Integer.toString(sump4));



                            }
                        });

                    }
                }

            }


        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        mdx.stop();
    }

  /*  public void CheckWinner(){
        AlertDialog alert=new AlertDialog();
    }*/

    public void Shuffle(){

        btn1.setText("");
        btn2.setText("");
        btn3.setText("");
        btn4.setText("");
        btn1.setBackgroundResource(R.drawable.background);
        btn2.setBackgroundResource(R.drawable.background);
        btn3.setBackgroundResource(R.drawable.background);
        btn4.setBackgroundResource(R.drawable.background);
        Collections.shuffle(Arrays.asList(name));
        //turn=false;

    }
    public void checkwinner(){
        List<Integer> arr=new ArrayList<Integer>();
        arr.add(sump1);
        arr.add(sump2);
        arr.add(sump3);
        arr.add(sump4);
        Collections.sort(arr,Collections.reverseOrder());
        List<String> data=new ArrayList<String>();
        for (int i=0;i<4;i++) {

            if (arr.get(i)==sump1){

                data.add(player1text.getText().toString());

            }
            if (arr.get(i)==sump2){
                //   List<String> data=new ArrayList<>();
                data.add(player2text.getText().toString());

            }
            if (arr.get(i)==sump3){
                //  List<String> data=new ArrayList<>();
                data.add(player3text.getText().toString());

            }
            if (arr.get(i)==sump4){
                // List<String> data=new ArrayList<>();
                data.add(player4text.getText().toString());

            }

        }


        ListView listview=new ListView(this);
    /*List<String> data=new ArrayList<>();
    data.add(arr[0]);
    data.add(Integer.toString(arr[1]));
    data.add(Integer.toString(sump3));
    data.add(Integer.toString(sump4));*/

        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,data);
        listview.setAdapter(adapter);
        AlertDialog.Builder builder=new AlertDialog.Builder(OfflinePlay.this,R.style.ThemeOverlay_MaterialComponents_MaterialAlertDialog_Background);
        builder.setView(listview);

        builder.setTitle("Winner");
        final AlertDialog dialog=builder.create();
        builder.show();
    }
}
