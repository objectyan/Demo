package com.baidu.navisdk.ui.widget;

import android.app.Activity;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.ui.widget.BNBaseDialog.OnNaviClickListener;
import com.baidu.navisdk.util.jar.JarUtils;
import java.util.regex.Pattern;

public class BNMessageDialog extends BNBaseDialog {
    private EditText mEditText;
    private OnFocusChangeListener mOnFocusChangeListener = new C45881();
    private TextView mTextView;

    /* renamed from: com.baidu.navisdk.ui.widget.BNMessageDialog$1 */
    class C45881 implements OnFocusChangeListener {
        C45881() {
        }

        public void onFocusChange(View v, boolean hasFocus) {
            if (!hasFocus) {
                ((InputMethodManager) BNaviModuleManager.getContext().getSystemService("input_method")).hideSoftInputFromWindow(((EditText) v).getWindowToken(), 0);
            }
        }
    }

    public BNMessageDialog(Activity activity) {
        super(activity);
        View view = JarUtils.inflate(activity, C4048R.layout.nsdk_layout_message_dialog, null);
        if (view != null) {
            this.mTextView = (TextView) view.findViewById(C4048R.id.text_view);
            this.mEditText = (EditText) view.findViewById(C4048R.id.edit_text);
            this.mEditText.setOnFocusChangeListener(this.mOnFocusChangeListener);
            setContent(view);
        }
    }

    public void setEditTextFocus(boolean focusable) {
        this.mEditText.setFocusable(focusable);
    }

    public BNMessageDialog setMessage(String text) {
        if (this.mTextView != null) {
            this.mTextView.setVisibility(0);
            this.mTextView.setText(text, BufferType.SPANNABLE);
        }
        if (this.mEditText != null) {
            this.mEditText.setVisibility(8);
        }
        return this;
    }

    public BNMessageDialog setMessageWidth(int width) {
        LayoutParams params = this.mTextView.getLayoutParams();
        params.width = width;
        this.mTextView.setLayoutParams(params);
        return this;
    }

    public BNMessageDialog setMessageHeight(int height) {
        LayoutParams params = this.mTextView.getLayoutParams();
        params.height = height;
        this.mTextView.setLayoutParams(params);
        return this;
    }

    public BNMessageDialog setEditTextMessage(String text) {
        this.mTextView.setVisibility(8);
        this.mEditText.setVisibility(0);
        this.mEditText.setText(text, BufferType.SPANNABLE);
        return this;
    }

    public BNMessageDialog setEditTextMessageWidth(int width) {
        LayoutParams params = this.mEditText.getLayoutParams();
        params.width = width;
        this.mEditText.setLayoutParams(params);
        return this;
    }

    public BNMessageDialog setEditTextMessageHeight(int height) {
        LayoutParams params = this.mEditText.getLayoutParams();
        params.height = height;
        this.mEditText.setLayoutParams(params);
        return this;
    }

    public String getEditTextMessage() {
        return this.mEditText.getText().toString();
    }

    public BNMessageDialog setTitleText(String text) {
        super.setTitleText(text);
        return this;
    }

    public BNMessageDialog setFirstBtnText(String text) {
        super.setFirstBtnText(text);
        return this;
    }

    public BNMessageDialog setSecondBtnText(String text) {
        super.setSecondBtnText(text);
        return this;
    }

    public BNMessageDialog setContent(View content) {
        super.setContent(content);
        return this;
    }

    public BNMessageDialog setOnFirstBtnClickListener(OnNaviClickListener listener) {
        super.setOnFirstBtnClickListener(listener);
        return this;
    }

    public BNMessageDialog setOnSecondBtnClickListener(OnNaviClickListener listener) {
        super.setOnSecondBtnClickListener(listener);
        return this;
    }

    public BNMessageDialog setContentWidth(int width) {
        super.setContentWidth(width);
        return this;
    }

    public BNMessageDialog setContentHeight(int height) {
        super.setContentHeight(height);
        return this;
    }

    public BNMessageDialog setFirstBtnEnabled(boolean enabled) {
        super.setFirstBtnEnabled(enabled);
        return this;
    }

    public BNMessageDialog setSecondBtnEnabled(boolean enabled) {
        super.setSecondBtnEnabled(enabled);
        return this;
    }

    public BNMessageDialog enableBackKey(boolean cancelable) {
        super.enableBackKey(cancelable);
        return this;
    }

    public BNMessageDialog setFilter(InputFilter[] filters) {
        this.mEditText.setFilters(filters);
        return this;
    }

    public BNMessageDialog setLastSelection() {
        this.mEditText.setSelection(getEditTextMessage().length());
        return this;
    }

    public BNMessageDialog setStringFilter(final String regEx) {
        this.mEditText.addTextChangedListener(new TextWatcher() {
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String source = BNMessageDialog.this.mEditText.getText().toString();
                String dest = BNMessageDialog.this.strFilter(source, regEx);
                if (!source.equals(dest)) {
                    BNMessageDialog.this.mEditText.setText(dest);
                    BNMessageDialog.this.mEditText.setSelection(dest.length());
                }
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void afterTextChanged(Editable s) {
            }
        });
        return this;
    }

    private String strFilter(String str, String regEx) {
        return Pattern.compile(regEx).matcher(str).replaceAll("").trim();
    }

    public void show() {
        if (this.isSupportDayNight) {
            this.mTextView.setTextColor(BNStyleManager.getColor(C4048R.color.nsdk_color_dialog_content_text));
            this.mEditText.setTextColor(BNStyleManager.getColor(C4048R.color.nsdk_color_dialog_content_text));
        }
        super.show();
    }
}
