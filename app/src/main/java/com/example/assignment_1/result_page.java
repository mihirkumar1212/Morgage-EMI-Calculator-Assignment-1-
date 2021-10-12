package com.example.assignment_1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class result_page extends AppCompatActivity {
    public Button back_button;
    public TextView pay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_page);

        pay = (TextView) findViewById(R.id.my_payemnt);

       String payment = getIntent().getStringExtra("cal");
        pay.setText(payment);

        back_button = (Button) findViewById(R.id.back);
        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(result_page.this, MainActivity.class);
                startActivity(intent);
            }
        });


    }
}