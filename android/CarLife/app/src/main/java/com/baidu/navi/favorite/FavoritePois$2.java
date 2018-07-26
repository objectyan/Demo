package com.baidu.navi.favorite;

class FavoritePois$2 implements Runnable {
    final /* synthetic */ FavoritePois this$0;

    FavoritePois$2(FavoritePois this$0) {
        this.this$0 = this$0;
    }

    public void run() {
        this.this$0.cleanAccountSyncData();
    }
}
