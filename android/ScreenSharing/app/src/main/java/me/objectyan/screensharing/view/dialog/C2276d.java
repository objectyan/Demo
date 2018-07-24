package com.baidu.carlife.view.dialog;

import android.content.Context;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import com.baidu.carlife.R;
import com.baidu.carlife.adpter.HomePersonPanelAdapter;
import com.baidu.carlife.core.LogUtil;
import com.baidu.carlife.p078f.C1438c;
import com.baidu.carlife.p078f.C1440d;
import com.baidu.che.codriver.util.C2736p;
import com.baidu.navi.style.StyleManager;
import java.util.HashMap;

/* compiled from: CommonLeftListDialog */
/* renamed from: com.baidu.carlife.view.dialog.d */
public class C2276d extends BaseDialog {
    /* renamed from: e */
    private ListView f7447e;
    /* renamed from: f */
    private BaseAdapter f7448f;
    /* renamed from: g */
    private View f7449g;
    /* renamed from: h */
    private boolean f7450h = false;
    /* renamed from: i */
    private C1438c f7451i;
    /* renamed from: j */
    private HashMap<String, Integer> f7452j;

    /* compiled from: CommonLeftListDialog */
    /* renamed from: com.baidu.carlife.view.dialog.d$1 */
    class C22731 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ C2276d f7443a;

        C22731(C2276d this$0) {
            this.f7443a = this$0;
        }

        public void onClick(View view) {
        }
    }

    /* compiled from: CommonLeftListDialog */
    /* renamed from: com.baidu.carlife.view.dialog.d$3 */
    class C22753 implements OnKeyListener {
        /* renamed from: a */
        final /* synthetic */ C2276d f7446a;

        C22753(C2276d this$0) {
            this.f7446a = this$0;
        }

        public boolean onKey(View v, int keyCode, KeyEvent event) {
            if (event == null || event.getAction() != 0 || keyCode != 22) {
                return false;
            }
            this.f7446a.mo1526d();
            return true;
        }
    }

    public C2276d(Context activity, BaseAdapter menuAdapter, OnItemClickListener onItemClickListener) {
        super(activity);
        this.f7448f = menuAdapter;
        this.f7447e.setOnItemClickListener(onItemClickListener);
        this.f7447e.setAdapter(this.f7448f);
        setCanceledOnTouchOutside(true);
        m8607k();
    }

    /* renamed from: a */
    protected View mo1528a() {
        View contentView = LayoutInflater.from(this.c).inflate(R.layout.common_dialog_left_list, null);
        contentView.setOnClickListener(new C22731(this));
        return contentView;
    }

    protected int getCustomWidth() {
        return this.c.getResources().getDimensionPixelSize(R.dimen.common_menu_left_width);
    }

    /* renamed from: b */
    protected void mo1529b() {
        this.f7447e = (ListView) findViewById(R.id.lv_menu);
        this.f7447e.setOverScrollMode(2);
        if (this.f7449g != null) {
            this.f7447e.addFooterView(this.f7449g, null, false);
        }
        if (this.f7450h) {
            this.f7447e.setDivider(null);
        }
    }

    /* renamed from: k */
    private void m8607k() {
        this.f7452j = new HashMap();
        this.f7452j.put(C2736p.f8996z, Integer.valueOf(1));
        this.f7452j.put(C2736p.f8966A, Integer.valueOf(2));
        this.f7452j.put(C2736p.f8967B, Integer.valueOf(3));
        this.f7452j.put(C2736p.f8968C, Integer.valueOf(4));
        this.f7452j.put(C2736p.f8969D, Integer.valueOf(6));
    }

    public void setSelected(int selectedPos) {
        if (this.f7448f instanceof HomePersonPanelAdapter) {
            ((HomePersonPanelAdapter) this.f7448f).m3190a(selectedPos);
            this.f7448f.notifyDataSetChanged();
        }
    }

    /* renamed from: i */
    public void mo1630i() {
        if (this.f7448f != null) {
            this.f7448f.notifyDataSetChanged();
        }
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        if (this.f7447e != null) {
            this.f7447e.setOnItemClickListener(onItemClickListener);
        }
    }

    /* renamed from: a */
    public void m8609a(final int selectedPos) {
        if (this.f7447e != null) {
            this.f7447e.post(new Runnable(this) {
                /* renamed from: b */
                final /* synthetic */ C2276d f7445b;

                public void run() {
                    this.f7445b.f7447e.setSelection(selectedPos > 0 ? selectedPos - 1 : selectedPos);
                }
            });
        }
    }

    /* renamed from: a */
    public void m8610a(View view) {
        this.f7449g = view;
    }

    /* renamed from: j */
    public void m8618j() {
        this.f7450h = true;
    }

    /* renamed from: f */
    public void mo1530f() {
        if (this.f7451i == null) {
            this.f7451i = new C1438c(this.f7447e, 9);
            this.f7451i.m5249a(new C22753(this));
            this.f7451i.m5244a(true);
        }
        C1440d.m5251a().m5253a(this.f7451i);
    }

    /* renamed from: g */
    public void mo1527g() {
        C1440d.m5251a().m5263e();
    }

    /* renamed from: a */
    public boolean mo1802a(String strCommand) {
        String[] items = StyleManager.getStringArray(R.array.person_ctrl_menu_item);
        int nIndex = -1;
        for (int i = 0; i < items.length; i++) {
            if (items[i].equals(strCommand)) {
                nIndex = i;
                break;
            }
        }
        LogUtil.d("BaseDialog", "person dialog onVoiceCommand: " + nIndex);
        if (nIndex != -1) {
            nIndex++;
        } else {
            LogUtil.d("BaseDialog", "check login command: " + strCommand);
            if (strCommand.contains("登录帐号")) {
                nIndex = 0;
                LogUtil.d("BaseDialog", "person dialog item index: " + 0);
            }
        }
        if (nIndex != -1) {
            OnItemClickListener onItemClickListener = this.f7447e.getOnItemClickListener();
            if (onItemClickListener != null) {
                onItemClickListener.onItemClick(this.f7447e, null, nIndex, 0);
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public boolean m8612a(String strCommand, String strIntent) {
        OnItemClickListener onItemClickListener = this.f7447e.getOnItemClickListener();
        if (onItemClickListener == null) {
            return false;
        }
        int nIndex = m8613b(strIntent);
        LogUtil.d("BaseDialog", "List click index: " + nIndex);
        if (nIndex == -1) {
            return false;
        }
        onItemClickListener.onItemClick(this.f7447e, null, nIndex, 0);
        return true;
    }

    /* renamed from: b */
    public int m8613b(String voiceCommand) {
        if (voiceCommand.equals("login")) {
            return 0;
        }
        Integer musicIndex = (Integer) this.f7452j.get(voiceCommand);
        return musicIndex == null ? -1 : musicIndex.intValue();
    }
}
