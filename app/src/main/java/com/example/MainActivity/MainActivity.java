package com.example.MainActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;

import com.example.myapplication.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Handler;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import LL.VibrationClass;

public class MainActivity extends AppCompatActivity  {

    private EditText timeEditText;

    private VibrationClass vibration;

    private Thread timerThread;
    private boolean isRunning;
    private FloatingActionButton startFloatingActionButton;
    private Handler mHandler = new Handler();
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //playIcon = new Icon();
        setContentView(R.layout.activity_main);
        isRunning = false;
        this.vibration = new VibrationClass(this);
        timeEditText = findViewById(R.id.timeEditText);
        timeEditText.setText("00:00");
        timeEditText.setEnabled(false);
        timeEditText.setFocusable(false);
        timeEditText.setFocusableInTouchMode(false);
        startFloatingActionButton = findViewById(R.id.startFloatingActionButton);
        startFloatingActionButton.setOnClickListener(v -> startButtonHandler());

    }



    private void startButtonHandler() {
        if(!isRunning) {
            isRunning = true;
            this.vibration.vibrateMin();
            this.timerThread = new Thread(()->{
                long timeStart = System.currentTimeMillis();
                while (true) {
                    try {
                        Thread.sleep(100);
                    } catch(InterruptedException e) {
                        System.out.println("Interrupted");
                        break;
                    }
                    long delta =  System.currentTimeMillis() - timeStart;
                    int milis = (int) (delta%1000);
                    int sec = (int) delta/1000;
                    mHandler.postDelayed(() -> timeEditText.setText(String.format("%d:%02d", sec, milis)), 0);
                }
            });
            timerThread.start();
        } else {
            isRunning = false;
            timerThread.interrupt();
        }


    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode==KeyEvent.KEYCODE_VOLUME_DOWN) {
            startButtonHandler();
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}