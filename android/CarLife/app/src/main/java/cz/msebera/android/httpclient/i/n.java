package cz.msebera.android.httpclient.i;

import cz.msebera.android.httpclient.al;
import cz.msebera.android.httpclient.annotation.Immutable;
import cz.msebera.android.httpclient.o.a;
import java.util.Locale;

@Immutable
public class n
  implements al
{
  public static final n a = new n();
  private static final String[][] b = { null, new String[3], new String[8], new String[8], new String[25], new String[8] };
  
  static
  {
    a(200, "OK");
    a(201, "Created");
    a(202, "Accepted");
    a(204, "No Content");
    a(301, "Moved Permanently");
    a(302, "Moved Temporarily");
    a(304, "Not Modified");
    a(400, "Bad Request");
    a(401, "Unauthorized");
    a(403, "Forbidden");
    a(404, "Not Found");
    a(500, "Internal Server Error");
    a(501, "Not Implemented");
    a(502, "Bad Gateway");
    a(503, "Service Unavailable");
    a(100, "Continue");
    a(307, "Temporary Redirect");
    a(405, "Method Not Allowed");
    a(409, "Conflict");
    a(412, "Precondition Failed");
    a(413, "Request Too Long");
    a(414, "Request-URI Too Long");
    a(415, "Unsupported Media Type");
    a(300, "Multiple Choices");
    a(303, "See Other");
    a(305, "Use Proxy");
    a(402, "Payment Required");
    a(406, "Not Acceptable");
    a(407, "Proxy Authentication Required");
    a(408, "Request Timeout");
    a(101, "Switching Protocols");
    a(203, "Non Authoritative Information");
    a(205, "Reset Content");
    a(206, "Partial Content");
    a(504, "Gateway Timeout");
    a(505, "Http Version Not Supported");
    a(410, "Gone");
    a(411, "Length Required");
    a(416, "Requested Range Not Satisfiable");
    a(417, "Expectation Failed");
    a(102, "Processing");
    a(207, "Multi-Status");
    a(422, "Unprocessable Entity");
    a(419, "Insufficient Space On Resource");
    a(420, "Method Failure");
    a(423, "Locked");
    a(507, "Insufficient Storage");
    a(424, "Failed Dependency");
  }
  
  private static void a(int paramInt, String paramString)
  {
    int i = paramInt / 100;
    b[i][(paramInt - i * 100)] = paramString;
  }
  
  public String a(int paramInt, Locale paramLocale)
  {
    if ((paramInt >= 100) && (paramInt < 600)) {}
    for (boolean bool = true;; bool = false)
    {
      a.a(bool, "Unknown category for status code " + paramInt);
      int i = paramInt / 100;
      paramInt -= i * 100;
      paramLocale = null;
      if (b[i].length > paramInt) {
        paramLocale = b[i][paramInt];
      }
      return paramLocale;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/i/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */