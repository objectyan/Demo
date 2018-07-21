package com.baidu.carlife.radio.b;

import com.baidu.carlife.model.MusicSongModel;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class v
  extends j<MusicSongModel>
{
  private u a;
  
  public v(m<JSONObject, MusicSongModel> paramm, u paramu)
  {
    super(paramm);
    this.a = paramu;
  }
  
  private List<MusicSongModel> b(JSONObject paramJSONObject)
    throws JSONException
  {
    paramJSONObject = paramJSONObject.getJSONObject("data").getJSONArray("list");
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    int j = paramJSONObject.length();
    while (i < j)
    {
      Object localObject = paramJSONObject.getJSONObject(i);
      localObject = (MusicSongModel)a().a(localObject);
      if (localObject != null) {
        localArrayList.add(localObject);
      }
      i += 1;
    }
    return localArrayList;
  }
  
  protected List<MusicSongModel> a(JSONObject paramJSONObject)
  {
    try
    {
      if (paramJSONObject.getInt("errno") != 0)
      {
        if (this.a != null)
        {
          this.a.a("errmsg=" + paramJSONObject.getString("errmsg"));
          return null;
        }
      }
      else
      {
        paramJSONObject = b(paramJSONObject);
        return paramJSONObject;
      }
    }
    catch (Exception paramJSONObject)
    {
      if (this.a != null) {
        this.a.a(paramJSONObject.toString());
      }
    }
    return null;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/radio/b/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */