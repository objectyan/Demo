package com.baidu.carlife.adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.carlife.C0965R;
import com.baidu.carlife.core.C1251e;
import com.baidu.carlife.logic.music.C1818h;
import com.baidu.carlife.model.MusicSongModel;
import com.baidu.carlife.util.C2188r;
import java.util.List;

/* compiled from: MusicListAdapter */
/* renamed from: com.baidu.carlife.adpter.j */
public class C0992j extends C0986h {
    /* renamed from: h */
    private List<MusicSongModel> f2532h = null;
    /* renamed from: i */
    private boolean f2533i = true;

    /* compiled from: MusicListAdapter */
    /* renamed from: com.baidu.carlife.adpter.j$a */
    private static class C0991a {
        /* renamed from: a */
        ImageView f2528a;
        /* renamed from: b */
        TextView f2529b;
        /* renamed from: c */
        TextView f2530c;
        /* renamed from: d */
        TextView f2531d;

        private C0991a() {
        }
    }

    public C0992j(Context context) {
        super(context);
    }

    /* renamed from: d */
    public int mo1363d() {
        if (this.f2532h == null || this.f2532h.size() == 0) {
            return 0;
        }
        return this.f2532h.size();
    }

    public Object getItem(int position) {
        return this.f2532h.get(position);
    }

    public long getItemId(int position) {
        return (long) position;
    }

    /* renamed from: a */
    public View mo1362a(int pos, View convertView, ViewGroup parent) {
        C0991a cache;
        if (convertView == null) {
            convertView = LayoutInflater.from(this.g).inflate(C0965R.layout.musiclist_list_item, null);
            convertView.setLayoutParams(new LayoutParams(-1, (int) this.g.getResources().getDimension(C0965R.dimen.frag_tele_listitem_height)));
            cache = new C0991a();
            cache.f2528a = (ImageView) convertView.findViewById(C0965R.id.iv_playing_hint);
            cache.f2529b = (TextView) convertView.findViewById(C0965R.id.tv_music_name);
            cache.f2530c = (TextView) convertView.findViewById(C0965R.id.tv_music_artist);
            cache.f2531d = (TextView) convertView.findViewById(C0965R.id.tv_music_duration);
            convertView.setTag(cache);
        }
        cache = (C0991a) convertView.getTag();
        cache.f2529b.setText(((MusicSongModel) this.f2532h.get(pos)).f5910b);
        cache.f2530c.setText(((MusicSongModel) this.f2532h.get(pos)).f5914f);
        if (this.f2533i) {
            int duration;
            cache.f2531d.setVisibility(0);
            try {
                duration = Integer.parseInt(((MusicSongModel) this.f2532h.get(pos)).f5917i) / 1000;
            } catch (NumberFormatException e) {
                duration = 1;
            }
            cache.f2531d.setText(C1251e.m4358a().m4389a(duration));
        } else {
            cache.f2531d.setVisibility(4);
        }
        MusicSongModel curSong = C1818h.m6730b().m6816h();
        if (curSong == null || !((MusicSongModel) this.f2532h.get(pos)).equals(curSong)) {
            cache.f2528a.setVisibility(4);
            cache.f2529b.setTextColor(C2188r.m8328a((int) C0965R.color.cl_text_a5_title));
            cache.f2530c.setTextColor(C2188r.m8328a((int) C0965R.color.cl_text_a2_content));
            cache.f2531d.setTextColor(C2188r.m8328a((int) C0965R.color.cl_text_a2_content));
        } else {
            cache.f2528a.setVisibility(0);
            cache.f2529b.setTextColor(C2188r.m8328a((int) C0965R.color.cl_other_c_highlight));
            cache.f2530c.setTextColor(C2188r.m8328a((int) C0965R.color.cl_other_c_highlight));
            cache.f2531d.setTextColor(C2188r.m8328a((int) C0965R.color.cl_other_c_highlight));
        }
        return convertView;
    }

    /* renamed from: a */
    public void m3210a(List<MusicSongModel> list) {
        if (list != null && !list.isEmpty()) {
            this.f2532h = list;
            notifyDataSetChanged();
        }
    }

    /* renamed from: b */
    public void m3211b(boolean durationVisible) {
        this.f2533i = durationVisible;
    }
}
