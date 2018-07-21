package com.baidu.ufosdk.ui;

import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.TextView;
import java.util.ArrayList;

final class a
  implements Runnable
{
  a(FeedbackFacePageActivity paramFeedbackFacePageActivity) {}
  
  public final void run()
  {
    String str = FeedbackFacePageActivity.a(this.a).getText().toString();
    FeedbackFacePageActivity.b(this.a).clear();
    FeedbackFacePageActivity.a(this.a, FeedbackFacePageActivity.b(this.a), str);
    FeedbackFacePageActivity.c(this.a).notifyDataSetChanged();
    if (FeedbackFacePageActivity.b(this.a).size() == 0)
    {
      FeedbackFacePageActivity.d(this.a).setVisibility(0);
      FeedbackFacePageActivity.e(this.a).setVisibility(8);
      str = "未检索到 “" + str + "” 相关问题信息\n请重新搜索或向我们直接反馈\n\n\n\n";
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(str);
      localSpannableStringBuilder.setSpan(new ForegroundColorSpan(-11821318), str.length() - 8, str.length() - 4, 33);
      FeedbackFacePageActivity.d(this.a).setText(localSpannableStringBuilder);
      FeedbackFacePageActivity.d(this.a).bringToFront();
      return;
    }
    FeedbackFacePageActivity.d(this.a).setVisibility(8);
    FeedbackFacePageActivity.e(this.a).setVisibility(0);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/ufosdk/ui/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */