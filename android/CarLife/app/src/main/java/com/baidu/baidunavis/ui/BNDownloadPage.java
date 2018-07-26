package com.baidu.baidunavis.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RemoteViews;
import com.baidu.baidunavis.BaiduNaviManager;
import com.baidu.baidunavis.NavMapAdapter;
import com.baidu.baidunavis.control.NavDayNightController;
import com.baidu.baidunavis.control.NavDayNightController.OnDayNightChangedListener;
import com.baidu.baidunavis.model.NavCommonFuncModel;
import com.baidu.baidunavis.ui.widget.NavTipTool;
import com.baidu.carlife.C0965R;
import com.baidu.carlife.CarlifeActivity;
import com.baidu.navi.fragment.ContentFragment;
import com.baidu.navisdk.comapi.offlinedata.BNOfflineDataManager;
import com.baidu.navisdk.comapi.offlinedata.BNOfflineDataManager.ImportNaviMapDataListener;
import com.baidu.navisdk.ui.download.BNDownloadNotifyManager;
import com.baidu.navisdk.ui.download.BNDownloadUIManager;

public class BNDownloadPage extends ContentFragment {
    public static final String KEY_FROM_CRUISER = "KEY_FROM_CRUISER";
    public static final String NAVIGATE_PAGE_NAME = "target_page_name";
    private static final String TAG = BNDownloadPage.class.getSimpleName();
    private boolean mIsFromCruiser = false;
    private OnDayNightChangedListener mOnDayNightChangedListener = new C08893();
    private BNDownloadUIManager mUIManager;

    /* renamed from: com.baidu.baidunavis.ui.BNDownloadPage$1 */
    class C08861 implements OnClickListener {
        C08861() {
        }

        public void onClick(View v) {
            BNDownloadPage.this.back();
        }
    }

    /* renamed from: com.baidu.baidunavis.ui.BNDownloadPage$3 */
    class C08893 implements OnDayNightChangedListener {
        C08893() {
        }

        public void onDayNightChanged(boolean isDay) {
            if (BNDownloadPage.this.mUIManager != null) {
                BNDownloadPage.this.mUIManager.updateStyle(isDay);
            }
        }
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle mShowBundle = getArguments();
        if (mShowBundle != null && mShowBundle.containsKey(KEY_FROM_CRUISER)) {
            this.mIsFromCruiser = mShowBundle.getBoolean(KEY_FROM_CRUISER, false);
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        if (BaiduNaviManager.sIsBaseEngineInitialized && initDownloadUIManager(getActivity())) {
            if (this.mUIManager != null) {
                this.mUIManager.remmoveParentView();
                View view = this.mUIManager.getView();
                if (view != null) {
                    return view;
                }
            }
            back();
            return null;
        }
        NavTipTool.onCreateToastDialog(NavCommonFuncModel.getInstance().getActivity(), (int) C0965R.string.nav_engine_is_not_initialized);
        back();
        return null;
    }

    protected View onCreateContentView(LayoutInflater inflater) {
        return null;
    }

    protected void onInitView() {
    }

    public void onResume() {
        super.onResume();
        getActivity().setRequestedOrientation(1);
        initNotification(getActivity());
        this.mOnDayNightChangedListener.onDayNightChanged(NavDayNightController.getInstance().isDay());
        NavDayNightController.getInstance().registerDayNightListener(this.mOnDayNightChangedListener);
    }

    private boolean initDownloadUIManager(final Activity bnDownloadActivity) {
        if (this.mUIManager == null || !this.mUIManager.isViewCreated()) {
            this.mUIManager = BNDownloadUIManager.getInstance(bnDownloadActivity);
            if (this.mUIManager == null) {
                return false;
            }
            this.mUIManager.createView(bnDownloadActivity);
            this.mUIManager.setBackBtnOnClickListener(new C08861());
            BNOfflineDataManager.getInstance().setImportNaviMapDataListener(new ImportNaviMapDataListener() {

                /* renamed from: com.baidu.baidunavis.ui.BNDownloadPage$2$1 */
                class C08871 implements Runnable {
                    C08871() {
                    }

                    public void run() {
                        NavMapAdapter.getInstance().importMap();
                    }
                }

                public void onImportNaviMapData() {
                    Activity activity = bnDownloadActivity;
                    if (activity != null) {
                        activity.runOnUiThread(new C08871());
                    }
                }

                @Deprecated
                public boolean checkDataExitByProvinceId(int provinceId) {
                    return false;
                }

                public void startDownLoadDataByProvinceId(int provinceId) {
                }
            });
        }
        return true;
    }

    private void initNotification(Activity bnDownloadActivity) {
        Context context = getActivity();
        Intent intent = new Intent(context, CarlifeActivity.class);
        intent.putExtra(NAVIGATE_PAGE_NAME, getClass().getName());
        BNDownloadNotifyManager.getInstance().init(context, intent, C0965R.drawable.ic_launcher, new RemoteViews(context.getPackageName(), C0965R.layout.status_bar_progress), C0965R.id.title, C0965R.id.progress_bar, C0965R.id.progress_text);
    }

    public void onDestroy() {
        super.onDestroy();
        NavDayNightController.getInstance().unregisterDayNightListener(this.mOnDayNightChangedListener);
        if (this.mUIManager != null) {
            this.mUIManager.destroyView();
        }
    }

    protected void onUpdateOrientation(int orientation) {
    }

    protected void onUpdateStyle(boolean dayStyle) {
    }

    public void onPause() {
        super.onPause();
        getActivity().setRequestedOrientation(2);
    }

    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (this.mUIManager != null) {
            this.mUIManager.onConfigurationChanged(newConfig);
        }
    }
}
