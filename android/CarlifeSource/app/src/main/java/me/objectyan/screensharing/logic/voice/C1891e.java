package com.baidu.carlife.logic.voice;

import android.text.TextUtils;
import com.baidu.carlife.model.C1942q;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ParseHelper */
/* renamed from: com.baidu.carlife.logic.voice.e */
public class C1891e {
    /* renamed from: a */
    public static C1942q m7240a(String result) {
        JSONException e;
        C1942q model = null;
        if (!TextUtils.isEmpty(result)) {
            try {
                String tempStr = new JSONObject(new JSONObject(new JSONObject(new JSONObject(result).getString("result") + "").getString("json_res") + "").getString("merged_res") + "").getString("semantic_form") + "";
                if (!TextUtils.isEmpty(tempStr)) {
                    JSONObject tempJson = new JSONObject(tempStr);
                    if (tempJson != null) {
                        JSONObject jsonResult = tempJson.optJSONArray("results").getJSONObject(0);
                        String domain = jsonResult.getString("domain") + "";
                        C1942q model2 = new C1942q(domain);
                        try {
                            model2.f6161H = tempJson.getString("raw_text") + "";
                            if (domain.isEmpty()) {
                                model = model2;
                                return model2;
                            }
                            model2.f6160G = jsonResult.getString("intent") + "";
                            JSONObject content;
                            if (model2.f6159F.equals("music")) {
                                if (model2.f6160G.equals("play") || model2.f6160G.equals("search")) {
                                    content = jsonResult.optJSONObject("object");
                                    if (content != null) {
                                        if (!content.isNull("singer")) {
                                            model2.f6162I.f6119b = content.getString("singer");
                                        }
                                        if (!content.isNull("song")) {
                                            model2.f6162I.f6118a = content.getString("song");
                                            model = model2;
                                        }
                                    }
                                } else if (model2.f6160G.equals(C1942q.f6135c)) {
                                    content = jsonResult.getJSONObject("object");
                                    if (!content.isNull("operation")) {
                                        model2.f6162I.f6121d = content.getString("operation");
                                        model = model2;
                                    }
                                }
                            } else if (model2.f6159F.equals("contact")) {
                                if (model2.f6160G.equals("call")) {
                                    content = jsonResult.getJSONObject("object");
                                    if (!content.isNull("name")) {
                                        model2.f6164K.f6126b = content.getString("name");
                                    }
                                    if (!content.isNull("phone_number")) {
                                        model2.f6164K.f6125a = content.getString("phone_number");
                                        model = model2;
                                    }
                                }
                            } else if (model2.f6159F.equals(C1942q.f6145m)) {
                                if (model2.f6160G.equals(C1942q.f6146n)) {
                                    content = jsonResult.getJSONObject("object");
                                    if (!content.isNull("entity")) {
                                        model2.f6165L.f6123a = content.getString("entity");
                                        model = model2;
                                    }
                                }
                            } else if (model2.f6159F.equals("map")) {
                                if (model2.f6160G.equals("nearby")) {
                                    content = jsonResult.getJSONObject("object");
                                    if (!content.isNull("nearby")) {
                                        model2.f6163J.f6116c = content.getString("nearby");
                                    }
                                    if (!content.isNull("poi_type")) {
                                        model2.f6163J.f6115b = content.getString("poi_type");
                                        model = model2;
                                    }
                                } else if (model2.f6160G.equals("route")) {
                                    content = jsonResult.getJSONObject("object");
                                    if (!content.isNull(C1942q.f6129B)) {
                                        model2.f6163J.f6114a = content.getString(C1942q.f6129B);
                                        model = model2;
                                    }
                                }
                            } else if (model2.f6159F.equals("other")) {
                                model = model2;
                                return model2;
                            }
                            model = model2;
                        } catch (JSONException e2) {
                            e = e2;
                            model = model2;
                            e.printStackTrace();
                            return null;
                        }
                    }
                }
            } catch (JSONException e3) {
                e = e3;
                e.printStackTrace();
                return null;
            }
        }
        return model;
    }
}
