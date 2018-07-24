package com.baidu.carlife.adpter;


import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.carlife.R;
import com.baidu.carlife.model.C1931j;
import com.baidu.carlife.util.C2188r;
import com.baidu.carlife.view.MultiImageView;
import java.util.List;

/* compiled from: MusicSDKListAdapter */
/* renamed from: com.baidu.carlife.adpter.k */
public class MusicSDKListAdapter extends BaseAdapter {
    /* renamed from: a */
    private Context f2537a;
    /* renamed from: b */
    private LayoutInflater f2538b;
    /* renamed from: c */
    private List<C1931j> f2539c;

    /* compiled from: MusicSDKListAdapter */
    /* renamed from: com.baidu.carlife.adpter.k$a */
    private static class C0994a {
        /* renamed from: a */
        MultiImageView f2534a;
        /* renamed from: b */
        TextView f2535b;
        /* renamed from: c */
        ImageView f2536c;

        private C0994a() {
        }
    }

    public MusicSDKListAdapter(Context context, List<C1931j> list) {
        this.f2537a = context;
        this.f2538b = LayoutInflater.from(context);
        this.f2539c = list;
    }

    public int getCount() {
        return this.f2539c.size();
    }

    public Object getItem(int position) {
        return this.f2539c.get(position);
    }

    public long getItemId(int position) {
        return (long) position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = this.f2538b.inflate(R.layout.music_apps_list_item, null);
            convertView.setLayoutParams(new LayoutParams(-1, (int) this.f2537a.getResources().getDimension(R.dimen.frag_music_typelist_item_height)));
            C0994a viewCache = new C0994a();
            viewCache.f2535b = (TextView) convertView.findViewById(R.id.tv_app_name);
            viewCache.f2534a = (MultiImageView) convertView.findViewById(R.id.ib_app_icon);
            viewCache.f2536c = (ImageView) convertView.findViewById(R.id.iv_selected_app_mark);
            convertView.setTag(viewCache);
        }
        C0994a cache = (C0994a) convertView.getTag();
        C1931j model = (C1931j) getItem(position);
        if (model == null) {
            return null;
        }
        if (TextUtils.isEmpty(model.l)) {
            cache.f2535b.setText("");
        } else {
            cache.f2535b.setText(model.l);
        }
        m3213a(cache.f2534a, model);
        if (model.f6066a) {
            cache.f2536c.setImageDrawable(C2188r.m8331b(R.drawable.com_ic_selected));
            cache.f2536c.setVisibility(0);
            cache.f2535b.setTextColor(C2188r.m8328a((int) R.color.cl_other_c_highlight));
            return convertView;
        }
        cache.f2536c.setVisibility(4);
        cache.f2535b.setTextColor(C2188r.m8328a((int) R.color.cl_text_a5_content));
        return convertView;
    }

    /* renamed from: a */
    private void m3213a(MultiImageView imageView, C1931j model) {
        if (model.f6068c >= 3) {
            imageView.setDefaultDrawable(C2188r.m8331b(R.drawable.music_ic_default));
            imageView.setImageUrl(model.j);
            return;
        }
        imageView.setDefaultDrawableResId(model.f6067b);
        imageView.setImageUrl(null);
    }
}
