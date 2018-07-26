package com.baidu.navisdk.module.ugc.ui.inmap.sub;

import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.Button;
import android.widget.TextView;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.module.ugc.ui.SubContentContract;
import com.baidu.navisdk.module.ugc.ui.inmap.sub.UgcReportMapSubDetailContract.Presenter;
import com.baidu.navisdk.module.ugc.ui.inmap.sub.UgcReportMapSubDetailContract.View;
import com.baidu.navisdk.module.ugc.ui.widget.UgcCustomLinearScrollView;
import com.baidu.navisdk.module.ugc.ui.widget.UgcCustomLinearScrollView.OnStatusChangeListener;

public class UgcReportMapSubDetailView extends View {
    private OnClickListener clickListener = new C42111();
    private int curState = 0;
    private android.view.View gobackView = null;
    private Presenter mPresenter = null;
    private UgcCustomLinearScrollView mainContentLayout = null;
    private ViewGroup mapComContainer = null;
    private ViewGroup mapFullScreenContainer = null;
    private android.view.View positionChangeLayout = null;
    private TextView positionInfoTv = null;
    private android.view.View scrollLayout = null;
    private android.view.View selectPositionInfoTv = null;
    private Button uploadBtn = null;

    /* renamed from: com.baidu.navisdk.module.ugc.ui.inmap.sub.UgcReportMapSubDetailView$1 */
    class C42111 implements OnClickListener {
        C42111() {
        }

        public void onClick(android.view.View v) {
            switch (v.getId()) {
                case C4048R.id.ugc_sub_title_change_position_layout /*1711867145*/:
                    if (UgcReportMapSubDetailView.this.mPresenter != null) {
                        UgcReportMapSubDetailView.this.mPresenter.showSelectorPointStatus();
                        return;
                    }
                    return;
                case C4048R.id.ugc_sub_upload_btn /*1711867191*/:
                    if (UgcReportMapSubDetailView.this.mPresenter != null) {
                        UgcReportMapSubDetailView.this.mPresenter.ugcUpLoad();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    /* renamed from: com.baidu.navisdk.module.ugc.ui.inmap.sub.UgcReportMapSubDetailView$2 */
    class C42122 implements OnStatusChangeListener {
        C42122() {
        }

        public void onStatusChange(int state) {
            UgcReportMapSubDetailView.this.curState = state;
            if (UgcReportMapSubDetailView.this.curState == 1) {
                UgcReportMapSubDetailView.this.showScrollDismissLayout();
                if (UgcReportMapSubDetailView.this.mPresenter != null) {
                    UgcReportMapSubDetailView.this.mPresenter.hasShowSelectorPointStatus();
                    return;
                }
                return;
            }
            UgcReportMapSubDetailView.this.showScrollShowLayout();
            if (UgcReportMapSubDetailView.this.mPresenter != null) {
                UgcReportMapSubDetailView.this.mPresenter.hasShowOriginPage();
            }
        }
    }

    /* renamed from: com.baidu.navisdk.module.ugc.ui.inmap.sub.UgcReportMapSubDetailView$3 */
    class C42133 implements OnGlobalLayoutListener {
        C42133() {
        }

        public void onGlobalLayout() {
            if (UgcReportMapSubDetailView.this.mPresenter != null) {
                UgcReportMapSubDetailView.this.mPresenter.informComHeight();
            }
        }
    }

    /* renamed from: com.baidu.navisdk.module.ugc.ui.inmap.sub.UgcReportMapSubDetailView$4 */
    class C42144 implements OnTouchListener {
        C42144() {
        }

        public boolean onTouch(android.view.View v, MotionEvent event) {
            if (event.getAction() != 0 || UgcReportMapSubDetailView.this.isSelectPointViewShowing()) {
                return false;
            }
            if (UgcReportMapSubDetailView.this.mPresenter != null) {
                UgcReportMapSubDetailView.this.mPresenter.showSelectorPointStatus();
            }
            return true;
        }
    }

    /* renamed from: com.baidu.navisdk.module.ugc.ui.inmap.sub.UgcReportMapSubDetailView$5 */
    class C42155 implements OnTouchListener {
        C42155() {
        }

        public boolean onTouch(android.view.View v, MotionEvent event) {
            if (!(event.getAction() != 0 || UgcReportMapSubDetailView.this.mPresenter == null || UgcReportMapSubDetailView.this.mPresenter.onBackPress())) {
                UgcReportMapSubDetailView.this.mPresenter.goback();
            }
            return true;
        }
    }

    public UgcReportMapSubDetailView(Context mContext) {
        super(mContext);
        initView();
        initListener();
    }

    public void setPresenter(SubContentContract.Presenter presenter) {
        super.setPresenter(presenter);
        this.mPresenter = (Presenter) presenter;
    }

    private void showScrollDismissLayout() {
        if (this.positionChangeLayout != null) {
            this.positionChangeLayout.setVisibility(8);
        }
        if (!(this.selectPositionInfoTv == null || this.positionInfoTv == null)) {
            this.selectPositionInfoTv.setVisibility(0);
            this.positionInfoTv.setVisibility(8);
        }
        if (this.mapFullScreenContainer != null) {
            this.mapFullScreenContainer.setVisibility(0);
        }
    }

    private void showScrollShowLayout() {
        if (this.positionChangeLayout != null) {
            this.positionChangeLayout.setVisibility(0);
        }
        if (this.selectPositionInfoTv != null) {
            this.selectPositionInfoTv.setVisibility(8);
            this.positionInfoTv.setVisibility(0);
        }
        if (this.mapFullScreenContainer != null) {
            this.mapFullScreenContainer.setVisibility(4);
        }
    }

    private void initView() {
        if (this.rootView != null) {
            this.mainContentLayout = (UgcCustomLinearScrollView) this.rootView.findViewById(C4048R.id.ugc_sub_main_content_layout);
            this.positionChangeLayout = this.rootView.findViewById(C4048R.id.ugc_sub_title_change_position_layout);
            this.scrollLayout = this.rootView.findViewById(C4048R.id.ugc_sub_scroll_layout);
            this.positionInfoTv = (TextView) this.rootView.findViewById(C4048R.id.ugc_sub_title_position_info_tv);
            this.mapComContainer = (ViewGroup) this.rootView.findViewById(C4048R.id.ugc_sub_fade_layer);
            this.mapFullScreenContainer = (ViewGroup) this.rootView.findViewById(C4048R.id.ugc_sub_map_container_layer);
            this.uploadBtn = (Button) this.rootView.findViewById(C4048R.id.ugc_sub_upload_btn);
            this.gobackView = this.rootView.findViewById(C4048R.id.goback_iv);
            this.selectPositionInfoTv = this.rootView.findViewById(C4048R.id.ugc_sub_select_position_info_tv);
            if (this.positionChangeLayout != null) {
                this.positionChangeLayout.setVisibility(0);
            }
            if (this.mapComContainer != null) {
                this.mapComContainer.setVisibility(0);
            }
            if (this.uploadBtn != null) {
                this.uploadBtn.setVisibility(0);
            }
            if (this.gobackView != null) {
                this.gobackView.setVisibility(0);
            }
            if (this.mapFullScreenContainer != null) {
                this.mapFullScreenContainer.setVisibility(4);
            }
        }
    }

    public void initPresenterView() {
        super.initPresenterView();
        if (this.laneLayout != null && this.mPresenter != null && this.mPresenter.isRoadBuild()) {
            this.laneLayout.setVisibility(8);
        }
    }

    private void initListener() {
        if (this.positionChangeLayout != null) {
            this.positionChangeLayout.setOnClickListener(this.clickListener);
        }
        if (this.uploadBtn != null) {
            this.uploadBtn.setOnClickListener(this.clickListener);
        }
        if (this.mainContentLayout != null) {
            this.mainContentLayout.setScrollSupport(true);
            this.mainContentLayout.setOnStatusChangeListener(new C42122());
        }
        if (this.mapComContainer != null) {
            this.mapComContainer.getViewTreeObserver().addOnGlobalLayoutListener(new C42133());
        }
        this.mapComContainer.setOnTouchListener(new C42144());
        if (this.gobackView != null) {
            this.gobackView.setOnTouchListener(new C42155());
        }
    }

    public void showAddrInfoUpdate(String addr, String addrDesc) {
        if (this.positionInfoTv != null) {
            TextView textView = this.positionInfoTv;
            if (TextUtils.isEmpty(addr)) {
                addr = "地图上的点";
            }
            textView.setText(addr);
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

    public void showSelectorPointStatus() {
        hideInputMethod();
        if (this.mainContentLayout != null && this.mainContentLayout.gotoBottom()) {
            showScrollDismissLayout();
            if (this.mPresenter != null) {
                this.mPresenter.hasShowSelectorPointStatus();
            }
        }
    }

    public void showOriginPage() {
        if (this.mainContentLayout != null && this.mainContentLayout.gotoTop()) {
            showScrollShowLayout();
            if (this.mPresenter != null) {
                this.mPresenter.hasShowOriginPage();
            }
        }
    }

    public ViewGroup getMapComPanelContainer() {
        return this.mapComContainer;
    }

    public ViewGroup getMapFullScreenContainer() {
        return this.mapFullScreenContainer;
    }
}
