package com.baidu.tts.client.model;

import com.baidu.tts.aop.tts.TtsError;
import com.baidu.tts.tools.DataTool;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class ModelBags
{
  private TtsError a;
  private List<ModelInfo> b;
  
  public void addModelInfo(ModelInfo paramModelInfo)
  {
    if (this.b == null) {
      this.b = new ArrayList();
    }
    this.b.add(paramModelInfo);
  }
  
  public List<ModelInfo> getModelInfos()
  {
    return this.b;
  }
  
  public TtsError getTtsError()
  {
    return this.a;
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
      ModelInfo localModelInfo = new ModelInfo();
      localModelInfo.parseJson(localJSONObject);
      addModelInfo(localModelInfo);
      i += 1;
    }
  }
  
  public void setList(List<Map<String, String>> paramList)
  {
    if (paramList != null)
    {
      ArrayList localArrayList = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Map localMap = (Map)paramList.next();
        ModelInfo localModelInfo = new ModelInfo();
        localModelInfo.setMap(localMap);
        localArrayList.add(localModelInfo);
      }
      this.b = localArrayList;
    }
  }
  
  public void setModelInfos(List<ModelInfo> paramList)
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
        localJSONArray.put(((ModelInfo)localIterator.next()).toJson());
      }
    }
    return localJSONArray;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/tts/client/model/ModelBags.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */