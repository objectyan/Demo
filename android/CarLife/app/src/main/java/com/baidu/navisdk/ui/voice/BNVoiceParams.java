package com.baidu.navisdk.ui.voice;

import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.util.http.HttpURLManager;

public class BNVoiceParams
{
  public static final String BUNDLE_VOICEINFO = "VOICEINFO";
  public static final String BUNDLE_VOICEINFO_ORG_POSITION = "ORG_POSITION";
  public static final String BUNDLE_VOICEINFO_ORG_STATUS = "ORG_STATUS";
  public static final String BUNDLE_VOICEINFO_ORG_WORD = "ORG_WORD";
  public static final String BUNDLE_VOICEINFO_TASKID = "TASK_ID";
  public static final String EXTEND_ID = "1-0";
  public static final String FULL_DOSE_TASK_ID = "2-";
  public static final String GLOBAL = "2-201526";
  public static final String JIN_SHA = "2-129798";
  public static final String MAIDOU_PATH_SUFFIX = "/baiduvoicedata/bd_tts_male.dat";
  public static final int MAX_LOCAL_RECORD = 10;
  public static final String MODULE_TAG = "BNVoice";
  public static final int Msg_Upload_Failed = 5;
  public static final int Msg_Upload_Finish = 2;
  public static final int Msg_Upload_Net_Error = 4;
  public static final int Msg_Upload_Progress = 1;
  public static final int Msg_Upload_Start = 0;
  public static final String ROBIN = "2-159740";
  public static final String ROBIN_LOCAL = "1-00001";
  public static final String TTS_SCENIC_ID = "20-";
  public static final String TTS_TEXT_ID = "3-";
  public static final String URL_OS = "0";
  public static final String URL_SID = "1";
  public static final String VOICE_DEFUALT_IMAGE_URL;
  public static final String VOICE_DETAIL_URL;
  public static final String VOICE_DETAIL_URL_MATCHER = "/static/webpage/voice_market_details";
  public static final String VOICE_NORMAL = "普通话";
  public static final String[] VOICE_RECORD_ORGWORD;
  public static final String[] VOICE_RECORD_ORGWORD_DETAIL_FORMAP;
  public static final String[] VOICE_RECORD_ORGWORD_DETAIL_FORNAVI;
  public static final String[] VOICE_RECORD_SHOWWORD;
  public static final String VOICE_SILENCE_DOWNLOAD_URL;
  public static final String VOICE_SQUARE_DEFAULT_IMAGE_URL;
  public static final String VOICE_SQUARE_URL_NAVING;
  public static final String VOICE_TOPIC_URL = "http://webpage.navi.baidu.com/static/webpage/voice_market_topic/clasic/";
  public static final String VOICE_TOPIC_URL_MATCHER = "/static/webpage/voice_market_topic/clasic/";
  public static final String sMaiDouTaskId = "9999";
  
  static
  {
    if (BNSettingManager.isUseHttpsOfflineURL())
    {
      str = "http://cp01-rdqa04-dev108.cp01.baidu.com:8111/static/webpage/voice_market_navingvoice/navingvoice/";
      VOICE_SQUARE_URL_NAVING = str;
      if (!BNSettingManager.isUseHttpsOfflineURL()) {
        break label336;
      }
    }
    label336:
    for (String str = "http://cp01-rdqa04-dev108.cp01.baidu.com:8111/static/webpage/voice_market_details_v2/";; str = HttpURLManager.getInstance().getScheme() + "webpagenavi.baidu.com/static/webpage/voice_market_details_v2/")
    {
      VOICE_DETAIL_URL = str;
      VOICE_SILENCE_DOWNLOAD_URL = HttpURLManager.getInstance().getScheme() + "client.map.baidu.com/opn/pvn/getcfg";
      VOICE_SQUARE_DEFAULT_IMAGE_URL = HttpURLManager.getInstance().getScheme() + "map.baidu.com/zt/y2014/dhyylist/mobile/others/shareicon.jpg";
      VOICE_DEFUALT_IMAGE_URL = HttpURLManager.getInstance().getScheme() + "imgsa.baidu.com/lbsopn/pic/item/48540923dd54564ed3cc8e93b0de9c82d0584fea.jpg";
      VOICE_RECORD_ORGWORD = new String[] { "导航开始", "闯红灯拍照", "限速拍照", "您已超速", "请减速慢行", "违章拍照", "请小心驾驶", "导航结束" };
      VOICE_RECORD_SHOWWORD = new String[] { "导航欢迎语", "有闯红灯拍照", "有限速拍照", "您已超速", "请减速慢行", "有违章拍照", "请小心驾驶", "导航结束语" };
      VOICE_RECORD_ORGWORD_DETAIL_FORMAP = new String[] { "亲爱的，导航已准备就绪，系好安全带，准备出发喽~", "注意闯红灯拍照，更要注意安全！", "有限速拍照，不要开太快啦！", "你已经超速啦，一定要慢点开", "你开的太快了，要减速啦", "违章拍照盯着你呢，不要被拍", "开车安全最重要，要小心驾驶", "你已经安全到达目的地啦，记得出门就查百度地图哦~新年快乐！" };
      VOICE_RECORD_ORGWORD_DETAIL_FORNAVI = new String[] { "亲爱的，导航已准备就绪，系好安全带，准备出发喽~", "注意闯红灯拍照，更要注意安全！", "有限速拍照，不要开太快啦！", "你已经超速啦，一定要慢点开", "你开的太快了，要减速啦", "违章拍照盯着你呢，不要被拍", "开车安全最重要，要小心驾驶", "你已经安全到达目的地啦，记得出门就查百度导航哦~新年快乐！" };
      return;
      str = HttpURLManager.getInstance().getScheme() + "webpagenavi.baidu.com/static/webpage/voice_market_navingvoice/navingvoice/";
      break;
    }
  }
  
  public static class StatisticsVoiceID
  {
    public static final String EIGHT_STRING = "0-";
    public static final String FULL_DOSE_STRING = "2-";
    public static final String HUNDRED_STRING = "1-";
    public static final String MAIDOU_STRING = "9999";
    public static final String PUTONGHUA_STRING = "2-0";
  }
  
  public static class VoiceDownArgType
  {
    public static final int VOICE_DOWN_ERROR_MD5 = 18;
    public static final int VOICE_DOWN_ERROR_SCDARD = 259;
    public static final int VOICE_DOWN_ERROR_UNKNOWN = 256;
    public static final int VOICE_DOWN_PAUSE_NETWORK = 261;
    public static final int VOICE_DOWN_PAUSE_NET_CHANGE_TO_3G = 262;
    public static final int VOICE_DOWN_PAUSE_USER = 260;
  }
  
  public static class VoiceDownStatusEvent
  {
    public static final int VOICE_DOWN_EVENT_DOWNING = 1;
    public static final int VOICE_DOWN_EVENT_ERROR = 3;
    public static final int VOICE_DOWN_EVENT_FINISH = 4;
    public static final int VOICE_DOWN_EVENT_IDLE = 0;
    public static final int VOICE_DOWN_EVENT_PAUSE = 2;
    public static final int VOICE_DOWN_EVENT_START = 5;
    public static final int VOICE_DOWN_EVENT_SWITCH_FAIL = 7;
    public static final int VOICE_DOWN_EVENT_SWITCH_SUCCESS = 6;
    public static final int VOICE_DOWN_EVENT_WAITING = 8;
  }
  
  public static abstract interface VoiceEntry
  {
    public static final String MAIN_BACK = "main_back";
    public static final String MY = "mine";
    public static final String NAVI = "navi";
    public static final String NAVING = "naving";
    public static final String OPENAPI = "openapi";
  }
  
  public static class VoiceNotifyType
  {
    public static final int VOICE_DATA_TYPE_BUILD_TTS = 5;
    public static final int VOICE_DATA_TYPE_DOWN = 1;
    public static final int VOICE_DATA_TYPE_NEWTASKINFO = 6;
    public static final int VOICE_DATA_TYPE_RECOMMEND = 3;
    public static final int VOICE_DATA_TYPE_RECORD = 2;
    public static final int VOICE_DATA_TYPE_UPLOAD = 4;
    public static final int VOICE_SQUARE_TOUCH = 7;
  }
  
  public static class VoiceRecordEvent
  {
    public static final int VOICE_RECORD_EVENT_TIMEOUT = 32;
    public static final int VOICE_RECORD_EVENT_TIMER = 33;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/voice/BNVoiceParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */