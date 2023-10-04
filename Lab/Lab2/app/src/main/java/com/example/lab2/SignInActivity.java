package com.example.lab2;

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
import java.util.ArrayList;
import java.util.List;

public class SignInActivity extends AppCompatActivity implements View.OnClickListener {

  private EditText etUserName;
  private EditText etPassword;
  private TextView tvNotAccount;
  private Button btnSignIn;
  private final String REQUIRE = "Require";


  List<User> userList = new ArrayList<>();
  private int btnSignInId;

  @SuppressLint("MissingInflatedId")
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_sign_in);
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    Intent intent = getIntent();
    if (intent != null) {
      String userName = intent.getStringExtra("userName");
      String password = intent.getStringExtra("password");
      if (userName != null && password != null) {
        userList.add(new User(userName, password));
      }

    }

    userList.add(new User("admin", "admin"));
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
    String userName = etUserName.getText().toString();
    String password = etPassword.getText().toString();
    if (checkExistUser(userName, password)) {
      Intent intent = new Intent(this, LoginSytemActivity.class);
      startActivity(intent);
      finish();
    } else {
      Toast.makeText(this, "User not exist", Toast.LENGTH_LONG).show();
    }

  }

  private void signUpForm() {
    Intent intent = new Intent(this, SignUpActivity.class);
    startActivity(intent);
    finish();
  }

  private boolean checkExistUser(String userName, String password) {
    for (int i = 0; i < userList.size(); i++) {
      if (userName.equals(userList.get(i).getUserName()) && password
          .equals(userList.get(i).getPassword())) {
        return true;
      }
    }
    return false;
  }
}