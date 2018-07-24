package com.baidu.carlife.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.carlife.R;
import com.baidu.navi.fragment.ContentFragment;
import com.baidu.navi.view.CommonTitleBar;

public class YMServiceDetailFragment extends ContentFragment {
    /* renamed from: a */
    private TextView f4896a;
    /* renamed from: b */
    private TextView f4897b;
    /* renamed from: c */
    private CommonTitleBar f4898c;

    protected View onCreateContentView(LayoutInflater inflater) {
        ViewGroup viewGroup = (ViewGroup) inflater.inflate(R.layout.frag_ym_service_terms, null);
        setCommonTitleBar(viewGroup, getResources().getString(R.string.ym_service_terms_title));
        this.f4897b = (TextView) viewGroup.findViewById(R.id.service_items_txt);
        return viewGroup;
    }

    protected void onInitView() {
    }

    protected void onUpdateOrientation(int orientation) {
    }

    protected void onUpdateStyle(boolean dayStyle) {
    }

    protected void onUpdateSkin() {
        updateCommonSkin();
    }
}
