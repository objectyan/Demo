package com.baidu.carlife.custom.elhyf.mydvr;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import com.baidu.carlife.C0965R;
import com.baidu.carlife.util.C2201w;
import com.tencent.mm.sdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.sdk.modelmsg.WXImageObject;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.WXAPIFactory;
import java.io.ByteArrayOutputStream;
import java.io.File;

/* compiled from: WeiXinShareManager */
/* renamed from: com.baidu.carlife.custom.elhyf.mydvr.c */
public class C1402c {
    /* renamed from: a */
    public static final String f4116a = "wxecea17450eadc380";
    /* renamed from: b */
    private static final int f4117b = 553779201;
    /* renamed from: c */
    private static final int f4118c = 100;
    /* renamed from: f */
    private static C1402c f4119f;
    /* renamed from: d */
    private Context f4120d;
    /* renamed from: e */
    private IWXAPI f4121e;

    /* compiled from: WeiXinShareManager */
    /* renamed from: com.baidu.carlife.custom.elhyf.mydvr.c$a */
    public enum C1401a {
        WXSCENE_SESSION,
        WXSCENE_TIMELINE
    }

    private C1402c() {
    }

    /* renamed from: a */
    public static C1402c m5174a() {
        if (f4119f == null) {
            f4119f = new C1402c();
        }
        return f4119f;
    }

    /* renamed from: a */
    public void m5180a(Context context) {
        this.f4120d = context;
        this.f4121e = WXAPIFactory.createWXAPI(context, f4116a, true);
        this.f4121e.registerApp(f4116a);
    }

    /* renamed from: a */
    public void m5182a(String picPath, C1401a shareWXScene) {
        if (!m5178b()) {
            return;
        }
        if (shareWXScene == C1401a.WXSCENE_TIMELINE && !m5179c()) {
            return;
        }
        if (new File(picPath).exists()) {
            WXImageObject imgObj = new WXImageObject();
            imgObj.setImagePath(picPath);
            m5176a(imgObj, BitmapFactory.decodeFile(picPath), shareWXScene);
            return;
        }
        C2201w.m8373a(this.f4120d.getString(C0965R.string.weixin_share_file_no_existed), 1);
    }

    /* renamed from: a */
    public void m5181a(Bitmap bmp, C1401a shareWXScene) {
        if (!m5178b()) {
            return;
        }
        if (shareWXScene != C1401a.WXSCENE_TIMELINE || m5179c()) {
            m5176a(new WXImageObject(bmp), bmp, shareWXScene);
        }
    }

    /* renamed from: a */
    private void m5176a(WXImageObject imgObj, Bitmap bmp, C1401a shareWXScene) {
        int i = 1;
        WXMediaMessage msg = new WXMediaMessage();
        msg.mediaObject = imgObj;
        Bitmap thumbBmp = Bitmap.createScaledBitmap(bmp, 100, 100, true);
        bmp.recycle();
        msg.thumbData = m5177a(thumbBmp, true);
        Req req = new Req();
        req.transaction = m5175a("img");
        req.message = msg;
        if (shareWXScene == C1401a.WXSCENE_SESSION) {
            i = 0;
        }
        req.scene = i;
        this.f4121e.sendReq(req);
    }

    /* renamed from: a */
    private byte[] m5177a(Bitmap bmp, boolean needRecycle) {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        bmp.compress(CompressFormat.PNG, 100, output);
        if (needRecycle) {
            bmp.recycle();
        }
        byte[] result = output.toByteArray();
        try {
            output.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /* renamed from: a */
    private String m5175a(String type) {
        return type == null ? String.valueOf(System.currentTimeMillis()) : type + System.currentTimeMillis();
    }

    /* renamed from: b */
    private boolean m5178b() {
        if (this.f4121e.isWXAppInstalled()) {
            return true;
        }
        C2201w.m8373a(this.f4120d.getString(C0965R.string.weixin_share_no_weixin_app), 1);
        return false;
    }

    /* renamed from: c */
    private boolean m5179c() {
        if (this.f4121e.getWXAppSupportAPI() >= 553779201) {
            return true;
        }
        C2201w.m8373a(this.f4120d.getString(C0965R.string.weixin_share_no_support), 1);
        return false;
    }
}
