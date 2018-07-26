package com.baidu.navisdk.ui.ugc.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.module.ugc.ui.widget.TwoStateScrollView.DragState;
import com.baidu.navisdk.module.ugc.ui.widget.TwoStateScrollView.OnStatusChangeListener;
import com.baidu.navisdk.module.ugc.utils.UgcImageLoaderUtils;
import com.baidu.navisdk.ui.ugc.adapter.UgcDetailsAdapter;
import com.baidu.navisdk.ui.ugc.adapter.UgcDetailsAdapter.CommentsLoadingState;
import com.baidu.navisdk.ui.ugc.adapter.UgcDetailsAdapter.ImgDisplay;
import com.baidu.navisdk.ui.ugc.control.BNRCEventDetailsViewController;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.ui.util.UIUtils;
import com.baidu.navisdk.ui.widget.BNLoadingViewProxy.ViewActionListener;
import com.baidu.navisdk.ui.widget.ptrrecyclerview.PullToRefreshRecyclerView;
import com.baidu.navisdk.ui.widget.ptrrecyclerview.PullToRefreshRecyclerView.PagingableListener;
import com.baidu.navisdk.ui.widget.ptrrecyclerview.footer.loadmore.BaseLoadMoreView;
import com.baidu.navisdk.ui.widget.ptrrecyclerview.footer.loadmore.BaseLoadMoreView.OnDrawListener;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.NetworkUtils;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.drawable.UrlDrawableContainIView;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.navisdk.util.statistic.userop.UserOPController;
import com.baidu.navisdk.util.statistic.userop.UserOPParams;
import com.baidu.navisdk.util.worker.BNWorkerCenter;
import com.baidu.navisdk.util.worker.BNWorkerConfig;
import com.baidu.navisdk.util.worker.BNWorkerNormalTask;

public class BNRCEventDetailsView implements OnClickListener {
    private static final String TAG = "BNRCEventDetailsView";
    private View awayFromSpacing;
    private TextView awayFromTv;
    private View backContainer;
    private View bgContainer;
    private Bitmap bitmap;
    private boolean commentsPtrListInited;
    private View contentView;
    private View eventDescriptionLayout;
    private TextView eventPortraitIV;
    private TextView eventReporterCountsTV;
    private TextView eventReporterLevelTV;
    private View eventSubLayout;
    private View eventSubLayoutDivider;
    private TextView eventSubTv1;
    private TextView eventSubTv2;
    private ImageView icEventType;
    private ImageView imgThumbnail;
    private ImageView imgZoomIv;
    private View imgZoomViewContainer;
    private ViewGroup mCommentsLoadingFooterContainer;
    private ViewActionListener mCommentsLoadingListener;
    private View mCommentsPtrBg;
    private PullToRefreshRecyclerView mCommentsPtrList;
    private BNRCEventDetailsViewController mController;
    private DragState mCurState;
    private BNWorkerNormalTask<String, String> mEnablePullRunnable;
    private int mOrientation;
    private ViewActionListener mOutlineLoadingListener;
    private UgcDetailsAdapter mUgcDetailsAdapter;
    private UgcRCEventCallback mUgcRCEventCallback;
    private ViewGroup outlineLoadingContainer;
    private View outlineViewContainer;
    private ViewGroup outlineViewContainerOuter;
    private TextView roadNameTv;
    private View rootView;
    private boolean scrollViewInited;
    private TextView timeIntervalTv;
    private View titleContainer;
    private TextView tvEventDescription;
    private TextView tvEventReporter;
    private TextView tvEventTimeStamp;
    private TextView tvEventType;
    private TextView tvUseful;
    private TextView tvUseless;
    private View userInfoLayout;
    private View vAvoidCongestion;
    private View vAvoidCongestionDivider;
    private View vUseful;
    private View vUseless;

    public interface UgcRCEventCallback {
        void onFinish();

        void onShowUserINfo(String str);
    }

    /* renamed from: com.baidu.navisdk.ui.ugc.view.BNRCEventDetailsView$2 */
    class C45062 implements ViewActionListener {
        C45062() {
        }

        public void onAction(int actionType) {
            switch (actionType) {
                case 1:
                    LogUtil.m15791e(BNRCEventDetailsView.TAG, "mOutlineLoadingListener: --> ACTION_RETRY");
                    BNRCEventDetailsView.this.initOutlineData();
                    return;
                default:
                    return;
            }
        }
    }

    /* renamed from: com.baidu.navisdk.ui.ugc.view.BNRCEventDetailsView$3 */
    class C45073 implements ViewActionListener {
        C45073() {
        }

        public void onAction(int actionType) {
            switch (actionType) {
                case 1:
                    LogUtil.m15791e(BNRCEventDetailsView.TAG, "mCommentsLoadingListener: --> ACTION_RETRY");
                    BNRCEventDetailsView.this.initCommentsData();
                    return;
                default:
                    return;
            }
        }
    }

    /* renamed from: com.baidu.navisdk.ui.ugc.view.BNRCEventDetailsView$4 */
    class C45084 implements OnGlobalLayoutListener {
        C45084() {
        }

        public void onGlobalLayout() {
            LogUtil.m15791e(BNRCEventDetailsView.TAG, "onGlobalLayout: outlineViewContainer --> " + BNRCEventDetailsView.this.outlineViewContainer + ", scrollViewInited: " + BNRCEventDetailsView.this.scrollViewInited);
            if (BNRCEventDetailsView.this.outlineViewContainer != null && !BNRCEventDetailsView.this.scrollViewInited) {
                int persistantHeight = BNRCEventDetailsView.this.outlineViewContainer.getMeasuredHeight();
                BNRCEventDetailsView.this.initCommentsList();
                if (BNRCEventDetailsView.this.mCommentsPtrList != null) {
                    int totalHeight = BNRCEventDetailsView.this.bgContainer.getMeasuredHeight() - BNRCEventDetailsView.this.mCommentsPtrList.getTopMargin();
                    BNRCEventDetailsView.this.mCommentsPtrList.setHeights(persistantHeight, totalHeight);
                    int remainHeight = totalHeight - persistantHeight;
                    int minHpx = ScreenUtil.getInstance().dip2px(161);
                    UgcDetailsAdapter access$700 = BNRCEventDetailsView.this.mUgcDetailsAdapter;
                    if (remainHeight >= minHpx) {
                        minHpx = remainHeight;
                    }
                    access$700.setLoadingStateHeight(minHpx);
                    BNRCEventDetailsView.this.mUgcDetailsAdapter.setData(BNRCEventDetailsView.this.mController.getModel().getComments());
                    BNRCEventDetailsView.this.mUgcDetailsAdapter.notifyDataSetChanged();
                    BNRCEventDetailsView.this.scrollViewInited = BNRCEventDetailsView.this.mCommentsPtrList.goToBottom(2);
                    LogUtil.m15791e(BNRCEventDetailsView.TAG, "onGlobalLayout: mTwoStateScrollView initiated --> " + BNRCEventDetailsView.this.scrollViewInited);
                }
                if (BNRCEventDetailsView.this.outlineViewContainerOuter != null && VERSION.SDK_INT >= 16) {
                    BNRCEventDetailsView.this.outlineViewContainerOuter.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                }
            }
        }
    }

    /* renamed from: com.baidu.navisdk.ui.ugc.view.BNRCEventDetailsView$5 */
    class C45095 implements OnStatusChangeListener {
        C45095() {
        }

        public void onStatusChange(DragState state) {
            LogUtil.m15791e(BNRCEventDetailsView.TAG, "onStatusChange: --> mCurState: " + BNRCEventDetailsView.this.mCurState + ", state: " + state);
            if (BNRCEventDetailsView.this.mCurState != state) {
                BNRCEventDetailsView.this.mCurState = state;
                if (state != DragState.BOTTOM) {
                    BNRCEventDetailsView.this.loadComments();
                }
            }
        }
    }

    /* renamed from: com.baidu.navisdk.ui.ugc.view.BNRCEventDetailsView$6 */
    class C45106 implements PagingableListener {
        C45106() {
        }

        public void onLoadMoreItems() {
            LogUtil.m15791e(BNRCEventDetailsView.TAG, "onLoadMoreItems:  --> ");
            if (LogUtil.LOGGABLE) {
                Toast.makeText(BNRCEventDetailsView.this.mController.getContext(), "onLoadMoreItems", 0).show();
            }
            UserOPController.getInstance().add(UserOPParams.GUIDE_3_u_2_2, null, null, null);
            BNRCEventDetailsView.this.mController.asyncGetCommentsData();
        }
    }

    /* renamed from: com.baidu.navisdk.ui.ugc.view.BNRCEventDetailsView$7 */
    class C45117 implements OnDrawListener {
        C45117() {
        }

        public boolean onDrawLoadMore(Canvas c, RecyclerView parent) {
            if (BNRCEventDetailsView.this.mCommentsLoadingFooterContainer.getChildCount() == 0) {
                View loading = null;
                if (BNRCEventDetailsViewController.getInstance().getLoadingProxy() != null) {
                    loading = BNRCEventDetailsViewController.getInstance().getLoadingProxy().getLoadingView();
                }
                if (loading != null) {
                    if (loading.getParent() != null && (loading.getParent() instanceof ViewGroup)) {
                        ((ViewGroup) loading.getParent()).removeView(loading);
                    }
                    BNRCEventDetailsView.this.mCommentsLoadingFooterContainer.addView(loading, new LayoutParams(-1, -1));
                }
            }
            BNRCEventDetailsView.this.mCommentsLoadingFooterContainer.setVisibility(0);
            return false;
        }
    }

    /* renamed from: com.baidu.navisdk.ui.ugc.view.BNRCEventDetailsView$8 */
    class C45128 implements ImgDisplay {
        C45128() {
        }

        public void showZoomedOutImg(boolean show, String url) {
            BNRCEventDetailsView.this.showImgZoomView(show, url);
        }
    }

    /* renamed from: com.baidu.navisdk.ui.ugc.view.BNRCEventDetailsView$9 */
    class C45139 implements OnTouchListener {
        C45139() {
        }

        public boolean onTouch(View v, MotionEvent event) {
            LogUtil.m15791e(BNRCEventDetailsView.TAG, "onTouch: action --> " + event.getAction());
            if (event.getAction() == 1) {
                BNRCEventDetailsView.this.usefulOrUselessClicked(true);
            }
            if (event.getAction() == 1 || event.getAction() == 0) {
                return true;
            }
            return false;
        }
    }

    public BNRCEventDetailsView(Context context, UgcRCEventCallback ugcRCEventCallback) {
        this(context, ugcRCEventCallback, 1);
    }

    public BNRCEventDetailsView(Context context, UgcRCEventCallback ugcRCEventCallback, int mOrientation) {
        this.mController = BNRCEventDetailsViewController.getInstance();
        this.rootView = null;
        this.mCommentsPtrList = null;
        this.commentsPtrListInited = false;
        this.vAvoidCongestion = null;
        this.userInfoLayout = null;
        this.eventPortraitIV = null;
        this.eventReporterLevelTV = null;
        this.eventReporterCountsTV = null;
        this.eventSubLayout = null;
        this.eventSubTv1 = null;
        this.eventSubTv2 = null;
        this.eventSubLayoutDivider = null;
        this.roadNameTv = null;
        this.awayFromTv = null;
        this.timeIntervalTv = null;
        this.awayFromSpacing = null;
        this.contentView = null;
        this.eventDescriptionLayout = null;
        this.mUgcRCEventCallback = null;
        this.mOrientation = 2;
        this.mCurState = DragState.BOTTOM;
        this.scrollViewInited = false;
        this.mEnablePullRunnable = new BNWorkerNormalTask<String, String>("BNRCEventDetailsView-EnablePullTask", null) {
            protected String execute() {
                if (BNRCEventDetailsView.this.mCommentsPtrList != null) {
                    BNRCEventDetailsView.this.mCommentsPtrList.setScrollSupport(true);
                    BNRCEventDetailsView.this.mCommentsPtrList.onFinishLoading(true, false);
                }
                return null;
            }
        };
        this.mOutlineLoadingListener = new C45062();
        this.mCommentsLoadingListener = new C45073();
        this.mOrientation = mOrientation;
        this.mUgcRCEventCallback = ugcRCEventCallback;
        initViews(context);
    }

    private void initViews(Context context) {
        if (context != null) {
            try {
                this.rootView = JarUtils.inflate((Activity) context, C4048R.layout.nsdk_layout_ugc_details_view, null);
                if (this.rootView != null) {
                    this.titleContainer = this.rootView.findViewById(C4048R.id.title_container);
                    this.backContainer = this.rootView.findViewById(C4048R.id.back_container);
                    this.bgContainer = this.rootView.findViewById(C4048R.id.ugc_rc_details_bg);
                    this.outlineLoadingContainer = (ViewGroup) this.rootView.findViewById(C4048R.id.contents_loading_state_container);
                    this.imgZoomViewContainer = this.rootView.findViewById(C4048R.id.ugc_rc_details_view_image);
                    this.outlineViewContainerOuter = (ViewGroup) this.rootView.findViewById(C4048R.id.outline_container_outer);
                    this.mCommentsPtrBg = this.rootView.findViewById(C4048R.id.ugc_comments_listview_bg);
                    this.mCommentsLoadingFooterContainer = (ViewGroup) this.rootView.findViewById(C4048R.id.ugc_comments_loading_footer_container);
                    this.imgZoomIv = (ImageView) this.rootView.findViewById(C4048R.id.img_full_screen_iv);
                    this.mCommentsPtrList = (PullToRefreshRecyclerView) this.rootView.findViewById(C4048R.id.ugc_comments_listview);
                    this.titleContainer.setVisibility(8);
                    initListeners();
                    initOutlineData();
                }
            } catch (Throwable th) {
                this.rootView = null;
            }
        }
    }

    private void imgThumbnailButtonClick() {
        if (this.imgThumbnail != null) {
            this.imgThumbnail.performClick();
        }
    }

    private void loadingStart(int type) {
        LogUtil.m15791e(TAG, "loadingStart: type --> " + type);
        switch (type) {
            case 1:
                if (this.outlineLoadingContainer != null) {
                    this.outlineLoadingContainer.setVisibility(0);
                }
                if (this.mController.getLoadingProxy() != null) {
                    this.mController.getLoadingProxy().onLoadingStart(2, this.outlineLoadingContainer);
                    return;
                }
                return;
            case 3:
                if (this.mUgcDetailsAdapter != null) {
                    this.mUgcDetailsAdapter.setCommentsLoadingState(CommentsLoadingState.LOADING);
                    this.mUgcDetailsAdapter.notifyDataSetChanged();
                    return;
                }
                return;
            default:
                if (this.mController.getLoadingProxy() != null) {
                    this.mController.getLoadingProxy().onLoadingStart(1, null);
                    return;
                }
                return;
        }
    }

    public void loadingEnd(int type, String errorStr, boolean suc) {
        LogUtil.m15791e(TAG, "loadingEnd: --> type: " + type + ", suc: " + suc + ", err: " + errorStr);
        switch (type) {
            case 1:
                if (suc) {
                    if (this.mController.getLoadingProxy() != null) {
                        this.mController.getLoadingProxy().onLoadingEnd(2, suc, this.outlineLoadingContainer, null);
                    }
                    if (this.outlineLoadingContainer != null) {
                        this.outlineLoadingContainer.setVisibility(8);
                        return;
                    }
                    return;
                } else if (this.mController.getLoadingProxy() != null) {
                    this.mController.getLoadingProxy().onLoadingEnd(2, suc, this.outlineLoadingContainer, this.mOutlineLoadingListener);
                    return;
                } else {
                    return;
                }
            case 3:
                if (!suc) {
                    if (this.mController.getModel().getCommentsLength() == 0) {
                        this.commentsPtrListInited = false;
                        this.mUgcDetailsAdapter.setCommentsLoadingState(CommentsLoadingState.LOADING);
                        this.mUgcDetailsAdapter.notifyDataSetChanged();
                        if (this.mController.getLoadingProxy() != null) {
                            this.mController.getLoadingProxy().onLoadingEnd(2, suc, null, this.mCommentsLoadingListener);
                            return;
                        }
                        return;
                    }
                    TipTool.onCreateToastDialog(this.mController.getContext(), errorStr);
                    if (this.mCommentsPtrList != null) {
                        this.mCommentsPtrList.onFinishLoading(false, false);
                        this.mCommentsPtrList.setScrollSupport(false);
                    }
                    BNWorkerCenter.getInstance().cancelTask(this.mEnablePullRunnable, false);
                    BNWorkerCenter.getInstance().submitMainThreadTaskDelay(this.mEnablePullRunnable, new BNWorkerConfig(2, 0), 500);
                    return;
                }
                return;
            default:
                if (this.mController.getLoadingProxy() != null) {
                    this.mController.getLoadingProxy().onLoadingEnd(1, suc, null, null);
                }
                TipTool.onCreateToastDialog(this.mController.getContext(), errorStr);
                return;
        }
    }

    private void initListeners() {
        if (this.bgContainer != null) {
            this.bgContainer.setOnClickListener(this);
        }
        if (this.backContainer != null) {
            this.backContainer.setOnClickListener(this);
        }
        if (this.titleContainer != null) {
            this.titleContainer.setOnClickListener(this);
        }
        if (this.outlineLoadingContainer != null) {
            this.outlineLoadingContainer.setOnClickListener(this);
        }
        if (this.outlineViewContainerOuter != null) {
            this.outlineViewContainerOuter.getViewTreeObserver().addOnGlobalLayoutListener(new C45084());
        }
        if (this.mCommentsPtrList != null) {
            this.mCommentsPtrList.setOnStatusChangeListener(new C45095());
        }
    }

    private void initOutlineData() {
        if (!this.mController.asyncGetRCEventDetailsData()) {
            loadingStart(1);
            this.mController.initOutlineDataBuild();
        }
    }

    private void initCommentsData() {
        if (!this.commentsPtrListInited && !this.mController.asyncGetCommentsData()) {
            this.commentsPtrListInited = true;
            loadingStart(3);
            this.mController.initCommentsDataBuild();
        }
    }

    private void initCommentsList() {
        if (this.mUgcDetailsAdapter == null) {
            this.mCommentsPtrList.setNeedStatusChangeAlways(true);
            this.mCommentsPtrList.setScrollSupport(true);
            switch (this.mController.getSource()) {
                case 1:
                case 3:
                case 4:
                    this.mCommentsPtrList.setTitleContainer(null, 0);
                    this.mCommentsPtrList.setTitleAnimEnabled(false);
                    if (this.mOrientation != 1) {
                        this.mCommentsPtrList.setTopMargin(0);
                        break;
                    }
                    this.mCommentsPtrList.setTopMargin(JarUtils.getResources().getDimensionPixelOffset(C4048R.dimen.nsdk_rg_top_panel_height));
                    break;
                case 2:
                    this.mCommentsPtrList.setTitleContainer(null, 0);
                    this.mCommentsPtrList.setTitleAnimEnabled(false);
                    this.mCommentsPtrList.setTopMargin(0);
                    break;
                default:
                    this.titleContainer.setVisibility(0);
                    this.mCommentsPtrList.setTopMargin(JarUtils.getResources().getDimensionPixelOffset(C4048R.dimen.nsdk_ugc_details_title_height));
                    this.mCommentsPtrList.setTitleContainer(this.titleContainer, (int) (((double) ScreenUtil.getInstance().getHeightPixels()) / 3.0d));
                    this.mCommentsPtrList.setTitleAnimEnabled(true);
                    break;
            }
            this.mCommentsPtrList.setViewBg(this.mCommentsPtrBg);
            this.mCommentsPtrList.setEnableBg(true);
            this.mCommentsPtrList.setSwipeEnable(true);
            this.mCommentsPtrList.setLayoutManager(new LinearLayoutManager(this.mController.getContext()));
            this.mCommentsPtrList.setPagingableListener(new C45106());
            BaseLoadMoreView loadMoreView = new BaseLoadMoreView(this.mController.getContext(), this.mCommentsPtrList.getRecyclerView());
            loadMoreView.setLoadMorePadding(JarUtils.getResources().getDimensionPixelOffset(C4048R.dimen.nsdk_ugc_detail_loading_footer_height));
            this.mCommentsPtrList.setLoadMoreFooter(loadMoreView);
            this.mCommentsPtrList.getLoadMoreFooter().setOnDrawListener(new C45117());
            this.mUgcDetailsAdapter = new UgcDetailsAdapter(this.mController.getContext());
            this.mUgcDetailsAdapter.setImgDisplay(new C45128());
            this.mUgcDetailsAdapter.setShowNoMoreCommentsFooter(false);
            if (this.outlineViewContainer.getParent() != null && (this.outlineViewContainer.getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.outlineViewContainer.getParent()).removeView(this.outlineViewContainer);
            }
            this.mUgcDetailsAdapter.setOutlineView(this.outlineViewContainer);
            this.mCommentsPtrList.setAdapter(this.mUgcDetailsAdapter);
            this.mCommentsPtrList.setVisibility(0);
        }
    }

    private void loadComments() {
        int a = 1;
        if (this.mController.getSource() == 1) {
            a = 2;
        } else if (this.mController.getSource() == 2) {
            a = 3;
        }
        UserOPController.getInstance().add(UserOPParams.GUIDE_3_u_2_1, "" + a, null, null);
        this.mController.stopTimer();
        initCommentsData();
        if (this.mCommentsPtrList != null) {
            this.mCommentsPtrList.setSwipeEnable(true);
        }
    }

    public void onOutlineDataSetChanged() {
        LogUtil.m15791e(TAG, "onOutlineDataSetChanged: --> start");
        initOutlineView();
        updateOutlineView();
        LogUtil.m15791e(TAG, "onOutlineDataSetChanged: --> end");
    }

    public void initOutlineView() {
        if (this.outlineViewContainerOuter == null) {
            LogUtil.m15791e(TAG, "initOutlineView: --> outlineViewContainerOuter = null");
            return;
        }
        this.outlineViewContainer = JarUtils.inflate((Activity) this.mController.getContext(), C4048R.layout.nsdk_layout_ugc_detail_outline, null);
        if (this.outlineViewContainer == null) {
            LogUtil.m15791e(TAG, "initOutlineView: --> inflate fail");
            if (this.mController != null) {
                this.mController.onDestroy();
            }
            if (this.rootView != null) {
                this.rootView.setVisibility(8);
                return;
            }
            return;
        }
        this.imgThumbnail = (ImageView) this.outlineViewContainer.findViewById(C4048R.id.img_thumbnail);
        this.icEventType = (ImageView) this.outlineViewContainer.findViewById(C4048R.id.ic_event_type);
        this.tvEventType = (TextView) this.outlineViewContainer.findViewById(C4048R.id.tv_event_type);
        this.tvEventTimeStamp = (TextView) this.outlineViewContainer.findViewById(C4048R.id.tv_event_time_stamp);
        this.tvEventDescription = (TextView) this.outlineViewContainer.findViewById(C4048R.id.tv_event_description);
        this.tvEventReporter = (TextView) this.outlineViewContainer.findViewById(C4048R.id.tv_event_reporter);
        this.vUseful = this.outlineViewContainer.findViewById(C4048R.id.view_useful);
        this.tvUseful = (TextView) this.outlineViewContainer.findViewById(C4048R.id.tv_useful);
        this.vUseless = this.outlineViewContainer.findViewById(C4048R.id.view_useless);
        this.tvUseless = (TextView) this.outlineViewContainer.findViewById(C4048R.id.tv_useless);
        this.vAvoidCongestion = this.outlineViewContainer.findViewById(C4048R.id.view_avoid_congestion);
        this.vAvoidCongestionDivider = this.outlineViewContainer.findViewById(C4048R.id.avoid_congestion_divider);
        this.userInfoLayout = this.outlineViewContainer.findViewById(C4048R.id.layout_event_user_info);
        this.eventPortraitIV = (TextView) this.outlineViewContainer.findViewById(C4048R.id.iv_event_portrait);
        this.eventReporterLevelTV = (TextView) this.outlineViewContainer.findViewById(C4048R.id.tv_event_reporter_level);
        this.eventReporterCountsTV = (TextView) this.outlineViewContainer.findViewById(C4048R.id.tv_event_reporter_counts);
        this.awayFromSpacing = this.outlineViewContainer.findViewById(C4048R.id.tv_event_distance_spacing);
        this.eventSubLayout = this.outlineViewContainer.findViewById(C4048R.id.tv_event_sub_layout);
        this.eventSubLayoutDivider = this.outlineViewContainer.findViewById(C4048R.id.label_divider);
        this.eventSubTv1 = (TextView) this.outlineViewContainer.findViewById(C4048R.id.tv_event_sub_type1);
        this.eventSubTv2 = (TextView) this.outlineViewContainer.findViewById(C4048R.id.tv_event_sub_type2);
        this.roadNameTv = (TextView) this.outlineViewContainer.findViewById(C4048R.id.tv_event_address);
        this.awayFromTv = (TextView) this.outlineViewContainer.findViewById(C4048R.id.tv_event_distance);
        this.timeIntervalTv = (TextView) this.outlineViewContainer.findViewById(C4048R.id.tv_event_description_time);
        this.contentView = this.outlineViewContainer.findViewById(C4048R.id.ugc_event_details_content_layout);
        this.eventDescriptionLayout = this.outlineViewContainer.findViewById(C4048R.id.event_discription_layout);
        this.outlineViewContainerOuter.addView(this.outlineViewContainer, new LayoutParams(-1, -2));
        this.outlineViewContainerOuter.setVisibility(0);
        if (this.imgThumbnail != null) {
            this.imgThumbnail.setClickable(false);
        }
        if (!(this.vAvoidCongestion == null || this.vAvoidCongestionDivider == null)) {
            switch (BNRCEventDetailsViewController.getInstance().getSource()) {
                case 3:
                case 4:
                    this.vAvoidCongestion.setVisibility(0);
                    this.vAvoidCongestionDivider.setVisibility(0);
                    break;
                default:
                    this.vAvoidCongestion.setVisibility(8);
                    this.vAvoidCongestionDivider.setVisibility(8);
                    break;
            }
        }
        if (this.imgThumbnail != null) {
            this.imgThumbnail.setOnClickListener(this);
        }
        if (this.vUseful != null) {
            this.vUseful.setOnTouchListener(new C45139());
        }
        if (this.vUseless != null) {
            this.vUseless.setOnTouchListener(new OnTouchListener() {
                public boolean onTouch(View v, MotionEvent event) {
                    LogUtil.m15791e(BNRCEventDetailsView.TAG, "onTouch: action --> " + event.getAction());
                    if (event.getAction() == 1) {
                        BNRCEventDetailsView.this.usefulOrUselessClicked(false);
                    }
                    if (event.getAction() == 1 || event.getAction() == 0) {
                        return true;
                    }
                    return false;
                }
            });
        }
        if (this.userInfoLayout != null) {
            this.userInfoLayout.setOnClickListener(this);
        }
        if (this.vAvoidCongestion != null) {
            this.vAvoidCongestion.setOnClickListener(this);
        }
        if (this.outlineViewContainer != null) {
            this.outlineViewContainer.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    if (BNRCEventDetailsView.this.mCommentsPtrList != null) {
                        BNRCEventDetailsView.this.mCommentsPtrList.goToTop();
                        BNRCEventDetailsView.this.loadComments();
                    }
                }
            });
        }
    }

    public void updateOutlineView() {
        if (this.imgThumbnail != null) {
            if (TextUtils.isEmpty(this.mController.getModel().getEventPic())) {
                this.imgThumbnail.setVisibility(8);
            } else {
                this.imgThumbnail.setClickable(false);
                UrlDrawableContainIView.getDrawable(this.mController.getModel().getEventPic(), C4048R.drawable.nsdk_rc_img_default_bg, this.imgThumbnail, new Handler(Looper.getMainLooper()) {
                    public void handleMessage(Message msg) {
                        super.handleMessage(msg);
                        if (msg.what != 8192) {
                            return;
                        }
                        if (msg.arg1 == 0) {
                            BNRCEventDetailsView.this.imgThumbnail.setClickable(true);
                        } else {
                            BNRCEventDetailsView.this.imgThumbnail.setClickable(false);
                        }
                    }
                });
            }
        }
        if (!(this.icEventType == null || TextUtils.isEmpty(this.mController.getModel().geteIcon()))) {
            try {
                new UgcImageLoaderUtils().updateUgcViewOnLine(this.mController.getModel().geteType(), this.icEventType, this.mController.getModel().geteIcon());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (this.tvEventType != null) {
            this.tvEventType.setText(this.mController.getModel().geteTitle());
        }
        if (this.tvEventTimeStamp != null) {
            this.tvEventTimeStamp.setText(this.mController.getModel().getShowTime());
        }
        if (this.tvEventDescription != null) {
            if (TextUtils.isEmpty(this.mController.getModel().getContent())) {
                this.tvEventDescription.setVisibility(8);
            } else {
                this.tvEventDescription.setText(this.mController.getModel().getContent());
            }
        }
        if (this.tvEventReporter != null) {
            if (TextUtils.isEmpty(this.mController.getModel().getUser())) {
                this.tvEventReporter.setText("百度热心用户");
            } else {
                this.tvEventReporter.setText(Html.fromHtml(this.mController.getModel().getUser()));
            }
        }
        boolean labelsShow;
        if (this.mController.getModel().getLabel() == null || this.mController.getModel().getLabel().length == 0) {
            labelsShow = false;
            if (this.eventSubLayout != null) {
                this.eventSubLayout.setVisibility(8);
            }
        } else {
            labelsShow = true;
            if (this.mController.getModel().getLabel().length == 1) {
                if (!(this.eventSubTv1 == null || this.eventSubTv2 == null)) {
                    this.eventSubTv1.setText(this.mController.getModel().getLabel()[0]);
                    this.eventSubTv2.setVisibility(8);
                    this.eventSubTv1.setVisibility(0);
                }
            } else if (!(this.mController.getModel().getLabel().length != 2 || this.eventSubTv1 == null || this.eventSubTv2 == null)) {
                this.eventSubTv1.setText(this.mController.getModel().getLabel()[0]);
                this.eventSubTv2.setText(this.mController.getModel().getLabel()[1]);
                this.eventSubTv2.setVisibility(0);
                this.eventSubTv1.setVisibility(0);
            }
        }
        if (this.roadNameTv != null) {
            this.roadNameTv.setText(this.mController.getModel().getRoadName());
        }
        if (this.awayFromTv != null) {
            this.awayFromTv.setText(this.mController.getModel().getAwayFrom());
            if (TextUtils.isEmpty(this.mController.getModel().getAwayFrom()) && this.awayFromSpacing != null) {
                this.awayFromSpacing.setVisibility(8);
            }
        }
        if (this.timeIntervalTv != null) {
            if (TextUtils.isEmpty(this.mController.getModel().getTimeInterval())) {
                this.timeIntervalTv.setVisibility(8);
            } else {
                this.timeIntervalTv.setText(this.mController.getModel().getTimeInterval());
            }
        }
        if (!(this.tvEventDescription == null || this.eventSubLayout == null || this.timeIntervalTv == null || this.imgThumbnail == null)) {
            if (this.tvEventDescription.getVisibility() == 8 && this.eventSubLayout.getVisibility() == 8 && this.timeIntervalTv.getVisibility() == 8 && this.imgThumbnail.getVisibility() == 8) {
                this.contentView.setVisibility(8);
            } else {
                this.contentView.setVisibility(0);
            }
        }
        if (this.eventSubLayoutDivider != null) {
            if (TextUtils.isEmpty(this.mController.getModel().getContent()) || !labelsShow) {
                this.eventSubLayoutDivider.setVisibility(8);
            } else {
                this.eventSubLayoutDivider.setVisibility(0);
            }
        }
        updateUsefulOrUselessView(true);
        updateUsefulOrUselessView(false);
        initViewShowByData();
    }

    public void updateUsefulOrUselessView(boolean useful) {
        int votedInt = this.mController.getModel().getVoted();
        int colorNormal = JarUtils.getResources().getColor(C4048R.color.nsdk_ugc_txt_unfocused);
        int colorHighlight = JarUtils.getResources().getColor(C4048R.color.nsdk_ugc_txt_normal);
        boolean voted;
        if (useful) {
            if (votedInt != 1) {
                voted = false;
            } else {
                voted = true;
            }
            if (this.tvUseful != null) {
                this.tvUseful.setText("有用(" + this.mController.getModel().getUseful() + ")");
                TextView textView = this.tvUseful;
                if (!voted) {
                    colorHighlight = colorNormal;
                }
                textView.setTextColor(colorHighlight);
                return;
            }
            return;
        }
        if (votedInt != 2) {
            voted = false;
        } else {
            voted = true;
        }
        if (this.tvUseless != null) {
            this.tvUseless.setText("没用(" + this.mController.getModel().getUseless() + ")");
            textView = this.tvUseless;
            if (!voted) {
                colorHighlight = colorNormal;
            }
            textView.setTextColor(colorHighlight);
        }
    }

    private void initViewShowByData() {
        if (this.mController.getModel() != null && this.mController.getModel().getOutlineDataBuild() != null) {
            if (this.mController.getModel().getOutlineDataBuild().getIsShowZoomView()) {
                imgThumbnailButtonClick();
            }
            if (this.mController.getModel().getOutlineDataBuild().getVotedIndex() == 0) {
                return;
            }
            if (this.mController.getModel().getOutlineDataBuild().getVotedIndex() == 1) {
                this.mController.getModel().setVoted(1);
                this.mController.getModel().setUseful(this.mController.getModel().getUseful() + 1);
                updateUsefulOrUselessView(true);
                return;
            }
            this.mController.getModel().setVoted(2);
            this.mController.getModel().setUseless(this.mController.getModel().getUseless() + 1);
            updateUsefulOrUselessView(false);
        }
    }

    public void onCommentsDataSetChanged() {
        if (this.mUgcDetailsAdapter != null && this.mCommentsLoadingFooterContainer != null) {
            boolean moreCommentsPending = this.mController.isMoreCommentsPending();
            int dataCount = this.mController.getModel().getCommentsLength();
            LogUtil.m15791e(TAG, "onCommentsDataSetChanged: --> moreCommentsPending: " + moreCommentsPending + ", dataCount: " + dataCount);
            if (dataCount == 0) {
                this.mUgcDetailsAdapter.setCommentsLoadingState(CommentsLoadingState.LOADED_NO_DATA);
                this.mUgcDetailsAdapter.notifyDataSetChanged();
                return;
            }
            initCommentsList();
            this.mUgcDetailsAdapter.setCommentsLoadingState(CommentsLoadingState.LOADED_HAS_DATA);
            this.mUgcDetailsAdapter.setData(this.mController.getModel().getComments());
            this.mUgcDetailsAdapter.notifyDataSetChanged();
            if (moreCommentsPending) {
                this.mCommentsPtrList.onFinishLoading(true, false);
                return;
            }
            this.mUgcDetailsAdapter.setShowNoMoreCommentsFooter(true);
            this.mCommentsLoadingFooterContainer.setVisibility(8);
            this.mUgcDetailsAdapter.notifyDataSetChanged();
            this.mCommentsPtrList.onFinishLoading(false, false);
        }
    }

    public void onDestroy() {
        this.commentsPtrListInited = false;
        if (this.mUgcRCEventCallback != null) {
            this.mUgcRCEventCallback.onFinish();
        }
        UIUtils.releaseImageViewWithoutNull(this.imgThumbnail);
        UIUtils.releaseImageViewWithoutNull(this.icEventType);
        UIUtils.releaseImageViewWithoutNull(this.imgZoomIv);
        if (this.bitmap != null) {
            this.bitmap.recycle();
            this.bitmap = null;
        }
        this.outlineViewContainer = null;
    }

    public void showImgZoomView(boolean showZoomView, String url) {
        if (this.imgZoomViewContainer != null && this.imgZoomIv != null) {
            if (!TextUtils.isEmpty(url)) {
                UrlDrawableContainIView.getDrawable(url, C4048R.drawable.nsdk_rc_img_default_bg, this.imgZoomIv, new Handler(Looper.getMainLooper()) {
                    public void handleMessage(Message msg) {
                        super.handleMessage(msg);
                        if (msg.what == 8192 && msg.arg1 != 0) {
                            LogUtil.m15791e(BNRCEventDetailsView.TAG, "handleMessage: zoom img load fail --> ");
                        }
                    }
                }, true);
            }
            this.imgZoomViewContainer.setVisibility(showZoomView ? 0 : 8);
            this.mController.setIsShowZoomView(showZoomView);
            if (showZoomView) {
                this.mController.stopTimer();
                this.imgZoomViewContainer.setOnClickListener(new OnClickListener() {
                    public void onClick(View v) {
                        BNRCEventDetailsView.this.showImgZoomView(false, null);
                    }
                });
            }
        }
    }

    public void updateUsefulOrUseless(boolean useful) {
        if (useful) {
            this.mController.getModel().setVoted(1);
            this.mController.getModel().setUseful(this.mController.getModel().getUseful() + 1);
            this.mController.getModel().getOutlineDataBuild().setVotedIndex(1);
        } else {
            this.mController.getModel().setVoted(2);
            this.mController.getModel().setUseless(this.mController.getModel().getUseless() + 1);
            this.mController.getModel().getOutlineDataBuild().setVotedIndex(2);
        }
        updateUsefulOrUselessView(useful);
    }

    public View getRootView() {
        return this.rootView;
    }

    private void onClickShade() {
        if (this.imgZoomViewContainer == null || !this.imgZoomViewContainer.isShown()) {
            if (this.mController != null) {
                this.mController.onDestroy();
            }
            if (this.rootView != null) {
                this.rootView.setVisibility(8);
                return;
            }
            return;
        }
        showImgZoomView(false, null);
    }

    public boolean onBackPressed() {
        if (this.imgZoomViewContainer != null && this.imgZoomViewContainer.isShown()) {
            showImgZoomView(false, null);
            return true;
        } else if (this.mController == null) {
            return false;
        } else {
            this.mController.onDestroy();
            return false;
        }
    }

    private void usefulOrUselessClicked(boolean useful) {
        if (NetworkUtils.getConnectStatus()) {
            UserOPController.getInstance().add(UserOPParams.GUIDE_3_u_3, useful ? "1" : "2", null, null);
            if (this.mController != null && !this.mController.isVotedUpdated()) {
                if (this.mController.getModel().getVoted() == 0) {
                    this.mController.setVotedUpdated(useful);
                    this.mController.asyncRCEventFeedbackData(useful);
                    loadingStart(2);
                    return;
                }
                TipTool.onCreateToastDialog(this.mController.getContext(), "您已经评价过了");
                return;
            }
            return;
        }
        TipTool.onCreateToastDialog(this.mController.getContext(), JarUtils.getResources().getString(C4048R.string.network_unconnected));
    }

    public void onClick(View v) {
        int id = v.getId();
        if (id != C4048R.id.view_useful && id != C4048R.id.view_useless) {
            if (id == C4048R.id.img_thumbnail) {
                showImgZoomView(true, this.mController.getModel().getEventPic());
            } else if (id == C4048R.id.ugc_rc_details_bg) {
                onClickShade();
            } else if (id == C4048R.id.layout_event_user_info) {
                if (this.mCommentsPtrList != null) {
                    this.mCommentsPtrList.goToTop();
                    loadComments();
                }
            } else if (id == C4048R.id.back_container) {
                if (this.mController != null) {
                    this.mController.onDestroy();
                }
                if (this.rootView != null) {
                    this.rootView.setVisibility(8);
                }
            } else if (id == C4048R.id.view_avoid_congestion) {
                if (BNRCEventDetailsViewController.getInstance().getSource() == 3) {
                    UserOPController.getInstance().add(UserOPParams.GUIDE_3_u_2_3, null, null, null);
                }
                if (this.mController != null) {
                    this.mController.doReCalcRoute();
                }
            } else if (id != C4048R.id.contents_loading_state_container && id == C4048R.id.title_container) {
            }
        }
    }
}
