package com.example.demolistview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lvMonhoc;
    ArrayList<String> arrayCourse;
    Button btnCreate, btnUpdate, btnDelete;
    EditText editText;
    int position = -1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Binding();
        arrayCourse = new ArrayList<>();
        arrayCourse.add("Android");
        arrayCourse.add("PHP");
        arrayCourse.add("IOS");
        arrayCourse.add("Unity");

        ArrayAdapter arrayAdapter = new ArrayAdapter(
                MainActivity.this,
                android.R.layout.simple_list_item_1,
                arrayCourse
        );
        lvMonhoc.setAdapter(arrayAdapter);
        lvMonhoc.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                editText.setText(getCourse(i));
                position = i;
            }
        });

        lvMonhoc.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                arrayCourse.remove(i);
                arrayAdapter.notifyDataSetChanged();
                return false;
            }
        });
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newCourse = editText.getText().toString();
                if (newCourse.length() == 0 || checkCourseExisted(newCourse)) {
                    showNotification("create");
                } else {
                    arrayCourse.add(newCourse);
                    arrayAdapter.notifyDataSetChanged();

                }

            }
        });
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (checkPosition() == true) {
                    String updateCourse = editText.getText().toString();
                    arrayCourse.set(position, updateCourse);
                    arrayAdapter.notifyDataSetChanged();
                    position = -1;
                    editText.clearFocus();
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(editText.getWindowToken(), 0);

                    editText.setText("");
                } else {
                    showNotification("update");
                }
            }


        });
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkPosition() == true) {
                    arrayCourse.remove(position);
                    arrayAdapter.notifyDataSetChanged();
                    position = -1;
                    editText.setText("");
                } else {
                    showNotification("update");
                }
            }
        });

    }

    private void Binding() {
        lvMonhoc = (ListView) findViewById(R.id.ListViewMonHoc);
        btnCreate = (Button) findViewById(R.id.buttonCreate);
        btnUpdate = (Button) findViewById(R.id.buttonUpdate);
        btnDelete = (Button) findViewById(R.id.buttonDelete);
        editText = (EditText) findViewById(R.id.editTextCourse);
    }

    private boolean checkPosition() {
        if (position < 0) {
            return false;
        }
        return true;
    }

    private void showNotification(String type) {
        switch (type) {
            case "create":
                Toast.makeText(MainActivity.this, "Please input new course",
                        Toast.LENGTH_LONG).show();
                break;
            case "update":
                Toast.makeText(MainActivity.this, "Please select course",
                        Toast.LENGTH_LONG).show();
                break;
            default:
                break;
        }
    }

    private String getCourse(int position) {
        return arrayCourse.get(position);
    }

    private boolean checkCourseExisted(String courseName) {
        Boolean check = false;
        for (String course : arrayCourse
        ) {
            if (course.equals(courseName)) {
                check = true;
            }

        }
        return check;
    }


}