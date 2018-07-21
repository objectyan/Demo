package com.baidu.sapi2.share;

 enum ShareEvent
{
  static
  {
    INVALIDATE = new ShareEvent("INVALIDATE", 1);
    SYNC_REQ = new ShareEvent("SYNC_REQ", 2);
  }
  
  private ShareEvent() {}
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/sapi2/share/ShareEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */