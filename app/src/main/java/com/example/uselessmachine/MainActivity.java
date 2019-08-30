package com.example.uselessmachine;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    private Button crash;
    private Switch useless;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        crash = findViewById(R.id.button_crash_main);
        useless = findViewById(R.id.switch_useless_main);
        setListeners();






        {

        }
    }
    private void setListeners()
    {


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
                        useless.setText(count);
                        count--;


                    }

                    @Override
                    public void onFinish()
                    {
                        System.exit(0);
                        count = 10;
                    }

                };





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

    private void crashTheApp()
    {

    }


}
