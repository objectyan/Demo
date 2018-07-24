package com.baidu.carlife.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ScrollView;
import android.widget.TextView;
import com.baidu.carlife.R;
import com.baidu.carlife.core.CarLifeSettings;
import com.baidu.carlife.p078f.C1440d;
import com.baidu.carlife.p078f.C1442f;
import com.baidu.carlife.p078f.C1443g;
import com.baidu.navi.fragment.ContentFragment;
import com.baidu.navi.fragment.NaviFragmentManager;

public class DisclaimerFragment extends ContentFragment {
    /* renamed from: a */
    private TextView f4261a;
    /* renamed from: b */
    private View f4262b;
    /* renamed from: c */
    private ScrollView f4263c;
    /* renamed from: d */
    private C1443g f4264d;
    /* renamed from: e */
    private C1442f f4265e;
    /* renamed from: f */
    private boolean f4266f;

    /* renamed from: com.baidu.carlife.fragment.DisclaimerFragment$1 */
    class C14511 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ DisclaimerFragment f4259a;

        C14511(DisclaimerFragment this$0) {
            this.f4259a = this$0;
        }

        public void onClick(View v) {
            boolean z = false;
            if (this.f4259a.f4266f) {
                this.f4259a.f4261a.setCompoundDrawablesWithIntrinsicBounds(R.drawable.com_ic_unchecked, 0, 0, 0);
            } else {
                this.f4259a.f4261a.setCompoundDrawablesWithIntrinsicBounds(R.drawable.com_ic_check, 0, 0, 0);
            }
            DisclaimerFragment disclaimerFragment = this.f4259a;
            if (!this.f4259a.f4266f) {
                z = true;
            }
            disclaimerFragment.f4266f = z;
        }
    }

    /* renamed from: com.baidu.carlife.fragment.DisclaimerFragment$2 */
    class C14522 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ DisclaimerFragment f4260a;

        C14522(DisclaimerFragment this$0) {
            this.f4260a = this$0;
        }

        public void onClick(View v) {
            CarLifeSettings.m4069a().m4075b(this.f4260a.f4266f);
            this.f4260a.showFragment(NaviFragmentManager.TYPE_HOME, null);
        }
    }

    protected View onCreateContentView(LayoutInflater inflater) {
        this.mContentView = inflater.inflate(R.layout.frag_disclaimer, null);
        this.f4261a = (TextView) this.mContentView.findViewById(R.id.notip_tv);
        this.f4262b = this.mContentView.findViewById(R.id.agree_btn);
        this.f4263c = (ScrollView) this.mContentView.findViewById(R.id.scroll_view);
        this.f4263c.setOverScrollMode(2);
        this.f4261a.setOnClickListener(new C14511(this));
        this.f4262b.setOnClickListener(new C14522(this));
        return this.mContentView;
    }

    protected void onInitView() {
    }

    protected void onUpdateOrientation(int orientation) {
    }

    protected void onUpdateStyle(boolean dayStyle) {
    }

    public boolean onBackPressed() {
        return true;
    }

    public void onInitFocusAreas() {
        if (this.fragmentType == getCurrentFragmentType()) {
            C1440d focusManager = C1440d.m5251a();
            if (this.f4265e == null) {
                this.f4265e = new C1442f(this.f4263c, 4);
            }
            if (this.f4264d == null) {
                this.f4264d = new C1443g(this.mContentView, 6);
                this.f4264d.m5300d(this.f4261a).m5300d(this.f4262b);
            }
            focusManager.m5256b(this.f4265e, this.f4264d);
            focusManager.m5268h(this.f4264d);
        }
    }
}
