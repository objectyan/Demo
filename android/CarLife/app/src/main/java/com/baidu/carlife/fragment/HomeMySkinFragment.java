package com.baidu.carlife.fragment;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import com.baidu.carlife.C0965R;
import com.baidu.carlife.adpter.C0982f;
import com.baidu.carlife.core.C1253f;
import com.baidu.carlife.core.C1260i;
import com.baidu.carlife.custom.C1342a;
import com.baidu.carlife.logic.C1872t;
import com.baidu.carlife.logic.C1872t.C1318b;
import com.baidu.carlife.model.C1934l;
import com.baidu.carlife.p054k.C1652m;
import com.baidu.carlife.p054k.p055a.C1626e.C0924a;
import com.baidu.carlife.p078f.C1437b;
import com.baidu.carlife.p078f.C1440d;
import com.baidu.carlife.p078f.C1443g;
import com.baidu.carlife.util.C2201w;
import com.baidu.navi.fragment.ContentFragment;
import java.util.ArrayList;
import java.util.List;

public class HomeMySkinFragment extends ContentFragment implements C0924a, C1318b {
    /* renamed from: a */
    private static final int f4503a = 100;
    /* renamed from: b */
    private C0982f f4504b;
    /* renamed from: c */
    private C1652m f4505c;
    /* renamed from: d */
    private List<C1934l> f4506d;
    /* renamed from: e */
    private C1872t f4507e;
    /* renamed from: f */
    private C1443g f4508f;
    /* renamed from: g */
    private C1437b f4509g;

    /* renamed from: com.baidu.carlife.fragment.HomeMySkinFragment$1 */
    class C15121 implements OnItemClickListener {
        /* renamed from: a */
        final /* synthetic */ HomeMySkinFragment f4501a;

        C15121(HomeMySkinFragment this$0) {
            this.f4501a = this$0;
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
            C1260i.m4435b("Framework", "position = " + position + ", id = " + id);
            view.performClick();
        }
    }

    /* renamed from: com.baidu.carlife.fragment.HomeMySkinFragment$2 */
    class C15132 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ HomeMySkinFragment f4502a;

        C15132(HomeMySkinFragment this$0) {
            this.f4502a = this$0;
        }

        public void onClick(View v) {
        }
    }

    protected View onCreateContentView(LayoutInflater inflater) {
        View contentView = inflater.inflate(C0965R.layout.home_my_skin, null);
        setCommonTitleBar(contentView, getString(C0965R.string.home_my_skin));
        GridView gridView = (GridView) contentView.findViewById(C0965R.id.skin_gv);
        gridView.setOverScrollMode(2);
        this.f4507e = C1872t.m7136a();
        this.f4507e.m7151a((C1318b) this);
        m5528a();
        this.f4504b = new C0982f(getContext(), this.f4506d);
        gridView.setAdapter(this.f4504b);
        gridView.setOnItemClickListener(new C15121(this));
        contentView.findViewById(C0965R.id.tv_title).setOnClickListener(new C15132(this));
        return contentView;
    }

    /* renamed from: a */
    private void m5528a() {
        String[] skinNames = getResources().getStringArray(C0965R.array.home_my_skin);
        this.f4506d = new ArrayList();
        C1934l defaultSkin = new C1934l();
        defaultSkin.f6089d = skinNames[0];
        defaultSkin.f6095j = 0;
        defaultSkin.f6096k = C0965R.drawable.home_ic_my_skin_black;
        defaultSkin.f6093h = C1872t.f5805b;
        C1934l blueSkin = new C1934l();
        blueSkin.f6095j = 1;
        blueSkin.f6089d = skinNames[1];
        blueSkin.f6093h = C1253f.jk;
        blueSkin.f6096k = C0965R.drawable.home_ic_my_skin_blue;
        blueSkin.f6090e = 3;
        this.f4506d.add(defaultSkin);
        this.f4506d.add(blueSkin);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        onUpdateSkin();
        this.f4507e.m7151a((C1318b) this);
    }

    protected void onInitView() {
    }

    protected void onUpdateOrientation(int orientation) {
    }

    protected void onUpdateStyle(boolean dayStyle) {
    }

    protected void onUpdateSkin() {
        updateCommonSkin();
        this.f4504b.notifyDataSetChanged();
    }

    /* renamed from: b */
    public void mo1481b(boolean isSuccess) {
        if (isSuccess) {
            onUpdateSkin();
        } else {
            C2201w.m8371a((int) C0965R.string.home_my_skin_fail, 0);
        }
    }

    public void onNetWorkResponse(int responseCode) {
        if (isAdded()) {
            switch (responseCode) {
                case 0:
                    this.f4506d.addAll(this.f4505c.m5962a());
                    this.f4504b.notifyDataSetChanged();
                    return;
                default:
                    return;
            }
        }
    }

    public void onInitFocusAreas() {
        if (this.f4508f == null) {
            this.f4508f = new C1443g(this.mContentView.findViewById(C0965R.id.ll_title), 2);
            this.f4508f.m5300d(this.mContentView.findViewById(C0965R.id.ib_left));
        }
        if (this.f4509g == null) {
            this.f4509g = new C1437b((GridView) this.mContentView.findViewById(C0965R.id.skin_gv), 6);
        }
        C1440d.m5251a().m5256b(this.f4508f, this.f4509g);
        C1440d.m5251a().m5268h(this.f4508f);
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.f4507e.m7158b((C1318b) this);
    }

    public void driving() {
        C1260i.m4435b("yftech", "HomeMySkinFragment driving");
        back();
        C1342a.m4926a().m4931d();
    }

    public void stopDriving() {
        C1260i.m4435b("yftech", "HomeMySkinFragment stopDriving");
    }
}
