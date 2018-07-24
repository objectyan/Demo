package com.baidu.carlife.adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.carlife.R;
import com.baidu.carlife.model.C1936n;
import com.baidu.carlife.model.MusicSongModel;
import java.util.ArrayList;
import java.util.List;

/* compiled from: VoiceResultsListAdapter */
/* renamed from: com.baidu.carlife.adpter.s */
public class VoiceResultsListAdapter extends BaseAdapter {
    /* renamed from: a */
    private Context f2622a;
    /* renamed from: b */
    private List f2623b = new ArrayList();
    /* renamed from: c */
    private C1025a f2624c;

    /* compiled from: VoiceResultsListAdapter */
    /* renamed from: com.baidu.carlife.adpter.s$a */
    public enum C1025a {
        ITEM_TYPE_MUSIC_LOCAL,
        ITEM_TYPE_MUSIC_ONLINE,
        ITEM_TYPE_PHONE
    }

    /* compiled from: VoiceResultsListAdapter */
    /* renamed from: com.baidu.carlife.adpter.s$b */
    private static class C1026b {
        /* renamed from: a */
        TextView f2620a;
        /* renamed from: b */
        TextView f2621b;

        private C1026b() {
        }

        /* renamed from: a */
        public void m3263a(String name) {
            this.f2620a.setText(name);
        }

        /* renamed from: b */
        public void m3264b(String num) {
            this.f2621b.setText(num);
        }
    }

    /* renamed from: a */
    public static int m3265a(int itemType) {
        if (itemType == C1025a.ITEM_TYPE_MUSIC_LOCAL.ordinal()) {
            return 0;
        }
        if (itemType == C1025a.ITEM_TYPE_MUSIC_ONLINE.ordinal()) {
            return 2;
        }
        return -1;
    }

    public VoiceResultsListAdapter(Context context) {
        this.f2622a = context;
    }

    /* renamed from: a */
    public void m3267a(List list, C1025a type) {
        this.f2624c = type;
        this.f2623b.clear();
        if (!(list == null || list.isEmpty())) {
            this.f2623b.addAll(list);
        }
        notifyDataSetChanged();
    }

    public int getCount() {
        return this.f2623b.size();
    }

    public Object getItem(int position) {
        try {
            return this.f2623b.get(position);
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    public long getItemId(int position) {
        return (long) position;
    }

    public int getItemViewType(int position) {
        return this.f2624c.ordinal();
    }

    public int getViewTypeCount() {
        return C1025a.values().length;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        C1026b cacheView = new C1026b();
        if (convertView == null) {
            switch (this.f2624c) {
                case ITEM_TYPE_MUSIC_LOCAL:
                case ITEM_TYPE_MUSIC_ONLINE:
                    convertView = LayoutInflater.from(this.f2622a).inflate(R.layout.voice_results_list_item_music, parent, false);
                    cacheView.f2620a = (TextView) convertView.findViewById(R.id.tv_song);
                    cacheView.f2621b = (TextView) convertView.findViewById(R.id.tv_singer);
                    break;
                case ITEM_TYPE_PHONE:
                    convertView = LayoutInflater.from(this.f2622a).inflate(R.layout.voice_results_list_item_phone, parent, false);
                    cacheView.f2620a = (TextView) convertView.findViewById(R.id.tv_name);
                    cacheView.f2621b = (TextView) convertView.findViewById(R.id.tv_num);
                    break;
            }
            convertView.setTag(cacheView);
        }
        cacheView = (C1026b) convertView.getTag();
        switch (this.f2624c) {
            case ITEM_TYPE_MUSIC_LOCAL:
            case ITEM_TYPE_MUSIC_ONLINE:
                MusicSongModel song = (MusicSongModel) getItem(position);
                cacheView.m3263a(song.f5910b);
                cacheView.m3264b(song.f5914f);
                break;
            case ITEM_TYPE_PHONE:
                C1936n model = (C1936n) getItem(position);
                if (model != null) {
                    if (m3266b(position)) {
                        cacheView.m3263a("");
                    } else {
                        cacheView.m3263a(model.f6104a);
                    }
                    cacheView.m3264b(model.f6105b);
                    break;
                }
                break;
        }
        return convertView;
    }

    /* renamed from: b */
    private boolean m3266b(int pos) {
        C1936n lastModel = (C1936n) getItem(pos - 1);
        C1936n curModel = (C1936n) getItem(pos);
        if (lastModel != null && lastModel.f6104a.equals(curModel.f6104a)) {
            return true;
        }
        return false;
    }
}
