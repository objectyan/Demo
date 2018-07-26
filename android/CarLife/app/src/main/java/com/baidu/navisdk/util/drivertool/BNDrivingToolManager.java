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
import com.baidu.carlife.radio.p080b.C2125n;
import com.baidu.navi.protocol.util.BNaviProtocolDef;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.CommonParams.Const.ModelName;
import com.baidu.navisdk.comapi.poisearch.BNPoiSearcher;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.logic.CommandCenter;
import com.baidu.navisdk.logic.CommandConst;
import com.baidu.navisdk.logic.CommandConstants;
import com.baidu.navisdk.logic.ReqData;
import com.baidu.navisdk.logic.RspData;
import com.baidu.navisdk.logic.commandparser.CmdGeneralHttpPostDataFunc;
import com.baidu.navisdk.logic.commandparser.CmdGeneralHttpRequestFunc;
import com.baidu.navisdk.logic.commandparser.CmdGeneralHttpRequestFunc.Callback;
import com.baidu.navisdk.model.modelfactory.NaviDataEngine;
import com.baidu.navisdk.model.modelfactory.PoiSearchModel;
import com.baidu.navisdk.ui.routeguide.control.RGEngineControl;
import com.baidu.navisdk.ui.widget.BNDebugModelDialog;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.NetworkUtils;
import com.baidu.navisdk.util.common.PackageUtil;
import com.baidu.navisdk.util.db.table.RouteCustomDBTable;
import com.baidu.navisdk.util.drivertool.model.DrivingToolIssueInfo;
import com.baidu.navisdk.util.drivertool.view.BNDrivingToolDialog;
import com.baidu.navisdk.util.drivertool.view.BNDrivingToolIssueStoreDialog;
import com.baidu.navisdk.util.drivertool.view.BNDrivingToolUploadDialog;
import com.baidu.sapi2.result.SapiResult;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
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

public class BNDrivingToolManager {
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
    public Handler mHandler = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message msg) {
            int type = msg.what;
            boolean ret = msg.arg1 == 0;
            if (type == CommandConst.K_MSG_GENERAL_HTTP_TYPE_UPDATE_TASKLIST) {
                if (ret) {
                    BNDrivingToolManager.this.updateTaskListView();
                }
                LogUtil.m15791e(BNDrivingToolManager.MODULENAME, "ret is " + ret + "TYPE_UPDATE_TASKLIST");
            } else if (type == CommandConst.K_MSG_GENERAL_HTTP_TYPE_UPDATE_ROUTELIST) {
                if (ret) {
                    BNDrivingToolManager.this.updateRouteListView();
                } else {
                    BNDrivingToolManager.this.setRouteSpinnerClickble(true);
                }
                LogUtil.m15791e(BNDrivingToolManager.MODULENAME, "ret is " + ret + "TYPE_UPDATE_ROUTELIST");
            } else if (type == CommandConst.K_MSG_GENERAL_HTTP_TYPE_UPDATE_ISSUELIST) {
                if (ret) {
                    BNDrivingToolManager.this.updateIssueListView();
                    BNDrivingToolManager.this.updateNewIssueDefaultAction();
                }
                LogUtil.m15791e(BNDrivingToolManager.MODULENAME, "ret is " + ret + "TYPE_UPDATE_ISSUELIST");
            } else if (type == CommandConst.K_MSG_GENERAL_HTTP_TYPE_UPDATE_PERSONRELIABLE) {
                if (ret && BNDrivingToolManager.this.mIssueStoreDialog == null) {
                    LogUtil.m15791e(BNDrivingToolManager.MODULENAME, "ret is " + ret + "TYPE_UPDATE_PERSONRELIABLE");
                } else {
                    LogUtil.m15791e(BNDrivingToolManager.MODULENAME, "ret is " + ret + "TYPE_UPDATE_PERSONRELIABLE");
                }
            } else if (type == CommandConst.K_MSG_GENERAL_HTTP_TYPE_UPLOAD_LOCALFILE) {
                LogUtil.m15791e(BNDrivingToolManager.MODULENAME, "ret is " + ret + "TYPE_UPLOAD_LOCALFILE");
                if (ret) {
                    RspData data = msg.obj;
                    JSONObject obj = data.mData;
                    if (obj != null) {
                        String errorNo = obj.optString(C2125n.f6745M);
                        BNDrivingToolUtils.log("asyn upload errno is " + errorNo);
                        if (!(errorNo == null || errorNo.equals("0"))) {
                            if (BNDrivingToolManager.this.mUploadDialog != null) {
                                BNDrivingToolManager.this.mUploadDialog.updateUploadFailView("上传文件" + ((String) BNDrivingToolManager.this.mDataFileList.get(BNDrivingToolManager.this.mFileIndex)) + "失败");
                                return;
                            }
                            return;
                        }
                    }
                    BNDrivingToolManager.this.deleteLocalFile(data.mReq.mObj);
                    BNDrivingToolUtils.log("上传文件" + ((String) BNDrivingToolManager.this.mDataFileList.get(BNDrivingToolManager.this.mFileIndex)) + SapiResult.RESULT_MSG_SUCCESS);
                    if (BNDrivingToolManager.this.mUploadDialog != null) {
                        BNDrivingToolManager.this.mUploadDialog.updateUploadSuccessView("上传文件" + ((String) BNDrivingToolManager.this.mDataFileList.get(BNDrivingToolManager.this.mFileIndex)) + SapiResult.RESULT_MSG_SUCCESS);
                    }
                } else if (BNDrivingToolManager.this.mUploadDialog != null) {
                    BNDrivingToolManager.this.mUploadDialog.updateUploadFailView("上传文件" + ((String) BNDrivingToolManager.this.mDataFileList.get(BNDrivingToolManager.this.mFileIndex)) + "失败");
                }
                BNDrivingToolManager.access$204(BNDrivingToolManager.this);
                if (BNDrivingToolManager.this.mFileIndex < BNDrivingToolManager.this.mDataFileList.size()) {
                    BNDrivingToolManager.this.uploadLocalFile((String) BNDrivingToolManager.this.mIndexFileList.get(BNDrivingToolManager.this.mFileIndex), (String) BNDrivingToolManager.this.mDataFileList.get(BNDrivingToolManager.this.mFileIndex), BNDrivingToolManager.this.mFileIndex);
                }
            } else if (type == 1003) {
                if (msg.arg1 == 0) {
                    BNDrivingToolManager.this.mCurrentAddressName = ((PoiSearchModel) NaviDataEngine.getInstance().getModel(ModelName.POI_SEARCH)).getAntiGeoPoi().mName;
                    LogUtil.m15791e(BNDrivingToolManager.MODULENAME, "mName " + BNDrivingToolManager.this.mCurrentAddressName);
                } else {
                    BNDrivingToolManager.this.mCurrentAddressName = "未知";
                }
                int searchType = Integer.parseInt(BNDrivingToolManager.this.mDrivingToolIssueInfo.mStoreType);
                if (searchType == 3) {
                    BNScreentShotManager.getInstance().screenShotFinish();
                } else if (searchType == 2) {
                    BNTakePhotoManager.getInstance().photoFinishAction();
                }
            }
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

    /* renamed from: com.baidu.navisdk.util.drivertool.BNDrivingToolManager$2 */
    class C46572 implements OnCancelListener {
        C46572() {
        }

        public void onCancel(DialogInterface dialog) {
            BNDrivingToolManager.this.setDrivingToolIconVisibility(true);
        }
    }

    /* renamed from: com.baidu.navisdk.util.drivertool.BNDrivingToolManager$3 */
    class C46583 implements OnCancelListener {
        C46583() {
        }

        public void onCancel(DialogInterface dialog) {
            BNDrivingToolManager.this.setDrivingToolIconVisibility(true);
        }
    }

    /* renamed from: com.baidu.navisdk.util.drivertool.BNDrivingToolManager$4 */
    class C46594 implements Callback {
        C46594() {
        }

        public int getRequestType() {
            return 1;
        }

        public String getUrl() {
            return BNDrivingToolUtils.sIsOnlineURL ? BNDrivingToolParams.PULL_TASKLIST_URL_ONLINE : BNDrivingToolParams.PULL_TASKLIST_URL;
        }

        public List<NameValuePair> getRequestParams() {
            List<NameValuePair> valuePairs = new ArrayList();
            valuePairs.add(new BasicNameValuePair("ignoreLogin", "1"));
            return valuePairs;
        }

        public boolean parseResponseJSON(JSONObject jsonObj) {
            BNDrivingToolManager.this.parseTaskListResult(jsonObj);
            return false;
        }

        public void responseImage(byte[] img) {
        }
    }

    /* renamed from: com.baidu.navisdk.util.drivertool.BNDrivingToolManager$7 */
    class C46627 implements Callback {
        C46627() {
        }

        public void responseImage(byte[] img) {
        }

        public boolean parseResponseJSON(JSONObject jsonObj) {
            BNDrivingToolManager.this.parseReliblePerson(jsonObj);
            return false;
        }

        public String getUrl() {
            return BNDrivingToolUtils.sIsOnlineURL ? BNDrivingToolParams.PULL_TASK_SET_URL_ONLINE : BNDrivingToolParams.PULL_TASK_SET_URL;
        }

        public int getRequestType() {
            return 1;
        }

        public List<NameValuePair> getRequestParams() {
            List<NameValuePair> valuePairs = new ArrayList();
            valuePairs.add(new BasicNameValuePair("task_id", BNDrivingToolManager.this.mTaskID));
            valuePairs.add(new BasicNameValuePair("ignoreLogin", "1"));
            LogUtil.m15791e(BNDrivingToolManager.MODULENAME, "asynPullReliablePerson getRequestParams= " + valuePairs.toString());
            return valuePairs;
        }
    }

    /* renamed from: com.baidu.navisdk.util.drivertool.BNDrivingToolManager$9 */
    class C46649 implements OnDismissListener {
        C46649() {
        }

        public void onDismiss(DialogInterface dialog) {
            BNDrivingToolManager.getInstance().isNoDrivingTest = false;
            BNDrivingToolManager.this.mIssueStoreDialog.setStoreViewEnable(true);
            BNDrivingToolManager.getInstance().setDrivingToolIconVisibility(true);
        }
    }

    public interface DrivingToolCallBack {
        int getCurrentCityID();

        void setToolIconVisible(boolean z);
    }

    private static class IssuePullInfo {
        public String issueTag;

        private IssuePullInfo() {
            this.issueTag = "0";
        }
    }

    private static class RoutePullInfo {
        public String routeTag;

        private RoutePullInfo() {
            this.routeTag = "0";
        }
    }

    public static class UploadFileResponseInfo {
        public String dataPath;
        public int index;
        public String indexPath;
        public String type;
    }

    private class UploadFileTask extends AsyncTask<String, String, String> {
        private UploadFileTask() {
        }

        protected String doInBackground(String... params) {
            BNDrivingToolManager.this.asynUploadLocalFile(params[0]);
            return null;
        }
    }

    static /* synthetic */ int access$204(BNDrivingToolManager x0) {
        int i = x0.mFileIndex + 1;
        x0.mFileIndex = i;
        return i;
    }

    public boolean canDrivingToolStart() {
        return this.isTaskRet && this.isRouteRet;
    }

    private BNDrivingToolManager() {
    }

    public void setDebugModeDialog(BNDebugModelDialog dialog) {
        this.mDebugModeDialog = dialog;
    }

    public static BNDrivingToolManager getInstance() {
        if (mInstance == null) {
            mInstance = new BNDrivingToolManager();
        }
        return mInstance;
    }

    public void getCurrentCityID() {
        if (this.mToolCallBack != null) {
            this.mCityID = String.valueOf(this.mToolCallBack.getCurrentCityID());
        }
    }

    public void updateNewIssueDefaultAction() {
        if (getInstance().mIssueFlag.equals("1") && this.mIssueStoreDialog != null) {
            this.mIssueStoreDialog.updateNewIssueDefaultAction();
        }
    }

    private void deleteLocalFile(UploadFileResponseInfo responseInfo) {
        if (responseInfo != null) {
            LogUtil.m15791e(MODULENAME, "deleteLocalFile " + responseInfo.dataPath + "type= " + responseInfo.type);
            String dataPath = responseInfo.dataPath;
            String typeStr = responseInfo.type;
            int type = 0;
            if (typeStr != null) {
                type = Integer.parseInt(typeStr);
            }
            if (type == 4) {
                new File(responseInfo.indexPath).delete();
                return;
            }
            String suffix = BNDrivingToolUtils.getSuffixByType(type);
            new File(dataPath.substring(0, dataPath.length() - 4) + BNDrivingToolParams.INDEX_FILE_SUFFIX).delete();
        }
    }

    public void uploadLocalMaterial(Context ctx) {
        uploadLocalFile();
        this.mUploadDialog = new BNDrivingToolUploadDialog(ctx);
        this.mUploadDialog.show();
        this.mUploadDialog.setOnCancelListener(new C46572());
    }

    public DrivingToolIssueInfo getIssueInfo() {
        if (this.mDrivingToolIssueInfo == null) {
            this.mDrivingToolIssueInfo = new DrivingToolIssueInfo();
        }
        return this.mDrivingToolIssueInfo;
    }

    public void updateTaskListView() {
        if (this.mDebugModeDialog != null) {
            this.mDebugModeDialog.updateTaskListView();
        }
    }

    public void updateRouteListView() {
        if (this.mDebugModeDialog != null) {
            this.mDebugModeDialog.updatRouteListView();
        }
    }

    public void setRouteSpinnerClickble(boolean isClickble) {
        if (this.mDebugModeDialog != null) {
            this.mDebugModeDialog.setRouteSpinnerCLickable(isClickble);
        }
    }

    public void updateIssueListView() {
        if (this.mIssueStoreDialog != null) {
            this.mIssueStoreDialog.updateIssueListView();
        }
    }

    public void setCurrentCityID(int cityID) {
        this.mCityID = String.valueOf(cityID);
    }

    public void setDrivingToolCallBack(DrivingToolCallBack toolCallBack) {
        this.mToolCallBack = toolCallBack;
    }

    public void openDrvingToolDialog(Activity activity) {
        this.mDrivingToolDialog = new BNDrivingToolDialog(activity);
        this.mDrivingToolDialog.setOnCancelListener(new C46583());
        this.mDrivingToolDialog.show();
    }

    public void dismissDrvingToolDialog() {
        if (this.mDrivingToolDialog != null) {
            this.mDrivingToolDialog.dismiss();
        }
    }

    public void setDrivingToolIconVisibility(boolean isVisible) {
        if (this.mToolCallBack != null) {
            this.mToolCallBack.setToolIconVisible(isVisible);
        }
    }

    public void asynPullTaskList() {
        ReqData reqdata = new ReqData(CommandConstants.K_COMMAND_KEY_GENERAL_HTTPREQUEST_FUNC, 7, this.mHandler, CommandConst.K_MSG_GENERAL_HTTP_TYPE_UPDATE_TASKLIST, 10000);
        CmdGeneralHttpRequestFunc.addFunc(reqdata, new C46594());
        CommandCenter.getInstance().sendRequest(reqdata);
    }

    private void parseTaskListResult(JSONObject jsonObj) {
        if (jsonObj != null) {
            LogUtil.m15791e(MODULENAME, "parseTaskListResult jsonObj= " + jsonObj.toString());
            try {
                if (jsonObj.getInt(C2125n.f6745M) == 0) {
                    JSONArray dataArray = jsonObj.getJSONArray("data");
                    if (dataArray != null) {
                        this.mTaskList.clear();
                        this.mTaskList.add(BNDrivingToolParams.DEFAULT_SPINNER_DATA);
                        getInstance().mTaskMap.clear();
                        for (int i = 0; i < dataArray.length(); i++) {
                            JSONObject obj = dataArray.getJSONObject(i);
                            String taskName = obj.getString("task_name");
                            if (!this.mTaskList.contains(taskName)) {
                                this.mTaskList.add(taskName);
                                getInstance().mTaskMap.put(taskName, obj.getString("task_id"));
                            }
                        }
                    }
                }
            } catch (Exception e) {
            }
        }
    }

    public int getLastSelectedTaskIndex() {
        if (this.mTaskMap == null || this.mTaskMap.size() <= 0 || this.mTaskList == null || this.mTaskList.size() <= 0) {
            return -1;
        }
        String drivingInfo = BNSettingManager.getLastDrivingInfo();
        String lastTaskId = null;
        if (drivingInfo != null) {
            String[] infoArray = drivingInfo.split(",");
            if (infoArray != null && infoArray.length > 0) {
                lastTaskId = infoArray[0];
            }
        }
        String tempTaskName = null;
        for (Entry<String, String> entry : this.mTaskMap.entrySet()) {
            if (((String) entry.getValue()).equals(lastTaskId)) {
                tempTaskName = (String) entry.getKey();
                break;
            }
        }
        if (tempTaskName != null) {
            for (int i = 0; i < this.mTaskList.size(); i++) {
                if (tempTaskName.equals(this.mTaskList.get(i))) {
                    return i;
                }
            }
        }
        return -1;
    }

    public void asynPullRoadList() {
        setRouteSpinnerClickble(false);
        final ReqData reqdata = new ReqData(CommandConstants.K_COMMAND_KEY_GENERAL_HTTPREQUEST_FUNC, 7, this.mHandler, CommandConst.K_MSG_GENERAL_HTTP_TYPE_UPDATE_ROUTELIST, 10000);
        RoutePullInfo routeInfo = new RoutePullInfo();
        routeInfo.routeTag = this.mRouteFlag;
        reqdata.setObj(routeInfo);
        CmdGeneralHttpRequestFunc.addFunc(reqdata, new Callback() {
            public void responseImage(byte[] img) {
            }

            public boolean parseResponseJSON(JSONObject jsonObj) {
                RoutePullInfo info = reqdata.mObj;
                String currentRouteTag = null;
                if (info != null) {
                    currentRouteTag = info.routeTag;
                }
                BNDrivingToolManager.this.parseRoadList(jsonObj, currentRouteTag);
                return false;
            }

            public String getUrl() {
                return BNDrivingToolUtils.sIsOnlineURL ? BNDrivingToolParams.PULL_ROAD_ID_URL_ONLINE : BNDrivingToolParams.PULL_ROAD_ID_URL;
            }

            public int getRequestType() {
                return 1;
            }

            public List<NameValuePair> getRequestParams() {
                List<NameValuePair> valuePairs = new ArrayList();
                valuePairs.add(new BasicNameValuePair("task_id", BNDrivingToolManager.this.mTaskID));
                BNDrivingToolManager.this.getCurrentCityID();
                valuePairs.add(new BasicNameValuePair("city_id", BNDrivingToolManager.this.mCityID));
                valuePairs.add(new BasicNameValuePair("create_new_flag", BNDrivingToolManager.this.mRouteFlag));
                valuePairs.add(new BasicNameValuePair("ignoreLogin", "1"));
                LogUtil.m15791e(BNDrivingToolManager.MODULENAME, "asynPullRoadList getRequestParams= " + valuePairs.toString());
                return valuePairs;
            }
        });
        CommandCenter.getInstance().sendRequest(reqdata);
    }

    private void parseRoadList(JSONObject jsonObj, String currentRouteTag) {
        if (jsonObj != null) {
            LogUtil.m15791e(MODULENAME, "parseRoadList jsonObj= " + jsonObj.toString());
            try {
                if (jsonObj.getInt(C2125n.f6745M) == 0) {
                    if (TextUtils.isEmpty(currentRouteTag)) {
                        currentRouteTag = this.mRouteFlag;
                    }
                    String routeName;
                    if (currentRouteTag.equals("1")) {
                        JSONObject dataObj = jsonObj.getJSONObject("data");
                        routeName = dataObj.getString(RouteCustomDBTable.NAME);
                        String routeID = dataObj.getString("route_id");
                        this.mRouteID = routeID;
                        this.mRouteList.add(routeName);
                        this.mNewRouteList.add(routeName);
                        this.mRoadMap.put(routeName, routeID);
                    } else if (currentRouteTag.equals("0")) {
                        JSONArray dataArray = jsonObj.getJSONArray("data");
                        this.mRouteList.clear();
                        this.mRoadMap.clear();
                        if (!this.mRouteList.contains(BNDrivingToolParams.DEFAULT_SPINNER_DATA)) {
                            this.mRouteList.add(BNDrivingToolParams.DEFAULT_SPINNER_DATA);
                        }
                        this.mRouteFlag = "0";
                        for (int i = 0; i < dataArray.length(); i++) {
                            JSONObject obj = dataArray.getJSONObject(i);
                            routeName = obj.getString(RouteCustomDBTable.NAME);
                            this.mRouteList.add(routeName);
                            this.mRoadMap.put(routeName, obj.getString("route_id"));
                        }
                    }
                }
            } catch (Exception e) {
                LogUtil.m15791e(MODULENAME, e.toString());
            }
        }
    }

    public boolean isIssueNewCreate(String issueID) {
        if (this.mIssueFlag.equals("0") || this.mIssueList == null || !((String) this.mIssueList.get(this.mIssueList.size() - 1)).equals(issueID)) {
            return false;
        }
        return true;
    }

    private CookieStore getCookieStore() {
        BasicClientCookie cookie = new BasicClientCookie("BDUSS", BNaviModuleManager.getBduss());
        CookieStore cookieStore = new BasicCookieStore();
        cookie.setDomain(".baidu.com");
        cookie.setPath("/");
        cookie.setVersion(0);
        cookieStore.addCookie(cookie);
        return cookieStore;
    }

    public void asynPullIssueList() {
        Context ctx = BNaviModuleManager.getContext();
        if (ctx == null || !NetworkUtils.isNetworkAvailable(ctx)) {
            parseLocalIssue();
            return;
        }
        final ReqData reqdata = new ReqData(CommandConstants.K_COMMAND_KEY_GENERAL_HTTPREQUEST_FUNC, 7, this.mHandler, CommandConst.K_MSG_GENERAL_HTTP_TYPE_UPDATE_ISSUELIST, 10000);
        reqdata.mCookieStore = getCookieStore();
        IssuePullInfo issueInfo = new IssuePullInfo();
        issueInfo.issueTag = this.mIssueFlag;
        reqdata.mObj = issueInfo;
        CmdGeneralHttpRequestFunc.addFunc(reqdata, new Callback() {
            public void responseImage(byte[] img) {
            }

            public boolean parseResponseJSON(JSONObject jsonObj) {
                IssuePullInfo info = reqdata.mObj;
                String currentIssueTag = null;
                if (info != null) {
                    currentIssueTag = info.issueTag;
                }
                BNDrivingToolManager.this.parseIssueList(jsonObj, currentIssueTag);
                return false;
            }

            public String getUrl() {
                return BNDrivingToolUtils.sIsOnlineURL ? BNDrivingToolParams.PULL_ISSUE_URL_ONLINE : BNDrivingToolParams.PULL_ISSUE_URL;
            }

            public int getRequestType() {
                return 1;
            }

            public List<NameValuePair> getRequestParams() {
                List<NameValuePair> valuePairs = new ArrayList();
                valuePairs.add(new BasicNameValuePair("task_id", BNDrivingToolManager.this.mTaskID));
                valuePairs.add(new BasicNameValuePair("route_id", BNDrivingToolManager.this.mRouteID));
                valuePairs.add(new BasicNameValuePair("cuid", PackageUtil.getCuid()));
                valuePairs.add(new BasicNameValuePair("create_new_flag", BNDrivingToolManager.this.mIssueFlag));
                valuePairs.add(new BasicNameValuePair("ignoreLogin", "1"));
                LogUtil.m15791e(BNDrivingToolManager.MODULENAME, "asynPullIssueList getRequestParams= " + valuePairs.toString());
                return valuePairs;
            }
        });
        CommandCenter.getInstance().sendRequest(reqdata);
    }

    private void parseLocalIssue() {
        Exception e;
        Throwable th;
        File localFile = new File(BNDrivingToolUtils.getDrivingToolDir() + File.separator + BNDrivingToolParams.LOCAL_ISSUE_STORE);
        if (localFile.exists()) {
            FileReader fileReader = null;
            BufferedReader bufReader = null;
            try {
                FileReader fileReader2 = new FileReader(localFile);
                try {
                    BufferedReader bufReader2 = new BufferedReader(fileReader2);
                    try {
                        this.mIssueList.clear();
                        String values = bufReader2.readLine();
                        if (values != null) {
                            String[] issue = values.split(",");
                            this.mDrivingToolIssueInfo.mIssueID = issue[0];
                            for (Object add : issue) {
                                this.mIssueList.add(add);
                            }
                        }
                        Message msg = this.mHandler.obtainMessage();
                        msg.what = CommandConst.K_MSG_GENERAL_HTTP_TYPE_UPDATE_ISSUELIST;
                        msg.arg1 = 0;
                        msg.sendToTarget();
                        if (bufReader2 != null) {
                            try {
                                bufReader2.close();
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                        }
                        if (fileReader2 != null) {
                            try {
                                fileReader2.close();
                                bufReader = bufReader2;
                                fileReader = fileReader2;
                                return;
                            } catch (IOException e22) {
                                e22.printStackTrace();
                                bufReader = bufReader2;
                                fileReader = fileReader2;
                                return;
                            }
                        }
                        fileReader = fileReader2;
                    } catch (Exception e3) {
                        e = e3;
                        bufReader = bufReader2;
                        fileReader = fileReader2;
                        try {
                            LogUtil.m15791e(MODULENAME, e.toString());
                            if (bufReader != null) {
                                try {
                                    bufReader.close();
                                } catch (IOException e222) {
                                    e222.printStackTrace();
                                }
                            }
                            if (fileReader == null) {
                                try {
                                    fileReader.close();
                                } catch (IOException e2222) {
                                    e2222.printStackTrace();
                                }
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            if (bufReader != null) {
                                try {
                                    bufReader.close();
                                } catch (IOException e22222) {
                                    e22222.printStackTrace();
                                }
                            }
                            if (fileReader != null) {
                                try {
                                    fileReader.close();
                                } catch (IOException e222222) {
                                    e222222.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        bufReader = bufReader2;
                        fileReader = fileReader2;
                        if (bufReader != null) {
                            bufReader.close();
                        }
                        if (fileReader != null) {
                            fileReader.close();
                        }
                        throw th;
                    }
                } catch (Exception e4) {
                    e = e4;
                    fileReader = fileReader2;
                    LogUtil.m15791e(MODULENAME, e.toString());
                    if (bufReader != null) {
                        bufReader.close();
                    }
                    if (fileReader == null) {
                        fileReader.close();
                    }
                } catch (Throwable th4) {
                    th = th4;
                    fileReader = fileReader2;
                    if (bufReader != null) {
                        bufReader.close();
                    }
                    if (fileReader != null) {
                        fileReader.close();
                    }
                    throw th;
                }
            } catch (Exception e5) {
                e = e5;
                LogUtil.m15791e(MODULENAME, e.toString());
                if (bufReader != null) {
                    bufReader.close();
                }
                if (fileReader == null) {
                    fileReader.close();
                }
            }
        }
    }

    private void parseIssueList(JSONObject jsonObj, String currentIssueTag) {
        if (jsonObj != null) {
            LogUtil.m15791e(MODULENAME, "parseIssueList jsonObj = " + jsonObj.toString());
            try {
                if (jsonObj.getInt(C2125n.f6745M) == 0) {
                    if (TextUtils.isEmpty(currentIssueTag)) {
                        currentIssueTag = this.mIssueFlag;
                    }
                    if (currentIssueTag.equals("1")) {
                        String issueID = jsonObj.getString("data");
                        this.mDrivingToolIssueInfo.mIssueID = issueID;
                        this.mIssueList.add(issueID);
                    } else if (currentIssueTag.equals("0")) {
                        JSONArray dataArray = jsonObj.getJSONArray("data");
                        this.mIssueList.clear();
                        this.mIssueList.add(BNDrivingToolParams.DEFAULT_SPINNER_DATA);
                        for (int i = 0; i < dataArray.length(); i++) {
                            String obj = dataArray.getString(i);
                            if (i == 0) {
                                this.mDrivingToolIssueInfo.mIssueID = obj;
                            }
                            this.mIssueList.add(obj.toString());
                        }
                    }
                    storeIssue();
                }
            } catch (Exception e) {
                LogUtil.m15791e(MODULENAME, e.toString());
            }
        }
    }

    private void storeIssue() {
        Exception e;
        Throwable th;
        FileOutputStream fileOutputStream = null;
        try {
            FileOutputStream fos = new FileOutputStream(new File(BNDrivingToolUtils.getDrivingToolDir() + File.separator + BNDrivingToolParams.LOCAL_ISSUE_STORE));
            try {
                if (this.mIssueList != null && this.mIssueList.size() > 0) {
                    for (String str : this.mIssueList) {
                        fos.write(str.getBytes("utf-8"));
                        fos.write(",".getBytes("utf-8"));
                    }
                }
                if (fos != null) {
                    try {
                        fos.close();
                        fileOutputStream = fos;
                        return;
                    } catch (IOException e2) {
                        e2.printStackTrace();
                        fileOutputStream = fos;
                        return;
                    }
                }
            } catch (Exception e3) {
                e = e3;
                fileOutputStream = fos;
                try {
                    LogUtil.m15791e(MODULENAME, e.toString());
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e22) {
                            e22.printStackTrace();
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e222) {
                            e222.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = fos;
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                throw th;
            }
        } catch (Exception e4) {
            e = e4;
            LogUtil.m15791e(MODULENAME, e.toString());
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
        }
    }

    public void asynPullReliablePerson() {
        Context ctx = BNaviModuleManager.getContext();
        if (ctx == null || !NetworkUtils.isNetworkAvailable(ctx)) {
            parseLocalReliablePerson();
            return;
        }
        ReqData reqdata = new ReqData(CommandConstants.K_COMMAND_KEY_GENERAL_HTTPREQUEST_FUNC, 7, this.mHandler, CommandConst.K_MSG_GENERAL_HTTP_TYPE_UPDATE_PERSONRELIABLE, 10000);
        CmdGeneralHttpRequestFunc.addFunc(reqdata, new C46627());
        CommandCenter.getInstance().sendRequest(reqdata);
    }

    private void parseLocalReliablePerson() {
        Exception e;
        Throwable th;
        File localFile = new File(BNDrivingToolUtils.getDrivingToolDir() + File.separator + BNDrivingToolParams.LOCAL_RELIABLE_STORE);
        if (localFile.exists()) {
            FileReader fileReader = null;
            BufferedReader bufReader = null;
            try {
                FileReader fileReader2 = new FileReader(localFile);
                try {
                    BufferedReader bufReader2 = new BufferedReader(fileReader2);
                    try {
                        this.mReliablePersonList.clear();
                        this.mReliablePersonMap.clear();
                        String values = bufReader2.readLine();
                        if (values != null) {
                            String[] issue = values.split(",");
                            this.mDrivingToolIssueInfo.mPersonReliableID = issue[1];
                            for (int i = 0; i < issue.length - 1; i += 2) {
                                this.mReliablePersonList.add(issue[i]);
                                this.mReliablePersonMap.put(issue[i], issue[i + 1]);
                            }
                        }
                        Message msg = this.mHandler.obtainMessage();
                        msg.what = CommandConst.K_MSG_GENERAL_HTTP_TYPE_UPDATE_PERSONRELIABLE;
                        msg.arg1 = 0;
                        msg.sendToTarget();
                        if (bufReader2 != null) {
                            try {
                                bufReader2.close();
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                        }
                        if (fileReader2 != null) {
                            try {
                                fileReader2.close();
                                bufReader = bufReader2;
                                fileReader = fileReader2;
                                return;
                            } catch (IOException e22) {
                                e22.printStackTrace();
                                bufReader = bufReader2;
                                fileReader = fileReader2;
                                return;
                            }
                        }
                        fileReader = fileReader2;
                    } catch (Exception e3) {
                        e = e3;
                        bufReader = bufReader2;
                        fileReader = fileReader2;
                        try {
                            LogUtil.m15791e(MODULENAME, e.toString());
                            if (bufReader != null) {
                                try {
                                    bufReader.close();
                                } catch (IOException e222) {
                                    e222.printStackTrace();
                                }
                            }
                            if (fileReader == null) {
                                try {
                                    fileReader.close();
                                } catch (IOException e2222) {
                                    e2222.printStackTrace();
                                }
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            if (bufReader != null) {
                                try {
                                    bufReader.close();
                                } catch (IOException e22222) {
                                    e22222.printStackTrace();
                                }
                            }
                            if (fileReader != null) {
                                try {
                                    fileReader.close();
                                } catch (IOException e222222) {
                                    e222222.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        bufReader = bufReader2;
                        fileReader = fileReader2;
                        if (bufReader != null) {
                            bufReader.close();
                        }
                        if (fileReader != null) {
                            fileReader.close();
                        }
                        throw th;
                    }
                } catch (Exception e4) {
                    e = e4;
                    fileReader = fileReader2;
                    LogUtil.m15791e(MODULENAME, e.toString());
                    if (bufReader != null) {
                        bufReader.close();
                    }
                    if (fileReader == null) {
                        fileReader.close();
                    }
                } catch (Throwable th4) {
                    th = th4;
                    fileReader = fileReader2;
                    if (bufReader != null) {
                        bufReader.close();
                    }
                    if (fileReader != null) {
                        fileReader.close();
                    }
                    throw th;
                }
            } catch (Exception e5) {
                e = e5;
                LogUtil.m15791e(MODULENAME, e.toString());
                if (bufReader != null) {
                    bufReader.close();
                }
                if (fileReader == null) {
                    fileReader.close();
                }
            }
        }
    }

    private void parseReliblePerson(JSONObject jsonObj) {
        if (jsonObj != null) {
            try {
                LogUtil.m15791e(MODULENAME, "parseReliblePerson jsonObj = " + jsonObj.toString());
                if (jsonObj.getInt(C2125n.f6745M) == 0) {
                    JSONObject dataObj = jsonObj.getJSONObject("data");
                    if (dataObj != null) {
                        JSONObject personObj = dataObj.getJSONObject("person_liable");
                        Iterator iterator = personObj.keys();
                        this.mReliablePersonList.clear();
                        this.mReliablePersonMap.clear();
                        this.mIssueReliableMap.clear();
                        this.mReliablePersonList.add(BNDrivingToolParams.DEFAULT_SPINNER_DATA);
                        while (iterator.hasNext()) {
                            String issueType = (String) iterator.next();
                            JSONObject innerObj = (JSONObject) personObj.get(issueType);
                            Iterator innerIterator = innerObj.keys();
                            ArrayList<String> pmList = new ArrayList();
                            while (innerIterator.hasNext()) {
                                String reliableID = (String) innerIterator.next();
                                String personName = (String) innerObj.get(reliableID);
                                StringBuffer buf = new StringBuffer();
                                buf.append(reliableID);
                                buf.append(",");
                                buf.append(personName);
                                pmList.add(buf.toString());
                            }
                            this.mIssueReliableMap.put(issueType, pmList);
                        }
                        LogUtil.m15791e("dingbin", this.mIssueReliableMap.toString());
                    }
                }
            } catch (Exception e) {
            }
        }
    }

    public void updateReliableList(int type) {
        if (this.mIssueReliableMap != null && this.mIssueReliableMap.size() > 0) {
            ArrayList<String> pmList = (ArrayList) this.mIssueReliableMap.get(String.valueOf(type));
            if (pmList != null && pmList.size() > 0) {
                this.mReliablePersonList.clear();
                this.mReliablePersonList.add(BNDrivingToolParams.DEFAULT_SPINNER_DATA);
                this.mReliablePersonMap.clear();
                Iterator it = pmList.iterator();
                while (it.hasNext()) {
                    String[] pmArray = ((String) it.next()).split(",");
                    this.mReliablePersonList.add(pmArray[1]);
                    this.mReliablePersonMap.put(pmArray[1], pmArray[0]);
                }
                if (this.mIssueStoreDialog != null) {
                    this.mIssueStoreDialog.updateReliablePersonView();
                }
            }
        }
    }

    private void storeReliablePerson() {
        Exception e;
        Throwable th;
        FileOutputStream fileOutputStream = null;
        try {
            FileOutputStream fos = new FileOutputStream(new File(BNDrivingToolUtils.getDrivingToolDir() + File.separator + BNDrivingToolParams.LOCAL_RELIABLE_STORE));
            try {
                Set<String> keySet = this.mReliablePersonMap.keySet();
                if (keySet != null && keySet.size() > 0) {
                    for (String str : keySet) {
                        fos.write(str.getBytes("utf-8"));
                        fos.write(",".getBytes("utf-8"));
                        fos.write(((String) this.mReliablePersonMap.get(str)).getBytes("utf-8"));
                        fos.write(",".getBytes("utf-8"));
                    }
                }
                if (fos != null) {
                    try {
                        fos.close();
                        fileOutputStream = fos;
                        return;
                    } catch (IOException e2) {
                        e2.printStackTrace();
                        fileOutputStream = fos;
                        return;
                    }
                }
            } catch (Exception e3) {
                e = e3;
                fileOutputStream = fos;
                try {
                    LogUtil.m15791e(MODULENAME, e.toString());
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e22) {
                            e22.printStackTrace();
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e222) {
                            e222.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = fos;
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                throw th;
            }
        } catch (Exception e4) {
            e = e4;
            LogUtil.m15791e(MODULENAME, e.toString());
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
        }
    }

    private byte[] getLineBytes() {
        try {
            return System.getProperty("line.separator").getBytes("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return new byte[0];
        }
    }

    public void storeIndexFile(int type) {
        String indexFileStr;
        Exception e;
        Throwable th;
        if (type == 4) {
            indexFileStr = BNAttachmentManager.getInstance().getAttachmentIndexPath();
        } else {
            indexFileStr = BNDrivingToolUtils.getDrivingToolDir() + File.separator + this.mIndexFileName + BNDrivingToolParams.INDEX_FILE_SUFFIX;
        }
        FileOutputStream fos = null;
        try {
            FileOutputStream fos2 = new FileOutputStream(new File(indexFileStr));
            try {
                writeValue(fos2, this.mTaskID);
                writeValue(fos2, this.mRouteID);
                writeValue(fos2, this.mDrivingToolIssueInfo.mIssueID);
                writeValue(fos2, String.valueOf(type));
                writeValue(fos2, this.mDrivingToolIssueInfo.mIssueDescrption);
                writeValue(fos2, this.mDrivingToolIssueInfo.mIssueType);
                writeValue(fos2, this.mDrivingToolIssueInfo.mPersonReliableID);
                writeValue(fos2, this.mDrivingToolIssueInfo.mIssueStatus);
                writeValue(fos2, this.mDrivingToolIssueInfo.mExtendInfo);
                writeValue(fos2, this.mDrivingToolIssueInfo.mIssueLocation);
                writeValue(fos2, this.mDrivingToolIssueInfo.mIssueTime);
                writeValue(fos2, this.mDrivingToolIssueInfo.mBduss);
                writeValue(fos2, PackageUtil.getCuid());
                writeValue(fos2, this.mDrivingToolIssueInfo.mSessionID);
                if (type == 4) {
                    writeValue(fos2, BNAttachmentManager.getInstance().mCurrentFilePath);
                }
                if (fos2 != null) {
                    try {
                        fos2.close();
                        fos = fos2;
                        return;
                    } catch (IOException e2) {
                        e2.printStackTrace();
                        fos = fos2;
                        return;
                    }
                }
            } catch (Exception e3) {
                e = e3;
                fos = fos2;
                try {
                    LogUtil.m15791e(MODULENAME, e.toString());
                    if (fos != null) {
                        try {
                            fos.close();
                        } catch (IOException e22) {
                            e22.printStackTrace();
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (fos != null) {
                        try {
                            fos.close();
                        } catch (IOException e222) {
                            e222.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                fos = fos2;
                if (fos != null) {
                    fos.close();
                }
                throw th;
            }
        } catch (Exception e4) {
            e = e4;
            LogUtil.m15791e(MODULENAME, e.toString());
            if (fos != null) {
                fos.close();
            }
        }
    }

    public void uploadLocalFile() {
        uploadLocalFileInner();
    }

    private void initIssueInfo() {
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

    private void uploadLocalFileInner() {
        this.mIndexFileList.clear();
        this.mDataFileList.clear();
        this.mFileIndex = 0;
        File[] fileArray = new File(BNDrivingToolUtils.getDrivingToolDir()).listFiles();
        if (fileArray != null) {
            for (File file : fileArray) {
                String fileName = file.getName();
                if (!fileName.endsWith(BNDrivingToolParams.INDEX_FILE_SUFFIX)) {
                    if (fileName.endsWith(BNDrivingToolParams.RESOURCE_PICTURE_SUFFIX) || fileName.endsWith(BNDrivingToolParams.RESOURCE_VIDEO_SUFFIX)) {
                        File indexFile = new File(BNDrivingToolUtils.getDrivingToolDir(), fileName.substring(0, fileName.length() - 4) + BNDrivingToolParams.INDEX_FILE_SUFFIX);
                        if (!indexFile.exists()) {
                            LogUtil.m15791e(MODULENAME, "left data file " + file.getName());
                        } else if (canUploadVideo(fileName)) {
                            this.mIndexFileList.add(indexFile.getAbsolutePath());
                            this.mDataFileList.add(file.getAbsolutePath());
                        }
                    } else if (fileName.endsWith(BNDrivingToolParams.NO_DT_INDEX_SUFFIX)) {
                        String dataPath = readDataPath(file.getAbsolutePath());
                        if (!TextUtils.isEmpty(dataPath)) {
                            this.mIndexFileList.add(file.getAbsolutePath());
                            this.mDataFileList.add(dataPath);
                        }
                    }
                }
            }
            if (this.mDataFileList.size() > 0) {
                LogUtil.m15791e(MODULENAME, this.mDataFileList.toString() + " size is " + this.mDataFileList.size());
                uploadLocalFile((String) this.mIndexFileList.get(0), (String) this.mDataFileList.get(0), 0);
            }
        }
    }

    private boolean canUploadVideo(String fileName) {
        if (TextUtils.isEmpty(fileName) || !fileName.endsWith(BNDrivingToolParams.RESOURCE_VIDEO_SUFFIX) || NetworkUtils.isWifiConnected()) {
            return true;
        }
        return false;
    }

    private String readDataPath(String indexPath) {
        Exception e;
        Throwable th;
        File indexFile = new File(indexPath);
        if (!indexFile.exists()) {
            return null;
        }
        FileReader fileReader = null;
        BufferedReader bufReader = null;
        try {
            FileReader fileReader2 = new FileReader(indexFile);
            try {
                BufferedReader bufReader2 = new BufferedReader(fileReader2);
                try {
                    List<String> valueList = new ArrayList();
                    while (true) {
                        String value = bufReader2.readLine();
                        if (value == null) {
                            break;
                        }
                        valueList.add(value);
                    }
                    if (valueList != null) {
                        if (valueList.size() == 15) {
                            String str = (String) valueList.get(14);
                            if (bufReader2 != null) {
                                try {
                                    bufReader2.close();
                                } catch (IOException e2) {
                                    e2.printStackTrace();
                                }
                            }
                            if (fileReader2 == null) {
                                return str;
                            }
                            try {
                                fileReader2.close();
                                return str;
                            } catch (IOException e22) {
                                e22.printStackTrace();
                                return str;
                            }
                        }
                    }
                    if (bufReader2 != null) {
                        try {
                            bufReader2.close();
                        } catch (IOException e222) {
                            e222.printStackTrace();
                        }
                    }
                    if (fileReader2 != null) {
                        try {
                            fileReader2.close();
                        } catch (IOException e2222) {
                            e2222.printStackTrace();
                        }
                    }
                    return null;
                } catch (Exception e3) {
                    e = e3;
                    bufReader = bufReader2;
                    fileReader = fileReader2;
                    try {
                        LogUtil.m15791e(MODULENAME, e.toString());
                        if (bufReader != null) {
                            try {
                                bufReader.close();
                            } catch (IOException e22222) {
                                e22222.printStackTrace();
                            }
                        }
                        if (fileReader != null) {
                            try {
                                fileReader.close();
                            } catch (IOException e222222) {
                                e222222.printStackTrace();
                            }
                        }
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        if (bufReader != null) {
                            try {
                                bufReader.close();
                            } catch (IOException e2222222) {
                                e2222222.printStackTrace();
                            }
                        }
                        if (fileReader != null) {
                            try {
                                fileReader.close();
                            } catch (IOException e22222222) {
                                e22222222.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    bufReader = bufReader2;
                    fileReader = fileReader2;
                    if (bufReader != null) {
                        bufReader.close();
                    }
                    if (fileReader != null) {
                        fileReader.close();
                    }
                    throw th;
                }
            } catch (Exception e4) {
                e = e4;
                fileReader = fileReader2;
                LogUtil.m15791e(MODULENAME, e.toString());
                if (bufReader != null) {
                    bufReader.close();
                }
                if (fileReader != null) {
                    fileReader.close();
                }
                return null;
            } catch (Throwable th4) {
                th = th4;
                fileReader = fileReader2;
                if (bufReader != null) {
                    bufReader.close();
                }
                if (fileReader != null) {
                    fileReader.close();
                }
                throw th;
            }
        } catch (Exception e5) {
            e = e5;
            LogUtil.m15791e(MODULENAME, e.toString());
            if (bufReader != null) {
                bufReader.close();
            }
            if (fileReader != null) {
                fileReader.close();
            }
            return null;
        }
    }

    private void uploadLocalFile(String indexPath, String dataPath, int index) {
        readIndexFile(indexPath, dataPath);
        this.mResponseInfo.indexPath = indexPath;
        new UploadFileTask().execute(new String[]{dataPath});
    }

    private void readIndexFile(String indexPath, String dataPath) {
        Exception e;
        Throwable th;
        initIssueInfo();
        File indexFile = new File(indexPath);
        if (indexFile.exists()) {
            FileReader fileReader = null;
            BufferedReader bufReader = null;
            try {
                FileReader fileReader2 = new FileReader(indexFile);
                try {
                    BufferedReader bufReader2 = new BufferedReader(fileReader2);
                    try {
                        List<String> valueList = new ArrayList();
                        while (true) {
                            String value = bufReader2.readLine();
                            if (value == null) {
                                break;
                            }
                            valueList.add(value);
                        }
                        if (valueList != null) {
                            if (valueList.size() == 14 || valueList.size() == 15) {
                                this.mUploadInfo.mTaskID = (String) valueList.get(0);
                                this.mUploadInfo.mRouteID = (String) valueList.get(1);
                                this.mUploadInfo.mIssueID = (String) valueList.get(2);
                                this.mUploadInfo.mStoreType = (String) valueList.get(3);
                                this.mUploadInfo.mIssueDescrption = (String) valueList.get(4);
                                this.mUploadInfo.mIssueType = (String) valueList.get(5);
                                this.mUploadInfo.mPersonReliableID = (String) valueList.get(6);
                                this.mUploadInfo.mIssueStatus = (String) valueList.get(7);
                                this.mUploadInfo.mExtendInfo = (String) valueList.get(8);
                                this.mUploadInfo.mIssueLocation = (String) valueList.get(9);
                                this.mUploadInfo.mIssueTime = (String) valueList.get(10);
                                this.mUploadInfo.mBduss = (String) valueList.get(11);
                                this.mUploadInfo.mCuid = (String) valueList.get(12);
                                this.mUploadInfo.mSessionID = (String) valueList.get(13);
                                LogUtil.m15791e(MODULENAME, this.mUploadInfo.toString());
                                if (bufReader2 != null) {
                                    try {
                                        bufReader2.close();
                                    } catch (IOException e2) {
                                        e2.printStackTrace();
                                    }
                                }
                                if (fileReader2 != null) {
                                    try {
                                        fileReader2.close();
                                        bufReader = bufReader2;
                                        fileReader = fileReader2;
                                        return;
                                    } catch (IOException e22) {
                                        e22.printStackTrace();
                                        bufReader = bufReader2;
                                        fileReader = fileReader2;
                                        return;
                                    }
                                }
                                fileReader = fileReader2;
                                return;
                            }
                        }
                        if (bufReader2 != null) {
                            try {
                                bufReader2.close();
                            } catch (IOException e222) {
                                e222.printStackTrace();
                            }
                        }
                        if (fileReader2 != null) {
                            try {
                                fileReader2.close();
                            } catch (IOException e2222) {
                                e2222.printStackTrace();
                            }
                        }
                    } catch (Exception e3) {
                        e = e3;
                        bufReader = bufReader2;
                        fileReader = fileReader2;
                        try {
                            LogUtil.m15791e(MODULENAME, e.toString());
                            if (bufReader != null) {
                                try {
                                    bufReader.close();
                                } catch (IOException e22222) {
                                    e22222.printStackTrace();
                                }
                            }
                            if (fileReader == null) {
                                try {
                                    fileReader.close();
                                } catch (IOException e222222) {
                                    e222222.printStackTrace();
                                }
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            if (bufReader != null) {
                                try {
                                    bufReader.close();
                                } catch (IOException e2222222) {
                                    e2222222.printStackTrace();
                                }
                            }
                            if (fileReader != null) {
                                try {
                                    fileReader.close();
                                } catch (IOException e22222222) {
                                    e22222222.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        bufReader = bufReader2;
                        fileReader = fileReader2;
                        if (bufReader != null) {
                            bufReader.close();
                        }
                        if (fileReader != null) {
                            fileReader.close();
                        }
                        throw th;
                    }
                } catch (Exception e4) {
                    e = e4;
                    fileReader = fileReader2;
                    LogUtil.m15791e(MODULENAME, e.toString());
                    if (bufReader != null) {
                        bufReader.close();
                    }
                    if (fileReader == null) {
                        fileReader.close();
                    }
                } catch (Throwable th4) {
                    th = th4;
                    fileReader = fileReader2;
                    if (bufReader != null) {
                        bufReader.close();
                    }
                    if (fileReader != null) {
                        fileReader.close();
                    }
                    throw th;
                }
            } catch (Exception e5) {
                e = e5;
                LogUtil.m15791e(MODULENAME, e.toString());
                if (bufReader != null) {
                    bufReader.close();
                }
                if (fileReader == null) {
                    fileReader.close();
                }
            }
        }
    }

    private void asynUploadLocalFile(final String dataPath) {
        LogUtil.m15791e(MODULENAME, "uploadLocalFile dataPath= " + dataPath);
        ReqData reqdata = new ReqData(CommandConstants.K_COMMAND_KEY_GENERAL_HTTPPOST_DATA_FUNC, 7, this.mHandler, CommandConst.K_MSG_GENERAL_HTTP_TYPE_UPLOAD_LOCALFILE, 10000);
        this.mResponseInfo.dataPath = dataPath;
        this.mResponseInfo.type = this.mUploadInfo.mStoreType;
        reqdata.setObj(this.mResponseInfo);
        reqdata.mCookieStore = getCookieStore();
        CmdGeneralHttpPostDataFunc.addFunc(reqdata, new CmdGeneralHttpPostDataFunc.Callback() {
            public boolean parseResponseJSON(JSONObject jsonObj) {
                return false;
            }

            public String getUrl() {
                return BNDrivingToolUtils.sIsOnlineURL ? BNDrivingToolParams.PUSH_ISSUE_URL_ONLINE : BNDrivingToolParams.PUSH_ISSUE_URL;
            }

            public int getRequestType() {
                return 1;
            }

            public MultipartEntity getMultipartEntity() {
                MultipartEntity entity = new MultipartEntity(HttpMultipartMode.BROWSER_COMPATIBLE);
                try {
                    FileBody fileBody = new FileBody(new File(dataPath));
                    byte[] fileByte = BNDrivingToolUtils.decodeBitmapFromFile(dataPath, BNaviProtocolDef.DEFAULT_IMAGE_HEIGHT, 800);
                    if (String.valueOf(4).equals(BNDrivingToolManager.this.mUploadInfo.mStoreType)) {
                        BNDrivingToolManager.this.mUploadInfo.mStoreType = String.valueOf(2);
                    }
                    entity.addPart(BNDrivingToolManager.this.getTypeString(BNDrivingToolManager.this.mUploadInfo.mStoreType), new ByteArrayBody(fileByte, new File(dataPath).getName()));
                    entity.addPart("ignoreLogin", new StringBody("1"));
                    entity.addPart("task_id", new StringBody(BNDrivingToolManager.this.mUploadInfo.mTaskID));
                    entity.addPart("route_id", new StringBody(BNDrivingToolManager.this.mUploadInfo.mRouteID));
                    if (TextUtils.isEmpty(BNDrivingToolManager.this.mUploadInfo.mIssueID)) {
                        entity.addPart("problem_id", new StringBody(BNDrivingToolManager.this.mUploadInfo.mIssueID));
                    } else {
                        String[] issueArray = BNDrivingToolManager.this.mUploadInfo.mIssueID.trim().split("\\|");
                        String issueId = BNDrivingToolManager.this.mUploadInfo.mIssueID;
                        if (issueArray != null && issueArray.length > 0) {
                            issueId = issueArray[0];
                        }
                        entity.addPart("problem_id", new StringBody(issueId));
                    }
                    if (BNDrivingToolManager.this.checkParamAdded(BNDrivingToolManager.this.mUploadInfo.mIssueDescrption)) {
                        entity.addPart("problem_describe", new StringBody(URLEncoder.encode(BNDrivingToolManager.this.mUploadInfo.mIssueDescrption, "UTF-8")));
                    }
                    if (BNDrivingToolManager.this.checkParamAdded(BNDrivingToolManager.this.mUploadInfo.mIssueType)) {
                        entity.addPart("problem_type", new StringBody(BNDrivingToolManager.this.mUploadInfo.mIssueType));
                    }
                    if (BNDrivingToolManager.this.checkParamAdded(BNDrivingToolManager.this.mUploadInfo.mPersonReliableID)) {
                        entity.addPart("person_liable", new StringBody(BNDrivingToolManager.this.mUploadInfo.mPersonReliableID));
                    }
                    if (BNDrivingToolManager.this.checkParamAdded(BNDrivingToolManager.this.mUploadInfo.mIssueStatus)) {
                        entity.addPart("status", new StringBody(BNDrivingToolManager.this.mUploadInfo.mIssueStatus));
                    }
                    entity.addPart("extends_info", new StringBody(BNDrivingToolManager.this.mUploadInfo.mExtendInfo));
                    entity.addPart("problem_poi", new StringBody(BNDrivingToolManager.this.mUploadInfo.mIssueLocation));
                    entity.addPart("problem_time", new StringBody(BNDrivingToolManager.this.mUploadInfo.mIssueTime));
                    entity.addPart("cuid", new StringBody(BNDrivingToolManager.this.mUploadInfo.mCuid));
                    entity.addPart("session_id", new StringBody(BNDrivingToolManager.this.mUploadInfo.mSessionID));
                    LogUtil.m15791e(BNDrivingToolManager.MODULENAME, "asynupload file prarams" + BNDrivingToolManager.this.mUploadInfo.toString());
                    BNDrivingToolUtils.log("asynupload file prarams" + dataPath + BNDrivingToolManager.this.mUploadInfo.toString());
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                return entity;
            }
        });
        CommandCenter.getInstance().sendRequest(reqdata);
    }

    private boolean checkParamAdded(String parma) {
        if (parma == null || parma.equals("null")) {
            return false;
        }
        return true;
    }

    private String getTypeString(String typeString) {
        int type = Integer.parseInt(typeString);
        if (type == 3) {
            return "screen";
        }
        if (type == 2) {
            return "photo";
        }
        if (type == 1) {
            return "video";
        }
        if (type == 4) {
            return "screen";
        }
        return null;
    }

    public void asynAntiGeoSearch(Context ctx) {
        int netMode = 1;
        if (1 == 1 && !NetworkUtils.isNetworkAvailable(ctx)) {
            netMode = 0;
        }
        BNPoiSearcher.getInstance().asynGetPoiByPoint(RGEngineControl.getInstance().getCarGeoPoint(), netMode, 10000, this.mHandler);
    }

    private boolean isIndexValueEmpty(String value) {
        if (value.equals("null")) {
            return true;
        }
        return false;
    }

    private void writeValue(FileOutputStream fos, String value) throws UnsupportedEncodingException, IOException {
        if (TextUtils.isEmpty(value)) {
            fos.write("null".getBytes("utf-8"));
        } else {
            fos.write(value.getBytes("utf-8"));
        }
        fos.write(getLineBytes());
    }

    public String getResourceStorePath() {
        return null;
    }

    public void uninit() {
    }

    public void clearIssueInfo() {
        this.mDrivingToolIssueInfo.mIssueID = null;
        this.mDrivingToolIssueInfo.mIssueDescrption = null;
        this.mDrivingToolIssueInfo.mIssueType = null;
        this.mDrivingToolIssueInfo.mPersonReliableID = null;
        this.mDrivingToolIssueInfo.mIssueStatus = null;
    }

    public BNDrivingToolIssueStoreDialog getIssueStoreDialog(int type) {
        Context ctx = BNaviModuleManager.getNaviActivity();
        if (ctx == null) {
            return null;
        }
        if (type == 4) {
            BNAttachmentManager.getInstance().mFilePathList.clear();
            getInstance().isNoDrivingTest = true;
        } else {
            getInstance().isNoDrivingTest = false;
        }
        this.mIssueStoreDialog = new BNDrivingToolIssueStoreDialog(ctx, type);
        this.mIssueStoreDialog.setOnDismissListener(new C46649());
        this.mIssueStoreDialog.setCanceledOnTouchOutside(false);
        return this.mIssueStoreDialog;
    }

    public BNDrivingToolIssueStoreDialog getCurrentIssueStoreDialog() {
        return this.mIssueStoreDialog;
    }
}
