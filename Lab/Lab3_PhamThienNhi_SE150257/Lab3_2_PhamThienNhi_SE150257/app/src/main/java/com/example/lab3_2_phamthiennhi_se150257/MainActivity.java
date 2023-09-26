package com.example.lab3_2_phamthiennhi_se150257;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import androidx.core.content.ContextCompat;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

  ListView lvtraicay;
  ArrayList<TraiCay> arrayTraicay;
  TraiCayAdapter adapter;

  Button btnCreate, btnUpdate, btnDelete, btnImportImage;
  ImageView imgHinh;
  EditText edtTen, edtMota;

  Bitmap selectedImage;

  private ActivityResultLauncher<Intent> galleryLauncher;

  int position = -1;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    Binding();
    AnhXa();
    adapter = new TraiCayAdapter(this, R.layout.dong_trai_cay, arrayTraicay);
    lvtraicay.setAdapter(adapter);
    selectedImage = BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher_background);

    galleryLauncher = registerForActivityResult(
        new ActivityResultContracts.StartActivityForResult(), result -> {
          if (result.getResultCode() == RESULT_OK) {
            Intent data = result.getData();
            if (data != null) {
              handleGalleryResult(data);
            }
          }
        });
    btnImportImage.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {

        Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
        photoPickerIntent.setType("image/*");
        galleryLauncher.launch(photoPickerIntent);
        imgHinh.setImageBitmap(selectedImage);
      }

    });
    lvtraicay.setOnItemClickListener((adapterView, view, i, l) -> {
      position = i;
      TraiCay traiCay = arrayTraicay.get(i);
      edtTen.setText(traiCay.getTen());
      edtMota.setText(traiCay.getMota());
      imgHinh.setImageBitmap(traiCay.getHinh());
    });

    btnCreate.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        String ten = edtTen.getText().toString();
        String mota = edtMota.getText().toString();
        if (ten.isEmpty() || mota.isEmpty()) {
          Toast.makeText(MainActivity.this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT)
              .show();
        } else if (checkExist(ten)) {
          Toast.makeText(MainActivity.this, "Tên trái cây đã tồn tại", Toast.LENGTH_SHORT).show();
        } else {
          if(position == -1){
            imgHinh.setImageBitmap(selectedImage);
          }
          selectedImage = ((BitmapDrawable) imgHinh.getDrawable()).getBitmap();
          if (selectedImage == null) {
            selectedImage = BitmapFactory.decodeResource(getResources(), R.drawable.no_image);
          } else {
            selectedImage = ((BitmapDrawable) imgHinh.getDrawable()).getBitmap();
          }

          arrayTraicay.add(0, new TraiCay(ten, mota, selectedImage));

          adapter.notifyDataSetChanged();
          position = -1;
          edtTen.setText("");
          edtMota.setText("");
          imgHinh.setImageDrawable(
              ContextCompat.getDrawable(MainActivity.this, R.drawable.ic_launcher_background));
          InputMethodManager imm = (InputMethodManager) getSystemService(
              Context.INPUT_METHOD_SERVICE);
          imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
          Toast.makeText(MainActivity.this, "Thêm thành công", Toast.LENGTH_SHORT).show();

        }
      }
    });
    btnUpdate.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        if (position == -1) {
          Toast.makeText(MainActivity.this, "Vui lòng chọn trái cây cần cập nhật",
              Toast.LENGTH_SHORT).show();
        } else {
          TraiCay traiCay = arrayTraicay.get(position);
          String ten = edtTen.getText().toString();
          String mota = edtMota.getText().toString();
          if (ten.isEmpty() || mota.isEmpty()) {
            Toast.makeText(MainActivity.this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT)
                .show();
          } else {

            selectedImage = ((BitmapDrawable) imgHinh.getDrawable()).getBitmap();
            if (selectedImage == traiCay.getHinh()) {
              selectedImage = traiCay.getHinh();
            } else {
              selectedImage = ((BitmapDrawable) imgHinh.getDrawable()).getBitmap();
            }

            TraiCay updatedTraiCay = arrayTraicay.get(position);
            updatedTraiCay.setTen(ten); // Update the 'ten' field
            updatedTraiCay.setMota(mota); // Update the 'mota' field
            updatedTraiCay.setHinh(selectedImage); // Update the 'hinh' fiel

            adapter.notifyDataSetChanged();
            position = -1;
            edtTen.setText("");
            edtMota.setText("");
            imgHinh.setImageDrawable(
                ContextCompat.getDrawable(MainActivity.this, R.drawable.ic_launcher_background));
            InputMethodManager imm = (InputMethodManager) getSystemService(
                Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
            Toast.makeText(MainActivity.this, "Cập nhật thành công", Toast.LENGTH_SHORT).show();
          }
        }
      }
    });
    btnDelete.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        if (position == -1) {
          Toast.makeText(MainActivity.this, "Vui lòng chọn trái cây cần xóa", Toast.LENGTH_SHORT)
              .show();
        } else {
          arrayTraicay.remove(position);
          adapter.notifyDataSetChanged();
          position = -1;
          edtTen.setText("");
          edtMota.setText("");
          imgHinh.setImageDrawable(
              ContextCompat.getDrawable(MainActivity.this, R.drawable.ic_launcher_background));
          InputMethodManager imm = (InputMethodManager) getSystemService(
              Context.INPUT_METHOD_SERVICE);
          imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
          Toast.makeText(MainActivity.this, "Xóa thành công", Toast.LENGTH_SHORT).show();
        }
      }
    });
  }

  private void handleGalleryResult(Intent data) {
    try {
      final Uri imageUri = data.getData();
      final InputStream imageStream = getContentResolver().openInputStream(imageUri);

      final Bitmap selectedImage = BitmapFactory.decodeStream(imageStream);
      imgHinh.setImageBitmap(selectedImage);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
      Toast.makeText(MainActivity.this, "Something went wrong", Toast.LENGTH_LONG).show();
    }
  }


  private void AnhXa() {
    lvtraicay = (ListView) findViewById(R.id.lvTraicay);
    arrayTraicay = new ArrayList<>();
    Bitmap appleBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.apple);
    Bitmap bananaBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.banana);
    Bitmap blueberryBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.blueberry);
    arrayTraicay.add(new TraiCay("Apple", "Apple... some description goes here", appleBitmap));
    arrayTraicay.add(new TraiCay("Banana", "Banana... some description goes here", bananaBitmap));
    arrayTraicay.add(
        new TraiCay("Blueberry", "Blueberry... some description goes here", blueberryBitmap));
  }

  private void Binding() {
    btnCreate = (Button) findViewById(R.id.btnCreate);
    btnUpdate = (Button) findViewById(R.id.btnUpdate);
    btnDelete = (Button) findViewById(R.id.btnDelete);

    btnImportImage = (Button) findViewById(R.id.btnImportImage);

    imgHinh = (ImageView) findViewById(R.id.imgHinh);

    edtTen = (EditText) findViewById(R.id.edtTen);
    edtMota = (EditText) findViewById(R.id.edtMota);
  }

  private boolean checkExist(String ten) {
    for (TraiCay traiCay : arrayTraicay) {
      if (traiCay.getTen().equals(ten)) {
        return true;
      }
    }
    return false;
  }
}