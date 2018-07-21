package com.baidu.ufosdk.d;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.webkit.WebView;
import java.lang.reflect.Method;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public final class b
{
  private HashMap a;
  private String b;
  private String c;
  
  public b(String paramString, Class paramClass)
  {
    try
    {
      if (TextUtils.isEmpty(paramString)) {
        throw new Exception("injected name can not be null");
      }
    }
    catch (Exception paramString)
    {
      com.baidu.ufosdk.util.c.d("init js error:" + paramString.getMessage());
      return;
    }
    this.b = paramString;
    this.a = new HashMap();
    paramString = paramClass.getDeclaredMethods();
    paramClass = new StringBuilder("javascript:(function(b){console.log(\"");
    paramClass.append(this.b);
    paramClass.append(" initialization begin\");");
    paramClass.append("var a={queue:[],callback:function(){");
    paramClass.append("var d=Array.prototype.slice.call(arguments,0);");
    paramClass.append("var c=d.shift();var e=d.shift();this.queue[c].apply(this,d);if(!e){delete this.queue[c]}}};");
    int j = paramString.length;
    for (;;)
    {
      if (i >= j)
      {
        paramClass.append("function(){var f=Array.prototype.slice.call(arguments,0);if(f.length<1){throw\"");
        paramClass.append(this.b);
        paramClass.append(" call error, message:miss method name\"}var e=[];for(var h=1;h<f.length;h++)");
        paramClass.append("{var c=f[h];var j=typeof c;e[e.length]=j;if(j==\"function\")");
        paramClass.append("{var d=a.queue.length;a.queue[d]=c;f[h]=d}}");
        paramClass.append("var g=JSON.parse(prompt(JSON.stringify({method:f.shift(),types:e,args:f})));");
        paramClass.append("if(g.code!=200){throw\"");
        paramClass.append(this.b);
        paramClass.append(" call error, code:\"+g.code+\", message:\"+g.result}return g.result};");
        paramClass.append("Object.getOwnPropertyNames(a).forEach(function(d){var c=a[d];");
        paramClass.append("if(typeof c===\"function\"&&d!==\"callback\"){a[d]=function(){");
        paramClass.append("return c.apply(a,[d].concat(Array.prototype.slice.call(arguments,0)))}}});b.");
        paramClass.append(this.b);
        paramClass.append("=a;console.log(\"");
        paramClass.append(this.b);
        paramClass.append(" initialization end\")})(window);");
        this.c = paramClass.toString();
        return;
      }
      Method localMethod = paramString[i];
      if (localMethod.getModifiers() == 9)
      {
        String str = a(localMethod);
        if (str != null)
        {
          this.a.put(str, localMethod);
          paramClass.append(String.format("a.%s=", new Object[] { localMethod.getName() }));
        }
      }
      i += 1;
    }
  }
  
  @SuppressLint({"DefaultLocale"})
  private String a(String paramString, int paramInt, Object paramObject)
  {
    if (paramObject == null) {
      paramObject = "null";
    }
    for (;;)
    {
      paramObject = String.format("{\"code\": %d, \"result\": %s}", new Object[] { Integer.valueOf(paramInt), paramObject });
      com.baidu.ufosdk.util.c.a(this.b + " call json: " + paramString + " result:" + (String)paramObject);
      return (String)paramObject;
      if ((paramObject instanceof String))
      {
        paramObject = ((String)paramObject).replace("\"", "\\\"");
        paramObject = "\"" + paramObject + "\"";
      }
      else if ((!(paramObject instanceof Integer)) && (!(paramObject instanceof Long)) && (!(paramObject instanceof Boolean)) && (!(paramObject instanceof Float)) && (!(paramObject instanceof Double)) && (!(paramObject instanceof JSONObject)))
      {
        paramObject = "null";
      }
      else
      {
        paramObject = String.valueOf(paramObject);
      }
    }
  }
  
  private static String a(Method paramMethod)
  {
    Object localObject = paramMethod.getName();
    Class[] arrayOfClass = paramMethod.getParameterTypes();
    int j = arrayOfClass.length;
    if ((j <= 0) || (arrayOfClass[0] != WebView.class))
    {
      com.baidu.ufosdk.util.c.c("method(" + (String)localObject + ") must use webview to be first parameter, will be pass");
      localObject = null;
    }
    int i;
    do
    {
      return (String)localObject;
      paramMethod = (Method)localObject;
      i = 1;
      localObject = paramMethod;
    } while (i >= j);
    localObject = arrayOfClass[i];
    if (localObject == String.class) {
      paramMethod = paramMethod + "_S";
    }
    for (;;)
    {
      i += 1;
      break;
      if ((localObject == Integer.TYPE) || (localObject == Long.TYPE) || (localObject == Float.TYPE) || (localObject == Double.TYPE)) {
        paramMethod = paramMethod + "_N";
      } else if (localObject == Boolean.TYPE) {
        paramMethod = paramMethod + "_B";
      } else if (localObject == JSONObject.class) {
        paramMethod = paramMethod + "_O";
      } else if (localObject == c.class) {
        paramMethod = paramMethod + "_F";
      } else {
        paramMethod = paramMethod + "_P";
      }
    }
  }
  
  public final String a()
  {
    return this.c;
  }
  
  public final String a(WebView paramWebView, String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      Object localObject1;
      Object[] arrayOfObject;
      int i;
      try
      {
        localObject2 = new JSONObject(paramString);
        localObject1 = ((JSONObject)localObject2).getString("method");
        JSONArray localJSONArray2 = ((JSONObject)localObject2).getJSONArray("types");
        localJSONArray1 = ((JSONObject)localObject2).getJSONArray("args");
        int k = localJSONArray2.length();
        arrayOfObject = new Object[k + 1];
        i = 0;
        arrayOfObject[0] = paramWebView;
        j = 0;
        if (j >= k)
        {
          paramWebView = (Method)this.a.get(localObject1);
          if (paramWebView == null) {
            return a(paramString, 500, "not found method(" + (String)localObject1 + ") with valid parameters");
          }
        }
        else
        {
          localObject2 = localJSONArray2.optString(j);
          if ("string".equals(localObject2))
          {
            localObject2 = localObject1 + "_S";
            if (localJSONArray1.isNull(j))
            {
              localObject1 = null;
              break label651;
            }
            localObject1 = localJSONArray1.getString(j);
            break label651;
          }
          if ("number".equals(localObject2))
          {
            localObject1 = localObject1 + "_N";
            i = i * 10 + j + 1;
            break label664;
          }
          if ("boolean".equals(localObject2))
          {
            localObject1 = localObject1 + "_B";
            arrayOfObject[(j + 1)] = Boolean.valueOf(localJSONArray1.getBoolean(j));
            break label664;
          }
          if ("object".equals(localObject2))
          {
            localObject2 = localObject1 + "_O";
            if (localJSONArray1.isNull(j))
            {
              localObject1 = null;
              break label673;
            }
            localObject1 = localJSONArray1.getJSONObject(j);
            break label673;
          }
          if ("function".equals(localObject2))
          {
            localObject1 = localObject1 + "_F";
            arrayOfObject[(j + 1)] = new c(paramWebView, this.b, localJSONArray1.getInt(j));
            break label664;
          }
          localObject1 = localObject1 + "_P";
          break label664;
        }
        if (i > 0)
        {
          localObject1 = paramWebView.getParameterTypes();
          break label689;
        }
        return a(paramString, 200, paramWebView.invoke(null, arrayOfObject));
      }
      catch (Exception paramWebView)
      {
        JSONArray localJSONArray1;
        if (paramWebView.getCause() == null) {
          continue;
        }
        return a(paramString, 500, "method execute error:" + paramWebView.getCause().getMessage());
        arrayOfObject[j] = Double.valueOf(localJSONArray1.getDouble(j - 1));
        continue;
        return a(paramString, 500, "method execute error:" + paramWebView.getMessage());
      }
      int j = i - i / 10 * 10;
      Object localObject2 = localObject1[j];
      if (localObject2 == Integer.TYPE)
      {
        arrayOfObject[j] = Integer.valueOf(localJSONArray1.getInt(j - 1));
        i /= 10;
      }
      else
      {
        if (localObject2 == Long.TYPE)
        {
          arrayOfObject[j] = Long.valueOf(Long.parseLong(localJSONArray1.getString(j - 1)));
          continue;
        }
        return a(paramString, 500, "call data empty");
        label651:
        arrayOfObject[(j + 1)] = localObject1;
        for (localObject1 = localObject2;; localObject1 = localObject2)
        {
          label664:
          j += 1;
          break;
          label673:
          arrayOfObject[(j + 1)] = localObject1;
        }
      }
      label689:
      if (i > 0) {}
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/ufosdk/d/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */