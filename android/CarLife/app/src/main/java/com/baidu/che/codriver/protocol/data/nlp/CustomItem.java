package com.baidu.che.codriver.protocol.data.nlp;

import android.text.TextUtils;
import com.baidu.che.codriver.util.INoProguard;

public class CustomItem
  implements INoProguard
{
  private String domain;
  private int index;
  private String indexList;
  private String intent;
  private String label;
  private String scene;
  private Slots slots;
  private String url;
  private int x;
  private int y;
  
  public String getDomain()
  {
    return this.domain;
  }
  
  public int getIndex()
  {
    return this.index;
  }
  
  public String getIndexList()
  {
    if (TextUtils.isEmpty(this.indexList)) {
      return "";
    }
    return this.indexList;
  }
  
  public String getIntent()
  {
    return this.intent;
  }
  
  public String getLabel()
  {
    if (TextUtils.isEmpty(this.label)) {
      return "";
    }
    return this.label;
  }
  
  public String getScene()
  {
    if (TextUtils.isEmpty(this.scene)) {
      return "";
    }
    return this.scene;
  }
  
  public Slots getSlots()
  {
    return this.slots;
  }
  
  public String getUrl()
  {
    return this.url;
  }
  
  public int getX()
  {
    return this.x;
  }
  
  public int getY()
  {
    return this.y;
  }
  
  public void setDomain(String paramString)
  {
    this.domain = paramString;
  }
  
  public void setIndex(int paramInt)
  {
    this.index = paramInt;
  }
  
  public void setIndexList(String paramString)
  {
    this.indexList = paramString;
  }
  
  public void setIntent(String paramString)
  {
    this.intent = paramString;
  }
  
  public void setLabel(String paramString)
  {
    this.label = paramString;
  }
  
  public void setScene(String paramString)
  {
    this.scene = paramString;
  }
  
  public void setSlots(Slots paramSlots)
  {
    this.slots = paramSlots;
  }
  
  public void setUrl(String paramString)
  {
    this.url = paramString;
  }
  
  public void setX(int paramInt)
  {
    this.x = paramInt;
  }
  
  public void setY(int paramInt)
  {
    this.y = paramInt;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/che/codriver/protocol/data/nlp/CustomItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */