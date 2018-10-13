package boisestate.warner.benjamin.flashcards;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    int correctAnswerColor = Color.rgb(46, 204, 113);
    int incorrectAnswerColor = Color.rgb(231, 76, 60);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.coalquatButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button coalquatButton = findViewById(R.id.coalquatButton);
                coalquatButton.setBackgroundColor(incorrectAnswerColor);
                Button bezoarButton = findViewById(R.id.bezoarButton);
                bezoarButton.setBackgroundColor(correctAnswerColor);
            }
        });

        findViewById(R.id.bezoarButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button bezoarButton = findViewById(R.id.bezoarButton);
                bezoarButton.setBackgroundColor(correctAnswerColor);
            }
        });

        findViewById(R.id.hairylollipopButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button hairylollipopButton = findViewById(R.id.hairylollipopButton);
                hairylollipopButton.setBackgroundColor(incorrectAnswerColor);
                Button bezoarButton = findViewById(R.id.bezoarButton);
                bezoarButton.setBackgroundColor(correctAnswerColor);
            }
        });
    }
}
