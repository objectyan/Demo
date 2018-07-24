package com.baidu.carlife.wechat.p111d;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.baidu.carlife.C0965R;
import com.baidu.carlife.util.C2188r;
import com.baidu.carlife.wechat.p108b.C2398k;
import com.baidu.carlife.wechat.p113g.C2498b;
import com.baidu.carlife.wechat.p113g.C2499c;
import java.util.ArrayList;
import java.util.List;

/* compiled from: MenuAdapter */
/* renamed from: com.baidu.carlife.wechat.d.a */
public class C2416a extends BaseAdapter {
    /* renamed from: a */
    private Context f7961a;
    /* renamed from: b */
    private List<C2417b> f7962b;
    /* renamed from: c */
    private float f7963c = C2499c.m9502c();

    public /* synthetic */ Object getItem(int i) {
        return m9248a(i);
    }

    public C2416a(Context context) {
        this.f7961a = context;
        m9247a();
    }

    /* renamed from: a */
    private void m9247a() {
        this.f7962b = new ArrayList();
        this.f7962b.add(C2417b.Session);
        this.f7962b.add(C2417b.Contact);
        this.f7962b.add(C2417b.Mute);
        this.f7962b.add(C2417b.Setting);
    }

    /* renamed from: a */
    public C2417b m9248a(int position) {
        return (C2417b) this.f7962b.get(position);
    }

    public int getCount() {
        return this.f7962b.size();
    }

    public long getItemId(int position) {
        return (long) position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(this.f7961a).inflate(C0965R.layout.recyclerview_item_menu, parent, false);
        TextView textView = (TextView) convertView.findViewById(C0965R.id.recyclerview_item_menu_textview);
        TextView countTextView = (TextView) convertView.findViewById(C0965R.id.recyclerview_item_menu_count);
        C2417b item = m9248a(position);
        textView.setText(item.m9249a());
        convertView.setBackground(C2188r.m8331b(C0965R.drawable.home_bg_item_selector));
        textView.setTextColor(C2188r.m8328a((int) C0965R.color.cl_text_a5));
        textView.setCompoundDrawablesWithIntrinsicBounds(0, item.m9250b(), 0, 0);
        if (item == C2417b.Mute) {
            if (C2498b.m9483a()) {
                textView.setCompoundDrawablesWithIntrinsicBounds(0, C0965R.mipmap.wx_ic_mute_on, 0, 0);
                textView.setText("微信已静音");
            } else {
                textView.setCompoundDrawablesWithIntrinsicBounds(0, C0965R.mipmap.wx_ic_mute_off, 0, 0);
                textView.setText("微信静音");
            }
        }
        countTextView.setVisibility(8);
        countTextView.setText("");
        if (m9248a(position) == C2417b.Session) {
            int unreadMsgCount = C2398k.m9160a().m9189d();
            if (unreadMsgCount > 0) {
                LayoutParams lp = (LayoutParams) countTextView.getLayoutParams();
                if (unreadMsgCount < 10) {
                    lp.width = (int) (18.0f * this.f7963c);
                } else {
                    lp.width = -2;
                }
                countTextView.setLayoutParams(lp);
                countTextView.setVisibility(0);
                if (unreadMsgCount > 99) {
                    countTextView.setText("...");
                } else {
                    countTextView.setText(String.valueOf(unreadMsgCount));
                }
            }
        }
        return convertView;
    }
}
