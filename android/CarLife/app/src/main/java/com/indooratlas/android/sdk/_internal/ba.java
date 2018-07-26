package com.indooratlas.android.sdk._internal;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import com.indooratlas.android.sdk._internal.bg.C5819a;
import com.indooratlas.android.sdk.resources.IAFloorPlan;
import com.indooratlas.android.sdk.resources.IAResourceManager;
import com.indooratlas.android.sdk.resources.IATask;
import java.io.IOException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class ba extends IAResourceManager {
    /* renamed from: a */
    private ac f23070a;
    /* renamed from: b */
    private bg f23071b;

    /* renamed from: com.indooratlas.android.sdk._internal.ba$a */
    static class C5788a extends C6015z<IAFloorPlan> {
        C5788a() {
        }

        /* renamed from: a */
        public final /* synthetic */ Object m19977a(C6013x c6013x) throws IOException {
            return C5788a.m19976c(c6013x);
        }

        /* renamed from: c */
        private static IAFloorPlan m19976c(C6013x c6013x) throws IOException {
            Throwable e;
            Object obj;
            IAFloorPlan iAFloorPlan = null;
            try {
                JSONArray jSONArray = new JSONArray(c6013x.d());
                try {
                    int length = jSONArray.length();
                    if (length > 0) {
                        for (int i = 0; i < length; i++) {
                            JSONObject jSONObject = jSONArray.getJSONObject(i);
                            if (jSONObject.has("idaFloorPlan")) {
                                int i2 = jSONObject.getInt("width");
                                int i3 = jSONObject.getInt("height");
                                String optString = jSONObject.optString("url");
                                JSONObject jSONObject2 = jSONObject.getJSONObject("idaFloorPlan");
                                String string = jSONObject2.getString("id");
                                String string2 = jSONObject2.getString("name");
                                int i4 = jSONObject2.getInt("floorLevel");
                                jSONObject2 = jSONObject.getJSONObject("transformations");
                                iAFloorPlan = new IAFloorPlan(string, string2, optString, i2, i3, i4, cn.m20233a(jSONObject2.getJSONArray("pixelToWgs")), cn.m20233a(jSONObject2.getJSONArray("wgsToPixel")));
                                break;
                            }
                        }
                        new Object[1][0] = jSONArray;
                    }
                    return iAFloorPlan;
                } catch (JSONException e2) {
                    e = e2;
                    obj = jSONArray;
                    new Object[1][0] = obj;
                    throw new IOException(e);
                }
            } catch (Throwable e3) {
                Throwable th = e3;
                IAFloorPlan iAFloorPlan2 = null;
                e = th;
                new Object[1][0] = obj;
                throw new IOException(e);
            }
        }
    }

    public ba(@NonNull Context context, Bundle bundle) throws IllegalStateException {
        try {
            C5819a c5819a = new C5819a(context);
            c5819a.f23182a = bundle;
            this.f23071b = c5819a.m20094a();
        } catch (Throwable e) {
            ee.m20409a("IASDK", e.getMessage(), new Object[0]);
            throw new IllegalStateException(e);
        }
    }

    public final IATask<IAFloorPlan> fetchFloorPlanWithId(@NonNull String floorPlanId) {
        if (this.f23070a == null) {
            bg bgVar = this.f23071b;
            ac aoVar = new ao(bgVar.f23190a, ct.m20253a());
            aoVar.m19787a(bgVar.f23191b, bgVar.f23192c);
            aoVar.m19786a("IAWire");
            this.f23070a = aoVar;
        }
        return new cm(this.f23070a.mo4596a(new C5788a(), floorPlanId));
    }
}
