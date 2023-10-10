package com.example.lab5_phamthiennhi_se150257.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.lab5_phamthiennhi_se150257.Module;
import com.example.lab5_phamthiennhi_se150257.R;
import com.example.lab5_phamthiennhi_se150257.User;
import com.example.lab5_phamthiennhi_se150257.adapter.UserAdapter.OnItemClickListener;
import com.example.lab5_phamthiennhi_se150257.adapter.UserAdapter.ViewHolder;
import java.util.ArrayList;

public class ModuleAdapter extends RecyclerView.Adapter<ModuleAdapter.ViewHolder> {
  private ArrayList<Module> moduleList;
  private OnItemClickListener listener; // Listener for item clicks
  public interface OnItemClickListener {
    void onItemClick(Module module, int position); // Pass the position as well
  }

  public ModuleAdapter(ArrayList<Module> moduleList, ModuleAdapter.OnItemClickListener listener) {
    this.moduleList = moduleList;
    this.listener = listener;
  }
  public ModuleAdapter(ArrayList<Module> moduleList) {
    this.moduleList = moduleList;
  }
  public static class ViewHolder extends RecyclerView.ViewHolder {
    TextView tv_title, tv_description, tv_tag;
    ImageView iv_image;
    public ViewHolder(View itemView) {
      super(itemView);
      tv_title = itemView.findViewById(R.id.tv_title);
      tv_description = itemView.findViewById(R.id.tv_description);
      tv_tag = itemView.findViewById(R.id.tv_tag);
      iv_image = itemView.findViewById(R.id.iv_image);
    }
  }

  @Override
  public ModuleAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    Context context = parent.getContext();
    LayoutInflater layoutInflater = LayoutInflater.from(context);
    View view = layoutInflater.inflate(R.layout.item_module, parent, false);
    ModuleAdapter.ViewHolder viewHolder = new ModuleAdapter.ViewHolder(view);
    return viewHolder;
  }

  @Override
  public void onBindViewHolder(ModuleAdapter.ViewHolder holder, int position) {
    Module module = moduleList.get(position);
    if(module.getImage() == 0){
      holder.iv_image.setImageURI(module.getImageUri());
    } else{
      holder.iv_image.setImageResource(module.getImage());
    }
    holder.tv_title.setText(module.getTitle());
    holder.tv_description.setText(module.getDescription());
    holder.tv_tag.setText(module.getTag());

    holder.itemView.setOnClickListener(v -> {
      if (listener != null) {
        listener.onItemClick(module, position); // Pass the position
      }
    });
  }

  @Override
  public int getItemCount() {
    return moduleList.size();
  }



}
