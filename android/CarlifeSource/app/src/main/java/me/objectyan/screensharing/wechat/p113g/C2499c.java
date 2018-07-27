package com.baidu.carlife.wechat.p113g;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.text.Html;
import com.baidu.carlife.core.AppContext;
import com.baidu.carlife.wechat.p105a.p107b.C2372c;
import com.baidu.carlife.wechat.p108b.C2382d;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import java.util.Hashtable;
import java.util.Random;
import java.util.regex.Pattern;

/* compiled from: Utils */
/* renamed from: com.baidu.carlife.wechat.g.c */
public class C2499c {
    /* renamed from: a */
    public static boolean m9498a(Context context, String permName) {
        boolean result = ContextCompat.checkSelfPermission(context, permName) == 0;
        C2372c.m9030c(permName + "  " + result);
        return result;
    }

    /* renamed from: a */
    public static void m9497a(Activity activity, String permission, int requestCode) {
        if (!C2499c.m9498a((Context) activity, permission)) {
            ActivityCompat.requestPermissions(activity, new String[]{permission}, requestCode);
        }
    }

    /* renamed from: a */
    public static Bitmap m9492a(String contents, int imgWidth, int imgHeight) {
        try {
            Hashtable<EncodeHintType, String> hints = new Hashtable();
            hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
            BitMatrix matrix = new QRCodeWriter().encode(contents, BarcodeFormat.QR_CODE, imgWidth, imgHeight, hints);
            int width = matrix.getWidth();
            int height = matrix.getHeight();
            int[] pixels = new int[(width * height)];
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    if (matrix.get(x, y)) {
                        pixels[(y * width) + x] = -230341307;
                    } else {
                        pixels[(y * width) + x] = -1;
                    }
                }
            }
            Bitmap bitmap = Bitmap.createBitmap(width, height, Config.RGB_565);
            bitmap.setPixels(pixels, 0, width, 0, 0, width, height);
            return bitmap;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public static Bitmap m9491a(Bitmap bitmap, float scale) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        return Bitmap.createBitmap(bitmap, ((int) (((float) width) - (((float) width) * scale))) / 2, ((int) (((float) height) - (((float) height) * scale))) / 2, (int) (((float) width) * scale), (int) (((float) height) * scale));
    }

    /* renamed from: a */
    public static String m9493a() {
        return System.currentTimeMillis() + "0" + (new Random().nextInt(900) + 100);
    }

    /* renamed from: b */
    public static String m9501b() {
        String randomNumStr = String.valueOf((1.0d + new Random().nextDouble()) * Math.pow(10.0d, 15.0d));
        String strNumstr = "";
        if (randomNumStr.length() >= 17) {
            strNumstr = randomNumStr.substring(2, 17);
        }
        return com.baidu.mobstat.Config.SESSTION_END_TIME + strNumstr;
    }

    /* renamed from: c */
    public static float m9502c() {
        return AppContext.m3876a().getResources().getDisplayMetrics().density;
    }

    /* renamed from: a */
    public static int m9489a(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    /* renamed from: b */
    public static int m9499b(Context context) {
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    /* renamed from: a */
    public static String m9494a(C2382d msg) {
        if (msg.m9107i() != null) {
            return "[位置]" + msg.m9107i().m9118a();
        }
        if (msg.m9106h() != null) {
            return "[音乐分享] " + Html.fromHtml(msg.m9106h().m9116b()) + " : " + Html.fromHtml(msg.m9106h().m9115a());
        }
        int msgType = msg.m9099b();
        String content = msg.m9104f();
        String result = "";
        switch (msgType) {
            case 1:
                return content;
            case 3:
                return "[图片消息，请在手机上查看]";
            case 34:
                return "[语音]";
            case 42:
                return "[名片消息，请在手机上查看]";
            case 43:
            case 62:
                return "[视频消息，请在手机上查看]";
            case 47:
                return "[动画表情，请在手机上查看]";
            case 10000:
                return content;
            default:
                return content;
        }
    }

    /* renamed from: b */
    public static Bitmap m9500b(Bitmap source, float radius) {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        Bitmap target = Bitmap.createBitmap(source.getWidth(), source.getHeight(), Config.ARGB_8888);
        Canvas canvas = new Canvas(target);
        canvas.drawRoundRect(new RectF(0.0f, 0.0f, (float) source.getWidth(), (float) source.getHeight()), radius, radius, paint);
        paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
        canvas.drawBitmap(source, 0.0f, 0.0f, paint);
        return target;
    }

    /* renamed from: a */
    public static Bitmap m9490a(Bitmap source) {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        int side = Math.min(source.getWidth(), source.getHeight());
        Bitmap target = Bitmap.createBitmap(side, side, Config.ARGB_8888);
        Canvas canvas = new Canvas(target);
        canvas.drawCircle((float) (side / 2), (float) (side / 2), (float) (side / 2), paint);
        paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
        canvas.drawBitmap(source, 0.0f, 0.0f, paint);
        return target;
    }

    /* renamed from: a */
    public static String m9495a(String str) {
        if (str != null) {
            return Pattern.compile("\\s*|\t|\r|\n").matcher(str).replaceAll("");
        }
        return "";
    }

    /* renamed from: a */
    public static String m9496a(byte[] src) {
        StringBuilder stringBuilder = new StringBuilder("");
        if (src == null || src.length <= 0) {
            return null;
        }
        for (byte b : src) {
            String hv = Integer.toHexString(b & 255);
            if (hv.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hv);
        }
        return stringBuilder.toString();
    }
}
