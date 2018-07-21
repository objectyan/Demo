package com.tencent.mm.sdk.diffdev;

public abstract interface IDiffDevOAuth
{
  public abstract void addListener(OAuthListener paramOAuthListener);
  
  public abstract boolean auth(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, OAuthListener paramOAuthListener);
  
  public abstract void detach();
  
  public abstract void removeAllListeners();
  
  public abstract void removeListener(OAuthListener paramOAuthListener);
  
  public abstract boolean stopAuth();
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/com/tencent/mm/sdk/diffdev/IDiffDevOAuth.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */