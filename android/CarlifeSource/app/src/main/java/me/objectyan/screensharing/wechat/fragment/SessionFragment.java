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
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.carlife.C0965R;
import com.baidu.carlife.view.p104a.C2251b;
import com.baidu.carlife.wechat.p108b.C2375a;
import com.baidu.carlife.wechat.p108b.C2398k;
import com.baidu.carlife.wechat.p108b.C2398k.C2397b;
import com.baidu.carlife.wechat.p110e.C2436c;
import com.baidu.carlife.wechat.p113g.C2499c;
import com.baidu.navi.fragment.NaviFragmentManager;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SessionFragment extends C2461a implements C2397b {
    /* renamed from: b */
    private ListView f8076b;
    /* renamed from: c */
    private TextView f8077c;
    /* renamed from: d */
    private ImageButton f8078d;
    /* renamed from: e */
    private C2479a f8079e;

    /* renamed from: com.baidu.carlife.wechat.fragment.SessionFragment$1 */
    class C24751 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ SessionFragment f8066a;

        C24751(SessionFragment this$0) {
            this.f8066a = this$0;
        }

        public void onClick(View v) {
            this.f8066a.back();
        }
    }

    /* renamed from: com.baidu.carlife.wechat.fragment.SessionFragment$2 */
    class C24762 implements OnItemClickListener {
        /* renamed from: a */
        final /* synthetic */ SessionFragment f8067a;

        C24762(SessionFragment this$0) {
            this.f8067a = this$0;
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
            boolean noDisturbFlag = false;
            C2375a chat = this.f8067a.f8079e.m9410a(position);
            if (chat != null) {
                Bundle bundle = new Bundle();
                bundle.putString("user_name", chat.m9045a().m9052a());
                bundle.putString("show_name", chat.m9045a().m9054b());
                if (chat.m9045a().m9066k() && chat.m9045a().m9061f() == 0) {
                    noDisturbFlag = true;
                }
                bundle.putBoolean("no_disturb_flag", noDisturbFlag);
                this.f8067a.showFragment(NaviFragmentManager.TYPE_WECHAT_CHAT, bundle);
                return;
            }
            Toast.makeText(this.f8067a.getActivity(), "聊天数据出错", 0).show();
        }
    }

    /* renamed from: com.baidu.carlife.wechat.fragment.SessionFragment$a */
    private class C2479a extends BaseAdapter {
        /* renamed from: a */
        final /* synthetic */ SessionFragment f8073a;
        /* renamed from: b */
        private List<C2375a> f8074b = null;
        /* renamed from: c */
        private float f8075c = C2499c.m9502c();

        /* renamed from: com.baidu.carlife.wechat.fragment.SessionFragment$a$1 */
        class C24771 implements Comparator<C2375a> {
            /* renamed from: a */
            final /* synthetic */ C2479a f8068a;

            C24771(C2479a this$1) {
                this.f8068a = this$1;
            }

            public /* synthetic */ int compare(Object obj, Object obj2) {
                return m9409a((C2375a) obj, (C2375a) obj2);
            }

            /* renamed from: a */
            public int m9409a(C2375a lhs, C2375a rhs) {
                int result = lhs.m9049c() - rhs.m9049c();
                if (result != 0) {
                    return result;
                }
                if ((lhs.m9048b() > 0 && rhs.m9048b() > 0) || (lhs.m9048b() < 0 && rhs.m9048b() < 0)) {
                    return (int) (rhs.m9048b() - lhs.m9048b());
                }
                if (lhs.m9048b() > 0) {
                    return -1;
                }
                return 1;
            }
        }

        /* renamed from: com.baidu.carlife.wechat.fragment.SessionFragment$a$a */
        class C2478a {
            /* renamed from: a */
            public SimpleDraweeView f8069a;
            /* renamed from: b */
            public TextView f8070b;
            /* renamed from: c */
            public TextView f8071c;
            /* renamed from: d */
            final /* synthetic */ C2479a f8072d;

            C2478a(C2479a this$1) {
                this.f8072d = this$1;
            }
        }

        public /* synthetic */ Object getItem(int i) {
            return m9410a(i);
        }

        public C2479a(SessionFragment sessionFragment) {
            this.f8073a = sessionFragment;
        }

        /* renamed from: a */
        public void m9411a() {
            this.f8074b = C2398k.m9160a().m9185c();
            Collections.sort(this.f8074b, new C24771(this));
            notifyDataSetChanged();
        }

        public int getCount() {
            return this.f8074b == null ? 0 : this.f8074b.size();
        }

        /* renamed from: a */
        public C2375a m9410a(int position) {
            return this.f8074b == null ? null : (C2375a) this.f8074b.get(position);
        }

        public long getItemId(int position) {
            return (long) position;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            C2478a viewHolder;
            if (convertView == null) {
                viewHolder = new C2478a(this);
                convertView = LayoutInflater.from(this.f8073a.getContext()).inflate(C0965R.layout.list_item_session, parent, false);
                viewHolder.f8069a = (SimpleDraweeView) convertView.findViewById(C0965R.id.list_item_session_icon);
                viewHolder.f8071c = (TextView) convertView.findViewById(C0965R.id.list_item_session_name);
                viewHolder.f8070b = (TextView) convertView.findViewById(C0965R.id.list_item_session_count);
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (C2478a) convertView.getTag();
            }
            C2375a chat = m9410a(position);
            if (TextUtils.isEmpty(chat.m9045a().m9060e())) {
                viewHolder.f8069a.setImageResource(C0965R.mipmap.list_icon_user);
            } else {
                viewHolder.f8069a.setImageURI(C2436c.m9320i() + chat.m9045a().m9060e());
            }
            viewHolder.f8071c.setText(Html.fromHtml(chat.m9045a().m9054b()));
            int unreadCount = C2398k.m9160a().m9190d(chat.m9045a().m9052a());
            if (unreadCount > 0) {
                viewHolder.f8070b.setVisibility(0);
                LayoutParams lp = (LayoutParams) viewHolder.f8070b.getLayoutParams();
                if (unreadCount < 10) {
                    lp.width = (int) (18.0f * this.f8075c);
                } else {
                    lp.width = -2;
                }
                viewHolder.f8070b.setLayoutParams(lp);
                if (unreadCount > 99) {
                    viewHolder.f8070b.setText("...");
                } else {
                    viewHolder.f8070b.setText(String.valueOf(unreadCount));
                }
            } else {
                viewHolder.f8070b.setVisibility(8);
                viewHolder.f8070b.setText("");
            }
            if (chat.m9045a().m9066k() && chat.m9045a().m9061f() == 0) {
                viewHolder.f8071c.setCompoundDrawablesWithIntrinsicBounds(0, 0, C0965R.mipmap.wx_ic_contacts_disturb_on, 0);
                viewHolder.f8071c.setCompoundDrawablePadding((int) (8.0f * C2499c.m9502c()));
            } else {
                viewHolder.f8071c.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                viewHolder.f8071c.setCompoundDrawablePadding(0);
            }
            int bgColor = C0965R.drawable.com_bg_item_selector;
            if (chat.m9045a().m9067l()) {
                bgColor = C0965R.drawable.list_item_top_bg_selector;
            }
            convertView.setBackground(this.f8073a.getResources().getDrawable(bgColor));
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
        View rootView = inflater.inflate(C0965R.layout.fragment_session, null);
        rootView.setOnClickListener(null);
        m9413a(rootView);
        return rootView;
    }

    protected void onInitView() {
    }

    public void onResume() {
        super.onResume();
        C2398k.m9160a().m9176a((C2397b) this);
    }

    public void onPause() {
        super.onPause();
        C2398k.m9160a().m9183b((C2397b) this);
    }

    /* renamed from: a */
    public void mo1856a() {
        this.f8079e.m9411a();
    }

    /* renamed from: a */
    private void m9413a(View rootView) {
        this.f8078d = (ImageButton) rootView.findViewById(C0965R.id.fragment_session_back);
        this.f8078d.setBackground(C2251b.m8527a(getActivity()));
        this.f8078d.setOnClickListener(new C24751(this));
        this.f8076b = (ListView) rootView.findViewById(C0965R.id.session_listview);
        this.f8077c = (TextView) rootView.findViewById(C0965R.id.session_empty_view);
        this.f8076b.setEmptyView(this.f8077c);
        this.f8079e = new C2479a(this);
        this.f8076b.setAdapter(this.f8079e);
        this.f8076b.setOnItemClickListener(new C24762(this));
        this.f8079e.m9411a();
    }
}
