package com.baidu.navisdk.module.routereport;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.text.Selection;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.che.codriver.platform.NaviCmdConstants;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.model.datastruct.LocData;
import com.baidu.navisdk.module.routereport.BNRouteReportModel.RouteReportItem;
import com.baidu.navisdk.module.routereport.RouteReportImgListAdapter.GridViewCallback;
import com.baidu.navisdk.module.ugc.dialog.PicChooseDialog;
import com.baidu.navisdk.module.ugc.dialog.PicChooseDialog.PicProcessCallBack;
import com.baidu.navisdk.module.ugc.ui.widget.UgcCustomLinearScrollView;
import com.baidu.navisdk.module.ugc.ui.widget.UgcCustomLinearScrollView.OnStatusChangeListener;
import com.baidu.navisdk.module.ugc.utils.PhotoProcessUtils.PicProcessResInfo;
import com.baidu.navisdk.ui.ugc.view.UgcSoundsRecordDialog;
import com.baidu.navisdk.ui.ugc.view.UgcSoundsRecordDialog.onUgcSoundsRecordCallback;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.ui.util.ForbidDaulClickUtils;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.ui.util.UIUtils;
import com.baidu.navisdk.util.common.FileUtils;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.NetworkUtils;
import com.baidu.navisdk.util.common.SystemAuth;
import com.baidu.navisdk.util.drawable.UrlDrawableContainIView;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.navisdk.util.logic.BNExtGPSLocationManager;
import com.baidu.navisdk.util.statistic.userop.UserOPController;
import com.baidu.navisdk.util.statistic.userop.UserOPParams;
import com.baidu.navisdk.util.worker.BNWorkerCenter;
import com.baidu.navisdk.util.worker.BNWorkerConfig;
import com.baidu.navisdk.util.worker.BNWorkerNormalTask;
import com.baidu.platform.comapi.map.MapBundleKey.MapObjKey;
import java.util.ArrayList;

public class BNRouteReportUI {
    private static final int RES_AUDIO_RECORD = 1711408143;
    private static final int RES_DELETE = 1711408142;
    private static final String TAG = BNRouteReportUI.class.getSimpleName();
    private static final int TEXT_MAX_LENGTH = 40;
    private State currentState = State.NONE;
    private boolean isShowDeleteView = false;
    private boolean isShowPicView = false;
    private Activity mActivity;
    private ImageView mAudioRecordIView = null;
    private View mBack;
    TextWatcher mContentTextWatcher = new TextWatcher() {
        public void afterTextChanged(Editable s) {
            if (BNRouteReportUI.this.mDescriEText != null && BNRouteReportUI.this.mAudioRecordIView != null) {
                if (s.length() <= 0) {
                    if (BNRouteReportUI.this.isShowDeleteView) {
                        BNRouteReportUI.this.isShowDeleteView = false;
                        if (BNRouteReportUI.this.mAudioRecordIView != null) {
                            BNRouteReportUI.this.mAudioRecordIView.setBackgroundDrawable(BNStyleManager.getDrawable(1711408143));
                        }
                    }
                } else if (!BNRouteReportUI.this.isShowDeleteView) {
                    BNRouteReportUI.this.isShowDeleteView = true;
                    if (BNRouteReportUI.this.mAudioRecordIView != null) {
                        BNRouteReportUI.this.mAudioRecordIView.setBackgroundDrawable(BNStyleManager.getDrawable(1711408142));
                    }
                }
                if (s.length() > 40) {
                    BNRouteReportUI.this.mDescriEText.setText(BNRouteReportUI.this.mDescriEText.getText().toString().substring(0, 40));
                    Selection.setSelection(BNRouteReportUI.this.mDescriEText.getText(), 40);
                    TipTool.onCreateToastDialog(BNRouteReportUI.this.mActivity, JarUtils.getResources().getString(C4048R.string.nsdk_string_ugc_report_content_max_length));
                }
                BNRouteReportModel.getInstance().getCurrentRouteReportModel().content = BNRouteReportUI.this.mDescriEText.getText().toString().trim();
                BNRouteReportUI.this.updateSubmitBtnState();
            }
        }

        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }
    };
    private EditText mDescriEText = null;
    private GridView mFLevelGridView = null;
    private RouteReportImgListAdapter mFLevelGridViewAdapter = null;
    private LinearLayout mFirstLevelLayout = null;
    public ArrayList<RouteReportItem> mFlevelItemsList = null;
    private RelativeLayout mFootContainer;
    private View mGreyShade = null;
    private OnFocusChangeListener mOnFocusChangeListener = new OnFocusChangeListener() {
        public void onFocusChange(View v, boolean hasFocus) {
            if (!hasFocus) {
                BNRouteReportUI.this.hideInputMethod();
            }
        }
    };
    private onUgcSoundsRecordCallback mOnUgcSoundsRecordCallback = new onUgcSoundsRecordCallback() {
        public void onRecordFinish(int recordTime, String filePath, boolean isSucess) {
            BNRouteReportUI.this.dismissSoundsRecordDialog();
            if (!isSucess) {
                return;
            }
            if (recordTime == 0) {
                TipTool.onCreateToastDialog(BNRouteReportUI.this.mActivity, JarUtils.getResources().getString(C4048R.string.nsdk_string_ugc_report_recorde_tooshort));
                return;
            }
            BNRouteReportUI.this.soundsViewShow(recordTime);
            BNRouteReportModel.getInstance().getCurrentRouteReportModel().voicePath = filePath;
            BNRouteReportModel.getInstance().getCurrentRouteReportModel().voiceLength = recordTime;
            BNRouteReportModel.getInstance().getCurrentRouteReportModel().content = null;
        }
    };
    private PicProcessCallBack mPicProcessListener = new PicProcessCallBack() {
        public void onSuccess(PicProcessResInfo mPicProcessResInfo) {
            BNRouteReportUI.this.showPhotoBitmap(mPicProcessResInfo.bitmap);
            BNRouteReportModel.getInstance().getCurrentRouteReportModel().photoPicPath = mPicProcessResInfo.filePath;
            BNRouteReportUI.this.dimissPicDialog();
            BNRouteReportUI.this.updateSubmitBtnState();
        }

        public void onFail(String str) {
            BNRouteReportUI.this.dimissPicDialog();
        }
    };
    private GridView mSLevelGridView = null;
    private RouteReportTextListAdapter mSLevelGridViewAdapter = null;
    private UgcCustomLinearScrollView mSecondLevelLayout = null;
    private ViewGroup mSelectionPointerContainer = null;
    private View mShadeContainer = null;
    private View mSlevelAddrInfoContainer = null;
    private TextView mSlevelAddrInfoTV = null;
    private View mSlevelEditAddrIc = null;
    private View mSlevelEditAddrTv = null;
    private View mSlevelFoldableArea = null;
    private ImageView mSlevelIcon = null;
    private View mSlevelSelectPointPrompt = null;
    private TextView mSlevelTypeTv = null;
    private boolean mStatusChanged = false;
    private Button mSubmitBtn = null;
    private TextView mTimeSumTView = null;
    private View mTitleContainer;
    private View mTransparentShade = null;
    private UgcSoundsRecordDialog mUgcSoundsRecordDialog = null;
    private View mYellowBarClose;
    private View mYellowBarContainer;
    private RelativeLayout mapPanelContainer;
    private ImageView photoDeletedIv = null;
    private ImageView photoGetIv = null;
    private ImageView photoShowIv = null;
    private View photoShowLayout = null;
    private PicChooseDialog picChooseDialog = null;
    private View routeReportRootView = null;
    private boolean scrollViewInited = false;

    /* renamed from: com.baidu.navisdk.module.routereport.BNRouteReportUI$1 */
    class C41761 implements OnTouchListener {
        C41761() {
        }

        public boolean onTouch(View v, MotionEvent event) {
            BNRouteReportUI.this.nextState(false);
            return true;
        }
    }

    /* renamed from: com.baidu.navisdk.module.routereport.BNRouteReportUI$2 */
    class C41772 implements OnTouchListener {
        C41772() {
        }

        public boolean onTouch(View v, MotionEvent event) {
            if (!ForbidDaulClickUtils.isFastDoubleClick()) {
                BNRouteReportUI.this.nextState(false);
            }
            return true;
        }
    }

    /* renamed from: com.baidu.navisdk.module.routereport.BNRouteReportUI$3 */
    class C41783 implements OnClickListener {
        C41783() {
        }

        public void onClick(View v) {
            BNRouteReportUI.this.nextState(false);
        }
    }

    /* renamed from: com.baidu.navisdk.module.routereport.BNRouteReportUI$4 */
    class C41794 implements OnClickListener {
        C41794() {
        }

        public void onClick(View v) {
            BNRouteReportUI.this.nextState(false);
        }
    }

    /* renamed from: com.baidu.navisdk.module.routereport.BNRouteReportUI$5 */
    class C41805 implements OnTouchListener {
        C41805() {
        }

        public boolean onTouch(View v, MotionEvent event) {
            BNRouteReportUI.this.nextState(false);
            return true;
        }
    }

    /* renamed from: com.baidu.navisdk.module.routereport.BNRouteReportUI$6 */
    class C41816 implements GridViewCallback {
        C41816() {
        }

        public void onItemClick(int position, RouteReportItem item) {
            if (item != null) {
                BNRouteReportModel.getInstance().getCurrentRouteReportModel().parentType = "" + item.mType;
                BNRouteReportModel.getInstance().setCurrentFlevelItem(item);
                if (BNRouteReportModel.needsProjection(item.mType)) {
                    BNRouteReportController.getInstance().onWrapperAction(6);
                } else {
                    BNRouteReportController.getInstance().onWrapperAction(7);
                }
                BNRouteReportUI.this.nextState(true);
                String sourceType = BNRouteReportController.getInstance().isIntentBeforeNavi() ? "1" : "2";
                switch (item.mType) {
                    case 11:
                        UserOPController.getInstance().add(UserOPParams.ROUTE_2_e_3, sourceType, null, null);
                        return;
                    case 12:
                        UserOPController.getInstance().add(UserOPParams.ROUTE_2_e_4, sourceType, null, null);
                        return;
                    case 13:
                        UserOPController.getInstance().add(UserOPParams.ROUTE_2_e_2, sourceType, null, null);
                        return;
                    case 14:
                        UserOPController.getInstance().add(UserOPParams.ROUTE_2_e_1, sourceType, null, null);
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* renamed from: com.baidu.navisdk.module.routereport.BNRouteReportUI$7 */
    class C41827 implements OnClickListener {
        C41827() {
        }

        public void onClick(View v) {
        }
    }

    /* renamed from: com.baidu.navisdk.module.routereport.BNRouteReportUI$8 */
    class C41838 implements OnClickListener {
        C41838() {
        }

        public void onClick(View v) {
            BNRouteReportUI.this.nextState(false);
        }
    }

    /* renamed from: com.baidu.navisdk.module.routereport.BNRouteReportUI$9 */
    class C41849 implements OnClickListener {
        C41849() {
        }

        public void onClick(View v) {
            BNRouteReportController.getInstance().setYellowBarClosedForThisLaunch(true);
            if (BNRouteReportUI.this.mYellowBarContainer != null) {
                BNRouteReportUI.this.mYellowBarContainer.setVisibility(8);
            }
        }
    }

    private enum State {
        NONE,
        FIRST_LEVEL,
        SELECT_POINT,
        SECOND_LEVEL
    }

    public BNRouteReportUI(Activity activity, boolean isNavigateBack) {
        if (activity != null) {
            this.mActivity = activity;
            try {
                this.routeReportRootView = JarUtils.inflate(this.mActivity, C4048R.layout.nsdk_layout_route_report, null);
                if (this.routeReportRootView != null) {
                    this.mFlevelItemsList = BNRouteReportModel.getInstance().getIntendedItemsList(BNRouteReportController.getInstance().getIntentType());
                    findViews();
                    initViews();
                    initListeners();
                    initState();
                }
            } catch (Exception e) {
                this.routeReportRootView = null;
            }
        }
    }

    private void findViews() {
        this.mShadeContainer = this.routeReportRootView.findViewById(C4048R.id.shade_container);
        this.mTransparentShade = this.routeReportRootView.findViewById(C4048R.id.transparent_shade);
        this.mGreyShade = this.routeReportRootView.findViewById(C4048R.id.grey_shade);
        this.mSelectionPointerContainer = (ViewGroup) this.routeReportRootView.findViewById(C4048R.id.selection_pointer_container);
        this.mTitleContainer = this.routeReportRootView.findViewById(C4048R.id.title_container);
        this.mBack = this.routeReportRootView.findViewById(C4048R.id.back_container);
        this.mYellowBarContainer = this.routeReportRootView.findViewById(C4048R.id.route_report_yellow_bar);
        this.mYellowBarClose = this.routeReportRootView.findViewById(C4048R.id.route_report_close_yellow_bar);
        this.mapPanelContainer = (RelativeLayout) this.routeReportRootView.findViewById(C4048R.id.ugc_sub_fade_layer);
        this.mFootContainer = (RelativeLayout) this.routeReportRootView.findViewById(C4048R.id.foot_container);
        this.mFirstLevelLayout = (LinearLayout) this.routeReportRootView.findViewById(C4048R.id.ugc_report_main_Flevel_Layout);
        this.mFLevelGridView = (GridView) this.routeReportRootView.findViewById(C4048R.id.ugc_report_main_grideview);
        this.mAudioRecordIView = (ImageView) this.routeReportRootView.findViewById(C4048R.id.ugc_report_sounds_imageview);
        this.mSecondLevelLayout = (UgcCustomLinearScrollView) this.routeReportRootView.findViewById(C4048R.id.ugc_report_main_Slevel_Layout);
        this.mSlevelIcon = (ImageView) this.routeReportRootView.findViewById(C4048R.id.ugc_report_slevel_icon);
        this.mSlevelTypeTv = (TextView) this.routeReportRootView.findViewById(C4048R.id.ugc_report_slevel_title);
        this.mSlevelAddrInfoContainer = this.routeReportRootView.findViewById(C4048R.id.slevel_addr_info_container);
        this.mSlevelAddrInfoTV = (TextView) this.routeReportRootView.findViewById(C4048R.id.slevel_addr_info);
        this.mSlevelEditAddrIc = this.routeReportRootView.findViewById(C4048R.id.slevel_edit_addr_icon);
        this.mSlevelEditAddrTv = this.routeReportRootView.findViewById(C4048R.id.slevel_edit_addr_txt);
        this.mSlevelSelectPointPrompt = this.routeReportRootView.findViewById(C4048R.id.slevel_select_point_prompt);
        this.mSlevelFoldableArea = this.routeReportRootView.findViewById(C4048R.id.ugc_sub_scroll_layout);
        this.mSLevelGridView = (GridView) this.routeReportRootView.findViewById(C4048R.id.route_report_slevel_gridview);
        this.mDescriEText = (EditText) this.routeReportRootView.findViewById(C4048R.id.ugc_report_sub_descri_etext);
        this.photoGetIv = (ImageView) this.routeReportRootView.findViewById(C4048R.id.ugc_sub_info_fill_photo_iv);
        this.photoShowLayout = this.routeReportRootView.findViewById(C4048R.id.ugc_sub_photo_show_layout);
        this.photoShowIv = (ImageView) this.routeReportRootView.findViewById(C4048R.id.ugc_sub_photo_show_iv);
        this.photoDeletedIv = (ImageView) this.routeReportRootView.findViewById(C4048R.id.ugc_sub_photo_show_delete_iv);
        this.mTimeSumTView = (TextView) this.routeReportRootView.findViewById(C4048R.id.ugc_report_sounds_timesum_tview);
        this.mSubmitBtn = (Button) this.routeReportRootView.findViewById(C4048R.id.ugc_report_reported_button);
    }

    private void initViews() {
        this.mYellowBarContainer.setVisibility(8);
        this.mTimeSumTView.setVisibility(8);
        this.mDescriEText.setVisibility(0);
        this.mDescriEText.addTextChangedListener(this.mContentTextWatcher);
        this.mDescriEText.setHintTextColor(Color.parseColor("#999999"));
        this.mFirstLevelLayout.setVisibility(0);
        this.mSecondLevelLayout.setVisibility(8);
        this.mSecondLevelLayout.setNeedStatusChange(true);
    }

    private void initState() {
        this.currentState = State.NONE;
        nextState(true);
        this.mSecondLevelLayout.setScrollSupport(true);
    }

    public synchronized void nextState(boolean forward) {
        LogUtil.m15791e(TAG, "nextState: --> currentState: " + this.currentState + ", forward: " + forward);
        switch (this.currentState) {
            case NONE:
                if (forward) {
                    this.currentState = State.FIRST_LEVEL;
                    if (this.mTitleContainer != null) {
                        this.mTitleContainer.setVisibility(8);
                    }
                    initFlevelGridView();
                    setShadeShow(true, true, new C41761());
                    BNRouteReportController.getInstance().onWrapperAction(5);
                    break;
                }
                break;
            case FIRST_LEVEL:
                if (!forward) {
                    this.currentState = State.NONE;
                    BNRouteReportController.getInstance().onWrapperAction(1);
                    break;
                }
                this.currentState = State.SELECT_POINT;
                if (this.mTitleContainer != null) {
                    this.mTitleContainer.setVisibility(0);
                }
                setShadeShow(false, false, null);
                if (this.mapPanelContainer != null) {
                    this.mapPanelContainer.setVisibility(0);
                }
                BNRouteReportController.getInstance().onWrapperAction(8);
                BNRouteReportController.getInstance().onWrapperAction(4);
                if (this.mFirstLevelLayout != null) {
                    this.mFirstLevelLayout.setVisibility(8);
                }
                showSelectPointFoot();
                break;
            case SELECT_POINT:
                if (!forward) {
                    this.currentState = State.FIRST_LEVEL;
                    clearSlevelInput();
                    if (this.mTitleContainer != null) {
                        this.mTitleContainer.setVisibility(8);
                    }
                    setShadeShow(true, true, new C41805());
                    BNRouteReportController.getInstance().onWrapperAction(5);
                    if (!(this.mFirstLevelLayout == null || this.mSecondLevelLayout == null)) {
                        this.mFirstLevelLayout.setVisibility(0);
                        this.mSecondLevelLayout.setVisibility(8);
                        break;
                    }
                }
                this.currentState = State.SECOND_LEVEL;
                if (this.mTitleContainer != null) {
                    this.mTitleContainer.setVisibility(0);
                }
                setShadeShow(true, false, new C41772());
                BNRouteReportController.getInstance().onWrapperAction(5);
                BNRouteReportController.getInstance().onWrapperAction(9);
                if (this.mSlevelAddrInfoTV != null) {
                    Bundle addrResult = BNRouteReportModel.getInstance().getAddrResult();
                    if (addrResult != null) {
                        String addr = addrResult.getString(NaviCmdConstants.KEY_NAVI_CMD_DEST_ADDRESS);
                        TextView textView = this.mSlevelAddrInfoTV;
                        if (TextUtils.isEmpty(addr)) {
                            addr = "地图上的点";
                        }
                        textView.setText(addr);
                    }
                }
                if (this.mSlevelEditAddrIc != null) {
                    this.mSlevelEditAddrIc.setOnClickListener(new C41783());
                }
                if (this.mSlevelEditAddrTv != null) {
                    this.mSlevelEditAddrTv.setOnClickListener(new C41794());
                }
                showSLevelList();
                break;
            case SECOND_LEVEL:
                if (!forward) {
                    this.currentState = State.SELECT_POINT;
                    hideInputMethod();
                    if (this.mTitleContainer != null) {
                        this.mTitleContainer.setVisibility(0);
                    }
                    setShadeShow(false, false, null);
                    if (this.mapPanelContainer != null) {
                        this.mapPanelContainer.setVisibility(0);
                    }
                    BNRouteReportController.getInstance().onWrapperAction(10);
                    BNRouteReportController.getInstance().onWrapperAction(4);
                    BNRouteReportController.getInstance().onWrapperAction(12);
                    if (this.mFirstLevelLayout != null) {
                        this.mFirstLevelLayout.setVisibility(8);
                    }
                    showSelectPointFoot();
                    break;
                }
                this.currentState = State.NONE;
                BNRouteReportController.getInstance().onWrapperAction(3);
                BNRouteReportController.getInstance().onWrapperAction(10);
                break;
        }
    }

    private void initFlevelGridView() {
        BNRouteReportModel.getInstance().getCurrentRouteReportModel().parentType = null;
        if (this.mFLevelGridView != null && this.mFlevelItemsList != null && this.mFlevelItemsList.size() > 0) {
            if (this.mFlevelItemsList.size() >= 4) {
                this.mFLevelGridView.setNumColumns(4);
            } else {
                this.mFLevelGridView.setNumColumns(this.mFlevelItemsList.size());
            }
            this.mFLevelGridViewAdapter = new RouteReportImgListAdapter(this.mActivity, this.mFlevelItemsList, new C41816());
            this.mFLevelGridViewAdapter.setBindedView(this.mFLevelGridView);
            this.mFLevelGridView.setAdapter(this.mFLevelGridViewAdapter);
        }
    }

    private void initListeners() {
        if (this.mTitleContainer != null) {
            this.mTitleContainer.setOnClickListener(new C41827());
        }
        if (this.mBack != null) {
            this.mBack.setOnClickListener(new C41838());
        }
        if (this.mYellowBarClose != null) {
            this.mYellowBarClose.setOnClickListener(new C41849());
        }
        if (this.mSubmitBtn != null) {
            this.mSubmitBtn.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
                public void onGlobalLayout() {
                    if (!BNRouteReportUI.this.scrollViewInited && BNRouteReportUI.this.mSecondLevelLayout != null) {
                        BNRouteReportUI.this.scrollViewInited = true;
                        BNRouteReportUI.this.mSecondLevelLayout.gotoBottom();
                    }
                }
            });
        }
        if (this.mSecondLevelLayout != null) {
            this.mSecondLevelLayout.setOnStatusChangeListener(new OnStatusChangeListener() {
                public void onStatusChange(int state) {
                    if (state == 1) {
                        if (BNRouteReportUI.this.currentState == State.SECOND_LEVEL) {
                            BNRouteReportUI.this.nextState(false);
                        }
                    } else if (!BNRouteReportUI.this.mStatusChanged) {
                        BNRouteReportUI.this.mStatusChanged = true;
                    } else if (BNRouteReportUI.this.currentState == State.SELECT_POINT) {
                        BNRouteReportController.getInstance().onWrapperAction(11);
                    }
                }
            });
        }
        if (this.mDescriEText != null) {
            this.mDescriEText.setOnFocusChangeListener(this.mOnFocusChangeListener);
        }
        if (this.mSubmitBtn != null) {
            this.mSubmitBtn.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    BNRouteReportUI.this.onClickSubmitButton();
                }
            });
        }
        if (this.mAudioRecordIView != null) {
            this.mAudioRecordIView.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    if (BNRouteReportUI.this.mTimeSumTView != null && BNRouteReportUI.this.mDescriEText != null) {
                        if (!BNRouteReportUI.this.isShowDeleteView) {
                            BNRouteReportUI.this.gotoSoundsRecord();
                        } else if (BNRouteReportUI.this.mTimeSumTView.isShown()) {
                            BNRouteReportUI.this.isShowDeleteView = false;
                            BNRouteReportUI.this.mTimeSumTView.setVisibility(8);
                            BNRouteReportUI.this.mDescriEText.setVisibility(0);
                            v.setBackgroundDrawable(BNStyleManager.getDrawable(1711408143));
                            BNRouteReportModel.getInstance().getCurrentRouteReportModel().voicePath = null;
                            BNRouteReportModel.getInstance().getCurrentRouteReportModel().voiceLength = -1;
                            BNRouteReportUI.this.updateSubmitBtnState();
                        } else {
                            BNRouteReportUI.this.isShowDeleteView = false;
                            v.setBackgroundDrawable(BNStyleManager.getDrawable(1711408143));
                            if (BNRouteReportUI.this.mDescriEText != null) {
                                BNRouteReportUI.this.mDescriEText.setText("");
                            }
                            BNRouteReportModel.getInstance().getCurrentRouteReportModel().content = null;
                            BNRouteReportUI.this.updateSubmitBtnState();
                        }
                    }
                }
            });
        }
        if (this.photoGetIv != null) {
            this.photoGetIv.setOnClickListener(new OnClickListener() {

                /* renamed from: com.baidu.navisdk.module.routereport.BNRouteReportUI$14$1 */
                class C41751 implements OnCancelListener {
                    C41751() {
                    }

                    public void onCancel(DialogInterface dialog) {
                        if (BNRouteReportUI.this.picChooseDialog != null) {
                            BNRouteReportUI.this.picChooseDialog.dismiss();
                            BNRouteReportUI.this.picChooseDialog = null;
                        }
                    }
                }

                public void onClick(View v) {
                    if (BNRouteReportUI.this.picChooseDialog == null) {
                        BNRouteReportUI.this.picChooseDialog = new PicChooseDialog(BNRouteReportUI.this.mActivity);
                    }
                    BNRouteReportUI.this.picChooseDialog.setListener(BNRouteReportUI.this.mPicProcessListener);
                    BNRouteReportUI.this.picChooseDialog.setOnCancelListener(new C41751());
                    BNRouteReportUI.this.picChooseDialog.show();
                }
            });
        }
    }

    public void updateYellowBarState(int yawPointsCount) {
        boolean hasBeenClosed = BNRouteReportController.getInstance().isYellowBarClosedForThisLaunch();
        LogUtil.m15791e(TAG, "updateYellowBarState: --> hasBeenClosed: " + hasBeenClosed + ", yawPointsCount: " + yawPointsCount);
        if (!hasBeenClosed && yawPointsCount > 0) {
            BNWorkerCenter.getInstance().submitMainThreadTask(new BNWorkerNormalTask<String, String>("UpdateYellowBarState-" + getClass().getSimpleName(), null) {
                protected String execute() {
                    if (BNRouteReportUI.this.mYellowBarContainer != null) {
                        BNRouteReportUI.this.mYellowBarContainer.setVisibility(BNRouteReportController.getInstance().isIntentBeforeNavi() ? 8 : 0);
                    }
                    return null;
                }
            }, new BNWorkerConfig(1, 0));
        }
    }

    private void hideInputMethod() {
        if (this.mDescriEText != null) {
            ((InputMethodManager) BNaviModuleManager.getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.mDescriEText.getWindowToken(), 0);
        }
    }

    private void initSlevelGridView(RouteReportItem data) {
        if (data != null && data.subItemsList != null && data.subItemsList.size() > 0) {
            if (data.subItemsList.size() >= 4) {
                this.mSLevelGridView.setNumColumns(4);
            } else {
                this.mSLevelGridView.setNumColumns(data.subItemsList.size());
            }
            this.mSLevelGridViewAdapter = new RouteReportTextListAdapter(this.mActivity, data.subItemsList, new RouteReportTextListAdapter.GridViewCallback() {
                public void onItemClick(int position, RouteReportItem item) {
                    BNRouteReportModel.getInstance().getCurrentRouteReportModel().subType = "" + item.mType;
                    BNRouteReportUI.this.updateSubmitBtnState();
                }
            });
            this.mSLevelGridViewAdapter.setCurrentSelectedItem(BNRouteReportModel.getInstance().getCurrentRouteReportModel().subType);
            this.mSLevelGridViewAdapter.setBindedView(this.mSLevelGridView);
            this.mSLevelGridView.setAdapter(this.mSLevelGridViewAdapter);
        }
    }

    private void showSelectPointFoot() {
        RouteReportItem data = BNRouteReportModel.getInstance().getCurrentFlevelItem();
        if (this.mSlevelTypeTv != null && this.mSlevelSelectPointPrompt != null && this.mSlevelAddrInfoContainer != null && data != null) {
            LogUtil.m15791e(TAG, "showSLevelList: data --> " + data.toString());
            this.mSlevelTypeTv.setText(data.mTitle == null ? "" : data.mTitle);
            BNRouteReportController.setupUrlDrawable(this.mSlevelIcon, BNRouteReportModel.getInstance().getDefaultResId(data.mType), data.mIconUrl);
            this.mSlevelSelectPointPrompt.setVisibility(0);
            this.mSlevelAddrInfoContainer.setVisibility(8);
            initSlevelGridView(data);
            this.mSecondLevelLayout.setVisibility(0);
            if (this.scrollViewInited) {
                this.mSecondLevelLayout.gotoBottom();
            }
        }
    }

    private void showSLevelList() {
        RouteReportItem data = BNRouteReportModel.getInstance().getCurrentFlevelItem();
        if (this.mSlevelTypeTv != null && this.mSlevelSelectPointPrompt != null && this.mSlevelAddrInfoContainer != null && data != null && this.mSlevelFoldableArea != null) {
            LogUtil.m15791e(TAG, "showSLevelList: data --> " + data.toString());
            this.mSlevelTypeTv.setText(data.mTitle == null ? "" : data.mTitle);
            this.mSlevelSelectPointPrompt.setVisibility(8);
            this.mSlevelAddrInfoContainer.setVisibility(0);
            updateSubmitBtnState();
            this.mSlevelFoldableArea.setVisibility(0);
            this.mSecondLevelLayout.setVisibility(0);
            if (this.scrollViewInited) {
                this.mSecondLevelLayout.gotoTop();
            }
        }
    }

    private void clearSlevelInput() {
        LogUtil.m15791e(TAG, "clearSlevelInput: --> ");
        BNRouteReportModel.getInstance().getCurrentRouteReportModel().subType = null;
        BNRouteReportModel.getInstance().getCurrentRouteReportModel().content = null;
        BNRouteReportModel.getInstance().getCurrentRouteReportModel().voiceLength = 0;
        try {
            if (BNRouteReportModel.getInstance().getCurrentRouteReportModel().voicePath != null) {
                FileUtils.del(BNRouteReportModel.getInstance().getCurrentRouteReportModel().voicePath);
            }
        } catch (Throwable th) {
        }
        BNRouteReportModel.getInstance().getCurrentRouteReportModel().voicePath = null;
        if (!(this.mDescriEText == null || this.mTimeSumTView == null || this.mAudioRecordIView == null)) {
            this.mTimeSumTView.setVisibility(8);
            this.mDescriEText.setText("");
            this.mDescriEText.setVisibility(0);
            this.mAudioRecordIView.setBackgroundDrawable(BNStyleManager.getDrawable(1711408143));
        }
        try {
            if (BNRouteReportModel.getInstance().getCurrentRouteReportModel().photoPicPath != null) {
                FileUtils.del(BNRouteReportModel.getInstance().getCurrentRouteReportModel().photoPicPath);
            }
        } catch (Throwable th2) {
        }
        BNRouteReportModel.getInstance().getCurrentRouteReportModel().photoPicPath = null;
        showPhotoCancle();
    }

    private void updateSubmitBtnState() {
        if (this.mSubmitBtn == null) {
            return;
        }
        if (BNRouteReportModel.getInstance().getCurrentRouteReportModel().subType != null) {
            this.mSubmitBtn.setEnabled(true);
        } else if (this.isShowDeleteView) {
            this.mSubmitBtn.setEnabled(true);
        } else if (this.isShowPicView) {
            this.mSubmitBtn.setEnabled(true);
        } else {
            this.mSubmitBtn.setEnabled(false);
        }
    }

    private void gotoSoundsRecord() {
        if (SystemAuth.checkAuth("android.permission.RECORD_AUDIO", true, "没有麦克风权限，请打开后重试")) {
            if (this.mUgcSoundsRecordDialog != null) {
                UgcSoundsRecordDialog.stopRecordAndDismiss();
            }
            if (this.mActivity != null && !this.mActivity.isFinishing()) {
                this.mUgcSoundsRecordDialog = new UgcSoundsRecordDialog(this.mActivity);
                this.mUgcSoundsRecordDialog.show();
                this.mUgcSoundsRecordDialog.setOnUgcSoundsRecordCallback(this.mOnUgcSoundsRecordCallback);
                return;
            }
            return;
        }
        BNRouteReportController.getInstance().onWrapperAction(2);
    }

    private void soundsViewShow(int recordTime) {
        if (this.mAudioRecordIView != null && this.mDescriEText != null && this.mTimeSumTView != null) {
            this.mTimeSumTView.setVisibility(0);
            this.mDescriEText.setVisibility(8);
            this.mAudioRecordIView.setBackgroundDrawable(BNStyleManager.getDrawable(1711408142));
            this.mTimeSumTView.setText(Html.fromHtml("语音描述  <font color=\"#3a86fd\"> " + recordTime + " \""));
            this.isShowDeleteView = true;
            updateSubmitBtnState();
        }
    }

    private void dismissSoundsRecordDialog() {
        if (this.mActivity != null && !this.mActivity.isFinishing() && this.mUgcSoundsRecordDialog != null) {
            if (this.mUgcSoundsRecordDialog.isShowing()) {
                this.mUgcSoundsRecordDialog.dismiss();
            }
            this.mUgcSoundsRecordDialog = null;
        }
    }

    private void showPhotoBitmap(Bitmap bitmap) {
        if (this.photoShowLayout != null && this.photoShowIv != null && this.photoDeletedIv != null && this.photoGetIv != null && bitmap != null) {
            this.isShowPicView = true;
            this.photoShowLayout.setVisibility(0);
            this.photoGetIv.setVisibility(8);
            this.photoShowIv.setImageBitmap(bitmap);
            this.photoDeletedIv.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    BNRouteReportUI.this.showPhotoCancle();
                }
            });
        }
    }

    private void showPhotoCancle() {
        if (this.photoShowLayout != null && this.photoGetIv != null) {
            this.isShowPicView = false;
            this.photoShowLayout.setVisibility(8);
            this.photoGetIv.setVisibility(0);
            updateSubmitBtnState();
        }
    }

    private void dimissPicDialog() {
        if (this.picChooseDialog != null) {
            this.picChooseDialog.dismiss();
            this.picChooseDialog = null;
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (this.picChooseDialog != null) {
            this.picChooseDialog.onActivityResult(requestCode, resultCode, data);
        }
    }

    private void onClickSubmitButton() {
        if (!ForbidDaulClickUtils.isFastDoubleClick()) {
            if (BNRouteReportController.getInstance().isUploading()) {
                TipTool.onCreateToastDialog(this.mActivity, JarUtils.getResources().getString(C4048R.string.nsdk_string_ugc_report_upload_frequent));
            } else if (NetworkUtils.isNetworkAvailable(this.mActivity)) {
                LocData curLoaction = BNExtGPSLocationManager.getInstance().getCurLocation();
                if (curLoaction == null) {
                    TipTool.onCreateToastDialog(this.mActivity, JarUtils.getResources().getString(C4048R.string.nsdk_string_ugc_report_lackgps));
                    return;
                }
                BNRouteReportModel.getInstance().getCurrentRouteReportModel().userPoint = BNRouteReportController.ll2mcStr(curLoaction.longitude, curLoaction.latitude);
                Bundle addrResult = BNRouteReportModel.getInstance().getAddrResult();
                if (addrResult != null) {
                    int x = (int) addrResult.getDouble(MapObjKey.OBJ_SL_PTX);
                    int y = (int) addrResult.getDouble(MapObjKey.OBJ_SL_PTY);
                    BNRouteReportModel.getInstance().getCurrentRouteReportModel().point = x + "," + y;
                    BNRouteReportModel.getInstance().getCurrentRouteReportModel().roadName = addrResult.getString(NaviCmdConstants.KEY_NAVI_CMD_DEST_ADDRESS);
                    BNRouteReportController.getInstance().upload();
                    nextState(true);
                }
            } else {
                TipTool.onCreateToastDialog(this.mActivity, JarUtils.getResources().getString(C4048R.string.nsdk_string_ugc_report_fail_badwet));
            }
        }
    }

    public void onResume() {
    }

    public void onPause() {
    }

    public void onDestroy() {
        if (this.mFLevelGridViewAdapter != null) {
            this.mFLevelGridViewAdapter.releaseBitmapRes();
        }
        UrlDrawableContainIView.recycleBitmap();
        UIUtils.releaseImageViewWithoutNull(this.photoShowIv);
        this.picChooseDialog = null;
        this.mActivity = null;
    }

    public boolean onBackPressed() {
        if (this.mUgcSoundsRecordDialog == null || !this.mUgcSoundsRecordDialog.isShowing()) {
            nextState(false);
        } else {
            dismissSoundsRecordDialog();
        }
        return true;
    }

    public void onConfigurationChanged(Configuration newConfig) {
    }

    public View getRootView() {
        return this.routeReportRootView;
    }

    public RelativeLayout getMapPanelContainer() {
        return this.mapPanelContainer;
    }

    public ViewGroup getSelectionPointerContainer() {
        return this.mSelectionPointerContainer;
    }

    public int[] getTopAndBottomHeightDp() {
        int[] result = new int[2];
        result[0] = 64;
        int rows = 0;
        if (this.mFlevelItemsList != null) {
            rows = (int) Math.ceil(((double) this.mFlevelItemsList.size()) / 4.0d);
        }
        result[1] = ((rows * 77) + 50) + ((rows - 1) * 22);
        return result;
    }

    private void setShadeShow(boolean show, boolean grey, OnTouchListener shadeTouchListener) {
        if (this.mShadeContainer != null && this.mGreyShade != null && this.mTransparentShade != null) {
            if (show) {
                this.mShadeContainer.setVisibility(0);
                if (shadeTouchListener == null) {
                    this.mShadeContainer.setOnTouchListener(new OnTouchListener() {
                        public boolean onTouch(View v, MotionEvent event) {
                            return true;
                        }
                    });
                    if (this.mapPanelContainer != null) {
                        this.mapPanelContainer.setOnTouchListener(new OnTouchListener() {
                            public boolean onTouch(View v, MotionEvent event) {
                                return true;
                            }
                        });
                    }
                } else {
                    this.mShadeContainer.setOnTouchListener(shadeTouchListener);
                    if (this.mapPanelContainer != null) {
                        this.mapPanelContainer.setOnTouchListener(shadeTouchListener);
                    }
                }
                if (grey) {
                    this.mGreyShade.setVisibility(0);
                    this.mTransparentShade.setVisibility(8);
                    return;
                }
                this.mGreyShade.setVisibility(8);
                this.mTransparentShade.setVisibility(0);
                return;
            }
            this.mShadeContainer.setVisibility(8);
            this.mShadeContainer.setOnTouchListener(null);
            if (this.mapPanelContainer != null) {
                this.mapPanelContainer.setOnTouchListener(null);
            }
        }
    }
}
