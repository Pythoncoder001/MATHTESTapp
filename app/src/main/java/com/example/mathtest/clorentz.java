package com.example.mathtest;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Vibrator;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class clorentz extends AppCompatActivity implements View.OnClickListener {


    public EditText input;
    public Button l1;
    public TextView answer;
    public EditText x2;
    public EditText l2;
    public Button check;
    public TextView cres;
    double c = (3 * (Math.pow(10, 8)));
    RelativeLayout layout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clorentz);

        layout = findViewById(R.id.relative_layout_c);
        input = findViewById(R.id.edit_text_var1);
        l1 = findViewById(R.id.button_lorentz_factor);
        answer = findViewById(R.id.text_view_answer);
        x2 = findViewById(R.id.edit_text_s2);
        l2 = findViewById(R.id.edit_text_l2);
        check = findViewById(R.id.button_canswer);
        cres = findViewById(R.id.text_view_canswer);

        check.setOnClickListener(this);
        l1.setOnClickListener(this);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.button_lorentz_factor: {
                if (TextUtils.isEmpty((input.getText().toString())))
                    Toast.makeText(clorentz.this, "Null values not acceptable", Toast.LENGTH_LONG).show();
                else {
                    double in1 = Double.parseDouble(input.getText().toString());
                    double Loren = 1 / (Math.sqrt(1 - (Math.pow((in1 / c), 2))));
                    String fLoren = Double.toString(Loren);

                    if ((c == in1) || (in1 > c) || TextUtils.isEmpty((input.getText().toString()))) {
                        Toast.makeText(clorentz.this, "Invalid input,try again!!",
                                Toast.LENGTH_LONG).show();
                    } else
                        answer.setText(fLoren);
                }
            }
            break;

            case R.id.button_canswer: {
                if ((TextUtils.isEmpty((x2.getText().toString()))) || (TextUtils.isEmpty((l2.getText().toString()))))
                    Toast.makeText(clorentz.this, "Null values not acceptable!", Toast.LENGTH_LONG).show();


                else {
                    double y = Double.parseDouble(x2.getText().toString());
                    double z = Double.parseDouble(l2.getText().toString());
                    double Loren2 = 1 / (Math.sqrt(1 - (Math.pow((y / c), 2))));


                    if (z == Loren2) {
                        cres.setText("Entered lorentz factor is correct");
                        layout.setBackgroundColor(getResources().getColor(R.color.design_default_color_secondary_variant));
                    } else {
                        layout.setBackgroundColor(getResources().getColor(R.color.ba160c));
                        Vibrator vibe = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

                        vibe.vibrate(100);
                        String fLoren1 = Double.toString(Loren2);
                        cres.setText(fLoren1);

                    }
                }
            }
            break;
        }
    }
}




