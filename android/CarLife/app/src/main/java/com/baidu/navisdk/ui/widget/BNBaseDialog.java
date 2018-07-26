package com.baidu.navisdk.ui.widget;

import android.app.Activity;
import android.app.Dialog;
import android.content.res.Resources.Theme;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.util.jar.JarUtils;

public class BNBaseDialog extends Dialog {
    protected boolean isSupportDayNight = false;
    private FrameLayout mContent;
    private TextView mFirstBtn;
    private boolean mFirstHasText;
    private OnNaviClickListener mOnFirstBtnClickListener;
    private OnNaviClickListener mOnSecondBtnClickListener;
    private TextView mSecondBtn;
    private boolean mSecondHasText;
    private TextView mTitleBar;
    private LinearLayout mTopContentLayout;

    public interface OnNaviClickListener {
        void onClick();
    }

    /* renamed from: com.baidu.navisdk.ui.widget.BNBaseDialog$1 */
    class C45621 implements OnClickListener {
        C45621() {
        }

        public void onClick(View v) {
            if (BNBaseDialog.this.mOnFirstBtnClickListener != null) {
                BNBaseDialog.this.mOnFirstBtnClickListener.onClick();
            }
            BNBaseDialog.this.dismiss();
        }
    }

    /* renamed from: com.baidu.navisdk.ui.widget.BNBaseDialog$2 */
    class C45632 implements OnClickListener {
        C45632() {
        }

        public void onClick(View v) {
            if (BNBaseDialog.this.mOnSecondBtnClickListener != null) {
                BNBaseDialog.this.mOnSecondBtnClickListener.onClick();
            }
            BNBaseDialog.this.dismiss();
        }
    }

    public BNBaseDialog(Activity activity) {
        super(activity);
        Theme theme = JarUtils.getResources().newTheme();
        theme.applyStyle(C4048R.style.BNDialog, true);
        JarUtils.setDialogThemeField(this, theme);
        View view = JarUtils.inflate(activity, C4048R.layout.nsdk_layout_dialog, null);
        setContentView(view);
        this.mTopContentLayout = (LinearLayout) view.findViewById(C4048R.id.top_content);
        this.mTitleBar = (TextView) view.findViewById(C4048R.id.title_bar);
        this.mContent = (FrameLayout) view.findViewById(C4048R.id.content);
        this.mFirstBtn = (TextView) view.findViewById(C4048R.id.first_btn);
        this.mSecondBtn = (TextView) view.findViewById(C4048R.id.second_btn);
        this.mFirstBtn.setOnClickListener(new C45621());
        this.mSecondBtn.setOnClickListener(new C45632());
        this.mFirstHasText = false;
        this.mSecondHasText = false;
        this.mTitleBar.setVisibility(8);
        this.mFirstBtn.setVisibility(8);
        this.mSecondBtn.setVisibility(8);
        setCanceledOnTouchOutside(false);
        updateDayStyle();
    }

    private void updateDayStyle() {
        this.mTopContentLayout.setBackgroundDrawable(JarUtils.getResources().getDrawable(C4048R.drawable.nsdk_drawable_common_dialog_top));
        this.mTitleBar.setTextColor(JarUtils.getResources().getColor(C4048R.color.nsdk_color_dialog_content_text));
        if (this.mFirstHasText && this.mSecondHasText) {
            this.mFirstBtn.setBackgroundDrawable(JarUtils.getResources().getDrawable(C4048R.drawable.nsdk_common_dialog_left));
            this.mSecondBtn.setBackgroundDrawable(JarUtils.getResources().getDrawable(C4048R.drawable.nsdk_common_dialog_right));
        } else if (!this.mFirstHasText && this.mSecondHasText) {
            this.mSecondBtn.setBackgroundDrawable(JarUtils.getResources().getDrawable(C4048R.drawable.nsdk_common_dialog_chang));
        } else if (!this.mSecondHasText && this.mFirstHasText) {
            this.mFirstBtn.setBackgroundDrawable(JarUtils.getResources().getDrawable(C4048R.drawable.nsdk_common_dialog_chang));
        }
    }

    public void updateStyle() {
        this.isSupportDayNight = true;
        this.mTopContentLayout.setBackgroundDrawable(BNStyleManager.getDrawable(C4048R.drawable.nsdk_drawable_common_dialog_top));
        this.mTitleBar.setTextColor(BNStyleManager.getColor(C4048R.color.nsdk_color_dialog_content_text));
        if (this.mFirstHasText && this.mSecondHasText) {
            this.mFirstBtn.setBackgroundDrawable(BNStyleManager.getDrawable(C4048R.drawable.nsdk_common_dialog_left));
            this.mSecondBtn.setBackgroundDrawable(BNStyleManager.getDrawable(C4048R.drawable.nsdk_common_dialog_right));
        } else if (!this.mFirstHasText && this.mSecondHasText) {
            this.mSecondBtn.setBackgroundDrawable(BNStyleManager.getDrawable(C4048R.drawable.nsdk_common_dialog_chang));
        } else if (!this.mSecondHasText && this.mFirstHasText) {
            this.mFirstBtn.setBackgroundDrawable(BNStyleManager.getDrawable(C4048R.drawable.nsdk_common_dialog_chang));
        }
    }

    public BNBaseDialog setTitleText(String text) {
        if (text == null) {
            this.mTitleBar.setVisibility(8);
            this.mTitleBar.setText("", BufferType.SPANNABLE);
        } else {
            this.mTitleBar.setVisibility(0);
            this.mTitleBar.setText(text, BufferType.SPANNABLE);
        }
        return this;
    }

    public BNBaseDialog setFirstBtnText(String text) {
        if (text == null) {
            this.mFirstHasText = false;
            this.mFirstBtn.setText("", BufferType.SPANNABLE);
        } else {
            this.mFirstHasText = true;
            this.mFirstBtn.setText(text, BufferType.SPANNABLE);
        }
        setBtnVisible();
        this.mFirstBtn.setTextColor(BNStyleManager.getColor(C4048R.color.nsdk_color_dialog_other_btn_text));
        return this;
    }

    public BNBaseDialog setSecondBtnText(String text) {
        if (text == null) {
            this.mSecondHasText = false;
            this.mSecondBtn.setText("", BufferType.SPANNABLE);
        } else {
            this.mSecondHasText = true;
            this.mSecondBtn.setText(text, BufferType.SPANNABLE);
        }
        setBtnVisible();
        this.mSecondBtn.setTextColor(BNStyleManager.getColor(C4048R.color.nsdk_color_dialog_other_btn_text));
        return this;
    }

    public BNBaseDialog setContent(View content) {
        if (this.mContent != null) {
            this.mContent.removeAllViews();
            this.mContent.addView(content);
        }
        return this;
    }

    public BNBaseDialog setOnFirstBtnClickListener(OnNaviClickListener listener) {
        this.mOnFirstBtnClickListener = listener;
        return this;
    }

    public BNBaseDialog setOnSecondBtnClickListener(OnNaviClickListener listener) {
        this.mOnSecondBtnClickListener = listener;
        return this;
    }

    public BNBaseDialog setContentWidth(int width) {
        LayoutParams params = this.mContent.getLayoutParams();
        params.width = width;
        this.mContent.setLayoutParams(params);
        return this;
    }

    public BNBaseDialog setContentHeight(int height) {
        LayoutParams params = this.mContent.getLayoutParams();
        params.height = height;
        this.mContent.setLayoutParams(params);
        return this;
    }

    public BNBaseDialog setFirstBtnEnabled(boolean enabled) {
        this.mFirstBtn.setEnabled(enabled);
        return this;
    }

    public BNBaseDialog setSecondBtnEnabled(boolean enabled) {
        this.mSecondBtn.setEnabled(enabled);
        return this;
    }

    public BNBaseDialog enableBackKey(boolean cancelable) {
        super.setCancelable(cancelable);
        return this;
    }

    private void setBtnVisible() {
        if (!this.mFirstHasText && !this.mSecondHasText) {
            this.mFirstBtn.setVisibility(8);
            this.mSecondBtn.setVisibility(8);
        } else if (!this.mSecondHasText && this.mFirstHasText) {
            this.mFirstBtn.setVisibility(0);
            this.mSecondBtn.setVisibility(8);
            this.mFirstBtn.setBackgroundDrawable(BNStyleManager.getDrawable(C4048R.drawable.nsdk_common_dialog_chang));
        } else if (!this.mFirstHasText && this.mSecondHasText) {
            this.mFirstBtn.setVisibility(8);
            this.mSecondBtn.setVisibility(0);
            this.mSecondBtn.setBackgroundDrawable(BNStyleManager.getDrawable(C4048R.drawable.nsdk_common_dialog_chang));
        } else if (this.mFirstHasText && this.mSecondHasText) {
            this.mFirstBtn.setVisibility(0);
            this.mSecondBtn.setVisibility(0);
            this.mFirstBtn.setBackgroundDrawable(BNStyleManager.getDrawable(C4048R.drawable.nsdk_common_dialog_left));
            this.mSecondBtn.setBackgroundDrawable(BNStyleManager.getDrawable(C4048R.drawable.nsdk_common_dialog_right));
        }
    }

    public void show() {
        if (this.isSupportDayNight) {
            updateStyle();
        } else {
            updateDayStyle();
        }
        try {
            super.show();
        } catch (Exception e) {
        }
    }

    public void dismiss() {
        this.mFirstHasText = false;
        this.mSecondHasText = false;
        try {
            super.dismiss();
        } catch (Exception e) {
        }
    }
}
