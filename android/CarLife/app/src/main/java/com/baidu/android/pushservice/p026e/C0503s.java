package com.baidu.android.pushservice.p026e;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.android.pushservice.p031j.C0578p;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.baidu.android.pushservice.e.s */
public class C0503s extends C0487c {
    /* renamed from: d */
    private ArrayList<String> f1624d = new ArrayList();

    public C0503s(C0496l c0496l, Context context) {
        super(c0496l, context);
    }

    /* renamed from: a */
    protected void mo1287a(int i, byte[] bArr) {
        Intent intent = new Intent();
        if (this.b.f1603a.equals("method_list_lapp_tags")) {
            intent.setAction("com.baidu.android.pushservice.action.lapp.RECEIVE");
        } else if (this.b.f1603a.equals("method_list_sdk_tags")) {
            intent.setAction("com.baidu.android.pushservice.action.sdk.RECEIVE");
        } else {
            intent.setAction(PushConstants.ACTION_RECEIVE);
        }
        intent.putExtra("method", this.b.f1603a);
        intent.putExtra(PushConstants.EXTRA_ERROR_CODE, i);
        intent.putExtra("content", bArr);
        if (!this.f1624d.isEmpty()) {
            intent.putStringArrayListExtra("tags_list", this.f1624d);
        }
        intent.setFlags(32);
        mo1285a(intent);
        if (TextUtils.isEmpty(this.b.f1607e)) {
            if (!(this.b.f1603a.equals("method_list_lapp_tags") || this.b.f1603a.equals("method_list_sdk_tags"))) {
                return;
            }
        } else if (!(this.b.f1603a.equals("method_list_lapp_tags") || this.b.f1603a.equals("method_list_sdk_tags"))) {
            intent.setPackage(this.b.f1607e);
        }
        C0578p.m2545b(this.a, intent, intent.getAction(), intent.getPackage());
    }

    /* renamed from: a */
    protected void mo1286a(HashMap<String, String> hashMap) {
        super.mo1286a((HashMap) hashMap);
        hashMap.put("method", "glist");
    }

    /* renamed from: b */
    protected String mo1284b(String str) {
        String b = super.mo1284b(str);
        try {
            JSONArray jSONArray = new JSONObject(b).getJSONObject("response_params").getJSONArray("groups");
            for (int i = 0; i < jSONArray.length(); i++) {
                this.f1624d.add(jSONArray.getJSONObject(i).getString("name"));
            }
        } catch (JSONException e) {
        }
        return b;
    }
}
