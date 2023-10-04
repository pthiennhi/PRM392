package com.example.lab4_3_phamthiennhi_se150257;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import java.io.Serializable;

public class SecondActivity extends AppCompatActivity {

  Button btnSecondActivity;
  TextView txtString, txtNumber, txtArray, txtObject, txtBundle;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_second);
    btnSecondActivity = findViewById(R.id.buttonSecond);

    txtString = findViewById(R.id.txtString);
    txtNumber = findViewById(R.id.txtNumber);
    txtArray = findViewById(R.id.txtArray);
    txtObject = findViewById(R.id.txtObject);
    txtBundle = findViewById(R.id.txtBundle);

    Intent intent = getIntent();
    String name = intent.getStringExtra("string");
    int number = intent.getIntExtra("number", 0);
    int[] array = intent.getIntArrayExtra("array");
    Student student = (Student) intent.getSerializableExtra("student");
    String studentName = student.getName();
    int studentAge = student.getAge();
    Bundle bundle = intent.getBundleExtra("bundle");

    txtString.setText("String: " + name);
    txtNumber.setText("Number: " + number);
    txtArray.setText(
        "Array: " + array[0] + " " + array[1] + " " + array[2] + " " + array[3] + " " + array[4]);

    txtObject.setText("Object:" + studentName + ", " + studentAge);

    if (bundle != null) {
      String name_b = bundle.getString("string_b");
      int number_b = bundle.getInt("number_b", 0);
      String[] array_b = bundle.getStringArray("array_b");
      Student student_b = (Student) bundle.getSerializable("student_b");

      txtBundle.setText("Bundle string: " + name_b + "\n" +
          "Bundle number: " + number_b + "\n" +
          "Bundle array: " + array_b[0] + " " + array_b[1] + " " + array_b[2] + " " + array_b[3]
          + "\n" +
          "Bundle object: " + student_b.getName() + ", " + student_b.getAge());
    }

    btnSecondActivity.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View view) {
        Intent intent = new Intent(SecondActivity.this, MainActivity.class);
        startActivity(intent);
      }
    });

  }
}