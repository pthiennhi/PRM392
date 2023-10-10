package com.example.lab5_phamthiennhi_se150257.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.lab5_phamthiennhi_se150257.R;
import com.example.lab5_phamthiennhi_se150257.User;
import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {

  // Store a member variable for the user
  private ArrayList<User> userList;
  private OnItemClickListener listener; // Listener for item clicks

  public interface OnItemClickListener {
    void onItemClick(User user, int position); // Pass the position as well
  }

  public UserAdapter(ArrayList<User> userList, OnItemClickListener listener) {
    this.userList = userList;
    this.listener = listener;
  }

  public UserAdapter(ArrayList<User> userList) {
    this.userList = userList;
  }

  @NonNull
  @Override
  public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    Context context = parent.getContext();
    LayoutInflater layoutInflater = LayoutInflater.from(context);
    View view = layoutInflater.inflate(R.layout.item_user, parent, false);
    ViewHolder viewHolder = new ViewHolder(view);
    return viewHolder;
  }

  @Override
  public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    User user = userList.get(position);
    holder.tvUsername.setText("Username: " + user.getUsername());
    holder.tvFullname.setText("Fullname: " + user.getFullname());
    holder.tvEmail.setText("Email: " + user.getEmail());
    holder.itemView.setOnClickListener(v -> {
      if (listener != null) {
        listener.onItemClick(user, position); // Pass the position
      }
    });
  }

  @Override
  public int getItemCount() {
    return userList.size();
  }

  public class ViewHolder extends RecyclerView.ViewHolder {

    TextView tvUsername;
    TextView tvFullname;
    TextView tvEmail;

    public ViewHolder(@NonNull View itemView) {
      super(itemView);
      tvUsername = itemView.findViewById(R.id.tv_username);
      tvFullname = itemView.findViewById(R.id.tv_fullname);
      tvEmail = itemView.findViewById(R.id.tv_email);
    }
  }

}
