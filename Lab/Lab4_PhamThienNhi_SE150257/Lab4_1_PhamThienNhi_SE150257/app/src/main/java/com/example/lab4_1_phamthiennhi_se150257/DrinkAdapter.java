package com.example.lab4_1_phamthiennhi_se150257;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

public class DrinkAdapter extends BaseAdapter {
  private Context context;
  private int layout;
  private List<Drink> drinkList;
  private int selectedPosition = -1;


  public DrinkAdapter(Context context, int layout, List<Drink> drinkList) {
    this.context = context;
    this.layout = layout;
    this.drinkList = drinkList;
  }

  public int getCount() {
    return this.drinkList.size();
  }

  public Object getItem(int i) {
    return null;
  }

  public long getItemId(int i) {
    return 0;
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
    Drink drink = drinkList.get(i);
    tvName.setText(drink.getName());
    tvDescription.setText(drink.getDescription());
    img.setImageResource(drink.getImage());

    if (i == selectedPosition) {
      view.setBackgroundColor(Color.LTGRAY);
    }
    return view;
  }

}
