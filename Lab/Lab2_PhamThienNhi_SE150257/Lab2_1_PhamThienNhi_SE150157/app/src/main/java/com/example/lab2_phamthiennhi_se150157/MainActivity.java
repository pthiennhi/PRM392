package com.example.lab2_phamthiennhi_se150157;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button btnGenerate;
    EditText editTextMin, editTextMax;
    TextView result, min_max, time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Binding();
        btnGenerate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textMin = editTextMin.getText().toString();
                String textMax = editTextMax.getText().toString();
                Integer min = 1;
                Integer max = 100;
                Integer resultRandom;
                if (!checkEmptyInput(textMin)) {
                    min = Integer.parseInt(textMin);
                } else {
                    editTextMin.setText("1");
                    min = 1;
                }
                if (!checkEmptyInput(textMax)) {
                    max = Integer.parseInt(textMax);
                } else {
                    editTextMax.setText("100");
                    max = 100;
                }
                if (min >= max) {
                    max = min + 1;
                    editTextMax.setText(max.toString());
                }


                Random random = new Random();
                resultRandom = random.nextInt(max - min + 1) + min;
                result.setTextSize(20);
                result.setText(resultRandom.toString());

                String textMinMax = "Min: " + min + ", " + "Max: " + max;
                min_max.setTextSize(16);
                min_max.setText(textMinMax);

                Date date = new Date();
                time.setTextSize(16);
                time.setText(date.toString());

            }
        });
    }

    private void Binding() {
        btnGenerate = findViewById(R.id.buttonGenerate);
        editTextMin = findViewById(R.id.editTextNumberMin);
        editTextMax = findViewById(R.id.editTextNumberMax);
        result = findViewById(R.id.result);
        min_max = findViewById(R.id.min_max);
        time = findViewById(R.id.time);
    }

    private boolean checkEmptyInput(String input) {
        return input.length() == 0;
    }
}