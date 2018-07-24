package com.baidu.carlife.p059c;

import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.carlife.p059c.p061f.C1139a.C1095b;
import com.baidu.carlife.p059c.p061f.C1139a.C1132a;
import com.baidu.carlife.p059c.p061f.C1140b.C1101b;
import com.baidu.carlife.p059c.p061f.C1140b.C1134a;

/* compiled from: BaseListAdapter */
/* renamed from: com.baidu.carlife.c.b */
public class C1102b extends BaseAdapter implements C1101b {
    /* renamed from: a */
    private C1134a f2879a;

    /* compiled from: BaseListAdapter */
    /* renamed from: com.baidu.carlife.c.b$a */
    public static final class C1096a implements C1095b {
        /* renamed from: a */
        private static final int f2871a = 0;
        /* renamed from: b */
        private SparseArray<View> f2872b = new SparseArray();
        /* renamed from: c */
        private View f2873c;
        /* renamed from: d */
        private C1132a f2874d;
        /* renamed from: e */
        private int f2875e;

        public C1096a(View root, int position) {
            this.f2873c = root;
            this.f2875e = position;
        }

        /* renamed from: a */
        public View m3702a() {
            return this.f2873c;
        }

        /* renamed from: b */
        public int m3708b() {
            return this.f2875e;
        }

        /* renamed from: c */
        public C1132a m3709c() {
            return this.f2874d;
        }

        /* renamed from: a */
        public <T extends View> T m3703a(int viewId) {
            View view = (View) this.f2872b.get(viewId);
            if (view != null) {
                return view;
            }
            view = this.f2873c.findViewById(viewId);
            this.f2872b.put(viewId, view);
            return view;
        }

        /* renamed from: a */
        public void m3705a(int viewId, String content) {
            ((TextView) m3703a(viewId)).setText(content);
        }

        /* renamed from: a */
        public void m3704a(int viewId, OnClickListener onClickListener) {
            if (viewId == 0) {
                this.f2873c.setOnClickListener(onClickListener);
            } else {
                m3703a(viewId).setOnClickListener(onClickListener);
            }
        }

        /* renamed from: a */
        public void m3707a(C1132a basePresenter) {
            this.f2874d = basePresenter;
        }
    }

    public int getCount() {
        return this.f2879a.mo1433d();
    }

    public Object getItem(int position) {
        return this.f2879a.mo1432c(position);
    }

    public long getItemId(int position) {
        return (long) position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View root;
        C1096a viewHolder;
        if (convertView == null) {
            root = LayoutInflater.from(parent.getContext()).inflate(this.f2879a.mo1431b(position), parent, false);
            viewHolder = new C1096a(root, position);
            root.setTag(viewHolder);
        } else {
            root = convertView;
            viewHolder = (C1096a) root.getTag();
        }
        C1132a itemPresenter = viewHolder.m3709c();
        if (itemPresenter == null) {
            itemPresenter = this.f2879a.mo1625d(position);
            itemPresenter.mo1425a(position);
            itemPresenter.mo1427a(this.f2879a);
            itemPresenter.mo1426a(viewHolder);
            viewHolder.m3707a(itemPresenter);
        }
        itemPresenter.mo1428a(this.f2879a.mo1432c(position));
        return root;
    }

    /* renamed from: a */
    public void mo1416a(Object data) {
        notifyDataSetChanged();
    }

    /* renamed from: a */
    public void m3724a(C1134a basePresenter) {
        this.f2879a = basePresenter;
    }
}
