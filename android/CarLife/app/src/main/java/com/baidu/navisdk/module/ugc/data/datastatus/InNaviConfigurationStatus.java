package com.baidu.navisdk.module.ugc.data.datastatus;

import android.graphics.Bitmap;

public class InNaviConfigurationStatus
{
  private String contentDescri = null;
  private int detailInfoIndex = -1;
  private boolean hasRecorde = false;
  private Bitmap photoBitmap = null;
  private int positionInfoIndex = -1;
  private int positionLineIndex = -1;
  
  public String getContentDescri()
  {
    return this.contentDescri;
  }
  
  public int getDetailInfoIndex()
  {
    return this.detailInfoIndex;
  }
  
  public Bitmap getPhotoBitmap()
  {
    return this.photoBitmap;
  }
  
  public int getPositionInfoIndex()
  {
    return this.positionInfoIndex;
  }
  
  public int getPositionLineIndex()
  {
    return this.positionLineIndex;
  }
  
  public boolean isHasRecorde()
  {
    return this.hasRecorde;
  }
  
  public void setContentDescri(String paramString)
  {
    this.contentDescri = paramString;
  }
  
  public void setDetailInfoIndex(int paramInt)
  {
    this.detailInfoIndex = paramInt;
  }
  
  public void setHasRecorde(boolean paramBoolean)
  {
    this.hasRecorde = paramBoolean;
  }
  
  public void setPhotoBitmap(Bitmap paramBitmap)
  {
    this.photoBitmap = paramBitmap;
  }
  
  public void setPositionInfoIndex(int paramInt)
  {
    this.positionInfoIndex = paramInt;
  }
  
  public void setPositionLineIndex(int paramInt)
  {
    this.positionLineIndex = paramInt;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/module/ugc/data/datastatus/InNaviConfigurationStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */