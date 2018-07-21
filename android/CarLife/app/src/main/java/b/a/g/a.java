package b.a.g;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import okio.Okio;
import okio.Sink;
import okio.Source;

public abstract interface a
{
  public static final a a = new a()
  {
    public Source a(File paramAnonymousFile)
      throws FileNotFoundException
    {
      return Okio.source(paramAnonymousFile);
    }
    
    public void a(File paramAnonymousFile1, File paramAnonymousFile2)
      throws IOException
    {
      d(paramAnonymousFile2);
      if (!paramAnonymousFile1.renameTo(paramAnonymousFile2)) {
        throw new IOException("failed to rename " + paramAnonymousFile1 + " to " + paramAnonymousFile2);
      }
    }
    
    public Sink b(File paramAnonymousFile)
      throws FileNotFoundException
    {
      try
      {
        Sink localSink = Okio.sink(paramAnonymousFile);
        return localSink;
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        paramAnonymousFile.getParentFile().mkdirs();
      }
      return Okio.sink(paramAnonymousFile);
    }
    
    public Sink c(File paramAnonymousFile)
      throws FileNotFoundException
    {
      try
      {
        Sink localSink = Okio.appendingSink(paramAnonymousFile);
        return localSink;
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        paramAnonymousFile.getParentFile().mkdirs();
      }
      return Okio.appendingSink(paramAnonymousFile);
    }
    
    public void d(File paramAnonymousFile)
      throws IOException
    {
      if ((!paramAnonymousFile.delete()) && (paramAnonymousFile.exists())) {
        throw new IOException("failed to delete " + paramAnonymousFile);
      }
    }
    
    public boolean e(File paramAnonymousFile)
    {
      return paramAnonymousFile.exists();
    }
    
    public long f(File paramAnonymousFile)
    {
      return paramAnonymousFile.length();
    }
    
    public void g(File paramAnonymousFile)
      throws IOException
    {
      File[] arrayOfFile = paramAnonymousFile.listFiles();
      if (arrayOfFile == null) {
        throw new IOException("not a readable directory: " + paramAnonymousFile);
      }
      int j = arrayOfFile.length;
      int i = 0;
      while (i < j)
      {
        paramAnonymousFile = arrayOfFile[i];
        if (paramAnonymousFile.isDirectory()) {
          g(paramAnonymousFile);
        }
        if (!paramAnonymousFile.delete()) {
          throw new IOException("failed to delete " + paramAnonymousFile);
        }
        i += 1;
      }
    }
  };
  
  public abstract Source a(File paramFile)
    throws FileNotFoundException;
  
  public abstract void a(File paramFile1, File paramFile2)
    throws IOException;
  
  public abstract Sink b(File paramFile)
    throws FileNotFoundException;
  
  public abstract Sink c(File paramFile)
    throws FileNotFoundException;
  
  public abstract void d(File paramFile)
    throws IOException;
  
  public abstract boolean e(File paramFile);
  
  public abstract long f(File paramFile);
  
  public abstract void g(File paramFile)
    throws IOException;
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/b/a/g/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */