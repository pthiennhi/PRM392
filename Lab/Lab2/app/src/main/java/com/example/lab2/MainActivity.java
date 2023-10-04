package com.example.lab2;

import android.content.Intent;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
  Button btnLab2_1, btnLab2_2, btnLab2_3;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    init();
    btnLab2_1.setOnClickListener(v -> {
      Intent intent = new Intent(MainActivity.this, RandomGeneratorActivity.class);
      startActivity(intent);
    });

    btnLab2_2.setOnClickListener(v -> {
      Intent intent = new Intent(MainActivity.this, CalculatorActivity.class);
      startActivity(intent);
    });

    btnLab2_3.setOnClickListener(v -> {
      Intent intent = new Intent(MainActivity.this, SignInActivity.class);
      startActivity(intent);
    });

  }

  private void init() {
    btnLab2_1 = findViewById(R.id.btnLab2_1);
    btnLab2_2 = findViewById(R.id.btnLab2_2);
    btnLab2_3 = findViewById(R.id.btnLab2_3);
  }
}