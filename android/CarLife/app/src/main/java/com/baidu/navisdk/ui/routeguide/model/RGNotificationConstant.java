package com.baidu.navisdk.ui.routeguide.model;

public class RGNotificationConstant
{
  public static final int COMMON_PRIORITY_HIGH_AUTO_HIDE_TIME = 10000;
  public static final int COMMON_PRIORITY_HIGH_ID = 300;
  public static final int COMMON_PRIORITY_LOW_AUTO_HIDE_TIME = 3000;
  public static final int COMMON_PRIORITY_LOW_ID = 100;
  public static final int COMMON_PRIORITY_MIDDLE_AUTO_HIDE_TIME = 5000;
  public static final int COMMON_PRIORITY_MIDDLE_ID = 200;
  public static final int LOCAL_ROUTE_INFO_TYPE_AVOID = 1;
  public static final int LOCAL_ROUTE_INFO_TYPE_GUIDE = 0;
  public static final int LOCAL_ROUTE_INFO_TYPE_INVALID = -1;
  public static final int MSG_TYPE_COUNT_DOWN_NOTIFICATION = 1001;
  public static final int MSG_TYPE_HIDE_NOTIFICATION = 1000;
  public static final int OPERABLE_PRIORITY_HIGH_AUTO_HIDE_TIME = 20000;
  public static final int OPERABLE_PRIORITY_HIGH_ID = 300;
  public static final int OPERABLE_PRIORITY_LOW_AUTO_HIDE_TIME = 10000;
  public static final int OPERABLE_PRIORITY_LOW_ID = 100;
  public static final int OPERABLE_PRIORITY_MIDDLE_AUTO_HIDE_TIME = 15000;
  public static final int OPERABLE_PRIORITY_MIDDLE_ID = 200;
  
  public class CommonNotification
  {
    public static final int TYPE_CANCEL_ROUTE_RECOMMEND = 100;
    public static final int TYPE_COMMON_RESULT = 112;
    public static final int TYPE_FIRST_VOICE_GUIDE = 113;
    public static final int TYPE_FLOAT_WINDOW_SUCCESS = 101;
    public static final int TYPE_GPS_WEAK = 102;
    public static final int TYPE_LOCAL_ROUTE = 103;
    public static final int TYPE_QUIET_MODE_CLOSE = 105;
    public static final int TYPE_QUIET_MODE_OPEN = 104;
    public static final int TYPE_ROUTE_PLAN_PREFER = 106;
    public static final int TYPE_SWITCH_ROUTE_FAIL = 107;
    public static final int TYPE_SWITCH_ROUTE_SUCCESS = 108;
    public static final int TYPE_UGC_OFFICIAL_EVENT = 109;
    public static final int TYPE_UGC_REPORT_SUCCESS = 110;
    public static final int TYPE_UPDATE_ROUTE_CONDITION_FAIL = 111;
    
    public CommonNotification() {}
  }
  
  public class OperableNotification
  {
    public static final int TYPE_BLUETOOTH = 100;
    public static final int TYPE_GLOBAL_VOICE = 105;
    public static final int TYPE_JAM_REPORT = 108;
    public static final int TYPE_PARK = 102;
    public static final int TYPE_PICK_POINT = 106;
    public static final int TYPE_ROUTE_INFO = 107;
    public static final int TYPE_ROUTE_RECOMMEND = 103;
    public static final int TYPE_VOICE_RECOMMEND = 104;
    public static final int TYPE_WAIT_ROUTE_PLAN_RESULT = 101;
    
    public OperableNotification() {}
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/routeguide/model/RGNotificationConstant.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */