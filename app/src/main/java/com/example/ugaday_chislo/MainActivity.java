package com.example.ugaday_chislo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvInfo;
    EditText etInput;
    Button bControl;
    int guess;
    boolean gameFinished;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        tvInfo = (TextView)findViewById(R.id.textView2);
        etInput = (EditText)findViewById(R.id.editTextNumber2);
        bControl = (Button)findViewById(R.id.button2);

        guess = (int)(Math.random()*100);
        gameFinished = false;



    }

    public void onClick(View v){

        if (!gameFinished) {
            int inp = Integer.parseInt(etInput.getText().toString());
            if (inp > guess)
               tvInfo.setText(getResources().getString(R.string.ahead));
            if (inp < guess)
                tvInfo.setText("Недолдет!");
            if (inp == guess)
            {
               tvInfo.setText("В точку!");
               bControl.setText(getResources().getString(R.string.play_more));
               gameFinished=true;

            }
            if (inp == guess)
            {
                tvInfo.setText("В точку!");
                etInput.setText(("0"));
            }

        }
        else
        {
            guess = (int)Math.random()*100;
            bControl.setText("Ввести значение");
            tvInfo.setText(getResources().getString(R.string.try_to_guess));
            gameFinished=false;
        }
    }
}