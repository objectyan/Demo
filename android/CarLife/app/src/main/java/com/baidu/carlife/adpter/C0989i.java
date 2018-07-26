package com.baidu.carlife.adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.carlife.BaiduNaviApplication;
import com.baidu.carlife.C0965R;
import com.baidu.carlife.core.C1249d;
import com.baidu.carlife.core.C1251e;
import com.baidu.carlife.logic.music.C1818h;
import com.baidu.carlife.model.C1929i;
import com.baidu.carlife.util.C2188r;
import com.baidu.carlife.view.MultiImageView;
import java.util.ArrayList;
import java.util.List;

/* compiled from: MusicAlbumListAdapter */
/* renamed from: com.baidu.carlife.adpter.i */
public class C0989i extends BaseAdapter {
    /* renamed from: a */
    protected static int f2525a = 4;
    /* renamed from: b */
    private Context f2526b = BaiduNaviApplication.getInstance().getApplicationContext();
    /* renamed from: c */
    private List<C1929i> f2527c = new ArrayList();

    /* compiled from: MusicAlbumListAdapter */
    /* renamed from: com.baidu.carlife.adpter.i$a */
    private static class C0988a {
        /* renamed from: a */
        public MultiImageView f2523a;
        /* renamed from: b */
        public TextView f2524b;

        private C0988a() {
        }

        /* renamed from: a */
        public void m3205a(String name) {
            this.f2524b.setText(name);
        }

        /* renamed from: a */
        public void m3204a(int color) {
            this.f2524b.setTextColor(color);
        }

        /* renamed from: b */
        public void m3207b(String url) {
            int imagesize = C1249d.m4331a().m4343c(100) - (C1251e.m4358a().m4397n() / C0989i.f2525a);
            LayoutParams params = this.f2523a.getLayoutParams();
            params.height = imagesize;
            params.width = imagesize;
            this.f2523a.setLayoutParams(params);
            this.f2523a.setDefaultDrawable(C2188r.m8331b(C0965R.drawable.music_ic_albumcover));
            this.f2523a.setImageUrl(url);
        }

        /* renamed from: b */
        public void m3206b(int resID) {
            int imagesize = C1249d.m4331a().m4343c(100) - (C1251e.m4358a().m4397n() / C0989i.f2525a);
            LayoutParams params = this.f2523a.getLayoutParams();
            params.height = imagesize;
            params.width = imagesize;
            this.f2523a.setLayoutParams(params);
            this.f2523a.setDefaultDrawable(C2188r.m8331b(resID));
            this.f2523a.setImageUrl(null);
        }
    }

    public int getCount() {
        return this.f2527c.size();
    }

    public Object getItem(int position) {
        try {
            return this.f2527c.get(position);
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    public long getItemId(int position) {
        return (long) position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(this.f2526b).inflate(C0965R.layout.music_albumlist_item, null);
            C0988a cache = new C0988a();
            cache.f2524b = (TextView) convertView.findViewById(C0965R.id.tv_music_theme);
            cache.f2523a = (MultiImageView) convertView.findViewById(C0965R.id.iv_music_theme);
            convertView.setTag(cache);
        }
        C0988a cacheTag = (C0988a) convertView.getTag();
        try {
            C1929i model = (C1929i) this.f2527c.get(position);
            cacheTag.m3205a(model.f6053a);
            if (model.f6056d > 0) {
                cacheTag.m3206b(model.f6056d);
            } else {
                cacheTag.m3207b(model.f6054b);
            }
            if (model.f6055c.equals(C1818h.m6730b().m6818j())) {
                cacheTag.m3204a(C2188r.m8328a((int) C0965R.color.cl_other_c_highlight));
                return convertView;
            }
            cacheTag.m3204a(C2188r.m8328a((int) C0965R.color.cl_text_a5_content));
            return convertView;
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    /* renamed from: a */
    public void m3208a(List<C1929i> list) {
        this.f2527c.clear();
        if (!(list == null || list.isEmpty())) {
            this.f2527c.addAll(list);
        }
        notifyDataSetChanged();
    }
}
