package com.baidu.carlife.adpter;

import android.app.Activity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.carlife.R;
import com.baidu.carlife.logic.p082b.C1502b;
import com.baidu.carlife.p083g.C1605a;
import com.baidu.carlife.p087l.CarlifeCoreSDK;
import com.baidu.carlife.util.C2186p;
import com.baidu.navi.style.StyleManager;
import com.baidu.navi.util.NaviAccountUtils;
import com.baidu.sapi2.shell.callback.SapiCallBack;
import com.baidu.sapi2.shell.response.GetPortraitResponse;
import com.baidu.sapi2.shell.response.SapiResponse;
import com.facebook.drawee.view.SimpleDraweeView;

/* compiled from: HomePersonPanelAdapter */
/* renamed from: com.baidu.carlife.adpter.g */
public class HomePersonPanelAdapter extends BaseAdapter {
    /* renamed from: a */
    public static final int f2504a = -1;
    /* renamed from: b */
    private String[] f2505b;
    /* renamed from: c */
    private Activity f2506c;
    /* renamed from: d */
    private LayoutInflater f2507d;
    /* renamed from: e */
    private String f2508e;
    /* renamed from: f */
    private int f2509f = -1;
    /* renamed from: g */
    private C1502b f2510g;

    public /* synthetic */ Object getItem(int i) {
        return m3194b(i);
    }

    public HomePersonPanelAdapter(Activity activity) {
        this.f2506c = activity;
        this.f2505b = StyleManager.getStringArray(R.array.person_ctrl_menu_item);
        this.f2507d = LayoutInflater.from(activity);
    }

    /* renamed from: a */
    public void m3190a(int selected) {
        this.f2509f = selected;
    }

    public int getCount() {
        return this.f2505b.length + 1;
    }

    public long getItemId(int position) {
        return (long) position;
    }

    /* renamed from: b */
    public String m3194b(int position) {
        if (position == 0) {
            return this.f2508e;
        }
        return this.f2505b[position - 1];
    }

    public View getView(int position, View convertView, ViewGroup root) {
        TextView textView;
        if (position == 0) {
            convertView = this.f2507d.inflate(R.layout.person_control_panel_item_login, root, false);
            textView = (TextView) convertView.findViewById(R.id.tv_person_login);
            SimpleDraweeView person = (SimpleDraweeView) convertView.findViewById(R.id.sdv_person);
            person.setAlpha(m3193a() ? 1.0f : 0.4f);
            m3189a(person);
            textView.setText(this.f2508e);
            textView.setEnabled(m3193a());
        } else {
            convertView = this.f2507d.inflate(R.layout.person_control_panel_list_item, root, false);
            textView = (TextView) convertView.findViewById(R.id.person_control_panel_list_item_tv);
            textView.setText(m3194b(position));
            View lineView = convertView.findViewById(R.id.control_panel_list_item_line);
            View redPointView = convertView.findViewById(R.id.red_point);
            if (this.f2510g.mo1567a(position)) {
                redPointView.setVisibility(0);
            } else {
                redPointView.setVisibility(8);
            }
            if (lineView != null) {
                if (position == this.f2505b.length) {
                    lineView.setVisibility(8);
                } else {
                    lineView.setVisibility(0);
                }
            }
        }
        if (this.f2509f == position) {
            textView.setSelected(true);
        } else {
            textView.setSelected(false);
        }
        return convertView;
    }

    /* renamed from: a */
    public void m3191a(C1502b secondClassNewFeatureHelper) {
        this.f2510g = secondClassNewFeatureHelper;
    }

    public boolean isEnabled(int position) {
        if (position == 0) {
            return m3193a();
        }
        return true;
    }

    /* renamed from: a */
    public boolean m3193a() {
        if (!CarlifeCoreSDK.m5979a().m5993N() || NaviAccountUtils.getInstance().isLogin()) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    public void m3192a(String strName) {
        this.f2508e = strName;
        notifyDataSetChanged();
    }

    /* renamed from: a */
    private void m3189a(final SimpleDraweeView imageView) {
        if (imageView != null) {
            if (!NaviAccountUtils.getInstance().isLogin()) {
                imageView.setImageURI("");
            } else if (NaviAccountUtils.getInstance().getPortraitUrl() != null) {
                imageView.setController(C1605a.m5867a(imageView, NaviAccountUtils.getInstance().getPortraitUrl(), 52, 52));
            } else {
                NaviAccountUtils.getInstance().asyncGetProtraitUrl(new SapiCallBack<GetPortraitResponse>(this) {
                    /* renamed from: b */
                    final /* synthetic */ HomePersonPanelAdapter f2503b;

                    public /* synthetic */ void onSuccess(SapiResponse sapiResponse) {
                        m3188a((GetPortraitResponse) sapiResponse);
                    }

                    /* renamed from: a */
                    public void m3188a(GetPortraitResponse getPortraitResponse) {
                        imageView.setController(C1605a.m5867a(imageView, getPortraitResponse.portrait, 52, 52));
                        C2186p.m8304a().m8319b("account_portrait_url", getPortraitResponse.portrait);
                    }

                    public void onNetworkFailed() {
                        String portrait = C2186p.m8304a().m8309a("account_portrait_url", "");
                        if (!TextUtils.isEmpty(portrait)) {
                            imageView.setController(C1605a.m5867a(imageView, portrait, 52, 52));
                        }
                    }

                    public void onSystemError(int i) {
                    }
                });
            }
        }
    }
}
