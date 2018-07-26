package com.baidu.android.pushservice.message;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.baidu.android.pushservice.C0554h;
import com.baidu.android.pushservice.C0580j;
import com.baidu.android.pushservice.message.p033a.C0612l;
import com.baidu.android.pushservice.p022i.C0420c;
import com.baidu.android.pushservice.p022i.C0559d;
import com.baidu.android.pushservice.p023b.C0432b;
import com.baidu.android.pushservice.p023b.C0437f;
import com.baidu.android.pushservice.p026e.C0486b;
import com.baidu.android.pushservice.p027f.C0521b;
import com.baidu.android.pushservice.p028g.C0527a;
import com.baidu.android.pushservice.p029h.C0544j;
import com.baidu.android.pushservice.p029h.C0545k;
import com.baidu.android.pushservice.p029h.C0553q;
import com.baidu.android.pushservice.p029h.p030a.C0532b;
import com.baidu.android.pushservice.p031j.C0578p;
import com.baidu.baidunavis.BaiduNaviParams.RoutePlanFailedSubType;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class PublicMsg implements Parcelable {
    public static final Creator<PublicMsg> CREATOR = new C05942();
    public static final int FLAG_NEED_CLEAR = 1;
    public static final int FLAG_NEED_SOUND = 4;
    public static final int FLAG_NEED_VIBRATE = 2;
    private static final String TAG = "PublicMsg";
    public String mAdvertiseBigPictureClickUrl;
    public String mAdvertiseBigPictureContent;
    public String mAdvertiseBigPictureTitle;
    public String mAdvertiseBigPictureUrl;
    public String mAdvertiseClickUrl;
    public String mAdvertiseDetailClickUrl;
    public String mAdvertiseDownloadClickUrl;
    public String mAdvertiseLargeIconUrl;
    public String mAdvertiseSmallIconUrl;
    public int mAdvertiseStyle;
    public String mAppId;
    public String mCustomContent;
    public String mDescription;
    public boolean mIsSupportApp = true;
    public String mMsgId;
    public int mNetType = 0;
    public int mNotificationBasicStyle = 7;
    public int mNotificationBuilder = 0;
    public int mOpenType = 0;
    public String mPkgContent;
    public String mPkgName;
    public int mPkgVercode = 0;
    public String mSupportAppname;
    public String mTitle;
    public String mUrl;
    public int mUserConfirm = 0;

    /* renamed from: com.baidu.android.pushservice.message.PublicMsg$2 */
    static class C05942 implements Creator<PublicMsg> {
        C05942() {
        }

        /* renamed from: a */
        public PublicMsg m2677a(Parcel parcel) {
            return new PublicMsg(parcel);
        }

        /* renamed from: a */
        public PublicMsg[] m2678a(int i) {
            return new PublicMsg[i];
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m2677a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return m2678a(i);
        }
    }

    PublicMsg(Parcel parcel) {
        this.mMsgId = parcel.readString();
        this.mAppId = parcel.readString();
        this.mTitle = parcel.readString();
        this.mDescription = parcel.readString();
        this.mUrl = parcel.readString();
        this.mPkgName = parcel.readString();
        this.mPkgVercode = parcel.readInt();
        this.mNotificationBuilder = parcel.readInt();
        this.mNotificationBasicStyle = parcel.readInt();
        this.mOpenType = parcel.readInt();
        this.mUserConfirm = parcel.readInt();
        this.mCustomContent = parcel.readString();
        this.mPkgContent = parcel.readString();
        this.mAdvertiseStyle = parcel.readInt();
        this.mAdvertiseSmallIconUrl = parcel.readString();
        this.mAdvertiseLargeIconUrl = parcel.readString();
        this.mAdvertiseClickUrl = parcel.readString();
        this.mAdvertiseBigPictureUrl = parcel.readString();
        this.mAdvertiseBigPictureClickUrl = parcel.readString();
        this.mAdvertiseDownloadClickUrl = parcel.readString();
        this.mAdvertiseDetailClickUrl = parcel.readString();
        this.mAdvertiseBigPictureTitle = parcel.readString();
        this.mAdvertiseBigPictureContent = parcel.readString();
    }

    private void addCustomContentToIntent(Intent intent) {
        if (this.mCustomContent != null) {
            try {
                JSONObject jSONObject = new JSONObject(this.mCustomContent);
                Iterator keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String str = (String) keys.next();
                    intent.putExtra(str, jSONObject.getString(str));
                }
                intent.putExtra("extra_extra_custom_content", this.mCustomContent);
            } catch (JSONException e) {
            }
        }
    }

    private void insertBehavior(Context context, C0437f c0437f, C0545k c0545k, C0544j c0544j) {
        if (c0437f != null) {
            c0544j.m2269b(c0437f.m1867c());
            C0544j a = C0578p.m2517a(c0544j, context, c0437f.m1867c());
            c0545k.j = c0437f.m1867c();
            try {
                C0553q.m2356a(context, c0545k);
                C0553q.m2355a(context, a);
            } catch (Exception e) {
            }
        }
    }

    private void insertNotiBehavior(Context context, String str, String str2, String str3) {
        C0545k c0545k = new C0545k();
        c0545k.d = str3;
        c0545k.f1803a = str;
        c0545k.e = System.currentTimeMillis();
        c0545k.f = C0532b.m2255b(context);
        c0545k.f1805c = C0612l.MSG_TYPE_MULTI_PRIVATE_NOTIFICATION.m2706a();
        c0545k.h = str2;
        C0437f d = C0432b.m1870a(context).m1886d(str2);
        if (d != null) {
            insertBehavior(context, d, c0545k, new C0544j(str2));
        }
    }

    private void sendResult(Context context, String str, int i) {
        final Object a = C0580j.m2614a(context).m2615a();
        final Object b = C0580j.m2614a(context).m2618b();
        if (TextUtils.isEmpty(a) || TextUtils.isEmpty(b)) {
            C0527a.m2218b(TAG, "Fail Send Public msg result. Token invalid!", context.getApplicationContext());
            return;
        }
        C0527a.m2216a(TAG, "Send Linkhit, msgId = " + str + ", resultCode = " + i, context.getApplicationContext());
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("msgid", str);
            jSONObject.put("result_code", i);
        } catch (JSONException e) {
            C0527a.m2218b(TAG, e.getMessage(), context.getApplicationContext());
        }
        final String jSONObject2 = jSONObject.toString();
        final Context context2 = context;
        C0559d.m2387a().m2388a(new C0420c(this, "PushService-linkhit", (short) 90) {
            /* renamed from: e */
            final /* synthetic */ PublicMsg f1900e;

            /* renamed from: a */
            public void mo1272a() {
                try {
                    HashMap hashMap = new HashMap();
                    C0486b.m2078a(hashMap);
                    hashMap.put("method", "linkhit");
                    hashMap.put("channel_token", b);
                    hashMap.put("data", jSONObject2);
                    if (C0521b.m2163a(C0554h.m2382e() + a, "POST", hashMap).m2162b() == 200) {
                        C0527a.m2219c(PublicMsg.TAG, "<<< public msg send result return OK!", context2.getApplicationContext());
                    }
                } catch (Exception e) {
                    C0527a.m2218b(PublicMsg.TAG, "error : " + e.getMessage(), context2.getApplicationContext());
                }
            }
        });
    }

    private void startApplicationLauncher(Context context, String str, String str2) {
        try {
            Intent parseUri = this.mPkgContent != null ? Intent.parseUri(this.mPkgContent, 0) : new Intent();
            String launcherActivityName = getLauncherActivityName(context, str);
            if (launcherActivityName != null) {
                parseUri.setClassName(str, launcherActivityName);
                parseUri.setFlags(parseUri.getFlags() | RoutePlanFailedSubType.ROUTEPLAN_RESULT_FAIL_PARSE_FAIL);
                parseUri.putExtra("open_type", 1);
                parseUri.putExtra("msgid", str2);
                context.startActivity(parseUri);
            }
        } catch (URISyntaxException e) {
            C0527a.m2218b(TAG, "error " + e.getMessage(), context.getApplicationContext());
        }
    }

    public int describeContents() {
        return 0;
    }

    public String getLauncherActivityName(Context context, String str) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.setPackage(str);
        for (ResolveInfo resolveInfo : context.getPackageManager().queryIntentActivities(intent, 0)) {
            if (resolveInfo.activityInfo != null) {
                return resolveInfo.activityInfo.name;
            }
        }
        return null;
    }

    public void handle(Context context, String str, String str2) {
        int i = 1;
        int i2 = 0;
        C0527a.m2216a(TAG, "--handle--", context.getApplicationContext());
        if ("com.baidu.pushservice.action.publicmsg.DELETE_V2".equals(str)) {
            C0527a.m2216a(TAG, "Public msg deleted by user", context.getApplicationContext());
            sendResult(context, str2, 2);
            return;
        }
        Intent intent;
        PackageManager packageManager = context.getPackageManager();
        try {
            if (packageManager.getPackageInfo(this.mPkgName, 0).versionCode >= this.mPkgVercode) {
                Intent parseUri = Intent.parseUri(this.mPkgContent, 0);
                parseUri.setPackage(this.mPkgName);
                if (packageManager.queryBroadcastReceivers(parseUri, 0).size() > 0) {
                    context.sendBroadcast(parseUri);
                } else if (packageManager.queryIntentActivities(parseUri, 0).size() > 0) {
                    parseUri.addFlags(RoutePlanFailedSubType.ROUTEPLAN_RESULT_FAIL_PARSE_FAIL);
                    context.startActivity(parseUri);
                }
                i2 = i;
                if (i2 == 0) {
                    intent = new Intent("android.intent.action.VIEW");
                    intent.setData(Uri.parse(this.mUrl));
                    intent.addFlags(RoutePlanFailedSubType.ROUTEPLAN_RESULT_FAIL_PARSE_FAIL);
                    try {
                        context.startActivity(intent);
                    } catch (ActivityNotFoundException e) {
                        C0527a.m2218b(TAG, ">>> Url cann't be deal! \r\n" + e.getMessage(), context);
                    }
                }
                sendResult(context, str2, i2);
            }
            i = 0;
            i2 = i;
        } catch (NameNotFoundException e2) {
            C0527a.m2218b(TAG, "package not exist \r\n" + e2.getMessage(), context);
        } catch (URISyntaxException e3) {
            C0527a.m2218b(TAG, "uri to intent fail \r\n" + e3.getMessage(), context);
        } catch (Exception e4) {
            C0527a.m2218b(TAG, "parse customize action error\r\n" + e4.getMessage(), context);
        }
        if (i2 == 0) {
            intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(this.mUrl));
            intent.addFlags(RoutePlanFailedSubType.ROUTEPLAN_RESULT_FAIL_PARSE_FAIL);
            context.startActivity(intent);
        }
        sendResult(context, str2, i2);
    }

    public void handleAlarmMessage(Context context, String str, String str2, String str3) {
        insertNotiBehavior(context, str2, str3, str);
    }

    public void handlePrivateNotification(Context context, String str, String str2, String str3, byte[] bArr, byte[] bArr2) {
        C0527a.m2216a(TAG, "=== Handle private notification: " + str, context);
        if ("com.baidu.android.pushservice.action.privatenotification.DELETE".equals(str)) {
            insertNotiBehavior(context, str2, str3, "010202");
            return;
        }
        PackageManager packageManager = context.getPackageManager();
        try {
            if (packageManager.getPackageInfo(this.mPkgName, 0).versionCode >= this.mPkgVercode) {
                Intent intent = new Intent();
                intent.putExtra("msgid", str2);
                intent.putExtra("notification_title", this.mTitle);
                intent.putExtra("notification_content", this.mDescription);
                intent.putExtra("com.baidu.pushservice.app_id", str3);
                intent.putExtra("baidu_message_secur_info", bArr);
                intent.putExtra("baidu_message_body", bArr2);
                addCustomContentToIntent(intent);
                C0578p.m2545b(context, intent, "com.baidu.android.pushservice.action.notification.CLICK", this.mPkgName);
                insertNotiBehavior(context, str2, str3, "010201");
                if (this.mOpenType == 1 && this.mUrl != null) {
                    Intent intent2 = new Intent();
                    intent2.setAction("android.intent.action.VIEW");
                    intent2.setData(Uri.parse(this.mUrl));
                    intent2.addFlags(RoutePlanFailedSubType.ROUTEPLAN_RESULT_FAIL_PARSE_FAIL);
                    context.startActivity(intent2);
                } else if (this.mOpenType != 2) {
                } else {
                    if (TextUtils.isEmpty(this.mPkgContent)) {
                        startApplicationLauncher(context, this.mPkgName, str2);
                        return;
                    }
                    intent = Intent.parseUri(this.mPkgContent, 0);
                    intent.setPackage(this.mPkgName);
                    if (packageManager.queryBroadcastReceivers(intent, 0).size() > 0) {
                        context.sendBroadcast(intent);
                    } else if (packageManager.queryIntentActivities(intent, 0).size() > 0) {
                        intent.addFlags(RoutePlanFailedSubType.ROUTEPLAN_RESULT_FAIL_PARSE_FAIL);
                        intent.putExtra("open_type", 1);
                        intent.putExtra("msgid", str2);
                        context.startActivity(intent);
                    }
                }
            }
        } catch (NameNotFoundException e) {
            C0527a.m2218b(TAG, "package not exist \r\n" + e.getMessage(), context);
        } catch (URISyntaxException e2) {
            C0527a.m2218b(TAG, "uri to intent fail \r\n" + e2.getMessage(), context);
        }
    }

    public void handleRichMediaNotification(Context context, String str, String str2) {
        C0527a.m2216a(TAG, "Handle rich media notification", context);
        C0545k c0545k = new C0545k();
        if ("com.baidu.android.pushservice.action.media.DELETE".equals(str)) {
            c0545k.d = "010402";
        } else {
            Intent intent = new Intent("com.baidu.android.pushservice.action.media.CLICK");
            intent.setPackage(this.mPkgName);
            intent.putExtra("public_msg", this);
            context.sendBroadcast(intent);
            c0545k.d = "010401";
        }
        c0545k.f1803a = this.mMsgId;
        c0545k.f1805c = C0612l.MSG_TYPE_RICH_MEDIA.m2706a();
        c0545k.e = System.currentTimeMillis();
        c0545k.g = 0;
        c0545k.f = C0532b.m2255b(context);
        c0545k.h = str2;
        C0437f d = C0432b.m1870a(context).m1886d(str2);
        if (d != null) {
            insertBehavior(context, d, c0545k, new C0544j(str2));
        }
    }

    public String toString() {
        return "\r\n mMsgId = " + this.mMsgId + "\r\n mAppId = " + this.mAppId + "\r\n mTitle = " + this.mTitle + "\r\n mDescription = " + this.mDescription + "\r\n mUrl = " + this.mUrl + "\r\n mNetType = " + this.mNetType + "\r\n mSupportAppname = " + this.mSupportAppname + "\r\n mIsSupportApp = " + this.mIsSupportApp + "\r\n mPkgName = " + this.mPkgName + "\r\n mPlgVercode = " + this.mPkgVercode + "\r\n mNotificationBuilder = " + this.mNotificationBuilder + "\r\n mNotificationBasicStyle = " + this.mNotificationBasicStyle + "\r\n mOpenType = " + this.mOpenType + "\r\n mCustomContent = " + this.mCustomContent + "\r\n mIntent = " + this.mPkgContent + "\r\n";
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mMsgId);
        parcel.writeString(this.mAppId);
        parcel.writeString(this.mTitle);
        parcel.writeString(this.mDescription);
        parcel.writeString(this.mUrl);
        parcel.writeString(this.mPkgName);
        parcel.writeInt(this.mPkgVercode);
        parcel.writeInt(this.mNotificationBuilder);
        parcel.writeInt(this.mNotificationBasicStyle);
        parcel.writeInt(this.mOpenType);
        parcel.writeInt(this.mUserConfirm);
        parcel.writeString(this.mCustomContent);
        parcel.writeString(this.mPkgContent);
        parcel.writeInt(this.mAdvertiseStyle);
        parcel.writeString(this.mAdvertiseSmallIconUrl);
        parcel.writeString(this.mAdvertiseLargeIconUrl);
        parcel.writeString(this.mAdvertiseClickUrl);
        parcel.writeString(this.mAdvertiseBigPictureUrl);
        parcel.writeString(this.mAdvertiseBigPictureClickUrl);
        parcel.writeString(this.mAdvertiseDownloadClickUrl);
        parcel.writeString(this.mAdvertiseDetailClickUrl);
        parcel.writeString(this.mAdvertiseBigPictureTitle);
        parcel.writeString(this.mAdvertiseBigPictureContent);
    }
}
