package com.example.mathtest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button lf;
    Button spi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lf = findViewById(R.id.button_lorentz_factor);
        spi = findViewById(R.id.button_spi_factor);
        lf.setOnClickListener(this);
        spi.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_lorentz_factor: {
                Intent intent = new Intent(this, clorentz.class);
                startActivity(intent);
            }
            break;
            case R.id.button_spi_factor: {
                Intent intent = new Intent(this, sifactoractivity.class);
                startActivity(intent);
            }
            break;
        }
    }
}