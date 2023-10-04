package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class LoginSytemActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_login_sytem);
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
  }
}