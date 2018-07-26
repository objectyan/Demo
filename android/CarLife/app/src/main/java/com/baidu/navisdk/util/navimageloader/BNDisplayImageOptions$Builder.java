package com.baidu.navisdk.util.navimageloader;

import android.os.Handler;
import com.baidu.navisdk.C4048R;

public class BNDisplayImageOptions$Builder {
    private boolean cacheInMemory = true;
    private boolean cacheOnDisk = true;
    private BNBitmapDisplayer displayer = BNImageLoader.getInstance().createBitmapDisplayer();
    private Handler handler = null;
    private int imageResOnFail = -1;
    private int imageResOnLoading = C4048R.drawable.ugc_default_pic;
    private boolean isPersistCache = false;
    private boolean isSyncLoading = false;

    public BNDisplayImageOptions$Builder showImageOnLoading(int imageRes) {
        this.imageResOnLoading = imageRes;
        return this;
    }

    public BNDisplayImageOptions$Builder isPersistCache(boolean isPersistCache) {
        this.isPersistCache = isPersistCache;
        return this;
    }

    private BNBitmapDisplayer createBitmapDisplayer() {
        return null;
    }

    public BNDisplayImageOptions$Builder showImageOnFail(int imageRes) {
        this.imageResOnFail = imageRes;
        return this;
    }

    @Deprecated
    public BNDisplayImageOptions$Builder cacheInMemory() {
        this.cacheInMemory = true;
        return this;
    }

    public BNDisplayImageOptions$Builder cacheInMemory(boolean cacheInMemory) {
        this.cacheInMemory = cacheInMemory;
        return this;
    }

    @Deprecated
    public BNDisplayImageOptions$Builder cacheOnDisc() {
        return cacheOnDisk(true);
    }

    @Deprecated
    public BNDisplayImageOptions$Builder cacheOnDisc(boolean cacheOnDisk) {
        return cacheOnDisk(cacheOnDisk);
    }

    public BNDisplayImageOptions$Builder cacheOnDisk(boolean cacheOnDisk) {
        this.cacheOnDisk = cacheOnDisk;
        return this;
    }

    public BNDisplayImageOptions$Builder displayer(BNBitmapDisplayer displayer) {
        if (displayer == null) {
            throw new IllegalArgumentException("displayer can't be null");
        }
        this.displayer = displayer;
        return this;
    }

    BNDisplayImageOptions$Builder syncLoading(boolean isSyncLoading) {
        this.isSyncLoading = isSyncLoading;
        return this;
    }

    public BNDisplayImageOptions$Builder handler(Handler handler) {
        this.handler = handler;
        return this;
    }

    public BNDisplayImageOptions$Builder cloneFrom(BNDisplayImageOptions options) {
        this.imageResOnLoading = BNDisplayImageOptions.access$800(options);
        this.imageResOnFail = BNDisplayImageOptions.access$900(options);
        this.cacheInMemory = BNDisplayImageOptions.access$1000(options);
        this.cacheOnDisk = BNDisplayImageOptions.access$1100(options);
        this.displayer = BNDisplayImageOptions.access$1200(options);
        this.handler = BNDisplayImageOptions.access$1300(options);
        this.isSyncLoading = BNDisplayImageOptions.access$1400(options);
        return this;
    }

    public BNDisplayImageOptions build() {
        return new BNDisplayImageOptions(this, null);
    }
}
