package com.baidu.navisdk.ui.routeguide.model;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.SysOSAPI;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RGEnlargeRoadMapModel
{
  public static final int Vector_Car_Point_Height = 46;
  public static final int Vector_Car_Point_Width = 42;
  private static RGEnlargeRoadMapModel mInstance = null;
  private Boolean IsClickToStreetView = Boolean.valueOf(false);
  private final String TAG = "RouteGuide";
  private Bitmap mArrowBitmap = null;
  private String mArrowName;
  private Bitmap mBGBitmap = null;
  private String mBGName;
  private int mCurrentAddDistance = 0;
  private int mEnlargeMapTypeForStatisitcs = 0;
  private boolean mIsAnyEnlargeRoadMapShowing = false;
  private int mLastCurPosRotate = 0;
  private int mLastCurPosX = 0;
  private int mLastCurPosY = 0;
  private Bundle mLastestData = null;
  private int mLatestAddDistance = 0;
  private String mStreetUid = null;
  private int mVectorImgHeight;
  private int mVectorImgWidth;
  
  public static RGEnlargeRoadMapModel getInstance()
  {
    if (mInstance == null) {
      mInstance = new RGEnlargeRoadMapModel();
    }
    return mInstance;
  }
  
  private String getRoadName(String paramString)
  {
    String str;
    if ((!"地图上的点".equals(paramString)) && (!"我的位置".equals(paramString)) && (!"未知路".equals(paramString)))
    {
      str = paramString;
      if (!"无名路".equals(paramString)) {}
    }
    else
    {
      str = "目的地";
    }
    return str;
  }
  
  public boolean canEnlargeViewHide()
  {
    LogUtil.e("RouteGuide", "dingbbin canEnlargeViewHide() mLatestAddDistance is " + this.mLatestAddDistance + " mCurrentAddDistance is " + this.mCurrentAddDistance);
    return this.mLatestAddDistance == this.mCurrentAddDistance;
  }
  
  public Bitmap getArrowBitmap()
  {
    return this.mArrowBitmap;
  }
  
  public Bitmap getBGBitmap()
  {
    return this.mBGBitmap;
  }
  
  public Bundle getData(String paramString, boolean paramBoolean, int paramInt1, int paramInt2, Bundle paramBundle)
  {
    if ((paramString != null) && (("raster_grid".equals(paramString)) || ("raster_direct_board".equals(paramString))))
    {
      Object localObject2 = null;
      Object localObject1 = null;
      Object localObject3 = null;
      Object localObject5 = null;
      int i = -1;
      int k = 0;
      int j = 0;
      int m = i;
      Object localObject4 = localObject5;
      if (paramBundle != null)
      {
        String str1 = paramBundle.getString("bg_name");
        String str2 = paramBundle.getString("arrow_name");
        String str3 = paramBundle.getString("road_name");
        if (paramBundle.containsKey("icon_name"))
        {
          localObject1 = paramBundle.getString("icon_name");
          i = RGSimpleGuideModel.getInstance().getTurnIconRes((String)localObject1);
          LogUtil.e("RouteGuide", "RasterRoadMap.getData() iconname=" + (String)localObject1 + ", resid=" + i);
        }
        if (!paramBoolean) {
          this.mCurrentAddDistance = paramBundle.getInt("add_dist");
        }
        if (paramBundle.containsKey("gridmap_kind")) {
          j = paramBundle.getInt("gridmap_kind");
        }
        localObject1 = str2;
        localObject2 = str1;
        k = j;
        m = i;
        localObject3 = str3;
        localObject4 = localObject5;
        if (paramBundle.containsKey("tag_content"))
        {
          localObject4 = paramBundle.getString("tag_content");
          localObject3 = str3;
          m = i;
          k = j;
          localObject2 = str1;
          localObject1 = str2;
        }
      }
      LogUtil.e("RouteGuide", "BG=" + (String)localObject2 + "  AR=" + (String)localObject1 + "  RN=" + (String)localObject3 + "  TD=" + paramInt1 + "  RD=" + paramInt1 + ", gridmapKind=" + k + ", TagContent=" + (String)localObject4);
      this.mLastestData = new Bundle();
      this.mLastestData.putString("raster_type", paramString);
      this.mLastestData.putBoolean("updateprogress", paramBoolean);
      this.mLastestData.putString("bg_name", (String)localObject2);
      this.mLastestData.putString("arrow_name", (String)localObject1);
      this.mLastestData.putString("road_name", (String)localObject3);
      this.mLastestData.putInt("total_dist", paramInt1);
      this.mLastestData.putInt("rem_dist", paramInt2);
      this.mLastestData.putInt("gridmap_kind", k);
      this.mLastestData.putString("tag_content", (String)localObject4);
      this.mLastestData.putInt("resid", m);
      return this.mLastestData;
    }
    return null;
  }
  
  public int getEnlargeMapTypeForStatisitcs()
  {
    return this.mEnlargeMapTypeForStatisitcs;
  }
  
  public Boolean getIsClickToStreetView()
  {
    return this.IsClickToStreetView;
  }
  
  public Bundle getLastestData()
  {
    return this.mLastestData;
  }
  
  public String getRoadName()
  {
    if (this.mLastestData != null) {
      return this.mLastestData.getString("road_name");
    }
    return "未知路";
  }
  
  public int getRoadmapProgress()
  {
    int i = getRoadmapRemainDis();
    int j = this.mLastestData.getInt("total_dist");
    if ((i <= 0) || (j <= 0)) {
      return 100;
    }
    return (j - i) * 100 / j;
  }
  
  public int getRoadmapRemainDis()
  {
    if (this.mLastestData != null) {
      return this.mLastestData.getInt("rem_dist");
    }
    return 0;
  }
  
  public Bundle getStreetViewData(boolean paramBoolean, Bundle paramBundle)
  {
    if (paramBundle == null) {
      return null;
    }
    this.mLastestData = new Bundle();
    this.mLastestData.putString("raster_type", "raster_street");
    this.mLastestData.putBoolean("updateprogress", paramBoolean);
    String str;
    if (paramBundle.containsKey("road_name"))
    {
      str = paramBundle.getString("road_name");
      this.mLastestData.putString("road_name", getRoadName(str));
    }
    if (paramBundle.containsKey("street_uid"))
    {
      str = paramBundle.getString("street_uid");
      this.mLastestData.putString("street_uid", str);
      setmStreetUid(str);
    }
    if (paramBundle.containsKey("total_dist")) {
      this.mLastestData.putInt("total_dist", paramBundle.getInt("total_dist"));
    }
    if (paramBundle.containsKey("rem_dist")) {
      this.mLastestData.putInt("rem_dist", paramBundle.getInt("rem_dist"));
    }
    if ((paramBundle.containsKey("add_dist")) && (!paramBoolean)) {
      this.mCurrentAddDistance = paramBundle.getInt("add_dist");
    }
    if (!paramBoolean)
    {
      paramBundle = paramBundle.getByteArray("image_bytes");
      if ((paramBundle == null) || (paramBundle.length <= 0)) {
        break label222;
      }
      LogUtil.e("RouteGuide", "getStreetViewData BG Image Buf is not Null!");
    }
    for (;;)
    {
      try
      {
        this.mBGBitmap = BitmapFactory.decodeByteArray(paramBundle, 0, paramBundle.length);
        return this.mLastestData;
      }
      catch (OutOfMemoryError paramBundle)
      {
        this.mBGBitmap = null;
        continue;
      }
      label222:
      LogUtil.e("RouteGuide", "getStreetViewData BG Image Buf is Null!");
    }
  }
  
  public int getVectorImgHeight()
  {
    return this.mVectorImgHeight;
  }
  
  public int getVectorImgWidth()
  {
    return this.mVectorImgWidth;
  }
  
  public Bundle getVectorMapData(boolean paramBoolean, Bundle paramBundle)
  {
    if (paramBundle == null)
    {
      LogUtil.e("RouteGuide", "!# getVectorMapData param bundle is null");
      return null;
    }
    int j = -1;
    int i = j;
    Object localObject;
    if (paramBundle != null)
    {
      i = j;
      if (paramBundle.containsKey("icon_name"))
      {
        localObject = paramBundle.getString("icon_name");
        i = RGSimpleGuideModel.getInstance().getTurnIconRes((String)localObject);
        LogUtil.e("RouteGuide", "RasterRoadMap.getVectorMapData() iconname=" + (String)localObject + ", resid=" + i);
      }
    }
    this.mLastestData = new Bundle();
    this.mLastestData.putString("raster_type", "raster_vector");
    this.mLastestData.putBoolean("updateprogress", paramBoolean);
    if (paramBundle.containsKey("road_name")) {
      this.mLastestData.putString("road_name", paramBundle.getString("road_name"));
    }
    if (paramBundle.containsKey("total_dist")) {
      this.mLastestData.putInt("total_dist", paramBundle.getInt("total_dist"));
    }
    if (paramBundle.containsKey("rem_dist")) {
      this.mLastestData.putInt("rem_dist", paramBundle.getInt("rem_dist"));
    }
    if ((paramBundle.containsKey("add_dist")) && (!paramBoolean)) {
      this.mCurrentAddDistance = paramBundle.getInt("add_dist");
    }
    this.mLastestData.putInt("resid", i);
    this.mLastestData.putInt("last_car_pos_x", this.mLastCurPosX);
    this.mLastestData.putInt("last_car_pos_y", this.mLastCurPosY);
    this.mLastestData.putInt("last_car_rotate", this.mLastCurPosRotate);
    this.mLastestData.putInt("car_pos_x", paramBundle.getInt("car_pos_x", 0));
    this.mLastestData.putInt("car_pos_y", paramBundle.getInt("car_pos_y", 0));
    this.mLastestData.putInt("car_rotate", paramBundle.getInt("car_rotate", 0));
    if (!paramBoolean)
    {
      this.mLastestData.putInt("last_car_pos_x", 0);
      this.mLastestData.putInt("last_car_pos_y", 0);
      this.mLastestData.putInt("last_car_rotate", 0);
      localObject = paramBundle.getIntArray("image_bytes");
      if (localObject != null)
      {
        this.mVectorImgWidth = paramBundle.getInt("image_width", 0);
        this.mVectorImgHeight = paramBundle.getInt("image_height", 0);
        if (!getInstance().setRasterImage((int[])localObject, this.mVectorImgWidth, this.mVectorImgHeight))
        {
          LogUtil.e("RouteGuide", "!# setRasterImage fail");
          return null;
        }
      }
      else
      {
        LogUtil.e("RouteGuide", "!# null vector image buffer!");
        return null;
      }
    }
    return this.mLastestData;
  }
  
  public int getmCurrentAddDistance()
  {
    return this.mCurrentAddDistance;
  }
  
  public int getmLatestAddDistance()
  {
    return this.mLatestAddDistance;
  }
  
  public String getmStreetUid()
  {
    return this.mStreetUid;
  }
  
  public boolean isAnyEnlargeRoadMapShowing()
  {
    return this.mIsAnyEnlargeRoadMapShowing;
  }
  
  public boolean isBGBitmapValid()
  {
    return this.mBGBitmap != null;
  }
  
  /* Error */
  public boolean isRasterImageValid(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: aload_0
    //   3: monitorenter
    //   4: ldc 43
    //   6: new 100	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   13: ldc_w 301
    //   16: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19: aload_1
    //   20: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: ldc_w 303
    //   26: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: aload_2
    //   30: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   36: invokestatic 122	com/baidu/navisdk/util/common/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   39: aload_1
    //   40: invokestatic 309	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   43: ifne +88 -> 131
    //   46: aload_1
    //   47: aload_0
    //   48: getfield 311	com/baidu/navisdk/ui/routeguide/model/RGEnlargeRoadMapModel:mBGName	Ljava/lang/String;
    //   51: invokevirtual 88	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   54: ifne +77 -> 131
    //   57: aload_0
    //   58: getfield 51	com/baidu/navisdk/ui/routeguide/model/RGEnlargeRoadMapModel:mBGBitmap	Landroid/graphics/Bitmap;
    //   61: ifnull +20 -> 81
    //   64: aload_0
    //   65: getfield 51	com/baidu/navisdk/ui/routeguide/model/RGEnlargeRoadMapModel:mBGBitmap	Landroid/graphics/Bitmap;
    //   68: invokevirtual 316	android/graphics/Bitmap:isRecycled	()Z
    //   71: ifne +10 -> 81
    //   74: aload_0
    //   75: getfield 51	com/baidu/navisdk/ui/routeguide/model/RGEnlargeRoadMapModel:mBGBitmap	Landroid/graphics/Bitmap;
    //   78: invokevirtual 319	android/graphics/Bitmap:recycle	()V
    //   81: aload_0
    //   82: aconst_null
    //   83: putfield 51	com/baidu/navisdk/ui/routeguide/model/RGEnlargeRoadMapModel:mBGBitmap	Landroid/graphics/Bitmap;
    //   86: aload_0
    //   87: aload_1
    //   88: putfield 311	com/baidu/navisdk/ui/routeguide/model/RGEnlargeRoadMapModel:mBGName	Ljava/lang/String;
    //   91: invokestatic 324	com/baidu/navisdk/comapi/routeguide/BNRouteGuider:getInstance	()Lcom/baidu/navisdk/comapi/routeguide/BNRouteGuider;
    //   94: aload_0
    //   95: getfield 311	com/baidu/navisdk/ui/routeguide/model/RGEnlargeRoadMapModel:mBGName	Ljava/lang/String;
    //   98: iconst_1
    //   99: invokevirtual 328	com/baidu/navisdk/comapi/routeguide/BNRouteGuider:getRasterExpandMapImage	(Ljava/lang/String;I)[B
    //   102: astore_1
    //   103: aload_1
    //   104: ifnull +27 -> 131
    //   107: aload_1
    //   108: arraylength
    //   109: ifle +22 -> 131
    //   112: ldc 43
    //   114: ldc_w 330
    //   117: invokestatic 122	com/baidu/navisdk/util/common/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   120: aload_0
    //   121: aload_1
    //   122: iconst_0
    //   123: aload_1
    //   124: arraylength
    //   125: invokestatic 244	android/graphics/BitmapFactory:decodeByteArray	([BII)Landroid/graphics/Bitmap;
    //   128: putfield 51	com/baidu/navisdk/ui/routeguide/model/RGEnlargeRoadMapModel:mBGBitmap	Landroid/graphics/Bitmap;
    //   131: aload_2
    //   132: invokestatic 309	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   135: ifne +88 -> 223
    //   138: aload_2
    //   139: aload_0
    //   140: getfield 332	com/baidu/navisdk/ui/routeguide/model/RGEnlargeRoadMapModel:mArrowName	Ljava/lang/String;
    //   143: invokevirtual 88	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   146: ifne +77 -> 223
    //   149: aload_0
    //   150: getfield 53	com/baidu/navisdk/ui/routeguide/model/RGEnlargeRoadMapModel:mArrowBitmap	Landroid/graphics/Bitmap;
    //   153: ifnull +20 -> 173
    //   156: aload_0
    //   157: getfield 53	com/baidu/navisdk/ui/routeguide/model/RGEnlargeRoadMapModel:mArrowBitmap	Landroid/graphics/Bitmap;
    //   160: invokevirtual 316	android/graphics/Bitmap:isRecycled	()Z
    //   163: ifne +10 -> 173
    //   166: aload_0
    //   167: getfield 53	com/baidu/navisdk/ui/routeguide/model/RGEnlargeRoadMapModel:mArrowBitmap	Landroid/graphics/Bitmap;
    //   170: invokevirtual 319	android/graphics/Bitmap:recycle	()V
    //   173: aload_0
    //   174: aconst_null
    //   175: putfield 53	com/baidu/navisdk/ui/routeguide/model/RGEnlargeRoadMapModel:mArrowBitmap	Landroid/graphics/Bitmap;
    //   178: aload_0
    //   179: aload_2
    //   180: putfield 332	com/baidu/navisdk/ui/routeguide/model/RGEnlargeRoadMapModel:mArrowName	Ljava/lang/String;
    //   183: invokestatic 324	com/baidu/navisdk/comapi/routeguide/BNRouteGuider:getInstance	()Lcom/baidu/navisdk/comapi/routeguide/BNRouteGuider;
    //   186: aload_0
    //   187: getfield 332	com/baidu/navisdk/ui/routeguide/model/RGEnlargeRoadMapModel:mArrowName	Ljava/lang/String;
    //   190: iconst_0
    //   191: invokevirtual 328	com/baidu/navisdk/comapi/routeguide/BNRouteGuider:getRasterExpandMapImage	(Ljava/lang/String;I)[B
    //   194: astore_1
    //   195: aload_1
    //   196: ifnull +27 -> 223
    //   199: aload_1
    //   200: arraylength
    //   201: ifle +22 -> 223
    //   204: ldc 43
    //   206: ldc_w 334
    //   209: invokestatic 122	com/baidu/navisdk/util/common/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   212: aload_0
    //   213: aload_1
    //   214: iconst_0
    //   215: aload_1
    //   216: arraylength
    //   217: invokestatic 244	android/graphics/BitmapFactory:decodeByteArray	([BII)Landroid/graphics/Bitmap;
    //   220: putfield 53	com/baidu/navisdk/ui/routeguide/model/RGEnlargeRoadMapModel:mArrowBitmap	Landroid/graphics/Bitmap;
    //   223: aload_0
    //   224: getfield 53	com/baidu/navisdk/ui/routeguide/model/RGEnlargeRoadMapModel:mArrowBitmap	Landroid/graphics/Bitmap;
    //   227: ifnull +45 -> 272
    //   230: aload_0
    //   231: getfield 51	com/baidu/navisdk/ui/routeguide/model/RGEnlargeRoadMapModel:mBGBitmap	Landroid/graphics/Bitmap;
    //   234: astore_1
    //   235: aload_1
    //   236: ifnull +36 -> 272
    //   239: aload_0
    //   240: monitorexit
    //   241: iload_3
    //   242: ireturn
    //   243: astore_1
    //   244: aload_0
    //   245: aconst_null
    //   246: putfield 51	com/baidu/navisdk/ui/routeguide/model/RGEnlargeRoadMapModel:mBGBitmap	Landroid/graphics/Bitmap;
    //   249: goto -118 -> 131
    //   252: astore_1
    //   253: aload_1
    //   254: athrow
    //   255: astore_1
    //   256: aload_0
    //   257: monitorexit
    //   258: aload_1
    //   259: athrow
    //   260: astore_1
    //   261: aload_0
    //   262: aconst_null
    //   263: putfield 53	com/baidu/navisdk/ui/routeguide/model/RGEnlargeRoadMapModel:mArrowBitmap	Landroid/graphics/Bitmap;
    //   266: goto -43 -> 223
    //   269: astore_1
    //   270: aload_1
    //   271: athrow
    //   272: iconst_0
    //   273: istore_3
    //   274: goto -35 -> 239
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	277	0	this	RGEnlargeRoadMapModel
    //   0	277	1	paramString1	String
    //   0	277	2	paramString2	String
    //   1	273	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   120	131	243	java/lang/OutOfMemoryError
    //   120	131	252	finally
    //   244	249	252	finally
    //   4	81	255	finally
    //   81	103	255	finally
    //   107	120	255	finally
    //   131	173	255	finally
    //   173	195	255	finally
    //   199	212	255	finally
    //   223	235	255	finally
    //   253	255	255	finally
    //   270	272	255	finally
    //   212	223	260	java/lang/OutOfMemoryError
    //   212	223	269	finally
    //   261	266	269	finally
  }
  
  public void releaseArrowBitmap()
  {
    try
    {
      if ((this.mArrowBitmap != null) && (!this.mArrowBitmap.isRecycled())) {
        this.mArrowBitmap.recycle();
      }
      this.mArrowBitmap = null;
      return;
    }
    catch (Exception localException)
    {
      this.mArrowBitmap = null;
    }
  }
  
  public void releaseBGBitmap()
  {
    try
    {
      if ((this.mBGBitmap != null) && (!this.mBGBitmap.isRecycled())) {
        this.mBGBitmap.recycle();
      }
      this.mBGBitmap = null;
      return;
    }
    catch (Exception localException)
    {
      this.mBGBitmap = null;
    }
  }
  
  public void reset()
  {
    releaseArrowBitmap();
    releaseBGBitmap();
    this.mIsAnyEnlargeRoadMapShowing = false;
    if (this.mLastestData != null)
    {
      this.mLastestData.clear();
      this.mLastestData = null;
    }
    this.mBGName = null;
    this.mArrowName = null;
    this.mStreetUid = null;
  }
  
  public void saveBGBitmap()
  {
    if (this.mBGBitmap != null)
    {
      Object localObject = new File(SysOSAPI.getInstance().GetSDCardPath() + "/enlarge");
      if (!((File)localObject).exists()) {
        ((File)localObject).mkdir();
      }
      if (!((File)localObject).exists())
      {
        LogUtil.e("RouteGuide", "saveBGBitmap() failed to create dir.");
        return;
      }
      localObject = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
      localObject = ((SimpleDateFormat)localObject).format(new Date()) + "-android.png";
      LogUtil.e("RouteGuide", "saveBGBitmap() path=" + SysOSAPI.getInstance().GetSDCardPath() + "/enlarge" + (String)localObject);
      localObject = new File(SysOSAPI.getInstance().GetSDCardPath() + "/enlarge", (String)localObject);
      if (((File)localObject).exists()) {
        ((File)localObject).delete();
      }
      try
      {
        localObject = new FileOutputStream((File)localObject);
        this.mBGBitmap.compress(Bitmap.CompressFormat.PNG, 90, (OutputStream)localObject);
        ((FileOutputStream)localObject).flush();
        ((FileOutputStream)localObject).close();
        return;
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        LogUtil.e("RouteGuide", "saveBGBitmap() FileNotFoundException.");
        localFileNotFoundException.printStackTrace();
        return;
      }
      catch (IOException localIOException)
      {
        LogUtil.e("RouteGuide", "saveBGBitmap() IOException.");
        localIOException.printStackTrace();
        return;
      }
    }
    LogUtil.e("RouteGuide", "saveBGBitmap() bg is null.");
  }
  
  public void setAnyEnlargeRoadMapShowing(boolean paramBoolean)
  {
    this.mIsAnyEnlargeRoadMapShowing = paramBoolean;
  }
  
  public void setEnlargeMapTypeForStatisitcs(int paramInt)
  {
    this.mEnlargeMapTypeForStatisitcs = paramInt;
  }
  
  public void setIsClickToStreetView(Boolean paramBoolean)
  {
    this.IsClickToStreetView = paramBoolean;
  }
  
  public void setLatestAddDistance(Bundle paramBundle)
  {
    if ((paramBundle != null) && (paramBundle.containsKey("add_dist"))) {
      this.mLatestAddDistance = paramBundle.getInt("add_dist");
    }
  }
  
  public boolean setRasterImage(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    if (paramArrayOfInt != null) {}
    for (;;)
    {
      try
      {
        if ((paramArrayOfInt.length > 0) && (paramInt1 > 0) && (paramInt2 > 0))
        {
          LogUtil.e("RouteGuide", "!# setRasterImage: image width=" + paramInt1 + ", height=" + paramInt2);
          releaseBGBitmap();
          try
          {
            this.mBGBitmap = Bitmap.createBitmap(paramArrayOfInt, paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
            if (this.mBGBitmap == null) {
              LogUtil.e("RouteGuide", "!# setRasterImage: create bitmap failed!!!!");
            }
            releaseArrowBitmap();
            bool = true;
            return bool;
          }
          catch (OutOfMemoryError paramArrayOfInt)
          {
            this.mBGBitmap = null;
            continue;
          }
        }
        LogUtil.e("RouteGuide", "!# setRasterImage: null imageBuf!!");
      }
      finally {}
      boolean bool = false;
    }
  }
  
  public void setmCurrentAddDistance(int paramInt)
  {
    this.mCurrentAddDistance = paramInt;
  }
  
  public void setmLatestAddDistance(int paramInt)
  {
    this.mLatestAddDistance = paramInt;
  }
  
  public void setmStreetUid(String paramString)
  {
    this.mStreetUid = paramString;
  }
  
  public void updateLastCarPos(int paramInt1, int paramInt2, int paramInt3)
  {
    this.mLastCurPosX = paramInt1;
    this.mLastCurPosY = paramInt2;
    this.mLastCurPosRotate = paramInt3;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/routeguide/model/RGEnlargeRoadMapModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */