package com.baidu.navi.protocol.model;

public class SetImageSizeDataStruct
  extends DataStruct
{
  public static final String KEY_IMAGE_HEIGHT = "height";
  public static final String KEY_IMAGE_WIDTH = "width";
  public int imageHeight = 480;
  public int imageWidth = 400;
  
  public SetImageSizeDataStruct()
  {
    this.mCmd = "setImageSize";
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/protocol/model/SetImageSizeDataStruct.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */