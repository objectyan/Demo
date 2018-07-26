package com.baidu.navisdk.util.drivertool.view;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources.Theme;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.ui.util.ForbidDaulClickUtils;
import com.baidu.navisdk.util.common.FileUtils;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.drivertool.BNAttachmentManager;
import com.baidu.navisdk.util.drivertool.BNDrivingToolManager;
import com.baidu.navisdk.util.drivertool.BNDrivingToolParams;
import com.baidu.navisdk.util.drivertool.BNScreentShotManager;
import com.baidu.navisdk.util.drivertool.model.DrivingToolIssueInfo;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.navisdk.util.worker.BNWorkerCenter;
import com.baidu.navisdk.util.worker.BNWorkerConfig;
import com.baidu.navisdk.util.worker.BNWorkerNormalTask;
import java.io.IOException;
import java.util.List;

public class BNDrivingToolIssueStoreDialog extends Dialog {
    private Button mAddAttachBtn;
    private LinearLayout mAddAttachLl;
    private Button mCancelBtn;
    private Button mCreateIssueBtn;
    private EditText mIssueDespEt;
    private Spinner mIssueIDSp;
    private Spinner mIssueStateSp;
    private Spinner mIssueTypeSp;
    private Spinner mResponsiblePmSp;
    private TextView mSelectPicTx;
    private Button mStoreBtn;
    private int mType;

    /* renamed from: com.baidu.navisdk.util.drivertool.view.BNDrivingToolIssueStoreDialog$1 */
    class C46851 implements OnClickListener {
        C46851() {
        }

        public void onClick(View v) {
            if (!ForbidDaulClickUtils.isFastDoubleClick(1500)) {
                BNDrivingToolManager.getInstance().mIssueFlag = "1";
                BNDrivingToolManager.getInstance().asynPullIssueList();
            }
        }
    }

    /* renamed from: com.baidu.navisdk.util.drivertool.view.BNDrivingToolIssueStoreDialog$2 */
    class C46862 implements OnItemSelectedListener {
        C46862() {
        }

        public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
            DrivingToolIssueInfo issueInfo = BNDrivingToolManager.getInstance().getIssueInfo();
            List<String> issueList = BNDrivingToolManager.getInstance().mIssueList;
            if (issueList != null) {
                issueInfo.mIssueID = ((String) issueList.get(position)).trim();
                if (BNDrivingToolManager.getInstance().isIssueNewCreate(issueInfo.mIssueID)) {
                    BNDrivingToolIssueStoreDialog.this.setStoreViewEnable(true);
                } else {
                    BNDrivingToolIssueStoreDialog.this.setStoreViewEnable(false);
                }
                if (BNDrivingToolParams.DEFAULT_SPINNER_DATA.equals(issueInfo.mIssueID)) {
                    BNDrivingToolManager.getInstance().isIssueRet = false;
                } else if (!BNDrivingToolManager.getInstance().isNoDrivingTest) {
                    BNDrivingToolManager.getInstance().isIssueRet = true;
                } else if (BNAttachmentManager.getInstance().mFilePathList.size() <= 0) {
                    BNDrivingToolManager.getInstance().isIssueRet = false;
                } else {
                    BNDrivingToolManager.getInstance().isIssueRet = true;
                }
                if (BNDrivingToolManager.getInstance().isIssueRet) {
                    BNDrivingToolIssueStoreDialog.this.setStoreBtnState(true);
                } else {
                    BNDrivingToolIssueStoreDialog.this.setStoreBtnState(false);
                }
            }
        }

        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    /* renamed from: com.baidu.navisdk.util.drivertool.view.BNDrivingToolIssueStoreDialog$3 */
    class C46873 implements OnItemSelectedListener {
        C46873() {
        }

        public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
            DrivingToolIssueInfo issueInfo = BNDrivingToolManager.getInstance().getIssueInfo();
            if (BNDrivingToolParams.ISSUE_TYPES[position].equals(BNDrivingToolParams.DEFAULT_SPINNER_DATA)) {
                issueInfo.mIssueType = null;
                return;
            }
            issueInfo.mIssueType = String.valueOf(position - 1);
            BNDrivingToolManager.getInstance().updateReliableList(position - 1);
        }

        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    /* renamed from: com.baidu.navisdk.util.drivertool.view.BNDrivingToolIssueStoreDialog$4 */
    class C46884 implements OnItemSelectedListener {
        C46884() {
        }

        public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
            DrivingToolIssueInfo issueInfo = BNDrivingToolManager.getInstance().getIssueInfo();
            List<String> reliableList = BNDrivingToolManager.getInstance().mReliablePersonList;
            if (reliableList != null && reliableList.size() > 0) {
                String reliablePerson = (String) reliableList.get(position);
                if (reliablePerson == null || !reliablePerson.equals(BNDrivingToolParams.DEFAULT_SPINNER_DATA)) {
                    issueInfo.mPersonReliableID = (String) BNDrivingToolManager.getInstance().mReliablePersonMap.get(reliablePerson);
                } else {
                    issueInfo.mPersonReliableID = null;
                }
            }
        }

        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    /* renamed from: com.baidu.navisdk.util.drivertool.view.BNDrivingToolIssueStoreDialog$5 */
    class C46895 implements OnItemSelectedListener {
        C46895() {
        }

        public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
            DrivingToolIssueInfo issueInfo = BNDrivingToolManager.getInstance().getIssueInfo();
            if (BNDrivingToolParams.ISSUE_STATUS[position].equals(BNDrivingToolParams.DEFAULT_SPINNER_DATA)) {
                issueInfo.mIssueStatus = null;
            } else {
                issueInfo.mIssueStatus = String.valueOf(position - 1);
            }
        }

        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    /* renamed from: com.baidu.navisdk.util.drivertool.view.BNDrivingToolIssueStoreDialog$6 */
    class C46906 implements OnClickListener {
        C46906() {
        }

        public void onClick(View v) {
            BNAttachmentManager.getInstance().startSelectPicture();
        }
    }

    /* renamed from: com.baidu.navisdk.util.drivertool.view.BNDrivingToolIssueStoreDialog$7 */
    class C46937 implements OnClickListener {
        C46937() {
        }

        public void onClick(View v) {
            BNWorkerCenter.getInstance().submitNormalTask(new BNWorkerNormalTask<String, String>(getClass().getSimpleName(), null) {
                protected String execute() {
                    boolean isOld = true;
                    if (BNDrivingToolIssueStoreDialog.this.mType == 3) {
                        BNScreentShotManager.sIsInThread = true;
                        BNScreentShotManager.getInstance().handleSave();
                    }
                    BNDrivingToolManager.getInstance().getIssueInfo().mIssueDescrption = BNDrivingToolIssueStoreDialog.this.mIssueDespEt.getText().toString().trim();
                    if (BNDrivingToolIssueStoreDialog.this.mResponsiblePmSp.isEnabled()) {
                        isOld = false;
                    }
                    if (isOld) {
                        DrivingToolIssueInfo info = BNDrivingToolManager.getInstance().getIssueInfo();
                        info.mIssueType = null;
                        info.mPersonReliableID = null;
                        info.mIssueStatus = null;
                    }
                    if (BNDrivingToolIssueStoreDialog.this.mType == 4) {
                        BNAttachmentManager.getInstance().storeAttachmentIndex(BNDrivingToolIssueStoreDialog.this.mType);
                    } else {
                        BNDrivingToolManager.getInstance().storeIndexFile(BNDrivingToolIssueStoreDialog.this.mType);
                    }
                    BNDrivingToolManager.getInstance().clearIssueInfo();
                    BNAttachmentManager.getInstance().mFilePathList.clear();
                    if (BNScreentShotManager.getInstance().mCachePath != null) {
                        try {
                            FileUtils.del(BNScreentShotManager.getInstance().mCachePath);
                        } catch (IOException e) {
                        }
                    }
                    if (BNDrivingToolIssueStoreDialog.this.mType == 3) {
                        BNScreentShotManager.sIsInThread = false;
                    } else {
                        BNWorkerCenter.getInstance().submitMainThreadTask(new BNWorkerNormalTask<String, String>("InitListener-" + getClass().getSimpleName(), null) {
                            protected String execute() {
                                BNDrivingToolIssueStoreDialog.this.dismiss();
                                BNDrivingToolManager.getInstance().setDrivingToolIconVisibility(true);
                                BNDrivingToolIssueStoreDialog.this.setStoreBtnState(false);
                                return null;
                            }
                        }, new BNWorkerConfig(100, 0));
                    }
                    return null;
                }
            }, new BNWorkerConfig(100, 0));
            if (BNDrivingToolIssueStoreDialog.this.mType == 3) {
                BNDrivingToolIssueStoreDialog.this.dismiss();
                BNDrivingToolManager.getInstance().setDrivingToolIconVisibility(true);
                BNDrivingToolIssueStoreDialog.this.setStoreBtnState(false);
            }
        }
    }

    /* renamed from: com.baidu.navisdk.util.drivertool.view.BNDrivingToolIssueStoreDialog$8 */
    class C46948 implements OnClickListener {
        C46948() {
        }

        public void onClick(View v) {
            BNDrivingToolIssueStoreDialog.this.dismiss();
        }
    }

    public BNDrivingToolIssueStoreDialog(Context ctx, int type) {
        super(ctx);
        this.mType = type;
        Theme theme = JarUtils.getResources().newTheme();
        theme.applyStyle(C4048R.style.BNDialog, true);
        JarUtils.setDialogThemeField(this, theme);
        View view = JarUtils.oldInflate((Activity) ctx, C4048R.layout.nsdk_layout_driving_tool_issue_store, null);
        setContentView(view);
        this.mIssueIDSp = (Spinner) view.findViewById(C4048R.id.issue_id_sp);
        this.mIssueDespEt = (EditText) view.findViewById(C4048R.id.issue_desp_et);
        this.mIssueTypeSp = (Spinner) view.findViewById(C4048R.id.issue_type_sp);
        this.mResponsiblePmSp = (Spinner) view.findViewById(C4048R.id.responsible_pm_sp);
        this.mIssueStateSp = (Spinner) view.findViewById(C4048R.id.current_state_sp);
        this.mCreateIssueBtn = (Button) view.findViewById(C4048R.id.create_issue_btn);
        this.mStoreBtn = (Button) view.findViewById(C4048R.id.store_btn);
        this.mAddAttachBtn = (Button) view.findViewById(C4048R.id.add_attch_btn);
        this.mSelectPicTx = (TextView) view.findViewById(C4048R.id.select_picture_tx);
        this.mCancelBtn = (Button) view.findViewById(C4048R.id.cancel_btn);
        this.mAddAttachLl = (LinearLayout) view.findViewById(C4048R.id.add_attach_ll);
        if (this.mType != 4) {
            this.mAddAttachLl.setVisibility(8);
        }
        Window window = getWindow();
        LayoutParams lp = window.getAttributes();
        lp.width = (ScreenUtil.getInstance().getWidthPixels() / 34) * 31;
        if (type == 4) {
            lp.height = (ScreenUtil.getInstance().getHeightPixels() / 45) * 27;
        } else {
            lp.height = (ScreenUtil.getInstance().getHeightPixels() / 40) * 21;
        }
        lp.gravity = 17;
        window.setAttributes(lp);
        window.setGravity(17);
        setStoreBtnState(false);
        initListener();
        initData();
    }

    public void updateAttachNumber(int type) {
        this.mSelectPicTx.setText("图片数：" + String.valueOf(type));
    }

    public void updateIssueListView() {
        if (this.mIssueIDSp != null) {
            List<String> issueList = BNDrivingToolManager.getInstance().mIssueList;
            if (issueList != null) {
                ArrayAdapter<String> adapter = new ArrayAdapter(BNaviModuleManager.getNaviActivity(), 17367048, issueList);
                adapter.setDropDownViewResource(17367049);
                this.mIssueIDSp.setAdapter(adapter);
                if (BNDrivingToolManager.getInstance().mIssueList != null && BNDrivingToolManager.getInstance().mIssueList.size() > 0 && BNDrivingToolManager.getInstance().mIssueFlag.equals("1")) {
                    int position = BNDrivingToolManager.getInstance().mIssueList.size() - 1;
                    this.mIssueIDSp.setSelection(position, true);
                    LogUtil.m15791e(BNDrivingToolManager.MODULENAME, "set new create issue selcetion " + ((String) BNDrivingToolManager.getInstance().mIssueList.get(position)));
                }
            }
        }
    }

    public void setStoreViewEnable(boolean enable) {
        if (this.mIssueTypeSp != null) {
            this.mIssueTypeSp.setEnabled(enable);
        }
        if (this.mIssueStateSp != null) {
            this.mIssueStateSp.setEnabled(enable);
        }
        if (this.mResponsiblePmSp != null) {
            this.mResponsiblePmSp.setEnabled(enable);
        }
    }

    public void updateReliablePersonView() {
        if (this.mResponsiblePmSp != null) {
            List<String> reliablePersonList = BNDrivingToolManager.getInstance().mReliablePersonList;
            if (reliablePersonList != null) {
                Context ctx = BNaviModuleManager.getNaviActivity();
                if (ctx != null) {
                    ArrayAdapter<String> adapter = new ArrayAdapter(ctx, 17367048, reliablePersonList);
                    adapter.setDropDownViewResource(17367049);
                    this.mResponsiblePmSp.setAdapter(adapter);
                }
            }
        }
    }

    private void initData() {
        if ("0".equals(BNDrivingToolManager.getInstance().mRouteFlag)) {
            BNDrivingToolManager.getInstance().mIssueFlag = "0";
        } else {
            BNDrivingToolManager.getInstance().mIssueFlag = "0";
            BNDrivingToolManager.getInstance().mRouteFlag = "0";
        }
        if (this.mType == 4) {
            BNDrivingToolManager.getInstance().mIssueFlag = "1";
        }
        BNDrivingToolManager.getInstance().asynPullIssueList();
        BNDrivingToolManager.getInstance().asynPullReliablePerson();
        String timeStr = BNDrivingToolManager.getInstance().getIssueInfo().mIssueTime;
        if (timeStr == null || timeStr.length() == 0) {
            timeStr = String.valueOf(System.currentTimeMillis());
        }
        Context ctx = BNaviModuleManager.getNaviActivity();
        if (ctx != null) {
            ArrayAdapter<String> adapter;
            if (this.mIssueTypeSp != null) {
                adapter = new ArrayAdapter(ctx, 17367048, BNDrivingToolParams.ISSUE_TYPES);
                adapter.setDropDownViewResource(17367049);
                this.mIssueTypeSp.setAdapter(adapter);
            }
            if (this.mIssueStateSp != null) {
                adapter = new ArrayAdapter(ctx, 17367048, BNDrivingToolParams.ISSUE_STATUS);
                adapter.setDropDownViewResource(17367049);
                this.mIssueStateSp.setAdapter(adapter);
            }
        }
    }

    private void initListener() {
        if (this.mCreateIssueBtn != null) {
            this.mCreateIssueBtn.setOnClickListener(new C46851());
        }
        if (this.mIssueIDSp != null) {
            this.mIssueIDSp.setOnItemSelectedListener(new C46862());
        }
        if (this.mIssueDespEt != null) {
            BNDrivingToolManager.getInstance().getIssueInfo().mIssueDescrption = this.mIssueDespEt.getText().toString().trim();
        }
        if (this.mIssueTypeSp != null) {
            this.mIssueTypeSp.setOnItemSelectedListener(new C46873());
        }
        if (this.mResponsiblePmSp != null) {
            this.mResponsiblePmSp.setOnItemSelectedListener(new C46884());
        }
        if (this.mIssueStateSp != null) {
            this.mIssueStateSp.setOnItemSelectedListener(new C46895());
        }
        if (this.mAddAttachBtn != null) {
            this.mAddAttachBtn.setOnClickListener(new C46906());
        }
        if (this.mStoreBtn != null) {
            this.mStoreBtn.setOnClickListener(new C46937());
        }
        if (this.mCancelBtn != null) {
            this.mCancelBtn.setOnClickListener(new C46948());
        }
    }

    public void setStoreBtnState(boolean state) {
        if (this.mStoreBtn != null) {
            if (state) {
                this.mStoreBtn.setBackgroundColor(-16711936);
            } else {
                this.mStoreBtn.setBackgroundColor(-7829368);
            }
            this.mStoreBtn.setClickable(state);
        }
    }

    public void updateNewIssueDefaultAction() {
        if (this.mIssueStateSp != null) {
            this.mIssueStateSp.setSelection(1);
        }
    }
}
