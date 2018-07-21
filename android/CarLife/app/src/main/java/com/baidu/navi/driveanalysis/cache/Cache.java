package com.baidu.navi.driveanalysis.cache;

import com.baidu.navi.driveanalysis.model.TrackModel;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class Cache
{
  private final int MAX_QUEUE_SIZE = 200;
  private INotify mNotify;
  private Queue<TrackModel> mQueue = new LinkedBlockingQueue();
  
  public int getSize()
  {
    try
    {
      int i = this.mQueue.size();
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void initNotify(INotify paramINotify)
  {
    this.mNotify = paramINotify;
  }
  
  public void insert(TrackModel paramTrackModel)
  {
    try
    {
      if (this.mQueue.size() == 200) {
        this.mQueue.remove();
      }
      this.mQueue.add(paramTrackModel);
      if ((this.mQueue.size() >= 4) && (this.mNotify != null)) {
        this.mNotify.dataChangeNotify();
      }
      return;
    }
    finally {}
  }
  
  public List<TrackModel> take(int paramInt)
  {
    try
    {
      LinkedList localLinkedList = new LinkedList();
      int i = 0;
      while (i < paramInt)
      {
        localLinkedList.add(this.mQueue.poll());
        i += 1;
      }
      return localLinkedList;
    }
    finally {}
  }
  
  public List<TrackModel> takeAll()
  {
    try
    {
      LinkedList localLinkedList = new LinkedList();
      int j = this.mQueue.size();
      int i = 0;
      while (i < j)
      {
        localLinkedList.add(this.mQueue.poll());
        i += 1;
      }
      return localLinkedList;
    }
    finally {}
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/driveanalysis/cache/Cache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */