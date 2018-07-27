package com.baidu.carlife.adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.TextView;

import com.baidu.carlife.R;
import com.baidu.carlife.core.CarlifeUtil;
import com.baidu.carlife.logic.voice.C1912n;
import com.baidu.carlife.p087l.CarlifeCoreSDK;
import com.baidu.carlife.util.C2188r;
import com.baidu.carlife.view.SwitchButton;

import com.baidu.navi.fragment.BaseFragment;
import com.baidu.navi.track.common.TrackConfigUtil;

/* compiled from: SettingListAdapter */
/* renamed from: com.baidu.carlife.adpter.q */
public class SettingListAdapter extends BaseAdapter {
    /* renamed from: a */
    private String[] f2601a;
    /* renamed from: b */
    private Context f2602b;
    /* renamed from: c */
    private Object f2603c = new Object();
    /* renamed from: d */
    private C1011b f2604d = new C10121(this);
    /* renamed from: e */
    private OnCheckedChangeListener f2605e = new C10132(this);
    /* renamed from: f */
    private OnCheckedChangeListener f2606f = new C10143(this);
    /* renamed from: g */
    private OnCheckedChangeListener f2607g = new C10154(this);

    /* compiled from: SettingListAdapter */
    /* renamed from: com.baidu.carlife.adpter.q$b */
    public interface C1011b {
        /* renamed from: a */
        void mo1377a();
    }

    /* compiled from: SettingListAdapter */
    /* renamed from: com.baidu.carlife.adpter.q$1 */
    class C10121 implements C1011b {
        /* renamed from: a */
        final /* synthetic */ SettingListAdapter f2587a;

        C10121(SettingListAdapter this$0) {
            this.f2587a = this$0;
        }

        /* renamed from: a */
        public void mo1377a() {
            this.f2587a.notifyDataSetChanged();
        }
    }

    /* compiled from: SettingListAdapter */
    /* renamed from: com.baidu.carlife.adpter.q$2 */
    class C10132 implements OnCheckedChangeListener {
        /* renamed from: a */
        final /* synthetic */ SettingListAdapter f2588a;

        C10132(SettingListAdapter this$0) {
            this.f2588a = this$0;
        }

        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (isChecked != this.f2588a.m3257a()) {
                new C1018a(this.f2588a, buttonView, isChecked).start();
            }
        }
    }

    /* compiled from: SettingListAdapter */
    /* renamed from: com.baidu.carlife.adpter.q$3 */
    class C10143 implements OnCheckedChangeListener {
        /* renamed from: a */
        final /* synthetic */ SettingListAdapter f2589a;

        C10143(SettingListAdapter this$0) {
            this.f2589a = this$0;
        }

        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            CarlifeCoreSDK.m5979a().m6032d(isChecked);
        }
    }

    /* compiled from: SettingListAdapter */
    /* renamed from: com.baidu.carlife.adpter.q$4 */
    class C10154 implements OnCheckedChangeListener {
        /* renamed from: a */
        final /* synthetic */ SettingListAdapter f2590a;

        C10154(SettingListAdapter this$0) {
            this.f2590a = this$0;
        }

        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (isChecked != TrackConfigUtil.getInstance().getRouteRecordFlag()) {
                TrackConfigUtil.getInstance().setRouteRecordFlag(isChecked);
            }
        }
    }

    /* compiled from: SettingListAdapter */
    /* renamed from: com.baidu.carlife.adpter.q$a */
    private class C1018a extends Thread {
        /* renamed from: a */
        CompoundButton f2593a;
        /* renamed from: b */
        boolean f2594b;
        /* renamed from: c */
        final /* synthetic */ SettingListAdapter f2595c;

        /* compiled from: SettingListAdapter */
        /* renamed from: com.baidu.carlife.adpter.q$a$1 */
        class C10161 implements Runnable {
            /* renamed from: a */
            final /* synthetic */ C1018a f2591a;

            C10161(C1018a this$1) {
                this.f2591a = this$1;
            }

            public void run() {
                C1912n.m7270a().m7308g();
            }
        }

        /* compiled from: SettingListAdapter */
        /* renamed from: com.baidu.carlife.adpter.q$a$2 */
        class C10172 implements Runnable {
            /* renamed from: a */
            final /* synthetic */ C1018a f2592a;

            C10172(C1018a this$1) {
                this.f2592a = this$1;
            }

            public void run() {
                C1912n.m7270a().m7309h();
            }
        }

        public C1018a(SettingListAdapter settingListAdapter, CompoundButton buttonView, boolean isChecked) {
            this.f2595c = settingListAdapter;
            this.f2593a = buttonView;
            this.f2594b = isChecked;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
            r3 = this;
            r0 = r3.f2595c;
            r1 = r0.f2603c;
            monitor-enter(r1);
            r0 = com.baidu.carlife.logic.voice.C1912n.m7270a();	 Catch:{ all -> 0x005c }
            r0 = r0.m7315n();	 Catch:{ all -> 0x005c }
            if (r0 == 0) goto L_0x0029;
        L_0x0011:
            r0 = r3.f2593a;	 Catch:{ all -> 0x005c }
            r0 = r0.isChecked();	 Catch:{ all -> 0x005c }
            if (r0 == 0) goto L_0x0027;
        L_0x0019:
            r0 = r3.f2593a;	 Catch:{ all -> 0x005c }
            r2 = 0;
            r0.setChecked(r2);	 Catch:{ all -> 0x005c }
            r0 = com.baidu.carlife.core.CarlifeUtil.m4358a();	 Catch:{ all -> 0x005c }
            r2 = 0;
            r0.m4390a(r2);	 Catch:{ all -> 0x005c }
        L_0x0027:
            monitor-exit(r1);	 Catch:{ all -> 0x005c }
        L_0x0028:
            return;
        L_0x0029:
            r0 = r3.f2594b;	 Catch:{ all -> 0x005c }
            r2 = r3.f2595c;	 Catch:{ all -> 0x005c }
            r2 = r2.m3257a();	 Catch:{ all -> 0x005c }
            if (r0 == r2) goto L_0x005a;
        L_0x0033:
            r0 = com.baidu.carlife.logic.voice.C1912n.m7270a();	 Catch:{ all -> 0x005c }
            r2 = r3.f2594b;	 Catch:{ all -> 0x005c }
            r0.m7299a(r2);	 Catch:{ all -> 0x005c }
            r0 = r3.f2594b;	 Catch:{ all -> 0x005c }
            if (r0 == 0) goto L_0x005f;
        L_0x0040:
            r0 = com.baidu.carlife.core.CarlifeUtil.m4358a();	 Catch:{ all -> 0x005c }
            r2 = r3.f2594b;	 Catch:{ all -> 0x005c }
            r0.m4390a(r2);	 Catch:{ all -> 0x005c }
            r0 = 2131297225; // 0x7f0903c9 float:1.8212389E38 double:1.05300074E-314;
            r2 = 0;
            com.baidu.carlife.util.C2201w.m8371a(r0, r2);	 Catch:{ all -> 0x005c }
            r0 = r3.f2593a;	 Catch:{ all -> 0x005c }
            r2 = new com.baidu.carlife.adpter.q$a$1;	 Catch:{ all -> 0x005c }
            r2.<init>(r3);	 Catch:{ all -> 0x005c }
            r0.post(r2);	 Catch:{ all -> 0x005c }
        L_0x005a:
            monitor-exit(r1);	 Catch:{ all -> 0x005c }
            goto L_0x0028;
        L_0x005c:
            r0 = move-exception;
            monitor-exit(r1);	 Catch:{ all -> 0x005c }
            throw r0;
        L_0x005f:
            r0 = com.baidu.carlife.core.CarlifeUtil.m4358a();	 Catch:{ all -> 0x005c }
            r2 = r3.f2594b;	 Catch:{ all -> 0x005c }
            r0.m4390a(r2);	 Catch:{ all -> 0x005c }
            r0 = 2131297206; // 0x7f0903b6 float:1.821235E38 double:1.0530007306E-314;
            r2 = 0;
            com.baidu.carlife.util.C2201w.m8371a(r0, r2);	 Catch:{ all -> 0x005c }
            r0 = r3.f2593a;	 Catch:{ all -> 0x005c }
            r2 = new com.baidu.carlife.adpter.q$a$2;	 Catch:{ all -> 0x005c }
            r2.<init>(r3);	 Catch:{ all -> 0x005c }
            r0.post(r2);	 Catch:{ all -> 0x005c }
            goto L_0x005a;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.carlife.adpter.q.a.run():void");
        }
    }

    /* compiled from: SettingListAdapter */
    /* renamed from: com.baidu.carlife.adpter.q$c */
    private class C1019c {
        /* renamed from: a */
        TextView f2596a;
        /* renamed from: b */
        SwitchButton f2597b;
        /* renamed from: c */
        ImageView f2598c;
        /* renamed from: d */
        View f2599d;
        /* renamed from: e */
        final /* synthetic */ SettingListAdapter f2600e;

        private C1019c(SettingListAdapter settingListAdapter) {
            this.f2600e = settingListAdapter;
        }
    }

    public SettingListAdapter(Context context, int arrayId) {
        this.f2602b = context;
        this.f2601a = this.f2602b.getResources().getStringArray(arrayId);
        C1912n.m7270a().m7295a(this.f2604d);
        BaseFragment.mActivity.m3103a(this.f2604d);
    }

    public int getCount() {
        if (CarlifeCoreSDK.m5979a().m6042i()) {
            return this.f2601a.length;
        }
        return this.f2601a.length - 1;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        if (position == 0) {
            return 0;
        }
        if (CarlifeCoreSDK.m5979a().m6042i()) {
            return (long) position;
        }
        return (long) (position + 1);
    }

    /* renamed from: a */
    public void m3260a(int arrayId) {
        this.f2601a = this.f2602b.getResources().getStringArray(arrayId);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(this.f2602b).inflate(R.layout.setting_list_item, parent, false);
            C1019c viewCache = new C1019c();
            viewCache.f2596a = (TextView) convertView.findViewById(R.id.tv_item_name);
            viewCache.f2597b = (SwitchButton) convertView.findViewById(R.id.sw_voice_wakeup);
            viewCache.f2598c = (ImageView) convertView.findViewById(R.id.iv_direction_icon);
            viewCache.f2599d = convertView.findViewById(R.id.red_point);
            convertView.setTag(viewCache);
        }
        C1019c cache = (C1019c) convertView.getTag();
        cache.f2597b.setOnCheckedChangeListener(null);
        if (!CarlifeCoreSDK.m5979a().m6042i()) {
            switch (position) {
                case 0:
                case 3:
                    cache.f2597b.setVisibility(0);
                    cache.f2598c.setVisibility(8);
                    cache.f2597b.setClickable(false);
                    if (position != 0) {
                        if (position == 3) {
                            cache.f2597b.setOnCheckedChangeListener(this.f2607g);
                            cache.f2597b.setChecked(TrackConfigUtil.getInstance().getRouteRecordFlag());
                            break;
                        }
                    }
                    cache.f2597b.setOnCheckedChangeListener(this.f2605e);
                    cache.f2597b.setChecked(m3257a());
                    break;
                break;
                case 2:
                    cache.f2598c.setVisibility(0);
                    cache.f2597b.setVisibility(8);
                    break;
                default:
                    cache.f2598c.setVisibility(0);
                    cache.f2597b.setVisibility(8);
                    break;
            }
        }
        switch (position) {
            case 0:
            case 1:
            case 4:
                cache.f2597b.setVisibility(0);
                cache.f2598c.setVisibility(8);
                cache.f2597b.setClickable(false);
                if (position != 0) {
                    if (position != 1) {
                        if (position == 4) {
                            cache.f2597b.setOnCheckedChangeListener(this.f2607g);
                            cache.f2597b.setChecked(TrackConfigUtil.getInstance().getRouteRecordFlag());
                            break;
                        }
                    }
                    cache.f2597b.setOnCheckedChangeListener(this.f2606f);
                    cache.f2597b.setChecked(CarlifeCoreSDK.m5979a().m6043j());
                    break;
                }
                cache.f2597b.setOnCheckedChangeListener(this.f2605e);
                cache.f2597b.setChecked(m3257a());
                break;
            break;
            case 2:
                cache.f2598c.setVisibility(0);
                cache.f2597b.setVisibility(8);
                break;
            default:
                cache.f2598c.setVisibility(0);
                cache.f2597b.setVisibility(8);
                break;
        }
        cache.f2596a.setText(this.f2601a[(int) getItemId(position)]);
        cache.f2596a.setTextColor(C2188r.m8328a((int) R.color.cl_text_a5_content));
        return convertView;
    }

    /* renamed from: a */
    private boolean m3257a() {
        return CarlifeUtil.m4358a().m4398o();
    }
}
