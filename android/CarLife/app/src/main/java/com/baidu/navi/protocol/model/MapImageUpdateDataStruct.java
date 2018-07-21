package com.baidu.navi.protocol.model;

public class MapImageUpdateDataStruct
  extends DataStruct
{
  public static final String KEY_IMAGE_HEIGHT = "height";
  public static final String KEY_IMAGE_PATH = "image";
  public static final String KEY_IMAGE_TYPE = "imagetype";
  public static final String KEY_IMAGE_WIDTH = "width";
  public static final String TYPE_BMP = "bmp";
  public static final String TYPE_JPG = "jpg";
  public static final String TYPE_PNG = "png";
  public int imageHeight = 480;
  public String imagePath;
  public String imageType;
  public int imageWidth = 400;
  
  public MapImageUpdateDataStruct()
  {
    this.mCmd = "notifyMapImageUpdate";
  }
  
  public String toString()
  {
    return "cmd=" + this.mCmd + " imagePath=" + this.imagePath + " imageType=" + this.imageType + " width=" + this.imageWidth + " height" + this.imageHeight;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/protocol/model/MapImageUpdateDataStruct.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */