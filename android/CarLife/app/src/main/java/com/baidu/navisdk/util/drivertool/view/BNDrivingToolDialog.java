package com.baidu.navisdk.util.drivertool.view;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.res.Resources.Theme;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.TextView;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.NetworkUtils;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.common.SystemAuth;
import com.baidu.navisdk.util.drivertool.BNDrivingToolManager;
import com.baidu.navisdk.util.drivertool.BNDrivingToolUtils;
import com.baidu.navisdk.util.drivertool.BNScreentShotManager;
import com.baidu.navisdk.util.drivertool.BNTakePhotoManager;
import com.baidu.navisdk.util.drivertool.BNVideoRecordManager;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.navisdk.util.worker.BNWorkerCenter;
import com.baidu.navisdk.util.worker.BNWorkerConfig;
import com.baidu.navisdk.util.worker.BNWorkerNormalTask;

public class BNDrivingToolDialog extends Dialog {
    public static final int UPDATE_ROUTE_MSG = 100;
    private String[] mDrivingTestNames = null;
    private Handler mHandler = new C46741();
    private Button mIssueListBtn;
    private Button mNewIssueBtn;
    private TextView mRouteSp;
    private Button mScreenShotBtn;
    private Button mSettingBtn;
    private Button mShortVideoBtn;
    private Button mTakePhotoBtn;

    /* renamed from: com.baidu.navisdk.util.drivertool.view.BNDrivingToolDialog$1 */
    class C46741 extends Handler {
        C46741() {
        }

        public void handleMessage(Message msg) {
            if (msg.what == 100 && BNDrivingToolDialog.this.mRouteSp != null) {
                if (BNDrivingToolManager.getInstance().isSinglePerson) {
                    BNDrivingToolDialog.this.mRouteSp.setText(BNStyleManager.getString(C4048R.string.nsdk_string_driving_tool_single_route));
                    return;
                }
                BNDrivingToolDialog.this.mRouteSp.setVisibility(0);
                BNDrivingToolDialog.this.mRouteSp.setText(BNDrivingToolManager.getInstance().mRouteName);
            }
        }
    }

    /* renamed from: com.baidu.navisdk.util.drivertool.view.BNDrivingToolDialog$2 */
    class C46752 implements OnClickListener {
        C46752() {
        }

        public void onClick(View v) {
            if (SystemAuth.checkAuth(SystemAuth.PHOTO_CAPTURE_AUTH, true, SystemAuth.PHOTO_CAPTURE_MSG)) {
                BNDrivingToolManager.getInstance().dismissDrvingToolDialog();
                BNDrivingToolManager.getInstance().setDrivingToolIconVisibility(true);
                long time = System.currentTimeMillis();
                BNDrivingToolManager.getInstance().getIssueInfo().mIssueTime = String.valueOf(time);
                BNDrivingToolManager.getInstance().getIssueInfo().mBduss = BNaviModuleManager.getBduss();
                BNDrivingToolManager.getInstance().getIssueInfo().mStoreType = String.valueOf(2);
                BNDrivingToolManager.getInstance().getIssueInfo().mIssueLocation = BNDrivingToolUtils.getCarPointString();
                BNDrivingToolManager.getInstance().getIssueInfo().mSessionID = BNRoutePlaner.getInstance().getRoutePlanSessionIDAndMrsl("", "");
                BNTakePhotoManager.getInstance().takePhoto();
                return;
            }
            TipTool.onCreateToastDialog(BNaviModuleManager.getNaviActivity(), SystemAuth.PHOTO_CAPTURE_MSG);
        }
    }

    /* renamed from: com.baidu.navisdk.util.drivertool.view.BNDrivingToolDialog$3 */
    class C46773 implements OnClickListener {
        C46773() {
        }

        public void onClick(View v) {
            if (BNScreentShotManager.sIsInThread) {
                TipTool.onCreateToastDialog(BNaviModuleManager.getNaviActivity(), BNScreentShotManager.SCREEN_IN_HANDLE);
                return;
            }
            BNDrivingToolManager.getInstance().dismissDrvingToolDialog();
            BNDrivingToolManager.getInstance().setDrivingToolIconVisibility(false);
            long time = System.currentTimeMillis();
            BNDrivingToolManager.getInstance().getIssueInfo().mIssueTime = String.valueOf(time);
            BNDrivingToolManager.getInstance().getIssueInfo().mStoreType = String.valueOf(3);
            BNDrivingToolManager.getInstance().getIssueInfo().mBduss = BNaviModuleManager.getBduss();
            BNDrivingToolManager.getInstance().getIssueInfo().mIssueLocation = BNDrivingToolUtils.getCarPointString();
            BNDrivingToolManager.getInstance().getIssueInfo().mSessionID = BNRoutePlaner.getInstance().getRoutePlanSessionIDAndMrsl("", "");
            final BNScreentShotManager screenShotMng = BNScreentShotManager.getInstance();
            if (BNDrivingToolUtils.isMobileRoot() && BNSettingManager.isRootScreenshotPermitted()) {
                BNWorkerCenter.getInstance().submitMainThreadTask(new BNWorkerNormalTask<String, String>("notifyDayNightObservers-" + getClass().getSimpleName(), null) {
                    protected String execute() {
                        screenShotMng.rootScreenShot();
                        return null;
                    }
                }, new BNWorkerConfig(2, 0));
                return;
            }
            screenShotMng.initParams();
            try {
                if (BNDrivingToolUtils.sCanShow && BNDrivingToolUtils.sMapRenderShow) {
                    BNScreentShotManager.getInstance().captureSurfaceView(0, 0, 1);
                }
            } catch (Exception e) {
                BNDrivingToolUtils.setSurfaceViewState(false);
                e.printStackTrace();
            }
        }
    }

    /* renamed from: com.baidu.navisdk.util.drivertool.view.BNDrivingToolDialog$4 */
    class C46784 implements OnClickListener {
        C46784() {
        }

        public void onClick(View v) {
            if (BNVideoRecordManager.getInstance().hasRecordAuth()) {
                BNDrivingToolManager.getInstance().dismissDrvingToolDialog();
                BNDrivingToolManager.getInstance().setDrivingToolIconVisibility(false);
                long time = System.currentTimeMillis();
                BNDrivingToolManager.getInstance().getIssueInfo().mIssueTime = String.valueOf(time);
                BNDrivingToolManager.getInstance().getIssueInfo().mBduss = BNaviModuleManager.getBduss();
                BNDrivingToolManager.getInstance().getIssueInfo().mIssueLocation = BNDrivingToolUtils.getCarPointString();
                BNDrivingToolManager.getInstance().getIssueInfo().mSessionID = BNRoutePlaner.getInstance().getRoutePlanSessionIDAndMrsl("", "");
                BNVideoRecordManager.getInstance().recordVideo();
                return;
            }
            TipTool.onCreateToastDialog(BNaviModuleManager.getContext(), BNVideoRecordManager.NO_RECORD_AUTH_MSG);
        }
    }

    /* renamed from: com.baidu.navisdk.util.drivertool.view.BNDrivingToolDialog$5 */
    class C46805 implements OnClickListener {

        /* renamed from: com.baidu.navisdk.util.drivertool.view.BNDrivingToolDialog$5$1 */
        class C46791 implements OnCancelListener {
            C46791() {
            }

            public void onCancel(DialogInterface dialog) {
                BNDrivingToolManager.getInstance().setDrivingToolIconVisibility(true);
            }
        }

        C46805() {
        }

        public void onClick(View v) {
            BNDrivingToolManager.getInstance().dismissDrvingToolDialog();
            BNDrivingToolManager.getInstance().setDrivingToolIconVisibility(false);
            Context ctx = BNaviModuleManager.getNaviActivity();
            if (ctx != null) {
                BNDrivingToolSettingDialog settingDialog = new BNDrivingToolSettingDialog(ctx);
                settingDialog.setOnCancelListener(new C46791());
                settingDialog.show();
            }
        }
    }

    /* renamed from: com.baidu.navisdk.util.drivertool.view.BNDrivingToolDialog$6 */
    class C46826 implements OnClickListener {

        /* renamed from: com.baidu.navisdk.util.drivertool.view.BNDrivingToolDialog$6$1 */
        class C46811 implements OnCancelListener {
            C46811() {
            }

            public void onCancel(DialogInterface dialog) {
                BNDrivingToolManager.getInstance().setDrivingToolIconVisibility(true);
            }
        }

        C46826() {
        }

        public void onClick(View v) {
            BNDrivingToolManager.getInstance().dismissDrvingToolDialog();
            BNDrivingToolManager.getInstance().getIssueInfo().mBduss = BNaviModuleManager.getBduss();
            BNDrivingToolManager.getInstance().getIssueInfo().mSessionID = BNRoutePlaner.getInstance().getRoutePlanSessionIDAndMrsl("", "");
            BNDrivingToolIssueStoreDialog mIssueDialog = BNDrivingToolManager.getInstance().getIssueStoreDialog(4);
            mIssueDialog.setOnCancelListener(new C46811());
            mIssueDialog.show();
        }
    }

    /* renamed from: com.baidu.navisdk.util.drivertool.view.BNDrivingToolDialog$7 */
    class C46847 implements OnClickListener {
        C46847() {
        }

        public void onClick(View v) {
            if (NetworkUtils.isNetworkAvailable(BNaviModuleManager.getContext())) {
                final BNIssueViewDialog viewDialog = new BNIssueViewDialog(BNaviModuleManager.getNaviActivity(), 16973833);
                viewDialog.show();
                viewDialog.setOnCancelListener(new OnCancelListener() {
                    public void onCancel(DialogInterface dialog) {
                        viewDialog.releaseResource();
                    }
                });
                return;
            }
            TipTool.onCreateToastDialog(BNaviModuleManager.getContext(), JarUtils.getResources().getString(C4048R.string.nsdk_string_cruise_no_network));
        }
    }

    public BNDrivingToolDialog(Context context) {
        super(context);
        Theme theme = JarUtils.getResources().newTheme();
        theme.applyStyle(C4048R.style.BNDialog, true);
        JarUtils.setDialogThemeField(this, theme);
        View view = JarUtils.inflate((Activity) context, C4048R.layout.nsdk_layout_driving_tool, null);
        setContentView(view);
        this.mRouteSp = (TextView) view.findViewById(C4048R.id.dt_name_sp);
        this.mTakePhotoBtn = (Button) view.findViewById(C4048R.id.take_picture_btn);
        this.mScreenShotBtn = (Button) view.findViewById(C4048R.id.screen_shot_btn);
        this.mShortVideoBtn = (Button) view.findViewById(C4048R.id.short_video_btn);
        this.mSettingBtn = (Button) view.findViewById(C4048R.id.setting_btn);
        this.mNewIssueBtn = (Button) view.findViewById(C4048R.id.new_issue_btn);
        this.mIssueListBtn = (Button) view.findViewById(C4048R.id.issue_view_btn);
        if (this.mIssueListBtn != null) {
            this.mIssueListBtn.setVisibility(BNaviModuleManager.isGooglePlayChannel() ? 8 : 0);
        }
        Window window = getWindow();
        LayoutParams lp = window.getAttributes();
        lp.width = (ScreenUtil.getInstance().getWidthPixels() / 8) * 5;
        lp.height = (ScreenUtil.getInstance().getHeightPixels() / 9) * 4;
        window.setAttributes(lp);
        window.setGravity(17);
        initData();
        initListener();
    }

    private void initListener() {
        if (this.mTakePhotoBtn != null) {
            this.mTakePhotoBtn.setOnClickListener(new C46752());
        }
        if (this.mScreenShotBtn != null) {
            this.mScreenShotBtn.setOnClickListener(new C46773());
        }
        if (this.mShortVideoBtn != null) {
            this.mShortVideoBtn.setOnClickListener(new C46784());
        }
        if (this.mSettingBtn != null) {
            this.mSettingBtn.setOnClickListener(new C46805());
        }
        if (this.mNewIssueBtn != null) {
            this.mNewIssueBtn.setOnClickListener(new C46826());
        }
        if (this.mIssueListBtn != null) {
            this.mIssueListBtn.setOnClickListener(new C46847());
        }
    }

    private void pullDrivingTestNames() {
        this.mDrivingTestNames = new String[]{"hello, 我是一个路测"};
    }

    private void initData() {
        pullDrivingTestNames();
        this.mHandler.sendEmptyMessage(100);
    }
}
