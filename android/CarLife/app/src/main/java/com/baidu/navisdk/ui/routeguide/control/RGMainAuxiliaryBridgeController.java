package com.baidu.navisdk.ui.routeguide.control;

import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.comapi.tts.TTSPlayerControl;
import com.baidu.navisdk.ui.util.BNStyleManager;

public class RGMainAuxiliaryBridgeController
{
  private static final String TAG = RGMainAuxiliaryBridgeController.class.getSimpleName();
  private static final String TEXT_TYPE_SWITCH_TO_GROUND = "已为您切换至高架下";
  private static final String TEXT_TYPE_SWITCH_TO_MAIN_ROUTE = "已为您切换至主路";
  private static final String TEXT_TYPE_SWITCH_TO_SLAVE_ROUTE = "已为您切换至辅路";
  private static final String TEXT_TYPE_SWITCH_TO_VIADUCT = "已为您切换至高架上";
  public static final int TTS_TYPE_SWITCH_TO_GROUND = 4;
  public static final int TTS_TYPE_SWITCH_TO_MAIN_ROUTE = 1;
  public static final int TTS_TYPE_SWITCH_TO_SLAVE_ROUTE = 2;
  public static final int TTS_TYPE_SWITCH_TO_VIADUCT = 3;
  private static Object mSyncObj = new Object();
  private static RGMainAuxiliaryBridgeController sInstance = null;
  
  public static RGMainAuxiliaryBridgeController getInstance()
  {
    if (sInstance == null) {}
    synchronized (mSyncObj)
    {
      if (sInstance == null) {
        sInstance = new RGMainAuxiliaryBridgeController();
      }
      return sInstance;
    }
  }
  
  public void onRoutePlanFail()
  {
    RGNotificationController.getInstance().showCommonResultMsg(BNStyleManager.getString(1711670264), false);
  }
  
  public void playMainAuxiliaryBridgeText(int paramInt)
  {
    if (2 != BNSettingManager.getVoiceMode())
    {
      if (paramInt != 1) {
        break label20;
      }
      TTSPlayerControl.playTTS("已为您切换至主路", 1);
    }
    label20:
    do
    {
      return;
      if (paramInt == 2)
      {
        TTSPlayerControl.playTTS("已为您切换至辅路", 1);
        return;
      }
      if (paramInt == 3)
      {
        TTSPlayerControl.playTTS("已为您切换至高架上", 1);
        return;
      }
    } while (paramInt != 4);
    TTSPlayerControl.playTTS("已为您切换至高架下", 1);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/routeguide/control/RGMainAuxiliaryBridgeController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */