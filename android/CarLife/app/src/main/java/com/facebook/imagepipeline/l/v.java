package com.facebook.imagepipeline.l;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract.Contacts;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.m.g;
import com.facebook.imagepipeline.i.d;
import com.facebook.imagepipeline.m.c;
import com.facebook.imagepipeline.memory.z;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

public class v
  extends y
{
  @VisibleForTesting
  static final String a = "LocalContentUriFetchProducer";
  private static final String[] b = { "_id", "_data" };
  private final ContentResolver c;
  
  public v(Executor paramExecutor, z paramz, ContentResolver paramContentResolver, boolean paramBoolean)
  {
    super(paramExecutor, paramz, paramBoolean);
    this.c = paramContentResolver;
  }
  
  private static int a(String paramString)
  {
    if (paramString == null) {
      return -1;
    }
    return (int)new File(paramString).length();
  }
  
  @Nullable
  private d a(Uri paramUri)
    throws IOException
  {
    paramUri = this.c.query(paramUri, b, null, null, null);
    if (paramUri == null) {
      return null;
    }
    try
    {
      int i = paramUri.getCount();
      if (i == 0) {
        return null;
      }
      paramUri.moveToFirst();
      Object localObject1 = paramUri.getString(paramUri.getColumnIndex("_data"));
      if (localObject1 != null)
      {
        localObject1 = b(new FileInputStream((String)localObject1), a((String)localObject1));
        return (d)localObject1;
      }
      return null;
    }
    finally
    {
      paramUri.close();
    }
  }
  
  protected d a(c paramc)
    throws IOException
  {
    Uri localUri = paramc.b();
    if (g.d(localUri)) {
      if (localUri.toString().endsWith("/photo"))
      {
        paramc = this.c.openInputStream(localUri);
        paramc = b(paramc, -1);
      }
    }
    Object localObject;
    do
    {
      return paramc;
      localObject = ContactsContract.Contacts.openContactPhotoInputStream(this.c, localUri);
      paramc = (c)localObject;
      if (localObject != null) {
        break;
      }
      throw new IOException("Contact photo does not exist: " + localUri);
      if (!g.e(localUri)) {
        break label103;
      }
      localObject = a(localUri);
      paramc = (c)localObject;
    } while (localObject != null);
    label103:
    return b(this.c.openInputStream(localUri), -1);
  }
  
  protected String a()
  {
    return "LocalContentUriFetchProducer";
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/facebook/imagepipeline/l/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */