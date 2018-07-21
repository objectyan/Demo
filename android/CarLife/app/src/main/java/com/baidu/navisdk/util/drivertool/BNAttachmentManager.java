package com.baidu.navisdk.util.drivertool;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.util.drivertool.model.DrivingToolIssueInfo;
import com.baidu.navisdk.util.drivertool.view.BNDrivingToolIssueStoreDialog;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

public class BNAttachmentManager
{
  public static final int REQUEST_ADD_ATTACH_CODE = 257;
  private static BNAttachmentManager mInstance = new BNAttachmentManager();
  public String mCurrentFilePath = null;
  public List<String> mFilePathList = new ArrayList();
  
  public static BNAttachmentManager getInstance()
  {
    return mInstance;
  }
  
  public String getAttachmentIndexPath()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("LP");
    localStringBuffer.append("_");
    localStringBuffer.append(UUID.randomUUID().toString());
    return BNDrivingToolUtils.getDrivingToolDir() + File.separator + localStringBuffer.toString() + ".lpdex";
  }
  
  public void onSelectPictureFinish(Intent paramIntent)
  {
    if (paramIntent == null) {}
    do
    {
      return;
      Object localObject = paramIntent.getData();
      paramIntent = new String[1];
      paramIntent[0] = "_data";
      localObject = BNaviModuleManager.getNaviActivity().getContentResolver().query((Uri)localObject, paramIntent, null, null, null);
      ((Cursor)localObject).moveToFirst();
      paramIntent = ((Cursor)localObject).getString(((Cursor)localObject).getColumnIndex(paramIntent[0]));
      ((Cursor)localObject).close();
      if (!this.mFilePathList.contains(paramIntent)) {
        this.mFilePathList.add(paramIntent);
      }
      paramIntent = BNDrivingToolManager.getInstance().getCurrentIssueStoreDialog();
      paramIntent.updateAttachNumber(this.mFilePathList.size());
    } while ("-  -  -  -  -  -  -  -  -  -  -  -  -  -  -".equals(BNDrivingToolManager.getInstance().getIssueInfo().mIssueID));
    paramIntent.setStoreBtnState(true);
  }
  
  public void startSelectPicture()
  {
    Intent localIntent = new Intent();
    localIntent.setType("image/*");
    localIntent.setAction("android.intent.action.PICK");
    if (BNaviModuleManager.getNaviActivity() != null) {
      BNaviModuleManager.getNaviActivity().startActivityForResult(Intent.createChooser(localIntent, "Select Picture"), 257);
    }
  }
  
  public void storeAttachmentIndex(int paramInt)
  {
    int i = 0;
    Iterator localIterator = this.mFilePathList.iterator();
    while (localIterator.hasNext())
    {
      this.mCurrentFilePath = ((String)localIterator.next());
      BNDrivingToolManager.getInstance().storeIndexFile(paramInt);
      if (i == 0) {
        BNDrivingToolManager.getInstance().getIssueInfo().mIssueDescrption = "";
      }
      i += 1;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/util/drivertool/BNAttachmentManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */