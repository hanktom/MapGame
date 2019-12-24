package com.fju.game;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private GameView gameView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
    }

    private void findViews() {
        findViewById(R.id.arrow_up).setOnClickListener(this);
        findViewById(R.id.arrow_down).setOnClickListener(this);
        findViewById(R.id.arrow_left).setOnClickListener(this);
        findViewById(R.id.arrow_right).setOnClickListener(this);
        gameView = findViewById(R.id.game);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.arrow_up:
                Log.d("MainActivity", "onClick: UP");
//                gameView.posY-=50;
                gameView.invalidate();
                break;
            case R.id.arrow_down:
                Log.d("MainActivity", "onClick: DOWN");
//                gameView.posY+=50;
                gameView.invalidate();
                break;
            case R.id.arrow_left:
                Log.d("MainActivity", "onClick: LEFT");
                gameView.setPosX(gameView.getX()-50);
                gameView.invalidate();
                break;
            case R.id.arrow_right:
                Log.d("MainActivity", "onClick: RIGHT");
                gameView.setPosX(gameView.getPosX()+50);
                gameView.invalidate();
                break;
        }

    }
}
