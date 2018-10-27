package boisestate.warner.benjamin.flashcards;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AddQuestionActivity extends AppCompatActivity {

    EditText questionEditor;
    EditText answerEditor;
    EditText wrongAnswer1Editor;
    EditText wrongAnswer2Editor;

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
        Intent data = new Intent();
        data.putExtra("question", questionEditor.getText().toString());
        data.putExtra("answer", answerEditor.getText().toString());
        data.putExtra("wrong_answer1", wrongAnswer1Editor.getText().toString());
        data.putExtra("wrong_answer2", wrongAnswer2Editor.getText().toString());
        setResult(RESULT_OK, data);
        finish();
    }
}
