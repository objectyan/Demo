package com.baidu.carlife.p078f;

import android.view.KeyEvent;
import android.view.View;
import android.widget.GridView;
import com.baidu.carlife.core.LogUtil;
import com.baidu.carlife.core.screen.presentation.view.CarlifeViewContainer;

/* compiled from: FocusGridView */
/* renamed from: com.baidu.carlife.f.b */
public class C1437b extends C1436a {
    /* renamed from: v */
    private static final String f4195v = "FocusGridView";

    public C1437b(GridView view, int position) {
        super(view, position);
        view.setOnKeyListener(this);
    }

    public boolean onKey(View v, int keyCode, KeyEvent event) {
        if (event != null && event.getAction() == 0) {
            LogUtil.m4440c(f4195v, "action=" + event.getAction() + "keyCode=" + keyCode);
            int selectedItemPosition = ((GridView) this.r).getSelectedItemPosition();
            LogUtil.m4440c(f4195v, "selectedItemPosition=" + selectedItemPosition);
            LogUtil.m4440c(f4195v, "isInTouchMode=" + ((GridView) this.r).isInTouchMode());
            switch (keyCode) {
                case 300:
                    if (!m5248d() && CarlifeViewContainer.m4699a().isDialogShown() && !C1440d.m5251a().m5270i()) {
                        return true;
                    }
                    if (selectedItemPosition + 1 >= ((GridView) this.r).getCount()) {
                        return true;
                    }
                    ((GridView) this.r).setSelection(selectedItemPosition + 1);
                    LogUtil.m4440c(f4195v, "newSelectedItemPosition=" + ((GridView) this.r).getSelectedItemPosition());
                    return true;
                case 301:
                    if (!m5248d() && CarlifeViewContainer.m4699a().isDialogShown() && !C1440d.m5251a().m5270i()) {
                        return true;
                    }
                    if (selectedItemPosition - 1 < 0) {
                        return true;
                    }
                    ((GridView) this.r).setSelection(selectedItemPosition - 1);
                    return true;
            }
        }
        return super.onKey(v, keyCode, event);
    }
}
