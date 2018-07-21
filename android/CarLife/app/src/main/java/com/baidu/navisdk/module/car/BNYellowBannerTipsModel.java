package com.baidu.navisdk.module.car;

import android.text.TextUtils;
import com.baidu.navisdk.util.common.LogUtil;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class BNYellowBannerTipsModel
{
  private static BNYellowBannerTipsModel instance = new BNYellowBannerTipsModel();
  protected ArrayList<TipsType> TipsTypeList = null;
  protected String[] bgcolors = null;
  protected int expireTime = 10;
  protected String[] icons = null;
  protected int[] iconsId = { 1711408175, 1711408168, 1711408174, 1711408171, 1711408166, 1711408164, 1711408165, 1711408163, 1711408161, 1711408162, 1711408175, 1711408169, 1711408173, 1711408172, 1711408175, 1711408167, 1711408175 };
  
  public static BNYellowBannerTipsModel getInstance()
  {
    return instance;
  }
  
  private String[] getStringArr(String paramString)
  {
    Object localObject = paramString;
    try
    {
      if (paramString.startsWith("[")) {
        localObject = paramString.substring(1);
      }
      paramString = (String)localObject;
      if (((String)localObject).endsWith("]")) {
        paramString = ((String)localObject).substring(0, ((String)localObject).length() - 1);
      }
      if (paramString != null)
      {
        localObject = paramString.split(",");
        int i = 0;
        for (;;)
        {
          paramString = (String)localObject;
          if (i >= localObject.length) {
            break;
          }
          localObject[i] = localObject[i].replace("\"", "");
          localObject[i] = localObject[i].replace("\\", "");
          i += 1;
        }
      }
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString = null;
    }
  }
  
  private void reset()
  {
    this.expireTime = 10;
    this.icons = null;
    this.bgcolors = null;
    this.TipsTypeList = null;
    this.iconsId = null;
  }
  
  public void initBackGroundColor()
  {
    this.bgcolors = new String[] { "#FFFFFF", "#FFFFFF", "#F75B5B" };
  }
  
  public void initDefaultData()
  {
    this.expireTime = 10;
    this.bgcolors = new String[] { "#FFFFFF", "#FFFFFF", "#F75B5B" };
    this.TipsTypeList = new ArrayList();
    this.TipsTypeList.add(new TipsType(0, "在转离", 1, null));
    this.TipsTypeList.add(new TipsType(1, "离转在", 1, null));
    this.TipsTypeList.add(new TipsType(2, "网络连接中断", 0, null));
    this.TipsTypeList.add(new TipsType(3, "本地化车牌设置提示", 4, null));
    this.TipsTypeList.add(new TipsType(4, "本地化可以/无法规避提示", 3, null));
    this.TipsTypeList.add(new TipsType(5, "非官方云端干预信息", 6, null));
    this.TipsTypeList.add(new TipsType(6, "官方云端干预信息", 7, null));
    this.TipsTypeList.add(new TipsType(7, "躲避拥堵", 11, null));
    this.TipsTypeList.add(new TipsType(8, "路线雷达进入提示", 0, null));
    this.TipsTypeList.add(new TipsType(9, "轨迹路线提示", 10, null));
    this.TipsTypeList.add(new TipsType(10, "官方事故提醒", 8, null));
    this.TipsTypeList.add(new TipsType(11, "恶劣天气", 0, null));
    this.TipsTypeList.add(new TipsType(12, "长途服务区", 0, null));
    this.TipsTypeList.add(new TipsType(13, "终点纠错", 2, null));
    this.TipsTypeList.add(new TipsType(14, "轮渡提示", 5, null));
    this.TipsTypeList.add(new TipsType(15, "路线排序", 0, null));
    this.TipsTypeList.add(new TipsType(16, "离线优先", 12, null));
    this.TipsTypeList.add(new TipsType(17, "途径路小黄条", 0, null));
    this.TipsTypeList.add(new TipsType(18, "WIFI提示", 9, null));
  }
  
  public void parseJson(JSONObject paramJSONObject)
  {
    try
    {
      paramJSONObject = paramJSONObject.getJSONObject("yellow_tips");
      this.expireTime = paramJSONObject.getInt("expire_time");
      this.icons = getStringArr(paramJSONObject.getString("icons"));
      this.bgcolors = getStringArr(paramJSONObject.getString("bgcolors"));
      if (this.TipsTypeList == null) {
        this.TipsTypeList = new ArrayList();
      }
      JSONArray localJSONArray = paramJSONObject.getJSONArray("types");
      int i = 0;
      while (i < localJSONArray.length())
      {
        JSONObject localJSONObject = localJSONArray.getJSONObject(i);
        String str = localJSONObject.getString("priority");
        paramJSONObject = str;
        if (TextUtils.isEmpty(str)) {
          paramJSONObject = "0";
        }
        this.TipsTypeList.add(new TipsType(localJSONObject.getInt("type"), localJSONObject.getString("name"), Integer.parseInt(paramJSONObject), localJSONObject.getString("text")));
        i += 1;
      }
      return;
    }
    catch (Exception paramJSONObject)
    {
      reset();
      paramJSONObject.printStackTrace();
    }
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    for (;;)
    {
      try
      {
        localStringBuffer.append("expireTime:" + this.expireTime + ";");
        i = 0;
        if ((this.icons != null) && (i < this.icons.length))
        {
          localStringBuffer.append("icons" + i + ":" + this.icons[i] + ";");
          i += 1;
          continue;
          if ((this.bgcolors == null) || (i >= this.bgcolors.length)) {
            break label268;
          }
          localStringBuffer.append("bgcolors" + i + ":" + this.bgcolors[i] + ";");
          i += 1;
          continue;
          if ((this.TipsTypeList != null) && (i < this.TipsTypeList.size()))
          {
            localStringBuffer.append("TipsTypeList" + i + ":" + ((TipsType)this.TipsTypeList.get(i)).toString() + ";");
            i += 1;
            continue;
          }
          return localStringBuffer.toString();
        }
      }
      catch (Exception localException)
      {
        LogUtil.e("Navi", "toString Exception");
      }
      int i = 0;
      continue;
      label268:
      i = 0;
    }
  }
  
  public void update()
  {
    if ((this.icons == null) || (this.bgcolors == null) || (this.TipsTypeList == null)) {
      initDefaultData();
    }
    LogUtil.e("BNYellowBannerTipsModel:", toString());
  }
  
  public static class TipsType
  {
    String name;
    int priority;
    String text;
    int type;
    
    public TipsType(int paramInt1, String paramString1, int paramInt2, String paramString2)
    {
      this.type = paramInt1;
      this.name = paramString1;
      this.priority = paramInt2;
      this.text = paramString2;
    }
    
    public String toString()
    {
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append("type:" + this.type + ";");
      localStringBuffer.append("name:" + this.name + ";");
      localStringBuffer.append("priority:" + this.priority + ";");
      localStringBuffer.append("text:" + this.text + ";");
      return localStringBuffer.toString();
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/module/car/BNYellowBannerTipsModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */