package com.example.lab2;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class CalculatorActivity extends AppCompatActivity {
  Button btnAdd, btnMinus, btnMultiple, btnDivide;
  EditText editTextNumber1, editTextNumber2;
  TextView result;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_calculator);
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    Binding();
    btnAdd.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        String txtNumber1 = editTextNumber1.getText().toString();
        String txtNumber2 = editTextNumber2.getText().toString();
        if(checkLengthDigits(txtNumber1, txtNumber2)){
          if (!txtNumber1.isEmpty() && !txtNumber2.isEmpty()) {
            try {
              Integer num1 = Integer.parseInt(txtNumber1);
              Integer num2 = Integer.parseInt(txtNumber2);
              Integer resultAdd = num1 + num2;
              result.setTextSize(24);
              result.setText(resultAdd.toString());
            } catch (NumberFormatException e) {
              // Handle the case where the input is not a valid integer
              showToast("Input number");
            }

          } else {
            showToast("Input number");
          }

        }
        else {
          showToast("Please input number less than 6 digits");
        }
      }
    });

    btnMinus.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        String txtNumber1 = editTextNumber1.getText().toString();
        String txtNumber2 = editTextNumber2.getText().toString();
        if(checkLengthDigits(txtNumber1, txtNumber2)){
          if (!txtNumber1.isEmpty() && !txtNumber2.isEmpty()) {
            try {
              Integer num1 = Integer.parseInt(txtNumber1);
              Integer num2 = Integer.parseInt(txtNumber2);
              Integer resultMinus = num1 - num2;
              result.setTextSize(24);
              result.setText(resultMinus.toString());
            } catch (NumberFormatException e) {
              // Handle the case where the input is not a valid integer
              showToast("Input number");
            }

          } else {
            showToast("Input number");
          }
        }else {
          showToast("Please input number less than 6 digits");
        }

      }
    });
    btnMultiple.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        String txtNumber1 = editTextNumber1.getText().toString();
        String txtNumber2 = editTextNumber2.getText().toString();
        if(checkLengthDigits(txtNumber1,txtNumber2)){
          if (!txtNumber1.isEmpty() && !txtNumber2.isEmpty()) {
            try {
              Integer num1 = Integer.parseInt(txtNumber1);
              Integer num2 = Integer.parseInt(txtNumber2);
              Integer resultMinus = num1 * num2;
              result.setTextSize(24);
              result.setText(resultMinus.toString());
            } catch (NumberFormatException e) {
              // Handle the case where the input is not a valid integer
              showToast("Input number");
            }

          } else {
            showToast("Input number");
          }
        }else {
          showToast("Please input number less than 6 digits");
        }

      }
    });
    btnDivide.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        String txtNumber1 = editTextNumber1.getText().toString();
        String txtNumber2 = editTextNumber2.getText().toString();
        if(checkLengthDigits(txtNumber1, txtNumber2)){
          if (!txtNumber1.isEmpty() && !txtNumber2.isEmpty()) {
            try {
              Float num1 = Float.parseFloat(txtNumber1);
              Float num2 = Float.parseFloat(txtNumber2);

              if (num2 == 0) {
                showToast("Cannot divide by zero");
              } else {
                Float resultDivide = num1 / num2;
                result.setTextSize(24);
                result.setText(resultDivide.toString());
              }
            } catch (NumberFormatException e) {
              showToast("Input number");
            }
          } else {
            showToast("Input number");
          }
        }else {
          showToast("Please input number less than 6 digits");
        }

      }
    });
  }

  private boolean checkInputEmpty(String number) {
    return number.length() == 0;
  }

  private void Binding() {
    btnAdd = (Button) findViewById(R.id.buttonAdd);
    btnMinus = (Button) findViewById(R.id.buttonMinus);
    btnMultiple = (Button) findViewById(R.id.buttonMutiple);
    btnDivide = (Button) findViewById(R.id.buttonDivide);
    editTextNumber1 = (EditText) findViewById(R.id.editTextNumber1);
    editTextNumber2 = (EditText) findViewById(R.id.editTextNumber2);
    result = (TextView) findViewById(R.id.result);
  }

  private void showToast(String msg) {
    Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
  }

  private boolean checkLengthDigits(String num1, String num2){
    boolean check = false;
    if(num1.length() >6 || num2.length() >6 ){
      check = false;
    }
    else {
      check = true;
    }
    return check;
  }
}