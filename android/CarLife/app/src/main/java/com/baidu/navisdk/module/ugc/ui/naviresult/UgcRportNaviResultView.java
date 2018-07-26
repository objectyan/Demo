package com.baidu.navisdk.module.ugc.ui.naviresult;

import android.app.Activity;
import android.content.Context;
import android.text.Html;
import android.view.MotionEvent;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.Button;
import android.widget.TextView;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.module.ugc.ui.SubContentContract;
import com.baidu.navisdk.module.ugc.ui.naviresult.UgcRportNaviResultContract.Presenter;
import com.baidu.navisdk.module.ugc.ui.naviresult.UgcRportNaviResultContract.View;
import com.baidu.navisdk.module.ugc.ui.widget.UgcCustomLinearScrollView;
import com.baidu.navisdk.module.ugc.ui.widget.UgcCustomLinearScrollView.OnStatusChangeListener;
import com.baidu.navisdk.ui.widget.BNDialog;
import com.baidu.navisdk.ui.widget.BNDialog.OnNaviClickListener;

public class UgcRportNaviResultView extends View {
    private static BNDialog mQuitReportDialog;
    private OnClickListener clickListener = new C42291();
    private int curState = 0;
    private android.view.View gobackView = null;
    private Presenter mPresenter;
    private UgcCustomLinearScrollView mainContentLayout = null;
    private ViewGroup mapComContainer = null;
    private boolean mapComContainerReady = false;
    private ViewGroup mapFullScreenContainer = null;
    private TextView newRoadtipsTv;
    private android.view.View positionChangeLayout = null;
    private TextView positionInfoTv = null;
    private android.view.View scrollLayout = null;
    private Button uploadBtn = null;

    /* renamed from: com.baidu.navisdk.module.ugc.ui.naviresult.UgcRportNaviResultView$1 */
    class C42291 implements OnClickListener {
        C42291() {
        }

        public void onClick(android.view.View v) {
            if (UgcRportNaviResultView.this.mPresenter != null) {
                switch (v.getId()) {
                    case C4048R.id.ugc_sub_title_change_position_layout /*1711867145*/:
                        UgcRportNaviResultView.this.mPresenter.gotoDtailView();
                        return;
                    case C4048R.id.ugc_sub_upload_btn /*1711867191*/:
                        UgcRportNaviResultView.this.mPresenter.secondUpload();
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* renamed from: com.baidu.navisdk.module.ugc.ui.naviresult.UgcRportNaviResultView$2 */
    class C42302 implements OnStatusChangeListener {
        C42302() {
        }

        public void onStatusChange(int state) {
            UgcRportNaviResultView.this.curState = state;
            if (UgcRportNaviResultView.this.curState == 1) {
                UgcRportNaviResultView.this.showScrollDismissLayout();
                if (UgcRportNaviResultView.this.mPresenter != null) {
                    UgcRportNaviResultView.this.mPresenter.hasShowSelectorPointStatus();
                    return;
                }
                return;
            }
            UgcRportNaviResultView.this.showScrollShowLayout();
            if (UgcRportNaviResultView.this.mPresenter != null) {
                UgcRportNaviResultView.this.mPresenter.hasShowOriginPage();
            }
        }
    }

    /* renamed from: com.baidu.navisdk.module.ugc.ui.naviresult.UgcRportNaviResultView$3 */
    class C42313 implements OnGlobalLayoutListener {
        C42313() {
        }

        public void onGlobalLayout() {
            if (UgcRportNaviResultView.this.mPresenter != null) {
                UgcRportNaviResultView.this.mapComContainerReady = true;
                UgcRportNaviResultView.this.mPresenter.informComHeight();
            }
        }
    }

    /* renamed from: com.baidu.navisdk.module.ugc.ui.naviresult.UgcRportNaviResultView$4 */
    class C42324 implements OnTouchListener {
        C42324() {
        }

        public boolean onTouch(android.view.View v, MotionEvent event) {
            if (event.getAction() != 0 || UgcRportNaviResultView.this.isSelectPointViewShowing()) {
                return false;
            }
            if (UgcRportNaviResultView.this.mPresenter == null || !UgcRportNaviResultView.this.mPresenter.isInNewRoad()) {
                if (UgcRportNaviResultView.this.mPresenter != null) {
                    UgcRportNaviResultView.this.mPresenter.finish();
                }
                return true;
            }
            UgcRportNaviResultView.this.mPresenter.gotoDtailView();
            return true;
        }
    }

    /* renamed from: com.baidu.navisdk.module.ugc.ui.naviresult.UgcRportNaviResultView$5 */
    class C42335 implements OnTouchListener {
        C42335() {
        }

        public boolean onTouch(android.view.View v, MotionEvent event) {
            if (!(event.getAction() != 0 || UgcRportNaviResultView.this.mPresenter == null || UgcRportNaviResultView.this.mPresenter.onBackPress())) {
                UgcRportNaviResultView.this.mPresenter.finish();
            }
            return true;
        }
    }

    public interface CallBack {
        void quitUgcPage();
    }

    public UgcRportNaviResultView(Context mContext) {
        super(mContext);
        initView();
        initListener();
    }

    public void setPresenter(SubContentContract.Presenter presenter) {
        super.setPresenter(presenter);
        this.mPresenter = (Presenter) presenter;
    }

    public ViewGroup getMapComPanelContainer() {
        return this.mapComContainer;
    }

    public ViewGroup getMapFullScreenContainer() {
        return this.mapFullScreenContainer;
    }

    private void initView() {
        if (this.rootView != null) {
            this.scrollLayout = this.rootView.findViewById(C4048R.id.ugc_sub_scroll_layout);
            this.mainContentLayout = (UgcCustomLinearScrollView) this.rootView.findViewById(C4048R.id.ugc_sub_main_content_layout);
            this.positionInfoTv = (TextView) this.rootView.findViewById(C4048R.id.ugc_sub_title_position_info_tv);
            this.mapComContainer = (ViewGroup) this.rootView.findViewById(C4048R.id.ugc_sub_fade_layer);
            this.mapFullScreenContainer = (ViewGroup) this.rootView.findViewById(C4048R.id.ugc_sub_map_container_layer);
            this.uploadBtn = (Button) this.rootView.findViewById(C4048R.id.ugc_sub_upload_btn);
            this.positionChangeLayout = this.rootView.findViewById(C4048R.id.ugc_sub_title_change_position_layout);
            this.rootView.findViewById(C4048R.id.ugc_sub_title_iv).setVisibility(8);
            this.newRoadtipsTv = (TextView) this.rootView.findViewById(C4048R.id.ugc_sub_title_result_info_tips_tv);
            this.gobackView = this.rootView.findViewById(C4048R.id.goback_iv);
            if (this.mapComContainer != null) {
                this.mapComContainer.setVisibility(0);
            }
            if (this.mapComContainer != null) {
                this.mapComContainer.setBackgroundColor(-16777216);
                this.mapComContainer.getBackground().setAlpha(66);
            }
            if (this.uploadBtn != null) {
                this.uploadBtn.setVisibility(0);
            }
        }
    }

    public void showPositionChangeLayout(boolean show) {
        if (this.positionChangeLayout == null) {
            return;
        }
        if (show) {
            this.positionChangeLayout.setVisibility(0);
        } else {
            this.positionChangeLayout.setVisibility(8);
        }
    }

    private void showScrollDismissLayout() {
        if (this.positionChangeLayout != null) {
            this.positionChangeLayout.setVisibility(8);
        }
        if (this.mapFullScreenContainer != null) {
            this.mapFullScreenContainer.setVisibility(0);
        }
    }

    private void showScrollShowLayout() {
        if (this.positionChangeLayout != null) {
            this.positionChangeLayout.setVisibility(0);
        }
        if (this.mapFullScreenContainer != null) {
            this.mapFullScreenContainer.setVisibility(4);
        }
    }

    public void showSelectorPointStatus() {
        if (!this.mapComContainerReady || this.mainContentLayout == null) {
            return;
        }
        if (this.mainContentLayout.gotoBottom()) {
            this.curState = 1;
            showScrollDismissLayout();
            return;
        }
        this.curState = 0;
    }

    public void showOriginPage() {
        if (!this.mapComContainerReady || this.mainContentLayout == null) {
            return;
        }
        if (this.mainContentLayout.gotoTop()) {
            this.curState = 0;
            showScrollShowLayout();
            return;
        }
        this.curState = 1;
    }

    public void supportScrollView() {
        if (this.mainContentLayout != null) {
            this.mainContentLayout.setScrollSupport(true);
            this.mainContentLayout.setOnStatusChangeListener(new C42302());
        }
    }

    public void initPresenterView() {
        super.initPresenterView();
    }

    private void initListener() {
        if (this.positionChangeLayout != null) {
            android.view.View view = this.positionChangeLayout;
            this.positionChangeLayout.setOnClickListener(this.clickListener);
        }
        if (this.uploadBtn != null) {
            this.uploadBtn.setOnClickListener(this.clickListener);
        }
        if (this.mapComContainer != null) {
            this.mapComContainer.getViewTreeObserver().addOnGlobalLayoutListener(new C42313());
        }
        this.mapComContainer.setOnTouchListener(new C42324());
        if (this.gobackView != null) {
            this.gobackView.setOnTouchListener(new C42335());
        }
    }

    public boolean isSelectPointViewShowing() {
        if (this.mainContentLayout == null) {
            return false;
        }
        if (this.mainContentLayout.getCurStatus() == 1) {
            return true;
        }
        return false;
    }

    public static synchronized void showQuitReportDialog(final Activity activity, final CallBack mCallBack) {
        synchronized (UgcRportNaviResultView.class) {
            if (activity != null) {
                if (!activity.isFinishing()) {
                    if (mQuitReportDialog == null) {
                        mQuitReportDialog = new BNDialog(activity).setTitleText(null).setContentMessage("您有未补充的上报\n是否放弃?").setContentCenter().setFirstBtnText(Html.fromHtml("<font color=\"#333333\">放弃补充</font>")).setOnFirstBtnClickListener(new OnNaviClickListener() {
                            public void onClick() {
                                UgcRportNaviResultView.dismissQuitReportDialog(activity);
                                if (mCallBack != null) {
                                    mCallBack.quitUgcPage();
                                }
                            }
                        }).setSecondBtnText(Html.fromHtml("<font color=\"#333333\">取消</font>")).setOnSecondBtnClickListener(new OnNaviClickListener() {
                            public void onClick() {
                                UgcRportNaviResultView.dismissQuitReportDialog(activity);
                            }
                        });
                    }
                    mQuitReportDialog.show();
                }
            }
        }
    }

    public static synchronized void dismissQuitReportDialog(Activity activity) {
        synchronized (UgcRportNaviResultView.class) {
            if (mQuitReportDialog == null || activity == null || activity.isFinishing()) {
                mQuitReportDialog = null;
            } else {
                if (mQuitReportDialog.isShowing()) {
                    mQuitReportDialog.dismiss();
                }
                mQuitReportDialog = null;
            }
        }
    }

    public void showAddrInfoUpdate(String adress, String adressDecri) {
        if (this.positionInfoTv != null) {
            this.positionInfoTv.setText(adress);
        }
    }

    public void showNewRoadLayoutView(boolean flag) {
        if (flag) {
            showPositionChangeLayout(true);
            this.gobackView.setVisibility(0);
            return;
        }
        showPositionChangeLayout(false);
    }

    public void setNewRoadSelectStatus(int status) {
        switch (status) {
            case 0:
                if (this.mapComContainer != null) {
                    this.mapComContainer.getBackground().setAlpha(0);
                }
                showSelectorPointStatus();
                if (this.mapFullScreenContainer != null) {
                    this.mapFullScreenContainer.setVisibility(0);
                }
                if (this.newRoadtipsTv != null) {
                    this.newRoadtipsTv.setVisibility(0);
                    this.newRoadtipsTv.setText("在图区确定新路起点");
                }
                if (this.positionInfoTv != null) {
                    this.positionInfoTv.setVisibility(8);
                    return;
                }
                return;
            case 1:
                if (this.newRoadtipsTv != null) {
                    this.newRoadtipsTv.setVisibility(0);
                    this.newRoadtipsTv.setText("在图区确定新路终点");
                    return;
                }
                return;
            case 2:
            case 3:
                if (this.mapFullScreenContainer != null) {
                    this.mapFullScreenContainer.setVisibility(8);
                }
                if (this.newRoadtipsTv != null) {
                    this.newRoadtipsTv.setVisibility(8);
                }
                if (this.positionInfoTv != null) {
                    this.positionInfoTv.setVisibility(0);
                }
                showOriginPage();
                return;
            default:
                return;
        }
    }
}
