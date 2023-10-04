package com.example.lab4_1_phamthiennhi_se150257;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

  Button btnSelectFood, btnSelectDrink, btnExit;
  TextView tvFood, tvDrink;
  String foodName, drinkName;
  Food food;
  Drink drink;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

//    if (savedInstanceState != null) {
//      Log.d("CCC", "savedInstanceState ne");
////      if ((Food) savedInstanceState.getSerializable("food") != null) {
////        Log.d("CCC", "food ne");
////        food = (Food) savedInstanceState.getSerializable("food");
////      }
////      if ((Drink) savedInstanceState.getSerializable("drink") != null) {
////        Log.d("CCC", "drink ne");
////        drink = (Drink) savedInstanceState.getSerializable("drink");
////      }
//      foodName = savedInstanceState.getString("foodName");
//      drinkName = savedInstanceState.getString("drinkName");
//    }

    setContentView(R.layout.activity_main);
    AppManager.getInstance().addActivity(this);
    binding();
    btnSelectFood.setOnClickListener(v -> {
      Intent intent = new Intent(MainActivity.this, FoodActivity.class);
      if (food != null) {
        intent.putExtra("food", food);
      }
      if (drink != null) {
        intent.putExtra("drink", drink);
      }
      startActivity(intent);
    });
    btnSelectDrink.setOnClickListener(v -> {
      Intent intent = new Intent(MainActivity.this, DrinkActivity.class);
      if (food != null) {
        intent.putExtra("food", food);
      }
      if (drink != null) {
        intent.putExtra("drink", drink);
      }
      startActivity(intent);
    });
    btnExit.setOnClickListener(v -> {
      AppManager.getInstance().exitApp();
    });

    Intent intent = getIntent();
    if ((Food) intent.getSerializableExtra("food") != null) {
      Log.d("CCC", "food ne");
      food = (Food) intent.getSerializableExtra("food");
    }

    if ((Drink) intent.getSerializableExtra("drink") != null) {
      Log.d("CCC", "drink ne");
      drink = (Drink) intent.getSerializableExtra("drink");
    }

    if (food != null) {
      foodName = food.getName();
    }
    if (drink != null) {
      drinkName = drink.getName();
    }

    tvFood.setText(foodName);
    tvDrink.setText(drinkName);
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();

    AppManager.getInstance().removeActivity(this);
  }


  public void binding() {
    btnSelectFood = findViewById(R.id.btnSelectFood);
    btnSelectDrink = findViewById(R.id.btnSelectDrink);
    btnExit = findViewById(R.id.btnExit);
    tvFood = findViewById(R.id.tvFood);
    tvDrink = findViewById(R.id.tvDrink);
  }

  @Override
  protected void onSaveInstanceState(Bundle savedInstanceState) {
    super.onSaveInstanceState(savedInstanceState);

//    if (food != null) {
//      Log.d("CCC", food.getName() + "luu");
//      savedInstanceState.putString("foodName", food.getName());
//    }
//    if (drink != null) {
//      Log.d("CCC", drink.getName() + "luu");
//      savedInstanceState.putString("drinkName", drink.getName());
//    }

  }

//  @Override
//  protected void onRestoreInstanceState(Bundle savedInstanceState) {
//    super.onRestoreInstanceState(savedInstanceState);
//
//    Log.d("CCC", "onRestoreInstanceState");
//    food = (Food) savedInstanceState.getSerializable("food");
//    drink = (Drink) savedInstanceState.getSerializable("drink");
//  }
}