package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    TextView pl1,pl2,status,score1,score2;
    ImageView img;
    String p1,p2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        pl1 = findViewById(R.id.p1);
        pl2 = findViewById(R.id.p2);

        Intent intent = getIntent();
        p1 = intent.getStringExtra(MainActivity.EXTRA_P1);
        p2 = intent.getStringExtra(MainActivity.EXTRA_P2);

        pl1.setText(p1);
        pl2.setText(p2);

        score1 = findViewById(R.id.score1);
        score2 = findViewById(R.id.score2);
        score1.setText(": "+player1);
        score2.setText(": "+player2);
        status = findViewById(R.id.status);
        status.setText(p1+"'s Turn Tap to Play");
    }

    // LOGIC FOR TIC TAC TOE
    // 0 - X
    // 1 - O
    // 2 - NULL
    int activePlayer = 0;
    int player1 = 0, player2 = 0 ;
    int cnt = 0 ;

    int[] gameState = {2,2,2,2,2,2,2,2,2};
    boolean gameActive = true;

    int[][] winPosition = {{0,1,2},{3,4,5},{6,7,8},
                           {0,3,6},{1,4,7},{2,5,8},
                           {0,4,8},{2,4,6}};

    public  void Playertap(View view){
         img = (ImageView) view;
        int tappedImage = Integer.parseInt(img.getTag().toString());


        if(gameState[tappedImage]==2){
            cnt = cnt + 1;
            gameState[tappedImage]=activePlayer;
            img.setTranslationY(-1000f);
            if(activePlayer==0){
                img.setImageResource(R.drawable.cross);
                activePlayer=1;
                status = findViewById(R.id.status);
                status.setText(p2+"'s Turn Tap to Play");
            }
            else{
                img.setImageResource(R.drawable.zero);
                activePlayer=0;
                status.setText(p1+"'s Turn Tap to Play");
            }
            img.animate().translationYBy(1000f).setDuration(300);
        }
        // check Win
        if(!gameActive){
            GameReset(view);
        }
        for(int[] winposition : winPosition){
            if( gameState[winposition[0]] == gameState[winposition[1]] &&
                gameState[winposition[1]] == gameState[winposition[2]] &&
                gameState[winposition[0]] != 2){
                String winner;
                gameActive = false;
                if(gameState[winposition[0]] == 0){
                    winner=p1+" has Won";
                    player1+=1;
                }
                else{
                    winner = p2+" has Won";
                    player2+=1;

                }
                status.setText(winner);
                score1.setText(": "+player1);
                score2.setText(": "+player2);
                break;
            }
            else{
                gameActive = false;
                for(int i=0;i<gameState.length;i++){
                    if(gameState[i]==2){
                        gameActive = true;
                        break;
                    }
                }
            }
        }
    }

    public void GameReset(View view){
        gameActive = true;
        activePlayer = 0;
        for(int i=0;i<gameState.length;i++){
            gameState[i]=2;
        }
        ((ImageView)findViewById(R.id.g1)).setImageResource(0);
        ((ImageView)findViewById(R.id.g2)).setImageResource(0);
        ((ImageView)findViewById(R.id.g3)).setImageResource(0);
        ((ImageView)findViewById(R.id.g4)).setImageResource(0);
        ((ImageView)findViewById(R.id.g5)).setImageResource(0);
        ((ImageView)findViewById(R.id.g6)).setImageResource(0);
        ((ImageView)findViewById(R.id.g7)).setImageResource(0);
        ((ImageView)findViewById(R.id.g8)).setImageResource(0);
        ((ImageView)findViewById(R.id.g9)).setImageResource(0);

        status.setText(p1+"'s Turn Tap to Play");
    }

}