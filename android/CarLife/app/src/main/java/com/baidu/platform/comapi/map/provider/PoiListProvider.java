package com.baidu.platform.comapi.map.provider;

import com.baidu.entity.pb.PoiResult;
import com.baidu.entity.pb.PoiResult.Addrs;
import com.baidu.entity.pb.PoiResult.Contents;
import com.baidu.entity.pb.PoiResult.Option;
import com.baidu.platform.comapi.basestruct.Point;
import com.baidu.platform.comjni.tools.AppTools;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PoiListProvider
  implements RenderProvider
{
  private static final int ARR_FOCUS_ID_OFFSET = 79;
  private static final int ARR_NORMAL_ID_OFFSET = 191;
  private static final int BRAND_ICON_ID_OFFSET = 151;
  private static final int OFFSET_VA = 15;
  private static final int SINGLE_NORMAL_ID_OFFSET = 248;
  private boolean isSinglePoi;
  private Point mCenterPoint;
  private boolean mIsAcc;
  private int pageIndex;
  private List<PoiResult> poiResultList;
  private int singleIndex;
  private List<PoiResult.Contents> uselessData;
  
  public PoiListProvider(List<PoiResult> paramList, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    this.poiResultList = paramList;
    this.isSinglePoi = paramBoolean;
    this.singleIndex = paramInt1;
    this.pageIndex = paramInt2;
  }
  
  private JSONObject buildCenterPointJson()
    throws JSONException
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("ty", 5);
    localJSONObject.put("nst", 12);
    localJSONObject.put("fst", 12);
    localJSONObject.put("of", 15);
    localJSONObject.put("in", -1);
    localJSONObject.put("tx", "");
    localJSONObject.put("geo", AppTools.getStringFromGeoPoint(this.mCenterPoint));
    return localJSONObject;
  }
  
  private JSONObject buildPoiContentJson(PoiResult.Contents paramContents, int paramInt)
    throws JSONException
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("ud", paramContents.getUid());
    localJSONObject.put("align", 2);
    localJSONObject.put("ty", 3);
    localJSONObject.put("of", 15);
    if (!this.isSinglePoi)
    {
      localJSONObject.put("fst", 313);
      localJSONObject.put("nst", 312);
    }
    for (;;)
    {
      localJSONObject.put("in", paramInt - getUseLessDataSize());
      localJSONObject.put("tx", paramContents.getName());
      localJSONObject.put("geo", paramContents.getGeo());
      return localJSONObject;
      localJSONObject.put("nst", 312);
      localJSONObject.put("fst", 313);
    }
  }
  
  private JSONArray generateAddressResultData()
    throws JSONException
  {
    JSONArray localJSONArray = new JSONArray();
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("ty", 13);
    localJSONObject.put("nst", 23);
    localJSONObject.put("fst", 23);
    localJSONObject.put("of", 15);
    localJSONObject.put("in", 0);
    localJSONObject.put("tx", ((PoiResult)this.poiResultList.get(this.pageIndex)).getAddrs(0).getName());
    localJSONObject.put("geo", ((PoiResult)this.poiResultList.get(this.pageIndex)).getAddrs(0).getGeo());
    localJSONArray.put(localJSONObject);
    return localJSONArray;
  }
  
  private JSONArray generatePoiResultData()
    throws JSONException
  {
    JSONArray localJSONArray = new JSONArray();
    if (this.isSinglePoi) {
      localJSONArray.put(buildPoiContentJson(((PoiResult)this.poiResultList.get(this.pageIndex)).getContents(this.singleIndex), this.singleIndex));
    }
    for (;;)
    {
      if (this.mCenterPoint != null) {
        localJSONArray.put(buildCenterPointJson());
      }
      return localJSONArray;
      int i = 0;
      while ((i < this.poiResultList.size()) && (i < 1))
      {
        int j = 0;
        if (j < ((PoiResult)this.poiResultList.get(i)).getContentsList().size())
        {
          PoiResult.Contents localContents = ((PoiResult)this.poiResultList.get(i)).getContents(j);
          if ((!isLegalPoiType(localContents.getPoiType())) || (!isMatchAccFlag(localContents.getAccFlag()))) {}
          for (;;)
          {
            j += 1;
            break;
            localJSONArray.put(buildPoiContentJson(localContents, j));
          }
        }
        i += 1;
      }
    }
  }
  
  private boolean isAddressResult()
  {
    if (((PoiResult)this.poiResultList.get(this.pageIndex)).getOption() != null) {
      return (((PoiResult)this.poiResultList.get(this.pageIndex)).getOption().getOpAddr()) && (((PoiResult)this.poiResultList.get(this.pageIndex)).getAddrsCount() > 0);
    }
    return false;
  }
  
  private boolean isLegalPoiType(int paramInt)
  {
    return (paramInt != 2) && (paramInt != 4);
  }
  
  private boolean isMatchAccFlag(int paramInt)
  {
    return (!this.mIsAcc) || (paramInt == 1) || (((PoiResult)this.poiResultList.get(this.pageIndex)).getContentsList().size() == 1);
  }
  
  public String getRenderData()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      if (isAddressResult()) {
        localJSONObject.put("dataset", generateAddressResultData());
      }
      for (;;)
      {
        return localJSONObject.toString();
        localJSONObject.put("dataset", generatePoiResultData());
      }
      return "";
    }
    catch (Exception localException) {}
  }
  
  public int getUseLessDataSize()
  {
    if (this.uselessData == null) {
      return 0;
    }
    return this.uselessData.size();
  }
  
  public void setAccFlag(boolean paramBoolean)
  {
    this.mIsAcc = paramBoolean;
  }
  
  public void setCenterPoint(Point paramPoint)
  {
    this.mCenterPoint = paramPoint;
  }
  
  public void setUseLessData(List<PoiResult.Contents> paramList)
  {
    this.uselessData = paramList;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/platform/comapi/map/provider/PoiListProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */