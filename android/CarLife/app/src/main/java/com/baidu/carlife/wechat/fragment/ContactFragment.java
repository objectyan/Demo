package com.baidu.carlife.wechat.fragment;

import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import com.baidu.carlife.C0965R;
import com.baidu.carlife.view.C2342g;
import com.baidu.carlife.view.p104a.C2251b;
import com.baidu.carlife.wechat.p108b.C2375a;
import com.baidu.carlife.wechat.p108b.C2376b;
import com.baidu.carlife.wechat.p108b.C2380c;
import com.baidu.carlife.wechat.p109c.C2415a;
import com.baidu.carlife.wechat.p109c.C2415a.C2413a;
import com.baidu.carlife.wechat.p110e.C2436c;
import com.baidu.navi.fragment.NaviFragmentManager;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ContactFragment extends C2461a {
    /* renamed from: b */
    private ImageButton f8061b;
    /* renamed from: c */
    private ListView f8062c;
    /* renamed from: d */
    private TextView f8063d;
    /* renamed from: e */
    private C2474a f8064e;
    /* renamed from: f */
    private List<C2376b> f8065f = null;

    /* renamed from: com.baidu.carlife.wechat.fragment.ContactFragment$1 */
    class C24671 implements Comparator<C2376b> {
        /* renamed from: a */
        final /* synthetic */ ContactFragment f8050a;

        C24671(ContactFragment this$0) {
            this.f8050a = this$0;
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m9395a((C2376b) obj, (C2376b) obj2);
        }

        /* renamed from: a */
        public int m9395a(C2376b lhs, C2376b rhs) {
            int result = lhs.m9069n() - rhs.m9069n();
            if (result == 0) {
                return lhs.m9056c().compareTo(rhs.m9056c());
            }
            return result;
        }
    }

    /* renamed from: com.baidu.carlife.wechat.fragment.ContactFragment$2 */
    class C24682 implements C2413a {
        /* renamed from: a */
        final /* synthetic */ ContactFragment f8051a;

        C24682(ContactFragment this$0) {
            this.f8051a = this$0;
        }

        /* renamed from: a */
        public void mo1857a() {
            this.f8051a.m9406c();
            this.f8051a.m9408b();
        }
    }

    /* renamed from: com.baidu.carlife.wechat.fragment.ContactFragment$3 */
    class C24693 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ ContactFragment f8052a;

        C24693(ContactFragment this$0) {
            this.f8052a = this$0;
        }

        public void onClick(View v) {
            this.f8052a.back();
        }
    }

    /* renamed from: com.baidu.carlife.wechat.fragment.ContactFragment$4 */
    class C24704 implements OnItemClickListener {
        /* renamed from: a */
        final /* synthetic */ ContactFragment f8053a;

        C24704(ContactFragment this$0) {
            this.f8053a = this$0;
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
            C2375a chat = new C2375a(this.f8053a.f8064e.m9399a(position), 0);
            Bundle bundle = new Bundle();
            bundle.putString("user_name", chat.m9045a().m9052a());
            bundle.putString("show_name", chat.m9045a().m9054b());
            boolean noDisturbFlag = chat.m9045a().m9066k() && chat.m9045a().m9061f() == 0;
            bundle.putBoolean("no_disturb_flag", noDisturbFlag);
            this.f8053a.showFragment(NaviFragmentManager.TYPE_WECHAT_CHAT, bundle);
        }
    }

    /* renamed from: com.baidu.carlife.wechat.fragment.ContactFragment$5 */
    class C24725 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ ContactFragment f8055a;

        /* renamed from: com.baidu.carlife.wechat.fragment.ContactFragment$5$1 */
        class C24711 implements C2413a {
            /* renamed from: a */
            final /* synthetic */ C24725 f8054a;

            C24711(C24725 this$1) {
                this.f8054a = this$1;
            }

            /* renamed from: a */
            public void mo1857a() {
                this.f8054a.f8055a.m9406c();
                this.f8054a.f8055a.m9408b();
            }
        }

        C24725(ContactFragment this$0) {
            this.f8055a = this$0;
        }

        public void onClick(View v) {
            this.f8055a.m9403a("正在加载微信好友。。。");
            C2415a.m9228a().m9240a(new C24711(this));
            if (!C2415a.m9228a().m9244d()) {
                C2415a.m9228a().m9241a("0");
            }
        }
    }

    /* renamed from: com.baidu.carlife.wechat.fragment.ContactFragment$a */
    private class C2474a extends BaseAdapter {
        /* renamed from: a */
        final /* synthetic */ ContactFragment f8060a;

        /* renamed from: com.baidu.carlife.wechat.fragment.ContactFragment$a$a */
        class C2473a {
            /* renamed from: a */
            public SimpleDraweeView f8056a;
            /* renamed from: b */
            public TextView f8057b;
            /* renamed from: c */
            public TextView f8058c;
            /* renamed from: d */
            final /* synthetic */ C2474a f8059d;

            C2473a(C2474a this$1) {
                this.f8059d = this$1;
            }
        }

        public /* synthetic */ Object getItem(int i) {
            return m9399a(i);
        }

        public C2474a(ContactFragment contactFragment) {
            this.f8060a = contactFragment;
        }

        public int getCount() {
            return this.f8060a.f8065f == null ? 0 : this.f8060a.f8065f.size();
        }

        /* renamed from: a */
        public C2376b m9399a(int position) {
            return this.f8060a.f8065f == null ? null : (C2376b) this.f8060a.f8065f.get(position);
        }

        public long getItemId(int position) {
            return (long) position;
        }

        /* renamed from: a */
        private String m9398a(C2376b contact) {
            if (contact.m9058d() == 1) {
                return "星标朋友";
            }
            if (contact.m9066k()) {
                return "群聊";
            }
            char c = contact.m9056c().charAt(0);
            if (c < 'a' || c > 'z') {
                return "#";
            }
            return String.valueOf(c).toUpperCase();
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            C2473a viewHolder;
            if (convertView == null) {
                viewHolder = new C2473a(this);
                convertView = LayoutInflater.from(this.f8060a.getContext()).inflate(C0965R.layout.list_item_contact, parent, false);
                viewHolder.f8057b = (TextView) convertView.findViewById(C0965R.id.list_item_contact_name);
                viewHolder.f8056a = (SimpleDraweeView) convertView.findViewById(C0965R.id.list_item_contact_icon);
                viewHolder.f8058c = (TextView) convertView.findViewById(C0965R.id.list_item_contact_section);
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (C2473a) convertView.getTag();
            }
            C2376b contact = m9399a(position);
            if (position == 0 || !TextUtils.equals(m9398a(contact), m9398a(m9399a(position - 1)))) {
                viewHolder.f8058c.setVisibility(0);
                viewHolder.f8058c.setText(m9398a(contact));
            } else {
                viewHolder.f8058c.setVisibility(8);
                viewHolder.f8058c.setText("");
            }
            viewHolder.f8057b.setText(Html.fromHtml(contact.m9054b()));
            viewHolder.f8056a.setImageURI(C2436c.m9320i() + contact.m9060e());
            return convertView;
        }
    }

    public /* bridge */ /* synthetic */ void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public /* bridge */ /* synthetic */ void onResume() {
        super.onResume();
    }

    public /* bridge */ /* synthetic */ void onStop() {
        super.onStop();
    }

    protected void onUpdateOrientation(int orientation) {
    }

    protected void onUpdateStyle(boolean dayStyle) {
    }

    protected View onCreateContentView(LayoutInflater inflater) {
        View rootView = inflater.inflate(C0965R.layout.fragment_contact, null);
        rootView.setOnClickListener(null);
        m9400a(rootView);
        m9408b();
        return rootView;
    }

    protected void onInitView() {
    }

    /* renamed from: a */
    public void mo1856a() {
        this.f8065f = null;
    }

    /* renamed from: b */
    public void m9408b() {
        if (this.f8065f == null || this.f8065f.size() == 0) {
            this.f8065f = C2380c.m9070a().m9087h();
            Collections.sort(this.f8065f, new C24671(this));
            this.f8064e.notifyDataSetChanged();
        }
        if (C2415a.m9228a().m9244d()) {
            C2415a.m9228a().m9240a(new C24682(this));
            m9403a("正在加载微信好友。。。");
        }
    }

    /* renamed from: a */
    private void m9400a(View rootView) {
        this.f8061b = (ImageButton) rootView.findViewById(C0965R.id.fragment_contact_back);
        this.f8061b.setBackground(C2251b.m8527a(getActivity()));
        this.f8061b.setOnClickListener(new C24693(this));
        this.f8062c = (ListView) rootView.findViewById(C0965R.id.contact_listview);
        this.f8063d = (TextView) rootView.findViewById(C0965R.id.contact_empty_view);
        this.f8062c.setEmptyView(this.f8063d);
        this.f8064e = new C2474a(this);
        this.f8062c.setAdapter(this.f8064e);
        this.f8062c.setOnItemClickListener(new C24704(this));
        this.f8063d.setOnClickListener(new C24725(this));
    }

    /* renamed from: a */
    private void m9403a(String msg) {
        C2342g.m8864e().m8890a(msg);
    }

    /* renamed from: c */
    private void m9406c() {
        C2342g.m8864e().m8895f();
    }
}
