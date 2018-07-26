package com.baidu.navi.fragment.carmode;

import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import com.baidu.baidumaps.p042f.p043a.p044a.C0705a;
import com.baidu.baidunavis.control.NavMapManager;
import com.baidu.carlife.C0965R;
import com.baidu.carlife.core.C0936j;
import com.baidu.carlife.core.C1157a;
import com.baidu.carlife.core.C1251e;
import com.baidu.carlife.core.C1253f;
import com.baidu.carlife.core.C1260i;
import com.baidu.carlife.core.C1261k;
import com.baidu.carlife.custom.C1343b;
import com.baidu.carlife.p078f.C1436a;
import com.baidu.carlife.p078f.C1438c;
import com.baidu.carlife.p078f.C1440d;
import com.baidu.carlife.p078f.C1443g;
import com.baidu.carlife.util.C2201w;
import com.baidu.carlife.view.CommonTipView;
import com.baidu.carlife.view.LoadMoreFooter;
import com.baidu.carlife.view.p104a.C2251b;
import com.baidu.navi.adapter.FavoritePoisListAdapter;
import com.baidu.navi.controller.AccountController;
import com.baidu.navi.controller.AccountController.IAccountListener;
import com.baidu.navi.favorite.FavoriteConfig;
import com.baidu.navi.favorite.FavoritePois;
import com.baidu.navi.favorite.sync.FavoriteDataSync;
import com.baidu.navi.fragment.ContentFragment;
import com.baidu.navi.interfaces.IFavoriteFragUiUpdateHandler;
import com.baidu.navi.util.NaviAccountUtils;
import com.baidu.navi.util.StatisticConstants;
import com.baidu.navi.util.StatisticManager;
import com.baidu.navisdk.util.common.NetworkUtils;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CarModeFavoriteFragment extends ContentFragment implements OnClickListener {
    private boolean isLoadMore = false;
    private int lastIndex = 0;
    private ImageButton mBtnBack;
    private ImageButton mEditBtn;
    private FavoritePoisListAdapter mFavoritesRecordListAdapter;
    private TextView mFinishBtn;
    private C1438c mFocusListView;
    private C1443g mFocusTitlebar;
    private boolean mIsEditable = false;
    private boolean mIsFocusable = false;
    private LoadMoreFooter mListFooter;
    private ListView mListView;
    private OnItemClickListener mOnItemClickListener = new C38635();
    private ImageButton mSyncBtn;
    private C0936j mSyncHandler;
    private CommonTipView mTipView;
    private TextView mTitleDescTv;
    private String mUpdateTime = "";
    private ViewGroup mViewGroup;

    /* renamed from: com.baidu.navi.fragment.carmode.CarModeFavoriteFragment$1 */
    class C38591 implements OnClickListener {
        C38591() {
        }

        public void onClick(View v) {
            if (CarModeFavoriteFragment.this.mIsEditable) {
                CarModeFavoriteFragment.this.quiteEditMode();
            } else {
                CarModeFavoriteFragment.this.back();
            }
        }
    }

    /* renamed from: com.baidu.navi.fragment.carmode.CarModeFavoriteFragment$2 */
    class C38602 implements OnClickListener {
        C38602() {
        }

        public void onClick(View v) {
            CarModeFavoriteFragment.this.isLoadMore = true;
            CarModeFavoriteFragment.this.lastIndex = CarModeFavoriteFragment.this.mFavoritesRecordListAdapter.getCount() - 1;
            CarModeFavoriteFragment.this.mFavoritesRecordListAdapter.updateData();
        }
    }

    /* renamed from: com.baidu.navi.fragment.carmode.CarModeFavoriteFragment$3 */
    class C38613 implements IFavoriteFragUiUpdateHandler {
        C38613() {
        }

        public void showLoadMoreFooter() {
            CarModeFavoriteFragment.this.mListFooter.setVisibility(0);
        }

        public void hideLoadMoreFooter() {
            if (!CarModeFavoriteFragment.this.mIsEditable) {
                CarModeFavoriteFragment.this.mListFooter.setVisibility(8);
            }
        }

        public void footerShowLoadMore() {
            CarModeFavoriteFragment.this.mListFooter.setTextContent(C1157a.a().getResources().getString(C0965R.string.route_record_footer_text_has_more_data));
        }

        public void footerShowNoMore() {
            CarModeFavoriteFragment.this.mListFooter.setTextContent(C1157a.a().getString(C0965R.string.route_record_footer_text_no_more_data));
        }

        public void showEditBtn() {
            CarModeFavoriteFragment.this.updateEditBtn();
        }

        public void hideEditBtn() {
            CarModeFavoriteFragment.this.mEditBtn.setVisibility(8);
        }

        public void syncEnd() {
            if (CarModeFavoriteFragment.this.isLoadMore) {
                if (CarModeFavoriteFragment.this.mFavoritesRecordListAdapter.getCount() > 0 && CarModeFavoriteFragment.this.lastIndex < CarModeFavoriteFragment.this.mFavoritesRecordListAdapter.getCount()) {
                    CarModeFavoriteFragment.this.mListView.setSelection(CarModeFavoriteFragment.this.lastIndex);
                }
            } else if (CarModeFavoriteFragment.this.mFavoritesRecordListAdapter.getCount() > 0) {
                CarModeFavoriteFragment.this.mListView.setSelection(0);
            }
            CarModeFavoriteFragment.this.isLoadMore = false;
        }
    }

    /* renamed from: com.baidu.navi.fragment.carmode.CarModeFavoriteFragment$4 */
    class C38624 implements OnFocusChangeListener {
        C38624() {
        }

        public void onFocusChange(View v, boolean hasFocus) {
            if (hasFocus) {
                CarModeFavoriteFragment.this.mIsFocusable = true;
            }
        }
    }

    /* renamed from: com.baidu.navi.fragment.carmode.CarModeFavoriteFragment$5 */
    class C38635 implements OnItemClickListener {
        C38635() {
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
            if (CarModeFavoriteFragment.this.mFavoritesRecordListAdapter == null) {
                return;
            }
            if (!CarModeFavoriteFragment.this.mIsEditable) {
                CarModeFavoriteFragment.this.mFavoritesRecordListAdapter.startCalcRoute(position);
            } else if (CarModeFavoriteFragment.this.mIsFocusable && id == 100) {
                CarModeFavoriteFragment.this.mFavoritesRecordListAdapter.deleteFavItemBackgroud(position);
            }
        }
    }

    /* renamed from: com.baidu.navi.fragment.carmode.CarModeFavoriteFragment$6 */
    class C38646 implements IAccountListener {
        C38646() {
        }

        public void onLogResult(boolean success) {
            StatisticManager.onEvent(StatisticConstants.NAVI_0029);
            FavoriteDataSync.getInstance().manualSync();
        }
    }

    private class SyncHandler extends C0936j {
        private SyncHandler() {
        }

        public void handleMessage(Message msg) {
            if (msg.what == C1253f.eK) {
                FavoriteConfig.getInstance().setIsSynced(true);
                CarModeFavoriteFragment.this.updateTitleUpdateTime();
                CarModeFavoriteFragment.this.mFavoritesRecordListAdapter.getFavoriteFragStatusListener().clearListViewData();
                CarModeFavoriteFragment.this.updateData();
            }
            if (msg.what == 1004) {
                CarModeFavoriteFragment.this.updateEditBtn();
            }
            if (msg.what == 1002) {
                CarModeFavoriteFragment.this.updateEditBtn();
            }
        }

        public void careAbout() {
            addMsg(C1253f.eK);
            addMsg(1004);
            addMsg(1002);
        }
    }

    protected View onCreateContentView(LayoutInflater inflater) {
        this.mViewGroup = (ViewGroup) inflater.inflate(C0965R.layout.frag_navi_favorite, null);
        initView(this.mViewGroup);
        this.mSyncHandler = new SyncHandler();
        C1261k.a(this.mSyncHandler);
        return this.mViewGroup;
    }

    private void initView(ViewGroup contenView) {
        setCommonTitleBar(this.mViewGroup, getResources().getString(C0965R.string.carlife_map_ctrl_favorite));
        this.mBtnBack = (ImageButton) contenView.findViewById(C0965R.id.ib_left);
        this.mBtnBack.setOnClickListener(new C38591());
        this.mTitleDescTv = (TextView) contenView.findViewById(C0965R.id.tv_title_desc);
        this.mTitleDescTv.setVisibility(0);
        this.mListView = (ListView) contenView.findViewById(C0965R.id.lv_list_view);
        this.mListView.setOverScrollMode(2);
        this.mSyncBtn = (ImageButton) contenView.findViewById(C0965R.id.ib_right0);
        this.mSyncBtn.setImageResource(C0965R.drawable.com_ic_synchronization);
        this.mSyncBtn.setBackground(C2251b.a(mActivity));
        this.mSyncBtn.setVisibility(0);
        this.mSyncBtn.setOnClickListener(this);
        this.mEditBtn = (ImageButton) contenView.findViewById(C0965R.id.ib_right);
        this.mEditBtn.setImageResource(C0965R.drawable.com_ic_edit);
        this.mEditBtn.setVisibility(0);
        this.mEditBtn.setBackground(C2251b.a(mActivity));
        this.mEditBtn.setOnClickListener(this);
        this.mFinishBtn = (TextView) contenView.findViewById(C0965R.id.tv_over_right_imgbtn);
        this.mFinishBtn.setText(C0965R.string.carlife_map_data_finish);
        this.mFinishBtn.setBackground(C2251b.a(mActivity));
        this.mFinishBtn.setOnClickListener(this);
        this.mFavoritesRecordListAdapter = new FavoritePoisListAdapter(getContext(), this);
        this.mListView.setAdapter(this.mFavoritesRecordListAdapter);
        this.mListView.setOnItemClickListener(this.mOnItemClickListener);
        this.mListView.setDivider(null);
        this.mTipView = (CommonTipView) contenView.findViewById(C0965R.id.common_tip_view);
        this.mTipView.a(C0965R.string.error_no_favorites, C0965R.drawable.com_ic_favorite_empty);
        this.mTipView.a(0);
        this.mListView.setEmptyView(this.mTipView);
        this.mListFooter = new LoadMoreFooter(getContext());
        this.mListFooter.setStatus(1);
        this.mListFooter.setOnClickListener(new C38602());
        this.mListView.addFooterView(this.mListFooter);
        this.mFavoritesRecordListAdapter.setFavoriteFragUiUpdateHandler(new C38613());
        this.mFavoritesRecordListAdapter.updateData();
    }

    public void onResume() {
        super.onResume();
        autoSyncFavData();
        if (getNaviFragmentManager().isDriving()) {
            C1260i.b("yftech", "CarModeFavoriteFragment onResume driving");
            drivingDisableClick();
        } else {
            C1260i.b("yftech", "CarModeFavoriteFragment onResume stopDriving");
            drivingEnabledClick();
        }
        if (NavMapManager.getInstance().getNaviMapMode() == 5) {
            C0705a.a().e();
            C0705a.a().g();
            NavMapManager.getInstance().handleMapOverlays(0);
            NavMapManager.getInstance().setNaviMapMode(0);
            NavMapManager.getInstance().showCarResultLayer(false);
        }
    }

    public void onDestroy() {
        C1261k.b(this.mSyncHandler);
        super.onDestroy();
    }

    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (this.mEditBtn != null && this.mSyncBtn != null) {
            updateEditBtn();
            updateSyncBtn();
        }
    }

    protected void onInitView() {
        updateTitleUpdateTime();
        updateSyncBtn();
        updateEditBtn();
    }

    protected void onUpdateOrientation(int orientation) {
    }

    protected void onUpdateStyle(boolean dayStyle) {
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case C0965R.id.ib_right0:
                if (isConnectedwithVehicle() && !isLogin()) {
                    C2201w.a(getResources().getString(C0965R.string.navi_favorite_prompt_safe_sync));
                    return;
                } else if (isLogin()) {
                    FavoriteDataSync.getInstance().manualSync();
                    return;
                } else {
                    toLoginWebView();
                    return;
                }
            case C0965R.id.ib_right:
                this.mListView.setEmptyView(null);
                this.mIsEditable = true;
                updateEditBtn();
                this.mFavoritesRecordListAdapter.getFavoriteFragStatusListener().editEnable();
                return;
            case C0965R.id.tv_over_right_imgbtn:
                this.mListView.setEmptyView(this.mTipView);
                quiteEditMode();
                return;
            default:
                return;
        }
    }

    public void onInitFocusAreas() {
        if (this.mFocusTitlebar == null) {
            this.mFocusTitlebar = new C1443g(this.mContentView.findViewById(C0965R.id.title_bar), 2);
            C1443g viewGroup = this.mFocusTitlebar.d(this.mContentView.findViewById(C0965R.id.ib_left));
            viewGroup.d(this.mSyncBtn);
            viewGroup.d(this.mEditBtn);
            viewGroup.d(this.mFinishBtn);
        }
        if (this.mFocusListView == null) {
            this.mFocusListView = new C1438c(this.mListView, 4);
        }
        setFocusListener(this.mContentView.findViewById(C0965R.id.ib_left));
        setFocusListener(this.mSyncBtn);
        setFocusListener(this.mEditBtn);
        setFocusListener(this.mFinishBtn);
        setFocusListener(this.mListView);
        C1440d.a().b(new C1436a[]{this.mFocusTitlebar, this.mFocusListView});
        if (this.mFavoritesRecordListAdapter == null || this.mFavoritesRecordListAdapter.getCount() <= 0) {
            C1440d.a().h(this.mFocusTitlebar);
            return;
        }
        C1440d.a().h(this.mFocusListView);
        this.mFocusListView.e();
    }

    public boolean onBackPressed() {
        if (!this.mIsEditable) {
            return false;
        }
        quiteEditMode();
        return true;
    }

    private void setFocusListener(View view) {
        view.setOnFocusChangeListener(new C38624());
    }

    private void updateData() {
        if (this.mFavoritesRecordListAdapter != null) {
            this.mFavoritesRecordListAdapter.updateData();
        }
    }

    private void autoSyncFavData() {
        if (!FavoriteConfig.getInstance().isSynced() && NaviAccountUtils.getInstance().isLogin() && NetworkUtils.isNetworkAvailable(C1157a.a()) && !FavoritePois.getPoiInstance().isBackGetFavInfoTaskIsRun() && !FavoriteDataSync.getInstance().isSyncing()) {
            FavoriteConfig.getInstance().setIsSynced(true);
            this.mFavoritesRecordListAdapter.getFavoriteFragStatusListener().clearListViewData();
            FavoriteDataSync.getInstance().manualSync();
        }
    }

    private void updateTitleUpdateTime() {
        if (isLogin()) {
            String dateTime = getManualSyncTime();
            if (dateTime != null && dateTime.length() != 0) {
                this.mTitleDescTv.setText(dateTime + " " + getResources().getString(C0965R.string.nsdk_string_dl_update));
                return;
            }
            return;
        }
        this.mTitleDescTv.setText(C0965R.string.navi_favorite_prompt_login_sync);
    }

    private void updateSyncBtn() {
        if (this.mIsEditable) {
            this.mSyncBtn.setVisibility(8);
            return;
        }
        this.mSyncBtn.setVisibility(0);
        if (!isConnectedwithVehicle() || isLogin()) {
            this.mSyncBtn.setAlpha(255);
            return;
        }
        this.mSyncBtn.setAlpha(102);
        this.mSyncBtn.setVisibility(8);
    }

    private void updateEditBtn() {
        if (this.mIsEditable) {
            this.mEditBtn.setVisibility(8);
            this.mFinishBtn.setVisibility(0);
        } else {
            this.mEditBtn.setVisibility(0);
            this.mFinishBtn.setVisibility(8);
        }
        if (this.mFavoritesRecordListAdapter.getCount() <= 0) {
            this.mIsEditable = false;
            this.mEditBtn.setVisibility(8);
        }
        updateSyncBtn();
    }

    private void quiteEditMode() {
        this.mIsEditable = false;
        updateEditBtn();
        this.mFavoritesRecordListAdapter.getFavoriteFragStatusListener().editDisable();
        updateData();
    }

    private boolean isLogin() {
        return NaviAccountUtils.getInstance().isLogin();
    }

    private String getManualSyncTime() {
        long time = FavoriteConfig.getInstance().getLastSyncTime();
        if (time == 0) {
            return this.mUpdateTime;
        }
        this.mUpdateTime = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(new Date(time));
        return this.mUpdateTime;
    }

    private boolean isConnectedwithVehicle() {
        C1251e.a();
        return C1251e.y();
    }

    private void toLoginWebView() {
        StatisticManager.onEvent(StatisticConstants.HOME_MINE_0001, StatisticConstants.HOME_ACCOUNT_LOGIN_003);
        AccountController.getInstance().loginIn(new C38646());
    }

    public void driving() {
        C1260i.b("yftech", "RouteRecordFragment driving");
        drivingDisableClick();
        if (C1343b.a().b()) {
            backTo(17, null);
        }
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
