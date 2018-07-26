package com.baidu.navi.fragment;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.carlife.C0965R;
import com.baidu.carlife.adpter.C1010p;
import com.baidu.carlife.core.C0936j;
import com.baidu.carlife.core.C1157a;
import com.baidu.carlife.core.C1251e;
import com.baidu.carlife.core.C1253f;
import com.baidu.carlife.core.C1260i;
import com.baidu.carlife.core.C1261k;
import com.baidu.carlife.core.screen.C0672b;
import com.baidu.carlife.model.C1932k;
import com.baidu.carlife.p078f.C1436a;
import com.baidu.carlife.p078f.C1438c;
import com.baidu.carlife.p078f.C1440d;
import com.baidu.carlife.p078f.C1443g;
import com.baidu.carlife.p084h.C1607b;
import com.baidu.carlife.p087l.C1663a;
import com.baidu.carlife.util.C2201w;
import com.baidu.carlife.view.LoadMoreFooter;
import com.baidu.carlife.view.SwitchButton;
import com.baidu.carlife.view.dialog.C1953c;
import com.baidu.carlife.view.dialog.C2278e;
import com.baidu.carlife.view.p104a.C2251b;
import com.baidu.carlife.view.routerecordprocessview.CycleProcessBar;
import com.baidu.navi.controller.AccountController;
import com.baidu.navi.controller.AccountController.IAccountListener;
import com.baidu.navi.controller.UserCenterController;
import com.baidu.navi.track.common.TrackConfig;
import com.baidu.navi.track.common.TrackConfigUtil;
import com.baidu.navi.track.database.DataBaseConstants.TrackQueryType;
import com.baidu.navi.track.datashop.TrackDataShop;
import com.baidu.navi.track.datashop.TrackShopEvent;
import com.baidu.navi.track.model.CarNaviModel;
import com.baidu.navi.track.sync.TrackDataSync;
import com.baidu.navi.util.NaviAccountUtils;
import com.baidu.navi.util.StatisticConstants;
import com.baidu.navi.util.StatisticManager;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RouteRecordFragment extends ContentFragment implements OnClickListener, C1607b {
    public static final int MSG_DELAY_HIDE_PROGRESS = 9797979;
    private final int ALL_ROUTE_MILEAGE_MAX = 5000;
    private final int LONGEST_STRING = 7;
    private final int MAX_RECORD_NUM = 20;
    private final int SINGLE_LONGEST_TIME_MAX = 1440;
    private final int WEEK_ROUTE_MILEAGE_MAX = 3000;
    private boolean isEditable = false;
    private SwitchButton journeyRecord;
    private int mAllRouteMileage = 0;
    private CycleProcessBar mAllRouteMileagePV;
    private TextView mAllRouteMileageTV;
    ImageButton mBtnBack;
    private C2278e mCommonProgressDialog;
    private ImageButton mEditBtn;
    private TextView mFinishBtn;
    private C1438c mFocusListView;
    private C1443g mFocusTitlebar;
    private LinearLayout mHeaderLayout;
    private View mInpageProcessDialog;
    private boolean mIsFocusable = false;
    private boolean mIsHeaderSyncFinish = true;
    private boolean mIsListItemSyncFinish = true;
    private boolean mIsNoMoreData = false;
    private boolean mIsTriggerLoadMore = false;
    private int mLastRecordTimeStamp = 0;
    private LoadMoreFooter mListFooter;
    private ListView mListView;
    private View mListViewHeader;
    private MsgManualSyncHandler mMsgManualSyncHandler;
    private OnItemClickListener mOnItemClickListener = new C38332();
    private List<C1932k> mRouteRecordList;
    private C1010p mRouteRecordListAdapter;
    private C1953c mSettingPromptDialog;
    private boolean mShowDialoged = false;
    private int mSingleLongestTime = 0;
    private CycleProcessBar mSingleLongestTimePV;
    private TextView mSingleLongestTimeTV;
    private ImageButton mSyncBtn;
    private Object mSyncStatusLock = new Object();
    private TextView mTitleDescTV;
    private TextView mUnitMinuteTV;
    private int mWeekRouteMileage = 0;
    private CycleProcessBar mWeekRouteMileagePV;
    private TextView mWeekRouteMileageTV;
    private RelativeLayout recordHeader;

    /* renamed from: com.baidu.navi.fragment.RouteRecordFragment$1 */
    class C38321 implements OnClickListener {
        C38321() {
        }

        public void onClick(View v) {
            if (RouteRecordFragment.this.isEditable) {
                RouteRecordFragment.this.quitEdit();
            } else {
                RouteRecordFragment.this.back();
            }
        }
    }

    /* renamed from: com.baidu.navi.fragment.RouteRecordFragment$2 */
    class C38332 implements OnItemClickListener {
        C38332() {
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
            boolean z = true;
            if (position == 0 && RouteRecordFragment.this.recordHeader.getVisibility() == 0) {
                boolean z2;
                boolean shouldRecord = TrackConfigUtil.getInstance().getRouteRecordFlag();
                TrackConfigUtil instance = TrackConfigUtil.getInstance();
                if (shouldRecord) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                instance.setRouteRecordFlag(z2);
                SwitchButton access$400 = RouteRecordFragment.this.journeyRecord;
                if (shouldRecord) {
                    z = false;
                }
                access$400.setChecked(z);
            } else if (id >= 0) {
                if (RouteRecordFragment.this.isEditable && RouteRecordFragment.this.mIsFocusable) {
                    RouteRecordFragment.this.deleteRecordItem((int) id);
                }
            } else if (!RouteRecordFragment.this.mIsNoMoreData) {
                RouteRecordFragment.this.mIsTriggerLoadMore = true;
                RouteRecordFragment.this.mListFooter.a();
                RouteRecordFragment.this.getStatisticsInfo();
                RouteRecordFragment.this.getRouteRecord();
            }
        }
    }

    /* renamed from: com.baidu.navi.fragment.RouteRecordFragment$5 */
    class C38365 implements OnFocusChangeListener {
        C38365() {
        }

        public void onFocusChange(View v, boolean hasFocus) {
            if (hasFocus) {
                RouteRecordFragment.this.mIsFocusable = true;
            }
        }
    }

    /* renamed from: com.baidu.navi.fragment.RouteRecordFragment$6 */
    class C38376 implements IAccountListener {
        C38376() {
        }

        public void onLogResult(boolean success) {
            if (success) {
                StatisticManager.onEvent(StatisticConstants.HOME_MINE_0006);
                UserCenterController.getInstance().startUpdateUserInfo(1, null);
                RouteRecordFragment.this.manualSync();
            }
        }
    }

    /* renamed from: com.baidu.navi.fragment.RouteRecordFragment$7 */
    class C38387 implements C0672b {
        C38387() {
        }

        public void onClick() {
            RouteRecordFragment.this.dismissDialog(RouteRecordFragment.this.mSettingPromptDialog);
        }
    }

    private class MsgManualSyncHandler extends C0936j {
        private MsgManualSyncHandler() {
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case C1253f.eJ /*700*/:
                    if (msg.obj.status != 0) {
                        RouteRecordFragment.this.hideInPageProcessDialog();
                        RouteRecordFragment.this.syncFailedPrompt();
                    }
                    RouteRecordFragment.this.setManualSyncTime(RouteRecordFragment.this.getCurrentDateTime());
                    RouteRecordFragment.this.updateTitleUpdateTime();
                    RouteRecordFragment.this.mIsTriggerLoadMore = false;
                    RouteRecordFragment.this.clearRouteRecordList();
                    RouteRecordFragment.this.getStatisticsInfo();
                    RouteRecordFragment.this.getRouteRecord();
                    return;
                case RouteRecordFragment.MSG_DELAY_HIDE_PROGRESS /*9797979*/:
                    RouteRecordFragment.this.mInpageProcessDialog.setVisibility(8);
                    return;
                default:
                    return;
            }
        }

        public void careAbout() {
            addMsg(C1253f.eJ);
        }
    }

    protected View onCreateContentView(LayoutInflater inflater) {
        View contentView = inflater.inflate(C0965R.layout.frag_route_record, null);
        init(contentView);
        this.mIsTriggerLoadMore = false;
        return contentView;
    }

    private void init(View contentView) {
        setCommonTitleBar(contentView, getResources().getStringArray(C0965R.array.home_my)[0]);
        this.mBtnBack = (ImageButton) contentView.findViewById(C0965R.id.ib_left);
        this.mBtnBack.setOnClickListener(new C38321());
        this.mTitleDescTV = (TextView) contentView.findViewById(C0965R.id.tv_title_desc);
        this.mTitleDescTV.setVisibility(0);
        this.mListView = (ListView) contentView.findViewById(C0965R.id.listview);
        this.mListView.setOverScrollMode(2);
        this.mListView.setFooterDividersEnabled(false);
        this.mListViewHeader = LayoutInflater.from(mActivity).inflate(C0965R.layout.view_route_record_header, this.mListView, false);
        this.mHeaderLayout = (LinearLayout) this.mListViewHeader.findViewById(C0965R.id.ll_header);
        this.mAllRouteMileagePV = (CycleProcessBar) this.mListViewHeader.findViewById(C0965R.id.vi_all_distance).findViewById(C0965R.id.vi_process);
        this.mWeekRouteMileagePV = (CycleProcessBar) this.mListViewHeader.findViewById(C0965R.id.vi_week_distance).findViewById(C0965R.id.vi_process);
        this.mSingleLongestTimePV = (CycleProcessBar) this.mListViewHeader.findViewById(C0965R.id.vi_single_longest_time).findViewById(C0965R.id.vi_process);
        this.mAllRouteMileageTV = (TextView) this.mListViewHeader.findViewById(C0965R.id.vi_all_distance).findViewById(C0965R.id.tv_parmeter);
        this.mWeekRouteMileageTV = (TextView) this.mListViewHeader.findViewById(C0965R.id.vi_week_distance).findViewById(C0965R.id.tv_parmeter);
        this.mSingleLongestTimeTV = (TextView) this.mListViewHeader.findViewById(C0965R.id.vi_single_longest_time).findViewById(C0965R.id.tv_parmeter);
        this.mUnitMinuteTV = (TextView) this.mListViewHeader.findViewById(C0965R.id.vi_single_longest_time).findViewById(C0965R.id.tv_unit_single_longest_time);
        this.mUnitMinuteTV.setText(getResources().getString(C0965R.string.minutes));
        this.mUnitMinuteTV.setTextSize(12.0f);
        setAllRouteMileage((float) this.mAllRouteMileage);
        setWeekRouteMileage((float) this.mWeekRouteMileage);
        setSingleLogestTime((float) this.mSingleLongestTime);
        View switchHeader = LayoutInflater.from(getActivity()).inflate(C0965R.layout.route_record_switch_header, this.mListView, false);
        this.recordHeader = (RelativeLayout) switchHeader.findViewById(C0965R.id.switch_header);
        ((TextView) this.recordHeader.findViewById(C0965R.id.tv_item_name)).setText(getText(C0965R.string.journey_setting_auto_record));
        this.journeyRecord = (SwitchButton) this.recordHeader.findViewById(C0965R.id.sw_voice_wakeup);
        this.journeyRecord.setChecked(TrackConfigUtil.getInstance().getRouteRecordFlag());
        this.journeyRecord.setClickable(false);
        this.recordHeader.setVisibility(8);
        this.recordHeader.setEnabled(false);
        this.mListView.addHeaderView(switchHeader, null, true);
        this.mListView.addHeaderView(this.mListViewHeader, null, false);
        this.mListFooter = new LoadMoreFooter(getContext());
        this.mListFooter.setStatus(1);
        this.mListView.addFooterView(this.mListFooter);
        this.mRouteRecordListAdapter = new C1010p(getContext());
        this.mRouteRecordList = new ArrayList();
        this.mRouteRecordListAdapter.a(this.mRouteRecordList);
        this.mListView.setAdapter(this.mRouteRecordListAdapter);
        this.mListView.setOnItemClickListener(this.mOnItemClickListener);
        this.mSyncBtn = (ImageButton) contentView.findViewById(C0965R.id.ib_right0);
        this.mSyncBtn.setImageResource(C0965R.drawable.com_ic_synchronization);
        this.mSyncBtn.setBackground(C2251b.a(mActivity));
        this.mSyncBtn.setVisibility(0);
        this.mSyncBtn.setOnClickListener(this);
        this.mEditBtn = (ImageButton) contentView.findViewById(C0965R.id.ib_right);
        this.mEditBtn.setImageResource(C0965R.drawable.com_ic_management);
        this.mEditBtn.setBackground(C2251b.a(mActivity));
        this.mEditBtn.setOnClickListener(this);
        this.mFinishBtn = (TextView) contentView.findViewById(C0965R.id.tv_over_right_imgbtn);
        this.mFinishBtn.setBackground(C2251b.a(mActivity));
        this.mFinishBtn.setOnClickListener(this);
        this.mInpageProcessDialog = contentView.findViewById(C0965R.id.vi_in_page_process_dialog);
        this.mInpageProcessDialog.setBackgroundColor(getResources().getColor(C0965R.color.cl_bg_e_dialog));
        ((TextView) this.mInpageProcessDialog.findViewById(C0965R.id.tv_process_content)).setTextColor(getResources().getColor(C0965R.color.cl_text_b_dialog));
        this.mMsgManualSyncHandler = new MsgManualSyncHandler();
        C1261k.a(this.mMsgManualSyncHandler);
    }

    protected void onInitView() {
        if (C1663a.a().N() && !isLogin()) {
            this.mSyncBtn.setVisibility(8);
        }
        this.mIsNoMoreData = false;
        this.mIsFocusable = false;
        if (!isLastTimeSyncFinished()) {
            showInPageProcessDialog();
        }
        updateTitleUpdateTime();
        clearRouteRecordList();
        getStatisticsInfo();
        getRouteRecord();
    }

    public void onDestroyView() {
        if (this.mSettingPromptDialog != null) {
            dismissDialog(this.mSettingPromptDialog);
        }
        super.onDestroyView();
    }

    public void onDestroy() {
        C1261k.b(this.mMsgManualSyncHandler);
        super.onDestroy();
    }

    protected void onUpdateOrientation(int orientation) {
    }

    protected void onUpdateStyle(boolean dayStyle) {
    }

    protected void onUpdateSkin() {
        super.onUpdateSkin();
        updateCommonSkin();
    }

    protected void onInit() {
        super.onInit();
        if (!TrackConfigUtil.getInstance().getRouteRecordFlag() && !this.mShowDialoged) {
            this.mShowDialoged = true;
            showSettingPromptDialog(C1157a.a());
        }
    }

    public void onInitFocusAreas() {
        if (this.fragmentType == getCurrentFragmentType()) {
            if (this.mFocusTitlebar == null) {
                this.mFocusTitlebar = new C1443g(this.mContentView.findViewById(C0965R.id.title_bar), 2);
                C1443g viewGroup = this.mFocusTitlebar.d(this.mContentView.findViewById(C0965R.id.ib_left));
                viewGroup.d(this.mSyncBtn);
                viewGroup.d(this.mEditBtn);
                viewGroup.d(this.mFinishBtn);
            }
            if (this.mFocusListView == null) {
                this.mFocusListView = new C1438c(this.mListView, 6);
            }
            setFocusListener(this.mContentView.findViewById(C0965R.id.ib_left));
            setFocusListener(this.mSyncBtn);
            setFocusListener(this.mEditBtn);
            setFocusListener(this.mFinishBtn);
            setFocusListener(this.mListView);
            C1440d.a().b(new C1436a[]{this.mFocusTitlebar, this.mFocusListView});
            if (this.mRouteRecordListAdapter == null || this.mRouteRecordListAdapter.getCount() <= 0) {
                C1440d.a().h(this.mFocusTitlebar);
            } else {
                C1440d.a().h(this.mFocusListView);
            }
        }
    }

    public synchronized void deleteRecordItem(int position) {
        if (this.mRouteRecordList != null && position >= 0 && position < this.mRouteRecordList.size()) {
            CarNaviModel model = ((C1932k) this.mRouteRecordList.get(position)).f6079i;
            this.mRouteRecordList.remove(position);
            this.mRouteRecordListAdapter.notifyDataSetChanged();
            TrackDataShop.getInstance().deleteRecord(null, model);
        }
    }

    private void setAllRouteMileage(float distance) {
        this.mAllRouteMileageTV.setText("" + ((int) distance));
        this.mAllRouteMileagePV.setmPercent(distance / 5000.0f);
    }

    private void setWeekRouteMileage(float distance) {
        this.mWeekRouteMileageTV.setText("" + ((int) distance));
        this.mWeekRouteMileagePV.setmPercent(distance / 3000.0f);
    }

    private void setSingleLogestTime(float time) {
        this.mSingleLongestTimeTV.setText("" + ((int) time));
        this.mSingleLongestTimePV.setmPercent(time / 1440.0f);
    }

    private void enableEdit() {
        showFinishIcon();
        this.mSyncBtn.setVisibility(8);
        int isHeaderVisiable = this.mHeaderLayout.getVisibility();
        this.mHeaderLayout.setVisibility(8);
        this.recordHeader.setVisibility(0);
        this.recordHeader.setEnabled(true);
        for (C1932k model : this.mRouteRecordList) {
            model.f6071a = true;
            if (this.mIsFocusable) {
                model.f6080j = true;
            } else {
                model.f6080j = false;
            }
        }
        this.mRouteRecordListAdapter.notifyDataSetChanged();
        if (this.mListView.getFirstVisiblePosition() <= 0) {
            this.mListView.smoothScrollToPosition(0);
        }
    }

    private void disableEdit() {
        showEditIcon();
        if (!C1663a.a().N() || isLogin()) {
            this.mSyncBtn.setVisibility(0);
        } else {
            this.mSyncBtn.setVisibility(8);
        }
        this.mHeaderLayout.setVisibility(0);
        this.recordHeader.setVisibility(8);
        for (C1932k model : this.mRouteRecordList) {
            model.f6071a = false;
        }
        getStatisticsInfo();
        this.mRouteRecordListAdapter.notifyDataSetChanged();
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case C0965R.id.ib_right0:
                if (!isNetworkAvailable()) {
                    syncFailedPrompt();
                    return;
                } else if (isLogin()) {
                    manualSync();
                    return;
                } else {
                    toLoginWebView();
                    return;
                }
            case C0965R.id.ib_right:
                this.isEditable = !this.isEditable;
                enableEdit();
                return;
            case C0965R.id.tv_over_right_imgbtn:
                quitEdit();
                return;
            default:
                return;
        }
    }

    public boolean onBackPressed() {
        if (!this.isEditable) {
            return false;
        }
        quitEdit();
        return true;
    }

    private void getStatisticsInfo() {
        setHeaderSyncStatus(false);
        beforeSyncProcess();
        TrackDataShop.getInstance().fetchStatistics(new Handler(Looper.getMainLooper()) {
            public void handleMessage(Message msg) {
                switch (msg.what) {
                    case 5:
                        TrackShopEvent trackShopEvent = msg.obj;
                        if (trackShopEvent.status == 0) {
                            RouteRecordFragment.this.setHeaderSyncStatus(true);
                            RouteRecordFragment.this.afterSyncProcess();
                            RouteRecordFragment.this.mAllRouteMileage = trackShopEvent.statistic.getCarNintaviDistance() / 1000;
                            RouteRecordFragment.this.mWeekRouteMileage = trackShopEvent.statistic.getCarWeekMileage() / 1000;
                            RouteRecordFragment.this.mSingleLongestTime = trackShopEvent.statistic.getCarMaxDuration() / 60;
                            RouteRecordFragment.this.setAllRouteMileage((float) RouteRecordFragment.this.mAllRouteMileage);
                            RouteRecordFragment.this.setWeekRouteMileage((float) RouteRecordFragment.this.mWeekRouteMileage);
                            RouteRecordFragment.this.setSingleLogestTime((float) RouteRecordFragment.this.mSingleLongestTime);
                            return;
                        }
                        RouteRecordFragment.this.syncFailedPrompt();
                        return;
                    default:
                        return;
                }
            }
        }, 0);
    }

    private void getRouteRecord() {
        setmIsListItemSyncStatus(false);
        beforeSyncProcess();
        TrackDataShop.getInstance().fetchTrackList(new Handler(Looper.getMainLooper()) {
            public void handleMessage(Message msg) {
                switch (msg.what) {
                    case 1:
                        TrackShopEvent trackShopEvent = msg.obj;
                        if (trackShopEvent.status == 0) {
                            RouteRecordFragment.this.setmIsListItemSyncStatus(true);
                            RouteRecordFragment.this.afterSyncProcess();
                            CarNaviModel carNaviModle = null;
                            for (CarNaviModel carNaviModle2 : trackShopEvent.list) {
                                RouteRecordFragment.this.addRouteRecordModel(carNaviModle2);
                            }
                            RouteRecordFragment.this.updateRouteRecordModelList();
                            if (carNaviModle2 != null) {
                                RouteRecordFragment.this.mLastRecordTimeStamp = carNaviModle2.getPBData().getCtime();
                            }
                        } else {
                            RouteRecordFragment.this.syncFailedPrompt();
                        }
                        if (trackShopEvent.status != 0 || trackShopEvent.list.size() >= 20) {
                            RouteRecordFragment.this.mListFooter.setTextContent(RouteRecordFragment.this.getResources().getString(C0965R.string.route_record_footer_text_has_more_data));
                            RouteRecordFragment.this.mIsNoMoreData = false;
                            return;
                        }
                        RouteRecordFragment.this.mListFooter.setTextContent(C1157a.a().getString(C0965R.string.route_record_footer_text_no_more_data));
                        RouteRecordFragment.this.mIsNoMoreData = true;
                        return;
                    default:
                        return;
                }
            }
        }, NaviAccountUtils.getInstance().getUid(), this.mLastRecordTimeStamp, TrackQueryType.CAR);
    }

    private void addRouteRecordModel(CarNaviModel model) {
        C1932k item = new C1932k();
        item.f6072b = stringCut(model.getPBData().getStartPoint().getAddr());
        item.f6073c = stringCut(model.getPBData().getEndPoint().getAddr());
        double distance = (1.0d * ((double) model.getPBData().getDistance())) / 1000.0d;
        item.f6074d = String.format("%.2f", new Object[]{Double.valueOf(distance)}) + "km";
        item.f6075e = "" + (model.getPBData().getDuration() / 60) + getResources().getString(C0965R.string.minutes);
        item.f6076f = "" + ((int) ((model.getPBData().getAvgSpeed() / 1000.0d) * 3600.0d)) + "km/h";
        String[] dateSet = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(new Date((1 * ((long) model.getPBData().getCtime())) * 1000)).trim().split(" ");
        if (dateSet.length > 0) {
            item.f6077g = dateSet[0];
        }
        if (dateSet.length > 1) {
            item.f6078h = dateSet[1];
        }
        item.f6079i = model;
        item.f6081k = this;
        routeRecordListAddItem(item);
    }

    private void routeRecordListAddItem(C1932k item) {
        item.f6071a = this.isEditable;
        this.mRouteRecordList.add(item);
    }

    private void updateRouteRecordModelList() {
        this.mRouteRecordListAdapter.notifyDataSetChanged();
    }

    private void syncFailedPrompt() {
        C2201w.a(getString(C0965R.string.route_record_sync_failed_prompt), 0);
    }

    private void showEditIcon() {
        this.mFinishBtn.setVisibility(8);
        this.mEditBtn.setVisibility(0);
    }

    private void showFinishIcon() {
        this.mEditBtn.setVisibility(8);
        this.mFinishBtn.setVisibility(0);
    }

    private void hideEditFinishIcon() {
        this.mEditBtn.setVisibility(8);
        this.mFinishBtn.setVisibility(8);
    }

    private String getCurrentDateTime() {
        return new SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(new Date(TrackConfig.getInstance().getLastSyncTime()));
    }

    private void updateTitleUpdateTime() {
        if (isLogin()) {
            String dateTime = getManualSyncTime();
            if (dateTime != null) {
                this.mTitleDescTV.setText(dateTime + " " + getResources().getString(C0965R.string.nsdk_string_dl_update));
                return;
            }
            return;
        }
        this.mTitleDescTV.setText(C0965R.string.route_record_prompt_login_sync);
    }

    private void setHeaderSyncStatus(boolean isFinished) {
        synchronized (this.mSyncStatusLock) {
            this.mIsHeaderSyncFinish = isFinished;
        }
    }

    private void setmIsListItemSyncStatus(boolean isFinished) {
        synchronized (this.mSyncStatusLock) {
            this.mIsListItemSyncFinish = isFinished;
        }
    }

    private boolean isSyncFinished() {
        boolean z;
        synchronized (this.mSyncStatusLock) {
            if (this.mIsHeaderSyncFinish && this.mIsListItemSyncFinish) {
                z = true;
            } else {
                z = false;
            }
        }
        return z;
    }

    private void beforeSyncProcess() {
        hideUpdateWidget();
        showInPageProcessDialog();
    }

    private void afterSyncProcess() {
        if (isSyncFinished()) {
            showUpdateWidget();
            hideInPageProcessDialog();
        }
    }

    private void showInPageProcessDialog() {
        if (!this.mIsTriggerLoadMore) {
            this.mMsgManualSyncHandler.removeMessages(MSG_DELAY_HIDE_PROGRESS);
            this.mInpageProcessDialog.setVisibility(0);
        }
    }

    private void hideInPageProcessDialog() {
        this.mMsgManualSyncHandler.sendEmptyMessageDelayed(MSG_DELAY_HIDE_PROGRESS, 500);
    }

    private void setFocusListener(View view) {
        view.setOnFocusChangeListener(new C38365());
    }

    private String stringCut(String str) {
        if (str.length() > 7) {
            return str.substring(0, 7) + "...";
        }
        return str;
    }

    private void hideUpdateWidget() {
        this.mSyncBtn.setVisibility(8);
        this.mFinishBtn.setVisibility(8);
        this.mEditBtn.setVisibility(8);
        this.mListFooter.setStatus(0);
    }

    private void showUpdateWidget() {
        if ((!C1663a.a().N() || isLogin()) && !this.isEditable) {
            this.mSyncBtn.setVisibility(0);
        } else {
            this.mSyncBtn.setVisibility(8);
        }
        if (this.isEditable) {
            this.mFinishBtn.setVisibility(0);
        } else {
            this.mEditBtn.setVisibility(0);
        }
        this.mListFooter.setStatus(1);
    }

    private void toLoginWebView() {
        StatisticManager.onEvent(StatisticConstants.HOME_MINE_0001, StatisticConstants.HOME_ACCOUNT_LOGIN_002);
        AccountController.getInstance().loginIn(new C38376());
    }

    private void manualSync() {
        if (TrackDataSync.getInstance().manualSync()) {
            hideUpdateWidget();
            showInPageProcessDialog();
        }
    }

    private void quitEdit() {
        this.isEditable = !this.isEditable;
        disableEdit();
    }

    private String getManualSyncTime() {
        return getContext().getSharedPreferences(C1253f.ia, 0).getString(C1253f.ij, null);
    }

    private void setManualSyncTime(String time) {
        Editor editor = getContext().getSharedPreferences(C1253f.ia, 0).edit();
        editor.putString(C1253f.ij, time);
        editor.commit();
    }

    private void clearRouteRecordList() {
        this.mLastRecordTimeStamp = 0;
        this.mRouteRecordListAdapter.notifyDataSetInvalidated();
        this.mRouteRecordList.clear();
    }

    private boolean isLastTimeSyncFinished() {
        return !TrackDataSync.getInstance().isSyncing();
    }

    private boolean isLogin() {
        return NaviAccountUtils.getInstance().isLogin();
    }

    private boolean isNetworkAvailable() {
        return C1251e.a().r();
    }

    private void showSettingPromptDialog(Context context) {
        if (context != null) {
            this.mSettingPromptDialog = new C1953c(context);
            this.mSettingPromptDialog.c(C0965R.string.route_record_alert_confirm);
            this.mSettingPromptDialog.a(C0965R.string.route_record_alert_content);
            this.mSettingPromptDialog.a(new C38387());
            showDialog(this.mSettingPromptDialog);
        }
    }

    public void onResume() {
        super.onResume();
        if (getNaviFragmentManager().isDriving()) {
            C1260i.b("yftech", "RouteRecordFragment onResume driving");
            drivingDisableClick();
            return;
        }
        C1260i.b("yftech", "RouteRecordFragment onResume stopDriving");
        drivingEnabledClick();
    }

    public void driving() {
        C1260i.b("yftech", "RouteRecordFragment driving");
        drivingDisableClick();
    }

    public void stopDriving() {
        C1260i.b("yftech", "RouteRecordFragment stopDriving");
        drivingEnabledClick();
    }

    private void drivingEnabledClick() {
        this.mEditBtn.setAlpha(1.0f);
        this.mEditBtn.setEnabled(true);
        this.mSyncBtn.setAlpha(1.0f);
        this.mSyncBtn.setEnabled(true);
    }

    private void drivingDisableClick() {
        this.mEditBtn.setAlpha(0.2f);
        this.mEditBtn.setEnabled(false);
        if (isLogin()) {
            this.mSyncBtn.setAlpha(1.0f);
            this.mSyncBtn.setEnabled(true);
            return;
        }
        this.mSyncBtn.setAlpha(0.2f);
        this.mSyncBtn.setEnabled(false);
    }
}
