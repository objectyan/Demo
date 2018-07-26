package com.baidu.navi.fragment.carmode;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageButton;
import android.widget.ListView;
import com.baidu.baidumaps.p042f.p043a.p044a.C0705a;
import com.baidu.baidunavis.control.NavMapManager;
import com.baidu.baidunavis.control.NavPoiController;
import com.baidu.carlife.C0965R;
import com.baidu.carlife.core.C1251e;
import com.baidu.carlife.core.C1260i;
import com.baidu.carlife.core.screen.C0672b;
import com.baidu.carlife.core.screen.C0690d;
import com.baidu.carlife.core.screen.presentation.p071a.C1307e;
import com.baidu.carlife.custom.C1342a;
import com.baidu.carlife.p054k.p055a.C1626e.C0924a;
import com.baidu.carlife.p078f.C1436a;
import com.baidu.carlife.p078f.C1438c;
import com.baidu.carlife.p078f.C1440d;
import com.baidu.carlife.p078f.C1443g;
import com.baidu.carlife.util.C2188r;
import com.baidu.carlife.util.C2201w;
import com.baidu.carlife.view.p104a.C2251b;
import com.baidu.navi.adapter.FavoriteDestinationAdapter;
import com.baidu.navi.controller.AccountController;
import com.baidu.navi.controller.AccountController.IAccountListener;
import com.baidu.navi.favorite.FavoriteConfig;
import com.baidu.navi.favorite.http.AuthTokenSyncRequest;
import com.baidu.navi.favorite.sync.FamilyAndCompanySyncManager;
import com.baidu.navi.fragment.BaseFragment;
import com.baidu.navi.fragment.ContentFragment;
import com.baidu.navi.logic.model.UIModel;
import com.baidu.navi.util.NaviAccountUtils;
import com.baidu.navi.util.StatisticConstants;
import com.baidu.navi.util.StatisticManager;
import com.baidu.navisdk.comapi.routeplan.RoutePlanParams.BundleKey;
import com.baidu.navisdk.model.AddressSettingModel;
import com.baidu.navisdk.ui.util.ForbidDaulClickUtils;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.NetworkUtils;
import com.baidu.navisdk.util.common.PreferenceHelper;

public class CarModeFavoriteDestFragment extends ContentFragment {
    private AuthTokenSyncRequest authTokenSyncRequest;
    private ImageButton mBtnAdd;
    private ImageButton mBtnBack;
    private ImageButton mBtnSync;
    private FavoriteDestinationAdapter mFavoriteDestAdapter;
    private C1443g mFocusAreaUp;
    private C1438c mFocusList;
    private ListView mListView;
    private Handler mSyncHomeHandler = new Handler() {
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            C1307e.a().c();
            FamilyAndCompanySyncManager.getInstance().setSyncing(false);
            switch (msg.what) {
                case 0:
                    CarModeFavoriteDestFragment.this.mFavoriteDestAdapter.notifyHistoryDataSetChanged();
                    TipTool.onCreateToastDialog(BaseFragment.getNaviActivity(), CarModeFavoriteDestFragment.this.getResources().getString(C0965R.string.sync_succes));
                    return;
                case 1:
                    TipTool.onCreateToastDialog(BaseFragment.getNaviActivity(), CarModeFavoriteDestFragment.this.getResources().getString(C0965R.string.sync_home_com_fail_));
                    return;
                case 2:
                    TipTool.onCreateToastDialog(BaseFragment.getNaviActivity(), CarModeFavoriteDestFragment.this.getResources().getString(C0965R.string.sync_home_com_fail_retry));
                    return;
                default:
                    return;
            }
        }
    };
    private ViewGroup mViewGroup;

    /* renamed from: com.baidu.navi.fragment.carmode.CarModeFavoriteDestFragment$1 */
    class C38501 implements OnClickListener {
        C38501() {
        }

        public void onClick(View v) {
            StatisticManager.onEvent(StatisticConstants.HOME_MY_FAV_NEW, StatisticConstants.HOME_MY_FAV_NEW);
            CarModeFavoriteDestFragment.this.goSearchFragment();
        }
    }

    /* renamed from: com.baidu.navi.fragment.carmode.CarModeFavoriteDestFragment$2 */
    class C38512 implements OnClickListener {
        C38512() {
        }

        public void onClick(View v) {
            CarModeFavoriteDestFragment.this.pageBack(CarModeFavoriteDestFragment.this.mModuleFrom);
        }
    }

    /* renamed from: com.baidu.navi.fragment.carmode.CarModeFavoriteDestFragment$3 */
    class C38523 implements OnClickListener {
        C38523() {
        }

        public void onClick(View v) {
            C1251e.a();
            if (C1251e.y() && !NaviAccountUtils.getInstance().isLogin()) {
                C2201w.a(CarModeFavoriteDestFragment.this.getResources().getString(C0965R.string.navi_favorite_prompt_safe_sync));
            } else if (NaviAccountUtils.getInstance().isLogin()) {
                CarModeFavoriteDestFragment.this.syncFamilyAndCompanyData();
            } else {
                CarModeFavoriteDestFragment.this.toLoginWebView();
            }
        }
    }

    /* renamed from: com.baidu.navi.fragment.carmode.CarModeFavoriteDestFragment$4 */
    class C38534 implements IAccountListener {
        C38534() {
        }

        public void onLogResult(boolean success) {
            CarModeFavoriteDestFragment.this.autoSyncFamilyAndCompanyData();
        }
    }

    /* renamed from: com.baidu.navi.fragment.carmode.CarModeFavoriteDestFragment$5 */
    class C38545 implements OnItemClickListener {
        C38545() {
        }

        public void onItemClick(AdapterView<?> adapterView, View arg1, int arg2, long arg3) {
            if (CarModeFavoriteDestFragment.this.mFavoriteDestAdapter != null && !ForbidDaulClickUtils.isFastDoubleClick()) {
                if (arg2 == 0 && !AddressSettingModel.hasSetHomeAddr(BaseFragment.mActivity)) {
                    UIModel.getInstance().goSettingFragment(4, CarModeFavoriteDestFragment.this.getNaviFragmentManager());
                    StatisticManager.onEvent(StatisticConstants.HOME_MY_FAV_SETTING, StatisticConstants.HOME_MY_FAV_SETTING_HOME);
                } else if (arg2 != 1 || AddressSettingModel.hasSetCompAddr(BaseFragment.mActivity)) {
                    StatisticManager.onEvent(StatisticConstants.NAVI_0020, StatisticConstants.NAVI_0020);
                    NavPoiController.getInstance().startCalcRoute(CarModeFavoriteDestFragment.this.mFavoriteDestAdapter.getDate(arg2));
                } else {
                    UIModel.getInstance().goSettingFragment(5, CarModeFavoriteDestFragment.this.getNaviFragmentManager());
                    StatisticManager.onEvent(StatisticConstants.HOME_MY_FAV_SETTING, StatisticConstants.HOME_MY_FAV_SETTING_COMPANY);
                }
            }
        }
    }

    /* renamed from: com.baidu.navi.fragment.carmode.CarModeFavoriteDestFragment$6 */
    class C38556 implements Runnable {
        C38556() {
        }

        public void run() {
            if (CarModeFavoriteDestFragment.this.mFavoriteDestAdapter != null) {
                CarModeFavoriteDestFragment.this.mFavoriteDestAdapter.notifyHistoryDataSetChanged();
            }
        }
    }

    /* renamed from: com.baidu.navi.fragment.carmode.CarModeFavoriteDestFragment$7 */
    class C38567 implements Runnable {
        C38567() {
        }

        public void run() {
            if (CarModeFavoriteDestFragment.this.mFavoriteDestAdapter != null) {
                CarModeFavoriteDestFragment.this.mFavoriteDestAdapter.notifyHistoryDataSetChanged();
            }
        }
    }

    /* renamed from: com.baidu.navi.fragment.carmode.CarModeFavoriteDestFragment$8 */
    class C38578 implements Runnable {
        C38578() {
        }

        public void run() {
            if (CarModeFavoriteDestFragment.this.mFavoriteDestAdapter != null) {
                CarModeFavoriteDestFragment.this.mFavoriteDestAdapter.notifyHistoryDataSetChanged();
            }
        }
    }

    /* renamed from: com.baidu.navi.fragment.carmode.CarModeFavoriteDestFragment$9 */
    class C38589 implements C0672b {
        C38589() {
        }

        public void onClick() {
            CarModeFavoriteDestFragment.this.stopSync();
        }
    }

    public void onAttach(Context activity) {
        super.onAttach(activity);
        this.mFavoriteDestAdapter = new FavoriteDestinationAdapter(activity, this);
    }

    protected View onCreateContentView(LayoutInflater inflater) {
        this.mViewGroup = (ViewGroup) inflater.inflate(C0965R.layout.carmode_frag_favorite_dest, null);
        setCommonTitleBar(this.mViewGroup, getResources().getString(C0965R.string.map_setting_frequently_used_address));
        findViews();
        return this.mViewGroup;
    }

    public void findViews() {
        this.mListView = (ListView) this.mViewGroup.findViewById(C0965R.id.listview);
        this.mBtnBack = (ImageButton) this.mViewGroup.findViewById(C0965R.id.ib_left);
        this.mBtnAdd = (ImageButton) this.mViewGroup.findViewById(C0965R.id.ib_right);
        this.mBtnSync = (ImageButton) this.mViewGroup.findViewById(C0965R.id.ib_right0);
        this.mBtnAdd.setVisibility(0);
        this.mBtnSync.setVisibility(0);
        this.mBtnAdd.setOnClickListener(new C38501());
        this.mBtnBack.setOnClickListener(new C38512());
        this.mBtnSync.setOnClickListener(new C38523());
    }

    public void goSearchFragment() {
        Bundle b = new Bundle();
        b.putInt(BundleKey.FROM_FRAGMENT, 304);
        b.putInt(BundleKey.SELECT_POINT_ACTION, 1);
        if (mActivity != null && !mActivity.isFinishing()) {
            showFragment(49, b);
        }
    }

    private void toLoginWebView() {
        AccountController.getInstance().loginIn(new C38534());
    }

    protected void onUpdateSkin() {
        this.mBtnAdd.setBackground(C2251b.a(mActivity));
        this.mBtnSync.setBackground(C2251b.a(mActivity));
        this.mBtnAdd.setImageDrawable(C2188r.b(C0965R.drawable.com_ic_add));
    }

    public void setupViews() {
        this.mListView.setAdapter(this.mFavoriteDestAdapter);
        this.mListView.setItemsCanFocus(true);
        this.mListView.setDivider(null);
        this.mListView.setOnItemClickListener(new C38545());
    }

    protected void onInitView() {
        setupViews();
    }

    public boolean onBackPressed() {
        pageBack(this.mModuleFrom);
        return true;
    }

    public void onResume() {
        super.onResume();
        autoSyncFamilyAndCompanyData();
        new Handler(Looper.getMainLooper()).postDelayed(new C38556(), 100);
        if (this.mViewGroup != null && getCurrentFragmentType() == 304) {
            onInitFocusAreas();
        }
        if (getNaviFragmentManager().isDriving()) {
            this.mBtnAdd.setAlpha(0.2f);
            this.mBtnAdd.setEnabled(false);
        } else {
            this.mBtnAdd.setAlpha(1.0f);
            this.mBtnAdd.setEnabled(true);
        }
        if (NavMapManager.getInstance().getNaviMapMode() == 5) {
            C0705a.a().e();
            C0705a.a().g();
            NavMapManager.getInstance().handleMapOverlays(0);
            NavMapManager.getInstance().setNaviMapMode(0);
            NavMapManager.getInstance().showCarResultLayer(false);
        }
    }

    protected void onUpdateOrientation(int orientation) {
    }

    protected void onUpdateStyle(boolean dayStyle) {
    }

    public void onInitFocusAreas() {
        if (this.mViewGroup != null && this.mBtnAdd != null && this.mBtnBack != null && this.mListView != null) {
            if (this.mFocusAreaUp == null && this.mViewGroup.findViewById(C0965R.id.common_title_bar) != null) {
                this.mBtnBack.setFocusable(true);
                this.mBtnSync.setFocusable(true);
                this.mBtnAdd.setFocusable(true);
                this.mFocusAreaUp = new C1443g(this.mViewGroup.findViewById(C0965R.id.common_title_bar), 2);
                this.mFocusAreaUp.d(this.mBtnBack).d(this.mBtnSync).d(this.mBtnAdd);
            }
            if (this.mFocusList == null) {
                this.mFocusList = new C1438c(this.mListView, 6);
            }
            C1440d.a().b(new C1436a[]{this.mFocusAreaUp, this.mFocusList});
            C1440d.a().h(this.mFocusList);
        }
    }

    public boolean isBack() {
        boolean backStatus = true;
        C1260i.b("yftech", "mFavoriteDestAdapter.getCount() == " + this.mFavoriteDestAdapter.getCount());
        if (this.mFavoriteDestAdapter.getCount() > 2) {
            backStatus = false;
        }
        if (this.mFavoriteDestAdapter.isBack()) {
            return backStatus;
        }
        C1260i.b("yftech", " mFavoriteDestAdapter.isBack() == " + this.mFavoriteDestAdapter.isBack());
        return false;
    }

    public void driving() {
        C1260i.b("yftech", "CarModeFavoriteDestFragment driving");
        this.mBtnAdd.setAlpha(0.2f);
        this.mBtnAdd.setEnabled(false);
        new Handler(Looper.getMainLooper()).postDelayed(new C38567(), 100);
        if (isBack()) {
            getNaviFragmentManager().back();
        }
        C1342a.a().d();
    }

    public void stopDriving() {
        this.mBtnAdd.setAlpha(1.0f);
        this.mBtnAdd.setEnabled(true);
        new Handler(Looper.getMainLooper()).postDelayed(new C38578(), 100);
    }

    private void autoSyncFamilyAndCompanyData() {
        if (!PreferenceHelper.getInstance(BaseFragment.getNaviActivity()).getBoolean(FavoriteConfig.FAMILY_HAS_SYNCED_AFTER_LOGIN, false) && NaviAccountUtils.getInstance().isLogin() && NetworkUtils.isNetworkAvailable(BaseFragment.getNaviActivity()) && !FamilyAndCompanySyncManager.getInstance().isSyncing()) {
            FamilyAndCompanySyncManager.getInstance().setSyncing(true);
            PreferenceHelper.getInstance(BaseFragment.getNaviActivity()).putBoolean(FavoriteConfig.FAMILY_HAS_SYNCED_AFTER_LOGIN, true);
            sendFamilyAndCompanyRequest();
        }
    }

    private void syncFamilyAndCompanyData() {
        if (!NetworkUtils.isNetworkAvailable(BaseFragment.getNaviActivity())) {
            TipTool.onCreateToastDialog(BaseFragment.getNaviActivity(), getResources().getString(C0965R.string.sync_home_com_fail_retry));
        } else if (FamilyAndCompanySyncManager.getInstance().isSyncing()) {
            TipTool.onCreateToastDialog(BaseFragment.getNaviActivity(), getResources().getString(C0965R.string.sync_home_com));
        } else {
            PreferenceHelper.getInstance(BaseFragment.getNaviActivity()).putBoolean(FavoriteConfig.FAMILY_HAS_SYNCED_AFTER_LOGIN, true);
            FamilyAndCompanySyncManager.getInstance().setmSyncHandler(this.mSyncHomeHandler);
            C1307e.a().a(getResources().getString(C0965R.string.progress_loading), new C38589(), new C0690d() {
                public void onCancel() {
                    CarModeFavoriteDestFragment.this.stopSync();
                }
            });
            sendFamilyAndCompanyRequest();
        }
    }

    private void sendFamilyAndCompanyRequest() {
        String authId = PreferenceHelper.getInstance(BaseFragment.getNaviActivity()).getString(AuthTokenSyncRequest.SYNC_AUTH_ID, "");
        String authToken = PreferenceHelper.getInstance(BaseFragment.getNaviActivity()).getString(AuthTokenSyncRequest.SYNC_AUTH_TOKEN, "");
        if (TextUtils.isEmpty(authId) || TextUtils.isEmpty(authToken)) {
            this.authTokenSyncRequest = new AuthTokenSyncRequest();
            this.authTokenSyncRequest.toGetRequest();
            this.authTokenSyncRequest.registerResponseListener(new C0924a() {
                public void onNetWorkResponse(int responseCode) {
                    FamilyAndCompanySyncManager.getInstance().setSyncing(false);
                    if (!CarModeFavoriteDestFragment.this.isAdded()) {
                        return;
                    }
                    if (responseCode == -4 || responseCode == -2) {
                        C1307e.a().c();
                        TipTool.onCreateToastDialog(BaseFragment.getNaviActivity(), CarModeFavoriteDestFragment.this.getResources().getString(C0965R.string.sync_home_com_fail_retry));
                    }
                }
            });
            return;
        }
        new Thread(new Runnable() {
            public void run() {
                FamilyAndCompanySyncManager.getInstance().startSync();
            }
        }).start();
    }

    public synchronized void stopSync() {
        if (this.authTokenSyncRequest != null) {
            this.authTokenSyncRequest.cancel();
            FamilyAndCompanySyncManager.getInstance().setSyncing(false);
        }
        FamilyAndCompanySyncManager.getInstance().stopSync();
    }
}
