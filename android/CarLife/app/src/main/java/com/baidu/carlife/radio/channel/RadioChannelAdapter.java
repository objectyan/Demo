package com.baidu.carlife.radio.channel;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.carlife.C0965R;
import com.baidu.carlife.model.C1942q;
import com.baidu.carlife.p083g.C1605a;
import com.baidu.carlife.radio.p102a.C2105a;
import com.baidu.carlife.util.C2170a;
import com.baidu.carlife.view.recyclingviewpager.RecyclingPagerAdapter;
import com.baidu.carlife.view.recyclingviewpager.RecyclingViewPager;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.ArrayList;
import java.util.List;

public class RadioChannelAdapter extends RecyclingPagerAdapter {
    /* renamed from: b */
    private static final int f6832b = Integer.MAX_VALUE;
    /* renamed from: c */
    private List<C2105a> f6833c = new ArrayList();
    /* renamed from: d */
    private String f6834d = "";
    /* renamed from: e */
    private Context f6835e;
    /* renamed from: f */
    private RecyclingViewPager f6836f;

    /* renamed from: com.baidu.carlife.radio.channel.RadioChannelAdapter$a */
    public static class C2144a {
        /* renamed from: a */
        SimpleDraweeView f6827a;
        /* renamed from: b */
        TextView f6828b;
        /* renamed from: c */
        ImageView f6829c;
    }

    public RadioChannelAdapter(Context context, RecyclingViewPager recyclingViewPager) {
        this.f6835e = context;
        this.f6836f = recyclingViewPager;
    }

    /* renamed from: a */
    public void m8093a(List<C2105a> list) {
        this.f6833c.clear();
        int len = list.size();
        for (int i = 0; i < len; i++) {
            if (i == 0) {
                this.f6834d = ((C2105a) list.get(i)).m7893a();
            }
            if (i % 2 == 0) {
                this.f6833c.add(list.get(i));
            } else {
                this.f6833c.add(0, list.get(i));
            }
        }
    }

    /* renamed from: a */
    public int m8089a() {
        return this.f6833c == null ? 0 : this.f6833c.size();
    }

    /* renamed from: a */
    public int m8090a(String channelId) {
        if (TextUtils.isEmpty(channelId)) {
            channelId = this.f6834d;
        }
        int len = m8089a();
        for (int i = 0; i < len; i++) {
            if (TextUtils.equals(channelId, ((C2105a) this.f6833c.get(i)).m7893a())) {
                return i;
            }
        }
        return 0;
    }

    /* renamed from: a */
    public C2105a m8092a(int position) {
        int index = 0;
        if (this.f6833c.size() > 0) {
            index = position % this.f6833c.size();
        }
        return (this.f6833c == null || this.f6833c.size() == 0) ? null : (C2105a) this.f6833c.get(index);
    }

    /* renamed from: a */
    public View mo1782a(int position, View convertView, ViewGroup container) {
        C2144a viewHolder;
        if (convertView == null) {
            viewHolder = new C2144a();
            convertView = LayoutInflater.from(this.f6835e).inflate(C0965R.layout.radio_channel_item, container, false);
            viewHolder.f6827a = (SimpleDraweeView) convertView.findViewById(C0965R.id.radio_channel_item_img);
            viewHolder.f6828b = (TextView) convertView.findViewById(C0965R.id.radio_channel_item_txt);
            viewHolder.f6829c = (ImageView) convertView.findViewById(C0965R.id.radio_channel_item_flag_play);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (C2144a) convertView.getTag();
        }
        C2105a item = m8092a(position);
        viewHolder.f6827a.setController(C1605a.m5867a(viewHolder.f6827a, item == null ? "" : item.m7897c(), 280, 280));
        viewHolder.f6828b.setText(m8088a(item));
        viewHolder.f6829c.setVisibility(8);
        this.f6836f.setChildrenView(position, convertView);
        return convertView;
    }

    /* renamed from: a */
    private String m8088a(C2105a model) {
        if (model == null) {
            return "";
        }
        String channelName = model.m7895b();
        if (C2170a.m8217a()) {
            return channelName;
        }
        if ("每日随心".equals(channelName)) {
            return "Daily Audio";
        }
        if (C1942q.f6153u.equals(channelName)) {
            return "Music";
        }
        if ("儿童".equals(channelName)) {
            return "Children";
        }
        if ("听书".equals(channelName)) {
            return "Audio Book";
        }
        if ("电台".equals(channelName)) {
            return "Radio";
        }
        if ("语音点播".equals(channelName)) {
            return "VOD";
        }
        if ("情感".equals(channelName)) {
            return "Emotion";
        }
        if ("学习".equals(channelName)) {
            return "Study";
        }
        if ("新闻".equals(channelName)) {
            return "News";
        }
        if ("娱乐".equals(channelName)) {
            return "Recreation";
        }
        return channelName;
    }

    public int getCount() {
        return Integer.MAX_VALUE;
    }
}
