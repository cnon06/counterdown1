package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btn1;
    TextView txt1;
     CountDownTimer cDt;
     int count=0;
    long timeLeftInMilliseconds=10000;
    boolean timerRunning;

    //Sinan


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 =(Button) findViewById(R.id.btn1);
        txt1 =(TextView) findViewById(R.id.txt1);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startStop();

            }
        });

    }


    public void startStop()
    {
        if(timerRunning)
        {
            stopTimer();
            btn1.setText("Start");
            timerRunning=false;
        }
        else
        {
            startTimer();
            btn1.setText("Pause");
            timerRunning=true;
        }
    }


    public  void startTimer()
    {
        cDt = new CountDownTimer(timeLeftInMilliseconds,100) {
            @Override
            public void onTick(long millisUntilFinished) {
                count++;
                txt1.setText(count+"");


            }

            @Override
            public void onFinish() {

            }
        }.start();
    }

    public  void stopTimer()
    {
            cDt.cancel();
    }


}