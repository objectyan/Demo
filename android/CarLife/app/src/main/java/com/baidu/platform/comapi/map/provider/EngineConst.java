package com.baidu.platform.comapi.map.provider;

public class EngineConst
{
  public static abstract interface BUS_STEP_TYPE
  {
    public static final int AIR = 2;
    public static final int BIKE = 7;
    public static final int BUS = 3;
    public static final int COACH = 6;
    public static final int DRIVE = 4;
    public static final int FOOT = 5;
    public static final int TRAIN = 1;
  }
  
  public static abstract interface BUS_VEHICLE_TYPE
  {
    public static final int BUS = 0;
    public static final int FERRY = 8;
    public static final int SUBWAY = 1;
  }
  
  public static abstract interface ENGINE_NODE_TYPE
  {
    public static final int BUSLINE_STOP = 23;
    public static final int END = 2;
    public static final int NONE = 1239;
    public static final int POI = 3;
    public static final int POI_ADDRESS = 13;
    public static final int ROUTE = 8;
    public static final int START = 1;
  }
  
  public static abstract interface ENGINE_ONLINE_NODE_TYPE
  {
    public static final int AREA = 3;
    public static final int LINE = 2;
    public static final int POINT = 1;
    public static final int TEXT = 4;
  }
  
  public static abstract interface ICON_ALIGN_TYPE
  {
    public static final int BOTTOM = 2;
    public static final int CENTER = 0;
    public static final int CUSTOMER = 3;
    public static final int TOP = 1;
  }
  
  public static abstract interface OVERLAY_KEY
  {
    public static final String ALIGN = "align";
    public static final String AREA_STYLE = "style";
    public static final String ARRAY = "dataset";
    public static final String CLICKABLE = "cli";
    public static final String COLLECT_DATA = "collect_data";
    public static final String DASH_STYLE = "dash";
    public static final String DIRECTION = "dir";
    public static final String DIS = "dis";
    public static final String DYNAMIC_SCENE = "scene";
    public static final String DYNAMIC_SHOW_AD = "show_ad";
    public static final String FBRGB = "fbrgb";
    public static final String FHALO = "fhalo";
    public static final String FOCUS_STYLE = "fst";
    public static final String FRGB = "frgb";
    public static final String FSRGB = "fsrgb";
    public static final String FST = "fst";
    public static final String FSTY = "fsty";
    public static final String FSZ = "fsz";
    public static final String GEO = "geo";
    public static final String IMG_EXT = "imge_ext";
    public static final String IMG_EXT_LEN = "len";
    public static final String INDEX = "in";
    public static final String INDOOR = "indoor";
    public static final String LEVEL = "level";
    public static final String MAXL = "maxl";
    public static final String MAX_LEVEL = "maxlevel";
    public static final String MINL = "minl";
    public static final String MIN_LEVEL = "minlevel";
    public static final String NBRGB = "nbrgb";
    public static final String NHALO = "nhalo";
    public static final String NORMAL_STYLE = "nst";
    public static final String NRGB = "nrgb";
    public static final String NSRGB = "nsrgb";
    public static final String NST = "nst";
    public static final String NSTY = "nsty";
    public static final String NSZ = "nsz";
    public static final String OFFSET = "of";
    public static final String PATH = "path";
    public static final String QID = "qid";
    public static final String RANK = "rank";
    public static final String SGEO = "sgeo";
    public static final String SGEO_BOUND = "bound";
    public static final String SGEO_DIFF_LEVEL = "difflevel";
    public static final String SGEO_ELEMENTS = "elements";
    public static final String SGEO_ELEMENTS_POINTS = "points";
    public static final String SGEO_LEVEL_COLOR = "scolor";
    public static final String SGEO_LEVEL_COLOR_LINE = "color";
    public static final String SGEO_MAX_LEVEL = "maxl";
    public static final String SGEO_MIN_LEVEL = "minl";
    public static final String SGEO_TYPE = "type";
    public static final String SHOW_COLLECT = "show_collect";
    public static final String TEXT = "tx";
    public static final String TYPE = "ty";
    public static final String UID = "ud";
    public static final String WIDTH = "width";
    public static final String X = "x";
    public static final String Y = "y";
  }
  
  public static abstract interface POI_TYPE
  {
    public static final int POI_TYPE_ADDR = 5;
    public static final int POI_TYPE_BUS_LINE = 2;
    public static final int POI_TYPE_BUS_STATION = 1;
    public static final int POI_TYPE_COMMON = 0;
    public static final int POI_TYPE_FAVS = 11;
    public static final int POI_TYPE_RGC = 10;
    public static final int POI_TYPE_RGC_ADDR = 9;
    public static final int POI_TYPE_SUBWAY_LINE = 4;
    public static final int POI_TYPE_SUBWAY_STATION = 3;
  }
  
  public static abstract interface SEARCH_RESULT_TYPE
  {
    public static final int AREA_SEARCH_LIST = 21;
    public static final int CIRCUM_SEARCH_LIST = 12;
    public static final int POI_LIST = 11;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/platform/comapi/map/provider/EngineConst.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */