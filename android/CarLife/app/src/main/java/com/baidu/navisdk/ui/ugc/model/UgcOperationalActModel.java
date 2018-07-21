package com.baidu.navisdk.ui.ugc.model;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.baidu.navisdk.util.common.LogUtil;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class UgcOperationalActModel
{
  private static final String TAG = UgcOperationalActModel.class.getName();
  public static final int TYPE_DEFAULT_ELECTRON_EYE = 3;
  public static final int TYPE_DEFAULT_FACING_DIRECTION = 27;
  public static final int TYPE_DEFAULT_FORBID_REVERSE = 22;
  public static final int TYPE_DEFAULT_FORBID_TURN_LEFT = 21;
  public static final int TYPE_DEFAULT_FORBID_TURN_RIGHT = 23;
  public static final int TYPE_DEFAULT_MAP_POINT = 29;
  public static final int TYPE_DEFAULT_NEW_ROAD = 1;
  public static final int TYPE_DEFAULT_REGULATIONS_BREAK = 24;
  public static final int TYPE_DEFAULT_ROAD_BUILD = 6;
  public static final int TYPE_DEFAULT_ROAD_CLOSED = 7;
  public static final int TYPE_DEFAULT_SAME_DIRECTION = 28;
  public static final int TYPE_DEFAULT_SPEED_LIMITED = 26;
  public static final int TYPE_DEFAULT_TRAFIC_ACCIDENT = 5;
  public static final int TYPE_DEFAULT_TRAFIC_JAM = 4;
  public static final int TYPE_DEFAULT_TRAFIC_LIGHT = 25;
  public static final int TYPE_DEFAULT_TRAFIC_REGULATE = 8;
  public static final int TYPE_DEFAULT_TRAFIC_RULE = 2;
  public static final int TYPE_UGC_ACT_BANNER_ICON = 4097;
  public static final int TYPE_UGC_ACT_CAMARA_ICON = 4098;
  public static final int TYPE_UGC_ACT_ENTRY_ICON = 4096;
  public static final int TYPE_UGC_CAMARA_ICON = 4099;
  public static final int TYPE_UGC_MAP_POINT_ICON = 4100;
  public static final int TYPE_UGC_REPORT_UP_ICON = 4101;
  private static UgcOperationalActModel instance;
  private static Map<Integer, SoftReference<Bitmap>> mBitMapCache;
  public static ArrayList<UgcBaseDataModel> mDefaultMapUgcDataList = null;
  public static ArrayList<UgcBaseDataModel> mDefaultNaviUgcDataList = null;
  private static Map<Integer, Integer> mDrawableIdCache = null;
  private static Map<Integer, String> mUrlCache;
  public boolean isWebDataValid = false;
  private actBaseDataModel mActBaseDataModel = null;
  private CommonBaseDataModel mCommonBaseDataModel = null;
  public ArrayList<UgcBaseDataModel> mMapUgcDataList = null;
  public ArrayList<UgcBaseDataModel> mNaviUgcDataList = null;
  public UgcReportSerInfoPackage mUgcReportSerInfoPackage = new UgcReportSerInfoPackage();
  public UgcViewShowModel mUgcViewShowModel = new UgcViewShowModel();
  public ArrayList<Long> ugcReportEventIdList = new ArrayList();
  
  private UgcOperationalActModel()
  {
    mBitMapCache = new HashMap();
    mDrawableIdCache = new HashMap();
    mDrawableIdCache.put(Integer.valueOf(4096), Integer.valueOf(1711408145));
    mDrawableIdCache.put(Integer.valueOf(4098), Integer.valueOf(1711408133));
    mDrawableIdCache.put(Integer.valueOf(4099), Integer.valueOf(1711408133));
    mDrawableIdCache.put(Integer.valueOf(4100), Integer.valueOf(1711408136));
    mDrawableIdCache.put(Integer.valueOf(1), Integer.valueOf(1711408103));
    mDrawableIdCache.put(Integer.valueOf(2), Integer.valueOf(1711408113));
    mDrawableIdCache.put(Integer.valueOf(3), Integer.valueOf(1711408097));
    mDrawableIdCache.put(Integer.valueOf(4), Integer.valueOf(1711408111));
    mDrawableIdCache.put(Integer.valueOf(5), Integer.valueOf(1711408110));
    mDrawableIdCache.put(Integer.valueOf(6), Integer.valueOf(1711408105));
    mDrawableIdCache.put(Integer.valueOf(7), Integer.valueOf(1711408106));
    mDrawableIdCache.put(Integer.valueOf(8), Integer.valueOf(1711408123));
    mDrawableIdCache.put(Integer.valueOf(21), Integer.valueOf(1711408100));
    mDrawableIdCache.put(Integer.valueOf(22), Integer.valueOf(1711408099));
    mDrawableIdCache.put(Integer.valueOf(23), Integer.valueOf(1711408101));
    mDrawableIdCache.put(Integer.valueOf(24), Integer.valueOf(1711408104));
    mDrawableIdCache.put(Integer.valueOf(25), Integer.valueOf(1711408112));
    mDrawableIdCache.put(Integer.valueOf(26), Integer.valueOf(1711408109));
    mDrawableIdCache.put(Integer.valueOf(27), Integer.valueOf(1711408098));
    mDrawableIdCache.put(Integer.valueOf(28), Integer.valueOf(1711408108));
    mDrawableIdCache.put(Integer.valueOf(29), Integer.valueOf(1711408136));
  }
  
  public static UgcOperationalActModel getInstance()
  {
    if (instance == null) {
      instance = new UgcOperationalActModel();
    }
    return instance;
  }
  
  public static void initDefaultData()
  {
    mDefaultMapUgcDataList = new ArrayList();
    UgcBaseDataModel localUgcBaseDataModel1 = new UgcBaseDataModel("地图选点", 29, null);
    UgcBaseDataModel localUgcBaseDataModel2 = new UgcBaseDataModel("拥堵", 4, null);
    localUgcBaseDataModel2.addSubUgcData(localUgcBaseDataModel1);
    mDefaultMapUgcDataList.add(localUgcBaseDataModel2);
    localUgcBaseDataModel2 = new UgcBaseDataModel("事故", 5, null);
    localUgcBaseDataModel2.addSubUgcData(localUgcBaseDataModel1);
    mDefaultMapUgcDataList.add(localUgcBaseDataModel2);
    localUgcBaseDataModel2 = new UgcBaseDataModel("施工", 6, null);
    localUgcBaseDataModel2.addSubUgcData(localUgcBaseDataModel1);
    mDefaultMapUgcDataList.add(localUgcBaseDataModel2);
    localUgcBaseDataModel2 = new UgcBaseDataModel("封路", 7, null);
    localUgcBaseDataModel2.addSubUgcData(localUgcBaseDataModel1);
    mDefaultMapUgcDataList.add(localUgcBaseDataModel2);
    mDefaultNaviUgcDataList = new ArrayList();
    localUgcBaseDataModel1 = new UgcBaseDataModel("对向车道", 27, null);
    localUgcBaseDataModel2 = new UgcBaseDataModel("同向车道", 28, null);
    UgcBaseDataModel localUgcBaseDataModel3 = new UgcBaseDataModel("新路", 1, null);
    mDefaultNaviUgcDataList.add(localUgcBaseDataModel3);
    localUgcBaseDataModel3 = new UgcBaseDataModel("交规", 2, null);
    localUgcBaseDataModel3.addSubUgcData(new UgcBaseDataModel("禁左", 21, null));
    localUgcBaseDataModel3.addSubUgcData(new UgcBaseDataModel("禁调头", 22, null));
    localUgcBaseDataModel3.addSubUgcData(new UgcBaseDataModel("禁右", 23, null));
    mDefaultNaviUgcDataList.add(localUgcBaseDataModel3);
    localUgcBaseDataModel3 = new UgcBaseDataModel("电子眼", 3, null);
    localUgcBaseDataModel3.addSubUgcData(new UgcBaseDataModel("违章", 24, null));
    localUgcBaseDataModel3.addSubUgcData(new UgcBaseDataModel("红绿灯", 25, null));
    localUgcBaseDataModel3.addSubUgcData(new UgcBaseDataModel("限速", 26, null));
    mDefaultNaviUgcDataList.add(localUgcBaseDataModel3);
    localUgcBaseDataModel3 = new UgcBaseDataModel("拥堵", 4, null);
    localUgcBaseDataModel3.addSubUgcData(localUgcBaseDataModel1);
    localUgcBaseDataModel3.addSubUgcData(localUgcBaseDataModel2);
    mDefaultNaviUgcDataList.add(localUgcBaseDataModel3);
    localUgcBaseDataModel3 = new UgcBaseDataModel("事故", 5, null);
    localUgcBaseDataModel3.addSubUgcData(localUgcBaseDataModel1);
    localUgcBaseDataModel3.addSubUgcData(localUgcBaseDataModel2);
    mDefaultNaviUgcDataList.add(localUgcBaseDataModel3);
    localUgcBaseDataModel3 = new UgcBaseDataModel("施工", 6, null);
    localUgcBaseDataModel3.addSubUgcData(localUgcBaseDataModel1);
    localUgcBaseDataModel3.addSubUgcData(localUgcBaseDataModel2);
    mDefaultNaviUgcDataList.add(localUgcBaseDataModel3);
    localUgcBaseDataModel3 = new UgcBaseDataModel("封路", 7, null);
    localUgcBaseDataModel3.addSubUgcData(localUgcBaseDataModel1);
    localUgcBaseDataModel3.addSubUgcData(localUgcBaseDataModel2);
    mDefaultNaviUgcDataList.add(localUgcBaseDataModel3);
  }
  
  public void addEventId(Long paramLong)
  {
    if (this.ugcReportEventIdList == null) {
      this.ugcReportEventIdList = new ArrayList();
    }
    this.ugcReportEventIdList.add(paramLong);
  }
  
  public void addMapUgcBaseDataModel(UgcBaseDataModel paramUgcBaseDataModel)
  {
    if (this.mMapUgcDataList == null) {
      this.mMapUgcDataList = new ArrayList();
    }
    if (this.mMapUgcDataList != null) {
      this.mMapUgcDataList.add(paramUgcBaseDataModel);
    }
  }
  
  public void addNaviUgcBaseDataModel(UgcBaseDataModel paramUgcBaseDataModel)
  {
    if (this.mNaviUgcDataList == null) {
      this.mNaviUgcDataList = new ArrayList();
    }
    if (this.mNaviUgcDataList != null) {
      this.mNaviUgcDataList.add(paramUgcBaseDataModel);
    }
  }
  
  public void clearBaseDataModel()
  {
    if (this.mMapUgcDataList != null)
    {
      this.mMapUgcDataList.clear();
      this.mMapUgcDataList = null;
    }
    if (this.mNaviUgcDataList != null)
    {
      this.mNaviUgcDataList.clear();
      this.mNaviUgcDataList = null;
    }
    this.mActBaseDataModel = null;
    this.mCommonBaseDataModel = null;
  }
  
  public actBaseDataModel getActBaseDataModel()
  {
    return this.mActBaseDataModel;
  }
  
  public CommonBaseDataModel getCommonBaseDataModel()
  {
    return this.mCommonBaseDataModel;
  }
  
  public Bitmap getUgcBitMapByType(int paramInt)
  {
    if ((mBitMapCache == null) || (!mBitMapCache.containsKey(Integer.valueOf(paramInt)))) {
      return null;
    }
    return (Bitmap)((SoftReference)mBitMapCache.get(Integer.valueOf(paramInt))).get();
  }
  
  public int getUgcDrawableIdByType(int paramInt)
  {
    if ((mDrawableIdCache == null) || (!mDrawableIdCache.containsKey(Integer.valueOf(paramInt)))) {
      return -1;
    }
    return ((Integer)mDrawableIdCache.get(Integer.valueOf(paramInt))).intValue();
  }
  
  public String getUrlByType(int paramInt)
  {
    if ((mUrlCache == null) || (!mUrlCache.containsKey(Integer.valueOf(paramInt)))) {
      return null;
    }
    return (String)mUrlCache.get(Integer.valueOf(paramInt));
  }
  
  public boolean isContainsEventId(Long paramLong)
  {
    if (this.ugcReportEventIdList != null)
    {
      Iterator localIterator = this.ugcReportEventIdList.iterator();
      while (localIterator.hasNext()) {
        if ((Long)localIterator.next() == paramLong) {
          return true;
        }
      }
    }
    return false;
  }
  
  public boolean isInOperationAct()
  {
    return this.mActBaseDataModel != null;
  }
  
  public void setActBaseDataModel(actBaseDataModel paramactBaseDataModel)
  {
    this.mActBaseDataModel = paramactBaseDataModel;
  }
  
  public void setCommonBaseDataModel(CommonBaseDataModel paramCommonBaseDataModel)
  {
    this.mCommonBaseDataModel = paramCommonBaseDataModel;
  }
  
  public void setUgcBitMapWithType(int paramInt, Bitmap paramBitmap)
  {
    if (paramBitmap != null)
    {
      if (mBitMapCache == null) {
        mBitMapCache = new HashMap();
      }
      mBitMapCache.put(Integer.valueOf(paramInt), new SoftReference(paramBitmap));
    }
  }
  
  public void showSpecificDataLog()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    if (this.mActBaseDataModel != null)
    {
      localStringBuffer.append(this.mActBaseDataModel.getSpecificDataLog());
      localStringBuffer.append("\r\n");
    }
    if (this.mCommonBaseDataModel != null)
    {
      localStringBuffer.append(this.mCommonBaseDataModel.getSpecificDataLog());
      localStringBuffer.append("\r\n");
    }
    Iterator localIterator;
    UgcBaseDataModel localUgcBaseDataModel;
    if (this.mMapUgcDataList != null)
    {
      localIterator = this.mMapUgcDataList.iterator();
      while (localIterator.hasNext())
      {
        localUgcBaseDataModel = (UgcBaseDataModel)localIterator.next();
        if (localUgcBaseDataModel != null)
        {
          localStringBuffer.append(localUgcBaseDataModel.getSpecificDataLog());
          localStringBuffer.append("\r\n");
        }
      }
    }
    if ((this.mNaviUgcDataList != null) && (this.mNaviUgcDataList != null))
    {
      localIterator = this.mNaviUgcDataList.iterator();
      while (localIterator.hasNext())
      {
        localUgcBaseDataModel = (UgcBaseDataModel)localIterator.next();
        if (localUgcBaseDataModel != null)
        {
          localStringBuffer.append(localUgcBaseDataModel.getSpecificDataLog());
          localStringBuffer.append("\r\n");
        }
      }
    }
    LogUtil.e(TAG, localStringBuffer.toString());
  }
  
  public static abstract interface BaseDataModel
  {
    public abstract String getSpecificDataLog();
    
    public abstract void initIconUrl();
    
    public abstract void setIcon(String paramString, Bitmap paramBitmap);
  }
  
  public static class CommonBaseDataModel
    implements UgcOperationalActModel.BaseDataModel
  {
    public SoftReference<Bitmap> caramaIcon = null;
    public String caramaIconUrl = null;
    public String caramaTitle = null;
    public String mapPointIconUrl = null;
    public String mapPointTitle = null;
    public String textLeft = null;
    public String textNew = null;
    public String textRight = null;
    
    public CommonBaseDataModel(String paramString1, String paramString2, String paramString3, String paramString4)
    {
      this.caramaTitle = paramString1;
      this.caramaIconUrl = paramString2;
      this.mapPointTitle = paramString3;
      this.mapPointIconUrl = paramString4;
    }
    
    public Bitmap getCaramaIcon(ImageView paramImageView)
    {
      if (this.caramaIconUrl == null) {}
      while ((this.caramaIcon == null) || (this.caramaIcon.get() == null)) {
        return null;
      }
      return (Bitmap)this.caramaIcon.get();
    }
    
    public String getSpecificDataLog()
    {
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append("carama:{");
      localStringBuffer.append("caramaTitle:" + this.caramaTitle + ",");
      localStringBuffer.append("caramaIconUrl:" + this.caramaIconUrl);
      localStringBuffer.append("}");
      localStringBuffer.append("map_point:{");
      localStringBuffer.append("mapPointTitle:" + this.mapPointTitle + ",");
      localStringBuffer.append("mapPointIconUrl:" + this.mapPointIconUrl);
      localStringBuffer.append("}");
      return localStringBuffer.toString();
    }
    
    public void initIconUrl()
    {
      if (UgcOperationalActModel.mUrlCache == null) {
        UgcOperationalActModel.access$002(new HashMap());
      }
      if ((this.caramaIconUrl != null) && (this.mapPointIconUrl != null))
      {
        UgcOperationalActModel.mUrlCache.put(Integer.valueOf(4099), this.caramaIconUrl);
        UgcOperationalActModel.mUrlCache.put(Integer.valueOf(4100), this.mapPointIconUrl);
      }
    }
    
    public void setFeedbackStyle(String paramString1, String paramString2, String paramString3)
    {
      this.textLeft = paramString1;
      this.textRight = paramString2;
      this.textNew = paramString3;
    }
    
    public void setIcon(String paramString, Bitmap paramBitmap)
    {
      if ((paramString == null) || (paramBitmap == null)) {}
      while ((this.caramaIconUrl == null) || (!this.caramaIconUrl.endsWith(paramString))) {
        return;
      }
      this.caramaIcon = new SoftReference(paramBitmap);
    }
  }
  
  public static class UgcBaseDataModel
    implements UgcOperationalActModel.BaseDataModel
  {
    public SoftReference<Bitmap> iconImage;
    public String iconUrl;
    public String title;
    public int type;
    public ArrayList<UgcBaseDataModel> ugcDataSub = null;
    
    public UgcBaseDataModel(String paramString1, int paramInt, String paramString2)
    {
      this.title = paramString1;
      this.type = paramInt;
      this.iconUrl = paramString2;
      initIconUrl();
    }
    
    public void addSubUgcData(UgcBaseDataModel paramUgcBaseDataModel)
    {
      if (this.ugcDataSub == null) {
        this.ugcDataSub = new ArrayList();
      }
      if (this.ugcDataSub != null) {
        this.ugcDataSub.add(paramUgcBaseDataModel);
      }
    }
    
    public String getSpecificDataLog()
    {
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append("{");
      localStringBuffer.append("title:" + this.title + ",");
      localStringBuffer.append("type:" + this.type + ",");
      localStringBuffer.append("iconUrl:" + this.iconUrl);
      if (this.ugcDataSub != null)
      {
        Iterator localIterator = this.ugcDataSub.iterator();
        while (localIterator.hasNext()) {
          localStringBuffer.append(((UgcBaseDataModel)localIterator.next()).getSpecificDataLog());
        }
      }
      localStringBuffer.append("}");
      return localStringBuffer.toString();
    }
    
    public void initIconUrl()
    {
      if (UgcOperationalActModel.mUrlCache == null) {
        UgcOperationalActModel.access$002(new HashMap());
      }
      if (this.iconUrl != null) {
        UgcOperationalActModel.mUrlCache.put(Integer.valueOf(this.type), this.iconUrl);
      }
    }
    
    public void setIcon(String paramString, Bitmap paramBitmap)
    {
      if ((this.iconUrl == null) || (paramString == null) || (paramBitmap == null)) {}
      while (!this.iconUrl.equals(paramString)) {
        return;
      }
      this.iconImage = new SoftReference(paramBitmap);
    }
  }
  
  public static class UgcReportSerInfoPackage
  {
    public String Name = "";
    public String business_trigger = "1";
    public String content = "";
    public String fromName = "";
    public String fromPoint = "";
    public String fromUid = "";
    public String parentType = "-1";
    public String photoPicPath = null;
    public String photoPoint = "";
    public String point = "";
    public String screenshotPicPath = null;
    public String sessionId = "";
    public String subType = "";
    public String toName = "";
    public String toPoint = "";
    public String toUid = "";
    public String uploadType = "1";
    public String userPoint = "";
    public String voicePath = null;
    
    public void clearInfo()
    {
      this.uploadType = "1";
      this.fromPoint = "";
      this.fromUid = "";
      this.fromName = "";
      this.toPoint = "";
      this.toUid = "";
      this.toName = "";
      this.business_trigger = "1";
      this.Name = "";
      this.parentType = "-1";
      this.subType = "";
      this.content = "";
      this.screenshotPicPath = null;
      this.photoPicPath = null;
      this.voicePath = null;
      this.point = "";
      this.photoPoint = "";
      this.userPoint = "";
      this.sessionId = "";
    }
    
    public String resportInfoComplemented()
    {
      return null;
    }
  }
  
  public static class UgcViewShowModel
  {
    public String content = null;
    public boolean hasPhoto = false;
    public int parentType = -1;
    public int subType = -1;
    public int sumTime = -1;
    
    public void dataClear()
    {
      this.parentType = -1;
      this.subType = -1;
      this.content = null;
      this.sumTime = -1;
      this.hasPhoto = false;
    }
  }
  
  public static class actBaseDataModel
    implements UgcOperationalActModel.BaseDataModel
  {
    public SoftReference<Bitmap> bannerIcon = null;
    public String bannerIconUrl = null;
    public String bannerTips = null;
    public String bottonTips = null;
    public SoftReference<Bitmap> camaraIcon = null;
    public String camaraIconUrl = null;
    public String camraTips = null;
    public SoftReference<Bitmap> entryIcon = null;
    public String entryIconUrl = null;
    public String entryTips = null;
    
    public actBaseDataModel(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
    {
      this.entryIconUrl = paramString1;
      this.bannerIconUrl = paramString2;
      this.camaraIconUrl = paramString3;
      this.entryTips = paramString4;
      this.bannerTips = paramString5;
      this.camraTips = paramString6;
      this.bottonTips = paramString7;
      initIconUrl();
    }
    
    public String getSpecificDataLog()
    {
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append("act:{");
      localStringBuffer.append("entryIconUrl:" + this.entryIconUrl + ",");
      localStringBuffer.append("bannerIconUrl:" + this.bannerIconUrl + ",");
      localStringBuffer.append("camaraIconUrl:" + this.camaraIconUrl + ",");
      localStringBuffer.append("entryTips:" + this.entryTips + ",");
      localStringBuffer.append("bannerTips:" + this.bannerTips + ",");
      localStringBuffer.append("camraTips:" + this.camraTips + ",");
      localStringBuffer.append("bottonTips:" + this.bottonTips);
      localStringBuffer.append("}");
      return localStringBuffer.toString();
    }
    
    public void initIconUrl()
    {
      if (UgcOperationalActModel.mUrlCache == null) {
        UgcOperationalActModel.access$002(new HashMap());
      }
      if ((this.entryIconUrl != null) && (this.bannerIconUrl != null) && (this.camaraIconUrl != null))
      {
        UgcOperationalActModel.mUrlCache.put(Integer.valueOf(4096), this.entryIconUrl);
        UgcOperationalActModel.mUrlCache.put(Integer.valueOf(4097), this.bannerIconUrl);
        UgcOperationalActModel.mUrlCache.put(Integer.valueOf(4098), this.camaraIconUrl);
      }
    }
    
    public void setIcon(String paramString, Bitmap paramBitmap)
    {
      if ((paramString == null) || (paramBitmap == null)) {}
      do
      {
        return;
        if ((this.entryIconUrl != null) && (this.entryIconUrl.endsWith(paramString)))
        {
          this.entryIcon = new SoftReference(paramBitmap);
          return;
        }
        if ((this.bannerIconUrl != null) && (this.bannerIconUrl.endsWith(paramString)))
        {
          this.bannerIcon = new SoftReference(paramBitmap);
          return;
        }
      } while ((this.camaraIconUrl == null) || (!this.camaraIconUrl.endsWith(paramString)));
      this.camaraIcon = new SoftReference(paramBitmap);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/ugc/model/UgcOperationalActModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */