package com.baidu.carlife.view.dialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.baidu.carlife.R;
import com.baidu.carlife.p078f.C1438c;
import com.baidu.carlife.p078f.C1440d;
import com.baidu.carlife.p078f.C1443g;
import com.baidu.che.codriver.sdk.p081a.C2602k.C1981b;
import com.baidu.navisdk.ui.ugc.model.BNRCEventDetailsModel;
import com.baidu.navisdk.util.common.StorageOptions;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: SdcardSelectListDialog */
/* renamed from: com.baidu.carlife.view.dialog.q */
public class C2308q extends BaseDialog {
    /* renamed from: e */
    private TextView f7567e;
    /* renamed from: f */
    private TextView f7568f;
    /* renamed from: g */
    private ListView f7569g;
    /* renamed from: h */
    private TextView f7570h;
    /* renamed from: i */
    private C1518a f7571i;
    /* renamed from: j */
    private int f7572j = 0;
    /* renamed from: k */
    private int f7573k = -1;
    /* renamed from: l */
    private C1438c f7574l;
    /* renamed from: m */
    private C1443g f7575m;

    /* compiled from: SdcardSelectListDialog */
    /* renamed from: com.baidu.carlife.view.dialog.q$a */
    public interface C1518a {
        /* renamed from: a */
        void mo1574a();
    }

    /* compiled from: SdcardSelectListDialog */
    /* renamed from: com.baidu.carlife.view.dialog.q$1 */
    class C23061 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ C2308q f7564a;

        C23061(C2308q this$0) {
            this.f7564a = this$0;
        }

        public void onClick(View v) {
            if (this.f7564a.f7571i != null) {
                this.f7564a.f7571i.mo1574a();
            }
        }
    }

    /* compiled from: SdcardSelectListDialog */
    /* renamed from: com.baidu.carlife.view.dialog.q$b */
    public class C2307b extends BaseAdapter {
        /* renamed from: a */
        final /* synthetic */ C2308q f7565a;
        /* renamed from: b */
        private ArrayList<HashMap<String, Object>> f7566b = new ArrayList();

        public C2307b(C2308q this$0, ArrayList<HashMap<String, Object>> mDataList) {
            this.f7565a = this$0;
            for (int i = 0; i < mDataList.size(); i++) {
                this.f7566b.add(mDataList.get(i));
            }
        }

        public int getCount() {
            if (this.f7566b == null || this.f7566b.size() <= 0) {
                return 0;
            }
            return this.f7566b.size();
        }

        public Object getItem(int position) {
            if (this.f7566b == null || position < 0 || position >= this.f7566b.size()) {
                return null;
            }
            return this.f7566b.get(position);
        }

        public long getItemId(int position) {
            return (long) position;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            convertView = LayoutInflater.from(this.f7565a.getContext()).inflate(R.layout.sdcard_selection_item, null);
            ImageView imageView = (ImageView) convertView.findViewById(R.id.imageview_storage);
            TextView textView01 = (TextView) convertView.findViewById(R.id.TextView01);
            TextView textView02 = (TextView) convertView.findViewById(R.id.TextView02);
            CheckBox checkBox = (CheckBox) convertView.findViewById(R.id.CheckBox1);
            checkBox.setChecked(false);
            if (this.f7566b != null && position >= 0 && position < this.f7566b.size()) {
                String sdcard = (String) ((HashMap) this.f7566b.get(position)).get(BNRCEventDetailsModel.BN_RC_KEY_LABEL);
                textView01.setText(sdcard);
                textView02.setText((String) ((HashMap) this.f7566b.get(position)).get(C1981b.f6362b));
                Boolean check = (Boolean) ((HashMap) this.f7566b.get(position)).get("check");
                if (this.f7565a.f7572j < 2) {
                    checkBox.setButtonDrawable(check.booleanValue() ? R.drawable.bnav_common_check_box_checked : R.drawable.bnav_common_check_box_unchecked);
                }
                if (this.f7565a.f7572j < 2 && check.booleanValue()) {
                    this.f7565a.setmCheckedPosition(position);
                }
                if (StorageOptions.INTERNAL_STORAGE.equals(sdcard)) {
                    imageView.setImageResource(R.drawable.bnav_sdcard_choose_sdcard0);
                } else {
                    imageView.setImageResource(R.drawable.bnav_sdcard_choose_sdcard1);
                }
            }
            return convertView;
        }
    }

    public C2308q(Context context, ArrayList<HashMap<String, Object>> dataList) {
        super(context);
        String sdcard = null;
        for (int i = 0; i < dataList.size(); i++) {
            if (((Boolean) ((HashMap) dataList.get(i)).get("check")).booleanValue()) {
                sdcard = (String) ((HashMap) dataList.get(i)).get(BNRCEventDetailsModel.BN_RC_KEY_LABEL);
                this.f7572j++;
            }
        }
        if (this.f7572j == 0) {
            this.f7568f.setText(R.string.muti_sdcard_choose_alert);
        } else if (this.f7572j == 2) {
            this.f7568f.setText(R.string.muti_sdcard_choose_alert_sdcard0_1);
        } else if (this.f7572j == 1) {
            if (StorageOptions.INTERNAL_STORAGE.equals(sdcard)) {
                this.f7568f.setText(R.string.muti_sdcard_choose_alert_sdcard0);
            } else {
                this.f7568f.setText(R.string.muti_sdcard_choose_alert_sdcard1);
            }
        }
        this.f7569g.setAdapter(new C2307b(this, dataList));
    }

    /* renamed from: a */
    protected View mo1528a() {
        return LayoutInflater.from(this.c).inflate(R.layout.sdcard_selection_layout, null);
    }

    /* renamed from: b */
    protected void mo1529b() {
        this.f7567e = (TextView) findViewById(R.id.title_bar);
        this.f7568f = (TextView) findViewById(R.id.title_detail);
        this.f7569g = (ListView) findViewById(R.id.listView1);
        this.f7569g.setSelector(R.drawable.bnav_common_bg_pressed_mask_selector);
        this.f7570h = (TextView) findViewById(R.id.ok_btn);
        this.f7570h.setOnClickListener(new C23061(this));
    }

    /* renamed from: a */
    public C2308q m8784a(C1518a listener) {
        this.f7571i = listener;
        return this;
    }

    public ListView getListView() {
        return this.f7569g;
    }

    /* renamed from: i */
    public void mo1630i() {
        this.f7572j = 0;
    }

    public int getmCheckedPosition() {
        return this.f7573k;
    }

    public void setmCheckedPosition(int mCheckedPosition) {
        this.f7573k = mCheckedPosition;
    }

    /* renamed from: f */
    public void mo1530f() {
        if (this.f7575m == null) {
            this.f7575m = new C1443g(this.f7570h, 11);
            this.f7575m.m5300d(this.f7570h);
        }
        if (this.f7574l == null) {
            this.f7574l = new C1438c(this.f7569g, 9);
        }
        this.f7575m.m5244a(true);
        this.f7574l.m5244a(true);
        C1440d.m5251a().m5253a(this.f7575m, this.f7574l);
    }

    /* renamed from: g */
    public void mo1527g() {
        C1440d.m5251a().m5263e();
    }
}
