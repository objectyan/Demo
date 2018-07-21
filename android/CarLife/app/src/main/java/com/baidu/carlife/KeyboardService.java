package com.baidu.carlife;

import android.app.Activity;
import android.os.AsyncTask;
import com.baidu.carlife.core.f;
import com.baidu.carlife.core.i;
import com.baidu.carlife.core.screen.e;
import com.baidu.carlife.view.a;
import java.io.File;
import java.util.ArrayList;

public class KeyboardService
{
  public static final String DIRECTORY_PATH;
  public static final String LIB_SQLITE = "keyboardlib_v4.sqlite";
  private static final String TAG = KeyboardService.class.getSimpleName();
  private static KeyboardService mInstance;
  private boolean loadLibSuc;
  private a mKeyboardCallBack;
  private long startLoadLibrary;
  
  static
  {
    DIRECTORY_PATH = f.jm + File.separator + "keyboard" + File.separator;
    System.loadLibrary("KeyboardService");
  }
  
  public static KeyboardService getInstance()
  {
    if (mInstance == null) {
      mInstance = new KeyboardService();
    }
    return mInstance;
  }
  
  public void init(Activity paramActivity, e parame)
  {
    new b(null).execute(new Void[0]);
    a.a().a(paramActivity, parame);
  }
  
  public native void initService(String paramString);
  
  public void initServiceCallback(boolean paramBoolean)
  {
    i.b("KeyboardService", "LoadLibrary:" + paramBoolean + ",time=" + (System.currentTimeMillis() - this.startLoadLibrary));
    this.loadLibSuc = paramBoolean;
    if (this.mKeyboardCallBack != null) {
      this.mKeyboardCallBack.a(paramBoolean);
    }
  }
  
  public boolean isLoadLibSuc()
  {
    return this.loadLibSuc;
  }
  
  public native ArrayList<String> relateWords(String paramString);
  
  public native ArrayList<String> search(String paramString);
  
  public void setKeyboardCallBack(a parama)
  {
    this.mKeyboardCallBack = parama;
  }
  
  public native void userSelected(String paramString);
  
  public static abstract interface a
  {
    public abstract void a(boolean paramBoolean);
  }
  
  private class b
    extends AsyncTask<Void, Void, Void>
  {
    private b() {}
    
    /* Error */
    private boolean a()
    {
      // Byte code:
      //   0: new 28	java/io/File
      //   3: dup
      //   4: new 30	java/lang/StringBuilder
      //   7: dup
      //   8: invokespecial 31	java/lang/StringBuilder:<init>	()V
      //   11: getstatic 35	com/baidu/carlife/KeyboardService:DIRECTORY_PATH	Ljava/lang/String;
      //   14: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   17: ldc 41
      //   19: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   22: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   25: invokespecial 48	java/io/File:<init>	(Ljava/lang/String;)V
      //   28: astore 5
      //   30: aload 5
      //   32: invokevirtual 51	java/io/File:exists	()Z
      //   35: ifeq +5 -> 40
      //   38: iconst_1
      //   39: ireturn
      //   40: new 28	java/io/File
      //   43: dup
      //   44: getstatic 35	com/baidu/carlife/KeyboardService:DIRECTORY_PATH	Ljava/lang/String;
      //   47: invokespecial 48	java/io/File:<init>	(Ljava/lang/String;)V
      //   50: astore_2
      //   51: aload_2
      //   52: invokevirtual 51	java/io/File:exists	()Z
      //   55: ifeq +30 -> 85
      //   58: aload_2
      //   59: invokevirtual 55	java/io/File:listFiles	()[Ljava/io/File;
      //   62: astore_2
      //   63: iconst_0
      //   64: istore_1
      //   65: iload_1
      //   66: aload_2
      //   67: arraylength
      //   68: if_icmpge +22 -> 90
      //   71: aload_2
      //   72: iload_1
      //   73: aaload
      //   74: invokevirtual 58	java/io/File:delete	()Z
      //   77: pop
      //   78: iload_1
      //   79: iconst_1
      //   80: iadd
      //   81: istore_1
      //   82: goto -17 -> 65
      //   85: aload_2
      //   86: invokevirtual 61	java/io/File:mkdirs	()Z
      //   89: pop
      //   90: aload 5
      //   92: invokevirtual 64	java/io/File:createNewFile	()Z
      //   95: pop
      //   96: sipush 1024
      //   99: newarray <illegal type>
      //   101: astore 10
      //   103: aconst_null
      //   104: astore 4
      //   106: aconst_null
      //   107: astore 6
      //   109: aconst_null
      //   110: astore_3
      //   111: aconst_null
      //   112: astore 8
      //   114: aconst_null
      //   115: astore 7
      //   117: aconst_null
      //   118: astore 9
      //   120: invokestatic 70	com/baidu/carlife/BaiduNaviApplication:getInstance	()Lcom/baidu/carlife/BaiduNaviApplication;
      //   123: invokevirtual 74	com/baidu/carlife/BaiduNaviApplication:getResources	()Landroid/content/res/Resources;
      //   126: ldc 75
      //   128: invokevirtual 81	android/content/res/Resources:openRawResource	(I)Ljava/io/InputStream;
      //   131: astore_2
      //   132: aload_2
      //   133: astore_3
      //   134: aload_2
      //   135: astore 4
      //   137: aload_2
      //   138: astore 6
      //   140: new 83	java/io/FileOutputStream
      //   143: dup
      //   144: aload 5
      //   146: invokespecial 86	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
      //   149: astore 5
      //   151: aload_2
      //   152: aload 10
      //   154: invokevirtual 92	java/io/InputStream:read	([B)I
      //   157: istore_1
      //   158: iload_1
      //   159: ifle +39 -> 198
      //   162: aload 5
      //   164: aload 10
      //   166: iconst_0
      //   167: iload_1
      //   168: invokevirtual 96	java/io/FileOutputStream:write	([BII)V
      //   171: goto -20 -> 151
      //   174: astore_3
      //   175: aload_2
      //   176: ifnull +7 -> 183
      //   179: aload_2
      //   180: invokevirtual 99	java/io/InputStream:close	()V
      //   183: aload 5
      //   185: ifnull +8 -> 193
      //   188: aload 5
      //   190: invokevirtual 100	java/io/FileOutputStream:close	()V
      //   193: iconst_0
      //   194: ireturn
      //   195: astore_2
      //   196: iconst_0
      //   197: ireturn
      //   198: aload 5
      //   200: invokevirtual 103	java/io/FileOutputStream:flush	()V
      //   203: aload_2
      //   204: ifnull +7 -> 211
      //   207: aload_2
      //   208: invokevirtual 99	java/io/InputStream:close	()V
      //   211: aload 5
      //   213: ifnull -175 -> 38
      //   216: aload 5
      //   218: invokevirtual 100	java/io/FileOutputStream:close	()V
      //   221: iconst_1
      //   222: ireturn
      //   223: astore_2
      //   224: iconst_0
      //   225: ireturn
      //   226: astore_2
      //   227: iconst_0
      //   228: ireturn
      //   229: astore_2
      //   230: iconst_0
      //   231: ireturn
      //   232: astore_2
      //   233: iconst_0
      //   234: ireturn
      //   235: astore_2
      //   236: aload_3
      //   237: astore_2
      //   238: aload 8
      //   240: astore_3
      //   241: aload_2
      //   242: ifnull +7 -> 249
      //   245: aload_2
      //   246: invokevirtual 99	java/io/InputStream:close	()V
      //   249: aload_3
      //   250: ifnull +7 -> 257
      //   253: aload_3
      //   254: invokevirtual 100	java/io/FileOutputStream:close	()V
      //   257: iconst_0
      //   258: ireturn
      //   259: astore_2
      //   260: iconst_0
      //   261: ireturn
      //   262: astore_2
      //   263: iconst_0
      //   264: ireturn
      //   265: astore 5
      //   267: aload 4
      //   269: astore_2
      //   270: aload 7
      //   272: astore_3
      //   273: aload_2
      //   274: ifnull +7 -> 281
      //   277: aload_2
      //   278: invokevirtual 99	java/io/InputStream:close	()V
      //   281: aload_3
      //   282: ifnull +7 -> 289
      //   285: aload_3
      //   286: invokevirtual 100	java/io/FileOutputStream:close	()V
      //   289: aload 5
      //   291: athrow
      //   292: astore_2
      //   293: iconst_0
      //   294: ireturn
      //   295: astore_2
      //   296: iconst_0
      //   297: ireturn
      //   298: astore 4
      //   300: aload 5
      //   302: astore_3
      //   303: aload 4
      //   305: astore 5
      //   307: goto -34 -> 273
      //   310: astore_3
      //   311: aload 5
      //   313: astore_3
      //   314: goto -73 -> 241
      //   317: astore_2
      //   318: aload 9
      //   320: astore 5
      //   322: aload 6
      //   324: astore_2
      //   325: goto -150 -> 175
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	328	0	this	b
      //   64	104	1	i	int
      //   50	130	2	localObject1	Object
      //   195	13	2	localIOException1	java.io.IOException
      //   223	1	2	localIOException2	java.io.IOException
      //   226	1	2	localIOException3	java.io.IOException
      //   229	1	2	localIOException4	java.io.IOException
      //   232	1	2	localIOException5	java.io.IOException
      //   235	1	2	localIOException6	java.io.IOException
      //   237	9	2	localObject2	Object
      //   259	1	2	localIOException7	java.io.IOException
      //   262	1	2	localIOException8	java.io.IOException
      //   269	9	2	localObject3	Object
      //   292	1	2	localIOException9	java.io.IOException
      //   295	1	2	localIOException10	java.io.IOException
      //   317	1	2	localFileNotFoundException1	java.io.FileNotFoundException
      //   324	1	2	localObject4	Object
      //   110	24	3	localObject5	Object
      //   174	63	3	localFileNotFoundException2	java.io.FileNotFoundException
      //   240	63	3	localObject6	Object
      //   310	1	3	localIOException11	java.io.IOException
      //   313	1	3	localObject7	Object
      //   104	164	4	localObject8	Object
      //   298	6	4	localObject9	Object
      //   28	189	5	localObject10	Object
      //   265	36	5	localObject11	Object
      //   305	16	5	localObject12	Object
      //   107	216	6	localObject13	Object
      //   115	156	7	localObject14	Object
      //   112	127	8	localObject15	Object
      //   118	201	9	localObject16	Object
      //   101	64	10	arrayOfByte	byte[]
      // Exception table:
      //   from	to	target	type
      //   151	158	174	java/io/FileNotFoundException
      //   162	171	174	java/io/FileNotFoundException
      //   198	203	174	java/io/FileNotFoundException
      //   90	96	195	java/io/IOException
      //   216	221	223	java/io/IOException
      //   207	211	226	java/io/IOException
      //   179	183	229	java/io/IOException
      //   188	193	232	java/io/IOException
      //   120	132	235	java/io/IOException
      //   140	151	235	java/io/IOException
      //   245	249	259	java/io/IOException
      //   253	257	262	java/io/IOException
      //   120	132	265	finally
      //   140	151	265	finally
      //   277	281	292	java/io/IOException
      //   285	289	295	java/io/IOException
      //   151	158	298	finally
      //   162	171	298	finally
      //   198	203	298	finally
      //   151	158	310	java/io/IOException
      //   162	171	310	java/io/IOException
      //   198	203	310	java/io/IOException
      //   120	132	317	java/io/FileNotFoundException
      //   140	151	317	java/io/FileNotFoundException
    }
    
    protected Void a(Void... paramVarArgs)
    {
      KeyboardService.access$102(KeyboardService.this, System.currentTimeMillis());
      if (a()) {
        KeyboardService.this.initService(KeyboardService.DIRECTORY_PATH + "keyboardlib_v4.sqlite");
      }
      return null;
    }
    
    protected void a(Void paramVoid)
    {
      super.onPostExecute(paramVoid);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/KeyboardService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */