package com.baidu.carlife.wechat.fragment;

import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import com.baidu.carlife.C0965R;
import com.baidu.carlife.view.p104a.C2251b;
import com.baidu.carlife.wechat.p105a.p107b.C2372c;
import com.baidu.carlife.wechat.p108b.C2376b;
import com.baidu.carlife.wechat.p108b.C2380c;
import com.baidu.carlife.wechat.p110e.C2436c;
import com.baidu.carlife.wechat.p113g.C2498b;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BlacklistFragment extends C2461a {
    /* renamed from: b */
    private ImageButton f8029b;
    /* renamed from: c */
    private ListView f8030c;
    /* renamed from: d */
    private TextView f8031d;
    /* renamed from: e */
    private C2460a f8032e;
    /* renamed from: f */
    private List<C2376b> f8033f = null;
    /* renamed from: g */
    private Set<String> f8034g = new HashSet();

    /* renamed from: com.baidu.carlife.wechat.fragment.BlacklistFragment$1 */
    class C24551 implements Comparator<C2376b> {
        /* renamed from: a */
        final /* synthetic */ BlacklistFragment f8015a;

        C24551(BlacklistFragment this$0) {
            this.f8015a = this$0;
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m9372a((C2376b) obj, (C2376b) obj2);
        }

        /* renamed from: a */
        public int m9372a(C2376b lhs, C2376b rhs) {
            int result = lhs.m9069n() - rhs.m9069n();
            if (result == 0) {
                return lhs.m9056c().compareTo(rhs.m9056c());
            }
            return result;
        }
    }

    /* renamed from: com.baidu.carlife.wechat.fragment.BlacklistFragment$2 */
    class C24562 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ BlacklistFragment f8016a;

        C24562(BlacklistFragment this$0) {
            this.f8016a = this$0;
        }

        public void onClick(View v) {
            this.f8016a.back();
        }
    }

    /* renamed from: com.baidu.carlife.wechat.fragment.BlacklistFragment$a */
    private class C2460a extends BaseAdapter {
        /* renamed from: a */
        final /* synthetic */ BlacklistFragment f8027a;

        /* renamed from: com.baidu.carlife.wechat.fragment.BlacklistFragment$a$a */
        class C2459a {
            /* renamed from: a */
            public SimpleDraweeView f8022a;
            /* renamed from: b */
            public TextView f8023b;
            /* renamed from: c */
            public TextView f8024c;
            /* renamed from: d */
            public CheckBox f8025d;
            /* renamed from: e */
            final /* synthetic */ C2460a f8026e;

            C2459a(C2460a this$1) {
                this.f8026e = this$1;
            }
        }

        public /* synthetic */ Object getItem(int i) {
            return m9374a(i);
        }

        public C2460a(BlacklistFragment blacklistFragment) {
            this.f8027a = blacklistFragment;
        }

        public int getCount() {
            return this.f8027a.f8033f == null ? 0 : this.f8027a.f8033f.size();
        }

        /* renamed from: a */
        public C2376b m9374a(int position) {
            return this.f8027a.f8033f == null ? null : (C2376b) this.f8027a.f8033f.get(position);
        }

        public long getItemId(int position) {
            return (long) position;
        }

        /* renamed from: a */
        private String m9373a(C2376b contact) {
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
            C2459a viewHolder;
            if (convertView == null) {
                viewHolder = new C2459a(this);
                convertView = LayoutInflater.from(this.f8027a.getContext()).inflate(C0965R.layout.list_item_blacklist, parent, false);
                viewHolder.f8023b = (TextView) convertView.findViewById(C0965R.id.list_item_blacklist_name);
                viewHolder.f8022a = (SimpleDraweeView) convertView.findViewById(C0965R.id.list_item_blacklist_icon);
                viewHolder.f8024c = (TextView) convertView.findViewById(C0965R.id.list_item_blacklist_section);
                viewHolder.f8025d = (CheckBox) convertView.findViewById(C0965R.id.list_item_blacklist_checkbox);
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (C2459a) convertView.getTag();
            }
            final C2376b contact = m9374a(position);
            if (position == 0 || !TextUtils.equals(m9373a(contact), m9373a(m9374a(position - 1)))) {
                viewHolder.f8024c.setVisibility(0);
                viewHolder.f8024c.setText(m9373a(contact));
            } else {
                viewHolder.f8024c.setVisibility(8);
                viewHolder.f8024c.setText("");
            }
            viewHolder.f8023b.setText(Html.fromHtml(contact.m9054b()));
            viewHolder.f8022a.setImageURI(C2436c.m9320i() + contact.m9060e());
            viewHolder.f8025d.setChecked(this.f8027a.m9380a(contact));
            viewHolder.f8025d.setOnClickListener(new OnClickListener(this) {
                /* renamed from: b */
                final /* synthetic */ C2460a f8018b;

                public void onClick(View v) {
                    if (this.f8018b.f8027a.m9380a(contact)) {
                        this.f8018b.f8027a.m9386c(contact);
                    } else {
                        this.f8018b.f8027a.m9383b(contact);
                    }
                    this.f8018b.f8027a.m9382b();
                }
            });
            convertView.setOnClickListener(new OnClickListener(this) {
                /* renamed from: c */
                final /* synthetic */ C2460a f8021c;

                public void onClick(View v) {
                    if (this.f8021c.f8027a.m9380a(contact)) {
                        this.f8021c.f8027a.m9386c(contact);
                    } else {
                        this.f8021c.f8027a.m9383b(contact);
                    }
                    viewHolder.f8025d.setChecked(this.f8021c.f8027a.m9380a(contact));
                    this.f8021c.f8027a.m9382b();
                }
            });
            convertView.setBackground(this.f8027a.getResources().getDrawable(C0965R.drawable.com_bg_item_selector));
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
        View rootView = inflater.inflate(C0965R.layout.fragment_blacklist, null);
        rootView.setOnClickListener(null);
        m9379a(rootView);
        m9378a();
        return rootView;
    }

    protected void onInitView() {
    }

    public void onPause() {
        super.onPause();
    }

    /* renamed from: a */
    private void m9378a() {
        this.f8033f = C2380c.m9070a().m9087h();
        Collections.sort(this.f8033f, new C24551(this));
        this.f8034g = C2498b.m9488d();
        C2372c.m9030c("blacklistSet = " + this.f8034g.toString());
        this.f8032e.notifyDataSetChanged();
    }

    /* renamed from: a */
    private void m9379a(View rootView) {
        this.f8029b = (ImageButton) rootView.findViewById(C0965R.id.fragment_blacklist_back);
        this.f8029b.setBackground(C2251b.m8527a(getActivity()));
        this.f8029b.setOnClickListener(new C24562(this));
        this.f8030c = (ListView) rootView.findViewById(C0965R.id.blacklist_listview);
        this.f8031d = (TextView) rootView.findViewById(C0965R.id.blacklist_empty_view);
        this.f8030c.setEmptyView(this.f8031d);
        this.f8032e = new C2460a(this);
        this.f8030c.setAdapter(this.f8032e);
    }

    /* renamed from: a */
    private boolean m9380a(C2376b contact) {
        String name = contact.m9062g();
        if (TextUtils.isEmpty(name)) {
            name = contact.m9054b();
        }
        return this.f8034g.contains(name);
    }

    /* renamed from: b */
    private void m9383b(C2376b contact) {
        String name = contact.m9062g();
        if (TextUtils.isEmpty(name)) {
            name = contact.m9054b();
        }
        this.f8034g.add(name);
    }

    /* renamed from: c */
    private void m9386c(C2376b contact) {
        String name = contact.m9062g();
        if (TextUtils.isEmpty(name)) {
            name = contact.m9054b();
        }
        this.f8034g.remove(name);
    }

    /* renamed from: b */
    private void m9382b() {
        C2372c.m9030c("blacklistSet = " + this.f8034g.toString());
        C2498b.m9481a(this.f8034g);
    }
}
