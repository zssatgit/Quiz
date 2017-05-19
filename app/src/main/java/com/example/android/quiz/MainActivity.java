package com.example.android.quiz;

import android.content.Context;
import android.media.Rating;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.android.quiz.R.id.q1c;
import static com.example.android.quiz.R.id.q2c;
import static com.example.android.quiz.R.id.q3a;
import static com.example.android.quiz.R.id.q4b;
import static com.example.android.quiz.R.id.q5a;
import static com.example.android.quiz.R.id.q5d;
import static com.example.android.quiz.R.id.score;
import static com.example.android.quiz.R.string.question1;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submit(View view) {
        int score = 0;
        EditText name = (EditText) findViewById(R.id.name_field);
        RadioButton q1c, q2c, q3a, q4b;
        CheckBox q5a, q5d;
        RatingBar star = (RatingBar) findViewById(R.id.score);
        TextView ans = (TextView) findViewById(R.id.ans);
        TextView answerText = (TextView) findViewById(R.id.answer);

        q1c = (RadioButton) findViewById(R.id.q1c);
        q2c = (RadioButton) findViewById(R.id.q2c);
        q3a = (RadioButton) findViewById(R.id.q3a);
        q4b = (RadioButton) findViewById(R.id.q4b);
        q5a = (CheckBox) findViewById(R.id.q5a);
        q5d = (CheckBox) findViewById(R.id.q5d);

        boolean q1 = q1c.isChecked();
        boolean q2 = q2c.isChecked();
        boolean q3 = q3a.isChecked();
        boolean q4 = q4b.isChecked();
        boolean q5 = q5a.isChecked() && q5d.isChecked();

        if (q1) {
            score += 1;
        }
        if (q2) {
            score += 1;
        }
        if (q3) {
            score += 1;
        }
        if (q4) {
            score += 1;
        }

        if (name.getText().toString().equals("")) {
            Toast.makeText(getApplicationContext(), "Please enter your name!",
                    Toast.LENGTH_SHORT).show();
            return;
        }

        star.setRating(score);
        ans.setText(getString(R.string.ans));
        String answer = "1. Sesame" + "\n2. Temperate" + "\n3. Consistency" + "\n4. Haft" +
                "\n5. Shanghai, Beijing";
        answerText.setText(answer);
        if (score == 5) {
            Toast.makeText(getApplicationContext(), "Congrats, " + name.getText().toString() + "!",
                    Toast.LENGTH_LONG).show();
        }
    }
}
