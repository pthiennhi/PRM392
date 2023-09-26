package com.example.lab2_3_phamthiennhi_se150257;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText etUserName;
    private EditText etPassword;
    private EditText etConfirmPassword;
    private TextView tvAlreadyAccount;
    private Button btnSignUp;
    private final String REQUIRE = "Require";


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        etUserName = findViewById(R.id.editUserName);
        etPassword = findViewById(R.id.editTextPassword);
        etConfirmPassword = findViewById(R.id.editTextConfirmPassword);
        tvAlreadyAccount = findViewById(R.id.tvAlreadyAccount);
        btnSignUp = findViewById(R.id.btnSignUp);

        tvAlreadyAccount.setOnClickListener(this);
        btnSignUp.setOnClickListener(this);
    }

    private boolean checkInput()
    {
        if (TextUtils.isEmpty(etUserName.getText().toString()))
        {
            etUserName.setError(REQUIRE);
            return false;
        }

        if (TextUtils.isEmpty(etPassword.getText().toString()))
        {
            etPassword.setError(REQUIRE);
            return false;
        }

        if (TextUtils.isEmpty(etConfirmPassword.getText().toString()))
        {
            etConfirmPassword.setError(REQUIRE);
            return false;
        }

        if (!TextUtils.equals(etPassword.getText().toString(),
                etConfirmPassword.getText().toString()))
        {
            Toast.makeText(this, "Password are not match", Toast.LENGTH_LONG).show();
            return false;
        }

        return true;
    }

    private void signUp()
    {
        if (!checkInput())
        {
            return;
        }
        else {
            Toast.makeText(this, "Sign up successfully", Toast.LENGTH_LONG).show();
            signInForm();
        }
    }

    private void signInForm()
    {
        Intent intent = new Intent(this, SignInActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onClick(View view) {
        int viewId = view.getId();
        if (viewId == R.id.btnSignUp)
        {
            signUp();
        } else if (viewId == R.id.tvAlreadyAccount)
        {
            signInForm();
        }
    }
}
