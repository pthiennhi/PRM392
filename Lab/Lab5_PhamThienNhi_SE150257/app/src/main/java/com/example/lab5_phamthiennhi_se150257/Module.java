package com.example.lab5_phamthiennhi_se150257;

import android.net.Uri;

public class Module {
  private String title, description, tag;
  private int image;

  private Uri imageUri;

  public Module(String title, String description, String tag, int image) {
    this.title = title;
    this.description = description;
    this.tag = tag;
    this.image = image;
  }
  public Module(String title, String description, String tag, Uri imageUri) {
    this.title = title;
    this.description = description;
    this.tag = tag;
    this.imageUri = imageUri;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getTag() {
    return tag;
  }

  public void setTag(String tag) {
    this.tag = tag;
  }

  public int getImage() {
    return image;
  }

  public void setImage(int image) {
    this.image = image;
  }

  public Uri getImageUri() {
    return imageUri;
  }
  public void setImageUri(Uri imageUri) {
    this.imageUri = imageUri;
  }
}
