package com.example.uselessmachine;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    private Button crash;
    private Switch useless;
    private Button bar;
    private ProgressBar progressbar;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        crash = findViewById(R.id.button_crash_main);
        useless = findViewById(R.id.switch_useless_main);
        bar = findViewById(R.id.button_bar_main);
        progressbar = findViewById(R.id.progressBar_crashprogress_main);
        setListeners();

    }
    private void setListeners()
    {
        bar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                progressBar();
            }
        });


        crash.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {


                new CountDownTimer(10000, 1000)
                {
                    private int count = 10;


                    @Override
                    public void onTick(long l)
                    {
                        useless.setText(String.valueOf(count));
                        count--;


                    }

                    @Override
                    public void onFinish()
                    {

                        count = 10;
                        finish();
                    }

                }.start();





            }
        });
        useless.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isSwitched) {
                if(isSwitched)
                {
                    Toast.makeText(MainActivity.this, "NUKE INCOMING!", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(MainActivity.this, "KIM JONG UN", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private void progressBar()
    {
        progressbar.setProgress(0);
        progressbar.setVisibility(View.VISIBLE);
        useless.setVisibility(View.INVISIBLE);
        crash.setVisibility(View.INVISIBLE);
        bar.setVisibility(View.INVISIBLE);

        new CountDownTimer(10000, 1000)
        {

            int count = 0;

            @Override
            public void onTick(long l)
            {

                count++;
                progressbar.setProgress(count);

            }
            public void onFinish()
            {
                useless.setVisibility(View.VISIBLE);
                crash.setVisibility(View.VISIBLE);
                progressbar.setVisibility(View.INVISIBLE);
                progressbar.setProgress(0);
                bar.setVisibility(View.VISIBLE);
            }

        }.start();


    }


}
