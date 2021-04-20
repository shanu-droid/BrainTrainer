package example.braintrainer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button goButton;
    TextView sumstext;
    TextView showanswer;
    TextView scoretext;
    TextView timertext;
    ConstraintLayout gamelayout;
    int loactionOfCorrect;
    Button option1;
    Button option2;
    Button option3;
    Button option4;
    Button play;
    int score = 0;
    int numberOfQuestion = 0;
    ArrayList<Integer> answer = new ArrayList<>();
    public void onClicking(View view){
      goButton.setVisibility(View.INVISIBLE);
      ClickingPlay(findViewById(R.id.timerTextView));
      gamelayout.setVisibility(View.VISIBLE);

    }
    public void ClickingPlay(View view){
     score = 0;
     numberOfQuestion = 0;
     timertext.setText("30s");
     scoretext.setText(score +  "/" + numberOfQuestion);
     newQuestion();
     play.setVisibility(View.INVISIBLE);
     Timer();
     showanswer.setText(" ");

    }
    public void ClickAnswer(View view){
      if(Integer.toString(loactionOfCorrect).equals(view.getTag().toString())){
          showanswer.setText(" Correct!! :) ");
         showanswer.setVisibility(View.VISIBLE);
         score ++;

      }
      else{
          showanswer.setText(" Wrong!! :( ");
          showanswer.setVisibility(View.VISIBLE);

      }
      numberOfQuestion++;
      scoretext.setText(score +  "/" + numberOfQuestion);
        newQuestion();

    }
    public void newQuestion(){
        Random rand = new Random();
        int a = rand.nextInt(21);
        int b = rand.nextInt(21);
        sumstext.setText(a + " + " + b);
        loactionOfCorrect = rand.nextInt(4);
        answer.clear();
        for(int i=0; i < 4 ; i++){
            if(i == loactionOfCorrect)  {
                answer.add(a + b);
            }
            else{
                int wrongAnswer = rand.nextInt(41);
                while(wrongAnswer == a+b){
                    wrongAnswer = rand.nextInt(41);
                }
                answer.add(wrongAnswer);
            }
        }
        option1.setText(Integer.toString(answer.get(0)));
        option2.setText(Integer.toString(answer.get(1)));
        option3.setText(Integer.toString(answer.get(2)));
        option4.setText(Integer.toString(answer.get(3)));

    }
    public void Timer(){
        new CountDownTimer(30100,1000){

            @Override
            public void onTick(long millisUntilFinished) {
             timertext.setText(millisUntilFinished/1000 + "s");
            }

            @Override
            public void onFinish() {
            showanswer.setText("Time Out!! :|");
            play.setVisibility(View.VISIBLE);
            }
        }.start();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        goButton = findViewById(R.id.goButton);
        sumstext = findViewById(R.id.sumsTextView);
        showanswer = findViewById(R.id.resultTextView);
        scoretext = findViewById(R.id.scoreTextView);
        timertext = findViewById(R.id.timerTextView);
        play = findViewById(R.id.playAgainButton);
        gamelayout = findViewById(R.id.game_layout);
        option1 = findViewById(R.id.button1);
        option2 = findViewById(R.id.button2);
        option3 = findViewById(R.id.button3);
        option4 = findViewById(R.id.button4);
        goButton.setVisibility(View.VISIBLE);
        gamelayout.setVisibility(View.INVISIBLE);


    }
}
