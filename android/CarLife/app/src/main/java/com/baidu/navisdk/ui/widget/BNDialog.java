package com.baidu.navisdk.ui.widget;

import android.app.Activity;
import android.app.Dialog;
import android.content.res.Resources.Theme;
import android.text.Spanned;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.util.jar.JarUtils;
import org.json.JSONObject;

public class BNDialog extends Dialog {
    private String currDialogId;
    private boolean isSupportDayNight = false;
    private FrameLayout mContentList;
    private TextView mFirstBtn;
    private boolean mFirstHasText;
    private LinearLayout mLayoutContentList;
    private TextView mMessage;
    private OnNaviClickListener mOnFirstBtnClickListener;
    private OnNaviClickListener mOnSecondBtnClickListener;
    private TextView mSecondBtn;
    private boolean mSecondHasText;
    private TextView mTitleBar;
    private TextView mTitleBarList;
    private LinearLayout mTopContentLayout;

    public interface OnNaviClickListener {
        void onClick();
    }

    /* renamed from: com.baidu.navisdk.ui.widget.BNDialog$1 */
    class C45751 implements OnClickListener {
        C45751() {
        }

        public void onClick(View v) {
            if (BNDialog.this.mOnFirstBtnClickListener != null) {
                BNDialog.this.mOnFirstBtnClickListener.onClick();
            }
            BNDialog.this.dismiss();
        }
    }

    /* renamed from: com.baidu.navisdk.ui.widget.BNDialog$2 */
    class C45762 implements OnClickListener {
        C45762() {
        }

        public void onClick(View v) {
            if (BNDialog.this.mOnSecondBtnClickListener != null) {
                BNDialog.this.mOnSecondBtnClickListener.onClick();
            }
            try {
                BNDialog.this.dismiss();
            } catch (Exception e) {
            }
        }
    }

    public BNDialog(Activity activity) {
        super(activity);
        Theme theme = JarUtils.getResources().newTheme();
        theme.applyStyle(C4048R.style.BNDialog, true);
        JarUtils.setDialogThemeField(this, theme);
        this.currDialogId = "BaiduMapAutoSDK_Dialog_" + System.currentTimeMillis();
        View view = JarUtils.inflate(activity, C4048R.layout.nsdk_layout_common_dialog, null);
        try {
            setContentView(view);
            this.mTopContentLayout = (LinearLayout) view.findViewById(C4048R.id.top_content);
            this.mTitleBar = (TextView) view.findViewById(C4048R.id.title_bar);
            this.mMessage = (TextView) view.findViewById(C4048R.id.content_message);
            this.mLayoutContentList = (LinearLayout) findViewById(C4048R.id.layout_list);
            this.mContentList = (FrameLayout) findViewById(C4048R.id.content_list);
            this.mTitleBarList = (TextView) findViewById(C4048R.id.title_bar_list);
            this.mFirstBtn = (TextView) view.findViewById(C4048R.id.first_btn);
            this.mSecondBtn = (TextView) view.findViewById(C4048R.id.second_btn);
            this.mFirstBtn.setOnClickListener(new C45751());
            this.mSecondBtn.setOnClickListener(new C45762());
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
        this.mTopContentLayout.setBackgroundDrawable(JarUtils.getResources().getDrawable(C4048R.drawable.nsdk_drawable_common_dialog_top));
        this.mTitleBar.setTextColor(JarUtils.getResources().getColor(C4048R.color.nsdk_color_dialog_content_text));
        this.mMessage.setTextColor(JarUtils.getResources().getColor(C4048R.color.nsdk_color_dialog_content_text));
        this.mFirstBtn.setTextColor(JarUtils.getResources().getColor(C4048R.color.nsdk_color_dialog_content_text));
        this.mSecondBtn.setTextColor(JarUtils.getResources().getColor(C4048R.color.nsdk_color_dialog_content_text));
        if (this.mFirstHasText && this.mSecondHasText) {
            this.mFirstBtn.setBackgroundDrawable(JarUtils.getResources().getDrawable(C4048R.drawable.nsdk_common_dialog_left));
            this.mSecondBtn.setBackgroundDrawable(JarUtils.getResources().getDrawable(C4048R.drawable.nsdk_common_dialog_right));
        } else if (!this.mFirstHasText && this.mSecondHasText) {
            this.mSecondBtn.setBackgroundDrawable(JarUtils.getResources().getDrawable(C4048R.drawable.nsdk_common_dialog_chang));
        } else if (this.mFirstHasText && !this.mSecondHasText) {
            this.mFirstBtn.setBackgroundDrawable(JarUtils.getResources().getDrawable(C4048R.drawable.nsdk_common_dialog_chang));
        }
    }

    public void updateStyle() {
        this.isSupportDayNight = true;
        this.mTopContentLayout.setBackgroundDrawable(BNStyleManager.getDrawable(C4048R.drawable.nsdk_drawable_common_dialog_top));
        this.mTitleBar.setTextColor(BNStyleManager.getColor(C4048R.color.nsdk_color_dialog_content_text));
        this.mMessage.setTextColor(BNStyleManager.getColor(C4048R.color.nsdk_color_dialog_content_text));
        this.mFirstBtn.setTextColor(BNStyleManager.getColor(C4048R.color.nsdk_color_dialog_content_text));
        this.mSecondBtn.setTextColor(BNStyleManager.getColor(C4048R.color.nsdk_color_dialog_content_text));
        if (this.mFirstHasText && this.mSecondHasText) {
            this.mFirstBtn.setBackgroundDrawable(BNStyleManager.getDrawable(C4048R.drawable.nsdk_common_dialog_left));
            this.mSecondBtn.setBackgroundDrawable(BNStyleManager.getDrawable(C4048R.drawable.nsdk_common_dialog_right));
        } else if (!this.mFirstHasText && this.mSecondHasText) {
            this.mSecondBtn.setBackgroundDrawable(BNStyleManager.getDrawable(C4048R.drawable.nsdk_common_dialog_chang));
        } else if (this.mFirstHasText && !this.mSecondHasText) {
            this.mFirstBtn.setBackgroundDrawable(BNStyleManager.getDrawable(C4048R.drawable.nsdk_common_dialog_chang));
        }
    }

    public BNDialog setContentMessage(String text) {
        if (this.mMessage != null) {
            if (TextUtils.isEmpty(text)) {
                this.mMessage.setVisibility(8);
                this.mMessage.setText("", BufferType.SPANNABLE);
            } else {
                this.mMessage.setVisibility(0);
                this.mMessage.setText(text, BufferType.SPANNABLE);
            }
        }
        return this;
    }

    public BNDialog setContentCenter() {
        this.mMessage.setGravity(17);
        return this;
    }

    public BNDialog setContentMessage(int resId) {
        return setContentMessage(JarUtils.getResources().getString(resId));
    }

    public BNDialog setContentMessageFromActivity(int resId) {
        this.mMessage.setVisibility(0);
        this.mMessage.setText(resId, BufferType.SPANNABLE);
        return this;
    }

    public BNDialog setContentList(View content) {
        if (this.mTopContentLayout != null) {
            this.mTopContentLayout.setBackgroundResource(BNStyleManager.getColor(C4048R.drawable.transparent));
        }
        if (this.mLayoutContentList != null) {
            this.mLayoutContentList.setVisibility(0);
        }
        if (this.mContentList != null) {
            this.mContentList.removeAllViews();
            this.mContentList.addView(content);
        }
        return this;
    }

    public BNDialog setTitleText(String text) {
        if (this.mTitleBar != null) {
            if (text == null) {
                this.mTitleBar.setVisibility(8);
                this.mTitleBar.setText("", BufferType.SPANNABLE);
            } else {
                this.mTitleBar.setVisibility(0);
                this.mTitleBar.setText(text, BufferType.SPANNABLE);
            }
        }
        return this;
    }

    public BNDialog setTitleText(int resId) {
        return setTitleText(JarUtils.getResources().getString(resId));
    }

    public BNDialog setTitleTextFromActivity(int resId) {
        this.mTitleBar.setVisibility(0);
        this.mTitleBar.setText(resId, BufferType.SPANNABLE);
        return this;
    }

    public BNDialog setFirstBtnText(String text) {
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

    public BNDialog setFirstBtnText(Spanned text) {
        if (text == null) {
            this.mFirstHasText = false;
            this.mFirstBtn.setText("");
        } else {
            this.mFirstHasText = true;
            this.mFirstBtn.setText(text);
        }
        setBtnVisible();
        return this;
    }

    public BNDialog setFirstBtnText(boolean isDayStyle, String text) {
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

    public BNDialog setFirstBtnTextFromActivity(int resId) {
        this.mFirstHasText = true;
        this.mFirstBtn.setText(resId, BufferType.SPANNABLE);
        setBtnVisible();
        return this;
    }

    public BNDialog setListTitleText(String text) {
        if (text == null) {
            this.mTitleBarList.setVisibility(8);
            this.mTitleBarList.setText("", BufferType.SPANNABLE);
        } else {
            this.mTopContentLayout.setVisibility(8);
            this.mTitleBarList.setVisibility(0);
            this.mTitleBarList.setText(text, BufferType.SPANNABLE);
        }
        this.mTitleBarList.setTextColor(BNStyleManager.getColor(C4048R.color.navi_dialog_high_light));
        this.mTitleBarList.setBackgroundDrawable(BNStyleManager.getDrawable(C4048R.drawable.nsdk_drawable_common_dialog_top));
        return this;
    }

    public BNDialog setFirstBtnText(int resId) {
        return setFirstBtnText(JarUtils.getResources().getString(resId));
    }

    public BNDialog setSecondBtnText(String text) {
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

    public BNDialog setSecondBtnText(Spanned text) {
        if (text == null) {
            this.mSecondHasText = false;
            this.mSecondBtn.setText("");
        } else {
            this.mSecondHasText = true;
            this.mSecondBtn.setText(text);
        }
        setBtnVisible();
        return this;
    }

    public BNDialog setSecondBtnText(boolean isDayStyle, String text) {
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

    public BNDialog setSecondBtnTextFromActivity(int resId) {
        this.mSecondHasText = true;
        this.mSecondBtn.setText(resId, BufferType.SPANNABLE);
        setBtnVisible();
        return this;
    }

    public BNDialog setSecondBtnText(int resId) {
        return setSecondBtnText(JarUtils.getResources().getString(resId));
    }

    public BNDialog setFirstBtnTextColorHighLight() {
        this.mFirstBtn.setTextColor(-12352272);
        return this;
    }

    public BNDialog setSecondBtnTextColorHighLight() {
        this.mSecondBtn.setTextColor(-12352272);
        return this;
    }

    public BNDialog setOnFirstBtnClickListener(OnNaviClickListener listener) {
        this.mOnFirstBtnClickListener = listener;
        return this;
    }

    public BNDialog setOnSecondBtnClickListener(OnNaviClickListener listener) {
        this.mOnSecondBtnClickListener = listener;
        return this;
    }

    public BNDialog setFirstBtnEnabled(boolean enabled) {
        this.mFirstBtn.setEnabled(enabled);
        return this;
    }

    public BNDialog setSecondBtnEnabled(boolean enabled) {
        this.mSecondBtn.setEnabled(enabled);
        return this;
    }

    public BNDialog enableBackKey(boolean cancelable) {
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

    private void setBtnVisible(boolean isDayStyle) {
        if (!this.mFirstHasText && !this.mSecondHasText) {
            this.mFirstBtn.setVisibility(8);
            this.mSecondBtn.setVisibility(8);
        } else if (!this.mSecondHasText && this.mFirstHasText) {
            this.mFirstBtn.setVisibility(0);
            this.mSecondBtn.setVisibility(8);
            this.mFirstBtn.setBackgroundDrawable(BNStyleManager.getDrawable(C4048R.drawable.nsdk_common_dialog_chang, isDayStyle));
        } else if (!this.mFirstHasText && this.mSecondHasText) {
            this.mFirstBtn.setVisibility(8);
            this.mSecondBtn.setVisibility(0);
            this.mSecondBtn.setBackgroundDrawable(BNStyleManager.getDrawable(C4048R.drawable.nsdk_common_dialog_chang, isDayStyle));
        } else if (this.mFirstHasText && this.mSecondHasText) {
            this.mFirstBtn.setVisibility(0);
            this.mSecondBtn.setVisibility(0);
            this.mFirstBtn.setBackgroundDrawable(BNStyleManager.getDrawable(C4048R.drawable.nsdk_common_dialog_left, isDayStyle));
            this.mSecondBtn.setBackgroundDrawable(BNStyleManager.getDrawable(C4048R.drawable.nsdk_common_dialog_right, isDayStyle));
        }
    }

    public TextView getFirstBtn() {
        return this.mFirstBtn;
    }

    public TextView getSecondBtn() {
        return this.mSecondBtn;
    }

    public void show() {
        if (this.isSupportDayNight) {
            updateStyle();
        } else {
            updateDayStyle();
        }
        try {
            JSONObject json = new JSONObject();
            json.put("dialogid", this.currDialogId);
            json.put("type", PushConstants.EXTRA_PUSH_MESSAGE);
            JSONObject value = new JSONObject();
            value.put("title", this.mTitleBar.getText().toString());
            value.put("content", this.mMessage.getText().toString());
            value.put("firstbtn", this.mFirstBtn.getText().toString());
            value.put("secondbtn", this.mSecondBtn.getText().toString());
            json.put("value", value);
            if (BNDialogListenerMang.getInstance().getBNDialogListener() != null) {
                BNDialogListenerMang.getInstance().getBNDialogListener().onShow(this.currDialogId, json.toString(), this);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        super.show();
    }

    public void dismiss() {
        this.mFirstHasText = false;
        this.mSecondHasText = false;
        if (BNDialogListenerMang.getInstance().getBNDialogListener() != null) {
            BNDialogListenerMang.getInstance().getBNDialogListener().onDismiss(this.currDialogId);
        }
        super.dismiss();
    }
}
