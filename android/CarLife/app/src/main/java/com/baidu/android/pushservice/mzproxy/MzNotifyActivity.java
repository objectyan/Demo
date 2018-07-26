package com.baidu.android.pushservice.mzproxy;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.android.pushservice.PushManager;
import com.baidu.baidunavis.BaiduNaviParams.RoutePlanFailedSubType;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public class MzNotifyActivity extends Activity {
    /* renamed from: a */
    private String f1978a;
    /* renamed from: b */
    private String f1979b;
    /* renamed from: c */
    private String f1980c;
    /* renamed from: d */
    private String f1981d = null;
    /* renamed from: e */
    private String f1982e;

    /* renamed from: a */
    private String m2773a(Context context, String str) {
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

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            Object stringExtra = getIntent().getStringExtra("extras");
            if (!TextUtils.isEmpty(stringExtra)) {
                JSONObject jSONObject = new JSONObject("{\"extras\":" + stringExtra + "}");
                if (!jSONObject.isNull("extras")) {
                    JSONArray jSONArray = jSONObject.getJSONArray("extras");
                    if (jSONArray != null) {
                        for (int i = 0; i < jSONArray.length(); i++) {
                            jSONObject = jSONArray.getJSONObject(i);
                            if (!jSONObject.isNull("Msgid")) {
                                this.f1978a = jSONObject.getString("Msgid");
                            }
                            if (!jSONObject.isNull("msgBody")) {
                                this.f1980c = jSONObject.getString("msgBody");
                            }
                        }
                        if (!TextUtils.isEmpty(this.f1980c)) {
                            JSONObject jSONObject2 = new JSONObject(this.f1980c);
                            if (!jSONObject2.isNull("custom_content")) {
                                this.f1981d = jSONObject2.getString("custom_content");
                            }
                            if (!jSONObject2.isNull("pkg_content")) {
                                this.f1982e = jSONObject2.getString("pkg_content");
                            }
                            if (!jSONObject2.isNull("mzsigninfo")) {
                                this.f1979b = jSONObject2.getString("mzsigninfo");
                            }
                        }
                    }
                }
                if (PushManager.hwMessageVerify(this, this.f1979b, (this.f1978a + this.f1981d).replaceAll("\\\\", ""))) {
                    Intent intent;
                    Intent intent2;
                    if (TextUtils.isEmpty(this.f1982e)) {
                        intent2 = new Intent();
                        intent2.setClassName(getPackageName(), m2773a(this, getPackageName()));
                        intent2.setFlags(RoutePlanFailedSubType.ROUTEPLAN_RESULT_FAIL_PARSE_FAIL);
                        intent = intent2;
                    } else {
                        intent2 = Intent.parseUri(this.f1982e, 0);
                        intent2.setPackage(getPackageName());
                        intent2.addFlags(RoutePlanFailedSubType.ROUTEPLAN_RESULT_FAIL_PARSE_FAIL);
                        intent = intent2;
                    }
                    jSONObject = new JSONObject(this.f1981d);
                    Iterator keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String str = (String) keys.next();
                        intent.putExtra(str, jSONObject.optString(str));
                    }
                    if (getPackageManager().queryIntentActivities(intent, 0).size() > 0) {
                        startActivity(intent);
                    }
                }
            }
        } catch (Exception e) {
        }
        finish();
    }
}
