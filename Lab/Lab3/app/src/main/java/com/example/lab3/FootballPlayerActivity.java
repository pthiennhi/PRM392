package com.example.lab3;

import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import java.util.ArrayList;

public class FootballPlayerActivity extends AppCompatActivity {
  ListView lvcauthu;
  ArrayList<CauThu> arrayCauThu;
  CauThuAdapter adapter;
  int index1 = -1;
  EditText avatar,footballerName, descript1,country;
  ImageView inputImage;
  Button btnAdd, btnDel, btnUpdate, btnClear;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_football_player);
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    AnhXa();
    adapter = new CauThuAdapter(FootballPlayerActivity.this,R.layout.cau_thu_layout,arrayCauThu);
    lvcauthu.setAdapter(adapter);
    Binding();

    lvcauthu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        avatar.setText(arrayCauThu.get(i).getAvatar());
        footballerName.setText(arrayCauThu.get(i).getName());
        descript1.setText(arrayCauThu.get(i).getDescript());
        country.setText(arrayCauThu.get(i).getCountry());
        index1 = i;
      }
    });

    btnAdd.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        if (!avatar.getText().toString().contains(".png") || !country.getText().toString().contains(".png")){
          AlertDialog alertDialog = new AlertDialog.Builder(FootballPlayerActivity.this).create();
          alertDialog.setTitle("Alert");
          alertDialog.setMessage("Image Link phải là .png!");
          alertDialog.show();
        } else if (footballerName.getText().toString().isEmpty()) {
          AlertDialog alertDialog = new AlertDialog.Builder(FootballPlayerActivity.this).create();
          alertDialog.setTitle("Alert");
          alertDialog.setMessage("Bạn chưa nhập tên Cầu Thủ!");
          alertDialog.show();
        }else {
          if (checkDuplicate(footballerName)){
            AlertDialog alertDialog = new AlertDialog.Builder(FootballPlayerActivity.this).create();
            alertDialog.setTitle("Alert");
            alertDialog.setMessage("Cầu thủ này đã có trong danh sách!");
            alertDialog.show();
          }else {
            arrayCauThu.add(new CauThu(avatar.getText().toString(),footballerName.getText().toString(),descript1.getText().toString(),country.getText().toString()));
            adapter.notifyDataSetChanged();
            index1 = -1;
          }
        }
      }
    });

    btnUpdate.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        if (footballerName.getText().toString().isEmpty()) {
          AlertDialog alertDialog = new AlertDialog.Builder(FootballPlayerActivity.this).create();
          alertDialog.setTitle("Alert");
          alertDialog.setMessage("Bạn chưa nhập tên Cầu Thủ!");
          alertDialog.show();
        }else {
          if(index1 != -1){
            arrayCauThu.get(index1).setAvatar(avatar.getText().toString());
            arrayCauThu.get(index1).setName(footballerName.getText().toString());
            arrayCauThu.get(index1).setDescript(descript1.getText().toString());
            arrayCauThu.get(index1).setCountry(country.getText().toString());
            adapter.notifyDataSetChanged();
            index1 = -1;
          }
          else {
            AlertDialog alertDialog = new AlertDialog.Builder(FootballPlayerActivity.this).create();
            alertDialog.setTitle("Alert");
            alertDialog.setMessage("Bạn chưa chọn Cầu Thủ!");
            alertDialog.show();
          }

        }
      }
    });

    btnDel.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        if (footballerName.getText().toString().isEmpty()) {
          AlertDialog alertDialog = new AlertDialog.Builder(FootballPlayerActivity.this).create();
          alertDialog.setTitle("Alert");
          alertDialog.setMessage("Bạn chưa nhập tên Cầu Thủ!");
          alertDialog.show();
        }else {
          if(index1 != -1) {
            arrayCauThu.remove(index1);
            adapter.notifyDataSetChanged();
            index1 = -1;
          }else {
            AlertDialog alertDialog = new AlertDialog.Builder(FootballPlayerActivity.this).create();
            alertDialog.setTitle("Alert");
            alertDialog.setMessage("Bạn chưa chọn Cầu Thủ!");
            alertDialog.show();
          }
        }
      }
    });

    btnClear.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        avatar.setText(null);
        footballerName.setText(null);
        descript1.setText(null);
        country.setText(null);
        index1 = -1;
      }
    });
  }

  private void AnhXa(){
    lvcauthu = (ListView) findViewById(R.id.ListViewCauThu);
    arrayCauThu = new ArrayList<>();
    arrayCauThu.add(new CauThu("https://w7.pngwing.com/pngs/78/184/png-transparent-pele-new-york-cosmos-brazil-national-football-team-world-cup-escape-to-victory-pele-brazil-sport-sports-equipment-painting-thumbnail.png","Pele","October 23, 1940(age 72)","https://purepng.com/public/uploads/large/purepng.com-brazil-flagflagscountrylandflag-83152399610914hbs.png"));
    arrayCauThu.add(new CauThu("https://e7.pngegg.com/pngimages/763/847/png-clipart-t-shirt-thumb-shoulder-turquoise-t-shirt-tshirt-arm.png","Diego Maradona","October 30, 1960(age 52","https://wonderfulengineering.com/wp-content/uploads/2015/07/Argentina-flag-11.png"));
  }

  public void Binding(){
    avatar = (EditText) findViewById(R.id.editTextTextAvatar);
    footballerName = (EditText) findViewById(R.id.editTextTextTenCauThu2);
    descript1 = (EditText) findViewById(R.id.editTextTextNgaySinhCauThu);
    country = (EditText) findViewById(R.id.editTextTextCountry);
    btnAdd = (Button) findViewById(R.id.buttonAddCauthu);
    btnDel = (Button) findViewById(R.id.buttonDeleteCauThu);
    btnUpdate = (Button) findViewById(R.id.buttonUpdateCauThu);
    btnClear = (Button) findViewById(R.id.buttonClearInput);
  }

  public boolean checkDuplicate(EditText footballerName){
    for (int i = 0; i < arrayCauThu.size(); i++) {
      if (arrayCauThu.get(i).getName().equalsIgnoreCase(footballerName.getText().toString())){
        return true;
      }
    }
    return false;
  }
}