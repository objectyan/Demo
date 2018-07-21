package com.baidu.navisdk.ui.routeguide.control;

import com.baidu.navisdk.ui.routeguide.mapmode.RGMapModeViewController;
import com.baidu.navisdk.ui.routeguide.model.RGLaneInfoModel;
import com.baidu.navisdk.util.common.LogUtil;
import java.util.ArrayList;

public class RGLaneLineController
{
  public static RGLaneLineController mInstance = null;
  public boolean isNormalEnlargeShow = false;
  public ArrayList<Integer> mLastImalgeIdList = new ArrayList();
  
  public static RGLaneLineController getInstance()
  {
    if (mInstance == null) {
      mInstance = new RGLaneLineController();
    }
    return mInstance;
  }
  
  public void handleSimulateHide()
  {
    LogUtil.e(RGLaneInfoModel.TAG, "handleSimulateHide");
    RGLaneInfoModel localRGLaneInfoModel = RGLaneInfoModel.getModel(false);
    if (localRGLaneInfoModel != null) {
      localRGLaneInfoModel.isShow = false;
    }
    getInstance().mLastImalgeIdList.clear();
    RGMapModeViewController.getInstance().requestShowExpendView(7, false, 2);
  }
  
  public void uninit()
  {
    this.mLastImalgeIdList.clear();
    if (RGLaneInfoModel.mInstance != null)
    {
      RGLaneInfoModel.mInstance.isLaneShow = false;
      RGLaneInfoModel.mInstance.isShow = false;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/routeguide/control/RGLaneLineController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */