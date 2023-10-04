package com.example.lab4_1_phamthiennhi_se150257;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

public class FoodAdapter extends BaseAdapter {

  private Context context;
  private int layout;
  private List<Food> foodList;

  private int selectedPosition = -1;


  public FoodAdapter(Context context, int layout, List<Food> foodList) {
    this.context = context;
    this.layout = layout;
    this.foodList = foodList;
  }

  public int getCount() {
    return this.foodList.size();
  }

  public Object getItem(int i) {
    return null;
  }

  public long getItemId(int i) {
    return i;
  }

  public void setSelectedPosition(int position) {
    selectedPosition = position;
    notifyDataSetChanged();
  }

  public View getView(int i, View view, ViewGroup viewGroup) {
    LayoutInflater inflater = (LayoutInflater) context.getSystemService(
        context.LAYOUT_INFLATER_SERVICE);
    view = inflater.inflate(layout, null);
    TextView tvName = (TextView) view.findViewById(R.id.tvName);
    TextView tvDescription = (TextView) view.findViewById(R.id.tvDescription);
    ImageView img = (ImageView) view.findViewById(R.id.imageofObject);
    Food food = foodList.get(i);
    tvName.setText(food.getName());
    tvDescription.setText(food.getDescription());
    img.setImageResource(food.getImage());

    if (i == selectedPosition) {
      view.setBackgroundColor(Color.LTGRAY);
    }
    return view;
  }


}
