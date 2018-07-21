package com.baidu.platform.comapi.map;

import com.baidu.platform.comapi.util.JsonBuilder;
import com.baidu.platform.comjni.map.basemap.AppBaseMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GraphicsOverlay
  extends InnerOverlay
{
  private final List<Geometry> geometryList = new ArrayList();
  private boolean isNeedUpdate = true;
  
  public GraphicsOverlay()
  {
    super(36);
  }
  
  public GraphicsOverlay(AppBaseMap paramAppBaseMap)
  {
    super(36, paramAppBaseMap);
  }
  
  public boolean addGeometry(Geometry paramGeometry)
  {
    synchronized (this.geometryList)
    {
      if (this.geometryList.contains(paramGeometry)) {
        return false;
      }
      this.isNeedUpdate = this.geometryList.add(paramGeometry);
      return this.isNeedUpdate;
    }
  }
  
  public void clear()
  {
    synchronized (this.geometryList)
    {
      this.geometryList.clear();
      super.clear();
      return;
    }
  }
  
  public void forceUpdate()
  {
    this.isNeedUpdate = true;
    UpdateOverlay();
  }
  
  public String getData()
  {
    if (this.isNeedUpdate)
    {
      synchronized (this.geometryList)
      {
        JsonBuilder localJsonBuilder = new JsonBuilder();
        localJsonBuilder.object();
        localJsonBuilder.key("dataset").arrayValue();
        Iterator localIterator = this.geometryList.iterator();
        if (localIterator.hasNext()) {
          localJsonBuilder.objectValue(((Geometry)localIterator.next()).getData());
        }
      }
      ((JsonBuilder)localObject).endArrayValue();
      ((JsonBuilder)localObject).endObject();
      setData(((JsonBuilder)localObject).getJson());
      this.isNeedUpdate = false;
    }
    return super.getData();
  }
  
  public boolean removeGeometry(Geometry paramGeometry)
  {
    synchronized (this.geometryList)
    {
      this.isNeedUpdate = this.geometryList.remove(paramGeometry);
      boolean bool = this.isNeedUpdate;
      return bool;
    }
  }
  
  public void setData(String paramString)
  {
    super.setData(paramString);
    this.isNeedUpdate = true;
  }
  
  public boolean switchLayer(int paramInt)
  {
    return this.mBaseMap.SwitchLayer(paramInt, this.mLayerID);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/platform/comapi/map/GraphicsOverlay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */