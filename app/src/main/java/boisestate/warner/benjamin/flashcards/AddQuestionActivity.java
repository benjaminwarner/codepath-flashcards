package boisestate.warner.benjamin.flashcards;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddQuestionActivity extends AppCompatActivity {

    private EditText questionEditor;
    private EditText answerEditor;
    private EditText wrongAnswer1Editor;
    private EditText wrongAnswer2Editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_question);
        questionEditor = findViewById(R.id.questionEditor);
        answerEditor = findViewById(R.id.answerEditor);
        wrongAnswer1Editor = findViewById(R.id.wrongAnswer1Editor);
        wrongAnswer2Editor = findViewById(R.id.wrongAnswer2Editor);

        Bundle data = getIntent().getExtras();
        boolean edit = data.getBoolean("edit");
        if (edit) {
            questionEditor.setText(data.getString("existing_question"));
            answerEditor.setText(data.getString("correct_answer"));
        }
    }

    public void backButtonClicked(View v) {
        setResult(RESULT_CANCELED);
        finish();
    }

    public void saveButtonClicked(View v) {
        String questionText = questionEditor.getText().toString();
        String answerText = answerEditor.getText().toString();
        String wrongAnswer1Text = wrongAnswer1Editor.getText().toString();
        String wrongAnswer2Text = wrongAnswer2Editor.getText().toString();
        if (questionText.equals("") || answerText.equals("") || wrongAnswer1Text.equals("") || wrongAnswer2Text.equals("")) {
            Toast errorToast = Toast.makeText(getApplicationContext(), "All fields must be filled out!", Toast.LENGTH_SHORT);
            errorToast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
            errorToast.show();
            return;
        }
        Intent data = new Intent();
        data.putExtra("question", questionText);
        data.putExtra("answer", answerText);
        data.putExtra("wrong_answer1", wrongAnswer1Text);
        data.putExtra("wrong_answer2", wrongAnswer2Text);
        setResult(RESULT_OK, data);
        finish();
    }
}
