package com.baidu.carlife.wechat.fragment;

import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import com.baidu.carlife.C0965R;
import com.baidu.carlife.view.p104a.C2251b;
import com.baidu.carlife.wechat.p108b.C2380c;
import com.baidu.carlife.wechat.p108b.C2382d;
import com.baidu.carlife.wechat.p108b.C2385g;
import com.baidu.carlife.wechat.p108b.C2398k;
import com.baidu.carlife.wechat.p108b.C2398k.C2397b;
import com.baidu.carlife.wechat.p110e.C2436c;
import com.baidu.carlife.wechat.p112f.C2451b;
import com.baidu.carlife.wechat.p113g.C2499c;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ChatFragment extends C2461a implements C2397b {
    /* renamed from: b */
    private ImageButton f8042b;
    /* renamed from: c */
    private TextView f8043c;
    /* renamed from: d */
    private ListView f8044d;
    /* renamed from: e */
    private C2466a f8045e;
    /* renamed from: f */
    private String f8046f = null;
    /* renamed from: g */
    private String f8047g = null;
    /* renamed from: h */
    private boolean f8048h = false;
    /* renamed from: i */
    private List<C2382d> f8049i = new ArrayList();

    /* renamed from: com.baidu.carlife.wechat.fragment.ChatFragment$1 */
    class C24621 implements Comparator<C2382d> {
        /* renamed from: a */
        final /* synthetic */ ChatFragment f8035a;

        C24621(ChatFragment this$0) {
            this.f8035a = this$0;
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m9388a((C2382d) obj, (C2382d) obj2);
        }

        /* renamed from: a */
        public int m9388a(C2382d lhs, C2382d rhs) {
            return (int) (lhs.m9109k() - rhs.m9109k());
        }
    }

    /* renamed from: com.baidu.carlife.wechat.fragment.ChatFragment$2 */
    class C24632 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ ChatFragment f8036a;

        C24632(ChatFragment this$0) {
            this.f8036a = this$0;
        }

        public void onClick(View v) {
            this.f8036a.back();
        }
    }

    /* renamed from: com.baidu.carlife.wechat.fragment.ChatFragment$3 */
    class C24643 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ ChatFragment f8037a;

        C24643(ChatFragment this$0) {
            this.f8037a = this$0;
        }

        public void onClick(View v) {
            C2451b.m9347d().m9349a(C2380c.m9070a().m9078b(this.f8037a.f8046f));
        }
    }

    /* renamed from: com.baidu.carlife.wechat.fragment.ChatFragment$a */
    private class C2466a extends BaseAdapter {
        /* renamed from: a */
        final /* synthetic */ ChatFragment f8041a;

        /* renamed from: com.baidu.carlife.wechat.fragment.ChatFragment$a$a */
        class C2465a {
            /* renamed from: a */
            public SimpleDraweeView f8038a;
            /* renamed from: b */
            public TextView f8039b;
            /* renamed from: c */
            final /* synthetic */ C2466a f8040c;

            C2465a(C2466a this$1) {
                this.f8040c = this$1;
            }
        }

        public /* synthetic */ Object getItem(int i) {
            return m9389a(i);
        }

        public C2466a(ChatFragment chatFragment) {
            this.f8041a = chatFragment;
        }

        public int getCount() {
            return this.f8041a.f8049i == null ? 0 : this.f8041a.f8049i.size();
        }

        /* renamed from: a */
        public C2382d m9389a(int position) {
            return this.f8041a.f8049i == null ? null : (C2382d) this.f8041a.f8049i.get(position);
        }

        public long getItemId(int position) {
            return (long) position;
        }

        public int getViewTypeCount() {
            return 2;
        }

        public int getItemViewType(int position) {
            if (C2380c.m9070a().m9077a(m9389a(position) == null ? "" : m9389a(position).m9102d())) {
                return 1;
            }
            return 0;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            C2465a viewHolder;
            if (getItemViewType(position) == 0) {
                if (convertView == null) {
                    viewHolder = new C2465a(this);
                    convertView = LayoutInflater.from(this.f8041a.getContext()).inflate(C0965R.layout.list_item_chat_left, parent, false);
                    viewHolder.f8038a = (SimpleDraweeView) convertView.findViewById(C0965R.id.list_item_chat_left_icon);
                    viewHolder.f8039b = (TextView) convertView.findViewById(C0965R.id.list_item_chat_left_content);
                    convertView.setTag(viewHolder);
                } else {
                    viewHolder = (C2465a) convertView.getTag();
                }
            } else if (convertView == null) {
                viewHolder = new C2465a(this);
                convertView = LayoutInflater.from(this.f8041a.getContext()).inflate(C0965R.layout.list_item_chat_right, parent, false);
                viewHolder.f8038a = (SimpleDraweeView) convertView.findViewById(C0965R.id.list_item_chat_right_icon);
                viewHolder.f8039b = (TextView) convertView.findViewById(C0965R.id.list_item_chat_right_content);
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (C2465a) convertView.getTag();
            }
            C2382d msg = m9389a(position);
            if (getItemViewType(position) == 1) {
                viewHolder.f8038a.setImageURI(C2436c.m9320i() + C2380c.m9070a().m9085f().m9135d());
            } else if (msg.m9105g().m9066k()) {
                C2385g member = msg.m9105g().m9059d(msg.m9111m());
                if (!(member == null || TextUtils.isEmpty(member.m9126d()))) {
                    viewHolder.f8038a.setImageURI(C2436c.m9320i() + member.m9126d());
                }
            } else if (!TextUtils.isEmpty(msg.m9105g().m9060e())) {
                viewHolder.f8038a.setImageURI(C2436c.m9320i() + msg.m9105g().m9060e());
            }
            String content = C2499c.m9494a(msg);
            if (TextUtils.isEmpty(content)) {
                viewHolder.f8039b.setText("");
            } else {
                viewHolder.f8039b.setText(Html.fromHtml(content.trim()));
            }
            return convertView;
        }
    }

    public /* bridge */ /* synthetic */ void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public /* bridge */ /* synthetic */ void onStop() {
        super.onStop();
    }

    protected void onUpdateOrientation(int orientation) {
    }

    protected void onUpdateStyle(boolean dayStyle) {
    }

    protected View onCreateContentView(LayoutInflater inflater) {
        View rootView = inflater.inflate(C0965R.layout.fragment_chat, null);
        rootView.setOnClickListener(null);
        m9391a(rootView);
        if (this.mShowBundle != null) {
            this.f8046f = this.mShowBundle.getString("user_name");
            this.f8047g = this.mShowBundle.getString("show_name");
            this.f8048h = this.mShowBundle.getBoolean("no_disturb_flag");
        }
        m9393b();
        return rootView;
    }

    protected void onInitView() {
    }

    /* renamed from: a */
    public void mo1856a() {
        m9393b();
    }

    public void onResume() {
        super.onResume();
        C2398k.m9160a().m9176a((C2397b) this);
    }

    public void onPause() {
        super.onPause();
        C2398k.m9160a().m9183b((C2397b) this);
    }

    /* renamed from: b */
    private void m9393b() {
        this.f8043c.setText(this.f8047g);
        if (!this.f8048h) {
            this.f8043c.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            this.f8043c.setCompoundDrawablePadding(0);
        }
        this.f8049i.clear();
        this.f8049i.addAll(C2398k.m9160a().m9186c(this.f8046f));
        Collections.sort(this.f8049i, new C24621(this));
        this.f8045e.notifyDataSetChanged();
        this.f8044d.setTranscriptMode(2);
        this.f8044d.setSelection(this.f8045e.getCount());
    }

    /* renamed from: a */
    private void m9391a(View rootView) {
        this.f8043c = (TextView) rootView.findViewById(C0965R.id.fragment_chat_title);
        this.f8042b = (ImageButton) rootView.findViewById(C0965R.id.fragment_chat_back);
        this.f8042b.setBackground(C2251b.m8527a(getActivity()));
        this.f8042b.setOnClickListener(new C24632(this));
        this.f8044d = (ListView) rootView.findViewById(C0965R.id.chat_listview);
        this.f8045e = new C2466a(this);
        this.f8044d.setAdapter(this.f8045e);
        this.f8044d.setOnItemClickListener(null);
        rootView.findViewById(C0965R.id.chat_btn_reply).setOnClickListener(new C24643(this));
    }
}
