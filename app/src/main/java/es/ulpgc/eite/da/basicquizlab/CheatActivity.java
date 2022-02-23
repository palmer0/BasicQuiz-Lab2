package es.ulpgc.eite.da.basicquizlab;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CheatActivity extends AppCompatActivity {

  public static final String TAG = "Quiz.CheatActivity";

  public final static String EXTRA_INDEX = "EXTRA_INDEX";
  public final static String EXTRA_ANSWER = "EXTRA_ANSWER";
  public final static String EXTRA_CHEATED = "EXTRA_CHEATED";

  private Button noButton, yesButton;
  private TextView answerText;

  private int currentAnswer;
  private boolean answerCheated;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_cheat);

    getSupportActionBar().setTitle(R.string.cheat_title);

    initLayoutData();
    linkLayoutComponents();
    enableLayoutButtons();
  }

  private void initLayoutData() {
    //currentAnswer = getIntent().getExtras().getInt(EXTRA_ANSWER);
    int questionIndex = getIntent().getExtras().getInt(EXTRA_INDEX);

    //questionArray=getResources().getStringArray(R.array.question_array);
    int[] replyArray = getResources().getIntArray(R.array.reply_array);
    currentAnswer = replyArray[questionIndex];

    Log.d(TAG, "questionIndex: " + questionIndex);
    Log.d(TAG, "currentAnswer: " + currentAnswer);
  }


  private void linkLayoutComponents() {
    noButton = findViewById(R.id.noButton);
    yesButton = findViewById(R.id.yesButton);

    answerText = findViewById(R.id.answerText);
  }

  private void enableLayoutButtons() {

    noButton.setOnClickListener(v -> onNoButtonClicked());
    yesButton.setOnClickListener(v -> onYesButtonClicked());
  }

  private void onYesButtonClicked() {

    /*
    yesButton.setEnabled(false);
    noButton.setEnabled(false);
    */

    answerCheated = true;

    if(currentAnswer == 0) {
      answerText.setText(R.string.false_text);
    } else {
      answerText.setText(R.string.true_text);

    }

    returnCheatedStatus();

  }

  private void onNoButtonClicked() {
    /*
    yesButton.setEnabled(false);
    noButton.setEnabled(false);
    */

    //returnCheatedStatus();

    //Intent intent = new Intent(CheatActivity.this, QuestionActivity.class);
    //startActivity(intent);

    finish();
  }




  private void returnCheatedStatus() {
    Log.d(TAG, "returnCheatedStatus()");
    Log.d(TAG, "answerCheated: " + answerCheated);

    Intent intent = new Intent();
    intent.putExtra(EXTRA_CHEATED, answerCheated);
    setResult(RESULT_OK, intent);

    //finish();
  }


  /*


  @Override
  public void onBackPressed() {
    Log.d(TAG, "onBackPressed()");

    returnCheatedStatus();
  }



  */
}
