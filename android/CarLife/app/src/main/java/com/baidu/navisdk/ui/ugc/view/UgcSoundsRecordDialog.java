package com.baidu.navisdk.ui.ugc.view;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.media.MediaRecorder;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.comapi.tts.TTSPlayerControl;
import com.baidu.navisdk.module.business.BusinessActivityPlayerManager;
import com.baidu.navisdk.ui.routeguide.asr.xdvoice.XDVoiceInstructManager;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.common.SysOSAPI;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.navisdk.util.listener.MediaFocuseChangeListener;
import java.util.Timer;
import java.util.TimerTask;

public class UgcSoundsRecordDialog
  extends Dialog
{
  public static final String SOUNDS_TEMP_FILE_PATH = SysOSAPI.getInstance().GetSDCardCachePath() + "/ugc_sounds_temp.amr";
  private static final String TAG = UgcSoundsRecordDialog.class.getName();
  private static final int TIME_COUNT_SUM = 20;
  private static final int WHAT_RECORD_STOP = 1000;
  private static UgcSoundsRecordDialog mUgcSoundsRecordDialog = null;
  private boolean isRecording = false;
  private TextView leftTimeTView = null;
  private onUgcSoundsRecordCallback mOnUgcSoundsRecordCallback;
  private MediaRecorder mRecorder;
  private RotateAnimation mRoateAnimation;
  private Timer mTimer;
  private ImageView recordProcessIView = null;
  private TextView startOrStopRecordTView = null;
  private ImageView startRecordIView = null;
  private int timeCount = 0;
  private int timeCountTime = 20;
  private Handler timeHandler = new Handler(Looper.getMainLooper())
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      if (!UgcSoundsRecordDialog.this.isRecording) {}
      int j;
      do
      {
        return;
        if (paramAnonymousMessage.what == 1000)
        {
          UgcSoundsRecordDialog.this.stopRecord();
          return;
        }
        j = paramAnonymousMessage.what;
        UgcSoundsRecordDialog.access$408(UgcSoundsRecordDialog.this);
        if (UgcSoundsRecordDialog.this.timeCount > 3) {
          UgcSoundsRecordDialog.access$402(UgcSoundsRecordDialog.this, 1);
        }
        paramAnonymousMessage = "";
        int i = 0;
        while (i < UgcSoundsRecordDialog.this.timeCount)
        {
          paramAnonymousMessage = paramAnonymousMessage + ".";
          i += 1;
        }
      } while ((UgcSoundsRecordDialog.this.titleTView == null) || (UgcSoundsRecordDialog.this.leftTimeTView == null));
      UgcSoundsRecordDialog.this.titleTView.setText(JarUtils.getResources().getString(1711670190) + paramAnonymousMessage);
      UgcSoundsRecordDialog.this.leftTimeTView.setText("剩下" + j + "\"");
    }
  };
  private TextView titleTView = null;
  
  public UgcSoundsRecordDialog(Context paramContext)
  {
    super(paramContext);
    mUgcSoundsRecordDialog = this;
    Object localObject = JarUtils.getResources().newTheme();
    ((Resources.Theme)localObject).applyStyle(1711996937, true);
    JarUtils.setDialogThemeField(this, (Resources.Theme)localObject);
    paramContext = JarUtils.inflate((Activity)paramContext, 1711472766, null);
    setContentView(paramContext);
    this.titleTView = ((TextView)paramContext.findViewById(1711867131));
    this.leftTimeTView = ((TextView)paramContext.findViewById(1711867132));
    this.recordProcessIView = ((ImageView)paramContext.findViewById(1711867133));
    this.startRecordIView = ((ImageView)paramContext.findViewById(1711867134));
    this.startOrStopRecordTView = ((TextView)paramContext.findViewById(1711867135));
    this.startOrStopRecordTView.setText("点击开始");
    this.leftTimeTView.setVisibility(4);
    this.recordProcessIView.setVisibility(8);
    paramContext = getWindow();
    localObject = paramContext.getAttributes();
    ((WindowManager.LayoutParams)localObject).width = ScreenUtil.getInstance().dip2px(269);
    ((WindowManager.LayoutParams)localObject).height = ScreenUtil.getInstance().dip2px(255);
    paramContext.setAttributes((WindowManager.LayoutParams)localObject);
    paramContext.setGravity(17);
    initListener();
    initAnimate();
  }
  
  private void initAnimate()
  {
    if (this.mRoateAnimation == null)
    {
      this.mRoateAnimation = new RotateAnimation(0.0F, 360.0F, 1, 0.5F, 1, 0.5F);
      this.mRoateAnimation.setDuration(1000L);
      this.mRoateAnimation.setRepeatMode(1);
      this.mRoateAnimation.setRepeatCount(-1);
    }
  }
  
  private void initListener()
  {
    setOnDismissListener(new DialogInterface.OnDismissListener()
    {
      public void onDismiss(DialogInterface paramAnonymousDialogInterface)
      {
        UgcSoundsRecordDialog.this.stopRecord();
      }
    });
    if (this.startRecordIView != null) {
      this.startRecordIView.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          UgcSoundsRecordDialog.this.recordBtnClick();
        }
      });
    }
    if (this.startOrStopRecordTView != null) {
      this.startOrStopRecordTView.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          UgcSoundsRecordDialog.this.recordBtnClick();
        }
      });
    }
  }
  
  private void startRecord()
  {
    MediaFocuseChangeListener.requestAudioFocus(BNaviModuleManager.getContext());
    this.isRecording = true;
    TTSPlayerControl.stopVoiceTTSOutput();
    TTSPlayerControl.pauseVoiceTTSOutput();
    BusinessActivityPlayerManager.getInstance().cancelPlayAudio();
    if ((this.titleTView != null) && (this.leftTimeTView != null) && (this.recordProcessIView != null) && (this.startRecordIView != null) && (this.startOrStopRecordTView != null))
    {
      this.titleTView.setText(JarUtils.getResources().getString(1711670190));
      this.leftTimeTView.setVisibility(0);
      this.recordProcessIView.setVisibility(0);
      this.startOrStopRecordTView.setText("点击停止");
      if (this.mRoateAnimation == null) {
        initAnimate();
      }
      this.leftTimeTView.setText("剩下20\"");
      this.recordProcessIView.startAnimation(this.mRoateAnimation);
    }
    if (this.mTimer == null) {
      this.mTimer = new Timer();
    }
    this.timeCountTime = 20;
    this.mTimer.schedule(new TimerTask()
    {
      public void run()
      {
        if (!UgcSoundsRecordDialog.this.isRecording) {
          return;
        }
        UgcSoundsRecordDialog.access$210(UgcSoundsRecordDialog.this);
        if (UgcSoundsRecordDialog.this.timeCountTime <= 0)
        {
          UgcSoundsRecordDialog.this.timeHandler.sendEmptyMessage(1000);
          return;
        }
        UgcSoundsRecordDialog.this.timeHandler.sendEmptyMessage(UgcSoundsRecordDialog.this.timeCountTime);
      }
    }, 1000L, 1000L);
    try
    {
      if (this.mRecorder == null) {
        this.mRecorder = new MediaRecorder();
      }
      this.mRecorder = new MediaRecorder();
      this.mRecorder.setAudioSource(1);
      this.mRecorder.setOutputFormat(1);
      this.mRecorder.setOutputFile(SOUNDS_TEMP_FILE_PATH);
      this.mRecorder.setAudioEncoder(1);
      this.mRecorder.prepare();
      this.mRecorder.start();
      return;
    }
    catch (Exception localException)
    {
      LogUtil.e(TAG, "MediaRecorder error:" + localException.toString());
    }
  }
  
  /* Error */
  private void stopRecord()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 101	com/baidu/navisdk/ui/ugc/view/UgcSoundsRecordDialog:isRecording	Z
    //   4: ifne +4 -> 8
    //   7: return
    //   8: invokestatic 278	com/baidu/navisdk/BNaviModuleManager:getContext	()Landroid/content/Context;
    //   11: invokestatic 359	com/baidu/navisdk/util/listener/MediaFocuseChangeListener:releaseAudioFocus	(Landroid/content/Context;)Z
    //   14: pop
    //   15: invokestatic 362	com/baidu/navisdk/comapi/tts/TTSPlayerControl:resumeVoiceTTSOutput	()V
    //   18: aload_0
    //   19: iconst_0
    //   20: putfield 101	com/baidu/navisdk/ui/ugc/view/UgcSoundsRecordDialog:isRecording	Z
    //   23: aload_0
    //   24: getfield 95	com/baidu/navisdk/ui/ugc/view/UgcSoundsRecordDialog:recordProcessIView	Landroid/widget/ImageView;
    //   27: ifnull +10 -> 37
    //   30: aload_0
    //   31: getfield 95	com/baidu/navisdk/ui/ugc/view/UgcSoundsRecordDialog:recordProcessIView	Landroid/widget/ImageView;
    //   34: invokevirtual 365	android/widget/ImageView:clearAnimation	()V
    //   37: aload_0
    //   38: getfield 315	com/baidu/navisdk/ui/ugc/view/UgcSoundsRecordDialog:mTimer	Ljava/util/Timer;
    //   41: ifnull +10 -> 51
    //   44: aload_0
    //   45: getfield 315	com/baidu/navisdk/ui/ugc/view/UgcSoundsRecordDialog:mTimer	Ljava/util/Timer;
    //   48: invokevirtual 368	java/util/Timer:cancel	()V
    //   51: aload_0
    //   52: getfield 325	com/baidu/navisdk/ui/ugc/view/UgcSoundsRecordDialog:mRecorder	Landroid/media/MediaRecorder;
    //   55: astore_1
    //   56: aload_1
    //   57: ifnull +22 -> 79
    //   60: aload_0
    //   61: getfield 325	com/baidu/navisdk/ui/ugc/view/UgcSoundsRecordDialog:mRecorder	Landroid/media/MediaRecorder;
    //   64: invokevirtual 371	android/media/MediaRecorder:stop	()V
    //   67: aload_0
    //   68: getfield 325	com/baidu/navisdk/ui/ugc/view/UgcSoundsRecordDialog:mRecorder	Landroid/media/MediaRecorder;
    //   71: invokevirtual 374	android/media/MediaRecorder:release	()V
    //   74: aload_0
    //   75: aconst_null
    //   76: putfield 325	com/baidu/navisdk/ui/ugc/view/UgcSoundsRecordDialog:mRecorder	Landroid/media/MediaRecorder;
    //   79: aload_0
    //   80: aconst_null
    //   81: putfield 325	com/baidu/navisdk/ui/ugc/view/UgcSoundsRecordDialog:mRecorder	Landroid/media/MediaRecorder;
    //   84: aload_0
    //   85: aconst_null
    //   86: putfield 315	com/baidu/navisdk/ui/ugc/view/UgcSoundsRecordDialog:mTimer	Ljava/util/Timer;
    //   89: aload_0
    //   90: getfield 376	com/baidu/navisdk/ui/ugc/view/UgcSoundsRecordDialog:mOnUgcSoundsRecordCallback	Lcom/baidu/navisdk/ui/ugc/view/UgcSoundsRecordDialog$onUgcSoundsRecordCallback;
    //   93: ifnull +23 -> 116
    //   96: aload_0
    //   97: getfield 376	com/baidu/navisdk/ui/ugc/view/UgcSoundsRecordDialog:mOnUgcSoundsRecordCallback	Lcom/baidu/navisdk/ui/ugc/view/UgcSoundsRecordDialog$onUgcSoundsRecordCallback;
    //   100: bipush 20
    //   102: aload_0
    //   103: getfield 105	com/baidu/navisdk/ui/ugc/view/UgcSoundsRecordDialog:timeCountTime	I
    //   106: isub
    //   107: getstatic 83	com/baidu/navisdk/ui/ugc/view/UgcSoundsRecordDialog:SOUNDS_TEMP_FILE_PATH	Ljava/lang/String;
    //   110: iconst_1
    //   111: invokeinterface 380 4 0
    //   116: aconst_null
    //   117: putstatic 85	com/baidu/navisdk/ui/ugc/view/UgcSoundsRecordDialog:mUgcSoundsRecordDialog	Lcom/baidu/navisdk/ui/ugc/view/UgcSoundsRecordDialog;
    //   120: return
    //   121: astore_1
    //   122: aload_1
    //   123: invokevirtual 383	java/lang/Exception:printStackTrace	()V
    //   126: aload_0
    //   127: aconst_null
    //   128: putfield 325	com/baidu/navisdk/ui/ugc/view/UgcSoundsRecordDialog:mRecorder	Landroid/media/MediaRecorder;
    //   131: aload_0
    //   132: aconst_null
    //   133: putfield 315	com/baidu/navisdk/ui/ugc/view/UgcSoundsRecordDialog:mTimer	Ljava/util/Timer;
    //   136: goto -47 -> 89
    //   139: astore_1
    //   140: aload_0
    //   141: aconst_null
    //   142: putfield 325	com/baidu/navisdk/ui/ugc/view/UgcSoundsRecordDialog:mRecorder	Landroid/media/MediaRecorder;
    //   145: aload_0
    //   146: aconst_null
    //   147: putfield 315	com/baidu/navisdk/ui/ugc/view/UgcSoundsRecordDialog:mTimer	Ljava/util/Timer;
    //   150: aload_1
    //   151: athrow
    //   152: astore_1
    //   153: goto -86 -> 67
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	156	0	this	UgcSoundsRecordDialog
    //   55	2	1	localMediaRecorder	MediaRecorder
    //   121	2	1	localException1	Exception
    //   139	12	1	localObject	Object
    //   152	1	1	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   37	51	121	java/lang/Exception
    //   51	56	121	java/lang/Exception
    //   67	79	121	java/lang/Exception
    //   37	51	139	finally
    //   51	56	139	finally
    //   60	67	139	finally
    //   67	79	139	finally
    //   122	126	139	finally
    //   60	67	152	java/lang/Exception
  }
  
  public static void stopRecordAndDismiss()
  {
    if ((mUgcSoundsRecordDialog != null) && (mUgcSoundsRecordDialog.isRecording)) {
      mUgcSoundsRecordDialog.stopRecord();
    }
  }
  
  public void cancel()
  {
    XDVoiceInstructManager.getInstance().setWakeupEnable(true);
    super.cancel();
  }
  
  public void dismiss()
  {
    XDVoiceInstructManager.getInstance().setWakeupEnable(true);
    super.dismiss();
  }
  
  public void recordBtnClick()
  {
    if (this.isRecording)
    {
      stopRecord();
      return;
    }
    startRecord();
  }
  
  public void setOnUgcSoundsRecordCallback(onUgcSoundsRecordCallback paramonUgcSoundsRecordCallback)
  {
    this.mOnUgcSoundsRecordCallback = paramonUgcSoundsRecordCallback;
  }
  
  public void show()
  {
    XDVoiceInstructManager.getInstance().setWakeupEnable(false);
    super.show();
  }
  
  public static abstract interface onUgcSoundsRecordCallback
  {
    public abstract void onRecordFinish(int paramInt, String paramString, boolean paramBoolean);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/ugc/view/UgcSoundsRecordDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */