package com.example.android.healthQuiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int count = 0, x = 0;
    float healthlevel = 0;
    String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void START(View view) {
        question();

    }

    public void YES(View view) {
        x = 0;
        updatehealth(x);
        question();

    }

    public void NO(View view) {
        x = 1;
        updatehealth(x);
        question();
    }

    public void SOMETIMES(View view) {
        count = count + 1;
        question();
    }

    public void RESTART(View view) {
        healthlevel = 0;
        count = 0;
        question();
    }

    public void question() {
        TextView t = (TextView) findViewById(R.id.text_view1);
        switch (count) {
            case 0:
                message = "Do you sleep 8 hours or more?";
                t.setText(message);
                break;
            case 1:
                message = "Do you take atleat 1800 calories daily ?";
                t.setText(message);
                break;
            case 2:
                message = "Do you go for a morning walk daily ? ";
                t.setText(message);
                break;

            case 3:
                message = "Do you drink atleat 2.5 litres of water daily ?";
                t.setText(message);
                break;

            case 4:
                message = "Is your B.M.I(body mass index) is between 18.5 to 24.9 ?\n(  B.M.I = WEIGHT(IN KG)/[SQUARE OF HEIGHT (IN METRES)]  )";
                t.setText(message);
                break;
            case 5:
                message = "Is your haemoglobin level more than:\n 1) 13.5 gm per deciliter or 135 gm per liter(for males)\n2)12 gm per deciliter (for females)";
                t.setText(message);
                break;
            case 6:
                healthlevel = (healthlevel * 100) / count;
                message = "Your quiz has ended." + "\nYour healthlevel is " + healthlevel + "%";
                t.setText(message);
                break;

        }

    }

    public void updatehealth(int x) {
        switch (x) {
            case 0:
                healthlevel = healthlevel + 1;
                count = count + 1;
                break;
            case 1:
                healthlevel = healthlevel - 1;
                count = count + 1;
                break;

        }

    }

}
