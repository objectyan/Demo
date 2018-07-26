package com.baidu.navisdk.ui.widget;

import android.app.Activity;
import android.app.Dialog;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnShowListener;
import android.content.res.Resources.Theme;
import android.os.Build.VERSION;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.debug.BNEyeSpyPaperController;
import com.baidu.navisdk.debug.BNEyeSpyPaperModel;
import com.baidu.navisdk.ui.routeguide.BNavigator;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.TimerUtil;
import com.baidu.navisdk.util.common.TimerUtil.TimerCallBack;
import com.baidu.navisdk.util.jar.JarUtils;

public class BNUserKeyLogDialog extends Dialog implements OnClickListener, TimerCallBack {
    private static final String TAG = "BNUserKeyLogDialog";
    private ImageView mAddTestPlanCb;
    private View mCancleView;
    private EditText mDespEText;
    private View mIssueIdCopyBtn;
    private TextView mIssueIdTv;
    private ImageView mLogSwitchCb;
    private BNEyeSpyPaperModel mModel = null;
    private TimerUtil mTimerUtil = null;
    private Button mUploadBtn;

    /* renamed from: com.baidu.navisdk.ui.widget.BNUserKeyLogDialog$1 */
    class C45941 implements OnShowListener {
        C45941() {
        }

        public void onShow(DialogInterface dialog) {
            BNUserKeyLogDialog.this.mTimerUtil.start(10);
        }
    }

    /* renamed from: com.baidu.navisdk.ui.widget.BNUserKeyLogDialog$2 */
    class C45952 implements OnDismissListener {
        C45952() {
        }

        public void onDismiss(DialogInterface dialog) {
            BNEyeSpyPaperController.getInstance().onUserKeyLogDialogDismiss();
            BNUserKeyLogDialog.this.mTimerUtil.cancle();
        }
    }

    public BNUserKeyLogDialog(Context context) {
        super(context);
        Theme theme = JarUtils.getResources().newTheme();
        theme.applyStyle(C4048R.style.BNDialog, true);
        JarUtils.setDialogThemeField(this, theme);
        View view = JarUtils.inflate((Activity) context, C4048R.layout.nsdk_layout_user_key_log, null);
        setContentView(view);
        this.mCancleView = view.findViewById(C4048R.id.eye_spy_paper_cancle);
        this.mUploadBtn = (Button) view.findViewById(C4048R.id.eye_spy_paper_upload);
        this.mLogSwitchCb = (ImageView) view.findViewById(C4048R.id.eye_spy_paper_open_normal_log_checkbox);
        this.mAddTestPlanCb = (ImageView) view.findViewById(C4048R.id.eye_spy_paper_add_to_testplan_checkbox);
        this.mDespEText = (EditText) view.findViewById(C4048R.id.eye_spy_paper_desp_et);
        this.mIssueIdTv = (TextView) view.findViewById(C4048R.id.eye_spy_paper_issue_id);
        this.mIssueIdCopyBtn = view.findViewById(C4048R.id.eye_spy_paper_issue_id_copy);
        this.mModel = BNEyeSpyPaperController.getInstance().getModel();
        initListener();
        initCheckBox();
    }

    private void initListener() {
        this.mTimerUtil = new TimerUtil();
        this.mTimerUtil.addCallback(this);
        this.mLogSwitchCb.setOnClickListener(this);
        this.mAddTestPlanCb.setOnClickListener(this);
        this.mUploadBtn.setOnClickListener(this);
        this.mCancleView.setOnClickListener(this);
        this.mIssueIdCopyBtn.setOnClickListener(this);
        this.mDespEText.setOnClickListener(this);
        setOnShowListener(new C45941());
        setOnDismissListener(new C45952());
    }

    public void onTick(int count) {
        if (count == 0) {
            dismiss();
        } else if (this.mUploadBtn != null) {
            this.mUploadBtn.setText("上报(" + count + "s)");
        }
    }

    private void initCheckBox() {
        this.mModel.addToTestPlaner();
        updateAddTestPlanCheckBox(this.mModel.isInTestPlaner());
        updateLogSwitchCheckBox(LogUtil.LOGWRITE);
        this.mIssueIdTv.setText(this.mModel.generateProblemId());
    }

    public void onClick(View v) {
        this.mTimerUtil.cancle();
        if (this.mUploadBtn != null) {
            this.mUploadBtn.setText("上报");
        }
        switch (v.getId()) {
            case C4048R.id.eye_spy_paper_issue_id_copy /*1711867251*/:
                if (VERSION.SDK_INT >= 11) {
                    ((ClipboardManager) v.getContext().getSystemService("clipboard")).setText(this.mIssueIdTv.getText());
                    TipTool.onCreateToastDialog(v.getContext(), "复制成功");
                    return;
                }
                return;
            case C4048R.id.eye_spy_paper_open_normal_log_checkbox /*1711867271*/:
                if (LogUtil.LOGWRITE) {
                    LogUtil.LOGWRITE = false;
                } else {
                    TipTool.onCreateToastDialog(BNaviModuleManager.getContext(), "普通日志开关已打开,请复现问题后点击右侧按钮上传日志");
                    LogUtil.LOGWRITE = true;
                }
                updateLogSwitchCheckBox(LogUtil.LOGWRITE);
                return;
            case C4048R.id.eye_spy_paper_add_to_testplan_checkbox /*1711867273*/:
                if (this.mModel.isInTestPlaner()) {
                    BNEyeSpyPaperController.getInstance().addToTestPlaner(false);
                } else {
                    BNEyeSpyPaperController.getInstance().addToTestPlaner(true);
                }
                updateAddTestPlanCheckBox(this.mModel.isInTestPlaner());
                return;
            case C4048R.id.eye_spy_paper_cancle /*1711867274*/:
                dismiss();
                return;
            case C4048R.id.eye_spy_paper_upload /*1711867275*/:
                this.mModel.mDespText = this.mDespEText.getText().toString();
                if (BNavigator.getInstance().isNaviBegin()) {
                    this.mModel.mUploadSource = 2;
                } else {
                    this.mModel.mUploadSource = 1;
                }
                BNEyeSpyPaperController.getInstance().uploadLog();
                dismiss();
                return;
            default:
                return;
        }
    }

    public void updateLogSwitchCheckBox(boolean opened) {
        if (opened) {
            try {
                this.mLogSwitchCb.setImageDrawable(JarUtils.getResources().getDrawable(C4048R.drawable.nsdk_set_checkin_icon));
                return;
            } catch (Exception e) {
                LogUtil.m15791e(TAG, "Exception updateLogCheckBoxDrawable:" + e.getMessage());
                return;
            }
        }
        this.mLogSwitchCb.setImageDrawable(JarUtils.getResources().getDrawable(C4048R.drawable.nsdk_set_checkout_icon));
    }

    public void updateAddTestPlanCheckBox(boolean opened) {
        if (opened) {
            this.mAddTestPlanCb.setImageDrawable(JarUtils.getResources().getDrawable(C4048R.drawable.nsdk_set_checkout_icon));
            return;
        }
        try {
            this.mAddTestPlanCb.setImageDrawable(JarUtils.getResources().getDrawable(C4048R.drawable.nsdk_set_checkin_icon));
        } catch (Exception e) {
            LogUtil.m15791e(TAG, "Exception updateLogCheckBoxDrawable:" + e.getMessage());
        }
    }
}
