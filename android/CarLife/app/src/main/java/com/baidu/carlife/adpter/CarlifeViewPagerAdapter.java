package com.baidu.carlife.adpter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.baidu.carlife.C0965R;
import com.baidu.carlife.core.C1260i;
import com.baidu.carlife.model.C1921b;
import java.util.ArrayList;
import java.util.List;

public class CarlifeViewPagerAdapter extends PagerAdapter {
    /* renamed from: a */
    private static final String f2444a = "CarLifeViewPagerAdapter";
    /* renamed from: c */
    private static final int f2445c = 4;
    /* renamed from: b */
    private List<View> f2446b = null;
    /* renamed from: d */
    private Context f2447d;

    public CarlifeViewPagerAdapter(Context context, List<C1921b> list) {
        this.f2447d = context;
        this.f2446b = m3171a(context, list);
    }

    public int getCount() {
        if (this.f2446b == null) {
            return 0;
        }
        return this.f2446b.size();
    }

    public boolean isViewFromObject(View arg0, Object arg1) {
        return arg0 == arg1;
    }

    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager) container).removeView((View) this.f2446b.get(position));
    }

    public Object instantiateItem(ViewGroup container, int position) {
        C1260i.m4445e(f2444a, "-----------instantiateItem----------POS5:" + position);
        ((ViewPager) container).addView((View) this.f2446b.get(position));
        return this.f2446b.get(position);
    }

    /* renamed from: a */
    private List<View> m3171a(Context context, List<C1921b> list) {
        LinearLayout pageView = m3172b();
        List<View> result = new ArrayList();
        int i = 0;
        while (i < list.size()) {
            View itemView = LayoutInflater.from(context).inflate(C0965R.layout.carlife_apps_list_item, null);
            Button b = (Button) itemView.findViewById(C0965R.id.btn_start_app);
            b.setTextSize(20.0f);
            b.setText(((C1921b) list.get(i)).f5932g);
            pageView.addView(itemView);
            if (i % 4 == 3 || i == list.size() - 1) {
                pageView.addView(m3170a());
                result.add(pageView);
                pageView = m3172b();
            }
            i++;
        }
        return result;
    }

    /* renamed from: a */
    private View m3170a() {
        View itemView = LayoutInflater.from(this.f2447d).inflate(C0965R.layout.carlife_apps_list_item, null);
        Button b = (Button) itemView.findViewById(C0965R.id.btn_start_app);
        b.setTextSize(20.0f);
        b.setText("待添加");
        return itemView;
    }

    /* renamed from: b */
    private LinearLayout m3172b() {
        LayoutParams param = new LayoutParams(-1, -2);
        LinearLayout pageView = new LinearLayout(this.f2447d);
        pageView.setOrientation(0);
        pageView.setLayoutParams(param);
        return pageView;
    }
}
