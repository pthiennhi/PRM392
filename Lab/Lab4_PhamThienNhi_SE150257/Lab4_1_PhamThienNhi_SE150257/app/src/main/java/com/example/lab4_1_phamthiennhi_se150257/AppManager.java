package com.example.lab4_1_phamthiennhi_se150257;

import android.app.Activity;
import java.util.ArrayList;
import java.util.List;

public class AppManager {


  private static AppManager instance;
  private List<Activity> activities;

  private AppManager() {
    activities = new ArrayList<>();
  }

  public static synchronized AppManager getInstance() {
    if (instance == null) {
      instance = new AppManager();
    }
    return instance;
  }

  public void addActivity(Activity activity) {
    activities.add(activity);
  }

  public void removeActivity(Activity activity) {
    activities.remove(activity);
  }

  public void exitApp() {
    for (Activity activity : activities) {
      activity.finish();
    }
    System.exit(0);
  }

}
