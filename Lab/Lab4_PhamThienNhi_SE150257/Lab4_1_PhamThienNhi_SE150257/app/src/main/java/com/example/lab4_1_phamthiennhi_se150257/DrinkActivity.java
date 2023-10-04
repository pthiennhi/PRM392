package com.example.lab4_1_phamthiennhi_se150257;

import android.content.Intent;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import java.util.ArrayList;

public class DrinkActivity extends AppCompatActivity {

  ListView listView;
  DrinkAdapter drinkAdapter;
  ArrayList<Drink> drinkArrayList;

  Drink drink;

  TextView tvTitle;

  Button btnChoose;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_drink);
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    binding();
    tvTitle.setText("Danh sách nước uống");
    drinkArrayList = new ArrayList<>();
    drinkArrayList.add(new Drink("Cafe", "Cafe Việt Nam", R.drawable.cafe));
    drinkArrayList.add(new Drink("Cà phê sữa đá", "Cà phê sữa đá Việt Nam", R.drawable.cafesuada));
    drinkArrayList.add(new Drink("Cà phê sữa nóng", "Cà phê sữa nóng Việt Nam", R.drawable.cafesuanong));
    drinkArrayList.add(new Drink("Coca", "Coca cola Viet Nam", R.drawable.coca));
    drinkArrayList.add(new Drink("Nước cam", "Nước cam Việt Nam", R.drawable.nuoccam));
    drinkArrayList.add(new Drink("Nước suối", "Nước suối Việt Nam", R.drawable.nuocsuoi));

    drinkAdapter = new DrinkAdapter(this, R.layout.food, drinkArrayList);

    listView.setAdapter(drinkAdapter);

    listView.setOnItemClickListener((parent, view, position, id) -> {
      drink = drinkArrayList.get(position);
      drinkAdapter.setSelectedPosition(position);
    });

    btnChoose.setOnClickListener(v -> {
      Intent prevIntent = getIntent();
      Intent intent = new Intent(DrinkActivity.this, MainActivity.class);

      if (drink != null) {
        intent.putExtra("drink", drink);
        intent.putExtra("food", prevIntent.getSerializableExtra("food"));
        startActivity(intent);
        finish();
      }
    });
  }

  public void binding() {
    listView = findViewById(R.id.lvDrink);
    tvTitle = findViewById(R.id.tvTitle);
    btnChoose = findViewById(R.id.btnChoose);
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()) {
      case android.R.id.home:
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        return true;
    }
    return super.onOptionsItemSelected(item);
  }
}