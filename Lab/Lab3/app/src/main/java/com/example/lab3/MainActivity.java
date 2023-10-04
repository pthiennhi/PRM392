package com.example.lab3;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

  Button btnLab3_1, btnLab3_2;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    Binding();
    btnLab3_1.setOnClickListener(v -> {
      Intent intent = new Intent(MainActivity.this, CourseActivity.class);
      startActivity(intent);
    });

    btnLab3_2.setOnClickListener(v -> {
      Intent intent = new Intent(MainActivity.this, FruitActivity.class);
      startActivity(intent);
    });
  }

  private void Binding() {
    btnLab3_1 = findViewById(R.id.btnLab3_1);
    btnLab3_2 = findViewById(R.id.btnLab3_2);
  }
}