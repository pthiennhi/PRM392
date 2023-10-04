package com.example.lab4_1_phamthiennhi_se150257;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.io.Serializable;
import java.util.ArrayList;

public class FoodActivity extends AppCompatActivity {

  ListView listView;
  FoodAdapter foodAdapter;

  Food food;

  ArrayList<Food> foodArrayList;

  TextView tvTitle;

  Button btnChoose;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_food);
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    binding();
    tvTitle.setText("Danh sách món ăn");
    foodArrayList = new ArrayList<>();
    foodArrayList.add(new Food("Bánh mì", "Bánh mì Việt Nam", R.drawable.banhmi));
    foodArrayList.add(new Food("Bún đậu mắm tôm", "Bún đậu mắm tôm Việt Nam", R.drawable.bundau));
    foodArrayList.add(new Food("Bún chả", "Bún chả Việt Nam", R.drawable.buncha));
    foodArrayList.add(new Food("Bún bò Huế", "Bún bò Huế Việt Nam", R.drawable.bunbohue));
    foodArrayList.add(
        new Food("Bún thịt nướng", "Bún thịt nướng Việt Nam", R.drawable.bunthitnuong));
    foodArrayList.add(new Food("Cơm tấm", "Cơm tấm Việt Nam", R.drawable.comtam));

    foodAdapter = new FoodAdapter(this, R.layout.food, foodArrayList);
    listView.setAdapter(foodAdapter);

    listView.setOnItemClickListener((parent, view, position, id) -> {
      food = foodArrayList.get(position);
      foodAdapter.setSelectedPosition(position);

    });

    btnChoose.setOnClickListener(v -> {
      Intent prevIntent = getIntent();
      Intent intent = new Intent(FoodActivity.this, MainActivity.class);
      
      if (food != null) {
        Toast.makeText(this, food.getName(), Toast.LENGTH_SHORT).show();
        intent.putExtra("food", (Serializable) food);
        intent.putExtra("drink", prevIntent.getSerializableExtra("drink"));
        startActivity(intent);
        finish();
      } else {
        Toast.makeText(this, "Chưa chọn món ăn", Toast.LENGTH_SHORT).show();
      }

    });
  }

  public void binding() {
    listView = findViewById(R.id.lvFood);
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