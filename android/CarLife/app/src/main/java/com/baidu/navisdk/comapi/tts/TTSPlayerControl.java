package com.baidu.navisdk.comapi.tts;

import com.baidu.navisdk.debug.SDKDebugFileUtil;
import com.baidu.navisdk.jni.nativeif.JNIStatisticsControl;
import com.baidu.navisdk.module.business.BusinessActivityPlayerManager;
import com.baidu.navisdk.ui.routeguide.model.RGSimpleGuideModel;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.SoundUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class TTSPlayerControl
{
  public static final int PER_TTS_DEFAULT_SPEED = 5;
  private static final String TTS_RES_FAIL = "Fail";
  private static final String TTS_RES_SUCCESS = "Success";
  private static boolean bStopVoiceOutput;
  private static SoundUtils mFastRouteSound;
  private static boolean mIsFellowSpeaking = false;
  private static boolean mIsTTSPlaying = false;
  private static ArrayList<OnTTSPlayStateListener> mOnTTSStateListenerList = new ArrayList();
  private static IBNTTSPlayerListener mTtsPlayerListener;
  private static LinkedList<String> stasStrTagList;
  
  static
  {
    bStopVoiceOutput = false;
    mFastRouteSound = null;
    stasStrTagList = null;
  }
  
  public static void addTTSPlayStateListener(OnTTSPlayStateListener paramOnTTSPlayStateListener)
  {
    if (mOnTTSStateListenerList != null) {
      mOnTTSStateListenerList.add(paramOnTTSPlayStateListener);
    }
  }
  
  public static int cancelAudio()
  {
    if ((getTTSState() == 2) && (mTtsPlayerListener != null)) {
      return mTtsPlayerListener.cancelAudio();
    }
    return -1;
  }
  
  public static void clearTagList()
  {
    if (stasStrTagList != null) {
      stasStrTagList.clear();
    }
  }
  
  private static int commonPlayTTS(String paramString1, String paramString2, int paramInt)
  {
    if (LogUtil.LOGGABLE) {
      LogUtil.e("TTS", "TTSPlayerControl.playTTSText(). speech=" + paramString1 + ", bPreempt=" + paramInt + ", bStopVoiceOutput=" + bStopVoiceOutput + ", mTtsPlayerListener=" + mTtsPlayerListener + ",pStrTag" + paramString2);
    }
    LogUtil.e("TTS", "TTSPlayerControl.playTTSText(). speech=" + paramString1 + ", bPreempt=" + paramInt + ", bStopVoiceOutput=" + bStopVoiceOutput + ", mTtsPlayerListener=" + mTtsPlayerListener + ",pStrTag" + paramString2);
    if ((paramString2 != null) && (paramString2.equals(""))) {
      LogUtil.e("playTTSText", "pStrTag is null");
    }
    if ((paramString2 != null) && (!paramString2.equals("")))
    {
      if (stasStrTagList == null) {
        stasStrTagList = new LinkedList();
      }
      stasStrTagList.add(paramString2);
    }
    BusinessActivityPlayerManager.getInstance().cancelPlayAudio();
    RGSimpleGuideModel.getInstance().updateTTSText(paramString1);
    if ((!bStopVoiceOutput) && (mTtsPlayerListener != null)) {
      return mTtsPlayerListener.playTTSText(paramString1, paramString2, paramInt);
    }
    LogUtil.e("playTTSText", "bStopVoiceOutput = " + bStopVoiceOutput + ",mTtsPlayerListener = " + mTtsPlayerListener);
    SDKDebugFileUtil.getInstance().addCoreLog("CoreLog_TTS: ", "TTSPlayerControl end. speech=" + paramString1 + ", bPreempt=" + paramInt + ", bStopVoiceOutput=" + bStopVoiceOutput + ", mTtsPlayerListener=" + mTtsPlayerListener + ",pStrTag" + paramString2);
    return 0;
  }
  
  public static boolean getFellowSpeakStatus()
  {
    return mIsFellowSpeaking;
  }
  
  public static boolean getMapTTSPlayStatus()
  {
    return getTTSState() == 2;
  }
  
  public static ArrayList<OnTTSPlayStateListener> getTTSPlayStateListener()
  {
    return mOnTTSStateListenerList;
  }
  
  public static boolean getTTSPlayStatus()
  {
    return mIsTTSPlaying;
  }
  
  public static int getTTSState()
  {
    if (mTtsPlayerListener != null)
    {
      int i = mTtsPlayerListener.getTTSState();
      LogUtil.e("TTS", "getTTSState =  " + i);
      return i;
    }
    return 1;
  }
  
  public static void init()
  {
    if (mTtsPlayerListener != null) {
      mTtsPlayerListener.initTTSPlayer();
    }
    initFastRouteVoice();
  }
  
  private static void initFastRouteVoice()
  {
    mFastRouteSound = new SoundUtils(1711603712);
  }
  
  public static boolean isNaviMuteState()
  {
    if (mTtsPlayerListener != null) {
      return mTtsPlayerListener.isNaviMuteState();
    }
    return false;
  }
  
  public static void pauseVoiceTTSOutput()
  {
    bStopVoiceOutput = true;
    if (mTtsPlayerListener != null) {
      mTtsPlayerListener.pauseTTS();
    }
  }
  
  public static int playAudio(String paramString, IBNTTSPlayerListener.AudioPlayerListener paramAudioPlayerListener)
  {
    if (mTtsPlayerListener != null) {
      return mTtsPlayerListener.playAudio(paramString, paramAudioPlayerListener);
    }
    return -1;
  }
  
  public static void playFastRouteVoice()
  {
    LogUtil.e("TTS", "TTSPlayerControl.playTTSText() play .");
    if (mFastRouteSound != null) {
      mFastRouteSound.play();
    }
  }
  
  public static int playTTS(String paramString, int paramInt)
  {
    LogUtil.e("TTS", "playTTSText from SDK. speech=" + paramString + ", bPreempt=" + paramInt + ", bStopVoiceOutput=" + bStopVoiceOutput + ", mTtsPlayerListener=" + mTtsPlayerListener);
    return commonPlayTTS(paramString, null, paramInt);
  }
  
  public static int playTTSText(String paramString, int paramInt)
  {
    LogUtil.e("TTS", "playTTSText from JNI. speech=" + paramString + ", bPreempt=" + paramInt + ", bStopVoiceOutput=" + bStopVoiceOutput + ", mTtsPlayerListener=" + mTtsPlayerListener);
    return commonPlayTTS(paramString, null, paramInt);
  }
  
  public static int playTTSText(String paramString1, String paramString2, int paramInt)
  {
    LogUtil.e("TTS", "playTTSText from JNI. speech=" + paramString1 + ", bPreempt=" + paramInt + ", bStopVoiceOutput=" + bStopVoiceOutput + ", mTtsPlayerListener=" + mTtsPlayerListener);
    return commonPlayTTS(paramString1, paramString2, paramInt);
  }
  
  public static int playXDTTSText(String paramString, int paramInt)
  {
    if (LogUtil.LOGGABLE) {
      LogUtil.e("TTS", "TTSPlayerControl.playXDTTSText() from jni. speech=" + paramString + ", bPreempt=" + paramInt + ", bStopVoiceOutput=" + bStopVoiceOutput + ", mTtsPlayerListener=" + mTtsPlayerListener + ",pStrTagnull");
    }
    BusinessActivityPlayerManager.getInstance().cancelPlayAudio();
    RGSimpleGuideModel.getInstance().updateTTSText(paramString);
    if ((!bStopVoiceOutput) && (mTtsPlayerListener != null)) {
      return mTtsPlayerListener.playXDTTSText(paramString, null, paramInt);
    }
    LogUtil.e("playXDTTSText", "bStopVoiceOutput = " + bStopVoiceOutput + ",mTtsPlayerListener = " + mTtsPlayerListener);
    SDKDebugFileUtil.getInstance().addCoreLog("CoreLog_TTS: ", "TTSPlayerControl end. speech=" + paramString + ", bPreempt=" + paramInt + ", bStopVoiceOutput=" + bStopVoiceOutput + ", mTtsPlayerListener=" + mTtsPlayerListener + ",pStrTagnull");
    return 0;
  }
  
  public static void removeTTSPlayStateListener(OnTTSPlayStateListener paramOnTTSPlayStateListener)
  {
    if ((mOnTTSStateListenerList != null) && (paramOnTTSPlayStateListener != null)) {
      mOnTTSStateListenerList.remove(paramOnTTSPlayStateListener);
    }
  }
  
  public static void resumeVoiceTTSOutput()
  {
    bStopVoiceOutput = false;
    if (mTtsPlayerListener != null) {
      mTtsPlayerListener.resumeTTS();
    }
  }
  
  public static void setFellowSpeakStatus(boolean paramBoolean)
  {
    mIsFellowSpeaking = paramBoolean;
  }
  
  public static void setNaviMuteState(boolean paramBoolean)
  {
    if (mTtsPlayerListener != null) {
      mTtsPlayerListener.setNaviMuteState(paramBoolean);
    }
  }
  
  public static void setPhoneIn(boolean paramBoolean)
  {
    if (mTtsPlayerListener != null)
    {
      if (paramBoolean) {
        mTtsPlayerListener.phoneCalling();
      }
    }
    else {
      return;
    }
    mTtsPlayerListener.phoneHangUp();
  }
  
  public static void setTTSPlayerListener(IBNTTSPlayerListener paramIBNTTSPlayerListener)
  {
    mTtsPlayerListener = paramIBNTTSPlayerListener;
  }
  
  public static void setTTSTextPlayResult(String paramString)
  {
    Object localObject;
    if (LogUtil.LOGGABLE)
    {
      LogUtil.e("setTTSTextPlayResult:", "pStrTag" + paramString);
      if (stasStrTagList != null)
      {
        localObject = stasStrTagList.iterator();
        while (((Iterator)localObject).hasNext()) {
          LogUtil.e("stasStrTagList:", (String)((Iterator)localObject).next());
        }
      }
    }
    if ((stasStrTagList == null) || (paramString == null) || (paramString.equals(""))) {}
    int j;
    do
    {
      return;
      j = stasStrTagList.indexOf(paramString);
    } while ((j < 0) || (j >= stasStrTagList.size()));
    int i = 0;
    while (i < j)
    {
      localObject = (String)stasStrTagList.remove();
      if (localObject != null)
      {
        LogUtil.e("setTTSTextPlayResult result:", (String)localObject + ":" + "Fail");
        JNIStatisticsControl.sInstance.setTTSTextPlayResult((String)localObject, "Fail");
      }
      i += 1;
    }
    stasStrTagList.remove();
    LogUtil.e("setTTSTextPlayResult result:", paramString + ":" + "Success");
    JNIStatisticsControl.sInstance.setTTSTextPlayResult(paramString, "Success");
  }
  
  public static void stopSound()
  {
    if (mFastRouteSound != null) {
      mFastRouteSound.stop();
    }
  }
  
  public static void stopVoiceTTSOutput()
  {
    LogUtil.e("TTSPlayerControl", "stopVoiceTTSOutput()");
    if ((getTTSState() == 2) && (mTtsPlayerListener != null)) {
      mTtsPlayerListener.stopTTS();
    }
  }
  
  public static void unInit()
  {
    if (mFastRouteSound != null) {
      mFastRouteSound.release();
    }
    if (mTtsPlayerListener != null) {
      mTtsPlayerListener.releaseTTSPlayer();
    }
  }
  
  public static abstract interface OnTTSPlayStateListener
  {
    public abstract void onPlayEnd();
    
    public abstract void onPlayStart();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/comapi/tts/TTSPlayerControl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */