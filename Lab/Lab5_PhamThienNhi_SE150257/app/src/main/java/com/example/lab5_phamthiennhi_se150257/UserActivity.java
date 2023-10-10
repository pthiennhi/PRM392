package com.example.lab5_phamthiennhi_se150257;

import android.os.Bundle;
import android.os.Debug;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.lab5_phamthiennhi_se150257.adapter.UserAdapter;
import java.util.ArrayList;

public class UserActivity extends AppCompatActivity  implements UserAdapter.OnItemClickListener{

  ArrayList<User> userlist;
  Button btnAdd, btnDelete, btnUpdate;

  EditText edtUsername, edtFullname, edtEmail;
  int position = -1;
  RecyclerView rvUser;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_user);
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    initView();
    RecyclerView rvUser = findViewById(R.id.rvUser);
    userlist = new ArrayList<>();
    userlist.add(new User("NguyenTT", "Tran Thanh Nguyen", "Nguyentt@ftp.edu.vn"));
    userlist.add(new User("Antv", "Tran Van An", "antv@gmail.com"));
    userlist.add(new User("BangTT", "Tran Thanh Bang", "bangtt@gmail.com"));
    userlist.add(new User("KhangTT", "Tran Thanh Khang", "khangtt@gmail.com"));
    userlist.add(new User("BaoNT", "Nguyen Thanh Bao", "baott@gmail.com"));
    userlist.add(new User("HungVH", "VO Huy Hung", "hungvh@gmail.com"));
    updateRecyclerView();


    btnAdd.setOnClickListener(v -> {
      String username = edtUsername.getText().toString();
      String fullname = edtFullname.getText().toString();
      String email = edtEmail.getText().toString();
      if(username.isEmpty() || fullname.isEmpty() || email.isEmpty()) {
        Toast.makeText(this, "Please enter all fields", Toast.LENGTH_SHORT).show();
        return;
      } else {
        for(User user : userlist) {
          if(user.getUsername().equals(username)) {
            Toast.makeText(this, "Username already exists", Toast.LENGTH_SHORT).show();
            return;
          }
        }
        userlist.add(0, new User(username, fullname, email));
        updateRecyclerView();
        Toast.makeText(this, "Add successfully", Toast.LENGTH_SHORT).show();
        clearForm();
      }
    });

    btnUpdate.setOnClickListener(v -> {
      String username = edtUsername.getText().toString();
      String fullname = edtFullname.getText().toString();
      String email = edtEmail.getText().toString();

        if(position == -1) {
          Toast.makeText(this, "Please select a user", Toast.LENGTH_SHORT).show();
          return;
        } else {
          userlist.get(position).setUsername(username);
          userlist.get(position).setFullname(fullname);
          userlist.get(position).setEmail(email);

          updateRecyclerView();
          Toast.makeText(this, "Update successfully", Toast.LENGTH_SHORT).show();
          clearForm();
          rvUser.scrollToPosition(position);
          position = -1;
      }
    });

    btnDelete.setOnClickListener(v -> {
      if(position == -1) {
        Toast.makeText(this, "Please select a user", Toast.LENGTH_SHORT).show();
        return;
      } else {
        userlist.remove(position);
        updateRecyclerView();
        Toast.makeText(this, "Delete successfully", Toast.LENGTH_SHORT).show();
        clearForm();
        position = -1;
      }
    });
  }

  private void initView() {
    btnAdd = findViewById(R.id.btnAdd);
    btnDelete = findViewById(R.id.btnDelete);
    btnUpdate = findViewById(R.id.btnEdit);
    edtUsername = findViewById(R.id.edtUsername);
    edtFullname = findViewById(R.id.edtFullname);
    edtEmail = findViewById(R.id.edtEmail);
    rvUser = findViewById(R.id.rvUser);
  }

  private void clearForm() {
    edtUsername.setText("");
    edtFullname.setText("");
    edtEmail.setText("");
  }

  private void setForm(User user) {
    edtUsername.setText(user.getUsername());
    edtFullname.setText(user.getFullname());
    edtEmail.setText(user.getEmail());
  }

  private void updateRecyclerView() {
    UserAdapter adapter = new UserAdapter(userlist, this);

    rvUser.setAdapter(adapter);
    rvUser.setLayoutManager(new LinearLayoutManager(this));
  }

  @Override
  public void onItemClick(User user, int position) {
    this.position = position;
    setForm(user);
  }
}