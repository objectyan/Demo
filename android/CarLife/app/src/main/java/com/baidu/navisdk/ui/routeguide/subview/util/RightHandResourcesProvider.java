package com.baidu.navisdk.ui.routeguide.subview.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.navisdk.model.modelfactory.NaviDataEngine;
import com.baidu.navisdk.model.modelfactory.RoutePlanModel;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.CoordinateTransformUtil;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;

public class RightHandResourcesProvider
{
  private static final int[] NEED_ROTATION_TURN_ID = { 1711407698, 1711407739, 1711407744, 1711407740, 1711407741, 1711407742, 1711407743, 1711407745, 1711407746, 1711407747, 1711407748, 1711407633 };
  private static final Rect THAILAND_BOUND = new Rect(622634, 10837256, 2313605, 11760548);
  private static GeoPoint lastEndPoint;
  private static boolean lastIsRightHand = false;
  private static GeoPoint lastStartPoint = null;
  
  static
  {
    lastEndPoint = null;
  }
  
  public static final Drawable getDrawableIncludeRightHandIcon(int paramInt)
  {
    paramInt = getIconIdIncludeRightHandIcon(paramInt);
    Drawable localDrawable = JarUtils.getResources().getDrawable(paramInt);
    Object localObject = localDrawable;
    if (localDrawable != null)
    {
      localObject = localDrawable;
      if (isNeedRotate(paramInt)) {
        localObject = localDrawable;
      }
    }
    try
    {
      if ((localDrawable instanceof BitmapDrawable))
      {
        localObject = ((BitmapDrawable)localDrawable).getBitmap();
        Matrix localMatrix = new Matrix();
        localMatrix.postScale(-1.0F, 1.0F);
        localObject = Bitmap.createBitmap((Bitmap)localObject, 0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight(), localMatrix, false);
        localObject = new BitmapDrawable(JarUtils.getResources(), (Bitmap)localObject);
      }
      return (Drawable)localObject;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return localDrawable;
  }
  
  public static final int getEnNaviType()
  {
    return ((RoutePlanModel)NaviDataEngine.getInstance().getModel("RoutePlanModel")).getEnNaviType();
  }
  
  private static final int getIconIdIncludeRightHandIcon(int paramInt)
  {
    int i = paramInt;
    if (isRightHand()) {
      i = getRightHandIconId(paramInt);
    }
    return i;
  }
  
  private static final int getRightHandIconId(int paramInt)
  {
    switch (paramInt)
    {
    case 1711407744: 
    default: 
      return paramInt;
    case 1711407745: 
      return 1711407741;
    case 1711407746: 
      return 1711407742;
    case 1711407747: 
      return 1711407743;
    case 1711407741: 
      return 1711407745;
    case 1711407742: 
      return 1711407746;
    }
    return 1711407747;
  }
  
  private static boolean isInThailandBound(GeoPoint paramGeoPoint)
  {
    return (paramGeoPoint != null) && (THAILAND_BOUND.contains(paramGeoPoint.getLongitudeE6(), paramGeoPoint.getLatitudeE6()));
  }
  
  private static boolean isInternational()
  {
    RoutePlanModel localRoutePlanModel = (RoutePlanModel)NaviDataEngine.getInstance().getModel("RoutePlanModel");
    return (localRoutePlanModel != null) && (localRoutePlanModel.getEnNaviType() != 0);
  }
  
  public static boolean isInternationalWithToast(Context paramContext)
  {
    if (isInternational())
    {
      TipTool.onCreateToastDialog(paramContext, JarUtils.getResources().getString(1711670359));
      return true;
    }
    return false;
  }
  
  private static boolean isNeedRotate(int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    int[] arrayOfInt;
    int j;
    int i;
    if (lastIsRightHand)
    {
      arrayOfInt = NEED_ROTATION_TURN_ID;
      j = arrayOfInt.length;
      i = 0;
    }
    for (;;)
    {
      bool1 = bool2;
      if (i < j)
      {
        if (paramInt == arrayOfInt[i]) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  private static final boolean isRightHand()
  {
    Object localObject = (RoutePlanModel)NaviDataEngine.getInstance().getModel("RoutePlanModel");
    if (((RoutePlanModel)localObject).getEnNaviType() == 1)
    {
      RoutePlanNode localRoutePlanNode = ((RoutePlanModel)localObject).getStartNode();
      localObject = ((RoutePlanModel)localObject).getEndNode();
      if ((localRoutePlanNode != null) && (localObject != null))
      {
        if ((lastStartPoint != null) && (lastStartPoint.equals(localRoutePlanNode.getGeoPoint())) && (lastEndPoint != null) && (lastEndPoint.equals(((RoutePlanNode)localObject).getGeoPoint()))) {
          return lastIsRightHand;
        }
        lastStartPoint = localRoutePlanNode.getGeoPoint();
        lastEndPoint = ((RoutePlanNode)localObject).getGeoPoint();
        if ((isInThailandBound(transNodeToGeoPoint(localRoutePlanNode))) && (isInThailandBound(transNodeToGeoPoint((RoutePlanNode)localObject))))
        {
          lastIsRightHand = true;
          return true;
        }
      }
    }
    lastIsRightHand = false;
    return false;
  }
  
  private static GeoPoint transNodeToGeoPoint(RoutePlanNode paramRoutePlanNode)
  {
    GeoPoint localGeoPoint2 = new GeoPoint();
    GeoPoint localGeoPoint1 = localGeoPoint2;
    if (paramRoutePlanNode != null)
    {
      paramRoutePlanNode = CoordinateTransformUtil.LLE62MC(paramRoutePlanNode.getLongitudeE6(), paramRoutePlanNode.getLatitudeE6());
      localGeoPoint1 = localGeoPoint2;
      if (paramRoutePlanNode != null) {
        localGeoPoint1 = new GeoPoint(paramRoutePlanNode.getInt("MCy"), paramRoutePlanNode.getInt("MCx"));
      }
    }
    return localGeoPoint1;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/routeguide/subview/util/RightHandResourcesProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */