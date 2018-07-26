package com.baidu.navisdk.module.ugc.ui.innavi.sub;

import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.module.ugc.ui.SubContentContract;
import com.baidu.navisdk.module.ugc.ui.innavi.sub.UgcReportNaviSubDetailContract.Presenter;
import com.baidu.navisdk.module.ugc.ui.innavi.sub.UgcReportNaviSubDetailContract.View;
import com.baidu.navisdk.module.ugc.ui.widget.UgcCustomLinearScrollView;
import com.baidu.navisdk.module.ugc.ui.widget.UgcCustomLinearScrollView.EventCatchListener;
import com.baidu.navisdk.util.common.ScreenUtil;

public class UgcReportNaviSubDetailView extends View {
    private Button cancleUploadBtn = null;
    private Context mContext;
    private int mOrientation;
    private Presenter mPresenter = null;
    private UgcCustomLinearScrollView mainContentView = null;
    private OnClickListener onClickListener = new C42262();
    private TextView positionInfoTv;
    private android.view.View subFadeLayer = null;
    private ImageView subTitleIv = null;
    private android.view.View subUploadLayout = null;
    private android.view.View subUploadSpacing = null;
    private Button uploadBtn = null;

    /* renamed from: com.baidu.navisdk.module.ugc.ui.innavi.sub.UgcReportNaviSubDetailView$1 */
    class C42251 implements EventCatchListener {
        C42251() {
        }

        public void onEventCatch(MotionEvent ev) {
            if (UgcReportNaviSubDetailView.this.mPresenter != null) {
                UgcReportNaviSubDetailView.this.mPresenter.mainContentOnTouch(ev);
            }
            if (UgcReportNaviSubDetailView.this.cancleUploadBtn != null) {
                UgcReportNaviSubDetailView.this.cancleUploadBtn.setText("取消 ");
            }
        }
    }

    /* renamed from: com.baidu.navisdk.module.ugc.ui.innavi.sub.UgcReportNaviSubDetailView$2 */
    class C42262 implements OnClickListener {
        C42262() {
        }

        public void onClick(android.view.View v) {
            if (UgcReportNaviSubDetailView.this.mPresenter != null) {
                switch (v.getId()) {
                    case C4048R.id.ugc_navi_sub_upload_cancle_btn /*1711867194*/:
                        UgcReportNaviSubDetailView.this.mPresenter.simpleUpload();
                        return;
                    case C4048R.id.ugc_navi_sub_upload_btn /*1711867195*/:
                        UgcReportNaviSubDetailView.this.mPresenter.comUpload();
                        return;
                    default:
                        return;
                }
            }
        }
    }

    public UgcReportNaviSubDetailView(Context mContext, int mOrientation) {
        super(mContext, mOrientation);
        this.mContext = mContext;
        this.mOrientation = mOrientation;
        initView(mOrientation);
        initListener();
    }

    public void setPresenter(SubContentContract.Presenter presenter) {
        super.setPresenter(presenter);
        this.mPresenter = (Presenter) presenter;
    }

    private void initListener() {
        if (this.uploadBtn != null) {
            this.uploadBtn.setOnClickListener(this.onClickListener);
        }
        if (this.cancleUploadBtn != null) {
            this.cancleUploadBtn.setOnClickListener(this.onClickListener);
        }
        if (this.mainContentView != null) {
            this.mainContentView.setOnEventCatchListener(new C42251());
        }
    }

    public void showIpoNaviView() {
        if (this.subFadeLayer != null) {
            this.subFadeLayer.setVisibility(0);
            this.subFadeLayer.setBackgroundColor(-16777216);
            this.subFadeLayer.getBackground().setAlpha(66);
            LayoutParams lp = (LayoutParams) this.subFadeLayer.getLayoutParams();
            lp.height = 0;
            lp.weight = 1.0f;
            this.subFadeLayer.setLayoutParams(lp);
        }
        if (this.subUploadSpacing != null) {
            ViewGroup.LayoutParams lp2 = this.subUploadSpacing.getLayoutParams();
            lp2.height = ScreenUtil.getInstance().dip2px(50);
            this.subUploadSpacing.setLayoutParams(lp2);
        }
    }

    private void initView(int mOrientation) {
        if (this.rootView != null) {
            this.subTitleIv = (ImageView) this.rootView.findViewById(C4048R.id.ugc_sub_title_iv);
            this.subUploadSpacing = this.rootView.findViewById(C4048R.id.ugc_navi_sub_upload_spacing);
            this.subUploadLayout = this.rootView.findViewById(C4048R.id.ugc_navi_sub_upload_layout);
            this.subFadeLayer = this.rootView.findViewById(C4048R.id.ugc_navi_sub_fade_layer);
            this.positionInfoTv = (TextView) this.rootView.findViewById(C4048R.id.ugc_sub_title_position_info_tv);
            if (!(this.subUploadSpacing == null || this.subUploadLayout == null || this.subFadeLayer == null)) {
                this.subUploadSpacing.setVisibility(0);
                this.subUploadLayout.setVisibility(0);
                if (mOrientation == 1) {
                    this.subFadeLayer.setVisibility(0);
                } else {
                    this.subFadeLayer.setVisibility(8);
                }
            }
            this.uploadBtn = (Button) this.rootView.findViewById(C4048R.id.ugc_navi_sub_upload_btn);
            this.cancleUploadBtn = (Button) this.rootView.findViewById(C4048R.id.ugc_navi_sub_upload_cancle_btn);
            this.mainContentView = (UgcCustomLinearScrollView) this.rootView.findViewById(C4048R.id.ugc_sub_main_content_layout);
        }
    }

    public void initPresenterView() {
        super.initPresenterView();
    }

    public void showCurTimes(int count) {
        if (this.cancleUploadBtn != null) {
            this.cancleUploadBtn.setText("取消 (" + count + "s)");
        }
    }

    public Context getContext() {
        return this.mContext;
    }

    public int getOrientation() {
        return this.mOrientation;
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

    public void hideSubTitleIv() {
        if (this.subTitleIv != null) {
            this.subTitleIv.setVisibility(8);
        }
    }
}
