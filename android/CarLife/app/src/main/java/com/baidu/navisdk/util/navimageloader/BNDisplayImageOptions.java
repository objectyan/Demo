package com.baidu.navisdk.util.navimageloader;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import com.baidu.navisdk.ui.util.BNStyleManager;

public final class BNDisplayImageOptions {
    private final boolean cacheInMemory;
    private final boolean cacheOnDisk;
    private final BNBitmapDisplayer displayer;
    private final Handler handler;
    private final int imageResOnFail;
    private final int imageResOnLoading;
    private final boolean isPersistCache;
    private final boolean isSyncLoading;

    private BNDisplayImageOptions(BNDisplayImageOptions$Builder builder) {
        this.imageResOnLoading = BNDisplayImageOptions$Builder.access$000(builder);
        this.imageResOnFail = BNDisplayImageOptions$Builder.access$100(builder);
        this.cacheInMemory = BNDisplayImageOptions$Builder.access$200(builder);
        this.cacheOnDisk = BNDisplayImageOptions$Builder.access$300(builder);
        this.handler = BNDisplayImageOptions$Builder.access$400(builder);
        this.isSyncLoading = BNDisplayImageOptions$Builder.access$500(builder);
        this.displayer = BNDisplayImageOptions$Builder.access$600(builder);
        this.isPersistCache = BNDisplayImageOptions$Builder.access$700(builder);
    }

    public boolean isPersistCache() {
        return this.isPersistCache;
    }

    public boolean shouldShowImageOnLoading() {
        return this.imageResOnLoading > 0;
    }

    public boolean shouldShowImageOnFail() {
        return this.imageResOnFail > 0;
    }

    public Drawable getImageOnLoading() {
        return BNStyleManager.getDrawable(this.imageResOnLoading);
    }

    public Drawable getImageOnFail() {
        return BNStyleManager.getDrawable(this.imageResOnFail);
    }

    public boolean isCacheInMemory() {
        return this.cacheInMemory;
    }

    public boolean isCacheOnDisk() {
        return this.cacheOnDisk;
    }

    public BNBitmapDisplayer getDisplayer() {
        return this.displayer;
    }

    public Handler getHandler() {
        return this.handler;
    }

    boolean isSyncLoading() {
        return this.isSyncLoading;
    }

    public static BNDisplayImageOptions createSimple() {
        return new BNDisplayImageOptions$Builder().build();
    }
}
