package com.baidu.navisdk.ui.ugc.control;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import com.baidu.carlife.radio.p080b.C2125n;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.jni.nativeif.JNITrajectoryControl;
import com.baidu.navisdk.logic.CommandCenter;
import com.baidu.navisdk.logic.CommandConstants;
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
import com.baidu.navisdk.util.statistic.userop.UserOPParams;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class BNRCEventDetailsViewController {
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
    private boolean isGettingComments;
    private boolean isGettingOutline;
    private String mBduss;
    private Context mContext;
    private String mEventId;
    private LoadingProxy mLoadingProxy;
    private int mSource;
    private Handler mUgcHandler;
    private UgcRCEventCallback mUgcRCEventCallback;
    private BNRCEventDetailsModel model;
    private boolean moreCommentsPending;
    private BNRCEventDetailsView view;
    private int votedUpdated;

    /* renamed from: com.baidu.navisdk.ui.ugc.control.BNRCEventDetailsViewController$2 */
    class C44952 implements Callback {
        C44952() {
        }

        public void responseImage(byte[] img) {
        }

        public boolean parseResponseJSON(JSONObject jsonObj) {
            return false;
        }

        public String getUrl() {
            return HttpURLManager.getInstance().getUsedUrl(ULRParam.URL_UGC_GET_EVENT_DETAIL);
        }

        public int getRequestType() {
            return 1;
        }

        public List<NameValuePair> getRequestParams() {
            return BNRCEventDetailsViewController.this.packetGetEventDetailReq(BNRCEventDetailsViewController.this.mEventId);
        }
    }

    /* renamed from: com.baidu.navisdk.ui.ugc.control.BNRCEventDetailsViewController$3 */
    class C44963 implements Callback {
        C44963() {
        }

        public void responseImage(byte[] img) {
        }

        public boolean parseResponseJSON(JSONObject jsonObj) {
            return false;
        }

        public String getUrl() {
            return HttpURLManager.getInstance().getUsedUrl(ULRParam.URL_UGC_GET_COMMENTS);
        }

        public int getRequestType() {
            return 1;
        }

        public List<NameValuePair> getRequestParams() {
            if (BNRCEventDetailsViewController.this.model.isFirstPageDataLoaded()) {
                return BNRCEventDetailsViewController.this.packetGetCommentsReq("" + BNRCEventDetailsViewController.this.model.getEventIdPlainText(), "" + BNRCEventDetailsViewController.this.model.getEventIdPlainText());
            }
            return BNRCEventDetailsViewController.this.packetGetCommentsReq("" + BNRCEventDetailsViewController.this.model.getEventIdPlainText(), "" + BNRCEventDetailsViewController.this.model.getLastCommentId());
        }
    }

    private static class LazyLoader {
        private static BNRCEventDetailsViewController instance = new BNRCEventDetailsViewController();

        private LazyLoader() {
        }
    }

    private BNRCEventDetailsViewController() {
        this.mContext = null;
        this.mEventId = null;
        this.mBduss = null;
        this.mUgcHandler = null;
        this.votedUpdated = 0;
        this.mUgcRCEventCallback = null;
        this.mLoadingProxy = null;
        this.mSource = 10;
        this.isGettingOutline = false;
        this.isGettingComments = false;
        this.moreCommentsPending = true;
        this.model = new BNRCEventDetailsModel();
    }

    public static BNRCEventDetailsViewController getInstance() {
        return LazyLoader.instance;
    }

    public View getView(Context context, String eventId, String bduss, UgcRCEventCallback ugcRCEventCallback) {
        this.mSource = 10;
        return getView(context, eventId, bduss, ugcRCEventCallback, 1);
    }

    public View getView(Context context, String eventId, String bduss, UgcRCEventCallback ugcRCEventCallback, int mOrientation) {
        if (context == null || eventId == null) {
            return null;
        }
        LogUtil.m15791e(TAG, "getView: --> mOrientation: " + mOrientation + ", mSource: " + this.mSource);
        UserOPController.getInstance().add(UserOPParams.GUIDE_3_u_2, null, null, null);
        resetUiFlags();
        this.mContext = context;
        this.mEventId = eventId;
        if (bduss == null) {
            bduss = "";
        }
        this.mBduss = bduss;
        this.mUgcRCEventCallback = ugcRCEventCallback;
        initHandler();
        this.view = new BNRCEventDetailsView(context, ugcRCEventCallback, mOrientation);
        if (this.view.getRootView() == null) {
            if (this.mUgcHandler != null) {
                this.mUgcHandler.sendEmptyMessage(5);
            }
        } else if ((this.mSource == 1 || this.mSource == 2) && this.mUgcHandler != null) {
            this.mUgcHandler.sendEmptyMessageDelayed(5, 15000);
        }
        return this.view.getRootView();
    }

    public void stopTimer() {
        if (this.mUgcHandler != null) {
            this.mUgcHandler.removeMessages(5);
        }
    }

    public boolean onBackPressed() {
        if (this.view == null) {
            return false;
        }
        return this.view.onBackPressed();
    }

    public void resetUiFlags() {
        LogUtil.m15791e(TAG, "resetUiFlags:  --> ");
        resetVotedUpdated();
    }

    public void onDestroy() {
        LogUtil.m15791e(TAG, "onDestroy:  --> ");
        if (this.view != null) {
            this.view.onDestroy();
            this.view = null;
        }
        if (this.mUgcHandler != null) {
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

    private void initHandler() {
        this.mUgcHandler = new Handler(this.mContext.getMainLooper()) {
            public void handleMessage(Message msg) {
                LogUtil.m15791e(BNRCEventDetailsViewController.TAG, "handleMessage: msg.what --> " + msg.what + ", msg.arg1: " + msg.arg1);
                JSONObject json;
                switch (msg.what) {
                    case 1:
                        if (msg.arg1 == 0) {
                            try {
                                json = msg.obj.mData;
                                if (json.getInt(C2125n.f6745M) == 0) {
                                    if (BNRCEventDetailsViewController.this.parseGetEventDetailResJSON(json.getJSONObject("data"))) {
                                        if (BNRCEventDetailsViewController.this.model.getOutlineDataBuild() != null) {
                                            BNRCEventDetailsViewController.this.model.getOutlineDataBuild().setMJsonObj(json);
                                        }
                                        if (BNRCEventDetailsViewController.this.view != null) {
                                            BNRCEventDetailsViewController.this.view.loadingEnd(1, null, true);
                                            BNRCEventDetailsViewController.this.view.onOutlineDataSetChanged();
                                        }
                                    } else {
                                        LogUtil.m15791e(BNRCEventDetailsViewController.TAG, "MSG_BN_RC_EVENT_DETAILS: -->> error 234");
                                        if (BNRCEventDetailsViewController.this.view != null) {
                                            BNRCEventDetailsViewController.this.view.loadingEnd(1, "加载失败", false);
                                        }
                                    }
                                } else {
                                    LogUtil.m15791e(BNRCEventDetailsViewController.TAG, "MSG_BN_RC_EVENT_DETAILS: -->> error 241");
                                    if (BNRCEventDetailsViewController.this.view != null) {
                                        BNRCEventDetailsViewController.this.view.loadingEnd(1, "加载失败", false);
                                    }
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                                LogUtil.m15791e(BNRCEventDetailsViewController.TAG, "MSG_BN_RC_EVENT_DETAILS: -->> error 247");
                                if (BNRCEventDetailsViewController.this.view != null) {
                                    BNRCEventDetailsViewController.this.view.loadingEnd(1, "加载失败", false);
                                }
                            }
                        } else {
                            LogUtil.m15791e(BNRCEventDetailsViewController.TAG, "MSG_BN_RC_EVENT_DETAILS: -->> network (" + msg.arg1 + ")");
                            if (BNRCEventDetailsViewController.this.view != null) {
                                BNRCEventDetailsViewController.this.view.loadingEnd(1, "加载失败", false);
                            }
                        }
                        BNRCEventDetailsViewController.this.isGettingOutline = false;
                        return;
                    case 2:
                        if (msg.arg1 == 0) {
                            try {
                                if (((JSONObject) ((RspData) msg.obj).mData).getInt(C2125n.f6745M) == 0) {
                                    if (BNRCEventDetailsViewController.this.view != null) {
                                        BNRCEventDetailsViewController.this.view.loadingEnd(2, null, true);
                                    }
                                    if (BNRCEventDetailsViewController.this.votedUpdated == 1) {
                                        if (BNRCEventDetailsViewController.this.view != null) {
                                            BNRCEventDetailsViewController.this.view.updateUsefulOrUseless(true);
                                        }
                                    } else if (BNRCEventDetailsViewController.this.votedUpdated == 2 && BNRCEventDetailsViewController.this.view != null) {
                                        BNRCEventDetailsViewController.this.view.updateUsefulOrUseless(false);
                                    }
                                } else {
                                    LogUtil.m15791e(BNRCEventDetailsViewController.TAG, "MSG_BN_RC_EVENT_FEEDBACK: -->> error 283");
                                    if (BNRCEventDetailsViewController.this.view != null) {
                                        BNRCEventDetailsViewController.this.view.loadingEnd(2, "加载失败", false);
                                    }
                                }
                            } catch (Exception e2) {
                                LogUtil.m15791e(BNRCEventDetailsViewController.TAG, "MSG_BN_RC_EVENT_FEEDBACK: -->> error 289");
                                if (BNRCEventDetailsViewController.this.view != null) {
                                    BNRCEventDetailsViewController.this.view.loadingEnd(2, "加载失败", false);
                                }
                            }
                        } else {
                            LogUtil.m15791e(BNRCEventDetailsViewController.TAG, "MSG_BN_RC_EVENT_FEEDBACK: -->> network (" + msg.arg1 + ")");
                            if (BNRCEventDetailsViewController.this.view != null) {
                                BNRCEventDetailsViewController.this.view.loadingEnd(2, "网络错误", false);
                            }
                        }
                        BNRCEventDetailsViewController.this.resetVotedUpdated();
                        return;
                    case 3:
                        if (msg.arg1 == 0) {
                            try {
                                json = (JSONObject) ((RspData) msg.obj).mData;
                                if (json.getInt(C2125n.f6745M) == 0) {
                                    if (BNRCEventDetailsViewController.this.parseGetCommentsJSON(json.getJSONObject("data"))) {
                                        if (BNRCEventDetailsViewController.this.model.getCommentsDataBuild() != null) {
                                            BNRCEventDetailsViewController.this.model.getCommentsDataBuild().setMJsonObj(json);
                                        }
                                        if (BNRCEventDetailsViewController.this.view != null) {
                                            BNRCEventDetailsViewController.this.view.loadingEnd(3, null, true);
                                            BNRCEventDetailsViewController.this.view.onCommentsDataSetChanged();
                                        }
                                    } else {
                                        LogUtil.m15791e(BNRCEventDetailsViewController.TAG, "MSG_BN_RC_COMMENTS: -->> error 330");
                                        if (BNRCEventDetailsViewController.this.view != null) {
                                            BNRCEventDetailsViewController.this.view.loadingEnd(3, "加载失败,请稍后重试", false);
                                        }
                                    }
                                } else {
                                    LogUtil.m15791e(BNRCEventDetailsViewController.TAG, "MSG_BN_RC_COMMENTS: -->> error 337, errMsg:" + json.getString(C2125n.f6746N));
                                    if (BNRCEventDetailsViewController.this.view != null) {
                                        BNRCEventDetailsViewController.this.view.loadingEnd(3, "加载失败,请稍后重试", false);
                                    }
                                }
                            } catch (Exception e3) {
                                LogUtil.m15791e(BNRCEventDetailsViewController.TAG, "MSG_BN_RC_COMMENTS: -->> error 344");
                                if (BNRCEventDetailsViewController.this.view != null) {
                                    BNRCEventDetailsViewController.this.view.loadingEnd(3, "加载失败,请稍后重试", false);
                                }
                            }
                        } else {
                            LogUtil.m15791e(BNRCEventDetailsViewController.TAG, "MSG_BN_RC_COMMENTS: -->> network (" + msg.arg1 + ")");
                            if (BNRCEventDetailsViewController.this.view != null) {
                                BNRCEventDetailsViewController.this.view.loadingEnd(3, "加载失败,请稍后重试", false);
                            }
                        }
                        BNRCEventDetailsViewController.this.isGettingComments = false;
                        return;
                    case 5:
                        BNRCEventDetailsViewController.this.onDestroy();
                        if (BNRCEventDetailsViewController.this.mUgcRCEventCallback != null) {
                            BNRCEventDetailsViewController.this.mUgcRCEventCallback.onFinish();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
    }

    public void initOutlineDataBuild() {
        OutlineDataBuild mOutlineDataBuild = new OutlineDataBuild();
        if (this.model != null) {
            this.model.setOutlineDataBuild(mOutlineDataBuild);
        }
    }

    public void initCommentsDataBuild() {
        CommentsDataBuild mCommentsBuild = new CommentsDataBuild();
        if (this.model != null) {
            this.model.setCommentsDataBuild(mCommentsBuild);
        }
    }

    public void setIsShowZoomView(boolean flag) {
        if (this.model != null && this.model.getOutlineDataBuild() != null) {
            this.model.getOutlineDataBuild().setIsShowZoomView(flag);
        }
    }

    public boolean asyncGetRCEventDetailsData() {
        if (this.model != null && this.model.getOutlineDataBuild() != null && this.model.getOutlineDataBuild().getMJsonObj() != null) {
            if (this.mUgcHandler != null) {
                Message msg = this.mUgcHandler.obtainMessage();
                msg.obj = new RspData(null, this.model.getOutlineDataBuild().getMJsonObj());
                msg.what = 1;
                this.mUgcHandler.sendMessage(msg);
            }
            LogUtil.m15791e(TAG, "asyncGetRCEventDetailsData: --> json data existed");
            return true;
        } else if (this.isGettingOutline) {
            LogUtil.m15791e(TAG, "asyncGetRCEventDetailsData: isGettingOutline --> " + this.isGettingOutline);
            return true;
        } else {
            this.isGettingOutline = true;
            ReqData reqdata = new ReqData(CommandConstants.K_COMMAND_KEY_GENERAL_HTTPREQUEST_FUNC, 7, this.mUgcHandler, 1, 10000);
            CmdGeneralHttpRequestFunc.addFunc(reqdata, new C44952());
            CommandCenter.getInstance().sendRequest(reqdata);
            return false;
        }
    }

    @SuppressLint({"DefaultLocale"})
    public List<NameValuePair> packetGetEventDetailReq(String eventId) {
        List<NameValuePair> valuePairs = new ArrayList();
        StringBuffer sb = new StringBuffer();
        try {
            valuePairs.add(new BasicNameValuePair(BNRCEventDetailsModel.BN_RC_KEY_EVENT_ID, eventId));
            sb.append("event_id=");
            sb.append(URLEncoder.encode(eventId, "utf-8"));
            valuePairs.add(new BasicNameValuePair("sid", String.valueOf(1)));
            sb.append("&sid=");
            sb.append(URLEncoder.encode(String.valueOf(1), "utf-8"));
            valuePairs.add(new BasicNameValuePair("cuid", PackageUtil.getCuid()));
            sb.append("&cuid=");
            sb.append(URLEncoder.encode(PackageUtil.getCuid(), "utf-8"));
            valuePairs.add(new BasicNameValuePair("os", String.valueOf(0)));
            sb.append("&os=");
            sb.append(URLEncoder.encode(String.valueOf(0), "utf-8"));
            String osv = String.valueOf(PackageUtil.getSystemVersion());
            valuePairs.add(new BasicNameValuePair("osv", osv));
            sb.append("&osv=");
            sb.append(URLEncoder.encode(osv, "utf-8"));
            valuePairs.add(new BasicNameValuePair("sv", PackageUtil.getVersionName()));
            sb.append("&sv=");
            sb.append(URLEncoder.encode(PackageUtil.getVersionName(), "utf-8"));
            String userPoint = new UgcHttpsUtils().getCurrentLocationPoint();
            valuePairs.add(new BasicNameValuePair("point", userPoint));
            sb.append("&point=");
            sb.append(URLEncoder.encode(userPoint, "utf-8"));
            String st = String.valueOf((int) (System.currentTimeMillis() * 1000));
            valuePairs.add(new BasicNameValuePair("st", st));
            sb.append("&st=");
            sb.append(URLEncoder.encode(st, "utf-8"));
            valuePairs.add(new BasicNameValuePair("sign", JNITrajectoryControl.sInstance.getUrlParamsSign(CloudConfigObtainManager.SortSequenceWithAscendingOder(valuePairs))));
            return valuePairs;
        } catch (UnsupportedEncodingException e) {
            return null;
        }
    }

    private boolean parseGetEventDetailResJSON(JSONObject jsonObj) {
        if (jsonObj == null) {
            return false;
        }
        try {
            this.model.setUseful(jsonObj.getInt(BNRCEventDetailsModel.BN_RC_KEY_USEFUL));
            this.model.setUseless(jsonObj.getInt(BNRCEventDetailsModel.BN_RC_KEY_USELESS));
        } catch (Exception e) {
        }
        try {
            this.model.seteType(jsonObj.getInt(BNRCEventDetailsModel.BN_RC_KEY_E_TYPE));
            String eIcon = jsonObj.getString(BNRCEventDetailsModel.BN_RC_KEY_E_ICON);
            this.model.seteIcon(eIcon == null ? null : eIcon.trim());
            this.model.seteTitle(jsonObj.getString(BNRCEventDetailsModel.BN_RC_KEY_E_TITLE));
            this.model.setShowTime(jsonObj.getString(BNRCEventDetailsModel.BN_RC_KEY_SHOW_TIME));
            String eventPic = jsonObj.getString(BNRCEventDetailsModel.BN_RC_KEY_EVENT_PIC);
            this.model.setEventPic(eventPic == null ? null : eventPic.trim());
            this.model.setUser(jsonObj.getString(BNRCEventDetailsModel.BN_RC_KEY_USER));
            this.model.setVoted(jsonObj.getInt(BNRCEventDetailsModel.BN_RC_KEY_VOTED));
            try {
                this.model.setAwayFrom(jsonObj.getString(BNRCEventDetailsModel.BN_RC_KEY_AWAY_FROM));
                this.model.setTimeInterval(jsonObj.getString(BNRCEventDetailsModel.BN_RC_KEY_TIME_INTERVAL));
                this.model.setContent(jsonObj.getString("content"));
                this.model.setRoadName(jsonObj.getString("road_name"));
                this.model.setLabel(parseStringToArr(jsonObj.getString(BNRCEventDetailsModel.BN_RC_KEY_LABEL)));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (jsonObj.has(BNRCEventDetailsModel.BN_RC_KEY_EVENT_ID)) {
                this.model.setEventIdPlainText(jsonObj.getLong(BNRCEventDetailsModel.BN_RC_KEY_EVENT_ID));
            }
            return true;
        } catch (JSONException e3) {
            return false;
        }
    }

    public boolean asyncGetCommentsData() {
        LogUtil.m15791e(TAG, "asyncGetCommentsData: firstPage --> " + this.model.isFirstPageDataLoaded());
        if (this.model.isFirstPageDataLoaded() && this.model != null && this.model.getCommentsDataBuild() != null && this.model.getCommentsDataBuild().getMJsonObj() != null) {
            if (this.mUgcHandler != null) {
                Message msg = this.mUgcHandler.obtainMessage();
                msg.obj = new RspData(null, this.model.getCommentsDataBuild().getMJsonObj());
                msg.what = 3;
                this.mUgcHandler.sendMessage(msg);
            }
            LogUtil.m15791e(TAG, "asyncGetCommentsData: --> json data existed");
            return true;
        } else if (this.isGettingComments) {
            LogUtil.m15791e(TAG, "asyncGetCommentsData: isGettingComments --> " + this.isGettingComments);
            return true;
        } else {
            this.isGettingComments = true;
            ReqData reqdata = new ReqData(CommandConstants.K_COMMAND_KEY_GENERAL_HTTPREQUEST_FUNC, 7, this.mUgcHandler, 3, 10000);
            CmdGeneralHttpRequestFunc.addFunc(reqdata, new C44963());
            CommandCenter.getInstance().sendRequest(reqdata);
            return false;
        }
    }

    private List<NameValuePair> packetGetCommentsReq(String eventId, String lastCommentId) {
        LogUtil.m15791e(TAG, "packetGetCommentsReq: --> eventId: " + eventId + ", lastCommentId: " + lastCommentId);
        List<NameValuePair> valuePairs = new ArrayList();
        StringBuffer sb = new StringBuffer();
        try {
            valuePairs.add(new BasicNameValuePair(BNRCEventDetailsModel.BN_RC_KEY_EVENT_ID, eventId));
            sb.append("event_id=");
            sb.append(URLEncoder.encode(eventId, "utf-8"));
            valuePairs.add(new BasicNameValuePair(BNRCEventDetailsModel.BN_RC_KEY_COMMENT_ID, lastCommentId));
            sb.append("comment_id=");
            sb.append(URLEncoder.encode(lastCommentId, "utf-8"));
            valuePairs.add(new BasicNameValuePair("cuid", PackageUtil.getCuid()));
            sb.append("&cuid=");
            sb.append(URLEncoder.encode(PackageUtil.getCuid(), "utf-8"));
            valuePairs.add(new BasicNameValuePair("os", String.valueOf(0)));
            sb.append("&os=");
            sb.append(URLEncoder.encode(String.valueOf(0), "utf-8"));
            String osv = String.valueOf(PackageUtil.getSystemVersion());
            valuePairs.add(new BasicNameValuePair("osv", osv));
            sb.append("&osv=");
            sb.append(URLEncoder.encode(osv, "utf-8"));
            valuePairs.add(new BasicNameValuePair("sv", PackageUtil.getVersionName()));
            sb.append("&sv=");
            sb.append(URLEncoder.encode(PackageUtil.getVersionName(), "utf-8"));
            valuePairs.add(new BasicNameValuePair("sign", JNITrajectoryControl.sInstance.getUrlParamsSign(CloudConfigObtainManager.SortSequenceWithAscendingOder(valuePairs))));
            return valuePairs;
        } catch (UnsupportedEncodingException e) {
            return null;
        }
    }

    private boolean parseGetCommentsJSON(JSONObject dataObject) {
        boolean z = false;
        if (dataObject == null) {
            return false;
        }
        LogUtil.m15791e(TAG, "parseGetCommentsJSON: data --> " + dataObject.toString());
        ArrayList<Comment> comments = new ArrayList();
        try {
            if (dataObject.getInt("next_page") == 1) {
                z = true;
            }
            this.moreCommentsPending = z;
            JSONArray commentsJArray = dataObject.getJSONArray("comment_list");
            int size = commentsJArray.length();
            for (int i = 0; i < size; i++) {
                Comment comment = new Comment();
                JSONObject commentJson = commentsJArray.getJSONObject(i);
                comment.id = commentJson.getLong("id");
                comment.showTime = commentJson.getString(BNRCEventDetailsModel.BN_RC_KEY_SHOW_TIME);
                comment.user = commentJson.getString(BNRCEventDetailsModel.BN_RC_KEY_USER);
                if (commentJson.has(BNRCEventDetailsModel.BN_RC_KEY_EVENT_PIC)) {
                    comment.picUrl = commentJson.getString(BNRCEventDetailsModel.BN_RC_KEY_EVENT_PIC);
                }
                comment.content = commentJson.getString("content");
                if (commentJson.has(BNRCEventDetailsModel.BN_RC_KEY_LABEL)) {
                    JSONArray labelsArray = commentJson.getJSONArray(BNRCEventDetailsModel.BN_RC_KEY_LABEL);
                    if (labelsArray != null) {
                        comment.labels = new String[labelsArray.length()];
                        for (int j = 0; j < labelsArray.length(); j++) {
                            comment.labels[j] = labelsArray.getString(j);
                        }
                    }
                }
                comments.add(comment);
            }
        } catch (JSONException e) {
        }
        this.model.addComments(comments);
        return true;
    }

    private String[] parseStringToArr(String str) {
        if (str == null || str.length() <= 2) {
            return null;
        }
        String[] arrRet = str.substring(1, str.length() - 1).split(",");
        if (arrRet.length >= 1) {
            arrRet[0] = arrRet[0].replace("\"", "");
        }
        if (arrRet.length >= 2) {
            arrRet[1] = arrRet[1].replace("\"", "");
        }
        if (TextUtils.isEmpty(arrRet[0]) && TextUtils.isEmpty(arrRet[1])) {
            return null;
        }
        if (arrRet.length > 1 && !TextUtils.isEmpty(arrRet[1])) {
            return arrRet;
        }
        return new String[]{arrRet[0]};
    }

    public void setVotedUpdated(boolean useful) {
        if (useful) {
            this.votedUpdated = 1;
        } else {
            this.votedUpdated = 2;
        }
    }

    public boolean isVotedUpdated() {
        return this.votedUpdated != 0;
    }

    private void resetVotedUpdated() {
        this.votedUpdated = 0;
    }

    public void asyncRCEventFeedbackData(final boolean useful) {
        ReqData reqdata = new ReqData(CommandConstants.K_COMMAND_KEY_GENERAL_HTTPREQUEST_FUNC, 7, this.mUgcHandler, 2, 10000);
        CmdGeneralHttpRequestFunc.addFunc(reqdata, new Callback() {
            public void responseImage(byte[] img) {
            }

            public boolean parseResponseJSON(JSONObject jsonObj) {
                return false;
            }

            public String getUrl() {
                return HttpURLManager.getInstance().getUsedUrl(ULRParam.URL_UGC_EVENT_FEEDBACK);
            }

            public int getRequestType() {
                return 1;
            }

            public List<NameValuePair> getRequestParams() {
                return BNRCEventDetailsViewController.this.packetEventFeedbackReq(BNRCEventDetailsViewController.this.mEventId, BNRCEventDetailsViewController.this.mBduss, useful);
            }
        });
        CommandCenter.getInstance().sendRequest(reqdata);
    }

    @SuppressLint({"DefaultLocale"})
    private List<NameValuePair> packetEventFeedbackReq(String eventId, String bduss, boolean useful) {
        List<NameValuePair> valuePairs = new ArrayList();
        StringBuffer sb = new StringBuffer();
        try {
            valuePairs.add(new BasicNameValuePair(BNRCEventDetailsModel.BN_RC_KEY_EVENT_ID, eventId));
            sb.append("event_id=");
            sb.append(URLEncoder.encode(eventId, "utf-8"));
            valuePairs.add(new BasicNameValuePair("sid", String.valueOf(1)));
            sb.append("&sid=");
            sb.append(URLEncoder.encode(String.valueOf(1), "utf-8"));
            valuePairs.add(new BasicNameValuePair("cuid", PackageUtil.getCuid()));
            sb.append("&cuid=");
            sb.append(URLEncoder.encode(PackageUtil.getCuid(), "utf-8"));
            valuePairs.add(new BasicNameValuePair("os", String.valueOf(0)));
            sb.append("&os=");
            sb.append(URLEncoder.encode(String.valueOf(0), "utf-8"));
            String osv = String.valueOf(PackageUtil.getSystemVersion());
            valuePairs.add(new BasicNameValuePair("osv", osv));
            sb.append("&osv=");
            sb.append(URLEncoder.encode(osv, "utf-8"));
            valuePairs.add(new BasicNameValuePair("sv", PackageUtil.getVersionName()));
            sb.append("&sv=");
            sb.append(URLEncoder.encode(PackageUtil.getVersionName(), "utf-8"));
            valuePairs.add(new BasicNameValuePair("bduss", bduss));
            sb.append("&bduss=");
            sb.append(URLEncoder.encode(bduss, "utf-8"));
            String usefulStr = useful ? "1" : "2";
            valuePairs.add(new BasicNameValuePair(BNRCEventDetailsModel.BN_RC_KEY_VOTE_TYPE, usefulStr));
            sb.append("&vote_type=");
            sb.append(URLEncoder.encode(usefulStr, "utf-8"));
            String point = new UgcHttpsUtils().getCurrentLocationPoint();
            if (TextUtils.isEmpty(point)) {
                point = "";
            }
            valuePairs.add(new BasicNameValuePair("point", point));
            sb.append("&point=");
            sb.append(URLEncoder.encode(point, "utf-8"));
            String st = String.valueOf((int) (System.currentTimeMillis() * 1000));
            valuePairs.add(new BasicNameValuePair("st", st));
            sb.append("&st=");
            sb.append(URLEncoder.encode(st, "utf-8"));
            valuePairs.add(new BasicNameValuePair("sign", JNITrajectoryControl.sInstance.getUrlParamsSign(CloudConfigObtainManager.SortSequenceWithAscendingOder(valuePairs))));
            return valuePairs;
        } catch (UnsupportedEncodingException e) {
            return null;
        }
    }

    public BNRCEventDetailsModel getModel() {
        return this.model;
    }

    public Context getContext() {
        return this.mContext;
    }

    public void onFinish() {
        onDestroy();
        if (this.mUgcRCEventCallback != null) {
            this.mUgcRCEventCallback.onFinish();
        }
    }

    public void doReCalcRoute() {
        LogUtil.m15791e(TAG, "doReCalcRoute: --> ");
        RGMapModeViewController.getInstance().showRefreshRoadProgess();
        BNRouteGuider.getInstance().calcOtherRoute(this.mEventId, 1, 27);
        onDestroy();
    }

    public void setLoadingProxy(LoadingProxy loadingProxy) {
        this.mLoadingProxy = loadingProxy;
    }

    public LoadingProxy getLoadingProxy() {
        return this.mLoadingProxy;
    }

    public void setSource(int source) {
        this.mSource = source;
    }

    public int getSource() {
        return this.mSource;
    }

    public boolean isMoreCommentsPending() {
        return this.moreCommentsPending;
    }
}
