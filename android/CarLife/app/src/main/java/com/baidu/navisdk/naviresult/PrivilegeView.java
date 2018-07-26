package com.baidu.navisdk.naviresult;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.Html;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.model.modelfactory.BusinessActivityModel.NaviEndPrivilege;
import com.baidu.navisdk.ui.util.UIUtils;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.drawable.UrlDrawableContainIView;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.navisdk.util.statistic.userop.UserOPController;
import com.baidu.navisdk.util.statistic.userop.UserOPParams;

public class PrivilegeView {
    private static final int ICONS_MAX = 4;
    private View iconsContainer;
    private ImageView[] iconsList;
    private Activity mActivity;
    private NaviEndPrivilege mData;
    private View privilegeBtn;
    private ImageView privilegeBtnIcon;
    private TextView privilegeBtnTv;
    private TextView privilegeDesp;
    private TextView privilegeDue;
    private LinearLayout rootView = null;
    private View shade;
    private View textContainer;
    private TextView title;

    /* renamed from: com.baidu.navisdk.naviresult.PrivilegeView$1 */
    class C42521 implements OnClickListener {
        C42521() {
        }

        public void onClick(View v) {
            if ("text".equals(PrivilegeView.this.mData.cardType)) {
                UserOPController.getInstance().add(UserOPParams.NAVI_RESULT_6_8);
            } else if ("pic".equals(PrivilegeView.this.mData.cardType)) {
                UserOPController.getInstance().add(UserOPParams.NAVI_RESULT_6_9);
            }
            BNNaviResultController.getInstance().openWithOpenAPI(PrivilegeView.this.mData.hlink);
        }
    }

    public PrivilegeView(Activity activity, NaviEndPrivilege data) {
        this.mActivity = activity;
        this.mData = data;
    }

    public LinearLayout getView() {
        if (this.mActivity == null || this.mData == null) {
            return null;
        }
        View view = JarUtils.inflate(this.mActivity, C4048R.layout.nsdk_layout_navi_result_privilege_view, null);
        if (view == null) {
            return null;
        }
        this.rootView = (LinearLayout) view;
        findViews();
        onDataSetChanged();
        return this.rootView;
    }

    private void findViews() {
        if (this.rootView != null) {
            this.title = (TextView) this.rootView.findViewById(C4048R.id.privilege_title);
            this.iconsContainer = this.rootView.findViewById(C4048R.id.icons_container);
            ImageView icon1 = (ImageView) this.rootView.findViewById(C4048R.id.icon_1);
            ImageView icon2 = (ImageView) this.rootView.findViewById(C4048R.id.icon_2);
            ImageView icon3 = (ImageView) this.rootView.findViewById(C4048R.id.icon_3);
            ImageView icon4 = (ImageView) this.rootView.findViewById(C4048R.id.icon_4);
            this.shade = this.rootView.findViewById(C4048R.id.shade);
            this.textContainer = this.rootView.findViewById(C4048R.id.text_container);
            this.privilegeDesp = (TextView) this.rootView.findViewById(C4048R.id.privilege_description);
            this.privilegeDue = (TextView) this.rootView.findViewById(C4048R.id.privilege_due);
            this.privilegeBtn = this.rootView.findViewById(C4048R.id.privilege_btn);
            this.privilegeBtnIcon = (ImageView) this.rootView.findViewById(C4048R.id.privilege_btn_icon);
            this.privilegeBtnTv = (TextView) this.rootView.findViewById(C4048R.id.privilege_btn_txt);
            this.iconsList = new ImageView[4];
            this.iconsList[0] = icon1;
            this.iconsList[1] = icon2;
            this.iconsList[2] = icon3;
            this.iconsList[3] = icon4;
        }
    }

    private void onDataSetChanged() {
        boolean clickable;
        LogUtil.m15791e("PrivilegeView", "onDataSetChanged: mData --> " + this.mData.toString());
        if (this.mData.unlock == 1) {
            clickable = true;
        } else {
            clickable = false;
        }
        if (clickable) {
            this.rootView.setOnClickListener(new C42521());
        }
        if (this.title != null) {
            this.title.setText(this.mData.hint == null ? "" : this.mData.hint);
        }
        if (this.privilegeBtnTv != null) {
            CharSequence charSequence;
            TextView textView = this.privilegeBtnTv;
            if (this.mData.tip == null) {
                charSequence = "";
            } else {
                charSequence = this.mData.tip;
            }
            textView.setText(charSequence);
        }
        if (this.privilegeBtn != null) {
            this.privilegeBtn.setEnabled(clickable);
        }
        if (this.privilegeBtnIcon != null) {
            UrlDrawableContainIView.getDrawable(this.mData.hicon, C4048R.drawable.nsdk_rc_img_default_bg, this.privilegeBtnIcon, new Handler(Looper.getMainLooper()) {
                public void handleMessage(Message msg) {
                    super.handleMessage(msg);
                    if (msg.what != 8192) {
                        return;
                    }
                    if (msg.arg1 == 0) {
                        PrivilegeView.this.privilegeBtnIcon.setVisibility(0);
                    } else {
                        PrivilegeView.this.privilegeBtnIcon.setVisibility(8);
                    }
                }
            });
        }
        if ("text".equals(this.mData.cardType)) {
            if (this.textContainer != null) {
                this.textContainer.setVisibility(0);
            }
            if (this.mData.list != null && this.privilegeDesp != null && this.privilegeDue != null) {
                CharSequence charSequence2;
                if (this.mData.list.length > 0) {
                    charSequence2 = Html.fromHtml(this.mData.list[0]);
                    if (charSequence2 != null) {
                        this.privilegeDesp.setText(charSequence2);
                    }
                }
                if (this.mData.list.length > 1) {
                    charSequence2 = Html.fromHtml(this.mData.list[1]);
                    if (charSequence2 != null) {
                        this.privilegeDue.setText(charSequence2);
                        this.privilegeDue.setVisibility(0);
                        return;
                    }
                    return;
                }
                this.privilegeDue.setVisibility(8);
            }
        } else if ("pic".equals(this.mData.cardType)) {
            if (this.iconsContainer != null) {
                this.iconsContainer.setVisibility(0);
            }
            if (this.shade != null) {
                int i;
                View view = this.shade;
                if (clickable) {
                    i = 8;
                } else {
                    i = 0;
                }
                view.setVisibility(i);
            }
            if (this.mData.list != null && this.iconsList != null) {
                int i2 = 0;
                while (i2 < this.mData.list.length && i2 < 4) {
                    setupUrlDrawable(this.iconsList[i2], this.mData.list[i2]);
                    i2++;
                }
            }
        }
    }

    private void setupUrlDrawable(ImageView imgView, final String url) {
        if (imgView != null) {
            UrlDrawableContainIView.getDrawable(url, C4048R.drawable.navi_result_car_logo_default, imgView, new Handler(Looper.getMainLooper()) {
                public void handleMessage(Message msg) {
                    super.handleMessage(msg);
                    if (msg.what == 8192 && msg.arg1 != 0) {
                        LogUtil.m15791e("PrivilegeView", "setupUrlDrawable: Fail --> url: " + url);
                    }
                }
            });
        }
    }

    public void clearImgData() {
        if (this.iconsList != null) {
            for (int i = 0; i < this.iconsList.length; i++) {
                if (this.iconsList[i] != null) {
                    UIUtils.releaseImageViewWithoutNull(this.iconsList[i]);
                }
            }
        }
    }
}
