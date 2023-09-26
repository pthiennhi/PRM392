package com.example.lab2_3_phamthiennhi_se150257;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SignInActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText etUserName;
    private EditText etPassword;
    private TextView tvNotAccount;
    private Button btnSignIn;
    private final String REQUIRE = "Require";

    private int btnSignInId;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        etUserName = findViewById(R.id.editUserName);
        etPassword = findViewById(R.id.editTextPassword);
        tvNotAccount = findViewById(R.id.tvNotAccountYet);
        btnSignIn = findViewById(R.id.btnSignIn);

        tvNotAccount.setOnClickListener(this);
        btnSignIn.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        int viewId = view.getId();
        if (viewId == R.id.btnSignIn) {
            signIn();
        } else if (viewId == R.id.tvNotAccountYet) {
            signUpForm();
        }
    }

    private boolean checkInput() {
        if (TextUtils.isEmpty(etUserName.getText().toString())) {
            etUserName.setError(REQUIRE);
            return false;
        }

        if (TextUtils.isEmpty(etPassword.getText().toString())) {
            etPassword.setError(REQUIRE);
            return false;
        }

        return true;
    }

    private void signIn() {
        if (!checkInput()) {
            return;
        }

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    private void signUpForm() {
        Intent intent = new Intent(this, SignUpActivity.class);
        startActivity(intent);
        finish();
    }
}
