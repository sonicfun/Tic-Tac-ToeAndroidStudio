package com.example.tic_tac_toe;

//This is a Singleton Class
public class MyData {
    private static MyData _instance;

    public String Player1Name, Player2Name;
    public int Player1_Vic, Player1_draws, Player1_defeats;
    public int Player2_Vic, Player2_draws, Player2_defeats;

    protected MyData()
    {}

    public static synchronized MyData getInstance()
    {
        if(_instance==null)
            _instance = new MyData();
        return _instance;
    }

    public void Reset()
    {
        Player1_defeats = Player1_draws = Player1_Vic = 0;
        Player2_defeats = Player2_draws = Player2_Vic = 0;
    }
}
