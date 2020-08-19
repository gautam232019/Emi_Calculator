package com.practice.emicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    EditText amount, rate, tenure;
    TextView emi;
    float amt;
    float rt;
    float time;
    float calc_emi;
    float x;
    Button calculatedEMI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        amount = (EditText) findViewById(R.id.loan_amount);
        rate = (EditText) findViewById(R.id.interest_rate);
        tenure = (EditText) findViewById(R.id.loan_tenure);

        emi = (TextView) findViewById(R.id.emi);

        calculatedEMI = (Button) findViewById(R.id.calc);

        calculatedEMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                amt = Float.parseFloat(amount.getText().toString());
                rt = Float.parseFloat(rate.getText().toString());
                time = Float.parseFloat(tenure.getText().toString());

                rt = rt / 1200;
                x = (float) Math.pow((1 + rt), time);

                calc_emi = (float) (amt * rt * x)/(x - 1);

                emi.setText("Rs. " + String.format("%.2f", calc_emi));
            }
        });
    }
}