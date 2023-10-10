package com.example.lab5_phamthiennhi_se150257;

import android.content.Intent;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
  Button btnLab5_1, btnLab5_2;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    btnLab5_1 = findViewById(R.id.btnLab5_1);
    btnLab5_2 = findViewById(R.id.btnLab5_2);
    btnLab5_1.setOnClickListener(v -> {
      Intent intent = new Intent(MainActivity.this, UserActivity.class);
      startActivity(intent);
    });
    btnLab5_2.setOnClickListener(v -> {
      Intent intent = new Intent(MainActivity.this, ModuleActivity.class);
      startActivity(intent);
    });
  }
}