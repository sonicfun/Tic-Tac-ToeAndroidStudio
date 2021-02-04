package com.example.tic_tac_toe;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
//This is the GameLogic of the game.
public class GameLogic {

    private int[] [] gameBoard;

    private String[] playerNames = {"Player 1", "Player 2"};

    //1st element --> row,2nd element --> col, 3rd element -->line type
    private  int[] winType = {-1,-1,-1};

     private Button setPlayAgainBTN;
     private Button homeBTN;
     private Button statisticBTN;
     private TextView playerTurn;

    private int player = 1;

    GameLogic(){
        gameBoard = new int[3][3];
        for (int r= 0; r<3; r++){
            for (int c=0; c<3; c++){
                gameBoard[r] [c] =0;
            }
        }

    }

    public boolean updateGameBoard(int row, int col){
        if(gameBoard[row-1][col-1] == 0){
            gameBoard[row-1] [col-1] = player;

            if(player == 1){
                playerTurn.setText((playerNames[1] + "'s Turn"));
            }
            else{
                playerTurn.setText((playerNames[0] + "'s Turn"));
            }

            return true;
        }
        else {
            return false;
        }
    }

    public boolean winnerCheck(){
        boolean isWinner = false;

        for (int r=0; r<3; r++){
            if(gameBoard[r][0] == gameBoard[r] [1] && gameBoard[r] [0] == gameBoard[r] [2] &&
            gameBoard [r] [0] != 0){
                winType = new int[] {r,0,1};
                isWinner = true;
            }
        }

        for (int c=0; c<3; c++){
            if(gameBoard[c][0] == gameBoard[c] [1] && gameBoard[c] [0] == gameBoard[c] [2] &&
                    gameBoard [c] [0] != 0){
                winType = new int[] {0,c,2};
                isWinner = true;
            }
        }

        if(gameBoard[0][0] == gameBoard[1] [1] && gameBoard[0] [0] == gameBoard[2] [2] &&
                gameBoard [0] [0] != 0) {
            winType = new int[] {0,2,3};
            isWinner = true;
        }
        if(gameBoard[2][0] == gameBoard[1] [1] && gameBoard[2] [0] == gameBoard[0] [2] &&
                gameBoard [2] [0] != 0){
            winType = new int[] {2,2,4};
            isWinner = true;
        }

        int boardFilled = 0;

        for (int r=0; r<3; r++){
            for (int c=0; c<3; c++){
                if (gameBoard[r] [c] !=0){
                    boardFilled+=1;
                }
            }
        }

        if(isWinner){
            setPlayAgainBTN.setVisibility(View.VISIBLE);
            homeBTN.setVisibility(View.VISIBLE);
            statisticBTN.setVisibility(View.VISIBLE);
            playerTurn.setText((playerNames[player-1] + " Won!!!!"));
            UpdateWinner();
            return true;

        }
        else  if(boardFilled == 9){
            setPlayAgainBTN.setVisibility(View.VISIBLE);
            homeBTN.setVisibility(View.VISIBLE);
            statisticBTN.setVisibility(View.VISIBLE);
            playerTurn.setText( "Tie Game!!!!");
            UpdateDraw();
            return false;
        }
        else {
            return false;
        }
    }

    public  void  resetGame(){
        gameBoard = new int[3][3];
        for (int r= 0; r<3; r++){
            for (int c=0; c<3; c++){
                gameBoard[r] [c] =0;
            }
        }

        player = 1;

        setPlayAgainBTN.setVisibility(View.GONE);
        homeBTN.setVisibility(View.GONE);
        statisticBTN.setVisibility(View.GONE);
        playerTurn.setText((playerNames[0]+"'s turn"));

    }

    protected void UpdateWinner(){
        MyData data = MyData.getInstance();

        if( player == 1){
            data.Player1_Vic +=1;
            data.Player2_defeats +=1;
        }
        else{
            data.Player2_Vic +=1;
            data.Player1_defeats+=1;

        }
    }

    protected  void UpdateDraw() {
        MyData data = MyData.getInstance();

        data.Player1_draws +=1;
        data.Player2_draws +=1;
    }
    public  void setPlayAgainBTN(Button playAgainBTN){
        this.setPlayAgainBTN = playAgainBTN;
    }

    public void setHomeBTN(Button homeBTN){
        this.homeBTN = homeBTN;
    }

    public  void setStatisticBTN (Button statisticBTN){
        this.statisticBTN = statisticBTN;
    }

    public void setPlayerTurn (TextView playerTurn){
        this.playerTurn = playerTurn;
    }

    public  void setPlayerNames(String[] playerNames){
        this.playerNames = playerNames;
    }

    public int[] [] getGameBoard() {
        return gameBoard;
    }

    public void setPlayer(int player) {
        this.player = player;
    }
    public int getPlayer(){
        return player;
    }

    public int[] getWinType(){
        return winType;
    }


}
