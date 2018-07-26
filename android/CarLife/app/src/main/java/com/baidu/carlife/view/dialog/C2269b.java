package com.baidu.carlife.view.dialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.carlife.C0965R;

/* compiled from: CarLifeUpdateProgressDialog */
/* renamed from: com.baidu.carlife.view.dialog.b */
public class C2269b extends C1953c {
    /* renamed from: e */
    private ProgressBar f7435e = null;
    /* renamed from: f */
    private TextView f7436f = null;
    /* renamed from: g */
    private TextView f7437g = null;
    /* renamed from: h */
    private String f7438h = "已完成: %dM/%dM";
    /* renamed from: i */
    private String f7439i = "%d%%";

    public C2269b(Context context) {
        super(context);
        View view = LayoutInflater.from(context).inflate(C0965R.layout.carlife_update_progress_dialog, null);
        this.f7435e = (ProgressBar) view.findViewById(C0965R.id.update_progress);
        this.f7436f = (TextView) view.findViewById(C0965R.id.has_finished);
        this.f7437g = (TextView) view.findViewById(C0965R.id.percent);
        m7437a(view);
    }

    public void setPercent(int percent) {
        this.f7437g.setText(String.format(this.f7439i, new Object[]{Integer.valueOf(percent)}));
    }

    public void setHasFinished(int cur, int total) {
        this.f7436f.setText(String.format(this.f7438h, new Object[]{Integer.valueOf(cur), Integer.valueOf(total)}));
    }

    public void setProgress(int progress) {
        this.f7435e.setProgress(progress);
    }
}
