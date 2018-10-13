package boisestate.warner.benjamin.flashcards;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    int correctAnswerColor = Color.rgb(46, 204, 113);
    int incorrectAnswerColor = Color.rgb(231, 76, 60);
    int startingAnswerColor = Color.parseColor("#ffffbb33");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void incorrectAnswerClicked(View v) {
        Button incorrectButton = (Button)v;
        incorrectButton.setBackgroundColor(incorrectAnswerColor);
        Button bezoarButton = findViewById(R.id.bezoarButton);
        bezoarButton.setBackgroundColor(correctAnswerColor);
    }

    public void correctAnswerClicked(View v) {
        Button correctButton = (Button)v;
        correctButton.setBackgroundColor(correctAnswerColor);
    }

    public void backgroundClicked(View v) {
        Button hairylollipopButton = findViewById(R.id.hairylollipopButton);
        hairylollipopButton.setBackgroundColor(startingAnswerColor);
        Button bezoarButton = findViewById(R.id.bezoarButton);
        bezoarButton.setBackgroundColor(startingAnswerColor);
        Button coalquatButton = findViewById(R.id.coalquatButton);
        coalquatButton.setBackgroundColor(startingAnswerColor);
    }
}
