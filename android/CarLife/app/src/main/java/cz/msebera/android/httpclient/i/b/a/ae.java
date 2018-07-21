package cz.msebera.android.httpclient.i.b.a;

import cz.msebera.android.httpclient.annotation.Immutable;
import cz.msebera.android.httpclient.n;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@Immutable
class ae
{
  static void a(n paramn)
    throws IOException
  {
    if (paramn == null) {}
    do
    {
      do
      {
        return;
      } while (!paramn.isStreaming());
      paramn = paramn.getContent();
    } while (paramn == null);
    paramn.close();
  }
  
  static void a(Closeable paramCloseable)
  {
    try
    {
      paramCloseable.close();
      return;
    }
    catch (IOException paramCloseable) {}
  }
  
  /* Error */
  static void a(java.io.File paramFile1, java.io.File paramFile2)
    throws IOException
  {
    // Byte code:
    //   0: new 37	java/io/RandomAccessFile
    //   3: dup
    //   4: aload_0
    //   5: ldc 39
    //   7: invokespecial 42	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   10: astore_0
    //   11: new 37	java/io/RandomAccessFile
    //   14: dup
    //   15: aload_1
    //   16: ldc 44
    //   18: invokespecial 42	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   21: astore_1
    //   22: aload_0
    //   23: invokevirtual 48	java/io/RandomAccessFile:getChannel	()Ljava/nio/channels/FileChannel;
    //   26: astore_2
    //   27: aload_1
    //   28: invokevirtual 48	java/io/RandomAccessFile:getChannel	()Ljava/nio/channels/FileChannel;
    //   31: astore_3
    //   32: aload_2
    //   33: lconst_0
    //   34: aload_0
    //   35: invokevirtual 52	java/io/RandomAccessFile:length	()J
    //   38: aload_3
    //   39: invokevirtual 58	java/nio/channels/FileChannel:transferTo	(JJLjava/nio/channels/WritableByteChannel;)J
    //   42: pop2
    //   43: aload_2
    //   44: invokevirtual 59	java/nio/channels/FileChannel:close	()V
    //   47: aload_3
    //   48: invokevirtual 59	java/nio/channels/FileChannel:close	()V
    //   51: aload_0
    //   52: invokevirtual 60	java/io/RandomAccessFile:close	()V
    //   55: aload_1
    //   56: invokevirtual 60	java/io/RandomAccessFile:close	()V
    //   59: return
    //   60: astore 4
    //   62: aload_2
    //   63: invokestatic 62	cz/msebera/android/httpclient/i/b/a/ae:a	(Ljava/io/Closeable;)V
    //   66: aload_3
    //   67: invokestatic 62	cz/msebera/android/httpclient/i/b/a/ae:a	(Ljava/io/Closeable;)V
    //   70: aload 4
    //   72: athrow
    //   73: astore_2
    //   74: aload_0
    //   75: invokestatic 62	cz/msebera/android/httpclient/i/b/a/ae:a	(Ljava/io/Closeable;)V
    //   78: aload_1
    //   79: invokestatic 62	cz/msebera/android/httpclient/i/b/a/ae:a	(Ljava/io/Closeable;)V
    //   82: aload_2
    //   83: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	84	0	paramFile1	java.io.File
    //   0	84	1	paramFile2	java.io.File
    //   26	37	2	localFileChannel1	java.nio.channels.FileChannel
    //   73	10	2	localIOException1	IOException
    //   31	36	3	localFileChannel2	java.nio.channels.FileChannel
    //   60	11	4	localIOException2	IOException
    // Exception table:
    //   from	to	target	type
    //   32	51	60	java/io/IOException
    //   22	32	73	java/io/IOException
    //   51	59	73	java/io/IOException
    //   62	73	73	java/io/IOException
  }
  
  static void a(InputStream paramInputStream, OutputStream paramOutputStream)
    throws IOException
  {
    byte[] arrayOfByte = new byte['ࠀ'];
    for (;;)
    {
      int i = paramInputStream.read(arrayOfByte);
      if (i == -1) {
        break;
      }
      paramOutputStream.write(arrayOfByte, 0, i);
    }
  }
  
  static void b(InputStream paramInputStream, OutputStream paramOutputStream)
    throws IOException
  {
    try
    {
      a(paramInputStream, paramOutputStream);
      paramInputStream.close();
      paramOutputStream.close();
      return;
    }
    catch (IOException localIOException)
    {
      a(paramInputStream);
      a(paramOutputStream);
      throw localIOException;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/i/b/a/ae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */