package com.baidu.navisdk.ui.widget;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
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
import android.widget.TextView;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.debug.NavSDKDebug;
import com.baidu.navisdk.hudsdk.BNRemoteConstants;
import com.baidu.navisdk.jni.nativeif.JNIGuidanceControl;
import com.baidu.navisdk.logic.CommandConst;
import com.baidu.navisdk.logic.commandparser.CmdDebugModeGetURL;
import com.baidu.navisdk.logic.commandparser.DebugModeMessageBean;
import com.baidu.navisdk.logic.commandparser.DebugModeMessageSerBean;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.ui.util.ForbidDaulClickUtils;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.ui.widget.StatusButton.StatusButtonChild;
import com.baidu.navisdk.ui.widget.StatusButton.onStatusButtonClickListener;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.NetworkUtils;
import com.baidu.navisdk.util.common.PackageUtil;
import com.baidu.navisdk.util.drivertool.BNDrivingToolManager;
import com.baidu.navisdk.util.drivertool.BNDrivingToolParams;
import com.baidu.navisdk.util.drivertool.BNDrivingToolUtils;
import com.baidu.navisdk.util.http.HttpURLManager;
import com.baidu.navisdk.util.http.HttpURLManager.ULRParam;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.navisdk.util.worker.BNWorkerCenter;
import com.baidu.navisdk.util.worker.BNWorkerConfig;
import com.baidu.navisdk.util.worker.BNWorkerNormalTask;
import java.util.List;
import java.util.Map;

public class BNDebugModelDialog extends Dialog {
    public static final boolean ANTI_CHEAT_DEBUG_SHOW = false;
    private ArrayAdapter<String> adapter;
    private int[] hDivider = new int[]{C4048R.id.bnav_rg_menu_h_divider_1, C4048R.id.bnav_rg_menu_h_divider_2, C4048R.id.bnav_rg_menu_h_divider_3, C4048R.id.bnav_rg_menu_h_divider_4, C4048R.id.bnav_rg_menu_h_divider_5, C4048R.id.bnav_rg_menu_h_divider_6, C4048R.id.bnav_rg_menu_h_divider_7, C4048R.id.bnav_rg_menu_h_divider_8, C4048R.id.bnav_rg_menu_h_divider_9};
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
    private Handler mHandler = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message msg) {
            if (CommandConst.K_MSG_GENERAL_HTTP_DEBUG_MODE_GET_URL_EXEC == msg.what) {
                if (msg.arg1 == 0) {
                    HttpURLManager.getInstance().mGuideMsg = CmdDebugModeGetURL.mGuideMsg;
                    BNDebugModelDialog.this.mGuideMsg = HttpURLManager.getInstance().mGuideMsg;
                    if (BNDebugModelDialog.this.mGuideMsg != null && BNDebugModelDialog.this.mGuideMsg.size() > 0) {
                        if (BNDebugModelDialog.this.mAdapter == null) {
                            BNDebugModelDialog.this.mAdapter = new DebugUrlAdapter();
                            BNDebugModelDialog.this.mELUrlDebugView.setAdapter(BNDebugModelDialog.this.mAdapter);
                        }
                        BNDebugModelDialog.this.mRLUrlDebugExpandView.setVisibility(0);
                    }
                } else {
                    TipTool.onCreateToastDialog(BNDebugModelDialog.this.mContext, "url配置请求失败 + error msg = " + msg.arg1);
                }
            }
            super.handleMessage(msg);
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
    protected OnCancelListener mOnCancelListener = null;
    private OnClickListener mOnClickListener = null;
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
    private onStatusButtonClickListener mStatusButtonClickListener = null;
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

    /* renamed from: com.baidu.navisdk.ui.widget.BNDebugModelDialog$2 */
    class C45672 implements OnChildClickListener {
        C45672() {
        }

        public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
            if (BNDebugModelDialog.this.mGuideMsg != null) {
                boolean z;
                DebugModeMessageSerBean serBean = (DebugModeMessageSerBean) ((DebugModeMessageBean) BNDebugModelDialog.this.mGuideMsg.get(groupPosition)).serList.get(childPosition);
                if (serBean.flag) {
                    z = false;
                } else {
                    z = true;
                }
                serBean.flag = z;
                if (serBean.type == 0) {
                    if (serBean.flag) {
                        HttpURLManager.getInstance().putUrl(serBean.key, serBean.value);
                        JNIGuidanceControl.getInstance().loadUrlAddrConfigParams(serBean.key, HttpURLManager.getInstance().getUsedUrl(serBean.key));
                    } else {
                        JNIGuidanceControl.getInstance().resetUrlAddrConfigParams(serBean.key);
                    }
                } else if (serBean.flag) {
                    HttpURLManager.getInstance().putUrl(serBean.key, serBean.value);
                } else {
                    HttpURLManager.getInstance().putUrl(serBean.key, HttpURLManager.getInstance().getOnlineUrl(serBean.key));
                }
                BNDebugModelDialog.this.synUrlHostOneMoudlue(serBean);
                BNDebugModelDialog.this.mAdapter.notifyDataSetChanged();
                BNDebugModelDialog.this.mELUrlDebugView.expandGroup(groupPosition);
            }
            return false;
        }
    }

    /* renamed from: com.baidu.navisdk.ui.widget.BNDebugModelDialog$3 */
    class C45683 implements OnClickListener {
        C45683() {
        }

        public void onClick(View v) {
            BNDebugModelDialog.this.dismiss();
            BNDebugModelDialog.this.setStartButtonState(false);
            BNDebugModelDialog.this.mDrivingToolStartBtn.setVisibility(8);
            BNDebugModelDialog.this.mDrivingToolOpenBtn.setVisibility(0);
            if (BNDebugModelDialog.this.mShowPullBtn != null) {
                BNDebugModelDialog.this.mShowPullBtn.setVisibility(8);
            }
            BNDrivingToolManager.getInstance().mNewRouteList.clear();
        }
    }

    /* renamed from: com.baidu.navisdk.ui.widget.BNDebugModelDialog$4 */
    class C45694 implements OnClickListener {
        C45694() {
        }

        public void onClick(View v) {
            BNDebugModelDialog.this.dismiss();
        }
    }

    /* renamed from: com.baidu.navisdk.ui.widget.BNDebugModelDialog$5 */
    class C45705 implements OnClickListener {
        C45705() {
        }

        public void onClick(View v) {
            BNDrivingToolManager.getInstance().isSinglePerson = false;
            BNDebugModelDialog.this.mMuitipleBtn.setVisibility(8);
            BNDebugModelDialog.this.mRouteLl.setVisibility(0);
            BNDebugModelDialog.this.mDrivingToolStartBtn.setVisibility(0);
            BNDebugModelDialog.this.mSingleDtBtn.setVisibility(8);
            BNDebugModelDialog.this.mStopDtBtn.setVisibility(8);
            BNDrivingToolManager.getInstance().asynPullRoadList();
        }
    }

    /* renamed from: com.baidu.navisdk.ui.widget.BNDebugModelDialog$6 */
    class C45716 implements OnClickListener {
        C45716() {
        }

        public void onClick(View v) {
            if (BNDebugModelDialog.this.mTaskListSp != null) {
                BNDebugModelDialog.this.mTaskListSp.setSelection(0);
            }
        }
    }

    /* renamed from: com.baidu.navisdk.ui.widget.BNDebugModelDialog$7 */
    class C45727 implements OnItemSelectedListener {
        C45727() {
        }

        public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
            List<String> taskList = BNDrivingToolManager.getInstance().mTaskList;
            if (taskList != null) {
                String taskName = (String) taskList.get(position);
                String taskId = null;
                if (BNDrivingToolParams.DEFAULT_SPINNER_DATA.equals(taskName)) {
                    BNDrivingToolManager.getInstance().isTaskRet = false;
                } else {
                    BNDrivingToolManager.getInstance().isTaskRet = true;
                }
                if (!BNDrivingToolParams.DEFAULT_SPINNER_DATA.equals(taskName)) {
                    taskId = (String) BNDrivingToolManager.getInstance().mTaskMap.get(taskName);
                    BNDrivingToolManager.getInstance().mTaskID = taskId;
                }
                if (BNDrivingToolManager.getInstance().canDrivingToolStart()) {
                    BNDrivingToolManager.getInstance().isSinglePerson = false;
                    BNDebugModelDialog.this.setStartButtonState(true);
                    BNSettingManager.setShowingDrivingTool(true);
                    BNDrivingToolUtils.storeDrivingToolTask();
                    BNDrivingToolUtils.sCanShow = true;
                } else {
                    BNDebugModelDialog.this.setStartButtonState(false);
                    BNSettingManager.setShowingDrivingTool(false);
                    BNDrivingToolUtils.sCanShow = false;
                }
                if (BNDebugModelDialog.this.mSingleDtBtn.getVisibility() == 0) {
                    if (BNDrivingToolManager.getInstance().isTaskRet) {
                        BNDebugModelDialog.this.setSingleButtonState(true);
                        BNSettingManager.setShowingDrivingTool(true);
                        BNDrivingToolUtils.storeDrivingToolTask();
                        BNDrivingToolManager.getInstance().isSinglePerson = true;
                        BNDrivingToolUtils.sCanShow = true;
                    } else {
                        BNDebugModelDialog.this.setSingleButtonState(false);
                        BNSettingManager.setShowingDrivingTool(false);
                        BNDrivingToolUtils.sCanShow = false;
                    }
                }
                if (!BNDrivingToolParams.DEFAULT_SPINNER_DATA.equals(taskName)) {
                    BNDrivingToolManager.getInstance().mRouteFlag = "0";
                    if (!BNDrivingToolManager.getInstance().isSinglePerson) {
                        BNDrivingToolManager.getInstance().asynPullRoadList();
                    }
                }
                LogUtil.m15791e(BNDrivingToolManager.MODULENAME, "taskId is + " + taskId);
            }
        }

        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    /* renamed from: com.baidu.navisdk.ui.widget.BNDebugModelDialog$8 */
    class C45738 implements OnItemSelectedListener {
        C45738() {
        }

        public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
            List<String> routeList = BNDrivingToolManager.getInstance().mRouteList;
            if (routeList != null) {
                String routeName = (String) routeList.get(position);
                if (BNDrivingToolParams.DEFAULT_SPINNER_DATA.equals(routeName)) {
                    BNDrivingToolManager.getInstance().isRouteRet = false;
                } else {
                    BNDrivingToolManager.getInstance().isRouteRet = true;
                    BNDrivingToolManager.getInstance().mRouteName = routeName;
                }
                if (BNDrivingToolManager.getInstance().canDrivingToolStart()) {
                    BNDebugModelDialog.this.setStartButtonState(true);
                    BNSettingManager.setShowingDrivingTool(true);
                    BNDrivingToolUtils.storeDrivingToolTask();
                    BNDrivingToolManager.getInstance().isSinglePerson = false;
                    BNDrivingToolUtils.sCanShow = true;
                } else {
                    BNDebugModelDialog.this.setStartButtonState(false);
                    BNSettingManager.setShowingDrivingTool(false);
                    BNDrivingToolUtils.sCanShow = false;
                }
                List<String> newRouteList = BNDrivingToolManager.getInstance().mNewRouteList;
                if (newRouteList == null || newRouteList.size() <= 0) {
                    BNDrivingToolManager.getInstance().mRouteFlag = "0";
                } else if (newRouteList.contains(routeName)) {
                    BNDrivingToolManager.getInstance().mRouteFlag = "1";
                } else {
                    BNDrivingToolManager.getInstance().mRouteFlag = "0";
                }
                String routeId = (String) BNDrivingToolManager.getInstance().mRoadMap.get(routeName);
                BNDrivingToolManager.getInstance().mRouteID = routeId;
                LogUtil.m15791e(BNDrivingToolManager.MODULENAME, "routeId is + " + routeId);
            }
        }

        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    /* renamed from: com.baidu.navisdk.ui.widget.BNDebugModelDialog$9 */
    class C45749 implements OnClickListener {
        C45749() {
        }

        public void onClick(View v) {
            if (!ForbidDaulClickUtils.isFastDoubleClick(1500)) {
                BNDrivingToolManager.getInstance().mRouteFlag = "1";
                BNDrivingToolManager.getInstance().asynPullRoadList();
            }
        }
    }

    class DebugUrlAdapter extends BaseExpandableListAdapter {
        ViewHolder mViewHolder;

        private class ViewHolder {
            CheckBox mCb;
            TextView mTVUrl;

            private ViewHolder() {
            }
        }

        DebugUrlAdapter() {
        }

        public Object getChild(int groupPosition, int childPosition) {
            return ((DebugModeMessageBean) BNDebugModelDialog.this.mGuideMsg.get(groupPosition)).serList.get(childPosition);
        }

        public long getChildId(int groupPosition, int childPosition) {
            return (long) childPosition;
        }

        public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
            DebugModeMessageSerBean bean = (DebugModeMessageSerBean) ((DebugModeMessageBean) BNDebugModelDialog.this.mGuideMsg.get(groupPosition)).serList.get(childPosition);
            if (convertView == null) {
                convertView = JarUtils.inflate((Activity) BNDebugModelDialog.this.mContext, C4048R.layout.nsdk_layout_debug_url_children, null);
                this.mViewHolder = new ViewHolder();
                this.mViewHolder.mTVUrl = (TextView) convertView.findViewById(C4048R.id.second_textview);
                this.mViewHolder.mCb = (CheckBox) convertView.findViewById(C4048R.id.child_check_box);
                convertView.setTag(this.mViewHolder);
            } else {
                this.mViewHolder = (ViewHolder) convertView.getTag();
            }
            this.mViewHolder.mTVUrl.setText(bean.key + "--" + bean.value);
            this.mViewHolder.mCb.setFocusable(false);
            this.mViewHolder.mCb.setClickable(false);
            if (bean.flag) {
                this.mViewHolder.mCb.setChecked(true);
            } else {
                this.mViewHolder.mCb.setChecked(false);
            }
            return convertView;
        }

        public int getChildrenCount(int groupPosition) {
            return ((DebugModeMessageBean) BNDebugModelDialog.this.mGuideMsg.get(groupPosition)).serList.size();
        }

        public Object getGroup(int groupPosition) {
            return BNDebugModelDialog.this.mGuideMsg.get(groupPosition);
        }

        public int getGroupCount() {
            return BNDebugModelDialog.this.mGuideMsg.size();
        }

        public long getGroupId(int groupPosition) {
            return (long) groupPosition;
        }

        public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = JarUtils.inflate((Activity) BNDebugModelDialog.this.mContext, C4048R.layout.nsdk_layout_debug_url_parent, null);
            }
            ((TextView) convertView.findViewById(C4048R.id.parent_textview)).setText(((DebugModeMessageBean) BNDebugModelDialog.this.mGuideMsg.get(groupPosition)).mSceneName);
            return convertView;
        }

        public boolean hasStableIds() {
            return true;
        }

        public boolean isChildSelectable(int groupPosition, int childPosition) {
            LogUtil.m15791e("wangyang", "selectable");
            return true;
        }
    }

    class SpinnerSelectedListener implements OnItemSelectedListener {
        SpinnerSelectedListener() {
        }

        public void onItemSelected(AdapterView arg0, View arg1, int arg2, long arg3) {
        }

        public void onNothingSelected(AdapterView arg0) {
        }
    }

    class SpinnerURLSelectedListener implements OnItemSelectedListener {
        SpinnerURLSelectedListener() {
        }

        public void onItemSelected(AdapterView arg0, View arg1, int arg2, long arg3) {
        }

        public void onNothingSelected(AdapterView arg0) {
        }
    }

    public BNDebugModelDialog(Context context) {
        View view;
        super(context);
        this.mContext = context;
        if (VERSION.SDK_INT < 21) {
            Theme theme = JarUtils.getResources().newTheme();
            theme.applyStyle(C4048R.style.theme_comm_progressdlg, true);
            JarUtils.setDialogThemeField(this, theme);
        } else {
            Window win = getWindow();
            requestWindowFeature(1);
            win.setBackgroundDrawableResource(17170445);
            win.getAttributes().gravity = 17;
        }
        try {
            view = JarUtils.oldInflate((Activity) context, C4048R.layout.nsdk_layout_debug_mode_dialog, null);
        } catch (Exception e) {
            view = null;
        }
        if (view != null) {
            setContentView(view);
            setCanceledOnTouchOutside(false);
            setCancelable(true);
            getWindow().getAttributes().gravity = 17;
            findView();
            setCloseIVListener();
            initListener();
            initButtonStatus();
        }
    }

    public void findView() {
        this.mCloseIV = (ImageView) findViewById(C4048R.id.iv_dialog_close);
        this.mFactoryCategory = findViewById(C4048R.id.bnav_rg_menu_factory_category);
        this.mCuidView = findViewById(C4048R.id.bnav_rg_menu_factory_cuid_item);
        this.mBuildView = findViewById(C4048R.id.bnav_rg_menu_factory_build_item);
        this.mJavaLogView = findViewById(C4048R.id.bnav_rg_menu_factory_java_log);
        this.mNativeLogView = findViewById(C4048R.id.bnav_rg_menu_factory_native_log);
        this.mMonkeyView = findViewById(C4048R.id.bnav_rg_menu_factory_monkey);
        this.mCuidTv = (TextView) findViewById(C4048R.id.bnav_rg_menu_cuid_item_tv);
        this.mBuildTimeTv = (TextView) findViewById(C4048R.id.bnav_rg_menu_build_item_tv);
        this.mJavaLogBtn = (StatusButton) findViewById(C4048R.id.bnav_rg_menu_java_log_checkbox);
        this.mNativeLogBtn = (StatusButton) findViewById(C4048R.id.bnav_rg_menu_native_log_checkbox);
        this.mMonkeyBtn = (StatusButton) findViewById(C4048R.id.bnav_rg_menu_monkey_checkbox);
        this.mTTSVocoderView = findViewById(C4048R.id.bnav_rg_menu_factory_tts_vocoder_debug);
        this.mTTSVocoderBtn = (StatusButton) findViewById(C4048R.id.bnav_rg_menu_tts_vocoder_checkbox);
        this.mAntiCheatView = findViewById(C4048R.id.bnav_rg_menu_factory_antic);
        this.mAntiCheatBtn = (StatusButton) findViewById(C4048R.id.bnav_rg_menu_antic_checkbox);
        this.mTTSSpeedUpIv = (ImageView) findViewById(C4048R.id.bnav_rg_menu_tts_speed_debug_up_iv);
        this.mTTSSpeedDownIv = (ImageView) findViewById(C4048R.id.bnav_rg_menu_tts_speed_debug_down_iv);
        this.mTTSSpeedResetBtn = (Button) findViewById(C4048R.id.bnav_rg_menu_tts_speed_debug_reset_btn);
        this.mTTSSpeedTv = (TextView) findViewById(C4048R.id.bnav_rg_menu_tts_speed_num_debug_tv);
        this.mRLGPSDebugView = (RelativeLayout) findViewById(C4048R.id.bnav_rg_menu_factory_gps_debug);
        this.mTVGPSDebugView = (TextView) findViewById(C4048R.id.bnav_rg_menu_gps_debug_tv);
        this.mSBGPSDebugView = (StatusButton) findViewById(C4048R.id.bnav_rg_menu_gps_checkbox);
        this.mRLUrlDebugView = (RelativeLayout) findViewById(C4048R.id.bnav_rg_menu_factory_debug_url);
        this.mTVUrlDebugView = (TextView) findViewById(C4048R.id.bnav_rg_menu_factory_debug_url_tv);
        this.mRLUrlDebugExpandView = (RelativeLayout) findViewById(C4048R.id.bnav_rl_expandable_debug_url);
        this.mELUrlDebugView = (ExpandableListView) findViewById(C4048R.id.bnav_rg_expandable_debug_url);
        this.mNotificationDebugView = findViewById(C4048R.id.bnav_rg_menu_factory_notification_layout);
        this.mNotificationDebugBtn = (StatusButton) findViewById(C4048R.id.bnav_rg_menu_java_notification_checkbox);
        this.mRootScreenView = (RelativeLayout) findViewById(C4048R.id.bnav_rg_menu_factory_root_switch);
        this.mRootScreenBtn = (StatusButton) findViewById(C4048R.id.bnav_rg_menu_root_screen_checkbox);
        this.mImageLogView = (RelativeLayout) findViewById(C4048R.id.bnav_rg_menu_factory_image_switch);
        this.mImageLogBtn = (StatusButton) findViewById(C4048R.id.bnav_rg_menu_image_log_checkbox);
        this.mHttpsDebugView = findViewById(C4048R.id.bnav_rg_menu_factory_https_layout);
        this.mHttpsDebugBtn = (StatusButton) findViewById(C4048R.id.bnav_rg_menu_java_https_checkbox);
        this.mELUrlDebugView.setOnChildClickListener(new C45672());
        this.mTVUrlDebugColseView = (TextView) findViewById(C4048R.id.bnav_rg_expandable_close_tv);
        this.mDrivingToolOpenBtn = (StatusButton) findViewById(C4048R.id.bnav_rg_menu_driving_tool_checkbox);
        if (this.mDrivingToolOpenBtn != null) {
            this.mDrivingToolOpenBtn.setLeftButtonText(BNStyleManager.getString(C4048R.string.nsdk_string_open));
            this.mDrivingToolOpenBtn.setRightButtonText(BNStyleManager.getString(C4048R.string.nsdk_string_close));
            this.mDrivingToolOpenBtn.setMidBtnGone(true);
            this.mDrivingToolOpenBtn.setRightBtnChecked();
        }
        this.mDrivingToolStartBtn = (Button) findViewById(C4048R.id.bnav_rg_menu_start_driving_btn);
        this.mShowPullBtn = (RelativeLayout) findViewById(C4048R.id.bnav_rg_menu_pull_list_rl);
        if (this.mDrivingToolStartBtn != null) {
            this.mDrivingToolStartBtn.setVisibility(8);
            this.mDrivingToolStartBtn.setOnClickListener(new C45683());
        }
        setStartButtonState(false);
        if (this.mShowPullBtn != null) {
            this.mShowPullBtn.setVisibility(8);
        }
        this.mSingleDtBtn = (Button) findViewById(C4048R.id.bnav_rg_menu_single_driving_btn);
        if (this.mSingleDtBtn != null) {
            this.mSingleDtBtn.setOnClickListener(new C45694());
        }
        this.mRouteLl = (LinearLayout) findViewById(C4048R.id.bnav_menu_route_ll);
        this.mMuitipleBtn = (Button) findViewById(C4048R.id.bnav_rg_menu_multiple_btn);
        if (this.mMuitipleBtn != null) {
            this.mMuitipleBtn.setOnClickListener(new C45705());
        }
        this.mStopDtBtn = (Button) findViewById(C4048R.id.bnav_rg_menu_stop_driving_btn);
        if (this.mStopDtBtn != null) {
            this.mStopDtBtn.setOnClickListener(new C45716());
        }
        this.mTaskListSp = (Spinner) findViewById(C4048R.id.bnav_rg_menu_task_list_sp);
        if (this.mTaskListSp != null) {
            BNDrivingToolManager.getInstance().asynPullTaskList();
            this.mTaskListSp.setOnItemSelectedListener(new C45727());
        }
        this.mRouteListSp = (Spinner) findViewById(C4048R.id.bnav_rg_menu_road_line_sp);
        if (this.mRouteListSp != null) {
            this.mRouteListSp.setOnItemSelectedListener(new C45738());
        }
        this.mCreateRouteBtn = (Button) findViewById(C4048R.id.bnav_rg_menu_new_road_btn);
        if (this.mCreateRouteBtn != null) {
            this.mCreateRouteBtn.setOnClickListener(new C45749());
        }
        if (!(this.mRLUrlDebugView == null || this.mTVUrlDebugView == null)) {
            this.mRLUrlDebugView.setVisibility(0);
            this.mTVUrlDebugView.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    if (HttpURLManager.getInstance().mGuideMsg != null && HttpURLManager.getInstance().mGuideMsg.size() > 0) {
                        BNDebugModelDialog.this.mGuideMsg = HttpURLManager.getInstance().mGuideMsg;
                        if (BNDebugModelDialog.this.mAdapter == null) {
                            BNDebugModelDialog.this.mAdapter = new DebugUrlAdapter();
                            BNDebugModelDialog.this.mELUrlDebugView.setAdapter(BNDebugModelDialog.this.mAdapter);
                        }
                        BNDebugModelDialog.this.mRLUrlDebugExpandView.setVisibility(0);
                    } else if (NetworkUtils.isNetworkAvailable(BNDebugModelDialog.this.mContext)) {
                        CmdDebugModeGetURL.requestDebugModeUrl(BNDebugModelDialog.this.mHandler);
                    } else {
                        TipTool.onCreateToastDialog(BNDebugModelDialog.this.mContext, "网络未连接");
                    }
                }
            });
            this.mTVUrlDebugColseView.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    BNDebugModelDialog.this.mRLUrlDebugExpandView.setVisibility(8);
                }
            });
        }
        if (this.mFactoryCategory != null) {
            this.mFactoryCategory.setVisibility(0);
        }
        if (!(this.mCuidView == null || this.mCuidTv == null)) {
            this.mCuidView.setVisibility(0);
            this.mCuidTv.setText("CUID:" + PackageUtil.getCuid());
        }
        if (!(this.mBuildView == null || this.mBuildTimeTv == null)) {
            this.mBuildView.setVisibility(0);
            this.mBuildTimeTv.setText("BuildTime:(" + PackageUtil.getBuildNo() + ")");
        }
        if (!(this.mJavaLogView == null || this.mJavaLogBtn == null)) {
            this.mJavaLogView.setVisibility(0);
            this.mJavaLogBtn.setLeftButtonText(BNStyleManager.getString(C4048R.string.nsdk_string_open));
            this.mJavaLogBtn.setRightButtonText(BNStyleManager.getString(C4048R.string.nsdk_string_close));
            this.mJavaLogBtn.setMidBtnGone(true);
        }
        if (!(this.mNotificationDebugView == null || this.mNotificationDebugBtn == null)) {
            this.mNotificationDebugView.setVisibility(0);
            this.mNotificationDebugBtn.setLeftButtonText(BNStyleManager.getString(C4048R.string.nsdk_string_open));
            this.mNotificationDebugBtn.setRightButtonText(BNStyleManager.getString(C4048R.string.nsdk_string_close));
            this.mNotificationDebugBtn.setMidBtnGone(true);
        }
        if (!(this.mRootScreenView == null || this.mRootScreenBtn == null)) {
            this.mRootScreenView.setVisibility(0);
            this.mRootScreenBtn.setLeftButtonText("开启");
            this.mRootScreenBtn.setRightButtonText("关闭");
            this.mRootScreenBtn.setMidBtnGone(true);
        }
        if (!(this.mImageLogView == null || this.mImageLogBtn == null)) {
            this.mImageLogView.setVisibility(0);
            this.mImageLogBtn.setLeftButtonText("开启");
            this.mImageLogBtn.setRightButtonText("关闭");
            this.mImageLogBtn.setMidBtnGone(true);
        }
        if (!(this.mHttpsDebugView == null || this.mHttpsDebugBtn == null)) {
            this.mHttpsDebugView.setVisibility(0);
            this.mHttpsDebugBtn.setLeftButtonText(BNStyleManager.getString(C4048R.string.nsdk_string_open));
            this.mHttpsDebugBtn.setRightButtonText(BNStyleManager.getString(C4048R.string.nsdk_string_close));
            this.mHttpsDebugBtn.setMidBtnGone(true);
        }
        if (!(this.mNativeLogView == null || this.mNativeLogBtn == null)) {
            this.mNativeLogView.setVisibility(0);
            this.mNativeLogBtn.setLeftButtonText(BNStyleManager.getString(C4048R.string.nsdk_string_open));
            this.mNativeLogBtn.setRightButtonText(BNStyleManager.getString(C4048R.string.nsdk_string_close));
            this.mNativeLogBtn.setMidBtnGone(true);
        }
        if (!(this.mMonkeyView == null || this.mMonkeyBtn == null)) {
            this.mMonkeyView.setVisibility(0);
            this.mMonkeyBtn.setLeftButtonText(BNStyleManager.getString(C4048R.string.nsdk_string_open));
            this.mMonkeyBtn.setRightButtonText(BNStyleManager.getString(C4048R.string.nsdk_string_close));
            this.mMonkeyBtn.setMidBtnGone(true);
        }
        if (!(this.mTTSVocoderView == null || this.mTTSVocoderBtn == null)) {
            this.mTTSVocoderView.setVisibility(0);
            this.mTTSVocoderBtn.setLeftButtonText("0");
            this.mTTSVocoderBtn.setMidButtonText("1");
            this.mTTSVocoderBtn.setRightButtonText("2");
        }
        if (this.mRLGPSDebugView != null && this.mSBGPSDebugView != null) {
            this.mRLGPSDebugView.setVisibility(0);
            this.mSBGPSDebugView.setLeftButtonText(BNStyleManager.getString(C4048R.string.nsdk_string_open));
            this.mSBGPSDebugView.setRightButtonText(BNStyleManager.getString(C4048R.string.nsdk_string_close));
            this.mSBGPSDebugView.setMidBtnGone(true);
        }
    }

    public void setSingleButtonState(boolean state) {
        if (this.mSingleDtBtn != null) {
            if (state) {
                this.mSingleDtBtn.setBackgroundColor(-16711936);
                this.mSingleDtBtn.setClickable(true);
                return;
            }
            this.mSingleDtBtn.setBackgroundColor(-7829368);
            this.mSingleDtBtn.setClickable(false);
        }
    }

    public void setStartButtonState(boolean state) {
        if (this.mDrivingToolStartBtn != null) {
            if (state) {
                this.mDrivingToolStartBtn.setBackgroundColor(-16711936);
                this.mDrivingToolStartBtn.setClickable(true);
                return;
            }
            this.mDrivingToolStartBtn.setBackgroundColor(-7829368);
            this.mDrivingToolStartBtn.setClickable(false);
        }
    }

    public void setRouteSpinnerCLickable(boolean isClickble) {
        if (this.mRouteListSp != null) {
            this.mRouteListSp.setClickable(isClickble);
        }
    }

    public void updateTaskListView() {
        if (this.mTaskListSp != null && BNDrivingToolManager.getInstance().mTaskList != null) {
            String lastTaskInfo = BNSettingManager.getLastDrivingInfo();
            String lastTaskId = null;
            if (lastTaskInfo != null) {
                String[] infoArray = lastTaskInfo.split(",");
                if (infoArray != null && infoArray.length > 0) {
                    lastTaskId = infoArray[0];
                }
            }
            String taskName = null;
            if (!TextUtils.isEmpty(lastTaskId)) {
                Map<String, String> taskMap = BNDrivingToolManager.getInstance().mTaskMap;
                if (taskMap != null && taskMap.size() > 0) {
                    for (String id : taskMap.values()) {
                        if (lastTaskId.equals(id)) {
                            taskName = BNRemoteConstants.ERROR_DEFAULT_STR;
                            break;
                        }
                    }
                }
            }
            ArrayAdapter<String> adapter = new ArrayAdapter(this.mContext, 17367048, BNDrivingToolManager.getInstance().mTaskList);
            adapter.setDropDownViewResource(17367049);
            this.mTaskListSp.setAdapter(adapter);
            if (!TextUtils.isEmpty(taskName)) {
                this.mTaskListSp.setSelection(0, true);
                BNWorkerCenter.getInstance().submitMainThreadTask(new BNWorkerNormalTask<String, String>("updateTaskListView-" + getClass().getSimpleName(), null) {
                    protected String execute() {
                        BNDebugModelDialog.this.updateTaskSpinnerView();
                        return null;
                    }
                }, new BNWorkerConfig(100, 0));
            }
        }
    }

    public void updatRouteListView() {
        if (this.mRouteListSp != null) {
            List<String> routeList = BNDrivingToolManager.getInstance().mRouteList;
            if (routeList != null) {
                ArrayAdapter<String> adapter = new ArrayAdapter(this.mContext, 17367048, routeList);
                adapter.setDropDownViewResource(17367049);
                this.mRouteListSp.setAdapter(adapter);
                if (BNDrivingToolManager.getInstance().mRouteList != null && BNDrivingToolManager.getInstance().mRouteFlag.equals("1")) {
                    this.mRouteListSp.setSelection(BNDrivingToolManager.getInstance().mRouteList.size() - 1, true);
                }
            }
        }
        setRouteSpinnerCLickable(true);
    }

    public void setCloseIVListener() {
        this.mCloseIV.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                if (BNDebugModelDialog.this.mOnCancelListener != null) {
                    BNDebugModelDialog.this.mOnCancelListener.onCancel(BNDebugModelDialog.this);
                }
                NavSDKDebug.sSDKFactoryMode = false;
                BNDebugModelDialog.this.dismiss();
            }
        });
    }

    public BNDebugModelDialog setYawingStyleGrivity(boolean isYawing) {
        Theme theme;
        if (isYawing) {
            theme = JarUtils.getResources().newTheme();
            theme.applyStyle(C4048R.style.theme_yaw_progressdlg, true);
            JarUtils.setDialogThemeField(this, theme);
            getWindow().getAttributes().gravity = 51;
        } else {
            theme = JarUtils.getResources().newTheme();
            theme.applyStyle(C4048R.style.theme_comm_progressdlg, true);
            JarUtils.setDialogThemeField(this, theme);
            getWindow().getAttributes().gravity = 17;
        }
        return this;
    }

    public void setOnCancelListener(OnCancelListener listener) {
        this.mOnCancelListener = listener;
        super.setOnCancelListener(listener);
    }

    public void setCloseGone() {
        this.mCloseIV.setVisibility(8);
    }

    public void setCloseVisible() {
        this.mCloseIV.setVisibility(0);
    }

    private void initStatusButtonClickListener() {
        this.mStatusButtonClickListener = new onStatusButtonClickListener() {
            public void onClick(StatusButton sButton, StatusButtonChild child) {
                if (sButton == BNDebugModelDialog.this.mJavaLogBtn && BNDebugModelDialog.this.mJavaLogBtn != null) {
                    switch (child) {
                        case LEFT:
                            BNSettingManager.setShowJavaLog(true);
                            return;
                        case RIGHT:
                            BNSettingManager.setShowJavaLog(false);
                            return;
                        default:
                            return;
                    }
                } else if (sButton == BNDebugModelDialog.this.mNotificationDebugBtn && BNDebugModelDialog.this.mNotificationDebugBtn != null) {
                    switch (child) {
                        case LEFT:
                            BNSettingManager.setShowNotificationDebug(true);
                            return;
                        case RIGHT:
                            BNSettingManager.setShowNotificationDebug(false);
                            return;
                        default:
                            return;
                    }
                } else if (sButton == BNDebugModelDialog.this.mRootScreenBtn && BNDebugModelDialog.this.mRootScreenBtn != null) {
                    switch (child) {
                        case LEFT:
                            BNSettingManager.setRootScreenOpen(true);
                            return;
                        case RIGHT:
                            BNSettingManager.setRootScreenOpen(false);
                            return;
                        default:
                            return;
                    }
                } else if (sButton == BNDebugModelDialog.this.mImageLogBtn && BNDebugModelDialog.this.mImageLogBtn != null) {
                    switch (child) {
                        case LEFT:
                            JNIGuidanceControl.getInstance().SetMapLoggerOpen(true);
                            return;
                        case RIGHT:
                            JNIGuidanceControl.getInstance().SetMapLoggerOpen(false);
                            return;
                        default:
                            return;
                    }
                } else if (sButton == BNDebugModelDialog.this.mHttpsDebugBtn && BNDebugModelDialog.this.mHttpsDebugBtn != null) {
                    switch (child) {
                        case LEFT:
                            BNSettingManager.setUseHttpsOfflineURL(true);
                            return;
                        case RIGHT:
                            BNSettingManager.setUseHttpsOfflineURL(false);
                            return;
                        default:
                            return;
                    }
                } else if (sButton == BNDebugModelDialog.this.mNativeLogBtn && BNDebugModelDialog.this.mNativeLogBtn != null) {
                    switch (child) {
                        case LEFT:
                            BNSettingManager.setShowNativeLog(true);
                            return;
                        case RIGHT:
                            BNSettingManager.setShowNativeLog(false);
                            return;
                        default:
                            return;
                    }
                } else if (sButton == BNDebugModelDialog.this.mMonkeyBtn && BNDebugModelDialog.this.mMonkeyBtn != null) {
                    switch (child) {
                        case LEFT:
                            BNSettingManager.setMonkey(true);
                            return;
                        case RIGHT:
                            BNSettingManager.setMonkey(false);
                            return;
                        default:
                            return;
                    }
                } else if (sButton == BNDebugModelDialog.this.mTTSVocoderBtn && BNDebugModelDialog.this.mTTSVocoderBtn != null) {
                    switch (child) {
                        case LEFT:
                            BNSettingManager.setTTSVocoderParam("0");
                            return;
                        case RIGHT:
                            BNSettingManager.setTTSVocoderParam("2");
                            return;
                        case MID:
                            BNSettingManager.setTTSVocoderParam("1");
                            return;
                        default:
                            return;
                    }
                } else if (sButton == BNDebugModelDialog.this.mSBGPSDebugView && BNDebugModelDialog.this.mSBGPSDebugView != null) {
                    switch (child) {
                        case LEFT:
                            BNSettingManager.setGPSDebug(true);
                            return;
                        case RIGHT:
                            BNSettingManager.setGPSDebug(false);
                            return;
                        default:
                            return;
                    }
                } else if (sButton == BNDebugModelDialog.this.mDrivingToolOpenBtn && BNDebugModelDialog.this.mDrivingToolOpenBtn != null) {
                    switch (child) {
                        case LEFT:
                            if (BNDrivingToolUtils.canDrivingToolOpen()) {
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
                            return;
                        case RIGHT:
                            return;
                        default:
                            return;
                    }
                }
            }
        };
    }

    private void initListener() {
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
            this.mTTSSpeedUpIv.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    if (BNDebugModelDialog.this.mTTSSpeedTv != null) {
                        int i = Integer.parseInt(BNDebugModelDialog.this.mTTSSpeedTv.getText().toString());
                        if (i >= 9) {
                            TipTool.onCreateToastDialog(BNDebugModelDialog.this.mContext, "当前为最高语速");
                            return;
                        }
                        i++;
                        BNDebugModelDialog.this.mTTSSpeedTv.setText(i + "");
                        BNSettingManager.setTTSSpeedParam(i);
                    }
                }
            });
        }
        if (this.mTTSSpeedDownIv != null) {
            this.mTTSSpeedDownIv.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    if (BNDebugModelDialog.this.mTTSSpeedTv != null) {
                        int i = Integer.parseInt(BNDebugModelDialog.this.mTTSSpeedTv.getText().toString());
                        if (i <= 0) {
                            TipTool.onCreateToastDialog(BNDebugModelDialog.this.mContext, "当前为最低语速");
                            return;
                        }
                        i--;
                        BNDebugModelDialog.this.mTTSSpeedTv.setText(i + "");
                        BNSettingManager.setTTSSpeedParam(i);
                    }
                }
            });
        }
        if (this.mTTSSpeedResetBtn != null) {
            this.mTTSSpeedResetBtn.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    if (BNDebugModelDialog.this.mTTSSpeedTv != null) {
                        BNDebugModelDialog.this.mTTSSpeedTv.setText(String.valueOf(5));
                    }
                    BNSettingManager.setTTSSpeedParam(5);
                }
            });
        }
    }

    public void initButtonStatus() {
        if (this.mJavaLogBtn != null) {
            if (BNSettingManager.isShowJavaLog()) {
                this.mJavaLogBtn.setLeftBtnChecked();
            } else {
                this.mJavaLogBtn.setRightBtnChecked();
            }
        }
        if (this.mNotificationDebugBtn != null) {
            if (BNSettingManager.isShowNotificationDebug()) {
                this.mNotificationDebugBtn.setLeftBtnChecked();
            } else {
                this.mNotificationDebugBtn.setRightBtnChecked();
            }
        }
        if (this.mImageLogBtn != null) {
            if (JNIGuidanceControl.getInstance().IsMapLoggerOpen()) {
                this.mImageLogBtn.setLeftBtnChecked();
            } else {
                this.mImageLogBtn.setRightBtnChecked();
            }
        }
        if (this.mRootScreenBtn != null) {
            if (BNSettingManager.isRootScreenOpen()) {
                this.mRootScreenBtn.setLeftBtnChecked();
            } else {
                this.mRootScreenBtn.setRightBtnChecked();
            }
        }
        if (this.mHttpsDebugBtn != null) {
            if (BNSettingManager.isUseHttpsOfflineURL()) {
                this.mHttpsDebugBtn.setLeftBtnChecked();
            } else {
                this.mHttpsDebugBtn.setRightBtnChecked();
            }
        }
        if (this.mNativeLogBtn != null) {
            if (BNSettingManager.isShowNativeLog()) {
                this.mNativeLogBtn.setLeftBtnChecked();
            } else {
                this.mNativeLogBtn.setRightBtnChecked();
            }
        }
        if (this.mMonkeyBtn != null) {
            if (BNSettingManager.isMonkey()) {
                this.mMonkeyBtn.setLeftBtnChecked();
            } else {
                this.mMonkeyBtn.setRightBtnChecked();
            }
        }
        if (this.mTTSVocoderBtn != null) {
            if (BNSettingManager.getTTSVocoderParam().equals("0")) {
                this.mTTSVocoderBtn.setLeftBtnChecked();
            } else if (BNSettingManager.getTTSVocoderParam().equals("1")) {
                this.mTTSVocoderBtn.setMidBtnChecked();
            } else {
                this.mTTSVocoderBtn.setRightBtnChecked();
            }
        }
        if (this.mSBGPSDebugView != null) {
            if (BNSettingManager.isGPSDebug()) {
                this.mSBGPSDebugView.setLeftBtnChecked();
            } else {
                this.mSBGPSDebugView.setRightBtnChecked();
            }
        }
        if (this.mDrivingToolOpenBtn != null) {
            if (BNSettingManager.isShowingDrivingTool()) {
                this.mDrivingToolOpenBtn.setLeftBtnChecked();
                updateDrivingToolView();
            } else {
                this.mDrivingToolOpenBtn.setRightBtnChecked();
            }
        }
        if (this.mTTSSpeedTv != null) {
            this.mTTSSpeedTv.setText(BNSettingManager.getTTSSpeedParam() + "");
        }
    }

    public void updateDrivingToolView() {
        this.mDrivingToolOpenBtn.setVisibility(8);
        this.mSingleDtBtn.setVisibility(0);
        this.mShowPullBtn.setVisibility(0);
        this.mRouteLl.setVisibility(8);
        this.mMuitipleBtn.setVisibility(0);
        BNDrivingToolManager.getInstance().isSinglePerson = true;
        BNDrivingToolManager.getInstance().mRouteID = "0";
    }

    public void updateTaskSpinnerView() {
        int index = -1;
        try {
            index = BNDrivingToolManager.getInstance().getLastSelectedTaskIndex();
            if (this.mTaskListSp != null) {
                this.mTaskListSp.setSelection(index);
            }
        } catch (Exception e) {
        }
        LogUtil.m15791e(BNDrivingToolManager.MODULENAME, "getSelectedTaskIndex index is " + index);
    }

    private void synUrlHostOneMoudlue(DebugModeMessageSerBean serBean) {
        if (serBean.key.equals(ULRParam.URL_UGC_OPER_INFO_REPORT)) {
            if (serBean.flag) {
                String hostStr = getUrlHost(serBean.value);
                String noHostStr = getUrlWithNoHost(HttpURLManager.getInstance().getOnlineUrl(ULRParam.URL_UGC_EVENT_FEEDBACK));
                if (hostStr != null) {
                    if (noHostStr != null) {
                        HttpURLManager.getInstance().putUrl(ULRParam.URL_UGC_EVENT_FEEDBACK, hostStr + "/" + noHostStr);
                    }
                    noHostStr = getUrlWithNoHost(HttpURLManager.getInstance().getOnlineUrl(ULRParam.URL_UGC_RCEVENT_COUNTS));
                    if (noHostStr != null) {
                        HttpURLManager.getInstance().putUrl(ULRParam.URL_UGC_RCEVENT_COUNTS, hostStr + "/" + noHostStr);
                    }
                    noHostStr = getUrlWithNoHost(HttpURLManager.getInstance().getOnlineUrl(ULRParam.URL_UGC_GET_EVENT_DETAIL));
                    if (noHostStr != null) {
                        HttpURLManager.getInstance().putUrl(ULRParam.URL_UGC_GET_EVENT_DETAIL, hostStr + "/" + noHostStr);
                        return;
                    }
                    return;
                }
                return;
            }
            HttpURLManager.getInstance().putUrl(ULRParam.URL_UGC_EVENT_FEEDBACK, HttpURLManager.getInstance().getOnlineUrl(ULRParam.URL_UGC_EVENT_FEEDBACK));
            HttpURLManager.getInstance().putUrl(ULRParam.URL_UGC_RCEVENT_COUNTS, HttpURLManager.getInstance().getOnlineUrl(ULRParam.URL_UGC_RCEVENT_COUNTS));
            HttpURLManager.getInstance().putUrl(ULRParam.URL_UGC_GET_EVENT_DETAIL, HttpURLManager.getInstance().getOnlineUrl(ULRParam.URL_UGC_GET_EVENT_DETAIL));
        } else if (serBean.key.equals(ULRParam.URL_INIT_CLOUD_CONFIG)) {
            BNSettingManager.setInitCloudCfg(serBean.flag);
        }
    }

    private String getUrlHost(String url) {
        int index = getSpeIndexFromUrl(url);
        if (index >= 0 && url != null && url.length() > index + 1) {
            return url.substring(0, index);
        }
        return null;
    }

    private String getUrlWithNoHost(String url) {
        int index = getSpeIndexFromUrl(url);
        if (index >= 0 && url != null && url.length() > index + 1) {
            return url.substring(index + 1);
        }
        return null;
    }

    private int getSpeIndexFromUrl(String url) {
        if (TextUtils.isEmpty(url)) {
            return -1;
        }
        String str;
        int indexAdd = 0;
        if (url.startsWith("http://") && url.length() > "http://".length()) {
            str = url.substring("http://".length());
            indexAdd = "http://".length();
        } else if (!url.startsWith("https://") || url.length() <= "https://".length()) {
            str = url;
        } else {
            str = url.substring("https://".length());
            indexAdd = "https://".length();
        }
        return str.indexOf("/") + indexAdd;
    }
}
