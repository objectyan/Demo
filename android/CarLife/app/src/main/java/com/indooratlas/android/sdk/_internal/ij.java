package com.indooratlas.android.sdk._internal;

import javax.security.auth.x500.X500Principal;

final class ij
{
  final String a;
  final int b;
  int c;
  int d;
  int e;
  int f;
  char[] g;
  
  public ij(X500Principal paramX500Principal)
  {
    this.a = paramX500Principal.getName("RFC2253");
    this.b = this.a.length();
  }
  
  private int a(int paramInt)
  {
    if (paramInt + 1 >= this.b) {
      throw new IllegalStateException("Malformed DN: " + this.a);
    }
    int i = this.g[paramInt];
    if ((i >= 48) && (i <= 57))
    {
      i -= 48;
      paramInt = this.g[(paramInt + 1)];
      if ((paramInt < 48) || (paramInt > 57)) {
        break label160;
      }
      paramInt -= 48;
    }
    for (;;)
    {
      return (i << 4) + paramInt;
      if ((i >= 97) && (i <= 102))
      {
        i -= 87;
        break;
      }
      if ((i >= 65) && (i <= 70))
      {
        i -= 55;
        break;
      }
      throw new IllegalStateException("Malformed DN: " + this.a);
      label160:
      if ((paramInt >= 97) && (paramInt <= 102))
      {
        paramInt -= 87;
      }
      else
      {
        if ((paramInt < 65) || (paramInt > 70)) {
          break label200;
        }
        paramInt -= 55;
      }
    }
    label200:
    throw new IllegalStateException("Malformed DN: " + this.a);
  }
  
  private char e()
  {
    int i = a(this.c);
    this.c += 1;
    if (i < 128) {
      return (char)i;
    }
    if ((i >= 192) && (i <= 247))
    {
      int j;
      int m;
      int k;
      if (i <= 223)
      {
        j = 1;
        i &= 0x1F;
        m = 0;
        k = i;
        i = m;
      }
      for (;;)
      {
        if (i >= j) {
          break label198;
        }
        this.c += 1;
        if ((this.c == this.b) || (this.g[this.c] != '\\'))
        {
          return '?';
          if (i <= 239)
          {
            j = 2;
            i &= 0xF;
            break;
          }
          j = 3;
          i &= 0x7;
          break;
        }
        this.c += 1;
        m = a(this.c);
        this.c += 1;
        if ((m & 0xC0) != 128) {
          return '?';
        }
        k = (k << 6) + (m & 0x3F);
        i += 1;
      }
      label198:
      return (char)k;
    }
    return '?';
  }
  
  final String a()
  {
    while ((this.c < this.b) && (this.g[this.c] == ' ')) {
      this.c += 1;
    }
    if (this.c == this.b) {
      return null;
    }
    this.d = this.c;
    for (this.c += 1; (this.c < this.b) && (this.g[this.c] != '=') && (this.g[this.c] != ' '); this.c += 1) {}
    if (this.c >= this.b) {
      throw new IllegalStateException("Unexpected end of DN: " + this.a);
    }
    this.e = this.c;
    if (this.g[this.c] == ' ')
    {
      while ((this.c < this.b) && (this.g[this.c] != '=') && (this.g[this.c] == ' ')) {
        this.c += 1;
      }
      if ((this.g[this.c] != '=') || (this.c == this.b)) {
        throw new IllegalStateException("Unexpected end of DN: " + this.a);
      }
    }
    do
    {
      this.c += 1;
    } while ((this.c < this.b) && (this.g[this.c] == ' '));
    if ((this.e - this.d > 4) && (this.g[(this.d + 3)] == '.') && ((this.g[this.d] == 'O') || (this.g[this.d] == 'o')) && ((this.g[(this.d + 1)] == 'I') || (this.g[(this.d + 1)] == 'i')) && ((this.g[(this.d + 2)] == 'D') || (this.g[(this.d + 2)] == 'd'))) {
      this.d += 4;
    }
    return new String(this.g, this.d, this.e - this.d);
  }
  
  final String b()
  {
    if (this.c + 4 >= this.b) {
      throw new IllegalStateException("Unexpected end of DN: " + this.a);
    }
    this.d = this.c;
    int k;
    for (this.c += 1;; this.c += 1)
    {
      if ((this.c == this.b) || (this.g[this.c] == '+') || (this.g[this.c] == ',') || (this.g[this.c] == ';')) {
        this.e = this.c;
      }
      for (;;)
      {
        k = this.e - this.d;
        if ((k >= 5) && ((k & 0x1) != 0)) {
          break label301;
        }
        throw new IllegalStateException("Unexpected end of DN: " + this.a);
        if (this.g[this.c] != ' ') {
          break;
        }
        this.e = this.c;
        for (this.c += 1; (this.c < this.b) && (this.g[this.c] == ' '); this.c += 1) {}
      }
      if ((this.g[this.c] >= 'A') && (this.g[this.c] <= 'F'))
      {
        localObject = this.g;
        i = this.c;
        localObject[i] = ((char)(localObject[i] + ' '));
      }
    }
    label301:
    Object localObject = new byte[k / 2];
    int i = 0;
    int j = this.d + 1;
    while (i < localObject.length)
    {
      localObject[i] = ((byte)a(j));
      j += 2;
      i += 1;
    }
    return new String(this.g, this.d, k);
  }
  
  final String c()
  {
    this.d = this.c;
    this.e = this.c;
    do
    {
      for (;;)
      {
        if (this.c >= this.b) {
          return new String(this.g, this.d, this.e - this.d);
        }
        switch (this.g[this.c])
        {
        default: 
          arrayOfChar = this.g;
          i = this.e;
          this.e = (i + 1);
          arrayOfChar[i] = this.g[this.c];
          this.c += 1;
          break;
        case '+': 
        case ',': 
        case ';': 
          return new String(this.g, this.d, this.e - this.d);
        case '\\': 
          arrayOfChar = this.g;
          i = this.e;
          this.e = (i + 1);
          arrayOfChar[i] = d();
          this.c += 1;
        }
      }
      this.f = this.e;
      this.c += 1;
      char[] arrayOfChar = this.g;
      int i = this.e;
      this.e = (i + 1);
      arrayOfChar[i] = ' ';
      while ((this.c < this.b) && (this.g[this.c] == ' '))
      {
        arrayOfChar = this.g;
        i = this.e;
        this.e = (i + 1);
        arrayOfChar[i] = ' ';
        this.c += 1;
      }
    } while ((this.c != this.b) && (this.g[this.c] != ',') && (this.g[this.c] != '+') && (this.g[this.c] != ';'));
    return new String(this.g, this.d, this.f - this.d);
  }
  
  final char d()
  {
    this.c += 1;
    if (this.c == this.b) {
      throw new IllegalStateException("Unexpected end of DN: " + this.a);
    }
    switch (this.g[this.c])
    {
    default: 
      return e();
    }
    return this.g[this.c];
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/com/indooratlas/android/sdk/_internal/ij.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */