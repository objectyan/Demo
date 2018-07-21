package a;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class a
  extends Exception
{
  private static final long a = 1L;
  private static final String b = "There were multiple errors.";
  private List<Throwable> c;
  
  public a(String paramString, List<? extends Throwable> paramList) {}
  
  public a(String paramString, Throwable[] paramArrayOfThrowable)
  {
    this(paramString, Arrays.asList(paramArrayOfThrowable));
  }
  
  public a(List<? extends Throwable> paramList)
  {
    this("There were multiple errors.", paramList);
  }
  
  public List<Throwable> a()
  {
    return this.c;
  }
  
  @Deprecated
  public List<Exception> b()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.c == null) {}
    for (;;)
    {
      return localArrayList;
      Iterator localIterator = this.c.iterator();
      while (localIterator.hasNext())
      {
        Throwable localThrowable = (Throwable)localIterator.next();
        if ((localThrowable instanceof Exception)) {
          localArrayList.add((Exception)localThrowable);
        } else {
          localArrayList.add(new Exception(localThrowable));
        }
      }
    }
  }
  
  @Deprecated
  public Throwable[] c()
  {
    return (Throwable[])this.c.toArray(new Throwable[this.c.size()]);
  }
  
  public void printStackTrace(PrintStream paramPrintStream)
  {
    super.printStackTrace(paramPrintStream);
    int i = -1;
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext())
    {
      Throwable localThrowable = (Throwable)localIterator.next();
      paramPrintStream.append("\n");
      paramPrintStream.append("  Inner throwable #");
      i += 1;
      paramPrintStream.append(Integer.toString(i));
      paramPrintStream.append(": ");
      localThrowable.printStackTrace(paramPrintStream);
      paramPrintStream.append("\n");
    }
  }
  
  public void printStackTrace(PrintWriter paramPrintWriter)
  {
    super.printStackTrace(paramPrintWriter);
    int i = -1;
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext())
    {
      Throwable localThrowable = (Throwable)localIterator.next();
      paramPrintWriter.append("\n");
      paramPrintWriter.append("  Inner throwable #");
      i += 1;
      paramPrintWriter.append(Integer.toString(i));
      paramPrintWriter.append(": ");
      localThrowable.printStackTrace(paramPrintWriter);
      paramPrintWriter.append("\n");
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */