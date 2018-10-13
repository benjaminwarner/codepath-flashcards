package boisestate.warner.benjamin.flashcards;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void incorrectAnswerClicked(View v) {
        Button incorrectButton = (Button)v;
        incorrectButton.setBackground(getDrawable(R.drawable.incorrect_answer_button_shape));
        Button bezoarButton = findViewById(R.id.bezoarButton);
        bezoarButton.setBackground(getDrawable(R.drawable.correct_answer_button_shape));
    }

    public void correctAnswerClicked(View v) {
        Button correctButton = (Button)v;
        correctButton.setBackground(getDrawable(R.drawable.correct_answer_button_shape));
    }

    public void backgroundClicked(View v) {
        Button hairylollipopButton = findViewById(R.id.hairylollipopButton);
        hairylollipopButton.setBackground(getDrawable(R.drawable.answer_button_shape));
        Button bezoarButton = findViewById(R.id.bezoarButton);
        bezoarButton.setBackground(getDrawable(R.drawable.answer_button_shape));
        Button coalquatButton = findViewById(R.id.coalquatButton);
        coalquatButton.setBackground(getDrawable(R.drawable.answer_button_shape));
    }
}
