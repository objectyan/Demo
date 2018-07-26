package com.baidu.carlife.fragment;

import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.baidu.carlife.C0965R;
import com.baidu.carlife.core.C1260i;
import com.baidu.carlife.custom.C1342a;
import com.baidu.carlife.p078f.C1440d;
import com.baidu.carlife.p078f.C1443g;
import com.baidu.carlife.util.C2188r;
import com.baidu.navi.controller.AccountController;
import com.baidu.navi.controller.UserCenterController;
import com.baidu.navi.fragment.ContentFragment;
import com.baidu.navi.util.NaviAccountUtils;
import com.baidu.navi.util.StatisticConstants;
import com.baidu.navi.util.StatisticManager;

public class HomeMyDetailFragment extends ContentFragment {
    /* renamed from: a */
    private C1443g f4499a;
    /* renamed from: b */
    private C1443g f4500b;

    /* renamed from: com.baidu.carlife.fragment.HomeMyDetailFragment$1 */
    class C15111 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ HomeMyDetailFragment f4498a;

        C15111(HomeMyDetailFragment this$0) {
            this.f4498a = this$0;
        }

        public void onClick(View v) {
            this.f4498a.m5526a();
            this.f4498a.back();
            StatisticManager.onEvent(StatisticConstants.HOME_MY_LOGOUT, StatisticConstants.HOME_MY_LOGOUT);
        }
    }

    protected View onCreateContentView(LayoutInflater inflater) {
        View contentView = inflater.inflate(C0965R.layout.frag_home_my_detail, null);
        setCommonTitleBar(contentView, getString(C0965R.string.home_my_detail));
        TextView userNameTv = (TextView) contentView.findViewById(C0965R.id.tv_username);
        if (NaviAccountUtils.getInstance().isLogin()) {
            String userName = NaviAccountUtils.getInstance().getUserName();
            if (!TextUtils.isEmpty(userName)) {
                userNameTv.setText(userName);
            }
        }
        contentView.findViewById(C0965R.id.btn_logout).setOnClickListener(new C15111(this));
        return contentView;
    }

    /* renamed from: a */
    private void m5526a() {
        AccountController.getInstance().logout();
        UserCenterController.getInstance().startUpdateUserInfo(0, new Handler());
    }

    public void onResume() {
        super.onResume();
    }

    protected void onUpdateSkin() {
        super.onUpdateSkin();
        updateCommonSkin();
        ((TextView) this.mContentView.findViewById(C0965R.id.temp)).setTextColor(C2188r.m8328a((int) C0965R.color.cl_text_a5_content));
        ((TextView) this.mContentView.findViewById(C0965R.id.tv_username)).setTextColor(C2188r.m8328a((int) C0965R.color.cl_text_a2_content));
        ((Button) this.mContentView.findViewById(C0965R.id.btn_logout)).setTextColor(C2188r.m8328a((int) C0965R.color.cl_text_a5_bgtext));
    }

    protected void onInitView() {
    }

    protected void onUpdateOrientation(int orientation) {
    }

    protected void onUpdateStyle(boolean dayStyle) {
    }

    public void driving() {
        C1260i.m4435b("yftech", "HomeMyDetailFragment driving");
        back();
        C1342a.m4926a().m4931d();
    }

    public void stopDriving() {
    }

    public void onInitFocusAreas() {
        if (this.f4499a == null) {
            this.f4499a = new C1443g(this.mContentView.findViewById(C0965R.id.ll_title), 2);
            this.f4499a.m5300d(this.mContentView.findViewById(C0965R.id.ib_left));
        }
        if (this.f4500b == null) {
            this.f4500b = new C1443g(this.mContentView.findViewById(C0965R.id.frag_home_my_detail), 6);
            this.f4500b.m5300d(this.mContentView.findViewById(C0965R.id.btn_logout));
        }
        C1440d.m5251a().m5256b(this.f4499a, this.f4500b);
        C1440d.m5251a().m5268h(this.f4500b);
    }
}
