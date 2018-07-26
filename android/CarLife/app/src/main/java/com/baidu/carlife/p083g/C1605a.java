package com.baidu.carlife.p083g;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import com.baidu.carlife.core.C1157a;
import com.baidu.carlife.core.C1253f;
import com.baidu.carlife.core.C1261k;
import com.baidu.carlife.logic.music.C1796d;
import com.baidu.carlife.model.MusicSongModel;
import com.baidu.carlife.p059c.C1105d;
import com.baidu.carlife.p059c.C1105d.C1091a;
import com.baidu.carlife.p059c.C1141f;
import com.baidu.carlife.p087l.C1663a;
import com.facebook.common.p140h.C2921a;
import com.facebook.drawee.p143c.C2926a;
import com.facebook.drawee.p144a.p145a.C5377b;
import com.facebook.drawee.p144a.p145a.C5378d;
import com.facebook.drawee.p147e.C2934a;
import com.facebook.drawee.p147e.C2935b;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.p151g.C5521b;
import com.facebook.imagepipeline.p152i.C5534b;
import com.facebook.imagepipeline.p154m.C2959c;
import com.facebook.imagepipeline.p154m.C2960d;
import com.facebook.imagepipeline.p276e.C5495d;
import com.facebook.p138c.C2918d;
import java.util.concurrent.Executor;

/* compiled from: FrescoUtils */
/* renamed from: com.baidu.carlife.g.a */
public class C1605a {
    /* renamed from: a */
    private static final int f4905a = 1920;
    /* renamed from: b */
    private static final int f4906b = 1080;

    /* compiled from: FrescoUtils */
    /* renamed from: com.baidu.carlife.g.a$1 */
    static class C16001 implements Executor {
        C16001() {
        }

        public void execute(@NonNull Runnable command) {
            command.run();
        }
    }

    /* compiled from: FrescoUtils */
    /* renamed from: com.baidu.carlife.g.a$a */
    private static final class C1602a extends C5521b {
        /* renamed from: a */
        private static final int f4900a = -1509949440;
        /* renamed from: b */
        private Context f4901b;

        /* compiled from: FrescoUtils */
        /* renamed from: com.baidu.carlife.g.a$a$1 */
        class C16011 implements C1091a<Bitmap> {
            /* renamed from: a */
            final /* synthetic */ C1602a f4899a;

            C16011(C1602a this$0) {
                this.f4899a = this$0;
            }

            /* renamed from: a */
            public void m5857a(Bitmap output) {
                C2934a hierarchy = new C2935b(this.f4899a.f4901b.getResources()).m11522e(new BitmapDrawable(this.f4899a.f4901b.getResources(), output)).m11525f(new ColorDrawable(C1602a.f4900a)).m11541u();
                C1261k.m4452a((int) C1253f.ex);
                C1261k.m4459a((int) C1253f.ex, hierarchy.m11449a());
            }

            /* renamed from: a */
            public void mo1408a() {
            }

            /* renamed from: b */
            public void mo1410b() {
            }
        }

        public C1602a(Context context) {
            this.f4901b = context;
        }

        /* renamed from: a */
        protected void m5861a(Bitmap bitmap) {
            C1141f.m3839a().m3841a(new C1603b(this.f4901b), bitmap, new C16011(this));
        }

        /* renamed from: a */
        protected void m5862a(C2918d<C2921a<C5534b>> c2918d) {
        }
    }

    /* compiled from: FrescoUtils */
    /* renamed from: com.baidu.carlife.g.a$b */
    private static final class C1603b extends C1105d<Bitmap, Bitmap> {
        /* renamed from: a */
        private static final int f4902a = 5;
        /* renamed from: b */
        private Context f4903b;

        public C1603b(Context context) {
            this.f4903b = context;
        }

        /* renamed from: a */
        public void m5863a(Bitmap input) {
            m3729a().mo1409a(VERSION.SDK_INT >= 17 ? C1796d.m6669a(this.f4903b, input, 5) : C1796d.m6670a(input, 5));
        }
    }

    /* compiled from: FrescoUtils */
    /* renamed from: com.baidu.carlife.g.a$c */
    private static final class C1604c extends C5521b {
        /* renamed from: a */
        private MusicSongModel f4904a;

        public C1604c(MusicSongModel songModel) {
            this.f4904a = songModel;
        }

        /* renamed from: a */
        public void m5865a(Bitmap bitmap) {
            if (bitmap != null) {
                this.f4904a.f5916h = bitmap;
                C1261k.m4459a((int) C1253f.dB, this.f4904a.f5916h);
            }
            if (C1663a.m5979a().m5993N()) {
                C1261k.m4461b(407);
            }
        }

        /* renamed from: a */
        public void m5866a(C2918d dataSource) {
            C1261k.m4461b(407);
        }
    }

    /* renamed from: a */
    public static C2926a m5867a(SimpleDraweeView draweeView, String url, int width, int height) {
        return ((C5378d) ((C5378d) C5377b.b().a(draweeView.getController())).b(C2960d.m11933a(Uri.parse(url)).m11938a(new C5495d(width, height)).m11957m())).q();
    }

    /* renamed from: a */
    public static void m5868a(Uri uri, Context context) {
        C1605a.m5869a(uri, new C1602a(context), (int) f4905a, (int) f4906b);
    }

    /* renamed from: a */
    private static void m5869a(Uri uri, C5521b baseBitmapDataSubscriber, int width, int height) {
        C2959c request = C2960d.m11933a(uri).m11938a(new C5495d(width, height)).m11957m();
        ((C5378d) C5377b.b().b(request)).q();
        C5377b.d().c(request, C1157a.m3876a()).mo2011a(baseBitmapDataSubscriber, new C16001());
    }

    /* renamed from: a */
    public static void m5870a(MusicSongModel radioSong, int width, int height) {
        if (radioSong.f5915g != null) {
            C1605a.m5869a(Uri.parse(radioSong.f5915g), new C1604c(radioSong), width, height);
        }
    }
}
