package com.baidu.carlife.view.dialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.carlife.R;
import com.baidu.carlife.core.LogUtil;

/* compiled from: VehicleUpdateProgressDialog */
/* renamed from: com.baidu.carlife.view.dialog.u */
public class C2329u extends C1953c {
    /* renamed from: e */
    private ProgressBar f7637e = null;
    /* renamed from: f */
    private TextView f7638f = null;
    /* renamed from: g */
    private TextView f7639g = null;
    /* renamed from: h */
    private TextView f7640h = null;
    /* renamed from: i */
    private String f7641i = "已完成: %dM/%dM";
    /* renamed from: j */
    private String f7642j = "%d%%";

    public C2329u(Context context) {
        super(context);
        View view = LayoutInflater.from(context).inflate(R.layout.vehicle_update_progress_dialog, null);
        this.f7637e = (ProgressBar) view.findViewById(R.id.update_progress);
        this.f7638f = (TextView) view.findViewById(R.id.has_finished);
        this.f7639g = (TextView) view.findViewById(R.id.percent);
        this.f7640h = (TextView) view.findViewById(R.id.titletxt);
        m7437a(view);
    }

    public void setPercent(int percent) {
        this.f7639g.setText(String.format(this.f7642j, new Object[]{Integer.valueOf(percent)}));
    }

    public void setHasFinished(int cur, int total) {
        this.f7638f.setText(String.format(this.f7641i, new Object[]{Integer.valueOf(cur), Integer.valueOf(total)}));
    }

    public void setProgress(int progress) {
        this.f7637e.setProgress(progress);
    }

    public void setTitle(String strTitle) {
        if (this.f7640h != null) {
            LogUtil.d("BaseDialog", "Set UpdateProgressDialog Title: " + strTitle);
            this.f7640h.setText(strTitle);
        }
    }

    public void setTitle(int resId) {
        if (this.f7640h != null) {
            setTitle(this.c.getString(resId));
        }
    }
}
