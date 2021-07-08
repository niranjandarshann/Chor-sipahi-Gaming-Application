package com.niru.newdemo;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class Join extends AppCompatActivity {

    Button create, btnInvite, btnAccept, btnLogin;

    //TextView txtName1, txtName2, txtScore1, txtScore2, txtSymbol;

    String userID;

    EditText edtInviteAccept1, edtLogin;

    ArrayAdapter<String> adapter;
    ArrayList<String> arrayList;
    // ArrayList<String> listItems=new ArrayList<String>();
    //ArrayAdapter<String> adapter;

    Edit names = new Edit();
    String myEmail;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference();
    int activePlayer = 1; // 1 is for 1st Player , 2 is for 2nd Player
    ArrayList<Integer> player1 = new ArrayList<>(); //  Player 1 Data
    ArrayList<Integer> player2 = new ArrayList<>(); // Player 2 Data
    String playerSession = "";
    //String mySample = "X";

    private FirebaseAnalytics mFirebaseAnalytics;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);

        Objects.requireNonNull(getSupportActionBar()).setElevation(0);

        // list = (ListView) findViewById(R.id.list);
        arrayList = new ArrayList<String>();

        edtLogin = findViewById(R.id.edtLogin);
        edtInviteAccept1=findViewById(R.id.edtInviteAccept1);

        // txtSymbol = findViewById(R.id.txtSymbol);

        btnLogin = findViewById(R.id.btnLogin);
        // Firebase
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        mAuth = FirebaseAuth.getInstance();


        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();

                if (user != null) {
                    userID = user.getUid();
                    myEmail = user.getEmail();
                    btnLogin.setEnabled(false);
                    edtLogin.setText(myEmail);
                    myRef.child("New Users").child(ExactName(myEmail)).child("Request").setValue(userID);
                    GettingRequest();

                } else {
                    Log.d("TAG ", "Null user!");
                }
            }
        };




    }

    private String ExactName(String string) {

        String[] exactName = string.split("@");
        /*String[] exactName = string.split("@");
        String[] exactName = string.split("@");
        String[] exactName = string.split("@");
*/

        return exactName[0];

    }

    private void NewUser(String email, String password) {

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("Successful Login", "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();

                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("Login Failed", "createUserWithEmail:failure", task.getException());
                            Toast.makeText(getApplicationContext(), "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();

                        }
                    }
                });

    }



    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        //FirebaseUser currentUser = mAuth.getCurrentUser();
        mAuth.addAuthStateListener(mAuthListener);
    }


    public void btnLogin(View view) {

        NewUser(edtLogin.getText().toString(), "1234567");

    }
    public void btnAccept(View view) {

        myRef.child("New Users").child(ExactName(edtInviteAccept1.getText().toString())).child("Request").push().setValue(myEmail);

        StartGame(ExactName(myEmail) + ":" + ExactName(edtInviteAccept1.getText().toString()));

        // mySample = "O";
        //btnInvite.setEnabled(false);

       // txtSymbol.setText("You Have 'X'");

    }

    private void StartGame(String playerGameID) {

        playerSession = playerGameID;
        myRef.child("Playing").child(playerGameID).removeValue();

        myRef.child("Playing").child(playerGameID).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                try {
                    player1.clear();
                    player2.clear();
                    activePlayer = 2;
                    HashMap<String, Object> hashMap = (HashMap<String, Object>) dataSnapshot.getValue();

                    if (hashMap != null) {

                        String value;

                        for (String key : hashMap.keySet()) {
                            value = (String) hashMap.get(key);


                            String[] splitID = key.split(":");
                            //                    autoPlay(Integer.parseInt(splitID[1]));

                        }

                    }

                } catch (Exception e) {
                    Log.e("TAG", "Error " + e);
                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }



    private void GettingRequest() {

        myRef.child("New Users").child(ExactName(myEmail)).child("Request").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                try {
                    HashMap<String, Object> hashMap = (HashMap<String, Object>) dataSnapshot.getValue();

                    if (hashMap != null) {

                        String value;

                        for (String key : hashMap.keySet()) {
                            value = (String) hashMap.get(key);
                            edtInviteAccept1.setText(value);
                            changeColor(edtInviteAccept1); // changing the background color of edit text when someone sents invitation
                            myRef.child("New Users").child(ExactName(myEmail)).child("Request").setValue(userID);
                            break;
                        }

                    }

                } catch (Exception e) {
                    Log.e("TAG", "Error " + e);
                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }


    private void changeColor(EditText editText) {

        editText.setBackgroundColor(Color.GREEN);

    }


}