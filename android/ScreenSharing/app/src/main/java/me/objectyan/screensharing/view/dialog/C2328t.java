package com.baidu.carlife.view.dialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import com.baidu.carlife.R;

/* compiled from: VehicleDisableDialog */
/* renamed from: com.baidu.carlife.view.dialog.t */
public class C2328t extends BaseDialog {

    /* compiled from: VehicleDisableDialog */
    /* renamed from: com.baidu.carlife.view.dialog.t$1 */
    class C23261 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ C2328t f7635a;

        C23261(C2328t this$0) {
            this.f7635a = this$0;
        }

        public void onClick(View view) {
            this.f7635a.mo1526d();
        }
    }

    /* compiled from: VehicleDisableDialog */
    /* renamed from: com.baidu.carlife.view.dialog.t$2 */
    class C23272 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ C2328t f7636a;

        C23272(C2328t this$0) {
            this.f7636a = this$0;
        }

        public void onClick(View v) {
        }
    }

    public C2328t(Context context) {
        super(context);
    }

    /* renamed from: a */
    protected View mo1528a() {
        View contentView = LayoutInflater.from(this.c).inflate(R.layout.layout_vehicle_disable, null);
        contentView.setOnClickListener(new C23261(this));
        return contentView;
    }

    /* renamed from: b */
    protected void mo1529b() {
        findViewById(R.id.tv_msg).setOnClickListener(new C23272(this));
    }

    protected int getCustomWidth() {
        return this.c.getResources().getDimensionPixelSize(R.dimen.dialog_vehicle_disable_width);
    }

    public int getCustomHeight() {
        return this.c.getResources().getDimensionPixelSize(R.dimen.dialog_vehicle_disable_height);
    }

    /* renamed from: f */
    public void mo1530f() {
    }
}
