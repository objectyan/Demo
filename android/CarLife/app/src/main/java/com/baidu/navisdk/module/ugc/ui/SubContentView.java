package com.baidu.navisdk.module.ugc.ui;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.text.Editable;
import android.text.Html;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.module.ugc.ui.SubContentContract.Presenter;
import com.baidu.navisdk.module.ugc.ui.SubContentContract.View;
import com.baidu.navisdk.module.ugc.utils.UgcImageLoaderUtils;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.jar.JarUtils;

public abstract class SubContentView implements OnClickListener, View {
    private static final int TEXT_MAX_LENGTH = 40;
    private EditText descriEditText;
    private ViewGroup[] detailContainerArr;
    private android.view.View detailFlagTv;
    private android.view.View detailLayout;
    private android.view.View[] detailSpaceViewArr;
    private ViewGroup[] laneContainerArr;
    protected android.view.View laneLayout;
    private android.view.View[] laneSpaceViewArr;
    TextWatcher mContentTextWatcher;
    protected Context mContext;
    private OnFocusChangeListener mOnFocusChangeListener;
    private int mOrientation;
    private Presenter mPresenter;
    private ImageView photoDeletedIv;
    private ImageView photoGetIv;
    private ImageView photoShowIv;
    private android.view.View photoShowLayout;
    private ViewGroup[] positionContainerArr;
    private android.view.View positionLayout;
    private android.view.View[] positionSpaceViewArr;
    protected android.view.View rootView;
    private TextView soundsDecTv;
    private ImageView soundsGetIv;
    private ImageView subTitleIv;
    private TextView subTitleStrIv;
    private Button uploadCommonBtn;
    private Button uploadNaviBtn;
    private OnClickListener viewGroupListener;

    /* renamed from: com.baidu.navisdk.module.ugc.ui.SubContentView$1 */
    class C42031 implements OnFocusChangeListener {
        C42031() {
        }

        public void onFocusChange(android.view.View v, boolean hasFocus) {
            if (!hasFocus) {
                SubContentView.this.hideInputMethod();
            }
        }
    }

    /* renamed from: com.baidu.navisdk.module.ugc.ui.SubContentView$2 */
    class C42042 implements OnClickListener {
        C42042() {
        }

        public void onClick(android.view.View v) {
            if (SubContentView.this.laneContainerArr != null && SubContentView.this.positionContainerArr != null && SubContentView.this.detailContainerArr != null) {
                try {
                    SubContentView.this.proccessViewGroupClickPerform((ViewGroup) v);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* renamed from: com.baidu.navisdk.module.ugc.ui.SubContentView$3 */
    class C42053 implements TextWatcher {
        C42053() {
        }

        public void afterTextChanged(Editable s) {
            int nSelStart = SubContentView.this.descriEditText.getSelectionStart();
            int nSelEnd = SubContentView.this.descriEditText.getSelectionEnd();
            boolean nOverMaxLength = s.length() > 40;
            if (SubContentView.this.soundsGetIv != null) {
                if (SubContentView.this.soundsGetIv == null || s == null || s.length() <= 0) {
                    SubContentView.this.soundsGetIv.setBackgroundDrawable(BNStyleManager.getDrawable(C4048R.drawable.ugc_sub_info_fill_sounds_icon));
                } else {
                    SubContentView.this.soundsGetIv.setBackgroundDrawable(BNStyleManager.getDrawable(C4048R.drawable.ugc_sub_info_fill_sounds_deleted_icon));
                }
            }
            if (nOverMaxLength) {
                try {
                    SubContentView.this.descriEditText.setText(SubContentView.this.descriEditText.getText().toString().substring(0, 40));
                } catch (Exception e) {
                }
                TipTool.onCreateToastDialog(SubContentView.this.mContext, JarUtils.getResources().getString(C4048R.string.nsdk_string_ugc_report_content_max_length));
            }
            if (SubContentView.this.mPresenter != null) {
                SubContentView.this.mPresenter.recordContentChange(SubContentView.this.descriEditText.getText().toString());
            }
        }

        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }
    }

    public SubContentView(Context mContext) {
        this(mContext, 1);
    }

    public SubContentView(Context mContext, int orientation) {
        this.rootView = null;
        this.mContext = null;
        this.mPresenter = null;
        this.laneLayout = null;
        this.detailLayout = null;
        this.positionLayout = null;
        this.laneContainerArr = new ViewGroup[4];
        this.laneSpaceViewArr = new android.view.View[3];
        this.positionContainerArr = new ViewGroup[4];
        this.positionSpaceViewArr = new android.view.View[3];
        this.detailContainerArr = new ViewGroup[4];
        this.detailSpaceViewArr = new android.view.View[3];
        this.subTitleIv = null;
        this.subTitleStrIv = null;
        this.descriEditText = null;
        this.photoGetIv = null;
        this.soundsGetIv = null;
        this.photoShowLayout = null;
        this.photoShowIv = null;
        this.photoDeletedIv = null;
        this.soundsDecTv = null;
        this.detailFlagTv = null;
        this.mOrientation = 2;
        this.uploadCommonBtn = null;
        this.uploadNaviBtn = null;
        this.mOnFocusChangeListener = new C42031();
        this.viewGroupListener = new C42042();
        this.mContentTextWatcher = new C42053();
        initVariable(mContext, orientation);
        initView();
        initListener();
    }

    private void initListener() {
        if (this.photoGetIv != null) {
            this.photoGetIv.setOnClickListener(this);
        }
        if (this.photoDeletedIv != null) {
            this.photoDeletedIv.setOnClickListener(this);
        }
        if (this.soundsGetIv != null) {
            this.soundsGetIv.setOnClickListener(this);
        }
        if (this.descriEditText != null) {
            this.descriEditText.setOnFocusChangeListener(this.mOnFocusChangeListener);
        }
    }

    private void initView() {
        if (this.mOrientation == 1) {
            this.rootView = JarUtils.inflate((Activity) this.mContext, C4048R.layout.nsdk_layout_ugc_report_sub_detail_view, null);
        } else {
            this.rootView = JarUtils.inflate((Activity) this.mContext, C4048R.layout.nsdk_layout_ugc_report_sub_detail_view_land, null);
        }
        if (this.rootView != null) {
            if (this.laneContainerArr != null && this.laneContainerArr.length >= 4) {
                this.laneContainerArr[0] = (ViewGroup) this.rootView.findViewById(C4048R.id.ugc_sub_lane_info_container1);
                this.laneContainerArr[1] = (ViewGroup) this.rootView.findViewById(C4048R.id.ugc_sub_lane_info_container2);
                this.laneContainerArr[2] = (ViewGroup) this.rootView.findViewById(C4048R.id.ugc_sub_lane_info_container3);
                this.laneContainerArr[3] = (ViewGroup) this.rootView.findViewById(C4048R.id.ugc_sub_lane_info_container4);
                if (!(this.laneContainerArr[0] == null || this.laneContainerArr[1] == null || this.laneContainerArr[2] == null || this.laneContainerArr[3] == null)) {
                    this.laneContainerArr[0].setTag(this.rootView.findViewById(C4048R.id.ugc_sub_lane_info_tv1));
                    this.laneContainerArr[1].setTag(this.rootView.findViewById(C4048R.id.ugc_sub_lane_info_tv2));
                    this.laneContainerArr[2].setTag(this.rootView.findViewById(C4048R.id.ugc_sub_lane_info_tv3));
                    this.laneContainerArr[3].setTag(this.rootView.findViewById(C4048R.id.ugc_sub_lane_info_tv4));
                }
            }
            if (this.laneSpaceViewArr != null && this.laneSpaceViewArr.length >= 3) {
                this.laneSpaceViewArr[0] = this.rootView.findViewById(C4048R.id.ugc_sub_lane_info_space1);
                this.laneSpaceViewArr[1] = this.rootView.findViewById(C4048R.id.ugc_sub_lane_info_space2);
                this.laneSpaceViewArr[2] = this.rootView.findViewById(C4048R.id.ugc_sub_lane_info_space3);
            }
            if (this.positionContainerArr != null && this.positionContainerArr.length >= 4) {
                this.positionContainerArr[0] = (ViewGroup) this.rootView.findViewById(C4048R.id.ugc_sub_position_info_container1);
                this.positionContainerArr[1] = (ViewGroup) this.rootView.findViewById(C4048R.id.ugc_sub_position_info_container2);
                this.positionContainerArr[2] = (ViewGroup) this.rootView.findViewById(C4048R.id.ugc_sub_position_info_container3);
                this.positionContainerArr[3] = (ViewGroup) this.rootView.findViewById(C4048R.id.ugc_sub_position_info_container4);
                if (!(this.positionContainerArr[0] == null || this.positionContainerArr[1] == null || this.positionContainerArr[2] == null || this.positionContainerArr[3] == null)) {
                    this.positionContainerArr[0].setTag(this.rootView.findViewById(C4048R.id.ugc_sub_position_info_tv1));
                    this.positionContainerArr[1].setTag(this.rootView.findViewById(C4048R.id.ugc_sub_position_info_tv2));
                    this.positionContainerArr[2].setTag(this.rootView.findViewById(C4048R.id.ugc_sub_position_info_tv3));
                    this.positionContainerArr[3].setTag(this.rootView.findViewById(C4048R.id.ugc_sub_position_info_tv4));
                }
            }
            if (this.positionSpaceViewArr != null && this.positionSpaceViewArr.length >= 3) {
                this.positionSpaceViewArr[0] = this.rootView.findViewById(C4048R.id.ugc_sub_position_info_space1);
                this.positionSpaceViewArr[1] = this.rootView.findViewById(C4048R.id.ugc_sub_position_info_space2);
                this.positionSpaceViewArr[2] = this.rootView.findViewById(C4048R.id.ugc_sub_position_info_space3);
            }
            if (this.detailContainerArr != null && this.detailContainerArr.length >= 4) {
                this.detailContainerArr[0] = (ViewGroup) this.rootView.findViewById(C4048R.id.ugc_sub_detail_info_container1);
                this.detailContainerArr[1] = (ViewGroup) this.rootView.findViewById(C4048R.id.ugc_sub_detail_info_container2);
                this.detailContainerArr[2] = (ViewGroup) this.rootView.findViewById(C4048R.id.ugc_sub_detail_info_container3);
                this.detailContainerArr[3] = (ViewGroup) this.rootView.findViewById(C4048R.id.ugc_sub_detail_info_container4);
                if (!(this.detailContainerArr[0] == null || this.detailContainerArr[1] == null || this.detailContainerArr[2] == null || this.detailContainerArr[3] == null)) {
                    this.detailContainerArr[0].setTag(this.rootView.findViewById(C4048R.id.ugc_sub_detail_info_tv1));
                    this.detailContainerArr[1].setTag(this.rootView.findViewById(C4048R.id.ugc_sub_detail_info_tv2));
                    this.detailContainerArr[2].setTag(this.rootView.findViewById(C4048R.id.ugc_sub_detail_info_tv3));
                    this.detailContainerArr[3].setTag(this.rootView.findViewById(C4048R.id.ugc_sub_detail_info_tv4));
                }
            }
            if (this.detailSpaceViewArr != null && this.detailSpaceViewArr.length >= 3) {
                this.detailSpaceViewArr[0] = this.rootView.findViewById(C4048R.id.ugc_sub_detail_info_space1);
                this.detailSpaceViewArr[1] = this.rootView.findViewById(C4048R.id.ugc_sub_detail_info_space2);
                this.detailSpaceViewArr[2] = this.rootView.findViewById(C4048R.id.ugc_sub_detail_info_space3);
            }
            this.detailLayout = this.rootView.findViewById(C4048R.id.ugc_sub_detail_info_layout);
            this.positionLayout = this.rootView.findViewById(C4048R.id.ugc_sub_position_info_layout);
            this.laneLayout = this.rootView.findViewById(C4048R.id.ugc_sub_lane_layout);
            this.subTitleIv = (ImageView) this.rootView.findViewById(C4048R.id.ugc_sub_title_iv);
            this.subTitleStrIv = (TextView) this.rootView.findViewById(C4048R.id.ugc_sub_title_type_tv);
            this.descriEditText = (EditText) this.rootView.findViewById(C4048R.id.ugc_sub_info_fill_content_et);
            this.photoGetIv = (ImageView) this.rootView.findViewById(C4048R.id.ugc_sub_info_fill_photo_iv);
            this.soundsGetIv = (ImageView) this.rootView.findViewById(C4048R.id.ugc_sub_info_fill_sounds_iv);
            this.photoShowLayout = this.rootView.findViewById(C4048R.id.ugc_sub_photo_show_layout);
            this.photoShowIv = (ImageView) this.rootView.findViewById(C4048R.id.ugc_sub_photo_show_iv);
            this.photoDeletedIv = (ImageView) this.rootView.findViewById(C4048R.id.ugc_sub_photo_show_delete_iv);
            this.soundsDecTv = (TextView) this.rootView.findViewById(C4048R.id.ugc_sub_sounds_content_tv);
            this.detailFlagTv = this.rootView.findViewById(C4048R.id.ugc_sub_detail_falg_tv);
            this.descriEditText.addTextChangedListener(this.mContentTextWatcher);
            this.descriEditText.setHintTextColor(Color.parseColor("#999999"));
            this.uploadCommonBtn = (Button) this.rootView.findViewById(C4048R.id.ugc_sub_upload_btn);
            this.uploadNaviBtn = (Button) this.rootView.findViewById(C4048R.id.ugc_navi_sub_upload_btn);
            showPhotoCancle();
        }
    }

    public void setUploadBtnClickable(boolean flag) {
        if (flag) {
            if (this.uploadCommonBtn != null && this.uploadNaviBtn != null) {
                this.uploadCommonBtn.setClickable(true);
                this.uploadNaviBtn.setClickable(true);
                this.uploadCommonBtn.setBackgroundDrawable(BNStyleManager.getDrawable(C4048R.drawable.bnav_common_ugc_blue_button_selector));
                this.uploadNaviBtn.setBackgroundDrawable(BNStyleManager.getDrawable(C4048R.drawable.bnav_common_ugc_blue_button_selector));
            }
        } else if (this.uploadCommonBtn != null && this.uploadNaviBtn != null) {
            this.uploadCommonBtn.setClickable(false);
            this.uploadNaviBtn.setClickable(false);
            this.uploadCommonBtn.setBackgroundDrawable(BNStyleManager.getDrawable(C4048R.drawable.bnav_common_ugc_gray_button_selector));
            this.uploadNaviBtn.setBackgroundDrawable(BNStyleManager.getDrawable(C4048R.drawable.bnav_common_ugc_gray_button_selector));
        }
    }

    public void hideInputMethod() {
        if (this.descriEditText != null) {
            ((InputMethodManager) BNaviModuleManager.getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.descriEditText.getWindowToken(), 0);
        }
    }

    public void setDetailFlagVisibility(boolean show) {
        if (this.detailFlagTv == null) {
            return;
        }
        if (show) {
            this.detailFlagTv.setVisibility(0);
        } else {
            this.detailFlagTv.setVisibility(8);
        }
    }

    public void initPresenterView() {
        if (this.mPresenter != null) {
            if (this.subTitleIv != null) {
                new UgcImageLoaderUtils().updateUgcViewOnLine(this.mPresenter.getSubType(), this.subTitleIv);
            }
            if (this.subTitleStrIv != null) {
                this.subTitleStrIv.setText(this.mPresenter.getSubTitleText());
            }
            if (this.descriEditText != null) {
                this.descriEditText.setHint("点击填写描述...");
            }
            initViewGroupLayout(this.mPresenter.getLaneInfoGvSize(), this.laneContainerArr, this.laneLayout, this.laneSpaceViewArr);
            initViewGroupLayout(this.mPresenter.getPositionInfoGvSize(), this.positionContainerArr, this.positionLayout, this.positionSpaceViewArr);
            initViewGroupLayout(this.mPresenter.getDetailGvSize(), this.detailContainerArr, this.detailLayout, this.detailSpaceViewArr);
            updateContainerStatusView(-1, this.laneContainerArr);
            updateContainerStatusView(-1, this.positionContainerArr);
            updateContainerStatusView(-1, this.detailContainerArr);
        }
    }

    public void setPositionLayout(boolean show) {
        if (this.positionLayout == null) {
            return;
        }
        if (show) {
            this.positionLayout.setVisibility(0);
        } else {
            this.positionLayout.setVisibility(8);
        }
    }

    private void initViewGroupLayout(int validLen, ViewGroup[] containerArr, android.view.View mLayout, android.view.View[] spacingArr) {
        if (containerArr != null && mLayout != null && this.mPresenter != null && spacingArr != null) {
            if (validLen <= 0) {
                mLayout.setVisibility(8);
                return;
            }
            int i = 0;
            while (i < validLen && i < containerArr.length) {
                if (containerArr[i] != null) {
                    containerArr[i].setVisibility(0);
                    containerArr[i].setOnClickListener(this.viewGroupListener);
                    if (containerArr == this.laneContainerArr) {
                        setViewGroupText(containerArr[i], this.mPresenter.getLaneInfoGvTextTile(i));
                    } else if (containerArr == this.positionContainerArr) {
                        setViewGroupText(containerArr[i], this.mPresenter.getPositionInfoGvTextTile(i));
                    } else if (containerArr == this.detailContainerArr) {
                        setViewGroupText(containerArr[i], this.mPresenter.getDetailGvTextTile(i));
                    }
                }
                i++;
            }
            for (i = validLen; i < containerArr.length; i++) {
                if (containerArr[i] != null) {
                    containerArr[i].setVisibility(8);
                }
            }
            i = 0;
            while (i < validLen - 1 && i < spacingArr.length) {
                if (spacingArr[i] != null) {
                    spacingArr[i].setVisibility(0);
                }
                i++;
            }
            i = validLen - 1;
            while (i >= 0 && i < spacingArr.length) {
                if (spacingArr[i] != null) {
                    spacingArr[i].setVisibility(8);
                }
                i++;
            }
        }
    }

    private void initVariable(Context mContext, int orientation) {
        this.mContext = mContext;
        this.mOrientation = orientation;
    }

    public void showPhotoGraph(Bitmap mBitmap) {
    }

    public void showPhotoCancle() {
        if (this.photoShowLayout != null && this.photoGetIv != null) {
            this.photoShowLayout.setVisibility(8);
            this.photoGetIv.setVisibility(0);
        }
    }

    public void showRecordResult(int recordTime) {
        if (this.soundsDecTv != null && this.descriEditText != null && this.soundsGetIv != null) {
            this.descriEditText.setVisibility(8);
            this.soundsDecTv.setVisibility(0);
            this.soundsGetIv.setBackgroundDrawable(BNStyleManager.getDrawable(C4048R.drawable.ugc_sub_info_fill_sounds_deleted_icon));
            this.soundsDecTv.setText(Html.fromHtml("语音描述  <font color=\"#3a86fd\"> " + recordTime + " \""));
        }
    }

    public android.view.View getParentView() {
        return this.rootView;
    }

    public void onClick(android.view.View v) {
        if (this.mPresenter != null) {
            switch (v.getId()) {
                case C4048R.id.ugc_sub_info_fill_photo_iv /*1711866997*/:
                    this.mPresenter.gotoPhotoCapture();
                    return;
                case C4048R.id.ugc_sub_photo_show_delete_iv /*1711867003*/:
                    this.mPresenter.deletePhotoShow();
                    return;
                case C4048R.id.ugc_sub_info_fill_sounds_iv /*1711867190*/:
                    if (this.soundsDecTv.getVisibility() == 8 && this.descriEditText != null && TextUtils.isEmpty(this.descriEditText.getText())) {
                        this.mPresenter.gotoSoundsRecordDialog();
                        return;
                    } else {
                        this.mPresenter.deletSoundShow();
                        return;
                    }
                default:
                    return;
            }
        }
    }

    public void showSoundCancle() {
        if (this.soundsDecTv != null && this.descriEditText != null && this.soundsGetIv != null) {
            this.descriEditText.setVisibility(0);
            this.descriEditText.setText("");
            this.descriEditText.setHint("点击填写描述...");
            this.soundsDecTv.setVisibility(8);
            this.soundsGetIv.setBackgroundDrawable(BNStyleManager.getDrawable(C4048R.drawable.ugc_sub_info_fill_sounds_icon));
        }
    }

    public Context getContext() {
        return this.mContext;
    }

    public void setPresenter(Presenter presenter) {
        this.mPresenter = presenter;
    }

    private void proccessViewGroupClickPerform(ViewGroup mViewGroup) {
        if (this.laneContainerArr != null && this.positionContainerArr != null && this.detailContainerArr != null) {
            int i;
            ViewGroup[] retViewGroupArr = null;
            ViewGroup retViewGroup = null;
            int index = -1;
            for (i = 0; i < this.laneContainerArr.length; i++) {
                if (this.laneContainerArr[i] == mViewGroup) {
                    retViewGroupArr = this.laneContainerArr;
                    retViewGroup = this.laneContainerArr[i];
                    index = i;
                    break;
                }
            }
            i = 0;
            while (index < 0 && i < this.positionContainerArr.length) {
                if (this.positionContainerArr[i] == mViewGroup) {
                    retViewGroupArr = this.positionContainerArr;
                    retViewGroup = this.positionContainerArr[i];
                    index = i;
                    break;
                }
                i++;
            }
            i = 0;
            while (index < 0 && i < this.detailContainerArr.length) {
                if (this.detailContainerArr[i] == mViewGroup) {
                    retViewGroupArr = this.detailContainerArr;
                    retViewGroup = this.detailContainerArr[i];
                    index = i;
                }
                i++;
            }
            if (retViewGroupArr != null && index >= 0) {
                if (((android.view.View) retViewGroup.getTag()).getTag() == null) {
                    updateContainerStatusView(index, retViewGroupArr);
                    recordClickStatus(index, retViewGroupArr);
                    ((android.view.View) retViewGroup.getTag()).setTag(new Object());
                    return;
                }
                updateContainerStatusView(-1, retViewGroupArr);
                recordClickStatus(-1, retViewGroupArr);
                ((android.view.View) retViewGroup.getTag()).setTag(null);
            }
        }
    }

    public void updateSubContainerStatus(int index, int type) {
        if (type == 0) {
            updateContainerStatusView(index, this.laneContainerArr);
            recordClickStatus(index, this.laneContainerArr);
        } else if (type == 1) {
            updateContainerStatusView(index, this.positionContainerArr);
            recordClickStatus(index, this.positionContainerArr);
        } else if (type == 2) {
            updateContainerStatusView(index, this.detailContainerArr);
            recordClickStatus(index, this.detailContainerArr);
        }
    }

    private void updateContainerStatusView(int index, ViewGroup[] mContainerArr) {
        if (mContainerArr != null) {
            for (int i = 0; i < mContainerArr.length; i++) {
                ViewGroup viewGroup = mContainerArr[i];
                TextView mTextView;
                if (i == index) {
                    LogUtil.m15791e("updateContainerStatusView click:", index + "" + mContainerArr.toString());
                    mContainerArr[i].setBackgroundDrawable(BNStyleManager.getDrawable(C4048R.drawable.nsdk_drawable_rg_ugc_view_selected));
                    mTextView = (TextView) mContainerArr[i].getTag();
                    mTextView.setTag(new Object());
                    mTextView.setTextColor(BNStyleManager.getColor(C4048R.color.cl_link_ugc_a));
                } else {
                    LogUtil.m15791e("updateContainerStatusView click:", index + "" + mContainerArr.toString());
                    mContainerArr[i].setBackgroundDrawable(BNStyleManager.getDrawable(C4048R.drawable.nsdk_drawable_rg_ugc_view_unselected));
                    mTextView = (TextView) mContainerArr[i].getTag();
                    mTextView.setTag(null);
                    mTextView.setTextColor(BNStyleManager.getColor(C4048R.color.cl_text_ugc_a));
                }
            }
        }
    }

    private void setViewGroupText(ViewGroup mViewGroup, String text) {
        if (mViewGroup != null && !TextUtils.isEmpty(text)) {
            try {
                ((TextView) mViewGroup.getTag()).setText(text);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void recordClickStatus(int index, ViewGroup[] mContainerArr) {
        if (this.mPresenter == null) {
            return;
        }
        if (mContainerArr == this.laneContainerArr) {
            this.mPresenter.recordLaneSelected(index);
        } else if (mContainerArr == this.positionContainerArr) {
            this.mPresenter.recordPositionSelected(index);
        } else if (mContainerArr == this.detailContainerArr) {
            this.mPresenter.recordDetailSelected(index);
        }
    }

    public void showPhotoBitmap(Bitmap bitmap) {
        if (this.photoShowLayout != null && this.photoShowIv != null && this.photoDeletedIv != null && this.photoGetIv != null && bitmap != null) {
            this.photoShowLayout.setVisibility(0);
            this.photoGetIv.setVisibility(8);
            this.photoShowIv.setImageBitmap(bitmap);
        }
    }

    public void showAddrInfoUpdate(String adress, String adressDecri) {
    }

    public void setDescriEditText(String str) {
        if (this.descriEditText != null) {
            this.descriEditText.setText(str);
        }
        if (this.mPresenter != null) {
            this.mPresenter.recordContentChange(this.descriEditText.getText().toString());
        }
    }

    public void setDescriEditHintText(String string) {
        if (this.descriEditText != null) {
            this.descriEditText.setHint(string);
            this.descriEditText.setVisibility(4);
        }
    }
}
