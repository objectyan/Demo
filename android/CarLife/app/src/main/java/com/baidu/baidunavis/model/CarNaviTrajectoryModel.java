package com.baidu.baidunavis.model;

public class CarNaviTrajectoryModel
{
  public static final String TAG = CarNaviTrajectoryModel.class.getSimpleName();
  private static CarNaviTrajectoryModel mInstance = null;
  public boolean isBackground = false;
  public boolean isCarNaviPageVisible = false;
  public boolean isFromRoutePlan = false;
  public boolean isRecordStart = false;
  
  public static CarNaviTrajectoryModel getInstance()
  {
    if (mInstance == null) {
      mInstance = new CarNaviTrajectoryModel();
    }
    return mInstance;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/baidunavis/model/CarNaviTrajectoryModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */