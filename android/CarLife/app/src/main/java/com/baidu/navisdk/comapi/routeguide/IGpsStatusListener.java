package com.baidu.navisdk.comapi.routeguide;

import android.os.Message;

public interface IGpsStatusListener {
    void onGpsServiceProcess(Message message);

    void onGpsStatusChange(Message message);
}
