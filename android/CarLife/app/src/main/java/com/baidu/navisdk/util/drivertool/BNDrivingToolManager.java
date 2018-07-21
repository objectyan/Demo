package com.baidu.navisdk.util.drivertool;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.comapi.poisearch.BNPoiSearcher;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.logic.CommandCenter;
import com.baidu.navisdk.logic.ReqData;
import com.baidu.navisdk.logic.RspData;
import com.baidu.navisdk.logic.commandparser.CmdGeneralHttpPostDataFunc;
import com.baidu.navisdk.logic.commandparser.CmdGeneralHttpPostDataFunc.Callback;
import com.baidu.navisdk.logic.commandparser.CmdGeneralHttpRequestFunc;
import com.baidu.navisdk.logic.commandparser.CmdGeneralHttpRequestFunc.Callback;
import com.baidu.navisdk.model.datastruct.SearchPoi;
import com.baidu.navisdk.model.modelfactory.NaviDataEngine;
import com.baidu.navisdk.model.modelfactory.PoiSearchModel;
import com.baidu.navisdk.ui.routeguide.control.RGEngineControl;
import com.baidu.navisdk.ui.widget.BNDebugModelDialog;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.NetworkUtils;
import com.baidu.navisdk.util.common.PackageUtil;
import com.baidu.navisdk.util.drivertool.model.DrivingToolIssueInfo;
import com.baidu.navisdk.util.drivertool.view.BNDrivingToolDialog;
import com.baidu.navisdk.util.drivertool.view.BNDrivingToolIssueStoreDialog;
import com.baidu.navisdk.util.drivertool.view.BNDrivingToolUploadDialog;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.apache.http.NameValuePair;
import org.apache.http.client.CookieStore;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.ByteArrayBody;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;

public class BNDrivingToolManager
{
  public static final String MODULENAME = "drivingTool";
  private static BNDrivingToolManager mInstance = null;
  public boolean isIssueRet = false;
  public Boolean isLoging = Boolean.valueOf(false);
  public boolean isNoDrivingTest = false;
  public boolean isRouteRet = false;
  public boolean isSinglePerson = true;
  public boolean isTaskRet = false;
  public String mCityID = null;
  public String mCurrentAddressName = null;
  private List<String> mDataFileList = new ArrayList();
  private BNDebugModelDialog mDebugModeDialog;
  private BNDrivingToolDialog mDrivingToolDialog;
  private DrivingToolIssueInfo mDrivingToolIssueInfo = new DrivingToolIssueInfo();
  private int mFileIndex = 0;
  public Handler mHandler = new Handler(Looper.getMainLooper())
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      int i = paramAnonymousMessage.what;
      boolean bool;
      if (paramAnonymousMessage.arg1 == 0)
      {
        bool = true;
        if (i != 1406) {
          break label67;
        }
        if (bool) {
          BNDrivingToolManager.this.updateTaskListView();
        }
        LogUtil.e("drivingTool", "ret is " + bool + "TYPE_UPDATE_TASKLIST");
      }
      label67:
      label407:
      label628:
      label696:
      do
      {
        do
        {
          do
          {
            return;
            bool = false;
            break;
            if (i == 1407)
            {
              if (bool) {
                BNDrivingToolManager.this.updateRouteListView();
              }
              for (;;)
              {
                LogUtil.e("drivingTool", "ret is " + bool + "TYPE_UPDATE_ROUTELIST");
                return;
                BNDrivingToolManager.this.setRouteSpinnerClickble(true);
              }
            }
            if (i == 1408)
            {
              if (bool)
              {
                BNDrivingToolManager.this.updateIssueListView();
                BNDrivingToolManager.this.updateNewIssueDefaultAction();
              }
              LogUtil.e("drivingTool", "ret is " + bool + "TYPE_UPDATE_ISSUELIST");
              return;
            }
            if (i == 1409)
            {
              if ((bool) && (BNDrivingToolManager.this.mIssueStoreDialog != null)) {}
              LogUtil.e("drivingTool", "ret is " + bool + "TYPE_UPDATE_PERSONRELIABLE");
              return;
            }
            if (i != 1410) {
              break label696;
            }
            LogUtil.e("drivingTool", "ret is " + bool + "TYPE_UPLOAD_LOCALFILE");
            if (!bool) {
              break label628;
            }
            paramAnonymousMessage = (RspData)paramAnonymousMessage.obj;
            Object localObject = (JSONObject)paramAnonymousMessage.mData;
            if (localObject == null) {
              break label407;
            }
            localObject = ((JSONObject)localObject).optString("errno");
            BNDrivingToolUtils.log("asyn upload errno is " + (String)localObject);
            if ((localObject == null) || (((String)localObject).equals("0"))) {
              break label407;
            }
          } while (BNDrivingToolManager.this.mUploadDialog == null);
          BNDrivingToolManager.this.mUploadDialog.updateUploadFailView("上传文件" + (String)BNDrivingToolManager.this.mDataFileList.get(BNDrivingToolManager.this.mFileIndex) + "失败");
          return;
          paramAnonymousMessage = (BNDrivingToolManager.UploadFileResponseInfo)paramAnonymousMessage.mReq.mObj;
          BNDrivingToolManager.this.deleteLocalFile(paramAnonymousMessage);
          BNDrivingToolUtils.log("上传文件" + (String)BNDrivingToolManager.this.mDataFileList.get(BNDrivingToolManager.this.mFileIndex) + "成功");
          if (BNDrivingToolManager.this.mUploadDialog != null) {
            BNDrivingToolManager.this.mUploadDialog.updateUploadSuccessView("上传文件" + (String)BNDrivingToolManager.this.mDataFileList.get(BNDrivingToolManager.this.mFileIndex) + "成功");
          }
          for (;;)
          {
            BNDrivingToolManager.access$204(BNDrivingToolManager.this);
            if (BNDrivingToolManager.this.mFileIndex >= BNDrivingToolManager.this.mDataFileList.size()) {
              break;
            }
            BNDrivingToolManager.this.uploadLocalFile((String)BNDrivingToolManager.this.mIndexFileList.get(BNDrivingToolManager.this.mFileIndex), (String)BNDrivingToolManager.this.mDataFileList.get(BNDrivingToolManager.this.mFileIndex), BNDrivingToolManager.this.mFileIndex);
            return;
            if (BNDrivingToolManager.this.mUploadDialog != null) {
              BNDrivingToolManager.this.mUploadDialog.updateUploadFailView("上传文件" + (String)BNDrivingToolManager.this.mDataFileList.get(BNDrivingToolManager.this.mFileIndex) + "失败");
            }
          }
        } while (i != 1003);
        if (paramAnonymousMessage.arg1 == 0)
        {
          paramAnonymousMessage = ((PoiSearchModel)NaviDataEngine.getInstance().getModel("PoiSearchModel")).getAntiGeoPoi();
          BNDrivingToolManager.this.mCurrentAddressName = paramAnonymousMessage.mName;
          LogUtil.e("drivingTool", "mName " + BNDrivingToolManager.this.mCurrentAddressName);
        }
        for (;;)
        {
          i = Integer.parseInt(BNDrivingToolManager.this.mDrivingToolIssueInfo.mStoreType);
          if (i != 3) {
            break;
          }
          BNScreentShotManager.getInstance().screenShotFinish();
          return;
          BNDrivingToolManager.this.mCurrentAddressName = "未知";
        }
      } while (i != 2);
      BNTakePhotoManager.getInstance().photoFinishAction();
    }
  };
  private List<String> mIndexFileList = new ArrayList();
  public String mIndexFileName = null;
  public String mIssueFlag = "0";
  public List<String> mIssueList = new ArrayList();
  public Map<String, ArrayList<String>> mIssueReliableMap = new HashMap();
  private BNDrivingToolIssueStoreDialog mIssueStoreDialog;
  public List<String> mNewRouteList = new ArrayList();
  public List<String> mReliablePersonList = new ArrayList();
  public Map<String, String> mReliablePersonMap = new HashMap();
  private UploadFileResponseInfo mResponseInfo = new UploadFileResponseInfo();
  public Map<String, String> mRoadMap = new HashMap();
  public String mRouteFlag = "0";
  public String mRouteID = null;
  public List<String> mRouteList = new ArrayList();
  public String mRouteName = null;
  public String mTaskID = null;
  public List<String> mTaskList = new ArrayList();
  public Map<String, String> mTaskMap = new HashMap();
  private DrivingToolCallBack mToolCallBack;
  private BNDrivingToolUploadDialog mUploadDialog;
  private DrivingToolIssueInfo mUploadInfo = new DrivingToolIssueInfo();
  public String mUserID = null;
  
  private void asynUploadLocalFile(final String paramString)
  {
    LogUtil.e("drivingTool", "uploadLocalFile dataPath= " + paramString);
    ReqData localReqData = new ReqData("cmd.general.http.post.data.func", 7, this.mHandler, 1410, 10000);
    this.mResponseInfo.dataPath = paramString;
    this.mResponseInfo.type = this.mUploadInfo.mStoreType;
    localReqData.setObj(this.mResponseInfo);
    localReqData.mCookieStore = getCookieStore();
    CmdGeneralHttpPostDataFunc.addFunc(localReqData, new CmdGeneralHttpPostDataFunc.Callback()
    {
      public MultipartEntity getMultipartEntity()
      {
        localMultipartEntity = new MultipartEntity(HttpMultipartMode.BROWSER_COMPATIBLE);
        try
        {
          new FileBody(new File(paramString));
          Object localObject = BNDrivingToolUtils.decodeBitmapFromFile(paramString, 480, 800);
          if (String.valueOf(4).equals(BNDrivingToolManager.this.mUploadInfo.mStoreType)) {
            BNDrivingToolManager.this.mUploadInfo.mStoreType = String.valueOf(2);
          }
          localMultipartEntity.addPart(BNDrivingToolManager.this.getTypeString(BNDrivingToolManager.this.mUploadInfo.mStoreType), new ByteArrayBody((byte[])localObject, new File(paramString).getName()));
          localMultipartEntity.addPart("ignoreLogin", new StringBody("1"));
          localMultipartEntity.addPart("task_id", new StringBody(BNDrivingToolManager.this.mUploadInfo.mTaskID));
          localMultipartEntity.addPart("route_id", new StringBody(BNDrivingToolManager.this.mUploadInfo.mRouteID));
          if (!TextUtils.isEmpty(BNDrivingToolManager.this.mUploadInfo.mIssueID))
          {
            String[] arrayOfString = BNDrivingToolManager.this.mUploadInfo.mIssueID.trim().split("\\|");
            String str = BNDrivingToolManager.this.mUploadInfo.mIssueID;
            localObject = str;
            if (arrayOfString != null)
            {
              localObject = str;
              if (arrayOfString.length > 0) {
                localObject = arrayOfString[0];
              }
            }
            localMultipartEntity.addPart("problem_id", new StringBody((String)localObject));
          }
          for (;;)
          {
            localObject = BNDrivingToolManager.this.mUploadInfo.mIssueDescrption;
            if (BNDrivingToolManager.this.checkParamAdded((String)localObject)) {
              localMultipartEntity.addPart("problem_describe", new StringBody(URLEncoder.encode(BNDrivingToolManager.this.mUploadInfo.mIssueDescrption, "UTF-8")));
            }
            localObject = BNDrivingToolManager.this.mUploadInfo.mIssueType;
            if (BNDrivingToolManager.this.checkParamAdded((String)localObject)) {
              localMultipartEntity.addPart("problem_type", new StringBody(BNDrivingToolManager.this.mUploadInfo.mIssueType));
            }
            localObject = BNDrivingToolManager.this.mUploadInfo.mPersonReliableID;
            if (BNDrivingToolManager.this.checkParamAdded((String)localObject)) {
              localMultipartEntity.addPart("person_liable", new StringBody(BNDrivingToolManager.this.mUploadInfo.mPersonReliableID));
            }
            localObject = BNDrivingToolManager.this.mUploadInfo.mIssueStatus;
            if (BNDrivingToolManager.this.checkParamAdded((String)localObject)) {
              localMultipartEntity.addPart("status", new StringBody(BNDrivingToolManager.this.mUploadInfo.mIssueStatus));
            }
            localMultipartEntity.addPart("extends_info", new StringBody(BNDrivingToolManager.this.mUploadInfo.mExtendInfo));
            localMultipartEntity.addPart("problem_poi", new StringBody(BNDrivingToolManager.this.mUploadInfo.mIssueLocation));
            localMultipartEntity.addPart("problem_time", new StringBody(BNDrivingToolManager.this.mUploadInfo.mIssueTime));
            localMultipartEntity.addPart("cuid", new StringBody(BNDrivingToolManager.this.mUploadInfo.mCuid));
            localMultipartEntity.addPart("session_id", new StringBody(BNDrivingToolManager.this.mUploadInfo.mSessionID));
            LogUtil.e("drivingTool", "asynupload file prarams" + BNDrivingToolManager.this.mUploadInfo.toString());
            BNDrivingToolUtils.log("asynupload file prarams" + paramString + BNDrivingToolManager.this.mUploadInfo.toString());
            return localMultipartEntity;
            localMultipartEntity.addPart("problem_id", new StringBody(BNDrivingToolManager.this.mUploadInfo.mIssueID));
          }
          return localMultipartEntity;
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          localUnsupportedEncodingException.printStackTrace();
        }
      }
      
      public int getRequestType()
      {
        return 1;
      }
      
      public String getUrl()
      {
        if (BNDrivingToolUtils.sIsOnlineURL) {
          return BNDrivingToolParams.PUSH_ISSUE_URL_ONLINE;
        }
        return "http://10.99.23.21:8088/naviServerAdmin/submitdtrouteproblem";
      }
      
      public boolean parseResponseJSON(JSONObject paramAnonymousJSONObject)
      {
        return false;
      }
    });
    CommandCenter.getInstance().sendRequest(localReqData);
  }
  
  private boolean canUploadVideo(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while ((!paramString.endsWith(".mp4")) || (NetworkUtils.isWifiConnected())) {
      return true;
    }
    return false;
  }
  
  private boolean checkParamAdded(String paramString)
  {
    return (paramString != null) && (!paramString.equals("null"));
  }
  
  private void deleteLocalFile(UploadFileResponseInfo paramUploadFileResponseInfo)
  {
    if (paramUploadFileResponseInfo == null) {
      return;
    }
    LogUtil.e("drivingTool", "deleteLocalFile " + paramUploadFileResponseInfo.dataPath + "type= " + paramUploadFileResponseInfo.type);
    String str1 = paramUploadFileResponseInfo.dataPath;
    String str2 = paramUploadFileResponseInfo.type;
    int i = 0;
    if (str2 != null) {
      i = Integer.parseInt(str2);
    }
    if (i == 4)
    {
      new File(paramUploadFileResponseInfo.indexPath).delete();
      return;
    }
    BNDrivingToolUtils.getSuffixByType(i);
    paramUploadFileResponseInfo = str1.substring(0, str1.length() - 4);
    new File(paramUploadFileResponseInfo + ".index").delete();
  }
  
  private CookieStore getCookieStore()
  {
    BasicClientCookie localBasicClientCookie = new BasicClientCookie("BDUSS", BNaviModuleManager.getBduss());
    BasicCookieStore localBasicCookieStore = new BasicCookieStore();
    localBasicClientCookie.setDomain(".baidu.com");
    localBasicClientCookie.setPath("/");
    localBasicClientCookie.setVersion(0);
    localBasicCookieStore.addCookie(localBasicClientCookie);
    return localBasicCookieStore;
  }
  
  public static BNDrivingToolManager getInstance()
  {
    if (mInstance == null) {
      mInstance = new BNDrivingToolManager();
    }
    return mInstance;
  }
  
  private byte[] getLineBytes()
  {
    Object localObject = System.getProperty("line.separator");
    try
    {
      localObject = ((String)localObject).getBytes("utf-8");
      return (byte[])localObject;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      localUnsupportedEncodingException.printStackTrace();
    }
    return new byte[0];
  }
  
  private String getTypeString(String paramString)
  {
    int i = Integer.parseInt(paramString);
    paramString = null;
    if (i == 3) {
      paramString = "screen";
    }
    do
    {
      return paramString;
      if (i == 2) {
        return "photo";
      }
      if (i == 1) {
        return "video";
      }
    } while (i != 4);
    return "screen";
  }
  
  private void initIssueInfo()
  {
    this.mUploadInfo.mTaskID = null;
    this.mUploadInfo.mRouteID = null;
    this.mUploadInfo.mCuid = null;
    this.mUploadInfo.mIssueID = null;
    this.mUploadInfo.mStoreType = null;
    this.mUploadInfo.mIssueDescrption = null;
    this.mUploadInfo.mIssueType = null;
    this.mUploadInfo.mPersonReliableID = null;
    this.mUploadInfo.mIssueStatus = null;
    this.mUploadInfo.mExtendInfo = null;
    this.mUploadInfo.mIssueLocation = null;
    this.mUploadInfo.mIssueTime = null;
    this.mUploadInfo.mBduss = null;
    this.mUploadInfo.mSessionID = null;
  }
  
  private boolean isIndexValueEmpty(String paramString)
  {
    return paramString.equals("null");
  }
  
  private void parseIssueList(JSONObject paramJSONObject, String paramString)
  {
    if (paramJSONObject == null) {
      return;
    }
    LogUtil.e("drivingTool", "parseIssueList jsonObj = " + paramJSONObject.toString());
    for (;;)
    {
      String str;
      try
      {
        if (paramJSONObject.getInt("errno") != 0) {
          break;
        }
        str = paramString;
        if (TextUtils.isEmpty(paramString)) {
          str = this.mIssueFlag;
        }
        if (str.equals("1"))
        {
          paramJSONObject = paramJSONObject.getString("data");
          this.mDrivingToolIssueInfo.mIssueID = paramJSONObject;
          this.mIssueList.add(paramJSONObject);
          storeIssue();
          return;
        }
      }
      catch (Exception paramJSONObject)
      {
        LogUtil.e("drivingTool", paramJSONObject.toString());
        return;
      }
      if (str.equals("0"))
      {
        paramJSONObject = paramJSONObject.getJSONArray("data");
        this.mIssueList.clear();
        this.mIssueList.add("-  -  -  -  -  -  -  -  -  -  -  -  -  -  -");
        int i = 0;
        while (i < paramJSONObject.length())
        {
          paramString = paramJSONObject.getString(i);
          if (i == 0) {
            this.mDrivingToolIssueInfo.mIssueID = paramString;
          }
          this.mIssueList.add(paramString.toString());
          i += 1;
        }
      }
    }
  }
  
  /* Error */
  private void parseLocalIssue()
  {
    // Byte code:
    //   0: new 362	java/io/File
    //   3: dup
    //   4: new 261	java/lang/StringBuilder
    //   7: dup
    //   8: invokespecial 262	java/lang/StringBuilder:<init>	()V
    //   11: invokestatic 534	com/baidu/navisdk/util/drivertool/BNDrivingToolUtils:getDrivingToolDir	()Ljava/lang/String;
    //   14: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: getstatic 537	java/io/File:separator	Ljava/lang/String;
    //   20: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: ldc_w 539
    //   26: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: invokevirtual 272	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: invokespecial 367	java/io/File:<init>	(Ljava/lang/String;)V
    //   35: astore_2
    //   36: aload_2
    //   37: invokevirtual 542	java/io/File:exists	()Z
    //   40: ifne +4 -> 44
    //   43: return
    //   44: aconst_null
    //   45: astore 4
    //   47: aconst_null
    //   48: astore 7
    //   50: aconst_null
    //   51: astore_3
    //   52: aconst_null
    //   53: astore 6
    //   55: aconst_null
    //   56: astore 5
    //   58: new 544	java/io/FileReader
    //   61: dup
    //   62: aload_2
    //   63: invokespecial 547	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   66: astore_2
    //   67: new 549	java/io/BufferedReader
    //   70: dup
    //   71: aload_2
    //   72: invokespecial 552	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   75: astore_3
    //   76: aload_0
    //   77: getfield 121	com/baidu/navisdk/util/drivertool/BNDrivingToolManager:mIssueList	Ljava/util/List;
    //   80: invokeinterface 520 1 0
    //   85: aload_3
    //   86: invokevirtual 555	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   89: astore 4
    //   91: aload 4
    //   93: ifnull +54 -> 147
    //   96: aload 4
    //   98: ldc_w 557
    //   101: invokevirtual 561	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   104: astore 4
    //   106: aload_0
    //   107: getfield 108	com/baidu/navisdk/util/drivertool/BNDrivingToolManager:mDrivingToolIssueInfo	Lcom/baidu/navisdk/util/drivertool/model/DrivingToolIssueInfo;
    //   110: aload 4
    //   112: iconst_0
    //   113: aaload
    //   114: putfield 457	com/baidu/navisdk/util/drivertool/model/DrivingToolIssueInfo:mIssueID	Ljava/lang/String;
    //   117: iconst_0
    //   118: istore_1
    //   119: iload_1
    //   120: aload 4
    //   122: arraylength
    //   123: if_icmpge +24 -> 147
    //   126: aload_0
    //   127: getfield 121	com/baidu/navisdk/util/drivertool/BNDrivingToolManager:mIssueList	Ljava/util/List;
    //   130: aload 4
    //   132: iload_1
    //   133: aaload
    //   134: invokeinterface 509 2 0
    //   139: pop
    //   140: iload_1
    //   141: iconst_1
    //   142: iadd
    //   143: istore_1
    //   144: goto -25 -> 119
    //   147: aload_0
    //   148: getfield 189	com/baidu/navisdk/util/drivertool/BNDrivingToolManager:mHandler	Landroid/os/Handler;
    //   151: invokevirtual 567	android/os/Handler:obtainMessage	()Landroid/os/Message;
    //   154: astore 4
    //   156: aload 4
    //   158: sipush 1408
    //   161: putfield 572	android/os/Message:what	I
    //   164: aload 4
    //   166: iconst_0
    //   167: putfield 575	android/os/Message:arg1	I
    //   170: aload 4
    //   172: invokevirtual 578	android/os/Message:sendToTarget	()V
    //   175: aload_3
    //   176: ifnull +7 -> 183
    //   179: aload_3
    //   180: invokevirtual 581	java/io/BufferedReader:close	()V
    //   183: aload_2
    //   184: ifnull +151 -> 335
    //   187: aload_2
    //   188: invokevirtual 582	java/io/FileReader:close	()V
    //   191: return
    //   192: astore_3
    //   193: aload_3
    //   194: invokevirtual 583	java/io/IOException:printStackTrace	()V
    //   197: goto -14 -> 183
    //   200: astore_2
    //   201: aload_2
    //   202: invokevirtual 583	java/io/IOException:printStackTrace	()V
    //   205: return
    //   206: astore 6
    //   208: aload 7
    //   210: astore_2
    //   211: aload 5
    //   213: astore_3
    //   214: aload_2
    //   215: astore 4
    //   217: ldc 41
    //   219: aload 6
    //   221: invokevirtual 513	java/lang/Exception:toString	()Ljava/lang/String;
    //   224: invokestatic 278	com/baidu/navisdk/util/common/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   227: aload 5
    //   229: ifnull +8 -> 237
    //   232: aload 5
    //   234: invokevirtual 581	java/io/BufferedReader:close	()V
    //   237: aload_2
    //   238: ifnull -195 -> 43
    //   241: aload_2
    //   242: invokevirtual 582	java/io/FileReader:close	()V
    //   245: return
    //   246: astore_2
    //   247: aload_2
    //   248: invokevirtual 583	java/io/IOException:printStackTrace	()V
    //   251: return
    //   252: astore_3
    //   253: aload_3
    //   254: invokevirtual 583	java/io/IOException:printStackTrace	()V
    //   257: goto -20 -> 237
    //   260: astore_2
    //   261: aload_3
    //   262: ifnull +7 -> 269
    //   265: aload_3
    //   266: invokevirtual 581	java/io/BufferedReader:close	()V
    //   269: aload 4
    //   271: ifnull +8 -> 279
    //   274: aload 4
    //   276: invokevirtual 582	java/io/FileReader:close	()V
    //   279: aload_2
    //   280: athrow
    //   281: astore_3
    //   282: aload_3
    //   283: invokevirtual 583	java/io/IOException:printStackTrace	()V
    //   286: goto -17 -> 269
    //   289: astore_3
    //   290: aload_3
    //   291: invokevirtual 583	java/io/IOException:printStackTrace	()V
    //   294: goto -15 -> 279
    //   297: astore 5
    //   299: aload 6
    //   301: astore_3
    //   302: aload_2
    //   303: astore 4
    //   305: aload 5
    //   307: astore_2
    //   308: goto -47 -> 261
    //   311: astore 5
    //   313: aload_2
    //   314: astore 4
    //   316: aload 5
    //   318: astore_2
    //   319: goto -58 -> 261
    //   322: astore 6
    //   324: goto -113 -> 211
    //   327: astore 6
    //   329: aload_3
    //   330: astore 5
    //   332: goto -121 -> 211
    //   335: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	336	0	this	BNDrivingToolManager
    //   118	26	1	i	int
    //   35	153	2	localObject1	Object
    //   200	2	2	localIOException1	IOException
    //   210	32	2	localObject2	Object
    //   246	2	2	localIOException2	IOException
    //   260	43	2	localObject3	Object
    //   307	12	2	localObject4	Object
    //   51	129	3	localBufferedReader	java.io.BufferedReader
    //   192	2	3	localIOException3	IOException
    //   213	1	3	localObject5	Object
    //   252	14	3	localIOException4	IOException
    //   281	2	3	localIOException5	IOException
    //   289	2	3	localIOException6	IOException
    //   301	29	3	localObject6	Object
    //   45	270	4	localObject7	Object
    //   56	177	5	localObject8	Object
    //   297	9	5	localObject9	Object
    //   311	6	5	localObject10	Object
    //   330	1	5	localObject11	Object
    //   53	1	6	localObject12	Object
    //   206	94	6	localException1	Exception
    //   322	1	6	localException2	Exception
    //   327	1	6	localException3	Exception
    //   48	161	7	localObject13	Object
    // Exception table:
    //   from	to	target	type
    //   179	183	192	java/io/IOException
    //   187	191	200	java/io/IOException
    //   58	67	206	java/lang/Exception
    //   241	245	246	java/io/IOException
    //   232	237	252	java/io/IOException
    //   58	67	260	finally
    //   217	227	260	finally
    //   265	269	281	java/io/IOException
    //   274	279	289	java/io/IOException
    //   67	76	297	finally
    //   76	91	311	finally
    //   96	117	311	finally
    //   119	140	311	finally
    //   147	175	311	finally
    //   67	76	322	java/lang/Exception
    //   76	91	327	java/lang/Exception
    //   96	117	327	java/lang/Exception
    //   119	140	327	java/lang/Exception
    //   147	175	327	java/lang/Exception
  }
  
  /* Error */
  private void parseLocalReliablePerson()
  {
    // Byte code:
    //   0: new 362	java/io/File
    //   3: dup
    //   4: new 261	java/lang/StringBuilder
    //   7: dup
    //   8: invokespecial 262	java/lang/StringBuilder:<init>	()V
    //   11: invokestatic 534	com/baidu/navisdk/util/drivertool/BNDrivingToolUtils:getDrivingToolDir	()Ljava/lang/String;
    //   14: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: getstatic 537	java/io/File:separator	Ljava/lang/String;
    //   20: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: ldc_w 586
    //   26: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: invokevirtual 272	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: invokespecial 367	java/io/File:<init>	(Ljava/lang/String;)V
    //   35: astore_2
    //   36: aload_2
    //   37: invokevirtual 542	java/io/File:exists	()Z
    //   40: ifne +4 -> 44
    //   43: return
    //   44: aconst_null
    //   45: astore 4
    //   47: aconst_null
    //   48: astore 7
    //   50: aconst_null
    //   51: astore_3
    //   52: aconst_null
    //   53: astore 6
    //   55: aconst_null
    //   56: astore 5
    //   58: new 544	java/io/FileReader
    //   61: dup
    //   62: aload_2
    //   63: invokespecial 547	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   66: astore_2
    //   67: new 549	java/io/BufferedReader
    //   70: dup
    //   71: aload_2
    //   72: invokespecial 552	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   75: astore_3
    //   76: aload_0
    //   77: getfield 123	com/baidu/navisdk/util/drivertool/BNDrivingToolManager:mReliablePersonList	Ljava/util/List;
    //   80: invokeinterface 520 1 0
    //   85: aload_0
    //   86: getfield 132	com/baidu/navisdk/util/drivertool/BNDrivingToolManager:mReliablePersonMap	Ljava/util/Map;
    //   89: invokeinterface 589 1 0
    //   94: aload_3
    //   95: invokevirtual 555	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   98: astore 4
    //   100: aload 4
    //   102: ifnull +76 -> 178
    //   105: aload 4
    //   107: ldc_w 557
    //   110: invokevirtual 561	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   113: astore 4
    //   115: aload_0
    //   116: getfield 108	com/baidu/navisdk/util/drivertool/BNDrivingToolManager:mDrivingToolIssueInfo	Lcom/baidu/navisdk/util/drivertool/model/DrivingToolIssueInfo;
    //   119: aload 4
    //   121: iconst_1
    //   122: aaload
    //   123: putfield 466	com/baidu/navisdk/util/drivertool/model/DrivingToolIssueInfo:mPersonReliableID	Ljava/lang/String;
    //   126: iconst_0
    //   127: istore_1
    //   128: iload_1
    //   129: aload 4
    //   131: arraylength
    //   132: iconst_1
    //   133: isub
    //   134: if_icmpge +44 -> 178
    //   137: aload_0
    //   138: getfield 123	com/baidu/navisdk/util/drivertool/BNDrivingToolManager:mReliablePersonList	Ljava/util/List;
    //   141: aload 4
    //   143: iload_1
    //   144: aaload
    //   145: invokeinterface 509 2 0
    //   150: pop
    //   151: aload_0
    //   152: getfield 132	com/baidu/navisdk/util/drivertool/BNDrivingToolManager:mReliablePersonMap	Ljava/util/Map;
    //   155: aload 4
    //   157: iload_1
    //   158: aaload
    //   159: aload 4
    //   161: iload_1
    //   162: iconst_1
    //   163: iadd
    //   164: aaload
    //   165: invokeinterface 593 3 0
    //   170: pop
    //   171: iload_1
    //   172: iconst_2
    //   173: iadd
    //   174: istore_1
    //   175: goto -47 -> 128
    //   178: aload_0
    //   179: getfield 189	com/baidu/navisdk/util/drivertool/BNDrivingToolManager:mHandler	Landroid/os/Handler;
    //   182: invokevirtual 567	android/os/Handler:obtainMessage	()Landroid/os/Message;
    //   185: astore 4
    //   187: aload 4
    //   189: sipush 1409
    //   192: putfield 572	android/os/Message:what	I
    //   195: aload 4
    //   197: iconst_0
    //   198: putfield 575	android/os/Message:arg1	I
    //   201: aload 4
    //   203: invokevirtual 578	android/os/Message:sendToTarget	()V
    //   206: aload_3
    //   207: ifnull +7 -> 214
    //   210: aload_3
    //   211: invokevirtual 581	java/io/BufferedReader:close	()V
    //   214: aload_2
    //   215: ifnull +151 -> 366
    //   218: aload_2
    //   219: invokevirtual 582	java/io/FileReader:close	()V
    //   222: return
    //   223: astore_3
    //   224: aload_3
    //   225: invokevirtual 583	java/io/IOException:printStackTrace	()V
    //   228: goto -14 -> 214
    //   231: astore_2
    //   232: aload_2
    //   233: invokevirtual 583	java/io/IOException:printStackTrace	()V
    //   236: return
    //   237: astore 6
    //   239: aload 7
    //   241: astore_2
    //   242: aload 5
    //   244: astore_3
    //   245: aload_2
    //   246: astore 4
    //   248: ldc 41
    //   250: aload 6
    //   252: invokevirtual 513	java/lang/Exception:toString	()Ljava/lang/String;
    //   255: invokestatic 278	com/baidu/navisdk/util/common/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   258: aload 5
    //   260: ifnull +8 -> 268
    //   263: aload 5
    //   265: invokevirtual 581	java/io/BufferedReader:close	()V
    //   268: aload_2
    //   269: ifnull -226 -> 43
    //   272: aload_2
    //   273: invokevirtual 582	java/io/FileReader:close	()V
    //   276: return
    //   277: astore_2
    //   278: aload_2
    //   279: invokevirtual 583	java/io/IOException:printStackTrace	()V
    //   282: return
    //   283: astore_3
    //   284: aload_3
    //   285: invokevirtual 583	java/io/IOException:printStackTrace	()V
    //   288: goto -20 -> 268
    //   291: astore_2
    //   292: aload_3
    //   293: ifnull +7 -> 300
    //   296: aload_3
    //   297: invokevirtual 581	java/io/BufferedReader:close	()V
    //   300: aload 4
    //   302: ifnull +8 -> 310
    //   305: aload 4
    //   307: invokevirtual 582	java/io/FileReader:close	()V
    //   310: aload_2
    //   311: athrow
    //   312: astore_3
    //   313: aload_3
    //   314: invokevirtual 583	java/io/IOException:printStackTrace	()V
    //   317: goto -17 -> 300
    //   320: astore_3
    //   321: aload_3
    //   322: invokevirtual 583	java/io/IOException:printStackTrace	()V
    //   325: goto -15 -> 310
    //   328: astore 5
    //   330: aload 6
    //   332: astore_3
    //   333: aload_2
    //   334: astore 4
    //   336: aload 5
    //   338: astore_2
    //   339: goto -47 -> 292
    //   342: astore 5
    //   344: aload_2
    //   345: astore 4
    //   347: aload 5
    //   349: astore_2
    //   350: goto -58 -> 292
    //   353: astore 6
    //   355: goto -113 -> 242
    //   358: astore 6
    //   360: aload_3
    //   361: astore 5
    //   363: goto -121 -> 242
    //   366: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	367	0	this	BNDrivingToolManager
    //   127	48	1	i	int
    //   35	184	2	localObject1	Object
    //   231	2	2	localIOException1	IOException
    //   241	32	2	localObject2	Object
    //   277	2	2	localIOException2	IOException
    //   291	43	2	localObject3	Object
    //   338	12	2	localObject4	Object
    //   51	160	3	localBufferedReader	java.io.BufferedReader
    //   223	2	3	localIOException3	IOException
    //   244	1	3	localObject5	Object
    //   283	14	3	localIOException4	IOException
    //   312	2	3	localIOException5	IOException
    //   320	2	3	localIOException6	IOException
    //   332	29	3	localObject6	Object
    //   45	301	4	localObject7	Object
    //   56	208	5	localObject8	Object
    //   328	9	5	localObject9	Object
    //   342	6	5	localObject10	Object
    //   361	1	5	localObject11	Object
    //   53	1	6	localObject12	Object
    //   237	94	6	localException1	Exception
    //   353	1	6	localException2	Exception
    //   358	1	6	localException3	Exception
    //   48	192	7	localObject13	Object
    // Exception table:
    //   from	to	target	type
    //   210	214	223	java/io/IOException
    //   218	222	231	java/io/IOException
    //   58	67	237	java/lang/Exception
    //   272	276	277	java/io/IOException
    //   263	268	283	java/io/IOException
    //   58	67	291	finally
    //   248	258	291	finally
    //   296	300	312	java/io/IOException
    //   305	310	320	java/io/IOException
    //   67	76	328	finally
    //   76	100	342	finally
    //   105	126	342	finally
    //   128	171	342	finally
    //   178	206	342	finally
    //   67	76	353	java/lang/Exception
    //   76	100	358	java/lang/Exception
    //   105	126	358	java/lang/Exception
    //   128	171	358	java/lang/Exception
    //   178	206	358	java/lang/Exception
  }
  
  private void parseReliblePerson(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    for (;;)
    {
      return;
      try
      {
        LogUtil.e("drivingTool", "parseReliblePerson jsonObj = " + paramJSONObject.toString());
        if (paramJSONObject.getInt("errno") == 0)
        {
          paramJSONObject = paramJSONObject.getJSONObject("data");
          if (paramJSONObject != null)
          {
            paramJSONObject = paramJSONObject.getJSONObject("person_liable");
            Iterator localIterator1 = paramJSONObject.keys();
            this.mReliablePersonList.clear();
            this.mReliablePersonMap.clear();
            this.mIssueReliableMap.clear();
            this.mReliablePersonList.add("-  -  -  -  -  -  -  -  -  -  -  -  -  -  -");
            while (localIterator1.hasNext())
            {
              String str1 = (String)localIterator1.next();
              JSONObject localJSONObject = (JSONObject)paramJSONObject.get(str1);
              Iterator localIterator2 = localJSONObject.keys();
              ArrayList localArrayList = new ArrayList();
              while (localIterator2.hasNext())
              {
                String str2 = (String)localIterator2.next();
                String str3 = (String)localJSONObject.get(str2);
                StringBuffer localStringBuffer = new StringBuffer();
                localStringBuffer.append(str2);
                localStringBuffer.append(",");
                localStringBuffer.append(str3);
                localArrayList.add(localStringBuffer.toString());
              }
              this.mIssueReliableMap.put(str1, localArrayList);
            }
            LogUtil.e("dingbin", this.mIssueReliableMap.toString());
            return;
          }
        }
      }
      catch (Exception paramJSONObject) {}
    }
  }
  
  private void parseRoadList(JSONObject paramJSONObject, String paramString)
  {
    if (paramJSONObject == null) {}
    for (;;)
    {
      return;
      LogUtil.e("drivingTool", "parseRoadList jsonObj= " + paramJSONObject.toString());
      Object localObject;
      try
      {
        if (paramJSONObject.getInt("errno") != 0) {
          continue;
        }
        localObject = paramString;
        if (TextUtils.isEmpty(paramString)) {
          localObject = this.mRouteFlag;
        }
        if (((String)localObject).equals("1"))
        {
          paramString = paramJSONObject.getJSONObject("data");
          paramJSONObject = paramString.getString("route_name");
          paramString = paramString.getString("route_id");
          this.mRouteID = paramString;
          this.mRouteList.add(paramJSONObject);
          this.mNewRouteList.add(paramJSONObject);
          this.mRoadMap.put(paramJSONObject, paramString);
          return;
        }
      }
      catch (Exception paramJSONObject)
      {
        LogUtil.e("drivingTool", paramJSONObject.toString());
        return;
      }
      if (((String)localObject).equals("0"))
      {
        paramJSONObject = paramJSONObject.getJSONArray("data");
        this.mRouteList.clear();
        this.mRoadMap.clear();
        if (!this.mRouteList.contains("-  -  -  -  -  -  -  -  -  -  -  -  -  -  -")) {
          this.mRouteList.add("-  -  -  -  -  -  -  -  -  -  -  -  -  -  -");
        }
        this.mRouteFlag = "0";
        int i = 0;
        while (i < paramJSONObject.length())
        {
          localObject = paramJSONObject.getJSONObject(i);
          paramString = ((JSONObject)localObject).getString("route_name");
          this.mRouteList.add(paramString);
          localObject = ((JSONObject)localObject).getString("route_id");
          this.mRoadMap.put(paramString, localObject);
          i += 1;
        }
      }
    }
  }
  
  private void parseTaskListResult(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    for (;;)
    {
      return;
      LogUtil.e("drivingTool", "parseTaskListResult jsonObj= " + paramJSONObject.toString());
      try
      {
        if (paramJSONObject.getInt("errno") != 0) {
          continue;
        }
        paramJSONObject = paramJSONObject.getJSONArray("data");
        if (paramJSONObject == null) {
          continue;
        }
        this.mTaskList.clear();
        this.mTaskList.add("-  -  -  -  -  -  -  -  -  -  -  -  -  -  -");
        getInstance().mTaskMap.clear();
        int i = 0;
        while (i < paramJSONObject.length())
        {
          Object localObject = paramJSONObject.getJSONObject(i);
          String str = ((JSONObject)localObject).getString("task_name");
          if (!this.mTaskList.contains(str))
          {
            this.mTaskList.add(str);
            localObject = ((JSONObject)localObject).getString("task_id");
            getInstance().mTaskMap.put(str, localObject);
          }
          i += 1;
        }
        return;
      }
      catch (Exception paramJSONObject) {}
    }
  }
  
  /* Error */
  private String readDataPath(String paramString)
  {
    // Byte code:
    //   0: new 362	java/io/File
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 367	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_1
    //   9: aload_1
    //   10: invokevirtual 542	java/io/File:exists	()Z
    //   13: ifne +7 -> 20
    //   16: aconst_null
    //   17: astore_3
    //   18: aload_3
    //   19: areturn
    //   20: aconst_null
    //   21: astore 4
    //   23: aconst_null
    //   24: astore 7
    //   26: aconst_null
    //   27: astore_3
    //   28: aconst_null
    //   29: astore 6
    //   31: aconst_null
    //   32: astore 5
    //   34: new 544	java/io/FileReader
    //   37: dup
    //   38: aload_1
    //   39: invokespecial 547	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   42: astore_1
    //   43: new 549	java/io/BufferedReader
    //   46: dup
    //   47: aload_1
    //   48: invokespecial 552	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   51: astore_3
    //   52: new 112	java/util/ArrayList
    //   55: dup
    //   56: invokespecial 113	java/util/ArrayList:<init>	()V
    //   59: astore 4
    //   61: aload_3
    //   62: invokevirtual 555	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   65: astore 5
    //   67: aload 5
    //   69: ifnull +57 -> 126
    //   72: aload 4
    //   74: aload 5
    //   76: invokeinterface 509 2 0
    //   81: pop
    //   82: goto -21 -> 61
    //   85: astore 6
    //   87: aload_3
    //   88: astore 5
    //   90: aload 5
    //   92: astore_3
    //   93: aload_1
    //   94: astore 4
    //   96: ldc 41
    //   98: aload 6
    //   100: invokevirtual 513	java/lang/Exception:toString	()Ljava/lang/String;
    //   103: invokestatic 278	com/baidu/navisdk/util/common/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   106: aload 5
    //   108: ifnull +8 -> 116
    //   111: aload 5
    //   113: invokevirtual 581	java/io/BufferedReader:close	()V
    //   116: aload_1
    //   117: ifnull +7 -> 124
    //   120: aload_1
    //   121: invokevirtual 582	java/io/FileReader:close	()V
    //   124: aconst_null
    //   125: areturn
    //   126: aload 4
    //   128: ifnull +17 -> 145
    //   131: aload 4
    //   133: invokeinterface 653 1 0
    //   138: istore_2
    //   139: iload_2
    //   140: bipush 15
    //   142: if_icmpeq +37 -> 179
    //   145: aload_3
    //   146: ifnull +7 -> 153
    //   149: aload_3
    //   150: invokevirtual 581	java/io/BufferedReader:close	()V
    //   153: aload_1
    //   154: ifnull +7 -> 161
    //   157: aload_1
    //   158: invokevirtual 582	java/io/FileReader:close	()V
    //   161: aconst_null
    //   162: areturn
    //   163: astore_3
    //   164: aload_3
    //   165: invokevirtual 583	java/io/IOException:printStackTrace	()V
    //   168: goto -15 -> 153
    //   171: astore_1
    //   172: aload_1
    //   173: invokevirtual 583	java/io/IOException:printStackTrace	()V
    //   176: goto -15 -> 161
    //   179: aload 4
    //   181: bipush 14
    //   183: invokeinterface 656 2 0
    //   188: checkcast 335	java/lang/String
    //   191: astore 4
    //   193: aload_3
    //   194: ifnull +7 -> 201
    //   197: aload_3
    //   198: invokevirtual 581	java/io/BufferedReader:close	()V
    //   201: aload 4
    //   203: astore_3
    //   204: aload_1
    //   205: ifnull -187 -> 18
    //   208: aload_1
    //   209: invokevirtual 582	java/io/FileReader:close	()V
    //   212: aload 4
    //   214: areturn
    //   215: astore_1
    //   216: aload_1
    //   217: invokevirtual 583	java/io/IOException:printStackTrace	()V
    //   220: aload 4
    //   222: areturn
    //   223: astore_3
    //   224: aload_3
    //   225: invokevirtual 583	java/io/IOException:printStackTrace	()V
    //   228: goto -27 -> 201
    //   231: astore_3
    //   232: aload_3
    //   233: invokevirtual 583	java/io/IOException:printStackTrace	()V
    //   236: goto -120 -> 116
    //   239: astore_1
    //   240: aload_1
    //   241: invokevirtual 583	java/io/IOException:printStackTrace	()V
    //   244: goto -120 -> 124
    //   247: astore_1
    //   248: aload_3
    //   249: ifnull +7 -> 256
    //   252: aload_3
    //   253: invokevirtual 581	java/io/BufferedReader:close	()V
    //   256: aload 4
    //   258: ifnull +8 -> 266
    //   261: aload 4
    //   263: invokevirtual 582	java/io/FileReader:close	()V
    //   266: aload_1
    //   267: athrow
    //   268: astore_3
    //   269: aload_3
    //   270: invokevirtual 583	java/io/IOException:printStackTrace	()V
    //   273: goto -17 -> 256
    //   276: astore_3
    //   277: aload_3
    //   278: invokevirtual 583	java/io/IOException:printStackTrace	()V
    //   281: goto -15 -> 266
    //   284: astore 5
    //   286: aload 6
    //   288: astore_3
    //   289: aload_1
    //   290: astore 4
    //   292: aload 5
    //   294: astore_1
    //   295: goto -47 -> 248
    //   298: astore 5
    //   300: aload_1
    //   301: astore 4
    //   303: aload 5
    //   305: astore_1
    //   306: goto -58 -> 248
    //   309: astore 6
    //   311: aload 7
    //   313: astore_1
    //   314: goto -224 -> 90
    //   317: astore 6
    //   319: goto -229 -> 90
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	322	0	this	BNDrivingToolManager
    //   0	322	1	paramString	String
    //   138	5	2	i	int
    //   17	133	3	localObject1	Object
    //   163	35	3	localIOException1	IOException
    //   203	1	3	localObject2	Object
    //   223	2	3	localIOException2	IOException
    //   231	22	3	localIOException3	IOException
    //   268	2	3	localIOException4	IOException
    //   276	2	3	localIOException5	IOException
    //   288	1	3	localObject3	Object
    //   21	281	4	localObject4	Object
    //   32	80	5	localObject5	Object
    //   284	9	5	localObject6	Object
    //   298	6	5	localObject7	Object
    //   29	1	6	localObject8	Object
    //   85	202	6	localException1	Exception
    //   309	1	6	localException2	Exception
    //   317	1	6	localException3	Exception
    //   24	288	7	localObject9	Object
    // Exception table:
    //   from	to	target	type
    //   52	61	85	java/lang/Exception
    //   61	67	85	java/lang/Exception
    //   72	82	85	java/lang/Exception
    //   131	139	85	java/lang/Exception
    //   179	193	85	java/lang/Exception
    //   149	153	163	java/io/IOException
    //   157	161	171	java/io/IOException
    //   208	212	215	java/io/IOException
    //   197	201	223	java/io/IOException
    //   111	116	231	java/io/IOException
    //   120	124	239	java/io/IOException
    //   34	43	247	finally
    //   96	106	247	finally
    //   252	256	268	java/io/IOException
    //   261	266	276	java/io/IOException
    //   43	52	284	finally
    //   52	61	298	finally
    //   61	67	298	finally
    //   72	82	298	finally
    //   131	139	298	finally
    //   179	193	298	finally
    //   34	43	309	java/lang/Exception
    //   43	52	317	java/lang/Exception
  }
  
  /* Error */
  private void readIndexFile(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 659	com/baidu/navisdk/util/drivertool/BNDrivingToolManager:initIssueInfo	()V
    //   4: new 362	java/io/File
    //   7: dup
    //   8: aload_1
    //   9: invokespecial 367	java/io/File:<init>	(Ljava/lang/String;)V
    //   12: astore_1
    //   13: aload_1
    //   14: invokevirtual 542	java/io/File:exists	()Z
    //   17: ifne +4 -> 21
    //   20: return
    //   21: aconst_null
    //   22: astore 4
    //   24: aconst_null
    //   25: astore 7
    //   27: aconst_null
    //   28: astore_2
    //   29: aconst_null
    //   30: astore 6
    //   32: aconst_null
    //   33: astore 5
    //   35: new 544	java/io/FileReader
    //   38: dup
    //   39: aload_1
    //   40: invokespecial 547	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   43: astore_1
    //   44: new 549	java/io/BufferedReader
    //   47: dup
    //   48: aload_1
    //   49: invokespecial 552	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   52: astore_2
    //   53: new 112	java/util/ArrayList
    //   56: dup
    //   57: invokespecial 113	java/util/ArrayList:<init>	()V
    //   60: astore 4
    //   62: aload_2
    //   63: invokevirtual 555	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   66: astore 5
    //   68: aload 5
    //   70: ifnull +62 -> 132
    //   73: aload 4
    //   75: aload 5
    //   77: invokeinterface 509 2 0
    //   82: pop
    //   83: goto -21 -> 62
    //   86: astore 6
    //   88: aload_2
    //   89: astore 5
    //   91: aload 5
    //   93: astore_2
    //   94: aload_1
    //   95: astore 4
    //   97: ldc 41
    //   99: aload 6
    //   101: invokevirtual 513	java/lang/Exception:toString	()Ljava/lang/String;
    //   104: invokestatic 278	com/baidu/navisdk/util/common/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   107: aload 5
    //   109: ifnull +8 -> 117
    //   112: aload 5
    //   114: invokevirtual 581	java/io/BufferedReader:close	()V
    //   117: aload_1
    //   118: ifnull -98 -> 20
    //   121: aload_1
    //   122: invokevirtual 582	java/io/FileReader:close	()V
    //   125: return
    //   126: astore_1
    //   127: aload_1
    //   128: invokevirtual 583	java/io/IOException:printStackTrace	()V
    //   131: return
    //   132: aload 4
    //   134: ifnull +29 -> 163
    //   137: aload 4
    //   139: invokeinterface 653 1 0
    //   144: bipush 14
    //   146: if_icmpeq +48 -> 194
    //   149: aload 4
    //   151: invokeinterface 653 1 0
    //   156: istore_3
    //   157: iload_3
    //   158: bipush 15
    //   160: if_icmpeq +34 -> 194
    //   163: aload_2
    //   164: ifnull +7 -> 171
    //   167: aload_2
    //   168: invokevirtual 581	java/io/BufferedReader:close	()V
    //   171: aload_1
    //   172: ifnull -152 -> 20
    //   175: aload_1
    //   176: invokevirtual 582	java/io/FileReader:close	()V
    //   179: return
    //   180: astore_1
    //   181: aload_1
    //   182: invokevirtual 583	java/io/IOException:printStackTrace	()V
    //   185: return
    //   186: astore_2
    //   187: aload_2
    //   188: invokevirtual 583	java/io/IOException:printStackTrace	()V
    //   191: goto -20 -> 171
    //   194: aload_0
    //   195: getfield 110	com/baidu/navisdk/util/drivertool/BNDrivingToolManager:mUploadInfo	Lcom/baidu/navisdk/util/drivertool/model/DrivingToolIssueInfo;
    //   198: aload 4
    //   200: iconst_0
    //   201: invokeinterface 656 2 0
    //   206: checkcast 335	java/lang/String
    //   209: putfield 450	com/baidu/navisdk/util/drivertool/model/DrivingToolIssueInfo:mTaskID	Ljava/lang/String;
    //   212: aload_0
    //   213: getfield 110	com/baidu/navisdk/util/drivertool/BNDrivingToolManager:mUploadInfo	Lcom/baidu/navisdk/util/drivertool/model/DrivingToolIssueInfo;
    //   216: aload 4
    //   218: iconst_1
    //   219: invokeinterface 656 2 0
    //   224: checkcast 335	java/lang/String
    //   227: putfield 451	com/baidu/navisdk/util/drivertool/model/DrivingToolIssueInfo:mRouteID	Ljava/lang/String;
    //   230: aload_0
    //   231: getfield 110	com/baidu/navisdk/util/drivertool/BNDrivingToolManager:mUploadInfo	Lcom/baidu/navisdk/util/drivertool/model/DrivingToolIssueInfo;
    //   234: aload 4
    //   236: iconst_2
    //   237: invokeinterface 656 2 0
    //   242: checkcast 335	java/lang/String
    //   245: putfield 457	com/baidu/navisdk/util/drivertool/model/DrivingToolIssueInfo:mIssueID	Ljava/lang/String;
    //   248: aload_0
    //   249: getfield 110	com/baidu/navisdk/util/drivertool/BNDrivingToolManager:mUploadInfo	Lcom/baidu/navisdk/util/drivertool/model/DrivingToolIssueInfo;
    //   252: aload 4
    //   254: iconst_3
    //   255: invokeinterface 656 2 0
    //   260: checkcast 335	java/lang/String
    //   263: putfield 291	com/baidu/navisdk/util/drivertool/model/DrivingToolIssueInfo:mStoreType	Ljava/lang/String;
    //   266: aload_0
    //   267: getfield 110	com/baidu/navisdk/util/drivertool/BNDrivingToolManager:mUploadInfo	Lcom/baidu/navisdk/util/drivertool/model/DrivingToolIssueInfo;
    //   270: aload 4
    //   272: iconst_4
    //   273: invokeinterface 656 2 0
    //   278: checkcast 335	java/lang/String
    //   281: putfield 460	com/baidu/navisdk/util/drivertool/model/DrivingToolIssueInfo:mIssueDescrption	Ljava/lang/String;
    //   284: aload_0
    //   285: getfield 110	com/baidu/navisdk/util/drivertool/BNDrivingToolManager:mUploadInfo	Lcom/baidu/navisdk/util/drivertool/model/DrivingToolIssueInfo;
    //   288: aload 4
    //   290: iconst_5
    //   291: invokeinterface 656 2 0
    //   296: checkcast 335	java/lang/String
    //   299: putfield 463	com/baidu/navisdk/util/drivertool/model/DrivingToolIssueInfo:mIssueType	Ljava/lang/String;
    //   302: aload_0
    //   303: getfield 110	com/baidu/navisdk/util/drivertool/BNDrivingToolManager:mUploadInfo	Lcom/baidu/navisdk/util/drivertool/model/DrivingToolIssueInfo;
    //   306: aload 4
    //   308: bipush 6
    //   310: invokeinterface 656 2 0
    //   315: checkcast 335	java/lang/String
    //   318: putfield 466	com/baidu/navisdk/util/drivertool/model/DrivingToolIssueInfo:mPersonReliableID	Ljava/lang/String;
    //   321: aload_0
    //   322: getfield 110	com/baidu/navisdk/util/drivertool/BNDrivingToolManager:mUploadInfo	Lcom/baidu/navisdk/util/drivertool/model/DrivingToolIssueInfo;
    //   325: aload 4
    //   327: bipush 7
    //   329: invokeinterface 656 2 0
    //   334: checkcast 335	java/lang/String
    //   337: putfield 469	com/baidu/navisdk/util/drivertool/model/DrivingToolIssueInfo:mIssueStatus	Ljava/lang/String;
    //   340: aload_0
    //   341: getfield 110	com/baidu/navisdk/util/drivertool/BNDrivingToolManager:mUploadInfo	Lcom/baidu/navisdk/util/drivertool/model/DrivingToolIssueInfo;
    //   344: aload 4
    //   346: bipush 8
    //   348: invokeinterface 656 2 0
    //   353: checkcast 335	java/lang/String
    //   356: putfield 472	com/baidu/navisdk/util/drivertool/model/DrivingToolIssueInfo:mExtendInfo	Ljava/lang/String;
    //   359: aload_0
    //   360: getfield 110	com/baidu/navisdk/util/drivertool/BNDrivingToolManager:mUploadInfo	Lcom/baidu/navisdk/util/drivertool/model/DrivingToolIssueInfo;
    //   363: aload 4
    //   365: bipush 9
    //   367: invokeinterface 656 2 0
    //   372: checkcast 335	java/lang/String
    //   375: putfield 475	com/baidu/navisdk/util/drivertool/model/DrivingToolIssueInfo:mIssueLocation	Ljava/lang/String;
    //   378: aload_0
    //   379: getfield 110	com/baidu/navisdk/util/drivertool/BNDrivingToolManager:mUploadInfo	Lcom/baidu/navisdk/util/drivertool/model/DrivingToolIssueInfo;
    //   382: aload 4
    //   384: bipush 10
    //   386: invokeinterface 656 2 0
    //   391: checkcast 335	java/lang/String
    //   394: putfield 478	com/baidu/navisdk/util/drivertool/model/DrivingToolIssueInfo:mIssueTime	Ljava/lang/String;
    //   397: aload_0
    //   398: getfield 110	com/baidu/navisdk/util/drivertool/BNDrivingToolManager:mUploadInfo	Lcom/baidu/navisdk/util/drivertool/model/DrivingToolIssueInfo;
    //   401: aload 4
    //   403: bipush 11
    //   405: invokeinterface 656 2 0
    //   410: checkcast 335	java/lang/String
    //   413: putfield 481	com/baidu/navisdk/util/drivertool/model/DrivingToolIssueInfo:mBduss	Ljava/lang/String;
    //   416: aload_0
    //   417: getfield 110	com/baidu/navisdk/util/drivertool/BNDrivingToolManager:mUploadInfo	Lcom/baidu/navisdk/util/drivertool/model/DrivingToolIssueInfo;
    //   420: aload 4
    //   422: bipush 12
    //   424: invokeinterface 656 2 0
    //   429: checkcast 335	java/lang/String
    //   432: putfield 454	com/baidu/navisdk/util/drivertool/model/DrivingToolIssueInfo:mCuid	Ljava/lang/String;
    //   435: aload_0
    //   436: getfield 110	com/baidu/navisdk/util/drivertool/BNDrivingToolManager:mUploadInfo	Lcom/baidu/navisdk/util/drivertool/model/DrivingToolIssueInfo;
    //   439: aload 4
    //   441: bipush 13
    //   443: invokeinterface 656 2 0
    //   448: checkcast 335	java/lang/String
    //   451: putfield 484	com/baidu/navisdk/util/drivertool/model/DrivingToolIssueInfo:mSessionID	Ljava/lang/String;
    //   454: ldc 41
    //   456: aload_0
    //   457: getfield 110	com/baidu/navisdk/util/drivertool/BNDrivingToolManager:mUploadInfo	Lcom/baidu/navisdk/util/drivertool/model/DrivingToolIssueInfo;
    //   460: invokevirtual 660	com/baidu/navisdk/util/drivertool/model/DrivingToolIssueInfo:toString	()Ljava/lang/String;
    //   463: invokestatic 278	com/baidu/navisdk/util/common/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   466: aload_2
    //   467: ifnull +7 -> 474
    //   470: aload_2
    //   471: invokevirtual 581	java/io/BufferedReader:close	()V
    //   474: aload_1
    //   475: ifnull +105 -> 580
    //   478: aload_1
    //   479: invokevirtual 582	java/io/FileReader:close	()V
    //   482: return
    //   483: astore_2
    //   484: aload_2
    //   485: invokevirtual 583	java/io/IOException:printStackTrace	()V
    //   488: goto -14 -> 474
    //   491: astore_1
    //   492: aload_1
    //   493: invokevirtual 583	java/io/IOException:printStackTrace	()V
    //   496: return
    //   497: astore_2
    //   498: aload_2
    //   499: invokevirtual 583	java/io/IOException:printStackTrace	()V
    //   502: goto -385 -> 117
    //   505: astore_1
    //   506: aload_2
    //   507: ifnull +7 -> 514
    //   510: aload_2
    //   511: invokevirtual 581	java/io/BufferedReader:close	()V
    //   514: aload 4
    //   516: ifnull +8 -> 524
    //   519: aload 4
    //   521: invokevirtual 582	java/io/FileReader:close	()V
    //   524: aload_1
    //   525: athrow
    //   526: astore_2
    //   527: aload_2
    //   528: invokevirtual 583	java/io/IOException:printStackTrace	()V
    //   531: goto -17 -> 514
    //   534: astore_2
    //   535: aload_2
    //   536: invokevirtual 583	java/io/IOException:printStackTrace	()V
    //   539: goto -15 -> 524
    //   542: astore 5
    //   544: aload 6
    //   546: astore_2
    //   547: aload_1
    //   548: astore 4
    //   550: aload 5
    //   552: astore_1
    //   553: goto -47 -> 506
    //   556: astore 5
    //   558: aload_1
    //   559: astore 4
    //   561: aload 5
    //   563: astore_1
    //   564: goto -58 -> 506
    //   567: astore 6
    //   569: aload 7
    //   571: astore_1
    //   572: goto -481 -> 91
    //   575: astore 6
    //   577: goto -486 -> 91
    //   580: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	581	0	this	BNDrivingToolManager
    //   0	581	1	paramString1	String
    //   0	581	2	paramString2	String
    //   156	5	3	i	int
    //   22	538	4	localObject1	Object
    //   33	80	5	str	String
    //   542	9	5	localObject2	Object
    //   556	6	5	localObject3	Object
    //   30	1	6	localObject4	Object
    //   86	459	6	localException1	Exception
    //   567	1	6	localException2	Exception
    //   575	1	6	localException3	Exception
    //   25	545	7	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   53	62	86	java/lang/Exception
    //   62	68	86	java/lang/Exception
    //   73	83	86	java/lang/Exception
    //   137	157	86	java/lang/Exception
    //   194	466	86	java/lang/Exception
    //   121	125	126	java/io/IOException
    //   175	179	180	java/io/IOException
    //   167	171	186	java/io/IOException
    //   470	474	483	java/io/IOException
    //   478	482	491	java/io/IOException
    //   112	117	497	java/io/IOException
    //   35	44	505	finally
    //   97	107	505	finally
    //   510	514	526	java/io/IOException
    //   519	524	534	java/io/IOException
    //   44	53	542	finally
    //   53	62	556	finally
    //   62	68	556	finally
    //   73	83	556	finally
    //   137	157	556	finally
    //   194	466	556	finally
    //   35	44	567	java/lang/Exception
    //   44	53	575	java/lang/Exception
  }
  
  /* Error */
  private void storeIssue()
  {
    // Byte code:
    //   0: new 362	java/io/File
    //   3: dup
    //   4: new 261	java/lang/StringBuilder
    //   7: dup
    //   8: invokespecial 262	java/lang/StringBuilder:<init>	()V
    //   11: invokestatic 534	com/baidu/navisdk/util/drivertool/BNDrivingToolUtils:getDrivingToolDir	()Ljava/lang/String;
    //   14: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: getstatic 537	java/io/File:separator	Ljava/lang/String;
    //   20: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: ldc_w 539
    //   26: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: invokevirtual 272	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: invokespecial 367	java/io/File:<init>	(Ljava/lang/String;)V
    //   35: astore_2
    //   36: aconst_null
    //   37: astore_1
    //   38: aconst_null
    //   39: astore 4
    //   41: new 662	java/io/FileOutputStream
    //   44: dup
    //   45: aload_2
    //   46: invokespecial 663	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   49: astore_2
    //   50: aload_0
    //   51: getfield 121	com/baidu/navisdk/util/drivertool/BNDrivingToolManager:mIssueList	Ljava/util/List;
    //   54: ifnull +90 -> 144
    //   57: aload_0
    //   58: getfield 121	com/baidu/navisdk/util/drivertool/BNDrivingToolManager:mIssueList	Ljava/util/List;
    //   61: invokeinterface 653 1 0
    //   66: ifle +78 -> 144
    //   69: aload_0
    //   70: getfield 121	com/baidu/navisdk/util/drivertool/BNDrivingToolManager:mIssueList	Ljava/util/List;
    //   73: invokeinterface 666 1 0
    //   78: astore_1
    //   79: aload_1
    //   80: invokeinterface 610 1 0
    //   85: ifeq +59 -> 144
    //   88: aload_2
    //   89: aload_1
    //   90: invokeinterface 614 1 0
    //   95: checkcast 335	java/lang/String
    //   98: ldc_w 435
    //   101: invokevirtual 439	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   104: invokevirtual 670	java/io/FileOutputStream:write	([B)V
    //   107: aload_2
    //   108: ldc_w 557
    //   111: ldc_w 435
    //   114: invokevirtual 439	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   117: invokevirtual 670	java/io/FileOutputStream:write	([B)V
    //   120: goto -41 -> 79
    //   123: astore_3
    //   124: aload_2
    //   125: astore_1
    //   126: ldc 41
    //   128: aload_3
    //   129: invokevirtual 513	java/lang/Exception:toString	()Ljava/lang/String;
    //   132: invokestatic 278	com/baidu/navisdk/util/common/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   135: aload_2
    //   136: ifnull +7 -> 143
    //   139: aload_2
    //   140: invokevirtual 671	java/io/FileOutputStream:close	()V
    //   143: return
    //   144: aload_2
    //   145: ifnull +54 -> 199
    //   148: aload_2
    //   149: invokevirtual 671	java/io/FileOutputStream:close	()V
    //   152: return
    //   153: astore_1
    //   154: aload_1
    //   155: invokevirtual 583	java/io/IOException:printStackTrace	()V
    //   158: return
    //   159: astore_1
    //   160: aload_1
    //   161: invokevirtual 583	java/io/IOException:printStackTrace	()V
    //   164: return
    //   165: astore_2
    //   166: aload_1
    //   167: ifnull +7 -> 174
    //   170: aload_1
    //   171: invokevirtual 671	java/io/FileOutputStream:close	()V
    //   174: aload_2
    //   175: athrow
    //   176: astore_1
    //   177: aload_1
    //   178: invokevirtual 583	java/io/IOException:printStackTrace	()V
    //   181: goto -7 -> 174
    //   184: astore_3
    //   185: aload_2
    //   186: astore_1
    //   187: aload_3
    //   188: astore_2
    //   189: goto -23 -> 166
    //   192: astore_3
    //   193: aload 4
    //   195: astore_2
    //   196: goto -72 -> 124
    //   199: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	200	0	this	BNDrivingToolManager
    //   37	89	1	localObject1	Object
    //   153	2	1	localIOException1	IOException
    //   159	12	1	localIOException2	IOException
    //   176	2	1	localIOException3	IOException
    //   186	1	1	localObject2	Object
    //   35	114	2	localObject3	Object
    //   165	21	2	localObject4	Object
    //   188	8	2	localObject5	Object
    //   123	6	3	localException1	Exception
    //   184	4	3	localObject6	Object
    //   192	1	3	localException2	Exception
    //   39	155	4	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   50	79	123	java/lang/Exception
    //   79	120	123	java/lang/Exception
    //   148	152	153	java/io/IOException
    //   139	143	159	java/io/IOException
    //   41	50	165	finally
    //   126	135	165	finally
    //   170	174	176	java/io/IOException
    //   50	79	184	finally
    //   79	120	184	finally
    //   41	50	192	java/lang/Exception
  }
  
  /* Error */
  private void storeReliablePerson()
  {
    // Byte code:
    //   0: new 362	java/io/File
    //   3: dup
    //   4: new 261	java/lang/StringBuilder
    //   7: dup
    //   8: invokespecial 262	java/lang/StringBuilder:<init>	()V
    //   11: invokestatic 534	com/baidu/navisdk/util/drivertool/BNDrivingToolUtils:getDrivingToolDir	()Ljava/lang/String;
    //   14: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: getstatic 537	java/io/File:separator	Ljava/lang/String;
    //   20: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: ldc_w 586
    //   26: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: invokevirtual 272	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: invokespecial 367	java/io/File:<init>	(Ljava/lang/String;)V
    //   35: astore_2
    //   36: aconst_null
    //   37: astore_1
    //   38: aconst_null
    //   39: astore 4
    //   41: new 662	java/io/FileOutputStream
    //   44: dup
    //   45: aload_2
    //   46: invokespecial 663	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   49: astore_2
    //   50: aload_0
    //   51: getfield 132	com/baidu/navisdk/util/drivertool/BNDrivingToolManager:mReliablePersonMap	Ljava/util/Map;
    //   54: invokeinterface 676 1 0
    //   59: astore_1
    //   60: aload_1
    //   61: ifnull +122 -> 183
    //   64: aload_1
    //   65: invokeinterface 679 1 0
    //   70: ifle +113 -> 183
    //   73: aload_1
    //   74: invokeinterface 680 1 0
    //   79: astore_1
    //   80: aload_1
    //   81: invokeinterface 610 1 0
    //   86: ifeq +97 -> 183
    //   89: aload_1
    //   90: invokeinterface 614 1 0
    //   95: checkcast 335	java/lang/String
    //   98: astore_3
    //   99: aload_2
    //   100: aload_3
    //   101: ldc_w 435
    //   104: invokevirtual 439	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   107: invokevirtual 670	java/io/FileOutputStream:write	([B)V
    //   110: aload_2
    //   111: ldc_w 557
    //   114: ldc_w 435
    //   117: invokevirtual 439	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   120: invokevirtual 670	java/io/FileOutputStream:write	([B)V
    //   123: aload_2
    //   124: aload_0
    //   125: getfield 132	com/baidu/navisdk/util/drivertool/BNDrivingToolManager:mReliablePersonMap	Ljava/util/Map;
    //   128: aload_3
    //   129: invokeinterface 683 2 0
    //   134: checkcast 335	java/lang/String
    //   137: ldc_w 435
    //   140: invokevirtual 439	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   143: invokevirtual 670	java/io/FileOutputStream:write	([B)V
    //   146: aload_2
    //   147: ldc_w 557
    //   150: ldc_w 435
    //   153: invokevirtual 439	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   156: invokevirtual 670	java/io/FileOutputStream:write	([B)V
    //   159: goto -79 -> 80
    //   162: astore_3
    //   163: aload_2
    //   164: astore_1
    //   165: ldc 41
    //   167: aload_3
    //   168: invokevirtual 513	java/lang/Exception:toString	()Ljava/lang/String;
    //   171: invokestatic 278	com/baidu/navisdk/util/common/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   174: aload_2
    //   175: ifnull +7 -> 182
    //   178: aload_2
    //   179: invokevirtual 671	java/io/FileOutputStream:close	()V
    //   182: return
    //   183: aload_2
    //   184: ifnull +54 -> 238
    //   187: aload_2
    //   188: invokevirtual 671	java/io/FileOutputStream:close	()V
    //   191: return
    //   192: astore_1
    //   193: aload_1
    //   194: invokevirtual 583	java/io/IOException:printStackTrace	()V
    //   197: return
    //   198: astore_1
    //   199: aload_1
    //   200: invokevirtual 583	java/io/IOException:printStackTrace	()V
    //   203: return
    //   204: astore_2
    //   205: aload_1
    //   206: ifnull +7 -> 213
    //   209: aload_1
    //   210: invokevirtual 671	java/io/FileOutputStream:close	()V
    //   213: aload_2
    //   214: athrow
    //   215: astore_1
    //   216: aload_1
    //   217: invokevirtual 583	java/io/IOException:printStackTrace	()V
    //   220: goto -7 -> 213
    //   223: astore_3
    //   224: aload_2
    //   225: astore_1
    //   226: aload_3
    //   227: astore_2
    //   228: goto -23 -> 205
    //   231: astore_3
    //   232: aload 4
    //   234: astore_2
    //   235: goto -72 -> 163
    //   238: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	239	0	this	BNDrivingToolManager
    //   37	128	1	localObject1	Object
    //   192	2	1	localIOException1	IOException
    //   198	12	1	localIOException2	IOException
    //   215	2	1	localIOException3	IOException
    //   225	1	1	localObject2	Object
    //   35	153	2	localObject3	Object
    //   204	21	2	localObject4	Object
    //   227	8	2	localObject5	Object
    //   98	31	3	str	String
    //   162	6	3	localException1	Exception
    //   223	4	3	localObject6	Object
    //   231	1	3	localException2	Exception
    //   39	194	4	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   50	60	162	java/lang/Exception
    //   64	80	162	java/lang/Exception
    //   80	159	162	java/lang/Exception
    //   187	191	192	java/io/IOException
    //   178	182	198	java/io/IOException
    //   41	50	204	finally
    //   165	174	204	finally
    //   209	213	215	java/io/IOException
    //   50	60	223	finally
    //   64	80	223	finally
    //   80	159	223	finally
    //   41	50	231	java/lang/Exception
  }
  
  private void uploadLocalFile(String paramString1, String paramString2, int paramInt)
  {
    readIndexFile(paramString1, paramString2);
    this.mResponseInfo.indexPath = paramString1;
    new UploadFileTask(null).execute(new String[] { paramString2 });
  }
  
  private void uploadLocalFileInner()
  {
    this.mIndexFileList.clear();
    this.mDataFileList.clear();
    this.mFileIndex = 0;
    File[] arrayOfFile = new File(BNDrivingToolUtils.getDrivingToolDir()).listFiles();
    if (arrayOfFile == null) {}
    do
    {
      return;
      int j = arrayOfFile.length;
      int i = 0;
      if (i < j)
      {
        File localFile = arrayOfFile[i];
        String str = localFile.getName();
        if (str.endsWith(".index")) {}
        for (;;)
        {
          i += 1;
          break;
          if ((str.endsWith(".png")) || (str.endsWith(".mp4")))
          {
            int k = str.length();
            Object localObject = str.substring(0, k - 4) + ".index";
            localObject = new File(BNDrivingToolUtils.getDrivingToolDir(), (String)localObject);
            if (!((File)localObject).exists())
            {
              LogUtil.e("drivingTool", "left data file " + localFile.getName());
            }
            else if (canUploadVideo(str))
            {
              this.mIndexFileList.add(((File)localObject).getAbsolutePath());
              this.mDataFileList.add(localFile.getAbsolutePath());
            }
          }
          else if (str.endsWith(".lpdex"))
          {
            str = readDataPath(localFile.getAbsolutePath());
            if (!TextUtils.isEmpty(str))
            {
              this.mIndexFileList.add(localFile.getAbsolutePath());
              this.mDataFileList.add(str);
            }
          }
        }
      }
    } while (this.mDataFileList.size() <= 0);
    LogUtil.e("drivingTool", this.mDataFileList.toString() + " size is " + this.mDataFileList.size());
    uploadLocalFile((String)this.mIndexFileList.get(0), (String)this.mDataFileList.get(0), 0);
  }
  
  private void writeValue(FileOutputStream paramFileOutputStream, String paramString)
    throws UnsupportedEncodingException, IOException
  {
    if (!TextUtils.isEmpty(paramString)) {
      paramFileOutputStream.write(paramString.getBytes("utf-8"));
    }
    for (;;)
    {
      paramFileOutputStream.write(getLineBytes());
      return;
      paramFileOutputStream.write("null".getBytes("utf-8"));
    }
  }
  
  public void asynAntiGeoSearch(Context paramContext)
  {
    int j = 1;
    int i = j;
    if (1 == 1)
    {
      i = j;
      if (!NetworkUtils.isNetworkAvailable(paramContext)) {
        i = 0;
      }
    }
    paramContext = RGEngineControl.getInstance().getCarGeoPoint();
    BNPoiSearcher.getInstance().asynGetPoiByPoint(paramContext, i, 10000, this.mHandler);
  }
  
  public void asynPullIssueList()
  {
    final Object localObject = BNaviModuleManager.getContext();
    if ((localObject == null) || (!NetworkUtils.isNetworkAvailable((Context)localObject)))
    {
      parseLocalIssue();
      return;
    }
    localObject = new ReqData("cmd.general.httprequest.func", 7, this.mHandler, 1408, 10000);
    ((ReqData)localObject).mCookieStore = getCookieStore();
    IssuePullInfo localIssuePullInfo = new IssuePullInfo(null);
    localIssuePullInfo.issueTag = this.mIssueFlag;
    ((ReqData)localObject).mObj = localIssuePullInfo;
    CmdGeneralHttpRequestFunc.addFunc((ReqData)localObject, new CmdGeneralHttpRequestFunc.Callback()
    {
      public List<NameValuePair> getRequestParams()
      {
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(new BasicNameValuePair("task_id", BNDrivingToolManager.this.mTaskID));
        localArrayList.add(new BasicNameValuePair("route_id", BNDrivingToolManager.this.mRouteID));
        localArrayList.add(new BasicNameValuePair("cuid", PackageUtil.getCuid()));
        localArrayList.add(new BasicNameValuePair("create_new_flag", BNDrivingToolManager.this.mIssueFlag));
        localArrayList.add(new BasicNameValuePair("ignoreLogin", "1"));
        LogUtil.e("drivingTool", "asynPullIssueList getRequestParams= " + localArrayList.toString());
        return localArrayList;
      }
      
      public int getRequestType()
      {
        return 1;
      }
      
      public String getUrl()
      {
        if (BNDrivingToolUtils.sIsOnlineURL) {
          return BNDrivingToolParams.PULL_ISSUE_URL_ONLINE;
        }
        return "http://10.99.23.21:8088/naviServerAdmin/getdtproblemid";
      }
      
      public boolean parseResponseJSON(JSONObject paramAnonymousJSONObject)
      {
        BNDrivingToolManager.IssuePullInfo localIssuePullInfo = (BNDrivingToolManager.IssuePullInfo)localObject.mObj;
        String str = null;
        if (localIssuePullInfo != null) {
          str = localIssuePullInfo.issueTag;
        }
        BNDrivingToolManager.this.parseIssueList(paramAnonymousJSONObject, str);
        return false;
      }
      
      public void responseImage(byte[] paramAnonymousArrayOfByte) {}
    });
    CommandCenter.getInstance().sendRequest((ReqData)localObject);
  }
  
  public void asynPullReliablePerson()
  {
    Object localObject = BNaviModuleManager.getContext();
    if ((localObject == null) || (!NetworkUtils.isNetworkAvailable((Context)localObject)))
    {
      parseLocalReliablePerson();
      return;
    }
    localObject = new ReqData("cmd.general.httprequest.func", 7, this.mHandler, 1409, 10000);
    CmdGeneralHttpRequestFunc.addFunc((ReqData)localObject, new CmdGeneralHttpRequestFunc.Callback()
    {
      public List<NameValuePair> getRequestParams()
      {
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(new BasicNameValuePair("task_id", BNDrivingToolManager.this.mTaskID));
        localArrayList.add(new BasicNameValuePair("ignoreLogin", "1"));
        LogUtil.e("drivingTool", "asynPullReliablePerson getRequestParams= " + localArrayList.toString());
        return localArrayList;
      }
      
      public int getRequestType()
      {
        return 1;
      }
      
      public String getUrl()
      {
        if (BNDrivingToolUtils.sIsOnlineURL) {
          return BNDrivingToolParams.PULL_TASK_SET_URL_ONLINE;
        }
        return "http://10.99.23.21:8088/naviServerAdmin/getdttaskdetailconfig";
      }
      
      public boolean parseResponseJSON(JSONObject paramAnonymousJSONObject)
      {
        BNDrivingToolManager.this.parseReliblePerson(paramAnonymousJSONObject);
        return false;
      }
      
      public void responseImage(byte[] paramAnonymousArrayOfByte) {}
    });
    CommandCenter.getInstance().sendRequest((ReqData)localObject);
  }
  
  public void asynPullRoadList()
  {
    setRouteSpinnerClickble(false);
    final ReqData localReqData = new ReqData("cmd.general.httprequest.func", 7, this.mHandler, 1407, 10000);
    RoutePullInfo localRoutePullInfo = new RoutePullInfo(null);
    localRoutePullInfo.routeTag = this.mRouteFlag;
    localReqData.setObj(localRoutePullInfo);
    CmdGeneralHttpRequestFunc.addFunc(localReqData, new CmdGeneralHttpRequestFunc.Callback()
    {
      public List<NameValuePair> getRequestParams()
      {
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(new BasicNameValuePair("task_id", BNDrivingToolManager.this.mTaskID));
        BNDrivingToolManager.this.getCurrentCityID();
        localArrayList.add(new BasicNameValuePair("city_id", BNDrivingToolManager.this.mCityID));
        localArrayList.add(new BasicNameValuePair("create_new_flag", BNDrivingToolManager.this.mRouteFlag));
        localArrayList.add(new BasicNameValuePair("ignoreLogin", "1"));
        LogUtil.e("drivingTool", "asynPullRoadList getRequestParams= " + localArrayList.toString());
        return localArrayList;
      }
      
      public int getRequestType()
      {
        return 1;
      }
      
      public String getUrl()
      {
        if (BNDrivingToolUtils.sIsOnlineURL) {
          return BNDrivingToolParams.PULL_ROAD_ID_URL_ONLINE;
        }
        return "http://10.99.23.21:8088/naviServerAdmin/getdtrouteid";
      }
      
      public boolean parseResponseJSON(JSONObject paramAnonymousJSONObject)
      {
        BNDrivingToolManager.RoutePullInfo localRoutePullInfo = (BNDrivingToolManager.RoutePullInfo)localReqData.mObj;
        String str = null;
        if (localRoutePullInfo != null) {
          str = localRoutePullInfo.routeTag;
        }
        BNDrivingToolManager.this.parseRoadList(paramAnonymousJSONObject, str);
        return false;
      }
      
      public void responseImage(byte[] paramAnonymousArrayOfByte) {}
    });
    CommandCenter.getInstance().sendRequest(localReqData);
  }
  
  public void asynPullTaskList()
  {
    ReqData localReqData = new ReqData("cmd.general.httprequest.func", 7, this.mHandler, 1406, 10000);
    CmdGeneralHttpRequestFunc.addFunc(localReqData, new CmdGeneralHttpRequestFunc.Callback()
    {
      public List<NameValuePair> getRequestParams()
      {
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(new BasicNameValuePair("ignoreLogin", "1"));
        return localArrayList;
      }
      
      public int getRequestType()
      {
        return 1;
      }
      
      public String getUrl()
      {
        if (BNDrivingToolUtils.sIsOnlineURL) {
          return BNDrivingToolParams.PULL_TASKLIST_URL_ONLINE;
        }
        return "http://10.99.23.21:8088/naviServerAdmin/getdttasklist";
      }
      
      public boolean parseResponseJSON(JSONObject paramAnonymousJSONObject)
      {
        BNDrivingToolManager.this.parseTaskListResult(paramAnonymousJSONObject);
        return false;
      }
      
      public void responseImage(byte[] paramAnonymousArrayOfByte) {}
    });
    CommandCenter.getInstance().sendRequest(localReqData);
  }
  
  public boolean canDrivingToolStart()
  {
    return (this.isTaskRet) && (this.isRouteRet);
  }
  
  public void clearIssueInfo()
  {
    this.mDrivingToolIssueInfo.mIssueID = null;
    this.mDrivingToolIssueInfo.mIssueDescrption = null;
    this.mDrivingToolIssueInfo.mIssueType = null;
    this.mDrivingToolIssueInfo.mPersonReliableID = null;
    this.mDrivingToolIssueInfo.mIssueStatus = null;
  }
  
  public void dismissDrvingToolDialog()
  {
    if (this.mDrivingToolDialog != null) {
      this.mDrivingToolDialog.dismiss();
    }
  }
  
  public void getCurrentCityID()
  {
    if (this.mToolCallBack != null) {
      this.mCityID = String.valueOf(this.mToolCallBack.getCurrentCityID());
    }
  }
  
  public BNDrivingToolIssueStoreDialog getCurrentIssueStoreDialog()
  {
    return this.mIssueStoreDialog;
  }
  
  public DrivingToolIssueInfo getIssueInfo()
  {
    if (this.mDrivingToolIssueInfo == null) {
      this.mDrivingToolIssueInfo = new DrivingToolIssueInfo();
    }
    return this.mDrivingToolIssueInfo;
  }
  
  public BNDrivingToolIssueStoreDialog getIssueStoreDialog(int paramInt)
  {
    Activity localActivity = BNaviModuleManager.getNaviActivity();
    if (localActivity == null) {
      return null;
    }
    if (paramInt == 4) {
      BNAttachmentManager.getInstance().mFilePathList.clear();
    }
    for (getInstance().isNoDrivingTest = true;; getInstance().isNoDrivingTest = false)
    {
      this.mIssueStoreDialog = new BNDrivingToolIssueStoreDialog(localActivity, paramInt);
      this.mIssueStoreDialog.setOnDismissListener(new DialogInterface.OnDismissListener()
      {
        public void onDismiss(DialogInterface paramAnonymousDialogInterface)
        {
          BNDrivingToolManager.getInstance().isNoDrivingTest = false;
          BNDrivingToolManager.this.mIssueStoreDialog.setStoreViewEnable(true);
          BNDrivingToolManager.getInstance().setDrivingToolIconVisibility(true);
        }
      });
      this.mIssueStoreDialog.setCanceledOnTouchOutside(false);
      return this.mIssueStoreDialog;
    }
  }
  
  public int getLastSelectedTaskIndex()
  {
    int j;
    if ((this.mTaskMap == null) || (this.mTaskMap.size() <= 0) || (this.mTaskList == null) || (this.mTaskList.size() <= 0))
    {
      j = -1;
      return j;
    }
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
    Iterator localIterator = this.mTaskMap.entrySet().iterator();
    do
    {
      localObject2 = localObject3;
      if (!localIterator.hasNext()) {
        break;
      }
      localObject2 = (Map.Entry)localIterator.next();
    } while (!((String)((Map.Entry)localObject2).getValue()).equals(localObject1));
    localObject2 = (String)((Map.Entry)localObject2).getKey();
    if (localObject2 != null)
    {
      int i = 0;
      for (;;)
      {
        if (i >= this.mTaskList.size()) {
          break label211;
        }
        j = i;
        if (((String)localObject2).equals(this.mTaskList.get(i))) {
          break;
        }
        i += 1;
      }
    }
    label211:
    return -1;
  }
  
  public String getResourceStorePath()
  {
    return null;
  }
  
  public boolean isIssueNewCreate(String paramString)
  {
    if (this.mIssueFlag.equals("0")) {}
    while ((this.mIssueList == null) || (!((String)this.mIssueList.get(this.mIssueList.size() - 1)).equals(paramString))) {
      return false;
    }
    return true;
  }
  
  public void openDrvingToolDialog(Activity paramActivity)
  {
    this.mDrivingToolDialog = new BNDrivingToolDialog(paramActivity);
    this.mDrivingToolDialog.setOnCancelListener(new DialogInterface.OnCancelListener()
    {
      public void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        BNDrivingToolManager.this.setDrivingToolIconVisibility(true);
      }
    });
    this.mDrivingToolDialog.show();
  }
  
  public void setCurrentCityID(int paramInt)
  {
    this.mCityID = String.valueOf(paramInt);
  }
  
  public void setDebugModeDialog(BNDebugModelDialog paramBNDebugModelDialog)
  {
    this.mDebugModeDialog = paramBNDebugModelDialog;
  }
  
  public void setDrivingToolCallBack(DrivingToolCallBack paramDrivingToolCallBack)
  {
    this.mToolCallBack = paramDrivingToolCallBack;
  }
  
  public void setDrivingToolIconVisibility(boolean paramBoolean)
  {
    if (this.mToolCallBack != null) {
      this.mToolCallBack.setToolIconVisible(paramBoolean);
    }
  }
  
  public void setRouteSpinnerClickble(boolean paramBoolean)
  {
    if (this.mDebugModeDialog != null) {
      this.mDebugModeDialog.setRouteSpinnerCLickable(paramBoolean);
    }
  }
  
  /* Error */
  public void storeIndexFile(int paramInt)
  {
    // Byte code:
    //   0: iload_1
    //   1: iconst_4
    //   2: if_icmpne +213 -> 215
    //   5: invokestatic 825	com/baidu/navisdk/util/drivertool/BNAttachmentManager:getInstance	()Lcom/baidu/navisdk/util/drivertool/BNAttachmentManager;
    //   8: invokevirtual 893	com/baidu/navisdk/util/drivertool/BNAttachmentManager:getAttachmentIndexPath	()Ljava/lang/String;
    //   11: astore_2
    //   12: new 362	java/io/File
    //   15: dup
    //   16: aload_2
    //   17: invokespecial 367	java/io/File:<init>	(Ljava/lang/String;)V
    //   20: astore_3
    //   21: aconst_null
    //   22: astore_2
    //   23: aconst_null
    //   24: astore 4
    //   26: new 662	java/io/FileOutputStream
    //   29: dup
    //   30: aload_3
    //   31: invokespecial 663	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   34: astore_3
    //   35: aload_0
    //   36: aload_3
    //   37: aload_0
    //   38: getfield 136	com/baidu/navisdk/util/drivertool/BNDrivingToolManager:mTaskID	Ljava/lang/String;
    //   41: invokespecial 895	com/baidu/navisdk/util/drivertool/BNDrivingToolManager:writeValue	(Ljava/io/FileOutputStream;Ljava/lang/String;)V
    //   44: aload_0
    //   45: aload_3
    //   46: aload_0
    //   47: getfield 138	com/baidu/navisdk/util/drivertool/BNDrivingToolManager:mRouteID	Ljava/lang/String;
    //   50: invokespecial 895	com/baidu/navisdk/util/drivertool/BNDrivingToolManager:writeValue	(Ljava/io/FileOutputStream;Ljava/lang/String;)V
    //   53: aload_0
    //   54: aload_3
    //   55: aload_0
    //   56: getfield 108	com/baidu/navisdk/util/drivertool/BNDrivingToolManager:mDrivingToolIssueInfo	Lcom/baidu/navisdk/util/drivertool/model/DrivingToolIssueInfo;
    //   59: getfield 457	com/baidu/navisdk/util/drivertool/model/DrivingToolIssueInfo:mIssueID	Ljava/lang/String;
    //   62: invokespecial 895	com/baidu/navisdk/util/drivertool/BNDrivingToolManager:writeValue	(Ljava/io/FileOutputStream;Ljava/lang/String;)V
    //   65: aload_0
    //   66: aload_3
    //   67: iload_1
    //   68: invokestatic 810	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   71: invokespecial 895	com/baidu/navisdk/util/drivertool/BNDrivingToolManager:writeValue	(Ljava/io/FileOutputStream;Ljava/lang/String;)V
    //   74: aload_0
    //   75: aload_3
    //   76: aload_0
    //   77: getfield 108	com/baidu/navisdk/util/drivertool/BNDrivingToolManager:mDrivingToolIssueInfo	Lcom/baidu/navisdk/util/drivertool/model/DrivingToolIssueInfo;
    //   80: getfield 460	com/baidu/navisdk/util/drivertool/model/DrivingToolIssueInfo:mIssueDescrption	Ljava/lang/String;
    //   83: invokespecial 895	com/baidu/navisdk/util/drivertool/BNDrivingToolManager:writeValue	(Ljava/io/FileOutputStream;Ljava/lang/String;)V
    //   86: aload_0
    //   87: aload_3
    //   88: aload_0
    //   89: getfield 108	com/baidu/navisdk/util/drivertool/BNDrivingToolManager:mDrivingToolIssueInfo	Lcom/baidu/navisdk/util/drivertool/model/DrivingToolIssueInfo;
    //   92: getfield 463	com/baidu/navisdk/util/drivertool/model/DrivingToolIssueInfo:mIssueType	Ljava/lang/String;
    //   95: invokespecial 895	com/baidu/navisdk/util/drivertool/BNDrivingToolManager:writeValue	(Ljava/io/FileOutputStream;Ljava/lang/String;)V
    //   98: aload_0
    //   99: aload_3
    //   100: aload_0
    //   101: getfield 108	com/baidu/navisdk/util/drivertool/BNDrivingToolManager:mDrivingToolIssueInfo	Lcom/baidu/navisdk/util/drivertool/model/DrivingToolIssueInfo;
    //   104: getfield 466	com/baidu/navisdk/util/drivertool/model/DrivingToolIssueInfo:mPersonReliableID	Ljava/lang/String;
    //   107: invokespecial 895	com/baidu/navisdk/util/drivertool/BNDrivingToolManager:writeValue	(Ljava/io/FileOutputStream;Ljava/lang/String;)V
    //   110: aload_0
    //   111: aload_3
    //   112: aload_0
    //   113: getfield 108	com/baidu/navisdk/util/drivertool/BNDrivingToolManager:mDrivingToolIssueInfo	Lcom/baidu/navisdk/util/drivertool/model/DrivingToolIssueInfo;
    //   116: getfield 469	com/baidu/navisdk/util/drivertool/model/DrivingToolIssueInfo:mIssueStatus	Ljava/lang/String;
    //   119: invokespecial 895	com/baidu/navisdk/util/drivertool/BNDrivingToolManager:writeValue	(Ljava/io/FileOutputStream;Ljava/lang/String;)V
    //   122: aload_0
    //   123: aload_3
    //   124: aload_0
    //   125: getfield 108	com/baidu/navisdk/util/drivertool/BNDrivingToolManager:mDrivingToolIssueInfo	Lcom/baidu/navisdk/util/drivertool/model/DrivingToolIssueInfo;
    //   128: getfield 472	com/baidu/navisdk/util/drivertool/model/DrivingToolIssueInfo:mExtendInfo	Ljava/lang/String;
    //   131: invokespecial 895	com/baidu/navisdk/util/drivertool/BNDrivingToolManager:writeValue	(Ljava/io/FileOutputStream;Ljava/lang/String;)V
    //   134: aload_0
    //   135: aload_3
    //   136: aload_0
    //   137: getfield 108	com/baidu/navisdk/util/drivertool/BNDrivingToolManager:mDrivingToolIssueInfo	Lcom/baidu/navisdk/util/drivertool/model/DrivingToolIssueInfo;
    //   140: getfield 475	com/baidu/navisdk/util/drivertool/model/DrivingToolIssueInfo:mIssueLocation	Ljava/lang/String;
    //   143: invokespecial 895	com/baidu/navisdk/util/drivertool/BNDrivingToolManager:writeValue	(Ljava/io/FileOutputStream;Ljava/lang/String;)V
    //   146: aload_0
    //   147: aload_3
    //   148: aload_0
    //   149: getfield 108	com/baidu/navisdk/util/drivertool/BNDrivingToolManager:mDrivingToolIssueInfo	Lcom/baidu/navisdk/util/drivertool/model/DrivingToolIssueInfo;
    //   152: getfield 478	com/baidu/navisdk/util/drivertool/model/DrivingToolIssueInfo:mIssueTime	Ljava/lang/String;
    //   155: invokespecial 895	com/baidu/navisdk/util/drivertool/BNDrivingToolManager:writeValue	(Ljava/io/FileOutputStream;Ljava/lang/String;)V
    //   158: aload_0
    //   159: aload_3
    //   160: aload_0
    //   161: getfield 108	com/baidu/navisdk/util/drivertool/BNDrivingToolManager:mDrivingToolIssueInfo	Lcom/baidu/navisdk/util/drivertool/model/DrivingToolIssueInfo;
    //   164: getfield 481	com/baidu/navisdk/util/drivertool/model/DrivingToolIssueInfo:mBduss	Ljava/lang/String;
    //   167: invokespecial 895	com/baidu/navisdk/util/drivertool/BNDrivingToolManager:writeValue	(Ljava/io/FileOutputStream;Ljava/lang/String;)V
    //   170: aload_0
    //   171: aload_3
    //   172: invokestatic 900	com/baidu/navisdk/util/common/PackageUtil:getCuid	()Ljava/lang/String;
    //   175: invokespecial 895	com/baidu/navisdk/util/drivertool/BNDrivingToolManager:writeValue	(Ljava/io/FileOutputStream;Ljava/lang/String;)V
    //   178: aload_0
    //   179: aload_3
    //   180: aload_0
    //   181: getfield 108	com/baidu/navisdk/util/drivertool/BNDrivingToolManager:mDrivingToolIssueInfo	Lcom/baidu/navisdk/util/drivertool/model/DrivingToolIssueInfo;
    //   184: getfield 484	com/baidu/navisdk/util/drivertool/model/DrivingToolIssueInfo:mSessionID	Ljava/lang/String;
    //   187: invokespecial 895	com/baidu/navisdk/util/drivertool/BNDrivingToolManager:writeValue	(Ljava/io/FileOutputStream;Ljava/lang/String;)V
    //   190: iload_1
    //   191: iconst_4
    //   192: if_icmpne +14 -> 206
    //   195: aload_0
    //   196: aload_3
    //   197: invokestatic 825	com/baidu/navisdk/util/drivertool/BNAttachmentManager:getInstance	()Lcom/baidu/navisdk/util/drivertool/BNAttachmentManager;
    //   200: getfield 903	com/baidu/navisdk/util/drivertool/BNAttachmentManager:mCurrentFilePath	Ljava/lang/String;
    //   203: invokespecial 895	com/baidu/navisdk/util/drivertool/BNDrivingToolManager:writeValue	(Ljava/io/FileOutputStream;Ljava/lang/String;)V
    //   206: aload_3
    //   207: ifnull +121 -> 328
    //   210: aload_3
    //   211: invokevirtual 671	java/io/FileOutputStream:close	()V
    //   214: return
    //   215: new 261	java/lang/StringBuilder
    //   218: dup
    //   219: invokespecial 262	java/lang/StringBuilder:<init>	()V
    //   222: invokestatic 534	com/baidu/navisdk/util/drivertool/BNDrivingToolUtils:getDrivingToolDir	()Ljava/lang/String;
    //   225: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   228: getstatic 537	java/io/File:separator	Ljava/lang/String;
    //   231: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   234: aload_0
    //   235: getfield 150	com/baidu/navisdk/util/drivertool/BNDrivingToolManager:mIndexFileName	Ljava/lang/String;
    //   238: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   241: ldc_w 386
    //   244: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   247: invokevirtual 272	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   250: astore_2
    //   251: goto -239 -> 12
    //   254: astore_2
    //   255: aload_2
    //   256: invokevirtual 583	java/io/IOException:printStackTrace	()V
    //   259: return
    //   260: astore_2
    //   261: aload 4
    //   263: astore_3
    //   264: aload_2
    //   265: astore 4
    //   267: aload_3
    //   268: astore_2
    //   269: ldc 41
    //   271: aload 4
    //   273: invokevirtual 513	java/lang/Exception:toString	()Ljava/lang/String;
    //   276: invokestatic 278	com/baidu/navisdk/util/common/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   279: aload_3
    //   280: ifnull -66 -> 214
    //   283: aload_3
    //   284: invokevirtual 671	java/io/FileOutputStream:close	()V
    //   287: return
    //   288: astore_2
    //   289: aload_2
    //   290: invokevirtual 583	java/io/IOException:printStackTrace	()V
    //   293: return
    //   294: astore_3
    //   295: aload_2
    //   296: ifnull +7 -> 303
    //   299: aload_2
    //   300: invokevirtual 671	java/io/FileOutputStream:close	()V
    //   303: aload_3
    //   304: athrow
    //   305: astore_2
    //   306: aload_2
    //   307: invokevirtual 583	java/io/IOException:printStackTrace	()V
    //   310: goto -7 -> 303
    //   313: astore 4
    //   315: aload_3
    //   316: astore_2
    //   317: aload 4
    //   319: astore_3
    //   320: goto -25 -> 295
    //   323: astore 4
    //   325: goto -58 -> 267
    //   328: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	329	0	this	BNDrivingToolManager
    //   0	329	1	paramInt	int
    //   11	240	2	str	String
    //   254	2	2	localIOException1	IOException
    //   260	5	2	localException1	Exception
    //   268	1	2	localObject1	Object
    //   288	12	2	localIOException2	IOException
    //   305	2	2	localIOException3	IOException
    //   316	1	2	localObject2	Object
    //   20	264	3	localObject3	Object
    //   294	22	3	localObject4	Object
    //   319	1	3	localObject5	Object
    //   24	248	4	localException2	Exception
    //   313	5	4	localObject6	Object
    //   323	1	4	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   210	214	254	java/io/IOException
    //   26	35	260	java/lang/Exception
    //   283	287	288	java/io/IOException
    //   26	35	294	finally
    //   269	279	294	finally
    //   299	303	305	java/io/IOException
    //   35	190	313	finally
    //   195	206	313	finally
    //   35	190	323	java/lang/Exception
    //   195	206	323	java/lang/Exception
  }
  
  public void uninit() {}
  
  public void updateIssueListView()
  {
    if (this.mIssueStoreDialog != null) {
      this.mIssueStoreDialog.updateIssueListView();
    }
  }
  
  public void updateNewIssueDefaultAction()
  {
    if ((getInstance().mIssueFlag.equals("1")) && (this.mIssueStoreDialog != null)) {
      this.mIssueStoreDialog.updateNewIssueDefaultAction();
    }
  }
  
  public void updateReliableList(int paramInt)
  {
    if ((this.mIssueReliableMap != null) && (this.mIssueReliableMap.size() > 0))
    {
      Object localObject = (ArrayList)this.mIssueReliableMap.get(String.valueOf(paramInt));
      if ((localObject != null) && (((ArrayList)localObject).size() > 0))
      {
        this.mReliablePersonList.clear();
        this.mReliablePersonList.add("-  -  -  -  -  -  -  -  -  -  -  -  -  -  -");
        this.mReliablePersonMap.clear();
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          String[] arrayOfString = ((String)((Iterator)localObject).next()).split(",");
          this.mReliablePersonList.add(arrayOfString[1]);
          this.mReliablePersonMap.put(arrayOfString[1], arrayOfString[0]);
        }
        if (this.mIssueStoreDialog != null) {
          this.mIssueStoreDialog.updateReliablePersonView();
        }
      }
    }
  }
  
  public void updateRouteListView()
  {
    if (this.mDebugModeDialog != null) {
      this.mDebugModeDialog.updatRouteListView();
    }
  }
  
  public void updateTaskListView()
  {
    if (this.mDebugModeDialog != null) {
      this.mDebugModeDialog.updateTaskListView();
    }
  }
  
  public void uploadLocalFile()
  {
    uploadLocalFileInner();
  }
  
  public void uploadLocalMaterial(Context paramContext)
  {
    uploadLocalFile();
    this.mUploadDialog = new BNDrivingToolUploadDialog(paramContext);
    this.mUploadDialog.show();
    this.mUploadDialog.setOnCancelListener(new DialogInterface.OnCancelListener()
    {
      public void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        BNDrivingToolManager.this.setDrivingToolIconVisibility(true);
      }
    });
  }
  
  public static abstract interface DrivingToolCallBack
  {
    public abstract int getCurrentCityID();
    
    public abstract void setToolIconVisible(boolean paramBoolean);
  }
  
  private static class IssuePullInfo
  {
    public String issueTag = "0";
  }
  
  private static class RoutePullInfo
  {
    public String routeTag = "0";
  }
  
  public static class UploadFileResponseInfo
  {
    public String dataPath;
    public int index;
    public String indexPath;
    public String type;
  }
  
  private class UploadFileTask
    extends AsyncTask<String, String, String>
  {
    private UploadFileTask() {}
    
    protected String doInBackground(String... paramVarArgs)
    {
      BNDrivingToolManager.this.asynUploadLocalFile(paramVarArgs[0]);
      return null;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/util/drivertool/BNDrivingToolManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */