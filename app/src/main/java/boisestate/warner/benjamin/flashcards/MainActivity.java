package boisestate.warner.benjamin.flashcards;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private static Random RANDOM_NUMBER_GENERATOR = new Random();
    private FlashcardDatabase database;
    private List<Flashcard> allFlashCards;
    private int currentDisplayIndex = 0;

    private ArrayList<Button> answerButtons = new ArrayList<Button>();
    private Button correctAnswerButton;
    private TextView flashcardQuestion;

    private void resetAnswerButtonStates() {
        for (Button b : answerButtons)
            b.setBackground(getDrawable(R.drawable.answer_button_shape));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        answerButtons.add((Button)findViewById(R.id.topAnswerButton));
        answerButtons.add((Button)findViewById(R.id.middleAnswerButton));
        answerButtons.add((Button)findViewById(R.id.bottomAnswerButton));
        correctAnswerButton = (Button)findViewById(R.id.middleAnswerButton);
        flashcardQuestion = (TextView)findViewById(R.id.flashcardQuestion);

        loadDatabase();
    }

    private void loadDatabase() {
        database = new FlashcardDatabase(getApplicationContext());
        allFlashCards = this.database.getAllCards();
        if (allFlashCards.size() > 0) {
            setAnswerButtonsAndQuestion(allFlashCards.get(0));
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // If the user cancelled making a new question, we don't want to try and
        // get data that doesn't exist
        if (requestCode == 0 && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            String newQuestion = extras.getString("question");
            String newAnswer = extras.getString("answer");
            String wrongAnswer1 = extras.getString("wrong_answer1");
            String wrongAnswer2 = extras.getString("wrong_answer2");

            database.insertCard(new Flashcard(newQuestion, newAnswer, wrongAnswer1, wrongAnswer2));
            allFlashCards = database.getAllCards();

            resetAnswerButtonStates();
            setAnswerButtonsAndQuestion(newQuestion, newAnswer, wrongAnswer1, wrongAnswer2);
        }
    }

    private void setAnswerButtonsAndQuestion(Flashcard flashcard) {
        setAnswerButtonsAndQuestion(
                flashcard.getQuestion(),
                flashcard.getAnswer(),
                flashcard.getWrongAnswer1(),
                flashcard.getWrongAnswer2()
        );
    }

    private void setAnswerButtonsAndQuestion(String question, String answer, String wrong1, String wrong2) {
        flashcardQuestion.setText(question);
        int correctAnswerButtonIndex = RANDOM_NUMBER_GENERATOR.nextInt(answerButtons.size());
        correctAnswerButton = answerButtons.get(correctAnswerButtonIndex);
        correctAnswerButton.setText(answer);
        int counter = 0;
        for (Button b : answerButtons) {
            if (b.equals(correctAnswerButton))
                continue;
            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    incorrectAnswerClicked(v);
                }
            });
            if (counter == 1)
                b.setText(wrong1);
            else
                b.setText(wrong2);
            counter += 1;
        }
    }

    public void incorrectAnswerClicked(View v) {
        Button incorrectButton = (Button)v;
        incorrectButton.setBackground(getDrawable(R.drawable.incorrect_answer_button_shape));
        correctAnswerButton.setBackground(getDrawable(R.drawable.correct_answer_button_shape));
    }

    public void correctAnswerClicked(View v) {
        correctAnswerButton.setBackground(getDrawable(R.drawable.correct_answer_button_shape));
    }

    public void backgroundClicked(View v) {
        resetAnswerButtonStates();
    }

    public void navigateToAddNewQuestion(View v) {
        ImageView addButton = (ImageView)v;
        Intent intent = new Intent(MainActivity.this, AddQuestionActivity.class);
        intent.putExtra("edit", false);
        MainActivity.this.startActivityForResult(intent, 0);
    }

    public void navigateToEditCurrentQuestion(View v) {
        Intent intent = new Intent(MainActivity.this, AddQuestionActivity.class);
        intent.putExtra("edit", true);
        intent.putExtra("existing_question", flashcardQuestion.getText().toString());
        intent.putExtra("correct_answer", correctAnswerButton.getText().toString());
        MainActivity.this.startActivityForResult(intent, 0);
    }

    public void goToNextQuestion(View v) {
        if (currentDisplayIndex >= allFlashCards.size() - 1)
            return;
        currentDisplayIndex++;
        Flashcard nextCard = allFlashCards.get(currentDisplayIndex);
        setAnswerButtonsAndQuestion(nextCard);
    }

    public void goToPreviousQuestion(View v) {
        if (currentDisplayIndex <= 0)
            return;
        currentDisplayIndex--;
        Flashcard previousCard = allFlashCards.get(currentDisplayIndex);
        setAnswerButtonsAndQuestion(previousCard);
    }
}
