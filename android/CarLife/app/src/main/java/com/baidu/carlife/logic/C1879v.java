package com.baidu.carlife.logic;

import com.baidu.carlife.C0965R;
import com.baidu.carlife.core.screen.presentation.C1328h;
import com.baidu.che.codriver.sdk.p081a.C2595h.C1878b;
import com.baidu.che.codriver.util.C2716c;
import com.baidu.che.codriver.util.C2725h;
import com.baidu.navi.fragment.ContentFragment;
import com.baidu.navi.fragment.NaviFragmentManager;

/* compiled from: UIOperationToolImpl */
/* renamed from: com.baidu.carlife.logic.v */
public class C1879v implements C1878b {
    /* renamed from: a */
    private static final String f5816a = C1879v.class.getName();

    /* renamed from: a */
    public boolean mo1701a(String strCommand, String strIntent) {
        C2725h.m10207b(f5816a, "doCommand: " + strCommand);
        String strZCW = C2716c.m10141a().getString(C0965R.string.home_discovery_zcw);
        ContentFragment contentFragment = C1328h.m4757a().getCurrentFragment();
        if (contentFragment == null) {
            C2725h.m10207b(f5816a, "doCommand: fragment Error");
            return false;
        }
        if (strCommand.startsWith("打开") || strCommand.startsWith("前往") || strCommand.startsWith("查看")) {
            strCommand = strCommand.substring(2);
            C2725h.m10207b(f5816a, "doCommand subCommand: " + strCommand);
        }
        return contentFragment.onVoiceCommand(strCommand, strIntent);
    }

    /* renamed from: a */
    public boolean mo1700a(int selectIndex) {
        C2725h.m10207b(f5816a, "doSelectCommand: " + selectIndex);
        ContentFragment contentFragment = C1328h.m4757a().getCurrentFragment();
        if (contentFragment != null) {
            return contentFragment.onVoiceCommand(selectIndex);
        }
        C2725h.m10207b(f5816a, "doSelectCommand: fragment Error");
        return false;
    }

    /* renamed from: a */
    public boolean mo1699a() {
        int curFragmentType = C1328h.m4757a().getCurrentFragmentType();
        C2725h.m10207b(f5816a, "isAtHomeFragment: " + curFragmentType);
        if (NaviFragmentManager.TYPE_HOME == curFragmentType) {
            C2725h.m10207b(f5816a, "isAtHomeFragment: true");
            return true;
        }
        C2725h.m10207b(f5816a, "isAtHomeFragment: fragment Error");
        return false;
    }
}
