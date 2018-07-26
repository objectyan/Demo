package com.baidu.navisdk.ui.widget;

import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.util.jar.JarUtils;

public class StatusButton extends LinearLayout {
    private onStatusButtonClickListener allListener;
    private RadioButton btn1;
    private RadioButton btn2;
    private RadioButton btn3;
    private RadioGroup btnGroup;
    private OnClickListener cl1;
    private OnClickListener cl2;
    private OnClickListener cl3;
    private boolean isMapMode = true;
    private Context mContext;
    private int setBtnFlag;

    public interface onStatusButtonClickListener {
        void onClick(StatusButton statusButton, StatusButtonChild statusButtonChild);
    }

    /* renamed from: com.baidu.navisdk.ui.widget.StatusButton$1 */
    class C46111 implements OnCheckedChangeListener {
        C46111() {
        }

        public void onCheckedChanged(RadioGroup group, int checkedId) {
            if (checkedId == StatusButton.this.btn1.getId() && StatusButton.this.setBtnFlag != 1) {
                StatusButton.this.setBtnFlag = 1;
            } else if (checkedId == StatusButton.this.btn2.getId() && StatusButton.this.setBtnFlag != 2) {
                StatusButton.this.setBtnFlag = 2;
            } else if (checkedId == StatusButton.this.btn3.getId() && StatusButton.this.setBtnFlag != 3) {
                StatusButton.this.setBtnFlag = 3;
            } else {
                return;
            }
            if (StatusButton.this.allListener != null) {
                switch (StatusButton.this.setBtnFlag) {
                    case 1:
                        StatusButton.this.allListener.onClick(StatusButton.this, StatusButtonChild.LEFT);
                        return;
                    case 2:
                        StatusButton.this.allListener.onClick(StatusButton.this, StatusButtonChild.MID);
                        return;
                    case 3:
                        StatusButton.this.allListener.onClick(StatusButton.this, StatusButtonChild.RIGHT);
                        return;
                    default:
                        return;
                }
            }
            switch (StatusButton.this.setBtnFlag) {
                case 1:
                    if (StatusButton.this.cl1 != null) {
                        StatusButton.this.cl1.onClick(StatusButton.this.btn1);
                        return;
                    }
                    return;
                case 2:
                    if (StatusButton.this.cl2 != null) {
                        StatusButton.this.cl2.onClick(StatusButton.this.btn2);
                        return;
                    }
                    return;
                case 3:
                    if (StatusButton.this.cl3 != null) {
                        StatusButton.this.cl3.onClick(StatusButton.this.btn3);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public enum StatusButtonChild {
        LEFT,
        MID,
        RIGHT
    }

    public StatusButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        initView();
    }

    public StatusButton(Context context) {
        super(context);
        this.mContext = context;
        initView();
    }

    public StatusButton setLeftButtonText(String content) {
        this.btn1.setText(content);
        return this;
    }

    public StatusButton setLeftButtonText(int resid) {
        this.btn1.setText(resid);
        return this;
    }

    public StatusButton setMidButtonText(String content) {
        this.btn2.setText(content);
        return this;
    }

    public StatusButton setMidButtonText(int resid) {
        this.btn2.setText(resid);
        return this;
    }

    public StatusButton setRightButtonText(String content) {
        this.btn3.setText(content);
        return this;
    }

    public StatusButton setRightButtonText(int resid) {
        this.btn3.setText(resid);
        return this;
    }

    public StatusButton setAllButtonText(String content1, String content2, String content3) {
        this.btn1.setText(content1);
        this.btn2.setText(content2);
        this.btn3.setText(content3);
        return this;
    }

    public StatusButton setAllButtonText(int resId1, int resId2, int resId3) {
        this.btn1.setText(resId1);
        this.btn2.setText(resId2);
        this.btn3.setText(resId3);
        return this;
    }

    public StatusButton setAllButtonText(String contentLeft, String contentRight) {
        this.btn1.setText(contentLeft);
        this.btn2.setVisibility(8);
        this.btn3.setText(contentRight);
        return this;
    }

    public StatusButton setAllButtonText(int resIdLeft, int resIdRight) {
        this.btn1.setText(resIdLeft);
        this.btn2.setVisibility(8);
        this.btn3.setText(resIdRight);
        return this;
    }

    public StatusButton setLeftBtnChecked() {
        this.btn1.setChecked(true);
        this.setBtnFlag = 1;
        return this;
    }

    public StatusButton setMidBtnChecked() {
        this.btn2.setChecked(true);
        this.setBtnFlag = 2;
        return this;
    }

    public StatusButton setRightBtnChecked() {
        this.btn3.setChecked(true);
        this.setBtnFlag = 3;
        return this;
    }

    public StatusButton setLeftBtnClickListener(OnClickListener leftCL) {
        this.cl1 = leftCL;
        return this;
    }

    public StatusButton setMidBtnClickListener(OnClickListener midCL) {
        this.cl2 = midCL;
        return this;
    }

    public StatusButton setRightBtnClickListener(OnClickListener rightCL) {
        this.cl3 = rightCL;
        return this;
    }

    public StatusButton setAllBtnClickListener(onStatusButtonClickListener allListener) {
        this.allListener = allListener;
        return this;
    }

    public StatusButton setMidBtnGone(boolean isGone) {
        this.btn2.setVisibility(8);
        return this;
    }

    public void updateDayStyle() {
        if (this.isMapMode) {
            this.btn1.setTextColor(createColorStateList(BNStyleManager.getColor(C4048R.color.nsdk_statusbutton_tc_default), BNStyleManager.getColor(C4048R.color.nsdk_statusbutton_tc_pressed), BNStyleManager.getColor(C4048R.color.nsdk_statusbutton_tc_pressed)));
            this.btn2.setTextColor(createColorStateList(BNStyleManager.getColor(C4048R.color.nsdk_statusbutton_tc_default), BNStyleManager.getColor(C4048R.color.nsdk_statusbutton_tc_pressed), BNStyleManager.getColor(C4048R.color.nsdk_statusbutton_tc_pressed)));
            this.btn3.setTextColor(createColorStateList(BNStyleManager.getColor(C4048R.color.nsdk_statusbutton_tc_default), BNStyleManager.getColor(C4048R.color.nsdk_statusbutton_tc_pressed), BNStyleManager.getColor(C4048R.color.nsdk_statusbutton_tc_pressed)));
            if (VERSION.SDK_INT > 15) {
                this.btn1.setBackground(BNStyleManager.getDrawable(C4048R.drawable.nsdk_drawable_statusbutton_left_button));
                this.btn2.setBackground(BNStyleManager.getDrawable(C4048R.drawable.nsdk_drawable_statusbutton_mid_button));
                this.btn3.setBackground(BNStyleManager.getDrawable(C4048R.drawable.nsdk_drawable_statusbutton_right_button));
                return;
            }
            this.btn1.setBackgroundDrawable(BNStyleManager.getDrawable(C4048R.drawable.nsdk_drawable_statusbutton_left_button));
            this.btn2.setBackgroundDrawable(BNStyleManager.getDrawable(C4048R.drawable.nsdk_drawable_statusbutton_mid_button));
            this.btn3.setBackgroundDrawable(BNStyleManager.getDrawable(C4048R.drawable.nsdk_drawable_statusbutton_right_button));
        }
    }

    private void initView() {
        this.isMapMode = BNSettingManager.isUsingMapMode();
        if (this.isMapMode) {
            JarUtils.inflate((Activity) this.mContext, C4048R.layout.nsdk_layout_statusbutton, this);
        } else {
            JarUtils.inflate((Activity) this.mContext, C4048R.layout.nsdk_layout_statusbutton_carmode, this);
        }
        this.btnGroup = (RadioGroup) findViewById(C4048R.id.rbtngroup);
        this.btn1 = (RadioButton) this.btnGroup.getChildAt(0);
        this.btn2 = (RadioButton) this.btnGroup.getChildAt(1);
        this.btn3 = (RadioButton) this.btnGroup.getChildAt(2);
        if (!BNStyleManager.getDayStyle()) {
            updateDayStyle();
        }
        this.btnGroup.setOnCheckedChangeListener(new C46111());
    }

    private ColorStateList createColorStateList(int normal, int pressed, int checked) {
        int[] colors = new int[]{pressed, checked, normal};
        states = new int[3][];
        states[0] = new int[]{16842919};
        states[1] = new int[]{16842912};
        states[2] = new int[0];
        return new ColorStateList(states, colors);
    }
}
