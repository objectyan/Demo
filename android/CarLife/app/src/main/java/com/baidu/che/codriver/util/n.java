package com.baidu.che.codriver.util;

import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;

public class n
{
  public static final boolean a = false;
  private static final String b = "VRTestUtils";
  private static long c = 0L;
  private static long d = 0L;
  private static long e = 0L;
  private static long f = 0L;
  private static long g = 0L;
  private static long h = 0L;
  private static long i = 0L;
  private static long j = 0L;
  private static long k = 0L;
  private static long l = 0L;
  private static long m = 0L;
  
  public static void a()
  {
    if (!c.o()) {
      return;
    }
    c = SystemClock.elapsedRealtime();
    h.b("VRTestUtils", "onVrReady:start_recording");
  }
  
  public static void a(String paramString)
  {
    if (!c.o()) {
      return;
    }
    d = SystemClock.elapsedRealtime();
    h.b("VRTestUtils", "onVrFinish-time:" + (d - f) + "ms");
    h.b("VRTestUtils", "onVrFinish--Result:" + paramString);
  }
  
  public static void b()
  {
    if (!c.o()) {
      return;
    }
    m = SystemClock.elapsedRealtime() - f + l;
    h.b("VRTestUtils", "onCommandExcuteComplete-time:" + m + "ms");
  }
  
  public static void b(String paramString)
  {
    if (!c.o()) {
      return;
    }
    e = SystemClock.elapsedRealtime();
    h.b("VRTestUtils", "onNlpFinish-time:" + (e - d) + "ms");
    h.b("VRTestUtils", "onNlpFinish--Result:" + paramString);
  }
  
  public static void c()
  {
    if (!c.o()) {
      return;
    }
    f = SystemClock.elapsedRealtime();
    l = f - g;
    h.b("VRTestUtils", "onSpeechEnd VAD time:" + l + "ms");
  }
  
  public static void d()
  {
    if (!c.o()) {
      return;
    }
    g = SystemClock.elapsedRealtime();
    h.b("VRTestUtils", "onSpeechEndManually");
  }
  
  public static void e()
  {
    if (!c.o()) {
      return;
    }
    h = SystemClock.elapsedRealtime();
    h.b("VRTestUtils", "onSpeechBegin:" + (h - c) + "ms");
  }
  
  public static void f()
  {
    if (!c.o()) {
      return;
    }
    h.b("VRTestUtils", "onRecognizeCorrect");
  }
  
  public static void g()
  {
    if (!c.o()) {
      return;
    }
    h.b("VRTestUtils", "onRecognizeWrong");
  }
  
  public static void h()
  {
    if (!c.o()) {
      return;
    }
    j = SystemClock.elapsedRealtime();
    h.b("VRTestUtils", "onWakeUpSpeakEnd");
  }
  
  public static void i()
  {
    if (!c.o()) {
      return;
    }
    k = SystemClock.elapsedRealtime();
    h.b("VRTestUtils", "onWakeUp:" + (k - j) + "ms");
  }
  
  public static void j()
  {
    if (!c.o()) {
      return;
    }
    h.b("VRTestUtils", "onWakeUpViewDisplay:" + (SystemClock.elapsedRealtime() - k) + "ms");
  }
  
  public static void k()
  {
    Intent localIntent = new Intent("com.baidu.che.codrivercustom.START");
    localIntent.addFlags(32);
    c.a().sendBroadcast(localIntent);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/che/codriver/util/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */