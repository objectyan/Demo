package com.baidu.tts.tools;

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.channels.FileChannel;

public class FileTools
{
  public static void createDir(String paramString)
  {
    new File(paramString).mkdirs();
  }
  
  public static File createFile(String paramString)
  {
    return getFile(paramString);
  }
  
  public static File createFile(String paramString1, String paramString2)
  {
    return getFile(jointPathAndName(paramString1, paramString2));
  }
  
  public static boolean deleteFile(File paramFile)
  {
    return (!paramFile.exists()) || (paramFile.delete());
  }
  
  public static boolean deleteFile(String paramString)
  {
    return deleteFile(createFile(paramString));
  }
  
  public static String extractFileName(String paramString)
  {
    return paramString.substring(paramString.lastIndexOf(File.separator) + 1);
  }
  
  public static boolean fileCopy(File paramFile1, File paramFile2)
    throws FileNotFoundException
  {
    return fileCopy(new FileInputStream(paramFile1), new FileOutputStream(paramFile2));
  }
  
  public static boolean fileCopy(FileDescriptor paramFileDescriptor1, FileDescriptor paramFileDescriptor2)
  {
    return fileCopy(new FileInputStream(paramFileDescriptor1), new FileOutputStream(paramFileDescriptor2));
  }
  
  public static boolean fileCopy(FileInputStream paramFileInputStream, FileOutputStream paramFileOutputStream)
  {
    try
    {
      boolean bool = fileCopy(paramFileInputStream.getChannel(), paramFileOutputStream.getChannel());
      try
      {
        paramFileInputStream.close();
        paramFileOutputStream.close();
        return bool;
      }
      catch (IOException paramFileInputStream)
      {
        paramFileInputStream.printStackTrace();
        return bool;
      }
      try
      {
        paramFileInputStream.close();
        paramFileOutputStream.close();
        throw ((Throwable)localObject);
      }
      catch (IOException paramFileInputStream)
      {
        for (;;)
        {
          paramFileInputStream.printStackTrace();
        }
      }
    }
    catch (Exception localException)
    {
      localException = localException;
      try
      {
        paramFileInputStream.close();
        paramFileOutputStream.close();
        return false;
      }
      catch (IOException paramFileInputStream)
      {
        paramFileInputStream.printStackTrace();
        return false;
      }
    }
    finally
    {
      localObject = finally;
    }
  }
  
  public static boolean fileCopy(String paramString1, String paramString2)
    throws FileNotFoundException
  {
    return fileCopy(createFile(paramString1), createFile(paramString2));
  }
  
  public static boolean fileCopy(String paramString1, String paramString2, String paramString3, String paramString4)
    throws FileNotFoundException
  {
    return fileCopy(createFile(paramString1, paramString2), createFile(paramString3, paramString4));
  }
  
  public static boolean fileCopy(FileChannel paramFileChannel1, FileChannel paramFileChannel2)
  {
    try
    {
      paramFileChannel1.transferTo(0L, paramFileChannel1.size(), paramFileChannel2);
      try
      {
        paramFileChannel1.close();
        paramFileChannel2.close();
        return true;
      }
      catch (IOException paramFileChannel1)
      {
        paramFileChannel1.printStackTrace();
        return false;
      }
      return false;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
      try
      {
        paramFileChannel1.close();
        paramFileChannel2.close();
        return true;
      }
      catch (IOException paramFileChannel1)
      {
        paramFileChannel1.printStackTrace();
        return false;
      }
    }
    finally
    {
      try
      {
        paramFileChannel1.close();
        paramFileChannel2.close();
        return true;
      }
      catch (IOException paramFileChannel1)
      {
        paramFileChannel1.printStackTrace();
      }
    }
  }
  
  public static File getFile(String paramString)
  {
    File localFile = new File(paramString);
    if (localFile.exists()) {}
    for (;;)
    {
      if (!localFile.exists()) {}
      try
      {
        localFile.createNewFile();
        return localFile;
      }
      catch (IOException paramString)
      {
        paramString.printStackTrace();
      }
      if (paramString.endsWith(File.separator))
      {
        localFile.mkdirs();
      }
      else
      {
        paramString = new File(paramString.substring(0, paramString.lastIndexOf(File.separator)));
        if (!paramString.exists()) {
          paramString.mkdirs();
        }
      }
    }
    return localFile;
  }
  
  public static File getFile(String paramString1, String paramString2)
  {
    return getFile(jointPathAndName(paramString1, paramString2));
  }
  
  public static boolean isFileExist(String paramString)
  {
    return new File(paramString).exists();
  }
  
  public static boolean isFileExist(Object... paramVarArgs)
  {
    if (paramVarArgs.length == 1)
    {
      paramVarArgs = paramVarArgs[0];
      if ((paramVarArgs instanceof File)) {
        paramVarArgs = (File)paramVarArgs;
      }
    }
    for (;;)
    {
      if (paramVarArgs != null)
      {
        return paramVarArgs.exists();
        if ((paramVarArgs instanceof String))
        {
          paramVarArgs = createFile((String)paramVarArgs);
          continue;
          if (paramVarArgs.length == 2)
          {
            paramVarArgs = createFile((String)paramVarArgs[0], (String)paramVarArgs[1]);
            continue;
          }
          throw new UnknownError();
        }
      }
      else
      {
        return false;
      }
      paramVarArgs = null;
    }
  }
  
  public static String jointPathAndName(String paramString1, String paramString2)
  {
    if (paramString1.endsWith(File.separator)) {
      return paramString1 + paramString2;
    }
    return paramString1 + File.separator + paramString2;
  }
  
  public static boolean writeFile(String paramString, File paramFile)
  {
    try
    {
      if (paramFile.exists()) {}
      for (;;)
      {
        paramFile = new FileWriter(paramFile, false);
        paramFile.write(paramString);
        paramFile.flush();
        paramFile.close();
        return true;
        paramFile.createNewFile();
      }
      return false;
    }
    catch (IOException paramString)
    {
      paramString.printStackTrace();
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/tts/tools/FileTools.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */