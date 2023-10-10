package com.example.lab5_phamthiennhi_se150257;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.PickVisualMediaRequest;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.activity.result.contract.ActivityResultContracts.PickVisualMedia;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.lab5_phamthiennhi_se150257.adapter.ModuleAdapter;
import java.util.ArrayList;

public class ModuleActivity extends AppCompatActivity implements ModuleAdapter.OnItemClickListener {

  ArrayList<Module> moduleList;
  Button btnAdd, btnDelete, btnUpdate, btnChooseImage;
  EditText edtTitle, edtDescription, edtTag;

  ImageView ivImage;
  int position = -1;
  RecyclerView rvModule;
  private ActivityResultLauncher<PickVisualMediaRequest> launcher;
  Uri image_uri;

  int SELECT_PICTURE = 200;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_module);
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    RecyclerView rvModule = findViewById(R.id.rvModule);
    initView();
    moduleList = new ArrayList<>();
    moduleList.add(new Module("ListView Trong Android",
        "ListView trng Android là một ViewGroup dùng để hiển thị danh sách các item có thể cuộn được. ListView có thể được sử dụng để hiển thị danh sách các item có thể chọn, hoặc không thể chọn. ListView có thể được sử dụng để hiển thị danh sách các item có thể chọn, hoặc không thể chọn.",
        "Android", R.drawable.android));
    moduleList.add(new Module("Xử Lý Sự Kiện IOS",
        "Xử lý sự kiện trong IOS là một ViewGroup dùng để hiển thị danh sách các item có thể cuộn được. ListView có thể được sử dụng để hiển thị danh sách các item có thể chọn, hoặc không thể chọn. ListView có thể được sử dụng để hiển thị danh sách các item có thể chọn, hoặc không thể chọn.",
        "IOS", R.drawable.ios));
    updateRecyclerView();

    launcher = registerForActivityResult(new ActivityResultContracts.PickVisualMedia(),
        result -> {
          if (result != null) {
            ivImage.setImageURI(result);
            try {
              Uri contentUri = Uri.parse(result.toString());
              image_uri = contentUri;
            } catch (Exception e) {
              Log.d("PhotoPicker", "Error: " + e.getMessage());
            }
          } else {
            // Handle the case where the user cancelled the selection
            Log.d("PhotoPicker", "Selection cancelled");
          }
        });
    btnChooseImage.setOnClickListener(v -> {
      picker();
    });

    btnAdd.setOnClickListener(v -> {
      String title = edtTitle.getText().toString();
      String description = edtDescription.getText().toString();
      String tag = edtTag.getText().toString();
      if (title.isEmpty() || description.isEmpty() || tag.isEmpty()) {
        Toast.makeText(this, "Please enter all fields", Toast.LENGTH_SHORT).show();
        return;
      } else {
        for (Module module : moduleList) {
          if (module.getTitle().equals(title)) {
            Toast.makeText(this, "Title already exists", Toast.LENGTH_SHORT).show();
            return;
          }
        }
        if (image_uri == null) {
          moduleList.add(0, new Module(title, description, tag, R.drawable.ic_launcher_background));
        } else {
          moduleList.add(0, new Module(title, description, tag, image_uri));
        }
        updateRecyclerView();
        Toast.makeText(this, "Add successfully", Toast.LENGTH_SHORT).show();
        position = -1;
        clearForm();


      }
    });

    btnUpdate.setOnClickListener(v -> {
      String title = edtTitle.getText().toString();
      String description = edtDescription.getText().toString();
      String tag = edtTag.getText().toString();
      if (position == -1) {
        Toast.makeText(this, "Please select a module", Toast.LENGTH_SHORT).show();
        return;
      } else if (title.isEmpty() || description.isEmpty() || tag.isEmpty()) {
        Toast.makeText(this, "Please enter all fields", Toast.LENGTH_SHORT).show();
        return;
      } else {
        for (Module module : moduleList) {
          if (module.getTitle().equals(title) && moduleList.indexOf(module) != position) {
            Toast.makeText(this, "Title already exists", Toast.LENGTH_SHORT).show();
            return;
          }
        }
        if(image_uri != null){
          moduleList.get(position).setImage(0);
          moduleList.get(position).setImageUri(image_uri);
        }
        moduleList.get(position).setTitle(title);
        moduleList.get(position).setDescription(description);
        moduleList.get(position).setTag(tag);
        updateRecyclerView();
        Toast.makeText(this, "Update successfully", Toast.LENGTH_SHORT).show();
        position = -1;
        clearForm();
      }
    });

    btnDelete.setOnClickListener(v -> {
      if (position == -1) {
        Toast.makeText(this, "Please select a module", Toast.LENGTH_SHORT).show();
        return;
      } else {
        moduleList.remove(position);
        updateRecyclerView();
        Toast.makeText(this, "Delete successfully", Toast.LENGTH_SHORT).show();
        position = -1;
        clearForm();
      }
    });
  }

  private void initView() {
    btnAdd = findViewById(R.id.btnAdd1);
    btnDelete = findViewById(R.id.btnDelete1);
    btnUpdate = findViewById(R.id.btnEdit1);
    btnChooseImage = findViewById(R.id.btnChooseImage);
    edtTitle = findViewById(R.id.edtTitle);
    edtDescription = findViewById(R.id.edtDescription);
    edtTag = findViewById(R.id.edtTag);
    rvModule = findViewById(R.id.rvModule);
    ivImage = findViewById(R.id.iv_image);
  }

  private void updateRecyclerView() {
    ModuleAdapter adapter = new ModuleAdapter(moduleList, this);
    rvModule.setAdapter(adapter);
    rvModule.setLayoutManager(new LinearLayoutManager(this));
  }

  private void clearForm() {
    edtTitle.setText("");
    edtDescription.setText("");
    edtTag.setText("");
    ivImage.setImageResource(R.drawable.ic_launcher_background);
    image_uri = null;
  }

  private void setForm(Module module) {
    edtTitle.setText(module.getTitle());
    edtDescription.setText(module.getDescription());
    edtTag.setText(module.getTag());
    if (module.getImage() == 0) {
      ivImage.setImageURI(module.getImageUri());
    } else {
      ivImage.setImageResource(module.getImage());
    }
  }

  @Override
  public void onItemClick(Module module, int position) {
    this.position = position;
    setForm(module);
  }

  private void picker() {
    launcher.launch(new PickVisualMediaRequest.Builder()
        .setMediaType(PickVisualMedia.ImageOnly.INSTANCE)
        .build());
  }


}