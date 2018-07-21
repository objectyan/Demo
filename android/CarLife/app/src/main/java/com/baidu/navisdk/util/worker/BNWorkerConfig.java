package com.baidu.navisdk.util.worker;

public class BNWorkerConfig
{
  public int tag;
  public int type;
  
  public BNWorkerConfig(int paramInt1, int paramInt2)
  {
    this.type = paramInt1;
    this.tag = paramInt2;
  }
  
  public static abstract interface TAG
  {
    public static final int NORMAL = 0;
    public static final int SETUP = 1;
  }
  
  public static abstract interface TYPE
  {
    public static final int DATA_DOWNLOAD = 101;
    public static final int DATA_STATISTICS = 102;
    public static final int DATA_UPDATE_DATA = 100;
    public static final int UI_DATA_DOWNLOAD = 7;
    public static final int UI_EDOG = 8;
    public static final int UI_LIGHT_NAVI = 9;
    public static final int UI_NAVI = 2;
    public static final int UI_NAVI_RESULT = 3;
    public static final int UI_NORMAL = 100;
    public static final int UI_ROUTE = 1;
    public static final int UI_SELECT_POINT_MAP_PAGE = 11;
    public static final int UI_UGC = 10;
    public static final int UI_VOICE_DETAILS = 6;
    public static final int UI_VOICE_MAIN = 5;
    public static final int UI_VOICE_SQUARE = 4;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/util/worker/BNWorkerConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */