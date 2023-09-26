package com.example.lab3_2_phamthiennhi_se150257;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class TraiCayAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<TraiCay> traiCayList;

    public TraiCayAdapter(Context context, int layout, List<TraiCay> traiCayList) {
        this.context = context;
        this.layout = layout;
        this.traiCayList = traiCayList;
    }

    @Override
    public int getCount() {
        return traiCayList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(layout, null);

        TextView tvTen = (TextView) view.findViewById(R.id.tvTen);
        TextView tvMota = (TextView) view.findViewById(R.id.tvMota);
        ImageView imgHinh = (ImageView) view.findViewById(R.id.imgHinh);

        TraiCay traiCay = traiCayList.get(i);
        tvTen.setText(traiCay.getTen());
        tvMota.setText(traiCay.getMota());
        Bitmap bitmap = traiCay.getHinh();
        if (bitmap != null) {
            imgHinh.setImageBitmap(bitmap);
        }

        return view;
    }
}
