package com.example.assignment_1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    public Button cal_button;
    public TextView princ_input,interest_input, period_input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       cal_button =  findViewById(R.id.calculate_button);

        princ_input = findViewById(R.id.principle_input);
        interest_input = findViewById(R.id.interest_input);
        period_input= findViewById(R.id.period_input);


        cal_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double numerator;
                double denominator;
                double principle = Double.parseDouble(princ_input.getText().toString());
                double interest = Double.parseDouble(interest_input.getText().toString());
                int period = Integer.parseInt(period_input.getText().toString());
                period = period * 12;
                interest = (interest/ 100)/12;

                double a= (1 + interest);
                numerator = interest *(Math.pow( a , period));
                denominator = (Math.pow( a , period)) - 1;
                double result =(principle * (numerator / denominator));

                String passing = (String.format("%.2f", result));
                //System.out.println("the result is "+ passing);


                Intent intent = new Intent(MainActivity.this, result_page.class);
                intent.putExtra("cal", passing);
                startActivity(intent);
            }
        });


    }

}