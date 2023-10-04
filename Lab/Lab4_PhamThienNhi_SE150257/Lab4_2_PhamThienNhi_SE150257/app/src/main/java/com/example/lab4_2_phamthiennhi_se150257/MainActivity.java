package com.example.lab4_2_phamthiennhi_se150257;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends Activity {

  Button btnSecondActivity;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    btnSecondActivity = findViewById(R.id.buttonMain);
    btnSecondActivity.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        startActivity(intent);
      }
    });

    Log.d("MainActivity", "onCreate Main");

  }

  @Override
  protected void onRestart() {
    super.onRestart();
    Log.d("MainActivity", "onRestart Main");
  }

  @Override
  protected void onResume() {
    super.onResume();
    Log.d("MainActivity", "onResume Main");
  }

  @Override
  protected void onPause() {
    super.onPause();
    Log.d("MainActivity", "onPause Main");
  }

  @Override
  protected void onStop() {
    super.onStop();
    Log.d("MainActivity", "onStop Main");
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
    Log.d("MainActivity", "onDestroy Main");
  }
}