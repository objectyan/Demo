package com.baidu.che.codriver.vr;

import android.text.TextUtils;
import com.baidu.carlife.radio.p080b.C2125n;
import com.baidu.che.codriver.p099f.C2535a;
import com.baidu.che.codriver.p099f.C2535a.C1840a;
import com.baidu.che.codriver.p116b.C2519a;
import com.baidu.che.codriver.protocol.data.nlp.NLPResponseData;
import com.baidu.che.codriver.ui.p124d.C2704g;
import com.baidu.che.codriver.util.C2716c;
import com.baidu.che.codriver.util.C2725h;
import com.baidu.che.codriver.util.C2727j;
import com.baidu.navisdk.hudsdk.BNRemoteConstants.ParamKey;
import com.baidu.speech.utils.AsrError;
import com.google.gson.Gson;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ParserHelper */
/* renamed from: com.baidu.che.codriver.vr.j */
public class C2820j implements Comparator<JSONObject> {
    /* renamed from: a */
    private static final String f9205a = "CoDriverVoice-ParserHelper";
    /* renamed from: b */
    private static final String f9206b = "__";
    /* renamed from: e */
    private static int f9207e = 0;
    /* renamed from: f */
    private static final Object f9208f = new Object();
    /* renamed from: c */
    private HashMap<String, Integer> f9209c;
    /* renamed from: d */
    private HashMap<String, C2815d> f9210d;
    /* renamed from: g */
    private C2813i f9211g;
    /* renamed from: h */
    private boolean f9212h = false;

    /* compiled from: ParserHelper */
    /* renamed from: com.baidu.che.codriver.vr.j$a */
    public interface C2758a {
        /* renamed from: a */
        void mo1966a(NLPResponseData nLPResponseData);

        /* renamed from: a */
        void mo1967a(C2848p c2848p);

        /* renamed from: a */
        void mo1968a(String str);
    }

    /* compiled from: ParserHelper */
    /* renamed from: com.baidu.che.codriver.vr.j$b */
    public enum C2819b {
        ONLINE_MODE,
        OFFLINE_MODE,
        ONLINE_AND_OFFLINE_MODE,
        IDLE
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return m10661a((JSONObject) obj, (JSONObject) obj2);
    }

    protected C2820j(HashMap<String, C2815d> localCommandMap) {
        this.f9210d = localCommandMap;
        this.f9209c = new HashMap();
        this.f9209c.put("other", Integer.valueOf(0));
        this.f9209c.put(C2848p.f9320u, Integer.valueOf(1));
        this.f9209c.put(C2848p.f9319t, Integer.valueOf(2));
        this.f9209c.put("flight", Integer.valueOf(3));
        this.f9209c.put("app", Integer.valueOf(4));
        this.f9209c.put(C2848p.f9315p, Integer.valueOf(5));
        this.f9209c.put("player", Integer.valueOf(6));
        this.f9209c.put("music", Integer.valueOf(7));
        this.f9209c.put("telephone", Integer.valueOf(8));
        this.f9209c.put("navigate_instruction", Integer.valueOf(9));
        this.f9209c.put("map", Integer.valueOf(10));
        this.f9209c.put(C2848p.f9309j, Integer.valueOf(11));
    }

    /* renamed from: a */
    protected void m10662a(C2813i interceptor) {
        this.f9211g = interceptor;
    }

    /* renamed from: a */
    protected void m10664a(String json, C2819b mode, C2758a callback) {
        if (callback != null) {
            C2848p result;
            String rawText;
            if (mode == C2819b.OFFLINE_MODE) {
                C2725h.m10207b(f9205a, "using localparse");
                result = new C2848p();
                rawText = m10659b(json, result, callback);
                if (rawText != null) {
                    m10658a(rawText, result, callback);
                }
            } else if (mode == C2819b.ONLINE_MODE) {
                C2725h.m10207b(f9205a, "using nlpParse");
                if (m10659b(json, new C2848p(), callback) != null) {
                    m10663a(m10653a(json), callback);
                }
            } else if (mode == C2819b.ONLINE_AND_OFFLINE_MODE) {
                result = new C2848p();
                rawText = m10659b(json, result, callback);
                if (rawText != null) {
                    boolean localParse = m10658a(rawText, result, callback);
                    C2725h.m10207b(f9205a, "localParse-->" + localParse);
                    if (!localParse) {
                        C2725h.m10207b(f9205a, "using nlpParse");
                        m10663a(rawText, callback);
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private String m10653a(String json) {
        String query = null;
        try {
            query = new JSONObject(json).getJSONArray("results_recognition").getString(0);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return query;
    }

    /* renamed from: a */
    protected void m10663a(String query, C2758a callback) {
        m10665a(null, query, callback);
    }

    /* renamed from: a */
    protected void m10665a(Map<String, Map> map, final String query, final C2758a callback) {
        C2725h.m10207b(f9205a, "using nlpParse ");
        C2848p result;
        if (!C2727j.m10218a(C2716c.m10141a())) {
            result = new C2848p();
            result.m10783a((int) AsrError.ERROR_OFFLINE_RECOGNIZE_FAIL);
            callback.mo1967a(result);
        } else if (TextUtils.isEmpty(query)) {
            result = new C2848p();
            result.m10783a(1);
            callback.mo1967a(result);
        } else if (this.f9211g != null && this.f9211g.mo1976b(query)) {
            C2725h.m10207b(f9205a, "onIntercept  return");
        } else if (!this.f9212h) {
            callback.mo1968a(query);
            this.f9212h = true;
            new C2535a(new C1840a(this) {
                /* renamed from: c */
                final /* synthetic */ C2820j f9199c;

                /* renamed from: a */
                public void mo1691a(String errMsg) {
                    C2725h.m10207b(C2820j.f9205a, "onErrorResponse: " + errMsg);
                    this.f9199c.f9212h = false;
                    C2848p result = new C2848p();
                    result.m10783a(3);
                    callback.mo1967a(result);
                }

                /* renamed from: b */
                public void mo1692b(String s) {
                    C2725h.m10207b(C2820j.f9205a, "onResponse: " + s);
                    this.f9199c.f9212h = false;
                    C2519a.m9552b(s);
                    C2848p result;
                    try {
                        JSONObject allResult = new JSONObject(s);
                        if (allResult.has("result_list")) {
                            result = new C2848p();
                            int error = allResult.optInt(ParamKey.KEY_MSG_ERRORS, 0);
                            result.m10783a(error);
                            if (error != 0) {
                                if (allResult.has("sub_error")) {
                                    result.m10783a(allResult.optInt("sub_error"));
                                }
                                callback.mo1967a(result);
                                return;
                            }
                            JSONObject resultFirst = allResult.getJSONArray("result_list").getJSONObject(0);
                            JSONObject semanticForm = resultFirst.getJSONObject("merged_res").getJSONObject("semantic_form");
                            result.m10790d(semanticForm.optString("raw_text"));
                            result.m10794f(resultFirst.toString());
                            JSONObject finalResult = this.f9199c.m10660b(semanticForm.optString("results"));
                            if (finalResult != null) {
                                result.m10792e(finalResult.toString());
                                result.m10784a(finalResult.optString("domain", "other"));
                                result.m10786b(finalResult.optString("intent"));
                                result.m10788c(finalResult.optString("object"));
                            } else {
                                result.m10783a(1);
                            }
                            result.m10790d(query);
                            callback.mo1967a(result);
                        } else if (allResult.has("result")) {
                            try {
                                NLPResponseData nlpResponseData = (NLPResponseData) new Gson().fromJson(s, NLPResponseData.class);
                                nlpResponseData.listType = m10650c(s);
                                callback.mo1966a(nlpResponseData);
                            } catch (Exception e) {
                                e.printStackTrace();
                                result = new C2848p();
                                result.m10783a(2);
                                callback.mo1967a(result);
                            }
                        } else {
                            result = new C2848p();
                            result.m10783a(2);
                            callback.mo1967a(result);
                        }
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                        result = new C2848p();
                        result.m10783a(2);
                        callback.mo1967a(result);
                    }
                }

                /* renamed from: c */
                private String m10650c(String json) throws JSONException {
                    JSONObject resultFirst = new JSONObject(json).getJSONArray("result").getJSONObject(0);
                    String cardType = "";
                    if (resultFirst != null) {
                        cardType = resultFirst.optString("card_type");
                    }
                    String listType = null;
                    if (!C2704g.f8857p.equals(cardType) && resultFirst.has("data")) {
                        listType = resultFirst.getJSONObject("data").optString("list_type");
                    }
                    JSONObject sbObject = resultFirst.optJSONObject("data");
                    if (sbObject != null) {
                        String sbDomain = sbObject.optString("domain");
                        JSONArray sbList = sbObject.optJSONArray("list");
                        sbObject.optString("list_type");
                    }
                    return listType;
                }
            }).m9622b((Map) map).m9619a(query);
        }
    }

    /* renamed from: b */
    private JSONObject m10660b(String results) throws JSONException {
        if (TextUtils.isEmpty(results)) {
            return null;
        }
        JSONArray array = new JSONArray(results);
        if (array.length() == 1) {
            return array.optJSONObject(0);
        }
        if (array.length() == 0) {
            return null;
        }
        List<JSONObject> maxScoreList = new ArrayList();
        for (int i = 0; i < array.length(); i++) {
            maxScoreList.add(array.optJSONObject(i));
        }
        Collections.sort(maxScoreList, this);
        return (JSONObject) maxScoreList.get(array.length() - 1);
    }

    /* renamed from: a */
    public int m10661a(JSONObject m, JSONObject n) {
        BigDecimal mScore = BigDecimal.valueOf(m.optDouble(C2125n.ag, 0.0d));
        BigDecimal nScore = BigDecimal.valueOf(n.optDouble(C2125n.ag, 0.0d));
        if (mScore.compareTo(nScore) == 0) {
            return ((Integer) this.f9209c.get(m.optString("domain", "other"))).intValue() - ((Integer) this.f9209c.get(n.optString("domain", "other"))).intValue();
        }
        return mScore.compareTo(nScore);
    }

    /* renamed from: a */
    private boolean m10658a(String rawText, C2848p result, C2758a callback) {
        rawText = rawText.toLowerCase(Locale.ENGLISH);
        C2815d grammarModel = (C2815d) this.f9210d.get(rawText.toLowerCase());
        if (grammarModel == null) {
            return false;
        }
        result.m10790d(rawText);
        result.m10784a(grammarModel.f9194a);
        result.m10786b(grammarModel.f9195b);
        result.m10788c(grammarModel.f9196c);
        callback.mo1968a(rawText);
        callback.mo1967a(result);
        return true;
    }

    /* renamed from: a */
    private JSONObject m10655a(JSONObject resultObject) {
        if (resultObject == null) {
            return null;
        }
        try {
            String intent = resultObject.optString("intent");
            JSONObject object = resultObject.optJSONObject("object");
            String[] intentArray = intent.split(f9206b);
            intent = intentArray[0];
            if (intentArray.length >= 3) {
                object.put(intentArray[1], intentArray[2]);
            }
            resultObject.put("intent", intent);
            resultObject.put("object", object);
        } catch (Exception e) {
            e.printStackTrace();
        }
        C2725h.m10207b(f9205a, "resultObject = " + resultObject.toString());
        return resultObject;
    }

    /* renamed from: a */
    private void m10656a(String json, C2848p resultModel) {
        try {
            resultModel.m10792e(m10655a(new JSONArray(new JSONObject(new JSONObject(json).optString("results_nlu")).optString("results")).getJSONObject(0)).toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: b */
    private String m10659b(String json, C2848p result, C2758a callback) {
        try {
            JSONObject allResult = new JSONObject(json);
            int error = allResult.optInt(ParamKey.KEY_MSG_ERRORS, 0);
            result.m10783a(error);
            if (error != 0) {
                if (allResult.has("sub_error")) {
                    error = allResult.optInt("sub_error");
                    result.m10783a(allResult.optInt("sub_error"));
                }
                if (error == AsrError.ERROR_AUDIO_VAD_NO_SPEECH && f9207e != AsrError.ERROR_AUDIO_VAD_NO_SPEECH) {
                    result.m10783a(4);
                }
                f9207e = error;
                callback.mo1967a(result);
                return null;
            }
            f9207e = 0;
            String rawText = m10653a(json);
            if (TextUtils.isEmpty(rawText)) {
                callback.mo1967a(result);
                return null;
            }
            m10656a(json, result);
            return rawText;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
