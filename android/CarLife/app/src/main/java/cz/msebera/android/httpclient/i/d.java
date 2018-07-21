package cz.msebera.android.httpclient.i;

import cz.msebera.android.httpclient.d.a;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CodingErrorAction;

public final class d
{
  public static CharsetDecoder a(a parama)
  {
    if (parama == null) {}
    Object localObject1;
    CodingErrorAction localCodingErrorAction;
    do
    {
      return null;
      localObject2 = parama.c();
      localObject1 = parama.d();
      localCodingErrorAction = parama.e();
    } while (localObject2 == null);
    Object localObject2 = ((Charset)localObject2).newDecoder();
    if (localObject1 != null)
    {
      parama = (a)localObject1;
      localObject1 = ((CharsetDecoder)localObject2).onMalformedInput(parama);
      if (localCodingErrorAction == null) {
        break label61;
      }
    }
    label61:
    for (parama = localCodingErrorAction;; parama = CodingErrorAction.REPORT)
    {
      return ((CharsetDecoder)localObject1).onUnmappableCharacter(parama);
      parama = CodingErrorAction.REPORT;
      break;
    }
  }
  
  public static CharsetEncoder b(a parama)
  {
    if (parama == null) {}
    do
    {
      return null;
      localObject2 = parama.c();
    } while (localObject2 == null);
    Object localObject1 = parama.d();
    CodingErrorAction localCodingErrorAction = parama.e();
    Object localObject2 = ((Charset)localObject2).newEncoder();
    if (localObject1 != null)
    {
      parama = (a)localObject1;
      localObject1 = ((CharsetEncoder)localObject2).onMalformedInput(parama);
      if (localCodingErrorAction == null) {
        break label61;
      }
    }
    label61:
    for (parama = localCodingErrorAction;; parama = CodingErrorAction.REPORT)
    {
      return ((CharsetEncoder)localObject1).onUnmappableCharacter(parama);
      parama = CodingErrorAction.REPORT;
      break;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/i/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */