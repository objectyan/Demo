package com.baidu.navi.favorite;

class FavoritePois$1 implements Runnable {
    final /* synthetic */ FavoritePois this$0;
    final /* synthetic */ String val$bduid;

    FavoritePois$1(FavoritePois this$0, String str) {
        this.this$0 = this$0;
        this.val$bduid = str;
    }

    public void run() {
        FavoritePois.access$000(this.this$0, this.val$bduid);
    }
}
