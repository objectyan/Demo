package com.indooratlas.android.sdk._internal;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class fy
{
  private static final Pattern c = Pattern.compile("(\\d{2,4})[^\\d]*");
  private static final Pattern d = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");
  private static final Pattern e = Pattern.compile("(\\d{1,2})[^\\d]*");
  private static final Pattern f = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");
  public final String a;
  public final String b;
  private final long g;
  private final String h;
  private final String i;
  private final boolean j;
  private final boolean k;
  private final boolean l;
  private final boolean m;
  
  private fy(String paramString1, String paramString2, long paramLong, String paramString3, String paramString4, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.g = paramLong;
    this.h = paramString3;
    this.i = paramString4;
    this.j = paramBoolean1;
    this.k = paramBoolean2;
    this.m = paramBoolean3;
    this.l = paramBoolean4;
  }
  
  private static int a(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    for (;;)
    {
      int n = paramInt2;
      if (paramInt1 < paramInt2)
      {
        n = paramString.charAt(paramInt1);
        if (((n >= 32) || (n == 9)) && (n < 127) && ((n < 48) || (n > 57)) && ((n < 97) || (n > 122)) && ((n < 65) || (n > 90)) && (n != 58)) {
          break label108;
        }
        n = 1;
        if (paramBoolean) {
          break label114;
        }
      }
      label108:
      label114:
      for (int i1 = 1;; i1 = 0)
      {
        if (n != i1) {
          break label120;
        }
        n = paramInt1;
        return n;
        n = 0;
        break;
      }
      label120:
      paramInt1 += 1;
    }
  }
  
  private static long a(String paramString)
  {
    try
    {
      l1 = Long.parseLong(paramString);
      if (l1 > 0L) {
        break label15;
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      long l1;
      label15:
      while (paramString.matches("-?\\d+")) {
        if (!paramString.startsWith("-")) {
          return Long.MAX_VALUE;
        }
      }
      throw localNumberFormatException;
    }
    return Long.MIN_VALUE;
    return l1;
  }
  
  private static fy a(long paramLong, ge paramge, String paramString)
  {
    int i13 = paramString.length();
    int n = gy.a(paramString, 0, i13, ';');
    int i1 = gy.a(paramString, 0, n, '=');
    if (i1 == n) {
      return null;
    }
    String str1 = gy.c(paramString, 0, i1);
    if (str1.isEmpty()) {
      return null;
    }
    String str2 = gy.c(paramString, i1 + 1, n);
    long l1 = 253402300799999L;
    long l2 = -1L;
    localObject1 = null;
    localObject2 = null;
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool2 = true;
    boolean bool1 = false;
    n += 1;
    int i14;
    Object localObject7;
    Object localObject3;
    if (n < i13)
    {
      i14 = gy.a(paramString, n, i13, ';');
      i1 = gy.a(paramString, n, i14, '=');
      localObject7 = gy.c(paramString, n, i1);
      if (i1 < i14)
      {
        localObject3 = gy.c(paramString, i1 + 1, i14);
        label162:
        if (!((String)localObject7).equalsIgnoreCase("expires")) {
          break label764;
        }
      }
    }
    for (;;)
    {
      int i3;
      int i5;
      int i2;
      try
      {
        int i15 = ((String)localObject3).length();
        i6 = a((String)localObject3, 0, i15, false);
        i1 = -1;
        i3 = -1;
        i5 = -1;
        i2 = -1;
        int i4 = -1;
        n = -1;
        localObject7 = f.matcher((CharSequence)localObject3);
        if (i6 < i15)
        {
          int i12 = a((String)localObject3, i6 + 1, i15, true);
          ((Matcher)localObject7).region(i6, i12);
          if ((i1 == -1) && (((Matcher)localObject7).usePattern(f).matches()))
          {
            i7 = Integer.parseInt(((Matcher)localObject7).group(1));
            i9 = Integer.parseInt(((Matcher)localObject7).group(2));
            i11 = Integer.parseInt(((Matcher)localObject7).group(3));
            i10 = i2;
            i8 = i4;
            i6 = n;
            i12 = a((String)localObject3, i12 + 1, i15, false);
            n = i6;
            i4 = i8;
            i2 = i10;
            i5 = i11;
            i3 = i9;
            i1 = i7;
            i6 = i12;
            continue;
            localObject3 = "";
            break label162;
          }
          if ((i2 == -1) && (((Matcher)localObject7).usePattern(e).matches()))
          {
            i10 = Integer.parseInt(((Matcher)localObject7).group(1));
            i6 = n;
            i8 = i4;
            i11 = i5;
            i9 = i3;
            i7 = i1;
            continue;
          }
          if ((i4 == -1) && (((Matcher)localObject7).usePattern(d).matches()))
          {
            String str3 = ((Matcher)localObject7).group(1).toLowerCase(Locale.US);
            i8 = d.pattern().indexOf(str3) / 4;
            i6 = n;
            i10 = i2;
            i11 = i5;
            i9 = i3;
            i7 = i1;
            continue;
          }
          i6 = n;
          int i8 = i4;
          int i10 = i2;
          int i11 = i5;
          int i9 = i3;
          int i7 = i1;
          if (n != -1) {
            continue;
          }
          i6 = n;
          i8 = i4;
          i10 = i2;
          i11 = i5;
          i9 = i3;
          i7 = i1;
          if (!((Matcher)localObject7).usePattern(c).matches()) {
            continue;
          }
          i6 = Integer.parseInt(((Matcher)localObject7).group(1));
          i8 = i4;
          i10 = i2;
          i11 = i5;
          i9 = i3;
          i7 = i1;
          continue;
          if (i6 < 1601) {
            throw new IllegalArgumentException();
          }
          if (i4 != -1) {
            break label1337;
          }
          throw new IllegalArgumentException();
          throw new IllegalArgumentException();
          throw new IllegalArgumentException();
          throw new IllegalArgumentException();
          throw new IllegalArgumentException();
          localObject3 = new GregorianCalendar(gy.d);
          ((Calendar)localObject3).setLenient(false);
          ((Calendar)localObject3).set(1, i6);
          ((Calendar)localObject3).set(2, i4 - 1);
          ((Calendar)localObject3).set(5, i2);
          ((Calendar)localObject3).set(11, i1);
          ((Calendar)localObject3).set(12, i3);
          ((Calendar)localObject3).set(13, i5);
          ((Calendar)localObject3).set(14, 0);
          long l3 = ((Calendar)localObject3).getTimeInMillis();
          l1 = l3;
          bool1 = true;
          localObject3 = localObject1;
          localObject1 = localObject2;
          localObject2 = localObject3;
          break label1316;
          label764:
          if (((String)localObject7).equalsIgnoreCase("max-age")) {
            try
            {
              l3 = a((String)localObject3);
              l2 = l3;
              bool1 = true;
              localObject3 = localObject1;
              localObject1 = localObject2;
              localObject2 = localObject3;
            }
            catch (NumberFormatException localNumberFormatException)
            {
              localObject4 = localObject1;
              localObject1 = localObject2;
              localObject2 = localObject4;
            }
          }
          if (!((String)localObject7).equalsIgnoreCase("domain")) {}
        }
      }
      catch (IllegalArgumentException localIllegalArgumentException1)
      {
        int i6;
        Object localObject4;
        localObject5 = localObject2;
        localObject2 = localObject1;
        localObject1 = localObject5;
      }
      try
      {
        if (((String)localObject4).endsWith(".")) {
          throw new IllegalArgumentException();
        }
        localObject7 = localObject4;
        if (((String)localObject4).startsWith(".")) {
          localObject7 = ((String)localObject4).substring(1);
        }
        localObject4 = gy.a((String)localObject7);
        if (localObject4 == null) {
          throw new IllegalArgumentException();
        }
        bool2 = false;
        localObject1 = localObject2;
        localObject2 = localObject4;
      }
      catch (IllegalArgumentException localIllegalArgumentException2)
      {
        for (;;)
        {
          Object localObject6 = localObject1;
          localObject1 = localObject2;
          localObject2 = localObject6;
        }
      }
      if (((String)localObject7).equalsIgnoreCase("path"))
      {
        localObject2 = localObject1;
        localObject1 = localObject4;
      }
      else if (((String)localObject7).equalsIgnoreCase("secure"))
      {
        bool4 = true;
        localObject4 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject4;
      }
      else if (((String)localObject7).equalsIgnoreCase("httponly"))
      {
        bool3 = true;
        localObject4 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject4;
        break label1316;
        if (l2 == Long.MIN_VALUE)
        {
          l1 = Long.MIN_VALUE;
          if (localObject1 == null)
          {
            paramString = paramge.b;
            if (localObject2 != null)
            {
              localObject1 = localObject2;
              if (((String)localObject2).startsWith("/")) {}
            }
            else
            {
              paramge = paramge.d();
              n = paramge.lastIndexOf('/');
              if (n == 0) {
                continue;
              }
              paramge = paramge.substring(0, n);
              localObject1 = paramge;
            }
            return new fy(str1, str2, l1, paramString, (String)localObject1, bool4, bool3, bool2, bool1);
          }
        }
        else
        {
          if (l2 == -1L) {
            continue;
          }
          if (l2 <= 9223372036854775L)
          {
            l1 = l2 * 1000L;
            l2 = paramLong + l1;
            if (l2 >= paramLong)
            {
              l1 = l2;
              if (l2 <= 253402300799999L) {
                continue;
              }
            }
            l1 = 253402300799999L;
            continue;
          }
          l1 = Long.MAX_VALUE;
          continue;
        }
        paramString = paramge.b;
        if (paramString.equals(localObject1))
        {
          n = 1;
          if (n == 0) {
            return null;
          }
        }
        else
        {
          if ((paramString.endsWith((String)localObject1)) && (paramString.charAt(paramString.length() - ((String)localObject1).length() - 1) == '.') && (!gy.b(paramString)))
          {
            n = 1;
            continue;
          }
          n = 0;
          continue;
          paramge = "/";
          continue;
        }
        paramString = (String)localObject1;
        continue;
      }
      else
      {
        localObject4 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject4;
        break label1316;
        continue;
        if ((n < 70) || (n > 99)) {
          continue;
        }
        n += 1900;
        i6 = n;
        if (n < 0) {
          continue;
        }
        i6 = n;
        if (n > 69) {
          continue;
        }
        i6 = n + 2000;
        continue;
      }
      label1316:
      n = i14 + 1;
      Object localObject5 = localObject2;
      localObject2 = localObject1;
      localObject1 = localObject5;
      break;
      label1337:
      if ((i2 > 0) && (i2 <= 31)) {
        if ((i1 >= 0) && (i1 <= 23)) {
          if ((i3 >= 0) && (i3 <= 59)) {
            if (i5 >= 0) {
              if (i5 <= 59) {}
            }
          }
        }
      }
    }
  }
  
  public static List<fy> a(ge paramge, gd paramgd)
  {
    int i1 = paramgd.a.length / 2;
    int n = 0;
    Object localObject2;
    for (Object localObject1 = null; n < i1; localObject1 = localObject2)
    {
      localObject2 = localObject1;
      if ("Set-Cookie".equalsIgnoreCase(paramgd.a(n)))
      {
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = new ArrayList(2);
        }
        ((List)localObject2).add(paramgd.b(n));
      }
      n += 1;
    }
    if (localObject1 != null)
    {
      localObject1 = Collections.unmodifiableList((List)localObject1);
      i1 = ((List)localObject1).size();
      paramgd = null;
      n = 0;
      label102:
      if (n >= i1) {
        break label172;
      }
      localObject2 = (String)((List)localObject1).get(n);
      localObject2 = a(System.currentTimeMillis(), paramge, (String)localObject2);
      if (localObject2 == null) {
        break label188;
      }
      if (paramgd != null) {
        break label185;
      }
      paramgd = new ArrayList();
      label148:
      paramgd.add(localObject2);
    }
    label172:
    label185:
    label188:
    for (;;)
    {
      n += 1;
      break label102;
      localObject1 = Collections.emptyList();
      break;
      if (paramgd != null) {
        return Collections.unmodifiableList(paramgd);
      }
      return Collections.emptyList();
      break label148;
    }
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a);
    localStringBuilder.append('=');
    localStringBuilder.append(this.b);
    if (this.l)
    {
      if (this.g != Long.MIN_VALUE) {
        break label131;
      }
      localStringBuilder.append("; max-age=0");
    }
    for (;;)
    {
      if (!this.m) {
        localStringBuilder.append("; domain=").append(this.h);
      }
      localStringBuilder.append("; path=").append(this.i);
      if (this.j) {
        localStringBuilder.append("; secure");
      }
      if (this.k) {
        localStringBuilder.append("; httponly");
      }
      return localStringBuilder.toString();
      label131:
      localStringBuilder.append("; expires=").append(hu.a(new Date(this.g)));
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/indooratlas/android/sdk/_internal/fy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */