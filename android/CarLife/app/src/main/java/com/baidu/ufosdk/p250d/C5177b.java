package com.baidu.ufosdk.p250d;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.che.codriver.vr.C2848p;
import com.baidu.navisdk.util.statistic.datacheck.regular.Regular;
import com.baidu.ufosdk.util.C5210c;
import java.lang.reflect.Method;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: JsCallJava */
/* renamed from: com.baidu.ufosdk.d.b */
public final class C5177b {
    /* renamed from: a */
    private HashMap f21394a;
    /* renamed from: b */
    private String f21395b;
    /* renamed from: c */
    private String f21396c;

    public C5177b(String str, Class cls) {
        try {
            if (TextUtils.isEmpty(str)) {
                throw new Exception("injected name can not be null");
            }
            this.f21395b = str;
            this.f21394a = new HashMap();
            Method[] declaredMethods = cls.getDeclaredMethods();
            StringBuilder stringBuilder = new StringBuilder("javascript:(function(b){console.log(\"");
            stringBuilder.append(this.f21395b);
            stringBuilder.append(" initialization begin\");");
            stringBuilder.append("var a={queue:[],callback:function(){");
            stringBuilder.append("var d=Array.prototype.slice.call(arguments,0);");
            stringBuilder.append("var c=d.shift();var e=d.shift();this.queue[c].apply(this,d);if(!e){delete this.queue[c]}}};");
            for (Method method : declaredMethods) {
                if (method.getModifiers() == 9) {
                    String a = C5177b.m17566a(method);
                    if (a != null) {
                        this.f21394a.put(a, method);
                        stringBuilder.append(String.format("a.%s=", new Object[]{method.getName()}));
                    }
                }
            }
            stringBuilder.append("function(){var f=Array.prototype.slice.call(arguments,0);if(f.length<1){throw\"");
            stringBuilder.append(this.f21395b);
            stringBuilder.append(" call error, message:miss method name\"}var e=[];for(var h=1;h<f.length;h++)");
            stringBuilder.append("{var c=f[h];var j=typeof c;e[e.length]=j;if(j==\"function\")");
            stringBuilder.append("{var d=a.queue.length;a.queue[d]=c;f[h]=d}}");
            stringBuilder.append("var g=JSON.parse(prompt(JSON.stringify({method:f.shift(),types:e,args:f})));");
            stringBuilder.append("if(g.code!=200){throw\"");
            stringBuilder.append(this.f21395b);
            stringBuilder.append(" call error, code:\"+g.code+\", message:\"+g.result}return g.result};");
            stringBuilder.append("Object.getOwnPropertyNames(a).forEach(function(d){var c=a[d];");
            stringBuilder.append("if(typeof c===\"function\"&&d!==\"callback\"){a[d]=function(){");
            stringBuilder.append("return c.apply(a,[d].concat(Array.prototype.slice.call(arguments,0)))}}});b.");
            stringBuilder.append(this.f21395b);
            stringBuilder.append("=a;console.log(\"");
            stringBuilder.append(this.f21395b);
            stringBuilder.append(" initialization end\")})(window);");
            this.f21396c = stringBuilder.toString();
        } catch (Exception e) {
            C5210c.m17736d("init js error:" + e.getMessage());
        }
    }

    /* renamed from: a */
    private static String m17566a(Method method) {
        String name = method.getName();
        Class[] parameterTypes = method.getParameterTypes();
        int length = parameterTypes.length;
        if (length <= 0 || parameterTypes[0] != WebView.class) {
            C5210c.m17735c("method(" + name + ") must use webview to be first parameter, will be pass");
            return null;
        }
        String str = name;
        for (int i = 1; i < length; i++) {
            Class cls = parameterTypes[i];
            if (cls == String.class) {
                str = new StringBuilder(String.valueOf(str)).append("_S").toString();
            } else if (cls == Integer.TYPE || cls == Long.TYPE || cls == Float.TYPE || cls == Double.TYPE) {
                str = new StringBuilder(String.valueOf(str)).append("_N").toString();
            } else if (cls == Boolean.TYPE) {
                str = new StringBuilder(String.valueOf(str)).append("_B").toString();
            } else if (cls == JSONObject.class) {
                str = new StringBuilder(String.valueOf(str)).append("_O").toString();
            } else if (cls == C5178c.class) {
                str = new StringBuilder(String.valueOf(str)).append("_F").toString();
            } else {
                str = new StringBuilder(String.valueOf(str)).append("_P").toString();
            }
        }
        return str;
    }

    /* renamed from: a */
    public final String m17567a() {
        return this.f21396c;
    }

    /* renamed from: a */
    public final String m17568a(WebView webView, String str) {
        if (TextUtils.isEmpty(str)) {
            return m17565a(str, 500, "call data empty");
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString("method");
            JSONArray jSONArray = jSONObject.getJSONArray("types");
            JSONArray jSONArray2 = jSONObject.getJSONArray("args");
            int length = jSONArray.length();
            Object[] objArr = new Object[(length + 1)];
            int i = 0;
            objArr[0] = webView;
            int i2 = 0;
            while (i2 < length) {
                String str2;
                int i3;
                String optString = jSONArray.optString(i2);
                int i4;
                int i5;
                if (Regular.TYPE_STRING.equals(optString)) {
                    optString = new StringBuilder(String.valueOf(string)).append("_S").toString();
                    i4 = i2 + 1;
                    if (jSONArray2.isNull(i2)) {
                        string = null;
                    } else {
                        string = jSONArray2.getString(i2);
                    }
                    objArr[i4] = string;
                    i5 = i;
                    str2 = optString;
                    i3 = i5;
                } else if (C2848p.aL.equals(optString)) {
                    string = new StringBuilder(String.valueOf(string)).append("_N").toString();
                    i3 = ((i * 10) + i2) + 1;
                    str2 = string;
                } else if ("boolean".equals(optString)) {
                    optString = new StringBuilder(String.valueOf(string)).append("_B").toString();
                    objArr[i2 + 1] = Boolean.valueOf(jSONArray2.getBoolean(i2));
                    i5 = i;
                    str2 = optString;
                    i3 = i5;
                } else if ("object".equals(optString)) {
                    JSONObject jSONObject2;
                    optString = new StringBuilder(String.valueOf(string)).append("_O").toString();
                    i4 = i2 + 1;
                    if (jSONArray2.isNull(i2)) {
                        jSONObject2 = null;
                    } else {
                        jSONObject2 = jSONArray2.getJSONObject(i2);
                    }
                    objArr[i4] = jSONObject2;
                    i5 = i;
                    str2 = optString;
                    i3 = i5;
                } else if ("function".equals(optString)) {
                    optString = new StringBuilder(String.valueOf(string)).append("_F").toString();
                    objArr[i2 + 1] = new C5178c(webView, this.f21395b, jSONArray2.getInt(i2));
                    i5 = i;
                    str2 = optString;
                    i3 = i5;
                } else {
                    i5 = i;
                    str2 = new StringBuilder(String.valueOf(string)).append("_P").toString();
                    i3 = i5;
                }
                i2++;
                string = str2;
                i = i3;
            }
            Method method = (Method) this.f21394a.get(string);
            if (method == null) {
                return m17565a(str, 500, "not found method(" + string + ") with valid parameters");
            }
            if (i > 0) {
                Class[] parameterTypes = method.getParameterTypes();
                while (i > 0) {
                    i2 = i - ((i / 10) * 10);
                    Class cls = parameterTypes[i2];
                    if (cls == Integer.TYPE) {
                        objArr[i2] = Integer.valueOf(jSONArray2.getInt(i2 - 1));
                    } else if (cls == Long.TYPE) {
                        objArr[i2] = Long.valueOf(Long.parseLong(jSONArray2.getString(i2 - 1)));
                    } else {
                        objArr[i2] = Double.valueOf(jSONArray2.getDouble(i2 - 1));
                    }
                    i /= 10;
                }
            }
            return m17565a(str, 200, method.invoke(null, objArr));
        } catch (Exception e) {
            if (e.getCause() != null) {
                return m17565a(str, 500, "method execute error:" + e.getCause().getMessage());
            }
            return m17565a(str, 500, "method execute error:" + e.getMessage());
        }
    }

    @SuppressLint({"DefaultLocale"})
    /* renamed from: a */
    private String m17565a(String str, int i, Object obj) {
        String str2;
        if (obj == null) {
            str2 = "null";
        } else if (obj instanceof String) {
            str2 = "\"" + ((String) obj).replace("\"", "\\\"") + "\"";
        } else if ((obj instanceof Integer) || (obj instanceof Long) || (obj instanceof Boolean) || (obj instanceof Float) || (obj instanceof Double) || (obj instanceof JSONObject)) {
            str2 = String.valueOf(obj);
        } else {
            str2 = "null";
        }
        str2 = String.format("{\"code\": %d, \"result\": %s}", new Object[]{Integer.valueOf(i), str2});
        C5210c.m17732a(this.f21395b + " call json: " + str + " result:" + str2);
        return str2;
    }
}
