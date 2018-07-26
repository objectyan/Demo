package com.baidu.che.codriver.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnGroupExpandListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.carlife.C0965R;
import com.baidu.carlife.logic.codriver.adapter.AdapterDialog;
import com.baidu.carlife.model.C1942q;
import com.baidu.carlife.p078f.C1440d;
import com.baidu.carlife.p078f.C1443g;
import com.baidu.che.codriver.ui.p128b.C2674b;
import com.baidu.che.codriver.util.C2725h;
import com.baidu.che.codriver.util.C2736p;

/* compiled from: HelpDialog */
/* renamed from: com.baidu.che.codriver.ui.a */
public class C2660a extends AdapterDialog {
    /* renamed from: g */
    private ExpandableListView f8747g;
    /* renamed from: h */
    private C2642a f8748h;
    /* renamed from: i */
    private boolean f8749i;
    /* renamed from: j */
    private int f8750j = -1;
    /* renamed from: k */
    private int f8751k = -1;
    /* renamed from: l */
    private TextView f8752l;

    /* compiled from: HelpDialog */
    /* renamed from: com.baidu.che.codriver.ui.a$1 */
    class C26401 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ C2660a f8690a;

        C26401(C2660a this$0) {
            this.f8690a = this$0;
        }

        public void onClick(View v) {
            C2725h.m10214e("BaseDialog", "############## close help dialog !");
            this.f8690a.mo1526d();
            if (this.f8690a.f8749i) {
                C2674b.m9985b().m10043t();
            }
        }
    }

    /* compiled from: HelpDialog */
    /* renamed from: com.baidu.che.codriver.ui.a$2 */
    class C26412 implements OnGroupExpandListener {
        /* renamed from: a */
        final /* synthetic */ C2660a f8691a;

        C26412(C2660a this$0) {
            this.f8691a = this$0;
        }

        public void onGroupExpand(int groupPosition) {
            int count = this.f8691a.f8747g.getExpandableListAdapter().getGroupCount();
            for (int i = 0; i < count; i++) {
                if (groupPosition != i) {
                    this.f8691a.f8747g.collapseGroup(i);
                }
            }
        }
    }

    /* compiled from: HelpDialog */
    /* renamed from: com.baidu.che.codriver.ui.a$a */
    class C2642a extends BaseExpandableListAdapter {
        /* renamed from: a */
        String[] f8692a = new String[]{C2736p.f8976f, C1942q.f6153u, "随心听", C1942q.f6156x, "日历", "百科", "天气"};
        /* renamed from: b */
        String[] f8693b = new String[]{"“我要去首都机场”", "“我要听王菲的红豆”", "“我要听中国广播电台”", "“打电话给小度”", "“上周三是几号”", "“李白是谁”", "“今天的天气怎么样”"};
        /* renamed from: c */
        String[] f8694c = new String[]{"“火车站怎么走”\n“我要去深圳机场”\n“我要回公司”\n“我要回家”\n“去附近的加油站”", "“我要听王菲的红豆”\n“我要听李荣浩的歌”\n“我想听张磊的南山南”", "“我要听中国广播电台”\n“我要听儿童节目”\n“我要听逻辑思维”\n“我想听相声”", "“打电话给小度”\n“呼叫10086”", "“上周三是几号”\n“今年除夕是几号”\n“这周六是几号”", "“李白是谁”\n“世界上最高的山”\n“双鱼座是几月”", "“今天的天气怎么样”\n“深圳的天气”\n“今天空气质量怎么样”"};
        /* renamed from: d */
        final /* synthetic */ C2660a f8695d;

        public C2642a(C2660a this$0) {
            this.f8695d = this$0;
        }

        public void onGroupExpanded(int groupPosition) {
            this.f8695d.f8751k = -1;
            this.f8695d.f8750j = groupPosition;
            System.out.println("onGroupExpanded");
        }

        public void onGroupCollapsed(int groupPosition) {
            this.f8695d.f8750j = -1;
            this.f8695d.f8751k = groupPosition;
            System.out.println("onGroupCollapsed");
        }

        public Object getChild(int arg0, int arg1) {
            return null;
        }

        public long getChildId(int arg0, int arg1) {
            return 0;
        }

        public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
            convertView = LayoutInflater.from(this.f8695d.getContext()).inflate(C0965R.layout.help_page_child, null);
            C2644c mChildHolder = new C2644c(this.f8695d);
            mChildHolder.f8701a = (TextView) convertView.findViewById(C0965R.id.child_text);
            mChildHolder.f8701a.setText(this.f8694c[groupPosition]);
            return convertView;
        }

        public int getChildrenCount(int arg0) {
            return 1;
        }

        public Object getGroup(int arg0) {
            return Integer.valueOf(arg0);
        }

        public int getGroupCount() {
            return this.f8692a.length;
        }

        public long getGroupId(int arg0) {
            return (long) arg0;
        }

        public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
            C2643b mHolder;
            if (convertView == null) {
                convertView = LayoutInflater.from(this.f8695d.getContext()).inflate(C0965R.layout.help_page_group, null);
                mHolder = new C2643b(this.f8695d);
                mHolder.f8696a = (ImageView) convertView.findViewById(C0965R.id.divider);
                mHolder.f8697b = (TextView) convertView.findViewById(C0965R.id.group_text);
                mHolder.f8698c = (TextView) convertView.findViewById(C0965R.id.group_text_two);
                mHolder.f8699d = (ImageView) convertView.findViewById(C0965R.id.group_down);
                convertView.setTag(mHolder);
            } else {
                mHolder = (C2643b) convertView.getTag();
            }
            if (groupPosition == 0) {
                mHolder.f8696a.setVisibility(8);
            } else {
                mHolder.f8696a.setVisibility(0);
            }
            mHolder.f8697b.setText(this.f8692a[groupPosition].toString());
            mHolder.f8698c.setText(this.f8693b[groupPosition]);
            if (isExpanded) {
                mHolder.f8698c.setText("");
                mHolder.f8699d.setImageDrawable(this.f8695d.getResources().getDrawable(C0965R.drawable.com_ic_pullup));
            } else {
                mHolder.f8698c.setText(this.f8693b[groupPosition]);
                mHolder.f8699d.setImageDrawable(this.f8695d.getResources().getDrawable(C0965R.drawable.com_ic_dropdown));
            }
            return convertView;
        }

        public boolean hasStableIds() {
            return false;
        }

        public boolean isChildSelectable(int arg0, int arg1) {
            return false;
        }
    }

    /* compiled from: HelpDialog */
    /* renamed from: com.baidu.che.codriver.ui.a$b */
    class C2643b {
        /* renamed from: a */
        ImageView f8696a;
        /* renamed from: b */
        TextView f8697b;
        /* renamed from: c */
        TextView f8698c;
        /* renamed from: d */
        ImageView f8699d;
        /* renamed from: e */
        final /* synthetic */ C2660a f8700e;

        C2643b(C2660a this$0) {
            this.f8700e = this$0;
        }
    }

    /* compiled from: HelpDialog */
    /* renamed from: com.baidu.che.codriver.ui.a$c */
    class C2644c {
        /* renamed from: a */
        TextView f8701a;
        /* renamed from: b */
        final /* synthetic */ C2660a f8702b;

        C2644c(C2660a this$0) {
            this.f8702b = this$0;
        }
    }

    public C2660a(Context context) {
        super(context, null, C0965R.style.FullScreenDialog);
    }

    /* renamed from: a */
    protected void mo1923a(Bundle savedInstanceState) {
        mo1529b();
        m9958b("帮助");
    }

    protected int getLayoutId() {
        return C0965R.layout.layout_voice_help;
    }

    /* renamed from: b */
    protected void m9958b(String titleText) {
        TextView title = (TextView) findViewById(C0965R.id.title_text);
        LinearLayout linearLayout = (LinearLayout) findViewById(C0965R.id.layout_title);
        if (title != null) {
            title.setText(titleText);
        }
        if (linearLayout != null) {
            linearLayout.setOnClickListener(new C26401(this));
        }
    }

    /* renamed from: b */
    protected void mo1529b() {
        this.f8747g = (ExpandableListView) findViewById(C0965R.id.help_expendlistview);
        if (this.f8747g != null) {
            this.f8748h = new C2642a(this);
            this.f8747g.setAdapter(this.f8748h);
            this.f8747g.setOnGroupExpandListener(new C26412(this));
            this.f8752l = (TextView) findViewById(C0965R.id.help_title);
            this.f8752l.setText("通过\"小度小度\"唤醒之后，说出以下指令即可");
        }
    }

    /* renamed from: a */
    public void m9956a(boolean shouldWakeVoiceDialog) {
        this.f8749i = shouldWakeVoiceDialog;
        super.mo1630i();
    }

    /* renamed from: f */
    public void mo1530f() {
        C1443g focusViewGroup = new C1443g(this.e, 7);
        focusViewGroup.m5300d(m6344a((int) C0965R.id.btn_back));
        focusViewGroup.m5244a(true);
        C1440d.m5251a().m5253a(focusViewGroup);
        C1440d.m5251a().m5268h(focusViewGroup);
    }
}
