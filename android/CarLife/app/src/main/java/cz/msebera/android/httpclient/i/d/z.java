package cz.msebera.android.httpclient.i.d;

import cz.msebera.android.httpclient.annotation.Immutable;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collection;

@Immutable
public class z
{
  private static final int a = 256;
  private final y b;
  
  z(y paramy)
  {
    this.b = paramy;
  }
  
  private boolean a(Reader paramReader, StringBuilder paramStringBuilder)
    throws IOException
  {
    boolean bool = false;
    paramStringBuilder.setLength(0);
    int i = 0;
    do
    {
      int j = paramReader.read();
      char c;
      if (j != -1)
      {
        c = (char)j;
        if (c != '\n') {}
      }
      else
      {
        if (j != -1) {
          bool = true;
        }
        return bool;
      }
      if (Character.isWhitespace(c)) {
        i = 1;
      }
      if (i == 0) {
        paramStringBuilder.append(c);
      }
    } while (paramStringBuilder.length() <= 256);
    throw new IOException("Line too long");
  }
  
  public void a(Reader paramReader)
    throws IOException
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    BufferedReader localBufferedReader = new BufferedReader(paramReader);
    StringBuilder localStringBuilder = new StringBuilder(256);
    boolean bool1 = true;
    while (bool1)
    {
      boolean bool2 = a(localBufferedReader, localStringBuilder);
      Object localObject = localStringBuilder.toString();
      bool1 = bool2;
      if (((String)localObject).length() != 0)
      {
        bool1 = bool2;
        if (!((String)localObject).startsWith("//"))
        {
          paramReader = (Reader)localObject;
          if (((String)localObject).startsWith(".")) {
            paramReader = ((String)localObject).substring(1);
          }
          bool1 = paramReader.startsWith("!");
          localObject = paramReader;
          if (bool1) {
            localObject = paramReader.substring(1);
          }
          if (bool1)
          {
            localArrayList2.add(localObject);
            bool1 = bool2;
          }
          else
          {
            localArrayList1.add(localObject);
            bool1 = bool2;
          }
        }
      }
    }
    this.b.a(localArrayList1);
    this.b.b(localArrayList2);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/i/d/z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */