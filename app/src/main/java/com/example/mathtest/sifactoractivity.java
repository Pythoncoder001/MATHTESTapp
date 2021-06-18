package com.example.mathtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.widget.TextView;


import java.util.Calendar;

public class sifactoractivity extends AppCompatActivity {

    public TextView sfac;
    public TextView time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sifactoractivity);

        sfac = findViewById(R.id.text_view_sifac);
        time = findViewById(R.id.text_view_time);

        Thread myThread;

        Runnable runnable = new CountDownRunner();
        myThread = new Thread(runnable);
        myThread.start();

    }

    public void doWork() {
        runOnUiThread(new Runnable() {
            public void run() {
                try {
                    Calendar c = Calendar.getInstance();
                    int sec = c.get(Calendar.SECOND);
                    int min = c.get(Calendar.MINUTE);
                    int hour = c.get(Calendar.HOUR);
                    double spi;
                    String t = hour + ":" + min + ":" + sec;
                    time.setText(t);
                    int num = hour;
                    int factorial = 1;
                    for (int i = 1; i <= num; ++i) {
                        factorial *= i;
                    }
                    spi = (double) (factorial) / ((min * min * min) + sec);
                    sfac.setText("  " + spi);


                } catch (Exception ignored) {
                }
            }
        });
    }

    class CountDownRunner implements Runnable {
        // @Override
        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    doWork();
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } catch (Exception ignored) {
                }
            }


        }
    }
}











