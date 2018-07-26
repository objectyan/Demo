package com.baidu.navi.routedetails;

import android.app.Activity;
import android.graphics.Rect;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.carlife.C0965R;
import com.baidu.carlife.core.screen.BaseDialog.C1265a;
import com.baidu.carlife.core.screen.C1277e;
import com.baidu.carlife.logic.voice.C1903m;
import com.baidu.carlife.view.dialog.C2282f;
import com.baidu.navi.routedetails.RGRouteDetailsOutlineItemView.OnDragOpenListener;
import com.baidu.navi.style.StyleManager;
import com.baidu.navi.voice.NaviState;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.CommonParams.Const.ModelName;
import com.baidu.navisdk.comapi.base.BNSubject;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.mapcontrol.BNMapObserver;
import com.baidu.navisdk.comapi.poisearch.BNPoiSearcher;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.comapi.statistics.BNStatisticsManager;
import com.baidu.navisdk.comapi.statistics.NaviStatConstants;
import com.baidu.navisdk.comapi.voicecommand.BNVoiceCommandController;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.navisdk.model.datastruct.RoutePlanOutlineItem;
import com.baidu.navisdk.model.modelfactory.NaviDataEngine;
import com.baidu.navisdk.model.modelfactory.RoutePlanModel;
import com.baidu.navisdk.model.params.MsgDefine;
import com.baidu.navisdk.ui.routedetails.IBNRouteDetailsListener;
import com.baidu.navisdk.ui.routeguide.control.NMapControlProxy;
import com.baidu.navisdk.ui.routeguide.control.RGRouteSortController;
import com.baidu.navisdk.ui.routeguide.model.RGMultiRouteModel;
import com.baidu.navisdk.ui.routeguide.model.RGParkPointModel;
import com.baidu.navisdk.ui.routeguide.model.RGRouteSortModel;
import com.baidu.navisdk.ui.routeguide.subview.RGBaseView;
import com.baidu.navisdk.ui.util.ForbidDaulClickUtils;
import com.baidu.navisdk.ui.util.ForbidDaulClickUtilsNonStatic;
import com.baidu.navisdk.util.common.CoordinateTransformUtil;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.statistic.NaviStatItem;
import com.baidu.navisdk.util.statistic.RoutePlanStatItem;
import com.baidu.navisdk.util.statistic.userop.UserOPController;
import com.baidu.navisdk.util.statistic.userop.UserOPParams;
import com.baidu.nplatform.comapi.MapItem;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import com.baidu.nplatform.comapi.basestruct.MapStatus;
import com.baidu.nplatform.comapi.map.MapController.AnimationType;
import java.util.ArrayList;
import java.util.Iterator;

public class RGRouteDetailsView extends RGBaseView {
    private static final int NAVI_COUNT_DOWN_TIME = 5;
    private static final String TAG = "RoutePlan";
    private final int ROUTES_SIZE = 3;
    TranslateAnimation anim;
    private Activity mActivity = null;
    private BNMapObserver mBNMapObserver = new BNMapObserver() {
        public void update(BNSubject o, int type, int event, Object arg) {
            if (1 == type) {
                switch (event) {
                    case 278:
                    case 514:
                        if (!RGRouteDetailsView.this.mForbidRouteMapClick) {
                            MapItem item = (MapItem) arg;
                            int index = item.mItemID;
                            RGRouteDetailsView.this.mCurrentRouteIndex = index;
                            RGRouteDetailsView.this.mRoutePlanModel.setCurIndex(index);
                            RGRouteDetailsView.this.cancleCountDownTask();
                            Iterator it = RGRouteDetailsView.this.mViewList.iterator();
                            while (it.hasNext()) {
                                ((RGRouteDetailsOutlineItemView) it.next()).unfocusItem();
                            }
                            if (RGRouteDetailsView.this.mViewList != null && index >= 0 && index < RGRouteDetailsView.this.mViewList.size()) {
                                ((RGRouteDetailsOutlineItemView) RGRouteDetailsView.this.mViewList.get(index)).focusItem();
                                BNRoutePlaner.getInstance().selectRoute(index);
                                RGRouteDetailsView.this.selectRoute(item.mItemID);
                                RGRouteDetailsView.this.updateIndicator(RGRouteDetailsView.this.mCurrentRouteIndex);
                                return;
                            }
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }
    };
    private IBNRouteDetailsListener mBNRouteDetailsListener = null;
    private View mBtnBack;
    private View mBtnOpenPreference;
    private NaviCountDownTask mCountDownTask;
    private int mCurrentRouteIndex = 0;
    private boolean mForbidRouteMapClick = false;
    private ViewGroup mGroupView;
    private boolean mIsCountDowning;
    private boolean mIsFisrtCountDown = true;
    private boolean mIsSeeOtherRoute = false;
    private ImageView mIvBack;
    private C1277e mOnDialogListener;
    private Handler mRPHandler = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 4:
                    LogUtil.m15791e("RoutePlan", "onRoutePlanSuccess");
                    RGRouteDetailsView.this.needAnimForFullview = true;
                    RGRouteDetailsView.this.mIsFisrtCountDown = true;
                    RGRouteDetailsView.this.clearParkDetailAfterReCalc();
                    RGRouteDetailsView.this.startNaviCountDown(5);
                    RGRouteDetailsView.this.mCurrentRouteIndex = 0;
                    RGRouteDetailsView.this.onUpdateOrientation();
                    if (RGRouteDetailsView.this.mBNRouteDetailsListener != null) {
                        RGRouteDetailsView.this.mBNRouteDetailsListener.onUpdate(2, 0, 0, null);
                        return;
                    }
                    return;
                case 7:
                    LogUtil.m15791e("RoutePlan", "onRoutePlanFail");
                    RGRouteDetailsView.this.backToHome(null);
                    return;
                case 32:
                    LogUtil.m15791e("RoutePlan", "onRoutePlanCanceled");
                    RGRouteDetailsView.this.backToHome(null);
                    return;
                default:
                    return;
            }
        }
    };
    private View mRlPreference;
    private RelativeLayout mRouteDetailLL;
    private LinearLayout mRouteOutlineLL;
    private RoutePlanModel mRoutePlanModel = null;
    private ArrayList<RoutePlanOutlineItem> mRoutePlanOutlineItemList;
    private C2282f mRoutePlanPreferenceDialog = null;
    private RoutePlanPreferenceDialogAdapter mRoutePlanPreferenceDialogAdapter = null;
    private LinearLayout mStartNaviLL;
    private TextView mStartNaviTextView;
    private RoutePlanStatItem mStatItem;
    private TextView mTvPreference;
    ArrayList<RGRouteDetailsOutlineItemView> mViewList;
    private boolean needAnimForFullview = true;
    private ArrayList<RGRouteSortModel> routeSortList;
    private int[] routesSelected = new int[3];
    private Runnable runnable = new C39451();

    /* renamed from: com.baidu.navi.routedetails.RGRouteDetailsView$1 */
    class C39451 implements Runnable {
        C39451() {
        }

        public void run() {
            LogUtil.m15791e("WandaDebug", "BNMapObserver.EventMapView.EVENT_CLICKED_END_LAYER onResume");
            BNMapController.getInstance().onResume();
        }
    }

    /* renamed from: com.baidu.navi.routedetails.RGRouteDetailsView$2 */
    class C39462 implements OnTouchListener {
        C39462() {
        }

        public boolean onTouch(View v, MotionEvent event) {
            RGRouteDetailsView.this.cancleCountDownTask();
            return true;
        }
    }

    /* renamed from: com.baidu.navi.routedetails.RGRouteDetailsView$3 */
    class C39473 implements OnClickListener {
        C39473() {
        }

        public void onClick(View v) {
            if (!ForbidDaulClickUtils.isFastDoubleClick()) {
                RGRouteDetailsView.this.cancleCountDownTask();
                BNStatisticsManager.getInstance().onEvent(BNaviModuleManager.getContext(), NaviStatConstants.MULTIPLEROUTES_DETAIL_STARTNAVIGATION, NaviStatConstants.MULTIPLEROUTES_DETAIL_STARTNAVIGATION);
                UserOPController.getInstance().add(UserOPParams.ROUTE_2_2);
                BNRouteGuider.getInstance().setUserChooseRouteBit(RGRouteDetailsView.this.getRouteSelectedInt());
                RGRouteDetailsView.this.startRealNavi();
            }
        }
    }

    /* renamed from: com.baidu.navi.routedetails.RGRouteDetailsView$4 */
    class C39484 implements OnClickListener {
        C39484() {
        }

        public void onClick(View v) {
            if (!ForbidDaulClickUtils.isFastDoubleClick()) {
                BNStatisticsManager.getInstance().onEvent(BNaviModuleManager.getContext(), NaviStatConstants.MULTIPLEROUTES_RETURN, NaviStatConstants.MULTIPLEROUTES_RETURN);
                UserOPController.getInstance().add(UserOPParams.COMMON_1_5, "2", null, null);
                RGRouteDetailsView.this.cancleCountDownTask();
                RGRouteDetailsView.this.onBackPressed();
            }
        }
    }

    /* renamed from: com.baidu.navi.routedetails.RGRouteDetailsView$5 */
    class C39495 implements OnClickListener {
        C39495() {
        }

        public void onClick(View v) {
            BNStatisticsManager.getInstance().onEvent(BNaviModuleManager.getContext(), NaviStatConstants.MULTIPLEROUTES_FAVORITES, NaviStatConstants.MULTIPLEROUTES_FAVORITES);
            UserOPController.getInstance().add(UserOPParams.ROUTE_2_5);
            RGRouteDetailsView.this.cancleCountDownTask();
            RGRouteDetailsView.this.showRoutePlanPreferenceDialog();
        }
    }

    /* renamed from: com.baidu.navi.routedetails.RGRouteDetailsView$6 */
    class C39506 implements OnTouchListener {
        C39506() {
        }

        public boolean onTouch(View v, MotionEvent event) {
            RGRouteDetailsView.this.cancleCountDownTask();
            return false;
        }
    }

    private class NaviCountDownTask extends AsyncTask<Integer, Integer, Void> {
        private NaviCountDownTask() {
        }

        protected Void doInBackground(Integer... params) {
            for (int secs = params[0].intValue(); secs > 0 && !isCancelled(); secs--) {
                publishProgress(new Integer[]{Integer.valueOf(secs)});
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }
            }
            return null;
        }

        protected void onProgressUpdate(Integer... progress) {
            if (RGRouteDetailsView.this.mStartNaviTextView != null && RGRouteDetailsView.this.mActivity != null) {
                RGRouteDetailsView.this.mStartNaviTextView.setText(String.format("(%dS)", new Object[]{progress[0]}));
            }
        }

        protected void onPostExecute(Void result) {
            if (!isCancelled() && !ForbidDaulClickUtils.isFastDoubleClick() && RGRouteDetailsView.this.mActivity != null) {
                UserOPController.getInstance().add(UserOPParams.ROUTE_2_2);
                RGRouteDetailsView.this.startRealNavi();
            }
        }

        public void cancelCountDown() {
            if (!(RGRouteDetailsView.this.mStartNaviTextView == null || RGRouteDetailsView.this.mActivity == null)) {
                RGRouteDetailsView.this.mStartNaviTextView.setText("");
            }
            cancel(true);
        }
    }

    public RGRouteDetailsView(Activity activity, C1277e listener) {
        this.mActivity = activity;
        this.mOnDialogListener = listener;
        initData();
        BNMapController.getInstance().recoveryHighLightRoute();
        BNMapController.getInstance().setHighLightRoute(0);
        this.mGroupView = (ViewGroup) this.mActivity.getLayoutInflater().inflate(C0965R.layout.frag_layout_route_detail, null);
        if (this.mRPHandler != null) {
            this.mRPHandler.postDelayed(this.runnable, 12000);
        }
    }

    private void initData() {
        this.mRoutePlanModel = (RoutePlanModel) NaviDataEngine.getInstance().getModel(ModelName.ROUTE_PLAN);
        this.mRoutePlanOutlineItemList = new ArrayList();
        this.mStatItem = RoutePlanStatItem.getInstance();
        this.mStatItem.mRouteSwitchStartTime = SystemClock.elapsedRealtime();
    }

    private View initViews() {
        if (this.mGroupView != null) {
            this.mGroupView.removeAllViews();
        }
        this.mActivity.getLayoutInflater().inflate(C0965R.layout.frag_layout_route_detail, this.mGroupView);
        findView();
        updatePreferenceView();
        onUpdateStyle(StyleManager.getDayStyle());
        setupRouteOutline();
        startNaviCountDown(5);
        return this.mGroupView;
    }

    private void initMap() {
        Rect rect = new Rect(0, 0, ScreenUtil.getInstance().getHeightPixels() - ScreenUtil.getInstance().dip2px(256), ScreenUtil.getInstance().getWidthPixels() - ScreenUtil.getInstance().dip2px(80));
        BNMapController.getInstance().setMapDrawScreenRect(rect);
        if (this.mRoutePlanModel != null) {
            updateMapViewForRPNode(this.mRoutePlanModel.getRouteInput(), rect);
        }
    }

    public View getRootView() {
        return this.mGroupView;
    }

    private void findView() {
        if (this.mGroupView != null) {
            this.mRouteDetailLL = (RelativeLayout) this.mGroupView.findViewById(C0965R.id.ll_route_detail);
            this.mRouteOutlineLL = (LinearLayout) this.mGroupView.findViewById(C0965R.id.ll_route_outline);
            this.mStartNaviLL = (LinearLayout) this.mGroupView.findViewById(C0965R.id.ll_start_navi);
            this.mBtnBack = this.mGroupView.findViewById(C0965R.id.layout_back);
            this.mIvBack = (ImageView) this.mGroupView.findViewById(C0965R.id.left_imageview);
            this.mBtnOpenPreference = this.mGroupView.findViewById(C0965R.id.layout_perference);
            this.mRlPreference = this.mGroupView.findViewById(C0965R.id.rl_pre);
            this.mTvPreference = (TextView) this.mGroupView.findViewById(C0965R.id.tv_pre);
            this.mStartNaviTextView = (TextView) this.mGroupView.findViewById(C0965R.id.tv_start_navi);
        }
    }

    private void updatePreferenceView() {
        this.routeSortList = RGRouteSortController.getInstance().getRouteSortList();
        String preStr = "智能推荐";
        for (int i = 0; i < this.routeSortList.size(); i++) {
            RGRouteSortModel model = (RGRouteSortModel) this.routeSortList.get(i);
            if (model != null && (model.mPreferValue & RGRouteSortController.getInstance().getPreferValue()) != 0 && !TextUtils.isEmpty(model.mItemName)) {
                preStr = model.mItemName;
                break;
            }
        }
        if (this.mTvPreference != null) {
            this.mTvPreference.setText(preStr);
        }
    }

    private void setListner() {
        if (this.mRouteDetailLL != null) {
            this.mRouteDetailLL.setOnTouchListener(new C39462());
        }
        if (this.mStartNaviLL != null) {
            this.mStartNaviLL.setOnClickListener(new C39473());
        }
        if (this.mBtnBack != null) {
            this.mBtnBack.setOnClickListener(new C39484());
        }
        if (this.mBtnOpenPreference != null) {
            this.mBtnOpenPreference.setOnClickListener(new C39495());
        }
        if (this.mGroupView != null) {
            this.mGroupView.setOnTouchListener(new C39506());
        }
    }

    public void updateData(Bundle b) {
    }

    public void onUpdateStyle(boolean isDay) {
        if (this.mRlPreference != null && this.mIvBack != null) {
            this.mRlPreference.setBackground(StyleManager.getDrawable(C0965R.drawable.map_bg_btn_selector));
            this.mIvBack.setBackground(StyleManager.getDrawable(C0965R.drawable.map_bg_btn_selector));
        }
    }

    public void destory() {
        LogUtil.m15791e("RoutePlan", "destory======");
        if (this.mRPHandler != null) {
            this.mRPHandler.removeCallbacks(this.runnable);
        }
        cancleCountDownTask();
    }

    public void setBNRouteDetailsListener(IBNRouteDetailsListener lis) {
        this.mBNRouteDetailsListener = lis;
    }

    public void onUpdateOrientation() {
        this.mForbidRouteMapClick = false;
        initViews();
        setListner();
        if (this.mBNRouteDetailsListener != null) {
            this.mBNRouteDetailsListener.onResetMapCtrlPanel();
        }
        initMap();
    }

    public void onShow() {
        if (this.mBNRouteDetailsListener != null) {
            this.mBNRouteDetailsListener.onShowSidePanel();
        }
        BNRoutePlaner.getInstance().addRouteResultHandler(this.mRPHandler);
        BNMapController.getInstance().addObserver(this.mBNMapObserver);
        if (this.mRoutePlanOutlineItemList != null) {
            NaviState.getInstance().notifyRouteDetail(true, this.mRoutePlanOutlineItemList.size());
        }
    }

    public void onHide() {
        BNRoutePlaner.getInstance().removeRouteResultHandler(this.mRPHandler);
        BNMapController.getInstance().deleteObserver(this.mBNMapObserver);
        NaviState.getInstance().notifyRouteDetail(false, 0);
    }

    public boolean onBackPressed() {
        RGParkPointModel.getInstance().setCanParkPoiShow(true);
        RGParkPointModel.getInstance().setDoneWithParkSearch(false);
        if (this.mBNRouteDetailsListener != null) {
            this.mBNRouteDetailsListener.onPageJump(1, null);
        }
        return true;
    }

    private String getLabelName() {
        ArrayList<RGRouteSortModel> routeSortList = RGRouteSortController.getInstance().getRouteSortList();
        if (routeSortList == null) {
            return "";
        }
        for (int i = 0; i < routeSortList.size(); i++) {
            RGRouteSortModel model = (RGRouteSortModel) routeSortList.get(i);
            if (model == null) {
                return "";
            }
            if ((model.mPreferValue & RGRouteSortController.getInstance().getPreferValue()) != 0) {
                return model.mItemName;
            }
        }
        return "";
    }

    private void setupRouteOutline() {
        if (this.mRoutePlanModel != null && this.mRoutePlanOutlineItemList != null && this.mRouteOutlineLL != null) {
            int index;
            if (this.mViewList == null) {
                this.mViewList = new ArrayList();
            } else {
                this.mViewList.clear();
            }
            LogUtil.m15791e("wangyang", "before getRouteOutlineData()=" + this.mRoutePlanModel.getRouteOutlineData() + "getRouteOutlineData.size =" + this.mRoutePlanModel.getRouteOutlineData().size());
            if (this.mRoutePlanModel.getRouteOutlineData() == null || this.mRoutePlanModel.getRouteOutlineData().size() == 0) {
                int routeCnt = BNRoutePlaner.getInstance().getRouteCnt();
                ArrayList<Bundle> routeResultBundle = new ArrayList();
                for (index = 0; index < routeCnt; index++) {
                    Bundle outlineBundle = new Bundle();
                    BNRoutePlaner.getInstance().getRouteInfo(index, outlineBundle);
                    routeResultBundle.add(outlineBundle);
                }
                this.mRoutePlanModel.parseRouteResultOutline(routeResultBundle);
                LogUtil.m15791e("wangyang", "after getRouteOutlineData()=" + this.mRoutePlanModel.getRouteOutlineData() + "getRouteOutlineData.size =" + this.mRoutePlanModel.getRouteOutlineData().size());
            }
            this.mRoutePlanOutlineItemList.clear();
            this.mRoutePlanOutlineItemList.addAll(this.mRoutePlanModel.getRouteOutlineData());
            this.mRouteOutlineLL.removeAllViews();
            NaviState.getInstance().notifyRouteDetail(true, this.mRoutePlanOutlineItemList.size());
            for (int i = 0; i < this.mRoutePlanOutlineItemList.size(); i++) {
                index = i;
                RoutePlanOutlineItem item = (RoutePlanOutlineItem) this.mRoutePlanOutlineItemList.get(i);
                final RGRouteDetailsOutlineItemView itemView = new RGRouteDetailsOutlineItemView(this.mActivity);
                if (itemView.isInitSucceeded()) {
                    this.mViewList.add(itemView);
                    itemView.setData(item.getPassTimeStr(), item.getLengthStr(), getLabelName(), item.getLights(), i);
                    if (this.mRoutePlanOutlineItemList.size() <= this.mCurrentRouteIndex) {
                        if (i == 0) {
                            this.mCurrentRouteIndex = i;
                            itemView.focusItem();
                            BNRoutePlaner.getInstance().selectRoute(index);
                            selectRoute(index);
                        } else {
                            itemView.unfocusItem();
                        }
                    } else if (i == this.mCurrentRouteIndex) {
                        itemView.focusItem();
                        BNRoutePlaner.getInstance().selectRoute(index);
                        selectRoute(index);
                    } else {
                        itemView.unfocusItem();
                    }
                    itemView.setTragOpenListener(new OnDragOpenListener() {
                        public void onOpen() {
                        }

                        public void onClick() {
                            if (!new ForbidDaulClickUtilsNonStatic().isFastDoubleClick()) {
                                RoutePlanStatItem access$300 = RGRouteDetailsView.this.mStatItem;
                                access$300.mSwitchRouteCount++;
                                RGRouteDetailsView.this.cancleCountDownTask();
                                if (RGRouteDetailsView.this.mCurrentRouteIndex != index) {
                                    RGRouteDetailsView.this.mCurrentRouteIndex = index;
                                    RGRouteDetailsView.this.mRoutePlanModel.setCurIndex(index);
                                    Iterator it = RGRouteDetailsView.this.mViewList.iterator();
                                    while (it.hasNext()) {
                                        ((RGRouteDetailsOutlineItemView) it.next()).unfocusItem();
                                    }
                                    itemView.focusItem();
                                    BNRoutePlaner.getInstance().selectRoute(index);
                                    RGRouteDetailsView.this.selectRoute(index);
                                    RGRouteDetailsView.this.updateIndicator(index);
                                }
                            }
                        }
                    });
                    this.mRouteOutlineLL.addView(itemView, new LayoutParams(-1, -2));
                }
            }
        }
    }

    private void startRealNavi() {
        C1903m.a().b();
        if (this.mBNRouteDetailsListener != null) {
            Bundle bundle = new Bundle();
            int ret = BNRoutePlaner.getInstance().getRouteInfo(this.mCurrentRouteIndex, bundle);
            if (ret == 0) {
                LogUtil.m15791e("RoutePlan", "step route info: error");
                if (this.mRoutePlanModel != null && this.mRoutePlanModel.getRouteInput().size() > 1) {
                    BNRoutePlaner.getInstance().setPointsToCalcRoute(this.mRoutePlanModel.getRouteInput(), 0);
                }
            } else if (ret == 1) {
                LogUtil.m15791e("RoutePlan", "step route info: part");
                BNRoutePlaner.getInstance().notifyObservers(1, 1, null);
                BNRoutePlaner.getInstance().setRouteInfoHandler(new Handler(Looper.getMainLooper()) {
                    public void handleMessage(Message msg) {
                        BNRoutePlaner.getInstance().clearRouteInfoHandler();
                        if (msg.what == MsgDefine.MSG_NAVI_Success_BuildGuideRoute) {
                            RGRouteDetailsView.this.startRealNavi();
                        } else if (msg.what != MsgDefine.MSG_NAVI_Fail_BuildGuideRoute) {
                        }
                    }
                });
            } else {
                if (ret == 2) {
                    LogUtil.m15791e("RoutePlan", "step route info: all");
                }
                this.mRoutePlanModel.parseRouteResult(this.mActivity.getApplicationContext(), bundle);
                if (this.mIsSeeOtherRoute) {
                    this.mBNRouteDetailsListener.onSwitchOtherRoute(this.mCurrentRouteIndex);
                } else {
                    this.mBNRouteDetailsListener.onStartRealNavi();
                }
                statistics(true);
            }
        }
    }

    private void startNavi(final boolean isAnologNavi) {
        if (this.mBNRouteDetailsListener != null) {
            int ret = BNRoutePlaner.getInstance().getRouteInfo(this.mCurrentRouteIndex, new Bundle());
            if (ret == 0) {
                LogUtil.m15791e("RoutePlan", "step route info: error");
            } else if (ret == 1) {
                LogUtil.m15791e("RoutePlan", "step route info: part");
                BNRoutePlaner.getInstance().notifyObservers(1, 1, null);
                BNRoutePlaner.getInstance().setRouteInfoHandler(new Handler(Looper.getMainLooper()) {
                    public void handleMessage(Message msg) {
                        BNRoutePlaner.getInstance().clearRouteInfoHandler();
                        if (msg.what == MsgDefine.MSG_NAVI_Success_BuildGuideRoute) {
                            RGRouteDetailsView.this.startNavi(isAnologNavi);
                        } else if (msg.what != MsgDefine.MSG_NAVI_Fail_BuildGuideRoute) {
                        }
                    }
                });
            } else {
                if (ret == 2) {
                    LogUtil.m15791e("RoutePlan", "step route info: all");
                }
                this.mBNRouteDetailsListener.onStartNavi(isAnologNavi);
                if (isAnologNavi) {
                    NaviStatItem.getInstance().setStartNaviFrom(9);
                    if (this.mRoutePlanOutlineItemList != null && this.mCurrentRouteIndex >= 0 && this.mCurrentRouteIndex < this.mRoutePlanOutlineItemList.size()) {
                        RoutePlanOutlineItem item = (RoutePlanOutlineItem) this.mRoutePlanOutlineItemList.get(this.mCurrentRouteIndex);
                        if (item != null) {
                            NaviStatItem.getInstance().setRoutePlanTimeAndDist((long) item.getPassTime(), (long) item.getLength());
                        }
                    }
                    UserOPController.getInstance().add(UserOPParams.ROUTE_2_3_3);
                }
            }
        }
    }

    public void updateMapViewForRPNode(ArrayList<RoutePlanNode> routeitems, Rect rect) {
        if (routeitems != null) {
            int left = Integer.MAX_VALUE;
            int right = 0;
            int bottom = Integer.MAX_VALUE;
            int top = 0;
            for (int i = 0; i < routeitems.size(); i++) {
                RoutePlanNode ri = (RoutePlanNode) routeitems.get(i);
                if (ri != null) {
                    GeoPoint geoPoint = ri.getGeoPoint();
                    if (geoPoint.isValid()) {
                        if (left > geoPoint.getLongitudeE6()) {
                            left = geoPoint.getLongitudeE6();
                        }
                        if (right < geoPoint.getLongitudeE6()) {
                            right = geoPoint.getLongitudeE6();
                        }
                        if (top < geoPoint.getLatitudeE6()) {
                            top = geoPoint.getLatitudeE6();
                        }
                        if (bottom > geoPoint.getLatitudeE6()) {
                            bottom = geoPoint.getLatitudeE6();
                        }
                    } else {
                        return;
                    }
                }
            }
            Bundle bundleRB = CoordinateTransformUtil.LLE62MC(right, bottom);
            Bundle bundleLT = CoordinateTransformUtil.LLE62MC(left, top);
            int mcRight = bundleRB.getInt("MCx");
            int mcBottom = bundleRB.getInt("MCy");
            int mcLeft = bundleLT.getInt("MCx");
            int mcTop = bundleLT.getInt("MCy");
            Bundle routeBound = new Bundle();
            if (BNRouteGuider.getInstance().getSlightNaviRouteBound(routeBound)) {
                mcLeft = routeBound.getInt("left", mcLeft);
                mcRight = routeBound.getInt("right", mcRight);
                mcTop = routeBound.getInt("top", mcTop);
                mcBottom = routeBound.getInt("bottom", mcBottom);
            }
            routeBound.putLong("left", (long) mcLeft);
            routeBound.putLong("right", (long) mcRight);
            routeBound.putLong("top", (long) mcTop);
            routeBound.putLong("bottom", (long) mcBottom);
            float level = BNMapController.getInstance().GetZoomToBound(routeBound, (float) (rect.right - rect.left), (float) (rect.bottom - rect.top));
            if (level >= 18.0f) {
                level = 18.0f;
            }
            level *= 0.95f;
            float centerX = (float) ((mcRight + mcLeft) / 2);
            float centerY = (float) ((mcTop + mcBottom) / 2);
            MapStatus st = BNMapController.getInstance().getMapStatus();
            float offsetY = (float) ScreenUtil.getInstance().dip2px(40);
            float offsetX = (float) ((rect.left - (ScreenUtil.getInstance().getHeightPixels() - rect.right)) >> 1);
            if (st != null) {
                st._Yoffset = (long) offsetY;
                st._Xoffset = (long) offsetX;
                st._CenterPtX = (int) centerX;
                st._CenterPtY = (int) centerY;
                st._Level = level;
                st._Overlooking = 0;
                st._Rotation = 0;
            }
            BNMapController.getInstance().setMapStatus(st, AnimationType.eAnimationAll);
        }
    }

    private void backToHome(Bundle bd) {
        if (this.mBNRouteDetailsListener != null) {
            this.mBNRouteDetailsListener.onPageJump(2, bd);
        }
    }

    public void startNaviCountDown(int count) {
        if (!this.mIsSeeOtherRoute) {
            this.mIsCountDowning = true;
            if (!(this.mCountDownTask == null || this.mCountDownTask.isCancelled())) {
                this.mCountDownTask.cancelCountDown();
            }
            if (this.mIsFisrtCountDown) {
                this.mCountDownTask = new NaviCountDownTask();
                this.mCountDownTask.execute(new Integer[]{Integer.valueOf(count)});
                if (this.mStartNaviTextView != null) {
                    this.mStartNaviTextView.setVisibility(0);
                }
            }
            this.mIsFisrtCountDown = false;
        } else if (this.mStartNaviTextView != null) {
            this.mStartNaviTextView.setVisibility(8);
        }
    }

    public void cancleCountDownTask() {
        if (this.mIsCountDowning) {
            if (!(this.mCountDownTask == null || this.mCountDownTask.isCancelled())) {
                this.mCountDownTask.cancelCountDown();
                this.mCountDownTask = null;
            }
            this.mIsCountDowning = false;
            if (this.mStartNaviTextView != null) {
                this.mStartNaviTextView.setVisibility(8);
            }
        }
    }

    public void updateIndicator(int index) {
        if (this.mViewList != null && index >= 0 && index < this.mViewList.size()) {
            setRouteSelected(index);
            initMap();
        }
    }

    private boolean chooseRouteIndex(int commandIndex) {
        if (this.mViewList == null || commandIndex >= this.mViewList.size() || commandIndex < 0) {
            return false;
        }
        for (int cnt = 0; cnt < this.mViewList.size(); cnt++) {
            RGRouteDetailsOutlineItemView view = (RGRouteDetailsOutlineItemView) this.mViewList.get(cnt);
            if (view == null) {
                return false;
            }
            if (cnt == commandIndex) {
                cancleCountDownTask();
                this.mCurrentRouteIndex = commandIndex;
                this.mRoutePlanModel.setCurIndex(commandIndex);
                Iterator it = this.mViewList.iterator();
                while (it.hasNext()) {
                    ((RGRouteDetailsOutlineItemView) it.next()).unfocusItem();
                }
                view.focusItem();
                BNRoutePlaner.getInstance().selectRoute(commandIndex);
                selectRoute(commandIndex);
                updateIndicator(commandIndex);
            }
        }
        return true;
    }

    private boolean chooseRoute(int commandIndex) {
        if (this.mViewList == null && commandIndex > 2 && commandIndex < 0) {
            return false;
        }
        for (int cnt = 0; cnt < this.mViewList.size(); cnt++) {
            RGRouteDetailsOutlineItemView view = (RGRouteDetailsOutlineItemView) this.mViewList.get(cnt);
            if (view == null) {
                return false;
            }
            if (cnt == commandIndex) {
                cancleCountDownTask();
                view.focusItem();
                BNRoutePlaner.getInstance().selectRoute(commandIndex);
                selectRoute(commandIndex);
                startRealNavi();
            } else {
                view.unfocusItem();
            }
        }
        return true;
    }

    private void selectRoute(int index) {
        if (RGMultiRouteModel.getInstance().isAvoidTrafficStatus) {
            BNMapController.getInstance().setHighLightAvoidTrafficRoute(index);
        } else {
            BNMapController.getInstance().setHighLightRoute(index);
        }
        NMapControlProxy.getInstance().updateLayer(10);
    }

    public boolean onVoiceCommand(int type, int subType, int arg1, Object arg2, boolean needResponse) {
        if (type != 3 || subType != 3) {
            if (type == 2) {
                switch (subType) {
                    case 65:
                        cancleCountDownTask();
                        BNRouteGuider.getInstance().setUserChooseRouteBit(getRouteSelectedInt());
                        startRealNavi();
                        BNVoiceCommandController.getInstance().commonVoiceCommandResponse(type, 1);
                        return true;
                    case 66:
                        if (chooseRoute(arg1)) {
                            BNVoiceCommandController.getInstance().commonVoiceCommandResponse(type, 1);
                            return true;
                        }
                        BNVoiceCommandController.getInstance().commonVoiceCommandResponse(type, 2);
                        return true;
                    case 67:
                        if (chooseRouteIndex(arg1 - 1)) {
                            BNVoiceCommandController.getInstance().commonVoiceCommandResponse(type, 1);
                            return true;
                        }
                        BNVoiceCommandController.getInstance().commonVoiceCommandResponse(type, 2);
                        return true;
                }
            }
            return false;
        } else if (chooseRoute(arg1 - 21)) {
            BNVoiceCommandController.getInstance().commonVoiceCommandResponse(type, 1);
            return true;
        } else {
            BNVoiceCommandController.getInstance().commonVoiceCommandResponse(type, 2);
            return true;
        }
    }

    private void statistics(boolean startNavi) {
        this.mStatItem.mStartNavi = startNavi;
        this.mStatItem.mRouteIndex = this.mCurrentRouteIndex;
        this.mStatItem.mRouteCount = BNRoutePlaner.getInstance().getRouteCnt();
        LogUtil.m15791e("RoutePlan", "stat test route routecount = " + this.mStatItem.mRouteCount);
        this.mStatItem.mRouteSwitchEndTime = SystemClock.elapsedRealtime();
        NaviStatItem.getInstance().setStartNaviFrom(1);
        if (this.mRoutePlanOutlineItemList != null && this.mCurrentRouteIndex >= 0 && this.mCurrentRouteIndex < this.mRoutePlanOutlineItemList.size()) {
            RoutePlanOutlineItem item = (RoutePlanOutlineItem) this.mRoutePlanOutlineItemList.get(this.mCurrentRouteIndex);
            if (item != null) {
                NaviStatItem.getInstance().setRoutePlanTimeAndDist((long) item.getPassTime(), (long) item.getLength());
                this.mStatItem.setRoutePlanTimeAndDist((long) item.getPassTime(), (long) item.getLength());
            }
        }
        if (!startNavi) {
            NaviStatItem.getInstance().init();
        }
        this.mStatItem.onEvent();
    }

    private void clearParkDetailAfterReCalc() {
        BNPoiSearcher.getInstance().clearBkgCache();
        BNMapController.getInstance().updateLayer(4);
        BNMapController.getInstance().showLayer(4, false);
    }

    private void setRouteSelected(int routeIndex) {
        if (this.routesSelected != null && routeIndex >= 0 && routeIndex < 3) {
            this.routesSelected[routeIndex] = 1;
        }
    }

    private int getRouteSelectedInt() {
        int i = 0;
        if (this.routesSelected != null) {
            int size = this.mViewList == null ? 0 : this.mViewList.size();
            if (size > 3) {
                size = 3;
            }
            int weight = 1;
            i = 1;
            for (int i2 = 1; i2 < size; i2++) {
                weight <<= 1;
                i += this.routesSelected[i2] * weight;
            }
        }
        return i;
    }

    public ArrayList<RGRouteDetailsOutlineItemView> getViewList() {
        return this.mViewList;
    }

    public View getStartNaviLL() {
        return this.mStartNaviLL;
    }

    public View getBtnBack() {
        return this.mBtnBack;
    }

    public View getBtnOpenPreference() {
        return this.mBtnOpenPreference;
    }

    private void showRoutePlanPreferenceDialog() {
        if (this.mRoutePlanPreferenceDialogAdapter == null) {
            this.mRoutePlanPreferenceDialogAdapter = new RoutePlanPreferenceDialogAdapter(this.mActivity);
        }
        if (this.mRoutePlanPreferenceDialog == null) {
            this.mRoutePlanPreferenceDialog = new C2282f(this.mActivity, this.mRoutePlanPreferenceDialogAdapter, new OnItemClickListener() {
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    RGRouteDetailsView.this.mOnDialogListener.dismissDialog(RGRouteDetailsView.this.mRoutePlanPreferenceDialog);
                    OnItemClickListener listener = RGRouteDetailsView.this.mRoutePlanPreferenceDialogAdapter.getOnItemClickListener();
                    if (listener != null) {
                        listener.onItemClick(parent, view, position, id);
                    }
                }
            });
            this.mRoutePlanPreferenceDialog.j();
        } else {
            this.mOnDialogListener.dismissDialog(this.mRoutePlanPreferenceDialog);
        }
        this.mOnDialogListener.showDialog(this.mRoutePlanPreferenceDialog, C1265a.Right);
    }
}
