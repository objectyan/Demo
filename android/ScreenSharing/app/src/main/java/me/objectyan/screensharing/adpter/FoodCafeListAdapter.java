package com.baidu.carlife.adpter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RatingBar;
import android.widget.TextView;
import com.baidu.carlife.BaiduNaviApplication;
import com.baidu.carlife.R;
import com.baidu.carlife.CarlifeActivity;
import com.baidu.carlife.core.CommonParams;
import com.baidu.carlife.core.screen.OnUIListener;
import com.baidu.carlife.logic.C1766h;
import com.baidu.carlife.model.C1925e;
import com.baidu.carlife.model.C1926f;
import com.baidu.carlife.util.C2188r;
import com.baidu.carlife.view.MultiImageView;
import com.baidu.navi.util.StatisticConstants;
import com.baidu.navi.util.StatisticManager;
import java.util.List;

/* compiled from: FoodCafeListAdapter */
/* renamed from: com.baidu.carlife.adpter.c */
public class FoodCafeListAdapter extends BaseAdapter {
    /* renamed from: a */
    private List<C1926f> f2476a;
    /* renamed from: b */
    private List<C1925e> f2477b;
    /* renamed from: c */
    private LayoutInflater f2478c;
    /* renamed from: d */
    private CarlifeActivity f2479d;
    /* renamed from: e */
    private OnUIListener f2480e;

    /* compiled from: FoodCafeListAdapter */
    /* renamed from: com.baidu.carlife.adpter.c$a */
    private class C0976a {
        /* renamed from: a */
        TextView f2461a;
        /* renamed from: b */
        TextView f2462b;
        /* renamed from: c */
        MultiImageView f2463c;
        /* renamed from: d */
        RatingBar f2464d;
        /* renamed from: e */
        TextView f2465e;
        /* renamed from: f */
        TextView f2466f;
        /* renamed from: g */
        TextView f2467g;
        /* renamed from: h */
        TextView f2468h;
        /* renamed from: i */
        TextView f2469i;
        /* renamed from: j */
        TextView f2470j;
        /* renamed from: k */
        TextView f2471k;
        /* renamed from: l */
        TextView f2472l;
        /* renamed from: m */
        TextView f2473m;
        /* renamed from: n */
        View f2474n;
        /* renamed from: o */
        final /* synthetic */ FoodCafeListAdapter f2475o;

        private C0976a(FoodCafeListAdapter foodCafeListAdapter) {
            this.f2475o = foodCafeListAdapter;
        }
    }

    public FoodCafeListAdapter(Context context, OnUIListener listener) {
        this.f2478c = LayoutInflater.from(context);
        this.f2480e = listener;
    }

    /* renamed from: a */
    public void m3177a(List<C1926f> queueList) {
        this.f2476a = queueList;
    }

    /* renamed from: b */
    public void m3178b(List<C1925e> cafeList) {
        this.f2477b = cafeList;
    }

    public int getItemViewType(int position) {
        if (this.f2476a == null || position >= this.f2476a.size()) {
            return 1;
        }
        return 0;
    }

    public int getViewTypeCount() {
        return 2;
    }

    public int getCount() {
        int cafeSize = 0;
        int queueSize = 0;
        if (this.f2477b != null) {
            cafeSize = this.f2477b.size();
        }
        if (this.f2476a != null) {
            queueSize = this.f2476a.size();
        }
        return cafeSize + queueSize;
    }

    public Object getItem(int position) {
        int queueSize = 0;
        if (this.f2476a != null) {
            queueSize = this.f2476a.size();
            if (position < queueSize) {
                return this.f2476a.get(position);
            }
        }
        if (this.f2477b != null) {
            return this.f2477b.get(position - queueSize);
        }
        return null;
    }

    public long getItemId(int position) {
        return (long) position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        C0976a holder;
        if (convertView == null) {
            holder = new C0976a();
            if (getItemViewType(position) == 1) {
                convertView = this.f2478c.inflate(R.layout.item_food_cafe, parent, false);
                holder.f2463c = (MultiImageView) convertView.findViewById(R.id.iv_logo);
                holder.f2461a = (TextView) convertView.findViewById(R.id.tv_name);
                holder.f2464d = (RatingBar) convertView.findViewById(R.id.rb_score);
                holder.f2465e = (TextView) convertView.findViewById(R.id.tv_price);
                holder.f2466f = (TextView) convertView.findViewById(R.id.tv_style);
                holder.f2467g = (TextView) convertView.findViewById(R.id.tv_waitnum);
                holder.f2469i = (TextView) convertView.findViewById(R.id.tv_notice);
                holder.f2468h = (TextView) convertView.findViewById(R.id.tv_temp);
                holder.f2462b = (TextView) convertView.findViewById(R.id.tv_distant);
                convertView.setTag(holder);
            } else {
                convertView = this.f2478c.inflate(R.layout.item_food_cafe_queue, parent, false);
                holder.f2461a = (TextView) convertView.findViewById(R.id.tv_name);
                holder.f2470j = (TextView) convertView.findViewById(R.id.tv_state);
                holder.f2462b = (TextView) convertView.findViewById(R.id.tv_distant);
                holder.f2471k = (TextView) convertView.findViewById(R.id.tv_queue_name);
                holder.f2472l = (TextView) convertView.findViewById(R.id.tv_queue_waitnum);
                holder.f2473m = (TextView) convertView.findViewById(R.id.tv_queue_waittime);
                holder.f2474n = convertView.findViewById(R.id.btn_distant);
                convertView.setTag(holder);
            }
        }
        holder = (C0976a) convertView.getTag();
        C1926f model = getItem(position);
        if (model instanceof C1926f) {
            final C1926f queue = model;
            m3176a(queue.f6009q, holder.f2461a);
            if (TextUtils.isEmpty(queue.f6005m)) {
                holder.f2470j.setVisibility(8);
            } else {
                holder.f2470j.setVisibility(0);
                holder.f2470j.setText(queue.f6005m);
                if (C1926f.m7390a(queue.f6004l)) {
                    holder.f2470j.setBackgroundResource(R.drawable.com_bg_point01);
                } else {
                    holder.f2470j.setBackgroundResource(R.drawable.com_bg_point02);
                }
            }
            int distance = 0;
            if (!TextUtils.isEmpty(queue.f6010r) && C1766h.f5367a.containsKey(queue.f6010r)) {
                distance = ((Integer) C1766h.f5367a.get(queue.f6010r)).intValue();
            }
            if (distance > 0) {
                holder.f2462b.setText(C1925e.m7388a(distance));
            } else {
                holder.f2462b.setText("");
            }
            if (TextUtils.isEmpty(queue.f6008p)) {
                holder.f2471k.setText(R.string.home_food_queue_default);
            } else {
                holder.f2471k.setText(queue.f6008p);
            }
            if (!C1926f.m7390a(queue.f6004l) || TextUtils.isEmpty(queue.f6001i)) {
                holder.f2473m.setText(R.string.home_food_queue_default);
            } else {
                holder.f2473m.setText(queue.f6001i);
            }
            if (C1926f.m7390a(queue.f6004l)) {
                holder.f2472l.setText(BaiduNaviApplication.getInstance().getApplicationContext().getString(R.string.home_food_waitnum1, new Object[]{Integer.valueOf(queue.f5996d)}));
            } else {
                holder.f2472l.setText(R.string.home_food_queue_default);
            }
            if (CommonParams.jr) {
                holder.f2474n.setVisibility(0);
                holder.f2474n.setOnClickListener(new OnClickListener(this) {
                    /* renamed from: b */
                    final /* synthetic */ FoodCafeListAdapter f2460b;

                    public void onClick(View v) {
                        if (!TextUtils.isEmpty(queue.f6009q)) {
                            StatisticManager.onEvent(StatisticConstants.DISCOVER_ZMS_0003, StatisticConstants.DISCOVER_ZMS_0003);
                            if (C1926f.m7390a(queue.f6004l)) {
                                StatisticManager.onEvent(StatisticConstants.DISCOVER_ZMS_0004, StatisticConstants.DISCOVER_ZMS_0004);
                            }
                            this.f2460b.f2480e.innerNameSearch(queue.f6009q);
                        }
                    }
                });
            } else {
                holder.f2474n.setVisibility(8);
            }
        } else {
            C1925e cafe = (C1925e) model;
            holder.f2463c.setDefaultDrawable(C2188r.m8331b(R.drawable.home_bg_food_albumcover));
            holder.f2463c.setImageUrl(cafe.f5976j);
            m3176a(cafe.f5975i, holder.f2461a);
            float temp = 0.0f;
            try {
                temp = Float.parseFloat(cafe.f5969B + "");
            } catch (Exception e) {
            }
            holder.f2464d.setRating(temp);
            if (cafe.f5968A > 0) {
                holder.f2465e.setText(BaiduNaviApplication.getInstance().getApplicationContext().getString(R.string.home_food_perprice, new Object[]{Integer.valueOf(cafe.f5968A)}));
            } else {
                holder.f2465e.setText("");
            }
            if (TextUtils.isEmpty(cafe.f5990x)) {
                holder.f2466f.setText("");
            } else {
                holder.f2466f.setText(cafe.f5990x);
            }
            if (cafe.f5980n.intValue() > 0) {
                holder.f2462b.setText(C1925e.m7388a(cafe.f5980n.intValue()));
            } else {
                holder.f2462b.setText("");
            }
            if (cafe.f5979m > 0) {
                holder.f2469i.setVisibility(4);
                holder.f2468h.setVisibility(0);
                holder.f2467g.setVisibility(0);
                holder.f2467g.setText(String.valueOf(cafe.f5979m));
            } else {
                holder.f2468h.setVisibility(4);
                holder.f2467g.setVisibility(4);
                holder.f2469i.setVisibility(0);
                if (cafe.f5978l == null || cafe.f5978l.isEmpty()) {
                    holder.f2469i.setText(BaiduNaviApplication.getInstance().getApplicationContext().getString(R.string.home_food_no_status));
                    holder.f2469i.setTextColor(C2188r.m8328a((int) R.color.cl_other_a_highlight));
                } else {
                    holder.f2469i.setText(cafe.f5978l);
                    if (cafe.f5978l.equals("不用排队")) {
                        holder.f2469i.setTextColor(C2188r.m8328a((int) R.color.cl_text_a2_content));
                    } else {
                        holder.f2469i.setTextColor(C2188r.m8328a((int) R.color.cl_other_a_highlight));
                    }
                }
            }
        }
        return convertView;
    }

    /* renamed from: a */
    private void m3176a(String name, TextView nameTV) {
        if (TextUtils.isEmpty(name)) {
            nameTV.setText("");
        } else {
            nameTV.setText(name);
        }
    }
}
