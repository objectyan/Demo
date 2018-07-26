package com.baidu.navisdk.ui.cruise;

import com.baidu.navisdk.model.datastruct.LocData;

public interface IBCruiserListener {
    public static final int PAGE_JUMP_TO_OFFLINE_DOWNLOAD = 2;
    public static final int PAGE_JUMP_TO_WHEN_QUIT = 1;

    void notifyLoacteData(LocData locData);

    void notifyQuitCruiser();

    void notifyStartCruiser();

    void onPageJump(int i, Object obj);
}
