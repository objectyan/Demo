package com.baidu.che.codriver.ui.p127a;

import android.view.ViewGroup;
import com.baidu.che.codriver.widget.CompoundRelativeLayout;

/* compiled from: BaseCheckedItemAdapter */
/* renamed from: com.baidu.che.codriver.ui.a.a */
public abstract class C2645a {
    /* renamed from: a */
    public static int f8703a = -1;

    /* renamed from: a */
    protected void m9912a(ViewGroup viewGroup, CompoundRelativeLayout view, int index) {
        m9911a(view, index);
        viewGroup.addView(view);
    }

    /* renamed from: a */
    private void m9911a(CompoundRelativeLayout item, int index) {
        if (f8703a > -1 && index == f8703a) {
            item.setChecked(true);
        }
    }
}
