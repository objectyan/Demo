package com.facebook.common.m;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.provider.MediaStore.Images.Media;
import javax.annotation.Nullable;

public class g
{
  public static final String a = "http";
  public static final String b = "https";
  public static final String c = "file";
  public static final String d = "content";
  public static final String e = "asset";
  public static final String f = "res";
  public static final String g = "data";
  private static final String h = Uri.withAppendedPath(ContactsContract.AUTHORITY_URI, "display_photo").getPath();
  
  public static Uri a(@Nullable String paramString)
  {
    if (paramString != null) {
      return Uri.parse(paramString);
    }
    return null;
  }
  
  @Nullable
  public static String a(ContentResolver paramContentResolver, Uri paramUri)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    if (c(paramUri)) {
      localObject1 = null;
    }
    while (!b(paramUri)) {
      try
      {
        paramUri = paramContentResolver.query(paramUri, null, null, null, null);
        paramContentResolver = (ContentResolver)localObject2;
        if (paramUri != null)
        {
          paramContentResolver = (ContentResolver)localObject2;
          localObject1 = paramUri;
          if (paramUri.moveToFirst())
          {
            localObject1 = paramUri;
            int i = paramUri.getColumnIndex("_data");
            paramContentResolver = (ContentResolver)localObject2;
            if (i != -1)
            {
              localObject1 = paramUri;
              paramContentResolver = paramUri.getString(i);
            }
          }
        }
        localObject1 = paramContentResolver;
        if (paramUri != null)
        {
          paramUri.close();
          localObject1 = paramContentResolver;
        }
        return (String)localObject1;
      }
      finally
      {
        if (localObject1 != null) {
          ((Cursor)localObject1).close();
        }
      }
    }
    return paramUri.getPath();
  }
  
  public static boolean a(@Nullable Uri paramUri)
  {
    paramUri = i(paramUri);
    return ("https".equals(paramUri)) || ("http".equals(paramUri));
  }
  
  public static boolean b(@Nullable Uri paramUri)
  {
    return "file".equals(i(paramUri));
  }
  
  public static boolean c(@Nullable Uri paramUri)
  {
    return "content".equals(i(paramUri));
  }
  
  public static boolean d(Uri paramUri)
  {
    return (c(paramUri)) && ("com.android.contacts".equals(paramUri.getAuthority())) && (!paramUri.getPath().startsWith(h));
  }
  
  public static boolean e(Uri paramUri)
  {
    paramUri = paramUri.toString();
    return (paramUri.startsWith(MediaStore.Images.Media.EXTERNAL_CONTENT_URI.toString())) || (paramUri.startsWith(MediaStore.Images.Media.INTERNAL_CONTENT_URI.toString()));
  }
  
  public static boolean f(@Nullable Uri paramUri)
  {
    return "asset".equals(i(paramUri));
  }
  
  public static boolean g(@Nullable Uri paramUri)
  {
    return "res".equals(i(paramUri));
  }
  
  public static boolean h(@Nullable Uri paramUri)
  {
    return "data".equals(i(paramUri));
  }
  
  @Nullable
  public static String i(@Nullable Uri paramUri)
  {
    if (paramUri == null) {
      return null;
    }
    return paramUri.getScheme();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/facebook/common/m/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */