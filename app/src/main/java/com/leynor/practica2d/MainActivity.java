package com.leynor.practica2d;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btn_move;
    private View.OnClickListener listener;
    GameView  gameView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        gameView = (GameView) findViewById(R.id.gameView);
        ThreadAnimacio threadAnimacio = new ThreadAnimacio(gameView);
        threadAnimacio.start();


    }


}
