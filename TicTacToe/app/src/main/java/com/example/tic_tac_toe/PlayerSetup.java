package com.example.tic_tac_toe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


//This is the PlayerSetup when you create the name of the players.
public class PlayerSetup extends AppCompatActivity {

    private EditText player1;
    private EditText player2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.player_setup);

        player1 = findViewById(R.id.editTextTextPersonName);
        player2 = findViewById(R.id.editTextTextPersonName2);
    }

    public void submitButtonClick(View view){
        String editTextTextPersonName = player1.getText().toString();
        String editTextTextPersonName2 = player2.getText().toString();
        MyData data = MyData.getInstance();
        data.Player1Name=editTextTextPersonName;
        data.Player2Name=editTextTextPersonName2;

        Intent intent = new Intent(this, GameDisplay.class);
        intent.putExtra("PLAYER_NAMES", new String[] {editTextTextPersonName, editTextTextPersonName2});
        startActivity(intent);


    }
}