package com.baidu.carlife.view.dialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.carlife.C0965R;
import com.baidu.navi.style.StyleManager;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.ui.util.BNStyleManager;

/* compiled from: FavoriteListDialog */
/* renamed from: com.baidu.carlife.view.dialog.h */
public class C2288h extends C2287n {
    /* renamed from: e */
    public static final int f7490e = 1;
    /* renamed from: f */
    public static final int f7491f = 2;
    /* renamed from: g */
    public static final int f7492g = 3;
    /* renamed from: h */
    public static final int f7493h = 4;
    /* renamed from: j */
    private String[] f7494j;
    /* renamed from: k */
    private C1464a f7495k;
    /* renamed from: l */
    private int f7496l;
    /* renamed from: m */
    private int f7497m;
    /* renamed from: n */
    private String[] f7498n = new String[]{"重命名", "添加到“我要去”", "取消收藏", "关闭"};
    /* renamed from: o */
    private String[] f7499o = new String[]{"重命名", "从“我要去”移除", "取消收藏", "关闭"};
    /* renamed from: p */
    private String[] f7500p = new String[]{"更改地址", "关闭"};
    /* renamed from: q */
    private String[] f7501q = new String[]{"拍照", "从相册选择", "关闭"};

    /* compiled from: FavoriteListDialog */
    /* renamed from: com.baidu.carlife.view.dialog.h$a */
    public interface C1464a {
        /* renamed from: a */
        void mo1555a(int i);

        /* renamed from: b */
        void mo1556b(int i);

        /* renamed from: c */
        void mo1557c(int i);

        /* renamed from: d */
        void mo1558d(int i);

        /* renamed from: e */
        void mo1559e(int i);
    }

    /* compiled from: FavoriteListDialog */
    /* renamed from: com.baidu.carlife.view.dialog.h$1 */
    class C22841 implements OnItemClickListener {
        /* renamed from: a */
        final /* synthetic */ C2288h f7472a;

        C22841(C2288h this$0) {
            this.f7472a = this$0;
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
            switch (this.f7472a.f7497m) {
                case 1:
                    if (this.f7472a.f7495k != null) {
                        if (position != 0) {
                            if (position != 1) {
                                if (position == 2) {
                                    this.f7472a.f7495k.mo1558d(this.f7472a.f7496l);
                                    break;
                                }
                            }
                            this.f7472a.f7495k.mo1556b(this.f7472a.f7496l);
                            break;
                        }
                        this.f7472a.f7495k.mo1555a(this.f7472a.f7496l);
                        break;
                    }
                    break;
                case 2:
                    if (this.f7472a.f7495k != null) {
                        if (position != 0) {
                            if (position != 1) {
                                if (position == 2) {
                                    this.f7472a.f7495k.mo1558d(this.f7472a.f7496l);
                                    break;
                                }
                            }
                            this.f7472a.f7495k.mo1557c(this.f7472a.f7496l);
                            break;
                        }
                        this.f7472a.f7495k.mo1555a(this.f7472a.f7496l);
                        break;
                    }
                    break;
                case 3:
                    if (this.f7472a.f7495k != null && position == 0) {
                        this.f7472a.f7495k.mo1559e(this.f7472a.f7496l);
                        break;
                    }
                case 4:
                    if (this.f7472a.f7495k != null) {
                        if (position != 0) {
                            if (position == 1) {
                                this.f7472a.f7495k.mo1559e(position);
                                break;
                            }
                        }
                        this.f7472a.f7495k.mo1559e(position);
                        break;
                    }
                    break;
            }
            this.f7472a.mo1526d();
        }
    }

    /* compiled from: FavoriteListDialog */
    /* renamed from: com.baidu.carlife.view.dialog.h$b */
    private class C2285b extends BaseAdapter {
        /* renamed from: a */
        final /* synthetic */ C2288h f7473a;
        /* renamed from: b */
        private String[] f7474b;

        public C2285b(C2288h c2288h, String[] dataList) {
            this.f7473a = c2288h;
            this.f7474b = dataList;
        }

        public int getCount() {
            if (this.f7474b == null || this.f7474b.length <= 0) {
                return 0;
            }
            return this.f7474b.length;
        }

        public Object getItem(int position) {
            if (this.f7474b == null || position < 0 || position >= this.f7474b.length) {
                return null;
            }
            return this.f7474b[position];
        }

        public long getItemId(int position) {
            return (long) position;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            TextView textView;
            if (convertView == null) {
                convertView = LayoutInflater.from(this.f7473a.getContext()).inflate(C0965R.layout.favorite_list_dialog_item, null);
                textView = (TextView) convertView.findViewById(C0965R.id.text_view);
                convertView.setTag(textView);
            } else {
                textView = (TextView) convertView.getTag();
            }
            textView.setText(this.f7474b[position]);
            switch (position) {
                case 0:
                    textView.setTextColor(StyleManager.getColor(C0965R.color.navi_dialog_high_light));
                    textView.setBackgroundDrawable(BNStyleManager.getDrawable(C4048R.drawable.nsdk_drawable_common_dialog_top));
                    break;
                case 1:
                    textView.setTextColor(StyleManager.getColor(C0965R.color.navi_dialog_high_light));
                    textView.setBackgroundDrawable(BNStyleManager.getDrawable(C4048R.drawable.nsdk_common_dialog_middle));
                    break;
                case 2:
                    textView.setTextColor(BNStyleManager.getColor(C4048R.color.nsdk_string_rg_comment_dialog_title));
                    textView.setBackgroundDrawable(BNStyleManager.getDrawable(C4048R.drawable.nsdk_common_dialog_chang));
                    break;
            }
            return convertView;
        }
    }

    public C2288h(Context context, int type, int pos, C1464a listener) {
        super(context);
        this.f7501q = context.getResources().getStringArray(C0965R.array.feedback_image);
        this.f7495k = listener;
        this.f7497m = type;
        this.f7496l = pos;
        m8705m();
        m8704l();
    }

    /* renamed from: l */
    private void m8704l() {
        m8670a((ListAdapter) new C2285b(this, this.f7494j));
        m8669a(new C22841(this));
    }

    /* renamed from: m */
    private void m8705m() {
        switch (this.f7497m) {
            case 1:
                this.f7494j = this.f7498n;
                return;
            case 2:
                this.f7494j = this.f7499o;
                return;
            case 3:
                this.f7494j = this.f7500p;
                return;
            case 4:
                this.f7494j = this.f7501q;
                return;
            default:
                return;
        }
    }

    public void setPoisition(int pos) {
        this.f7496l = pos;
    }

    /* renamed from: f */
    public void mo1530f() {
    }
}
