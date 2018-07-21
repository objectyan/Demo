package com.baidu.navisdk.module.ugc.data.datastatus;

import android.text.TextUtils;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import java.net.URLEncoder;
import java.text.NumberFormat;

public class UgcReportInfoUploadPackage
{
  public int businessTrigger = 1;
  public int cityId = -1;
  public String cityName = null;
  public String contact = "";
  public String content = null;
  public String cuid = null;
  public int detailPosition = -1;
  public int detailType = -1;
  public String endName = null;
  public String endPoint = null;
  public String fromName = null;
  public String fromPoint = "";
  public String fromUid = null;
  public String guid = null;
  public int id = -1;
  public int isChange = 0;
  public boolean isInSubView = false;
  public int lanePosition = -1;
  public int laneType = -1;
  public String linkid = null;
  public GeoPoint mGeoPoint;
  public int mainPosition = -1;
  public int mark = -1;
  public String mrsl = null;
  public String name = null;
  public int os = 0;
  public String osv = null;
  public int parentType = -1;
  public String photoPicPath = null;
  public String photoPoint = null;
  public String point = null;
  public int recordTime = -1;
  public String roadName = null;
  public String screenshotPicPath = null;
  public String sessionId = null;
  public int speedLimit = -1;
  public String startName = null;
  public String startPoint = null;
  public int subPosition = -1;
  public int subType = -1;
  public int supply = 0;
  public String sv = null;
  public String toName = null;
  public String toPoint = null;
  public String toUid = null;
  public String userPoint = null;
  public String voicePath = null;
  
  private static UgcReportInfoUploadPackage copy(UgcReportInfoUploadPackage paramUgcReportInfoUploadPackage)
  {
    if (paramUgcReportInfoUploadPackage == null) {
      return null;
    }
    UgcReportInfoUploadPackage localUgcReportInfoUploadPackage = new UgcReportInfoUploadPackage();
    localUgcReportInfoUploadPackage.id = paramUgcReportInfoUploadPackage.id;
    localUgcReportInfoUploadPackage.userPoint = paramUgcReportInfoUploadPackage.userPoint;
    localUgcReportInfoUploadPackage.point = paramUgcReportInfoUploadPackage.point;
    localUgcReportInfoUploadPackage.businessTrigger = paramUgcReportInfoUploadPackage.businessTrigger;
    localUgcReportInfoUploadPackage.parentType = paramUgcReportInfoUploadPackage.parentType;
    localUgcReportInfoUploadPackage.subType = paramUgcReportInfoUploadPackage.subType;
    localUgcReportInfoUploadPackage.guid = paramUgcReportInfoUploadPackage.guid;
    localUgcReportInfoUploadPackage.content = paramUgcReportInfoUploadPackage.content;
    localUgcReportInfoUploadPackage.photoPicPath = paramUgcReportInfoUploadPackage.photoPicPath;
    localUgcReportInfoUploadPackage.photoPoint = paramUgcReportInfoUploadPackage.photoPoint;
    localUgcReportInfoUploadPackage.roadName = paramUgcReportInfoUploadPackage.roadName;
    localUgcReportInfoUploadPackage.isChange = paramUgcReportInfoUploadPackage.isChange;
    localUgcReportInfoUploadPackage.contact = paramUgcReportInfoUploadPackage.contact;
    localUgcReportInfoUploadPackage.voicePath = paramUgcReportInfoUploadPackage.voicePath;
    localUgcReportInfoUploadPackage.os = paramUgcReportInfoUploadPackage.os;
    localUgcReportInfoUploadPackage.osv = paramUgcReportInfoUploadPackage.osv;
    localUgcReportInfoUploadPackage.sv = paramUgcReportInfoUploadPackage.sv;
    localUgcReportInfoUploadPackage.cuid = paramUgcReportInfoUploadPackage.cuid;
    localUgcReportInfoUploadPackage.name = paramUgcReportInfoUploadPackage.name;
    localUgcReportInfoUploadPackage.sessionId = paramUgcReportInfoUploadPackage.sessionId;
    localUgcReportInfoUploadPackage.mrsl = paramUgcReportInfoUploadPackage.mrsl;
    localUgcReportInfoUploadPackage.fromName = paramUgcReportInfoUploadPackage.fromName;
    localUgcReportInfoUploadPackage.fromPoint = paramUgcReportInfoUploadPackage.fromPoint;
    localUgcReportInfoUploadPackage.toPoint = paramUgcReportInfoUploadPackage.toPoint;
    localUgcReportInfoUploadPackage.fromUid = paramUgcReportInfoUploadPackage.fromUid;
    localUgcReportInfoUploadPackage.cityId = paramUgcReportInfoUploadPackage.cityId;
    localUgcReportInfoUploadPackage.cityName = paramUgcReportInfoUploadPackage.cityName;
    localUgcReportInfoUploadPackage.toUid = paramUgcReportInfoUploadPackage.toUid;
    localUgcReportInfoUploadPackage.toName = paramUgcReportInfoUploadPackage.toName;
    localUgcReportInfoUploadPackage.screenshotPicPath = paramUgcReportInfoUploadPackage.screenshotPicPath;
    localUgcReportInfoUploadPackage.laneType = paramUgcReportInfoUploadPackage.laneType;
    localUgcReportInfoUploadPackage.detailType = paramUgcReportInfoUploadPackage.detailType;
    localUgcReportInfoUploadPackage.speedLimit = paramUgcReportInfoUploadPackage.speedLimit;
    localUgcReportInfoUploadPackage.startPoint = paramUgcReportInfoUploadPackage.startPoint;
    localUgcReportInfoUploadPackage.endPoint = paramUgcReportInfoUploadPackage.endPoint;
    localUgcReportInfoUploadPackage.startName = paramUgcReportInfoUploadPackage.startName;
    localUgcReportInfoUploadPackage.endName = paramUgcReportInfoUploadPackage.endName;
    localUgcReportInfoUploadPackage.mark = paramUgcReportInfoUploadPackage.mark;
    localUgcReportInfoUploadPackage.supply = paramUgcReportInfoUploadPackage.supply;
    localUgcReportInfoUploadPackage.linkid = paramUgcReportInfoUploadPackage.linkid;
    return localUgcReportInfoUploadPackage;
  }
  
  private void formatInfo()
  {
    this.userPoint = formatPoint(this.userPoint);
    this.point = formatPoint(this.point);
    this.guid = formatStr(this.guid);
    this.content = formatUTF8Encode(this.content);
    this.photoPoint = formatPoint(this.photoPoint);
    this.roadName = formatUTF8Encode(this.roadName);
    this.osv = formatStr(this.osv);
    this.sv = formatStr(this.sv);
    this.cuid = formatStr(this.cuid);
    this.name = formatUTF8Encode(this.name);
    this.sessionId = formatStr(this.sessionId);
    this.mrsl = formatStr(this.mrsl);
    this.fromName = formatUTF8Encode(this.fromName);
    this.toPoint = formatPoint(this.toPoint);
    this.fromUid = formatStr(this.fromUid);
    this.cityName = formatUTF8Encode(this.cityName);
    this.toUid = formatStr(this.toUid);
    this.toName = formatUTF8Encode(this.toName);
    this.startPoint = formatPoint(this.startPoint);
    this.endPoint = formatPoint(this.endPoint);
    this.startName = formatUTF8Encode(this.startName);
    this.endName = formatUTF8Encode(this.endName);
    this.linkid = formatStr(this.linkid);
  }
  
  private String formatPoint(String paramString)
  {
    Object localObject3;
    if (TextUtils.isEmpty(paramString)) {
      localObject3 = "";
    }
    for (;;)
    {
      return (String)localObject3;
      localObject3 = null;
      int i = paramString.indexOf(",");
      Object localObject1 = localObject3;
      String str;
      if (i > 0)
      {
        localObject1 = localObject3;
        if (i < paramString.length() - 1)
        {
          localObject1 = paramString.substring(0, i);
          str = paramString.substring(i + 1, paramString.length());
        }
      }
      try
      {
        double d1 = Double.parseDouble((String)localObject1);
        double d2 = Double.parseDouble(str);
        localObject1 = NumberFormat.getInstance();
        ((NumberFormat)localObject1).setGroupingUsed(false);
        localObject1 = ((NumberFormat)localObject1).format(Double.valueOf(d1)) + "," + ((NumberFormat)localObject1).format(Double.valueOf(d2));
        localObject3 = localObject1;
        if (localObject1 != null) {
          continue;
        }
        return paramString;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Object localObject2 = localObject3;
        }
      }
    }
  }
  
  private String formatStr(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
  }
  
  private String formatUTF8Encode(String paramString)
  {
    String str = "";
    if (paramString != null) {}
    try
    {
      str = URLEncoder.encode(paramString, "utf-8");
      return str;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return "";
  }
  
  public static UgcReportInfoUploadPackage getNewFormatPackage(UgcReportInfoUploadPackage paramUgcReportInfoUploadPackage)
  {
    paramUgcReportInfoUploadPackage = copy(paramUgcReportInfoUploadPackage);
    if (paramUgcReportInfoUploadPackage == null) {
      return null;
    }
    paramUgcReportInfoUploadPackage.formatInfo();
    return paramUgcReportInfoUploadPackage;
  }
  
  public void clearInfo()
  {
    this.id = -1;
    this.userPoint = null;
    this.point = null;
    this.businessTrigger = 1;
    this.parentType = -1;
    this.subType = -1;
    this.guid = null;
    this.content = null;
    this.photoPicPath = null;
    this.photoPoint = null;
    this.roadName = null;
    this.isChange = 0;
    this.contact = "";
    this.voicePath = null;
    this.os = 0;
    this.osv = null;
    this.sv = null;
    this.cuid = null;
    this.name = null;
    this.sessionId = null;
    this.mrsl = null;
    this.fromName = null;
    this.fromPoint = "";
    this.toPoint = null;
    this.fromUid = null;
    this.cityId = -1;
    this.cityName = null;
    this.toUid = null;
    this.toName = null;
    this.screenshotPicPath = null;
    this.laneType = -1;
    this.detailType = -1;
    this.speedLimit = -1;
    this.startPoint = null;
    this.endPoint = null;
    this.startName = null;
    this.endName = null;
    this.mark = -1;
    this.supply = 0;
    this.linkid = null;
    this.mGeoPoint = null;
    this.isInSubView = false;
  }
  
  public void showLog(String paramString)
  {
    LogUtil.e(paramString + ":UgcReportInfoUploadPackage", "parentType:" + this.parentType + "laneType:" + this.laneType + "detailType" + this.detailType + "os:" + this.os + "cuid" + this.cuid);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/module/ugc/data/datastatus/UgcReportInfoUploadPackage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */