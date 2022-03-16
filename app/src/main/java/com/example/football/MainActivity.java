package com.example.football;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int leftCounter = 0;
    int rightCounter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void setScoreToZero(View view){
        leftCounter = 0;
        rightCounter = 0;
        resetUI();
    }
   public void addPointToLeftTeam(View view){
        TextView leftScore = findViewById(R.id.leftscore);
        leftCounter++;
        leftScore.setText(String.valueOf(leftCounter));
    }
    public void addPointToRightTeam(View view){
        TextView rightScore = findViewById(R.id.rightscore);
        rightCounter++;
        rightScore.setText(String.valueOf(rightCounter));
    }
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putIntArray("Scores", new int[] {leftCounter, rightCounter});
    }
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState != null && savedInstanceState.containsKey("Scores")) {
            int[] scores = savedInstanceState.getIntArray("Scores");
            leftCounter = scores[0];
            rightCounter = scores[1];
            resetUI();
        }
    }
    protected void resetUI(){
        TextView leftScore = findViewById(R.id.leftscore);
        leftScore.setText(String.valueOf(leftCounter));
        TextView rightScore = findViewById(R.id.rightscore);
        rightScore.setText(String.valueOf(rightCounter));
    }
}