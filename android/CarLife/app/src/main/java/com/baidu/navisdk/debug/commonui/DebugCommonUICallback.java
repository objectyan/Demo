package com.baidu.navisdk.debug.commonui;

import com.baidu.navisdk.debug.commonui.DebugCommonUIView.DebugViewKeyValueData;
import java.util.List;

public interface DebugCommonUICallback {
    String getInfo();

    List<DebugViewKeyValueData> getKeyValues();
}
