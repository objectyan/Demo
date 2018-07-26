package com.baidu.navisdk.ui.widget;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.util.jar.JarUtils;

public class BNNetworkingDialog extends BNBaseDialog {
    private OnBackPressedListener mBackPressedListener;
    private TextView mConfirmNetworkingTv;
    private LinearLayout mContentLayout;
    private TextView mDownloadOfflinedataTv;
    private TextView mNetworkingCancleTv;
    private TextView mNetworkingContent;

    public interface OnBackPressedListener {
        void onBackPressed();
    }

    public BNNetworkingDialog(Activity activity) {
        super(activity);
        View view = JarUtils.inflate(activity, C4048R.layout.nsdk_layout_network_dialog, null);
        setTitleText(JarUtils.getResources().getString(C4048R.string.nsdk_string_rp_alert_notification));
        setContent(view);
        this.mContentLayout = (LinearLayout) view.findViewById(C4048R.id.content_layout);
        this.mNetworkingContent = (TextView) view.findViewById(C4048R.id.networking_content);
        this.mConfirmNetworkingTv = (TextView) view.findViewById(C4048R.id.confirm_networking_tv);
        this.mDownloadOfflinedataTv = (TextView) view.findViewById(C4048R.id.dl_offline_data_tv);
        this.mNetworkingCancleTv = (TextView) view.findViewById(C4048R.id.network_cancle_tv);
        setCanceledOnTouchOutside(false);
        initStyle();
    }

    public void initStyle() {
        this.mConfirmNetworkingTv.setBackgroundDrawable(BNStyleManager.getDrawable(C4048R.drawable.nsdk_common_dialog_middle));
        this.mDownloadOfflinedataTv.setBackgroundDrawable(BNStyleManager.getDrawable(C4048R.drawable.nsdk_common_dialog_middle));
        this.mNetworkingCancleTv.setBackgroundDrawable(BNStyleManager.getDrawable(C4048R.drawable.nsdk_common_dialog_middle));
        this.mNetworkingContent.setTextColor(BNStyleManager.getColor(C4048R.color.nsdk_color_dialog_content_text));
        this.mConfirmNetworkingTv.setTextColor(BNStyleManager.getColor(C4048R.color.nsdk_color_dialog_other_btn_text));
        this.mDownloadOfflinedataTv.setTextColor(BNStyleManager.getColor(C4048R.color.nsdk_color_dialog_other_btn_text));
        this.mNetworkingCancleTv.setTextColor(BNStyleManager.getColor(C4048R.color.nsdk_color_dialog_other_btn_text));
    }

    public BNNetworkingDialog setNetworkingContentMessage(String text) {
        this.mNetworkingContent.setText(text);
        return this;
    }

    public BNNetworkingDialog setConfirmNetworkMessage(String text) {
        this.mConfirmNetworkingTv.setText(text);
        return this;
    }

    public BNNetworkingDialog setConfirmNetworkingListener(OnClickListener listener) {
        this.mConfirmNetworkingTv.setOnClickListener(listener);
        return this;
    }

    public BNNetworkingDialog setDownloadListener(OnClickListener listener) {
        this.mDownloadOfflinedataTv.setOnClickListener(listener);
        return this;
    }

    public BNNetworkingDialog setCancleListener(OnClickListener listener) {
        this.mNetworkingCancleTv.setOnClickListener(listener);
        return this;
    }

    public BNNetworkingDialog setTwoButtonMode(boolean b) {
        if (b) {
            this.mDownloadOfflinedataTv.setVisibility(8);
        }
        return this;
    }

    public BNNetworkingDialog setOneButtonMode(boolean b) {
        if (b) {
            this.mDownloadOfflinedataTv.setVisibility(8);
            this.mNetworkingCancleTv.setVisibility(8);
        }
        return this;
    }

    public void onBackPressed() {
        super.onBackPressed();
        if (this.mBackPressedListener != null) {
            this.mBackPressedListener.onBackPressed();
        }
    }

    public BNNetworkingDialog setOnBackPressedListener(OnBackPressedListener listener) {
        this.mBackPressedListener = listener;
        return this;
    }

    public void show() {
        initStyle();
        super.show();
    }
}
