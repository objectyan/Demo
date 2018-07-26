package com.baidu.ufosdk.ui;

import android.os.AsyncTask;
import android.view.inputmethod.InputMethodManager;
import com.baidu.ufosdk.util.C5210c;
import com.baidu.ufosdk.util.C5216i;

/* compiled from: FeedbackFacePageActivity */
/* renamed from: com.baidu.ufosdk.ui.w */
final class C5204w extends AsyncTask {
    /* renamed from: a */
    final /* synthetic */ FeedbackFacePageActivity f21681a;

    protected final /* synthetic */ Object doInBackground(Object... objArr) {
        return C5204w.m17726a();
    }

    protected final /* bridge */ /* synthetic */ void onProgressUpdate(Object... objArr) {
    }

    C5204w(FeedbackFacePageActivity feedbackFacePageActivity) {
        this.f21681a = feedbackFacePageActivity;
    }

    protected final void onPreExecute() {
        if (this.f21681a.getCurrentFocus() != null && this.f21681a.getCurrentFocus().getWindowToken() != null) {
            ((InputMethodManager) this.f21681a.getSystemService("input_method")).hideSoftInputFromWindow(this.f21681a.getCurrentFocus().getWindowToken(), 2);
        }
    }

    /* renamed from: a */
    private static Integer m17726a() {
        try {
            Thread.sleep(280);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    protected final /* synthetic */ void onPostExecute(Object obj) {
        this.f21681a.finish();
        try {
            this.f21681a.overridePendingTransition(C5216i.m17758a(this.f21681a.getApplicationContext(), "ufo_slide_in_from_left"), C5216i.m17758a(this.f21681a.getApplicationContext(), "ufo_slide_out_to_right"));
        } catch (Exception e) {
            C5210c.m17736d("exit!");
        }
    }
}
