package com.baidu.che.codriver.vr;

import com.baidu.che.codriver.util.INoProguard;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class ImageSearchData
  implements INoProguard
{
  @SerializedName("images")
  public List<ImageDetail> list;
  
  public static class ImageDetail
    implements INoProguard
  {
    @SerializedName("src")
    public String bigImage;
    @SerializedName("thumb")
    public String smailImage;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/che/codriver/vr/ImageSearchData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */