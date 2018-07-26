package com.baidu.carlife.custom.elhyf.mydvr;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.baidu.carlife.C0965R;
import com.baidu.carlife.core.screen.C0672b;
import com.baidu.carlife.core.screen.presentation.p071a.C1309g;
import com.baidu.carlife.custom.elhyf.mydvr.C1398a.C1382a;
import com.baidu.carlife.custom.elhyf.mydvr.C1400b.C1399a;
import com.baidu.carlife.custom.elhyf.mydvr.C1402c.C1401a;
import com.baidu.carlife.custom.elhyf.p072a.C1351b;
import com.baidu.carlife.custom.elhyf.p072a.C1351b.C1349b;
import com.baidu.carlife.custom.elhyf.p072a.C1351b.C1350c;
import com.baidu.carlife.view.dialog.C1953c;
import com.baidu.navi.fragment.ContentFragment;
import java.util.ArrayList;

public class MyDvrFragment extends ContentFragment {
    /* renamed from: a */
    private static final String f4072a = "video";
    /* renamed from: b */
    private static final String f4073b = "photo";
    /* renamed from: c */
    private ImageButton f4074c;
    /* renamed from: d */
    private TextView f4075d;
    /* renamed from: e */
    private TextView f4076e;
    /* renamed from: f */
    private View f4077f;
    /* renamed from: g */
    private View f4078g;
    /* renamed from: h */
    private TextView f4079h;
    /* renamed from: i */
    private TextView f4080i;
    /* renamed from: j */
    private ListView f4081j;
    /* renamed from: k */
    private ListView f4082k;
    /* renamed from: l */
    private C1394a f4083l;
    /* renamed from: m */
    private C1394a f4084m;
    /* renamed from: n */
    private ArrayList<C1400b> f4085n;
    /* renamed from: o */
    private ArrayList<C1400b> f4086o;
    /* renamed from: p */
    private C1953c f4087p = null;
    /* renamed from: q */
    private C1351b f4088q = null;

    /* renamed from: com.baidu.carlife.custom.elhyf.mydvr.MyDvrFragment$1 */
    class C13831 implements C1382a {
        /* renamed from: a */
        final /* synthetic */ MyDvrFragment f4051a;

        C13831(MyDvrFragment this$0) {
            this.f4051a = this$0;
        }

        /* renamed from: a */
        public void mo1543a(ArrayList<C1400b> arrayList) {
            if (this.f4051a.f4083l != null) {
                this.f4051a.f4083l.notifyDataSetChanged();
                if (this.f4051a.f4085n.size() == 0) {
                    this.f4051a.f4079h.setVisibility(0);
                } else {
                    this.f4051a.f4079h.setVisibility(8);
                }
            }
        }

        /* renamed from: b */
        public void mo1544b(ArrayList<C1400b> arrayList) {
            if (this.f4051a.f4084m != null) {
                this.f4051a.f4084m.notifyDataSetChanged();
                if (this.f4051a.f4086o.size() == 0) {
                    this.f4051a.f4080i.setVisibility(0);
                } else {
                    this.f4051a.f4080i.setVisibility(8);
                }
            }
        }
    }

    /* renamed from: com.baidu.carlife.custom.elhyf.mydvr.MyDvrFragment$2 */
    class C13842 implements OnItemClickListener {
        /* renamed from: a */
        final /* synthetic */ MyDvrFragment f4052a;

        C13842(MyDvrFragment this$0) {
            this.f4052a = this$0;
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
            C1398a.m5125a().m5155b(this.f4052a.getActivity(), ((C1400b) this.f4052a.f4085n.get(position)).m5170e());
        }
    }

    /* renamed from: com.baidu.carlife.custom.elhyf.mydvr.MyDvrFragment$3 */
    class C13853 implements OnItemClickListener {
        /* renamed from: a */
        final /* synthetic */ MyDvrFragment f4053a;

        C13853(MyDvrFragment this$0) {
            this.f4053a = this$0;
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
            C1398a.m5125a().m5151a(this.f4053a.getActivity(), ((C1400b) this.f4053a.f4086o.get(position)).m5170e());
        }
    }

    /* renamed from: com.baidu.carlife.custom.elhyf.mydvr.MyDvrFragment$4 */
    class C13864 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ MyDvrFragment f4054a;

        C13864(MyDvrFragment this$0) {
            this.f4054a = this$0;
        }

        public void onClick(View v) {
            this.f4054a.getNaviFragmentManager().back();
        }
    }

    /* renamed from: com.baidu.carlife.custom.elhyf.mydvr.MyDvrFragment$5 */
    class C13875 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ MyDvrFragment f4055a;

        C13875(MyDvrFragment this$0) {
            this.f4055a = this$0;
        }

        public void onClick(View v) {
            this.f4055a.m5115d();
        }
    }

    /* renamed from: com.baidu.carlife.custom.elhyf.mydvr.MyDvrFragment$6 */
    class C13886 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ MyDvrFragment f4056a;

        C13886(MyDvrFragment this$0) {
            this.f4056a = this$0;
        }

        public void onClick(View v) {
            this.f4056a.m5117e();
        }
    }

    /* renamed from: com.baidu.carlife.custom.elhyf.mydvr.MyDvrFragment$a */
    private class C1394a extends BaseAdapter {
        /* renamed from: a */
        final /* synthetic */ MyDvrFragment f4068a;
        /* renamed from: b */
        private ArrayList<C1400b> f4069b;
        /* renamed from: c */
        private Context f4070c;
        /* renamed from: d */
        private String f4071d;

        public /* synthetic */ Object getItem(int i) {
            return m5103a(i);
        }

        public C1394a(MyDvrFragment myDvrFragment, Context context, ArrayList<C1400b> list, String adapterType) {
            this.f4068a = myDvrFragment;
            this.f4070c = context;
            this.f4069b = list;
            this.f4071d = adapterType;
        }

        public int getCount() {
            return this.f4069b.size();
        }

        /* renamed from: a */
        public C1400b m5103a(int position) {
            return null;
        }

        public long getItemId(int position) {
            return 0;
        }

        public View getView(final int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = View.inflate(this.f4070c, C0965R.layout.frag_home_my_mydvr_item, null);
            }
            ImageView ivThumbnail = (ImageView) convertView.findViewById(C0965R.id.iv_thumbnail);
            TextView tvHour = (TextView) convertView.findViewById(C0965R.id.tv_hour);
            TextView tvDate = (TextView) convertView.findViewById(C0965R.id.tv_date);
            Button btnDel = (Button) convertView.findViewById(C0965R.id.btn_del);
            Button btnShare = (Button) convertView.findViewById(C0965R.id.btn_share);
            ImageView ivCameraType = (ImageView) convertView.findViewById(C0965R.id.iv_camera_type);
            TextView tvSize = (TextView) convertView.findViewById(C0965R.id.tv_size);
            C1400b receivedFileSpeech = (C1400b) this.f4069b.get(position);
            if (receivedFileSpeech != null) {
                if (receivedFileSpeech.m5160a() != null) {
                    ivThumbnail.setImageBitmap(receivedFileSpeech.m5160a());
                } else if (MyDvrFragment.f4073b.equals(this.f4071d)) {
                    ivThumbnail.setImageResource(C0965R.mipmap.mydvr_picture);
                    btnShare.setVisibility(0);
                } else {
                    ivThumbnail.setImageResource(C0965R.mipmap.mydvr_video);
                    btnShare.setVisibility(8);
                }
                tvHour.setText(receivedFileSpeech.m5172f());
                tvDate.setText(receivedFileSpeech.m5166c());
                if (receivedFileSpeech.m5173g() == C1399a.Back_Camera) {
                    ivCameraType.setImageResource(C0965R.mipmap.mydvr_dvr_back);
                } else {
                    ivCameraType.setImageResource(C0965R.mipmap.mydvr_dvr_front);
                }
                tvSize.setText(receivedFileSpeech.m5168d() + "MB");
            }
            btnDel.setOnClickListener(new OnClickListener(this) {
                /* renamed from: b */
                final /* synthetic */ C1394a f4065b;

                public void onClick(View v) {
                    this.f4065b.f4068a.m5109a((C1400b) this.f4065b.f4069b.get(position), this.f4065b.f4071d);
                }
            });
            btnShare.setOnClickListener(new OnClickListener(this) {
                /* renamed from: b */
                final /* synthetic */ C1394a f4067b;

                public void onClick(View view) {
                    this.f4067b.f4068a.m5108a((C1400b) this.f4067b.f4069b.get(position));
                }
            });
            return convertView;
        }
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        m5105a();
    }

    /* renamed from: a */
    private void m5105a() {
        C1398a.m5125a().m5152a(new C13831(this));
    }

    protected View onCreateContentView(LayoutInflater inflater) {
        View contentView = inflater.inflate(C0965R.layout.frag_home_my_mydvr, null);
        setCommonTitleBar(contentView, getString(C0965R.string.home_my_mydvr));
        return contentView;
    }

    protected void onInitView() {
        m5111b();
        m5113c();
        this.f4085n = C1398a.m5125a().m5154b();
        if (this.f4083l == null) {
            if (this.f4085n.size() == 0) {
                this.f4079h.setVisibility(0);
            } else {
                this.f4079h.setVisibility(8);
            }
        }
        this.f4083l = new C1394a(this, getActivity(), this.f4085n, f4072a);
        this.f4081j.setAdapter(this.f4083l);
        this.f4081j.setOnItemClickListener(new C13842(this));
        this.f4086o = C1398a.m5125a().m5158c();
        this.f4084m = new C1394a(this, getActivity(), this.f4086o, f4073b);
        this.f4082k.setAdapter(this.f4084m);
        this.f4082k.setOnItemClickListener(new C13853(this));
    }

    /* renamed from: b */
    private void m5111b() {
        this.f4074c = (ImageButton) this.mContentView.findViewById(C0965R.id.ib_left);
        this.f4075d = (TextView) this.mContentView.findViewById(C0965R.id.tv_video);
        this.f4076e = (TextView) this.mContentView.findViewById(C0965R.id.tv_photo);
        this.f4079h = (TextView) this.mContentView.findViewById(C0965R.id.tv_no_video);
        this.f4080i = (TextView) this.mContentView.findViewById(C0965R.id.tv_no_photo);
        this.f4077f = this.mContentView.findViewById(C0965R.id.view_video_bottom_line);
        this.f4078g = this.mContentView.findViewById(C0965R.id.view_photo_bottom_line);
        this.f4081j = (ListView) this.mContentView.findViewById(C0965R.id.lv_mydvr_video);
        this.f4082k = (ListView) this.mContentView.findViewById(C0965R.id.lv_mydvr_photo);
    }

    /* renamed from: c */
    private void m5113c() {
        this.f4074c.setOnClickListener(new C13864(this));
        this.f4075d.setOnClickListener(new C13875(this));
        this.f4076e.setOnClickListener(new C13886(this));
    }

    /* renamed from: d */
    private void m5115d() {
        this.f4075d.setTextColor(getActivity().getResources().getColor(C0965R.color.mydvr_contact_title_selected));
        this.f4077f.setVisibility(0);
        this.f4081j.setVisibility(0);
        this.f4076e.setTextColor(getActivity().getResources().getColor(C0965R.color.mydvr_contact_title_not_selected));
        this.f4078g.setVisibility(8);
        this.f4082k.setVisibility(8);
        if (this.f4085n.size() == 0) {
            this.f4079h.setVisibility(0);
        } else {
            this.f4079h.setVisibility(8);
        }
        this.f4080i.setVisibility(8);
    }

    /* renamed from: e */
    private void m5117e() {
        this.f4076e.setTextColor(getActivity().getResources().getColor(C0965R.color.mydvr_contact_title_selected));
        this.f4078g.setVisibility(0);
        this.f4082k.setVisibility(0);
        this.f4075d.setTextColor(getActivity().getResources().getColor(C0965R.color.mydvr_contact_title_not_selected));
        this.f4077f.setVisibility(8);
        this.f4081j.setVisibility(8);
        if (this.f4086o.size() == 0) {
            this.f4080i.setVisibility(0);
        } else {
            this.f4080i.setVisibility(8);
        }
        this.f4079h.setVisibility(8);
    }

    protected void onUpdateOrientation(int orientation) {
    }

    protected void onUpdateStyle(boolean dayStyle) {
    }

    protected void onUpdateSkin() {
        super.onUpdateSkin();
        updateCommonSkin();
    }

    /* renamed from: a */
    private void m5109a(final C1400b receivedFileSpeech, final String adapterType) {
        if (this.f4087p == null) {
            this.f4087p = new C1953c(getActivity()).m7442b((int) C0965R.string.home_my_mydvr_dialog_title).m7457g(17).m7447c((int) C0965R.string.alert_confirm).m7458q().m7450d((int) C0965R.string.alert_cancel);
        }
        this.f4087p.m7438a(new C0672b(this) {
            /* renamed from: c */
            final /* synthetic */ MyDvrFragment f4059c;

            public void onClick() {
                if (MyDvrFragment.f4073b.equals(adapterType)) {
                    C1398a.m5125a().m5157b(receivedFileSpeech);
                } else {
                    C1398a.m5125a().m5153a(receivedFileSpeech);
                }
            }
        });
        if (this.f4087p.isShown()) {
            this.f4087p.mo1526d();
        }
        if (f4073b.equals(adapterType)) {
            this.f4087p.m7444b(getString(C0965R.string.home_my_mydvr_dialog_content_photo));
        } else {
            this.f4087p.m7444b(getString(C0965R.string.home_my_mydvr_dialog_content_video));
        }
        C1309g.m4699a().m4701b().showDialog(this.f4087p);
    }

    /* renamed from: a */
    private void m5108a(final C1400b receivedFileSpeech) {
        if (this.f4088q == null) {
            this.f4088q = new C1351b(getActivity());
        }
        this.f4088q.m4954a(new C1349b(this) {
            /* renamed from: b */
            final /* synthetic */ MyDvrFragment f4061b;

            /* renamed from: a */
            public void mo1545a() {
                C1402c.m5174a().m5182a(receivedFileSpeech.m5170e(), C1401a.WXSCENE_SESSION);
            }
        });
        this.f4088q.m4955a(new C1350c(this) {
            /* renamed from: b */
            final /* synthetic */ MyDvrFragment f4063b;

            /* renamed from: a */
            public void mo1546a() {
                C1402c.m5174a().m5182a(receivedFileSpeech.m5170e(), C1401a.WXSCENE_TIMELINE);
            }
        });
        if (this.f4088q.isShown()) {
            this.f4088q.mo1526d();
        }
        C1309g.m4699a().m4701b().showDialog(this.f4088q);
    }
}
