package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quizapp.Data.Question;

public class MainActivity extends AppCompatActivity {
    int currentQuest = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String[] questions = new String[5];
        boolean[] responses = new boolean[5];
        Question question1 = new Question("Are snails vertebrates?", false);
        questions[0]=question1.getQuestion();
        responses[0]=question1.isYes();
        Question question2 = new Question("Is Argentina in Europe?", false);
        questions[1]=question2.getQuestion();
        responses[1]=question2.isYes();
        Question question3 = new Question("Is this operation right? 20x20=400", true);
        questions[2]=question3.getQuestion();
        responses[2]=question3.isYes();
        Question question4 = new Question("Is James Gosling the creator of the Java language?" , true);
        questions[3]=question4.getQuestion();
        responses[3]=question4.isYes();
        Question question5 = new Question("Do penguins fly?", false);
        questions[4]=question5.getQuestion();
        responses[4]=question5.isYes();


        TextView questionText = (TextView) findViewById(R.id.question);
        questionText.setText(question1.getQuestion());
        Button buttonYes = findViewById(R.id.buttonYes);
        Button buttonNo = findViewById(R.id.buttonNo);
        ImageButton buttonNext = findViewById(R.id.next);
        ImageButton buttonPrevious = findViewById(R.id.previous);
        buttonPrevious.setEnabled(false);

        buttonYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(responses[currentQuest]){
                    Toast.makeText(MainActivity.this, "Correct!", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "Incorrect!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        buttonNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(responses[currentQuest]){
                    Toast.makeText(MainActivity.this, "Incorrect!", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "Correct!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonPrevious.setEnabled(true);
                currentQuest++;
                questionText.setText(questions[currentQuest]);
                if(currentQuest==4){
                    buttonNext.setEnabled(false);
                }
            }
        });

        buttonPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonNext.setEnabled(true);
                currentQuest--;
                questionText.setText(questions[currentQuest]);
                if(currentQuest==0){
                    buttonPrevious.setEnabled(false);
                }
            }
        });
    }

}