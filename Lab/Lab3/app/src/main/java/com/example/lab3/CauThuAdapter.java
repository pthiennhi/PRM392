package com.example.lab3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class CauThuAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<CauThu> cauThuList;

    public CauThuAdapter(Context context, int layout, List<CauThu> cauThuList) {
        this.context = context;
        this.layout = layout;
        this.cauThuList = cauThuList;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public int getLayout() {
        return layout;
    }

    public void setLayout(int layout) {
        this.layout = layout;
    }

    public List<CauThu> getCauThuList() {
        return cauThuList;
    }

    public void setCauThuList(List<CauThu> cauThuList) {
        this.cauThuList = cauThuList;
    }

    @Override
    public int getCount() {
        return cauThuList.size();
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
    public View getView(int i, View view1, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        view1 = inflater.inflate(layout,null);
        TextView txtTen = (TextView) view1.findViewById(R.id.textViewTenCauThu);
        TextView txtMota = (TextView) view1.findViewById(R.id.textViewNgaySinh);
        ImageView imageView = (ImageView) view1.findViewById(R.id.imageViewAvatar);
        ImageView imageView1 = (ImageView) view1.findViewById(R.id.imageViewQuocGia);
        CauThu cauThu = cauThuList.get(i);
        txtTen.setText(cauThu.getName());
        txtMota.setText(cauThu.getDescript());
        Glide.with(view1).load(cauThu.getAvatar()).into(imageView);
        Glide.with(view1).load(cauThu.getCountry()).into(imageView1);
        return view1;
    }
}
