package com.baidu.navisdk.ui.widget;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.jni.nativeif.JNIGuidanceControl;
import com.baidu.navisdk.logic.commandparser.CmdDebugModeGetURL;
import com.baidu.navisdk.logic.commandparser.DebugModeMessageBean;
import com.baidu.navisdk.logic.commandparser.DebugModeMessageSerBean;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.ui.util.ForbidDaulClickUtils;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.NetworkUtils;
import com.baidu.navisdk.util.common.PackageUtil;
import com.baidu.navisdk.util.drivertool.BNDrivingToolManager;
import com.baidu.navisdk.util.drivertool.BNDrivingToolUtils;
import com.baidu.navisdk.util.http.HttpURLManager;
import com.baidu.navisdk.util.http.HttpURLManager.ULRParam;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.navisdk.util.worker.BNWorkerCenter;
import com.baidu.navisdk.util.worker.BNWorkerConfig;
import com.baidu.navisdk.util.worker.BNWorkerNormalTask;
import com.baidu.navisdk.util.worker.IBNWorkerCenter;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class BNDebugModelDialog
  extends Dialog
{
  public static final boolean ANTI_CHEAT_DEBUG_SHOW = false;
  private ArrayAdapter<String> adapter;
  private int[] hDivider = { 1711866002, 1711866006, 1711866010, 1711866014, 1711866018, 1711866022, 1711866030, 1711866048, 1711866064 };
  private DebugUrlAdapter mAdapter;
  private StatusButton mAntiCheatBtn = null;
  private View mAntiCheatView = null;
  private TextView mBuildTimeTv = null;
  private View mBuildView = null;
  protected ImageView mCloseIV;
  private Context mContext;
  private Button mCreateRouteBtn;
  private TextView mCuidTv = null;
  private View mCuidView = null;
  private StatusButton mDrivingToolOpenBtn;
  private Button mDrivingToolStartBtn;
  private ExpandableListView mELUrlDebugView;
  private View mFactoryCategory = null;
  private List<DebugModeMessageBean> mGuideMsg = null;
  private Handler mHandler = new Handler(Looper.getMainLooper())
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      if (1405 == paramAnonymousMessage.what)
      {
        if (paramAnonymousMessage.arg1 != 0) {
          break label128;
        }
        HttpURLManager.getInstance().mGuideMsg = CmdDebugModeGetURL.mGuideMsg;
        BNDebugModelDialog.access$002(BNDebugModelDialog.this, HttpURLManager.getInstance().mGuideMsg);
        if ((BNDebugModelDialog.this.mGuideMsg != null) && (BNDebugModelDialog.this.mGuideMsg.size() > 0))
        {
          if (BNDebugModelDialog.this.mAdapter == null)
          {
            BNDebugModelDialog.access$102(BNDebugModelDialog.this, new BNDebugModelDialog.DebugUrlAdapter(BNDebugModelDialog.this));
            BNDebugModelDialog.this.mELUrlDebugView.setAdapter(BNDebugModelDialog.this.mAdapter);
          }
          BNDebugModelDialog.this.mRLUrlDebugExpandView.setVisibility(0);
        }
      }
      for (;;)
      {
        super.handleMessage(paramAnonymousMessage);
        return;
        label128:
        TipTool.onCreateToastDialog(BNDebugModelDialog.this.mContext, "url配置请求失败 + error msg = " + paramAnonymousMessage.arg1);
      }
    }
  };
  private StatusButton mHttpsDebugBtn = null;
  private View mHttpsDebugView = null;
  private StatusButton mImageLogBtn = null;
  private View mImageLogView = null;
  private StatusButton mJavaLogBtn = null;
  private View mJavaLogView = null;
  private StatusButton mMonkeyBtn = null;
  private View mMonkeyView = null;
  private Button mMuitipleBtn;
  private StatusButton mNativeLogBtn = null;
  private View mNativeLogView = null;
  private StatusButton mNotificationDebugBtn = null;
  private View mNotificationDebugView = null;
  protected DialogInterface.OnCancelListener mOnCancelListener = null;
  private View.OnClickListener mOnClickListener = null;
  private RelativeLayout mRLGPSDebugView;
  private RelativeLayout mRLUrlDebugExpandView;
  private RelativeLayout mRLUrlDebugView;
  private StatusButton mRootScreenBtn = null;
  private View mRootScreenView = null;
  private Spinner mRouteListSp;
  private LinearLayout mRouteLl;
  private StatusButton mSBGPSDebugView;
  private RelativeLayout mShowPullBtn;
  private Button mSingleDtBtn;
  private StatusButton.onStatusButtonClickListener mStatusButtonClickListener = null;
  private Button mStopDtBtn;
  private ImageView mTTSSpeedDownIv = null;
  private Button mTTSSpeedResetBtn = null;
  private TextView mTTSSpeedTv = null;
  private ImageView mTTSSpeedUpIv = null;
  private StatusButton mTTSVocoderBtn = null;
  private View mTTSVocoderView = null;
  private TextView mTVGPSDebugView;
  private TextView mTVUrlDebugColseView;
  private TextView mTVUrlDebugView;
  private Spinner mTaskListSp;
  
  public BNDebugModelDialog(Context paramContext)
  {
    super(paramContext);
    this.mContext = paramContext;
    Object localObject;
    if (Build.VERSION.SDK_INT < 21)
    {
      localObject = JarUtils.getResources().newTheme();
      ((Resources.Theme)localObject).applyStyle(1711996939, true);
      JarUtils.setDialogThemeField(this, (Resources.Theme)localObject);
    }
    try
    {
      for (;;)
      {
        paramContext = JarUtils.oldInflate((Activity)paramContext, 1711472666, null);
        if (paramContext != null) {
          break;
        }
        return;
        localObject = getWindow();
        requestWindowFeature(1);
        ((Window)localObject).setBackgroundDrawableResource(17170445);
        ((Window)localObject).getAttributes().gravity = 17;
      }
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        paramContext = null;
      }
      setContentView(paramContext);
      setCanceledOnTouchOutside(false);
      setCancelable(true);
      getWindow().getAttributes().gravity = 17;
      findView();
      setCloseIVListener();
      initListener();
      initButtonStatus();
    }
  }
  
  private int getSpeIndexFromUrl(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return -1;
    }
    int i = 0;
    if ((paramString.startsWith("http://")) && (paramString.length() > "http://".length()))
    {
      paramString = paramString.substring("http://".length());
      i = "http://".length();
    }
    for (;;)
    {
      return paramString.indexOf("/") + i;
      if ((paramString.startsWith("https://")) && (paramString.length() > "https://".length()))
      {
        paramString = paramString.substring("https://".length());
        i = "https://".length();
      }
    }
  }
  
  private String getUrlHost(String paramString)
  {
    int i = getSpeIndexFromUrl(paramString);
    if (i < 0) {}
    while ((paramString == null) || (paramString.length() <= i + 1)) {
      return null;
    }
    return paramString.substring(0, i);
  }
  
  private String getUrlWithNoHost(String paramString)
  {
    int i = getSpeIndexFromUrl(paramString);
    if (i < 0) {}
    while ((paramString == null) || (paramString.length() <= i + 1)) {
      return null;
    }
    return paramString.substring(i + 1);
  }
  
  private void initListener()
  {
    initStatusButtonClickListener();
    if (this.mJavaLogBtn != null) {
      this.mJavaLogBtn.setAllBtnClickListener(this.mStatusButtonClickListener);
    }
    if (this.mNotificationDebugBtn != null) {
      this.mNotificationDebugBtn.setAllBtnClickListener(this.mStatusButtonClickListener);
    }
    if (this.mRootScreenBtn != null) {
      this.mRootScreenBtn.setAllBtnClickListener(this.mStatusButtonClickListener);
    }
    if (this.mImageLogBtn != null) {
      this.mImageLogBtn.setAllBtnClickListener(this.mStatusButtonClickListener);
    }
    if (this.mHttpsDebugBtn != null) {
      this.mHttpsDebugBtn.setAllBtnClickListener(this.mStatusButtonClickListener);
    }
    if (this.mNativeLogBtn != null) {
      this.mNativeLogBtn.setAllBtnClickListener(this.mStatusButtonClickListener);
    }
    if (this.mMonkeyBtn != null) {
      this.mMonkeyBtn.setAllBtnClickListener(this.mStatusButtonClickListener);
    }
    if (this.mTTSVocoderBtn != null) {
      this.mTTSVocoderBtn.setAllBtnClickListener(this.mStatusButtonClickListener);
    }
    if (this.mSBGPSDebugView != null) {
      this.mSBGPSDebugView.setAllBtnClickListener(this.mStatusButtonClickListener);
    }
    if (this.mDrivingToolOpenBtn != null) {
      this.mDrivingToolOpenBtn.setAllBtnClickListener(this.mStatusButtonClickListener);
    }
    if (this.mTTSSpeedUpIv != null) {
      this.mTTSSpeedUpIv.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          int i;
          if (BNDebugModelDialog.this.mTTSSpeedTv != null)
          {
            i = Integer.parseInt(BNDebugModelDialog.this.mTTSSpeedTv.getText().toString());
            if (i >= 9) {
              TipTool.onCreateToastDialog(BNDebugModelDialog.this.mContext, "当前为最高语速");
            }
          }
          else
          {
            return;
          }
          paramAnonymousView = BNDebugModelDialog.this.mTTSSpeedTv;
          StringBuilder localStringBuilder = new StringBuilder();
          i += 1;
          paramAnonymousView.setText(i + "");
          BNSettingManager.setTTSSpeedParam(i);
        }
      });
    }
    if (this.mTTSSpeedDownIv != null) {
      this.mTTSSpeedDownIv.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          int i;
          if (BNDebugModelDialog.this.mTTSSpeedTv != null)
          {
            i = Integer.parseInt(BNDebugModelDialog.this.mTTSSpeedTv.getText().toString());
            if (i <= 0) {
              TipTool.onCreateToastDialog(BNDebugModelDialog.this.mContext, "当前为最低语速");
            }
          }
          else
          {
            return;
          }
          paramAnonymousView = BNDebugModelDialog.this.mTTSSpeedTv;
          StringBuilder localStringBuilder = new StringBuilder();
          i -= 1;
          paramAnonymousView.setText(i + "");
          BNSettingManager.setTTSSpeedParam(i);
        }
      });
    }
    if (this.mTTSSpeedResetBtn != null) {
      this.mTTSSpeedResetBtn.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          if (BNDebugModelDialog.this.mTTSSpeedTv != null) {
            BNDebugModelDialog.this.mTTSSpeedTv.setText(String.valueOf(5));
          }
          BNSettingManager.setTTSSpeedParam(5);
        }
      });
    }
  }
  
  private void initStatusButtonClickListener()
  {
    this.mStatusButtonClickListener = new StatusButton.onStatusButtonClickListener()
    {
      public void onClick(StatusButton paramAnonymousStatusButton, StatusButton.StatusButtonChild paramAnonymousStatusButtonChild)
      {
        if ((paramAnonymousStatusButton == BNDebugModelDialog.this.mJavaLogBtn) && (BNDebugModelDialog.this.mJavaLogBtn != null)) {
          switch (BNDebugModelDialog.18.$SwitchMap$com$baidu$navisdk$ui$widget$StatusButton$StatusButtonChild[paramAnonymousStatusButtonChild.ordinal()])
          {
          }
        }
        do
        {
          return;
          BNSettingManager.setShowJavaLog(true);
          return;
          BNSettingManager.setShowJavaLog(false);
          return;
          if ((paramAnonymousStatusButton == BNDebugModelDialog.this.mNotificationDebugBtn) && (BNDebugModelDialog.this.mNotificationDebugBtn != null))
          {
            switch (BNDebugModelDialog.18.$SwitchMap$com$baidu$navisdk$ui$widget$StatusButton$StatusButtonChild[paramAnonymousStatusButtonChild.ordinal()])
            {
            default: 
              return;
            case 1: 
              BNSettingManager.setShowNotificationDebug(true);
              return;
            }
            BNSettingManager.setShowNotificationDebug(false);
            return;
          }
          if ((paramAnonymousStatusButton == BNDebugModelDialog.this.mRootScreenBtn) && (BNDebugModelDialog.this.mRootScreenBtn != null))
          {
            switch (BNDebugModelDialog.18.$SwitchMap$com$baidu$navisdk$ui$widget$StatusButton$StatusButtonChild[paramAnonymousStatusButtonChild.ordinal()])
            {
            default: 
              return;
            case 1: 
              BNSettingManager.setRootScreenOpen(true);
              return;
            }
            BNSettingManager.setRootScreenOpen(false);
            return;
          }
          if ((paramAnonymousStatusButton == BNDebugModelDialog.this.mImageLogBtn) && (BNDebugModelDialog.this.mImageLogBtn != null))
          {
            switch (BNDebugModelDialog.18.$SwitchMap$com$baidu$navisdk$ui$widget$StatusButton$StatusButtonChild[paramAnonymousStatusButtonChild.ordinal()])
            {
            default: 
              return;
            case 1: 
              JNIGuidanceControl.getInstance().SetMapLoggerOpen(true);
              return;
            }
            JNIGuidanceControl.getInstance().SetMapLoggerOpen(false);
            return;
          }
          if ((paramAnonymousStatusButton == BNDebugModelDialog.this.mHttpsDebugBtn) && (BNDebugModelDialog.this.mHttpsDebugBtn != null))
          {
            switch (BNDebugModelDialog.18.$SwitchMap$com$baidu$navisdk$ui$widget$StatusButton$StatusButtonChild[paramAnonymousStatusButtonChild.ordinal()])
            {
            default: 
              return;
            case 1: 
              BNSettingManager.setUseHttpsOfflineURL(true);
              return;
            }
            BNSettingManager.setUseHttpsOfflineURL(false);
            return;
          }
          if ((paramAnonymousStatusButton == BNDebugModelDialog.this.mNativeLogBtn) && (BNDebugModelDialog.this.mNativeLogBtn != null))
          {
            switch (BNDebugModelDialog.18.$SwitchMap$com$baidu$navisdk$ui$widget$StatusButton$StatusButtonChild[paramAnonymousStatusButtonChild.ordinal()])
            {
            default: 
              return;
            case 1: 
              BNSettingManager.setShowNativeLog(true);
              return;
            }
            BNSettingManager.setShowNativeLog(false);
            return;
          }
          if ((paramAnonymousStatusButton == BNDebugModelDialog.this.mMonkeyBtn) && (BNDebugModelDialog.this.mMonkeyBtn != null))
          {
            switch (BNDebugModelDialog.18.$SwitchMap$com$baidu$navisdk$ui$widget$StatusButton$StatusButtonChild[paramAnonymousStatusButtonChild.ordinal()])
            {
            default: 
              return;
            case 1: 
              BNSettingManager.setMonkey(true);
              return;
            }
            BNSettingManager.setMonkey(false);
            return;
          }
          if ((paramAnonymousStatusButton == BNDebugModelDialog.this.mTTSVocoderBtn) && (BNDebugModelDialog.this.mTTSVocoderBtn != null))
          {
            switch (BNDebugModelDialog.18.$SwitchMap$com$baidu$navisdk$ui$widget$StatusButton$StatusButtonChild[paramAnonymousStatusButtonChild.ordinal()])
            {
            default: 
              return;
            case 1: 
              BNSettingManager.setTTSVocoderParam("0");
              return;
            case 3: 
              BNSettingManager.setTTSVocoderParam("1");
              return;
            }
            BNSettingManager.setTTSVocoderParam("2");
            return;
          }
          if ((paramAnonymousStatusButton == BNDebugModelDialog.this.mSBGPSDebugView) && (BNDebugModelDialog.this.mSBGPSDebugView != null))
          {
            switch (BNDebugModelDialog.18.$SwitchMap$com$baidu$navisdk$ui$widget$StatusButton$StatusButtonChild[paramAnonymousStatusButtonChild.ordinal()])
            {
            default: 
              return;
            case 1: 
              BNSettingManager.setGPSDebug(true);
              return;
            }
            BNSettingManager.setGPSDebug(false);
            return;
          }
        } while ((paramAnonymousStatusButton != BNDebugModelDialog.this.mDrivingToolOpenBtn) || (BNDebugModelDialog.this.mDrivingToolOpenBtn == null));
        switch (BNDebugModelDialog.18.$SwitchMap$com$baidu$navisdk$ui$widget$StatusButton$StatusButtonChild[paramAnonymousStatusButtonChild.ordinal()])
        {
        case 2: 
        default: 
          return;
        }
        if (BNDrivingToolUtils.canDrivingToolOpen())
        {
          BNDebugModelDialog.this.mDrivingToolOpenBtn.setVisibility(8);
          BNDebugModelDialog.this.mSingleDtBtn.setVisibility(0);
          BNDebugModelDialog.this.mShowPullBtn.setVisibility(0);
          BNDebugModelDialog.this.mRouteLl.setVisibility(8);
          BNDebugModelDialog.this.mMuitipleBtn.setVisibility(0);
          BNDrivingToolManager.getInstance().isSinglePerson = true;
          BNDrivingToolManager.getInstance().mRouteID = "0";
          return;
        }
        BNSettingManager.setShowingDrivingTool(false);
        BNDebugModelDialog.this.mDrivingToolOpenBtn.setRightBtnChecked();
      }
    };
  }
  
  private void synUrlHostOneMoudlue(DebugModeMessageSerBean paramDebugModeMessageSerBean)
  {
    if (paramDebugModeMessageSerBean.key.equals(HttpURLManager.ULRParam.URL_UGC_OPER_INFO_REPORT)) {
      if (paramDebugModeMessageSerBean.flag)
      {
        paramDebugModeMessageSerBean = getUrlHost(paramDebugModeMessageSerBean.value);
        str = getUrlWithNoHost(HttpURLManager.getInstance().getOnlineUrl(HttpURLManager.ULRParam.URL_UGC_EVENT_FEEDBACK));
        if (paramDebugModeMessageSerBean != null) {}
      }
    }
    while (!paramDebugModeMessageSerBean.key.equals(HttpURLManager.ULRParam.URL_INIT_CLOUD_CONFIG))
    {
      String str;
      do
      {
        return;
        if (str != null) {
          HttpURLManager.getInstance().putUrl(HttpURLManager.ULRParam.URL_UGC_EVENT_FEEDBACK, paramDebugModeMessageSerBean + "/" + str);
        }
        str = getUrlWithNoHost(HttpURLManager.getInstance().getOnlineUrl(HttpURLManager.ULRParam.URL_UGC_RCEVENT_COUNTS));
        if (str != null) {
          HttpURLManager.getInstance().putUrl(HttpURLManager.ULRParam.URL_UGC_RCEVENT_COUNTS, paramDebugModeMessageSerBean + "/" + str);
        }
        str = getUrlWithNoHost(HttpURLManager.getInstance().getOnlineUrl(HttpURLManager.ULRParam.URL_UGC_GET_EVENT_DETAIL));
      } while (str == null);
      HttpURLManager.getInstance().putUrl(HttpURLManager.ULRParam.URL_UGC_GET_EVENT_DETAIL, paramDebugModeMessageSerBean + "/" + str);
      return;
      HttpURLManager.getInstance().putUrl(HttpURLManager.ULRParam.URL_UGC_EVENT_FEEDBACK, HttpURLManager.getInstance().getOnlineUrl(HttpURLManager.ULRParam.URL_UGC_EVENT_FEEDBACK));
      HttpURLManager.getInstance().putUrl(HttpURLManager.ULRParam.URL_UGC_RCEVENT_COUNTS, HttpURLManager.getInstance().getOnlineUrl(HttpURLManager.ULRParam.URL_UGC_RCEVENT_COUNTS));
      HttpURLManager.getInstance().putUrl(HttpURLManager.ULRParam.URL_UGC_GET_EVENT_DETAIL, HttpURLManager.getInstance().getOnlineUrl(HttpURLManager.ULRParam.URL_UGC_GET_EVENT_DETAIL));
      return;
    }
    BNSettingManager.setInitCloudCfg(paramDebugModeMessageSerBean.flag);
  }
  
  public void findView()
  {
    this.mCloseIV = ((ImageView)findViewById(1711865904));
    this.mFactoryCategory = findViewById(1711866766);
    this.mCuidView = findViewById(1711866768);
    this.mBuildView = findViewById(1711865999);
    this.mJavaLogView = findViewById(1711866003);
    this.mNativeLogView = findViewById(1711866007);
    this.mMonkeyView = findViewById(1711866011);
    this.mCuidTv = ((TextView)findViewById(1711866769));
    this.mBuildTimeTv = ((TextView)findViewById(1711866001));
    this.mJavaLogBtn = ((StatusButton)findViewById(1711866005));
    this.mNativeLogBtn = ((StatusButton)findViewById(1711866009));
    this.mMonkeyBtn = ((StatusButton)findViewById(1711866013));
    this.mTTSVocoderView = findViewById(1711866028);
    this.mTTSVocoderBtn = ((StatusButton)findViewById(1711866029));
    this.mAntiCheatView = findViewById(1711866072);
    this.mAntiCheatBtn = ((StatusButton)findViewById(1711866073));
    this.mTTSSpeedUpIv = ((ImageView)findViewById(1711866034));
    this.mTTSSpeedDownIv = ((ImageView)findViewById(1711866035));
    this.mTTSSpeedResetBtn = ((Button)findViewById(1711866036));
    this.mTTSSpeedTv = ((TextView)findViewById(1711866032));
    this.mRLGPSDebugView = ((RelativeLayout)findViewById(1711866023));
    this.mTVGPSDebugView = ((TextView)findViewById(1711866024));
    this.mSBGPSDebugView = ((StatusButton)findViewById(1711866025));
    this.mRLUrlDebugView = ((RelativeLayout)findViewById(1711866046));
    this.mTVUrlDebugView = ((TextView)findViewById(1711866047));
    this.mRLUrlDebugExpandView = ((RelativeLayout)findViewById(1711866074));
    this.mELUrlDebugView = ((ExpandableListView)findViewById(1711866076));
    this.mNotificationDebugView = findViewById(1711866038);
    this.mNotificationDebugBtn = ((StatusButton)findViewById(1711866040));
    this.mRootScreenView = ((RelativeLayout)findViewById(1711866065));
    this.mRootScreenBtn = ((StatusButton)findViewById(1711866067));
    this.mImageLogView = ((RelativeLayout)findViewById(1711866069));
    this.mImageLogBtn = ((StatusButton)findViewById(1711866071));
    this.mHttpsDebugView = findViewById(1711866043);
    this.mHttpsDebugBtn = ((StatusButton)findViewById(1711866045));
    this.mELUrlDebugView.setOnChildClickListener(new ExpandableListView.OnChildClickListener()
    {
      public boolean onChildClick(ExpandableListView paramAnonymousExpandableListView, View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, long paramAnonymousLong)
      {
        boolean bool;
        if (BNDebugModelDialog.this.mGuideMsg != null)
        {
          paramAnonymousExpandableListView = (DebugModeMessageSerBean)((DebugModeMessageBean)BNDebugModelDialog.this.mGuideMsg.get(paramAnonymousInt1)).serList.get(paramAnonymousInt2);
          if (paramAnonymousExpandableListView.flag) {
            break label137;
          }
          bool = true;
          paramAnonymousExpandableListView.flag = bool;
          if (paramAnonymousExpandableListView.type != 0) {
            break label157;
          }
          if (!paramAnonymousExpandableListView.flag) {
            break label143;
          }
          HttpURLManager.getInstance().putUrl(paramAnonymousExpandableListView.key, paramAnonymousExpandableListView.value);
          JNIGuidanceControl.getInstance().loadUrlAddrConfigParams(paramAnonymousExpandableListView.key, HttpURLManager.getInstance().getUsedUrl(paramAnonymousExpandableListView.key));
        }
        for (;;)
        {
          BNDebugModelDialog.this.synUrlHostOneMoudlue(paramAnonymousExpandableListView);
          BNDebugModelDialog.this.mAdapter.notifyDataSetChanged();
          BNDebugModelDialog.this.mELUrlDebugView.expandGroup(paramAnonymousInt1);
          return false;
          label137:
          bool = false;
          break;
          label143:
          JNIGuidanceControl.getInstance().resetUrlAddrConfigParams(paramAnonymousExpandableListView.key);
          continue;
          label157:
          if (paramAnonymousExpandableListView.flag) {
            HttpURLManager.getInstance().putUrl(paramAnonymousExpandableListView.key, paramAnonymousExpandableListView.value);
          } else {
            HttpURLManager.getInstance().putUrl(paramAnonymousExpandableListView.key, HttpURLManager.getInstance().getOnlineUrl(paramAnonymousExpandableListView.key));
          }
        }
      }
    });
    this.mTVUrlDebugColseView = ((TextView)findViewById(1711866075));
    this.mDrivingToolOpenBtn = ((StatusButton)findViewById(1711866052));
    if (this.mDrivingToolOpenBtn != null)
    {
      this.mDrivingToolOpenBtn.setLeftButtonText(BNStyleManager.getString(1711669886));
      this.mDrivingToolOpenBtn.setRightButtonText(BNStyleManager.getString(1711669887));
      this.mDrivingToolOpenBtn.setMidBtnGone(true);
      this.mDrivingToolOpenBtn.setRightBtnChecked();
    }
    this.mDrivingToolStartBtn = ((Button)findViewById(1711866053));
    this.mShowPullBtn = ((RelativeLayout)findViewById(1711866055));
    if (this.mDrivingToolStartBtn != null)
    {
      this.mDrivingToolStartBtn.setVisibility(8);
      this.mDrivingToolStartBtn.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          BNDebugModelDialog.this.dismiss();
          BNDebugModelDialog.this.setStartButtonState(false);
          BNDebugModelDialog.this.mDrivingToolStartBtn.setVisibility(8);
          BNDebugModelDialog.this.mDrivingToolOpenBtn.setVisibility(0);
          if (BNDebugModelDialog.this.mShowPullBtn != null) {
            BNDebugModelDialog.this.mShowPullBtn.setVisibility(8);
          }
          BNDrivingToolManager.getInstance().mNewRouteList.clear();
        }
      });
    }
    setStartButtonState(false);
    if (this.mShowPullBtn != null) {
      this.mShowPullBtn.setVisibility(8);
    }
    this.mSingleDtBtn = ((Button)findViewById(1711866054));
    if (this.mSingleDtBtn != null) {
      this.mSingleDtBtn.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          BNDebugModelDialog.this.dismiss();
        }
      });
    }
    this.mRouteLl = ((LinearLayout)findViewById(1711866059));
    this.mMuitipleBtn = ((Button)findViewById(1711866062));
    if (this.mMuitipleBtn != null) {
      this.mMuitipleBtn.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          BNDrivingToolManager.getInstance().isSinglePerson = false;
          BNDebugModelDialog.this.mMuitipleBtn.setVisibility(8);
          BNDebugModelDialog.this.mRouteLl.setVisibility(0);
          BNDebugModelDialog.this.mDrivingToolStartBtn.setVisibility(0);
          BNDebugModelDialog.this.mSingleDtBtn.setVisibility(8);
          BNDebugModelDialog.this.mStopDtBtn.setVisibility(8);
          BNDrivingToolManager.getInstance().asynPullRoadList();
        }
      });
    }
    this.mStopDtBtn = ((Button)findViewById(1711866063));
    if (this.mStopDtBtn != null) {
      this.mStopDtBtn.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          if (BNDebugModelDialog.this.mTaskListSp != null) {
            BNDebugModelDialog.this.mTaskListSp.setSelection(0);
          }
        }
      });
    }
    this.mTaskListSp = ((Spinner)findViewById(1711866058));
    if (this.mTaskListSp != null)
    {
      BNDrivingToolManager.getInstance().asynPullTaskList();
      this.mTaskListSp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
      {
        public void onItemSelected(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          paramAnonymousAdapterView = BNDrivingToolManager.getInstance().mTaskList;
          if (paramAnonymousAdapterView != null)
          {
            paramAnonymousView = (String)paramAnonymousAdapterView.get(paramAnonymousInt);
            paramAnonymousAdapterView = null;
            if (!"-  -  -  -  -  -  -  -  -  -  -  -  -  -  -".equals(paramAnonymousView)) {
              break label212;
            }
            BNDrivingToolManager.getInstance().isTaskRet = false;
            if (!"-  -  -  -  -  -  -  -  -  -  -  -  -  -  -".equals(paramAnonymousView))
            {
              paramAnonymousAdapterView = (String)BNDrivingToolManager.getInstance().mTaskMap.get(paramAnonymousView);
              BNDrivingToolManager.getInstance().mTaskID = paramAnonymousAdapterView;
            }
            if (!BNDrivingToolManager.getInstance().canDrivingToolStart()) {
              break label222;
            }
            BNDrivingToolManager.getInstance().isSinglePerson = false;
            BNDebugModelDialog.this.setStartButtonState(true);
            BNSettingManager.setShowingDrivingTool(true);
            BNDrivingToolUtils.storeDrivingToolTask();
            BNDrivingToolUtils.sCanShow = true;
            label107:
            if (BNDebugModelDialog.this.mSingleDtBtn.getVisibility() == 0)
            {
              if (!BNDrivingToolManager.getInstance().isTaskRet) {
                break label241;
              }
              BNDebugModelDialog.this.setSingleButtonState(true);
              BNSettingManager.setShowingDrivingTool(true);
              BNDrivingToolUtils.storeDrivingToolTask();
              BNDrivingToolManager.getInstance().isSinglePerson = true;
            }
          }
          for (BNDrivingToolUtils.sCanShow = true;; BNDrivingToolUtils.sCanShow = false)
          {
            if (!"-  -  -  -  -  -  -  -  -  -  -  -  -  -  -".equals(paramAnonymousView))
            {
              BNDrivingToolManager.getInstance().mRouteFlag = "0";
              if (!BNDrivingToolManager.getInstance().isSinglePerson) {
                BNDrivingToolManager.getInstance().asynPullRoadList();
              }
            }
            LogUtil.e("drivingTool", "taskId is + " + paramAnonymousAdapterView);
            return;
            label212:
            BNDrivingToolManager.getInstance().isTaskRet = true;
            break;
            label222:
            BNDebugModelDialog.this.setStartButtonState(false);
            BNSettingManager.setShowingDrivingTool(false);
            BNDrivingToolUtils.sCanShow = false;
            break label107;
            label241:
            BNDebugModelDialog.this.setSingleButtonState(false);
            BNSettingManager.setShowingDrivingTool(false);
          }
        }
        
        public void onNothingSelected(AdapterView<?> paramAnonymousAdapterView) {}
      });
    }
    this.mRouteListSp = ((Spinner)findViewById(1711866060));
    if (this.mRouteListSp != null) {
      this.mRouteListSp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
      {
        public void onItemSelected(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          paramAnonymousAdapterView = BNDrivingToolManager.getInstance().mRouteList;
          if (paramAnonymousAdapterView != null)
          {
            paramAnonymousAdapterView = (String)paramAnonymousAdapterView.get(paramAnonymousInt);
            if (!"-  -  -  -  -  -  -  -  -  -  -  -  -  -  -".equals(paramAnonymousAdapterView)) {
              break label159;
            }
            BNDrivingToolManager.getInstance().isRouteRet = false;
            if (!BNDrivingToolManager.getInstance().canDrivingToolStart()) {
              break label176;
            }
            BNDebugModelDialog.this.setStartButtonState(true);
            BNSettingManager.setShowingDrivingTool(true);
            BNDrivingToolUtils.storeDrivingToolTask();
            BNDrivingToolManager.getInstance().isSinglePerson = false;
            BNDrivingToolUtils.sCanShow = true;
            label73:
            paramAnonymousView = BNDrivingToolManager.getInstance().mNewRouteList;
            if ((paramAnonymousView == null) || (paramAnonymousView.size() <= 0)) {
              break label206;
            }
            if (!paramAnonymousView.contains(paramAnonymousAdapterView)) {
              break label195;
            }
            BNDrivingToolManager.getInstance().mRouteFlag = "1";
          }
          for (;;)
          {
            paramAnonymousAdapterView = (String)BNDrivingToolManager.getInstance().mRoadMap.get(paramAnonymousAdapterView);
            BNDrivingToolManager.getInstance().mRouteID = paramAnonymousAdapterView;
            LogUtil.e("drivingTool", "routeId is + " + paramAnonymousAdapterView);
            return;
            label159:
            BNDrivingToolManager.getInstance().isRouteRet = true;
            BNDrivingToolManager.getInstance().mRouteName = paramAnonymousAdapterView;
            break;
            label176:
            BNDebugModelDialog.this.setStartButtonState(false);
            BNSettingManager.setShowingDrivingTool(false);
            BNDrivingToolUtils.sCanShow = false;
            break label73;
            label195:
            BNDrivingToolManager.getInstance().mRouteFlag = "0";
            continue;
            label206:
            BNDrivingToolManager.getInstance().mRouteFlag = "0";
          }
        }
        
        public void onNothingSelected(AdapterView<?> paramAnonymousAdapterView) {}
      });
    }
    this.mCreateRouteBtn = ((Button)findViewById(1711866061));
    if (this.mCreateRouteBtn != null) {
      this.mCreateRouteBtn.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          if (ForbidDaulClickUtils.isFastDoubleClick(1500L)) {
            return;
          }
          BNDrivingToolManager.getInstance().mRouteFlag = "1";
          BNDrivingToolManager.getInstance().asynPullRoadList();
        }
      });
    }
    if ((this.mRLUrlDebugView != null) && (this.mTVUrlDebugView != null))
    {
      this.mRLUrlDebugView.setVisibility(0);
      this.mTVUrlDebugView.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          if ((HttpURLManager.getInstance().mGuideMsg == null) || (HttpURLManager.getInstance().mGuideMsg.size() <= 0))
          {
            if (NetworkUtils.isNetworkAvailable(BNDebugModelDialog.this.mContext))
            {
              CmdDebugModeGetURL.requestDebugModeUrl(BNDebugModelDialog.this.mHandler);
              return;
            }
            TipTool.onCreateToastDialog(BNDebugModelDialog.this.mContext, "网络未连接");
            return;
          }
          BNDebugModelDialog.access$002(BNDebugModelDialog.this, HttpURLManager.getInstance().mGuideMsg);
          if (BNDebugModelDialog.this.mAdapter == null)
          {
            BNDebugModelDialog.access$102(BNDebugModelDialog.this, new BNDebugModelDialog.DebugUrlAdapter(BNDebugModelDialog.this));
            BNDebugModelDialog.this.mELUrlDebugView.setAdapter(BNDebugModelDialog.this.mAdapter);
          }
          BNDebugModelDialog.this.mRLUrlDebugExpandView.setVisibility(0);
        }
      });
      this.mTVUrlDebugColseView.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          BNDebugModelDialog.this.mRLUrlDebugExpandView.setVisibility(8);
        }
      });
    }
    if (this.mFactoryCategory != null) {
      this.mFactoryCategory.setVisibility(0);
    }
    if ((this.mCuidView != null) && (this.mCuidTv != null))
    {
      this.mCuidView.setVisibility(0);
      this.mCuidTv.setText("CUID:" + PackageUtil.getCuid());
    }
    if ((this.mBuildView != null) && (this.mBuildTimeTv != null))
    {
      this.mBuildView.setVisibility(0);
      this.mBuildTimeTv.setText("BuildTime:(" + PackageUtil.getBuildNo() + ")");
    }
    if ((this.mJavaLogView != null) && (this.mJavaLogBtn != null))
    {
      this.mJavaLogView.setVisibility(0);
      this.mJavaLogBtn.setLeftButtonText(BNStyleManager.getString(1711669886));
      this.mJavaLogBtn.setRightButtonText(BNStyleManager.getString(1711669887));
      this.mJavaLogBtn.setMidBtnGone(true);
    }
    if ((this.mNotificationDebugView != null) && (this.mNotificationDebugBtn != null))
    {
      this.mNotificationDebugView.setVisibility(0);
      this.mNotificationDebugBtn.setLeftButtonText(BNStyleManager.getString(1711669886));
      this.mNotificationDebugBtn.setRightButtonText(BNStyleManager.getString(1711669887));
      this.mNotificationDebugBtn.setMidBtnGone(true);
    }
    if ((this.mRootScreenView != null) && (this.mRootScreenBtn != null))
    {
      this.mRootScreenView.setVisibility(0);
      this.mRootScreenBtn.setLeftButtonText("开启");
      this.mRootScreenBtn.setRightButtonText("关闭");
      this.mRootScreenBtn.setMidBtnGone(true);
    }
    if ((this.mImageLogView != null) && (this.mImageLogBtn != null))
    {
      this.mImageLogView.setVisibility(0);
      this.mImageLogBtn.setLeftButtonText("开启");
      this.mImageLogBtn.setRightButtonText("关闭");
      this.mImageLogBtn.setMidBtnGone(true);
    }
    if ((this.mHttpsDebugView != null) && (this.mHttpsDebugBtn != null))
    {
      this.mHttpsDebugView.setVisibility(0);
      this.mHttpsDebugBtn.setLeftButtonText(BNStyleManager.getString(1711669886));
      this.mHttpsDebugBtn.setRightButtonText(BNStyleManager.getString(1711669887));
      this.mHttpsDebugBtn.setMidBtnGone(true);
    }
    if ((this.mNativeLogView != null) && (this.mNativeLogBtn != null))
    {
      this.mNativeLogView.setVisibility(0);
      this.mNativeLogBtn.setLeftButtonText(BNStyleManager.getString(1711669886));
      this.mNativeLogBtn.setRightButtonText(BNStyleManager.getString(1711669887));
      this.mNativeLogBtn.setMidBtnGone(true);
    }
    if ((this.mMonkeyView != null) && (this.mMonkeyBtn != null))
    {
      this.mMonkeyView.setVisibility(0);
      this.mMonkeyBtn.setLeftButtonText(BNStyleManager.getString(1711669886));
      this.mMonkeyBtn.setRightButtonText(BNStyleManager.getString(1711669887));
      this.mMonkeyBtn.setMidBtnGone(true);
    }
    if ((this.mTTSVocoderView != null) && (this.mTTSVocoderBtn != null))
    {
      this.mTTSVocoderView.setVisibility(0);
      this.mTTSVocoderBtn.setLeftButtonText("0");
      this.mTTSVocoderBtn.setMidButtonText("1");
      this.mTTSVocoderBtn.setRightButtonText("2");
    }
    if ((this.mRLGPSDebugView != null) && (this.mSBGPSDebugView != null))
    {
      this.mRLGPSDebugView.setVisibility(0);
      this.mSBGPSDebugView.setLeftButtonText(BNStyleManager.getString(1711669886));
      this.mSBGPSDebugView.setRightButtonText(BNStyleManager.getString(1711669887));
      this.mSBGPSDebugView.setMidBtnGone(true);
    }
  }
  
  public void initButtonStatus()
  {
    if (this.mJavaLogBtn != null)
    {
      if (BNSettingManager.isShowJavaLog()) {
        this.mJavaLogBtn.setLeftBtnChecked();
      }
    }
    else
    {
      if (this.mNotificationDebugBtn != null)
      {
        if (!BNSettingManager.isShowNotificationDebug()) {
          break label271;
        }
        this.mNotificationDebugBtn.setLeftBtnChecked();
      }
      label42:
      if (this.mImageLogBtn != null)
      {
        if (!JNIGuidanceControl.getInstance().IsMapLoggerOpen()) {
          break label282;
        }
        this.mImageLogBtn.setLeftBtnChecked();
      }
      label66:
      if (this.mRootScreenBtn != null)
      {
        if (!BNSettingManager.isRootScreenOpen()) {
          break label293;
        }
        this.mRootScreenBtn.setLeftBtnChecked();
      }
      label87:
      if (this.mHttpsDebugBtn != null)
      {
        if (!BNSettingManager.isUseHttpsOfflineURL()) {
          break label304;
        }
        this.mHttpsDebugBtn.setLeftBtnChecked();
      }
      label108:
      if (this.mNativeLogBtn != null)
      {
        if (!BNSettingManager.isShowNativeLog()) {
          break label315;
        }
        this.mNativeLogBtn.setLeftBtnChecked();
      }
      label129:
      if (this.mMonkeyBtn != null)
      {
        if (!BNSettingManager.isMonkey()) {
          break label326;
        }
        this.mMonkeyBtn.setLeftBtnChecked();
      }
      label150:
      if (this.mTTSVocoderBtn != null)
      {
        if (!BNSettingManager.getTTSVocoderParam().equals("0")) {
          break label337;
        }
        this.mTTSVocoderBtn.setLeftBtnChecked();
      }
      label177:
      if (this.mSBGPSDebugView != null)
      {
        if (!BNSettingManager.isGPSDebug()) {
          break label371;
        }
        this.mSBGPSDebugView.setLeftBtnChecked();
      }
      label198:
      if (this.mDrivingToolOpenBtn != null)
      {
        if (!BNSettingManager.isShowingDrivingTool()) {
          break label382;
        }
        this.mDrivingToolOpenBtn.setLeftBtnChecked();
        updateDrivingToolView();
      }
    }
    for (;;)
    {
      if (this.mTTSSpeedTv != null) {
        this.mTTSSpeedTv.setText(BNSettingManager.getTTSSpeedParam() + "");
      }
      return;
      this.mJavaLogBtn.setRightBtnChecked();
      break;
      label271:
      this.mNotificationDebugBtn.setRightBtnChecked();
      break label42;
      label282:
      this.mImageLogBtn.setRightBtnChecked();
      break label66;
      label293:
      this.mRootScreenBtn.setRightBtnChecked();
      break label87;
      label304:
      this.mHttpsDebugBtn.setRightBtnChecked();
      break label108;
      label315:
      this.mNativeLogBtn.setRightBtnChecked();
      break label129;
      label326:
      this.mMonkeyBtn.setRightBtnChecked();
      break label150;
      label337:
      if (BNSettingManager.getTTSVocoderParam().equals("1"))
      {
        this.mTTSVocoderBtn.setMidBtnChecked();
        break label177;
      }
      this.mTTSVocoderBtn.setRightBtnChecked();
      break label177;
      label371:
      this.mSBGPSDebugView.setRightBtnChecked();
      break label198;
      label382:
      this.mDrivingToolOpenBtn.setRightBtnChecked();
    }
  }
  
  public void setCloseGone()
  {
    this.mCloseIV.setVisibility(8);
  }
  
  public void setCloseIVListener()
  {
    this.mCloseIV.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (BNDebugModelDialog.this.mOnCancelListener != null) {
          BNDebugModelDialog.this.mOnCancelListener.onCancel(BNDebugModelDialog.this);
        }
        com.baidu.navisdk.debug.NavSDKDebug.sSDKFactoryMode = false;
        BNDebugModelDialog.this.dismiss();
      }
    });
  }
  
  public void setCloseVisible()
  {
    this.mCloseIV.setVisibility(0);
  }
  
  public void setOnCancelListener(DialogInterface.OnCancelListener paramOnCancelListener)
  {
    this.mOnCancelListener = paramOnCancelListener;
    super.setOnCancelListener(paramOnCancelListener);
  }
  
  public void setRouteSpinnerCLickable(boolean paramBoolean)
  {
    if (this.mRouteListSp != null) {
      this.mRouteListSp.setClickable(paramBoolean);
    }
  }
  
  public void setSingleButtonState(boolean paramBoolean)
  {
    if (this.mSingleDtBtn == null) {
      return;
    }
    if (paramBoolean)
    {
      this.mSingleDtBtn.setBackgroundColor(-16711936);
      this.mSingleDtBtn.setClickable(true);
      return;
    }
    this.mSingleDtBtn.setBackgroundColor(-7829368);
    this.mSingleDtBtn.setClickable(false);
  }
  
  public void setStartButtonState(boolean paramBoolean)
  {
    if (this.mDrivingToolStartBtn == null) {
      return;
    }
    if (paramBoolean)
    {
      this.mDrivingToolStartBtn.setBackgroundColor(-16711936);
      this.mDrivingToolStartBtn.setClickable(true);
      return;
    }
    this.mDrivingToolStartBtn.setBackgroundColor(-7829368);
    this.mDrivingToolStartBtn.setClickable(false);
  }
  
  public BNDebugModelDialog setYawingStyleGrivity(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      localTheme = JarUtils.getResources().newTheme();
      localTheme.applyStyle(1711996941, true);
      JarUtils.setDialogThemeField(this, localTheme);
      getWindow().getAttributes().gravity = 51;
      return this;
    }
    Resources.Theme localTheme = JarUtils.getResources().newTheme();
    localTheme.applyStyle(1711996939, true);
    JarUtils.setDialogThemeField(this, localTheme);
    getWindow().getAttributes().gravity = 17;
    return this;
  }
  
  public void updatRouteListView()
  {
    if (this.mRouteListSp != null)
    {
      Object localObject = BNDrivingToolManager.getInstance().mRouteList;
      if (localObject != null)
      {
        localObject = new ArrayAdapter(this.mContext, 17367048, (List)localObject);
        ((ArrayAdapter)localObject).setDropDownViewResource(17367049);
        this.mRouteListSp.setAdapter((SpinnerAdapter)localObject);
        if ((BNDrivingToolManager.getInstance().mRouteList != null) && (BNDrivingToolManager.getInstance().mRouteFlag.equals("1")))
        {
          int i = BNDrivingToolManager.getInstance().mRouteList.size();
          this.mRouteListSp.setSelection(i - 1, true);
        }
      }
    }
    setRouteSpinnerCLickable(true);
  }
  
  public void updateDrivingToolView()
  {
    this.mDrivingToolOpenBtn.setVisibility(8);
    this.mSingleDtBtn.setVisibility(0);
    this.mShowPullBtn.setVisibility(0);
    this.mRouteLl.setVisibility(8);
    this.mMuitipleBtn.setVisibility(0);
    BNDrivingToolManager.getInstance().isSinglePerson = true;
    BNDrivingToolManager.getInstance().mRouteID = "0";
  }
  
  public void updateTaskListView()
  {
    if ((this.mTaskListSp != null) && (BNDrivingToolManager.getInstance().mTaskList != null))
    {
      Object localObject3 = BNSettingManager.getLastDrivingInfo();
      Object localObject2 = null;
      Object localObject1 = localObject2;
      if (localObject3 != null)
      {
        localObject3 = ((String)localObject3).split(",");
        localObject1 = localObject2;
        if (localObject3 != null)
        {
          localObject1 = localObject2;
          if (localObject3.length > 0) {
            localObject1 = localObject3[0];
          }
        }
      }
      localObject3 = null;
      localObject2 = localObject3;
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        Object localObject4 = BNDrivingToolManager.getInstance().mTaskMap;
        localObject2 = localObject3;
        if (localObject4 != null)
        {
          localObject2 = localObject3;
          if (((Map)localObject4).size() > 0)
          {
            localObject4 = ((Map)localObject4).values().iterator();
            do
            {
              localObject2 = localObject3;
              if (!((Iterator)localObject4).hasNext()) {
                break;
              }
            } while (!((String)localObject1).equals((String)((Iterator)localObject4).next()));
            localObject2 = "ok";
          }
        }
      }
      localObject1 = new ArrayAdapter(this.mContext, 17367048, BNDrivingToolManager.getInstance().mTaskList);
      ((ArrayAdapter)localObject1).setDropDownViewResource(17367049);
      this.mTaskListSp.setAdapter((SpinnerAdapter)localObject1);
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        this.mTaskListSp.setSelection(0, true);
        BNWorkerCenter.getInstance().submitMainThreadTask(new BNWorkerNormalTask("updateTaskListView-" + getClass().getSimpleName(), null)new BNWorkerConfig
        {
          protected String execute()
          {
            BNDebugModelDialog.this.updateTaskSpinnerView();
            return null;
          }
        }, new BNWorkerConfig(100, 0));
      }
    }
  }
  
  public void updateTaskSpinnerView()
  {
    i = -1;
    try
    {
      int j = BNDrivingToolManager.getInstance().getLastSelectedTaskIndex();
      k = j;
      i = j;
      if (this.mTaskListSp != null)
      {
        i = j;
        this.mTaskListSp.setSelection(j);
        k = j;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int k = i;
      }
    }
    LogUtil.e("drivingTool", "getSelectedTaskIndex index is " + k);
  }
  
  class DebugUrlAdapter
    extends BaseExpandableListAdapter
  {
    ViewHolder mViewHolder;
    
    DebugUrlAdapter() {}
    
    public Object getChild(int paramInt1, int paramInt2)
    {
      return ((DebugModeMessageBean)BNDebugModelDialog.this.mGuideMsg.get(paramInt1)).serList.get(paramInt2);
    }
    
    public long getChildId(int paramInt1, int paramInt2)
    {
      return paramInt2;
    }
    
    public View getChildView(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
    {
      paramViewGroup = (DebugModeMessageSerBean)((DebugModeMessageBean)BNDebugModelDialog.this.mGuideMsg.get(paramInt1)).serList.get(paramInt2);
      if (paramView == null)
      {
        paramView = JarUtils.inflate((Activity)BNDebugModelDialog.this.mContext, 1711472667, null);
        this.mViewHolder = new ViewHolder(null);
        this.mViewHolder.mTVUrl = ((TextView)paramView.findViewById(1711866077));
        this.mViewHolder.mCb = ((CheckBox)paramView.findViewById(1711866078));
        paramView.setTag(this.mViewHolder);
      }
      for (;;)
      {
        this.mViewHolder.mTVUrl.setText(paramViewGroup.key + "--" + paramViewGroup.value);
        this.mViewHolder.mCb.setFocusable(false);
        this.mViewHolder.mCb.setClickable(false);
        if (!paramViewGroup.flag) {
          break;
        }
        this.mViewHolder.mCb.setChecked(true);
        return paramView;
        this.mViewHolder = ((ViewHolder)paramView.getTag());
      }
      this.mViewHolder.mCb.setChecked(false);
      return paramView;
    }
    
    public int getChildrenCount(int paramInt)
    {
      return ((DebugModeMessageBean)BNDebugModelDialog.this.mGuideMsg.get(paramInt)).serList.size();
    }
    
    public Object getGroup(int paramInt)
    {
      return BNDebugModelDialog.this.mGuideMsg.get(paramInt);
    }
    
    public int getGroupCount()
    {
      return BNDebugModelDialog.this.mGuideMsg.size();
    }
    
    public long getGroupId(int paramInt)
    {
      return paramInt;
    }
    
    public View getGroupView(int paramInt, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
    {
      paramViewGroup = paramView;
      if (paramView == null) {
        paramViewGroup = JarUtils.inflate((Activity)BNDebugModelDialog.this.mContext, 1711472668, null);
      }
      ((TextView)paramViewGroup.findViewById(1711866079)).setText(((DebugModeMessageBean)BNDebugModelDialog.this.mGuideMsg.get(paramInt)).mSceneName);
      return paramViewGroup;
    }
    
    public boolean hasStableIds()
    {
      return true;
    }
    
    public boolean isChildSelectable(int paramInt1, int paramInt2)
    {
      LogUtil.e("wangyang", "selectable");
      return true;
    }
    
    private class ViewHolder
    {
      CheckBox mCb;
      TextView mTVUrl;
      
      private ViewHolder() {}
    }
  }
  
  class SpinnerSelectedListener
    implements AdapterView.OnItemSelectedListener
  {
    SpinnerSelectedListener() {}
    
    public void onItemSelected(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong) {}
    
    public void onNothingSelected(AdapterView paramAdapterView) {}
  }
  
  class SpinnerURLSelectedListener
    implements AdapterView.OnItemSelectedListener
  {
    SpinnerURLSelectedListener() {}
    
    public void onItemSelected(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong) {}
    
    public void onNothingSelected(AdapterView paramAdapterView) {}
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/widget/BNDebugModelDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */