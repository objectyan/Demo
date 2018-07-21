package b.a.a;

import java.io.IOException;
import okio.Buffer;
import okio.ForwardingSink;
import okio.Sink;

class e
  extends ForwardingSink
{
  private boolean a;
  
  public e(Sink paramSink)
  {
    super(paramSink);
  }
  
  protected void a(IOException paramIOException) {}
  
  public void close()
    throws IOException
  {
    if (this.a) {
      return;
    }
    try
    {
      super.close();
      return;
    }
    catch (IOException localIOException)
    {
      this.a = true;
      a(localIOException);
    }
  }
  
  public void flush()
    throws IOException
  {
    if (this.a) {
      return;
    }
    try
    {
      super.flush();
      return;
    }
    catch (IOException localIOException)
    {
      this.a = true;
      a(localIOException);
    }
  }
  
  public void write(Buffer paramBuffer, long paramLong)
    throws IOException
  {
    if (this.a)
    {
      paramBuffer.skip(paramLong);
      return;
    }
    try
    {
      super.write(paramBuffer, paramLong);
      return;
    }
    catch (IOException paramBuffer)
    {
      this.a = true;
      a(paramBuffer);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/b/a/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */