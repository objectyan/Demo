package com.baidu.navi.fragment;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.carlife.C0965R;
import com.baidu.carlife.view.C2252a;
import com.baidu.carlife.view.C2252a.C2245a;
import com.baidu.carlife.view.KeyboardEditText;
import com.baidu.navi.util.StatisticConstants;
import com.baidu.navi.util.StatisticManager;
import com.baidu.navi.utils.StringUtils;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.ui.routeguide.control.RGCarPreferSettingController;
import com.baidu.navisdk.util.common.ScreenUtil;

public class CarPlateFragment extends ContentFragment implements OnClickListener {
    private OnClickListener clickListener = new C37862();
    private KeyboardEditText edtCarPlateNum;
    private ImageView imgBackBtn;
    private LayoutInflater inflater;
    private final String[][] mCityShotNames;
    private LinearLayout mColumnsLinear;
    private ViewGroup mViewGroup;
    private String oldCarPlate;
    private TextView tvCnCarPlate;
    private TextView tvCompleteBtn;

    /* renamed from: com.baidu.navi.fragment.CarPlateFragment$1 */
    class C37851 implements TextWatcher {
        C37851() {
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            if (charSequence.length() > 0 && i2 - i1 > 0) {
                CarPlateFragment.this.edtCarPlateNum.setText(charSequence.toString().toUpperCase());
                CarPlateFragment.this.edtCarPlateNum.setSelection(charSequence.length());
            }
        }

        public void afterTextChanged(Editable editable) {
        }
    }

    /* renamed from: com.baidu.navi.fragment.CarPlateFragment$2 */
    class C37862 implements OnClickListener {
        C37862() {
        }

        public void onClick(View v) {
            CarPlateFragment.this.tvCnCarPlate.setText(((TextView) v).getText());
        }
    }

    public CarPlateFragment() {
        r0 = new String[4][];
        r0[0] = new String[]{"京", "沪", "鄂", "湘", "川", "渝", "粤", "鲁", "津", "浙"};
        r0[1] = new String[]{"豫", "贵", "青", "琼", "辽", "吉", "藏", "闽"};
        r0[2] = new String[]{"冀", "苏", "皖", "赣", "甘", "陕", "新"};
        r0[3] = new String[]{"黑", "宁", "云", "蒙", "晋", "桂"};
        this.mCityShotNames = r0;
    }

    protected void onUpdateOrientation(int orientation) {
    }

    protected void onUpdateStyle(boolean dayStyle) {
    }

    protected View onCreateContentView(LayoutInflater inflater) {
        this.inflater = inflater;
        this.mViewGroup = (ViewGroup) inflater.inflate(C0965R.layout.frag_car_plate, null);
        initView();
        initData();
        initListener();
        return this.mViewGroup;
    }

    private void initView() {
        this.imgBackBtn = (ImageView) this.mViewGroup.findViewById(C0965R.id.img_back);
        this.tvCompleteBtn = (TextView) this.mViewGroup.findViewById(C0965R.id.tv_commit_btn);
        this.tvCnCarPlate = (TextView) this.mViewGroup.findViewById(C0965R.id.car_plate_head);
        this.edtCarPlateNum = (KeyboardEditText) this.mViewGroup.findViewById(C0965R.id.edt_car_plate_input);
        this.mColumnsLinear = (LinearLayout) this.mViewGroup.findViewById(C0965R.id.ll_keyboard_container);
    }

    private void initData() {
        this.oldCarPlate = BNSettingManager.getPlateFromLocal(BaseFragment.getNaviActivity());
        if (!TextUtils.isEmpty(this.oldCarPlate)) {
            this.tvCnCarPlate.setText(this.oldCarPlate.trim().substring(0, 1));
            this.edtCarPlateNum.setText(this.oldCarPlate.trim().substring(1, this.oldCarPlate.length()));
        }
    }

    private void initListener() {
        this.imgBackBtn.setOnClickListener(this);
        this.tvCompleteBtn.setOnClickListener(this);
        this.tvCnCarPlate.setOnClickListener(this);
        this.edtCarPlateNum.addTextChangedListener(getTextChangedListener());
        KeyboardEditText keyboardEditText = this.edtCarPlateNum;
        C2252a a = C2252a.a();
        a.getClass();
        keyboardEditText.setOnTouchListener(new C2245a(a, this.edtCarPlateNum, 0, null, null));
        this.edtCarPlateNum.setOnClickListener(this);
        C2252a.a().a(this.edtCarPlateNum);
    }

    @NonNull
    private TextWatcher getTextChangedListener() {
        return new C37851();
    }

    protected void onInitView() {
    }

    public void onClick(View v) {
        if (v.getId() != C0965R.id.car_plate_head) {
            dismissPop();
        }
        switch (v.getId()) {
            case C0965R.id.img_back:
                onBackPressed();
                return;
            case C0965R.id.car_plate_head:
                showKeyBoardPop();
                return;
            case C0965R.id.tv_commit_btn:
                hideInputMethodView();
                if (isCanCommit()) {
                    onBackPressed();
                    return;
                } else {
                    Toast.makeText(getContext(), C0965R.string.plate_car_number, 0).show();
                    return;
                }
            default:
                return;
        }
    }

    private boolean hideInputMethodView() {
        if (this.edtCarPlateNum == null) {
            return false;
        }
        InputMethodManager imm = (InputMethodManager) getContext().getSystemService("input_method");
        if (imm == null || !imm.isActive()) {
            return false;
        }
        imm.hideSoftInputFromWindow(this.edtCarPlateNum.getWindowToken(), 0);
        if (this.edtCarPlateNum.hasFocus()) {
            this.edtCarPlateNum.clearFocus();
        }
        return true;
    }

    public boolean onBackPressed() {
        dismissPop();
        hideInputMethodView();
        back();
        return true;
    }

    private void displayColumns() {
        if (this.mColumnsLinear != null) {
            this.mColumnsLinear.removeAllViews();
            this.mColumnsLinear.setVisibility(0);
        }
        for (String[] createLinear : this.mCityShotNames) {
            createLinear(createLinear, 10);
        }
    }

    private void createLinear(String[] shortNames, int maxRows) {
        LinearLayout layout = new LinearLayout(getContext());
        LayoutParams lp = new LayoutParams(-1, -2, 1.0f);
        layout.setOrientation(0);
        layout.setGravity(17);
        layout.setLayoutParams(lp);
        for (CharSequence text : shortNames) {
            View view = this.inflater.inflate(C0965R.layout.item_column, null, false);
            TextView tv = (TextView) view.findViewById(C0965R.id.text);
            tv.setText(text);
            tv.setTextColor(Color.parseColor("#FFFFFFFF"));
            tv.setTextSize(18.0f);
            tv.setOnClickListener(this.clickListener);
            view.setLayoutParams(new LayoutParams(ScreenUtil.getInstance().getHeightPixels() / maxRows, -2));
            tv.setGravity(17);
            layout.addView(view);
        }
        this.mColumnsLinear.addView(layout);
    }

    private void showKeyBoardPop() {
        displayColumns();
        hideInputMethodView();
    }

    private void dismissPop() {
        if (this.mColumnsLinear != null) {
            this.mColumnsLinear.setVisibility(8);
        }
    }

    private boolean isCanCommit() {
        String num = this.edtCarPlateNum.getText().toString();
        if (TextUtils.isEmpty(num)) {
            BNSettingManager.getPlateFromLocal(BaseFragment.getNaviActivity());
            BNRoutePlaner.getInstance().setCalcPrefCarNo("");
            RGCarPreferSettingController.getInstance().updatePreferValue(32, false);
            return true;
        } else if (num.length() <= 5) {
            return false;
        } else {
            String plate = this.tvCnCarPlate.getText().toString().trim() + num;
            if (!StringUtils.isCarPlate(plate)) {
                return false;
            }
            BNSettingManager.setCarPlateToLocal(BaseFragment.getNaviActivity(), plate);
            BNRoutePlaner.getInstance().setCalcPrefCarNo(plate);
            RGCarPreferSettingController.getInstance().updatePreferValue(32, true);
            if (plate.equals(this.oldCarPlate)) {
                return true;
            }
            StatisticManager.onEvent(StatisticConstants.NAVI_0034, StatisticConstants.NAVI_0034);
            return true;
        }
    }
}
