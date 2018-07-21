package com.baidu.tts.client.model;

import android.content.Context;
import com.baidu.tts.aop.tts.TtsError;
import com.baidu.tts.tools.DataTool;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class ModelFileBags
{
  private TtsError a;
  private List<ModelFileInfo> b;
  
  public void addFileInfo(ModelFileInfo paramModelFileInfo)
  {
    if (this.b == null) {
      this.b = new ArrayList();
    }
    this.b.add(paramModelFileInfo);
  }
  
  public void generateAbsPath(Context paramContext)
  {
    if (this.b != null)
    {
      Iterator localIterator = this.b.iterator();
      while (localIterator.hasNext()) {
        ((ModelFileInfo)localIterator.next()).generateAbsPath(paramContext);
      }
    }
  }
  
  public ModelFileInfo getModelFileInfo(int paramInt)
  {
    if (this.b != null) {
      return (ModelFileInfo)this.b.get(paramInt);
    }
    return null;
  }
  
  public List<ModelFileInfo> getModelFileInfos()
  {
    return this.b;
  }
  
  public TtsError getTtsError()
  {
    return this.a;
  }
  
  public String getUrl(int paramInt)
  {
    ModelFileInfo localModelFileInfo = getModelFileInfo(paramInt);
    if (localModelFileInfo != null) {
      return localModelFileInfo.getUrl();
    }
    return null;
  }
  
  public boolean isEmpty()
  {
    return DataTool.isListEmpty(this.b);
  }
  
  public void parseJson(JSONArray paramJSONArray)
  {
    int j = paramJSONArray.length();
    int i = 0;
    while (i < j)
    {
      JSONObject localJSONObject = paramJSONArray.optJSONObject(i);
      ModelFileInfo localModelFileInfo = new ModelFileInfo();
      localModelFileInfo.parseJson(localJSONObject);
      addFileInfo(localModelFileInfo);
      i += 1;
    }
  }
  
  public void setList(List<Map<String, String>> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Map localMap = (Map)paramList.next();
      ModelFileInfo localModelFileInfo = new ModelFileInfo();
      localModelFileInfo.setMap(localMap);
      localArrayList.add(localModelFileInfo);
    }
    this.b = localArrayList;
  }
  
  public void setModelFileInfos(List<ModelFileInfo> paramList)
  {
    this.b = paramList;
  }
  
  public void setTtsError(TtsError paramTtsError)
  {
    this.a = paramTtsError;
  }
  
  public JSONArray toJson()
  {
    JSONArray localJSONArray = new JSONArray();
    if (!isEmpty())
    {
      Iterator localIterator = this.b.iterator();
      while (localIterator.hasNext()) {
        localJSONArray.put(((ModelFileInfo)localIterator.next()).toJson());
      }
    }
    return localJSONArray;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/tts/client/model/ModelFileBags.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */