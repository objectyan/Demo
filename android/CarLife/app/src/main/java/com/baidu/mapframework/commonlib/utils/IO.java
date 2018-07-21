package com.baidu.mapframework.commonlib.utils;

import com.baidu.platform.comapi.util.f;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class IO
{
  private static final String a = IO.class.getName();
  private static final int b = 8192;
  
  private static void a(File paramFile1, File paramFile2, FileFilter paramFileFilter, boolean paramBoolean, List<String> paramList)
    throws IOException
  {
    if (paramFileFilter == null) {}
    for (File[] arrayOfFile = paramFile1.listFiles(); arrayOfFile == null; arrayOfFile = paramFile1.listFiles(paramFileFilter)) {
      throw new IOException("Failed to list contents of " + paramFile1);
    }
    if (paramFile2.exists())
    {
      if (!paramFile2.isDirectory()) {
        throw new IOException("Destination '" + paramFile2 + "' exists but is not a directory");
      }
    }
    else if ((!paramFile2.mkdirs()) && (!paramFile2.isDirectory())) {
      throw new IOException("Destination '" + paramFile2 + "' directory cannot be created");
    }
    if (!paramFile2.canWrite()) {
      throw new IOException("Destination '" + paramFile2 + "' cannot be written to");
    }
    int j = arrayOfFile.length;
    int i = 0;
    if (i < j)
    {
      File localFile1 = arrayOfFile[i];
      File localFile2 = new File(paramFile2, localFile1.getName());
      if ((paramList == null) || (!paramList.contains(localFile1.getCanonicalPath())))
      {
        if (!localFile1.isDirectory()) {
          break label268;
        }
        a(localFile1, localFile2, paramFileFilter, paramBoolean, paramList);
      }
      for (;;)
      {
        i += 1;
        break;
        label268:
        a(localFile1, localFile2, paramBoolean);
      }
    }
    if (paramBoolean) {
      paramFile2.setLastModified(paramFile1.lastModified());
    }
  }
  
  private static void a(File paramFile1, File paramFile2, boolean paramBoolean)
    throws IOException
  {
    if ((paramFile2.exists()) && (paramFile2.isDirectory())) {
      throw new IOException("Destination '" + paramFile2 + "' exists but is a directory");
    }
    localFileOutputStream = null;
    localFileChannel2 = null;
    Object localObject5 = null;
    Object localObject2 = null;
    FileChannel localFileChannel3 = null;
    FileChannel localFileChannel1 = null;
    for (;;)
    {
      try
      {
        localObject3 = new FileInputStream(paramFile1);
      }
      finally
      {
        Object localObject1;
        localObject3 = localFileChannel2;
        paramFile1 = localFileOutputStream;
        closeQuietly(localFileChannel1);
        closeQuietly((Closeable)localObject3);
        closeQuietly((Closeable)localObject2);
        closeQuietly(paramFile1);
      }
      try
      {
        localFileOutputStream = new FileOutputStream(paramFile2);
        localFileChannel1 = localFileChannel3;
        localObject2 = localObject5;
      }
      finally
      {
        paramFile1 = (File)localObject3;
        localObject3 = localFileChannel2;
        continue;
      }
      try
      {
        localFileChannel2 = ((FileInputStream)localObject3).getChannel();
        localFileChannel1 = localFileChannel3;
        localObject2 = localFileChannel2;
        localFileChannel3 = localFileOutputStream.getChannel();
        localFileChannel1 = localFileChannel3;
        localObject2 = localFileChannel2;
        l3 = localFileChannel2.size();
        l1 = 0L;
      }
      finally
      {
        paramFile2 = localFileOutputStream;
        paramFile1 = (File)localObject3;
        localObject3 = paramFile2;
        paramFile2 = (File)localObject4;
        continue;
        if (l1 >= l3) {
          continue;
        }
        if (l3 - l1 <= 8192L) {
          continue;
        }
        l2 = 8192L;
        continue;
      }
      localFileChannel1 = localFileChannel3;
      localObject2 = localFileChannel2;
      l2 = localFileChannel3.transferFrom(localFileChannel2, l1, localObject1);
      l1 += l2;
      break label315;
      l2 = l3 - l1;
      continue;
      closeQuietly(localFileChannel3);
      closeQuietly(localFileOutputStream);
      closeQuietly(localFileChannel2);
      closeQuietly((Closeable)localObject3);
      if (paramFile1.length() != paramFile2.length()) {
        throw new IOException("Failed to copy full contents from '" + paramFile1 + "' to '" + paramFile2 + "'");
      }
    }
    if (paramBoolean) {
      paramFile2.setLastModified(paramFile1.lastModified());
    }
  }
  
  public static void cleanDirectory(File paramFile)
    throws IOException
  {
    if (!paramFile.exists()) {
      throw new IllegalArgumentException(paramFile + " does not exist");
    }
    if (!paramFile.isDirectory()) {
      throw new IllegalArgumentException(paramFile + " is not a directory");
    }
    File[] arrayOfFile = paramFile.listFiles();
    if (arrayOfFile == null) {
      throw new IOException("Failed to list contents of " + paramFile);
    }
    paramFile = null;
    int j = arrayOfFile.length;
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        File localFile = arrayOfFile[i];
        try
        {
          forceDelete(localFile);
          i += 1;
        }
        catch (IOException paramFile)
        {
          for (;;) {}
        }
      }
    }
    if (paramFile != null) {
      throw paramFile;
    }
  }
  
  public static void closeQuietly(@Nullable Closeable paramCloseable)
  {
    if (paramCloseable == null)
    {
      f.e(a, "closeQuietly closeable is null");
      return;
    }
    f.b(a, "closeQuietly " + paramCloseable);
    try
    {
      paramCloseable.close();
      return;
    }
    catch (Exception paramCloseable)
    {
      f.e(a, "closeQuietly closeable failed");
    }
  }
  
  public static void copyDirectory(File paramFile1, File paramFile2)
    throws IOException
  {
    copyDirectory(paramFile1, paramFile2, true);
  }
  
  public static void copyDirectory(File paramFile1, File paramFile2, FileFilter paramFileFilter)
    throws IOException
  {
    copyDirectory(paramFile1, paramFile2, paramFileFilter, true);
  }
  
  public static void copyDirectory(File paramFile1, File paramFile2, FileFilter paramFileFilter, boolean paramBoolean)
    throws IOException
  {
    if (paramFile1 == null) {
      throw new NullPointerException("Source must not be null");
    }
    if (paramFile2 == null) {
      throw new NullPointerException("Destination must not be null");
    }
    if (!paramFile1.exists()) {
      throw new FileNotFoundException("Source '" + paramFile1 + "' does not exist");
    }
    if (!paramFile1.isDirectory()) {
      throw new IOException("Source '" + paramFile1 + "' exists but is not a directory");
    }
    if (paramFile1.getCanonicalPath().equals(paramFile2.getCanonicalPath())) {
      throw new IOException("Source '" + paramFile1 + "' and destination '" + paramFile2 + "' are the same");
    }
    ArrayList localArrayList2 = null;
    ArrayList localArrayList1 = localArrayList2;
    if (paramFile2.getCanonicalPath().startsWith(paramFile1.getCanonicalPath()))
    {
      if (paramFileFilter == null) {}
      for (File[] arrayOfFile = paramFile1.listFiles();; arrayOfFile = paramFile1.listFiles(paramFileFilter))
      {
        localArrayList1 = localArrayList2;
        if (arrayOfFile == null) {
          break;
        }
        localArrayList1 = localArrayList2;
        if (arrayOfFile.length <= 0) {
          break;
        }
        localArrayList2 = new ArrayList(arrayOfFile.length);
        int j = arrayOfFile.length;
        int i = 0;
        for (;;)
        {
          localArrayList1 = localArrayList2;
          if (i >= j) {
            break;
          }
          localArrayList2.add(new File(paramFile2, arrayOfFile[i].getName()).getCanonicalPath());
          i += 1;
        }
      }
    }
    a(paramFile1, paramFile2, paramFileFilter, paramBoolean, localArrayList1);
  }
  
  public static void copyDirectory(File paramFile1, File paramFile2, boolean paramBoolean)
    throws IOException
  {
    copyDirectory(paramFile1, paramFile2, null, paramBoolean);
  }
  
  public static void copyFile(File paramFile1, File paramFile2)
    throws IOException
  {
    copyFile(paramFile1, paramFile2, true);
  }
  
  public static void copyFile(File paramFile1, File paramFile2, boolean paramBoolean)
    throws IOException
  {
    if (paramFile1 == null) {
      throw new NullPointerException("Source must not be null");
    }
    if (paramFile2 == null) {
      throw new NullPointerException("Destination must not be null");
    }
    if (!paramFile1.exists()) {
      throw new FileNotFoundException("Source '" + paramFile1 + "' does not exist");
    }
    if (paramFile1.isDirectory()) {
      throw new IOException("Source '" + paramFile1 + "' exists but is a directory");
    }
    if (paramFile1.getCanonicalPath().equals(paramFile2.getCanonicalPath())) {
      throw new IOException("Source '" + paramFile1 + "' and destination '" + paramFile2 + "' are the same");
    }
    File localFile = paramFile2.getParentFile();
    if ((localFile != null) && (!localFile.mkdirs()) && (!localFile.isDirectory())) {
      throw new IOException("Destination '" + localFile + "' directory cannot be created");
    }
    if ((paramFile2.exists()) && (!paramFile2.canWrite())) {
      throw new IOException("Destination '" + paramFile2 + "' exists but is read-only");
    }
    a(paramFile1, paramFile2, paramBoolean);
  }
  
  public static void copyStream(@Nullable InputStream paramInputStream, @Nullable OutputStream paramOutputStream)
    throws IOException
  {
    if ((paramInputStream == null) || (paramOutputStream == null))
    {
      f.c(a, "copyStream : outputStream or inputStream is null", new Throwable());
      throw new IOException("copyStream : outputStream or inputStream is null");
    }
    f.b(a, "copyStream");
    Object localObject1 = paramInputStream;
    Object localObject2 = paramInputStream;
    Object localObject3 = paramOutputStream;
    try
    {
      if (!(paramInputStream instanceof BufferedInputStream))
      {
        localObject2 = paramInputStream;
        localObject3 = paramOutputStream;
        localObject1 = new BufferedInputStream(paramInputStream);
      }
      paramInputStream = paramOutputStream;
      localObject2 = localObject1;
      localObject3 = paramOutputStream;
      if (!(paramOutputStream instanceof BufferedOutputStream))
      {
        localObject2 = localObject1;
        localObject3 = paramOutputStream;
        paramInputStream = new BufferedOutputStream(paramOutputStream);
      }
      localObject2 = localObject1;
      localObject3 = paramInputStream;
      paramOutputStream = new byte[' '];
      for (;;)
      {
        localObject2 = localObject1;
        localObject3 = paramInputStream;
        int i = ((InputStream)localObject1).read(paramOutputStream);
        if (i == -1) {
          break;
        }
        localObject2 = localObject1;
        localObject3 = paramInputStream;
        paramInputStream.write(paramOutputStream, 0, i);
      }
      localObject2 = localObject1;
    }
    finally
    {
      closeQuietly((Closeable)localObject2);
      closeQuietly((Closeable)localObject3);
    }
    localObject3 = paramInputStream;
    paramInputStream.flush();
    closeQuietly((Closeable)localObject1);
    closeQuietly(paramInputStream);
  }
  
  public static void deleteDirectory(File paramFile)
    throws IOException
  {
    if (!paramFile.exists()) {}
    do
    {
      return;
      cleanDirectory(paramFile);
    } while (paramFile.delete());
    throw new IOException("Unable to delete directory " + paramFile + ".");
  }
  
  @Deprecated
  public static void deleteFile(@Nullable File paramFile)
  {
    if ((paramFile == null) || (!paramFile.exists()))
    {
      f.e(a, "deleteFile the file is null");
      return;
    }
    f.b(a, "deleteFile " + paramFile.getAbsolutePath());
    try
    {
      if (paramFile.isDirectory())
      {
        File[] arrayOfFile = paramFile.listFiles();
        if (arrayOfFile != null)
        {
          int j = arrayOfFile.length;
          int i = 0;
          while (i < j)
          {
            deleteFile(arrayOfFile[i]);
            i += 1;
          }
        }
      }
      paramFile.delete();
      return;
    }
    catch (Exception localException)
    {
      f.e(a, "deleteFile fail " + paramFile.getAbsolutePath());
    }
  }
  
  public static boolean deleteQuietly(File paramFile)
  {
    if (paramFile == null) {
      return false;
    }
    try
    {
      if (paramFile.isDirectory()) {
        cleanDirectory(paramFile);
      }
      try
      {
        boolean bool = paramFile.delete();
        return bool;
      }
      catch (Exception paramFile)
      {
        return false;
      }
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  public static void forceDelete(File paramFile)
    throws IOException
  {
    if (paramFile.isDirectory()) {
      deleteDirectory(paramFile);
    }
    boolean bool;
    do
    {
      return;
      bool = paramFile.exists();
    } while (paramFile.delete());
    if (!bool) {
      throw new FileNotFoundException("File does not exist: " + paramFile);
    }
    throw new IOException("Unable to delete file: " + paramFile);
  }
  
  public static void forceMkDir(@Nullable File paramFile)
    throws IOException
  {
    if (paramFile == null) {}
    do
    {
      do
      {
        return;
        if (!paramFile.exists()) {
          break;
        }
      } while (paramFile.isDirectory());
      throw new IOException("File " + paramFile + " exists and is not a directory. Unable to create directory.");
    } while ((paramFile.mkdirs()) || (paramFile.isDirectory()));
    throw new IOException("Unable to create directory " + paramFile);
  }
  
  @NotNull
  public static byte[] inputStreamToBytes(@Nullable InputStream paramInputStream)
    throws IOException
  {
    if (paramInputStream == null)
    {
      f.c(a, "inputStreamToBytes : inputStream is null", new Throwable());
      throw new IOException("inputStreamToBytes : inputStream is null");
    }
    f.b(a, "inputStreamToBytes");
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    copyStream(paramInputStream, localByteArrayOutputStream);
    return localByteArrayOutputStream.toByteArray();
  }
  
  @NotNull
  public static List<File> listFiles(@Nullable File paramFile)
  {
    LinkedList localLinkedList = new LinkedList();
    if (paramFile == null) {}
    for (;;)
    {
      return localLinkedList;
      paramFile = paramFile.listFiles();
      if (paramFile != null)
      {
        int j = paramFile.length;
        int i = 0;
        while (i < j)
        {
          Object localObject = paramFile[i];
          localLinkedList.add(localObject);
          if (((File)localObject).isDirectory())
          {
            localObject = listFiles((File)localObject).iterator();
            while (((Iterator)localObject).hasNext()) {
              localLinkedList.add((File)((Iterator)localObject).next());
            }
          }
          i += 1;
        }
      }
    }
  }
  
  public static void moveFile(File paramFile1, File paramFile2)
    throws IOException
  {
    if (paramFile1 == null) {
      throw new NullPointerException("Source must not be null");
    }
    if (paramFile2 == null) {
      throw new NullPointerException("Destination must not be null");
    }
    if (!paramFile1.exists()) {
      throw new FileNotFoundException("Source '" + paramFile1 + "' does not exist");
    }
    if (paramFile1.isDirectory()) {
      throw new IOException("Source '" + paramFile1 + "' is a directory");
    }
    if (paramFile2.exists()) {
      throw new IOException("Destination '" + paramFile2 + "' already exists");
    }
    if (paramFile2.isDirectory()) {
      throw new IOException("Destination '" + paramFile2 + "' is a directory");
    }
    if (!paramFile1.renameTo(paramFile2))
    {
      copyFile(paramFile1, paramFile2);
      if (!paramFile1.delete())
      {
        deleteQuietly(paramFile2);
        throw new IOException("Failed to delete original file '" + paramFile1 + "' after copy to '" + paramFile2 + "'");
      }
    }
  }
  
  public static byte[] readFile(@Nullable File paramFile)
    throws IOException
  {
    if (paramFile == null)
    {
      f.c(a, "readFile : file is null", new Throwable());
      throw new IOException("readFile : file is null");
    }
    f.b(a, "readFile " + paramFile.getAbsolutePath());
    if (!paramFile.isFile()) {
      throw new IOException(paramFile.getAbsolutePath() + " is not a File");
    }
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    copyStream(new FileInputStream(paramFile), localByteArrayOutputStream);
    return localByteArrayOutputStream.toByteArray();
  }
  
  public static void writeToFile(@Nullable File paramFile, @Nullable InputStream paramInputStream)
    throws IOException
  {
    if ((paramFile == null) || (paramInputStream == null))
    {
      f.c(a, "writeToFile : file or inputStream is null", new Throwable());
      throw new IOException("writeToFile : file or inputStream is null");
    }
    f.b(a, "writeToFile " + paramFile.getAbsolutePath());
    File localFile = paramFile.getParentFile();
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    if (!localFile.exists()) {
      throw new IOException("Can't create dir " + localFile.getAbsolutePath());
    }
    copyStream(paramInputStream, new FileOutputStream(paramFile));
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/mapframework/commonlib/utils/IO.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */