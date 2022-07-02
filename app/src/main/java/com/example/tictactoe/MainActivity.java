package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText player1, player2;
    public static final String EXTRA_P1 = "com.example.firstmultiscreen.extra.p1";
    public static final String EXTRA_P2 = "com.example.firstmultiscreen.extra.p2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        player1 = findViewById(R.id.player1);
        player2 = findViewById(R.id.player2);
    }

    public void openActivity(View view){
        Intent intent = new Intent(this,MainActivity2.class);
        String p1 = player1.getText().toString();
        String p2 = player2.getText().toString();
        intent.putExtra(EXTRA_P1,p1);
        intent.putExtra(EXTRA_P2,p2);
        startActivity(intent);
    }
}