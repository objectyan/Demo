package com.baidu.navisdk.ui.disclaimer.control;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.TextView;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.ui.disclaimer.control.Disclaimer.Type;
import com.baidu.navisdk.util.jar.JarUtils;

public class DisclaimerController implements OnClickListener {
    private CheckBox mCheckBox;
    private final Disclaimer mDisclaimer;
    private final IDisclaimerListener mDisclaimerListener;

    public DisclaimerController(Disclaimer disclaimer, IDisclaimerListener mDisclaimerListener) {
        this.mDisclaimer = disclaimer;
        this.mDisclaimerListener = mDisclaimerListener;
    }

    public View getDisclaimerView(Activity activity) {
        View view = null;
        if (this.mDisclaimer != null) {
            try {
                view = JarUtils.inflate(activity, this.mDisclaimer.getLayoutId(), null);
                if (view != null) {
                    TextView rejectBtnView = (TextView) view.findViewById(C4048R.id.disclaimer_reject_btn);
                    TextView receiveBtnView = (TextView) view.findViewById(C4048R.id.disclaimer_receive_btn);
                    this.mCheckBox = (CheckBox) view.findViewById(C4048R.id.disclaimer_checkbox);
                    if (rejectBtnView != null) {
                        rejectBtnView.setOnClickListener(this);
                    }
                    if (receiveBtnView != null) {
                        receiveBtnView.setOnClickListener(this);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return view;
    }

    public void onClick(View view) {
        if (view != null) {
            switch (view.getId()) {
                case C4048R.id.disclaimer_reject_btn /*1711866136*/:
                    onRejectDisclaimer();
                    return;
                case C4048R.id.disclaimer_receive_btn /*1711866137*/:
                    onReceiveDisclaimer();
                    return;
                default:
                    return;
            }
        }
    }

    private void onRejectDisclaimer() {
        if (this.mDisclaimerListener != null) {
            this.mDisclaimerListener.onRejectDisclaimer();
        }
    }

    private void onReceiveDisclaimer() {
        if (!(this.mCheckBox == null || this.mDisclaimer == null)) {
            BNSettingManager.setDisclaimerShow(getLocalCacheKey(this.mDisclaimer.getType()), !this.mCheckBox.isChecked());
        }
        if (this.mDisclaimerListener != null) {
            this.mDisclaimerListener.onReceiveDisclaimer();
        }
    }

    public static Disclaimer getShowDisclaimer(int naviType) {
        Type type = null;
        if (naviType == 1) {
            type = Type.INTERNATIONAL;
        }
        if (type != null && BNSettingManager.isDisclaimerShow(getLocalCacheKey(type)) && type == Type.INTERNATIONAL) {
            return new Disclaimer(type, C4048R.layout.nsdk_layout_international_disclaimer);
        }
        return null;
    }

    private static String getLocalCacheKey(Type type) {
        return "NAVI_SHOW_DISCLAIMER_" + type.getName();
    }
}
