package com.example.tic_tac_toe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


//This is the game display screen.
public class GameDisplay extends AppCompatActivity {

    private  TicTacToeBoard ticTacToeBoard;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_display);

        Button playAgainBTN = findViewById(R.id.play_again);
        Button homeBTN = findViewById(R.id.home_button);
        Button statisticBTN=findViewById(R.id.statistics_button);
        TextView playerTurn = findViewById(R.id.player_display);

        playAgainBTN.setVisibility(View.GONE);
        statisticBTN.setVisibility(View.GONE);
        homeBTN.setVisibility(View.GONE);

        String[] playerNames = getIntent().getStringArrayExtra("PLAYER_NAMES");

        if (playerNames != null) {
            playerTurn.setText((playerNames[0] + "'s Turn"));
        }

        ticTacToeBoard = findViewById(R.id.ticTacToeBoard);

        ticTacToeBoard.setUpGame(playAgainBTN,  homeBTN, statisticBTN, playerTurn, playerNames);

    }

    public void playAgainBTN(View view){

        ticTacToeBoard.resetGame();
        ticTacToeBoard.invalidate();
    }

    public void StatisticButtonClick(View view){
        Intent intent = new Intent(this, Statistics.class);
        startActivity(intent);

    }


    public  void homeButtonClick(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}