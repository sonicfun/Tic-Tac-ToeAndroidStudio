package com.example.tic_tac_toe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

// This activity displays the statitics.
public class Statistics extends AppCompatActivity {

    private TextView player1;
    private TextView player2;
    private TextView player1Vic;
    private TextView player2Vic;
    private TextView player1Draws;
    private TextView player2Draws;
    private TextView player1Loses;
    private TextView player2Loses;
    private  TicTacToeBoard ticTacToeBoard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.statistics);

       player1 = (TextView) findViewById(R.id.Player1);
       player2 = (TextView) findViewById(R.id.Player2);
       player1Vic = (TextView) findViewById(R.id.Player1Wins);
       player2Vic = (TextView) findViewById(R.id.Player2Wins);
       player1Loses = (TextView) findViewById(R.id.Player1Loses);
       player2Loses = (TextView) findViewById(R.id.Player2Loses);
       player1Draws = (TextView) findViewById(R.id.Player1Tie);
       player2Draws = (TextView) findViewById(R.id.Player2Tie);

       DisplayStatitics();

    }

    public void playAgainBTN(View view){

       // ticTacToeBoard.resetGame();
        //ticTacToeBoard.invalidate();
        MyData data = MyData.getInstance();
        data.Reset();
        DisplayStatitics();

    }

    public  void homeButtonClick(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    protected void DisplayStatitics(){
        MyData data = MyData.getInstance();
        player1.setText(data.Player1Name);
        player1Vic.setText(String.format("Victory %d",data.Player1_Vic));
        player1Loses.setText(String.format("Loss %d",data.Player1_defeats));
        player1Draws.setText(String.format("Draw %d",data.Player1_draws));
        player2.setText(data.Player2Name);
        player2Vic.setText(String.format("Victory %d",data.Player2_Vic));
        player2Loses.setText(String.format("Loss %d", data.Player2_defeats));
        player2Draws.setText(String.format("Draw %d", data.Player2_draws));

    }
}