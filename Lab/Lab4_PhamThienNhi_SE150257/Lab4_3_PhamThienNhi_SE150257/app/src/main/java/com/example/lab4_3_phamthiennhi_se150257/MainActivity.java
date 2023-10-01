package com.example.lab4_3_phamthiennhi_se150257;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import java.io.Serializable;

public class MainActivity extends AppCompatActivity {

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
        Student student = new Student("Thien Nhi", 20);

        intent.putExtra("string", "Hello Thien Nhi");
        intent.putExtra("number", 123);
        intent.putExtra("array", new int[]{1, 2, 3, 4, 5});
        intent.putExtra("student", (Serializable) student);

        Bundle bundle = new Bundle();
        bundle.putString("string_b", "Hello Thien");
        bundle.putInt("number_b", 321);
        bundle.putStringArray("array_b", new String[]{"a", "b", "c", "d", "e"});
        bundle.putSerializable("student_b", (Serializable) student);
        intent.putExtra("bundle", bundle);

        startActivity(intent);
      }
    });


  }
}