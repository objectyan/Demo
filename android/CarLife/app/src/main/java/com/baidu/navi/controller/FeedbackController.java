package com.baidu.navi.controller;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import android.util.Base64;
import com.baidu.carlife.k.a.e.a;
import com.baidu.carlife.k.e;
import com.baidu.navi.logic.drawable.PathDrawable;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.MD5;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import org.apache.http.NameValuePair;

public class FeedbackController
{
  private static final String KEY = "bd44977f4225b957923ddefa781e8f93";
  public static final int PHOTO_REQUEST_CAREMA = 4609;
  public static final int PHOTO_REQUEST_GALLERY = 4610;
  private static final String PREIX = "navi";
  private static FeedbackController sInstance = null;
  private int bmpSize = 120;
  private String mContact;
  private String mContent;
  private Handler mHandler;
  private ArrayList<Bitmap> mPicList;
  private ArrayList<String> mPicListPath;
  private File tempFile;
  private String type;
  
  public static FeedbackController getInstance()
  {
    if (sInstance == null) {
      sInstance = new FeedbackController();
    }
    return sInstance;
  }
  
  private void toRequest(List<String> paramList, String paramString1, String paramString2, String paramString3, Context paramContext, e.a parama)
  {
    paramList = new e(paramString1, paramString2, paramString3, paramList, paramContext);
    paramList.registerResponseListener(parama);
    paramList.toPostRequest();
  }
  
  public Bitmap base64ToBitmap(String paramString)
  {
    paramString = Base64.decode(paramString, 0);
    return BitmapFactory.decodeByteArray(paramString, 0, paramString.length);
  }
  
  /* Error */
  public String bitmapToBase64(Bitmap paramBitmap)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_2
    //   5: aconst_null
    //   6: astore 5
    //   8: aconst_null
    //   9: astore 6
    //   11: aconst_null
    //   12: astore_3
    //   13: aload_1
    //   14: ifnull +46 -> 60
    //   17: aload 6
    //   19: astore_3
    //   20: new 93	java/io/ByteArrayOutputStream
    //   23: dup
    //   24: invokespecial 94	java/io/ByteArrayOutputStream:<init>	()V
    //   27: astore_2
    //   28: aload_1
    //   29: getstatic 100	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   32: bipush 100
    //   34: aload_2
    //   35: invokevirtual 106	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   38: pop
    //   39: aload_2
    //   40: invokevirtual 109	java/io/ByteArrayOutputStream:flush	()V
    //   43: aload_2
    //   44: invokevirtual 112	java/io/ByteArrayOutputStream:close	()V
    //   47: aload_2
    //   48: invokevirtual 116	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   51: iconst_0
    //   52: invokestatic 120	android/util/Base64:encodeToString	([BI)Ljava/lang/String;
    //   55: astore_1
    //   56: aload_2
    //   57: astore_3
    //   58: aload_1
    //   59: astore_2
    //   60: aload_2
    //   61: astore 4
    //   63: aload_3
    //   64: ifnull +14 -> 78
    //   67: aload_3
    //   68: invokevirtual 109	java/io/ByteArrayOutputStream:flush	()V
    //   71: aload_3
    //   72: invokevirtual 112	java/io/ByteArrayOutputStream:close	()V
    //   75: aload_2
    //   76: astore 4
    //   78: aload 4
    //   80: areturn
    //   81: astore_1
    //   82: aload_1
    //   83: invokevirtual 123	java/io/IOException:printStackTrace	()V
    //   86: aload_2
    //   87: areturn
    //   88: astore_2
    //   89: aload 5
    //   91: astore_1
    //   92: aload_1
    //   93: astore_3
    //   94: aload_2
    //   95: invokevirtual 123	java/io/IOException:printStackTrace	()V
    //   98: aload_1
    //   99: ifnull -21 -> 78
    //   102: aload_1
    //   103: invokevirtual 109	java/io/ByteArrayOutputStream:flush	()V
    //   106: aload_1
    //   107: invokevirtual 112	java/io/ByteArrayOutputStream:close	()V
    //   110: aconst_null
    //   111: areturn
    //   112: astore_1
    //   113: aload_1
    //   114: invokevirtual 123	java/io/IOException:printStackTrace	()V
    //   117: aconst_null
    //   118: areturn
    //   119: astore_1
    //   120: aload_3
    //   121: ifnull +11 -> 132
    //   124: aload_3
    //   125: invokevirtual 109	java/io/ByteArrayOutputStream:flush	()V
    //   128: aload_3
    //   129: invokevirtual 112	java/io/ByteArrayOutputStream:close	()V
    //   132: aload_1
    //   133: athrow
    //   134: astore_2
    //   135: aload_2
    //   136: invokevirtual 123	java/io/IOException:printStackTrace	()V
    //   139: goto -7 -> 132
    //   142: astore_1
    //   143: aload_2
    //   144: astore_3
    //   145: goto -25 -> 120
    //   148: astore_3
    //   149: aload_2
    //   150: astore_1
    //   151: aload_3
    //   152: astore_2
    //   153: goto -61 -> 92
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	156	0	this	FeedbackController
    //   0	156	1	paramBitmap	Bitmap
    //   4	83	2	localObject1	Object
    //   88	7	2	localIOException1	IOException
    //   134	16	2	localIOException2	IOException
    //   152	1	2	localObject2	Object
    //   12	133	3	localObject3	Object
    //   148	4	3	localIOException3	IOException
    //   1	78	4	localObject4	Object
    //   6	84	5	localObject5	Object
    //   9	9	6	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   67	75	81	java/io/IOException
    //   20	28	88	java/io/IOException
    //   102	110	112	java/io/IOException
    //   20	28	119	finally
    //   94	98	119	finally
    //   124	132	134	java/io/IOException
    //   28	56	142	finally
    //   28	56	148	java/io/IOException
  }
  
  public File bitmapToFile(Bitmap paramBitmap)
  {
    File localFile = new File(PathDrawable.getCachePath(), UUID.randomUUID().toString() + ".jpg");
    try
    {
      localFile.createNewFile();
      if (localFile != null) {
        localObject = null;
      }
    }
    catch (IOException paramBitmap)
    {
      try
      {
        FileOutputStream localFileOutputStream = new FileOutputStream(localFile);
        localObject = localFileOutputStream;
      }
      catch (FileNotFoundException paramBitmap)
      {
        try
        {
          paramBitmap.compress(Bitmap.CompressFormat.JPEG, 50, (OutputStream)localObject);
        }
        catch (Exception paramBitmap)
        {
          try
          {
            for (;;)
            {
              Object localObject;
              ((FileOutputStream)localObject).flush();
              try
              {
                ((FileOutputStream)localObject).close();
                return localFile;
              }
              catch (IOException paramBitmap)
              {
                paramBitmap.printStackTrace();
              }
              localIOException = localIOException;
              localIOException.printStackTrace();
              continue;
              localFileNotFoundException = localFileNotFoundException;
              localFileNotFoundException.printStackTrace();
              continue;
              paramBitmap = paramBitmap;
              paramBitmap.printStackTrace();
            }
          }
          catch (IOException paramBitmap)
          {
            for (;;)
            {
              paramBitmap.printStackTrace();
            }
          }
        }
      }
    }
    return localFile;
  }
  
  protected String generateSign(List<NameValuePair> paramList)
  {
    if (paramList == null) {
      return null;
    }
    Object localObject2 = null;
    Object localObject1 = localObject2;
    for (;;)
    {
      int i;
      try
      {
        Object localObject3 = new StringBuffer();
        i = 0;
        localObject1 = localObject2;
        if (i < paramList.size())
        {
          localObject1 = localObject2;
          ((StringBuffer)localObject3).append(((NameValuePair)paramList.get(i)).getName());
          localObject1 = localObject2;
          ((StringBuffer)localObject3).append("=");
          localObject1 = localObject2;
          ((StringBuffer)localObject3).append(URLEncoder.encode(((NameValuePair)paramList.get(i)).getValue(), "utf-8"));
          localObject1 = localObject2;
          if (i < paramList.size() - 1)
          {
            localObject1 = localObject2;
            ((StringBuffer)localObject3).append("&");
          }
        }
        else
        {
          localObject1 = localObject2;
          localObject3 = "navi" + ((StringBuffer)localObject3).toString() + "bd44977f4225b957923ddefa781e8f93";
          localObject1 = localObject2;
          paramList = MD5.toMD5((String)localObject3).toLowerCase(Locale.getDefault());
          localObject1 = paramList;
          LogUtil.e("FeedBackFragment", "sign source = " + (String)localObject3 + "\n sign = " + paramList);
          return paramList;
        }
      }
      catch (Exception paramList)
      {
        LogUtil.e("FeedBackFragment", "generateSign fail" + paramList.getMessage());
        return (String)localObject1;
      }
      i += 1;
    }
  }
  
  public Bitmap getBitMap(String paramString)
  {
    try
    {
      paramString = BitmapFactory.decodeFile(paramString);
      return paramString;
    }
    catch (OutOfMemoryError paramString) {}
    return null;
  }
  
  public Bitmap getBitmapByOpt(String paramString)
  {
    int n = 1;
    for (;;)
    {
      int i;
      int i1;
      int m;
      try
      {
        BitmapFactory.Options localOptions = new BitmapFactory.Options();
        localOptions.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(paramString, localOptions);
        i = localOptions.outHeight;
        i1 = localOptions.outWidth / this.bmpSize;
        m = i / this.bmpSize;
        i = 1;
        if (i1 > m)
        {
          j = 1;
          break label111;
          localOptions.inJustDecodeBounds = false;
          localOptions.inSampleSize = i;
          paramString = BitmapFactory.decodeFile(paramString, localOptions);
          return paramString;
        }
        else
        {
          j = 0;
        }
      }
      catch (OutOfMemoryError paramString)
      {
        return null;
      }
      int k = 0;
      break label120;
      int j = 0;
      break label139;
      k = 0;
      label111:
      if (m >= 1)
      {
        k = 1;
        label120:
        if ((k & j) != 0) {
          i = i1;
        }
        if (m > i1)
        {
          j = 1;
          label139:
          if (i1 >= 1)
          {
            k = n;
            if ((k & j) != 0) {
              i = m;
            }
          }
        }
      }
    }
  }
  
  public Bitmap getBitmapByOptToSend(String paramString)
  {
    int n = 1;
    for (;;)
    {
      int i;
      int i1;
      int m;
      try
      {
        BitmapFactory.Options localOptions = new BitmapFactory.Options();
        localOptions.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(paramString, localOptions);
        i = this.bmpSize * 2;
        j = localOptions.outHeight;
        i1 = localOptions.outWidth / i;
        m = j / i;
        i = 1;
        if (i1 > m)
        {
          j = 1;
          break label118;
          localOptions.inJustDecodeBounds = false;
          localOptions.inSampleSize = i;
          localOptions.inDensity = 0;
          paramString = BitmapFactory.decodeFile(paramString, localOptions);
          return paramString;
        }
        else
        {
          j = 0;
        }
      }
      catch (OutOfMemoryError paramString)
      {
        return null;
      }
      int k = 0;
      break label127;
      int j = 0;
      break label146;
      k = 0;
      label118:
      if (m >= 1)
      {
        k = 1;
        label127:
        if ((k & j) != 0) {
          i = i1;
        }
        if (m > i1)
        {
          j = 1;
          label146:
          if (i1 >= 1)
          {
            k = n;
            if ((k & j) != 0) {
              i = m;
            }
          }
        }
      }
    }
  }
  
  public String getBitmapFilePath(Activity paramActivity, int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject;
    if (paramInt1 == 4610)
    {
      if (paramIntent == null) {
        break label126;
      }
      localObject = paramIntent.getData();
      paramIntent = new String[1];
      paramIntent[0] = "_data";
    }
    try
    {
      localObject = paramActivity.getApplicationContext().getContentResolver().query((Uri)localObject, paramIntent, null, null, null);
      paramActivity = null;
      if (localObject != null)
      {
        ((Cursor)localObject).moveToFirst();
        paramActivity = ((Cursor)localObject).getString(((Cursor)localObject).getColumnIndex(paramIntent[0]));
        ((Cursor)localObject).close();
      }
      return paramActivity;
    }
    catch (Exception paramActivity)
    {
      label126:
      for (;;) {}
    }
    if (paramInt1 == 4609)
    {
      if (hasSdcard()) {
        return this.tempFile.getAbsolutePath();
      }
      TipTool.onCreateToastDialog(paramActivity.getApplicationContext(), "未找到存储卡，无法存储照片！");
    }
    return null;
  }
  
  public File getTempFile()
  {
    return this.tempFile;
  }
  
  public String getType()
  {
    return this.type;
  }
  
  public String getmContact()
  {
    return this.mContact;
  }
  
  public String getmContent()
  {
    return this.mContent;
  }
  
  public ArrayList<Bitmap> getmPicList()
  {
    return this.mPicList;
  }
  
  public ArrayList<String> getmPicListPath()
  {
    return this.mPicListPath;
  }
  
  public boolean hasSdcard()
  {
    return Environment.getExternalStorageState().equals("mounted");
  }
  
  public void initPicList()
  {
    this.mPicList = new ArrayList();
    this.mPicListPath = new ArrayList();
  }
  
  public File judgeFileSize(File paramFile)
  {
    while ((paramFile != null) && (paramFile.length() >= 2097152)) {
      paramFile = bitmapToFile(getBitmapByOptToSend(paramFile.getPath()));
    }
    return paramFile;
  }
  
  public void openPicSrc(Activity paramActivity, int paramInt)
  {
    if ((getInstance().getmPicListPath() != null) && (paramInt >= 0) && (paramInt < getInstance().getmPicListPath().size()))
    {
      Intent localIntent = new Intent("android.intent.action.VIEW");
      localIntent.setDataAndType(Uri.fromFile(new File((String)getInstance().getmPicListPath().get(paramInt))), "image/*");
      paramActivity.startActivity(localIntent);
    }
  }
  
  public void setTempFile(File paramFile)
  {
    this.tempFile = paramFile;
  }
  
  public void setType(String paramString)
  {
    this.type = paramString;
  }
  
  public void setmContact(String paramString)
  {
    this.mContact = paramString;
  }
  
  public void setmContent(String paramString)
  {
    this.mContent = paramString;
  }
  
  public void setmHandler(Handler paramHandler)
  {
    this.mHandler = paramHandler;
  }
  
  public void setmPicList(ArrayList<Bitmap> paramArrayList)
  {
    this.mPicList = paramArrayList;
  }
  
  public void setmPicListPath(ArrayList<String> paramArrayList)
  {
    this.mPicListPath = paramArrayList;
  }
  
  public void startUploadFeedback(final e.a parama, final String paramString1, final String paramString2, final String paramString3, final Context paramContext)
  {
    if ((this.mPicListPath != null) && (this.mPicListPath.size() > 0))
    {
      new Thread(new Runnable()
      {
        public void run()
        {
          ArrayList localArrayList = new ArrayList();
          int i = 0;
          while (i < FeedbackController.this.mPicListPath.size())
          {
            localArrayList.add(FeedbackController.this.bitmapToBase64(FeedbackController.this.getBitMap(FeedbackController.this.judgeFileSize(FeedbackController.this.bitmapToFile(FeedbackController.this.getBitmapByOptToSend((String)FeedbackController.this.mPicListPath.get(i)))).getPath())));
            i += 1;
          }
          FeedbackController.this.toRequest(localArrayList, paramString1, paramString2, paramString3, paramContext, parama);
        }
      }).start();
      return;
    }
    toRequest(null, paramString1, paramString2, paramString3, paramContext, parama);
  }
  
  public static abstract interface UploadFeedbackCallback
  {
    public abstract void onUploadFeedbackFail(Exception paramException);
    
    public abstract void onUploadFeedbackSuccess();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/controller/FeedbackController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */