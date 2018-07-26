package com.baidu.navisdk.ui.widget;

import android.app.Activity;
import android.app.Dialog;
import android.content.res.Resources.Theme;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.util.jar.JarUtils;

public class BNImageTextDialog extends Dialog {
    private boolean isSupportDayNight = false;
    private LinearLayout mContentLayout;
    private TextView mFirstBtn;
    private boolean mFirstHasText;
    private TextView mMessage;
    private OnNaviClickListener mOnFirstBtnClickListener;
    private OnNaviClickListener mOnSecondBtnClickListener;
    private TextView mSecondBtn;
    private boolean mSecondHasText;
    private TextView mTitleBar;
    private ImageView mTopImageView;

    public interface OnNaviClickListener {
        void onClick();
    }

    /* renamed from: com.baidu.navisdk.ui.widget.BNImageTextDialog$1 */
    class C45781 implements OnClickListener {
        C45781() {
        }

        public void onClick(View v) {
            if (BNImageTextDialog.this.mOnFirstBtnClickListener != null) {
                BNImageTextDialog.this.mOnFirstBtnClickListener.onClick();
            }
            BNImageTextDialog.this.dismiss();
        }
    }

    /* renamed from: com.baidu.navisdk.ui.widget.BNImageTextDialog$2 */
    class C45792 implements OnClickListener {
        C45792() {
        }

        public void onClick(View v) {
            if (BNImageTextDialog.this.mOnSecondBtnClickListener != null) {
                BNImageTextDialog.this.mOnSecondBtnClickListener.onClick();
            }
            try {
                BNImageTextDialog.this.dismiss();
            } catch (Exception e) {
            }
        }
    }

    public BNImageTextDialog(Activity activity) {
        super(activity);
        Theme theme = JarUtils.getResources().newTheme();
        theme.applyStyle(C4048R.style.BNDialog, true);
        JarUtils.setDialogThemeField(this, theme);
        View view = JarUtils.inflate(activity, C4048R.layout.nsdk_layout_image_text_dialog, null);
        try {
            setContentView(view);
            this.mContentLayout = (LinearLayout) view.findViewById(C4048R.id.it_dialog_content);
            this.mTopImageView = (ImageView) view.findViewById(C4048R.id.it_dialog_imageview);
            this.mTitleBar = (TextView) view.findViewById(C4048R.id.it_dialog_title);
            this.mMessage = (TextView) view.findViewById(C4048R.id.it_dialog_content_message);
            this.mFirstBtn = (TextView) view.findViewById(C4048R.id.first_btn);
            this.mSecondBtn = (TextView) view.findViewById(C4048R.id.second_btn);
            this.mFirstBtn.setOnClickListener(new C45781());
            this.mSecondBtn.setOnClickListener(new C45792());
            this.mFirstHasText = false;
            this.mSecondHasText = false;
            this.mTitleBar.setVisibility(8);
            this.mMessage.setVisibility(8);
            this.mFirstBtn.setVisibility(8);
            this.mSecondBtn.setVisibility(8);
            setCanceledOnTouchOutside(false);
        } catch (Throwable th) {
        }
    }

    private void updateDayStyle() {
        this.mTitleBar.setTextColor(JarUtils.getResources().getColor(C4048R.color.cl_text_a));
        this.mMessage.setTextColor(JarUtils.getResources().getColor(C4048R.color.cl_text_a));
        this.mFirstBtn.setTextColor(JarUtils.getResources().getColorStateList(C4048R.color.nsdk_color_image_text_dialog_btn_selector));
        this.mSecondBtn.setTextColor(JarUtils.getResources().getColorStateList(C4048R.color.nsdk_color_image_text_dialog_btn_selector));
        this.mFirstBtn.setBackgroundDrawable(JarUtils.getResources().getDrawable(C4048R.drawable.bnav_image_text_dialog_button_selector));
        this.mSecondBtn.setBackgroundDrawable(JarUtils.getResources().getDrawable(C4048R.drawable.bnav_image_text_dialog_button_selector));
    }

    public void updateStyle() {
        this.isSupportDayNight = true;
        this.mTitleBar.setTextColor(BNStyleManager.getColor(C4048R.color.nsdk_color_dialog_content_text));
        this.mMessage.setTextColor(BNStyleManager.getColor(C4048R.color.nsdk_color_dialog_content_text));
        this.mFirstBtn.setTextColor(JarUtils.getResources().getColorStateList(C4048R.color.nsdk_color_image_text_dialog_btn_selector));
        this.mSecondBtn.setTextColor(JarUtils.getResources().getColorStateList(C4048R.color.nsdk_color_image_text_dialog_btn_selector));
        this.mFirstBtn.setBackgroundDrawable(BNStyleManager.getDrawable(C4048R.drawable.bnav_image_text_dialog_button_selector));
        this.mSecondBtn.setBackgroundDrawable(BNStyleManager.getDrawable(C4048R.drawable.bnav_image_text_dialog_button_selector));
    }

    public BNImageTextDialog setContentMessage(String text) {
        if (text == null) {
            this.mMessage.setVisibility(8);
            this.mMessage.setText("", BufferType.SPANNABLE);
        } else {
            this.mMessage.setVisibility(0);
            this.mMessage.setText(text, BufferType.SPANNABLE);
        }
        return this;
    }

    public BNImageTextDialog setTopImageDrawable(Drawable drawable) {
        this.mTopImageView.setVisibility(0);
        this.mTopImageView.setImageDrawable(drawable);
        return this;
    }

    public BNImageTextDialog setBottomImageDrawable(Drawable drawable) {
        this.mContentLayout.setBackgroundDrawable(drawable);
        return this;
    }

    public BNImageTextDialog setTitleText(String text) {
        if (text == null) {
            this.mTitleBar.setVisibility(8);
            this.mTitleBar.setText("", BufferType.SPANNABLE);
        } else {
            this.mTitleBar.setVisibility(0);
            this.mTitleBar.setText(text, BufferType.SPANNABLE);
        }
        return this;
    }

    public BNImageTextDialog setFirstBtnText(String text) {
        if (text == null) {
            this.mFirstHasText = false;
            this.mFirstBtn.setText("", BufferType.SPANNABLE);
        } else {
            this.mFirstHasText = true;
            this.mFirstBtn.setText(text, BufferType.SPANNABLE);
        }
        setBtnVisible();
        return this;
    }

    public BNImageTextDialog setFirstBtnText(boolean isDayStyle, String text) {
        if (text == null) {
            this.mFirstHasText = false;
            this.mFirstBtn.setText("", BufferType.SPANNABLE);
        } else {
            this.mFirstHasText = true;
            this.mFirstBtn.setText(text, BufferType.SPANNABLE);
        }
        setBtnVisible(isDayStyle);
        return this;
    }

    public BNImageTextDialog setSecondBtnText(String text) {
        if (text == null) {
            this.mSecondHasText = false;
            this.mSecondBtn.setText("", BufferType.SPANNABLE);
        } else {
            this.mSecondHasText = true;
            this.mSecondBtn.setText(text, BufferType.SPANNABLE);
        }
        setBtnVisible();
        return this;
    }

    public BNImageTextDialog setSecondBtnChecked() {
        this.mSecondBtn.setSelected(true);
        return this;
    }

    public BNImageTextDialog setSecondBtnText(boolean isDayStyle, String text) {
        if (text == null) {
            this.mSecondHasText = false;
            this.mSecondBtn.setText("", BufferType.SPANNABLE);
        } else {
            this.mSecondHasText = true;
            this.mSecondBtn.setText(text, BufferType.SPANNABLE);
        }
        setBtnVisible(isDayStyle);
        return this;
    }

    public BNImageTextDialog setOnFirstBtnClickListener(OnNaviClickListener listener) {
        this.mOnFirstBtnClickListener = listener;
        return this;
    }

    public BNImageTextDialog setOnSecondBtnClickListener(OnNaviClickListener listener) {
        this.mOnSecondBtnClickListener = listener;
        return this;
    }

    public BNImageTextDialog enableBackKey(boolean cancelable) {
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
            this.mFirstBtn.setBackgroundDrawable(BNStyleManager.getDrawable(C4048R.drawable.bnav_image_text_dialog_button_selector));
        } else if (!this.mFirstHasText && this.mSecondHasText) {
            this.mFirstBtn.setVisibility(8);
            this.mSecondBtn.setVisibility(0);
            this.mSecondBtn.setBackgroundDrawable(BNStyleManager.getDrawable(C4048R.drawable.bnav_image_text_dialog_button_selector));
        } else if (this.mFirstHasText && this.mSecondHasText) {
            this.mFirstBtn.setVisibility(0);
            this.mSecondBtn.setVisibility(0);
            this.mFirstBtn.setBackgroundDrawable(BNStyleManager.getDrawable(C4048R.drawable.bnav_image_text_dialog_button_selector));
            this.mSecondBtn.setBackgroundDrawable(BNStyleManager.getDrawable(C4048R.drawable.bnav_image_text_dialog_button_selector));
        }
    }

    private void setBtnVisible(boolean isDayStyle) {
        if (!this.mFirstHasText && !this.mSecondHasText) {
            this.mFirstBtn.setVisibility(8);
            this.mSecondBtn.setVisibility(8);
        } else if (!this.mSecondHasText && this.mFirstHasText) {
            this.mFirstBtn.setVisibility(0);
            this.mSecondBtn.setVisibility(8);
            this.mFirstBtn.setBackgroundDrawable(BNStyleManager.getDrawable(C4048R.drawable.bnav_image_text_dialog_button_selector, isDayStyle));
        } else if (!this.mFirstHasText && this.mSecondHasText) {
            this.mFirstBtn.setVisibility(8);
            this.mSecondBtn.setVisibility(0);
            this.mSecondBtn.setBackgroundDrawable(BNStyleManager.getDrawable(C4048R.drawable.bnav_image_text_dialog_button_selector, isDayStyle));
        } else if (this.mFirstHasText && this.mSecondHasText) {
            this.mFirstBtn.setVisibility(0);
            this.mSecondBtn.setVisibility(0);
            this.mFirstBtn.setBackgroundDrawable(BNStyleManager.getDrawable(C4048R.drawable.bnav_image_text_dialog_button_selector, isDayStyle));
            this.mSecondBtn.setBackgroundDrawable(BNStyleManager.getDrawable(C4048R.drawable.bnav_image_text_dialog_button_selector, isDayStyle));
        }
    }

    public void show() {
        if (this.isSupportDayNight) {
            updateStyle();
        } else {
            updateDayStyle();
        }
        super.show();
    }

    public void dismiss() {
        this.mFirstHasText = false;
        this.mSecondHasText = false;
        super.dismiss();
    }
}
