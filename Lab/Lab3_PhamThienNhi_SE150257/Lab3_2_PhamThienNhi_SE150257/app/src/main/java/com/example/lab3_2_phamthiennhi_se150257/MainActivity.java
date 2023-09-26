package com.example.lab3_2_phamthiennhi_se150257;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvtraicay;
    ArrayList<TraiCay> arrayTraicay;
    TraiCayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AnhXa();

        adapter = new TraiCayAdapter(this, R.layout.dong_trai_cay, arrayTraicay);
        lvtraicay.setAdapter(adapter);
    }

    private void AnhXa() {
        lvtraicay = (ListView) findViewById(R.id.lvTraicay);
        arrayTraicay = new ArrayList<>();
        arrayTraicay.add(new TraiCay("Chuoi tieu", "dd", R.drawable.ic_launcher_background));
        arrayTraicay.add(new TraiCay("Chuoi tieu", "dd", R.drawable.ic_launcher_background));
        arrayTraicay.add(new TraiCay("Chuoi tieu", "dd", R.drawable.ic_launcher_background));
    }
}