package com.baidu.navisdk.ui.routeguide.model;

import com.baidu.navisdk.ui.routeguide.control.RGLaneLineController;
import com.baidu.navisdk.ui.routeguide.mapmode.RGMapModeViewController;
import com.baidu.navisdk.util.common.LogUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class RGLaneInfoModel
{
  public static final int AFTER_SOURCE = 1;
  private static final int BUS_IMAGE_ID = 1711407239;
  public static final int CURRENT_MAX_LINE = 9;
  public static final int ENLARGE_TYPE = 100;
  public static final int LANE_SOURCE = 2;
  public static final int MAX_LINE_NUMBER = 16;
  public static final int NORMAL_LANE = 101;
  public static final int PORTRAIT_ENLARGE = 200;
  public static final String TAG = RGLaneInfoModel.class.getName();
  public static RGLaneInfoModel mInstance = new RGLaneInfoModel();
  public boolean isLaneShow = false;
  public boolean isShow = false;
  public int mID = 0;
  private HashMap<String, Integer> mImageMap = new HashMap();
  public ArrayList<Integer> mImalgeIdList = new ArrayList();
  public RGLineItem[] mLaneLineList = new RGLineItem[16];
  public int mLineNumber = 0;
  public int mRemainDist = 0;
  public int mStartDist = 0;
  public double mX = 0.0D;
  public double mY = 0.0D;
  
  private int getImageID(String paramString, boolean paramBoolean)
  {
    int j = 0;
    int i = j;
    if (this.mImageMap != null)
    {
      i = j;
      if (this.mImageMap.containsKey(paramString)) {
        i = ((Integer)this.mImageMap.get(paramString)).intValue();
      }
    }
    LogUtil.e(TAG, "getImageID id is " + i);
    return i;
  }
  
  public static RGLaneInfoModel getModel(boolean paramBoolean)
  {
    if ((paramBoolean) || (mInstance == null)) {
      mInstance = new RGLaneInfoModel();
    }
    return mInstance;
  }
  
  private void initMap()
  {
    if (this.mImageMap.size() > 0) {
      return;
    }
    if (this.mImageMap == null) {
      this.mImageMap = new HashMap();
    }
    this.mImageMap.put("11000000", Integer.valueOf(1711407260));
    this.mImageMap.put("10000000", Integer.valueOf(1711407261));
    this.mImageMap.put("00110000", Integer.valueOf(1711407262));
    this.mImageMap.put("00100000", Integer.valueOf(1711407263));
    this.mImageMap.put("00001100", Integer.valueOf(1711407252));
    this.mImageMap.put("00001000", Integer.valueOf(1711407255));
    this.mImageMap.put("00000011", Integer.valueOf(1711407258));
    this.mImageMap.put("00000010", Integer.valueOf(1711407259));
    this.mImageMap.put("10001000", Integer.valueOf(1711407216));
    this.mImageMap.put("11001000", Integer.valueOf(1711407219));
    this.mImageMap.put("10001100", Integer.valueOf(1711407215));
    this.mImageMap.put("00101000", Integer.valueOf(1711407218));
    this.mImageMap.put("00111000", Integer.valueOf(1711407220));
    this.mImageMap.put("00101100", Integer.valueOf(1711407217));
    this.mImageMap.put("10101000", Integer.valueOf(1711407221));
    this.mImageMap.put("11101000", Integer.valueOf(1711407223));
    this.mImageMap.put("10111000", Integer.valueOf(1711407224));
    this.mImageMap.put("10101100", Integer.valueOf(1711407222));
    this.mImageMap.put("10000010", Integer.valueOf(1711407226));
    this.mImageMap.put("11000010", Integer.valueOf(1711407241));
    this.mImageMap.put("10000011", Integer.valueOf(1711407225));
    this.mImageMap.put("10100000", Integer.valueOf(1711407243));
    this.mImageMap.put("11100000", Integer.valueOf(1711407242));
    this.mImageMap.put("10110000", Integer.valueOf(1711407248));
    this.mImageMap.put("00100010", Integer.valueOf(1711407228));
    this.mImageMap.put("00110010", Integer.valueOf(1711407247));
    this.mImageMap.put("00100011", Integer.valueOf(1711407227));
    this.mImageMap.put("00001010", Integer.valueOf(1711407230));
    this.mImageMap.put("00001110", Integer.valueOf(1711407253));
    this.mImageMap.put("00001011", Integer.valueOf(1711407229));
    this.mImageMap.put("10100010", Integer.valueOf(1711407232));
    this.mImageMap.put("11100010", Integer.valueOf(1711407244));
    this.mImageMap.put("10110010", Integer.valueOf(1711407249));
    this.mImageMap.put("10100011", Integer.valueOf(1711407231));
    this.mImageMap.put("10001010", Integer.valueOf(1711407236));
    this.mImageMap.put("11001010", Integer.valueOf(1711407246));
    this.mImageMap.put("10001110", Integer.valueOf(1711407256));
    this.mImageMap.put("10001011", Integer.valueOf(1711407235));
    this.mImageMap.put("00101010", Integer.valueOf(1711407238));
    this.mImageMap.put("00111010", Integer.valueOf(1711407251));
    this.mImageMap.put("00101110", Integer.valueOf(1711407257));
    this.mImageMap.put("00101011", Integer.valueOf(1711407237));
    this.mImageMap.put("10101010", Integer.valueOf(1711407234));
    this.mImageMap.put("11101010", Integer.valueOf(1711407245));
    this.mImageMap.put("10111010", Integer.valueOf(1711407250));
    this.mImageMap.put("10101110", Integer.valueOf(1711407254));
    this.mImageMap.put("10101011", Integer.valueOf(1711407233));
  }
  
  private boolean isNewLaneShow()
  {
    if (RGEnlargeRoadMapModel.getInstance().isAnyEnlargeRoadMapShowing()) {
      return true;
    }
    ArrayList localArrayList = RGLaneLineController.getInstance().mLastImalgeIdList;
    if ((this.mImalgeIdList != null) && (localArrayList != null) && (this.mImalgeIdList.size() == localArrayList.size()))
    {
      int i = 0;
      while (i < this.mImalgeIdList.size())
      {
        if (((Integer)this.mImalgeIdList.get(i)).intValue() != ((Integer)localArrayList.get(i)).intValue()) {
          return true;
        }
        i += 1;
      }
      return false;
    }
    return true;
  }
  
  public void cloneData(RGLineItem[] paramArrayOfRGLineItem)
  {
    if ((paramArrayOfRGLineItem == null) || (paramArrayOfRGLineItem.length <= 0)) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < paramArrayOfRGLineItem.length)
      {
        this.mLaneLineList[i] = paramArrayOfRGLineItem[i];
        LogUtil.e(TAG, "cloneData is " + this.mLaneLineList[i].toString());
        i += 1;
      }
    }
  }
  
  public int getImageIDFromItem(RGLineItem paramRGLineItem)
  {
    if (paramRGLineItem.isBusLine) {
      return 1711407239;
    }
    return getImageID(parseItem(paramRGLineItem), paramRGLineItem.isBusLine);
  }
  
  public void handleShowMessage()
  {
    LogUtil.e(TAG, "handleShowMessage");
    initMap();
    this.isShow = true;
    if (!this.isLaneShow)
    {
      LogUtil.e(TAG, "handleShowMessage isLaneShow " + this.isLaneShow);
      return;
    }
    if (this.mLineNumber > 9) {
      this.mLineNumber = 9;
    }
    this.mImalgeIdList.clear();
    int i = 0;
    while (i < this.mLineNumber)
    {
      int j = getImageIDFromItem(this.mLaneLineList[i]);
      this.mImalgeIdList.add(Integer.valueOf(j));
      i += 1;
    }
    if (!isNewLaneShow())
    {
      LogUtil.e(TAG, "update, not show");
      return;
    }
    RGLaneLineController.getInstance().mLastImalgeIdList.clear();
    Iterator localIterator = this.mImalgeIdList.iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      RGLaneLineController.getInstance().mLastImalgeIdList.add(localInteger);
    }
    RGMapModeViewController.getInstance().updateLaneLineImage(this.mImalgeIdList);
    RGMapModeViewController.getInstance().updateEnlargeLaneLineImage(this.mImalgeIdList);
    RGMapModeViewController.getInstance().requestShowExpendView(7, true, 2);
  }
  
  public boolean isShowLaneLineView()
  {
    return (this.isShow) && (this.isLaneShow);
  }
  
  public String parseItem(RGLineItem paramRGLineItem)
  {
    int j = 1;
    if (paramRGLineItem == null) {
      return "0";
    }
    StringBuffer localStringBuffer = new StringBuffer();
    if (paramRGLineItem.isLeft)
    {
      i = 1;
      localStringBuffer.append(i);
      if (!paramRGLineItem.isLeftBright) {
        break label188;
      }
      i = 1;
      label44:
      localStringBuffer.append(i);
      if (!paramRGLineItem.isRight) {
        break label193;
      }
      i = 1;
      label60:
      localStringBuffer.append(i);
      if (!paramRGLineItem.isRightBright) {
        break label198;
      }
      i = 1;
      label76:
      localStringBuffer.append(i);
      if (!paramRGLineItem.isFront) {
        break label203;
      }
      i = 1;
      label92:
      localStringBuffer.append(i);
      if (!paramRGLineItem.isFrontBright) {
        break label208;
      }
      i = 1;
      label108:
      localStringBuffer.append(i);
      if (!paramRGLineItem.isBack) {
        break label213;
      }
      i = 1;
      label124:
      localStringBuffer.append(i);
      if (!paramRGLineItem.isBackBright) {
        break label218;
      }
    }
    label188:
    label193:
    label198:
    label203:
    label208:
    label213:
    label218:
    for (int i = j;; i = 0)
    {
      localStringBuffer.append(i);
      LogUtil.e(TAG, "parseItemToLong long is " + localStringBuffer.toString());
      return localStringBuffer.toString();
      i = 0;
      break;
      i = 0;
      break label44;
      i = 0;
      break label60;
      i = 0;
      break label76;
      i = 0;
      break label92;
      i = 0;
      break label108;
      i = 0;
      break label124;
    }
  }
  
  public String toString()
  {
    return String.format("[%d,%d,%d,%b]", new Object[] { Integer.valueOf(this.mLineNumber), Integer.valueOf(this.mStartDist), Integer.valueOf(this.mID), Boolean.valueOf(this.isLaneShow) });
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/routeguide/model/RGLaneInfoModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */