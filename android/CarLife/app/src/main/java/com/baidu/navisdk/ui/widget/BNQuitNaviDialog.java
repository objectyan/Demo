package com.baidu.navisdk.ui.widget;

import android.app.Activity;
import android.app.Dialog;
import android.content.res.Resources.Theme;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.util.jar.JarUtils;

public class BNQuitNaviDialog extends Dialog {
    public static final int TYPE_COMPLETE_UGC = 2;
    public static final int TYPE_QUIT_NAVI = 1;
    private TextView cancleTv = null;
    private TextView completeUgcInfoTv = null;
    private OnNaviClickListener listener = null;
    private TextView quitNaviTv = null;

    public interface OnNaviClickListener {
        void onClick(int i);
    }

    /* renamed from: com.baidu.navisdk.ui.widget.BNQuitNaviDialog$1 */
    class C45901 implements OnClickListener {
        C45901() {
        }

        public void onClick(View v) {
            if (BNQuitNaviDialog.this.listener != null) {
                BNQuitNaviDialog.this.listener.onClick(2);
            }
        }
    }

    /* renamed from: com.baidu.navisdk.ui.widget.BNQuitNaviDialog$2 */
    class C45912 implements OnClickListener {
        C45912() {
        }

        public void onClick(View v) {
            BNQuitNaviDialog.this.dismiss();
        }
    }

    /* renamed from: com.baidu.navisdk.ui.widget.BNQuitNaviDialog$3 */
    class C45923 implements OnClickListener {
        C45923() {
        }

        public void onClick(View v) {
            if (BNQuitNaviDialog.this.listener != null) {
                BNQuitNaviDialog.this.listener.onClick(1);
            }
        }
    }

    public BNQuitNaviDialog setOnBtnClickListener(OnNaviClickListener listener) {
        this.listener = listener;
        return this;
    }

    public BNQuitNaviDialog(Activity activity) {
        super(activity);
        Theme theme = JarUtils.getResources().newTheme();
        theme.applyStyle(C4048R.style.BNDialog, true);
        JarUtils.setDialogThemeField(this, theme);
        View view = JarUtils.inflate(activity, C4048R.layout.nsdk_layout_quit_navi_dialog, null);
        try {
            setContentView(view);
            this.completeUgcInfoTv = (TextView) view.findViewById(C4048R.id.complete_ugc_info_tv);
            this.cancleTv = (TextView) view.findViewById(C4048R.id.cancle_tv);
            this.quitNaviTv = (TextView) view.findViewById(C4048R.id.quit_navi_tv);
            this.completeUgcInfoTv.setOnClickListener(new C45901());
            this.cancleTv.setOnClickListener(new C45912());
            this.quitNaviTv.setOnClickListener(new C45923());
        } catch (Throwable th) {
        }
    }

    public void setUgcInfoTv(boolean show) {
        if (this.completeUgcInfoTv == null) {
            return;
        }
        if (show) {
            this.completeUgcInfoTv.setVisibility(0);
        } else {
            this.completeUgcInfoTv.setVisibility(8);
        }
    }

    public void onBackPressed() {
        super.onBackPressed();
        if (this.quitNaviTv != null) {
            this.quitNaviTv.performClick();
        }
    }
}
