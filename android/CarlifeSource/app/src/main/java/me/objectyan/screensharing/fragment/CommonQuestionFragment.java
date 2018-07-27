package com.baidu.carlife.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ScrollView;
import android.widget.TextView;
import com.baidu.carlife.R;
import com.baidu.carlife.p078f.C1440d;
import com.baidu.carlife.p078f.C1442f;
import com.baidu.carlife.p078f.C1443g;
import com.baidu.navi.fragment.ContentFragment;

public class CommonQuestionFragment extends ContentFragment {
    /* renamed from: a */
    private ScrollView f4239a;
    /* renamed from: b */
    private ImageButton f4240b;
    /* renamed from: c */
    private TextView f4241c;
    /* renamed from: d */
    private C1443g f4242d;
    /* renamed from: e */
    private C1442f f4243e;

    /* renamed from: com.baidu.carlife.fragment.CommonQuestionFragment$1 */
    class C14471 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ CommonQuestionFragment f4238a;

        C14471(CommonQuestionFragment this$0) {
            this.f4238a = this$0;
        }

        public void onClick(View v) {
            this.f4238a.back(null);
        }
    }

    protected void onUpdateOrientation(int orientation) {
    }

    protected void onUpdateStyle(boolean dayStyle) {
    }

    protected View onCreateContentView(LayoutInflater inflater) {
        this.mContentView = inflater.inflate(R.layout.frag_common_questions, null);
        this.f4239a = (ScrollView) this.mContentView.findViewById(R.id.scroll_view);
        this.f4240b = (ImageButton) this.mContentView.findViewById(R.id.ib_left);
        this.f4241c = (TextView) this.mContentView.findViewById(R.id.tv_title);
        this.f4240b.setOnClickListener(new C14471(this));
        this.f4241c.setText(R.string.commonquestion_setting_title);
        return this.mContentView;
    }

    protected void onUpdateSkin() {
        super.onUpdateSkin();
        updateCommonSkin();
    }

    protected void onInitView() {
    }

    public void onInitFocusAreas() {
        if (this.fragmentType == getCurrentFragmentType()) {
            if (this.f4242d == null) {
                this.f4242d = new C1443g(this.mContentView.findViewById(R.id.common_title_bar), 2);
                this.f4242d.m5300d(this.mContentView.findViewById(R.id.ib_left));
            }
            if (this.f4243e == null) {
                this.f4243e = new C1442f(this.f4239a, 4);
            }
            C1440d focusManager = C1440d.m5251a();
            focusManager.m5256b(this.f4242d, this.f4243e);
            focusManager.m5268h(this.f4242d);
        }
    }
}
