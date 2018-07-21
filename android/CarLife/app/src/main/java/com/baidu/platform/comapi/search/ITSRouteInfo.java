package com.baidu.platform.comapi.search;

import java.util.ArrayList;

public class ITSRouteInfo
{
  public String digest;
  public boolean isHaveITS;
  public ArrayList<ITStep> steps;
  
  public static class ITStep
  {
    public int[] end;
    public int[] status;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/platform/comapi/search/ITSRouteInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */