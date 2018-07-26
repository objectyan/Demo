package com.baidu.navisdk.module.ugc.ui.innavi.main;

import android.app.Activity;
import android.content.Context;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.module.ugc.ui.innavi.main.UgcReportNaviMainContract.Presenter;
import com.baidu.navisdk.module.ugc.ui.innavi.main.UgcReportNaviMainContract.View;
import com.baidu.navisdk.util.jar.JarUtils;

public class UgcReportNaviMainView implements OnClickListener, View {
    private Button cancleBtn = null;
    private Button closeBtn = null;
    private String closeText = "关闭";
    private Button contentSupBtn = null;
    private ImageView[] dynamicBtnArr = null;
    private android.view.View fadeViewLayout = null;
    private android.view.View mContentView = null;
    private Context mContext;
    private int mOrientation;
    private Presenter mPresenter = null;
    private android.view.View mRootView = null;
    private ViewGroup mRootViewContainer = null;
    private android.view.View mainViewLayout = null;
    private GridView parentItemsGv = null;
    private android.view.View routeGuideView = null;
    private ImageView subItemImageIv = null;
    private TextView subItemTextTv = null;
    private OnClickListener tipsViewClickListnener = new C42202();
    private ImageView uploadItemImagev = null;
    private TextView uploadItemTextv = null;
    private android.view.View uploadViewLayout = null;

    /* renamed from: com.baidu.navisdk.module.ugc.ui.innavi.main.UgcReportNaviMainView$1 */
    class C42191 implements OnTouchListener {
        C42191() {
        }

        public boolean onTouch(android.view.View arg0, MotionEvent arg1) {
            return true;
        }
    }

    /* renamed from: com.baidu.navisdk.module.ugc.ui.innavi.main.UgcReportNaviMainView$2 */
    class C42202 implements OnClickListener {
        C42202() {
        }

        public void onClick(android.view.View v) {
            switch (v.getId()) {
                case C4048R.id.ugc_navi_button_content_fill_bn /*1711867198*/:
                    if (UgcReportNaviMainView.this.mPresenter != null) {
                        UgcReportNaviMainView.this.mPresenter.gotoNaviSubDetailView(false);
                        return;
                    }
                    return;
                case C4048R.id.ugc_navi_button_upload_bn /*1711867199*/:
                    if (UgcReportNaviMainView.this.mPresenter != null) {
                        UgcReportNaviMainView.this.mPresenter.simpleUpload();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    class NaviMainGvAdapter extends BaseAdapter implements OnClickListener {
        private Activity mContext;
        private int mOrientation;
        private Presenter mPresenter;
        OnTouchListener onTouchListener = new C42211();

        /* renamed from: com.baidu.navisdk.module.ugc.ui.innavi.main.UgcReportNaviMainView$NaviMainGvAdapter$1 */
        class C42211 implements OnTouchListener {
            C42211() {
            }

            public boolean onTouch(android.view.View v, MotionEvent event) {
                ImageView imgView = ((ViewHolder) v.getTag()).mChildIView;
                if (imgView != null) {
                    Drawable drawable;
                    if (event.getAction() == 0) {
                        drawable = imgView.getBackground();
                        if (drawable != null) {
                            drawable.setColorFilter(-7829368, Mode.MULTIPLY);
                        }
                    } else if (event.getAction() == 1 || event.getAction() == 3) {
                        drawable = imgView.getBackground();
                        if (drawable != null) {
                            drawable.clearColorFilter();
                        }
                    }
                }
                return false;
            }
        }

        class ViewHolder {
            public ImageView mChildIView;
            public TextView mChildName;
            public int position;

            ViewHolder() {
            }
        }

        public NaviMainGvAdapter(Presenter mPresenter, Activity mContext, int orient) {
            this.mContext = mContext;
            this.mPresenter = mPresenter;
            this.mOrientation = orient;
        }

        public int getCount() {
            if (this.mPresenter == null) {
                return 0;
            }
            return this.mPresenter.parentItemsGvSize();
        }

        public android.view.View getView(int position, android.view.View convertView, ViewGroup parent) {
            ViewHolder holder;
            if (convertView == null) {
                if (this.mOrientation == 1) {
                    convertView = JarUtils.inflate(this.mContext, C4048R.layout.nsdk_layout_ugc_report_child_gride_item, null);
                } else {
                    convertView = JarUtils.inflate(this.mContext, C4048R.layout.nsdk_layout_ugc_report_child_gride_item_land, null);
                }
                if (convertView == null) {
                    return null;
                }
                holder = new ViewHolder();
                holder.mChildIView = (ImageView) convertView.findViewById(C4048R.id.ugc_report_child_iview);
                holder.mChildName = (TextView) convertView.findViewById(C4048R.id.ugc_report_child_tview);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            holder.position = position;
            if (convertView != null) {
                convertView.setOnTouchListener(this.onTouchListener);
            }
            convertView.setOnClickListener(this);
            this.mPresenter.parentItemsGvImageLoader(position, holder.mChildIView);
            holder.mChildName.setText(this.mPresenter.getParentItemsGvTextTile(position));
            return convertView;
        }

        public void onClick(android.view.View v) {
            try {
                ViewHolder mViewHolder = (ViewHolder) v.getTag();
                if (this.mPresenter != null) {
                    this.mPresenter.gotoUploadView(mViewHolder.position, false);
                }
            } catch (Exception e) {
            }
        }

        public Object getItem(int position) {
            return null;
        }

        public long getItemId(int position) {
            return 0;
        }
    }

    public UgcReportNaviMainView(Context mContext, int mOrientation) {
        this.mContext = mContext;
        this.mOrientation = mOrientation;
        initView(mContext, mOrientation);
        initListener();
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    private void initView(Context mContext, int mOrientation) {
        if (mContext != null) {
            this.mContext = mContext;
            if (mOrientation == 1) {
                this.mRootView = JarUtils.inflate((Activity) mContext, C4048R.layout.nsdk_layout_ugc_report_navi_main_view, null);
            } else {
                this.mRootView = JarUtils.inflate((Activity) mContext, C4048R.layout.nsdk_layout_ugc_report_navi_main_view_land, null);
            }
            if (this.mRootView != null) {
                this.mContentView = this.mRootView.findViewById(C4048R.id.ugc_map_navi_content);
                this.parentItemsGv = (GridView) this.mRootView.findViewById(C4048R.id.ugc_map_navi_allitems_gv);
                this.dynamicBtnArr = new ImageView[2];
                this.dynamicBtnArr[0] = (ImageView) this.mRootView.findViewById(C4048R.id.ugc_map_navi_dynamic_btn1);
                this.dynamicBtnArr[1] = (ImageView) this.mRootView.findViewById(C4048R.id.ugc_map_navi_dynamic_btn2);
                this.cancleBtn = (Button) this.mRootView.findViewById(C4048R.id.ugc_map_navi_cancle_btn);
                this.routeGuideView = this.mRootView.findViewById(C4048R.id.ugc_map_navi_title_common_bar);
            }
        }
    }

    private void initListener() {
        if (this.cancleBtn != null) {
            this.cancleBtn.setOnClickListener(this);
        }
        if (this.mContentView != null) {
            this.mContentView.setOnTouchListener(new C42191());
        }
    }

    public ViewGroup getParentContainer() {
        if (this.mRootViewContainer != null) {
            return this.mRootViewContainer;
        }
        if (this.mRootView == null || this.mRootView.getParent() == null) {
            return null;
        }
        return (ViewGroup) this.mRootView.getParent();
    }

    public android.view.View getParentView() {
        return this.mRootView;
    }

    public void setPresenter(Presenter presenter) {
        this.mPresenter = presenter;
    }

    public void initPresenterView() {
        if (this.mPresenter != null) {
            if (this.parentItemsGv != null) {
                this.parentItemsGv.setAdapter(new NaviMainGvAdapter(this.mPresenter, (Activity) this.mContext, this.mOrientation));
            }
            if (this.mPresenter.getDynamicItemsSize() == 0) {
                if (!(this.dynamicBtnArr[0] == null || this.dynamicBtnArr[1] == null)) {
                    ((android.view.View) this.dynamicBtnArr[0].getParent()).setVisibility(8);
                    ((android.view.View) this.dynamicBtnArr[1].getParent()).setVisibility(8);
                }
            } else if (this.mPresenter.getDynamicItemsSize() == 1) {
                if ("缺路".endsWith(this.mPresenter.getParentItemsGvTextTile(0))) {
                    if (this.dynamicBtnArr[1] != null) {
                        ((android.view.View) this.dynamicBtnArr[1].getParent()).setVisibility(8);
                    }
                } else if (this.dynamicBtnArr[0] != null) {
                    this.dynamicBtnArr[0].setVisibility(8);
                    ((android.view.View) this.dynamicBtnArr[0].getParent()).setVisibility(8);
                }
            }
            if (this.dynamicBtnArr[0] != null && this.dynamicBtnArr[1] != null) {
                this.dynamicBtnArr[0].setOnClickListener(this);
                this.dynamicBtnArr[1].setOnClickListener(this);
            }
        }
    }

    public void showIpoView() {
        if (this.routeGuideView != null) {
            this.routeGuideView.setBackgroundColor(17170444);
            this.routeGuideView.getBackground().setAlpha(66);
        }
    }

    public void showUploadCountDownView() {
        if (this.mainViewLayout != null) {
            this.mainViewLayout.setVisibility(8);
        }
        if (this.uploadViewLayout != null) {
            this.uploadViewLayout.setVisibility(0);
        }
    }

    public void showCurTimes(int count) {
        if (this.closeBtn != null) {
            this.closeBtn.setText(this.closeText + "(" + count + "s)");
        }
    }

    public void onClick(android.view.View v) {
        if (this.mPresenter != null) {
            switch (v.getId()) {
                case C4048R.id.ugc_map_navi_dynamic_btn1 /*1711867125*/:
                    this.mPresenter.gotoUploadView(0, true);
                    return;
                case C4048R.id.ugc_map_navi_dynamic_btn2 /*1711867126*/:
                    if (this.dynamicBtnArr[0] == null || this.dynamicBtnArr[0].getVisibility() != 8) {
                        this.mPresenter.gotoUploadView(1, true);
                        return;
                    } else {
                        this.mPresenter.gotoUploadView(0, true);
                        return;
                    }
                case C4048R.id.ugc_map_navi_cancle_btn /*1711867128*/:
                    this.mPresenter.finish();
                    return;
                default:
                    return;
            }
        }
    }

    public Context getContext() {
        return this.mContext;
    }

    public void initUploadView() {
        if (this.mRootView != null && this.mContext != null && this.mPresenter != null) {
            android.view.View convertView;
            this.mRootViewContainer = (ViewGroup) this.mRootView.getParent();
            if (this.mOrientation == 1) {
                convertView = JarUtils.inflate((Activity) this.mContext, C4048R.layout.nsdk_layout_ugc_report_sub_tips_view, null);
            } else {
                convertView = JarUtils.inflate((Activity) this.mContext, C4048R.layout.nsdk_layout_ugc_report_sub_tips_view_land, null);
            }
            if (!(this.mRootViewContainer == null || convertView == null)) {
                this.mRootViewContainer.removeAllViews();
                this.mRootViewContainer.addView(convertView, new LayoutParams(-1, -1));
            }
            this.closeBtn = (Button) convertView.findViewById(C4048R.id.ugc_navi_button_upload_bn);
            this.contentSupBtn = (Button) convertView.findViewById(C4048R.id.ugc_navi_button_content_fill_bn);
            this.subItemImageIv = (ImageView) convertView.findViewById(C4048R.id.ugc_sub_title_iv);
            this.subItemTextTv = (TextView) convertView.findViewById(C4048R.id.ugc_sub_title_type_tv);
            if (!(this.closeBtn == null || this.contentSupBtn == null)) {
                this.closeBtn.setOnClickListener(this.tipsViewClickListnener);
                this.contentSupBtn.setOnClickListener(this.tipsViewClickListnener);
                if (this.mPresenter.getIsTipsDynamic()) {
                    this.closeText = "稍后补充";
                } else {
                    this.closeText = "立即上报";
                }
            }
            if (this.subItemTextTv != null && this.subItemImageIv != null) {
                this.subItemTextTv.setText(this.mPresenter.getUploadTipsTextTitle());
                this.mPresenter.parentTipsItemsGvImageLoader(this.subItemImageIv);
            }
        }
    }

    public void hideTipItemIv() {
        if (this.subItemImageIv != null) {
            this.subItemImageIv.setVisibility(8);
        }
    }
}
