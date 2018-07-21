package com.baidu.baidunavis.tts;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.baidunavis.NavMapAdapter;
import com.baidu.baidunavis.control.NavLogUtils;
import com.baidu.baidunavis.model.NavCommonFuncModel;
import com.baidu.baidunavis.ui.widget.NavTipTool;
import com.baidu.carlife.util.u;
import com.baidu.mapframework.common.util.StorageInformation;
import com.baidu.mapframework.common.util.StorageSettings;
import com.baidu.mapframework.tts.OnTTSStateChangedListener;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.comapi.tts.IBNTTSPlayerListener.AudioPlayerListener;
import com.baidu.navisdk.comapi.tts.TTSPlayerControl;
import com.baidu.navisdk.debug.SDKDebugFileUtil;
import com.baidu.navisdk.util.worker.BNWorkerCenter;
import com.baidu.navisdk.util.worker.BNWorkerConfig;
import com.baidu.navisdk.util.worker.BNWorkerNormalTask;
import com.baidu.navisdk.util.worker.IBNWorkerCenter;
import com.baidu.navisdk.util.worker.loop.BNMainLooperHandler;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.client.SpeechError;
import com.baidu.tts.client.SpeechSynthesizer;
import com.baidu.tts.client.SpeechSynthesizerListener;
import com.baidu.tts.client.SynthesizerTool;
import com.baidu.tts.client.TtsMode;
import java.io.File;

public class BdTTSPlayer
{
  private static final int DEFAULT_SPEED_5 = 5;
  private static final int DEFAULT_SPEED_6 = 6;
  private static final int DEFAULT_SPEED_7 = 7;
  public static final int INIT_STATE_INITING = 1;
  public static final int INIT_STATE_NO = 0;
  public static final int INIT_STATE_OK = 2;
  public static final String K_TTS_DATA_FILE = "bd_etts_common_speech_f7_mand_eng_high_am-mix_v3.0.0_20170512.dat";
  public static final String K_TTS_DATA_TAIWAN_FILE = "bd_etts_common_speech_taiwan_mand_eng_high_am-mgc_v3.0.0_20170807.dat";
  private static final String K_TTS_LICENCE_FILE = "baidu_tts_licence.dat";
  private static final String K_TTS_ROBIN_FILE = "1-00001.dat";
  private static final String K_TTS_TEXT_DATA_FILE = "bd_etts_common_text_txt_all_mand_eng_middle_mix_v3.1.0_20170525.dat";
  private static final int MAX_SPEED = 9;
  private static final int MIN_SPEED = 0;
  private static final int MSG_FREE_CUSTOM_TTS_VOICE = 6;
  private static final int MSG_INIT_FAILED = 4;
  private static final int MSG_INIT_FINISHED = 2;
  private static final int MSG_LOAD_CUSTOM_TTS_VOICE = 7;
  private static final int MSG_REQUEST_INIT = 1;
  private static final int MSG_REQUEST_SWITCH_VOICE_DATA = 3;
  private static final int MSG_RESET_TTS_FOR_TIMEOUT = 5;
  private static final String OLD_MAP_MENGMENGDA_PATH = "/BaiduCarlife/tts/";
  private static final String TAG = "BdTTSPlayer";
  private boolean isNeedSaveConfig = true;
  private boolean isTimeOutEnable = false;
  private Context mContext;
  private int mCurrentProgress = 0;
  private String mCurrentSelectPath = "bd_etts_common_speech_f7_mand_eng_high_am-mix_v3.0.0_20170512.dat";
  private String mCurrentTTSTextPath = null;
  private String mCurrentTTSVoiceDataPath = null;
  private int mCurrentVolume = 7;
  private SharedPreferences.Editor mEditor;
  private Handler mHandler = new BNMainLooperHandler()
  {
    public void onMessage(Message paramAnonymousMessage)
    {
      if (paramAnonymousMessage.what == 1) {}
      do
      {
        do
        {
          do
          {
            return;
          } while (paramAnonymousMessage.what == 2);
          if (paramAnonymousMessage.what == 3)
          {
            BNWorkerCenter.getInstance().submitNormalTask(new BNWorkerNormalTask("AudioUtils", null)new BNWorkerConfig
            {
              protected String execute()
              {
                BdTTSPlayer.this.switchTTSVoiceDataInner(BdTTSPlayer.this.mRequestSwitchPath, BdTTSPlayer.this.mRequestSwitchTextPath, BdTTSPlayer.this.isNeedSaveConfig);
                return null;
              }
            }, new BNWorkerConfig(100, 0));
            return;
          }
          if (paramAnonymousMessage.what != 4) {
            break;
          }
        } while (BdTTSPlayer.this.mContext == null);
        try
        {
          NavTipTool.onCreateToastDialog(BdTTSPlayer.this.mContext, 2131296310);
          return;
        }
        catch (Exception paramAnonymousMessage)
        {
          return;
        }
        if (5 == paramAnonymousMessage.what)
        {
          BdTTSPlayer.this.resetTTSForTimeout();
          return;
        }
        if (6 == paramAnonymousMessage.what)
        {
          BdTTSPlayer.loge("BdTTSPlayer", "MSG_FREE_CUSTOM_TTS_VOICE mInitState:" + BdTTSPlayer.this.mInitState);
          if (BdTTSPlayer.this.mInitState == 1)
          {
            Log.e("BdTTSPlayer", "freeCustomTTSVoice waiting");
            BdTTSPlayer.this.mHandler.sendEmptyMessageDelayed(6, 1000L);
            return;
          }
          BNWorkerCenter.getInstance().submitNormalTask(new BNWorkerNormalTask("TTS", null)new BNWorkerConfig
          {
            protected String execute()
            {
              BdTTSPlayer.this.freeCustomTTSVoiceDataInner();
              return null;
            }
          }, new BNWorkerConfig(100, 0));
          return;
        }
      } while (7 != paramAnonymousMessage.what);
      BdTTSPlayer.loge("BdTTSPlayer", "MSG_LOAD_CUSTOM_TTS_VOICE mInitState:" + BdTTSPlayer.this.mInitState);
      if (BdTTSPlayer.this.mInitState == 1)
      {
        Log.e("BdTTSPlayer", "loadCustomTTSVoice waiting");
        BdTTSPlayer.this.mHandler.sendEmptyMessageDelayed(7, 1000L);
        return;
      }
      BNWorkerCenter.getInstance().submitNormalTask(new BNWorkerNormalTask("TTS", null)new BNWorkerConfig
      {
        protected String execute()
        {
          BdTTSPlayer.this.loadCustomTTSVoiceDataInner();
          return null;
        }
      }, new BNWorkerConfig(100, 0));
    }
  };
  private IBNTTSPlayerPCMListener mIBNTTSPlayerPCMListener;
  private IBNTTSPlayerWeChatListener mIBNTTSPlayerWeChatListener;
  private IBNTTSVoiceHintListener mIBNTTSVoiceHintListener;
  private int mInitState = 0;
  private boolean mIsAudioPlaying = false;
  private boolean mIsNaviMute = false;
  private boolean mIsPausing = false;
  private boolean mIsSwitching = false;
  private boolean mIsTTSPlaying = false;
  private MediaPlayer mMediaPlayer = null;
  private String mNormalVoicePath = null;
  private OnTTSStateChangedListener mOnTTSStateChangedListener;
  private OnTTSVoiceDataSwitchListener mOnTTSVoiceDataSwitchListener = null;
  private boolean mPhoneIn = false;
  private Object mPlayStateLock = new Object();
  private SharedPreferences mPreferences;
  private String mRequestSwitchPath = null;
  private String mRequestSwitchTextPath = null;
  private String mSDCardAPPBasePath = null;
  private SpeechSynthesizerListener mSpeechSynthesizerListener = new SpeechSynthesizerListener()
  {
    public void onError(String paramAnonymousString, SpeechError paramAnonymousSpeechError)
    {
      SDKDebugFileUtil.getInstance().addCoreLog("CoreLog_TTS: ", " BdTTSPlayer onSpeechFinish onError() arg1=" + paramAnonymousSpeechError.toString());
      SDKDebugFileUtil.getInstance().uploadLogFile(1, true, true, 2000L);
      BdTTSPlayer.loge("BdTTSPlayer", "onError() arg1=" + paramAnonymousSpeechError.toString());
      if (BdTTSPlayer.this.mOnTTSStateChangedListener != null) {
        BdTTSPlayer.this.mOnTTSStateChangedListener.onPlayError(paramAnonymousSpeechError.code, paramAnonymousSpeechError.description);
      }
    }
    
    public void onSpeechFinish(String arg1)
    {
      BdTTSPlayer.loge("BdTTSPlayer", "onSpeechFinish() arg0=" + ???);
      synchronized (BdTTSPlayer.this.mPlayStateLock)
      {
        BdTTSPlayer.access$1602(BdTTSPlayer.this, false);
        if ((BdTTSPlayer.this.mHandler != null) && (BdTTSPlayer.this.mHandler.hasMessages(5))) {
          BdTTSPlayer.this.mHandler.removeMessages(5);
        }
      }
      synchronized (BdTTSPlayer.this.mSyncObj)
      {
        if (BdTTSPlayer.this.mIsSwitching) {}
        synchronized (BdTTSPlayer.this.mPlayStateLock)
        {
          BdTTSPlayer.this.mPlayStateLock.notifyAll();
          if (BdTTSPlayer.this.mOnTTSStateChangedListener != null) {
            BdTTSPlayer.this.mOnTTSStateChangedListener.onPlayEnd();
          }
          if (BdTTSPlayer.this.mIBNTTSPlayerPCMListener != null) {
            BdTTSPlayer.this.mIBNTTSPlayerPCMListener.notifyTTSEnd();
          }
          if (BdTTSPlayer.this.mIBNTTSVoiceHintListener != null) {
            BdTTSPlayer.this.mIBNTTSVoiceHintListener.notifyTTSEnd();
          }
          if (BdTTSPlayer.this.mIBNTTSPlayerWeChatListener != null) {
            BdTTSPlayer.this.mIBNTTSPlayerWeChatListener.notifyTTSEnd();
          }
          return;
          localObject2 = finally;
          throw ((Throwable)localObject2);
        }
      }
    }
    
    public void onSpeechProgressChanged(String paramAnonymousString, int paramAnonymousInt)
    {
      BdTTSPlayer.loge("BdTTSPlayer", "onSpeechProgressChanged arg0=" + paramAnonymousString + " arg1=" + paramAnonymousInt);
      BdTTSPlayer.access$1102(BdTTSPlayer.this, paramAnonymousInt);
    }
    
    public void onSpeechStart(String arg1)
    {
      BdTTSPlayer.loge("BdTTSPlayer", "onSpeechStart() arg0=" + ???);
      BdTTSPlayer.access$1102(BdTTSPlayer.this, 0);
      if (BdTTSPlayer.this.mOnTTSStateChangedListener != null) {
        BdTTSPlayer.this.mOnTTSStateChangedListener.onPlayStart();
      }
      if (BdTTSPlayer.this.mIBNTTSVoiceHintListener != null) {
        BdTTSPlayer.this.mIBNTTSVoiceHintListener.notifyTTSStart();
      }
      if (BdTTSPlayer.this.mIBNTTSPlayerWeChatListener != null) {
        BdTTSPlayer.this.mIBNTTSPlayerWeChatListener.notifyTTSStart();
      }
      synchronized (BdTTSPlayer.this.mPlayStateLock)
      {
        BdTTSPlayer.access$1602(BdTTSPlayer.this, true);
        return;
      }
    }
    
    public void onSynthesizeDataArrived(String paramAnonymousString, byte[] paramAnonymousArrayOfByte, int paramAnonymousInt)
    {
      if (BaseTTSPlayer.getInstance().mIsCarlifeConnected)
      {
        if (BdTTSPlayer.this.mIBNTTSPlayerPCMListener != null)
        {
          BdTTSPlayer.loge("jason", "into there and call handlePCMStream, data length = " + paramAnonymousArrayOfByte.length);
          BdTTSPlayer.this.mIBNTTSPlayerPCMListener.handlePCMStream(paramAnonymousArrayOfByte, false);
          return;
        }
        BdTTSPlayer.loge("BdTTSPlayer", "the listener is null");
        return;
      }
      BdTTSPlayer.loge("BdTTSPlayer", "it is not conectted!");
    }
    
    public void onSynthesizeFinish(String paramAnonymousString) {}
    
    public void onSynthesizeStart(String paramAnonymousString)
    {
      BdTTSPlayer.loge("BdTTSPlayer", "onSynthesizeStart() arg0=" + paramAnonymousString);
      if (BdTTSPlayer.this.mIBNTTSPlayerPCMListener != null) {
        BdTTSPlayer.this.mIBNTTSPlayerPCMListener.notifyTTSStart();
      }
    }
  };
  private Object mSyncObj = new Object();
  private String mTtsJinShaVoiceDataPath = NavMapAdapter.getInstance().getDataPath() + File.separator + "baiduvoicedata" + File.separator + "2-129798" + File.separator + "2-129798" + ".dat";
  private String mTtsRobinVoiceDataPath = NavMapAdapter.getInstance().getDataPath() + File.separator + "baiduvoicedata" + File.separator + "2-159740" + File.separator + "2-159740" + ".dat";
  private boolean mVoiceing = false;
  private String ttsPath;
  private SpeechSynthesizer ttsplayer;
  
  /* Error */
  private static boolean copyAssetsFile(String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 13
    //   3: aconst_null
    //   4: astore 12
    //   6: aconst_null
    //   7: astore 11
    //   9: aconst_null
    //   10: astore 10
    //   12: aload 12
    //   14: astore 7
    //   16: aload 11
    //   18: astore 8
    //   20: aload 13
    //   22: astore 9
    //   24: new 280	com/baidu/mapframework/nirvana/schedule/ScheduleConfig
    //   27: dup
    //   28: invokestatic 286	com/baidu/mapframework/nirvana/schedule/DataTaskType:forUpdateData	()Lcom/baidu/mapframework/nirvana/schedule/DataTaskType;
    //   31: getstatic 292	com/baidu/mapframework/nirvana/schedule/ScheduleTag:NULL	Lcom/baidu/mapframework/nirvana/schedule/ScheduleTag;
    //   34: invokespecial 295	com/baidu/mapframework/nirvana/schedule/ScheduleConfig:<init>	(Lcom/baidu/mapframework/nirvana/schedule/TaskType;Lcom/baidu/mapframework/nirvana/schedule/ScheduleTag;)V
    //   37: astore 14
    //   39: aload 12
    //   41: astore 7
    //   43: aload 11
    //   45: astore 8
    //   47: aload 13
    //   49: astore 9
    //   51: new 297	com/baidu/mapframework/nirvana/assets/AssetsTask
    //   54: dup
    //   55: invokestatic 303	com/baidu/platform/comapi/c:f	()Landroid/content/Context;
    //   58: aload_0
    //   59: invokespecial 306	com/baidu/mapframework/nirvana/assets/AssetsTask:<init>	(Landroid/content/Context;Ljava/lang/String;)V
    //   62: astore_0
    //   63: aload 12
    //   65: astore 7
    //   67: aload 11
    //   69: astore 8
    //   71: aload 13
    //   73: astore 9
    //   75: getstatic 312	com/baidu/mapframework/nirvana/module/Module:NAV_MODULE	Lcom/baidu/mapframework/nirvana/module/Module;
    //   78: aload_0
    //   79: aload 14
    //   81: invokestatic 318	com/baidu/mapframework/nirvana/assets/AssetsManager:open	(Lcom/baidu/mapframework/nirvana/module/Module;Lcom/baidu/mapframework/nirvana/assets/AssetsTask;Lcom/baidu/mapframework/nirvana/schedule/ScheduleConfig;)V
    //   84: aload 12
    //   86: astore 7
    //   88: aload 11
    //   90: astore 8
    //   92: aload 13
    //   94: astore 9
    //   96: aload_0
    //   97: invokevirtual 322	com/baidu/mapframework/nirvana/assets/AssetsTask:getInputStream	()Ljava/io/InputStream;
    //   100: astore_0
    //   101: aload_0
    //   102: ifnonnull +19 -> 121
    //   105: invokestatic 170	com/baidu/baidunavis/NavMapAdapter:getInstance	()Lcom/baidu/baidunavis/NavMapAdapter;
    //   108: aload_0
    //   109: invokevirtual 326	com/baidu/baidunavis/NavMapAdapter:close	(Ljava/io/Closeable;)V
    //   112: invokestatic 170	com/baidu/baidunavis/NavMapAdapter:getInstance	()Lcom/baidu/baidunavis/NavMapAdapter;
    //   115: aconst_null
    //   116: invokevirtual 326	com/baidu/baidunavis/NavMapAdapter:close	(Ljava/io/Closeable;)V
    //   119: iconst_0
    //   120: ireturn
    //   121: aload_0
    //   122: astore 7
    //   124: aload 11
    //   126: astore 8
    //   128: aload_0
    //   129: astore 9
    //   131: new 180	java/io/File
    //   134: dup
    //   135: aload_1
    //   136: invokespecial 329	java/io/File:<init>	(Ljava/lang/String;)V
    //   139: astore 12
    //   141: aload_0
    //   142: astore 7
    //   144: aload 11
    //   146: astore 8
    //   148: aload_0
    //   149: astore 9
    //   151: aload 12
    //   153: invokevirtual 333	java/io/File:length	()J
    //   156: lstore 4
    //   158: aload_0
    //   159: astore 7
    //   161: aload 11
    //   163: astore 8
    //   165: aload_0
    //   166: astore 9
    //   168: aload_0
    //   169: invokevirtual 339	java/io/InputStream:available	()I
    //   172: istore_3
    //   173: aload_0
    //   174: astore 7
    //   176: aload 11
    //   178: astore 8
    //   180: aload_0
    //   181: astore 9
    //   183: aload 12
    //   185: invokevirtual 342	java/io/File:exists	()Z
    //   188: istore 6
    //   190: iload 6
    //   192: ifeq +27 -> 219
    //   195: lload 4
    //   197: iload_3
    //   198: i2l
    //   199: lcmp
    //   200: ifne +19 -> 219
    //   203: invokestatic 170	com/baidu/baidunavis/NavMapAdapter:getInstance	()Lcom/baidu/baidunavis/NavMapAdapter;
    //   206: aload_0
    //   207: invokevirtual 326	com/baidu/baidunavis/NavMapAdapter:close	(Ljava/io/Closeable;)V
    //   210: invokestatic 170	com/baidu/baidunavis/NavMapAdapter:getInstance	()Lcom/baidu/baidunavis/NavMapAdapter;
    //   213: aconst_null
    //   214: invokevirtual 326	com/baidu/baidunavis/NavMapAdapter:close	(Ljava/io/Closeable;)V
    //   217: iconst_1
    //   218: ireturn
    //   219: aload_0
    //   220: astore 7
    //   222: aload 11
    //   224: astore 8
    //   226: aload_0
    //   227: astore 9
    //   229: new 180	java/io/File
    //   232: dup
    //   233: aload_1
    //   234: invokespecial 329	java/io/File:<init>	(Ljava/lang/String;)V
    //   237: astore 12
    //   239: aload_0
    //   240: astore 7
    //   242: aload 11
    //   244: astore 8
    //   246: aload_0
    //   247: astore 9
    //   249: aload 12
    //   251: invokevirtual 342	java/io/File:exists	()Z
    //   254: ifne +19 -> 273
    //   257: aload_0
    //   258: astore 7
    //   260: aload 11
    //   262: astore 8
    //   264: aload_0
    //   265: astore 9
    //   267: aload 12
    //   269: invokevirtual 345	java/io/File:mkdirs	()Z
    //   272: pop
    //   273: aload_0
    //   274: astore 7
    //   276: aload 11
    //   278: astore 8
    //   280: aload_0
    //   281: astore 9
    //   283: new 180	java/io/File
    //   286: dup
    //   287: new 163	java/lang/StringBuilder
    //   290: dup
    //   291: invokespecial 164	java/lang/StringBuilder:<init>	()V
    //   294: aload_1
    //   295: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   298: ldc_w 347
    //   301: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   304: aload_2
    //   305: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   308: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   311: invokespecial 329	java/io/File:<init>	(Ljava/lang/String;)V
    //   314: astore 12
    //   316: aload_0
    //   317: astore 7
    //   319: aload 11
    //   321: astore 8
    //   323: aload_0
    //   324: astore 9
    //   326: ldc 65
    //   328: new 163	java/lang/StringBuilder
    //   331: dup
    //   332: invokespecial 164	java/lang/StringBuilder:<init>	()V
    //   335: ldc_w 349
    //   338: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   341: aload_1
    //   342: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   345: ldc_w 347
    //   348: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   351: aload_2
    //   352: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   355: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   358: invokestatic 268	com/baidu/baidunavis/tts/BdTTSPlayer:loge	(Ljava/lang/String;Ljava/lang/String;)V
    //   361: aload_0
    //   362: astore 7
    //   364: aload 11
    //   366: astore 8
    //   368: aload_0
    //   369: astore 9
    //   371: aload 12
    //   373: invokevirtual 342	java/io/File:exists	()Z
    //   376: ifeq +37 -> 413
    //   379: aload_0
    //   380: astore 7
    //   382: aload 11
    //   384: astore 8
    //   386: aload_0
    //   387: astore 9
    //   389: aload 12
    //   391: invokevirtual 352	java/io/File:delete	()Z
    //   394: pop
    //   395: aload_0
    //   396: astore 7
    //   398: aload 11
    //   400: astore 8
    //   402: aload_0
    //   403: astore 9
    //   405: ldc 65
    //   407: ldc_w 354
    //   410: invokestatic 268	com/baidu/baidunavis/tts/BdTTSPlayer:loge	(Ljava/lang/String;Ljava/lang/String;)V
    //   413: aload_0
    //   414: astore 7
    //   416: aload 11
    //   418: astore 8
    //   420: aload_0
    //   421: astore 9
    //   423: new 356	java/io/FileOutputStream
    //   426: dup
    //   427: aload 12
    //   429: invokespecial 359	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   432: astore_1
    //   433: sipush 1024
    //   436: newarray <illegal type>
    //   438: astore_2
    //   439: aload_0
    //   440: aload_2
    //   441: invokevirtual 363	java/io/InputStream:read	([B)I
    //   444: istore_3
    //   445: iload_3
    //   446: ifle +46 -> 492
    //   449: aload_1
    //   450: aload_2
    //   451: iconst_0
    //   452: iload_3
    //   453: invokevirtual 369	java/io/OutputStream:write	([BII)V
    //   456: goto -17 -> 439
    //   459: astore_2
    //   460: aload_0
    //   461: astore 7
    //   463: aload_1
    //   464: astore 8
    //   466: ldc_w 371
    //   469: aload_2
    //   470: invokevirtual 372	java/lang/Exception:toString	()Ljava/lang/String;
    //   473: invokestatic 268	com/baidu/baidunavis/tts/BdTTSPlayer:loge	(Ljava/lang/String;Ljava/lang/String;)V
    //   476: invokestatic 170	com/baidu/baidunavis/NavMapAdapter:getInstance	()Lcom/baidu/baidunavis/NavMapAdapter;
    //   479: aload_0
    //   480: invokevirtual 326	com/baidu/baidunavis/NavMapAdapter:close	(Ljava/io/Closeable;)V
    //   483: invokestatic 170	com/baidu/baidunavis/NavMapAdapter:getInstance	()Lcom/baidu/baidunavis/NavMapAdapter;
    //   486: aload_1
    //   487: invokevirtual 326	com/baidu/baidunavis/NavMapAdapter:close	(Ljava/io/Closeable;)V
    //   490: iconst_0
    //   491: ireturn
    //   492: invokestatic 170	com/baidu/baidunavis/NavMapAdapter:getInstance	()Lcom/baidu/baidunavis/NavMapAdapter;
    //   495: aload_0
    //   496: invokevirtual 326	com/baidu/baidunavis/NavMapAdapter:close	(Ljava/io/Closeable;)V
    //   499: invokestatic 170	com/baidu/baidunavis/NavMapAdapter:getInstance	()Lcom/baidu/baidunavis/NavMapAdapter;
    //   502: aload_1
    //   503: invokevirtual 326	com/baidu/baidunavis/NavMapAdapter:close	(Ljava/io/Closeable;)V
    //   506: iconst_1
    //   507: ireturn
    //   508: astore_1
    //   509: aload 7
    //   511: astore_0
    //   512: invokestatic 170	com/baidu/baidunavis/NavMapAdapter:getInstance	()Lcom/baidu/baidunavis/NavMapAdapter;
    //   515: aload_0
    //   516: invokevirtual 326	com/baidu/baidunavis/NavMapAdapter:close	(Ljava/io/Closeable;)V
    //   519: invokestatic 170	com/baidu/baidunavis/NavMapAdapter:getInstance	()Lcom/baidu/baidunavis/NavMapAdapter;
    //   522: aload 8
    //   524: invokevirtual 326	com/baidu/baidunavis/NavMapAdapter:close	(Ljava/io/Closeable;)V
    //   527: aload_1
    //   528: athrow
    //   529: astore_2
    //   530: aload_1
    //   531: astore 8
    //   533: aload_2
    //   534: astore_1
    //   535: goto -23 -> 512
    //   538: astore_2
    //   539: aload 9
    //   541: astore_0
    //   542: aload 10
    //   544: astore_1
    //   545: goto -85 -> 460
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	548	0	paramString1	String
    //   0	548	1	paramString2	String
    //   0	548	2	paramString3	String
    //   172	281	3	i	int
    //   156	40	4	l	long
    //   188	3	6	bool	boolean
    //   14	496	7	localObject1	Object
    //   18	514	8	localObject2	Object
    //   22	518	9	localObject3	Object
    //   10	533	10	localObject4	Object
    //   7	410	11	localObject5	Object
    //   4	424	12	localFile	File
    //   1	92	13	localObject6	Object
    //   37	43	14	localScheduleConfig	com.baidu.mapframework.nirvana.schedule.ScheduleConfig
    // Exception table:
    //   from	to	target	type
    //   433	439	459	java/lang/Exception
    //   439	445	459	java/lang/Exception
    //   449	456	459	java/lang/Exception
    //   24	39	508	finally
    //   51	63	508	finally
    //   75	84	508	finally
    //   96	101	508	finally
    //   131	141	508	finally
    //   151	158	508	finally
    //   168	173	508	finally
    //   183	190	508	finally
    //   229	239	508	finally
    //   249	257	508	finally
    //   267	273	508	finally
    //   283	316	508	finally
    //   326	361	508	finally
    //   371	379	508	finally
    //   389	395	508	finally
    //   405	413	508	finally
    //   423	433	508	finally
    //   466	476	508	finally
    //   433	439	529	finally
    //   439	445	529	finally
    //   449	456	529	finally
    //   24	39	538	java/lang/Exception
    //   51	63	538	java/lang/Exception
    //   75	84	538	java/lang/Exception
    //   96	101	538	java/lang/Exception
    //   131	141	538	java/lang/Exception
    //   151	158	538	java/lang/Exception
    //   168	173	538	java/lang/Exception
    //   183	190	538	java/lang/Exception
    //   229	239	538	java/lang/Exception
    //   249	257	538	java/lang/Exception
    //   267	273	538	java/lang/Exception
    //   283	316	538	java/lang/Exception
    //   326	361	538	java/lang/Exception
    //   371	379	538	java/lang/Exception
    //   389	395	538	java/lang/Exception
    //   405	413	538	java/lang/Exception
    //   423	433	538	java/lang/Exception
  }
  
  private boolean copyRes()
  {
    boolean bool1;
    if (this.mContext == null) {
      bool1 = false;
    }
    boolean bool2;
    do
    {
      return bool1;
      bool1 = copyAssetsFile("bd_etts_common_speech_f7_mand_eng_high_am-mix_v3.0.0_20170512.dat", this.mNormalVoicePath, "bd_etts_common_speech_f7_mand_eng_high_am-mix_v3.0.0_20170512.dat");
      loge("BdTTSPlayer", "initPlayer() copy, ret=" + bool1 + ", path=" + this.mNormalVoicePath + "/" + "bd_etts_common_speech_f7_mand_eng_high_am-mix_v3.0.0_20170512.dat");
      bool1 &= copyAssetsFile("bd_etts_common_text_txt_all_mand_eng_middle_mix_v3.1.0_20170525.dat", this.mNormalVoicePath, "bd_etts_common_text_txt_all_mand_eng_middle_mix_v3.1.0_20170525.dat");
      loge("BdTTSPlayer", "initPlayer() copy text, ret=" + bool1 + ", path=" + this.mNormalVoicePath + "/" + "bd_etts_common_text_txt_all_mand_eng_middle_mix_v3.1.0_20170525.dat");
      bool2 = bool1 & copyAssetsFile("bd_etts_common_speech_taiwan_mand_eng_high_am-mgc_v3.0.0_20170807.dat", this.mNormalVoicePath, "bd_etts_common_speech_taiwan_mand_eng_high_am-mgc_v3.0.0_20170807.dat");
      loge("BdTTSPlayer", "initPlayer() copy text, ret=" + bool2 + ", path=" + this.mNormalVoicePath + "/" + "bd_etts_common_speech_taiwan_mand_eng_high_am-mgc_v3.0.0_20170807.dat");
      bool1 = bool2;
    } while (!bool2);
    return copyAssetsFile("baidu_tts_licence.dat", this.mNormalVoicePath, "baidu_tts_licence.dat");
  }
  
  /* Error */
  private boolean freeCustomTTSVoiceDataInner()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 257	com/baidu/baidunavis/tts/BdTTSPlayer:mContext	Landroid/content/Context;
    //   4: ifnonnull +5 -> 9
    //   7: iconst_0
    //   8: ireturn
    //   9: aload_0
    //   10: getfield 155	com/baidu/baidunavis/tts/BdTTSPlayer:mPlayStateLock	Ljava/lang/Object;
    //   13: astore_2
    //   14: aload_2
    //   15: monitorenter
    //   16: aload_0
    //   17: getfield 131	com/baidu/baidunavis/tts/BdTTSPlayer:mIsTTSPlaying	Z
    //   20: istore_1
    //   21: iload_1
    //   22: ifeq +13 -> 35
    //   25: aload_0
    //   26: getfield 155	com/baidu/baidunavis/tts/BdTTSPlayer:mPlayStateLock	Ljava/lang/Object;
    //   29: ldc2_w 387
    //   32: invokevirtual 392	java/lang/Object:wait	(J)V
    //   35: aload_2
    //   36: monitorexit
    //   37: aload_0
    //   38: getfield 394	com/baidu/baidunavis/tts/BdTTSPlayer:ttsplayer	Lcom/baidu/tts/client/SpeechSynthesizer;
    //   41: invokevirtual 399	com/baidu/tts/client/SpeechSynthesizer:stop	()I
    //   44: pop
    //   45: aload_0
    //   46: getfield 394	com/baidu/baidunavis/tts/BdTTSPlayer:ttsplayer	Lcom/baidu/tts/client/SpeechSynthesizer;
    //   49: invokevirtual 402	com/baidu/tts/client/SpeechSynthesizer:freeCustomResource	()I
    //   52: pop
    //   53: ldc 65
    //   55: ldc_w 403
    //   58: invokestatic 268	com/baidu/baidunavis/tts/BdTTSPlayer:loge	(Ljava/lang/String;Ljava/lang/String;)V
    //   61: iconst_1
    //   62: ireturn
    //   63: astore_3
    //   64: aload_2
    //   65: monitorexit
    //   66: aload_3
    //   67: athrow
    //   68: astore_2
    //   69: aload_0
    //   70: aconst_null
    //   71: putfield 394	com/baidu/baidunavis/tts/BdTTSPlayer:ttsplayer	Lcom/baidu/tts/client/SpeechSynthesizer;
    //   74: aload_0
    //   75: iconst_0
    //   76: putfield 121	com/baidu/baidunavis/tts/BdTTSPlayer:mInitState	I
    //   79: invokestatic 170	com/baidu/baidunavis/NavMapAdapter:getInstance	()Lcom/baidu/baidunavis/NavMapAdapter;
    //   82: aload_2
    //   83: invokevirtual 407	com/baidu/baidunavis/NavMapAdapter:exceptionLog	(Ljava/lang/Throwable;)V
    //   86: iconst_0
    //   87: ireturn
    //   88: astore_3
    //   89: goto -54 -> 35
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	92	0	this	BdTTSPlayer
    //   20	2	1	bool	boolean
    //   68	15	2	localThrowable	Throwable
    //   63	4	3	localObject2	Object
    //   88	1	3	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   16	21	63	finally
    //   25	35	63	finally
    //   35	37	63	finally
    //   64	66	63	finally
    //   9	16	68	java/lang/Throwable
    //   37	61	68	java/lang/Throwable
    //   66	68	68	java/lang/Throwable
    //   25	35	88	java/lang/Exception
  }
  
  private String getInitPlaySpeed(boolean paramBoolean)
  {
    if (paramBoolean) {
      return String.valueOf(7);
    }
    return String.valueOf(BNSettingManager.getTTSSpeedParam());
  }
  
  private boolean initPlayerInner(String paramString)
  {
    long l;
    String str;
    boolean bool2;
    for (;;)
    {
      try
      {
        if ((this.mContext == null) || (this.mSDCardAPPBasePath == null) || (this.mSDCardAPPBasePath.length() == 0))
        {
          this.mInitState = 0;
          SDKDebugFileUtil.getInstance().addCoreLog("CoreLog_TTS: ", " BdTTSPlayer initPlayerInner 1111: ");
          bool1 = false;
          return bool1;
        }
        l = SystemClock.elapsedRealtime();
        str = paramString;
        bool1 = false;
        paramString = str;
        if (str != null) {
          paramString = str;
        }
        try
        {
          if (str.length() > 0)
          {
            if (!new File(str).exists()) {
              continue;
            }
            paramString = str;
            if (!SynthesizerTool.verifyModelFile(str))
            {
              BNSettingManager.setVoicePersonality(0);
              paramString = null;
            }
          }
          this.mPreferences = this.mContext.getSharedPreferences("map_asr_pre", 0);
          this.mEditor = this.mPreferences.edit();
          int i;
          if ((paramString == null) || (paramString.length() == 0))
          {
            paramString = this.mNormalVoicePath + File.separator + this.mCurrentSelectPath;
            bool1 = true;
            i = this.mPreferences.getInt("asr_normal", 0);
            this.mEditor.putInt("asr_normal", i + 1);
            this.mEditor.commit();
            bool2 = bool1;
            str = paramString;
            if (BNSettingManager.getHasDownloadJinShaTTS())
            {
              bool2 = bool1;
              str = paramString;
              if (BNSettingManager.getAutoSwitchJinShaTTS())
              {
                bool2 = bool1;
                str = paramString;
                if (new File(this.mTtsJinShaVoiceDataPath).exists())
                {
                  bool2 = bool1;
                  str = paramString;
                  if (SynthesizerTool.verifyModelFile(this.mTtsJinShaVoiceDataPath))
                  {
                    bool2 = false;
                    str = this.mTtsJinShaVoiceDataPath;
                    saveCustomVoiceDataPath(this.mTtsJinShaVoiceDataPath);
                    BNSettingManager.setVoicePersonality(3);
                    BNSettingManager.setVoiceTaskId("2-129798");
                    BNSettingManager.setAutoSwitchJinShaTTS(false);
                  }
                }
              }
            }
            if ((str != null) && (str.length() > 0) && (!new File(str).exists()))
            {
              this.mInitState = 0;
              SDKDebugFileUtil.getInstance().addCoreLog("CoreLog_TTS: ", " BdTTSPlayer initPlayerInner 2222: ");
              bool1 = false;
              continue;
              BNSettingManager.setVoicePersonality(0);
              paramString = null;
              continue;
            }
          }
          else
          {
            i = this.mPreferences.getInt("asr_maidou", 0);
            this.mEditor.putInt("asr_maidou", i + 1);
            this.mEditor.commit();
            continue;
          }
        }
        catch (Throwable paramString)
        {
          SDKDebugFileUtil.getInstance().addCoreLog("CoreLog_TTS: ", " BdTTSPlayer initPlayerInner 3333: " + paramString.toString());
          this.ttsplayer = null;
          this.mInitState = 0;
          if (this.mHandler != null) {
            this.mHandler.sendEmptyMessage(4);
          }
          NavMapAdapter.getInstance().exceptionLog(paramString);
          bool1 = false;
        }
        if (this.ttsplayer != null) {
          break label1340;
        }
        loge("BdTTSPlayer", "initPlayer() start");
        if (NavLogUtils.LOGGABLE) {
          LoggerProxy.printable(true);
        }
        NavLogUtils.e("BdTTSPlayer SynthesizerTool.getEngineVersion() = ", SynthesizerTool.getEngineVersion() + "");
        NavLogUtils.e("BdTTSPlayer SynthesizerTool.getEngineInfo() = ", SynthesizerTool.getEngineInfo());
        this.ttsplayer = SpeechSynthesizer.getInstance();
        this.ttsplayer.setContext(this.mContext);
        this.ttsplayer.setSpeechSynthesizerListener(this.mSpeechSynthesizerListener);
        this.ttsplayer.setApiKey("sQ7RFHINisS0HdnZfITNlT1p", "azrqa6WpOzQ37cbO9Cnb10M7MRojPKG3");
        this.ttsplayer.setAppId("7789047");
        paramString = getInitPlaySpeed(bool2);
        this.ttsplayer.setParam(SpeechSynthesizer.PARAM_SPEED, paramString);
        NavLogUtils.e("BdTTSPlayer", "initPlayerInner() set1.speed=" + paramString);
        this.ttsplayer.setParam(SpeechSynthesizer.PARAM_VOCODER_OPTIM_LEVEL, BNSettingManager.getTTSVocoderParam());
        if ((str != null) && (str.equals(this.mTtsJinShaVoiceDataPath)))
        {
          this.ttsplayer.setParam(SpeechSynthesizer.PARAM_SPEED, "6");
          setCurrentVolume(8);
          loge("BdTTSPlayer", "initPlayer() tts data path=" + str + ", time=" + (SystemClock.elapsedRealtime() - l) + "/ms");
          this.ttsplayer.setParam(SpeechSynthesizer.PARAM_TTS_TEXT_MODEL_FILE, this.mNormalVoicePath + File.separator + "bd_etts_common_text_txt_all_mand_eng_middle_mix_v3.1.0_20170525.dat");
          this.ttsplayer.setParam(SpeechSynthesizer.PARAM_TTS_SPEECH_MODEL_FILE, str);
          if (!bool2) {
            break;
          }
          bool1 = SynthesizerTool.verifyModelFile(str);
          loge("BdTTSPlayer", "initPlayer() verifyRet=" + bool1 + ", time=" + (SystemClock.elapsedRealtime() - l) + "/ms");
          if (bool1) {
            break;
          }
          loge("BdTTSPlayer", "initPlayer() failed to verify tts. path=" + str);
          this.ttsplayer = null;
          this.mInitState = 0;
          bool1 = false;
          continue;
        }
        if ((str != null) && (str.contains("bd_etts_common_speech_taiwan_mand_eng_high_am-mgc_v3.0.0_20170807.dat")))
        {
          this.ttsplayer.setParam(SpeechSynthesizer.PARAM_SPEED, "4");
          setCurrentVolume(8);
          continue;
        }
        if (str == null) {
          break label981;
        }
      }
      finally {}
      if (str.contains("bd_etts_common_speech_f7_mand_eng_high_am-mix_v3.0.0_20170512.dat"))
      {
        this.ttsplayer.setParam(SpeechSynthesizer.PARAM_SPEED, "7");
        setCurrentVolume(7);
      }
      else
      {
        label981:
        this.ttsplayer.setParam(SpeechSynthesizer.PARAM_SPEED, getInitPlaySpeed(bool2));
        setCurrentVolume(7);
      }
    }
    paramString = this.mNormalVoicePath + File.separator + "baidu_tts_licence.dat";
    this.ttsplayer.setParam(SpeechSynthesizer.PARAM_TTS_LICENCE_FILE, paramString);
    this.ttsplayer.initTts(TtsMode.OFFLINE);
    this.ttsplayer.setParam(SpeechSynthesizer.PARAM_OPEN_XML, "1");
    this.ttsplayer.setParam(SpeechSynthesizer.PARAM_CUSTOM_SYNTH, "1");
    boolean bool1 = getTTSVoiceDataCustom();
    paramString = getCustomVoiceDataPath();
    loge("BdTTSPlayer", "initPlayerInner custom = " + bool1 + " path = " + paramString);
    if ((bool1) && (paramString != null) && (paramString.length() > 0))
    {
      File localFile = new File(paramString);
      if (localFile != null)
      {
        paramString = localFile;
        if (localFile.exists()) {}
      }
      else
      {
        paramString = localFile;
        if (str != null)
        {
          paramString = localFile;
          if (str.equals(this.mTtsRobinVoiceDataPath)) {
            paramString = new File(this.mNormalVoicePath + File.separator + "1-00001.dat");
          }
        }
      }
      if ((paramString != null) && (paramString.exists())) {
        this.ttsplayer.loadCustomResource(paramString.getPath());
      }
    }
    else
    {
      label1255:
      this.mCurrentTTSTextPath = null;
      if (!bool2) {
        break label1373;
      }
      this.mCurrentTTSVoiceDataPath = null;
      saveTTSVoiceDataPath(this.mNormalVoicePath + File.separator + this.mCurrentSelectPath);
    }
    for (;;)
    {
      loge("BdTTSPlayer", "initPlayer() end, initTime=" + (SystemClock.elapsedRealtime() - l) + "/ms");
      label1340:
      this.mInitState = 2;
      bool1 = true;
      break;
      if (!bool2) {
        break label1255;
      }
      saveTTSVoiceDataCustom(false);
      setTTSVoiceDataPath(null);
      BNSettingManager.setVoicePersonality(0);
      break label1255;
      label1373:
      this.mCurrentTTSVoiceDataPath = str;
      saveTTSVoiceDataPath(str);
    }
  }
  
  public static boolean isCalling(Context paramContext)
  {
    if (paramContext == null) {
      return false;
    }
    switch (((TelephonyManager)paramContext.getSystemService("phone")).getCallState())
    {
    default: 
      return false;
    }
    return true;
  }
  
  /* Error */
  private boolean loadCustomTTSVoiceDataInner()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 257	com/baidu/baidunavis/tts/BdTTSPlayer:mContext	Landroid/content/Context;
    //   4: ifnonnull +5 -> 9
    //   7: iconst_0
    //   8: ireturn
    //   9: aload_0
    //   10: getfield 155	com/baidu/baidunavis/tts/BdTTSPlayer:mPlayStateLock	Ljava/lang/Object;
    //   13: astore_2
    //   14: aload_2
    //   15: monitorenter
    //   16: aload_0
    //   17: getfield 131	com/baidu/baidunavis/tts/BdTTSPlayer:mIsTTSPlaying	Z
    //   20: istore_1
    //   21: iload_1
    //   22: ifeq +13 -> 35
    //   25: aload_0
    //   26: getfield 155	com/baidu/baidunavis/tts/BdTTSPlayer:mPlayStateLock	Ljava/lang/Object;
    //   29: ldc2_w 387
    //   32: invokevirtual 392	java/lang/Object:wait	(J)V
    //   35: aload_2
    //   36: monitorexit
    //   37: aload_0
    //   38: getfield 394	com/baidu/baidunavis/tts/BdTTSPlayer:ttsplayer	Lcom/baidu/tts/client/SpeechSynthesizer;
    //   41: invokevirtual 399	com/baidu/tts/client/SpeechSynthesizer:stop	()I
    //   44: pop
    //   45: aload_0
    //   46: invokevirtual 641	com/baidu/baidunavis/tts/BdTTSPlayer:getTTSVoiceDataCustom	()Z
    //   49: istore_1
    //   50: aload_0
    //   51: invokevirtual 644	com/baidu/baidunavis/tts/BdTTSPlayer:getCustomVoiceDataPath	()Ljava/lang/String;
    //   54: astore_2
    //   55: ldc 65
    //   57: new 163	java/lang/StringBuilder
    //   60: dup
    //   61: invokespecial 164	java/lang/StringBuilder:<init>	()V
    //   64: ldc_w 680
    //   67: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: iload_1
    //   71: invokevirtual 380	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   74: ldc_w 682
    //   77: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: aload_2
    //   81: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   87: invokestatic 268	com/baidu/baidunavis/tts/BdTTSPlayer:loge	(Ljava/lang/String;Ljava/lang/String;)V
    //   90: iload_1
    //   91: ifeq +51 -> 142
    //   94: aload_2
    //   95: ifnull +47 -> 142
    //   98: aload_2
    //   99: invokevirtual 424	java/lang/String:length	()I
    //   102: ifle +40 -> 142
    //   105: new 180	java/io/File
    //   108: dup
    //   109: aload_2
    //   110: invokespecial 329	java/io/File:<init>	(Ljava/lang/String;)V
    //   113: astore_3
    //   114: aload_3
    //   115: ifnull +27 -> 142
    //   118: aload_3
    //   119: invokevirtual 342	java/io/File:exists	()Z
    //   122: ifeq +20 -> 142
    //   125: aload_0
    //   126: getfield 394	com/baidu/baidunavis/tts/BdTTSPlayer:ttsplayer	Lcom/baidu/tts/client/SpeechSynthesizer;
    //   129: invokevirtual 402	com/baidu/tts/client/SpeechSynthesizer:freeCustomResource	()I
    //   132: pop
    //   133: aload_0
    //   134: getfield 394	com/baidu/baidunavis/tts/BdTTSPlayer:ttsplayer	Lcom/baidu/tts/client/SpeechSynthesizer;
    //   137: aload_2
    //   138: invokevirtual 654	com/baidu/tts/client/SpeechSynthesizer:loadCustomResource	(Ljava/lang/String;)I
    //   141: pop
    //   142: iconst_1
    //   143: ireturn
    //   144: astore_3
    //   145: aload_2
    //   146: monitorexit
    //   147: aload_3
    //   148: athrow
    //   149: astore_2
    //   150: aload_0
    //   151: aconst_null
    //   152: putfield 394	com/baidu/baidunavis/tts/BdTTSPlayer:ttsplayer	Lcom/baidu/tts/client/SpeechSynthesizer;
    //   155: aload_0
    //   156: iconst_0
    //   157: putfield 121	com/baidu/baidunavis/tts/BdTTSPlayer:mInitState	I
    //   160: invokestatic 170	com/baidu/baidunavis/NavMapAdapter:getInstance	()Lcom/baidu/baidunavis/NavMapAdapter;
    //   163: aload_2
    //   164: invokevirtual 407	com/baidu/baidunavis/NavMapAdapter:exceptionLog	(Ljava/lang/Throwable;)V
    //   167: iconst_0
    //   168: ireturn
    //   169: astore_3
    //   170: goto -135 -> 35
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	173	0	this	BdTTSPlayer
    //   20	71	1	bool	boolean
    //   149	15	2	localThrowable	Throwable
    //   113	6	3	localFile	File
    //   144	4	3	localObject2	Object
    //   169	1	3	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   16	21	144	finally
    //   25	35	144	finally
    //   35	37	144	finally
    //   145	147	144	finally
    //   9	16	149	java/lang/Throwable
    //   37	90	149	java/lang/Throwable
    //   98	114	149	java/lang/Throwable
    //   118	142	149	java/lang/Throwable
    //   147	149	149	java/lang/Throwable
    //   25	35	169	java/lang/Exception
  }
  
  private static void loge(String paramString1, String paramString2)
  {
    NavLogUtils.e(paramString1, paramString2);
  }
  
  private void makesureDirs()
  {
    File localFile = new File(this.mSDCardAPPBasePath + File.separator + "tts");
    if ((localFile != null) && (!localFile.exists())) {
      localFile.mkdir();
    }
    localFile = new File(this.mNormalVoicePath);
    if ((localFile != null) && (!localFile.exists())) {
      localFile.mkdir();
    }
  }
  
  private int playTTSTextImp(String paramString1, String paramString2, int paramInt)
  {
    if ((this.ttsplayer == null) || (this.mInitState != 2))
    {
      SDKDebugFileUtil.getInstance().addCoreLog("CoreLog_TTS: ", " BdTTSPlayer playTTSText ttsplayer == null || mInitState != INIT_STATE_OK ");
      return 0;
    }
    if (this.mPhoneIn)
    {
      SDKDebugFileUtil.getInstance().addCoreLog("CoreLog_TTS: ", " BdTTSPlayer playTTSText mPhoneIn " + this.mPhoneIn);
      return 0;
    }
    synchronized (this.mSyncObj)
    {
      if (this.mIsSwitching)
      {
        SDKDebugFileUtil.getInstance().addCoreLog("CoreLog_TTS: ", " BdTTSPlayer playTTSText mIsSwitching " + this.mIsSwitching);
        return 0;
      }
    }
    for (;;)
    {
      try
      {
        if (!isCalling(this.mContext))
        {
          if ((paramInt == 1) && (getTTSState() == 2)) {
            stopTTS();
          }
          dospeak(paramString1, paramString2);
        }
        else
        {
          paramString1 = SDKDebugFileUtil.getInstance();
          paramString2 = new StringBuilder().append(" BdTTSPlayer playTTSText !isCalling(mContext) ");
          if (!isCalling(this.mContext))
          {
            bool = true;
            paramString1.addCoreLog("CoreLog_TTS: ", bool);
          }
        }
      }
      catch (Exception paramString1)
      {
        SDKDebugFileUtil.getInstance().addCoreLog("CoreLog_TTS: ", " BdTTSPlayer playTTSText Exception " + paramString1.toString());
        loge("", paramString1.toString());
      }
      boolean bool = false;
    }
    return 1;
  }
  
  private void resetTTSForTimeout()
  {
    SDKDebugFileUtil.getInstance().addCoreLog("CoreLog_TTS: ", " BdTTSPlayer resetTTSForTimeout 111: ");
    if ((this.ttsplayer == null) || (this.mInitState != 2)) {
      return;
    }
    loge("BdTTSPlayer", "resetTTSForTimeout() ");
    stopTTS();
  }
  
  private void saveCustomVoiceDataPath(String paramString)
  {
    if ((this.mContext == null) || (paramString == null)) {}
    Object localObject;
    do
    {
      do
      {
        return;
        localObject = this.mContext.getSharedPreferences("_navi_sdk_tts_custom_path_", 0);
      } while (localObject == null);
      localObject = ((SharedPreferences)localObject).edit();
    } while (localObject == null);
    ((SharedPreferences.Editor)localObject).putString("_navi_sdk_tts_custom_path_", paramString);
    ((SharedPreferences.Editor)localObject).commit();
  }
  
  private void saveTTSVoiceDataCustom(boolean paramBoolean)
  {
    if (this.mContext == null) {}
    Object localObject;
    do
    {
      do
      {
        return;
        localObject = this.mContext.getSharedPreferences("_navi_sdk_tts_custom_", 0);
      } while (localObject == null);
      localObject = ((SharedPreferences)localObject).edit();
    } while (localObject == null);
    ((SharedPreferences.Editor)localObject).putBoolean("_navi_sdk_tts_custom_", paramBoolean);
    ((SharedPreferences.Editor)localObject).commit();
  }
  
  private boolean switchTTSVoiceData(String paramString1, String paramString2, boolean paramBoolean1, OnTTSVoiceDataSwitchListener paramOnTTSVoiceDataSwitchListener, boolean paramBoolean2)
  {
    if (this.mHandler == null) {
      return false;
    }
    synchronized (this.mSyncObj)
    {
      if (this.mIsSwitching) {
        return false;
      }
    }
    this.mIsSwitching = true;
    this.mRequestSwitchPath = paramString1;
    this.mRequestSwitchTextPath = paramString2;
    this.isNeedSaveConfig = paramBoolean1;
    this.mOnTTSVoiceDataSwitchListener = paramOnTTSVoiceDataSwitchListener;
    if (paramBoolean2)
    {
      this.mHandler.obtainMessage(3).sendToTarget();
      return true;
    }
    return switchTTSVoiceDataInner(paramString1, paramString2, paramBoolean1);
  }
  
  /* Error */
  private boolean switchTTSVoiceDataInner(String arg1, String paramString2, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 257	com/baidu/baidunavis/tts/BdTTSPlayer:mContext	Landroid/content/Context;
    //   4: ifnonnull +7 -> 11
    //   7: iconst_0
    //   8: istore_3
    //   9: iload_3
    //   10: ireturn
    //   11: aload_0
    //   12: aload_1
    //   13: putfield 740	com/baidu/baidunavis/tts/BdTTSPlayer:ttsPath	Ljava/lang/String;
    //   16: iconst_0
    //   17: istore 5
    //   19: aload_0
    //   20: aload_0
    //   21: getfield 257	com/baidu/baidunavis/tts/BdTTSPlayer:mContext	Landroid/content/Context;
    //   24: ldc_w 452
    //   27: iconst_0
    //   28: invokevirtual 458	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   31: putfield 460	com/baidu/baidunavis/tts/BdTTSPlayer:mPreferences	Landroid/content/SharedPreferences;
    //   34: aload_0
    //   35: aload_0
    //   36: getfield 460	com/baidu/baidunavis/tts/BdTTSPlayer:mPreferences	Landroid/content/SharedPreferences;
    //   39: invokeinterface 466 1 0
    //   44: putfield 468	com/baidu/baidunavis/tts/BdTTSPlayer:mEditor	Landroid/content/SharedPreferences$Editor;
    //   47: aload_1
    //   48: ifnull +10 -> 58
    //   51: aload_1
    //   52: invokevirtual 424	java/lang/String:length	()I
    //   55: ifne +137 -> 192
    //   58: aload_0
    //   59: new 163	java/lang/StringBuilder
    //   62: dup
    //   63: invokespecial 164	java/lang/StringBuilder:<init>	()V
    //   66: aload_0
    //   67: getfield 125	com/baidu/baidunavis/tts/BdTTSPlayer:mNormalVoicePath	Ljava/lang/String;
    //   70: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: getstatic 183	java/io/File:separator	Ljava/lang/String;
    //   76: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: aload_0
    //   80: getfield 129	com/baidu/baidunavis/tts/BdTTSPlayer:mCurrentSelectPath	Ljava/lang/String;
    //   83: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   89: putfield 740	com/baidu/baidunavis/tts/BdTTSPlayer:ttsPath	Ljava/lang/String;
    //   92: iconst_1
    //   93: istore 5
    //   95: aload_0
    //   96: getfield 460	com/baidu/baidunavis/tts/BdTTSPlayer:mPreferences	Landroid/content/SharedPreferences;
    //   99: ldc_w 470
    //   102: iconst_0
    //   103: invokeinterface 474 3 0
    //   108: istore 4
    //   110: aload_0
    //   111: getfield 468	com/baidu/baidunavis/tts/BdTTSPlayer:mEditor	Landroid/content/SharedPreferences$Editor;
    //   114: ldc_w 470
    //   117: iload 4
    //   119: iconst_1
    //   120: iadd
    //   121: invokeinterface 480 3 0
    //   126: pop
    //   127: aload_0
    //   128: getfield 468	com/baidu/baidunavis/tts/BdTTSPlayer:mEditor	Landroid/content/SharedPreferences$Editor;
    //   131: invokeinterface 483 1 0
    //   136: pop
    //   137: aload_0
    //   138: getfield 394	com/baidu/baidunavis/tts/BdTTSPlayer:ttsplayer	Lcom/baidu/tts/client/SpeechSynthesizer;
    //   141: ifnonnull +101 -> 242
    //   144: aload_0
    //   145: aload_0
    //   146: getfield 740	com/baidu/baidunavis/tts/BdTTSPlayer:ttsPath	Ljava/lang/String;
    //   149: invokespecial 742	com/baidu/baidunavis/tts/BdTTSPlayer:initPlayerInner	(Ljava/lang/String;)Z
    //   152: istore 5
    //   154: aload_0
    //   155: getfield 153	com/baidu/baidunavis/tts/BdTTSPlayer:mSyncObj	Ljava/lang/Object;
    //   158: astore_1
    //   159: aload_1
    //   160: monitorenter
    //   161: aload_0
    //   162: iconst_0
    //   163: putfield 139	com/baidu/baidunavis/tts/BdTTSPlayer:mIsSwitching	Z
    //   166: aload_1
    //   167: monitorexit
    //   168: iload 5
    //   170: istore_3
    //   171: aload_0
    //   172: getfield 147	com/baidu/baidunavis/tts/BdTTSPlayer:mOnTTSVoiceDataSwitchListener	Lcom/baidu/baidunavis/tts/OnTTSVoiceDataSwitchListener;
    //   175: ifnull -166 -> 9
    //   178: aload_0
    //   179: getfield 147	com/baidu/baidunavis/tts/BdTTSPlayer:mOnTTSVoiceDataSwitchListener	Lcom/baidu/baidunavis/tts/OnTTSVoiceDataSwitchListener;
    //   182: iload 5
    //   184: invokeinterface 747 2 0
    //   189: iload 5
    //   191: ireturn
    //   192: aload_0
    //   193: getfield 460	com/baidu/baidunavis/tts/BdTTSPlayer:mPreferences	Landroid/content/SharedPreferences;
    //   196: ldc_w 503
    //   199: iconst_0
    //   200: invokeinterface 474 3 0
    //   205: istore 4
    //   207: aload_0
    //   208: getfield 468	com/baidu/baidunavis/tts/BdTTSPlayer:mEditor	Landroid/content/SharedPreferences$Editor;
    //   211: ldc_w 503
    //   214: iload 4
    //   216: iconst_1
    //   217: iadd
    //   218: invokeinterface 480 3 0
    //   223: pop
    //   224: aload_0
    //   225: getfield 468	com/baidu/baidunavis/tts/BdTTSPlayer:mEditor	Landroid/content/SharedPreferences$Editor;
    //   228: invokeinterface 483 1 0
    //   233: pop
    //   234: goto -97 -> 137
    //   237: astore_2
    //   238: aload_1
    //   239: monitorexit
    //   240: aload_2
    //   241: athrow
    //   242: aload_0
    //   243: getfield 155	com/baidu/baidunavis/tts/BdTTSPlayer:mPlayStateLock	Ljava/lang/Object;
    //   246: astore_1
    //   247: aload_1
    //   248: monitorenter
    //   249: aload_0
    //   250: getfield 131	com/baidu/baidunavis/tts/BdTTSPlayer:mIsTTSPlaying	Z
    //   253: istore 6
    //   255: iload 6
    //   257: ifeq +13 -> 270
    //   260: aload_0
    //   261: getfield 155	com/baidu/baidunavis/tts/BdTTSPlayer:mPlayStateLock	Ljava/lang/Object;
    //   264: ldc2_w 387
    //   267: invokevirtual 392	java/lang/Object:wait	(J)V
    //   270: aload_1
    //   271: monitorexit
    //   272: aload_0
    //   273: getfield 394	com/baidu/baidunavis/tts/BdTTSPlayer:ttsplayer	Lcom/baidu/tts/client/SpeechSynthesizer;
    //   276: invokevirtual 399	com/baidu/tts/client/SpeechSynthesizer:stop	()I
    //   279: pop
    //   280: aload_0
    //   281: getfield 740	com/baidu/baidunavis/tts/BdTTSPlayer:ttsPath	Ljava/lang/String;
    //   284: invokestatic 446	com/baidu/tts/client/SynthesizerTool:verifyModelFile	(Ljava/lang/String;)Z
    //   287: istore 6
    //   289: ldc 65
    //   291: new 163	java/lang/StringBuilder
    //   294: dup
    //   295: invokespecial 164	java/lang/StringBuilder:<init>	()V
    //   298: ldc_w 749
    //   301: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   304: iload 6
    //   306: invokevirtual 380	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   309: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   312: invokestatic 268	com/baidu/baidunavis/tts/BdTTSPlayer:loge	(Ljava/lang/String;Ljava/lang/String;)V
    //   315: iload 6
    //   317: ifeq +576 -> 893
    //   320: aload_0
    //   321: getfield 740	com/baidu/baidunavis/tts/BdTTSPlayer:ttsPath	Ljava/lang/String;
    //   324: ifnull +459 -> 783
    //   327: aload_0
    //   328: getfield 740	com/baidu/baidunavis/tts/BdTTSPlayer:ttsPath	Ljava/lang/String;
    //   331: aload_0
    //   332: getfield 194	com/baidu/baidunavis/tts/BdTTSPlayer:mTtsJinShaVoiceDataPath	Ljava/lang/String;
    //   335: invokevirtual 585	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   338: ifeq +445 -> 783
    //   341: aload_0
    //   342: getfield 394	com/baidu/baidunavis/tts/BdTTSPlayer:ttsplayer	Lcom/baidu/tts/client/SpeechSynthesizer;
    //   345: getstatic 570	com/baidu/tts/client/SpeechSynthesizer:PARAM_SPEED	Ljava/lang/String;
    //   348: ldc_w 587
    //   351: invokevirtual 573	com/baidu/tts/client/SpeechSynthesizer:setParam	(Ljava/lang/String;Ljava/lang/String;)I
    //   354: pop
    //   355: aload_0
    //   356: bipush 8
    //   358: invokevirtual 590	com/baidu/baidunavis/tts/BdTTSPlayer:setCurrentVolume	(I)V
    //   361: aload_0
    //   362: getfield 394	com/baidu/baidunavis/tts/BdTTSPlayer:ttsplayer	Lcom/baidu/tts/client/SpeechSynthesizer;
    //   365: invokevirtual 402	com/baidu/tts/client/SpeechSynthesizer:freeCustomResource	()I
    //   368: pop
    //   369: aload_0
    //   370: getfield 394	com/baidu/baidunavis/tts/BdTTSPlayer:ttsplayer	Lcom/baidu/tts/client/SpeechSynthesizer;
    //   373: aload_0
    //   374: getfield 740	com/baidu/baidunavis/tts/BdTTSPlayer:ttsPath	Ljava/lang/String;
    //   377: aload_2
    //   378: invokevirtual 752	com/baidu/tts/client/SpeechSynthesizer:loadModel	(Ljava/lang/String;Ljava/lang/String;)I
    //   381: istore 4
    //   383: invokestatic 429	com/baidu/navisdk/debug/SDKDebugFileUtil:getInstance	()Lcom/baidu/navisdk/debug/SDKDebugFileUtil;
    //   386: ldc_w 431
    //   389: new 163	java/lang/StringBuilder
    //   392: dup
    //   393: invokespecial 164	java/lang/StringBuilder:<init>	()V
    //   396: ldc_w 754
    //   399: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   402: iload 4
    //   404: invokevirtual 532	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   407: ldc_w 756
    //   410: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   413: aload_0
    //   414: getfield 740	com/baidu/baidunavis/tts/BdTTSPlayer:ttsPath	Ljava/lang/String;
    //   417: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   420: ldc_w 758
    //   423: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   426: aload_2
    //   427: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   430: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   433: invokevirtual 436	com/baidu/navisdk/debug/SDKDebugFileUtil:addCoreLog	(Ljava/lang/String;Ljava/lang/String;)V
    //   436: aload_0
    //   437: invokevirtual 641	com/baidu/baidunavis/tts/BdTTSPlayer:getTTSVoiceDataCustom	()Z
    //   440: istore 6
    //   442: aload_0
    //   443: invokevirtual 644	com/baidu/baidunavis/tts/BdTTSPlayer:getCustomVoiceDataPath	()Ljava/lang/String;
    //   446: astore_1
    //   447: ldc 65
    //   449: new 163	java/lang/StringBuilder
    //   452: dup
    //   453: invokespecial 164	java/lang/StringBuilder:<init>	()V
    //   456: ldc_w 760
    //   459: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   462: iload 6
    //   464: invokevirtual 380	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   467: ldc_w 682
    //   470: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   473: aload_1
    //   474: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   477: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   480: invokestatic 268	com/baidu/baidunavis/tts/BdTTSPlayer:loge	(Ljava/lang/String;Ljava/lang/String;)V
    //   483: iload 6
    //   485: ifeq +134 -> 619
    //   488: aload_1
    //   489: ifnull +130 -> 619
    //   492: aload_1
    //   493: invokevirtual 424	java/lang/String:length	()I
    //   496: ifle +123 -> 619
    //   499: new 180	java/io/File
    //   502: dup
    //   503: aload_1
    //   504: invokespecial 329	java/io/File:<init>	(Ljava/lang/String;)V
    //   507: astore 7
    //   509: aload 7
    //   511: ifnull +14 -> 525
    //   514: aload 7
    //   516: astore_1
    //   517: aload 7
    //   519: invokevirtual 342	java/io/File:exists	()Z
    //   522: ifne +66 -> 588
    //   525: aload 7
    //   527: astore_1
    //   528: aload_0
    //   529: getfield 740	com/baidu/baidunavis/tts/BdTTSPlayer:ttsPath	Ljava/lang/String;
    //   532: ifnull +56 -> 588
    //   535: aload 7
    //   537: astore_1
    //   538: aload_0
    //   539: getfield 740	com/baidu/baidunavis/tts/BdTTSPlayer:ttsPath	Ljava/lang/String;
    //   542: aload_0
    //   543: getfield 198	com/baidu/baidunavis/tts/BdTTSPlayer:mTtsRobinVoiceDataPath	Ljava/lang/String;
    //   546: invokevirtual 585	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   549: ifeq +39 -> 588
    //   552: new 180	java/io/File
    //   555: dup
    //   556: new 163	java/lang/StringBuilder
    //   559: dup
    //   560: invokespecial 164	java/lang/StringBuilder:<init>	()V
    //   563: aload_0
    //   564: getfield 125	com/baidu/baidunavis/tts/BdTTSPlayer:mNormalVoicePath	Ljava/lang/String;
    //   567: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   570: getstatic 183	java/io/File:separator	Ljava/lang/String;
    //   573: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   576: ldc 44
    //   578: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   581: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   584: invokespecial 329	java/io/File:<init>	(Ljava/lang/String;)V
    //   587: astore_1
    //   588: aload_1
    //   589: ifnull +30 -> 619
    //   592: aload_1
    //   593: invokevirtual 342	java/io/File:exists	()Z
    //   596: ifeq +23 -> 619
    //   599: aload_0
    //   600: getfield 394	com/baidu/baidunavis/tts/BdTTSPlayer:ttsplayer	Lcom/baidu/tts/client/SpeechSynthesizer;
    //   603: invokevirtual 402	com/baidu/tts/client/SpeechSynthesizer:freeCustomResource	()I
    //   606: pop
    //   607: aload_0
    //   608: getfield 394	com/baidu/baidunavis/tts/BdTTSPlayer:ttsplayer	Lcom/baidu/tts/client/SpeechSynthesizer;
    //   611: aload_1
    //   612: invokevirtual 651	java/io/File:getPath	()Ljava/lang/String;
    //   615: invokevirtual 654	com/baidu/tts/client/SpeechSynthesizer:loadCustomResource	(Ljava/lang/String;)I
    //   618: pop
    //   619: aload_0
    //   620: aload_2
    //   621: putfield 151	com/baidu/baidunavis/tts/BdTTSPlayer:mCurrentTTSTextPath	Ljava/lang/String;
    //   624: iload 5
    //   626: ifeq +345 -> 971
    //   629: aload_0
    //   630: aconst_null
    //   631: putfield 149	com/baidu/baidunavis/tts/BdTTSPlayer:mCurrentTTSVoiceDataPath	Ljava/lang/String;
    //   634: iload_3
    //   635: ifeq +44 -> 679
    //   638: iload 5
    //   640: ifeq +342 -> 982
    //   643: new 163	java/lang/StringBuilder
    //   646: dup
    //   647: invokespecial 164	java/lang/StringBuilder:<init>	()V
    //   650: aload_0
    //   651: getfield 125	com/baidu/baidunavis/tts/BdTTSPlayer:mNormalVoicePath	Ljava/lang/String;
    //   654: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   657: getstatic 183	java/io/File:separator	Ljava/lang/String;
    //   660: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   663: aload_0
    //   664: getfield 129	com/baidu/baidunavis/tts/BdTTSPlayer:mCurrentSelectPath	Ljava/lang/String;
    //   667: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   670: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   673: astore_1
    //   674: aload_0
    //   675: aload_1
    //   676: invokevirtual 657	com/baidu/baidunavis/tts/BdTTSPlayer:saveTTSVoiceDataPath	(Ljava/lang/String;)V
    //   679: aload_0
    //   680: getfield 153	com/baidu/baidunavis/tts/BdTTSPlayer:mSyncObj	Ljava/lang/Object;
    //   683: astore_1
    //   684: aload_1
    //   685: monitorenter
    //   686: aload_0
    //   687: iconst_0
    //   688: putfield 139	com/baidu/baidunavis/tts/BdTTSPlayer:mIsSwitching	Z
    //   691: aload_1
    //   692: monitorexit
    //   693: aload_0
    //   694: getfield 147	com/baidu/baidunavis/tts/BdTTSPlayer:mOnTTSVoiceDataSwitchListener	Lcom/baidu/baidunavis/tts/OnTTSVoiceDataSwitchListener;
    //   697: ifnull +13 -> 710
    //   700: aload_0
    //   701: getfield 147	com/baidu/baidunavis/tts/BdTTSPlayer:mOnTTSVoiceDataSwitchListener	Lcom/baidu/baidunavis/tts/OnTTSVoiceDataSwitchListener;
    //   704: iconst_1
    //   705: invokeinterface 747 2 0
    //   710: iconst_1
    //   711: ireturn
    //   712: astore_2
    //   713: aload_1
    //   714: monitorexit
    //   715: aload_2
    //   716: athrow
    //   717: astore_2
    //   718: invokestatic 429	com/baidu/navisdk/debug/SDKDebugFileUtil:getInstance	()Lcom/baidu/navisdk/debug/SDKDebugFileUtil;
    //   721: ldc_w 431
    //   724: new 163	java/lang/StringBuilder
    //   727: dup
    //   728: invokespecial 164	java/lang/StringBuilder:<init>	()V
    //   731: ldc_w 762
    //   734: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   737: aload_2
    //   738: invokevirtual 506	java/lang/Throwable:toString	()Ljava/lang/String;
    //   741: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   744: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   747: invokevirtual 436	com/baidu/navisdk/debug/SDKDebugFileUtil:addCoreLog	(Ljava/lang/String;Ljava/lang/String;)V
    //   750: aload_0
    //   751: aconst_null
    //   752: putfield 394	com/baidu/baidunavis/tts/BdTTSPlayer:ttsplayer	Lcom/baidu/tts/client/SpeechSynthesizer;
    //   755: aload_0
    //   756: iconst_0
    //   757: putfield 121	com/baidu/baidunavis/tts/BdTTSPlayer:mInitState	I
    //   760: aload_0
    //   761: getfield 153	com/baidu/baidunavis/tts/BdTTSPlayer:mSyncObj	Ljava/lang/Object;
    //   764: astore_1
    //   765: aload_1
    //   766: monitorenter
    //   767: aload_0
    //   768: iconst_0
    //   769: putfield 139	com/baidu/baidunavis/tts/BdTTSPlayer:mIsSwitching	Z
    //   772: aload_1
    //   773: monitorexit
    //   774: invokestatic 170	com/baidu/baidunavis/NavMapAdapter:getInstance	()Lcom/baidu/baidunavis/NavMapAdapter;
    //   777: aload_2
    //   778: invokevirtual 407	com/baidu/baidunavis/NavMapAdapter:exceptionLog	(Ljava/lang/Throwable;)V
    //   781: iconst_0
    //   782: ireturn
    //   783: aload_0
    //   784: getfield 740	com/baidu/baidunavis/tts/BdTTSPlayer:ttsPath	Ljava/lang/String;
    //   787: ifnull +38 -> 825
    //   790: aload_0
    //   791: getfield 740	com/baidu/baidunavis/tts/BdTTSPlayer:ttsPath	Ljava/lang/String;
    //   794: ldc 38
    //   796: invokevirtual 613	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   799: ifeq +26 -> 825
    //   802: aload_0
    //   803: getfield 394	com/baidu/baidunavis/tts/BdTTSPlayer:ttsplayer	Lcom/baidu/tts/client/SpeechSynthesizer;
    //   806: getstatic 570	com/baidu/tts/client/SpeechSynthesizer:PARAM_SPEED	Ljava/lang/String;
    //   809: ldc_w 615
    //   812: invokevirtual 573	com/baidu/tts/client/SpeechSynthesizer:setParam	(Ljava/lang/String;Ljava/lang/String;)I
    //   815: pop
    //   816: aload_0
    //   817: bipush 8
    //   819: invokevirtual 590	com/baidu/baidunavis/tts/BdTTSPlayer:setCurrentVolume	(I)V
    //   822: goto -461 -> 361
    //   825: aload_0
    //   826: getfield 740	com/baidu/baidunavis/tts/BdTTSPlayer:ttsPath	Ljava/lang/String;
    //   829: ifnull +38 -> 867
    //   832: aload_0
    //   833: getfield 740	com/baidu/baidunavis/tts/BdTTSPlayer:ttsPath	Ljava/lang/String;
    //   836: ldc 35
    //   838: invokevirtual 613	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   841: ifeq +26 -> 867
    //   844: aload_0
    //   845: getfield 394	com/baidu/baidunavis/tts/BdTTSPlayer:ttsplayer	Lcom/baidu/tts/client/SpeechSynthesizer;
    //   848: getstatic 570	com/baidu/tts/client/SpeechSynthesizer:PARAM_SPEED	Ljava/lang/String;
    //   851: ldc_w 617
    //   854: invokevirtual 573	com/baidu/tts/client/SpeechSynthesizer:setParam	(Ljava/lang/String;Ljava/lang/String;)I
    //   857: pop
    //   858: aload_0
    //   859: bipush 7
    //   861: invokevirtual 590	com/baidu/baidunavis/tts/BdTTSPlayer:setCurrentVolume	(I)V
    //   864: goto -503 -> 361
    //   867: aload_0
    //   868: getfield 394	com/baidu/baidunavis/tts/BdTTSPlayer:ttsplayer	Lcom/baidu/tts/client/SpeechSynthesizer;
    //   871: getstatic 570	com/baidu/tts/client/SpeechSynthesizer:PARAM_SPEED	Ljava/lang/String;
    //   874: aload_0
    //   875: iload 5
    //   877: invokespecial 567	com/baidu/baidunavis/tts/BdTTSPlayer:getInitPlaySpeed	(Z)Ljava/lang/String;
    //   880: invokevirtual 573	com/baidu/tts/client/SpeechSynthesizer:setParam	(Ljava/lang/String;Ljava/lang/String;)I
    //   883: pop
    //   884: aload_0
    //   885: bipush 7
    //   887: invokevirtual 590	com/baidu/baidunavis/tts/BdTTSPlayer:setCurrentVolume	(I)V
    //   890: goto -529 -> 361
    //   893: invokestatic 429	com/baidu/navisdk/debug/SDKDebugFileUtil:getInstance	()Lcom/baidu/navisdk/debug/SDKDebugFileUtil;
    //   896: ldc_w 431
    //   899: ldc_w 764
    //   902: invokevirtual 436	com/baidu/navisdk/debug/SDKDebugFileUtil:addCoreLog	(Ljava/lang/String;Ljava/lang/String;)V
    //   905: ldc 65
    //   907: new 163	java/lang/StringBuilder
    //   910: dup
    //   911: invokespecial 164	java/lang/StringBuilder:<init>	()V
    //   914: ldc_w 766
    //   917: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   920: aload_0
    //   921: getfield 740	com/baidu/baidunavis/tts/BdTTSPlayer:ttsPath	Ljava/lang/String;
    //   924: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   927: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   930: invokestatic 268	com/baidu/baidunavis/tts/BdTTSPlayer:loge	(Ljava/lang/String;Ljava/lang/String;)V
    //   933: aload_0
    //   934: getfield 153	com/baidu/baidunavis/tts/BdTTSPlayer:mSyncObj	Ljava/lang/Object;
    //   937: astore_1
    //   938: aload_1
    //   939: monitorenter
    //   940: aload_0
    //   941: iconst_0
    //   942: putfield 139	com/baidu/baidunavis/tts/BdTTSPlayer:mIsSwitching	Z
    //   945: aload_1
    //   946: monitorexit
    //   947: aload_0
    //   948: getfield 147	com/baidu/baidunavis/tts/BdTTSPlayer:mOnTTSVoiceDataSwitchListener	Lcom/baidu/baidunavis/tts/OnTTSVoiceDataSwitchListener;
    //   951: ifnull +13 -> 964
    //   954: aload_0
    //   955: getfield 147	com/baidu/baidunavis/tts/BdTTSPlayer:mOnTTSVoiceDataSwitchListener	Lcom/baidu/baidunavis/tts/OnTTSVoiceDataSwitchListener;
    //   958: iconst_0
    //   959: invokeinterface 747 2 0
    //   964: iconst_0
    //   965: ireturn
    //   966: astore_2
    //   967: aload_1
    //   968: monitorexit
    //   969: aload_2
    //   970: athrow
    //   971: aload_0
    //   972: aload_0
    //   973: getfield 740	com/baidu/baidunavis/tts/BdTTSPlayer:ttsPath	Ljava/lang/String;
    //   976: putfield 149	com/baidu/baidunavis/tts/BdTTSPlayer:mCurrentTTSVoiceDataPath	Ljava/lang/String;
    //   979: goto -345 -> 634
    //   982: aload_0
    //   983: getfield 740	com/baidu/baidunavis/tts/BdTTSPlayer:ttsPath	Ljava/lang/String;
    //   986: astore_1
    //   987: goto -313 -> 674
    //   990: astore_2
    //   991: aload_1
    //   992: monitorexit
    //   993: aload_2
    //   994: athrow
    //   995: astore_2
    //   996: aload_1
    //   997: monitorexit
    //   998: aload_2
    //   999: athrow
    //   1000: astore 7
    //   1002: goto -732 -> 270
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1005	0	this	BdTTSPlayer
    //   0	1005	2	paramString2	String
    //   0	1005	3	paramBoolean	boolean
    //   108	295	4	i	int
    //   17	859	5	bool1	boolean
    //   253	231	6	bool2	boolean
    //   507	29	7	localFile	File
    //   1000	1	7	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   161	168	237	finally
    //   238	240	237	finally
    //   249	255	712	finally
    //   260	270	712	finally
    //   270	272	712	finally
    //   713	715	712	finally
    //   242	249	717	java/lang/Throwable
    //   272	315	717	java/lang/Throwable
    //   320	361	717	java/lang/Throwable
    //   361	483	717	java/lang/Throwable
    //   492	509	717	java/lang/Throwable
    //   517	525	717	java/lang/Throwable
    //   528	535	717	java/lang/Throwable
    //   538	588	717	java/lang/Throwable
    //   592	619	717	java/lang/Throwable
    //   619	624	717	java/lang/Throwable
    //   629	634	717	java/lang/Throwable
    //   643	674	717	java/lang/Throwable
    //   674	679	717	java/lang/Throwable
    //   679	686	717	java/lang/Throwable
    //   693	710	717	java/lang/Throwable
    //   715	717	717	java/lang/Throwable
    //   783	822	717	java/lang/Throwable
    //   825	864	717	java/lang/Throwable
    //   867	890	717	java/lang/Throwable
    //   893	940	717	java/lang/Throwable
    //   947	964	717	java/lang/Throwable
    //   969	971	717	java/lang/Throwable
    //   971	979	717	java/lang/Throwable
    //   982	987	717	java/lang/Throwable
    //   993	995	717	java/lang/Throwable
    //   940	947	966	finally
    //   967	969	966	finally
    //   686	693	990	finally
    //   991	993	990	finally
    //   767	774	995	finally
    //   996	998	995	finally
    //   260	270	1000	java/lang/Exception
  }
  
  public boolean canSwitchVoice()
  {
    if (this.mHandler == null) {}
    while (this.mContext == null) {
      return false;
    }
    synchronized (this.mSyncObj)
    {
      if (this.mIsSwitching) {
        return false;
      }
    }
    return true;
  }
  
  /* Error */
  public int cancelAudio()
  {
    // Byte code:
    //   0: ldc 65
    //   2: ldc_w 769
    //   5: invokestatic 268	com/baidu/baidunavis/tts/BdTTSPlayer:loge	(Ljava/lang/String;Ljava/lang/String;)V
    //   8: iconst_m1
    //   9: istore_2
    //   10: iload_2
    //   11: istore_1
    //   12: aload_0
    //   13: getfield 161	com/baidu/baidunavis/tts/BdTTSPlayer:mMediaPlayer	Landroid/media/MediaPlayer;
    //   16: ifnull +34 -> 50
    //   19: aload_0
    //   20: getfield 161	com/baidu/baidunavis/tts/BdTTSPlayer:mMediaPlayer	Landroid/media/MediaPlayer;
    //   23: invokevirtual 774	android/media/MediaPlayer:isPlaying	()Z
    //   26: ifeq +10 -> 36
    //   29: aload_0
    //   30: getfield 161	com/baidu/baidunavis/tts/BdTTSPlayer:mMediaPlayer	Landroid/media/MediaPlayer;
    //   33: invokevirtual 776	android/media/MediaPlayer:stop	()V
    //   36: aload_0
    //   37: getfield 161	com/baidu/baidunavis/tts/BdTTSPlayer:mMediaPlayer	Landroid/media/MediaPlayer;
    //   40: invokevirtual 779	android/media/MediaPlayer:release	()V
    //   43: aload_0
    //   44: aconst_null
    //   45: putfield 161	com/baidu/baidunavis/tts/BdTTSPlayer:mMediaPlayer	Landroid/media/MediaPlayer;
    //   48: iconst_0
    //   49: istore_1
    //   50: aload_0
    //   51: getfield 155	com/baidu/baidunavis/tts/BdTTSPlayer:mPlayStateLock	Ljava/lang/Object;
    //   54: astore_3
    //   55: aload_3
    //   56: monitorenter
    //   57: aload_0
    //   58: iconst_0
    //   59: putfield 133	com/baidu/baidunavis/tts/BdTTSPlayer:mIsAudioPlaying	Z
    //   62: aload_3
    //   63: monitorexit
    //   64: iload_1
    //   65: ireturn
    //   66: astore_3
    //   67: ldc 65
    //   69: ldc_w 781
    //   72: invokestatic 268	com/baidu/baidunavis/tts/BdTTSPlayer:loge	(Ljava/lang/String;Ljava/lang/String;)V
    //   75: iload_2
    //   76: istore_1
    //   77: goto -27 -> 50
    //   80: astore 4
    //   82: aload_3
    //   83: monitorexit
    //   84: aload 4
    //   86: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	87	0	this	BdTTSPlayer
    //   11	66	1	i	int
    //   9	67	2	j	int
    //   66	17	3	localException	Exception
    //   80	5	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   19	36	66	java/lang/Exception
    //   36	48	66	java/lang/Exception
    //   57	64	80	finally
    //   82	84	80	finally
  }
  
  public void dospeak(String paramString)
  {
    dospeak(paramString, null);
  }
  
  public void dospeak(String arg1, String paramString2)
  {
    if (this.ttsplayer == null) {
      SDKDebugFileUtil.getInstance().addCoreLog("CoreLog_TTS: ", " BdTTSPlayer dospeak ttsplayer == null ");
    }
    for (;;)
    {
      return;
      synchronized (this.mPlayStateLock)
      {
        this.mIsTTSPlaying = true;
        try
        {
          int i = this.ttsplayer.speak(???);
          TTSPlayerControl.setTTSTextPlayResult(paramString2);
          loge("BdTTSPlayer", "dospeak() ret=" + i + ", speech=" + ???);
          if (i == 0) {
            continue;
          }
          SDKDebugFileUtil.getInstance().addCoreLog("CoreLog_TTS: ", " BdTTSPlayer dospeak ret=" + i + ", speech=" + ???);
          return;
        }
        catch (Throwable ???)
        {
          SDKDebugFileUtil.getInstance().addCoreLog("CoreLog_TTS: ", " BdTTSPlayer dospeak Throwable " + ???.getMessage());
          Log.e("BdTTSPlayer", "dospeak Exception:" + ???.getMessage());
          synchronized (this.mPlayStateLock)
          {
            this.mIsTTSPlaying = false;
            return;
          }
        }
      }
    }
  }
  
  public boolean freeCustomTTSVoice(String paramString, OnTTSVoiceDataSwitchListener paramOnTTSVoiceDataSwitchListener)
  {
    if (this.mInitState == 0) {
      Log.e("BdTTSPlayer", "freeCustomTTSVoice fail state:" + this.mInitState);
    }
    while (this.mHandler == null) {
      return false;
    }
    this.mHandler.obtainMessage(6).sendToTarget();
    return true;
  }
  
  public int getCurrentProgress()
  {
    return this.mCurrentProgress;
  }
  
  public String getCurrentTTSVoiceDataPath()
  {
    return this.mCurrentTTSVoiceDataPath;
  }
  
  public int getCurrentVolume()
  {
    return this.mCurrentVolume;
  }
  
  public String getCustomVoiceDataPath()
  {
    Object localObject2;
    if (this.mContext == null) {
      localObject2 = null;
    }
    Object localObject1;
    for (;;)
    {
      return (String)localObject2;
      localObject1 = this.mContext.getSharedPreferences("_navi_sdk_tts_custom_path_", 0);
      if (localObject1 == null) {
        return null;
      }
      String str1 = ((SharedPreferences)localObject1).getString("_navi_sdk_tts_custom_path_", "");
      if ((str1 == null) || (str1.length() == 0)) {
        return null;
      }
      localObject1 = str1;
      try
      {
        String str2 = StorageSettings.getInstance().getCurrentStorage().getRootPath();
        localObject2 = str1;
        localObject1 = str1;
        if (!str1.startsWith(str2))
        {
          localObject1 = str1;
          localObject2 = str1.substring(str1.indexOf(File.separator + "BaiduCarlife"));
          localObject1 = localObject2;
          localObject2 = str2 + (String)localObject2;
          return (String)localObject2;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    return (String)localObject1;
  }
  
  public int getInitState()
  {
    return this.mInitState;
  }
  
  public String getLastTTSVoiceDataPath()
  {
    Object localObject3;
    if (this.mContext == null) {
      localObject3 = null;
    }
    Object localObject2;
    do
    {
      do
      {
        return (String)localObject3;
        SharedPreferences localSharedPreferences = this.mContext.getSharedPreferences("_navi_sdk_pres_", 0);
        if (localSharedPreferences == null) {
          return null;
        }
        String str1 = localSharedPreferences.getString("tts_voice_data_path", "");
        if ((str1 == null) || (str1.length() == 0)) {
          return null;
        }
        localObject3 = str1;
        try
        {
          String str2 = StorageSettings.getInstance().getCurrentStorage().getRootPath();
          localObject3 = str1;
          NavLogUtils.e("BdTTSPlayer", "getLastTTSVoiceDataPath() path:" + str1 + ", sdcardrRootPath:" + str2);
          localObject1 = str1;
          localObject3 = str1;
          if (!str1.startsWith(str2))
          {
            localObject3 = str1;
            localObject1 = str1.substring(str1.indexOf(File.separator + "BaiduCarlife"));
            localObject3 = localObject1;
            localObject1 = str2 + (String)localObject1;
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            Object localObject1;
            localException.printStackTrace();
            localObject2 = localObject3;
          }
          ((SharedPreferences.Editor)localObject2).putString("tts_voice_data_path", "");
          ((SharedPreferences.Editor)localObject2).commit();
          return null;
        }
        if (((String)localObject1).contains("/BaiduCarlife/tts/"))
        {
          NavLogUtils.e("BdTTSPlayer", "getLastTTSVoiceDataPath() contains old map mengmengda");
          localObject1 = localSharedPreferences.edit();
          if (localObject1 == null) {
            return null;
          }
        }
        localObject3 = localObject2;
      } while (((String)localObject2).contains("bd_etts_common_speech_f7_mand_eng_high_am-mix_v3.0.0_20170512.dat"));
      localObject3 = localObject2;
    } while (((String)localObject2).contains("bd_etts_common_speech_taiwan_mand_eng_high_am-mgc_v3.0.0_20170807.dat"));
    return null;
  }
  
  public int getTTSState()
  {
    if (this.ttsplayer == null)
    {
      SDKDebugFileUtil.getInstance().addCoreLog("CoreLog_TTS: ", " BdTTSPlayer getTTSState !is");
      return 0;
    }
    for (;;)
    {
      int i;
      synchronized (this.mPlayStateLock)
      {
        if (this.isTimeOutEnable)
        {
          if ((this.mIsTTSPlaying) && (!this.mIsPausing)) {
            break label260;
          }
          if (this.mHandler.hasMessages(5)) {
            this.mHandler.removeMessages(5);
          }
        }
        if (!this.mIsPausing) {
          break label286;
        }
        i = 3;
        if (SDKDebugFileUtil.getInstance().isShowCoreLog(3, 0, i, null, null)) {
          SDKDebugFileUtil.getInstance().addCoreLog("CoreLog_TTS: ", " BaseTTSPlayer getTTSState mTmpTTSState: " + i + ", mIsTTSPlaying: " + this.mIsTTSPlaying + ", mIsAudioPlaying: " + this.mIsAudioPlaying + ", mIsPausing: " + this.mIsPausing + ", isTimeOutEnable: " + this.isTimeOutEnable);
        }
        loge("BdTTSPlayer", "TTSState: " + i + ", mIsTTSPlaying: " + this.mIsTTSPlaying + ", mIsAudioPlaying: " + this.mIsAudioPlaying + ", mIsPausing: " + this.mIsPausing + ", isTimeOutEnable: " + this.isTimeOutEnable);
        return i;
      }
      label260:
      if (!this.mHandler.hasMessages(5))
      {
        this.mHandler.sendEmptyMessageDelayed(5, 20000L);
        continue;
        label286:
        if (!this.mIsTTSPlaying)
        {
          boolean bool = this.mIsAudioPlaying;
          if (!bool)
          {
            i = 1;
            continue;
          }
        }
        i = 2;
      }
    }
  }
  
  public boolean getTTSVoiceDataCustom()
  {
    if (this.mContext == null) {}
    SharedPreferences localSharedPreferences;
    do
    {
      return false;
      localSharedPreferences = this.mContext.getSharedPreferences("_navi_sdk_tts_custom_", 0);
    } while (localSharedPreferences == null);
    return localSharedPreferences.getBoolean("_navi_sdk_tts_custom_", false);
  }
  
  public boolean getVoiceState()
  {
    return this.mVoiceing;
  }
  
  public void initPlayer(Context paramContext, String paramString)
  {
    if ((paramContext == null) || (paramString == null) || (paramString.length() == 0) || (this.mInitState != 0) || (!NavCommonFuncModel.isNeonCpuFeature()))
    {
      SDKDebugFileUtil.getInstance().addCoreLog("CoreLog_TTS: ", " BdTTSPlayer initPlayer 1111: ");
      return;
    }
    this.mInitState = 1;
    this.mContext = paramContext.getApplicationContext();
    this.mSDCardAPPBasePath = paramString;
    this.mNormalVoicePath = paramContext.getDir("tts", 0).getPath();
    makesureDirs();
    if (copyRes())
    {
      initPlayerInner(getLastTTSVoiceDataPath());
      return;
    }
    SDKDebugFileUtil.getInstance().addCoreLog("CoreLog_TTS: ", " BdTTSPlayer initPlayer 2222: ");
    this.mInitState = 0;
  }
  
  public boolean isJinshaTTS()
  {
    return (this.ttsPath != null) && (this.ttsPath.equals(this.mTtsJinShaVoiceDataPath));
  }
  
  public boolean isNaviMute()
  {
    return this.mIsNaviMute;
  }
  
  public boolean loadCustomResource(String paramString)
  {
    if (this.mContext != null)
    {
      saveCustomVoiceDataPath(paramString);
      return true;
    }
    return false;
  }
  
  public boolean loadCustomTTSVoice(String paramString, OnTTSVoiceDataSwitchListener paramOnTTSVoiceDataSwitchListener)
  {
    if (this.mInitState == 0) {
      Log.e("BdTTSPlayer", "loadCustomTTSVoice fail state:" + this.mInitState);
    }
    while (this.mHandler == null) {
      return false;
    }
    this.mHandler.obtainMessage(7).sendToTarget();
    return true;
  }
  
  public int pauseTTS()
  {
    loge("BdTTSPlayer", "pauseTTS");
    if (this.ttsplayer != null) {
      synchronized (this.mPlayStateLock)
      {
        this.mIsPausing = true;
        return this.ttsplayer.pause();
      }
    }
    return -1;
  }
  
  public int playAudio(String paramString, final IBNTTSPlayerListener.AudioPlayerListener paramAudioPlayerListener)
  {
    loge("BdTTSPlayer", "playAudio");
    if (BNSettingManager.getVoiceMode() == 2)
    {
      loge("BdTTSPlayer", "voice mode is Quite, return");
      return 0;
    }
    if ((paramString == null) || (TextUtils.isEmpty(paramString)))
    {
      loge("BdTTSPlayer", "audioPath is null or empty");
      return -1;
    }
    synchronized (this.mPlayStateLock)
    {
      this.mIsAudioPlaying = true;
      try
      {
        if (this.mMediaPlayer == null) {
          this.mMediaPlayer = new MediaPlayer();
        }
        this.mMediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener()
        {
          public void onPrepared(MediaPlayer paramAnonymousMediaPlayer)
          {
            BdTTSPlayer.this.mMediaPlayer.start();
          }
        });
        this.mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener()
        {
          public void onCompletion(MediaPlayer paramAnonymousMediaPlayer)
          {
            if (paramAudioPlayerListener != null) {
              paramAudioPlayerListener.playCompletion();
            }
          }
        });
        this.mMediaPlayer.setDataSource(paramString);
        this.mMediaPlayer.prepareAsync();
        return 0;
      }
      catch (Exception paramString)
      {
        loge("BdTTSPlayer", "playAudio exception");
        cancelAudio();
        return -1;
      }
    }
  }
  
  public int playTTSText(String paramString, int paramInt)
  {
    return playTTSText(paramString, null, paramInt);
  }
  
  public int playTTSText(String paramString1, String paramString2, int paramInt)
  {
    if ((this.mVoiceing) || (this.mIsNaviMute)) {
      return 0;
    }
    return playTTSTextImp(paramString1, paramString2, paramInt);
  }
  
  public int playVoiceTTSText(String paramString, int paramInt)
  {
    return playTTSTextImp(paramString, null, paramInt);
  }
  
  public int playWeChatTTSText(String paramString, int paramInt)
  {
    if (this.mVoiceing) {
      return 0;
    }
    return playTTSTextImp(paramString, null, paramInt);
  }
  
  public boolean recoveryToNavVoice()
  {
    loge("BdTTSPlayer", "recoveryToNavVoice state:" + this.mInitState);
    if (this.mInitState != 2) {
      return false;
    }
    String str = getLastTTSVoiceDataPath();
    int i;
    if (TextUtils.isEmpty(this.mCurrentTTSVoiceDataPath)) {
      if (TextUtils.isEmpty(str))
      {
        i = 0;
        if (TextUtils.isEmpty(this.mCurrentTTSTextPath)) {
          break label117;
        }
      }
    }
    label117:
    for (int j = 1;; j = 0)
    {
      if ((i == 0) && (j == 0)) {
        break label122;
      }
      return switchTTSVoiceDataAsync(str, null, true, null);
      i = 1;
      break;
      if (this.mCurrentTTSVoiceDataPath.equals(str))
      {
        i = 0;
        break;
      }
      i = 1;
      break;
    }
    label122:
    if ((TextUtils.isEmpty(str)) || (str.equals(this.mTtsJinShaVoiceDataPath)))
    {
      loge("BdTTSPlayer", "recover speed = 6");
      setPlaySpeed(6);
    }
    for (;;)
    {
      loge("BdTTSPlayer", "recoveryToNavVoice no need");
      return true;
      i = BNSettingManager.getTTSSpeedParam();
      loge("BdTTSPlayer", "recover speed = " + i);
      setPlaySpeed(i);
    }
  }
  
  public void releaseTTSPlayer()
  {
    loge("BdTTSPlayer", "releaseTTSPlayer");
    stopTTS();
  }
  
  public int resumeTTS()
  {
    loge("BdTTSPlayer", "resumeTTS");
    if (this.ttsplayer != null) {
      synchronized (this.mPlayStateLock)
      {
        this.mIsPausing = false;
        return this.ttsplayer.resume();
      }
    }
    return -1;
  }
  
  public void saveTTSVoiceDataPath(String paramString)
  {
    if ((this.mContext == null) || (paramString == null)) {}
    Object localObject;
    do
    {
      do
      {
        return;
        localObject = this.mContext.getSharedPreferences("_navi_sdk_pres_", 0);
      } while (localObject == null);
      localObject = ((SharedPreferences)localObject).edit();
    } while (localObject == null);
    ((SharedPreferences.Editor)localObject).putString("tts_voice_data_path", paramString);
    ((SharedPreferences.Editor)localObject).commit();
  }
  
  public void setBNTTSPlayerStatusChangedWeChat(IBNTTSPlayerWeChatListener paramIBNTTSPlayerWeChatListener)
  {
    this.mIBNTTSPlayerWeChatListener = paramIBNTTSPlayerWeChatListener;
  }
  
  public void setCurrentSelectPath(String paramString)
  {
    this.mCurrentSelectPath = paramString;
  }
  
  public void setCurrentVolume(int paramInt)
  {
    this.mCurrentVolume = paramInt;
    if (this.ttsplayer != null) {
      this.ttsplayer.setParam(SpeechSynthesizer.PARAM_VOLUME, String.valueOf(paramInt));
    }
  }
  
  public boolean setCustomParams(boolean paramBoolean)
  {
    if (this.mContext != null)
    {
      saveTTSVoiceDataCustom(paramBoolean);
      return true;
    }
    return false;
  }
  
  public void setEnableTimeOut(boolean paramBoolean)
  {
    this.isTimeOutEnable = paramBoolean;
    if ((!this.isTimeOutEnable) && (this.mHandler != null) && (this.mHandler.hasMessages(5))) {
      this.mHandler.removeMessages(5);
    }
  }
  
  public void setIBNTTSPlayerPCMListener(IBNTTSPlayerPCMListener paramIBNTTSPlayerPCMListener)
  {
    this.mIBNTTSPlayerPCMListener = paramIBNTTSPlayerPCMListener;
  }
  
  public void setIBNTTSVoiceHintListener(IBNTTSVoiceHintListener paramIBNTTSVoiceHintListener)
  {
    this.mIBNTTSVoiceHintListener = paramIBNTTSVoiceHintListener;
  }
  
  public void setNaviMute(boolean paramBoolean)
  {
    boolean bool = false;
    if (!paramBoolean) {}
    for (this.mIsNaviMute = false;; this.mIsNaviMute = paramBoolean)
    {
      if ((this.mIsNaviMute) && (!this.mVoiceing)) {
        stopTTS();
      }
      return;
      paramBoolean = bool;
      if (!this.mIsNaviMute) {
        paramBoolean = true;
      }
    }
  }
  
  public void setOnTTSStateChangedListener(OnTTSStateChangedListener paramOnTTSStateChangedListener)
  {
    this.mOnTTSStateChangedListener = paramOnTTSStateChangedListener;
  }
  
  public void setPhoneIn(boolean paramBoolean)
  {
    this.mPhoneIn = paramBoolean;
  }
  
  public int setPlaySpeed(int paramInt)
  {
    NavLogUtils.e("BdTTSPlayer", "setPlaySpeed() set7.speed=" + paramInt);
    try
    {
      if (this.ttsplayer != null)
      {
        String str = getInitPlaySpeed(true);
        if ((paramInt < 0) || (paramInt > 9))
        {
          NavLogUtils.e("BdTTSPlayer", "setPlaySpeed() set8.speed=" + str);
          return this.ttsplayer.setParam(SpeechSynthesizer.PARAM_SPEED, str);
        }
        NavLogUtils.e("BdTTSPlayer", "setPlaySpeed() set9.speed=" + String.valueOf(paramInt));
        paramInt = this.ttsplayer.setParam(SpeechSynthesizer.PARAM_SPEED, String.valueOf(paramInt));
        return paramInt;
      }
    }
    catch (Exception localException) {}
    return -1;
  }
  
  public int setStereoVolume(float paramFloat1, float paramFloat2)
  {
    if (this.ttsplayer == null) {
      return 0;
    }
    return this.ttsplayer.setStereoVolume(paramFloat1, paramFloat2);
  }
  
  public void setTTSStreamType(int paramInt)
  {
    if (this.ttsplayer != null) {
      this.ttsplayer.setAudioStreamType(paramInt);
    }
  }
  
  public boolean setTTSVoiceDataPath(String paramString)
  {
    if (this.mContext == null) {
      return false;
    }
    int i = 0;
    try
    {
      this.mPreferences = this.mContext.getSharedPreferences("map_asr_pre", 0);
      this.mEditor = this.mPreferences.edit();
      int j;
      if ((paramString == null) || (paramString.length() == 0))
      {
        i = 1;
        j = this.mPreferences.getInt("asr_normal", 0);
        this.mEditor.putInt("asr_normal", j + 1);
        this.mEditor.commit();
      }
      while (i != 0)
      {
        saveTTSVoiceDataPath("");
        break label154;
        j = this.mPreferences.getInt("asr_maidou", 0);
        this.mEditor.putInt("asr_maidou", j + 1);
        this.mEditor.commit();
      }
      saveTTSVoiceDataPath(paramString);
      label154:
      return true;
    }
    catch (Throwable paramString) {}
    return false;
  }
  
  public void setVoiceState(boolean paramBoolean)
  {
    this.mVoiceing = paramBoolean;
  }
  
  /* Error */
  public void stopTTS()
  {
    // Byte code:
    //   0: ldc 65
    //   2: ldc_w 1029
    //   5: invokestatic 268	com/baidu/baidunavis/tts/BdTTSPlayer:loge	(Ljava/lang/String;Ljava/lang/String;)V
    //   8: aload_0
    //   9: getfield 208	com/baidu/baidunavis/tts/BdTTSPlayer:mVoiceing	Z
    //   12: ifeq +12 -> 24
    //   15: ldc 65
    //   17: ldc_w 1031
    //   20: invokestatic 268	com/baidu/baidunavis/tts/BdTTSPlayer:loge	(Ljava/lang/String;Ljava/lang/String;)V
    //   23: return
    //   24: aload_0
    //   25: getfield 394	com/baidu/baidunavis/tts/BdTTSPlayer:ttsplayer	Lcom/baidu/tts/client/SpeechSynthesizer;
    //   28: ifnull -5 -> 23
    //   31: aload_0
    //   32: getfield 155	com/baidu/baidunavis/tts/BdTTSPlayer:mPlayStateLock	Ljava/lang/Object;
    //   35: astore_1
    //   36: aload_1
    //   37: monitorenter
    //   38: aload_0
    //   39: iconst_0
    //   40: putfield 131	com/baidu/baidunavis/tts/BdTTSPlayer:mIsTTSPlaying	Z
    //   43: aload_0
    //   44: iconst_0
    //   45: putfield 135	com/baidu/baidunavis/tts/BdTTSPlayer:mIsPausing	Z
    //   48: aload_1
    //   49: monitorexit
    //   50: invokestatic 1034	com/baidu/baidunavis/model/NavCommonFuncModel:getInstance	()Lcom/baidu/baidunavis/model/NavCommonFuncModel;
    //   53: invokevirtual 1037	com/baidu/baidunavis/model/NavCommonFuncModel:getContext	()Landroid/content/Context;
    //   56: astore_1
    //   57: aload_1
    //   58: ifnull +8 -> 66
    //   61: aload_1
    //   62: invokestatic 1042	com/baidu/baidunavis/tts/AudioUtils:releaseAudioFocus	(Landroid/content/Context;)Z
    //   65: pop
    //   66: aload_0
    //   67: getfield 394	com/baidu/baidunavis/tts/BdTTSPlayer:ttsplayer	Lcom/baidu/tts/client/SpeechSynthesizer;
    //   70: invokevirtual 399	com/baidu/tts/client/SpeechSynthesizer:stop	()I
    //   73: pop
    //   74: invokestatic 1048	com/baidu/carlife/util/u:a	()Lcom/baidu/carlife/util/u;
    //   77: invokevirtual 1051	com/baidu/carlife/util/u:c	()V
    //   80: aload_0
    //   81: getfield 234	com/baidu/baidunavis/tts/BdTTSPlayer:mIBNTTSPlayerWeChatListener	Lcom/baidu/baidunavis/tts/IBNTTSPlayerWeChatListener;
    //   84: ifnull -61 -> 23
    //   87: aload_0
    //   88: getfield 234	com/baidu/baidunavis/tts/BdTTSPlayer:mIBNTTSPlayerWeChatListener	Lcom/baidu/baidunavis/tts/IBNTTSPlayerWeChatListener;
    //   91: invokeinterface 1056 1 0
    //   96: return
    //   97: astore_1
    //   98: return
    //   99: astore_2
    //   100: aload_1
    //   101: monitorexit
    //   102: aload_2
    //   103: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	104	0	this	BdTTSPlayer
    //   97	4	1	localThrowable	Throwable
    //   99	4	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   24	38	97	java/lang/Throwable
    //   50	57	97	java/lang/Throwable
    //   61	66	97	java/lang/Throwable
    //   66	96	97	java/lang/Throwable
    //   102	104	97	java/lang/Throwable
    //   38	50	99	finally
    //   100	102	99	finally
  }
  
  public void stopTTSVR()
  {
    loge("BdTTSPlayer", "stopTTSVR");
    try
    {
      if (this.ttsplayer != null) {}
      synchronized (this.mPlayStateLock)
      {
        this.mIsTTSPlaying = false;
        this.mIsPausing = false;
        ??? = NavCommonFuncModel.getInstance().getContext();
        if (??? != null) {
          AudioUtils.releaseAudioFocus((Context)???);
        }
        this.ttsplayer.stop();
        u.a().d();
        if (this.mIBNTTSPlayerWeChatListener != null) {
          this.mIBNTTSPlayerWeChatListener.notifyTTSInterrupt();
        }
        return;
      }
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public void stopTTSWX()
  {
    loge("BdTTSPlayer", "stopTTSWX");
    try
    {
      if (this.ttsplayer != null) {}
      synchronized (this.mPlayStateLock)
      {
        this.mIsTTSPlaying = false;
        this.mIsPausing = false;
        this.ttsplayer.stop();
        u.a().c();
        return;
      }
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public boolean switchTTSVoiceDataAsync(String paramString1, String paramString2, boolean paramBoolean, OnTTSVoiceDataSwitchListener paramOnTTSVoiceDataSwitchListener)
  {
    return switchTTSVoiceData(paramString1, paramString2, paramBoolean, paramOnTTSVoiceDataSwitchListener, true);
  }
  
  public boolean switchTTSVoiceDataSync(String paramString1, String paramString2, boolean paramBoolean)
  {
    return switchTTSVoiceData(paramString1, paramString2, paramBoolean, null, false);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/baidunavis/tts/BdTTSPlayer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */