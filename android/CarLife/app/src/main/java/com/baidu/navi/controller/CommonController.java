package com.baidu.navi.controller;

import android.os.Handler;
import android.os.Looper;
import com.baidu.carlife.C0965R;
import com.baidu.carlife.CarlifeActivity;
import com.baidu.carlife.core.screen.C0672b;
import com.baidu.carlife.core.screen.C1277e;
import com.baidu.carlife.core.screen.presentation.C1328h;
import com.baidu.carlife.view.dialog.C1953c;
import com.baidu.navisdk.comapi.offlinedata.BNOfflineDataManager;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.NetworkUtils;

public class CommonController {
    private CarlifeActivity mActivity;
    private C1953c mDataInfoDialog;
    private C1277e mDialogListener;
    private Handler mHandler = new Handler(Looper.getMainLooper());

    /* renamed from: com.baidu.navi.controller.CommonController$1 */
    class C36801 implements C0672b {
        C36801() {
        }

        public void onClick() {
            C1328h.a().back();
        }
    }

    /* renamed from: com.baidu.navi.controller.CommonController$2 */
    class C36822 implements C0672b {

        /* renamed from: com.baidu.navi.controller.CommonController$2$1 */
        class C36811 implements Runnable {
            C36811() {
            }

            public void run() {
                CommonController.this.showNoNetAndOfflineDataDialog();
            }
        }

        C36822() {
        }

        public void onClick() {
            CommonController.this.mDialogListener.dismissDialog(CommonController.this.mDataInfoDialog);
            if (!NetworkUtils.isNetworkAvailable(CommonController.this.mActivity)) {
                TipTool.onCreateToastDialog(CommonController.this.mActivity, CommonController.this.mActivity.getString(C0965R.string.network_conn_failed));
                CommonController.this.mHandler.post(new C36811());
            }
        }
    }

    public interface IDialogControllerListener {
        void onShowHomePage();
    }

    public CommonController(CarlifeActivity activity, C1277e listener) {
        this.mActivity = activity;
        this.mDialogListener = listener;
    }

    public boolean isNeedShowDialog() {
        if (BNOfflineDataManager.getInstance().haveValidData() || NetworkUtils.isNetworkAvailable(this.mActivity)) {
            return false;
        }
        return true;
    }

    public boolean checkOfflineDataOrNetwork() {
        if (!isNeedShowDialog()) {
            return true;
        }
        showNoNetAndOfflineDataDialog();
        return false;
    }

    public void showNoNetAndOfflineDataDialog() {
        if (this.mActivity != null && !this.mActivity.isFinishing()) {
            if (this.mDataInfoDialog == null) {
                this.mDataInfoDialog = new C1953c(this.mActivity).b(C0965R.string.alert_notification).b(this.mActivity.getString(C0965R.string.alert_no_net_data_info)).g(17).c(C0965R.string.alert_retry).q().a(new C36822()).d(C0965R.string.alert_cancel).r().b(new C36801());
            }
            this.mDialogListener.showDialog(this.mDataInfoDialog);
        }
    }

    public void dismissNoNetAndOfflineDataDialog() {
        if (this.mActivity != null && this.mDataInfoDialog != null && this.mDialogListener != null && this.mDialogListener.isDialogShown()) {
            this.mDialogListener.dismissDialog(this.mDataInfoDialog);
        }
    }
}
