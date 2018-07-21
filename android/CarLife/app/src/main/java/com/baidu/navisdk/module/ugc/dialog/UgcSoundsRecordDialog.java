package com.baidu.navisdk.module.ugc.dialog;

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
import com.baidu.navisdk.module.ugc.utils.UgcMapsViewConstructor;
import com.baidu.navisdk.ui.routeguide.asr.xdvoice.XDVoiceInstructManager;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.common.SysOSAPI;
import com.baidu.navisdk.util.common.SystemAuth;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.navisdk.util.listener.MediaFocuseChangeListener;
import java.util.Timer;
import java.util.TimerTask;

public class UgcSoundsRecordDialog
  extends Dialog
{
  private static final String TAG = UgcSoundsRecordDialog.class.getName();
  private static final int TIME_COUNT_SUM = 20;
  private static final int WHAT_RECORD_STOP = 1000;
  private static UgcSoundsRecordDialog mUgcSoundsRecordDialog = null;
  private String filePath = null;
  private boolean isRecording = false;
  private TextView leftTimeTView = null;
  private OnUgcSoundsRecordCallback mOnUgcSoundsRecordCallback;
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
  
  public static boolean checkAudioAuth()
  {
    boolean bool = true;
    if (!SystemAuth.checkAuth("android.permission.RECORD_AUDIO", true, "没有麦克风权限，请打开后重试"))
    {
      UgcMapsViewConstructor.requestSoundsAuth();
      bool = false;
    }
    return bool;
  }
  
  private String getUniqueSoundsFileName()
  {
    return SysOSAPI.getInstance().GetSDCardCachePath() + "/" + new Object().hashCode() + ".amr";
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
      this.filePath = getUniqueSoundsFileName();
      this.mRecorder.setAudioSource(1);
      this.mRecorder.setOutputFormat(1);
      this.mRecorder.setOutputFile(this.filePath);
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
    //   1: getfield 77	com/baidu/navisdk/module/ugc/dialog/UgcSoundsRecordDialog:isRecording	Z
    //   4: ifne +4 -> 8
    //   7: return
    //   8: invokestatic 308	com/baidu/navisdk/BNaviModuleManager:getContext	()Landroid/content/Context;
    //   11: invokestatic 391	com/baidu/navisdk/util/listener/MediaFocuseChangeListener:releaseAudioFocus	(Landroid/content/Context;)Z
    //   14: pop
    //   15: invokestatic 394	com/baidu/navisdk/comapi/tts/TTSPlayerControl:resumeVoiceTTSOutput	()V
    //   18: aload_0
    //   19: iconst_0
    //   20: putfield 77	com/baidu/navisdk/module/ugc/dialog/UgcSoundsRecordDialog:isRecording	Z
    //   23: aload_0
    //   24: getfield 71	com/baidu/navisdk/module/ugc/dialog/UgcSoundsRecordDialog:recordProcessIView	Landroid/widget/ImageView;
    //   27: ifnull +10 -> 37
    //   30: aload_0
    //   31: getfield 71	com/baidu/navisdk/module/ugc/dialog/UgcSoundsRecordDialog:recordProcessIView	Landroid/widget/ImageView;
    //   34: invokevirtual 397	android/widget/ImageView:clearAnimation	()V
    //   37: aload_0
    //   38: getfield 345	com/baidu/navisdk/module/ugc/dialog/UgcSoundsRecordDialog:mTimer	Ljava/util/Timer;
    //   41: ifnull +10 -> 51
    //   44: aload_0
    //   45: getfield 345	com/baidu/navisdk/module/ugc/dialog/UgcSoundsRecordDialog:mTimer	Ljava/util/Timer;
    //   48: invokevirtual 400	java/util/Timer:cancel	()V
    //   51: aload_0
    //   52: getfield 355	com/baidu/navisdk/module/ugc/dialog/UgcSoundsRecordDialog:mRecorder	Landroid/media/MediaRecorder;
    //   55: astore_1
    //   56: aload_1
    //   57: ifnull +22 -> 79
    //   60: aload_0
    //   61: getfield 355	com/baidu/navisdk/module/ugc/dialog/UgcSoundsRecordDialog:mRecorder	Landroid/media/MediaRecorder;
    //   64: invokevirtual 403	android/media/MediaRecorder:stop	()V
    //   67: aload_0
    //   68: getfield 355	com/baidu/navisdk/module/ugc/dialog/UgcSoundsRecordDialog:mRecorder	Landroid/media/MediaRecorder;
    //   71: invokevirtual 406	android/media/MediaRecorder:release	()V
    //   74: aload_0
    //   75: aconst_null
    //   76: putfield 355	com/baidu/navisdk/module/ugc/dialog/UgcSoundsRecordDialog:mRecorder	Landroid/media/MediaRecorder;
    //   79: aload_0
    //   80: aconst_null
    //   81: putfield 355	com/baidu/navisdk/module/ugc/dialog/UgcSoundsRecordDialog:mRecorder	Landroid/media/MediaRecorder;
    //   84: aload_0
    //   85: aconst_null
    //   86: putfield 345	com/baidu/navisdk/module/ugc/dialog/UgcSoundsRecordDialog:mTimer	Ljava/util/Timer;
    //   89: aload_0
    //   90: getfield 408	com/baidu/navisdk/module/ugc/dialog/UgcSoundsRecordDialog:mOnUgcSoundsRecordCallback	Lcom/baidu/navisdk/module/ugc/dialog/UgcSoundsRecordDialog$OnUgcSoundsRecordCallback;
    //   93: ifnull +24 -> 117
    //   96: aload_0
    //   97: getfield 408	com/baidu/navisdk/module/ugc/dialog/UgcSoundsRecordDialog:mOnUgcSoundsRecordCallback	Lcom/baidu/navisdk/module/ugc/dialog/UgcSoundsRecordDialog$OnUgcSoundsRecordCallback;
    //   100: bipush 20
    //   102: aload_0
    //   103: getfield 81	com/baidu/navisdk/module/ugc/dialog/UgcSoundsRecordDialog:timeCountTime	I
    //   106: isub
    //   107: aload_0
    //   108: getfield 83	com/baidu/navisdk/module/ugc/dialog/UgcSoundsRecordDialog:filePath	Ljava/lang/String;
    //   111: iconst_1
    //   112: invokeinterface 412 4 0
    //   117: aconst_null
    //   118: putstatic 60	com/baidu/navisdk/module/ugc/dialog/UgcSoundsRecordDialog:mUgcSoundsRecordDialog	Lcom/baidu/navisdk/module/ugc/dialog/UgcSoundsRecordDialog;
    //   121: return
    //   122: astore_1
    //   123: aload_1
    //   124: invokevirtual 415	java/lang/Exception:printStackTrace	()V
    //   127: aload_0
    //   128: aconst_null
    //   129: putfield 355	com/baidu/navisdk/module/ugc/dialog/UgcSoundsRecordDialog:mRecorder	Landroid/media/MediaRecorder;
    //   132: aload_0
    //   133: aconst_null
    //   134: putfield 345	com/baidu/navisdk/module/ugc/dialog/UgcSoundsRecordDialog:mTimer	Ljava/util/Timer;
    //   137: goto -48 -> 89
    //   140: astore_1
    //   141: aload_0
    //   142: aconst_null
    //   143: putfield 355	com/baidu/navisdk/module/ugc/dialog/UgcSoundsRecordDialog:mRecorder	Landroid/media/MediaRecorder;
    //   146: aload_0
    //   147: aconst_null
    //   148: putfield 345	com/baidu/navisdk/module/ugc/dialog/UgcSoundsRecordDialog:mTimer	Ljava/util/Timer;
    //   151: aload_1
    //   152: athrow
    //   153: astore_1
    //   154: goto -87 -> 67
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	157	0	this	UgcSoundsRecordDialog
    //   55	2	1	localMediaRecorder	MediaRecorder
    //   122	2	1	localException1	Exception
    //   140	12	1	localObject	Object
    //   153	1	1	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   37	51	122	java/lang/Exception
    //   51	56	122	java/lang/Exception
    //   67	79	122	java/lang/Exception
    //   37	51	140	finally
    //   51	56	140	finally
    //   60	67	140	finally
    //   67	79	140	finally
    //   123	127	140	finally
    //   60	67	153	java/lang/Exception
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
  
  public void setOnUgcSoundsRecordCallback(OnUgcSoundsRecordCallback paramOnUgcSoundsRecordCallback)
  {
    this.mOnUgcSoundsRecordCallback = paramOnUgcSoundsRecordCallback;
  }
  
  public void show()
  {
    XDVoiceInstructManager.getInstance().setWakeupEnable(false);
    super.show();
  }
  
  public static abstract interface OnUgcSoundsRecordCallback
  {
    public abstract void onRecordFinish(int paramInt, String paramString, boolean paramBoolean);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/module/ugc/dialog/UgcSoundsRecordDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */