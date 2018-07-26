package com.baidu.navi.util;

import android.app.ProgressDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.carlife.C0965R;
import com.baidu.navi.style.StyleManager;
import com.baidu.navi.utils.http.BaseHttpClient;
import com.baidu.navi.utils.http.BitmapRspHandler;
import com.baidu.navisdk.util.common.UserTask;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ShareTools {
    public static final String APP_ID = "wxbc677c875691da4e";
    public static final String BUNDLE_KEY_CONTENT = "content";
    public static final String BUNDLE_KEY_CONTENTTYPE = "contentType";
    public static final String BUNDLE_KEY_DISTANCE = "distance";
    public static final String BUNDLE_KEY_DURATION = "duration";
    public static final String BUNDLE_KEY_FILEPATH = "filepath";
    public static final String BUNDLE_KEY_IMAGESOURCE = "imageSource";
    public static final String BUNDLE_KEY_IMG_URL = "img_url";
    public static final String BUNDLE_KEY_NAVTYPE = "nav_type";
    public static final String BUNDLE_KEY_ROUTE = "route";
    public static final String BUNDLE_KEY_SHARE_SHORT_URL = "share_short_url";
    public static final String BUNDLE_KEY_SHARE_URL = "share_url";
    public static final String BUNDLE_KEY_SPEED = "speed";
    public static final String BUNDLE_KEY_START_END = "nav_start_end";
    public static final String BUNDLE_KEY_STREET_SHORT_CONTENT = "bundle_key_street_short_content";
    public static final String BUNDLE_KEY_SUBJECT = "subject";
    public static final String BUNDLE_KEY_TITLE = "title";
    public static final String BUNDLE_KEY_TOTAL_STEP = "total_step";
    public static final String BUNDLE_KEY_WEIBO_FILEPATH = "weibo_filepath";
    public static final String BUNDLE_KEY_WEIXIN_FILEPATH = "weixin_filepath";
    private static final String CONSUMER_KEY = "3770889857";
    public static final String DEFAULT_MYLOC_WEIBO_IMG = "http://client.map.baidu.com/imap/cfg/static/share_myloc_wb.png";
    public static final String DEFAULT_MYLOC_WEIXIN_IMG = "http://client.map.baidu.com/imap/cfg/static/share_myloc_wx.png";
    public static final String DEFAULT_NAV_WEIBO_IMG = "http://client.map.baidu.com/imap/cfg/static/share_route_wb.png";
    public static final String DEFAULT_NAV_WEIXIN_IMG = "http://client.map.baidu.com/imap/cfg/static/share_route_wx.png";
    public static final String DEFAULT_POI_WEIBO_IMG = "http://client.map.baidu.com/imap/cfg/static/share_poi_wb.png";
    public static final String DEFAULT_POI_WEIXIN_IMG = "http://client.map.baidu.com/imap/cfg/static/share_poi_wx.png";
    public static final String DEFAULT_STREET_WEIBO_IMG = "http://client.map.baidu.com/imap/cfg/static/share_street_wb.png";
    public static final String DEFAULT_STREET_WEIXIN_IMG = "http://client.map.baidu.com/imap/cfg/static/share_street_wx.png";
    private static final int ERROR_CODE_AUTHORIZE = 403;
    private static final int ERROR_CODE_REPEAT = 400;
    private static final float PROPORTION = 2.56f;
    private static final String REDIRECT_URL = "https://openapi.baidu.com/social/oauth/2.0/receiver";
    public static final String SHARE_TO_CAT_URL = "http://client.map.baidu.com/sendtocar/";
    public static final int SHARE_TYPE_HAPPINESS = 4;
    public static final int SHARE_TYPE_HEATMAP = 7;
    public static final int SHARE_TYPE_MYLOC = 3;
    public static final int SHARE_TYPE_NAV = 1;
    public static final int SHARE_TYPE_NEWS = 8;
    public static final int SHARE_TYPE_POI = 2;
    public static final int SHARE_TYPE_STREETSCAPE = 5;
    public static final int SHARE_TYPE_VOICES = 9;
    private static final int STREET_WB_HEIGHT = 250;
    private static final int STREET_WB_WIDTH = 460;
    private static final int TYPE_WEIXIN = 0;
    private static final int TYPE_WEIXIN_TIMELINE = 1;
    private static final int WB_IMG_HEIGHT = 118;
    private static final int WB_IMG_WIDTH = 302;
    private static final int WEIXIN_THUMB_SIZE = 150;
    private int TYPE_NON_STREET = 0;
    private int TYPE_STREET_WEIBO = 1;
    private int TYPE_STREET_WEIXIN = 2;
    private Bitmap mBitmap = null;
    private Context mContext;
    private PackageManager mPkgManager = null;
    private ProgressDialog mProgressDialog = null;
    private List<ResolveInfo> mResolveInfos = null;
    private Bundle mShareBundle;
    private int mShareType = 0;
    private String[] mmsPackage = new String[2];

    private interface UrlBitmapListener {
        void onUrlBitmapLoadSucess(Bitmap bitmap);
    }

    public static class AccessTokenKeeper {
        private static final String PREFERENCES_NAME = "com_weibo_sdk_android";

        public static void clear(Context context) {
            Editor editor = context.getSharedPreferences(PREFERENCES_NAME, 32768).edit();
            editor.clear();
            editor.commit();
        }
    }

    public Bitmap getmBitmap() {
        return this.mBitmap;
    }

    public void setmBitmap(Bitmap mBitmap) {
        this.mBitmap = small(mBitmap);
    }

    public ShareTools(Context context, int shareType) {
        this.mContext = context;
        this.mPkgManager = this.mContext.getPackageManager();
        this.mShareType = shareType;
    }

    public void share(Bundle m_shareBundle) {
        if (!this.mContext.isFinishing()) {
            new ArrayList().add(m_shareBundle);
        }
    }

    public void share(List<Bundle> list) {
        if (!this.mContext.isFinishing()) {
        }
    }

    private Boolean hasCurApp(Bundle bundle, String pkgName) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.addCategory("android.intent.category.DEFAULT");
        String filepath = bundle.getString(BUNDLE_KEY_FILEPATH);
        if (filepath == null || filepath.length() == 0) {
            intent.setType("text/plain");
        } else {
            intent.setType("image/png");
        }
        this.mResolveInfos = this.mPkgManager.queryIntentActivities(intent, 65536);
        for (int i = 0; i < this.mResolveInfos.size(); i++) {
            String label = ((ResolveInfo) this.mResolveInfos.get(i)).activityInfo.packageName;
            if (label != null && label.startsWith(pkgName)) {
                return Boolean.valueOf(true);
            }
        }
        return Boolean.valueOf(false);
    }

    private void setTextStyle(Bundle mBundle) {
        mBundle.putString("content", mBundle.getString("content").replace('，', '\n'));
    }

    private void shareToSms(Bundle m_shareBundle) {
        String filepath;
        setTextStyle(m_shareBundle);
        Intent startAppIntent = new Intent("android.intent.action.SEND");
        startAppIntent.putExtra("android.intent.extra.SUBJECT", m_shareBundle.getString(BUNDLE_KEY_SUBJECT));
        String content = m_shareBundle.getString("content");
        if (this.mShareType == 7 && !TextUtils.isEmpty(m_shareBundle.getString(BUNDLE_KEY_SHARE_URL))) {
            content = m_shareBundle.getString(BUNDLE_KEY_SUBJECT) + "--" + content + m_shareBundle.getString(BUNDLE_KEY_SHARE_URL);
        } else if (this.mShareType == 8 && !TextUtils.isEmpty(m_shareBundle.getString(BUNDLE_KEY_SHARE_SHORT_URL))) {
            content = m_shareBundle.getString(BUNDLE_KEY_SUBJECT) + "--" + content + m_shareBundle.getString(BUNDLE_KEY_SHARE_SHORT_URL);
        }
        startAppIntent.putExtra("android.intent.extra.TEXT", content);
        startAppIntent.putExtra("sms_body", content);
        String urlPath = m_shareBundle.getString(BUNDLE_KEY_FILEPATH);
        if (urlPath == null || !urlPath.startsWith("file:/")) {
            filepath = urlPath;
        } else {
            filepath = urlPath.replace("file:/", "");
        }
        if (filepath == null || filepath.length() <= 0) {
            startAppIntent.setType("text/plain");
        } else {
            File file = new File(filepath);
            if (file.exists()) {
                startAppIntent.putExtra("android.intent.extra.STREAM", Uri.fromFile(file));
                startAppIntent.setType("image/jpeg");
            } else {
                startAppIntent.setType("text/plain");
            }
        }
        getMmsInfo(urlPath);
        if (this.mmsPackage[0] != null) {
            startAppIntent.setComponent(new ComponentName(this.mmsPackage[0], this.mmsPackage[1]));
            try {
                this.mContext.startActivity(startAppIntent);
            } catch (Exception e) {
            }
        }
    }

    private void getMmsInfo(String filepath) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.addCategory("android.intent.category.DEFAULT");
        if (filepath == null || filepath.length() == 0) {
            intent.setType("text/plain");
        } else {
            intent.setType("image/png");
        }
        this.mResolveInfos = this.mPkgManager.queryIntentActivities(intent, 65536);
        for (ResolveInfo resilve : this.mResolveInfos) {
            if ("com.android.mms".equals(resilve.activityInfo.packageName)) {
                this.mmsPackage[0] = resilve.activityInfo.packageName;
                this.mmsPackage[1] = resilve.activityInfo.name;
                return;
            }
        }
        for (ResolveInfo resilve2 : this.mResolveInfos) {
            if (resilve2.activityInfo.name.equalsIgnoreCase("com.android.mms.ui.ComposeMessageActivity") || resilve2.activityInfo.name.equalsIgnoreCase("com.dataviz.stargate.MessageEditView") || resilve2.activityInfo.name.contains("Message") || resilve2.activityInfo.name.contains("com.android.mms")) {
                this.mmsPackage[0] = resilve2.activityInfo.packageName;
                this.mmsPackage[1] = resilve2.activityInfo.name;
                return;
            } else if (resilve2.activityInfo.packageName.contains("com.google.android.talk")) {
                this.mmsPackage[0] = resilve2.activityInfo.packageName;
                this.mmsPackage[1] = resilve2.activityInfo.name;
                return;
            }
        }
    }

    private void shareToSinaWeibo(Bundle bundle) {
    }

    private void authorizeSinaWeibo() {
    }

    public void onSinaAuthorizeCallback(int requestCode, int resultCode, Intent data) {
    }

    private void autoPutDefaultImageUrlWithBundle(String key, String defaultValue, Bundle bundle, int type) {
        if (bundle != null) {
            boolean useDefaultValue = false;
            if (!bundle.containsKey(key)) {
                useDefaultValue = true;
            } else if (TextUtils.isEmpty(bundle.getString(key))) {
                useDefaultValue = true;
            }
            if (useDefaultValue) {
                bundle.putString(key, defaultValue);
            } else if (type != this.TYPE_NON_STREET) {
                String imgurl = bundle.getString(key);
                if (type == this.TYPE_STREET_WEIBO) {
                    imgurl = imgurl + "&width=460&height=250";
                } else if (type == this.TYPE_STREET_WEIXIN) {
                    imgurl = imgurl + "&width=150&height=150";
                }
                bundle.putString(key, imgurl);
            }
        }
    }

    private void shareToWeixin(Bundle bundle) {
        preSendWeixinMsg(bundle, 0);
    }

    private void shareToWeixinTimeline(Bundle bundle) {
        preSendWeixinMsg(bundle, 1);
    }

    private void preSendWeixinMsg(final Bundle bundle, final int type) {
        switch (this.mShareType) {
            case 1:
                bundle.putString(BUNDLE_KEY_IMG_URL, DEFAULT_NAV_WEIXIN_IMG);
                break;
            case 2:
                bundle.putString(BUNDLE_KEY_IMG_URL, DEFAULT_POI_WEIXIN_IMG);
                this.mBitmap = StyleManager.getBitmap(C0965R.drawable.ic_launcher);
                break;
            case 3:
                bundle.putString(BUNDLE_KEY_IMG_URL, DEFAULT_MYLOC_WEIXIN_IMG);
                break;
            case 4:
            case 7:
                bundle.putString(BUNDLE_KEY_IMG_URL, DEFAULT_MYLOC_WEIXIN_IMG);
                String url = bundle.getString(BUNDLE_KEY_FILEPATH);
                String weixinUrl = bundle.getString(BUNDLE_KEY_WEIXIN_FILEPATH);
                if (!TextUtils.isEmpty(weixinUrl)) {
                    url = weixinUrl;
                }
                if (url != null && url.startsWith("file:/")) {
                    Bitmap bitmap = BitmapFactory.decodeFile(url.replace("file:/", ""));
                    if (bitmap != null) {
                        sendWeixinMsg(bundle, type, bitmap);
                        return;
                    }
                }
                break;
            case 5:
                autoPutDefaultImageUrlWithBundle(BUNDLE_KEY_IMG_URL, DEFAULT_STREET_WEIXIN_IMG, bundle, this.TYPE_STREET_WEIXIN);
                break;
            case 8:
                this.mBitmap = StyleManager.getBitmap(C0965R.drawable.ic_launcher);
                break;
        }
        if (9 == this.mShareType) {
            UrlBitmap(bundle.getString(BUNDLE_KEY_IMG_URL), new UrlBitmapListener() {
                public void onUrlBitmapLoadSucess(Bitmap bmp) {
                    if (ShareTools.this.mProgressDialog != null && ShareTools.this.mProgressDialog.isShowing()) {
                        ShareTools.this.mProgressDialog.cancel();
                        ShareTools.this.mProgressDialog = null;
                        ShareTools.this.mBitmap = bmp;
                        ShareTools.this.sendWeixinMsg(bundle, type, ShareTools.this.mBitmap);
                    }
                }
            });
        } else {
            sendWeixinMsg(bundle, type, this.mBitmap);
        }
    }

    private void sendWeixinMsg(Bundle bundle, int type, Bitmap bitmap) {
    }

    private Bitmap small(Bitmap bitmap) {
        Matrix matrix = new Matrix();
        matrix.postScale(0.5f, 0.5f);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    private byte[] bmpToByteArray(Bitmap bmp, boolean needRecycle, int maxbyte) {
        if (bmp == null) {
            return null;
        }
        int h;
        int w;
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        int height = bmp.getHeight();
        int width = bmp.getWidth();
        if (height > width && height > 400) {
            h = 400;
            w = (width * 400) / height;
        } else if (width <= height || width <= 400) {
            h = height;
            w = width;
        } else {
            w = 400;
            h = (height * 400) / width;
        }
        Bitmap thumb = Bitmap.createScaledBitmap(bmp, w, h, false);
        thumb.compress(CompressFormat.PNG, 60, output);
        int options = 60 - 10;
        while (output.toByteArray().length > maxbyte) {
            output.reset();
            thumb.compress(CompressFormat.JPEG, options, output);
            options -= 10;
            if (options < 0) {
                break;
            }
        }
        if (needRecycle) {
            bmp.recycle();
        }
        thumb.recycle();
        byte[] result = output.toByteArray();
        try {
            output.close();
            return result;
        } catch (Exception e) {
            return null;
        }
    }

    private String buildWeixinTransaction(String type) {
        return type == null ? String.valueOf(System.currentTimeMillis()) : type + System.currentTimeMillis();
    }

    private String formatRoute(String route) {
        if (route.length() > 8) {
            return route.substring(0, 7) + "...";
        }
        return "";
    }

    private void UrlBitmap(final String url, final UrlBitmapListener urlListener) {
        this.mProgressDialog = ProgressDialog.show(this.mContext, null, "准备分享", true);
        this.mProgressDialog.setCancelable(true);
        new UserTask<String, String, Bitmap>() {
            Bitmap mBmp;

            /* renamed from: com.baidu.navi.util.ShareTools$2$1 */
            class C39801 extends BitmapRspHandler {
                C39801() {
                }

                public void onRevBitmap(Bitmap retBmp) {
                    C39812.this.mBmp = retBmp;
                }

                public void onFailure(Throwable error) {
                    C39812.this.mBmp = StyleManager.getBitmap(C0965R.drawable.ic_launcher);
                }
            }

            public Bitmap doInBackground(String... params) {
                new BaseHttpClient().get(url, new C39801());
                return this.mBmp;
            }

            public void onPostExecute(Bitmap bmp) {
                if (bmp != null) {
                    urlListener.onUrlBitmapLoadSucess(bmp);
                }
            }
        }.execute("");
    }
}
