package com.example.lab4_2_phamthiennhi_se150257;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class SecondActivity extends AppCompatActivity {

  Button btnSecondActivity;
  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_second);
    btnSecondActivity = findViewById(R.id.buttonSecond);

    btnSecondActivity.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View view) {
        Intent intent = new Intent(SecondActivity.this, MainActivity.class);
        startActivity(intent);
      }
    });

  }

  @Override
  protected void onStart() {
    super.onStart();
    Log.d("SecondActivity", "onStart Second");
  }

  @Override
  protected void onResume() {
    super.onResume();
    Log.d("SecondActivity", "onResume Second");
  }

  @Override
  protected void onRestart() {
    super.onRestart();
    Log.d("SecondActivity", "onRestart Second");
  }
}