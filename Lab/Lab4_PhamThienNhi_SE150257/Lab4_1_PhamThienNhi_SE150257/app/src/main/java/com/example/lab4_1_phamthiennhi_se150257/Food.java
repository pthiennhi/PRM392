package com.example.lab4_1_phamthiennhi_se150257;

import java.io.Serializable;

public class Food implements Serializable {
  private String Name, Description;
  private int Image;

  public Food(String name, String description, int image) {
    this.Name = name;
    this.Description = description;
    this.Image = image;
  }

  public String getName() {
    return this.Name;
  }

  public void setName(String name) {
    this.Name = name;
  }

  public String getDescription() {
    return this.Description;
  }

  public void setDescription(String description) {
    this.Description = description;
  }

  public int getImage() {
    return this.Image;
  }

  public void setImage(int image) {
    this.Image = image;
  }

}
