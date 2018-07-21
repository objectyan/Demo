package com.baidu.navisdk.ui.ugc.control;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.jni.nativeif.JNITrajectoryControl;
import com.baidu.navisdk.logic.CommandCenter;
import com.baidu.navisdk.logic.ReqData;
import com.baidu.navisdk.logic.RspData;
import com.baidu.navisdk.logic.commandparser.CmdGeneralHttpRequestFunc;
import com.baidu.navisdk.logic.commandparser.CmdGeneralHttpRequestFunc.Callback;
import com.baidu.navisdk.module.cloudconfig.CloudConfigObtainManager;
import com.baidu.navisdk.module.ugc.https.UgcHttpsUtils;
import com.baidu.navisdk.ui.routeguide.mapmode.RGMapModeViewController;
import com.baidu.navisdk.ui.ugc.model.BNRCEventDetailsModel;
import com.baidu.navisdk.ui.ugc.model.BNRCEventDetailsModel.Comment;
import com.baidu.navisdk.ui.ugc.model.BNRCEventDetailsModel.CommentsDataBuild;
import com.baidu.navisdk.ui.ugc.model.BNRCEventDetailsModel.OutlineDataBuild;
import com.baidu.navisdk.ui.ugc.view.BNRCEventDetailsView;
import com.baidu.navisdk.ui.ugc.view.BNRCEventDetailsView.UgcRCEventCallback;
import com.baidu.navisdk.ui.widget.BNLoadingViewProxy.LoadingProxy;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.PackageUtil;
import com.baidu.navisdk.util.http.HttpURLManager;
import com.baidu.navisdk.util.http.HttpURLManager.ULRParam;
import com.baidu.navisdk.util.statistic.userop.UserOPController;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class BNRCEventDetailsViewController
{
  public static final int MAX_TIME_COUNT = 15;
  public static final int MSG_BN_RC_COMMENTS = 3;
  public static final int MSG_BN_RC_EVENT_DETAILS = 1;
  public static final int MSG_BN_RC_EVENT_FEEDBACK = 2;
  public static final int MSG_BN_RC_EVENT_OUTTIME_QUIT = 5;
  public static final int SOURCE_LIGHT_NAVI = 2;
  public static final int SOURCE_NORMAL_NAVI = 1;
  public static final int SOURCE_NORMAL_NAVI_NOTIFICATION = 4;
  public static final int SOURCE_NORMAL_NAVI_ON_ROUTE = 3;
  public static final int SOURCE_OTHERS = 10;
  private static final String TAG = BNRCEventDetailsViewController.class.getSimpleName();
  private static final int VOTED_DEFAULT = 0;
  private static final int VOTED_USEFUL = 1;
  private static final int VOTED_USELESS = 2;
  private boolean isGettingComments = false;
  private boolean isGettingOutline = false;
  private String mBduss = null;
  private Context mContext = null;
  private String mEventId = null;
  private BNLoadingViewProxy.LoadingProxy mLoadingProxy = null;
  private int mSource = 10;
  private Handler mUgcHandler = null;
  private BNRCEventDetailsView.UgcRCEventCallback mUgcRCEventCallback = null;
  private BNRCEventDetailsModel model = new BNRCEventDetailsModel();
  private boolean moreCommentsPending = true;
  private BNRCEventDetailsView view;
  private int votedUpdated = 0;
  
  public static BNRCEventDetailsViewController getInstance()
  {
    return LazyLoader.instance;
  }
  
  private void initHandler()
  {
    this.mUgcHandler = new Handler(this.mContext.getMainLooper())
    {
      public void handleMessage(Message paramAnonymousMessage)
      {
        LogUtil.e(BNRCEventDetailsViewController.TAG, "handleMessage: msg.what --> " + paramAnonymousMessage.what + ", msg.arg1: " + paramAnonymousMessage.arg1);
        JSONObject localJSONObject;
        switch (paramAnonymousMessage.what)
        {
        case 4: 
        default: 
        case 1: 
        case 2: 
        case 5: 
          do
          {
            return;
            if (paramAnonymousMessage.arg1 == 0) {}
            for (;;)
            {
              try
              {
                paramAnonymousMessage = (JSONObject)((RspData)paramAnonymousMessage.obj).mData;
                if (paramAnonymousMessage.getInt("errno") != 0) {
                  continue;
                }
                localJSONObject = paramAnonymousMessage.getJSONObject("data");
                if (!BNRCEventDetailsViewController.this.parseGetEventDetailResJSON(localJSONObject)) {
                  continue;
                }
                if (BNRCEventDetailsViewController.this.model.getOutlineDataBuild() != null) {
                  BNRCEventDetailsViewController.this.model.getOutlineDataBuild().setMJsonObj(paramAnonymousMessage);
                }
                if (BNRCEventDetailsViewController.this.view != null)
                {
                  BNRCEventDetailsViewController.this.view.loadingEnd(1, null, true);
                  BNRCEventDetailsViewController.this.view.onOutlineDataSetChanged();
                }
              }
              catch (Exception paramAnonymousMessage)
              {
                paramAnonymousMessage.printStackTrace();
                LogUtil.e(BNRCEventDetailsViewController.TAG, "MSG_BN_RC_EVENT_DETAILS: -->> error 247");
                if (BNRCEventDetailsViewController.this.view == null) {
                  continue;
                }
                BNRCEventDetailsViewController.this.view.loadingEnd(1, "加载失败", false);
                continue;
                LogUtil.e(BNRCEventDetailsViewController.TAG, "MSG_BN_RC_EVENT_DETAILS: -->> error 241");
                if (BNRCEventDetailsViewController.this.view == null) {
                  continue;
                }
                BNRCEventDetailsViewController.this.view.loadingEnd(1, "加载失败", false);
                continue;
              }
              BNRCEventDetailsViewController.access$602(BNRCEventDetailsViewController.this, false);
              return;
              LogUtil.e(BNRCEventDetailsViewController.TAG, "MSG_BN_RC_EVENT_DETAILS: -->> error 234");
              if (BNRCEventDetailsViewController.this.view != null)
              {
                BNRCEventDetailsViewController.this.view.loadingEnd(1, "加载失败", false);
                continue;
                LogUtil.e(BNRCEventDetailsViewController.TAG, "MSG_BN_RC_EVENT_DETAILS: -->> network (" + paramAnonymousMessage.arg1 + ")");
                if (BNRCEventDetailsViewController.this.view != null) {
                  BNRCEventDetailsViewController.this.view.loadingEnd(1, "加载失败", false);
                }
              }
            }
            if (paramAnonymousMessage.arg1 == 0) {}
            for (;;)
            {
              try
              {
                if (((JSONObject)((RspData)paramAnonymousMessage.obj).mData).getInt("errno") != 0) {
                  continue;
                }
                if (BNRCEventDetailsViewController.this.view != null) {
                  BNRCEventDetailsViewController.this.view.loadingEnd(2, null, true);
                }
                if (BNRCEventDetailsViewController.this.votedUpdated != 1) {
                  continue;
                }
                if (BNRCEventDetailsViewController.this.view != null) {
                  BNRCEventDetailsViewController.this.view.updateUsefulOrUseless(true);
                }
              }
              catch (Exception paramAnonymousMessage)
              {
                LogUtil.e(BNRCEventDetailsViewController.TAG, "MSG_BN_RC_EVENT_FEEDBACK: -->> error 289");
                if (BNRCEventDetailsViewController.this.view == null) {
                  continue;
                }
                BNRCEventDetailsViewController.this.view.loadingEnd(2, "加载失败", false);
                continue;
                LogUtil.e(BNRCEventDetailsViewController.TAG, "MSG_BN_RC_EVENT_FEEDBACK: -->> error 283");
                if (BNRCEventDetailsViewController.this.view == null) {
                  continue;
                }
                BNRCEventDetailsViewController.this.view.loadingEnd(2, "加载失败", false);
                continue;
              }
              BNRCEventDetailsViewController.this.resetVotedUpdated();
              return;
              if ((BNRCEventDetailsViewController.this.votedUpdated == 2) && (BNRCEventDetailsViewController.this.view != null))
              {
                BNRCEventDetailsViewController.this.view.updateUsefulOrUseless(false);
                continue;
                LogUtil.e(BNRCEventDetailsViewController.TAG, "MSG_BN_RC_EVENT_FEEDBACK: -->> network (" + paramAnonymousMessage.arg1 + ")");
                if (BNRCEventDetailsViewController.this.view != null) {
                  BNRCEventDetailsViewController.this.view.loadingEnd(2, "网络错误", false);
                }
              }
            }
            BNRCEventDetailsViewController.this.onDestroy();
          } while (BNRCEventDetailsViewController.this.mUgcRCEventCallback == null);
          BNRCEventDetailsViewController.this.mUgcRCEventCallback.onFinish();
          return;
        }
        if (paramAnonymousMessage.arg1 == 0) {}
        for (;;)
        {
          try
          {
            paramAnonymousMessage = (JSONObject)((RspData)paramAnonymousMessage.obj).mData;
            if (paramAnonymousMessage.getInt("errno") != 0) {
              continue;
            }
            localJSONObject = paramAnonymousMessage.getJSONObject("data");
            if (!BNRCEventDetailsViewController.this.parseGetCommentsJSON(localJSONObject)) {
              continue;
            }
            if (BNRCEventDetailsViewController.this.model.getCommentsDataBuild() != null) {
              BNRCEventDetailsViewController.this.model.getCommentsDataBuild().setMJsonObj(paramAnonymousMessage);
            }
            if (BNRCEventDetailsViewController.this.view != null)
            {
              BNRCEventDetailsViewController.this.view.loadingEnd(3, null, true);
              BNRCEventDetailsViewController.this.view.onCommentsDataSetChanged();
            }
          }
          catch (Exception paramAnonymousMessage)
          {
            LogUtil.e(BNRCEventDetailsViewController.TAG, "MSG_BN_RC_COMMENTS: -->> error 344");
            if (BNRCEventDetailsViewController.this.view == null) {
              continue;
            }
            BNRCEventDetailsViewController.this.view.loadingEnd(3, "加载失败,请稍后重试", false);
            continue;
            paramAnonymousMessage = paramAnonymousMessage.getString("errmsg");
            LogUtil.e(BNRCEventDetailsViewController.TAG, "MSG_BN_RC_COMMENTS: -->> error 337, errMsg:" + paramAnonymousMessage);
            if (BNRCEventDetailsViewController.this.view == null) {
              continue;
            }
            BNRCEventDetailsViewController.this.view.loadingEnd(3, "加载失败,请稍后重试", false);
            continue;
          }
          BNRCEventDetailsViewController.access$1102(BNRCEventDetailsViewController.this, false);
          return;
          LogUtil.e(BNRCEventDetailsViewController.TAG, "MSG_BN_RC_COMMENTS: -->> error 330");
          if (BNRCEventDetailsViewController.this.view != null)
          {
            BNRCEventDetailsViewController.this.view.loadingEnd(3, "加载失败,请稍后重试", false);
            continue;
            LogUtil.e(BNRCEventDetailsViewController.TAG, "MSG_BN_RC_COMMENTS: -->> network (" + paramAnonymousMessage.arg1 + ")");
            if (BNRCEventDetailsViewController.this.view != null) {
              BNRCEventDetailsViewController.this.view.loadingEnd(3, "加载失败,请稍后重试", false);
            }
          }
        }
      }
    };
  }
  
  @SuppressLint({"DefaultLocale"})
  private List<NameValuePair> packetEventFeedbackReq(String paramString1, String paramString2, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    StringBuffer localStringBuffer = new StringBuffer();
    try
    {
      localArrayList.add(new BasicNameValuePair("event_id", paramString1));
      localStringBuffer.append("event_id=");
      localStringBuffer.append(URLEncoder.encode(paramString1, "utf-8"));
      localArrayList.add(new BasicNameValuePair("sid", String.valueOf(1)));
      localStringBuffer.append("&sid=");
      localStringBuffer.append(URLEncoder.encode(String.valueOf(1), "utf-8"));
      localArrayList.add(new BasicNameValuePair("cuid", PackageUtil.getCuid()));
      localStringBuffer.append("&cuid=");
      localStringBuffer.append(URLEncoder.encode(PackageUtil.getCuid(), "utf-8"));
      localArrayList.add(new BasicNameValuePair("os", String.valueOf(0)));
      localStringBuffer.append("&os=");
      localStringBuffer.append(URLEncoder.encode(String.valueOf(0), "utf-8"));
      paramString1 = String.valueOf(PackageUtil.getSystemVersion());
      localArrayList.add(new BasicNameValuePair("osv", paramString1));
      localStringBuffer.append("&osv=");
      localStringBuffer.append(URLEncoder.encode(paramString1, "utf-8"));
      localArrayList.add(new BasicNameValuePair("sv", PackageUtil.getVersionName()));
      localStringBuffer.append("&sv=");
      localStringBuffer.append(URLEncoder.encode(PackageUtil.getVersionName(), "utf-8"));
      localArrayList.add(new BasicNameValuePair("bduss", paramString2));
      localStringBuffer.append("&bduss=");
      localStringBuffer.append(URLEncoder.encode(paramString2, "utf-8"));
      if (paramBoolean) {}
      for (paramString1 = "1";; paramString1 = "2")
      {
        localArrayList.add(new BasicNameValuePair("vote_type", paramString1));
        localStringBuffer.append("&vote_type=");
        localStringBuffer.append(URLEncoder.encode(paramString1, "utf-8"));
        paramString2 = new UgcHttpsUtils().getCurrentLocationPoint();
        paramString1 = paramString2;
        if (TextUtils.isEmpty(paramString2)) {
          paramString1 = "";
        }
        localArrayList.add(new BasicNameValuePair("point", paramString1));
        localStringBuffer.append("&point=");
        localStringBuffer.append(URLEncoder.encode(paramString1, "utf-8"));
        paramString1 = String.valueOf((int)(System.currentTimeMillis() * 1000L));
        localArrayList.add(new BasicNameValuePair("st", paramString1));
        localStringBuffer.append("&st=");
        localStringBuffer.append(URLEncoder.encode(paramString1, "utf-8"));
        paramString1 = CloudConfigObtainManager.SortSequenceWithAscendingOder(localArrayList);
        localArrayList.add(new BasicNameValuePair("sign", JNITrajectoryControl.sInstance.getUrlParamsSign(paramString1)));
        return localArrayList;
      }
      return null;
    }
    catch (UnsupportedEncodingException paramString1) {}
  }
  
  private List<NameValuePair> packetGetCommentsReq(String paramString1, String paramString2)
  {
    LogUtil.e(TAG, "packetGetCommentsReq: --> eventId: " + paramString1 + ", lastCommentId: " + paramString2);
    ArrayList localArrayList = new ArrayList();
    StringBuffer localStringBuffer = new StringBuffer();
    try
    {
      localArrayList.add(new BasicNameValuePair("event_id", paramString1));
      localStringBuffer.append("event_id=");
      localStringBuffer.append(URLEncoder.encode(paramString1, "utf-8"));
      localArrayList.add(new BasicNameValuePair("comment_id", paramString2));
      localStringBuffer.append("comment_id=");
      localStringBuffer.append(URLEncoder.encode(paramString2, "utf-8"));
      localArrayList.add(new BasicNameValuePair("cuid", PackageUtil.getCuid()));
      localStringBuffer.append("&cuid=");
      localStringBuffer.append(URLEncoder.encode(PackageUtil.getCuid(), "utf-8"));
      localArrayList.add(new BasicNameValuePair("os", String.valueOf(0)));
      localStringBuffer.append("&os=");
      localStringBuffer.append(URLEncoder.encode(String.valueOf(0), "utf-8"));
      paramString1 = String.valueOf(PackageUtil.getSystemVersion());
      localArrayList.add(new BasicNameValuePair("osv", paramString1));
      localStringBuffer.append("&osv=");
      localStringBuffer.append(URLEncoder.encode(paramString1, "utf-8"));
      localArrayList.add(new BasicNameValuePair("sv", PackageUtil.getVersionName()));
      localStringBuffer.append("&sv=");
      localStringBuffer.append(URLEncoder.encode(PackageUtil.getVersionName(), "utf-8"));
      paramString1 = CloudConfigObtainManager.SortSequenceWithAscendingOder(localArrayList);
      localArrayList.add(new BasicNameValuePair("sign", JNITrajectoryControl.sInstance.getUrlParamsSign(paramString1)));
      return localArrayList;
    }
    catch (UnsupportedEncodingException paramString1) {}
    return null;
  }
  
  private boolean parseGetCommentsJSON(JSONObject paramJSONObject)
  {
    boolean bool = false;
    if (paramJSONObject == null) {
      return false;
    }
    LogUtil.e(TAG, "parseGetCommentsJSON: data --> " + paramJSONObject.toString());
    ArrayList localArrayList = new ArrayList();
    try
    {
      if (paramJSONObject.getInt("next_page") == 1) {
        bool = true;
      }
      this.moreCommentsPending = bool;
      paramJSONObject = paramJSONObject.getJSONArray("comment_list");
      int k = paramJSONObject.length();
      int i = 0;
      while (i < k)
      {
        BNRCEventDetailsModel.Comment localComment = new BNRCEventDetailsModel.Comment();
        Object localObject = paramJSONObject.getJSONObject(i);
        localComment.id = ((JSONObject)localObject).getLong("id");
        localComment.showTime = ((JSONObject)localObject).getString("show_time");
        localComment.user = ((JSONObject)localObject).getString("user");
        if (((JSONObject)localObject).has("event_pic")) {
          localComment.picUrl = ((JSONObject)localObject).getString("event_pic");
        }
        localComment.content = ((JSONObject)localObject).getString("content");
        if (((JSONObject)localObject).has("label"))
        {
          localObject = ((JSONObject)localObject).getJSONArray("label");
          if (localObject != null)
          {
            localComment.labels = new String[((JSONArray)localObject).length()];
            int j = 0;
            while (j < ((JSONArray)localObject).length())
            {
              localComment.labels[j] = ((JSONArray)localObject).getString(j);
              j += 1;
            }
          }
        }
        localArrayList.add(localComment);
        i += 1;
      }
      return true;
    }
    catch (JSONException paramJSONObject)
    {
      this.model.addComments(localArrayList);
    }
  }
  
  private boolean parseGetEventDetailResJSON(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return false;
    }
    try
    {
      int i = paramJSONObject.getInt("useful");
      this.model.setUseful(i);
      i = paramJSONObject.getInt("useless");
      this.model.setUseless(i);
      i = paramJSONObject.getInt("e_type");
      this.model.seteType(i);
      Object localObject = paramJSONObject.getString("e_icon");
      BNRCEventDetailsModel localBNRCEventDetailsModel = this.model;
      if (localObject == null) {
        localObject = null;
      }
      for (;;)
      {
        localBNRCEventDetailsModel.seteIcon((String)localObject);
        localObject = paramJSONObject.getString("e_title");
        this.model.seteTitle((String)localObject);
        localObject = paramJSONObject.getString("show_time");
        this.model.setShowTime((String)localObject);
        localObject = paramJSONObject.getString("event_pic");
        localBNRCEventDetailsModel = this.model;
        if (localObject == null)
        {
          localObject = null;
          localBNRCEventDetailsModel.setEventPic((String)localObject);
          localObject = paramJSONObject.getString("user");
          this.model.setUser((String)localObject);
          i = paramJSONObject.getInt("voted");
          this.model.setVoted(i);
        }
        try
        {
          localObject = paramJSONObject.getString("away_from");
          this.model.setAwayFrom((String)localObject);
          localObject = paramJSONObject.getString("time_interval");
          this.model.setTimeInterval((String)localObject);
          localObject = paramJSONObject.getString("content");
          this.model.setContent((String)localObject);
          localObject = paramJSONObject.getString("road_name");
          this.model.setRoadName((String)localObject);
          localObject = parseStringToArr(paramJSONObject.getString("label"));
          this.model.setLabel((String[])localObject);
          if (paramJSONObject.has("event_id"))
          {
            this.model.setEventIdPlainText(paramJSONObject.getLong("event_id"));
            break label310;
            localObject = ((String)localObject).trim();
            continue;
            localObject = ((String)localObject).trim();
          }
        }
        catch (Exception localException1)
        {
          for (;;)
          {
            localException1.printStackTrace();
          }
        }
      }
    }
    catch (JSONException paramJSONObject)
    {
      return false;
    }
    catch (Exception localException2)
    {
      for (;;) {}
    }
    label310:
    return true;
  }
  
  private String[] parseStringToArr(String paramString)
  {
    if ((paramString == null) || (paramString.length() <= 2)) {
      paramString = null;
    }
    String[] arrayOfString;
    do
    {
      return paramString;
      arrayOfString = paramString.substring(1, paramString.length() - 1).split(",");
      if (arrayOfString.length >= 1) {
        arrayOfString[0] = arrayOfString[0].replace("\"", "");
      }
      if (arrayOfString.length >= 2) {
        arrayOfString[1] = arrayOfString[1].replace("\"", "");
      }
      if ((TextUtils.isEmpty(arrayOfString[0])) && (TextUtils.isEmpty(arrayOfString[1]))) {
        return null;
      }
      if (arrayOfString.length <= 1) {
        break;
      }
      paramString = arrayOfString;
    } while (!TextUtils.isEmpty(arrayOfString[1]));
    return new String[] { arrayOfString[0] };
  }
  
  private void resetVotedUpdated()
  {
    this.votedUpdated = 0;
  }
  
  public boolean asyncGetCommentsData()
  {
    LogUtil.e(TAG, "asyncGetCommentsData: firstPage --> " + this.model.isFirstPageDataLoaded());
    if ((this.model.isFirstPageDataLoaded()) && (this.model != null) && (this.model.getCommentsDataBuild() != null) && (this.model.getCommentsDataBuild().getMJsonObj() != null))
    {
      if (this.mUgcHandler != null)
      {
        localObject = this.mUgcHandler.obtainMessage();
        ((Message)localObject).obj = new RspData(null, this.model.getCommentsDataBuild().getMJsonObj());
        ((Message)localObject).what = 3;
        this.mUgcHandler.sendMessage((Message)localObject);
      }
      LogUtil.e(TAG, "asyncGetCommentsData: --> json data existed");
      return true;
    }
    if (this.isGettingComments)
    {
      LogUtil.e(TAG, "asyncGetCommentsData: isGettingComments --> " + this.isGettingComments);
      return true;
    }
    this.isGettingComments = true;
    Object localObject = new ReqData("cmd.general.httprequest.func", 7, this.mUgcHandler, 3, 10000);
    CmdGeneralHttpRequestFunc.addFunc((ReqData)localObject, new CmdGeneralHttpRequestFunc.Callback()
    {
      public List<NameValuePair> getRequestParams()
      {
        if (BNRCEventDetailsViewController.this.model.isFirstPageDataLoaded()) {
          return BNRCEventDetailsViewController.this.packetGetCommentsReq("" + BNRCEventDetailsViewController.this.model.getEventIdPlainText(), "" + BNRCEventDetailsViewController.this.model.getEventIdPlainText());
        }
        return BNRCEventDetailsViewController.this.packetGetCommentsReq("" + BNRCEventDetailsViewController.this.model.getEventIdPlainText(), "" + BNRCEventDetailsViewController.this.model.getLastCommentId());
      }
      
      public int getRequestType()
      {
        return 1;
      }
      
      public String getUrl()
      {
        return HttpURLManager.getInstance().getUsedUrl(HttpURLManager.ULRParam.URL_UGC_GET_COMMENTS);
      }
      
      public boolean parseResponseJSON(JSONObject paramAnonymousJSONObject)
      {
        return false;
      }
      
      public void responseImage(byte[] paramAnonymousArrayOfByte) {}
    });
    CommandCenter.getInstance().sendRequest((ReqData)localObject);
    return false;
  }
  
  public boolean asyncGetRCEventDetailsData()
  {
    if ((this.model != null) && (this.model.getOutlineDataBuild() != null) && (this.model.getOutlineDataBuild().getMJsonObj() != null))
    {
      if (this.mUgcHandler != null)
      {
        localObject = this.mUgcHandler.obtainMessage();
        ((Message)localObject).obj = new RspData(null, this.model.getOutlineDataBuild().getMJsonObj());
        ((Message)localObject).what = 1;
        this.mUgcHandler.sendMessage((Message)localObject);
      }
      LogUtil.e(TAG, "asyncGetRCEventDetailsData: --> json data existed");
      return true;
    }
    if (this.isGettingOutline)
    {
      LogUtil.e(TAG, "asyncGetRCEventDetailsData: isGettingOutline --> " + this.isGettingOutline);
      return true;
    }
    this.isGettingOutline = true;
    Object localObject = new ReqData("cmd.general.httprequest.func", 7, this.mUgcHandler, 1, 10000);
    CmdGeneralHttpRequestFunc.addFunc((ReqData)localObject, new CmdGeneralHttpRequestFunc.Callback()
    {
      public List<NameValuePair> getRequestParams()
      {
        return BNRCEventDetailsViewController.this.packetGetEventDetailReq(BNRCEventDetailsViewController.this.mEventId);
      }
      
      public int getRequestType()
      {
        return 1;
      }
      
      public String getUrl()
      {
        return HttpURLManager.getInstance().getUsedUrl(HttpURLManager.ULRParam.URL_UGC_GET_EVENT_DETAIL);
      }
      
      public boolean parseResponseJSON(JSONObject paramAnonymousJSONObject)
      {
        return false;
      }
      
      public void responseImage(byte[] paramAnonymousArrayOfByte) {}
    });
    CommandCenter.getInstance().sendRequest((ReqData)localObject);
    return false;
  }
  
  public void asyncRCEventFeedbackData(final boolean paramBoolean)
  {
    ReqData localReqData = new ReqData("cmd.general.httprequest.func", 7, this.mUgcHandler, 2, 10000);
    CmdGeneralHttpRequestFunc.addFunc(localReqData, new CmdGeneralHttpRequestFunc.Callback()
    {
      public List<NameValuePair> getRequestParams()
      {
        return BNRCEventDetailsViewController.this.packetEventFeedbackReq(BNRCEventDetailsViewController.this.mEventId, BNRCEventDetailsViewController.this.mBduss, paramBoolean);
      }
      
      public int getRequestType()
      {
        return 1;
      }
      
      public String getUrl()
      {
        return HttpURLManager.getInstance().getUsedUrl(HttpURLManager.ULRParam.URL_UGC_EVENT_FEEDBACK);
      }
      
      public boolean parseResponseJSON(JSONObject paramAnonymousJSONObject)
      {
        return false;
      }
      
      public void responseImage(byte[] paramAnonymousArrayOfByte) {}
    });
    CommandCenter.getInstance().sendRequest(localReqData);
  }
  
  public void doReCalcRoute()
  {
    LogUtil.e(TAG, "doReCalcRoute: --> ");
    RGMapModeViewController.getInstance().showRefreshRoadProgess();
    BNRouteGuider.getInstance().calcOtherRoute(this.mEventId, 1, 27);
    onDestroy();
  }
  
  public Context getContext()
  {
    return this.mContext;
  }
  
  public BNLoadingViewProxy.LoadingProxy getLoadingProxy()
  {
    return this.mLoadingProxy;
  }
  
  public BNRCEventDetailsModel getModel()
  {
    return this.model;
  }
  
  public int getSource()
  {
    return this.mSource;
  }
  
  public View getView(Context paramContext, String paramString1, String paramString2, BNRCEventDetailsView.UgcRCEventCallback paramUgcRCEventCallback)
  {
    this.mSource = 10;
    return getView(paramContext, paramString1, paramString2, paramUgcRCEventCallback, 1);
  }
  
  public View getView(Context paramContext, String paramString1, String paramString2, BNRCEventDetailsView.UgcRCEventCallback paramUgcRCEventCallback, int paramInt)
  {
    if ((paramContext == null) || (paramString1 == null)) {
      return null;
    }
    LogUtil.e(TAG, "getView: --> mOrientation: " + paramInt + ", mSource: " + this.mSource);
    UserOPController.getInstance().add("3.u.2", null, null, null);
    resetUiFlags();
    this.mContext = paramContext;
    this.mEventId = paramString1;
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "";
    }
    this.mBduss = paramString1;
    this.mUgcRCEventCallback = paramUgcRCEventCallback;
    initHandler();
    this.view = new BNRCEventDetailsView(paramContext, paramUgcRCEventCallback, paramInt);
    if (this.view.getRootView() == null) {
      if (this.mUgcHandler != null) {
        this.mUgcHandler.sendEmptyMessage(5);
      }
    }
    for (;;)
    {
      return this.view.getRootView();
      if (((this.mSource == 1) || (this.mSource == 2)) && (this.mUgcHandler != null)) {
        this.mUgcHandler.sendEmptyMessageDelayed(5, 15000L);
      }
    }
  }
  
  public void initCommentsDataBuild()
  {
    BNRCEventDetailsModel.CommentsDataBuild localCommentsDataBuild = new BNRCEventDetailsModel.CommentsDataBuild();
    if (this.model != null) {
      this.model.setCommentsDataBuild(localCommentsDataBuild);
    }
  }
  
  public void initOutlineDataBuild()
  {
    BNRCEventDetailsModel.OutlineDataBuild localOutlineDataBuild = new BNRCEventDetailsModel.OutlineDataBuild();
    if (this.model != null) {
      this.model.setOutlineDataBuild(localOutlineDataBuild);
    }
  }
  
  public boolean isMoreCommentsPending()
  {
    return this.moreCommentsPending;
  }
  
  public boolean isVotedUpdated()
  {
    return this.votedUpdated != 0;
  }
  
  public boolean onBackPressed()
  {
    if (this.view == null) {
      return false;
    }
    return this.view.onBackPressed();
  }
  
  public void onDestroy()
  {
    LogUtil.e(TAG, "onDestroy:  --> ");
    if (this.view != null)
    {
      this.view.onDestroy();
      this.view = null;
    }
    if (this.mUgcHandler != null)
    {
      this.mUgcHandler.removeCallbacksAndMessages(null);
      this.mUgcHandler = null;
    }
    if (this.model != null) {
      this.model.clearData();
    }
    this.mLoadingProxy = null;
    this.moreCommentsPending = true;
    this.isGettingOutline = false;
    this.isGettingComments = false;
  }
  
  public void onFinish()
  {
    onDestroy();
    if (this.mUgcRCEventCallback != null) {
      this.mUgcRCEventCallback.onFinish();
    }
  }
  
  @SuppressLint({"DefaultLocale"})
  public List<NameValuePair> packetGetEventDetailReq(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    StringBuffer localStringBuffer = new StringBuffer();
    try
    {
      localArrayList.add(new BasicNameValuePair("event_id", paramString));
      localStringBuffer.append("event_id=");
      localStringBuffer.append(URLEncoder.encode(paramString, "utf-8"));
      localArrayList.add(new BasicNameValuePair("sid", String.valueOf(1)));
      localStringBuffer.append("&sid=");
      localStringBuffer.append(URLEncoder.encode(String.valueOf(1), "utf-8"));
      localArrayList.add(new BasicNameValuePair("cuid", PackageUtil.getCuid()));
      localStringBuffer.append("&cuid=");
      localStringBuffer.append(URLEncoder.encode(PackageUtil.getCuid(), "utf-8"));
      localArrayList.add(new BasicNameValuePair("os", String.valueOf(0)));
      localStringBuffer.append("&os=");
      localStringBuffer.append(URLEncoder.encode(String.valueOf(0), "utf-8"));
      paramString = String.valueOf(PackageUtil.getSystemVersion());
      localArrayList.add(new BasicNameValuePair("osv", paramString));
      localStringBuffer.append("&osv=");
      localStringBuffer.append(URLEncoder.encode(paramString, "utf-8"));
      localArrayList.add(new BasicNameValuePair("sv", PackageUtil.getVersionName()));
      localStringBuffer.append("&sv=");
      localStringBuffer.append(URLEncoder.encode(PackageUtil.getVersionName(), "utf-8"));
      paramString = new UgcHttpsUtils().getCurrentLocationPoint();
      localArrayList.add(new BasicNameValuePair("point", paramString));
      localStringBuffer.append("&point=");
      localStringBuffer.append(URLEncoder.encode(paramString, "utf-8"));
      paramString = String.valueOf((int)(System.currentTimeMillis() * 1000L));
      localArrayList.add(new BasicNameValuePair("st", paramString));
      localStringBuffer.append("&st=");
      localStringBuffer.append(URLEncoder.encode(paramString, "utf-8"));
      paramString = CloudConfigObtainManager.SortSequenceWithAscendingOder(localArrayList);
      localArrayList.add(new BasicNameValuePair("sign", JNITrajectoryControl.sInstance.getUrlParamsSign(paramString)));
      return localArrayList;
    }
    catch (UnsupportedEncodingException paramString) {}
    return null;
  }
  
  public void resetUiFlags()
  {
    LogUtil.e(TAG, "resetUiFlags:  --> ");
    resetVotedUpdated();
  }
  
  public void setIsShowZoomView(boolean paramBoolean)
  {
    if ((this.model != null) && (this.model.getOutlineDataBuild() != null)) {
      this.model.getOutlineDataBuild().setIsShowZoomView(paramBoolean);
    }
  }
  
  public void setLoadingProxy(BNLoadingViewProxy.LoadingProxy paramLoadingProxy)
  {
    this.mLoadingProxy = paramLoadingProxy;
  }
  
  public void setSource(int paramInt)
  {
    this.mSource = paramInt;
  }
  
  public void setVotedUpdated(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.votedUpdated = 1;
      return;
    }
    this.votedUpdated = 2;
  }
  
  public void stopTimer()
  {
    if (this.mUgcHandler != null) {
      this.mUgcHandler.removeMessages(5);
    }
  }
  
  private static class LazyLoader
  {
    private static BNRCEventDetailsViewController instance = new BNRCEventDetailsViewController(null);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/ugc/control/BNRCEventDetailsViewController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */